package t5;

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
import r5.AbstractC2595k;
import r5.C2603t;
import r5.C2605v;
import r5.InterfaceC2598n;
import r5.Z;
import t5.InterfaceC2698s;
import t5.Q0;

/* JADX INFO: loaded from: classes2.dex */
public abstract class C0 implements t5.r {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final Z.g f23289A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final Z.g f23290B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final r5.l0 f23291C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static Random f23292D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r5.a0 f23293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f23294b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f23296d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r5.Z f23297e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final D0 f23298f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final U f23299g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f23300h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final t f23302j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f23303k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f23304l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final D f23305m;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public y f23311s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f23312t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public InterfaceC2698s f23313u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public u f23314v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public u f23315w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f23316x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public r5.l0 f23317y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f23318z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f23295c = new r5.p0(new C2659a());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f23301i = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Y f23306n = new Y();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile A f23307o = new A(new ArrayList(8), Collections.emptyList(), null, null, false, false, false, 0);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f23308p = new AtomicBoolean();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicInteger f23309q = new AtomicInteger();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicInteger f23310r = new AtomicInteger();

    public static final class A {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f23319a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f23320b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Collection f23321c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Collection f23322d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f23323e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final C f23324f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f23325g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f23326h;

        public A(List list, Collection collection, Collection collection2, C c7, boolean z7, boolean z8, boolean z9, int i7) {
            this.f23320b = list;
            this.f23321c = (Collection) H2.m.o(collection, "drainedSubstreams");
            this.f23324f = c7;
            this.f23322d = collection2;
            this.f23325g = z7;
            this.f23319a = z8;
            this.f23326h = z9;
            this.f23323e = i7;
            H2.m.u(!z8 || list == null, "passThrough should imply buffer is null");
            H2.m.u((z8 && c7 == null) ? false : true, "passThrough should imply winningSubstream != null");
            H2.m.u(!z8 || (collection.size() == 1 && collection.contains(c7)) || (collection.size() == 0 && c7.f23341b), "passThrough should imply winningSubstream is drained");
            H2.m.u((z7 && c7 == null) ? false : true, "cancelled should imply committed");
        }

        public A a(C c7) {
            Collection collectionUnmodifiableCollection;
            H2.m.u(!this.f23326h, "hedging frozen");
            H2.m.u(this.f23324f == null, "already committed");
            if (this.f23322d == null) {
                collectionUnmodifiableCollection = Collections.singleton(c7);
            } else {
                ArrayList arrayList = new ArrayList(this.f23322d);
                arrayList.add(c7);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            return new A(this.f23320b, this.f23321c, collectionUnmodifiableCollection, this.f23324f, this.f23325g, this.f23319a, this.f23326h, this.f23323e + 1);
        }

        public A b() {
            return new A(this.f23320b, this.f23321c, this.f23322d, this.f23324f, true, this.f23319a, this.f23326h, this.f23323e);
        }

        public A c(C c7) {
            List list;
            boolean z7;
            Collection collectionEmptyList;
            H2.m.u(this.f23324f == null, "Already committed");
            List list2 = this.f23320b;
            if (this.f23321c.contains(c7)) {
                collectionEmptyList = Collections.singleton(c7);
                list = null;
                z7 = true;
            } else {
                list = list2;
                z7 = false;
                collectionEmptyList = Collections.emptyList();
            }
            return new A(list, collectionEmptyList, this.f23322d, c7, this.f23325g, z7, this.f23326h, this.f23323e);
        }

        public A d() {
            return this.f23326h ? this : new A(this.f23320b, this.f23321c, this.f23322d, this.f23324f, this.f23325g, this.f23319a, true, this.f23323e);
        }

        public A e(C c7) {
            ArrayList arrayList = new ArrayList(this.f23322d);
            arrayList.remove(c7);
            return new A(this.f23320b, this.f23321c, Collections.unmodifiableCollection(arrayList), this.f23324f, this.f23325g, this.f23319a, this.f23326h, this.f23323e);
        }

        public A f(C c7, C c8) {
            ArrayList arrayList = new ArrayList(this.f23322d);
            arrayList.remove(c7);
            arrayList.add(c8);
            return new A(this.f23320b, this.f23321c, Collections.unmodifiableCollection(arrayList), this.f23324f, this.f23325g, this.f23319a, this.f23326h, this.f23323e);
        }

        public A g(C c7) {
            c7.f23341b = true;
            if (!this.f23321c.contains(c7)) {
                return this;
            }
            ArrayList arrayList = new ArrayList(this.f23321c);
            arrayList.remove(c7);
            return new A(this.f23320b, Collections.unmodifiableCollection(arrayList), this.f23322d, this.f23324f, this.f23325g, this.f23319a, this.f23326h, this.f23323e);
        }

        public A h(C c7) {
            Collection collectionUnmodifiableCollection;
            H2.m.u(!this.f23319a, "Already passThrough");
            if (c7.f23341b) {
                collectionUnmodifiableCollection = this.f23321c;
            } else if (this.f23321c.isEmpty()) {
                collectionUnmodifiableCollection = Collections.singletonList(c7);
            } else {
                ArrayList arrayList = new ArrayList(this.f23321c);
                arrayList.add(c7);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            Collection collection = collectionUnmodifiableCollection;
            C c8 = this.f23324f;
            boolean z7 = c8 != null;
            List list = this.f23320b;
            if (z7) {
                H2.m.u(c8 == c7, "Another RPC attempt has already committed");
                list = null;
            }
            return new A(list, collection, this.f23322d, this.f23324f, this.f23325g, z7, this.f23326h, this.f23323e);
        }
    }

    public final class B implements InterfaceC2698s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C f23327a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r5.Z f23329a;

            public a(r5.Z z7) {
                this.f23329a = z7;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0.this.f23313u.d(this.f23329a);
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C f23331a;

            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b bVar = b.this;
                    C0.this.g0(bVar.f23331a);
                }
            }

