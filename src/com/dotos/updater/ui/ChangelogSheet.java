package com.dotos.updater.ui;

import android.annotation.NonNull;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.dotos.updater.R;
import com.dotos.updater.UpdatesCheckReceiver;
import com.dotos.updater.controller.UpdaterService;
import com.dotos.updater.misc.Constants;
import com.dotos.updater.misc.Utils;

import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;
import androidx.preference.PreferenceManager;

public class ChangelogSheet extends RoundedSheetFragment {

    private ChangelogLayout changelogLayout;
    private TextView details;
    private LinearLayout chg;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        chg.removeView(details);
        chg.removeView(changelogLayout);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle bundle) {
        View view = inflater.inflate(R.layout.changelog_sheet, container, false);
        chg = view.findViewById(R.id.chg);
        LinearLayout.LayoutParams param = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        param.topMargin = (int) dpToPx(12);
        param.leftMargin = (int) dpToPx(24);
        param.rightMargin = (int) dpToPx(24);
        details.setLayoutParams(param);
        details.setBackgroundResource(R.drawable.outline_bg);
        details.setPadding((int) dpToPx(12), (int) dpToPx(12), (int) dpToPx(12), (int) dpToPx(12));
        details.setTypeface(ResourcesCompat.getFont(getContext(), R.font.google_sans));
        chg.addView(details);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.topMargin = (int) dpToPx(12);
        params.bottomMargin = (int) dpToPx(12);
        params.leftMargin = (int) dpToPx(12);
        params.rightMargin = (int) dpToPx(12);
        changelogLayout.setLayoutParams(params);
        chg.addView(changelogLayout);
        return view;
    }

    public void initDetailsText(TextView details) {
        this.details = details;
    }

    public void setDetails(String line0, String line1, String line2) {
        details.setText(String.format("%s\n%s\n%s", line0, line1, line2));
    }

    public void setChangelogLayout(ChangelogLayout changelogLayout) {
        this.changelogLayout = changelogLayout;
    }

    public void setDevice(String value) {
        changelogLayout.setDevice(value);
    }

    public void setSettings(String value) {
        changelogLayout.setSettings(value);
    }

    public void setMisc(String value) {
        changelogLayout.setMisc(value);
    }

    public void setSystem(String value) {
        changelogLayout.setSystem(value);
    }

    public void setSecurityPatch(String value) {
        changelogLayout.setSecurityPatch(value);
    }

    private float dpToPx(int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, getResources().getDisplayMetrics());
    }
}
