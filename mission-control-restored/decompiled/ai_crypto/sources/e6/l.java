package e6;

import b6.InterfaceC1101w0;
import kotlin.jvm.internal.G;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class l {

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f13923a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Q5.p f13924b;

        /* JADX INFO: renamed from: e6.l$a$a, reason: collision with other inner class name */
        public static final class C0239a extends J5.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f13925a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f13926b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f13928d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f13929e;

            public C0239a(H5.d dVar) {
                super(dVar);
            }

            @Override // J5.a
            public final Object invokeSuspend(Object obj) {
                this.f13925a = obj;
                this.f13926b |= Integer.MIN_VALUE;
                return a.this.b(null, this);
            }
        }

        public a(d dVar, Q5.p pVar) {
            this.f13923a = dVar;
            this.f13924b = pVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // e6.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object b(e6.e r6, H5.d r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof e6.l.a.C0239a
                if (r0 == 0) goto L13
                r0 = r7
                e6.l$a$a r0 = (e6.l.a.C0239a) r0
                int r1 = r0.f13926b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13926b = r1
                goto L18
            L13:
                e6.l$a$a r0 = new e6.l$a$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.f13925a
                java.lang.Object r1 = I5.c.e()
                int r2 = r0.f13926b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L40
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                E5.q.b(r7)
                goto L6f
            L2c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L34:
                java.lang.Object r6 = r0.f13929e
                e6.e r6 = (e6.e) r6
                java.lang.Object r2 = r0.f13928d
                e6.l$a r2 = (e6.l.a) r2
                E5.q.b(r7)
                goto L53
            L40:
                E5.q.b(r7)
                e6.d r7 = r5.f13923a
                r0.f13928d = r5
                r0.f13929e = r6
                r0.f13926b = r4
                java.lang.Object r7 = e6.f.e(r7, r6, r0)
                if (r7 != r1) goto L52
                return r1
            L52:
                r2 = r5
            L53:
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L6f
                Q5.p r2 = r2.f13924b
                r4 = 0
                r0.f13928d = r4
                r0.f13929e = r4
                r0.f13926b = r3
                r3 = 6
                kotlin.jvm.internal.p.a(r3)
                java.lang.Object r6 = r2.invoke(r6, r7, r0)
                r7 = 7
                kotlin.jvm.internal.p.a(r7)
                if (r6 != r1) goto L6f
                return r1
            L6f:
                E5.E r6 = E5.E.f1657a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: e6.l.a.b(e6.e, H5.d):java.lang.Object");
        }
    }

    public static final class b extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f13931b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13932c;

        public b(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f13931b = obj;
            this.f13932c |= Integer.MIN_VALUE;
            return f.e(null, null, this);
        }
    }

    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f13933a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ G f13934b;

        public static final class a extends J5.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f13935a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f13936b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f13938d;

            public a(H5.d dVar) {
                super(dVar);
            }

            @Override // J5.a
            public final Object invokeSuspend(Object obj) {
                this.f13936b = obj;
                this.f13938d |= Integer.MIN_VALUE;
                return c.this.d(null, this);
            }
        }

        public c(e eVar, G g7) {
            this.f13933a = eVar;
            this.f13934b = g7;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // e6.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object d(java.lang.Object r5, H5.d r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof e6.l.c.a
                if (r0 == 0) goto L13
                r0 = r6
                e6.l$c$a r0 = (e6.l.c.a) r0
                int r1 = r0.f13938d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13938d = r1
                goto L18
            L13:
                e6.l$c$a r0 = new e6.l$c$a
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.f13936b
                java.lang.Object r1 = I5.c.e()
                int r2 = r0.f13938d
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r5 = r0.f13935a
                e6.l$c r5 = (e6.l.c) r5
                E5.q.b(r6)     // Catch: java.lang.Throwable -> L2d
                goto L47
            L2d:
                r6 = move-exception
                goto L4c
            L2f:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r6)
                throw r5
            L37:
                E5.q.b(r6)
                e6.e r6 = r4.f13933a     // Catch: java.lang.Throwable -> L4a
                r0.f13935a = r4     // Catch: java.lang.Throwable -> L4a
                r0.f13938d = r3     // Catch: java.lang.Throwable -> L4a
                java.lang.Object r5 = r6.d(r5, r0)     // Catch: java.lang.Throwable -> L4a
                if (r5 != r1) goto L47
                return r1
            L47:
                E5.E r5 = E5.E.f1657a
                return r5
            L4a:
                r6 = move-exception
                r5 = r4
            L4c:
                kotlin.jvm.internal.G r5 = r5.f13934b
                r5.f18249a = r6
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: e6.l.c.d(java.lang.Object, H5.d):java.lang.Object");
        }
    }

    public static final d a(d dVar, Q5.p pVar) {
        return new a(dVar, pVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(e6.d r4, e6.e r5, H5.d r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof e6.l.b
            if (r0 == 0) goto L13
            r0 = r6
            e6.l$b r0 = (e6.l.b) r0
            int r1 = r0.f13932c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13932c = r1
            goto L18
        L13:
            e6.l$b r0 = new e6.l$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f13931b
            java.lang.Object r1 = I5.c.e()
            int r2 = r0.f13932c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.f13930a
            kotlin.jvm.internal.G r4 = (kotlin.jvm.internal.G) r4
            E5.q.b(r6)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r5 = move-exception
            goto L53
        L2f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L37:
            E5.q.b(r6)
            kotlin.jvm.internal.G r6 = new kotlin.jvm.internal.G
            r6.<init>()
            e6.l$c r2 = new e6.l$c     // Catch: java.lang.Throwable -> L51
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L51
            r0.f13930a = r6     // Catch: java.lang.Throwable -> L51
            r0.f13932c = r3     // Catch: java.lang.Throwable -> L51
            java.lang.Object r4 = r4.b(r2, r0)     // Catch: java.lang.Throwable -> L51
            if (r4 != r1) goto L4f
            return r1
        L4f:
            r4 = 0
            return r4
        L51:
            r5 = move-exception
            r4 = r6
        L53:
            java.lang.Object r4 = r4.f18249a
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r6 = d(r5, r4)
            if (r6 != 0) goto L76
            H5.g r6 = r0.getContext()
            boolean r6 = c(r5, r6)
            if (r6 != 0) goto L76
            if (r4 != 0) goto L6a
            return r5
        L6a:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L72
            E5.AbstractC0460e.a(r4, r5)
            throw r4
        L72:
            E5.AbstractC0460e.a(r5, r4)
            throw r5
        L76:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.l.b(e6.d, e6.e, H5.d):java.lang.Object");
    }

    public static final boolean c(Throwable th, H5.g gVar) {
        InterfaceC1101w0 interfaceC1101w0 = (InterfaceC1101w0) gVar.get(InterfaceC1101w0.f9097L);
        if (interfaceC1101w0 == null || !interfaceC1101w0.isCancelled()) {
            return false;
        }
        return d(th, interfaceC1101w0.getCancellationException());
    }

    public static final boolean d(Throwable th, Throwable th2) {
        return th2 != null && kotlin.jvm.internal.r.b(th2, th);
    }
}
