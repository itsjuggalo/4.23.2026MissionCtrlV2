package qg;

import kotlin.jvm.internal.m0;
import ng.y1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class l {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f19142a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ pd.p f19143b;

        /* JADX INFO: renamed from: qg.l$a$a, reason: collision with other inner class name */
        public static final class C0332a extends id.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f19144a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f19145b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f19147d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f19148e;

            public C0332a(gd.e eVar) {
                super(eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) {
                this.f19144a = obj;
                this.f19145b |= Integer.MIN_VALUE;
                return a.this.collect(null, this);
            }
        }

        public a(d dVar, pd.p pVar) {
            this.f19142a = dVar;
            this.f19143b = pVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
        
            if (r6 == r1) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // qg.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object collect(qg.e r6, gd.e r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof qg.l.a.C0332a
                if (r0 == 0) goto L13
                r0 = r7
                qg.l$a$a r0 = (qg.l.a.C0332a) r0
                int r1 = r0.f19145b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f19145b = r1
                goto L18
            L13:
                qg.l$a$a r0 = new qg.l$a$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.f19144a
                java.lang.Object r1 = hd.c.f()
                int r2 = r0.f19145b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L40
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                cd.s.b(r7)
                goto L6f
            L2c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L34:
                java.lang.Object r6 = r0.f19148e
                qg.e r6 = (qg.e) r6
                java.lang.Object r2 = r0.f19147d
                qg.l$a r2 = (qg.l.a) r2
                cd.s.b(r7)
                goto L53
            L40:
                cd.s.b(r7)
                qg.d r7 = r5.f19142a
                r0.f19147d = r5
                r0.f19148e = r6
                r0.f19145b = r4
                java.lang.Object r7 = qg.f.e(r7, r6, r0)
                if (r7 != r1) goto L52
                goto L6e
            L52:
                r2 = r5
            L53:
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L6f
                pd.p r2 = r2.f19143b
                r4 = 0
                r0.f19147d = r4
                r0.f19148e = r4
                r0.f19145b = r3
                r3 = 6
                kotlin.jvm.internal.r.a(r3)
                java.lang.Object r6 = r2.invoke(r6, r7, r0)
                r7 = 7
                kotlin.jvm.internal.r.a(r7)
                if (r6 != r1) goto L6f
            L6e:
                return r1
            L6f:
                cd.h0 r6 = cd.h0.f3852a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: qg.l.a.collect(qg.e, gd.e):java.lang.Object");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f19149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f19150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f19151c;

        public b(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f19150b = obj;
            this.f19151c |= Integer.MIN_VALUE;
            return f.e(null, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f19152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ m0 f19153b;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a extends id.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f19154a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f19155b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f19157d;

            public a(gd.e eVar) {
                super(eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) {
                this.f19155b = obj;
                this.f19157d |= Integer.MIN_VALUE;
                return c.this.emit(null, this);
            }
        }

        public c(e eVar, m0 m0Var) {
            this.f19152a = eVar;
            this.f19153b = m0Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // qg.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(java.lang.Object r5, gd.e r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof qg.l.c.a
                if (r0 == 0) goto L13
                r0 = r6
                qg.l$c$a r0 = (qg.l.c.a) r0
                int r1 = r0.f19157d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f19157d = r1
                goto L18
            L13:
                qg.l$c$a r0 = new qg.l$c$a
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.f19155b
                java.lang.Object r1 = hd.c.f()
                int r2 = r0.f19157d
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r5 = r0.f19154a
                qg.l$c r5 = (qg.l.c) r5
                cd.s.b(r6)     // Catch: java.lang.Throwable -> L2d
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
                cd.s.b(r6)
                qg.e r6 = r4.f19152a     // Catch: java.lang.Throwable -> L4a
                r0.f19154a = r4     // Catch: java.lang.Throwable -> L4a
                r0.f19157d = r3     // Catch: java.lang.Throwable -> L4a
                java.lang.Object r5 = r6.emit(r5, r0)     // Catch: java.lang.Throwable -> L4a
                if (r5 != r1) goto L47
                return r1
            L47:
                cd.h0 r5 = cd.h0.f3852a
                return r5
            L4a:
                r6 = move-exception
                r5 = r4
            L4c:
                kotlin.jvm.internal.m0 r5 = r5.f19153b
                r5.f14947a = r6
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: qg.l.c.emit(java.lang.Object, gd.e):java.lang.Object");
        }
    }

    public static final d a(d dVar, pd.p pVar) {
        return new a(dVar, pVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(qg.d r4, qg.e r5, gd.e r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof qg.l.b
            if (r0 == 0) goto L13
            r0 = r6
            qg.l$b r0 = (qg.l.b) r0
            int r1 = r0.f19151c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f19151c = r1
            goto L18
        L13:
            qg.l$b r0 = new qg.l$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f19150b
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f19151c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.f19149a
            kotlin.jvm.internal.m0 r4 = (kotlin.jvm.internal.m0) r4
            cd.s.b(r6)     // Catch: java.lang.Throwable -> L2d
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
            cd.s.b(r6)
            kotlin.jvm.internal.m0 r6 = new kotlin.jvm.internal.m0
            r6.<init>()
            qg.l$c r2 = new qg.l$c     // Catch: java.lang.Throwable -> L51
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L51
            r0.f19149a = r6     // Catch: java.lang.Throwable -> L51
            r0.f19151c = r3     // Catch: java.lang.Throwable -> L51
            java.lang.Object r4 = r4.collect(r2, r0)     // Catch: java.lang.Throwable -> L51
            if (r4 != r1) goto L4f
            return r1
        L4f:
            r4 = 0
            return r4
        L51:
            r5 = move-exception
            r4 = r6
        L53:
            java.lang.Object r4 = r4.f14947a
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r6 = d(r5, r4)
            if (r6 != 0) goto L76
            gd.i r6 = r0.getContext()
            boolean r6 = c(r5, r6)
            if (r6 != 0) goto L76
            if (r4 != 0) goto L6a
            return r5
        L6a:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L72
            cd.e.a(r4, r5)
            throw r4
        L72:
            cd.e.a(r5, r4)
            throw r5
        L76:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: qg.l.b(qg.d, qg.e, gd.e):java.lang.Object");
    }

    public static final boolean c(Throwable th, gd.i iVar) {
        y1 y1Var = (y1) iVar.get(y1.N);
        if (y1Var == null || !y1Var.isCancelled()) {
            return false;
        }
        return d(th, y1Var.getCancellationException());
    }

    public static final boolean d(Throwable th, Throwable th2) {
        return th2 != null && kotlin.jvm.internal.t.b(th2, th);
    }
}
