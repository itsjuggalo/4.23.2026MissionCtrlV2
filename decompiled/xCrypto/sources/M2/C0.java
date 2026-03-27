package M2;

import K2.AbstractC0363k;
import K2.C0353a;
import K2.C0371t;
import K2.C0373v;
import K2.InterfaceC0366n;
import K2.Z;
import M2.InterfaceC0443s;
import M2.Q0;
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

/* JADX INFO: loaded from: classes3.dex */
public abstract class C0 implements M2.r {

    /* JADX INFO: renamed from: A, reason: collision with root package name */
    public static final Z.g f1736A;

    /* JADX INFO: renamed from: B, reason: collision with root package name */
    public static final Z.g f1737B;

    /* JADX INFO: renamed from: C, reason: collision with root package name */
    public static final K2.l0 f1738C;

    /* JADX INFO: renamed from: D, reason: collision with root package name */
    public static Random f1739D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K2.a0 f1740a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f1741b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f1743d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final K2.Z f1744e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final D0 f1745f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final U f1746g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f1747h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final u f1749j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f1750k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f1751l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final E f1752m;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public z f1758s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f1759t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public InterfaceC0443s f1760u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public v f1761v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public v f1762w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f1763x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public K2.l0 f1764y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1765z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f1742c = new K2.p0(new C0403a());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f1748i = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Y f1753n = new Y();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile B f1754o = new B(new ArrayList(8), Collections.EMPTY_LIST, null, null, false, false, false, 0);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f1755p = new AtomicBoolean();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicInteger f1756q = new AtomicInteger();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicInteger f1757r = new AtomicInteger();

    public class A implements s {
        public A() {
        }

        @Override // M2.C0.s
        public void a(D d4) {
            d4.f1788a.i(C0.this.new C(d4));
        }
    }

    public static final class B {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f1767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f1768b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Collection f1769c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Collection f1770d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f1771e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final D f1772f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f1773g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f1774h;

        public B(List list, Collection collection, Collection collection2, D d4, boolean z4, boolean z5, boolean z6, int i4) {
            this.f1768b = list;
            this.f1769c = (Collection) Z1.m.o(collection, "drainedSubstreams");
            this.f1772f = d4;
            this.f1770d = collection2;
            this.f1773g = z4;
            this.f1767a = z5;
            this.f1774h = z6;
            this.f1771e = i4;
            Z1.m.u(!z5 || list == null, "passThrough should imply buffer is null");
            Z1.m.u((z5 && d4 == null) ? false : true, "passThrough should imply winningSubstream != null");
            Z1.m.u(!z5 || (collection.size() == 1 && collection.contains(d4)) || (collection.size() == 0 && d4.f1789b), "passThrough should imply winningSubstream is drained");
            Z1.m.u((z4 && d4 == null) ? false : true, "cancelled should imply committed");
        }

        public B a(D d4) {
            Collection collectionUnmodifiableCollection;
            Z1.m.u(!this.f1774h, "hedging frozen");
            Z1.m.u(this.f1772f == null, "already committed");
            if (this.f1770d == null) {
                collectionUnmodifiableCollection = Collections.singleton(d4);
            } else {
                ArrayList arrayList = new ArrayList(this.f1770d);
                arrayList.add(d4);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            return new B(this.f1768b, this.f1769c, collectionUnmodifiableCollection, this.f1772f, this.f1773g, this.f1767a, this.f1774h, this.f1771e + 1);
        }

        public B b() {
            return new B(this.f1768b, this.f1769c, this.f1770d, this.f1772f, true, this.f1767a, this.f1774h, this.f1771e);
        }

        public B c(D d4) {
            List list;
            boolean z4;
            Collection collectionSingleton;
            Z1.m.u(this.f1772f == null, "Already committed");
            List list2 = this.f1768b;
            if (this.f1769c.contains(d4)) {
                collectionSingleton = Collections.singleton(d4);
                list = null;
                z4 = true;
            } else {
                list = list2;
                z4 = false;
                collectionSingleton = Collections.EMPTY_LIST;
            }
            return new B(list, collectionSingleton, this.f1770d, d4, this.f1773g, z4, this.f1774h, this.f1771e);
        }

        public B d() {
            return this.f1774h ? this : new B(this.f1768b, this.f1769c, this.f1770d, this.f1772f, this.f1773g, this.f1767a, true, this.f1771e);
        }

        public B e(D d4) {
            ArrayList arrayList = new ArrayList(this.f1770d);
            arrayList.remove(d4);
            return new B(this.f1768b, this.f1769c, Collections.unmodifiableCollection(arrayList), this.f1772f, this.f1773g, this.f1767a, this.f1774h, this.f1771e);
        }

        public B f(D d4, D d5) {
            ArrayList arrayList = new ArrayList(this.f1770d);
            arrayList.remove(d4);
            arrayList.add(d5);
            return new B(this.f1768b, this.f1769c, Collections.unmodifiableCollection(arrayList), this.f1772f, this.f1773g, this.f1767a, this.f1774h, this.f1771e);
        }

        public B g(D d4) {
            d4.f1789b = true;
            if (!this.f1769c.contains(d4)) {
                return this;
            }
            ArrayList arrayList = new ArrayList(this.f1769c);
            arrayList.remove(d4);
            return new B(this.f1768b, Collections.unmodifiableCollection(arrayList), this.f1770d, this.f1772f, this.f1773g, this.f1767a, this.f1774h, this.f1771e);
        }

        public B h(D d4) {
            Collection collectionUnmodifiableCollection;
            Z1.m.u(!this.f1767a, "Already passThrough");
            if (d4.f1789b) {
                collectionUnmodifiableCollection = this.f1769c;
            } else if (this.f1769c.isEmpty()) {
                collectionUnmodifiableCollection = Collections.singletonList(d4);
            } else {
                ArrayList arrayList = new ArrayList(this.f1769c);
                arrayList.add(d4);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            Collection collection = collectionUnmodifiableCollection;
            D d5 = this.f1772f;
            boolean z4 = d5 != null;
            List list = this.f1768b;
            if (z4) {
                Z1.m.u(d5 == d4, "Another RPC attempt has already committed");
                list = null;
            }
            return new B(list, collection, this.f1770d, this.f1772f, this.f1773g, z4, this.f1774h, this.f1771e);
        }
    }

    public final class C implements InterfaceC0443s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final D f1775a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ K2.Z f1777a;

            public a(K2.Z z4) {
                this.f1777a = z4;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0.this.f1760u.d(this.f1777a);
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ D f1779a;

            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b bVar = b.this;
                    C0.this.h0(bVar.f1779a);
                }
            }

