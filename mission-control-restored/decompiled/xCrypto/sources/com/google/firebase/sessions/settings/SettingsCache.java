package com.google.firebase.sessions.settings;

import S.InterfaceC0523i;
import V.c;
import V.f;
import V.i;
import W2.E;
import W2.q;
import Z2.e;
import a3.AbstractC0787c;
import b3.AbstractC0866d;
import b3.InterfaceC0868f;
import b3.l;
import com.google.firebase.sessions.SessionConfigsDataStore;
import i3.o;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import t3.AbstractC1820j;
import t3.L;
import w3.d;

/* JADX INFO: loaded from: classes.dex */
public final class SettingsCache {

    @Deprecated
    public static final String TAG = "SettingsCache";
    private final InterfaceC0523i dataStore;
    private SessionConfigs sessionConfigs;
    private static final Companion Companion = new Companion(null);
    private static final f.a SESSIONS_ENABLED = i.a(LocalOverrideSettings.SESSIONS_ENABLED);
    private static final f.a SAMPLING_RATE = i.c(LocalOverrideSettings.SAMPLING_RATE);
    private static final f.a RESTART_TIMEOUT_SECONDS = i.e("firebase_sessions_restart_timeout");
    private static final f.a CACHE_DURATION_SECONDS = i.e("firebase_sessions_cache_duration");
    private static final f.a CACHE_UPDATED_TIME = i.f("firebase_sessions_cache_updated_time");

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SettingsCache$1, reason: invalid class name */
    @InterfaceC0868f(c = "com.google.firebase.sessions.settings.SettingsCache$1", f = "SettingsCache.kt", l = {52}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends l implements o {
        Object L$0;
        int label;

        public AnonymousClass1(e eVar) {
            super(2, eVar);
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            return SettingsCache.this.new AnonymousClass1(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            SettingsCache settingsCache;
            Object objE = AbstractC0787c.e();
            int i4 = this.label;
            if (i4 == 0) {
                q.b(obj);
                SettingsCache settingsCache2 = SettingsCache.this;
                d data = settingsCache2.dataStore.getData();
                this.L$0 = settingsCache2;
                this.label = 1;
                Object objK = w3.f.k(data, this);
                if (objK == objE) {
                    return objE;
                }
                settingsCache = settingsCache2;
                obj = objK;
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                settingsCache = (SettingsCache) this.L$0;
                q.b(obj);
            }
            settingsCache.updateSessionConfigs(((f) obj).d());
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(L l4, e eVar) {
            return ((AnonymousClass1) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final f.a getCACHE_DURATION_SECONDS() {
            return SettingsCache.CACHE_DURATION_SECONDS;
        }

        public final f.a getCACHE_UPDATED_TIME() {
            return SettingsCache.CACHE_UPDATED_TIME;
        }

        public final f.a getRESTART_TIMEOUT_SECONDS() {
            return SettingsCache.RESTART_TIMEOUT_SECONDS;
        }

        public final f.a getSAMPLING_RATE() {
            return SettingsCache.SAMPLING_RATE;
        }

        public final f.a getSESSIONS_ENABLED() {
            return SettingsCache.SESSIONS_ENABLED;
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "com.google.firebase.sessions.settings.SettingsCache", f = "SettingsCache.kt", l = {122}, m = "updateConfigValue")
    public static final class C10481<T> extends AbstractC0866d {
        int label;
        /* synthetic */ Object result;

        public C10481(e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SettingsCache.this.updateConfigValue(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2, reason: invalid class name */
    @InterfaceC0868f(c = "com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2", f = "SettingsCache.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends l implements o {
        final /* synthetic */ f.a $key;
        final /* synthetic */ T $value;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SettingsCache this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(T t4, f.a aVar, SettingsCache settingsCache, e eVar) {
            super(2, eVar);
            this.$value = t4;
            this.$key = aVar;
            this.this$0 = settingsCache;
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$value, this.$key, this.this$0, eVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // i3.o
        public final Object invoke(c cVar, e eVar) {
            return ((AnonymousClass2) create(cVar, eVar)).invokeSuspend(E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0787c.e();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.b(obj);
            c cVar = (c) this.L$0;
            Object obj2 = this.$value;
            if (obj2 != null) {
                cVar.j(this.$key, obj2);
            } else {
                cVar.i(this.$key);
            }
            this.this$0.updateSessionConfigs(cVar);
            return E.f5463a;
        }
    }

    public SettingsCache(@SessionConfigsDataStore InterfaceC0523i dataStore) {
        r.f(dataStore, "dataStore");
        this.dataStore = dataStore;
        AbstractC1820j.b(null, new AnonymousClass1(null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final <T> java.lang.Object updateConfigValue(V.f.a r6, T r7, Z2.e r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof com.google.firebase.sessions.settings.SettingsCache.C10481
            if (r0 == 0) goto L13
            r0 = r8
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = (com.google.firebase.sessions.settings.SettingsCache.C10481) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1 r0 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$1
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            W2.q.b(r8)     // Catch: java.io.IOException -> L29
            goto L5d
        L29:
            r6 = move-exception
            goto L47
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            W2.q.b(r8)
            S.i r8 = r5.dataStore     // Catch: java.io.IOException -> L29
            com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2 r2 = new com.google.firebase.sessions.settings.SettingsCache$updateConfigValue$2     // Catch: java.io.IOException -> L29
            r4 = 0
            r2.<init>(r7, r6, r5, r4)     // Catch: java.io.IOException -> L29
            r0.label = r3     // Catch: java.io.IOException -> L29
            java.lang.Object r6 = V.j.a(r8, r2, r0)     // Catch: java.io.IOException -> L29
            if (r6 != r1) goto L5d
            return r1
        L47:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Failed to update cache config value: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "SettingsCache"
            android.util.Log.w(r7, r6)
        L5d:
            W2.E r6 = W2.E.f5463a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCache.updateConfigValue(V.f$a, java.lang.Object, Z2.e):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateSessionConfigs(f fVar) {
        this.sessionConfigs = new SessionConfigs((Boolean) fVar.b(SESSIONS_ENABLED), (Double) fVar.b(SAMPLING_RATE), (Integer) fVar.b(RESTART_TIMEOUT_SECONDS), (Integer) fVar.b(CACHE_DURATION_SECONDS), (Long) fVar.b(CACHE_UPDATED_TIME));
    }

    public final boolean hasCacheExpired$com_google_firebase_firebase_sessions() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        SessionConfigs sessionConfigs2 = null;
        if (sessionConfigs == null) {
            r.t("sessionConfigs");
            sessionConfigs = null;
        }
        Long cacheUpdatedTime = sessionConfigs.getCacheUpdatedTime();
        SessionConfigs sessionConfigs3 = this.sessionConfigs;
        if (sessionConfigs3 == null) {
            r.t("sessionConfigs");
        } else {
            sessionConfigs2 = sessionConfigs3;
        }
        Integer cacheDuration = sessionConfigs2.getCacheDuration();
        return cacheUpdatedTime == null || cacheDuration == null || (System.currentTimeMillis() - cacheUpdatedTime.longValue()) / ((long) 1000) >= ((long) cacheDuration.intValue());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object removeConfigs$com_google_firebase_firebase_sessions(Z2.e r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1
            if (r0 == 0) goto L13
            r0 = r6
            com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1 r0 = (com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1 r0 = new com.google.firebase.sessions.settings.SettingsCache$removeConfigs$1
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            W2.q.b(r6)     // Catch: java.io.IOException -> L29
            goto L5d
        L29:
            r6 = move-exception
            goto L47
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L33:
            W2.q.b(r6)
            S.i r6 = r5.dataStore     // Catch: java.io.IOException -> L29
            com.google.firebase.sessions.settings.SettingsCache$removeConfigs$2 r2 = new com.google.firebase.sessions.settings.SettingsCache$removeConfigs$2     // Catch: java.io.IOException -> L29
            r4 = 0
            r2.<init>(r5, r4)     // Catch: java.io.IOException -> L29
            r0.label = r3     // Catch: java.io.IOException -> L29
            java.lang.Object r6 = V.j.a(r6, r2, r0)     // Catch: java.io.IOException -> L29
            if (r6 != r1) goto L5d
            return r1
        L47:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Failed to remove config values: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            java.lang.String r0 = "SettingsCache"
            android.util.Log.w(r0, r6)
        L5d:
            W2.E r6 = W2.E.f5463a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SettingsCache.removeConfigs$com_google_firebase_firebase_sessions(Z2.e):java.lang.Object");
    }

    public final Integer sessionRestartTimeout() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        if (sessionConfigs == null) {
            r.t("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.getSessionRestartTimeout();
    }

    public final Double sessionSamplingRate() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        if (sessionConfigs == null) {
            r.t("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.getSessionSamplingRate();
    }

    public final Boolean sessionsEnabled() {
        SessionConfigs sessionConfigs = this.sessionConfigs;
        if (sessionConfigs == null) {
            r.t("sessionConfigs");
            sessionConfigs = null;
        }
        return sessionConfigs.getSessionEnabled();
    }

    public final Object updateSamplingRate(Double d4, e eVar) throws Throwable {
        Object objUpdateConfigValue = updateConfigValue(SAMPLING_RATE, d4, eVar);
        return objUpdateConfigValue == AbstractC0787c.e() ? objUpdateConfigValue : E.f5463a;
    }

    public final Object updateSessionCacheDuration(Integer num, e eVar) throws Throwable {
        Object objUpdateConfigValue = updateConfigValue(CACHE_DURATION_SECONDS, num, eVar);
        return objUpdateConfigValue == AbstractC0787c.e() ? objUpdateConfigValue : E.f5463a;
    }

    public final Object updateSessionCacheUpdatedTime(Long l4, e eVar) throws Throwable {
        Object objUpdateConfigValue = updateConfigValue(CACHE_UPDATED_TIME, l4, eVar);
        return objUpdateConfigValue == AbstractC0787c.e() ? objUpdateConfigValue : E.f5463a;
    }

    public final Object updateSessionRestartTimeout(Integer num, e eVar) throws Throwable {
        Object objUpdateConfigValue = updateConfigValue(RESTART_TIMEOUT_SECONDS, num, eVar);
        return objUpdateConfigValue == AbstractC0787c.e() ? objUpdateConfigValue : E.f5463a;
    }

    public final Object updateSettingsEnabled(Boolean bool, e eVar) throws Throwable {
        Object objUpdateConfigValue = updateConfigValue(SESSIONS_ENABLED, bool, eVar);
        return objUpdateConfigValue == AbstractC0787c.e() ? objUpdateConfigValue : E.f5463a;
    }
}