            public b(C c7) {
                this.f23331a = c7;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0.this.f23294b.execute(new a());
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0.this.f23318z = true;
                C0.this.f23313u.b(C0.this.f23311s.f23397a, C0.this.f23311s.f23398b, C0.this.f23311s.f23399c);
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C f23335a;

            public d(C c7) {
                this.f23335a = c7;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0.this.g0(this.f23335a);
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Q0.a f23337a;

            public e(Q0.a aVar) {
                this.f23337a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0.this.f23313u.a(this.f23337a);
            }
        }

        public class f implements Runnable {
            public f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C0.this.f23318z) {
                    return;
                }
                C0.this.f23313u.c();
            }
        }

        public B(C c7) {
            this.f23327a = c7;
        }

        @Override // t5.Q0
        public void a(Q0.a aVar) {
            A a7 = C0.this.f23307o;
            H2.m.u(a7.f23324f != null, "Headers should be received prior to messages.");
            if (a7.f23324f != this.f23327a) {
                S.e(aVar);
            } else {
                C0.this.f23295c.execute(new e(aVar));
            }
        }

        @Override // t5.InterfaceC2698s
        public void b(r5.l0 l0Var, InterfaceC2698s.a aVar, r5.Z z7) {
            u uVar;
            synchronized (C0.this.f23301i) {
                C0 c02 = C0.this;
                c02.f23307o = c02.f23307o.g(this.f23327a);
                C0.this.f23306n.a(l0Var.m());
            }
            if (C0.this.f23310r.decrementAndGet() == Integer.MIN_VALUE) {
                C0.this.f23295c.execute(new c());
                return;
            }
            C c7 = this.f23327a;
            if (c7.f23342c) {
                C0.this.d0(c7);
                if (C0.this.f23307o.f23324f == this.f23327a) {
                    C0.this.n0(l0Var, aVar, z7);
                    return;
                }
                return;
            }
            InterfaceC2698s.a aVar2 = InterfaceC2698s.a.MISCARRIED;
            if (aVar == aVar2 && C0.this.f23309q.incrementAndGet() > 1000) {
                C0.this.d0(this.f23327a);
                if (C0.this.f23307o.f23324f == this.f23327a) {
                    C0.this.n0(r5.l0.f22719s.q("Too many transparent retries. Might be a bug in gRPC").p(l0Var.d()), aVar, z7);
                    return;
                }
                return;
            }
            if (C0.this.f23307o.f23324f == null) {
                if (aVar == aVar2 || (aVar == InterfaceC2698s.a.REFUSED && C0.this.f23308p.compareAndSet(false, true))) {
                    C cE0 = C0.this.e0(this.f23327a.f23343d, true);
                    if (cE0 == null) {
                        return;
                    }
                    if (C0.this.f23300h) {
                        synchronized (C0.this.f23301i) {
                            C0 c03 = C0.this;
                            c03.f23307o = c03.f23307o.f(this.f23327a, cE0);
                        }
                    }
                    C0.this.f23294b.execute(new d(cE0));
                    return;
                }
                if (aVar != InterfaceC2698s.a.DROPPED) {
                    C0.this.f23308p.set(true);
                    if (C0.this.f23300h) {
                        v vVarF = f(l0Var, z7);
                        if (vVarF.f23389a) {
                            C0.this.m0(vVarF.f23390b);
                        }
                        synchronized (C0.this.f23301i) {
                            try {
                                C0 c04 = C0.this;
                                c04.f23307o = c04.f23307o.e(this.f23327a);
                                if (vVarF.f23389a) {
                                    C0 c05 = C0.this;
                                    if (!c05.i0(c05.f23307o)) {
                                        if (!C0.this.f23307o.f23322d.isEmpty()) {
                                        }
                                    }
                                    return;
                                }
                            } finally {
                            }
                        }
                    } else {
                        x xVarG = g(l0Var, z7);
                        if (xVarG.f23395a) {
                            C cE02 = C0.this.e0(this.f23327a.f23343d + 1, false);
                            if (cE02 == null) {
                                return;
                            }
                            synchronized (C0.this.f23301i) {
                                C0 c06 = C0.this;
                                uVar = new u(c06.f23301i);
                                c06.f23314v = uVar;
                            }
                            uVar.c(C0.this.f23296d.schedule(new b(cE02), xVarG.f23396b, TimeUnit.NANOSECONDS));
                            return;
                        }
                    }
                } else if (C0.this.f23300h) {
                    C0.this.h0();
                }
            }
            C0.this.d0(this.f23327a);
            if (C0.this.f23307o.f23324f == this.f23327a) {
                C0.this.n0(l0Var, aVar, z7);
            }
        }

