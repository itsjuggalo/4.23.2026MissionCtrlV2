package xa;

import cd.h0;
import cd.s;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.t;
import ng.n0;
import ng.o0;
import ua.w0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gd.i f24763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final w0 f24764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l1.i f24765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f24766d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f24767a;

        /* JADX INFO: renamed from: xa.m$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public /* synthetic */ class C0449a implements qg.e, kotlin.jvm.internal.n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AtomicReference f24769a;

            public C0449a(AtomicReference atomicReference) {
                this.f24769a = atomicReference;
            }

            @Override // kotlin.jvm.internal.n
            public final cd.f a() {
                return new kotlin.jvm.internal.a(2, this.f24769a, AtomicReference.class, "set", "set(Ljava/lang/Object;)V", 4);
            }

            @Override // qg.e
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object emit(SessionConfigs sessionConfigs, gd.e eVar) {
                Object objL = a.l(this.f24769a, sessionConfigs, eVar);
                return objL == hd.c.f() ? objL : h0.f3852a;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof qg.e) && (obj instanceof kotlin.jvm.internal.n)) {
                    return t.b(a(), ((kotlin.jvm.internal.n) obj).a());
                }
                return false;
            }

            public final int hashCode() {
                return a().hashCode();
            }
        }

        public a(gd.e eVar) {
            super(2, eVar);
        }

        public static final /* synthetic */ Object l(AtomicReference atomicReference, SessionConfigs sessionConfigs, gd.e eVar) {
            atomicReference.set(sessionConfigs);
            return h0.f3852a;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return m.this.new a(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.f24767a;
            if (i10 == 0) {
                s.b(obj);
                qg.d data = m.this.f24765c.getData();
                C0449a c0449a = new C0449a(m.this.f24766d);
                this.f24767a = 1;
                if (data.collect(c0449a, this) == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                s.b(obj);
            }
            return h0.f3852a;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((a) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f24770a;

        public b(gd.e eVar) {
            super(2, eVar);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return m.this.new b(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.f24770a;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                s.b(obj);
                return obj;
            }
            s.b(obj);
            qg.d data = m.this.f24765c.getData();
            this.f24770a = 1;
            Object objL = qg.f.l(data, this);
            return objL == objF ? objF : objL;
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((b) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends id.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f24772a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f24774c;

        public c(gd.e eVar) {
            super(eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) {
            this.f24772a = obj;
            this.f24774c |= Integer.MIN_VALUE;
            return m.this.b(null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f24775a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SessionConfigs f24776b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SessionConfigs sessionConfigs, gd.e eVar) {
            super(2, eVar);
            this.f24776b = sessionConfigs;
        }

        @Override // pd.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SessionConfigs sessionConfigs, gd.e eVar) {
            return ((d) create(sessionConfigs, eVar)).invokeSuspend(h0.f3852a);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            return new d(this.f24776b, eVar);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            hd.c.f();
            if (this.f24775a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            s.b(obj);
            return this.f24776b;
        }
    }

    public m(gd.i backgroundDispatcher, w0 timeProvider, l1.i sessionConfigsDataStore) {
        t.f(backgroundDispatcher, "backgroundDispatcher");
        t.f(timeProvider, "timeProvider");
        t.f(sessionConfigsDataStore, "sessionConfigsDataStore");
        this.f24763a = backgroundDispatcher;
        this.f24764b = timeProvider;
        this.f24765c = sessionConfigsDataStore;
        this.f24766d = new AtomicReference();
        ng.k.d(o0.a(backgroundDispatcher), null, null, new a(null), 3, null);
    }

    @Override // xa.l
    public Double a() {
        return h().getSessionSamplingRate();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // xa.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(xa.SessionConfigs r6, gd.e r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof xa.m.c
            if (r0 == 0) goto L13
            r0 = r7
            xa.m$c r0 = (xa.m.c) r0
            int r1 = r0.f24774c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f24774c = r1
            goto L18
        L13:
            xa.m$c r0 = new xa.m$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f24772a
            java.lang.Object r1 = hd.c.f()
            int r2 = r0.f24774c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            cd.s.b(r7)     // Catch: java.io.IOException -> L29
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
            cd.s.b(r7)
            l1.i r7 = r5.f24765c     // Catch: java.io.IOException -> L29
            xa.m$d r2 = new xa.m$d     // Catch: java.io.IOException -> L29
            r4 = 0
            r2.<init>(r6, r4)     // Catch: java.io.IOException -> L29
            r0.f24774c = r3     // Catch: java.io.IOException -> L29
            java.lang.Object r6 = r7.a(r2, r0)     // Catch: java.io.IOException -> L29
            if (r6 != r1) goto L5d
            return r1
        L47:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Failed to update config values: "
            r7.append(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "FirebaseSessions"
            android.util.Log.w(r7, r6)
        L5d:
            cd.h0 r6 = cd.h0.f3852a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: xa.m.b(xa.h, gd.e):java.lang.Object");
    }

    @Override // xa.l
    public Integer c() {
        return h().getSessionTimeoutSeconds();
    }

    @Override // xa.l
    public boolean d() {
        Long cacheUpdatedTimeSeconds = h().getCacheUpdatedTimeSeconds();
        Integer cacheDurationSeconds = h().getCacheDurationSeconds();
        return cacheUpdatedTimeSeconds == null || cacheDurationSeconds == null || this.f24764b.a().getSeconds() - cacheUpdatedTimeSeconds.longValue() >= ((long) cacheDurationSeconds.intValue());
    }

    @Override // xa.l
    public Boolean e() {
        return h().getSessionsEnabled();
    }

    public final SessionConfigs h() {
        if (this.f24766d.get() == null) {
            com.amazon.a.a.l.d.a(this.f24766d, null, ng.j.b(null, new b(null), 1, null));
        }
        Object obj = this.f24766d.get();
        t.e(obj, "get(...)");
        return (SessionConfigs) obj;
    }
}
