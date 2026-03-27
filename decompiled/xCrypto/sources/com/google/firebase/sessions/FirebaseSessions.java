package com.google.firebase.sessions;

import W2.E;
import Z2.e;
import Z2.i;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import b3.InterfaceC0868f;
import b3.l;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseKt;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.annotations.concurrent.Background;
import com.google.firebase.firestore.index.FirestoreIndexValueWriter;
import com.google.firebase.sessions.settings.SessionsSettings;
import i3.o;
import kotlin.jvm.internal.AbstractC1585j;
import kotlin.jvm.internal.r;
import t3.AbstractC1822k;
import t3.L;
import t3.M;

/* JADX INFO: loaded from: classes.dex */
public final class FirebaseSessions {
    public static final Companion Companion = new Companion(null);
    private static final String TAG = "FirebaseSessions";
    private final FirebaseApp firebaseApp;
    private final SessionsSettings settings;

    /* JADX INFO: renamed from: com.google.firebase.sessions.FirebaseSessions$1, reason: invalid class name */
    @InterfaceC0868f(c = "com.google.firebase.sessions.FirebaseSessions$1", f = "FirebaseSessions.kt", l = {51, FirestoreIndexValueWriter.INDEX_TYPE_MAP}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends l implements o {
        final /* synthetic */ i $backgroundDispatcher;
        final /* synthetic */ SessionLifecycleServiceBinder $lifecycleServiceBinder;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(i iVar, SessionLifecycleServiceBinder sessionLifecycleServiceBinder, e eVar) {
            super(2, eVar);
            this.$backgroundDispatcher = iVar;
            this.$lifecycleServiceBinder = sessionLifecycleServiceBinder;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$1(String str, FirebaseOptions firebaseOptions) {
            Log.w("FirebaseSessions", "FirebaseApp instance deleted. Sessions library will stop collecting data.");
            SessionsActivityLifecycleCallbacks.INSTANCE.setLifecycleClient(null);
        }

        @Override // b3.AbstractC0863a
        public final e create(Object obj, e eVar) {
            return FirebaseSessions.this.new AnonymousClass1(this.$backgroundDispatcher, this.$lifecycleServiceBinder, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
        
            if (r6.updateSettings(r5) == r0) goto L25;
         */
        @Override // b3.AbstractC0863a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = a3.AbstractC0787c.e()
                int r1 = r5.label
                java.lang.String r2 = "FirebaseSessions"
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L20
                if (r1 == r4) goto L1c
                if (r1 != r3) goto L14
                W2.q.b(r6)
                goto L62
            L14:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1c:
                W2.q.b(r6)
                goto L2e
            L20:
                W2.q.b(r6)
                com.google.firebase.sessions.api.FirebaseSessionsDependencies r6 = com.google.firebase.sessions.api.FirebaseSessionsDependencies.INSTANCE
                r5.label = r4
                java.lang.Object r6 = r6.getRegisteredSubscribers$com_google_firebase_firebase_sessions(r5)
                if (r6 != r0) goto L2e
                goto L61
            L2e:
                java.util.Map r6 = (java.util.Map) r6
                java.util.Collection r6 = r6.values()
                if (r6 == 0) goto L3d
                boolean r1 = r6.isEmpty()
                if (r1 == 0) goto L3d
                goto L94
            L3d:
                java.util.Iterator r6 = r6.iterator()
            L41:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L94
                java.lang.Object r1 = r6.next()
                com.google.firebase.sessions.api.SessionSubscriber r1 = (com.google.firebase.sessions.api.SessionSubscriber) r1
                boolean r1 = r1.isDataCollectionEnabled()
                if (r1 == 0) goto L41
                com.google.firebase.sessions.FirebaseSessions r6 = com.google.firebase.sessions.FirebaseSessions.this
                com.google.firebase.sessions.settings.SessionsSettings r6 = com.google.firebase.sessions.FirebaseSessions.access$getSettings$p(r6)
                r5.label = r3
                java.lang.Object r6 = r6.updateSettings(r5)
                if (r6 != r0) goto L62
            L61:
                return r0
            L62:
                com.google.firebase.sessions.FirebaseSessions r6 = com.google.firebase.sessions.FirebaseSessions.this
                com.google.firebase.sessions.settings.SessionsSettings r6 = com.google.firebase.sessions.FirebaseSessions.access$getSettings$p(r6)
                boolean r6 = r6.getSessionsEnabled()
                if (r6 != 0) goto L74
                java.lang.String r6 = "Sessions SDK disabled. Not listening to lifecycle events."
                android.util.Log.d(r2, r6)
                goto L99
            L74:
                com.google.firebase.sessions.SessionLifecycleClient r6 = new com.google.firebase.sessions.SessionLifecycleClient
                Z2.i r0 = r5.$backgroundDispatcher
                r6.<init>(r0)
                com.google.firebase.sessions.SessionLifecycleServiceBinder r0 = r5.$lifecycleServiceBinder
                r6.bindToService(r0)
                com.google.firebase.sessions.SessionsActivityLifecycleCallbacks r0 = com.google.firebase.sessions.SessionsActivityLifecycleCallbacks.INSTANCE
                r0.setLifecycleClient(r6)
                com.google.firebase.sessions.FirebaseSessions r6 = com.google.firebase.sessions.FirebaseSessions.this
                com.google.firebase.FirebaseApp r6 = com.google.firebase.sessions.FirebaseSessions.access$getFirebaseApp$p(r6)
                com.google.firebase.sessions.b r0 = new com.google.firebase.sessions.b
                r0.<init>()
                r6.addLifecycleEventListener(r0)
                goto L99
            L94:
                java.lang.String r6 = "No Sessions subscribers. Not listening to lifecycle events."
                android.util.Log.d(r2, r6)
            L99:
                W2.E r6 = W2.E.f5463a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.FirebaseSessions.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
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

        public final FirebaseSessions getInstance() {
            Object obj = FirebaseKt.getApp(Firebase.INSTANCE).get(FirebaseSessions.class);
            r.e(obj, "Firebase.app[FirebaseSessions::class.java]");
            return (FirebaseSessions) obj;
        }

        private Companion() {
        }
    }

    public FirebaseSessions(FirebaseApp firebaseApp, SessionsSettings settings, @Background i backgroundDispatcher, SessionLifecycleServiceBinder lifecycleServiceBinder) {
        r.f(firebaseApp, "firebaseApp");
        r.f(settings, "settings");
        r.f(backgroundDispatcher, "backgroundDispatcher");
        r.f(lifecycleServiceBinder, "lifecycleServiceBinder");
        this.firebaseApp = firebaseApp;
        this.settings = settings;
        Log.d("FirebaseSessions", "Initializing Firebase Sessions SDK.");
        Context applicationContext = firebaseApp.getApplicationContext().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(SessionsActivityLifecycleCallbacks.INSTANCE);
            AbstractC1822k.d(M.a(backgroundDispatcher), null, null, new AnonymousClass1(backgroundDispatcher, lifecycleServiceBinder, null), 3, null);
            return;
        }
        Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + com.amazon.a.a.o.c.a.b.f8816a);
    }
}
