/*
 * Copyright (C) 2017 The LineageOS Project
 * Copyright (C) 2018 The DotOS Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.cesium.ota.misc;

public final class Constants {

    private Constants() {
    }

    public static final String AB_PAYLOAD_BIN_PATH = "payload.bin";
    public static final String AB_PAYLOAD_PROPERTIES_PATH = "payload_properties.txt";

    public static final String PREF_LAST_UPDATE_CHECK = "last_update_check";
    public static final String PREF_AUTO_UPDATES_CHECK = "auto_updates_check";
    public static final String PREF_AUTO_DELETE_UPDATES = "auto_delete_updates";
    public static final String PREF_AB_PERF_MODE = "ab_perf_mode";
    public static final String PREF_MOBILE_DATA_WARNING = "pref_mobile_data_warning";
    public static final String PREF_NEEDS_REBOOT_ID = "needs_reboot_id";

    public static final String UNCRYPT_FILE_EXT = ".uncrypt";

    public static final String PROP_AB_DEVICE = "ro.build.ab_update";
    public static final String PROP_BUILD_DATE = "ro.build.date.utc";
    public static final String PROP_BUILD_VERSION = "org.cesium.build_version";
    public static final String PROP_BUILD_VERSION_INCREMENTAL = "ro.build.version.incremental";
    public static final String PROP_DEVICE = "org.cesium.device";
    public static final String PROP_NEXT_DEVICE = "cesium.ota.next_device";
    public static final String PROP_RELEASE_TYPE = "org.cesium.build_type";
    public static final String PROP_UPDATER_ALLOW_DOWNGRADING = "cesium.updater.allow_downgrading";
    public static final String PROP_UPDATER_URI = "cesium.updater.uri";

    public static final String PREF_INSTALL_OLD_TIMESTAMP = "install_old_timestamp";
    public static final String PREF_INSTALL_NEW_TIMESTAMP = "install_new_timestamp";
    public static final String PREF_INSTALL_PACKAGE_PATH = "install_package_path";
    public static final String PREF_INSTALL_AGAIN = "install_again";
    public static final String PREF_INSTALL_NOTIFIED = "install_notified";
}
