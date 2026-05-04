package l1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h0 implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15041a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final wg.a f15042b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l1.b f15043c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final qg.d f15044d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15045a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f15046b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f15047c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15049e;

        public a(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f15047c = obj;
            this.f15049e |= Integer.MIN_VALUE;
            return h0.this.c(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15050a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f15051b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f15052c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f15054e;

        public b(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f15052c = obj;
            this.f15054e |= Integer.MIN_VALUE;
            return h0.this.b(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15055a;

        public c(gd.e eVar) {
            super(2, eVar);
        }

        @Override // pd.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(qg.e eVar, gd.e eVar2) {
            return ((c) create(eVar, eVar2)).invokeSuspend(cd.h0.f3852a);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return new c(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            hd.c.f();
            if (this.f15055a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            cd.s.b(obj);
            return cd.h0.f3852a;
        }
    }

    public h0(String filePath) {
        kotlin.jvm.internal.t.f(filePath, "filePath");
        this.f15041a = filePath;
        this.f15042b = wg.g.b(false, 1, null);
        this.f15043c = new l1.b(0);
        this.f15044d = qg.f.n(new c(null));
    }

    @Override // l1.t
    public Object a(gd.e eVar) {
        return id.b.c(this.f15043c.d());
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // l1.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(pd.o r7, gd.e r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof l1.h0.b
            if (r0 == 0) goto L13
            r0 = r8
            l1.h0$b r0 = (l1.h0.b) r0
            int r1 = r0.f15054e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15054e = r1
            goto L18
        L13:
            l1.h0$b r0 = new l1.h0$b
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f15052c
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f15054e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            boolean r7 = r0.f15051b
            java.lang.Object r0 = r0.f15050a
            wg.a r0 = (wg.a) r0
            cd.s.b(r8)     // Catch: java.lang.Throwable -> L30
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
            cd.s.b(r8)
            wg.a r8 = r6.f15042b
            boolean r2 = r8.a(r4)
            java.lang.Boolean r5 = id.b.a(r2)     // Catch: java.lang.Throwable -> L5d
            r0.f15050a = r8     // Catch: java.lang.Throwable -> L5d
            r0.f15051b = r2     // Catch: java.lang.Throwable -> L5d
            r0.f15054e = r3     // Catch: java.lang.Throwable -> L5d
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
        throw new UnsupportedOperationException("Method not decompiled: l1.h0.b(pd.o, gd.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // l1.t
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(pd.k r8, gd.e r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof l1.h0.a
            if (r0 == 0) goto L13
            r0 = r9
            l1.h0$a r0 = (l1.h0.a) r0
            int r1 = r0.f15049e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15049e = r1
            goto L18
        L13:
            l1.h0$a r0 = new l1.h0$a
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.f15047c
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f15049e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L49
            if (r2 == r4) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r8 = r0.f15045a
            wg.a r8 = (wg.a) r8
            cd.s.b(r9)     // Catch: java.lang.Throwable -> L31
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
            java.lang.Object r8 = r0.f15046b
            wg.a r8 = (wg.a) r8
            java.lang.Object r2 = r0.f15045a
            pd.k r2 = (pd.k) r2
            cd.s.b(r9)
            r9 = r8
            r8 = r2
            goto L5b
        L49:
            cd.s.b(r9)
            wg.a r9 = r7.f15042b
            r0.f15045a = r8
            r0.f15046b = r9
            r0.f15049e = r4
            java.lang.Object r2 = r9.d(r5, r0)
            if (r2 != r1) goto L5b
            goto L67
        L5b:
            r0.f15045a = r9     // Catch: java.lang.Throwable -> L6f
            r0.f15046b = r5     // Catch: java.lang.Throwable -> L6f
            r0.f15049e = r3     // Catch: java.lang.Throwable -> L6f
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
        throw new UnsupportedOperationException("Method not decompiled: l1.h0.c(pd.k, gd.e):java.lang.Object");
    }

    @Override // l1.t
    public Object d(gd.e eVar) {
        return id.b.c(this.f15043c.b());
    }

    @Override // l1.t
    public qg.d e() {
        return this.f15044d;
    }
}