        @Override // t5.Q0
        public void c() {
            if (C0.this.d()) {
                C0.this.f23295c.execute(new f());
            }
        }

        @Override // t5.InterfaceC2698s
        public void d(r5.Z z7) {
            if (this.f23327a.f23343d > 0) {
                Z.g gVar = C0.f23289A;
                z7.e(gVar);
                z7.p(gVar, String.valueOf(this.f23327a.f23343d));
            }
            C0.this.d0(this.f23327a);
            if (C0.this.f23307o.f23324f == this.f23327a) {
                if (C0.this.f23305m != null) {
                    C0.this.f23305m.c();
                }
                C0.this.f23295c.execute(new a(z7));
            }
        }

        public final Integer e(r5.Z z7) {
            String str = (String) z7.g(C0.f23290B);
            if (str == null) {
                return null;
            }
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public final v f(r5.l0 l0Var, r5.Z z7) {
            Integer numE = e(z7);
            boolean zContains = C0.this.f23299g.f23581c.contains(l0Var.m());
            boolean z8 = (C0.this.f23305m == null || (!zContains && (numE == null || numE.intValue() >= 0))) ? false : !C0.this.f23305m.b();
            if (zContains && !z8 && !l0Var.o() && numE != null && numE.intValue() > 0) {
                numE = 0;
            }
            return new v(zContains && !z8, numE);
        }

        public final x g(r5.l0 l0Var, r5.Z z7) {
            long nanos = 0;
            boolean z8 = false;
            if (C0.this.f23298f == null) {
                return new x(false, 0L);
            }
            boolean zContains = C0.this.f23298f.f23443f.contains(l0Var.m());
            Integer numE = e(z7);
            boolean z9 = (C0.this.f23305m == null || (!zContains && (numE == null || numE.intValue() >= 0))) ? false : !C0.this.f23305m.b();
            if (C0.this.f23298f.f23438a > this.f23327a.f23343d + 1 && !z9) {
                if (numE == null) {
                    if (zContains) {
                        nanos = (long) (C0.this.f23316x * C0.f23292D.nextDouble());
                        C0.this.f23316x = Math.min((long) (r10.f23316x * C0.this.f23298f.f23441d), C0.this.f23298f.f23440c);
                        z8 = true;
                    }
                } else if (numE.intValue() >= 0) {
                    nanos = TimeUnit.MILLISECONDS.toNanos(numE.intValue());
                    C0 c02 = C0.this;
                    c02.f23316x = c02.f23298f.f23439b;
                    z8 = true;
                }
            }
            return new x(z8, nanos);
        }
    }

    public static final class C {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public t5.r f23340a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f23341b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f23342c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f23343d;

        public C(int i7) {
            this.f23343d = i7;
        }
    }

    public static final class D {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f23344a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23345b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f23346c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicInteger f23347d;

        public D(float f7, float f8) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.f23347d = atomicInteger;
            this.f23346c = (int) (f8 * 1000.0f);
            int i7 = (int) (f7 * 1000.0f);
            this.f23344a = i7;
            this.f23345b = i7 / 2;
            atomicInteger.set(i7);
        }

        public boolean a() {
            return this.f23347d.get() > this.f23345b;
        }

