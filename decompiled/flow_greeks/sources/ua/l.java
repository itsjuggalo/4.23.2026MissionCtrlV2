package ua;

import android.app.Application;
import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f22599c = new b(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.g f22600a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final xa.j f22601b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f22602a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ q0 f22604c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(q0 q0Var, gd.e eVar) {
            super(2, eVar);
            this.f22604c = q0Var;
        }

        public static final void l(q0 q0Var, String str, a7.p pVar) {
            Log.w("FirebaseSessions", "FirebaseApp instance deleted. Sessions library will stop collecting data.");
            q0Var.a();
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return l.this.new a(this.f22604c, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:24:0x005f, code lost:
        
            if (r6.f(r5) == r0) goto L25;
         */
        @Override // id.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = hd.c.f()
                int r1 = r5.f22602a
                java.lang.String r2 = "FirebaseSessions"
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L20
                if (r1 == r4) goto L1c
                if (r1 != r3) goto L14
                cd.s.b(r6)
                goto L62
            L14:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1c:
                cd.s.b(r6)
                goto L2e
            L20:
                cd.s.b(r6)
                va.b r6 = va.b.f23206a
                r5.f22602a = r4
                java.lang.Object r6 = r6.c(r5)
                if (r6 != r0) goto L2e
                goto L61
            L2e:
                java.util.Map r6 = (java.util.Map) r6
                java.util.Collection r6 = r6.values()
                if (r6 == 0) goto L3d
                boolean r1 = r6.isEmpty()
                if (r1 == 0) goto L3d
                goto L8b
            L3d:
                java.util.Iterator r6 = r6.iterator()
            L41:
                boolean r1 = r6.hasNext()
                if (r1 == 0) goto L8b
                java.lang.Object r1 = r6.next()
                va.c r1 = (va.c) r1
                boolean r1 = r1.a()
                if (r1 == 0) goto L41
                ua.l r6 = ua.l.this
                xa.j r6 = ua.l.b(r6)
                r5.f22602a = r3
                java.lang.Object r6 = r6.f(r5)
                if (r6 != r0) goto L62
            L61:
                return r0
            L62:
                ua.l r6 = ua.l.this
                xa.j r6 = ua.l.b(r6)
                boolean r6 = r6.c()
                if (r6 != 0) goto L78
                java.lang.String r6 = "Sessions SDK disabled. Not listening to lifecycle events."
                int r6 = android.util.Log.d(r2, r6)
                id.b.c(r6)
                goto L94
            L78:
                ua.l r6 = ua.l.this
                a7.g r6 = ua.l.a(r6)
                ua.q0 r0 = r5.f22604c
                ua.k r1 = new ua.k
                r1.<init>()
                r6.h(r1)
                cd.h0 r6 = cd.h0.f3852a
                goto L94
            L8b:
                java.lang.String r6 = "No Sessions subscribers. Not listening to lifecycle events."
                int r6 = android.util.Log.d(r2, r6)
                id.b.c(r6)
            L94:
                cd.h0 r6 = cd.h0.f3852a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: ua.l.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // pd.o
        public final Object invoke(ng.n0 n0Var, gd.e eVar) {
            return ((a) create(n0Var, eVar)).invokeSuspend(cd.h0.f3852a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.k kVar) {
            this();
        }

        public b() {
        }
    }

    public l(a7.g firebaseApp, xa.j settings, gd.i backgroundDispatcher, q0 sessionsActivityLifecycleCallbacks) {
        kotlin.jvm.internal.t.f(firebaseApp, "firebaseApp");
        kotlin.jvm.internal.t.f(settings, "settings");
        kotlin.jvm.internal.t.f(backgroundDispatcher, "backgroundDispatcher");
        kotlin.jvm.internal.t.f(sessionsActivityLifecycleCallbacks, "sessionsActivityLifecycleCallbacks");
        this.f22600a = firebaseApp;
        this.f22601b = settings;
        Log.d("FirebaseSessions", "Initializing Firebase Sessions 3.0.3.");
        Context applicationContext = firebaseApp.m().getApplicationContext();
        if (applicationContext instanceof Application) {
            ((Application) applicationContext).registerActivityLifecycleCallbacks(sessionsActivityLifecycleCallbacks);
            ng.k.d(ng.o0.a(backgroundDispatcher), null, null, new a(sessionsActivityLifecycleCallbacks, null), 3, null);
            return;
        }
        Log.e("FirebaseSessions", "Failed to register lifecycle callbacks, unexpected context " + applicationContext.getClass() + com.amazon.a.a.o.c.a.b.f4610a);
    }
}
