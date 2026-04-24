package w3;

import b3.AbstractC0866d;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class k {

    public static final class a extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15599a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f15600b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15601c;

        public a(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f15600b = obj;
            this.f15601c |= Integer.MIN_VALUE;
            return k.c(null, null, null, this);
        }
    }

    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f15602a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i3.p f15603b;

        public static final class a extends AbstractC0866d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f15604a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f15605b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f15607d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f15608e;

            public a(Z2.e eVar) {
                super(eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) {
                this.f15604a = obj;
                this.f15605b |= Integer.MIN_VALUE;
                return b.this.collect(null, this);
            }
        }

        public b(d dVar, i3.p pVar) {
            this.f15602a = dVar;
            this.f15603b = pVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
        /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // w3.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object collect(w3.e r9, Z2.e r10) throws java.lang.Throwable {
            /*
                r8 = this;
                boolean r0 = r10 instanceof w3.k.b.a
                if (r0 == 0) goto L13
                r0 = r10
                w3.k$b$a r0 = (w3.k.b.a) r0
                int r1 = r0.f15605b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f15605b = r1
                goto L18
            L13:
                w3.k$b$a r0 = new w3.k$b$a
                r0.<init>(r10)
            L18:
                java.lang.Object r10 = r0.f15604a
                java.lang.Object r1 = a3.AbstractC0787c.e()
                int r2 = r0.f15605b
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L55
                if (r2 == r5) goto L47
                if (r2 == r4) goto L3e
                if (r2 != r3) goto L36
                java.lang.Object r9 = r0.f15607d
                x3.n r9 = (x3.n) r9
                W2.q.b(r10)     // Catch: java.lang.Throwable -> L34
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
                java.lang.Object r9 = r0.f15607d
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                W2.q.b(r10)
                goto Lad
            L47:
                java.lang.Object r9 = r0.f15608e
                w3.e r9 = (w3.e) r9
                java.lang.Object r2 = r0.f15607d
                w3.k$b r2 = (w3.k.b) r2
                W2.q.b(r10)     // Catch: java.lang.Throwable -> L53
                goto L68
            L53:
                r9 = move-exception
                goto L99
            L55:
                W2.q.b(r10)
                w3.d r10 = r8.f15602a     // Catch: java.lang.Throwable -> L97
                r0.f15607d = r8     // Catch: java.lang.Throwable -> L97
                r0.f15608e = r9     // Catch: java.lang.Throwable -> L97
                r0.f15605b = r5     // Catch: java.lang.Throwable -> L97
                java.lang.Object r10 = r10.collect(r9, r0)     // Catch: java.lang.Throwable -> L97
                if (r10 != r1) goto L67
                goto Lac
            L67:
                r2 = r8
            L68:
                x3.n r10 = new x3.n
                Z2.i r4 = r0.getContext()
                r10.<init>(r9, r4)
                i3.p r9 = r2.f15603b     // Catch: java.lang.Throwable -> L8f
                r0.f15607d = r10     // Catch: java.lang.Throwable -> L8f
                r0.f15608e = r6     // Catch: java.lang.Throwable -> L8f
                r0.f15605b = r3     // Catch: java.lang.Throwable -> L8f
                r2 = 6
                kotlin.jvm.internal.p.a(r2)     // Catch: java.lang.Throwable -> L8f
                java.lang.Object r9 = r9.invoke(r10, r6, r0)     // Catch: java.lang.Throwable -> L8f
                r0 = 7
                kotlin.jvm.internal.p.a(r0)     // Catch: java.lang.Throwable -> L8f
                if (r9 != r1) goto L88
                goto Lac
            L88:
                r9 = r10
            L89:
                r9.releaseIntercepted()
                W2.E r9 = W2.E.f5463a
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
                w3.w r10 = new w3.w
                r10.<init>(r9)
                i3.p r2 = r2.f15603b
                r0.f15607d = r9
                r0.f15608e = r6
                r0.f15605b = r4
                java.lang.Object r10 = w3.k.a(r10, r2, r9, r0)
                if (r10 != r1) goto Lad
            Lac:
                return r1
            Lad:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: w3.k.b.collect(w3.e, Z2.e):java.lang.Object");
        }
    }

    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i3.o f15609a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f15610b;

        public static final class a extends AbstractC0866d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f15611a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f15612b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f15614d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f15615e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Object f15616f;

            public a(Z2.e eVar) {
                super(eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) {
                this.f15611a = obj;
                this.f15612b |= Integer.MIN_VALUE;
                return c.this.collect(null, this);
            }
        }

        public c(i3.o oVar, d dVar) {
            this.f15609a = oVar;
            this.f15610b = dVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:26:0x0080, code lost:
        
            if (r7.collect(r2, r0) != r1) goto L28;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // w3.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object collect(w3.e r7, Z2.e r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof w3.k.c.a
                if (r0 == 0) goto L13
                r0 = r8
                w3.k$c$a r0 = (w3.k.c.a) r0
                int r1 = r0.f15612b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f15612b = r1
                goto L18
            L13:
                w3.k$c$a r0 = new w3.k$c$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.f15611a
                java.lang.Object r1 = a3.AbstractC0787c.e()
                int r2 = r0.f15612b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                W2.q.b(r8)
                goto L83
            L2c:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L34:
                java.lang.Object r7 = r0.f15616f
                x3.n r7 = (x3.n) r7
                java.lang.Object r2 = r0.f15615e
                w3.e r2 = (w3.e) r2
                java.lang.Object r4 = r0.f15614d
                w3.k$c r4 = (w3.k.c) r4
                W2.q.b(r8)     // Catch: java.lang.Throwable -> L44
                goto L6e
            L44:
                r8 = move-exception
                goto L8a
            L46:
                W2.q.b(r8)
                x3.n r8 = new x3.n
                Z2.i r2 = r0.getContext()
                r8.<init>(r7, r2)
                i3.o r2 = r6.f15609a     // Catch: java.lang.Throwable -> L86
                r0.f15614d = r6     // Catch: java.lang.Throwable -> L86
                r0.f15615e = r7     // Catch: java.lang.Throwable -> L86
                r0.f15616f = r8     // Catch: java.lang.Throwable -> L86
                r0.f15612b = r4     // Catch: java.lang.Throwable -> L86
                r4 = 6
                kotlin.jvm.internal.p.a(r4)     // Catch: java.lang.Throwable -> L86
                java.lang.Object r2 = r2.invoke(r8, r0)     // Catch: java.lang.Throwable -> L86
                r4 = 7
                kotlin.jvm.internal.p.a(r4)     // Catch: java.lang.Throwable -> L86
                if (r2 != r1) goto L6b
                goto L82
            L6b:
                r4 = r6
                r2 = r7
                r7 = r8
            L6e:
                r7.releaseIntercepted()
                w3.d r7 = r4.f15610b
                r8 = 0
                r0.f15614d = r8
                r0.f15615e = r8
                r0.f15616f = r8
                r0.f15612b = r3
                java.lang.Object r7 = r7.collect(r2, r0)
                if (r7 != r1) goto L83
            L82:
                return r1
            L83:
                W2.E r7 = W2.E.f5463a
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
            throw new UnsupportedOperationException("Method not decompiled: w3.k.c.collect(w3.e, Z2.e):java.lang.Object");
        }
    }

    public static final void b(e eVar) throws Throwable {
        if (eVar instanceof w) {
            throw ((w) eVar).f15681a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(w3.e r4, i3.p r5, java.lang.Throwable r6, Z2.e r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof w3.k.a
            if (r0 == 0) goto L13
            r0 = r7
            w3.k$a r0 = (w3.k.a) r0
            int r1 = r0.f15601c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15601c = r1
            goto L18
        L13:
            w3.k$a r0 = new w3.k$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f15600b
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f15601c
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r4 = r0.f15599a
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            W2.q.b(r7)     // Catch: java.lang.Throwable -> L2e
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
            W2.q.b(r7)
            r0.f15599a = r6     // Catch: java.lang.Throwable -> L2e
            r0.f15601c = r3     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L2e
            if (r4 != r1) goto L46
            return r1
        L46:
            W2.E r4 = W2.E.f5463a
            return r4
        L49:
            if (r6 == 0) goto L50
            if (r6 == r4) goto L50
            W2.AbstractC0737e.a(r4, r6)
        L50:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.k.c(w3.e, i3.p, java.lang.Throwable, Z2.e):java.lang.Object");
    }

    public static final d d(d dVar, i3.p pVar) {
        return new b(dVar, pVar);
    }

    public static final d e(d dVar, i3.o oVar) {
        return new c(oVar, dVar);
    }
}
