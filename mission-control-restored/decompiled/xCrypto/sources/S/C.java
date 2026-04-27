package S;

import a3.AbstractC0787c;
import b3.AbstractC0864b;
import b3.AbstractC0866d;

/* JADX INFO: loaded from: classes.dex */
public final class C implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C3.a f3581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C0516b f3582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w3.d f3583d;

    public static final class a extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3584a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f3585b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f3586c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3588e;

        public a(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f3586c = obj;
            this.f3588e |= Integer.MIN_VALUE;
            return C.this.d(null, this);
        }
    }

    public static final class b extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f3590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f3591c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3593e;

        public b(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f3591c = obj;
            this.f3593e |= Integer.MIN_VALUE;
            return C.this.b(null, this);
        }
    }

    public static final class c extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3594a;

        public c(Z2.e eVar) {
            super(2, eVar);
        }

        @Override // i3.o
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(w3.e eVar, Z2.e eVar2) {
            return ((c) create(eVar, eVar2)).invokeSuspend(W2.E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return new c(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC0787c.e();
            if (this.f3594a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            W2.q.b(obj);
            return W2.E.f5463a;
        }
    }

    public C(String filePath) {
        kotlin.jvm.internal.r.f(filePath, "filePath");
        this.f3580a = filePath;
        this.f3581b = C3.c.b(false, 1, null);
        this.f3582c = new C0516b(0);
        this.f3583d = w3.f.m(new c(null));
    }

    @Override // S.t
    public Object a(Z2.e eVar) {
        return AbstractC0864b.c(this.f3582c.d());
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // S.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(i3.o r7, Z2.e r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof S.C.b
            if (r0 == 0) goto L13
            r0 = r8
            S.C$b r0 = (S.C.b) r0
            int r1 = r0.f3593e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3593e = r1
            goto L18
        L13:
            S.C$b r0 = new S.C$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f3591c
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f3593e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            boolean r7 = r0.f3590b
            java.lang.Object r0 = r0.f3589a
            C3.a r0 = (C3.a) r0
            W2.q.b(r8)     // Catch: java.lang.Throwable -> L30
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
            W2.q.b(r8)
            C3.a r8 = r6.f3581b
            boolean r2 = r8.a(r4)
            java.lang.Boolean r5 = b3.AbstractC0864b.a(r2)     // Catch: java.lang.Throwable -> L5d
            r0.f3589a = r8     // Catch: java.lang.Throwable -> L5d
            r0.f3590b = r2     // Catch: java.lang.Throwable -> L5d
            r0.f3593e = r3     // Catch: java.lang.Throwable -> L5d
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
        throw new UnsupportedOperationException("Method not decompiled: S.C.b(i3.o, Z2.e):java.lang.Object");
    }

    @Override // S.t
    public Object c(Z2.e eVar) {
        return AbstractC0864b.c(this.f3582c.b());
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // S.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(i3.k r8, Z2.e r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof S.C.a
            if (r0 == 0) goto L13
            r0 = r9
            S.C$a r0 = (S.C.a) r0
            int r1 = r0.f3588e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3588e = r1
            goto L18
        L13:
            S.C$a r0 = new S.C$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f3586c
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f3588e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r8 = r0.f3584a
            C3.a r8 = (C3.a) r8
            W2.q.b(r9)     // Catch: java.lang.Throwable -> L31
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
            java.lang.Object r8 = r0.f3585b
            C3.a r8 = (C3.a) r8
            java.lang.Object r2 = r0.f3584a
            i3.k r2 = (i3.k) r2
            W2.q.b(r9)
            r9 = r8
            r8 = r2
            goto L5b
        L49:
            W2.q.b(r9)
            C3.a r9 = r7.f3581b
            r0.f3584a = r8
            r0.f3585b = r9
            r0.f3588e = r4
            java.lang.Object r2 = r9.d(r5, r0)
            if (r2 != r1) goto L5b
            goto L67
        L5b:
            r0.f3584a = r9     // Catch: java.lang.Throwable -> L6f
            r0.f3585b = r5     // Catch: java.lang.Throwable -> L6f
            r0.f3588e = r3     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r8 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L6f
            if (r8 != r1) goto L68
        L67:
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
        throw new UnsupportedOperationException("Method not decompiled: S.C.d(i3.k, Z2.e):java.lang.Object");
    }

    @Override // S.t
    public w3.d e() {
        return this.f3583d;
    }
}
