package e6;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class k {

    public static final class a extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13905a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f13906b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13907c;

        public a(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f13906b = obj;
            this.f13907c |= Integer.MIN_VALUE;
            return k.c(null, null, null, this);
        }
    }

    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f13908a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Q5.p f13909b;

        public static final class a extends J5.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f13910a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f13911b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f13913d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f13914e;

            public a(H5.d dVar) {
                super(dVar);
            }

            @Override // J5.a
            public final Object invokeSuspend(Object obj) {
                this.f13910a = obj;
                this.f13911b |= Integer.MIN_VALUE;
                return b.this.b(null, this);
            }
        }

        public b(d dVar, Q5.p pVar) {
            this.f13908a = dVar;
            this.f13909b = pVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0086 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00ab A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // e6.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object b(e6.e r9, H5.d r10) throws java.lang.Throwable {
            /*
                r8 = this;
                boolean r0 = r10 instanceof e6.k.b.a
                if (r0 == 0) goto L13
                r0 = r10
                e6.k$b$a r0 = (e6.k.b.a) r0
                int r1 = r0.f13911b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13911b = r1
                goto L18
            L13:
                e6.k$b$a r0 = new e6.k$b$a
                r0.<init>(r10)
            L18:
                java.lang.Object r10 = r0.f13910a
                java.lang.Object r1 = I5.c.e()
                int r2 = r0.f13911b
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L54
                if (r2 == r5) goto L46
                if (r2 == r4) goto L3e
                if (r2 != r3) goto L36
                java.lang.Object r9 = r0.f13913d
                f6.n r9 = (f6.n) r9
                E5.q.b(r10)     // Catch: java.lang.Throwable -> L34
                goto L88
            L34:
                r10 = move-exception
                goto L92
            L36:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L3e:
                java.lang.Object r9 = r0.f13913d
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                E5.q.b(r10)
                goto Lac
            L46:
                java.lang.Object r9 = r0.f13914e
                e6.e r9 = (e6.e) r9
                java.lang.Object r2 = r0.f13913d
                e6.k$b r2 = (e6.k.b) r2
                E5.q.b(r10)     // Catch: java.lang.Throwable -> L52
                goto L67
            L52:
                r9 = move-exception
                goto L98
            L54:
                E5.q.b(r10)
                e6.d r10 = r8.f13908a     // Catch: java.lang.Throwable -> L96
                r0.f13913d = r8     // Catch: java.lang.Throwable -> L96
                r0.f13914e = r9     // Catch: java.lang.Throwable -> L96
                r0.f13911b = r5     // Catch: java.lang.Throwable -> L96
                java.lang.Object r10 = r10.b(r9, r0)     // Catch: java.lang.Throwable -> L96
                if (r10 != r1) goto L66
                return r1
            L66:
                r2 = r8
            L67:
                f6.n r10 = new f6.n
                H5.g r4 = r0.getContext()
                r10.<init>(r9, r4)
                Q5.p r9 = r2.f13909b     // Catch: java.lang.Throwable -> L8e
                r0.f13913d = r10     // Catch: java.lang.Throwable -> L8e
                r0.f13914e = r6     // Catch: java.lang.Throwable -> L8e
                r0.f13911b = r3     // Catch: java.lang.Throwable -> L8e
                r2 = 6
                kotlin.jvm.internal.p.a(r2)     // Catch: java.lang.Throwable -> L8e
                java.lang.Object r9 = r9.invoke(r10, r6, r0)     // Catch: java.lang.Throwable -> L8e
                r0 = 7
                kotlin.jvm.internal.p.a(r0)     // Catch: java.lang.Throwable -> L8e
                if (r9 != r1) goto L87
                return r1
            L87:
                r9 = r10
            L88:
                r9.releaseIntercepted()
                E5.E r9 = E5.E.f1657a
                return r9
            L8e:
                r9 = move-exception
                r7 = r10
                r10 = r9
                r9 = r7
            L92:
                r9.releaseIntercepted()
                throw r10
            L96:
                r9 = move-exception
                r2 = r8
            L98:
                e6.w r10 = new e6.w
                r10.<init>(r9)
                Q5.p r2 = r2.f13909b
                r0.f13913d = r9
                r0.f13914e = r6
                r0.f13911b = r4
                java.lang.Object r10 = e6.k.a(r10, r2, r9, r0)
                if (r10 != r1) goto Lac
                return r1
            Lac:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: e6.k.b.b(e6.e, H5.d):java.lang.Object");
        }
    }

    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Q5.o f13915a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f13916b;

        public static final class a extends J5.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f13917a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f13918b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f13920d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f13921e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Object f13922f;

            public a(H5.d dVar) {
                super(dVar);
            }

            @Override // J5.a
            public final Object invokeSuspend(Object obj) {
                this.f13917a = obj;
                this.f13918b |= Integer.MIN_VALUE;
                return c.this.b(null, this);
            }
        }

        public c(Q5.o oVar, d dVar) {
            this.f13915a = oVar;
            this.f13916b = dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0082 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // e6.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object b(e6.e r7, H5.d r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof e6.k.c.a
                if (r0 == 0) goto L13
                r0 = r8
                e6.k$c$a r0 = (e6.k.c.a) r0
                int r1 = r0.f13918b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13918b = r1
                goto L18
            L13:
                e6.k$c$a r0 = new e6.k$c$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.f13917a
                java.lang.Object r1 = I5.c.e()
                int r2 = r0.f13918b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                E5.q.b(r8)
                goto L83
            L2c:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L34:
                java.lang.Object r7 = r0.f13922f
                f6.n r7 = (f6.n) r7
                java.lang.Object r2 = r0.f13921e
                e6.e r2 = (e6.e) r2
                java.lang.Object r4 = r0.f13920d
                e6.k$c r4 = (e6.k.c) r4
                E5.q.b(r8)     // Catch: java.lang.Throwable -> L44
                goto L6e
            L44:
                r8 = move-exception
                goto L8a
            L46:
                E5.q.b(r8)
                f6.n r8 = new f6.n
                H5.g r2 = r0.getContext()
                r8.<init>(r7, r2)
                Q5.o r2 = r6.f13915a     // Catch: java.lang.Throwable -> L86
                r0.f13920d = r6     // Catch: java.lang.Throwable -> L86
                r0.f13921e = r7     // Catch: java.lang.Throwable -> L86
                r0.f13922f = r8     // Catch: java.lang.Throwable -> L86
                r0.f13918b = r4     // Catch: java.lang.Throwable -> L86
                r4 = 6
                kotlin.jvm.internal.p.a(r4)     // Catch: java.lang.Throwable -> L86
                java.lang.Object r2 = r2.invoke(r8, r0)     // Catch: java.lang.Throwable -> L86
                r4 = 7
                kotlin.jvm.internal.p.a(r4)     // Catch: java.lang.Throwable -> L86
                if (r2 != r1) goto L6b
                return r1
            L6b:
                r4 = r6
                r2 = r7
                r7 = r8
            L6e:
                r7.releaseIntercepted()
                e6.d r7 = r4.f13916b
                r8 = 0
                r0.f13920d = r8
                r0.f13921e = r8
                r0.f13922f = r8
                r0.f13918b = r3
                java.lang.Object r7 = r7.b(r2, r0)
                if (r7 != r1) goto L83
                return r1
            L83:
                E5.E r7 = E5.E.f1657a
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
            throw new UnsupportedOperationException("Method not decompiled: e6.k.c.b(e6.e, H5.d):java.lang.Object");
        }
    }

    public static final void b(e eVar) throws Throwable {
        if (eVar instanceof w) {
            throw ((w) eVar).f13987a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(e6.e r4, Q5.p r5, java.lang.Throwable r6, H5.d r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof e6.k.a
            if (r0 == 0) goto L13
            r0 = r7
            e6.k$a r0 = (e6.k.a) r0
            int r1 = r0.f13907c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13907c = r1
            goto L18
        L13:
            e6.k$a r0 = new e6.k$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f13906b
            java.lang.Object r1 = I5.c.e()
            int r2 = r0.f13907c
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r4 = r0.f13905a
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            E5.q.b(r7)     // Catch: java.lang.Throwable -> L2e
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
            E5.q.b(r7)
            r0.f13905a = r6     // Catch: java.lang.Throwable -> L2e
            r0.f13907c = r3     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L2e
            if (r4 != r1) goto L46
            return r1
        L46:
            E5.E r4 = E5.E.f1657a
            return r4
        L49:
            if (r6 == 0) goto L50
            if (r6 == r4) goto L50
            E5.AbstractC0460e.a(r4, r6)
        L50:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.k.c(e6.e, Q5.p, java.lang.Throwable, H5.d):java.lang.Object");
    }

    public static final d d(d dVar, Q5.p pVar) {
        return new b(dVar, pVar);
    }

    public static final d e(d dVar, Q5.o oVar) {
        return new c(oVar, dVar);
    }
}
