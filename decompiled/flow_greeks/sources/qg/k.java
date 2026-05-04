package qg;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class k {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f19124a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f19125b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19126c;

        public a(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f19125b = obj;
            this.f19126c |= Integer.MIN_VALUE;
            return k.c(null, null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f19127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ pd.p f19128b;

        public static final class a extends id.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f19129a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f19130b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f19132d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f19133e;

            public a(gd.e eVar) {
                super(eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) {
                this.f19129a = obj;
                this.f19130b |= Integer.MIN_VALUE;
                return b.this.collect(null, this);
            }
        }

        public b(d dVar, pd.p pVar) {
            this.f19127a = dVar;
            this.f19128b = pVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // qg.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object collect(qg.e r9, gd.e r10) throws java.lang.Throwable {
            /*
                r8 = this;
                boolean r0 = r10 instanceof qg.k.b.a
                if (r0 == 0) goto L13
                r0 = r10
                qg.k$b$a r0 = (qg.k.b.a) r0
                int r1 = r0.f19130b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f19130b = r1
                goto L18
            L13:
                qg.k$b$a r0 = new qg.k$b$a
                r0.<init>(r10)
            L18:
                java.lang.Object r10 = r0.f19129a
                java.lang.Object r1 = hd.c.f()
                int r2 = r0.f19130b
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L55
                if (r2 == r5) goto L47
                if (r2 == r4) goto L3e
                if (r2 != r3) goto L36
                java.lang.Object r9 = r0.f19132d
                rg.o r9 = (rg.o) r9
                cd.s.b(r10)     // Catch: java.lang.Throwable -> L34
                goto L89
            L34:
                r10 = move-exception
                goto L93
            L36:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L3e:
                java.lang.Object r9 = r0.f19132d
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                cd.s.b(r10)
                goto Lad
            L47:
                java.lang.Object r9 = r0.f19133e
                qg.e r9 = (qg.e) r9
                java.lang.Object r2 = r0.f19132d
                qg.k$b r2 = (qg.k.b) r2
                cd.s.b(r10)     // Catch: java.lang.Throwable -> L53
                goto L68
            L53:
                r9 = move-exception
                goto L99
            L55:
                cd.s.b(r10)
                qg.d r10 = r8.f19127a     // Catch: java.lang.Throwable -> L97
                r0.f19132d = r8     // Catch: java.lang.Throwable -> L97
                r0.f19133e = r9     // Catch: java.lang.Throwable -> L97
                r0.f19130b = r5     // Catch: java.lang.Throwable -> L97
                java.lang.Object r10 = r10.collect(r9, r0)     // Catch: java.lang.Throwable -> L97
                if (r10 != r1) goto L67
                goto Lac
            L67:
                r2 = r8
            L68:
                rg.o r10 = new rg.o
                gd.i r4 = r0.getContext()
                r10.<init>(r9, r4)
                pd.p r9 = r2.f19128b     // Catch: java.lang.Throwable -> L8f
                r0.f19132d = r10     // Catch: java.lang.Throwable -> L8f
                r0.f19133e = r6     // Catch: java.lang.Throwable -> L8f
                r0.f19130b = r3     // Catch: java.lang.Throwable -> L8f
                r2 = 6
                kotlin.jvm.internal.r.a(r2)     // Catch: java.lang.Throwable -> L8f
                java.lang.Object r9 = r9.invoke(r10, r6, r0)     // Catch: java.lang.Throwable -> L8f
                r0 = 7
                kotlin.jvm.internal.r.a(r0)     // Catch: java.lang.Throwable -> L8f
                if (r9 != r1) goto L88
                goto Lac
            L88:
                r9 = r10
            L89:
                r9.releaseIntercepted()
                cd.h0 r9 = cd.h0.f3852a
                return r9
            L8f:
                r9 = move-exception
                r7 = r10
                r10 = r9
                r9 = r7
            L93:
                r9.releaseIntercepted()
                throw r10
            L97:
                r9 = move-exception
                r2 = r8
            L99:
                qg.w r10 = new qg.w
                r10.<init>(r9)
                pd.p r2 = r2.f19128b
                r0.f19132d = r9
                r0.f19133e = r6
                r0.f19130b = r4
                java.lang.Object r10 = qg.k.a(r10, r2, r9, r0)
                if (r10 != r1) goto Lad
            Lac:
                return r1
            Lad:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: qg.k.b.collect(qg.e, gd.e):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ pd.o f19134a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f19135b;

        public static final class a extends id.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f19136a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f19137b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f19139d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f19140e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Object f19141f;

            public a(gd.e eVar) {
                super(eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) {
                this.f19136a = obj;
                this.f19137b |= Integer.MIN_VALUE;
                return c.this.collect(null, this);
            }
        }

        public c(pd.o oVar, d dVar) {
            this.f19134a = oVar;
            this.f19135b = dVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
        
            if (r7.collect(r2, r0) != r1) goto L28;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // qg.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object collect(qg.e r7, gd.e r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof qg.k.c.a
                if (r0 == 0) goto L13
                r0 = r8
                qg.k$c$a r0 = (qg.k.c.a) r0
                int r1 = r0.f19137b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f19137b = r1
                goto L18
            L13:
                qg.k$c$a r0 = new qg.k$c$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.f19136a
                java.lang.Object r1 = hd.c.f()
                int r2 = r0.f19137b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                cd.s.b(r8)
                goto L83
            L2c:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L34:
                java.lang.Object r7 = r0.f19141f
                rg.o r7 = (rg.o) r7
                java.lang.Object r2 = r0.f19140e
                qg.e r2 = (qg.e) r2
                java.lang.Object r4 = r0.f19139d
                qg.k$c r4 = (qg.k.c) r4
                cd.s.b(r8)     // Catch: java.lang.Throwable -> L44
                goto L6e
            L44:
                r8 = move-exception
                goto L8a
            L46:
                cd.s.b(r8)
                rg.o r8 = new rg.o
                gd.i r2 = r0.getContext()
                r8.<init>(r7, r2)
                pd.o r2 = r6.f19134a     // Catch: java.lang.Throwable -> L86
                r0.f19139d = r6     // Catch: java.lang.Throwable -> L86
                r0.f19140e = r7     // Catch: java.lang.Throwable -> L86
                r0.f19141f = r8     // Catch: java.lang.Throwable -> L86
                r0.f19137b = r4     // Catch: java.lang.Throwable -> L86
                r4 = 6
                kotlin.jvm.internal.r.a(r4)     // Catch: java.lang.Throwable -> L86
                java.lang.Object r2 = r2.invoke(r8, r0)     // Catch: java.lang.Throwable -> L86
                r4 = 7
                kotlin.jvm.internal.r.a(r4)     // Catch: java.lang.Throwable -> L86
                if (r2 != r1) goto L6b
                goto L82
            L6b:
                r4 = r6
                r2 = r7
                r7 = r8
            L6e:
                r7.releaseIntercepted()
                qg.d r7 = r4.f19135b
                r8 = 0
                r0.f19139d = r8
                r0.f19140e = r8
                r0.f19141f = r8
                r0.f19137b = r3
                java.lang.Object r7 = r7.collect(r2, r0)
                if (r7 != r1) goto L83
            L82:
                return r1
            L83:
                cd.h0 r7 = cd.h0.f3852a
                return r7
            L86:
                r7 = move-exception
                r5 = r8
                r8 = r7
                r7 = r5
            L8a:
                r7.releaseIntercepted()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: qg.k.c.collect(qg.e, gd.e):java.lang.Object");
        }
    }

    public static final void b(e eVar) throws Throwable {
        if (eVar instanceof w) {
            throw ((w) eVar).f19206a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(qg.e r4, pd.p r5, java.lang.Throwable r6, gd.e r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof qg.k.a
            if (r0 == 0) goto L13
            r0 = r7
            qg.k$a r0 = (qg.k.a) r0
            int r1 = r0.f19126c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f19126c = r1
            goto L18
        L13:
            qg.k$a r0 = new qg.k$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f19125b
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f19126c
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r4 = r0.f19124a
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            cd.s.b(r7)     // Catch: java.lang.Throwable -> L2e
            goto L46
        L2e:
            r4 = move-exception
            goto L49
        L30:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L38:
            cd.s.b(r7)
            r0.f19124a = r6     // Catch: java.lang.Throwable -> L2e
            r0.f19126c = r3     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L2e
            if (r4 != r1) goto L46
            return r1
        L46:
            cd.h0 r4 = cd.h0.f3852a
            return r4
        L49:
            if (r6 == 0) goto L50
            if (r6 == r4) goto L50
            cd.e.a(r4, r6)
        L50:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: qg.k.c(qg.e, pd.p, java.lang.Throwable, gd.e):java.lang.Object");
    }

    public static final d d(d dVar, pd.p pVar) {
        return new b(dVar, pVar);
    }

    public static final d e(d dVar, pd.o oVar) {
        return new c(oVar, dVar);
    }
}
