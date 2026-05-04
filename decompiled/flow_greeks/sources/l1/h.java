package l1;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f15023a = new a(null);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: l1.h$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0262a extends id.m implements pd.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f15024a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f15025b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ List f15026c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0262a(List list, gd.e eVar) {
                super(2, eVar);
                this.f15026c = list;
            }

            @Override // pd.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(s sVar, gd.e eVar) {
                return ((C0262a) create(sVar, eVar)).invokeSuspend(cd.h0.f3852a);
            }

            @Override // id.a
            public final gd.e create(Object obj, gd.e eVar) {
                C0262a c0262a = new C0262a(this.f15026c, eVar);
                c0262a.f15025b = obj;
                return c0262a;
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = hd.c.f();
                int i10 = this.f15024a;
                if (i10 == 0) {
                    cd.s.b(obj);
                    s sVar = (s) this.f15025b;
                    a aVar = h.f15023a;
                    List list = this.f15026c;
                    this.f15024a = 1;
                    if (aVar.c(list, sVar, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    cd.s.b(obj);
                }
                return cd.h0.f3852a;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class b extends id.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f15027a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f15028b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public /* synthetic */ Object f15029c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f15031e;

            public b(gd.e eVar) {
                super(eVar);
            }

            @Override // id.a
            public final Object invokeSuspend(Object obj) {
                this.f15029c = obj;
                this.f15031e |= Integer.MIN_VALUE;
                return a.this.c(null, null, this);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class c extends id.m implements pd.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f15032a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f15033b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object f15034c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f15035d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public /* synthetic */ Object f15036e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ List f15037f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ List f15038g;

            /* JADX INFO: renamed from: l1.h$a$c$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static final class C0263a extends id.m implements pd.k {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f15039a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ g f15040b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0263a(g gVar, gd.e eVar) {
                    super(1, eVar);
                    this.f15040b = gVar;
                }

                @Override // pd.k
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(gd.e eVar) {
                    return ((C0263a) create(eVar)).invokeSuspend(cd.h0.f3852a);
                }

                @Override // id.a
                public final gd.e create(gd.e eVar) {
                    return new C0263a(this.f15040b, eVar);
                }

                @Override // id.a
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = hd.c.f();
                    int i10 = this.f15039a;
                    if (i10 == 0) {
                        cd.s.b(obj);
                        g gVar = this.f15040b;
                        this.f15039a = 1;
                        if (gVar.a(this) == objF) {
                            return objF;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        cd.s.b(obj);
                    }
                    return cd.h0.f3852a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(List list, List list2, gd.e eVar) {
                super(2, eVar);
                this.f15037f = list;
                this.f15038g = list2;
            }

            @Override // pd.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, gd.e eVar) {
                return ((c) create(obj, eVar)).invokeSuspend(cd.h0.f3852a);
            }

            @Override // id.a
            public final gd.e create(Object obj, gd.e eVar) {
                c cVar = new c(this.f15037f, this.f15038g, eVar);
                cVar.f15036e = obj;
                return cVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x008c A[RETURN] */
            @Override // id.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
                /*
                    r9 = this;
                    java.lang.Object r0 = hd.c.f()
                    int r1 = r9.f15035d
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L37
                    if (r1 == r3) goto L22
                    if (r1 != r2) goto L1a
                    java.lang.Object r1 = r9.f15032a
                    java.util.Iterator r1 = (java.util.Iterator) r1
                    java.lang.Object r4 = r9.f15036e
                    java.util.List r4 = (java.util.List) r4
                    cd.s.b(r10)
                    goto L44
                L1a:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r0)
                    throw r10
                L22:
                    java.lang.Object r1 = r9.f15034c
                    java.lang.Object r4 = r9.f15033b
                    l1.g r4 = (l1.g) r4
                    java.lang.Object r5 = r9.f15032a
                    java.util.Iterator r5 = (java.util.Iterator) r5
                    java.lang.Object r6 = r9.f15036e
                    java.util.List r6 = (java.util.List) r6
                    cd.s.b(r10)
                    r8 = r6
                    r6 = r4
                    r4 = r8
                    goto L66
                L37:
                    cd.s.b(r10)
                    java.lang.Object r10 = r9.f15036e
                    java.util.List r1 = r9.f15037f
                    java.util.List r4 = r9.f15038g
                    java.util.Iterator r1 = r1.iterator()
                L44:
                    boolean r5 = r1.hasNext()
                    if (r5 == 0) goto L8c
                    java.lang.Object r5 = r1.next()
                    l1.g r5 = (l1.g) r5
                    r9.f15036e = r4
                    r9.f15032a = r1
                    r9.f15033b = r5
                    r9.f15034c = r10
                    r9.f15035d = r3
                    java.lang.Object r6 = r5.c(r10, r9)
                    if (r6 != r0) goto L61
                    goto L87
                L61:
                    r8 = r1
                    r1 = r10
                    r10 = r6
                    r6 = r5
                    r5 = r8
                L66:
                    java.lang.Boolean r10 = (java.lang.Boolean) r10
                    boolean r10 = r10.booleanValue()
                    if (r10 == 0) goto L8a
                    l1.h$a$c$a r10 = new l1.h$a$c$a
                    r7 = 0
                    r10.<init>(r6, r7)
                    r4.add(r10)
                    r9.f15036e = r4
                    r9.f15032a = r5
                    r9.f15033b = r7
                    r9.f15034c = r7
                    r9.f15035d = r2
                    java.lang.Object r10 = r6.b(r1, r9)
                    if (r10 != r0) goto L88
                L87:
                    return r0
                L88:
                    r1 = r5
                    goto L44
                L8a:
                    r10 = r1
                    goto L88
                L8c:
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: l1.h.a.c.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final pd.o b(List migrations) {
            kotlin.jvm.internal.t.f(migrations, "migrations");
            return new C0262a(migrations, null);
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x006f  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0098  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0086 -> B:25:0x0069). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0089 -> B:25:0x0069). Please report as a decompilation issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object c(java.util.List r7, l1.s r8, gd.e r9) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r9 instanceof l1.h.a.b
                if (r0 == 0) goto L13
                r0 = r9
                l1.h$a$b r0 = (l1.h.a.b) r0
                int r1 = r0.f15031e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f15031e = r1
                goto L18
            L13:
                l1.h$a$b r0 = new l1.h$a$b
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.f15029c
                java.lang.Object r1 = hd.c.f()
                int r2 = r0.f15031e
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L3e
                if (r2 != r3) goto L36
                java.lang.Object r7 = r0.f15028b
                java.util.Iterator r7 = (java.util.Iterator) r7
                java.lang.Object r8 = r0.f15027a
                kotlin.jvm.internal.m0 r8 = (kotlin.jvm.internal.m0) r8
                cd.s.b(r9)     // Catch: java.lang.Throwable -> L34
                goto L69
            L34:
                r9 = move-exception
                goto L82
            L36:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L3e:
                java.lang.Object r7 = r0.f15027a
                java.util.List r7 = (java.util.List) r7
                cd.s.b(r9)
                goto L60
            L46:
                cd.s.b(r9)
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                l1.h$a$c r2 = new l1.h$a$c
                r5 = 0
                r2.<init>(r7, r9, r5)
                r0.f15027a = r9
                r0.f15031e = r4
                java.lang.Object r7 = r8.a(r2, r0)
                if (r7 != r1) goto L5f
                goto L81
            L5f:
                r7 = r9
            L60:
                kotlin.jvm.internal.m0 r8 = new kotlin.jvm.internal.m0
                r8.<init>()
                java.util.Iterator r7 = r7.iterator()
            L69:
                boolean r9 = r7.hasNext()
                if (r9 == 0) goto L92
                java.lang.Object r9 = r7.next()
                pd.k r9 = (pd.k) r9
                r0.f15027a = r8     // Catch: java.lang.Throwable -> L34
                r0.f15028b = r7     // Catch: java.lang.Throwable -> L34
                r0.f15031e = r3     // Catch: java.lang.Throwable -> L34
                java.lang.Object r9 = r9.invoke(r0)     // Catch: java.lang.Throwable -> L34
                if (r9 != r1) goto L69
            L81:
                return r1
            L82:
                java.lang.Object r2 = r8.f14947a
                if (r2 != 0) goto L89
                r8.f14947a = r9
                goto L69
            L89:
                kotlin.jvm.internal.t.c(r2)
                java.lang.Throwable r2 = (java.lang.Throwable) r2
                cd.e.a(r2, r9)
                goto L69
            L92:
                java.lang.Object r7 = r8.f14947a
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 != 0) goto L9b
                cd.h0 r7 = cd.h0.f3852a
                return r7
            L9b:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: l1.h.a.c(java.util.List, l1.s, gd.e):java.lang.Object");
        }

        public a() {
        }
    }
}
