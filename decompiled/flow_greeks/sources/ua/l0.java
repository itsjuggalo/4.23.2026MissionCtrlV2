package ua;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class l0 implements k0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f22605f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final double f22606g = Math.random();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a7.g f22607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ga.h f22608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final xa.j f22609c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final h f22610d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final gd.i f22611e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f22612a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f22613b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f22614c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f22615d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Object f22616e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Object f22617f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f22618g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final /* synthetic */ SessionDetails f22620i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SessionDetails sessionDetails, gd.e eVar) {
            super(2, eVar);
            this.f22620i = sessionDetails;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return l0.this.new b(this.f22620i, eVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:24:0x0096  */
        @Override // id.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                r8 = this;
                java.lang.Object r0 = hd.c.f()
                int r1 = r8.f22618g
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L45
                if (r1 == r4) goto L41
                if (r1 == r3) goto L3d
                if (r1 != r2) goto L35
                java.lang.Object r0 = r8.f22617f
                xa.j r0 = (xa.j) r0
                java.lang.Object r1 = r8.f22616e
                ua.h0 r1 = (ua.SessionDetails) r1
                java.lang.Object r2 = r8.f22615d
                a7.g r2 = (a7.g) r2
                java.lang.Object r3 = r8.f22614c
                ua.j0 r3 = (ua.j0) r3
                java.lang.Object r4 = r8.f22613b
                ua.l0 r4 = (ua.l0) r4
                java.lang.Object r5 = r8.f22612a
                ua.t r5 = (ua.t) r5
                cd.s.b(r9)
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
                cd.s.b(r9)
                goto L6c
            L41:
                cd.s.b(r9)
                goto L53
            L45:
                cd.s.b(r9)
                ua.l0 r9 = ua.l0.this
                r8.f22618g = r4
                java.lang.Object r9 = ua.l0.f(r9, r8)
                if (r9 != r0) goto L53
                goto L95
            L53:
                java.lang.Boolean r9 = (java.lang.Boolean) r9
                boolean r9 = r9.booleanValue()
                if (r9 == 0) goto Lb0
                ua.t$a r9 = ua.t.f22653c
                ua.l0 r1 = ua.l0.this
                ga.h r1 = ua.l0.d(r1)
                r8.f22618g = r3
                java.lang.Object r9 = r9.a(r1, r8)
                if (r9 != r0) goto L6c
                goto L95
            L6c:
                r5 = r9
                ua.t r5 = (ua.t) r5
                ua.l0 r4 = ua.l0.this
                ua.j0 r3 = ua.j0.f22596a
                a7.g r9 = ua.l0.c(r4)
                ua.h0 r1 = r8.f22620i
                ua.l0 r6 = ua.l0.this
                xa.j r6 = ua.l0.e(r6)
                va.b r7 = va.b.f23206a
                r8.f22612a = r5
                r8.f22613b = r4
                r8.f22614c = r3
                r8.f22615d = r9
                r8.f22616e = r1
                r8.f22617f = r6
                r8.f22618g = r2
                java.lang.Object r2 = r7.c(r8)
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
                java.lang.String r5 = r9.b()
                java.lang.String r6 = r9.a()
                ua.i0 r9 = r0.a(r1, r2, r3, r4, r5, r6)
                ua.l0.b(r7, r9)
            Lb0:
                cd.h0 r9 = cd.h0.f3852a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: ua.l0.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // pd.o
        public final Object invoke(ng.n0 n0Var, gd.e eVar) {
            return ((b) create(n0Var, eVar)).invokeSuspend(cd.h0.f3852a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f22621a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f22622b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f22624d;

        public c(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f22622b = obj;
            this.f22624d |= Integer.MIN_VALUE;
            return l0.this.i(this);
        }
    }

    public l0(a7.g firebaseApp, ga.h firebaseInstallations, xa.j sessionSettings, h eventGDTLogger, gd.i backgroundDispatcher) {
        kotlin.jvm.internal.t.f(firebaseApp, "firebaseApp");
        kotlin.jvm.internal.t.f(firebaseInstallations, "firebaseInstallations");
        kotlin.jvm.internal.t.f(sessionSettings, "sessionSettings");
        kotlin.jvm.internal.t.f(eventGDTLogger, "eventGDTLogger");
        kotlin.jvm.internal.t.f(backgroundDispatcher, "backgroundDispatcher");
        this.f22607a = firebaseApp;
        this.f22608b = firebaseInstallations;
        this.f22609c = sessionSettings;
        this.f22610d = eventGDTLogger;
        this.f22611e = backgroundDispatcher;
    }

    @Override // ua.k0
    public void a(SessionDetails sessionDetails) {
        kotlin.jvm.internal.t.f(sessionDetails, "sessionDetails");
        ng.k.d(ng.o0.a(this.f22611e), null, null, new b(sessionDetails, null), 3, null);
    }

    public final void g(i0 i0Var) {
        try {
            this.f22610d.a(i0Var);
            Log.d("FirebaseSessions", "Successfully logged Session Start event.");
        } catch (RuntimeException e10) {
            Log.e("FirebaseSessions", "Error logging Session Start event to DataTransport: ", e10);
        }
    }

    public final boolean h() {
        return f22606g <= this.f22609c.a();
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object i(gd.e r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof ua.l0.c
            if (r0 == 0) goto L13
            r0 = r9
            ua.l0$c r0 = (ua.l0.c) r0
            int r1 = r0.f22624d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f22624d = r1
            goto L18
        L13:
            ua.l0$c r0 = new ua.l0$c
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f22622b
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f22624d
            r3 = 2
            r4 = 0
            java.lang.String r5 = "FirebaseSessions"
            r6 = 1
            if (r2 == 0) goto L43
            if (r2 == r6) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r0 = r0.f22621a
            ua.l0 r0 = (ua.l0) r0
            cd.s.b(r9)
            goto L87
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3b:
            java.lang.Object r2 = r0.f22621a
            ua.l0 r2 = (ua.l0) r2
            cd.s.b(r9)
            goto L54
        L43:
            cd.s.b(r9)
            va.b r9 = va.b.f23206a
            r0.f22621a = r8
            r0.f22624d = r6
            java.lang.Object r9 = r9.c(r0)
            if (r9 != r1) goto L53
            goto L85
        L53:
            r2 = r8
        L54:
            java.util.Map r9 = (java.util.Map) r9
            java.util.Collection r9 = r9.values()
            if (r9 == 0) goto L63
            boolean r7 = r9.isEmpty()
            if (r7 == 0) goto L63
            goto Lae
        L63:
            java.util.Iterator r9 = r9.iterator()
        L67:
            boolean r7 = r9.hasNext()
            if (r7 == 0) goto Lae
            java.lang.Object r7 = r9.next()
            va.c r7 = (va.c) r7
            boolean r7 = r7.a()
            if (r7 == 0) goto L67
            xa.j r9 = r2.f22609c
            r0.f22621a = r2
            r0.f22624d = r3
            java.lang.Object r9 = r9.f(r0)
            if (r9 != r1) goto L86
        L85:
            return r1
        L86:
            r0 = r2
        L87:
            xa.j r9 = r0.f22609c
            boolean r9 = r9.c()
            if (r9 != 0) goto L99
            java.lang.String r9 = "Sessions SDK disabled through settings API. Events will not be sent."
            android.util.Log.d(r5, r9)
            java.lang.Boolean r9 = id.b.a(r4)
            return r9
        L99:
            boolean r9 = r0.h()
            if (r9 != 0) goto La9
            java.lang.String r9 = "Sessions SDK has dropped this session due to sampling."
            android.util.Log.d(r5, r9)
            java.lang.Boolean r9 = id.b.a(r4)
            return r9
        La9:
            java.lang.Boolean r9 = id.b.a(r6)
            return r9
        Lae:
            java.lang.String r9 = "Sessions SDK disabled through data collection. Events will not be sent."
            android.util.Log.d(r5, r9)
            java.lang.Boolean r9 = id.b.a(r4)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: ua.l0.i(gd.e):java.lang.Object");
    }
}
