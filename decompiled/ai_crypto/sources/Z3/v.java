package Z3;

import android.util.Log;
import b6.AbstractC1077k;
import c0.InterfaceC1119h;
import g0.C1631c;
import g0.f;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes.dex */
public final class v implements com.google.firebase.sessions.h {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f5977f = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final H5.g f5978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC1119h f5979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f5980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e6.d f5981e;

    public static final class a extends J5.l implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5982a;

        /* JADX INFO: renamed from: Z3.v$a$a, reason: collision with other inner class name */
        public static final class C0108a implements e6.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ v f5984a;

            public C0108a(v vVar) {
                this.f5984a = vVar;
            }

            @Override // e6.e
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public final Object d(C0793m c0793m, H5.d dVar) {
                this.f5984a.f5980d.set(c0793m);
                return E5.E.f1657a;
            }
        }

        public a(H5.d dVar) {
            super(2, dVar);
        }

        @Override // J5.a
        public final H5.d create(Object obj, H5.d dVar) {
            return v.this.new a(dVar);
        }

        @Override // Q5.o
        public final Object invoke(b6.L l7, H5.d dVar) {
            return ((a) create(l7, dVar)).invokeSuspend(E5.E.f1657a);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = I5.c.e();
            int i7 = this.f5982a;
            if (i7 == 0) {
                E5.q.b(obj);
                e6.d dVar = v.this.f5981e;
                C0108a c0108a = new C0108a(v.this);
                this.f5982a = 1;
                if (dVar.b(c0108a, this) == objE) {
                    return objE;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                E5.q.b(obj);
            }
            return E5.E.f1657a;
        }
    }

    public static final class b {
        public /* synthetic */ b(AbstractC2148j abstractC2148j) {
            this();
        }

        public b() {
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f5985a = new c();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final f.a f5986b = g0.h.g("session_id");

        public final f.a a() {
            return f5986b;
        }
    }

    public static final class d extends J5.l implements Q5.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f5988b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public /* synthetic */ Object f5989c;

        public d(H5.d dVar) {
            super(3, dVar);
        }

        @Override // Q5.p
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(e6.e eVar, Throwable th, H5.d dVar) {
            d dVar2 = new d(dVar);
            dVar2.f5988b = eVar;
            dVar2.f5989c = th;
            return dVar2.invokeSuspend(E5.E.f1657a);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = I5.c.e();
            int i7 = this.f5987a;
            if (i7 == 0) {
                E5.q.b(obj);
                e6.e eVar = (e6.e) this.f5988b;
                Log.e("FirebaseSessionsRepo", "Error reading stored session data.", (Throwable) this.f5989c);
                g0.f fVarA = g0.g.a();
                this.f5988b = null;
                this.f5987a = 1;
                if (eVar.d(fVarA, this) == objE) {
                    return objE;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                E5.q.b(obj);
            }
            return E5.E.f1657a;
        }
    }

    public static final class e implements e6.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e6.d f5990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ v f5991b;

        public static final class a implements e6.e {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ e6.e f5992a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ v f5993b;

            /* JADX INFO: renamed from: Z3.v$e$a$a, reason: collision with other inner class name */
            public static final class C0109a extends J5.d {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public /* synthetic */ Object f5994a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public int f5995b;

                public C0109a(H5.d dVar) {
                    super(dVar);
                }

                @Override // J5.a
                public final Object invokeSuspend(Object obj) {
                    this.f5994a = obj;
                    this.f5995b |= Integer.MIN_VALUE;
                    return a.this.d(null, this);
                }
            }

            public a(e6.e eVar, v vVar) {
                this.f5992a = eVar;
                this.f5993b = vVar;
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
                    boolean r0 = r6 instanceof Z3.v.e.a.C0109a
                    if (r0 == 0) goto L13
                    r0 = r6
                    Z3.v$e$a$a r0 = (Z3.v.e.a.C0109a) r0
                    int r1 = r0.f5995b
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L13
                    int r1 = r1 - r2
                    r0.f5995b = r1
                    goto L18
                L13:
                    Z3.v$e$a$a r0 = new Z3.v$e$a$a
                    r0.<init>(r6)
                L18:
                    java.lang.Object r6 = r0.f5994a
                    java.lang.Object r1 = I5.c.e()
                    int r2 = r0.f5995b
                    r3 = 1
                    if (r2 == 0) goto L31
                    if (r2 != r3) goto L29
                    E5.q.b(r6)
                    goto L47
                L29:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L31:
                    E5.q.b(r6)
                    e6.e r6 = r4.f5992a
                    g0.f r5 = (g0.f) r5
                    Z3.v r2 = r4.f5993b
                    Z3.m r5 = Z3.v.f(r2, r5)
                    r0.f5995b = r3
                    java.lang.Object r5 = r6.d(r5, r0)
                    if (r5 != r1) goto L47
                    return r1
                L47:
                    E5.E r5 = E5.E.f1657a
                    return r5
                */
                throw new UnsupportedOperationException("Method not decompiled: Z3.v.e.a.d(java.lang.Object, H5.d):java.lang.Object");
            }
        }

        public e(e6.d dVar, v vVar) {
            this.f5990a = dVar;
            this.f5991b = vVar;
        }

        @Override // e6.d
        public Object b(e6.e eVar, H5.d dVar) {
            Object objB = this.f5990a.b(new a(eVar, this.f5991b), dVar);
            return objB == I5.c.e() ? objB : E5.E.f1657a;
        }
    }

    public static final class f extends J5.l implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5997a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f5999c;

        public static final class a extends J5.l implements Q5.o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public int f6000a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public /* synthetic */ Object f6001b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final /* synthetic */ String f6002c;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(String str, H5.d dVar) {
                super(2, dVar);
                this.f6002c = str;
            }

            @Override // J5.a
            public final H5.d create(Object obj, H5.d dVar) {
                a aVar = new a(this.f6002c, dVar);
                aVar.f6001b = obj;
                return aVar;
            }

            @Override // Q5.o
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public final Object invoke(C1631c c1631c, H5.d dVar) {
                return ((a) create(c1631c, dVar)).invokeSuspend(E5.E.f1657a);
            }

            @Override // J5.a
            public final Object invokeSuspend(Object obj) throws Throwable {
                I5.c.e();
                if (this.f6000a != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                E5.q.b(obj);
                ((C1631c) this.f6001b).j(c.f5985a.a(), this.f6002c);
                return E5.E.f1657a;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(String str, H5.d dVar) {
            super(2, dVar);
            this.f5999c = str;
        }

        @Override // J5.a
        public final H5.d create(Object obj, H5.d dVar) {
            return v.this.new f(this.f5999c, dVar);
        }

        @Override // Q5.o
        public final Object invoke(b6.L l7, H5.d dVar) {
            return ((f) create(l7, dVar)).invokeSuspend(E5.E.f1657a);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = I5.c.e();
            int i7 = this.f5997a;
            try {
                if (i7 == 0) {
                    E5.q.b(obj);
                    InterfaceC1119h interfaceC1119h = v.this.f5979c;
                    a aVar = new a(this.f5999c, null);
                    this.f5997a = 1;
                    if (g0.i.a(interfaceC1119h, aVar, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i7 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    E5.q.b(obj);
                }
            } catch (IOException e7) {
                Log.w("FirebaseSessionsRepo", "Failed to update session Id: " + e7);
            }
            return E5.E.f1657a;
        }
    }

    public v(H5.g backgroundDispatcher, InterfaceC1119h dataStore) {
        kotlin.jvm.internal.r.f(backgroundDispatcher, "backgroundDispatcher");
        kotlin.jvm.internal.r.f(dataStore, "dataStore");
        this.f5978b = backgroundDispatcher;
        this.f5979c = dataStore;
        this.f5980d = new AtomicReference();
        this.f5981e = new e(e6.f.d(dataStore.getData(), new d(null)), this);
        AbstractC1077k.d(b6.M.a(backgroundDispatcher), null, null, new a(null), 3, null);
    }

    @Override // com.google.firebase.sessions.h
    public String a() {
        C0793m c0793m = (C0793m) this.f5980d.get();
        if (c0793m != null) {
            return c0793m.a();
        }
        return null;
    }

    @Override // com.google.firebase.sessions.h
    public void b(String sessionId) {
        kotlin.jvm.internal.r.f(sessionId, "sessionId");
        AbstractC1077k.d(b6.M.a(this.f5978b), null, null, new f(sessionId, null), 3, null);
    }

    public final C0793m g(g0.f fVar) {
        return new C0793m((String) fVar.b(c.f5985a.a()));
    }
}
