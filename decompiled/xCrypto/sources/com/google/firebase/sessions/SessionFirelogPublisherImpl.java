package com.google.firebase.sessions;

import W2.E;
import Z2.e;
import Z2.i;
import android.util.Log;
import b3.AbstractC0866d;
import b3.InterfaceC0868f;
import b3.l;
import com.google.firebase.FirebaseApp;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.settings.SessionsSettings;
import i3.o;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import t3.AbstractC1822k;
import t3.L;
import t3.M;

/* JADX INFO: loaded from: classes.dex */
public final class SessionFirelogPublisherImpl implements SessionFirelogPublisher {
    private static final String TAG = "SessionFirelogPublisher";
    private final i backgroundDispatcher;
    private final EventGDTLoggerInterface eventGDTLogger;
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final SessionsSettings sessionSettings;
    public static final Companion Companion = new Companion(null);
    private static final double randomValueForSampling = Math.random();

    public static final class Companion {
        public /* synthetic */ Companion(AbstractC1585j abstractC1585j) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1, reason: invalid class name */
    @InterfaceC0868f(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl$logSession$1", f = "SessionFirelogPublisher.kt", l = {69, 70, 76}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends l implements o {
        final /* synthetic */ SessionDetails $sessionDetails;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SessionDetails sessionDetails, e eVar) {
            super(2, eVar);
            this.$sessionDetails = sessionDetails;
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            return SessionFirelogPublisherImpl.this.new AnonymousClass1(this.$sessionDetails, eVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
        @Override // b3.AbstractC0863a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                r8 = this;
                java.lang.Object r0 = a3.AbstractC0787c.e()
                int r1 = r8.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L45
                if (r1 == r4) goto L41
                if (r1 == r3) goto L3d
                if (r1 != r2) goto L35
                java.lang.Object r0 = r8.L$5
                com.google.firebase.sessions.settings.SessionsSettings r0 = (com.google.firebase.sessions.settings.SessionsSettings) r0
                java.lang.Object r1 = r8.L$4
                com.google.firebase.sessions.SessionDetails r1 = (com.google.firebase.sessions.SessionDetails) r1
                java.lang.Object r2 = r8.L$3
                com.google.firebase.FirebaseApp r2 = (com.google.firebase.FirebaseApp) r2
                java.lang.Object r3 = r8.L$2
                com.google.firebase.sessions.SessionEvents r3 = (com.google.firebase.sessions.SessionEvents) r3
                java.lang.Object r4 = r8.L$1
                com.google.firebase.sessions.SessionFirelogPublisherImpl r4 = (com.google.firebase.sessions.SessionFirelogPublisherImpl) r4
                java.lang.Object r5 = r8.L$0
                com.google.firebase.sessions.InstallationId r5 = (com.google.firebase.sessions.InstallationId) r5
                W2.q.b(r9)
                r7 = r3
                r3 = r0
                r0 = r7
                r7 = r2
                r2 = r1
                r1 = r7
            L32:
                r7 = r4
                goto L9d
            L35:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L3d:
                W2.q.b(r9)
                goto L6c
            L41:
                W2.q.b(r9)
                goto L53
            L45:
                W2.q.b(r9)
                com.google.firebase.sessions.SessionFirelogPublisherImpl r9 = com.google.firebase.sessions.SessionFirelogPublisherImpl.this
                r8.label = r4
                java.lang.Object r9 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$shouldLogSession(r9, r8)
                if (r9 != r0) goto L53
                goto L95
            L53:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto Lb0
                com.google.firebase.sessions.InstallationId$Companion r9 = com.google.firebase.sessions.InstallationId.Companion
                com.google.firebase.sessions.SessionFirelogPublisherImpl r1 = com.google.firebase.sessions.SessionFirelogPublisherImpl.this
                com.google.firebase.installations.FirebaseInstallationsApi r1 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$getFirebaseInstallations$p(r1)
                r8.label = r3
                java.lang.Object r9 = r9.create(r1, r8)
                if (r9 != r0) goto L6c
                goto L95
            L6c:
                r5 = r9
                com.google.firebase.sessions.InstallationId r5 = (com.google.firebase.sessions.InstallationId) r5
                com.google.firebase.sessions.SessionFirelogPublisherImpl r4 = com.google.firebase.sessions.SessionFirelogPublisherImpl.this
                com.google.firebase.sessions.SessionEvents r3 = com.google.firebase.sessions.SessionEvents.INSTANCE
                com.google.firebase.FirebaseApp r9 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$getFirebaseApp$p(r4)
                com.google.firebase.sessions.SessionDetails r1 = r8.$sessionDetails
                com.google.firebase.sessions.SessionFirelogPublisherImpl r6 = com.google.firebase.sessions.SessionFirelogPublisherImpl.this
                com.google.firebase.sessions.settings.SessionsSettings r6 = com.google.firebase.sessions.SessionFirelogPublisherImpl.access$getSessionSettings$p(r6)
                com.google.firebase.sessions.api.FirebaseSessionsDependencies r7 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.INSTANCE
                r8.L$0 = r5
                r8.L$1 = r4
                r8.L$2 = r3
                r8.L$3 = r9
                r8.L$4 = r1
                r8.L$5 = r6
                r8.label = r2
                java.lang.Object r2 = r7.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r8)
                if (r2 != r0) goto L96
            L95:
                return r0
            L96:
                r0 = r1
                r1 = r9
                r9 = r2
                r2 = r0
                r0 = r3
                r3 = r6
                goto L32
            L9d:
                r4 = r9
                java.util.Map r4 = (java.util.Map) r4
                r9 = r5
                java.lang.String r5 = r9.getFid()
                java.lang.String r6 = r9.getAuthToken()
                com.google.firebase.sessions.SessionEvent r9 = r0.buildSession(r1, r2, r3, r4, r5, r6)
                com.google.firebase.sessions.SessionFirelogPublisherImpl.access$attemptLoggingSessionEvent(r7, r9)
            Lb0:
                W2.E r9 = W2.E.f5463a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i3.o
        public final Object invoke(L l4, e eVar) {
            return ((AnonymousClass1) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    /* JADX INFO: renamed from: com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1, reason: invalid class name and case insensitive filesystem */
    @InterfaceC0868f(c = "com.google.firebase.sessions.SessionFirelogPublisherImpl", f = "SessionFirelogPublisher.kt", l = {com.amazon.device.iap.internal.a.f9090a}, m = "shouldLogSession")
    public static final class C10471 extends AbstractC0866d {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public C10471(e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SessionFirelogPublisherImpl.this.shouldLogSession(this);
        }
    }

    public SessionFirelogPublisherImpl(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallations, SessionsSettings sessionSettings, EventGDTLoggerInterface eventGDTLogger, @Background i backgroundDispatcher) {
        r.f(firebaseApp, "firebaseApp");
        r.f(firebaseInstallations, "firebaseInstallations");
        r.f(sessionSettings, "sessionSettings");
        r.f(eventGDTLogger, "eventGDTLogger");
        r.f(backgroundDispatcher, "backgroundDispatcher");
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallations;
        this.sessionSettings = sessionSettings;
        this.eventGDTLogger = eventGDTLogger;
        this.backgroundDispatcher = backgroundDispatcher;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void attemptLoggingSessionEvent(SessionEvent sessionEvent) {
        try {
            this.eventGDTLogger.log(sessionEvent);
            Log.d(TAG, "Successfully logged Session Start event.");
        } catch (RuntimeException e4) {
            Log.e(TAG, "Error logging Session Start event to DataTransport: ", e4);
        }
    }

    private final boolean shouldCollectEvents() {
        return randomValueForSampling <= this.sessionSettings.getSamplingRate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object shouldLogSession(Z2.e r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.google.firebase.sessions.SessionFirelogPublisherImpl.C10471
            if (r0 == 0) goto L13
            r0 = r6
            com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 r0 = (com.google.firebase.sessions.SessionFirelogPublisherImpl.C10471) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1 r0 = new com.google.firebase.sessions.SessionFirelogPublisherImpl$shouldLogSession$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.label
            java.lang.String r3 = "SessionFirelogPublisher"
            r4 = 1
            if (r2 == 0) goto L37
            if (r2 != r4) goto L2f
            java.lang.Object r0 = r0.L$0
            com.google.firebase.sessions.SessionFirelogPublisherImpl r0 = (com.google.firebase.sessions.SessionFirelogPublisherImpl) r0
            W2.q.b(r6)
            goto L4d
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L37:
            W2.q.b(r6)
            java.lang.String r6 = "Data Collection is enabled for at least one Subscriber"
            android.util.Log.d(r3, r6)
            com.google.firebase.sessions.settings.SessionsSettings r6 = r5.sessionSettings
            r0.L$0 = r5
            r0.label = r4
            java.lang.Object r6 = r6.updateSettings(r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            r0 = r5
        L4d:
            com.google.firebase.sessions.settings.SessionsSettings r6 = r0.sessionSettings
            boolean r6 = r6.getSessionsEnabled()
            r1 = 0
            if (r6 != 0) goto L60
            java.lang.String r6 = "Sessions SDK disabled. Events will not be sent."
            android.util.Log.d(r3, r6)
            java.lang.Boolean r6 = b3.AbstractC0864b.a(r1)
            return r6
        L60:
            boolean r6 = r0.shouldCollectEvents()
            if (r6 != 0) goto L70
            java.lang.String r6 = "Sessions SDK has dropped this session due to sampling."
            android.util.Log.d(r3, r6)
            java.lang.Boolean r6 = b3.AbstractC0864b.a(r1)
            return r6
        L70:
            java.lang.Boolean r6 = b3.AbstractC0864b.a(r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.SessionFirelogPublisherImpl.shouldLogSession(Z2.e):java.lang.Object");
    }

    @Override // com.google.firebase.sessions.SessionFirelogPublisher
    public void logSession(SessionDetails sessionDetails) {
        r.f(sessionDetails, "sessionDetails");
        AbstractC1822k.d(M.a(this.backgroundDispatcher), null, null, new AnonymousClass1(sessionDetails, null), 3, null);
    }
}
