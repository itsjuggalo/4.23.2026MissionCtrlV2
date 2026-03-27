package com.google.firebase.sessions.settings;

import C3.a;
import C3.c;
import Z2.e;
import Z2.i;
import b3.AbstractC0866d;
import b3.InterfaceC0868f;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import com.google.firebase.sessions.dagger.Lazy;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import r3.k;
import s3.C1779a;
import s3.d;
import t3.AbstractC1822k;
import t3.M;

/* JADX INFO: loaded from: classes.dex */
public final class RemoteSettings implements SettingsProvider {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String FORWARD_SLASH_STRING = "/";

    @Deprecated
    public static final String TAG = "SessionConfigFetcher";
    private final ApplicationInfo appInfo;
    private final i backgroundDispatcher;
    private final CrashlyticsSettingsFetcher configsFetcher;
    private final a fetchInProgress;
    private final FirebaseInstallationsApi firebaseInstallationsApi;
    private final Lazy<SettingsCache> lazySettingsCache;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1, reason: invalid class name */
    @InterfaceC0868f(c = "com.google.firebase.sessions.settings.RemoteSettings", f = "RemoteSettings.kt", l = {177, 83, 101}, m = "updateSettings")
    public static final class AnonymousClass1 extends AbstractC0866d {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteSettings.this.updateSettings(this);
        }
    }

    public RemoteSettings(@Background i backgroundDispatcher, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo appInfo, CrashlyticsSettingsFetcher configsFetcher, Lazy<SettingsCache> lazySettingsCache) {
        r.f(backgroundDispatcher, "backgroundDispatcher");
        r.f(firebaseInstallationsApi, "firebaseInstallationsApi");
        r.f(appInfo, "appInfo");
        r.f(configsFetcher, "configsFetcher");
        r.f(lazySettingsCache, "lazySettingsCache");
        this.backgroundDispatcher = backgroundDispatcher;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.appInfo = appInfo;
        this.configsFetcher = configsFetcher;
        this.lazySettingsCache = lazySettingsCache;
        this.fetchInProgress = c.b(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsCache getSettingsCache() {
        SettingsCache settingsCache = this.lazySettingsCache.get();
        r.e(settingsCache, "lazySettingsCache.get()");
        return settingsCache;
    }

    private final String removeForwardSlashesIn(String str) {
        return new k(FORWARD_SLASH_STRING).c(str, "");
    }

    public final void clearCachedSettings$com_google_firebase_firebase_sessions() {
        AbstractC1822k.d(M.a(this.backgroundDispatcher), null, null, new RemoteSettings$clearCachedSettings$1(this, null), 3, null);
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Double getSamplingRate() {
        return getSettingsCache().sessionSamplingRate();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Boolean getSessionEnabled() {
        return getSettingsCache().sessionsEnabled();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /* JADX INFO: renamed from: getSessionRestartTimeout-FghU774 */
    public C1779a mo18getSessionRestartTimeoutFghU774() {
        Integer numSessionRestartTimeout = getSettingsCache().sessionRestartTimeout();
        if (numSessionRestartTimeout == null) {
            return null;
        }
        C1779a.C0237a c0237a = C1779a.f14679b;
        return C1779a.i(s3.c.s(numSessionRestartTimeout.intValue(), d.f14689e));
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public boolean isSettingsStale() {
        return getSettingsCache().hasCacheExpired$com_google_firebase_firebase_sessions();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00c7 A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:21:0x004a, B:47:0x00b9, B:49:0x00c7, B:52:0x00d2), top: B:64:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00d2 A[Catch: all -> 0x004f, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:21:0x004a, B:47:0x00b9, B:49:0x00c7, B:52:0x00d2), top: B:64:0x004a }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object updateSettings(Z2.e r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings.updateSettings(Z2.e):java.lang.Object");
    }
}
