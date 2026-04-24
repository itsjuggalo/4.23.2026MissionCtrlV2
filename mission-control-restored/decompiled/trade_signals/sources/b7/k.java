package b7;

import s5.InterfaceC2707e;
import u5.AbstractC2777d;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class k {

    public static final class a extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13236a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f13237b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13238c;

        public a(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f13237b = obj;
            this.f13238c |= Integer.MIN_VALUE;
            return k.c(null, null, null, this);
        }
    }

    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f13239a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ B5.p f13240b;

        public static final class a extends AbstractC2777d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f13241a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f13242b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f13244d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f13245e;

            public a(InterfaceC2707e interfaceC2707e) {
                super(interfaceC2707e);
            }

            @Override // u5.AbstractC2774a
            public final Object invokeSuspend(Object obj) {
                this.f13241a = obj;
                this.f13242b |= Integer.MIN_VALUE;
                return b.this.collect(null, this);
            }
        }

        public b(d dVar, B5.p pVar) {
            this.f13239a = dVar;
            this.f13240b = pVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x0086 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0087  */
        /* JADX WARN: Removed duplicated region for block: B:46:0x00ab A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:56:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // b7.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object collect(b7.e r9, s5.InterfaceC2707e r10) throws java.lang.Throwable {
            /*
                r8 = this;
                boolean r0 = r10 instanceof b7.k.b.a
                if (r0 == 0) goto L13
                r0 = r10
                b7.k$b$a r0 = (b7.k.b.a) r0
                int r1 = r0.f13242b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13242b = r1
                goto L18
            L13:
                b7.k$b$a r0 = new b7.k$b$a
                r0.<init>(r10)
            L18:
                java.lang.Object r10 = r0.f13241a
                java.lang.Object r1 = t5.AbstractC2751c.f()
                int r2 = r0.f13242b
                r3 = 3
                r4 = 2
                r5 = 1
                r6 = 0
                if (r2 == 0) goto L54
                if (r2 == r5) goto L46
                if (r2 == r4) goto L3e
                if (r2 != r3) goto L36
                java.lang.Object r9 = r0.f13244d
                c7.o r9 = (c7.o) r9
                o5.AbstractC2491s.b(r10)     // Catch: java.lang.Throwable -> L34
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
                java.lang.Object r9 = r0.f13244d
                java.lang.Throwable r9 = (java.lang.Throwable) r9
                o5.AbstractC2491s.b(r10)
                goto Lac
            L46:
                java.lang.Object r9 = r0.f13245e
                b7.e r9 = (b7.e) r9
                java.lang.Object r2 = r0.f13244d
                b7.k$b r2 = (b7.k.b) r2
                o5.AbstractC2491s.b(r10)     // Catch: java.lang.Throwable -> L52
                goto L67
            L52:
                r9 = move-exception
                goto L98
            L54:
                o5.AbstractC2491s.b(r10)
                b7.d r10 = r8.f13239a     // Catch: java.lang.Throwable -> L96
                r0.f13244d = r8     // Catch: java.lang.Throwable -> L96
                r0.f13245e = r9     // Catch: java.lang.Throwable -> L96
                r0.f13242b = r5     // Catch: java.lang.Throwable -> L96
                java.lang.Object r10 = r10.collect(r9, r0)     // Catch: java.lang.Throwable -> L96
                if (r10 != r1) goto L66
                return r1
            L66:
                r2 = r8
            L67:
                c7.o r10 = new c7.o
                s5.i r4 = r0.getContext()
                r10.<init>(r9, r4)
                B5.p r9 = r2.f13240b     // Catch: java.lang.Throwable -> L8e
                r0.f13244d = r10     // Catch: java.lang.Throwable -> L8e
                r0.f13245e = r6     // Catch: java.lang.Throwable -> L8e
                r0.f13242b = r3     // Catch: java.lang.Throwable -> L8e
                r2 = 6
                kotlin.jvm.internal.r.a(r2)     // Catch: java.lang.Throwable -> L8e
                java.lang.Object r9 = r9.invoke(r10, r6, r0)     // Catch: java.lang.Throwable -> L8e
                r0 = 7
                kotlin.jvm.internal.r.a(r0)     // Catch: java.lang.Throwable -> L8e
                if (r9 != r1) goto L87
                return r1
            L87:
                r9 = r10
            L88:
                r9.releaseIntercepted()
                o5.H r9 = o5.C2470H.f21956a
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
                b7.w r10 = new b7.w
                r10.<init>(r9)
                B5.p r2 = r2.f13240b
                r0.f13244d = r9
                r0.f13245e = r6
                r0.f13242b = r4
                java.lang.Object r10 = b7.k.a(r10, r2, r9, r0)
                if (r10 != r1) goto Lac
                return r1
            Lac:
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: b7.k.b.collect(b7.e, s5.e):java.lang.Object");
        }
    }

    public static final class c implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ B5.o f13246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f13247b;

        public static final class a extends AbstractC2777d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f13248a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f13249b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f13251d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f13252e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Object f13253f;

            public a(InterfaceC2707e interfaceC2707e) {
                super(interfaceC2707e);
            }

            @Override // u5.AbstractC2774a
            public final Object invokeSuspend(Object obj) {
                this.f13248a = obj;
                this.f13249b |= Integer.MIN_VALUE;
                return c.this.collect(null, this);
            }
        }

        public c(B5.o oVar, d dVar) {
            this.f13246a = oVar;
            this.f13247b = dVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0082 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // b7.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object collect(b7.e r7, s5.InterfaceC2707e r8) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r8 instanceof b7.k.c.a
                if (r0 == 0) goto L13
                r0 = r8
                b7.k$c$a r0 = (b7.k.c.a) r0
                int r1 = r0.f13249b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13249b = r1
                goto L18
            L13:
                b7.k$c$a r0 = new b7.k$c$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.f13248a
                java.lang.Object r1 = t5.AbstractC2751c.f()
                int r2 = r0.f13249b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                o5.AbstractC2491s.b(r8)
                goto L83
            L2c:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L34:
                java.lang.Object r7 = r0.f13253f
                c7.o r7 = (c7.o) r7
                java.lang.Object r2 = r0.f13252e
                b7.e r2 = (b7.e) r2
                java.lang.Object r4 = r0.f13251d
                b7.k$c r4 = (b7.k.c) r4
                o5.AbstractC2491s.b(r8)     // Catch: java.lang.Throwable -> L44
                goto L6e
            L44:
                r8 = move-exception
                goto L8a
            L46:
                o5.AbstractC2491s.b(r8)
                c7.o r8 = new c7.o
                s5.i r2 = r0.getContext()
                r8.<init>(r7, r2)
                B5.o r2 = r6.f13246a     // Catch: java.lang.Throwable -> L86
                r0.f13251d = r6     // Catch: java.lang.Throwable -> L86
                r0.f13252e = r7     // Catch: java.lang.Throwable -> L86
                r0.f13253f = r8     // Catch: java.lang.Throwable -> L86
                r0.f13249b = r4     // Catch: java.lang.Throwable -> L86
                r4 = 6
                kotlin.jvm.internal.r.a(r4)     // Catch: java.lang.Throwable -> L86
                java.lang.Object r2 = r2.invoke(r8, r0)     // Catch: java.lang.Throwable -> L86
                r4 = 7
                kotlin.jvm.internal.r.a(r4)     // Catch: java.lang.Throwable -> L86
                if (r2 != r1) goto L6b
                return r1
            L6b:
                r4 = r6
                r2 = r7
                r7 = r8
            L6e:
                r7.releaseIntercepted()
                b7.d r7 = r4.f13247b
                r8 = 0
                r0.f13251d = r8
                r0.f13252e = r8
                r0.f13253f = r8
                r0.f13249b = r3
                java.lang.Object r7 = r7.collect(r2, r0)
                if (r7 != r1) goto L83
                return r1
            L83:
                o5.H r7 = o5.C2470H.f21956a
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
            throw new UnsupportedOperationException("Method not decompiled: b7.k.c.collect(b7.e, s5.e):java.lang.Object");
        }
    }

    public static final void b(e eVar) throws Throwable {
        if (eVar instanceof w) {
            throw ((w) eVar).f13318a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object c(b7.e r4, B5.p r5, java.lang.Throwable r6, s5.InterfaceC2707e r7) throws java.lang.Throwable {
        /*
            boolean r0 = r7 instanceof b7.k.a
            if (r0 == 0) goto L13
            r0 = r7
            b7.k$a r0 = (b7.k.a) r0
            int r1 = r0.f13238c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13238c = r1
            goto L18
        L13:
            b7.k$a r0 = new b7.k$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f13237b
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.f13238c
            r3 = 1
            if (r2 == 0) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r4 = r0.f13236a
            r6 = r4
            java.lang.Throwable r6 = (java.lang.Throwable) r6
            o5.AbstractC2491s.b(r7)     // Catch: java.lang.Throwable -> L2e
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
            o5.AbstractC2491s.b(r7)
            r0.f13236a = r6     // Catch: java.lang.Throwable -> L2e
            r0.f13238c = r3     // Catch: java.lang.Throwable -> L2e
            java.lang.Object r4 = r5.invoke(r4, r6, r0)     // Catch: java.lang.Throwable -> L2e
            if (r4 != r1) goto L46
            return r1
        L46:
            o5.H r4 = o5.C2470H.f21956a
            return r4
        L49:
            if (r6 == 0) goto L50
            if (r6 == r4) goto L50
            o5.AbstractC2477e.a(r4, r6)
        L50:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b7.k.c(b7.e, B5.p, java.lang.Throwable, s5.e):java.lang.Object");
    }

    public static final d d(d dVar, B5.p pVar) {
        return new b(dVar, pVar);
    }

    public static final d e(d dVar, B5.o oVar) {
        return new c(oVar, dVar);
    }
}
