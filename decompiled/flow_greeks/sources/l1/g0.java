package l1;

import com.google.android.gms.common.api.a;
import ng.y1;
import pg.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ng.n0 f15013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final pd.o f15014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pg.g f15015c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l1.b f15016d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends kotlin.jvm.internal.v implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pd.k f15017a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ g0 f15018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ pd.o f15019c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(pd.k kVar, g0 g0Var, pd.o oVar) {
            super(1);
            this.f15017a = kVar;
            this.f15018b = g0Var;
            this.f15019c = oVar;
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((Throwable) obj);
            return cd.h0.f3852a;
        }

        public final void invoke(Throwable th) {
            cd.h0 h0Var;
            this.f15017a.invoke(th);
            this.f15018b.f15015c.d(th);
            do {
                Object objF = pg.k.f(this.f15018b.f15015c.b());
                if (objF != null) {
                    this.f15019c.invoke(objF, th);
                    h0Var = cd.h0.f3852a;
                } else {
                    h0Var = null;
                }
            } while (h0Var != null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15020a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f15021b;

        public b(gd.e eVar) {
            super(2, eVar);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return g0.this.new b(eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x005a, code lost:
        
            if (r1.invoke(r6, r5) != r0) goto L18;
         */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0051 A[PHI: r1 r6
          0x0051: PHI (r1v1 pd.o) = (r1v2 pd.o), (r1v4 pd.o) binds: [B:13:0x004e, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]
          0x0051: PHI (r6v5 java.lang.Object) = (r6v12 java.lang.Object), (r6v0 java.lang.Object) binds: [B:13:0x004e, B:9:0x001a] A[DONT_GENERATE, DONT_INLINE]] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005a -> B:18:0x005d). Please report as a decompilation issue!!! */
        @Override // id.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = hd.c.f()
                int r1 = r5.f15021b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                cd.s.b(r6)
                goto L5d
            L12:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1a:
                java.lang.Object r1 = r5.f15020a
                pd.o r1 = (pd.o) r1
                cd.s.b(r6)
                goto L51
            L22:
                cd.s.b(r6)
                l1.g0 r6 = l1.g0.this
                l1.b r6 = l1.g0.c(r6)
                int r6 = r6.b()
                if (r6 <= 0) goto L6c
            L31:
                l1.g0 r6 = l1.g0.this
                ng.n0 r6 = l1.g0.d(r6)
                ng.o0.d(r6)
                l1.g0 r6 = l1.g0.this
                pd.o r1 = l1.g0.a(r6)
                l1.g0 r6 = l1.g0.this
                pg.g r6 = l1.g0.b(r6)
                r5.f15020a = r1
                r5.f15021b = r3
                java.lang.Object r6 = r6.a(r5)
                if (r6 != r0) goto L51
                goto L5c
            L51:
                r4 = 0
                r5.f15020a = r4
                r5.f15021b = r2
                java.lang.Object r6 = r1.invoke(r6, r5)
                if (r6 != r0) goto L5d
            L5c:
                return r0
            L5d:
                l1.g0 r6 = l1.g0.this
                l1.b r6 = l1.g0.c(r6)
                int r6 = r6.a()
                if (r6 != 0) goto L31
                cd.h0 r6 = cd.h0.f3852a
                return r6
            L6c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "Check failed."
                r6.<init>(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: l1.g0.b.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // pd.o
        public final Object invoke(ng.n0 n0Var, gd.e eVar) {
            return ((b) create(n0Var, eVar)).invokeSuspend(cd.h0.f3852a);
        }
    }

    public g0(ng.n0 scope, pd.k onComplete, pd.o onUndeliveredElement, pd.o consumeMessage) {
        kotlin.jvm.internal.t.f(scope, "scope");
        kotlin.jvm.internal.t.f(onComplete, "onComplete");
        kotlin.jvm.internal.t.f(onUndeliveredElement, "onUndeliveredElement");
        kotlin.jvm.internal.t.f(consumeMessage, "consumeMessage");
        this.f15013a = scope;
        this.f15014b = consumeMessage;
        this.f15015c = pg.j.b(a.e.API_PRIORITY_OTHER, null, null, 6, null);
        this.f15016d = new l1.b(0);
        y1 y1Var = (y1) scope.g().get(y1.N);
        if (y1Var != null) {
            y1Var.invokeOnCompletion(new a(onComplete, this, onUndeliveredElement));
        }
    }

    public final void e(Object obj) throws Throwable {
        Object objL = this.f15015c.l(obj);
        if (objL instanceof k.a) {
            Throwable thE = pg.k.e(objL);
            if (thE != null) {
                throw thE;
            }
            throw new pg.r("Channel was closed normally");
        }
        if (!pg.k.i(objL)) {
            throw new IllegalStateException("Check failed.");
        }
        if (this.f15016d.c() == 0) {
            ng.k.d(this.f15013a, null, null, new b(null), 3, null);
        }
    }
}
