package S;

import S.J;
import S.w;
import a3.AbstractC0787c;
import b3.AbstractC0864b;
import b3.AbstractC0866d;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC1585j;
import t3.AbstractC1818i;
import t3.AbstractC1851z;
import t3.InterfaceC1846w0;
import t3.InterfaceC1847x;
import t3.L;

/* JADX INFO: renamed from: S.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0525k implements InterfaceC0523i {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final a f3627m = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final E f3628a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0519e f3629b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final L f3630c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w3.d f3631d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C3.a f3632e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f3633f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public InterfaceC1846w0 f3634g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final S.l f3635h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f3636i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final W2.j f3637j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final W2.j f3638k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final B f3639l;

    /* JADX INFO: renamed from: S.k$a */
    public static final class a {
        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: S.k$b */
    public final class b extends z {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f3640c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ C0525k f3641d;

        /* JADX INFO: renamed from: S.k$b$a */
        public static final class a extends AbstractC0866d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f3642a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f3643b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f3645d;

            public a(Z2.e eVar) {
                super(eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) {
                this.f3643b = obj;
                this.f3645d |= Integer.MIN_VALUE;
                return b.this.b(this);
            }
        }

        /* JADX INFO: renamed from: S.k$b$b, reason: collision with other inner class name */
        public static final class C0064b extends b3.l implements i3.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f3646a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f3647b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object f3648c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Object f3649d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public Object f3650e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public int f3651f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public int f3652g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public final /* synthetic */ C0525k f3653h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public final /* synthetic */ b f3654i;

            /* JADX INFO: renamed from: S.k$b$b$a */
            public static final class a implements S.s {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ C3.a f3655a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ kotlin.jvm.internal.D f3656b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public final /* synthetic */ kotlin.jvm.internal.F f3657c;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public final /* synthetic */ C0525k f3658d;

                /* JADX INFO: renamed from: S.k$b$b$a$a, reason: collision with other inner class name */
                public static final class C0065a extends AbstractC0866d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public Object f3659a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public Object f3660b;

                    /* JADX INFO: renamed from: c, reason: collision with root package name */
                    public Object f3661c;

                    /* JADX INFO: renamed from: d, reason: collision with root package name */
                    public Object f3662d;

                    /* JADX INFO: renamed from: e, reason: collision with root package name */
                    public Object f3663e;

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    public /* synthetic */ Object f3664f;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    public int f3666h;

                    public C0065a(Z2.e eVar) {
                        super(eVar);
                    }

                    @Override // b3.AbstractC0863a
                    public final Object invokeSuspend(Object obj) {
                        this.f3664f = obj;
                        this.f3666h |= Integer.MIN_VALUE;
                        return a.this.a(null, this);
                    }
                }

                public a(C3.a aVar, kotlin.jvm.internal.D d4, kotlin.jvm.internal.F f4, C0525k c0525k) {
                    this.f3655a = aVar;
                    this.f3656b = d4;
                    this.f3657c = f4;
                    this.f3658d = c0525k;
                }

                /* JADX WARN: Removed duplicated region for block: B:38:0x00ba A[Catch: all -> 0x0056, TRY_LEAVE, TryCatch #0 {all -> 0x0056, blocks: (B:21:0x0052, B:36:0x00b2, B:38:0x00ba), top: B:53:0x0052 }] */
                /* JADX WARN: Removed duplicated region for block: B:43:0x00d1  */
                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // S.s
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public java.lang.Object a(i3.o r10, Z2.e r11) throws java.lang.Throwable {
                    /*
                        Method dump skipped, instruction units count: 231
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: S.C0525k.b.C0064b.a.a(i3.o, Z2.e):java.lang.Object");
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0064b(C0525k c0525k, b bVar, Z2.e eVar) {
                super(1, eVar);
                this.f3653h = c0525k;
                this.f3654i = bVar;
            }

            @Override // i3.k
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Z2.e eVar) {
                return ((C0064b) create(eVar)).invokeSuspend(W2.E.f5463a);
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Z2.e eVar) {
                return new C0064b(this.f3653h, this.f3654i, eVar);
            }

            /* JADX WARN: Removed duplicated region for block: B:23:0x00af  */
            /* JADX WARN: Removed duplicated region for block: B:31:0x00e6  */
            /* JADX WARN: Removed duplicated region for block: B:35:0x00f2  */
            /* JADX WARN: Removed duplicated region for block: B:39:0x010d  */
            @Override // b3.AbstractC0863a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
                /*
                    Method dump skipped, instruction units count: 287
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: S.C0525k.b.C0064b.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public b(C0525k c0525k, List initTasksList) {
            kotlin.jvm.internal.r.f(initTasksList, "initTasksList");
            this.f3641d = c0525k;
            this.f3640c = X2.x.g0(initTasksList);
        }

        /* JADX WARN: Removed duplicated region for block: B:26:0x006e  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // S.z
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object b(Z2.e r7) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r7 instanceof S.C0525k.b.a
                if (r0 == 0) goto L13
                r0 = r7
                S.k$b$a r0 = (S.C0525k.b.a) r0
                int r1 = r0.f3645d
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f3645d = r1
                goto L18
            L13:
                S.k$b$a r0 = new S.k$b$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.f3643b
                java.lang.Object r1 = a3.AbstractC0787c.e()
                int r2 = r0.f3645d
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L40
                if (r2 == r4) goto L38
                if (r2 != r3) goto L30
                java.lang.Object r0 = r0.f3642a
                S.k$b r0 = (S.C0525k.b) r0
                W2.q.b(r7)
                goto L6b
            L30:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L38:
                java.lang.Object r0 = r0.f3642a
                S.k$b r0 = (S.C0525k.b) r0
                W2.q.b(r7)
                goto L7d
            L40:
                W2.q.b(r7)
                java.util.List r7 = r6.f3640c
                if (r7 == 0) goto L6e
                kotlin.jvm.internal.r.c(r7)
                boolean r7 = r7.isEmpty()
                if (r7 == 0) goto L51
                goto L6e
            L51:
                S.k r7 = r6.f3641d
                S.t r7 = S.C0525k.c(r7)
                S.k$b$b r2 = new S.k$b$b
                S.k r4 = r6.f3641d
                r5 = 0
                r2.<init>(r4, r6, r5)
                r0.f3642a = r6
                r0.f3645d = r3
                java.lang.Object r7 = r7.d(r2, r0)
                if (r7 != r1) goto L6a
                goto L7b
            L6a:
                r0 = r6
            L6b:
                S.f r7 = (S.C0520f) r7
                goto L7f
            L6e:
                S.k r7 = r6.f3641d
                r0.f3642a = r6
                r0.f3645d = r4
                r2 = 0
                java.lang.Object r7 = S.C0525k.n(r7, r2, r0)
                if (r7 != r1) goto L7c
            L7b:
                return r1
            L7c:
                r0 = r6
            L7d:
                S.f r7 = (S.C0520f) r7
            L7f:
                S.k r0 = r0.f3641d
                S.l r0 = S.C0525k.d(r0)
                r0.c(r7)
                W2.E r7 = W2.E.f5463a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: S.C0525k.b.b(Z2.e):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: S.k$c */
    public static final class c extends kotlin.jvm.internal.s implements Function0 {
        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final S.t invoke() {
            return C0525k.this.s().c();
        }
    }

    /* JADX INFO: renamed from: S.k$d */
    public static final class d extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3668a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3669b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f3670c;

        /* JADX INFO: renamed from: S.k$d$a */
        public static final class a extends b3.l implements i3.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f3672a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C0525k f3673b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(C0525k c0525k, Z2.e eVar) {
                super(2, eVar);
                this.f3673b = c0525k;
            }

            @Override // i3.o
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(w3.e eVar, Z2.e eVar2) {
                return ((a) create(eVar, eVar2)).invokeSuspend(W2.E.f5463a);
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                return new a(this.f3673b, eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = AbstractC0787c.e();
                int i4 = this.f3672a;
                if (i4 == 0) {
                    W2.q.b(obj);
                    C0525k c0525k = this.f3673b;
                    this.f3672a = 1;
                    if (c0525k.u(this) == objE) {
                        return objE;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    W2.q.b(obj);
                }
                return W2.E.f5463a;
            }
        }

        /* JADX INFO: renamed from: S.k$d$b */
        public static final class b extends b3.l implements i3.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f3674a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f3675b;

            public b(Z2.e eVar) {
                super(2, eVar);
            }

            @Override // i3.o
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(D d4, Z2.e eVar) {
                return ((b) create(d4, eVar)).invokeSuspend(W2.E.f5463a);
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                b bVar = new b(eVar);
                bVar.f3675b = obj;
                return bVar;
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC0787c.e();
                if (this.f3674a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
                return AbstractC0864b.a(!(((D) this.f3675b) instanceof S.r));
            }
        }

        /* JADX INFO: renamed from: S.k$d$c */
        public static final class c extends b3.l implements i3.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f3676a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f3677b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ D f3678c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(D d4, Z2.e eVar) {
                super(2, eVar);
                this.f3678c = d4;
            }

            @Override // i3.o
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(D d4, Z2.e eVar) {
                return ((c) create(d4, eVar)).invokeSuspend(W2.E.f5463a);
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                c cVar = new c(this.f3678c, eVar);
                cVar.f3677b = obj;
                return cVar;
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                AbstractC0787c.e();
                if (this.f3676a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
                D d4 = (D) this.f3677b;
                return AbstractC0864b.a((d4 instanceof C0520f) && d4.a() <= this.f3678c.a());
            }
        }

        /* JADX INFO: renamed from: S.k$d$d, reason: collision with other inner class name */
        public static final class C0066d extends b3.l implements i3.p {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f3679a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ C0525k f3680b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0066d(C0525k c0525k, Z2.e eVar) {
                super(3, eVar);
                this.f3680b = c0525k;
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = AbstractC0787c.e();
                int i4 = this.f3679a;
                if (i4 == 0) {
                    W2.q.b(obj);
                    C0525k c0525k = this.f3680b;
                    this.f3679a = 1;
                    if (c0525k.p(this) == objE) {
                        return objE;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    W2.q.b(obj);
                }
                return W2.E.f5463a;
            }

            @Override // i3.p
            public final Object invoke(w3.e eVar, Throwable th, Z2.e eVar2) {
                return new C0066d(this.f3680b, eVar2).invokeSuspend(W2.E.f5463a);
            }
        }

        /* JADX INFO: renamed from: S.k$d$e */
        public static final class e implements w3.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ w3.d f3681a;

            /* JADX INFO: renamed from: S.k$d$e$a */
            public static final class a implements w3.e {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final /* synthetic */ w3.e f3682a;

                /* JADX INFO: renamed from: S.k$d$e$a$a, reason: collision with other inner class name */
                public static final class C0067a extends AbstractC0866d {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public /* synthetic */ Object f3683a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    public int f3684b;

                    public C0067a(Z2.e eVar) {
                        super(eVar);
                    }

                    @Override // b3.AbstractC0863a
                    public final Object invokeSuspend(Object obj) {
                        this.f3683a = obj;
                        this.f3684b |= Integer.MIN_VALUE;
                        return a.this.emit(null, this);
                    }
                }

                public a(w3.e eVar) {
                    this.f3682a = eVar;
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
                        boolean r0 = r6 instanceof S.C0525k.d.e.a.C0067a
                        if (r0 == 0) goto L13
                        r0 = r6
                        S.k$d$e$a$a r0 = (S.C0525k.d.e.a.C0067a) r0
                        int r1 = r0.f3684b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f3684b = r1
                        goto L18
                    L13:
                        S.k$d$e$a$a r0 = new S.k$d$e$a$a
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f3683a
                        java.lang.Object r1 = a3.AbstractC0787c.e()
                        int r2 = r0.f3684b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        W2.q.b(r6)
                        goto L4f
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        W2.q.b(r6)
                        w3.e r6 = r4.f3682a
                        S.D r5 = (S.D) r5
                        boolean r2 = r5 instanceof S.x
                        if (r2 != 0) goto L69
                        boolean r2 = r5 instanceof S.C0520f
                        if (r2 == 0) goto L52
                        S.f r5 = (S.C0520f) r5
                        java.lang.Object r5 = r5.c()
                        r0.f3684b = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L4f
                        return r1
                    L4f:
                        W2.E r5 = W2.E.f5463a
                        return r5
                    L52:
                        boolean r6 = r5 instanceof S.r
                        if (r6 == 0) goto L57
                        goto L59
                    L57:
                        boolean r3 = r5 instanceof S.H
                    L59:
                        if (r3 == 0) goto L63
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "This is a bug in DataStore. Please file a bug at: https://issuetracker.google.com/issues/new?component=907884&template=1466542"
                        r5.<init>(r6)
                        throw r5
                    L63:
                        W2.m r5 = new W2.m
                        r5.<init>()
                        throw r5
                    L69:
                        S.x r5 = (S.x) r5
                        java.lang.Throwable r5 = r5.b()
                        throw r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: S.C0525k.d.e.a.emit(java.lang.Object, Z2.e):java.lang.Object");
                }
            }

            public e(w3.d dVar) {
                this.f3681a = dVar;
            }

            @Override // w3.d
            public Object collect(w3.e eVar, Z2.e eVar2) {
                Object objCollect = this.f3681a.collect(new a(eVar), eVar2);
                return objCollect == AbstractC0787c.e() ? objCollect : W2.E.f5463a;
            }
        }

        public d(Z2.e eVar) {
            super(2, eVar);
        }

        @Override // i3.o
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(w3.e eVar, Z2.e eVar2) {
            return ((d) create(eVar, eVar2)).invokeSuspend(W2.E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            d dVar = C0525k.this.new d(eVar);
            dVar.f3670c = obj;
            return dVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:32:0x00bb, code lost:
        
            if (w3.f.i(r1, r9, r8) == r0) goto L33;
         */
        @Override // b3.AbstractC0863a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 208
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: S.C0525k.d.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: S.k$e */
    public static final class e extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3686a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f3687b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f3688c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3690e;

        public e(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f3688c = obj;
            this.f3690e |= Integer.MIN_VALUE;
            return C0525k.this.p(this);
        }
    }

    /* JADX INFO: renamed from: S.k$f */
    public static final class f extends b3.l implements i3.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3691a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ i3.k f3692b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(i3.k kVar, Z2.e eVar) {
            super(1, eVar);
            this.f3692b = kVar;
        }

        @Override // i3.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Z2.e eVar) {
            return ((f) create(eVar)).invokeSuspend(W2.E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Z2.e eVar) {
            return new f(this.f3692b, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.f3691a;
            if (i4 != 0) {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
                return obj;
            }
            W2.q.b(obj);
            i3.k kVar = this.f3692b;
            this.f3691a = 1;
            Object objInvoke = kVar.invoke(this);
            return objInvoke == objE ? objE : objInvoke;
        }
    }

    /* JADX INFO: renamed from: S.k$g */
    public static final class g extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f3694b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f3695c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f3696d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3698f;

        public g(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f3696d = obj;
            this.f3698f |= Integer.MIN_VALUE;
            return C0525k.this.t(null, this);
        }
    }

    /* JADX INFO: renamed from: S.k$h */
    public static final class h extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3699a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f3700b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f3701c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3703e;

        public h(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f3701c = obj;
            this.f3703e |= Integer.MIN_VALUE;
            return C0525k.this.u(this);
        }
    }

    /* JADX INFO: renamed from: S.k$i */
    public static final class i extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3704a;

        /* JADX INFO: renamed from: S.k$i$a */
        public static final class a implements w3.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C0525k f3706a;

            public a(C0525k c0525k) {
                this.f3706a = c0525k;
            }

            @Override // w3.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object emit(W2.E e4, Z2.e eVar) throws Throwable {
                if (this.f3706a.f3635h.a() instanceof S.r) {
                    return W2.E.f5463a;
                }
                Object objW = this.f3706a.w(true, eVar);
                return objW == AbstractC0787c.e() ? objW : W2.E.f5463a;
            }
        }

        public i(Z2.e eVar) {
            super(2, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return C0525k.this.new i(eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:14:0x004b, code lost:
        
            if (r5.collect(r1, r4) == r0) goto L15;
         */
        @Override // b3.AbstractC0863a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                java.lang.Object r0 = a3.AbstractC0787c.e()
                int r1 = r4.f3704a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1e
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                W2.q.b(r5)
                goto L4e
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                W2.q.b(r5)
                goto L30
            L1e:
                W2.q.b(r5)
                S.k r5 = S.C0525k.this
                S.k$b r5 = S.C0525k.e(r5)
                r4.f3704a = r3
                java.lang.Object r5 = r5.a(r4)
                if (r5 != r0) goto L30
                goto L4d
            L30:
                S.k r5 = S.C0525k.this
                S.t r5 = S.C0525k.c(r5)
                w3.d r5 = r5.e()
                w3.d r5 = w3.f.f(r5)
                S.k$i$a r1 = new S.k$i$a
                S.k r3 = S.C0525k.this
                r1.<init>(r3)
                r4.f3704a = r2
                java.lang.Object r5 = r5.collect(r1, r4)
                if (r5 != r0) goto L4e
            L4d:
                return r0
            L4e:
                W2.E r5 = W2.E.f5463a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: S.C0525k.i.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((i) create(l4, eVar)).invokeSuspend(W2.E.f5463a);
        }
    }

    /* JADX INFO: renamed from: S.k$j */
    public static final class j extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3708b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f3709c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f3711e;

        public j(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f3709c = obj;
            this.f3711e |= Integer.MIN_VALUE;
            return C0525k.this.v(this);
        }
    }

    /* JADX INFO: renamed from: S.k$k, reason: collision with other inner class name */
    public static final class C0068k extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f3713b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f3714c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public /* synthetic */ Object f3715d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3717f;

        public C0068k(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f3715d = obj;
            this.f3717f |= Integer.MIN_VALUE;
            return C0525k.this.w(false, this);
        }
    }

    /* JADX INFO: renamed from: S.k$l */
    public static final class l extends b3.l implements i3.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3718a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3719b;

        public l(Z2.e eVar) {
            super(1, eVar);
        }

        @Override // i3.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Z2.e eVar) {
            return ((l) create(eVar)).invokeSuspend(W2.E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Z2.e eVar) {
            return C0525k.this.new l(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            D xVar;
            Object objE = AbstractC0787c.e();
            int i4 = this.f3719b;
            try {
            } catch (Throwable th2) {
                S.t tVarR = C0525k.this.r();
                this.f3718a = th2;
                this.f3719b = 2;
                Object objC = tVarR.c(this);
                if (objC != objE) {
                    th = th2;
                    obj = objC;
                }
                return objE;
            }
            if (i4 == 0) {
                W2.q.b(obj);
                C0525k c0525k = C0525k.this;
                this.f3719b = 1;
                obj = c0525k.y(true, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    if (i4 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    th = (Throwable) this.f3718a;
                    W2.q.b(obj);
                    xVar = new S.x(th, ((Number) obj).intValue());
                    return W2.t.a(xVar, AbstractC0864b.a(true));
                }
                W2.q.b(obj);
            }
            xVar = (D) obj;
            return W2.t.a(xVar, AbstractC0864b.a(true));
        }
    }

    /* JADX INFO: renamed from: S.k$m */
    public static final class m extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ boolean f3723c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f3725e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(int i4, Z2.e eVar) {
            super(2, eVar);
            this.f3725e = i4;
        }

        public final Object b(boolean z4, Z2.e eVar) {
            return ((m) create(Boolean.valueOf(z4), eVar)).invokeSuspend(W2.E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            m mVar = C0525k.this.new m(this.f3725e, eVar);
            mVar.f3723c = ((Boolean) obj).booleanValue();
            return mVar;
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return b(((Boolean) obj).booleanValue(), (Z2.e) obj2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v2 */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v5 */
        /* JADX WARN: Type inference failed for: r0v6 */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r1v0, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v15 */
        /* JADX WARN: Type inference failed for: r1v4, types: [boolean] */
        /* JADX WARN: Type inference failed for: r1v6 */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r4v0 */
        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Throwable th;
            int iIntValue;
            ?? r02;
            ?? r03;
            D d4;
            ?? r12;
            Object objE = AbstractC0787c.e();
            ?? r13 = this.f3722b;
            try {
            } catch (Throwable th2) {
                if (r13 != 0) {
                    S.t tVarR = C0525k.this.r();
                    this.f3721a = th2;
                    this.f3723c = r13;
                    this.f3722b = 2;
                    Object objC = tVarR.c(this);
                    if (objC != objE) {
                        r03 = r13;
                        th = th2;
                        obj = objC;
                    }
                    return objE;
                }
                ?? r4 = r13;
                th = th2;
                iIntValue = this.f3725e;
                r02 = r4 == true ? 1 : 0;
            }
            if (r13 == 0) {
                W2.q.b(obj);
                boolean z4 = this.f3723c;
                C0525k c0525k = C0525k.this;
                this.f3723c = z4;
                this.f3722b = 1;
                obj = c0525k.y(z4, this);
                r13 = z4;
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (r13 != 1) {
                    if (r13 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    boolean z5 = this.f3723c;
                    th = (Throwable) this.f3721a;
                    W2.q.b(obj);
                    r03 = z5;
                    iIntValue = ((Number) obj).intValue();
                    r02 = r03;
                    S.x xVar = new S.x(th, iIntValue);
                    r12 = r02;
                    d4 = xVar;
                    return W2.t.a(d4, AbstractC0864b.a(r12));
                }
                boolean z6 = this.f3723c;
                W2.q.b(obj);
                r13 = z6;
            }
            d4 = (D) obj;
            r12 = r13;
            return W2.t.a(d4, AbstractC0864b.a(r12));
        }
    }

    /* JADX INFO: renamed from: S.k$n */
    public static final class n extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3726a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Object f3727b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Object f3728c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Object f3729d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f3730e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f3731f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public /* synthetic */ Object f3732g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f3734i;

        public n(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f3732g = obj;
            this.f3734i |= Integer.MIN_VALUE;
            return C0525k.this.y(false, this);
        }
    }

    /* JADX INFO: renamed from: S.k$o */
    public static final class o extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3735a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3736b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ boolean f3737c;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ int f3739e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(int i4, Z2.e eVar) {
            super(2, eVar);
            this.f3739e = i4;
        }

        public final Object b(boolean z4, Z2.e eVar) {
            return ((o) create(Boolean.valueOf(z4), eVar)).invokeSuspend(W2.E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            o oVar = C0525k.this.new o(this.f3739e, eVar);
            oVar.f3737c = ((Boolean) obj).booleanValue();
            return oVar;
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return b(((Boolean) obj).booleanValue(), (Z2.e) obj2);
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x0059  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x005e  */
        @Override // b3.AbstractC0863a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
            /*
                r5 = this;
                java.lang.Object r0 = a3.AbstractC0787c.e()
                int r1 = r5.f3736b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1c
                if (r1 != r2) goto L14
                java.lang.Object r0 = r5.f3735a
                W2.q.b(r6)
                goto L49
            L14:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1c:
                boolean r1 = r5.f3737c
                W2.q.b(r6)
                goto L34
            L22:
                W2.q.b(r6)
                boolean r1 = r5.f3737c
                S.k r6 = S.C0525k.this
                r5.f3737c = r1
                r5.f3736b = r3
                java.lang.Object r6 = S.C0525k.m(r6, r5)
                if (r6 != r0) goto L34
                goto L46
            L34:
                if (r1 == 0) goto L50
                S.k r1 = S.C0525k.this
                S.t r1 = S.C0525k.c(r1)
                r5.f3735a = r6
                r5.f3736b = r2
                java.lang.Object r1 = r1.c(r5)
                if (r1 != r0) goto L47
            L46:
                return r0
            L47:
                r0 = r6
                r6 = r1
            L49:
                java.lang.Number r6 = (java.lang.Number) r6
                int r6 = r6.intValue()
                goto L55
            L50:
                int r0 = r5.f3739e
                r4 = r0
                r0 = r6
                r6 = r4
            L55:
                S.f r1 = new S.f
                if (r0 == 0) goto L5e
                int r2 = r0.hashCode()
                goto L5f
            L5e:
                r2 = 0
            L5f:
                r1.<init>(r0, r2, r6)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: S.C0525k.o.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: S.k$p */
    public static final class p extends b3.l implements i3.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3741b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.F f3742c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ C0525k f3743d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.E f3744e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(kotlin.jvm.internal.F f4, C0525k c0525k, kotlin.jvm.internal.E e4, Z2.e eVar) {
            super(1, eVar);
            this.f3742c = f4;
            this.f3743d = c0525k;
            this.f3744e = e4;
        }

        @Override // i3.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Z2.e eVar) {
            return ((p) create(eVar)).invokeSuspend(W2.E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Z2.e eVar) {
            return new p(this.f3742c, this.f3743d, this.f3744e, eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            kotlin.jvm.internal.E e4;
            kotlin.jvm.internal.F f4;
            kotlin.jvm.internal.E e5;
            Object objE = AbstractC0787c.e();
            int i4 = this.f3741b;
            try {
            } catch (C0518d unused) {
                kotlin.jvm.internal.E e6 = this.f3744e;
                C0525k c0525k = this.f3743d;
                Object obj2 = this.f3742c.f13410a;
                this.f3740a = e6;
                this.f3741b = 3;
                Object objB = c0525k.B(obj2, true, this);
                if (objB != objE) {
                    e4 = e6;
                    obj = objB;
                }
                return objE;
            }
            if (i4 == 0) {
                W2.q.b(obj);
                f4 = this.f3742c;
                C0525k c0525k2 = this.f3743d;
                this.f3740a = f4;
                this.f3741b = 1;
                obj = c0525k2.x(this);
                if (obj == objE) {
                }
                return objE;
            }
            if (i4 != 1) {
                if (i4 == 2) {
                    e5 = (kotlin.jvm.internal.E) this.f3740a;
                    W2.q.b(obj);
                    e5.f13409a = ((Number) obj).intValue();
                    return W2.E.f5463a;
                }
                if (i4 != 3) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                e4 = (kotlin.jvm.internal.E) this.f3740a;
                W2.q.b(obj);
                e4.f13409a = ((Number) obj).intValue();
                return W2.E.f5463a;
            }
            f4 = (kotlin.jvm.internal.F) this.f3740a;
            W2.q.b(obj);
            f4.f13410a = obj;
            e5 = this.f3744e;
            S.t tVarR = this.f3743d.r();
            this.f3740a = e5;
            this.f3741b = 2;
            obj = tVarR.c(this);
            if (obj == objE) {
                return objE;
            }
            e5.f13409a = ((Number) obj).intValue();
            return W2.E.f5463a;
        }
    }

    /* JADX INFO: renamed from: S.k$q */
    public static final class q extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3745a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ boolean f3747c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(boolean z4, Z2.e eVar) {
            super(2, eVar);
            this.f3747c = z4;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            return C0525k.this.new q(this.f3747c, eVar);
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
        
            if (r5 == r0) goto L22;
         */
        @Override // b3.AbstractC0863a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) throws java.lang.Throwable {
            /*
                r4 = this;
                java.lang.Object r0 = a3.AbstractC0787c.e()
                int r1 = r4.f3745a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L20
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                W2.q.b(r5)
                goto L54
            L12:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            L1a:
                W2.q.b(r5)     // Catch: java.lang.Throwable -> L1e
                goto L47
            L1e:
                r5 = move-exception
                goto L57
            L20:
                W2.q.b(r5)
                S.k r5 = S.C0525k.this
                S.l r5 = S.C0525k.d(r5)
                S.D r5 = r5.a()
                boolean r5 = r5 instanceof S.r
                if (r5 == 0) goto L3c
                S.k r5 = S.C0525k.this
                S.l r5 = S.C0525k.d(r5)
                S.D r5 = r5.a()
                return r5
            L3c:
                S.k r5 = S.C0525k.this     // Catch: java.lang.Throwable -> L1e
                r4.f3745a = r3     // Catch: java.lang.Throwable -> L1e
                java.lang.Object r5 = S.C0525k.k(r5, r4)     // Catch: java.lang.Throwable -> L1e
                if (r5 != r0) goto L47
                goto L53
            L47:
                S.k r5 = S.C0525k.this
                boolean r1 = r4.f3747c
                r4.f3745a = r2
                java.lang.Object r5 = S.C0525k.l(r5, r1, r4)
                if (r5 != r0) goto L54
            L53:
                return r0
            L54:
                S.D r5 = (S.D) r5
                return r5
            L57:
                S.x r0 = new S.x
                r1 = -1
                r0.<init>(r5, r1)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: S.C0525k.q.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((q) create(l4, eVar)).invokeSuspend(W2.E.f5463a);
        }
    }

    /* JADX INFO: renamed from: S.k$r */
    public static final class r extends kotlin.jvm.internal.s implements Function0 {
        public r() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final F invoke() {
            return C0525k.this.f3628a.a();
        }
    }

    /* JADX INFO: renamed from: S.k$s */
    public static final class s extends b3.l implements i3.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3749a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3750b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Z2.i f3752d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ i3.o f3753e;

        /* JADX INFO: renamed from: S.k$s$a */
        public static final class a extends b3.l implements i3.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f3754a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ i3.o f3755b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ C0520f f3756c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(i3.o oVar, C0520f c0520f, Z2.e eVar) {
                super(2, eVar);
                this.f3755b = oVar;
                this.f3756c = c0520f;
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                return new a(this.f3755b, this.f3756c, eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = AbstractC0787c.e();
                int i4 = this.f3754a;
                if (i4 != 0) {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    W2.q.b(obj);
                    return obj;
                }
                W2.q.b(obj);
                i3.o oVar = this.f3755b;
                Object objC = this.f3756c.c();
                this.f3754a = 1;
                Object objInvoke = oVar.invoke(objC, this);
                return objInvoke == objE ? objE : objInvoke;
            }

            @Override // i3.o
            public final Object invoke(L l4, Z2.e eVar) {
                return ((a) create(l4, eVar)).invokeSuspend(W2.E.f5463a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public s(Z2.i iVar, i3.o oVar, Z2.e eVar) {
            super(1, eVar);
            this.f3752d = iVar;
            this.f3753e = oVar;
        }

        @Override // i3.k
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Z2.e eVar) {
            return ((s) create(eVar)).invokeSuspend(W2.E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Z2.e eVar) {
            return C0525k.this.new s(this.f3752d, this.f3753e, eVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x005e  */
        @Override // b3.AbstractC0863a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
            /*
                r8 = this;
                java.lang.Object r0 = a3.AbstractC0787c.e()
                int r1 = r8.f3750b
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L2b
                if (r1 == r4) goto L27
                if (r1 == r3) goto L1f
                if (r1 != r2) goto L17
                java.lang.Object r0 = r8.f3749a
                W2.q.b(r9)
                return r0
            L17:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r0)
                throw r9
            L1f:
                java.lang.Object r1 = r8.f3749a
                S.f r1 = (S.C0520f) r1
                W2.q.b(r9)
                goto L51
            L27:
                W2.q.b(r9)
                goto L39
            L2b:
                W2.q.b(r9)
                S.k r9 = S.C0525k.this
                r8.f3750b = r4
                java.lang.Object r9 = S.C0525k.n(r9, r4, r8)
                if (r9 != r0) goto L39
                goto L6a
            L39:
                r1 = r9
                S.f r1 = (S.C0520f) r1
                Z2.i r9 = r8.f3752d
                S.k$s$a r5 = new S.k$s$a
                i3.o r6 = r8.f3753e
                r7 = 0
                r5.<init>(r6, r1, r7)
                r8.f3749a = r1
                r8.f3750b = r3
                java.lang.Object r9 = t3.AbstractC1818i.g(r9, r5, r8)
                if (r9 != r0) goto L51
                goto L6a
            L51:
                r1.b()
                java.lang.Object r1 = r1.c()
                boolean r1 = kotlin.jvm.internal.r.b(r1, r9)
                if (r1 != 0) goto L6b
                S.k r1 = S.C0525k.this
                r8.f3749a = r9
                r8.f3750b = r2
                java.lang.Object r1 = r1.B(r9, r4, r8)
                if (r1 != r0) goto L6b
            L6a:
                return r0
            L6b:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: S.C0525k.s.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: renamed from: S.k$t */
    public static final class t extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3757a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f3758b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ i3.o f3760d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public t(i3.o oVar, Z2.e eVar) {
            super(2, eVar);
            this.f3760d = oVar;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            t tVar = C0525k.this.new t(this.f3760d, eVar);
            tVar.f3758b = obj;
            return tVar;
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.f3757a;
            if (i4 != 0) {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
                return obj;
            }
            W2.q.b(obj);
            L l4 = (L) this.f3758b;
            InterfaceC1847x interfaceC1847xB = AbstractC1851z.b(null, 1, null);
            C0525k.this.f3639l.e(new w.a(this.f3760d, interfaceC1847xB, C0525k.this.f3635h.a(), l4.l()));
            this.f3757a = 1;
            Object objAwait = interfaceC1847xB.await(this);
            return objAwait == objE ? objE : objAwait;
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((t) create(l4, eVar)).invokeSuspend(W2.E.f5463a);
        }
    }

    /* JADX INFO: renamed from: S.k$u */
    public static final class u extends kotlin.jvm.internal.s implements i3.k {
        public u() {
            super(1);
        }

        public final void a(Throwable th) {
            if (th != null) {
                C0525k.this.f3635h.c(new S.r(th));
            }
            if (C0525k.this.f3637j.isInitialized()) {
                C0525k.this.s().close();
            }
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((Throwable) obj);
            return W2.E.f5463a;
        }
    }

    /* JADX INFO: renamed from: S.k$v */
    public static final class v extends kotlin.jvm.internal.s implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f3762a = new v();

        public v() {
            super(2);
        }

        public final void a(w.a msg, Throwable th) {
            kotlin.jvm.internal.r.f(msg, "msg");
            InterfaceC1847x interfaceC1847xA = msg.a();
            if (th == null) {
                th = new CancellationException("DataStore scope was cancelled before updateData could complete");
            }
            interfaceC1847xA.G(th);
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((w.a) obj, (Throwable) obj2);
            return W2.E.f5463a;
        }
    }

    /* JADX INFO: renamed from: S.k$w */
    public static final class w extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f3764b;

        public w(Z2.e eVar) {
            super(2, eVar);
        }

        @Override // i3.o
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(w.a aVar, Z2.e eVar) {
            return ((w) create(aVar, eVar)).invokeSuspend(W2.E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            w wVar = C0525k.this.new w(eVar);
            wVar.f3764b = obj;
            return wVar;
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.f3763a;
            if (i4 == 0) {
                W2.q.b(obj);
                w.a aVar = (w.a) this.f3764b;
                C0525k c0525k = C0525k.this;
                this.f3763a = 1;
                if (c0525k.t(aVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
            }
            return W2.E.f5463a;
        }
    }

    /* JADX INFO: renamed from: S.k$x */
    public static final class x extends AbstractC0866d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3766a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f3767b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f3769d;

        public x(Z2.e eVar) {
            super(eVar);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) {
            this.f3767b = obj;
            this.f3769d |= Integer.MIN_VALUE;
            return C0525k.this.B(null, false, this);
        }
    }

    /* JADX INFO: renamed from: S.k$y */
    public static final class y extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f3770a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f3771b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f3772c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.E f3773d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ C0525k f3774e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ Object f3775f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ boolean f3776g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public y(kotlin.jvm.internal.E e4, C0525k c0525k, Object obj, boolean z4, Z2.e eVar) {
            super(2, eVar);
            this.f3773d = e4;
            this.f3774e = c0525k;
            this.f3775f = obj;
            this.f3776g = z4;
        }

        @Override // i3.o
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(K k4, Z2.e eVar) {
            return ((y) create(k4, eVar)).invokeSuspend(W2.E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            y yVar = new y(this.f3773d, this.f3774e, this.f3775f, this.f3776g, eVar);
            yVar.f3772c = obj;
            return yVar;
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x005a, code lost:
        
            if (r3.d(r7, r6) == r0) goto L16;
         */
        @Override // b3.AbstractC0863a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) throws java.lang.Throwable {
            /*
                r6 = this;
                java.lang.Object r0 = a3.AbstractC0787c.e()
                int r1 = r6.f3771b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L26
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                W2.q.b(r7)
                goto L5d
            L12:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L1a:
                java.lang.Object r1 = r6.f3770a
                kotlin.jvm.internal.E r1 = (kotlin.jvm.internal.E) r1
                java.lang.Object r3 = r6.f3772c
                S.K r3 = (S.K) r3
                W2.q.b(r7)
                goto L45
            L26:
                W2.q.b(r7)
                java.lang.Object r7 = r6.f3772c
                S.K r7 = (S.K) r7
                kotlin.jvm.internal.E r1 = r6.f3773d
                S.k r4 = r6.f3774e
                S.t r4 = S.C0525k.c(r4)
                r6.f3772c = r7
                r6.f3770a = r1
                r6.f3771b = r3
                java.lang.Object r3 = r4.a(r6)
                if (r3 != r0) goto L42
                goto L5c
            L42:
                r5 = r3
                r3 = r7
                r7 = r5
            L45:
                java.lang.Number r7 = (java.lang.Number) r7
                int r7 = r7.intValue()
                r1.f13409a = r7
                java.lang.Object r7 = r6.f3775f
                r1 = 0
                r6.f3772c = r1
                r6.f3770a = r1
                r6.f3771b = r2
                java.lang.Object r7 = r3.d(r7, r6)
                if (r7 != r0) goto L5d
            L5c:
                return r0
            L5d:
                boolean r7 = r6.f3776g
                if (r7 == 0) goto L7d
                S.k r7 = r6.f3774e
                S.l r7 = S.C0525k.d(r7)
                S.f r0 = new S.f
                java.lang.Object r1 = r6.f3775f
                if (r1 == 0) goto L72
                int r2 = r1.hashCode()
                goto L73
            L72:
                r2 = 0
            L73:
                kotlin.jvm.internal.E r3 = r6.f3773d
                int r3 = r3.f13409a
                r0.<init>(r1, r2, r3)
                r7.c(r0)
            L7d:
                W2.E r7 = W2.E.f5463a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: S.C0525k.y.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public C0525k(E storage, List initTasksList, InterfaceC0519e corruptionHandler, L scope) {
        kotlin.jvm.internal.r.f(storage, "storage");
        kotlin.jvm.internal.r.f(initTasksList, "initTasksList");
        kotlin.jvm.internal.r.f(corruptionHandler, "corruptionHandler");
        kotlin.jvm.internal.r.f(scope, "scope");
        this.f3628a = storage;
        this.f3629b = corruptionHandler;
        this.f3630c = scope;
        this.f3631d = w3.f.m(new d(null));
        this.f3632e = C3.c.b(false, 1, null);
        this.f3635h = new S.l();
        this.f3636i = new b(this, initTasksList);
        this.f3637j = W2.k.b(new r());
        this.f3638k = W2.k.b(new c());
        this.f3639l = new B(scope, new u(), v.f3762a, new w(null));
    }

    public final Object A(i3.o oVar, Z2.i iVar, Z2.e eVar) {
        return r().d(new s(iVar, oVar, null), eVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object B(java.lang.Object r11, boolean r12, Z2.e r13) throws java.lang.Throwable {
        /*
            r10 = this;
            boolean r0 = r13 instanceof S.C0525k.x
            if (r0 == 0) goto L13
            r0 = r13
            S.k$x r0 = (S.C0525k.x) r0
            int r1 = r0.f3769d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3769d = r1
            goto L18
        L13:
            S.k$x r0 = new S.k$x
            r0.<init>(r13)
        L18:
            java.lang.Object r13 = r0.f3767b
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f3769d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r11 = r0.f3766a
            kotlin.jvm.internal.E r11 = (kotlin.jvm.internal.E) r11
            W2.q.b(r13)
            goto L56
        L2d:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L35:
            W2.q.b(r13)
            kotlin.jvm.internal.E r5 = new kotlin.jvm.internal.E
            r5.<init>()
            S.F r13 = r10.s()
            S.k$y r4 = new S.k$y
            r9 = 0
            r6 = r10
            r7 = r11
            r8 = r12
            r4.<init>(r5, r6, r7, r8, r9)
            r0.f3766a = r5
            r0.f3769d = r3
            java.lang.Object r11 = r13.b(r4, r0)
            if (r11 != r1) goto L55
            return r1
        L55:
            r11 = r5
        L56:
            int r11 = r11.f13409a
            java.lang.Integer r11 = b3.AbstractC0864b.c(r11)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: S.C0525k.B(java.lang.Object, boolean, Z2.e):java.lang.Object");
    }

    @Override // S.InterfaceC0523i
    public Object a(i3.o oVar, Z2.e eVar) {
        J j4 = (J) eVar.getContext().get(J.a.C0061a.f3604a);
        if (j4 != null) {
            j4.a(this);
        }
        return AbstractC1818i.g(new J(j4, this), new t(oVar, null), eVar);
    }

    @Override // S.InterfaceC0523i
    public w3.d getData() {
        return this.f3631d;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object p(Z2.e r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof S.C0525k.e
            if (r0 == 0) goto L13
            r0 = r6
            S.k$e r0 = (S.C0525k.e) r0
            int r1 = r0.f3690e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3690e = r1
            goto L18
        L13:
            S.k$e r0 = new S.k$e
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f3688c
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f3690e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r1 = r0.f3687b
            C3.a r1 = (C3.a) r1
            java.lang.Object r0 = r0.f3686a
            S.k r0 = (S.C0525k) r0
            W2.q.b(r6)
            goto L4e
        L32:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3a:
            W2.q.b(r6)
            C3.a r6 = r5.f3632e
            r0.f3686a = r5
            r0.f3687b = r6
            r0.f3690e = r3
            java.lang.Object r0 = r6.d(r4, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            r0 = r5
            r1 = r6
        L4e:
            int r6 = r0.f3633f     // Catch: java.lang.Throwable -> L5e
            int r6 = r6 + (-1)
            r0.f3633f = r6     // Catch: java.lang.Throwable -> L5e
            if (r6 != 0) goto L62
            t3.w0 r6 = r0.f3634g     // Catch: java.lang.Throwable -> L5e
            if (r6 == 0) goto L60
            t3.InterfaceC1846w0.a.b(r6, r4, r3, r4)     // Catch: java.lang.Throwable -> L5e
            goto L60
        L5e:
            r6 = move-exception
            goto L6a
        L60:
            r0.f3634g = r4     // Catch: java.lang.Throwable -> L5e
        L62:
            W2.E r6 = W2.E.f5463a     // Catch: java.lang.Throwable -> L5e
            r1.c(r4)
            W2.E r6 = W2.E.f5463a
            return r6
        L6a:
            r1.c(r4)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: S.C0525k.p(Z2.e):java.lang.Object");
    }

    public final Object q(boolean z4, i3.k kVar, Z2.e eVar) {
        return z4 ? kVar.invoke(eVar) : r().d(new f(kVar, null), eVar);
    }

    public final S.t r() {
        return (S.t) this.f3638k.getValue();
    }

    public final F s() {
        return (F) this.f3637j.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00b9, code lost:
    
        if (r9 == r1) goto L46;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r9v0, types: [S.w$a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v15 */
    /* JADX WARN: Type inference failed for: r9v16, types: [S.w$a] */
    /* JADX WARN: Type inference failed for: r9v19 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v25 */
    /* JADX WARN: Type inference failed for: r9v3, types: [t3.x] */
    /* JADX WARN: Type inference failed for: r9v31 */
    /* JADX WARN: Type inference failed for: r9v32 */
    /* JADX WARN: Type inference failed for: r9v33 */
    /* JADX WARN: Type inference failed for: r9v34 */
    /* JADX WARN: Type inference failed for: r9v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object t(S.w.a r9, Z2.e r10) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S.C0525k.t(S.w$a, Z2.e):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object u(Z2.e r12) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r12 instanceof S.C0525k.h
            if (r0 == 0) goto L13
            r0 = r12
            S.k$h r0 = (S.C0525k.h) r0
            int r1 = r0.f3703e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3703e = r1
            goto L18
        L13:
            S.k$h r0 = new S.k$h
            r0.<init>(r12)
        L18:
            java.lang.Object r12 = r0.f3701c
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f3703e
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r1 = r0.f3700b
            C3.a r1 = (C3.a) r1
            java.lang.Object r0 = r0.f3699a
            S.k r0 = (S.C0525k) r0
            W2.q.b(r12)
            goto L4e
        L32:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L3a:
            W2.q.b(r12)
            C3.a r12 = r11.f3632e
            r0.f3699a = r11
            r0.f3700b = r12
            r0.f3703e = r3
            java.lang.Object r0 = r12.d(r4, r0)
            if (r0 != r1) goto L4c
            return r1
        L4c:
            r0 = r11
            r1 = r12
        L4e:
            int r12 = r0.f3633f     // Catch: java.lang.Throwable -> L67
            int r12 = r12 + r3
            r0.f3633f = r12     // Catch: java.lang.Throwable -> L67
            if (r12 != r3) goto L6a
            t3.L r5 = r0.f3630c     // Catch: java.lang.Throwable -> L67
            S.k$i r8 = new S.k$i     // Catch: java.lang.Throwable -> L67
            r8.<init>(r4)     // Catch: java.lang.Throwable -> L67
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            t3.w0 r12 = t3.AbstractC1818i.d(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L67
            r0.f3634g = r12     // Catch: java.lang.Throwable -> L67
            goto L6a
        L67:
            r0 = move-exception
            r12 = r0
            goto L72
        L6a:
            W2.E r12 = W2.E.f5463a     // Catch: java.lang.Throwable -> L67
            r1.c(r4)
            W2.E r12 = W2.E.f5463a
            return r12
        L72:
            r1.c(r4)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: S.C0525k.u(Z2.e):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0069, code lost:
    
        if (r4.c(r0) == r1) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object v(Z2.e r6) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r6 instanceof S.C0525k.j
            if (r0 == 0) goto L13
            r0 = r6
            S.k$j r0 = (S.C0525k.j) r0
            int r1 = r0.f3711e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f3711e = r1
            goto L18
        L13:
            S.k$j r0 = new S.k$j
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f3709c
            java.lang.Object r1 = a3.AbstractC0787c.e()
            int r2 = r0.f3711e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3c
            if (r2 != r3) goto L34
            int r1 = r0.f3708b
            java.lang.Object r0 = r0.f3707a
            S.k r0 = (S.C0525k) r0
            W2.q.b(r6)     // Catch: java.lang.Throwable -> L32
            goto L6c
        L32:
            r6 = move-exception
            goto L73
        L34:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L3c:
            java.lang.Object r2 = r0.f3707a
            S.k r2 = (S.C0525k) r2
            W2.q.b(r6)
            goto L57
        L44:
            W2.q.b(r6)
            S.t r6 = r5.r()
            r0.f3707a = r5
            r0.f3711e = r4
            java.lang.Object r6 = r6.c(r0)
            if (r6 != r1) goto L56
            goto L6b
        L56:
            r2 = r5
        L57:
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            S.k$b r4 = r2.f3636i     // Catch: java.lang.Throwable -> L6f
            r0.f3707a = r2     // Catch: java.lang.Throwable -> L6f
            r0.f3708b = r6     // Catch: java.lang.Throwable -> L6f
            r0.f3711e = r3     // Catch: java.lang.Throwable -> L6f
            java.lang.Object r6 = r4.c(r0)     // Catch: java.lang.Throwable -> L6f
            if (r6 != r1) goto L6c
        L6b:
            return r1
        L6c:
            W2.E r6 = W2.E.f5463a
            return r6
        L6f:
            r0 = move-exception
            r1 = r6
            r6 = r0
            r0 = r2
        L73:
            S.l r0 = r0.f3635h
            S.x r2 = new S.x
            r2.<init>(r6, r1)
            r0.c(r2)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: S.C0525k.v(Z2.e):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a7, code lost:
    
        if (r11 == r1) goto L39;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c0, code lost:
    
        if (r11 == r1) goto L39;
     */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object w(boolean r10, Z2.e r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S.C0525k.w(boolean, Z2.e):java.lang.Object");
    }

    public final Object x(Z2.e eVar) {
        return G.a(s(), eVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object y(boolean r10, Z2.e r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: S.C0525k.y(boolean, Z2.e):java.lang.Object");
    }

    public final Object z(boolean z4, Z2.e eVar) {
        return AbstractC1818i.g(this.f3630c.l(), new q(z4, null), eVar);
    }
}
