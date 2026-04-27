package c0;

import E5.E;

/* JADX INFO: loaded from: classes.dex */
public final class u implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9310a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k6.a f9311b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1112a f9312c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e6.d f9313d;

    public static final class a extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f9314a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f9315b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f9316c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9318e;

        public a(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f9316c = obj;
            this.f9318e |= Integer.MIN_VALUE;
            return u.this.e(null, this);
        }
    }

    public static final class b extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f9319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f9320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f9321c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f9323e;

        public b(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f9321c = obj;
            this.f9323e |= Integer.MIN_VALUE;
            return u.this.d(null, this);
        }
    }

    public static final class c extends J5.l implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9324a;

        public c(H5.d dVar) {
            super(2, dVar);
        }

        @Override // J5.a
        public final H5.d create(Object obj, H5.d dVar) {
            return new c(dVar);
        }

        @Override // Q5.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(e6.e eVar, H5.d dVar) {
            return ((c) create(eVar, dVar)).invokeSuspend(E.f1657a);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            I5.c.e();
            if (this.f9324a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            E5.q.b(obj);
            return E.f1657a;
        }
    }

    public u(String filePath) {
        kotlin.jvm.internal.r.f(filePath, "filePath");
        this.f9310a = filePath;
        this.f9311b = k6.c.b(false, 1, null);
        this.f9312c = new C1112a(0);
        this.f9313d = e6.f.m(new c(null));
    }

    @Override // c0.n
    public Object a(H5.d dVar) {
        return J5.b.c(this.f9312c.b());
    }

    @Override // c0.n
    public Object b(H5.d dVar) {
        return J5.b.c(this.f9312c.d());
    }

    @Override // c0.n
    public e6.d c() {
        return this.f9313d;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // c0.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(Q5.o r7, H5.d r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof c0.u.b
            if (r0 == 0) goto L13
            r0 = r8
            c0.u$b r0 = (c0.u.b) r0
            int r1 = r0.f9323e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9323e = r1
            goto L18
        L13:
            c0.u$b r0 = new c0.u$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f9321c
            java.lang.Object r1 = I5.c.e()
            int r2 = r0.f9323e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            boolean r7 = r0.f9320b
            java.lang.Object r0 = r0.f9319a
            k6.a r0 = (k6.a) r0
            E5.q.b(r8)     // Catch: java.lang.Throwable -> L30
            goto L57
        L30:
            r8 = move-exception
            goto L61
        L32:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3a:
            E5.q.b(r8)
            k6.a r8 = r6.f9311b
            boolean r2 = r8.a(r4)
            java.lang.Boolean r5 = J5.b.a(r2)     // Catch: java.lang.Throwable -> L5d
            r0.f9319a = r8     // Catch: java.lang.Throwable -> L5d
            r0.f9320b = r2     // Catch: java.lang.Throwable -> L5d
            r0.f9323e = r3     // Catch: java.lang.Throwable -> L5d
            java.lang.Object r7 = r7.invoke(r5, r0)     // Catch: java.lang.Throwable -> L5d
            if (r7 != r1) goto L54
            return r1
        L54:
            r0 = r8
            r8 = r7
            r7 = r2
        L57:
            if (r7 == 0) goto L5c
            r0.c(r4)
        L5c:
            return r8
        L5d:
            r7 = move-exception
            r0 = r8
            r8 = r7
            r7 = r2
        L61:
            if (r7 == 0) goto L66
            r0.c(r4)
        L66:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.u.d(Q5.o, H5.d):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // c0.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object e(Q5.k r8, H5.d r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof c0.u.a
            if (r0 == 0) goto L13
            r0 = r9
            c0.u$a r0 = (c0.u.a) r0
            int r1 = r0.f9318e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9318e = r1
            goto L18
        L13:
            c0.u$a r0 = new c0.u$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f9316c
            java.lang.Object r1 = I5.c.e()
            int r2 = r0.f9318e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r8 = r0.f9314a
            k6.a r8 = (k6.a) r8
            E5.q.b(r9)     // Catch: java.lang.Throwable -> L31
            goto L6b
        L31:
            r9 = move-exception
            goto L73
        L33:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3b:
            java.lang.Object r8 = r0.f9315b
            k6.a r8 = (k6.a) r8
            java.lang.Object r2 = r0.f9314a
            Q5.k r2 = (Q5.k) r2
            E5.q.b(r9)
            r9 = r8
            r8 = r2
            goto L5b
        L49:
            E5.q.b(r9)
            k6.a r9 = r7.f9311b
            r0.f9314a = r8
            r0.f9315b = r9
            r0.f9318e = r4
            java.lang.Object r2 = r9.d(r5, r0)
            if (r2 != r1) goto L5b
            return r1
        L5b:
            r0.f9314a = r9     // Catch: java.lang.Throwable -> L6f
            r0.f9315b = r5     // Catch: java.lang.Throwable -> L6f
            r0.f9318e = r3     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r8 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L6f
            if (r8 != r1) goto L68
            return r1
        L68:
            r6 = r9
            r9 = r8
            r8 = r6
        L6b:
            r8.c(r5)
            return r9
        L6f:
            r8 = move-exception
            r6 = r9
            r9 = r8
            r8 = r6
        L73:
            r8.c(r5)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: c0.u.e(Q5.k, H5.d):java.lang.Object");
    }
}
