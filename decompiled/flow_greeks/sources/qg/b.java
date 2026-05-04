package qg;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final pd.o f19112e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f19113a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f19114b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f19116d;

        public a(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f19114b = obj;
            this.f19116d |= Integer.MIN_VALUE;
            return b.this.e(null, this);
        }
    }

    public /* synthetic */ b(pd.o oVar, gd.i iVar, int i10, pg.a aVar, int i11, kotlin.jvm.internal.k kVar) {
        this(oVar, (i11 & 2) != 0 ? gd.j.f10531a : iVar, (i11 & 4) != 0 ? -2 : i10, (i11 & 8) != 0 ? pg.a.f18621a : aVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // qg.c, rg.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(pg.v r5, gd.e r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof qg.b.a
            if (r0 == 0) goto L13
            r0 = r6
            qg.b$a r0 = (qg.b.a) r0
            int r1 = r0.f19116d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f19116d = r1
            goto L18
        L13:
            qg.b$a r0 = new qg.b$a
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f19114b
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f19116d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f19113a
            pg.v r5 = (pg.v) r5
            cd.s.b(r6)
            goto L43
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            cd.s.b(r6)
            r0.f19113a = r5
            r0.f19116d = r3
            java.lang.Object r6 = super.e(r5, r0)
            if (r6 != r1) goto L43
            return r1
        L43:
            boolean r5 = r5.n()
            if (r5 == 0) goto L4c
            cd.h0 r5 = cd.h0.f3852a
            return r5
        L4c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "'awaitClose { yourCallbackOrListener.cancel() }' should be used in the end of callbackFlow block.\nOtherwise, a callback/listener may leak in case of external cancellation.\nSee callbackFlow API documentation for the details."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: qg.b.e(pg.v, gd.e):java.lang.Object");
    }

    @Override // qg.c, rg.e
    public rg.e f(gd.i iVar, int i10, pg.a aVar) {
        return new b(this.f19112e, iVar, i10, aVar);
    }

    public b(pd.o oVar, gd.i iVar, int i10, pg.a aVar) {
        super(oVar, iVar, i10, aVar);
        this.f19112e = oVar;
    }
}
