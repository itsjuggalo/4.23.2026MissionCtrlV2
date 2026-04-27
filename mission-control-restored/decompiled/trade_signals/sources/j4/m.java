package j4;

import Y6.AbstractC1007h;
import Y6.AbstractC1009i;
import Y6.L;
import Y6.M;
import b0.InterfaceC1178i;
import g4.InterfaceC1808X;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.C2286a;
import kotlin.jvm.internal.InterfaceC2299n;
import o5.AbstractC2491s;
import o5.C2470H;
import o5.InterfaceC2478f;
import s5.InterfaceC2707e;
import s5.InterfaceC2711i;
import t5.AbstractC2751c;
import u5.AbstractC2777d;
import u5.AbstractC2785l;

/* JADX INFO: loaded from: classes.dex */
public final class m implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2711i f20083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1808X f20084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC1178i f20085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicReference f20086d;

    public static final class a extends AbstractC2785l implements B5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20087a;

        /* JADX INFO: renamed from: j4.m$a$a, reason: collision with other inner class name */
        public /* synthetic */ class C0328a implements b7.e, InterfaceC2299n {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AtomicReference f20089a;

            public C0328a(AtomicReference atomicReference) {
                this.f20089a = atomicReference;
            }

            @Override // kotlin.jvm.internal.InterfaceC2299n
            public final InterfaceC2478f a() {
                return new C2286a(2, this.f20089a, AtomicReference.class, "set", "set(Ljava/lang/Object;)V", 4);
            }

            @Override // b7.e
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Object emit(SessionConfigs sessionConfigs, InterfaceC2707e interfaceC2707e) {
                Object objC = a.c(this.f20089a, sessionConfigs, interfaceC2707e);
                return objC == AbstractC2751c.f() ? objC : C2470H.f21956a;
            }

            public final boolean equals(Object obj) {
                if ((obj instanceof b7.e) && (obj instanceof InterfaceC2299n)) {
                    return AbstractC2304t.b(a(), ((InterfaceC2299n) obj).a());
                }
                return false;
            }

            public final int hashCode() {
                return a().hashCode();
            }
        }

        public a(InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
        }

        public static final /* synthetic */ Object c(AtomicReference atomicReference, SessionConfigs sessionConfigs, InterfaceC2707e interfaceC2707e) {
            atomicReference.set(sessionConfigs);
            return C2470H.f21956a;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return m.this.new a(interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((a) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.f20087a;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                b7.d data = m.this.f20085c.getData();
                C0328a c0328a = new C0328a(m.this.f20086d);
                this.f20087a = 1;
                if (data.collect(c0328a, this) == objF) {
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

    public static final class b extends AbstractC2785l implements B5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20090a;

        public b(InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return m.this.new b(interfaceC2707e);
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((b) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.f20090a;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                b7.d data = m.this.f20085c.getData();
                this.f20090a = 1;
                obj = b7.f.l(data, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
            }
            return obj;
        }
    }

    public static final class c extends AbstractC2777d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public /* synthetic */ Object f20092a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f20094c;

        public c(InterfaceC2707e interfaceC2707e) {
            super(interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) {
            this.f20092a = obj;
            this.f20094c |= Integer.MIN_VALUE;
            return m.this.c(null, this);
        }
    }

    public static final class d extends AbstractC2785l implements B5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f20095a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SessionConfigs f20096b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(SessionConfigs sessionConfigs, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.f20096b = sessionConfigs;
        }

        @Override // B5.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(SessionConfigs sessionConfigs, InterfaceC2707e interfaceC2707e) {
            return ((d) create(sessionConfigs, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            return new d(this.f20096b, interfaceC2707e);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            AbstractC2751c.f();
            if (this.f20095a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            AbstractC2491s.b(obj);
            return this.f20096b;
        }
    }

    public m(InterfaceC2711i backgroundDispatcher, InterfaceC1808X timeProvider, InterfaceC1178i sessionConfigsDataStore) {
        AbstractC2304t.f(backgroundDispatcher, "backgroundDispatcher");
        AbstractC2304t.f(timeProvider, "timeProvider");
        AbstractC2304t.f(sessionConfigsDataStore, "sessionConfigsDataStore");
        this.f20083a = backgroundDispatcher;
        this.f20084b = timeProvider;
        this.f20085c = sessionConfigsDataStore;
        this.f20086d = new AtomicReference();
        AbstractC1009i.d(M.a(backgroundDispatcher), null, null, new a(null), 3, null);
    }

    @Override // j4.l
    public Double a() {
        return h().getSessionSamplingRate();
    }

    @Override // j4.l
    public Integer b() {
        return h().getSessionTimeoutSeconds();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // j4.l
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(j4.SessionConfigs r6, s5.InterfaceC2707e r7) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r7 instanceof j4.m.c
            if (r0 == 0) goto L13
            r0 = r7
            j4.m$c r0 = (j4.m.c) r0
            int r1 = r0.f20094c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f20094c = r1
            goto L18
        L13:
            j4.m$c r0 = new j4.m$c
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.f20092a
            java.lang.Object r1 = t5.AbstractC2751c.f()
            int r2 = r0.f20094c
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            o5.AbstractC2491s.b(r7)     // Catch: java.io.IOException -> L29
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
            o5.AbstractC2491s.b(r7)
            b0.i r7 = r5.f20085c     // Catch: java.io.IOException -> L29
            j4.m$d r2 = new j4.m$d     // Catch: java.io.IOException -> L29
            r4 = 0
            r2.<init>(r6, r4)     // Catch: java.io.IOException -> L29
            r0.f20094c = r3     // Catch: java.io.IOException -> L29
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
            o5.H r6 = o5.C2470H.f21956a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j4.m.c(j4.h, s5.e):java.lang.Object");
    }

    @Override // j4.l
    public boolean d() {
        Long cacheUpdatedTimeSeconds = h().getCacheUpdatedTimeSeconds();
        Integer cacheDurationSeconds = h().getCacheDurationSeconds();
        return cacheUpdatedTimeSeconds == null || cacheDurationSeconds == null || this.f20084b.a().getSeconds() - cacheUpdatedTimeSeconds.longValue() >= ((long) cacheDurationSeconds.intValue());
    }

    @Override // j4.l
    public Boolean e() {
        return h().getSessionsEnabled();
    }

    public final SessionConfigs h() {
        if (this.f20086d.get() == null) {
            com.amazon.a.a.l.d.a(this.f20086d, null, AbstractC1007h.b(null, new b(null), 1, null));
        }
        Object obj = this.f20086d.get();
        AbstractC2304t.e(obj, "get(...)");
        return (SessionConfigs) obj;
    }
}
