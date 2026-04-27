package com.google.firebase.sessions.settings;

import V2.a;
import Z2.i;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteSettingsFetcher_Factory implements Factory<RemoteSettingsFetcher> {
    private final a appInfoProvider;
    private final a blockingDispatcherProvider;

    public RemoteSettingsFetcher_Factory(a aVar, a aVar2) {
        this.appInfoProvider = aVar;
        this.blockingDispatcherProvider = aVar2;
    }

    public static RemoteSettingsFetcher_Factory create(a aVar, a aVar2) {
        return new RemoteSettingsFetcher_Factory(aVar, aVar2);
    }

    public static RemoteSettingsFetcher newInstance(ApplicationInfo applicationInfo, i iVar) {
        return new RemoteSettingsFetcher(applicationInfo, iVar);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, V2.a
    public RemoteSettingsFetcher get() {
        return newInstance((ApplicationInfo) this.appInfoProvider.get(), (i) this.blockingDispatcherProvider.get());
    }
}
