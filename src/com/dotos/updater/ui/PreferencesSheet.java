package com.dotos.updater.ui;

import android.annotation.NonNull;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;

import com.dotos.updater.R;
import com.dotos.updater.UpdatesCheckReceiver;
import com.dotos.updater.controller.UpdaterService;
import com.dotos.updater.misc.Constants;
import com.dotos.updater.misc.Utils;

public class PreferencesSheet extends RoundedSheetFragment {

    SharedPreferences prefs;
    Switch autoCheck;
    Switch autoDelete;
    Switch dataWarning;
    Switch abPerfMode;
    UpdaterService mUpdaterService;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view =  inflater.inflate(R.layout.preferences_sheet, container, false);
        autoCheck = view.findViewById(R.id.preferences_auto_updates_check);
        autoDelete = view.findViewById(R.id.preferences_auto_delete_updates);
        dataWarning = view.findViewById(R.id.preferences_mobile_data_warning);
        abPerfMode = view.findViewById(R.id.preferences_ab_perf_mode);

        if (!Utils.isABDevice()) {
            abPerfMode.setVisibility(View.GONE);
        }

        prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        autoCheck.setChecked(prefs.getBoolean(Constants.PREF_AUTO_UPDATES_CHECK, true));
        autoDelete.setChecked(prefs.getBoolean(Constants.PREF_AUTO_DELETE_UPDATES, false));
        dataWarning.setChecked(prefs.getBoolean(Constants.PREF_MOBILE_DATA_WARNING, true));
        abPerfMode.setChecked(prefs.getBoolean(Constants.PREF_AB_PERF_MODE, false));
        return view;
    }

    public void setUpdaterService(UpdaterService mUpdaterService) {
        this.mUpdaterService = mUpdaterService;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        prefs.edit()
                .putBoolean(Constants.PREF_AUTO_UPDATES_CHECK,
                        autoCheck.isChecked())
                .putBoolean(Constants.PREF_AUTO_DELETE_UPDATES,
                        autoDelete.isChecked())
                .putBoolean(Constants.PREF_MOBILE_DATA_WARNING,
                        dataWarning.isChecked())
                .putBoolean(Constants.PREF_AB_PERF_MODE,
                        abPerfMode.isChecked())
                .apply();

        if (autoCheck.isChecked()) {
            UpdatesCheckReceiver.scheduleRepeatingUpdatesCheck(getContext());
        } else {
            UpdatesCheckReceiver.cancelRepeatingUpdatesCheck(getContext());
            UpdatesCheckReceiver.cancelUpdatesCheck(getContext());
        }

        boolean enableABPerfMode = abPerfMode.isChecked();
        mUpdaterService.getUpdaterController().setPerformanceMode(enableABPerfMode);
    }
}
