package com.google.firebase.sessions.settings;

import Z2.e;
import b3.AbstractC0866d;
import b3.InterfaceC0868f;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseKt;
import com.google.firebase.sessions.FirebaseSessionsComponent;
import com.google.firebase.sessions.LocalOverrideSettingsProvider;
import com.google.firebase.sessions.RemoteSettingsProvider;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import s3.C1779a;
import s3.c;
import s3.d;

/* JADX INFO: loaded from: classes.dex */
public final class SessionsSettings {
    public static final Companion Companion = new Companion(null);
    private final SettingsProvider localOverrideSettings;
    private final SettingsProvider remoteSettings;

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        public final SessionsSettings getInstance() {
            return ((FirebaseSessionsComponent) FirebaseKt.getApp(Firebase.INSTANCE).get(FirebaseSessionsComponent.class)).getSessionsSettings();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1, reason: invalid class name */
    @InterfaceC0868f(c = "com.google.firebase.sessions.settings.SessionsSettings", f = "SessionsSettings.kt", l = {98, 99}, m = "updateSettings")
    public static final class AnonymousClass1 extends AbstractC0866d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionsSettings.this.updateSettings(this);
        }
    }

    public SessionsSettings(@LocalOverrideSettingsProvider SettingsProvider localOverrideSettings, @RemoteSettingsProvider SettingsProvider remoteSettings) {
        r.f(localOverrideSettings, "localOverrideSettings");
        r.f(remoteSettings, "remoteSettings");
        this.localOverrideSettings = localOverrideSettings;
        this.remoteSettings = remoteSettings;
    }

    private final boolean isValidSamplingRate(double d4) {
        return 0.0d <= d4 && d4 <= 1.0d;
    }

    /* JADX INFO: renamed from: isValidSessionRestartTimeout-LRDsOJo, reason: not valid java name */
    private final boolean m19isValidSessionRestartTimeoutLRDsOJo(long j4) {
        return C1779a.G(j4) && C1779a.B(j4);
    }

    public final double getSamplingRate() {
        Double samplingRate = this.localOverrideSettings.getSamplingRate();
        if (samplingRate != null) {
            double dDoubleValue = samplingRate.doubleValue();
            if (isValidSamplingRate(dDoubleValue)) {
                return dDoubleValue;
            }
        }
        Double samplingRate2 = this.remoteSettings.getSamplingRate();
        if (samplingRate2 == null) {
            return 1.0d;
        }
        double dDoubleValue2 = samplingRate2.doubleValue();
        if (isValidSamplingRate(dDoubleValue2)) {
            return dDoubleValue2;
        }
        return 1.0d;
    }

    /* JADX INFO: renamed from: getSessionRestartTimeout-UwyO8pc, reason: not valid java name */
    public final long m20getSessionRestartTimeoutUwyO8pc() {
        C1779a c1779aMo18getSessionRestartTimeoutFghU774 = this.localOverrideSettings.mo18getSessionRestartTimeoutFghU774();
        if (c1779aMo18getSessionRestartTimeoutFghU774 != null) {
            long jN = c1779aMo18getSessionRestartTimeoutFghU774.N();
            if (m19isValidSessionRestartTimeoutLRDsOJo(jN)) {
                return jN;
            }
        }
        C1779a c1779aMo18getSessionRestartTimeoutFghU7742 = this.remoteSettings.mo18getSessionRestartTimeoutFghU774();
        if (c1779aMo18getSessionRestartTimeoutFghU7742 != null) {
            long jN2 = c1779aMo18getSessionRestartTimeoutFghU7742.N();
            if (m19isValidSessionRestartTimeoutLRDsOJo(jN2)) {
                return jN2;
            }
        }
        C1779a.C0237a c0237a = C1779a.f14679b;
        return c.s(30, d.f14690f);
    }

    public final boolean getSessionsEnabled() {
        Boolean sessionEnabled = this.localOverrideSettings.getSessionEnabled();
        if (sessionEnabled != null) {
            return sessionEnabled.booleanValue();
        }
        Boolean sessionEnabled2 = this.remoteSettings.getSessionEnabled();
        if (sessionEnabled2 != null) {
            return sessionEnabled2.booleanValue();
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0058, code lost:
    
        if (r6.updateSettings(r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object updateSettings(Z2.e r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.google.firebase.sessions.settings.SessionsSettings.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r6
            com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1 r0 = (com.google.firebase.sessions.settings.SessionsSettings.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1 r0 = new com.google.firebase.sessions.settings.SessionsSettings$updateSettings$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            W2.q.b(r6)
            goto L5b
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.L$0
            com.google.firebase.sessions.settings.SessionsSettings r2 = (com.google.firebase.sessions.settings.SessionsSettings) r2
            W2.q.b(r6)
            goto L4d
        L3c:
            W2.q.b(r6)
            com.google.firebase.sessions.settings.SettingsProvider r6 = r5.localOverrideSettings
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.updateSettings(r0)
            if (r6 != r1) goto L4c
            goto L5a
        L4c:
            r2 = r5
        L4d:
            com.google.firebase.sessions.settings.SettingsProvider r6 = r2.remoteSettings
            r2 = 0
            r0.L$0 = r2
            r0.label = r3
            java.lang.Object r6 = r6.updateSettings(r0)
            if (r6 != r1) goto L5b
        L5a:
            return r1
        L5b:
            W2.E r6 = W2.E.f5463a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.SessionsSettings.updateSettings(Z2.e):java.lang.Object");
    }
}
