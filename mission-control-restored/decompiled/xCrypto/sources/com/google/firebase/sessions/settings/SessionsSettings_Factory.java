package com.google.firebase.sessions.settings;

import V2.a;
import com.google.firebase.sessions.dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class SessionsSettings_Factory implements Factory<SessionsSettings> {
    private final a localOverrideSettingsProvider;
    private final a remoteSettingsProvider;

    public SessionsSettings_Factory(a aVar, a aVar2) {
        this.localOverrideSettingsProvider = aVar;
        this.remoteSettingsProvider = aVar2;
    }

    public static SessionsSettings_Factory create(a aVar, a aVar2) {
        return new SessionsSettings_Factory(aVar, aVar2);
    }

    public static SessionsSettings newInstance(SettingsProvider settingsProvider, SettingsProvider settingsProvider2) {
        return new SessionsSettings(settingsProvider, settingsProvider2);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, V2.a
    public SessionsSettings get() {
        return newInstance((SettingsProvider) this.localOverrideSettingsProvider.get(), (SettingsProvider) this.remoteSettingsProvider.get());
    }
}
