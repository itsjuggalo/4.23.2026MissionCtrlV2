package d4;

import E5.E;
import E5.q;
import Q5.o;
import b6.AbstractC1075j;
import b6.L;
import c0.InterfaceC1119h;
import g0.C1631c;
import g0.f;
import kotlin.jvm.internal.AbstractC2148j;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class k {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f13394c = new b(null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final f.a f13395d = g0.h.a("firebase_sessions_enabled");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f.a f13396e = g0.h.c("firebase_sessions_sampling_rate");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final f.a f13397f = g0.h.e("firebase_sessions_restart_timeout");

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final f.a f13398g = g0.h.e("firebase_sessions_cache_duration");

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final f.a f13399h = g0.h.f("firebase_sessions_cache_updated_time");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1119h f13400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public h f13401b;

    public static final class a extends J5.l implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Object f13402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f13403b;

        public a(H5.d dVar) {
            super(2, dVar);
        }

        @Override // J5.a
        public final H5.d create(Object obj, H5.d dVar) {
            return k.this.new a(dVar);
        }

        @Override // Q5.o
        public final Object invoke(L l7, H5.d dVar) {
            return ((a) create(l7, dVar)).invokeSuspend(E.f1657a);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            k kVar;
            Object objE = I5.c.e();
            int i7 = this.f13403b;
            if (i7 == 0) {
                q.b(obj);
                k kVar2 = k.this;
                e6.d data = kVar2.f13400a.getData();
                this.f13402a = kVar2;
                this.f13403b = 1;
                Object objK = e6.f.k(data, this);
                if (objK == objE) {
                    return objE;
                }
                kVar = kVar2;
                obj = objK;
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kVar = (k) this.f13402a;
                q.b(obj);
            }
            kVar.l(((g0.f) obj).d());
            return E.f1657a;
        }
    }

    public static final class b {
        public /* synthetic */ b(AbstractC2148j abstractC2148j) {
            this();
        }

        public b() {
        }
    }

    public static final class c extends J5.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f13405a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f13407c;

        public c(H5.d dVar) {
            super(dVar);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) {
            this.f13405a = obj;
            this.f13407c |= Integer.MIN_VALUE;
            return k.this.h(null, null, this);
        }
    }

    public static final class d extends J5.l implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13408a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f13409b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Object f13410c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ f.a f13411d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ k f13412e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Object obj, f.a aVar, k kVar, H5.d dVar) {
            super(2, dVar);
            this.f13410c = obj;
            this.f13411d = aVar;
            this.f13412e = kVar;
        }

        @Override // J5.a
        public final H5.d create(Object obj, H5.d dVar) {
            d dVar2 = new d(this.f13410c, this.f13411d, this.f13412e, dVar);
            dVar2.f13409b = obj;
            return dVar2;
        }

        @Override // Q5.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(C1631c c1631c, H5.d dVar) {
            return ((d) create(c1631c, dVar)).invokeSuspend(E.f1657a);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            I5.c.e();
            if (this.f13408a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            q.b(obj);
            C1631c c1631c = (C1631c) this.f13409b;
            Object obj2 = this.f13410c;
            if (obj2 != null) {
                c1631c.j(this.f13411d, obj2);
            } else {
                c1631c.i(this.f13411d);
            }
            this.f13412e.l(c1631c);
            return E.f1657a;
        }
    }

    public k(InterfaceC1119h dataStore) {
        r.f(dataStore, "dataStore");
        this.f13400a = dataStore;
        AbstractC1075j.b(null, new a(null), 1, null);
    }

    public final boolean d() {
        h hVar = this.f13401b;
        h hVar2 = null;
        if (hVar == null) {
            r.s("sessionConfigs");
            hVar = null;
        }
        Long lB = hVar.b();
        h hVar3 = this.f13401b;
        if (hVar3 == null) {
            r.s("sessionConfigs");
        } else {
            hVar2 = hVar3;
        }
        Integer numA = hVar2.a();
        return lB == null || numA == null || (System.currentTimeMillis() - lB.longValue()) / ((long) 1000) >= ((long) numA.intValue());
    }

    public final Integer e() {
        h hVar = this.f13401b;
        if (hVar == null) {
            r.s("sessionConfigs");
            hVar = null;
        }
        return hVar.d();
    }

    public final Double f() {
        h hVar = this.f13401b;
        if (hVar == null) {
            r.s("sessionConfigs");
            hVar = null;
        }
        return hVar.e();
    }

    public final Boolean g() {
        h hVar = this.f13401b;
        if (hVar == null) {
            r.s("sessionConfigs");
            hVar = null;
        }
        return hVar.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(g0.f.a r6, java.lang.Object r7, H5.d r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof d4.k.c
            if (r0 == 0) goto L13
            r0 = r8
            d4.k$c r0 = (d4.k.c) r0
            int r1 = r0.f13407c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f13407c = r1
            goto L18
        L13:
            d4.k$c r0 = new d4.k$c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.f13405a
            java.lang.Object r1 = I5.c.e()
            int r2 = r0.f13407c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            E5.q.b(r8)     // Catch: java.io.IOException -> L29
            goto L5d
        L29:
            r6 = move-exception
            goto L47
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            E5.q.b(r8)
            c0.h r8 = r5.f13400a     // Catch: java.io.IOException -> L29
            d4.k$d r2 = new d4.k$d     // Catch: java.io.IOException -> L29
            r4 = 0
            r2.<init>(r7, r6, r5, r4)     // Catch: java.io.IOException -> L29
            r0.f13407c = r3     // Catch: java.io.IOException -> L29
            java.lang.Object r6 = g0.i.a(r8, r2, r0)     // Catch: java.io.IOException -> L29
            if (r6 != r1) goto L5d
            return r1
        L47:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Failed to update cache config value: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "SettingsCache"
            android.util.Log.w(r7, r6)
        L5d:
            E5.E r6 = E5.E.f1657a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: d4.k.h(g0.f$a, java.lang.Object, H5.d):java.lang.Object");
    }

    public final Object i(Double d7, H5.d dVar) throws Throwable {
        Object objH = h(f13396e, d7, dVar);
        return objH == I5.c.e() ? objH : E.f1657a;
    }

    public final Object j(Integer num, H5.d dVar) throws Throwable {
        Object objH = h(f13398g, num, dVar);
        return objH == I5.c.e() ? objH : E.f1657a;
    }

    public final Object k(Long l7, H5.d dVar) throws Throwable {
        Object objH = h(f13399h, l7, dVar);
        return objH == I5.c.e() ? objH : E.f1657a;
    }

    public final void l(g0.f fVar) {
        this.f13401b = new h((Boolean) fVar.b(f13395d), (Double) fVar.b(f13396e), (Integer) fVar.b(f13397f), (Integer) fVar.b(f13398g), (Long) fVar.b(f13399h));
    }

    public final Object m(Integer num, H5.d dVar) throws Throwable {
        Object objH = h(f13397f, num, dVar);
        return objH == I5.c.e() ? objH : E.f1657a;
    }

    public final Object n(Boolean bool, H5.d dVar) throws Throwable {
        Object objH = h(f13395d, bool, dVar);
        return objH == I5.c.e() ? objH : E.f1657a;
    }
}
