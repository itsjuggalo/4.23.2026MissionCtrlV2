package b0;

import java.util.List;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2491s;
import o5.C2470H;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;
import u5.AbstractC2777d;
import u5.AbstractC2785l;

/* JADX INFO: renamed from: b0.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1177h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12599a = new a(null);

    /* JADX INFO: renamed from: b0.h$a */
    public static final class a {

        /* JADX INFO: renamed from: b0.h$a$a, reason: collision with other inner class name */
        public static final class C0209a extends AbstractC2785l implements B5.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f12600a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f12601b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ List f12602c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0209a(List list, InterfaceC2707e interfaceC2707e) {
                super(2, interfaceC2707e);
                this.f12602c = list;
            }

            @Override // B5.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(s sVar, InterfaceC2707e interfaceC2707e) {
                return ((C0209a) create(sVar, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
            }

            @Override // u5.AbstractC2774a
            public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
                C0209a c0209a = new C0209a(this.f12602c, interfaceC2707e);
                c0209a.f12601b = obj;
                return c0209a;
            }

            @Override // u5.AbstractC2774a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = AbstractC2751c.f();
                int i8 = this.f12600a;
                if (i8 == 0) {
                    AbstractC2491s.b(obj);
                    s sVar = (s) this.f12601b;
                    a aVar = AbstractC1177h.f12599a;
                    List list = this.f12602c;
                    this.f12600a = 1;
                    if (aVar.c(list, sVar, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC2491s.b(obj);
                }
                return C2470H.f21956a;
            }
        }

        /* JADX INFO: renamed from: b0.h$a$b */
        public static final class b extends AbstractC2777d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f12603a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f12604b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public /* synthetic */ Object f12605c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f12607e;

            public b(InterfaceC2707e interfaceC2707e) {
                super(interfaceC2707e);
            }

            @Override // u5.AbstractC2774a
            public final Object invokeSuspend(Object obj) {
                this.f12605c = obj;
                this.f12607e |= Integer.MIN_VALUE;
                return a.this.c(null, null, this);
            }
        }

        /* JADX INFO: renamed from: b0.h$a$c */
        public static final class c extends AbstractC2785l implements B5.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f12608a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f12609b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object f12610c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f12611d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public /* synthetic */ Object f12612e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ List f12613f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ List f12614g;

            /* JADX INFO: renamed from: b0.h$a$c$a, reason: collision with other inner class name */
            public static final class C0210a extends AbstractC2785l implements B5.k {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f12615a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public final /* synthetic */ InterfaceC1176g f12616b;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C0210a(InterfaceC1176g interfaceC1176g, InterfaceC2707e interfaceC2707e) {
                    super(1, interfaceC2707e);
                    this.f12616b = interfaceC1176g;
                }

                @Override // B5.k
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object invoke(InterfaceC2707e interfaceC2707e) {
                    return ((C0210a) create(interfaceC2707e)).invokeSuspend(C2470H.f21956a);
                }

                @Override // u5.AbstractC2774a
                public final InterfaceC2707e create(InterfaceC2707e interfaceC2707e) {
                    return new C0210a(this.f12616b, interfaceC2707e);
                }

                @Override // u5.AbstractC2774a
                public final Object invokeSuspend(Object obj) throws Throwable {
                    Object objF = AbstractC2751c.f();
                    int i8 = this.f12615a;
                    if (i8 == 0) {
                        AbstractC2491s.b(obj);
                        InterfaceC1176g interfaceC1176g = this.f12616b;
                        this.f12615a = 1;
                        if (interfaceC1176g.b(this) == objF) {
                            return objF;
                        }
                    } else {
                        if (i8 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        AbstractC2491s.b(obj);
                    }
                    return C2470H.f21956a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(List list, List list2, InterfaceC2707e interfaceC2707e) {
                super(2, interfaceC2707e);
                this.f12613f = list;
                this.f12614g = list2;
            }

            @Override // B5.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, InterfaceC2707e interfaceC2707e) {
                return ((c) create(obj, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
            }

            @Override // u5.AbstractC2774a
            public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
                c cVar = new c(this.f12613f, this.f12614g, interfaceC2707e);
                cVar.f12612e = obj;
                return cVar;
            }

            /* JADX WARN: Removed duplicated region for block: B:13:0x004a  */
            /* JADX WARN: Removed duplicated region for block: B:19:0x006e  */
            /* JADX WARN: Removed duplicated region for block: B:23:0x008a  */
            /* JADX WARN: Removed duplicated region for block: B:24:0x008c A[RETURN] */
            @Override // u5.AbstractC2774a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
                /*
                    r9 = this;
                    java.lang.Object r0 = t5.AbstractC2751c.f()
                    int r1 = r9.f12611d
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L37
                    if (r1 == r3) goto L22
                    if (r1 != r2) goto L1a
                    java.lang.Object r1 = r9.f12608a
                    java.util.Iterator r1 = (java.util.Iterator) r1
                    java.lang.Object r4 = r9.f12612e
                    java.util.List r4 = (java.util.List) r4
                    o5.AbstractC2491s.b(r10)
                    goto L44
                L1a:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r0)
                    throw r10
                L22:
                    java.lang.Object r1 = r9.f12610c
                    java.lang.Object r4 = r9.f12609b
                    b0.g r4 = (b0.InterfaceC1176g) r4
                    java.lang.Object r5 = r9.f12608a
                    java.util.Iterator r5 = (java.util.Iterator) r5
                    java.lang.Object r6 = r9.f12612e
                    java.util.List r6 = (java.util.List) r6
                    o5.AbstractC2491s.b(r10)
                    r8 = r6
                    r6 = r4
                    r4 = r8
                    goto L66
                L37:
                    o5.AbstractC2491s.b(r10)
                    java.lang.Object r10 = r9.f12612e
                    java.util.List r1 = r9.f12613f
                    java.util.List r4 = r9.f12614g
                    java.util.Iterator r1 = r1.iterator()
                L44:
                    boolean r5 = r1.hasNext()
                    if (r5 == 0) goto L8c
                    java.lang.Object r5 = r1.next()
                    b0.g r5 = (b0.InterfaceC1176g) r5
                    r9.f12612e = r4
                    r9.f12608a = r1
                    r9.f12609b = r5
                    r9.f12610c = r10
                    r9.f12611d = r3
                    java.lang.Object r6 = r5.c(r10, r9)
                    if (r6 != r0) goto L61
                    return r0
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
                    b0.h$a$c$a r10 = new b0.h$a$c$a
                    r7 = 0
                    r10.<init>(r6, r7)
                    r4.add(r10)
                    r9.f12612e = r4
                    r9.f12608a = r5
                    r9.f12609b = r7
                    r9.f12610c = r7
                    r9.f12611d = r2
                    java.lang.Object r10 = r6.a(r1, r9)
                    if (r10 != r0) goto L88
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
                throw new UnsupportedOperationException("Method not decompiled: b0.AbstractC1177h.a.c.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        public a() {
        }

        public final B5.o b(List migrations) {
            AbstractC2304t.f(migrations, "migrations");
            return new C0209a(migrations, null);
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
        public final java.lang.Object c(java.util.List r7, b0.s r8, s5.InterfaceC2707e r9) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r9 instanceof b0.AbstractC1177h.a.b
                if (r0 == 0) goto L13
                r0 = r9
                b0.h$a$b r0 = (b0.AbstractC1177h.a.b) r0
                int r1 = r0.f12607e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f12607e = r1
                goto L18
            L13:
                b0.h$a$b r0 = new b0.h$a$b
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.f12605c
                java.lang.Object r1 = t5.AbstractC2751c.f()
                int r2 = r0.f12607e
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L3e
                if (r2 != r3) goto L36
                java.lang.Object r7 = r0.f12604b
                java.util.Iterator r7 = (java.util.Iterator) r7
                java.lang.Object r8 = r0.f12603a
                kotlin.jvm.internal.N r8 = (kotlin.jvm.internal.N) r8
                o5.AbstractC2491s.b(r9)     // Catch: java.lang.Throwable -> L34
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
                java.lang.Object r7 = r0.f12603a
                java.util.List r7 = (java.util.List) r7
                o5.AbstractC2491s.b(r9)
                goto L60
            L46:
                o5.AbstractC2491s.b(r9)
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                b0.h$a$c r2 = new b0.h$a$c
                r5 = 0
                r2.<init>(r7, r9, r5)
                r0.f12603a = r9
                r0.f12607e = r4
                java.lang.Object r7 = r8.a(r2, r0)
                if (r7 != r1) goto L5f
                return r1
            L5f:
                r7 = r9
            L60:
                kotlin.jvm.internal.N r8 = new kotlin.jvm.internal.N
                r8.<init>()
                java.util.Iterator r7 = r7.iterator()
            L69:
                boolean r9 = r7.hasNext()
                if (r9 == 0) goto L92
                java.lang.Object r9 = r7.next()
                B5.k r9 = (B5.k) r9
                r0.f12603a = r8     // Catch: java.lang.Throwable -> L34
                r0.f12604b = r7     // Catch: java.lang.Throwable -> L34
                r0.f12607e = r3     // Catch: java.lang.Throwable -> L34
                java.lang.Object r9 = r9.invoke(r0)     // Catch: java.lang.Throwable -> L34
                if (r9 != r1) goto L69
                return r1
            L82:
                java.lang.Object r2 = r8.f20469a
                if (r2 != 0) goto L89
                r8.f20469a = r9
                goto L69
            L89:
                kotlin.jvm.internal.AbstractC2304t.c(r2)
                java.lang.Throwable r2 = (java.lang.Throwable) r2
                o5.AbstractC2477e.a(r2, r9)
                goto L69
            L92:
                java.lang.Object r7 = r8.f20469a
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 != 0) goto L9b
                o5.H r7 = o5.C2470H.f21956a
                return r7
            L9b:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: b0.AbstractC1177h.a.c(java.util.List, b0.s, s5.e):java.lang.Object");
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }
}
