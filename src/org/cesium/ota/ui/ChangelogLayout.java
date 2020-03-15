package org.cesium.ota.ui;

import android.annotation.Nullable;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.cesium.ota.R;


public class ChangelogLayout extends LinearLayout {

    View view;
    TextView c_system, d_system,
            c_settings, d_settings,
            c_device, d_device,
            c_sec_patch , d_sec_patch,
            c_misc, d_misc;

    public ChangelogLayout(Context context) {
        super(context);
        init(context);
    }

    public ChangelogLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    protected void init(Context context) {
        view = inflate(context, R.layout.changelog_layout, this);
        c_system = findViewById(R.id.c_system);
        d_system = findViewById(R.id.d_system);
        c_settings = findViewById(R.id.c_settings);
        d_settings = findViewById(R.id.d_settings);
        c_device = findViewById(R.id.c_device);
        d_device = findViewById(R.id.d_device);
        c_sec_patch = findViewById(R.id.c_sec_patch);
        d_sec_patch = findViewById(R.id.d_sec_patch);
        c_misc = findViewById(R.id.c_misc);
        d_misc = findViewById(R.id.d_misc);
    }

    public void setSystem(String str) {
        if (c_system.getVisibility() != VISIBLE && d_system.getVisibility() != VISIBLE && str != null) {
            c_system.setVisibility(VISIBLE);
            d_system.setVisibility(VISIBLE);
        }
        d_system.setText(str);
    }

    public void setSettings(String str) {
        if (c_settings.getVisibility() != VISIBLE && d_settings.getVisibility() != VISIBLE && str != null) {
            c_settings.setVisibility(VISIBLE);
            d_settings.setVisibility(VISIBLE);
        }
        d_settings.setText(str);
    }

    public void setDevice(String str) {
        if (c_device.getVisibility() != VISIBLE && d_device.getVisibility() != VISIBLE && str != null) {
            c_device.setVisibility(VISIBLE);
            d_device.setVisibility(VISIBLE);
        }
        d_device.setText(str);
    }

    public void setSecurityPatch(String str) {
        if (c_sec_patch.getVisibility() != VISIBLE && d_sec_patch.getVisibility() != VISIBLE && str != null) {
            c_sec_patch.setVisibility(VISIBLE);
            d_sec_patch.setVisibility(VISIBLE);
        }
        d_sec_patch.setText(String.format(" Security Patch upstream to %s", str));
    }

    public void setMisc(String str) {
        if (c_misc.getVisibility() != VISIBLE && d_misc.getVisibility() != VISIBLE && str != null) {
            c_misc.setVisibility(VISIBLE);
            d_misc.setVisibility(VISIBLE);
        }
        d_misc.setText(str);
    }
}
