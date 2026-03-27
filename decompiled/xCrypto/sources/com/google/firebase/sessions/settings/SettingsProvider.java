package com.google.firebase.sessions.settings;

import W2.E;
import Z2.e;
import s3.C1779a;

/* JADX INFO: loaded from: classes.dex */
public interface SettingsProvider {

    public static final class DefaultImpls {
        public static boolean isSettingsStale(SettingsProvider settingsProvider) {
            return false;
        }

        public static Object updateSettings(SettingsProvider settingsProvider, e eVar) {
            return E.f5463a;
        }
    }

    Double getSamplingRate();

    Boolean getSessionEnabled();

    /* JADX INFO: renamed from: getSessionRestartTimeout-FghU774 */
    C1779a mo18getSessionRestartTimeoutFghU774();

    boolean isSettingsStale();

    Object updateSettings(e eVar);
}
