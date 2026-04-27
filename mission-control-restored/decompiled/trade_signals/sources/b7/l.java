package b7;

import Y6.InterfaceC1033u0;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.N;
import s5.InterfaceC2707e;
import s5.InterfaceC2711i;
import u5.AbstractC2777d;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class l {

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f13254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ B5.p f13255b;

        /* JADX INFO: renamed from: b7.l$a$a, reason: collision with other inner class name */
        public static final class C0225a extends AbstractC2777d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public /* synthetic */ Object f13256a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f13257b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f13259d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f13260e;

            public C0225a(InterfaceC2707e interfaceC2707e) {
                super(interfaceC2707e);
            }

            @Override // u5.AbstractC2774a
            public final Object invokeSuspend(Object obj) {
                this.f13256a = obj;
                this.f13257b |= Integer.MIN_VALUE;
                return a.this.collect(null, this);
            }
        }

        public a(d dVar, B5.p pVar) {
            this.f13254a = dVar;
            this.f13255b = pVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // b7.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object collect(b7.e r6, s5.InterfaceC2707e r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof b7.l.a.C0225a
                if (r0 == 0) goto L13
                r0 = r7
                b7.l$a$a r0 = (b7.l.a.C0225a) r0
                int r1 = r0.f13257b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13257b = r1
                goto L18
            L13:
                b7.l$a$a r0 = new b7.l$a$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.f13256a
                java.lang.Object r1 = t5.AbstractC2751c.f()
                int r2 = r0.f13257b
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L40
                if (r2 == r4) goto L34
                if (r2 != r3) goto L2c
                o5.AbstractC2491s.b(r7)
                goto L6f
            L2c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L34:
                java.lang.Object r6 = r0.f13260e
                b7.e r6 = (b7.e) r6
                java.lang.Object r2 = r0.f13259d
                b7.l$a r2 = (b7.l.a) r2
                o5.AbstractC2491s.b(r7)
                goto L53
            L40:
                o5.AbstractC2491s.b(r7)
                b7.d r7 = r5.f13254a
                r0.f13259d = r5
                r0.f13260e = r6
                r0.f13257b = r4
                java.lang.Object r7 = b7.f.e(r7, r6, r0)
                if (r7 != r1) goto L52
                return r1
            L52:
                r2 = r5
            L53:
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 == 0) goto L6f
                B5.p r2 = r2.f13255b
                r4 = 0
                r0.f13259d = r4
                r0.f13260e = r4
                r0.f13257b = r3
                r3 = 6
                kotlin.jvm.internal.r.a(r3)
                java.lang.Object r6 = r2.invoke(r6, r7, r0)
                r7 = 7
                kotlin.jvm.internal.r.a(r7)
                if (r6 != r1) goto L6f
                return r1
            L6f:
                o5.H r6 = o5.C2470H.f21956a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: b7.l.a.collect(b7.e, s5.e):java.lang.Object");
        }
    }

    public static final class b extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f13262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13263c;

        public b(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f13262b = obj;
            this.f13263c |= Integer.MIN_VALUE;
            return f.e(null, null, this);
        }
    }

    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f13264a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ N f13265b;

        public static final class a extends AbstractC2777d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f13266a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f13267b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f13269d;

            public a(InterfaceC2707e interfaceC2707e) {
                super(interfaceC2707e);
            }

            @Override // u5.AbstractC2774a
            public final Object invokeSuspend(Object obj) {
                this.f13267b = obj;
                this.f13269d |= Integer.MIN_VALUE;
                return c.this.emit(null, this);
            }
        }

        public c(e eVar, N n8) {
            this.f13264a = eVar;
            this.f13265b = n8;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // b7.e
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(java.lang.Object r5, s5.InterfaceC2707e r6) throws java.lang.Throwable {
            /*
                r4 = this;
                boolean r0 = r6 instanceof b7.l.c.a
                if (r0 == 0) goto L13
                r0 = r6
                b7.l$c$a r0 = (b7.l.c.a) r0
                int r1 = r0.f13269d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f13269d = r1
                goto L18
            L13:
                b7.l$c$a r0 = new b7.l$c$a
                r0.<init>(r6)
            L18:
                java.lang.Object r6 = r0.f13267b
                java.lang.Object r1 = t5.AbstractC2751c.f()
                int r2 = r0.f13269d
                r3 = 1
                if (r2 == 0) goto L37
                if (r2 != r3) goto L2f
                java.lang.Object r5 = r0.f13266a
                b7.l$c r5 = (b7.l.c) r5
                o5.AbstractC2491s.b(r6)     // Catch: java.lang.Throwable -> L2d
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
                o5.AbstractC2491s.b(r6)
                b7.e r6 = r4.f13264a     // Catch: java.lang.Throwable -> L4a
                r0.f13266a = r4     // Catch: java.lang.Throwable -> L4a
                r0.f13269d = r3     // Catch: java.lang.Throwable -> L4a
                java.lang.Object r5 = r6.emit(r5, r0)     // Catch: java.lang.Throwable -> L4a
                if (r5 != r1) goto L47
                return r1
            L47:
                o5.H r5 = o5.C2470H.f21956a
                return r5
            L4a:
                r6 = move-exception
                r5 = r4
            L4c:
                kotlin.jvm.internal.N r5 = r5.f13265b
                r5.f20469a = r6
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: b7.l.c.emit(java.lang.Object, s5.e):java.lang.Object");
        }
    }

    public static final d a(d dVar, B5.p pVar) {
        return new a(dVar, pVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(b7.d r4, b7.e r5, s5.InterfaceC2707e r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof b7.l.b
            if (r0 == 0) goto L13
            r0 = r6
            b7.l$b r0 = (b7.l.b) r0
            int r1 = r0.f13263c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13263c = r1
            goto L18
        L13:
            b7.l$b r0 = new b7.l$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f13262b
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.f13263c
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r4 = r0.f13261a
            kotlin.jvm.internal.N r4 = (kotlin.jvm.internal.N) r4
            o5.AbstractC2491s.b(r6)     // Catch: java.lang.Throwable -> L2d
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
            o5.AbstractC2491s.b(r6)
            kotlin.jvm.internal.N r6 = new kotlin.jvm.internal.N
            r6.<init>()
            b7.l$c r2 = new b7.l$c     // Catch: java.lang.Throwable -> L51
            r2.<init>(r5, r6)     // Catch: java.lang.Throwable -> L51
            r0.f13261a = r6     // Catch: java.lang.Throwable -> L51
            r0.f13263c = r3     // Catch: java.lang.Throwable -> L51
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
            java.lang.Object r4 = r4.f20469a
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            boolean r6 = d(r5, r4)
            if (r6 != 0) goto L76
            s5.i r6 = r0.getContext()
            boolean r6 = c(r5, r6)
            if (r6 != 0) goto L76
            if (r4 != 0) goto L6a
            return r5
        L6a:
            boolean r6 = r5 instanceof java.util.concurrent.CancellationException
            if (r6 == 0) goto L72
            o5.AbstractC2477e.a(r4, r5)
            throw r4
        L72:
            o5.AbstractC2477e.a(r5, r4)
            throw r5
        L76:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b7.l.b(b7.d, b7.e, s5.e):java.lang.Object");
    }

    public static final boolean c(Throwable th, InterfaceC2711i interfaceC2711i) {
        InterfaceC1033u0 interfaceC1033u0 = (InterfaceC1033u0) interfaceC2711i.a(InterfaceC1033u0.f9694L);
        if (interfaceC1033u0 == null || !interfaceC1033u0.isCancelled()) {
            return false;
        }
        return d(th, interfaceC1033u0.B());
    }

    public static final boolean d(Throwable th, Throwable th2) {
        return th2 != null && AbstractC2304t.b(th2, th);
    }
}
