package S;

import a3.AbstractC0787c;
import b3.AbstractC0866d;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: S.h, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0522h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3609a = new a(null);

    /* JADX INFO: renamed from: S.h$a */
    public static final class a {

        /* JADX INFO: renamed from: S.h$a$a, reason: collision with other inner class name */
        public static final class C0062a extends b3.l implements i3.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f3610a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f3611b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ List f3612c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0062a(List list, Z2.e eVar) {
                super(2, eVar);
                this.f3612c = list;
            }

            @Override // i3.o
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(s sVar, Z2.e eVar) {
                return ((C0062a) create(sVar, eVar)).invokeSuspend(W2.E.f5463a);
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                C0062a c0062a = new C0062a(this.f3612c, eVar);
                c0062a.f3611b = obj;
                return c0062a;
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = AbstractC0787c.e();
                int i4 = this.f3610a;
                if (i4 == 0) {
                    W2.q.b(obj);
                    s sVar = (s) this.f3611b;
                    a aVar = AbstractC0522h.f3609a;
                    List list = this.f3612c;
                    this.f3610a = 1;
                    if (aVar.c(list, sVar, this) == objE) {
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

        /* JADX INFO: renamed from: S.h$a$b */
        public static final class b extends AbstractC0866d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f3613a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f3614b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public /* synthetic */ Object f3615c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f3617e;

            public b(Z2.e eVar) {
                super(eVar);
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) {
                this.f3615c = obj;
                this.f3617e |= Integer.MIN_VALUE;
                return a.this.c(null, null, this);
            }
        }

        /* JADX INFO: renamed from: S.h$a$c */
        public static final class c extends b3.l implements i3.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f3618a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f3619b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object f3620c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f3621d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public /* synthetic */ Object f3622e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ List f3623f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ List f3624g;

            /* JADX INFO: renamed from: S.h$a$c$a, reason: collision with other inner class name */
            public static final class C0063a extends b3.l implements i3.k {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f3625a;

                public C0063a(InterfaceC0521g interfaceC0521g, Z2.e eVar) {
                    super(1, eVar);
                }

                @Override // i3.k
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public final Object invoke(Z2.e eVar) {
                    return ((C0063a) create(eVar)).invokeSuspend(W2.E.f5463a);
                }

                @Override // b3.AbstractC0863a
                public final Z2.e create(Z2.e eVar) {
                    return new C0063a(null, eVar);
                }

                @Override // b3.AbstractC0863a
                public final Object invokeSuspend(Object obj) throws Throwable {
                    AbstractC0787c.e();
                    int i4 = this.f3625a;
                    if (i4 == 0) {
                        W2.q.b(obj);
                        this.f3625a = 1;
                        throw null;
                    }
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    W2.q.b(obj);
                    return W2.E.f5463a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(List list, List list2, Z2.e eVar) {
                super(2, eVar);
                this.f3623f = list;
                this.f3624g = list2;
            }

            @Override // i3.o
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, Z2.e eVar) {
                return ((c) create(obj, eVar)).invokeSuspend(W2.E.f5463a);
            }

            @Override // b3.AbstractC0863a
            public final Z2.e create(Object obj, Z2.e eVar) {
                c cVar = new c(this.f3623f, this.f3624g, eVar);
                cVar.f3622e = obj;
                return cVar;
            }

            @Override // b3.AbstractC0863a
            public final Object invokeSuspend(Object obj) throws Throwable {
                List list;
                Iterator it;
                AbstractC0787c.e();
                int i4 = this.f3621d;
                if (i4 == 0) {
                    W2.q.b(obj);
                    obj = this.f3622e;
                    List list2 = this.f3623f;
                    list = this.f3624g;
                    it = list2.iterator();
                } else if (i4 == 1) {
                    Object obj2 = this.f3620c;
                    android.support.v4.media.session.b.a(this.f3619b);
                    Iterator it2 = (Iterator) this.f3618a;
                    List list3 = (List) this.f3622e;
                    W2.q.b(obj);
                    if (((Boolean) obj).booleanValue()) {
                        list3.add(new C0063a(null, null));
                        this.f3622e = list3;
                        this.f3618a = it2;
                        this.f3619b = null;
                        this.f3620c = null;
                        this.f3621d = 2;
                        throw null;
                    }
                    obj = obj2;
                    it = it2;
                    list = list3;
                } else {
                    if (i4 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) this.f3618a;
                    list = (List) this.f3622e;
                    W2.q.b(obj);
                }
                if (!it.hasNext()) {
                    return obj;
                }
                android.support.v4.media.session.b.a(it.next());
                this.f3622e = list;
                this.f3618a = it;
                this.f3619b = null;
                this.f3620c = obj;
                this.f3621d = 1;
                throw null;
            }
        }

        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public final i3.o b(List migrations) {
            kotlin.jvm.internal.r.f(migrations, "migrations");
            return new C0062a(migrations, null);
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
        public final java.lang.Object c(java.util.List r7, S.s r8, Z2.e r9) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r9 instanceof S.AbstractC0522h.a.b
                if (r0 == 0) goto L13
                r0 = r9
                S.h$a$b r0 = (S.AbstractC0522h.a.b) r0
                int r1 = r0.f3617e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f3617e = r1
                goto L18
            L13:
                S.h$a$b r0 = new S.h$a$b
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.f3615c
                java.lang.Object r1 = a3.AbstractC0787c.e()
                int r2 = r0.f3617e
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L3e
                if (r2 != r3) goto L36
                java.lang.Object r7 = r0.f3614b
                java.util.Iterator r7 = (java.util.Iterator) r7
                java.lang.Object r8 = r0.f3613a
                kotlin.jvm.internal.F r8 = (kotlin.jvm.internal.F) r8
                W2.q.b(r9)     // Catch: java.lang.Throwable -> L34
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
                java.lang.Object r7 = r0.f3613a
                java.util.List r7 = (java.util.List) r7
                W2.q.b(r9)
                goto L60
            L46:
                W2.q.b(r9)
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                S.h$a$c r2 = new S.h$a$c
                r5 = 0
                r2.<init>(r7, r9, r5)
                r0.f3613a = r9
                r0.f3617e = r4
                java.lang.Object r7 = r8.a(r2, r0)
                if (r7 != r1) goto L5f
                goto L81
            L5f:
                r7 = r9
            L60:
                kotlin.jvm.internal.F r8 = new kotlin.jvm.internal.F
                r8.<init>()
                java.util.Iterator r7 = r7.iterator()
            L69:
                boolean r9 = r7.hasNext()
                if (r9 == 0) goto L92
                java.lang.Object r9 = r7.next()
                i3.k r9 = (i3.k) r9
                r0.f3613a = r8     // Catch: java.lang.Throwable -> L34
                r0.f3614b = r7     // Catch: java.lang.Throwable -> L34
                r0.f3617e = r3     // Catch: java.lang.Throwable -> L34
                java.lang.Object r9 = r9.invoke(r0)     // Catch: java.lang.Throwable -> L34
                if (r9 != r1) goto L69
            L81:
                return r1
            L82:
                java.lang.Object r2 = r8.f13410a
                if (r2 != 0) goto L89
                r8.f13410a = r9
                goto L69
            L89:
                kotlin.jvm.internal.r.c(r2)
                java.lang.Throwable r2 = (java.lang.Throwable) r2
                W2.AbstractC0737e.a(r2, r9)
                goto L69
            L92:
                java.lang.Object r7 = r8.f13410a
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 != 0) goto L9b
                W2.E r7 = W2.E.f5463a
                return r7
            L9b:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: S.AbstractC0522h.a.c(java.util.List, S.s, Z2.e):java.lang.Object");
        }

        public a() {
        }
    }
}
