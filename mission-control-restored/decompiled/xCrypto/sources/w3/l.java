package w3;

import b3.AbstractC0866d;
import kotlin.jvm.internal.F;
import t3.InterfaceC1846w0;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class l {

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f15617a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i3.p f15618b;

        /* JADX INFO: renamed from: w3.l$a$a, reason: collision with other inner class name */
        public static final class C0254a extends AbstractC0866d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f15619a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f15620b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f15622d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f15623e;

            public C0254a(Z2.e eVar) {
                super(eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) {
                this.f15619a = obj;
                this.f15620b |= Integer.MIN_VALUE;
                return a.this.collect(null, this);
            }
        }

        public a(d dVar, i3.p pVar) {
            this.f15617a = dVar;
            this.f15618b = pVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x006c, code lost:
        
            if (r6 == r1) goto L24;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // w3.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object collect(w3.e r6, Z2.e r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof w3.l.a.C0254a
                if (r0 == 0) goto L13
                r0 = r7
                w3.l$a$a r0 = (w3.l.a.C0254a) r0
                int r1 = r0.f15620b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f15620b = r1
                goto L18
            L13:
                w3.l$a$a r0 = new w3.l$a$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.f15619a
                java.lang.Object r1 = a3.AbstractC0787c.e()
                int r2 = r0.f15620b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L40
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                W2.q.b(r7)
                goto L6f
            L2c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L34:
                java.lang.Object r6 = r0.f15623e
                w3.e r6 = (w3.e) r6
                java.lang.Object r2 = r0.f15622d
                w3.l$a r2 = (w3.l.a) r2
                W2.q.b(r7)
                goto L53
            L40:
                W2.q.b(r7)
                w3.d r7 = r5.f15617a
                r0.f15622d = r5
                r0.f15623e = r6
                r0.f15620b = r4
                java.lang.Object r7 = w3.f.e(r7, r6, r0)
                if (r7 != r1) goto L52
                goto L6e
            L52:
                r2 = r5
            L53:
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L6f
                i3.p r2 = r2.f15618b
                r4 = 0
                r0.f15622d = r4
                r0.f15623e = r4
                r0.f15620b = r3
                r3 = 6
                kotlin.jvm.internal.p.a(r3)
                java.lang.Object r6 = r2.invoke(r6, r7, r0)
                r7 = 7
                kotlin.jvm.internal.p.a(r7)
                if (r6 != r1) goto L6f
            L6e:
                return r1
            L6f:
                W2.E r6 = W2.E.f5463a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: w3.l.a.collect(w3.e, Z2.e):java.lang.Object");
        }
    }

    public static final class b extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f15624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f15625b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f15626c;

        public b(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f15625b = obj;
            this.f15626c |= Integer.MIN_VALUE;
            return f.e(null, null, this);
        }
    }

    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f15627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ F f15628b;

        public static final class a extends AbstractC0866d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f15629a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f15630b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f15632d;

            public a(Z2.e eVar) {
                super(eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) {
                this.f15630b = obj;
                this.f15632d |= Integer.MIN_VALUE;
                return c.this.emit(null, this);
            }
        }

        public c(e eVar, F f4) {
            this.f15627a = eVar;
            this.f15628b = f4;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // w3.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(java.lang.Object r5, Z2.e r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof w3.l.c.a
                if (r0 == 0) goto L13
                r0 = r6
                w3.l$c$a r0 = (w3.l.c.a) r0
                int r1 = r0.f15632d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f15632d = r1
                goto L18
            L13:
                w3.l$c$a r0 = new w3.l$c$a
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.f15630b
                java.lang.Object r1 = a3.AbstractC0787c.e()
                int r2 = r0.f15632d
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r5 = r0.f15629a
                w3.l$c r5 = (w3.l.c) r5
                W2.q.b(r6)     // Catch: java.lang.Throwable -> L2d
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
                W2.q.b(r6)
                w3.e r6 = r4.f15627a     // Catch: java.lang.Throwable -> L4a
                r0.f15629a = r4     // Catch: java.lang.Throwable -> L4a
                r0.f15632d = r3     // Catch: java.lang.Throwable -> L4a
                java.lang.Object r5 = r6.emit(r5, r0)     // Catch: java.lang.Throwable -> L4a
                if (r5 != r1) goto L47
                return r1
            L47:
                W2.E r5 = W2.E.f5463a
                return r5
            L4a:
                r6 = move-exception
                r5 = r4
            L4c:
                kotlin.jvm.internal.F r5 = r5.f15628b
                r5.f13410a = r6
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: w3.l.c.emit(java.lang.Object, Z2.e):java.lang.Object");
        }
    }

    public static final d a(d dVar, i3.p pVar) {
        return new a(dVar, pVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(w3.d r4, w3.e r5, Z2.e r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof w3.l.b
            if (r0 == 0) goto L13
            r0 = r6
            w3.l$b r0 = (w3.l.b) r0
            int r1 = r0.f15626c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f15626c = r1
            goto L18
        L13:
            w3.l$b r0 = new w3.l$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f15625b
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f15626c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.f15624a
            kotlin.jvm.internal.F r4 = (kotlin.jvm.internal.F) r4
            W2.q.b(r6)     // Catch: java.lang.Throwable -> L2d
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
            W2.q.b(r6)
            kotlin.jvm.internal.F r6 = new kotlin.jvm.internal.F
            r6.<init>()
            w3.l$c r2 = new w3.l$c     // Catch: java.lang.Throwable -> L51
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L51
            r0.f15624a = r6     // Catch: java.lang.Throwable -> L51
            r0.f15626c = r3     // Catch: java.lang.Throwable -> L51
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
            java.lang.Object r4 = r4.f13410a
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r6 = d(r5, r4)
            if (r6 != 0) goto L76
            Z2.i r6 = r0.getContext()
            boolean r6 = c(r5, r6)
            if (r6 != 0) goto L76
            if (r4 != 0) goto L6a
            return r5
        L6a:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L72
            W2.AbstractC0737e.a(r4, r5)
            throw r4
        L72:
            W2.AbstractC0737e.a(r5, r4)
            throw r5
        L76:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: w3.l.b(w3.d, w3.e, Z2.e):java.lang.Object");
    }

    public static final boolean c(Throwable th, Z2.i iVar) {
        InterfaceC1846w0 interfaceC1846w0 = (InterfaceC1846w0) iVar.get(InterfaceC1846w0.f15039M);
        if (interfaceC1846w0 == null || !interfaceC1846w0.isCancelled()) {
            return false;
        }
        return d(th, interfaceC1846w0.getCancellationException());
    }

    public static final boolean d(Throwable th, Throwable th2) {
        return th2 != null && kotlin.jvm.internal.r.b(th2, th);
    }
}
