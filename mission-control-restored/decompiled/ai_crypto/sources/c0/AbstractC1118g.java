package c0;

import E5.E;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: renamed from: c0.g, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1118g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9118a = new a(null);

    /* JADX INFO: renamed from: c0.g$a */
    public static final class a {

        /* JADX INFO: renamed from: c0.g$a$a, reason: collision with other inner class name */
        public static final class C0153a extends J5.l implements Q5.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f9119a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f9120b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ List f9121c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0153a(List list, H5.d dVar) {
                super(2, dVar);
                this.f9121c = list;
            }

            @Override // J5.a
            public final H5.d create(Object obj, H5.d dVar) {
                C0153a c0153a = new C0153a(this.f9121c, dVar);
                c0153a.f9120b = obj;
                return c0153a;
            }

            @Override // Q5.o
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(m mVar, H5.d dVar) {
                return ((C0153a) create(mVar, dVar)).invokeSuspend(E.f1657a);
            }

            @Override // J5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objE = I5.c.e();
                int i7 = this.f9119a;
                if (i7 == 0) {
                    E5.q.b(obj);
                    m mVar = (m) this.f9120b;
                    a aVar = AbstractC1118g.f9118a;
                    List list = this.f9121c;
                    this.f9119a = 1;
                    if (aVar.c(list, mVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    E5.q.b(obj);
                }
                return E.f1657a;
            }
        }

        /* JADX INFO: renamed from: c0.g$a$b */
        public static final class b extends J5.d {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f9122a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f9123b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public /* synthetic */ Object f9124c;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f9126e;

            public b(H5.d dVar) {
                super(dVar);
            }

            @Override // J5.a
            public final Object invokeSuspend(Object obj) {
                this.f9124c = obj;
                this.f9126e |= Integer.MIN_VALUE;
                return a.this.c(null, null, this);
            }
        }

        /* JADX INFO: renamed from: c0.g$a$c */
        public static final class c extends J5.l implements Q5.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public Object f9127a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public Object f9128b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Object f9129c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f9130d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public /* synthetic */ Object f9131e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public final /* synthetic */ List f9132f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public final /* synthetic */ List f9133g;

            /* JADX INFO: renamed from: c0.g$a$c$a, reason: collision with other inner class name */
            public static final class C0154a extends J5.l implements Q5.k {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public int f9134a;

                public C0154a(InterfaceC1117f interfaceC1117f, H5.d dVar) {
                    super(1, dVar);
                }

                @Override // J5.a
                public final H5.d create(H5.d dVar) {
                    return new C0154a(null, dVar);
                }

                @Override // Q5.k
                /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
                public final Object invoke(H5.d dVar) {
                    return ((C0154a) create(dVar)).invokeSuspend(E.f1657a);
                }

                @Override // J5.a
                public final Object invokeSuspend(Object obj) throws Throwable {
                    I5.c.e();
                    int i7 = this.f9134a;
                    if (i7 == 0) {
                        E5.q.b(obj);
                        this.f9134a = 1;
                        throw null;
                    }
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    E5.q.b(obj);
                    return E.f1657a;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public c(List list, List list2, H5.d dVar) {
                super(2, dVar);
                this.f9132f = list;
                this.f9133g = list2;
            }

            @Override // J5.a
            public final H5.d create(Object obj, H5.d dVar) {
                c cVar = new c(this.f9132f, this.f9133g, dVar);
                cVar.f9131e = obj;
                return cVar;
            }

            @Override // Q5.o
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(Object obj, H5.d dVar) {
                return ((c) create(obj, dVar)).invokeSuspend(E.f1657a);
            }

            @Override // J5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                List list;
                Iterator it;
                I5.c.e();
                int i7 = this.f9130d;
                if (i7 == 0) {
                    E5.q.b(obj);
                    obj = this.f9131e;
                    List list2 = this.f9132f;
                    list = this.f9133g;
                    it = list2.iterator();
                } else if (i7 == 1) {
                    Object obj2 = this.f9129c;
                    android.support.v4.media.session.b.a(this.f9128b);
                    Iterator it2 = (Iterator) this.f9127a;
                    List list3 = (List) this.f9131e;
                    E5.q.b(obj);
                    if (((Boolean) obj).booleanValue()) {
                        list3.add(new C0154a(null, null));
                        this.f9131e = list3;
                        this.f9127a = it2;
                        this.f9128b = null;
                        this.f9129c = null;
                        this.f9130d = 2;
                        throw null;
                    }
                    obj = obj2;
                    it = it2;
                    list = list3;
                } else {
                    if (i7 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    it = (Iterator) this.f9127a;
                    list = (List) this.f9131e;
                    E5.q.b(obj);
                }
                if (!it.hasNext()) {
                    return obj;
                }
                android.support.v4.media.session.b.a(it.next());
                this.f9131e = list;
                this.f9127a = it;
                this.f9128b = null;
                this.f9129c = obj;
                this.f9130d = 1;
                throw null;
            }
        }

        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public final Q5.o b(List migrations) {
            kotlin.jvm.internal.r.f(migrations, "migrations");
            return new C0153a(migrations, null);
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
        public final java.lang.Object c(java.util.List r7, c0.m r8, H5.d r9) throws java.lang.Throwable {
            /*
                r6 = this;
                boolean r0 = r9 instanceof c0.AbstractC1118g.a.b
                if (r0 == 0) goto L13
                r0 = r9
                c0.g$a$b r0 = (c0.AbstractC1118g.a.b) r0
                int r1 = r0.f9126e
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f9126e = r1
                goto L18
            L13:
                c0.g$a$b r0 = new c0.g$a$b
                r0.<init>(r9)
            L18:
                java.lang.Object r9 = r0.f9124c
                java.lang.Object r1 = I5.c.e()
                int r2 = r0.f9126e
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L46
                if (r2 == r4) goto L3e
                if (r2 != r3) goto L36
                java.lang.Object r7 = r0.f9123b
                java.util.Iterator r7 = (java.util.Iterator) r7
                java.lang.Object r8 = r0.f9122a
                kotlin.jvm.internal.G r8 = (kotlin.jvm.internal.G) r8
                E5.q.b(r9)     // Catch: java.lang.Throwable -> L34
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
                java.lang.Object r7 = r0.f9122a
                java.util.List r7 = (java.util.List) r7
                E5.q.b(r9)
                goto L60
            L46:
                E5.q.b(r9)
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                c0.g$a$c r2 = new c0.g$a$c
                r5 = 0
                r2.<init>(r7, r9, r5)
                r0.f9122a = r9
                r0.f9126e = r4
                java.lang.Object r7 = r8.a(r2, r0)
                if (r7 != r1) goto L5f
                return r1
            L5f:
                r7 = r9
            L60:
                kotlin.jvm.internal.G r8 = new kotlin.jvm.internal.G
                r8.<init>()
                java.util.Iterator r7 = r7.iterator()
            L69:
                boolean r9 = r7.hasNext()
                if (r9 == 0) goto L92
                java.lang.Object r9 = r7.next()
                Q5.k r9 = (Q5.k) r9
                r0.f9122a = r8     // Catch: java.lang.Throwable -> L34
                r0.f9123b = r7     // Catch: java.lang.Throwable -> L34
                r0.f9126e = r3     // Catch: java.lang.Throwable -> L34
                java.lang.Object r9 = r9.invoke(r0)     // Catch: java.lang.Throwable -> L34
                if (r9 != r1) goto L69
                return r1
            L82:
                java.lang.Object r2 = r8.f18249a
                if (r2 != 0) goto L89
                r8.f18249a = r9
                goto L69
            L89:
                kotlin.jvm.internal.r.c(r2)
                java.lang.Throwable r2 = (java.lang.Throwable) r2
                E5.AbstractC0460e.a(r2, r9)
                goto L69
            L92:
                java.lang.Object r7 = r8.f18249a
                java.lang.Throwable r7 = (java.lang.Throwable) r7
                if (r7 != 0) goto L9b
                E5.E r7 = E5.E.f1657a
                return r7
            L9b:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: c0.AbstractC1118g.a.c(java.util.List, c0.m, H5.d):java.lang.Object");
        }

        public a() {
        }
    }
}