            public b(D d4) {
                this.f1779a = d4;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0.this.f1741b.execute(new a());
            }
        }

        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C0.this.f1765z = true;
                C0.this.f1760u.b(C0.this.f1758s.f1847a, C0.this.f1758s.f1848b, C0.this.f1758s.f1849c);
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ D f1783a;

            public d(D d4) {
                this.f1783a = d4;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0.this.h0(this.f1783a);
            }
        }

        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Q0.a f1785a;

            public e(Q0.a aVar) {
                this.f1785a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                C0.this.f1760u.a(this.f1785a);
            }
        }

        public class f implements Runnable {
            public f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (C0.this.f1765z) {
                    return;
                }
                C0.this.f1760u.c();
            }
        }

        public C(D d4) {
            this.f1775a = d4;
        }

        @Override // M2.Q0
        public void a(Q0.a aVar) {
            B b4 = C0.this.f1754o;
            Z1.m.u(b4.f1772f != null, "Headers should be received prior to messages.");
            if (b4.f1772f != this.f1775a) {
                S.d(aVar);
            } else {
                C0.this.f1742c.execute(new e(aVar));
            }
        }

        @Override // M2.InterfaceC0443s
        public void b(K2.l0 l0Var, InterfaceC0443s.a aVar, K2.Z z4) {
            v vVar;
            synchronized (C0.this.f1748i) {
                C0 c02 = C0.this;
                c02.f1754o = c02.f1754o.g(this.f1775a);
                C0.this.f1753n.a(l0Var.m());
            }
            if (C0.this.f1757r.decrementAndGet() == Integer.MIN_VALUE) {
                C0.this.f1742c.execute(new c());
                return;
            }
            D d4 = this.f1775a;
            if (d4.f1790c) {
                C0.this.e0(d4);
                if (C0.this.f1754o.f1772f == this.f1775a) {
                    C0.this.o0(l0Var, aVar, z4);
                    return;
                }
                return;
            }
            InterfaceC0443s.a aVar2 = InterfaceC0443s.a.MISCARRIED;
            if (aVar == aVar2 && C0.this.f1756q.incrementAndGet() > 1000) {
                C0.this.e0(this.f1775a);
                if (C0.this.f1754o.f1772f == this.f1775a) {
                    C0.this.o0(K2.l0.f1229s.q("Too many transparent retries. Might be a bug in gRPC").p(l0Var.d()), aVar, z4);
                    return;
                }
                return;
            }
            if (C0.this.f1754o.f1772f == null) {
                if (aVar == aVar2 || (aVar == InterfaceC0443s.a.REFUSED && C0.this.f1755p.compareAndSet(false, true))) {
                    D dF0 = C0.this.f0(this.f1775a.f1791d, true);
                    if (dF0 == null) {
                        return;
                    }
                    if (C0.this.f1747h) {
                        synchronized (C0.this.f1748i) {
                            C0 c03 = C0.this;
                            c03.f1754o = c03.f1754o.f(this.f1775a, dF0);
                        }
                    }
                    C0.this.f1741b.execute(new d(dF0));
                    return;
                }
                if (aVar != InterfaceC0443s.a.DROPPED) {
                    C0.this.f1755p.set(true);
                    if (C0.this.f1747h) {
                        w wVarF = f(l0Var, z4);
                        if (wVarF.f1839a) {
                            C0.this.n0(wVarF.f1840b);
                        }
                        synchronized (C0.this.f1748i) {
                            try {
                                C0 c04 = C0.this;
                                c04.f1754o = c04.f1754o.e(this.f1775a);
                                if (wVarF.f1839a) {
                                    C0 c05 = C0.this;
                                    if (!c05.j0(c05.f1754o)) {
                                        if (!C0.this.f1754o.f1770d.isEmpty()) {
                                        }
                                    }
                                    return;
                                }
                            } finally {
                            }
                        }
                    } else {
                        y yVarG = g(l0Var, z4);
                        if (yVarG.f1845a) {
                            D dF02 = C0.this.f0(this.f1775a.f1791d + 1, false);
                            if (dF02 == null) {
                                return;
                            }
                            synchronized (C0.this.f1748i) {
                                C0 c06 = C0.this;
                                vVar = new v(c06.f1748i);
                                c06.f1761v = vVar;
                            }
                            vVar.c(C0.this.f1743d.schedule(new b(dF02), yVarG.f1846b, TimeUnit.NANOSECONDS));
                            return;
                        }
                    }
                } else if (C0.this.f1747h) {
                    C0.this.i0();
                }
            }
            C0.this.e0(this.f1775a);
            if (C0.this.f1754o.f1772f == this.f1775a) {
                C0.this.o0(l0Var, aVar, z4);
            }
        }

        @Override // M2.Q0
        public void c() {
            if (C0.this.j()) {
                C0.this.f1742c.execute(new f());
            }
        }

        @Override // M2.InterfaceC0443s
        public void d(K2.Z z4) {
            if (this.f1775a.f1791d > 0) {
                Z.g gVar = C0.f1736A;
                z4.e(gVar);
                z4.p(gVar, String.valueOf(this.f1775a.f1791d));
            }
            C0.this.e0(this.f1775a);
            if (C0.this.f1754o.f1772f == this.f1775a) {
                if (C0.this.f1752m != null) {
                    C0.this.f1752m.c();
                }
                C0.this.f1742c.execute(new a(z4));
            }
        }

        public final Integer e(K2.Z z4) {
            String str = (String) z4.g(C0.f1737B);
            if (str == null) {
                return null;
            }
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public final w f(K2.l0 l0Var, K2.Z z4) {
            Integer numE = e(z4);
            boolean zContains = C0.this.f1746g.f2030c.contains(l0Var.m());
            boolean z5 = (C0.this.f1752m == null || (!zContains && (numE == null || numE.intValue() >= 0))) ? false : !C0.this.f1752m.b();
            if (zContains && !z5 && !l0Var.o() && numE != null && numE.intValue() > 0) {
                numE = 0;
            }
            return new w(zContains && !z5, numE);
        }

        public final y g(K2.l0 l0Var, K2.Z z4) {
            long nanos = 0;
            boolean z5 = false;
            if (C0.this.f1745f == null) {
                return new y(false, 0L);
            }
            boolean zContains = C0.this.f1745f.f1892f.contains(l0Var.m());
            Integer numE = e(z4);
            boolean z6 = (C0.this.f1752m == null || (!zContains && (numE == null || numE.intValue() >= 0))) ? false : !C0.this.f1752m.b();
            if (C0.this.f1745f.f1887a > this.f1775a.f1791d + 1 && !z6) {
                if (numE == null) {
                    if (zContains) {
                        nanos = (long) (C0.this.f1763x * C0.f1739D.nextDouble());
                        C0.this.f1763x = Math.min((long) (r10.f1763x * C0.this.f1745f.f1890d), C0.this.f1745f.f1889c);
                        z5 = true;
                    }
                } else if (numE.intValue() >= 0) {
                    nanos = TimeUnit.MILLISECONDS.toNanos(numE.intValue());
                    C0 c02 = C0.this;
                    c02.f1763x = c02.f1745f.f1888b;
                    z5 = true;
                }
            }
            return new y(z5, nanos);
        }
    }

    public static final class D {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public M2.r f1788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f1789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1790c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f1791d;

        public D(int i4) {
            this.f1791d = i4;
        }
    }

    public static final class E {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f1792a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f1793b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f1794c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicInteger f1795d;

        public E(float f4, float f5) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.f1795d = atomicInteger;
            this.f1794c = (int) (f5 * 1000.0f);
            int i4 = (int) (f4 * 1000.0f);
            this.f1792a = i4;
            this.f1793b = i4 / 2;
            atomicInteger.set(i4);
        }

        public boolean a() {
            return this.f1795d.get() > this.f1793b;
        }

        public boolean b() {
            int i4;
            int i5;
            do {
                i4 = this.f1795d.get();
                if (i4 == 0) {
                    return false;
                }
                i5 = i4 - 1000;
            } while (!this.f1795d.compareAndSet(i4, Math.max(i5, 0)));
            return i5 > this.f1793b;
        }

        public void c() {
            int i4;
            int i5;
            do {
                i4 = this.f1795d.get();
                i5 = this.f1792a;
                if (i4 == i5) {
                    return;
                }
            } while (!this.f1795d.compareAndSet(i4, Math.min(this.f1794c + i4, i5)));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof E)) {
                return false;
            }
            E e4 = (E) obj;
            return this.f1792a == e4.f1792a && this.f1794c == e4.f1794c;
        }

        public int hashCode() {
            return Z1.i.b(Integer.valueOf(this.f1792a), Integer.valueOf(this.f1794c));
        }
    }

    /* JADX INFO: renamed from: M2.C0$a, reason: case insensitive filesystem */
    public class C0403a implements Thread.UncaughtExceptionHandler {
        public C0403a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            throw K2.l0.k(th).q("Uncaught exception in the SynchronizationContext. Re-thrown.").d();
        }
    }

    /* JADX INFO: renamed from: M2.C0$b, reason: case insensitive filesystem */
    public class C0404b implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f1797a;

        public C0404b(String str) {
            this.f1797a = str;
        }

        @Override // M2.C0.s
        public void a(D d4) {
            d4.f1788a.l(this.f1797a);
        }
    }

    /* JADX INFO: renamed from: M2.C0$c, reason: case insensitive filesystem */
    public class RunnableC0405c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection f1799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ D f1800b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Future f1801c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Future f1802d;

        public RunnableC0405c(Collection collection, D d4, Future future, Future future2) {
            this.f1799a = collection;
            this.f1800b = d4;
            this.f1801c = future;
            this.f1802d = future2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (D d4 : this.f1799a) {
                if (d4 != this.f1800b) {
                    d4.f1788a.c(C0.f1738C);
                }
            }
            Future future = this.f1801c;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.f1802d;
            if (future2 != null) {
                future2.cancel(false);
            }
            C0.this.l0();
        }
    }

    /* JADX INFO: renamed from: M2.C0$d, reason: case insensitive filesystem */
    public class C0406d implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0366n f1804a;

        public C0406d(InterfaceC0366n interfaceC0366n) {
            this.f1804a = interfaceC0366n;
        }

        @Override // M2.C0.s
        public void a(D d4) {
            d4.f1788a.b(this.f1804a);
        }
    }

    /* JADX INFO: renamed from: M2.C0$e, reason: case insensitive filesystem */
    public class C0407e implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0371t f1806a;

        public C0407e(C0371t c0371t) {
            this.f1806a = c0371t;
        }

        @Override // M2.C0.s
        public void a(D d4) {
            d4.f1788a.h(this.f1806a);
        }
    }

    public class f implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C0373v f1808a;

        public f(C0373v c0373v) {
            this.f1808a = c0373v;
        }

        @Override // M2.C0.s
        public void a(D d4) {
            d4.f1788a.o(this.f1808a);
        }
    }

    public class g implements s {
        public g() {
        }

        @Override // M2.C0.s
        public void a(D d4) {
            d4.f1788a.flush();
        }
    }

    public class h implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1811a;

        public h(boolean z4) {
            this.f1811a = z4;
        }

        @Override // M2.C0.s
        public void a(D d4) {
            d4.f1788a.r(this.f1811a);
        }
    }

    public class i implements s {
        public i() {
        }

        @Override // M2.C0.s
        public void a(D d4) {
            d4.f1788a.m();
        }
    }

    public class j implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1814a;

        public j(int i4) {
            this.f1814a = i4;
        }

        @Override // M2.C0.s
        public void a(D d4) {
            d4.f1788a.f(this.f1814a);
        }
    }

    public class k implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1816a;

        public k(int i4) {
            this.f1816a = i4;
        }

        @Override // M2.C0.s
        public void a(D d4) {
            d4.f1788a.g(this.f1816a);
        }
    }

    public class l implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f1818a;

        public l(boolean z4) {
            this.f1818a = z4;
        }

        @Override // M2.C0.s
        public void a(D d4) {
            d4.f1788a.a(this.f1818a);
        }
    }

    public class m implements s {
        public m() {
        }

        @Override // M2.C0.s
        public void a(D d4) {
            d4.f1788a.q();
        }
    }

    public class n implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f1821a;

        public n(int i4) {
            this.f1821a = i4;
        }

        @Override // M2.C0.s
        public void a(D d4) {
            d4.f1788a.e(this.f1821a);
        }
    }

    public class o implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f1823a;

        public o(Object obj) {
            this.f1823a = obj;
        }

        @Override // M2.C0.s
        public void a(D d4) {
            d4.f1788a.p(C0.this.f1740a.j(this.f1823a));
            d4.f1788a.flush();
        }
    }

    public class p extends AbstractC0363k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractC0363k f1825a;

        public p(AbstractC0363k abstractC0363k) {
            this.f1825a = abstractC0363k;
        }

        @Override // K2.AbstractC0363k.a
        public AbstractC0363k a(AbstractC0363k.b bVar, K2.Z z4) {
            return this.f1825a;
        }
    }

    public class q implements Runnable {
        public q() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (C0.this.f1765z) {
                return;
            }
            C0.this.f1760u.c();
        }
    }

    public class r implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ K2.l0 f1828a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ InterfaceC0443s.a f1829b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ K2.Z f1830c;

        public r(K2.l0 l0Var, InterfaceC0443s.a aVar, K2.Z z4) {
            this.f1828a = l0Var;
            this.f1829b = aVar;
            this.f1830c = z4;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0.this.f1765z = true;
            C0.this.f1760u.b(this.f1828a, this.f1829b, this.f1830c);
        }
    }

    public interface s {
        void a(D d4);
    }

    public class t extends AbstractC0363k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final D f1832b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f1833c;

        public t(D d4) {
            this.f1832b = d4;
        }

        @Override // K2.o0
        public void h(long j4) {
            if (C0.this.f1754o.f1772f != null) {
                return;
            }
            synchronized (C0.this.f1748i) {
                try {
                    if (C0.this.f1754o.f1772f == null && !this.f1832b.f1789b) {
                        long j5 = this.f1833c + j4;
                        this.f1833c = j5;
                        if (j5 <= C0.this.f1759t) {
                            return;
                        }
                        if (this.f1833c > C0.this.f1750k) {
                            this.f1832b.f1790c = true;
                        } else {
                            long jA = C0.this.f1749j.a(this.f1833c - C0.this.f1759t);
                            C0.this.f1759t = this.f1833c;
                            if (jA > C0.this.f1751l) {
                                this.f1832b.f1790c = true;
                            }
                        }
                        D d4 = this.f1832b;
                        Runnable runnableD0 = d4.f1790c ? C0.this.d0(d4) : null;
                        if (runnableD0 != null) {
                            runnableD0.run();
                        }
                    }
                } finally {
                }
            }
        }
    }

    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicLong f1835a = new AtomicLong();

        public long a(long j4) {
            return this.f1835a.addAndGet(j4);
        }
    }

    public static final class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f1836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Future f1837b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f1838c;

        public v(Object obj) {
            this.f1836a = obj;
        }

        public boolean a() {
            return this.f1838c;
        }

        public Future b() {
            this.f1838c = true;
            return this.f1837b;
        }

        public void c(Future future) {
            synchronized (this.f1836a) {
                try {
                    if (!this.f1838c) {
                        this.f1837b = future;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static final class w {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f1839a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f1840b;

        public w(boolean z4, Integer num) {
            this.f1839a = z4;
            this.f1840b = num;
        }
    }

    public final class x implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final v f1841a;

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ D f1843a;

            public a(D d4) {
                this.f1843a = d4;
            }

            @Override // java.lang.Runnable
            public void run() {
                v vVar;
                boolean z4;
                synchronized (C0.this.f1748i) {
                    try {
                        vVar = null;
                        if (x.this.f1841a.a()) {
                            z4 = true;
                        } else {
                            C0 c02 = C0.this;
                            c02.f1754o = c02.f1754o.a(this.f1843a);
                            C0 c03 = C0.this;
                            if (c03.j0(c03.f1754o) && (C0.this.f1752m == null || C0.this.f1752m.a())) {
                                C0 c04 = C0.this;
                                vVar = new v(c04.f1748i);
                                c04.f1762w = vVar;
                            } else {
                                C0 c05 = C0.this;
                                c05.f1754o = c05.f1754o.d();
                                C0.this.f1762w = null;
                            }
                            z4 = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z4) {
                    this.f1843a.f1788a.i(C0.this.new C(this.f1843a));
                    this.f1843a.f1788a.c(K2.l0.f1216f.q("Unneeded hedging"));
                } else {
                    if (vVar != null) {
                        vVar.c(C0.this.f1743d.schedule(C0.this.new x(vVar), C0.this.f1746g.f2029b, TimeUnit.NANOSECONDS));
                    }
                    C0.this.h0(this.f1843a);
                }
            }
        }

        public x(v vVar) {
            this.f1841a = vVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0 c02 = C0.this;
            D dF0 = c02.f0(c02.f1754o.f1771e, false);
            if (dF0 == null) {
                return;
            }
            C0.this.f1741b.execute(new a(dF0));
        }
    }

    public static final class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f1845a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f1846b;

        public y(boolean z4, long j4) {
            this.f1845a = z4;
            this.f1846b = j4;
        }
    }

    public static final class z {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final K2.l0 f1847a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceC0443s.a f1848b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final K2.Z f1849c;

        public z(K2.l0 l0Var, InterfaceC0443s.a aVar, K2.Z z4) {
            this.f1847a = l0Var;
            this.f1848b = aVar;
            this.f1849c = z4;
        }
    }

    static {
        Z.d dVar = K2.Z.f1097e;
        f1736A = Z.g.e("grpc-previous-rpc-attempts", dVar);
        f1737B = Z.g.e("grpc-retry-pushback-ms", dVar);
        f1738C = K2.l0.f1216f.q("Stream thrown away because RetriableStream committed");
        f1739D = new Random();
    }

    public C0(K2.a0 a0Var, K2.Z z4, u uVar, long j4, long j5, Executor executor, ScheduledExecutorService scheduledExecutorService, D0 d02, U u4, E e4) {
        this.f1740a = a0Var;
        this.f1749j = uVar;
        this.f1750k = j4;
        this.f1751l = j5;
        this.f1741b = executor;
        this.f1743d = scheduledExecutorService;
        this.f1744e = z4;
        this.f1745f = d02;
        if (d02 != null) {
            this.f1763x = d02.f1888b;
        }
        this.f1746g = u4;
        Z1.m.e(d02 == null || u4 == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.f1747h = u4 != null;
        this.f1752m = e4;
    }

    @Override // M2.P0
    public final void a(boolean z4) {
        g0(new l(z4));
    }

    @Override // M2.P0
    public final void b(InterfaceC0366n interfaceC0366n) {
        g0(new C0406d(interfaceC0366n));
    }

    @Override // M2.r
    public final void c(K2.l0 l0Var) {
        D d4;
        D d5 = new D(0);
        d5.f1788a = new C0439p0();
        Runnable runnableD0 = d0(d5);
        if (runnableD0 != null) {
            synchronized (this.f1748i) {
                this.f1754o = this.f1754o.h(d5);
            }
            runnableD0.run();
            o0(l0Var, InterfaceC0443s.a.PROCESSED, new K2.Z());
            return;
        }
        synchronized (this.f1748i) {
            try {
                if (this.f1754o.f1769c.contains(this.f1754o.f1772f)) {
                    d4 = this.f1754o.f1772f;
                } else {
                    this.f1764y = l0Var;
                    d4 = null;
                }
                this.f1754o = this.f1754o.b();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (d4 != null) {
            d4.f1788a.c(l0Var);
        }
    }

    @Override // M2.r
    public final C0353a d() {
        return this.f1754o.f1772f != null ? this.f1754o.f1772f.f1788a.d() : C0353a.f1111c;
    }

    public final Runnable d0(D d4) {
        Future future;
        Future future2;
        synchronized (this.f1748i) {
            try {
                if (this.f1754o.f1772f != null) {
                    return null;
                }
                Collection collection = this.f1754o.f1769c;
                this.f1754o = this.f1754o.c(d4);
                this.f1749j.a(-this.f1759t);
                v vVar = this.f1761v;
                if (vVar != null) {
                    Future futureB = vVar.b();
                    this.f1761v = null;
                    future = futureB;
                } else {
                    future = null;
                }
                v vVar2 = this.f1762w;
                if (vVar2 != null) {
                    Future futureB2 = vVar2.b();
                    this.f1762w = null;
                    future2 = futureB2;
                } else {
                    future2 = null;
                }
                return new RunnableC0405c(collection, d4, future, future2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // M2.P0
    public final void e(int i4) {
        B b4 = this.f1754o;
        if (b4.f1767a) {
            b4.f1772f.f1788a.e(i4);
        } else {
            g0(new n(i4));
        }
    }

    public final void e0(D d4) {
        Runnable runnableD0 = d0(d4);
        if (runnableD0 != null) {
            this.f1741b.execute(runnableD0);
        }
    }

    @Override // M2.r
    public final void f(int i4) {
        g0(new j(i4));
    }

    public final D f0(int i4, boolean z4) {
        int i5;
        do {
            i5 = this.f1757r.get();
            if (i5 < 0) {
                return null;
            }
        } while (!this.f1757r.compareAndSet(i5, i5 + 1));
        D d4 = new D(i4);
        d4.f1788a = k0(q0(this.f1744e, i4), new p(new t(d4)), i4, z4);
        return d4;
    }

    @Override // M2.P0
    public final void flush() {
        B b4 = this.f1754o;
        if (b4.f1767a) {
            b4.f1772f.f1788a.flush();
        } else {
            g0(new g());
        }
    }

    @Override // M2.r
    public final void g(int i4) {
        g0(new k(i4));
    }

    public final void g0(s sVar) {
        Collection collection;
        synchronized (this.f1748i) {
            try {
                if (!this.f1754o.f1767a) {
                    this.f1754o.f1768b.add(sVar);
                }
                collection = this.f1754o.f1769c;
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            sVar.a((D) it.next());
        }
    }

    @Override // M2.r
    public final void h(C0371t c0371t) {
        g0(new C0407e(c0371t));
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
    
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0038, code lost:
    
        r8.f1742c.execute(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003e, code lost:
    
        if (r2 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0040, code lost:
    
        r9.f1788a.i(new M2.C0.C(r8, r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
    
        r0 = r9.f1788a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0050, code lost:
    
        if (r8.f1754o.f1772f != r9) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0052, code lost:
    
        r9 = r8.f1764y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0055, code lost:
    
        r9 = M2.C0.f1738C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0057, code lost:
    
        r0.c(r9);
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
    
        r4 = (M2.C0.s) r0.next();
        r4.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009d, code lost:
    
        if ((r4 instanceof M2.C0.A) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009f, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a0, code lost:
    
        r4 = r8.f1754o;
        r5 = r4.f1772f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
    
        if (r5 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a6, code lost:
    
        if (r5 == r9) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ab, code lost:
    
        if (r4.f1773g == false) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h0(M2.C0.D r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            r2 = r0
            r3 = r1
        L4:
            java.lang.Object r4 = r8.f1748i
            monitor-enter(r4)
            M2.C0$B r5 = r8.f1754o     // Catch: java.lang.Throwable -> L11
            M2.C0$D r6 = r5.f1772f     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L14
            if (r6 == r9) goto L14
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            goto L36
        L11:
            r9 = move-exception
            goto Lb0
        L14:
            boolean r6 = r5.f1773g     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L1a
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            goto L36
        L1a:
            java.util.List r6 = r5.f1768b     // Catch: java.lang.Throwable -> L11
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L11
            if (r0 != r6) goto L5b
            M2.C0$B r0 = r5.h(r9)     // Catch: java.lang.Throwable -> L11
            r8.f1754o = r0     // Catch: java.lang.Throwable -> L11
            boolean r0 = r8.j()     // Catch: java.lang.Throwable -> L11
            if (r0 != 0) goto L30
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            return
        L30:
            M2.C0$q r1 = new M2.C0$q     // Catch: java.lang.Throwable -> L11
            r1.<init>()     // Catch: java.lang.Throwable -> L11
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
        L36:
            if (r1 == 0) goto L3e
            java.util.concurrent.Executor r9 = r8.f1742c
            r9.execute(r1)
            return
        L3e:
            if (r2 != 0) goto L4a
            M2.r r0 = r9.f1788a
            M2.C0$C r1 = new M2.C0$C
            r1.<init>(r9)
            r0.i(r1)
        L4a:
            M2.r r0 = r9.f1788a
            M2.C0$B r1 = r8.f1754o
            M2.C0$D r1 = r1.f1772f
            if (r1 != r9) goto L55
            K2.l0 r9 = r8.f1764y
            goto L57
        L55:
            K2.l0 r9 = M2.C0.f1738C
        L57:
            r0.c(r9)
            return
        L5b:
            boolean r6 = r9.f1789b     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L61
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            return
        L61:
            int r6 = r0 + 128
            java.util.List r7 = r5.f1768b     // Catch: java.lang.Throwable -> L11
            int r7 = r7.size()     // Catch: java.lang.Throwable -> L11
            int r6 = java.lang.Math.min(r6, r7)     // Catch: java.lang.Throwable -> L11
            if (r3 != 0) goto L7b
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L11
            java.util.List r5 = r5.f1768b     // Catch: java.lang.Throwable -> L11
            java.util.List r0 = r5.subList(r0, r6)     // Catch: java.lang.Throwable -> L11
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L11
            goto L87
        L7b:
            r3.clear()     // Catch: java.lang.Throwable -> L11
            java.util.List r5 = r5.f1768b     // Catch: java.lang.Throwable -> L11
            java.util.List r0 = r5.subList(r0, r6)     // Catch: java.lang.Throwable -> L11
            r3.addAll(r0)     // Catch: java.lang.Throwable -> L11
        L87:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            java.util.Iterator r0 = r3.iterator()
        L8c:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto Lad
            java.lang.Object r4 = r0.next()
            M2.C0$s r4 = (M2.C0.s) r4
            r4.a(r9)
            boolean r4 = r4 instanceof M2.C0.A
            if (r4 == 0) goto La0
            r2 = 1
        La0:
            M2.C0$B r4 = r8.f1754o
            M2.C0$D r5 = r4.f1772f
            if (r5 == 0) goto La9
            if (r5 == r9) goto La9
            goto Lad
        La9:
            boolean r4 = r4.f1773g
            if (r4 == 0) goto L8c
        Lad:
            r0 = r6
            goto L4
        Lb0:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: M2.C0.h0(M2.C0$D):void");
    }

    @Override // M2.r
    public final void i(InterfaceC0443s interfaceC0443s) {
        v vVar;
        E e4;
        this.f1760u = interfaceC0443s;
        K2.l0 l0VarM0 = m0();
        if (l0VarM0 != null) {
            c(l0VarM0);
            return;
        }
        synchronized (this.f1748i) {
            this.f1754o.f1768b.add(new A());
        }
        D dF0 = f0(0, false);
        if (dF0 == null) {
            return;
        }
        if (this.f1747h) {
            synchronized (this.f1748i) {
                try {
                    this.f1754o = this.f1754o.a(dF0);
                    if (j0(this.f1754o) && ((e4 = this.f1752m) == null || e4.a())) {
                        vVar = new v(this.f1748i);
                        this.f1762w = vVar;
                    } else {
                        vVar = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (vVar != null) {
                vVar.c(this.f1743d.schedule(new x(vVar), this.f1746g.f2029b, TimeUnit.NANOSECONDS));
            }
        }
        h0(dF0);
    }

    public final void i0() {
        Future future;
        synchronized (this.f1748i) {
            try {
                v vVar = this.f1762w;
                future = null;
                if (vVar != null) {
                    Future futureB = vVar.b();
                    this.f1762w = null;
                    future = futureB;
                }
                this.f1754o = this.f1754o.d();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    @Override // M2.P0
    public final boolean j() {
        Iterator it = this.f1754o.f1769c.iterator();
        while (it.hasNext()) {
            if (((D) it.next()).f1788a.j()) {
                return true;
            }
        }
        return false;
    }

    public final boolean j0(B b4) {
        return b4.f1772f == null && b4.f1771e < this.f1746g.f2028a && !b4.f1774h;
    }

    public abstract M2.r k0(K2.Z z4, AbstractC0363k.a aVar, int i4, boolean z5);

    @Override // M2.r
    public final void l(String str) {
        g0(new C0404b(str));
    }

    public abstract void l0();

    @Override // M2.r
    public final void m() {
        g0(new i());
    }

    public abstract K2.l0 m0();

    @Override // M2.r
    public void n(Y y4) {
        B b4;
        synchronized (this.f1748i) {
            y4.b("closed", this.f1753n);
            b4 = this.f1754o;
        }
        if (b4.f1772f != null) {
            Y y5 = new Y();
            b4.f1772f.f1788a.n(y5);
            y4.b("committed", y5);
            return;
        }
        Y y6 = new Y();
        for (D d4 : b4.f1769c) {
            Y y7 = new Y();
            d4.f1788a.n(y7);
            y6.a(y7);
        }
        y4.b("open", y6);
    }

    public final void n0(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            i0();
            return;
        }
        synchronized (this.f1748i) {
            try {
                v vVar = this.f1762w;
                if (vVar == null) {
                    return;
                }
                Future futureB = vVar.b();
                v vVar2 = new v(this.f1748i);
                this.f1762w = vVar2;
                if (futureB != null) {
                    futureB.cancel(false);
                }
                vVar2.c(this.f1743d.schedule(new x(vVar2), num.intValue(), TimeUnit.MILLISECONDS));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // M2.r
    public final void o(C0373v c0373v) {
        g0(new f(c0373v));
    }

    public final void o0(K2.l0 l0Var, InterfaceC0443s.a aVar, K2.Z z4) {
        this.f1758s = new z(l0Var, aVar, z4);
        if (this.f1757r.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            this.f1742c.execute(new r(l0Var, aVar, z4));
        }
    }

    @Override // M2.P0
    public final void p(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    public final void p0(Object obj) {
        B b4 = this.f1754o;
        if (b4.f1767a) {
            b4.f1772f.f1788a.p(this.f1740a.j(obj));
        } else {
            g0(new o(obj));
        }
    }

    @Override // M2.P0
    public void q() {
        g0(new m());
    }

    public final K2.Z q0(K2.Z z4, int i4) {
        K2.Z z5 = new K2.Z();
        z5.m(z4);
        if (i4 > 0) {
            z5.p(f1736A, String.valueOf(i4));
        }
        return z5;
    }

    @Override // M2.r
    public final void r(boolean z4) {
        g0(new h(z4));
    }
}
