package G4;

import F4.AbstractC0497k;
import F4.C0505t;
import F4.C0507v;
import F4.InterfaceC0500n;
import F4.X;
import G4.InterfaceC0551s;
import G4.Q0;
import io.flutter.plugins.firebase.database.Constants;
import java.io.InputStream;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import v2.AbstractC2844j;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class C0 implements G4.r {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final X.g f2326A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final X.g f2327B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final F4.j0 f2328C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static Random f2329D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final F4.Y f2330a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f2331b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f2333d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final F4.X f2334e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final D0 f2335f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final U f2336g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f2337h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final t f2339j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f2340k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f2341l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final D f2342m;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public y f2348s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f2349t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public InterfaceC0551s f2350u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public u f2351v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public u f2352w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f2353x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public F4.j0 f2354y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2355z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f2332c = new F4.n0(new C0512a());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f2338i = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Y f2343n = new Y();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile A f2344o = new A(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f2345p = new AtomicBoolean();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicInteger f2346q = new AtomicInteger();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicInteger f2347r = new AtomicInteger();

    public static final class A {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2356a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f2357b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Collection f2358c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Collection f2359d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f2360e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final C f2361f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f2362g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f2363h;

        public A(List list, Collection collection, Collection collection2, C c8, boolean z7, boolean z8, boolean z9, int i8) {
            this.f2357b = list;
            this.f2358c = (Collection) AbstractC2848n.o(collection, "drainedSubstreams");
            this.f2361f = c8;
            this.f2359d = collection2;
            this.f2362g = z7;
            this.f2356a = z8;
            this.f2363h = z9;
            this.f2360e = i8;
            AbstractC2848n.u(!z8 || list == null, "passThrough should imply buffer is null");
            AbstractC2848n.u((z8 && c8 == null) ? false : true, "passThrough should imply winningSubstream != null");
            AbstractC2848n.u(!z8 || (collection.size() == 1 && collection.contains(c8)) || (collection.size() == 0 && c8.f2378b), "passThrough should imply winningSubstream is drained");
            AbstractC2848n.u((z7 && c8 == null) ? false : true, "cancelled should imply committed");
        }

        public A a(C c8) {
            Collection collectionUnmodifiableCollection;
            AbstractC2848n.u(!this.f2363h, "hedging frozen");
            AbstractC2848n.u(this.f2361f == null, "already committed");
            if (this.f2359d == null) {
                collectionUnmodifiableCollection = Collections.singleton(c8);
            } else {
                ArrayList arrayList = new ArrayList(this.f2359d);
                arrayList.add(c8);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            return new A(this.f2357b, this.f2358c, collectionUnmodifiableCollection, this.f2361f, this.f2362g, this.f2356a, this.f2363h, this.f2360e + 1);
        }

        public A b() {
            return new A(this.f2357b, this.f2358c, this.f2359d, this.f2361f, true, this.f2356a, this.f2363h, this.f2360e);
        }

        public A c(C c8) {
            List list;
            boolean z7;
            Collection collectionEmptyList;
            AbstractC2848n.u(this.f2361f == null, "Already committed");
            List list2 = this.f2357b;
            if (this.f2358c.contains(c8)) {
                collectionEmptyList = Collections.singleton(c8);
                list = null;
                z7 = true;
            } else {
                list = list2;
                z7 = false;
                collectionEmptyList = Collections.emptyList();
            }
            return new A(list, collectionEmptyList, this.f2359d, c8, this.f2362g, z7, this.f2363h, this.f2360e);
        }

        public A d() {
            return this.f2363h ? this : new A(this.f2357b, this.f2358c, this.f2359d, this.f2361f, this.f2362g, this.f2356a, true, this.f2360e);
        }

        public A e(C c8) {
            ArrayList arrayList = new ArrayList(this.f2359d);
            arrayList.remove(c8);
            return new A(this.f2357b, this.f2358c, Collections.unmodifiableCollection(arrayList), this.f2361f, this.f2362g, this.f2356a, this.f2363h, this.f2360e);
        }

        public A f(C c8, C c9) {
            ArrayList arrayList = new ArrayList(this.f2359d);
            arrayList.remove(c8);
            arrayList.add(c9);
            return new A(this.f2357b, this.f2358c, Collections.unmodifiableCollection(arrayList), this.f2361f, this.f2362g, this.f2356a, this.f2363h, this.f2360e);
        }

        public A g(C c8) {
            c8.f2378b = true;
            if (!this.f2358c.contains(c8)) {
                return this;
            }
            ArrayList arrayList = new ArrayList(this.f2358c);
            arrayList.remove(c8);
            return new A(this.f2357b, Collections.unmodifiableCollection(arrayList), this.f2359d, this.f2361f, this.f2362g, this.f2356a, this.f2363h, this.f2360e);
        }

        public A h(C c8) {
            Collection collectionUnmodifiableCollection;
            AbstractC2848n.u(!this.f2356a, "Already passThrough");
            if (c8.f2378b) {
                collectionUnmodifiableCollection = this.f2358c;
            } else if (this.f2358c.isEmpty()) {
                collectionUnmodifiableCollection = Collections.singletonList(c8);
            } else {
                ArrayList arrayList = new ArrayList(this.f2358c);
                arrayList.add(c8);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            Collection collection = collectionUnmodifiableCollection;
            C c9 = this.f2361f;
            boolean z7 = c9 != null;
            List list = this.f2357b;
            if (z7) {
                AbstractC2848n.u(c9 == c8, "Another RPC attempt has already committed");
                list = null;
            }
            return new A(list, collection, this.f2359d, this.f2361f, this.f2362g, z7, this.f2363h, this.f2360e);
        }
    }

    public final class B implements InterfaceC0551s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C f2364a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ F4.X f2366a;

            public a(F4.X x8) {
                this.f2366a = x8;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0.this.f2350u.b(this.f2366a);
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C f2368a;

            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b bVar = b.this;
                    C0.this.g0(bVar.f2368a);
                }
            }

            public b(C c8) {
                this.f2368a = c8;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0.this.f2331b.execute(new a());
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0.this.f2355z = true;
                C0.this.f2350u.c(C0.this.f2348s.f2434a, C0.this.f2348s.f2435b, C0.this.f2348s.f2436c);
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C f2372a;

            public d(C c8) {
                this.f2372a = c8;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0.this.g0(this.f2372a);
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Q0.a f2374a;

            public e(Q0.a aVar) {
                this.f2374a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0.this.f2350u.a(this.f2374a);
            }
        }

        public class f implements Runnable {
            public f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C0.this.f2355z) {
                    return;
                }
                C0.this.f2350u.d();
            }
        }

        public B(C c8) {
            this.f2364a = c8;
        }

        @Override // G4.Q0
        public void a(Q0.a aVar) {
            A a8 = C0.this.f2344o;
            AbstractC2848n.u(a8.f2361f != null, "Headers should be received prior to messages.");
            if (a8.f2361f != this.f2364a) {
                S.d(aVar);
            } else {
                C0.this.f2332c.execute(new e(aVar));
            }
        }

        @Override // G4.InterfaceC0551s
        public void b(F4.X x8) {
            if (this.f2364a.f2380d > 0) {
                X.g gVar = C0.f2326A;
                x8.e(gVar);
                x8.o(gVar, String.valueOf(this.f2364a.f2380d));
            }
            C0.this.d0(this.f2364a);
            if (C0.this.f2344o.f2361f == this.f2364a) {
                if (C0.this.f2342m != null) {
                    C0.this.f2342m.c();
                }
                C0.this.f2332c.execute(new a(x8));
            }
        }

        @Override // G4.InterfaceC0551s
        public void c(F4.j0 j0Var, InterfaceC0551s.a aVar, F4.X x8) {
            u uVar;
            synchronized (C0.this.f2338i) {
                C0 c02 = C0.this;
                c02.f2344o = c02.f2344o.g(this.f2364a);
                C0.this.f2343n.a(j0Var.n());
            }
            if (C0.this.f2347r.decrementAndGet() == Integer.MIN_VALUE) {
                C0.this.f2332c.execute(new c());
                return;
            }
            C c8 = this.f2364a;
            if (c8.f2379c) {
                C0.this.d0(c8);
                if (C0.this.f2344o.f2361f == this.f2364a) {
                    C0.this.n0(j0Var, aVar, x8);
                    return;
                }
                return;
            }
            InterfaceC0551s.a aVar2 = InterfaceC0551s.a.MISCARRIED;
            if (aVar == aVar2 && C0.this.f2346q.incrementAndGet() > 1000) {
                C0.this.d0(this.f2364a);
                if (C0.this.f2344o.f2361f == this.f2364a) {
                    C0.this.n0(F4.j0.f1811s.r("Too many transparent retries. Might be a bug in gRPC").q(j0Var.d()), aVar, x8);
                    return;
                }
                return;
            }
            if (C0.this.f2344o.f2361f == null) {
                if (aVar == aVar2 || (aVar == InterfaceC0551s.a.REFUSED && C0.this.f2345p.compareAndSet(false, true))) {
                    C cE0 = C0.this.e0(this.f2364a.f2380d, true);
                    if (cE0 == null) {
                        return;
                    }
                    if (C0.this.f2337h) {
                        synchronized (C0.this.f2338i) {
                            C0 c03 = C0.this;
                            c03.f2344o = c03.f2344o.f(this.f2364a, cE0);
                        }
                    }
                    C0.this.f2331b.execute(new d(cE0));
                    return;
                }
                if (aVar != InterfaceC0551s.a.DROPPED) {
                    C0.this.f2345p.set(true);
                    if (C0.this.f2337h) {
                        v vVarF = f(j0Var, x8);
                        if (vVarF.f2426a) {
                            C0.this.m0(vVarF.f2427b);
                        }
                        synchronized (C0.this.f2338i) {
                            try {
                                C0 c04 = C0.this;
                                c04.f2344o = c04.f2344o.e(this.f2364a);
                                if (vVarF.f2426a) {
                                    C0 c05 = C0.this;
                                    if (!c05.i0(c05.f2344o)) {
                                        if (!C0.this.f2344o.f2359d.isEmpty()) {
                                        }
                                    }
                                    return;
                                }
                            } finally {
                            }
                        }
                    } else {
                        x xVarG = g(j0Var, x8);
                        if (xVarG.f2432a) {
                            C cE02 = C0.this.e0(this.f2364a.f2380d + 1, false);
                            if (cE02 == null) {
                                return;
                            }
                            synchronized (C0.this.f2338i) {
                                C0 c06 = C0.this;
                                uVar = new u(c06.f2338i);
                                c06.f2351v = uVar;
                            }
                            uVar.c(C0.this.f2333d.schedule(new b(cE02), xVarG.f2433b, TimeUnit.NANOSECONDS));
                            return;
                        }
                    }
                } else if (C0.this.f2337h) {
                    C0.this.h0();
                }
            }
            C0.this.d0(this.f2364a);
            if (C0.this.f2344o.f2361f == this.f2364a) {
                C0.this.n0(j0Var, aVar, x8);
            }
        }

        @Override // G4.Q0
        public void d() {
            if (C0.this.d()) {
                C0.this.f2332c.execute(new f());
            }
        }

        public final Integer e(F4.X x8) {
            String str = (String) x8.g(C0.f2327B);
            if (str == null) {
                return null;
            }
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public final v f(F4.j0 j0Var, F4.X x8) {
            Integer numE = e(x8);
            boolean z7 = !C0.this.f2336g.f2618c.contains(j0Var.n());
            boolean z8 = (C0.this.f2342m == null || (z7 && (numE == null || numE.intValue() >= 0))) ? false : !C0.this.f2342m.b();
            if (!z7 && !z8 && !j0Var.p() && numE != null && numE.intValue() > 0) {
                numE = 0;
            }
            return new v((z7 || z8) ? false : true, numE);
        }

        public final x g(F4.j0 j0Var, F4.X x8) {
            C0 c02;
            long jMin;
            long nanos = 0;
            boolean z7 = false;
            if (C0.this.f2335f == null) {
                return new x(false, 0L);
            }
            boolean zContains = C0.this.f2335f.f2480f.contains(j0Var.n());
            Integer numE = e(x8);
            boolean z8 = (C0.this.f2342m == null || (!zContains && (numE == null || numE.intValue() >= 0))) ? false : !C0.this.f2342m.b();
            if (C0.this.f2335f.f2475a > this.f2364a.f2380d + 1 && !z8) {
                if (numE == null) {
                    if (zContains) {
                        nanos = (long) (C0.this.f2353x * C0.f2329D.nextDouble());
                        c02 = C0.this;
                        jMin = Math.min((long) (c02.f2353x * C0.this.f2335f.f2478d), C0.this.f2335f.f2477c);
                        c02.f2353x = jMin;
                        z7 = true;
                    }
                } else if (numE.intValue() >= 0) {
                    nanos = TimeUnit.MILLISECONDS.toNanos(numE.intValue());
                    c02 = C0.this;
                    jMin = c02.f2335f.f2476b;
                    c02.f2353x = jMin;
                    z7 = true;
                }
            }
            return new x(z7, nanos);
        }
    }

    public static final class C {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public G4.r f2377a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f2378b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2379c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f2380d;

        public C(int i8) {
            this.f2380d = i8;
        }
    }

    public static final class D {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f2381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f2382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f2383c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicInteger f2384d;

        public D(float f8, float f9) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.f2384d = atomicInteger;
            this.f2383c = (int) (f9 * 1000.0f);
            int i8 = (int) (f8 * 1000.0f);
            this.f2381a = i8;
            this.f2382b = i8 / 2;
            atomicInteger.set(i8);
        }

        public boolean a() {
            return this.f2384d.get() > this.f2382b;
        }

        public boolean b() {
            int i8;
            int i9;
            do {
                i8 = this.f2384d.get();
                if (i8 == 0) {
                    return false;
                }
                i9 = i8 - 1000;
            } while (!this.f2384d.compareAndSet(i8, Math.max(i9, 0)));
            return i9 > this.f2382b;
        }

        public void c() {
            int i8;
            int i9;
            do {
                i8 = this.f2384d.get();
                i9 = this.f2381a;
                if (i8 == i9) {
                    return;
                }
            } while (!this.f2384d.compareAndSet(i8, Math.min(this.f2383c + i8, i9)));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof D)) {
                return false;
            }
            D d8 = (D) obj;
            return this.f2381a == d8.f2381a && this.f2383c == d8.f2383c;
        }

        public int hashCode() {
            return AbstractC2844j.b(Integer.valueOf(this.f2381a), Integer.valueOf(this.f2383c));
        }
    }

    /* JADX INFO: renamed from: G4.C0$a, reason: case insensitive filesystem */
    public class C0512a implements Thread.UncaughtExceptionHandler {
        public C0512a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            throw F4.j0.l(th).r("Uncaught exception in the SynchronizationContext. Re-thrown.").d();
        }
    }

    /* JADX INFO: renamed from: G4.C0$b, reason: case insensitive filesystem */
    public class C0513b implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f2386a;

        public C0513b(String str) {
            this.f2386a = str;
        }

        @Override // G4.C0.r
        public void a(C c8) {
            c8.f2377a.j(this.f2386a);
        }
    }

    /* JADX INFO: renamed from: G4.C0$c, reason: case insensitive filesystem */
    public class RunnableC0514c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection f2388a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C f2389b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Future f2390c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Future f2391d;

        public RunnableC0514c(Collection collection, C c8, Future future, Future future2) {
            this.f2388a = collection;
            this.f2389b = c8;
            this.f2390c = future;
            this.f2391d = future2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (C c8 : this.f2388a) {
                if (c8 != this.f2389b) {
                    c8.f2377a.a(C0.f2328C);
                }
            }
            Future future = this.f2390c;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.f2391d;
            if (future2 != null) {
                future2.cancel(false);
            }
            C0.this.k0();
        }
    }

    /* JADX INFO: renamed from: G4.C0$d, reason: case insensitive filesystem */
    public class C0515d implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0500n f2393a;

        public C0515d(InterfaceC0500n interfaceC0500n) {
            this.f2393a = interfaceC0500n;
        }

        @Override // G4.C0.r
        public void a(C c8) {
            c8.f2377a.b(this.f2393a);
        }
    }

    public class e implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0505t f2395a;

        public e(C0505t c0505t) {
            this.f2395a = c0505t;
        }

        @Override // G4.C0.r
        public void a(C c8) {
            c8.f2377a.h(this.f2395a);
        }
    }

    public class f implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0507v f2397a;

        public f(C0507v c0507v) {
            this.f2397a = c0507v;
        }

        @Override // G4.C0.r
        public void a(C c8) {
            c8.f2377a.l(this.f2397a);
        }
    }

    public class g implements r {
        public g() {
        }

        @Override // G4.C0.r
        public void a(C c8) {
            c8.f2377a.flush();
        }
    }

    public class h implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f2400a;

        public h(boolean z7) {
            this.f2400a = z7;
        }

        @Override // G4.C0.r
        public void a(C c8) {
            c8.f2377a.q(this.f2400a);
        }
    }

    public class i implements r {
        public i() {
        }

        @Override // G4.C0.r
        public void a(C c8) {
            c8.f2377a.k();
        }
    }

    public class j implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2403a;

        public j(int i8) {
            this.f2403a = i8;
        }

        @Override // G4.C0.r
        public void a(C c8) {
            c8.f2377a.f(this.f2403a);
        }
    }

    public class k implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2405a;

        public k(int i8) {
            this.f2405a = i8;
        }

        @Override // G4.C0.r
        public void a(C c8) {
            c8.f2377a.g(this.f2405a);
        }
    }

    public class l implements r {
        public l() {
        }

        @Override // G4.C0.r
        public void a(C c8) {
            c8.f2377a.p();
        }
    }

    public class m implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2408a;

        public m(int i8) {
            this.f2408a = i8;
        }

        @Override // G4.C0.r
        public void a(C c8) {
            c8.f2377a.e(this.f2408a);
        }
    }

    public class n implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f2410a;

        public n(Object obj) {
            this.f2410a = obj;
        }

        @Override // G4.C0.r
        public void a(C c8) {
            c8.f2377a.o(C0.this.f2330a.j(this.f2410a));
            c8.f2377a.flush();
        }
    }

    public class o extends AbstractC0497k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0497k f2412a;

        public o(AbstractC0497k abstractC0497k) {
            this.f2412a = abstractC0497k;
        }

        @Override // F4.AbstractC0497k.a
        public AbstractC0497k a(AbstractC0497k.b bVar, F4.X x8) {
            return this.f2412a;
        }
    }

    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0.this.f2355z) {
                return;
            }
            C0.this.f2350u.d();
        }
    }

    public class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ F4.j0 f2415a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0551s.a f2416b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ F4.X f2417c;

        public q(F4.j0 j0Var, InterfaceC0551s.a aVar, F4.X x8) {
            this.f2415a = j0Var;
            this.f2416b = aVar;
            this.f2417c = x8;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0.this.f2355z = true;
            C0.this.f2350u.c(this.f2415a, this.f2416b, this.f2417c);
        }
    }

    public interface r {
        void a(C c8);
    }

    public class s extends AbstractC0497k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C f2419b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f2420c;

        public s(C c8) {
            this.f2419b = c8;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x0075 A[Catch: all -> 0x0034, TryCatch #0 {all -> 0x0034, blocks: (B:7:0x0012, B:9:0x001c, B:12:0x0023, B:14:0x0032, B:18:0x0036, B:20:0x0043, B:21:0x0045, B:25:0x006f, B:27:0x0075, B:29:0x007d, B:22:0x0048, B:24:0x006c, B:33:0x0084), top: B:37:0x0012 }] */
        /* JADX WARN: Removed duplicated region for block: B:28:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:31:0x0080  */
        /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        @Override // F4.m0
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void h(long r6) {
            /*
                r5 = this;
                G4.C0 r0 = G4.C0.this
                G4.C0$A r0 = G4.C0.L(r0)
                G4.C0$C r0 = r0.f2361f
                if (r0 == 0) goto Lb
                return
            Lb:
                G4.C0 r0 = G4.C0.this
                java.lang.Object r0 = G4.C0.X(r0)
                monitor-enter(r0)
                G4.C0 r1 = G4.C0.this     // Catch: java.lang.Throwable -> L34
                G4.C0$A r1 = G4.C0.L(r1)     // Catch: java.lang.Throwable -> L34
                G4.C0$C r1 = r1.f2361f     // Catch: java.lang.Throwable -> L34
                if (r1 != 0) goto L84
                G4.C0$C r1 = r5.f2419b     // Catch: java.lang.Throwable -> L34
                boolean r1 = r1.f2378b     // Catch: java.lang.Throwable -> L34
                if (r1 == 0) goto L23
                goto L84
            L23:
                long r1 = r5.f2420c     // Catch: java.lang.Throwable -> L34
                long r1 = r1 + r6
                r5.f2420c = r1     // Catch: java.lang.Throwable -> L34
                G4.C0 r6 = G4.C0.this     // Catch: java.lang.Throwable -> L34
                long r6 = G4.C0.Q(r6)     // Catch: java.lang.Throwable -> L34
                int r6 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
                if (r6 > 0) goto L36
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
                return
            L34:
                r6 = move-exception
                goto L86
            L36:
                long r6 = r5.f2420c     // Catch: java.lang.Throwable -> L34
                G4.C0 r1 = G4.C0.this     // Catch: java.lang.Throwable -> L34
                long r1 = G4.C0.S(r1)     // Catch: java.lang.Throwable -> L34
                int r6 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
                r7 = 1
                if (r6 <= 0) goto L48
                G4.C0$C r6 = r5.f2419b     // Catch: java.lang.Throwable -> L34
            L45:
                r6.f2379c = r7     // Catch: java.lang.Throwable -> L34
                goto L6f
            L48:
                G4.C0 r6 = G4.C0.this     // Catch: java.lang.Throwable -> L34
                G4.C0$t r6 = G4.C0.T(r6)     // Catch: java.lang.Throwable -> L34
                long r1 = r5.f2420c     // Catch: java.lang.Throwable -> L34
                G4.C0 r3 = G4.C0.this     // Catch: java.lang.Throwable -> L34
                long r3 = G4.C0.Q(r3)     // Catch: java.lang.Throwable -> L34
                long r1 = r1 - r3
                long r1 = r6.a(r1)     // Catch: java.lang.Throwable -> L34
                G4.C0 r6 = G4.C0.this     // Catch: java.lang.Throwable -> L34
                long r3 = r5.f2420c     // Catch: java.lang.Throwable -> L34
                G4.C0.R(r6, r3)     // Catch: java.lang.Throwable -> L34
                G4.C0 r6 = G4.C0.this     // Catch: java.lang.Throwable -> L34
                long r3 = G4.C0.U(r6)     // Catch: java.lang.Throwable -> L34
                int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r6 <= 0) goto L6f
                G4.C0$C r6 = r5.f2419b     // Catch: java.lang.Throwable -> L34
                goto L45
            L6f:
                G4.C0$C r6 = r5.f2419b     // Catch: java.lang.Throwable -> L34
                boolean r7 = r6.f2379c     // Catch: java.lang.Throwable -> L34
                if (r7 == 0) goto L7c
                G4.C0 r7 = G4.C0.this     // Catch: java.lang.Throwable -> L34
                java.lang.Runnable r6 = G4.C0.V(r7, r6)     // Catch: java.lang.Throwable -> L34
                goto L7d
            L7c:
                r6 = 0
            L7d:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
                if (r6 == 0) goto L83
                r6.run()
            L83:
                return
            L84:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
                return
            L86:
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L34
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: G4.C0.s.h(long):void");
        }
    }

    public static final class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicLong f2422a = new AtomicLong();

        public long a(long j8) {
            return this.f2422a.addAndGet(j8);
        }
    }

    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f2423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Future f2424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f2425c;

        public u(Object obj) {
            this.f2423a = obj;
        }

        public boolean a() {
            return this.f2425c;
        }

        public Future b() {
            this.f2425c = true;
            return this.f2424b;
        }

        public void c(Future future) {
            synchronized (this.f2423a) {
                try {
                    if (!this.f2425c) {
                        this.f2424b = future;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static final class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2426a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f2427b;

        public v(boolean z7, Integer num) {
            this.f2426a = z7;
            this.f2427b = num;
        }
    }

    public final class w implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u f2428a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C f2430a;

            public a(C c8) {
                this.f2430a = c8;
            }

            @Override // java.lang.Runnable
            public void run() {
                u uVar;
                C0 c02;
                boolean z7;
                synchronized (C0.this.f2338i) {
                    try {
                        uVar = null;
                        if (w.this.f2428a.a()) {
                            z7 = true;
                        } else {
                            C0 c03 = C0.this;
                            c03.f2344o = c03.f2344o.a(this.f2430a);
                            C0 c04 = C0.this;
                            if (c04.i0(c04.f2344o) && (C0.this.f2342m == null || C0.this.f2342m.a())) {
                                c02 = C0.this;
                                uVar = new u(c02.f2338i);
                            } else {
                                C0 c05 = C0.this;
                                c05.f2344o = c05.f2344o.d();
                                c02 = C0.this;
                            }
                            c02.f2352w = uVar;
                            z7 = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z7) {
                    this.f2430a.f2377a.i(C0.this.new B(this.f2430a));
                    this.f2430a.f2377a.a(F4.j0.f1798f.r("Unneeded hedging"));
                } else {
                    if (uVar != null) {
                        uVar.c(C0.this.f2333d.schedule(C0.this.new w(uVar), C0.this.f2336g.f2617b, TimeUnit.NANOSECONDS));
                    }
                    C0.this.g0(this.f2430a);
                }
            }
        }

        public w(u uVar) {
            this.f2428a = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0 c02 = C0.this;
            C cE0 = c02.e0(c02.f2344o.f2360e, false);
            if (cE0 == null) {
                return;
            }
            C0.this.f2331b.execute(new a(cE0));
        }
    }

    public static final class x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f2432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f2433b;

        public x(boolean z7, long j8) {
            this.f2432a = z7;
            this.f2433b = j8;
        }
    }

    public static final class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final F4.j0 f2434a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC0551s.a f2435b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final F4.X f2436c;

        public y(F4.j0 j0Var, InterfaceC0551s.a aVar, F4.X x8) {
            this.f2434a = j0Var;
            this.f2435b = aVar;
            this.f2436c = x8;
        }
    }

    public class z implements r {
        public z() {
        }

        @Override // G4.C0.r
        public void a(C c8) {
            c8.f2377a.i(C0.this.new B(c8));
        }
    }

    static {
        X.d dVar = F4.X.f1686e;
        f2326A = X.g.e("grpc-previous-rpc-attempts", dVar);
        f2327B = X.g.e("grpc-retry-pushback-ms", dVar);
        f2328C = F4.j0.f1798f.r("Stream thrown away because RetriableStream committed");
        f2329D = new Random();
    }

    public C0(F4.Y y7, F4.X x8, t tVar, long j8, long j9, Executor executor, ScheduledExecutorService scheduledExecutorService, D0 d02, U u8, D d8) {
        this.f2330a = y7;
        this.f2339j = tVar;
        this.f2340k = j8;
        this.f2341l = j9;
        this.f2331b = executor;
        this.f2333d = scheduledExecutorService;
        this.f2334e = x8;
        this.f2335f = d02;
        if (d02 != null) {
            this.f2353x = d02.f2476b;
        }
        this.f2336g = u8;
        AbstractC2848n.e(d02 == null || u8 == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.f2337h = u8 != null;
        this.f2342m = d8;
    }

    @Override // G4.r
    public final void a(F4.j0 j0Var) {
        C c8;
        C c9 = new C(0);
        c9.f2377a = new C0547p0();
        Runnable runnableC0 = c0(c9);
        if (runnableC0 != null) {
            synchronized (this.f2338i) {
                this.f2344o = this.f2344o.h(c9);
            }
            runnableC0.run();
            n0(j0Var, InterfaceC0551s.a.PROCESSED, new F4.X());
            return;
        }
        synchronized (this.f2338i) {
            try {
                if (this.f2344o.f2358c.contains(this.f2344o.f2361f)) {
                    c8 = this.f2344o.f2361f;
                } else {
                    this.f2354y = j0Var;
                    c8 = null;
                }
                this.f2344o = this.f2344o.b();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (c8 != null) {
            c8.f2377a.a(j0Var);
        }
    }

    @Override // G4.P0
    public final void b(InterfaceC0500n interfaceC0500n) {
        f0(new C0515d(interfaceC0500n));
    }

    public final Runnable c0(C c8) {
        Future future;
        Future future2;
        synchronized (this.f2338i) {
            try {
                if (this.f2344o.f2361f != null) {
                    return null;
                }
                Collection collection = this.f2344o.f2358c;
                this.f2344o = this.f2344o.c(c8);
                this.f2339j.a(-this.f2349t);
                u uVar = this.f2351v;
                if (uVar != null) {
                    Future futureB = uVar.b();
                    this.f2351v = null;
                    future = futureB;
                } else {
                    future = null;
                }
                u uVar2 = this.f2352w;
                if (uVar2 != null) {
                    Future futureB2 = uVar2.b();
                    this.f2352w = null;
                    future2 = futureB2;
                } else {
                    future2 = null;
                }
                return new RunnableC0514c(collection, c8, future, future2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // G4.P0
    public final boolean d() {
        Iterator it = this.f2344o.f2358c.iterator();
        while (it.hasNext()) {
            if (((C) it.next()).f2377a.d()) {
                return true;
            }
        }
        return false;
    }

    public final void d0(C c8) {
        Runnable runnableC0 = c0(c8);
        if (runnableC0 != null) {
            this.f2331b.execute(runnableC0);
        }
    }

    @Override // G4.P0
    public final void e(int i8) {
        A a8 = this.f2344o;
        if (a8.f2356a) {
            a8.f2361f.f2377a.e(i8);
        } else {
            f0(new m(i8));
        }
    }

    public final C e0(int i8, boolean z7) {
        int i9;
        do {
            i9 = this.f2347r.get();
            if (i9 < 0) {
                return null;
            }
        } while (!this.f2347r.compareAndSet(i9, i9 + 1));
        C c8 = new C(i8);
        c8.f2377a = j0(p0(this.f2334e, i8), new o(new s(c8)), i8, z7);
        return c8;
    }

    @Override // G4.r
    public final void f(int i8) {
        f0(new j(i8));
    }

    public final void f0(r rVar) {
        Collection collection;
        synchronized (this.f2338i) {
            try {
                if (!this.f2344o.f2356a) {
                    this.f2344o.f2357b.add(rVar);
                }
                collection = this.f2344o.f2358c;
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            rVar.a((C) it.next());
        }
    }

    @Override // G4.P0
    public final void flush() {
        A a8 = this.f2344o;
        if (a8.f2356a) {
            a8.f2361f.f2377a.flush();
        } else {
            f0(new g());
        }
    }

    @Override // G4.r
    public final void g(int i8) {
        f0(new k(i8));
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0035, code lost:
    
        if (r1 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0037, code lost:
    
        r8.f2332c.execute(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x003c, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        if (r2 != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003f, code lost:
    
        r9.f2377a.i(new G4.C0.B(r8, r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0049, code lost:
    
        r0 = r9.f2377a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004f, code lost:
    
        if (r8.f2344o.f2361f != r9) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0051, code lost:
    
        r9 = r8.f2354y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0054, code lost:
    
        r9 = G4.C0.f2328C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0056, code lost:
    
        r0.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0059, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0087, code lost:
    
        r0 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x008f, code lost:
    
        if (r0.hasNext() == false) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0091, code lost:
    
        r4 = (G4.C0.r) r0.next();
        r4.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009c, code lost:
    
        if ((r4 instanceof G4.C0.z) == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009e, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009f, code lost:
    
        r4 = r8.f2344o;
        r5 = r4.f2361f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a3, code lost:
    
        if (r5 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a5, code lost:
    
        if (r5 == r9) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00aa, code lost:
    
        if (r4.f2362g == false) goto L66;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g0(G4.C0.C r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            r2 = r0
            r3 = r1
        L4:
            java.lang.Object r4 = r8.f2338i
            monitor-enter(r4)
            G4.C0$A r5 = r8.f2344o     // Catch: java.lang.Throwable -> L11
            G4.C0$C r6 = r5.f2361f     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L14
            if (r6 == r9) goto L14
        Lf:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            goto L35
        L11:
            r9 = move-exception
            goto Laf
        L14:
            boolean r6 = r5.f2362g     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L19
            goto Lf
        L19:
            java.util.List r6 = r5.f2357b     // Catch: java.lang.Throwable -> L11
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L11
            if (r0 != r6) goto L5a
            G4.C0$A r0 = r5.h(r9)     // Catch: java.lang.Throwable -> L11
            r8.f2344o = r0     // Catch: java.lang.Throwable -> L11
            boolean r0 = r8.d()     // Catch: java.lang.Throwable -> L11
            if (r0 != 0) goto L2f
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            return
        L2f:
            G4.C0$p r1 = new G4.C0$p     // Catch: java.lang.Throwable -> L11
            r1.<init>()     // Catch: java.lang.Throwable -> L11
            goto Lf
        L35:
            if (r1 == 0) goto L3d
            java.util.concurrent.Executor r9 = r8.f2332c
            r9.execute(r1)
            return
        L3d:
            if (r2 != 0) goto L49
            G4.r r0 = r9.f2377a
            G4.C0$B r1 = new G4.C0$B
            r1.<init>(r9)
            r0.i(r1)
        L49:
            G4.r r0 = r9.f2377a
            G4.C0$A r1 = r8.f2344o
            G4.C0$C r1 = r1.f2361f
            if (r1 != r9) goto L54
            F4.j0 r9 = r8.f2354y
            goto L56
        L54:
            F4.j0 r9 = G4.C0.f2328C
        L56:
            r0.a(r9)
            return
        L5a:
            boolean r6 = r9.f2378b     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L60
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            return
        L60:
            int r6 = r0 + 128
            java.util.List r7 = r5.f2357b     // Catch: java.lang.Throwable -> L11
            int r7 = r7.size()     // Catch: java.lang.Throwable -> L11
            int r6 = java.lang.Math.min(r6, r7)     // Catch: java.lang.Throwable -> L11
            if (r3 != 0) goto L7a
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L11
            java.util.List r5 = r5.f2357b     // Catch: java.lang.Throwable -> L11
            java.util.List r0 = r5.subList(r0, r6)     // Catch: java.lang.Throwable -> L11
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L11
            goto L86
        L7a:
            r3.clear()     // Catch: java.lang.Throwable -> L11
            java.util.List r5 = r5.f2357b     // Catch: java.lang.Throwable -> L11
            java.util.List r0 = r5.subList(r0, r6)     // Catch: java.lang.Throwable -> L11
            r3.addAll(r0)     // Catch: java.lang.Throwable -> L11
        L86:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            java.util.Iterator r0 = r3.iterator()
        L8b:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto Lac
            java.lang.Object r4 = r0.next()
            G4.C0$r r4 = (G4.C0.r) r4
            r4.a(r9)
            boolean r4 = r4 instanceof G4.C0.z
            if (r4 == 0) goto L9f
            r2 = 1
        L9f:
            G4.C0$A r4 = r8.f2344o
            G4.C0$C r5 = r4.f2361f
            if (r5 == 0) goto La8
            if (r5 == r9) goto La8
            goto Lac
        La8:
            boolean r4 = r4.f2362g
            if (r4 == 0) goto L8b
        Lac:
            r0 = r6
            goto L4
        Laf:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: G4.C0.g0(G4.C0$C):void");
    }

    @Override // G4.r
    public final void h(C0505t c0505t) {
        f0(new e(c0505t));
    }

    public final void h0() {
        Future future;
        synchronized (this.f2338i) {
            try {
                u uVar = this.f2352w;
                future = null;
                if (uVar != null) {
                    Future futureB = uVar.b();
                    this.f2352w = null;
                    future = futureB;
                }
                this.f2344o = this.f2344o.d();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    @Override // G4.r
    public final void i(InterfaceC0551s interfaceC0551s) {
        u uVar;
        D d8;
        this.f2350u = interfaceC0551s;
        F4.j0 j0VarL0 = l0();
        if (j0VarL0 != null) {
            a(j0VarL0);
            return;
        }
        synchronized (this.f2338i) {
            this.f2344o.f2357b.add(new z());
        }
        C cE0 = e0(0, false);
        if (cE0 == null) {
            return;
        }
        if (this.f2337h) {
            synchronized (this.f2338i) {
                try {
                    this.f2344o = this.f2344o.a(cE0);
                    if (i0(this.f2344o) && ((d8 = this.f2342m) == null || d8.a())) {
                        uVar = new u(this.f2338i);
                        this.f2352w = uVar;
                    } else {
                        uVar = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (uVar != null) {
                uVar.c(this.f2333d.schedule(new w(uVar), this.f2336g.f2617b, TimeUnit.NANOSECONDS));
            }
        }
        g0(cE0);
    }

    public final boolean i0(A a8) {
        return a8.f2361f == null && a8.f2360e < this.f2336g.f2616a && !a8.f2363h;
    }

    @Override // G4.r
    public final void j(String str) {
        f0(new C0513b(str));
    }

    public abstract G4.r j0(F4.X x8, AbstractC0497k.a aVar, int i8, boolean z7);

    @Override // G4.r
    public final void k() {
        f0(new i());
    }

    public abstract void k0();

    @Override // G4.r
    public final void l(C0507v c0507v) {
        f0(new f(c0507v));
    }

    public abstract F4.j0 l0();

    @Override // G4.r
    public void m(Y y7) {
        A a8;
        Y y8;
        String str;
        synchronized (this.f2338i) {
            y7.b("closed", this.f2343n);
            a8 = this.f2344o;
        }
        if (a8.f2361f != null) {
            y8 = new Y();
            a8.f2361f.f2377a.m(y8);
            str = Constants.COMMITTED;
        } else {
            y8 = new Y();
            for (C c8 : a8.f2358c) {
                Y y9 = new Y();
                c8.f2377a.m(y9);
                y8.a(y9);
            }
            str = "open";
        }
        y7.b(str, y8);
    }

    public final void m0(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            h0();
            return;
        }
        synchronized (this.f2338i) {
            try {
                u uVar = this.f2352w;
                if (uVar == null) {
                    return;
                }
                Future futureB = uVar.b();
                u uVar2 = new u(this.f2338i);
                this.f2352w = uVar2;
                if (futureB != null) {
                    futureB.cancel(false);
                }
                uVar2.c(this.f2333d.schedule(new w(uVar2), num.intValue(), TimeUnit.MILLISECONDS));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void n0(F4.j0 j0Var, InterfaceC0551s.a aVar, F4.X x8) {
        this.f2348s = new y(j0Var, aVar, x8);
        if (this.f2347r.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            this.f2332c.execute(new q(j0Var, aVar, x8));
        }
    }

    @Override // G4.P0
    public final void o(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    public final void o0(Object obj) {
        A a8 = this.f2344o;
        if (a8.f2356a) {
            a8.f2361f.f2377a.o(this.f2330a.j(obj));
        } else {
            f0(new n(obj));
        }
    }

    @Override // G4.P0
    public void p() {
        f0(new l());
    }

    public final F4.X p0(F4.X x8, int i8) {
        F4.X x9 = new F4.X();
        x9.l(x8);
        if (i8 > 0) {
            x9.o(f2326A, String.valueOf(i8));
        }
        return x9;
    }

    @Override // G4.r
    public final void q(boolean z7) {
        f0(new h(z7));
    }
}
