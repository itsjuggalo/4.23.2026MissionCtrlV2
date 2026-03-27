package com.google.firebase.sessions.settings;

import S.InterfaceC0523i;
import V2.a;
import com.google.firebase.sessions.dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class SettingsCache_Factory implements Factory<SettingsCache> {
    private final a dataStoreProvider;

    public SettingsCache_Factory(a aVar) {
        this.dataStoreProvider = aVar;
    }

    public static SettingsCache_Factory create(a aVar) {
        return new SettingsCache_Factory(aVar);
    }

    public static SettingsCache newInstance(InterfaceC0523i interfaceC0523i) {
        return new SettingsCache(interfaceC0523i);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, V2.a
    public SettingsCache get() {
        return newInstance((InterfaceC0523i) this.dataStoreProvider.get());
    }
}