        public boolean b() {
            int i7;
            int i8;
            do {
                i7 = this.f23347d.get();
                if (i7 == 0) {
                    return false;
                }
                i8 = i7 - 1000;
            } while (!this.f23347d.compareAndSet(i7, Math.max(i8, 0)));
            return i8 > this.f23345b;
        }

        public void c() {
            int i7;
            int i8;
            do {
                i7 = this.f23347d.get();
                i8 = this.f23344a;
                if (i7 == i8) {
                    return;
                }
            } while (!this.f23347d.compareAndSet(i7, Math.min(this.f23346c + i7, i8)));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof D)) {
                return false;
            }
            D d7 = (D) obj;
            return this.f23344a == d7.f23344a && this.f23346c == d7.f23346c;
        }

        public int hashCode() {
            return H2.i.b(Integer.valueOf(this.f23344a), Integer.valueOf(this.f23346c));
        }
    }

    /* JADX INFO: renamed from: t5.C0$a, reason: case insensitive filesystem */
    public class C2659a implements Thread.UncaughtExceptionHandler {
        public C2659a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            throw r5.l0.k(th).q("Uncaught exception in the SynchronizationContext. Re-thrown.").d();
        }
    }

    /* JADX INFO: renamed from: t5.C0$b, reason: case insensitive filesystem */
    public class C2660b implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f23349a;

        public C2660b(String str) {
            this.f23349a = str;
        }

        @Override // t5.C0.r
        public void a(C c7) {
            c7.f23340a.l(this.f23349a);
        }
    }

    /* JADX INFO: renamed from: t5.C0$c, reason: case insensitive filesystem */
    public class RunnableC2661c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection f23351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ C f23352b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Future f23353c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Future f23354d;

        public RunnableC2661c(Collection collection, C c7, Future future, Future future2) {
            this.f23351a = collection;
            this.f23352b = c7;
            this.f23353c = future;
            this.f23354d = future2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (C c7 : this.f23351a) {
                if (c7 != this.f23352b) {
                    c7.f23340a.b(C0.f23291C);
                }
            }
            Future future = this.f23353c;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.f23354d;
            if (future2 != null) {
                future2.cancel(false);
            }
            C0.this.k0();
        }
    }

    /* JADX INFO: renamed from: t5.C0$d, reason: case insensitive filesystem */
    public class C2662d implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2598n f23356a;

        public C2662d(InterfaceC2598n interfaceC2598n) {
            this.f23356a = interfaceC2598n;
        }

        @Override // t5.C0.r
        public void a(C c7) {
            c7.f23340a.a(this.f23356a);
        }
    }

    public class e implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C2603t f23358a;

        public e(C2603t c2603t) {
            this.f23358a = c2603t;
        }

        @Override // t5.C0.r
        public void a(C c7) {
            c7.f23340a.p(this.f23358a);
        }
    }

    public class f implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C2605v f23360a;

        public f(C2605v c2605v) {
            this.f23360a = c2605v;
        }

        @Override // t5.C0.r
        public void a(C c7) {
            c7.f23340a.o(this.f23360a);
        }
    }

    public class g implements r {
        public g() {
        }

        @Override // t5.C0.r
        public void a(C c7) {
            c7.f23340a.flush();
        }
    }

    public class h implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f23363a;

        public h(boolean z7) {
            this.f23363a = z7;
        }

        @Override // t5.C0.r
        public void a(C c7) {
            c7.f23340a.q(this.f23363a);
        }
    }

    public class i implements r {
        public i() {
        }

        @Override // t5.C0.r
        public void a(C c7) {
            c7.f23340a.m();
        }
    }

    public class j implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23366a;

        public j(int i7) {
            this.f23366a = i7;
        }

        @Override // t5.C0.r
        public void a(C c7) {
            c7.f23340a.i(this.f23366a);
        }
    }

    public class k implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23368a;

        public k(int i7) {
            this.f23368a = i7;
        }

        @Override // t5.C0.r
        public void a(C c7) {
            c7.f23340a.j(this.f23368a);
        }
    }

    public class l implements r {
        public l() {
        }

        @Override // t5.C0.r
        public void a(C c7) {
            c7.f23340a.g();
        }
    }

    public class m implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f23371a;

        public m(int i7) {
            this.f23371a = i7;
        }

        @Override // t5.C0.r
        public void a(C c7) {
            c7.f23340a.h(this.f23371a);
        }
    }

    public class n implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f23373a;

        public n(Object obj) {
            this.f23373a = obj;
        }

        @Override // t5.C0.r
        public void a(C c7) {
            c7.f23340a.e(C0.this.f23293a.j(this.f23373a));
            c7.f23340a.flush();
        }
    }

    public class o extends AbstractC2595k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC2595k f23375a;

        public o(AbstractC2595k abstractC2595k) {
            this.f23375a = abstractC2595k;
        }

        @Override // r5.AbstractC2595k.a
        public AbstractC2595k a(AbstractC2595k.b bVar, r5.Z z7) {
            return this.f23375a;
        }
    }

    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0.this.f23318z) {
                return;
            }
            C0.this.f23313u.c();
        }
    }

    public class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ r5.l0 f23378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC2698s.a f23379b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ r5.Z f23380c;

        public q(r5.l0 l0Var, InterfaceC2698s.a aVar, r5.Z z7) {
            this.f23378a = l0Var;
            this.f23379b = aVar;
            this.f23380c = z7;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0.this.f23318z = true;
            C0.this.f23313u.b(this.f23378a, this.f23379b, this.f23380c);
        }
    }

    public interface r {
        void a(C c7);
    }

    public class s extends AbstractC2595k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final C f23382b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f23383c;

        public s(C c7) {
            this.f23382b = c7;
        }

        @Override // r5.o0
        public void h(long j7) {
            if (C0.this.f23307o.f23324f != null) {
                return;
            }
            synchronized (C0.this.f23301i) {
                try {
                    if (C0.this.f23307o.f23324f == null && !this.f23382b.f23341b) {
                        long j8 = this.f23383c + j7;
                        this.f23383c = j8;
                        if (j8 <= C0.this.f23312t) {
                            return;
                        }
                        if (this.f23383c > C0.this.f23303k) {
                            this.f23382b.f23342c = true;
                        } else {
                            long jA = C0.this.f23302j.a(this.f23383c - C0.this.f23312t);
                            C0.this.f23312t = this.f23383c;
                            if (jA > C0.this.f23304l) {
                                this.f23382b.f23342c = true;
                            }
                        }
                        C c7 = this.f23382b;
                        Runnable runnableC0 = c7.f23342c ? C0.this.c0(c7) : null;
                        if (runnableC0 != null) {
                            runnableC0.run();
                        }
                    }
                } finally {
                }
            }
        }
    }

    public static final class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicLong f23385a = new AtomicLong();

        public long a(long j7) {
            return this.f23385a.addAndGet(j7);
        }
    }

    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f23386a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Future f23387b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f23388c;

        public u(Object obj) {
            this.f23386a = obj;
        }

        public boolean a() {
            return this.f23388c;
        }

        public Future b() {
            this.f23388c = true;
            return this.f23387b;
        }

        public void c(Future future) {
            synchronized (this.f23386a) {
                try {
                    if (!this.f23388c) {
                        this.f23387b = future;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static final class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f23389a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f23390b;

        public v(boolean z7, Integer num) {
            this.f23389a = z7;
            this.f23390b = num;
        }
    }

    public final class w implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u f23391a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ C f23393a;

            public a(C c7) {
                this.f23393a = c7;
            }

            @Override // java.lang.Runnable
            public void run() {
                u uVar;
                boolean z7;
                synchronized (C0.this.f23301i) {
                    try {
                        uVar = null;
                        if (w.this.f23391a.a()) {
                            z7 = true;
                        } else {
                            C0 c02 = C0.this;
                            c02.f23307o = c02.f23307o.a(this.f23393a);
                            C0 c03 = C0.this;
                            if (c03.i0(c03.f23307o) && (C0.this.f23305m == null || C0.this.f23305m.a())) {
                                C0 c04 = C0.this;
                                uVar = new u(c04.f23301i);
                                c04.f23315w = uVar;
                            } else {
                                C0 c05 = C0.this;
                                c05.f23307o = c05.f23307o.d();
                                C0.this.f23315w = null;
                            }
                            z7 = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z7) {
                    this.f23393a.f23340a.n(C0.this.new B(this.f23393a));
                    this.f23393a.f23340a.b(r5.l0.f22706f.q("Unneeded hedging"));
                } else {
                    if (uVar != null) {
                        uVar.c(C0.this.f23296d.schedule(C0.this.new w(uVar), C0.this.f23299g.f23580b, TimeUnit.NANOSECONDS));
                    }
                    C0.this.g0(this.f23393a);
                }
            }
        }

        public w(u uVar) {
            this.f23391a = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0 c02 = C0.this;
            C cE0 = c02.e0(c02.f23307o.f23323e, false);
            if (cE0 == null) {
                return;
            }
            C0.this.f23294b.execute(new a(cE0));
        }
    }

    public static final class x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f23395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f23396b;

        public x(boolean z7, long j7) {
            this.f23395a = z7;
            this.f23396b = j7;
        }
    }

    public static final class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r5.l0 f23397a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC2698s.a f23398b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final r5.Z f23399c;

        public y(r5.l0 l0Var, InterfaceC2698s.a aVar, r5.Z z7) {
            this.f23397a = l0Var;
            this.f23398b = aVar;
            this.f23399c = z7;
        }
    }

    public class z implements r {
        public z() {
        }

        @Override // t5.C0.r
        public void a(C c7) {
            c7.f23340a.n(C0.this.new B(c7));
        }
    }

    static {
        Z.d dVar = r5.Z.f22587e;
        f23289A = Z.g.e("grpc-previous-rpc-attempts", dVar);
        f23290B = Z.g.e("grpc-retry-pushback-ms", dVar);
        f23291C = r5.l0.f22706f.q("Stream thrown away because RetriableStream committed");
        f23292D = new Random();
    }

    public C0(r5.a0 a0Var, r5.Z z7, t tVar, long j7, long j8, Executor executor, ScheduledExecutorService scheduledExecutorService, D0 d02, U u7, D d7) {
        this.f23293a = a0Var;
        this.f23302j = tVar;
        this.f23303k = j7;
        this.f23304l = j8;
        this.f23294b = executor;
        this.f23296d = scheduledExecutorService;
        this.f23297e = z7;
        this.f23298f = d02;
        if (d02 != null) {
            this.f23316x = d02.f23439b;
        }
        this.f23299g = u7;
        H2.m.e(d02 == null || u7 == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.f23300h = u7 != null;
        this.f23305m = d7;
    }

    @Override // t5.P0
    public final void a(InterfaceC2598n interfaceC2598n) {
        f0(new C2662d(interfaceC2598n));
    }

    @Override // t5.r
    public final void b(r5.l0 l0Var) {
        C c7;
        C c8 = new C(0);
        c8.f23340a = new C2694p0();
        Runnable runnableC0 = c0(c8);
        if (runnableC0 != null) {
            synchronized (this.f23301i) {
                this.f23307o = this.f23307o.h(c8);
            }
            runnableC0.run();
            n0(l0Var, InterfaceC2698s.a.PROCESSED, new r5.Z());
            return;
        }
        synchronized (this.f23301i) {
            try {
                if (this.f23307o.f23321c.contains(this.f23307o.f23324f)) {
                    c7 = this.f23307o.f23324f;
                } else {
                    this.f23317y = l0Var;
                    c7 = null;
                }
                this.f23307o = this.f23307o.b();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (c7 != null) {
            c7.f23340a.b(l0Var);
        }
    }

    public final Runnable c0(C c7) {
        Future future;
        Future future2;
        synchronized (this.f23301i) {
            try {
                if (this.f23307o.f23324f != null) {
                    return null;
                }
                Collection collection = this.f23307o.f23321c;
                this.f23307o = this.f23307o.c(c7);
                this.f23302j.a(-this.f23312t);
                u uVar = this.f23314v;
                if (uVar != null) {
                    Future futureB = uVar.b();
                    this.f23314v = null;
                    future = futureB;
                } else {
                    future = null;
                }
                u uVar2 = this.f23315w;
                if (uVar2 != null) {
                    Future futureB2 = uVar2.b();
                    this.f23315w = null;
                    future2 = futureB2;
                } else {
                    future2 = null;
                }
                return new RunnableC2661c(collection, c7, future, future2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t5.P0
    public final boolean d() {
        Iterator it = this.f23307o.f23321c.iterator();
        while (it.hasNext()) {
            if (((C) it.next()).f23340a.d()) {
                return true;
            }
        }
        return false;
    }

    public final void d0(C c7) {
        Runnable runnableC0 = c0(c7);
        if (runnableC0 != null) {
            this.f23294b.execute(runnableC0);
        }
    }

    @Override // t5.P0
    public final void e(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    public final C e0(int i7, boolean z7) {
        int i8;
        do {
            i8 = this.f23310r.get();
            if (i8 < 0) {
                return null;
            }
        } while (!this.f23310r.compareAndSet(i8, i8 + 1));
        C c7 = new C(i7);
        c7.f23340a = j0(p0(this.f23297e, i7), new o(new s(c7)), i7, z7);
        return c7;
    }

    public final void f0(r rVar) {
        Collection collection;
        synchronized (this.f23301i) {
            try {
                if (!this.f23307o.f23319a) {
                    this.f23307o.f23320b.add(rVar);
                }
                collection = this.f23307o.f23321c;
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            rVar.a((C) it.next());
        }
    }

    @Override // t5.P0
    public final void flush() {
        A a7 = this.f23307o;
        if (a7.f23319a) {
            a7.f23324f.f23340a.flush();
        } else {
            f0(new g());
        }
    }

    @Override // t5.P0
    public void g() {
        f0(new l());
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
    
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0038, code lost:
    
        r8.f23295c.execute(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003e, code lost:
    
        if (r2 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0040, code lost:
    
        r9.f23340a.n(new t5.C0.B(r8, r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
    
        r0 = r9.f23340a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0050, code lost:
    
        if (r8.f23307o.f23324f != r9) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0052, code lost:
    
        r9 = r8.f23317y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0055, code lost:
    
        r9 = t5.C0.f23291C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0057, code lost:
    
        r0.b(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x005a, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0088, code lost:
    
        r0 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0090, code lost:
    
        if (r0.hasNext() == false) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0092, code lost:
    
        r4 = (t5.C0.r) r0.next();
        r4.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009d, code lost:
    
        if ((r4 instanceof t5.C0.z) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009f, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a0, code lost:
    
        r4 = r8.f23307o;
        r5 = r4.f23324f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
    
        if (r5 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a6, code lost:
    
        if (r5 == r9) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ab, code lost:
    
        if (r4.f23325g == false) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g0(t5.C0.C r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            r2 = r0
            r3 = r1
        L4:
            java.lang.Object r4 = r8.f23301i
            monitor-enter(r4)
            t5.C0$A r5 = r8.f23307o     // Catch: java.lang.Throwable -> L11
            t5.C0$C r6 = r5.f23324f     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L14
            if (r6 == r9) goto L14
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            goto L36
        L11:
            r9 = move-exception
            goto Lb0
        L14:
            boolean r6 = r5.f23325g     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L1a
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            goto L36
        L1a:
            java.util.List r6 = r5.f23320b     // Catch: java.lang.Throwable -> L11
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L11
            if (r0 != r6) goto L5b
            t5.C0$A r0 = r5.h(r9)     // Catch: java.lang.Throwable -> L11
            r8.f23307o = r0     // Catch: java.lang.Throwable -> L11
            boolean r0 = r8.d()     // Catch: java.lang.Throwable -> L11
            if (r0 != 0) goto L30
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            return
        L30:
            t5.C0$p r1 = new t5.C0$p     // Catch: java.lang.Throwable -> L11
            r1.<init>()     // Catch: java.lang.Throwable -> L11
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
        L36:
            if (r1 == 0) goto L3e
            java.util.concurrent.Executor r9 = r8.f23295c
            r9.execute(r1)
            return
        L3e:
            if (r2 != 0) goto L4a
            t5.r r0 = r9.f23340a
            t5.C0$B r1 = new t5.C0$B
            r1.<init>(r9)
            r0.n(r1)
        L4a:
            t5.r r0 = r9.f23340a
            t5.C0$A r1 = r8.f23307o
            t5.C0$C r1 = r1.f23324f
            if (r1 != r9) goto L55
            r5.l0 r9 = r8.f23317y
            goto L57
        L55:
            r5.l0 r9 = t5.C0.f23291C
        L57:
            r0.b(r9)
            return
        L5b:
            boolean r6 = r9.f23341b     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L61
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            return
        L61:
            int r6 = r0 + 128
            java.util.List r7 = r5.f23320b     // Catch: java.lang.Throwable -> L11
            int r7 = r7.size()     // Catch: java.lang.Throwable -> L11
            int r6 = java.lang.Math.min(r6, r7)     // Catch: java.lang.Throwable -> L11
            if (r3 != 0) goto L7b
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L11
            java.util.List r5 = r5.f23320b     // Catch: java.lang.Throwable -> L11
            java.util.List r0 = r5.subList(r0, r6)     // Catch: java.lang.Throwable -> L11
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L11
            goto L87
        L7b:
            r3.clear()     // Catch: java.lang.Throwable -> L11
            java.util.List r5 = r5.f23320b     // Catch: java.lang.Throwable -> L11
            java.util.List r0 = r5.subList(r0, r6)     // Catch: java.lang.Throwable -> L11
            r3.addAll(r0)     // Catch: java.lang.Throwable -> L11
        L87:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            java.util.Iterator r0 = r3.iterator()
        L8c:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto Lad
            java.lang.Object r4 = r0.next()
            t5.C0$r r4 = (t5.C0.r) r4
            r4.a(r9)
            boolean r4 = r4 instanceof t5.C0.z
            if (r4 == 0) goto La0
            r2 = 1
        La0:
            t5.C0$A r4 = r8.f23307o
            t5.C0$C r5 = r4.f23324f
            if (r5 == 0) goto La9
            if (r5 == r9) goto La9
            goto Lad
        La9:
            boolean r4 = r4.f23325g
            if (r4 == 0) goto L8c
        Lad:
            r0 = r6
            goto L4
        Lb0:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: t5.C0.g0(t5.C0$C):void");
    }

    @Override // t5.P0
    public final void h(int i7) {
        A a7 = this.f23307o;
        if (a7.f23319a) {
            a7.f23324f.f23340a.h(i7);
        } else {
            f0(new m(i7));
        }
    }

    public final void h0() {
        Future future;
        synchronized (this.f23301i) {
            try {
                u uVar = this.f23315w;
                future = null;
                if (uVar != null) {
                    Future futureB = uVar.b();
                    this.f23315w = null;
                    future = futureB;
                }
                this.f23307o = this.f23307o.d();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    @Override // t5.r
    public final void i(int i7) {
        f0(new j(i7));
    }

    public final boolean i0(A a7) {
        return a7.f23324f == null && a7.f23323e < this.f23299g.f23579a && !a7.f23326h;
    }

    @Override // t5.r
    public final void j(int i7) {
        f0(new k(i7));
    }

    public abstract t5.r j0(r5.Z z7, AbstractC2595k.a aVar, int i7, boolean z8);

    @Override // t5.r
    public void k(Y y7) {
        A a7;
        synchronized (this.f23301i) {
            y7.b("closed", this.f23306n);
            a7 = this.f23307o;
        }
        if (a7.f23324f != null) {
            Y y8 = new Y();
            a7.f23324f.f23340a.k(y8);
            y7.b("committed", y8);
            return;
        }
        Y y9 = new Y();
        for (C c7 : a7.f23321c) {
            Y y10 = new Y();
            c7.f23340a.k(y10);
            y9.a(y10);
        }
        y7.b("open", y9);
    }

    public abstract void k0();

    @Override // t5.r
    public final void l(String str) {
        f0(new C2660b(str));
    }

    public abstract r5.l0 l0();

    @Override // t5.r
    public final void m() {
        f0(new i());
    }

    public final void m0(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            h0();
            return;
        }
        synchronized (this.f23301i) {
            try {
                u uVar = this.f23315w;
                if (uVar == null) {
                    return;
                }
                Future futureB = uVar.b();
                u uVar2 = new u(this.f23301i);
                this.f23315w = uVar2;
                if (futureB != null) {
                    futureB.cancel(false);
                }
                uVar2.c(this.f23296d.schedule(new w(uVar2), num.intValue(), TimeUnit.MILLISECONDS));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // t5.r
    public final void n(InterfaceC2698s interfaceC2698s) {
        u uVar;
        D d7;
        this.f23313u = interfaceC2698s;
        r5.l0 l0VarL0 = l0();
        if (l0VarL0 != null) {
            b(l0VarL0);
            return;
        }
        synchronized (this.f23301i) {
            this.f23307o.f23320b.add(new z());
        }
        C cE0 = e0(0, false);
        if (cE0 == null) {
            return;
        }
        if (this.f23300h) {
            synchronized (this.f23301i) {
                try {
                    this.f23307o = this.f23307o.a(cE0);
                    if (i0(this.f23307o) && ((d7 = this.f23305m) == null || d7.a())) {
                        uVar = new u(this.f23301i);
                        this.f23315w = uVar;
                    } else {
                        uVar = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (uVar != null) {
                uVar.c(this.f23296d.schedule(new w(uVar), this.f23299g.f23580b, TimeUnit.NANOSECONDS));
            }
        }
        g0(cE0);
    }

    public final void n0(r5.l0 l0Var, InterfaceC2698s.a aVar, r5.Z z7) {
        this.f23311s = new y(l0Var, aVar, z7);
        if (this.f23310r.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            this.f23295c.execute(new q(l0Var, aVar, z7));
        }
    }

    @Override // t5.r
    public final void o(C2605v c2605v) {
        f0(new f(c2605v));
    }

    public final void o0(Object obj) {
        A a7 = this.f23307o;
        if (a7.f23319a) {
            a7.f23324f.f23340a.e(this.f23293a.j(obj));
        } else {
            f0(new n(obj));
        }
    }

    @Override // t5.r
    public final void p(C2603t c2603t) {
        f0(new e(c2603t));
    }

    public final r5.Z p0(r5.Z z7, int i7) {
        r5.Z z8 = new r5.Z();
        z8.m(z7);
        if (i7 > 0) {
            z8.p(f23289A, String.valueOf(i7));
        }
        return z8;
    }

    @Override // t5.r
    public final void q(boolean z7) {
        f0(new h(z7));
    }
}
