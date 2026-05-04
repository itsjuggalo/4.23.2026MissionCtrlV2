package pg;

import cd.h0;
import cd.r;
import ng.i0;
import ng.n0;
import ng.p0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f18681a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f18682b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f18683c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f18684d;

        public a(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f18683c = obj;
            this.f18684d |= Integer.MIN_VALUE;
            return t.a(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ng.n f18685a;

        public b(ng.n nVar) {
            this.f18685a = nVar;
        }

        public final void a(Throwable th) {
            ng.n nVar = this.f18685a;
            r.a aVar = cd.r.f3870b;
            nVar.resumeWith(cd.r.b(h0.f3852a));
        }

        @Override // pd.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return h0.f3852a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(pg.v r4, kotlin.jvm.functions.Function0 r5, gd.e r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof pg.t.a
            if (r0 == 0) goto L13
            r0 = r6
            pg.t$a r0 = (pg.t.a) r0
            int r1 = r0.f18684d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f18684d = r1
            goto L18
        L13:
            pg.t$a r0 = new pg.t$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f18683c
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f18684d
            r3 = 1
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L34
            java.lang.Object r4 = r0.f18682b
            r5 = r4
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            java.lang.Object r4 = r0.f18681a
            pg.v r4 = (pg.v) r4
            cd.s.b(r6)     // Catch: java.lang.Throwable -> L32
            goto L75
        L32:
            r4 = move-exception
            goto L7b
        L34:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3c:
            cd.s.b(r6)
            gd.i r6 = r0.getContext()
            ng.y1$b r2 = ng.y1.N
            gd.i$b r6 = r6.get(r2)
            if (r6 != r4) goto L7f
            r0.f18681a = r4     // Catch: java.lang.Throwable -> L32
            r0.f18682b = r5     // Catch: java.lang.Throwable -> L32
            r0.f18684d = r3     // Catch: java.lang.Throwable -> L32
            ng.p r6 = new ng.p     // Catch: java.lang.Throwable -> L32
            gd.e r2 = hd.b.c(r0)     // Catch: java.lang.Throwable -> L32
            r6.<init>(r2, r3)     // Catch: java.lang.Throwable -> L32
            r6.E()     // Catch: java.lang.Throwable -> L32
            pg.t$b r2 = new pg.t$b     // Catch: java.lang.Throwable -> L32
            r2.<init>(r6)     // Catch: java.lang.Throwable -> L32
            r4.m(r2)     // Catch: java.lang.Throwable -> L32
            java.lang.Object r4 = r6.y()     // Catch: java.lang.Throwable -> L32
            java.lang.Object r6 = hd.c.f()     // Catch: java.lang.Throwable -> L32
            if (r4 != r6) goto L72
            id.h.c(r0)     // Catch: java.lang.Throwable -> L32
        L72:
            if (r4 != r1) goto L75
            return r1
        L75:
            r5.invoke()
            cd.h0 r4 = cd.h0.f3852a
            return r4
        L7b:
            r5.invoke()
            throw r4
        L7f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: pg.t.a(pg.v, kotlin.jvm.functions.Function0, gd.e):java.lang.Object");
    }

    public static final w b(n0 n0Var, gd.i iVar, int i10, pg.a aVar, p0 p0Var, pd.k kVar, pd.o oVar) {
        u uVar = new u(i0.k(n0Var, iVar), j.b(i10, aVar, null, 4, null));
        if (kVar != null) {
            uVar.invokeOnCompletion(kVar);
        }
        uVar.N0(p0Var, uVar, oVar);
        return uVar;
    }

    public static /* synthetic */ w c(n0 n0Var, gd.i iVar, int i10, pg.a aVar, p0 p0Var, pd.k kVar, pd.o oVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            iVar = gd.j.f10531a;
        }
        if ((i11 & 2) != 0) {
            i10 = 0;
        }
        if ((i11 & 4) != 0) {
            aVar = pg.a.f18621a;
        }
        if ((i11 & 8) != 0) {
            p0Var = p0.f17167a;
        }
        if ((i11 & 16) != 0) {
            kVar = null;
        }
        pd.k kVar2 = kVar;
        return b(n0Var, iVar, i10, aVar, p0Var, kVar2, oVar);
    }
}
