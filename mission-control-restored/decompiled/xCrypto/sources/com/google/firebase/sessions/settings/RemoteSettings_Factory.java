package com.google.firebase.sessions.settings;

import V2.a;
import Z2.i;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.dagger.Lazy;
import com.google.firebase.sessions.dagger.internal.DoubleCheck;
import com.google.firebase.sessions.dagger.internal.Factory;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteSettings_Factory implements Factory<RemoteSettings> {
    private final a appInfoProvider;
    private final a backgroundDispatcherProvider;
    private final a configsFetcherProvider;
    private final a firebaseInstallationsApiProvider;
    private final a settingsCacheProvider;

    public RemoteSettings_Factory(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        this.backgroundDispatcherProvider = aVar;
        this.firebaseInstallationsApiProvider = aVar2;
        this.appInfoProvider = aVar3;
        this.configsFetcherProvider = aVar4;
        this.settingsCacheProvider = aVar5;
    }

    public static RemoteSettings_Factory create(a aVar, a aVar2, a aVar3, a aVar4, a aVar5) {
        return new RemoteSettings_Factory(aVar, aVar2, aVar3, aVar4, aVar5);
    }

    public static RemoteSettings newInstance(i iVar, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo applicationInfo, CrashlyticsSettingsFetcher crashlyticsSettingsFetcher, Lazy<SettingsCache> lazy) {
        return new RemoteSettings(iVar, firebaseInstallationsApi, applicationInfo, crashlyticsSettingsFetcher, lazy);
    }

    @Override // com.google.firebase.sessions.dagger.internal.Factory, V2.a
    public RemoteSettings get() {
        return newInstance((i) this.backgroundDispatcherProvider.get(), (FirebaseInstallationsApi) this.firebaseInstallationsApiProvider.get(), (ApplicationInfo) this.appInfoProvider.get(), (CrashlyticsSettingsFetcher) this.configsFetcherProvider.get(), DoubleCheck.lazy(this.settingsCacheProvider));
    }
}
