package tb;

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
import rb.k;
import rb.y0;
import tb.p2;
import tb.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b2 implements tb.r {
    public static final y0.g A;
    public static final y0.g B;
    public static final rb.k1 C;
    public static Random D;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final rb.z0 f20963a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Executor f20964b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ScheduledExecutorService f20966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final rb.y0 f20967e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final c2 f20968f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t0 f20969g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f20970h;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final t f20972j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f20973k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f20974l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final d0 f20975m;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public y f20981s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public long f20982t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public tb.s f20983u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public u f20984v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public u f20985w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public long f20986x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public rb.k1 f20987y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f20988z;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f20965c = new rb.o1(new a());

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f20971i = new Object();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final x0 f20976n = new x0();

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public volatile a0 f20977o = new a0(new ArrayList(8), Collections.EMPTY_LIST, null, null, false, false, false, 0);

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f20978p = new AtomicBoolean();

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicInteger f20979q = new AtomicInteger();

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicInteger f20980r = new AtomicInteger();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Thread.UncaughtExceptionHandler {
        public a() {
        }

        @Override // java.lang.Thread.UncaughtExceptionHandler
        public void uncaughtException(Thread thread, Throwable th) {
            throw rb.k1.l(th).r("Uncaught exception in the SynchronizationContext. Re-thrown.").d();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f20990a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List f20991b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Collection f20992c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Collection f20993d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f20994e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final c0 f20995f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f20996g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f20997h;

        public a0(List list, Collection collection, Collection collection2, c0 c0Var, boolean z10, boolean z11, boolean z12, int i10) {
            this.f20991b = list;
            this.f20992c = (Collection) p6.n.o(collection, "drainedSubstreams");
            this.f20995f = c0Var;
            this.f20993d = collection2;
            this.f20996g = z10;
            this.f20990a = z11;
            this.f20997h = z12;
            this.f20994e = i10;
            p6.n.u(!z11 || list == null, "passThrough should imply buffer is null");
            p6.n.u((z11 && c0Var == null) ? false : true, "passThrough should imply winningSubstream != null");
            p6.n.u(!z11 || (collection.size() == 1 && collection.contains(c0Var)) || (collection.size() == 0 && c0Var.f21019b), "passThrough should imply winningSubstream is drained");
            p6.n.u((z10 && c0Var == null) ? false : true, "cancelled should imply committed");
        }

        public a0 a(c0 c0Var) {
            Collection collectionUnmodifiableCollection;
            p6.n.u(!this.f20997h, "hedging frozen");
            p6.n.u(this.f20995f == null, "already committed");
            if (this.f20993d == null) {
                collectionUnmodifiableCollection = Collections.singleton(c0Var);
            } else {
                ArrayList arrayList = new ArrayList(this.f20993d);
                arrayList.add(c0Var);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            return new a0(this.f20991b, this.f20992c, collectionUnmodifiableCollection, this.f20995f, this.f20996g, this.f20990a, this.f20997h, this.f20994e + 1);
        }

        public a0 b() {
            return new a0(this.f20991b, this.f20992c, this.f20993d, this.f20995f, true, this.f20990a, this.f20997h, this.f20994e);
        }

        public a0 c(c0 c0Var) {
            List list;
            boolean z10;
            Collection collectionSingleton;
            p6.n.u(this.f20995f == null, "Already committed");
            List list2 = this.f20991b;
            if (this.f20992c.contains(c0Var)) {
                collectionSingleton = Collections.singleton(c0Var);
                list = null;
                z10 = true;
            } else {
                list = list2;
                z10 = false;
                collectionSingleton = Collections.EMPTY_LIST;
            }
            return new a0(list, collectionSingleton, this.f20993d, c0Var, this.f20996g, z10, this.f20997h, this.f20994e);
        }

        public a0 d() {
            return this.f20997h ? this : new a0(this.f20991b, this.f20992c, this.f20993d, this.f20995f, this.f20996g, this.f20990a, true, this.f20994e);
        }

        public a0 e(c0 c0Var) {
            ArrayList arrayList = new ArrayList(this.f20993d);
            arrayList.remove(c0Var);
            return new a0(this.f20991b, this.f20992c, Collections.unmodifiableCollection(arrayList), this.f20995f, this.f20996g, this.f20990a, this.f20997h, this.f20994e);
        }

        public a0 f(c0 c0Var, c0 c0Var2) {
            ArrayList arrayList = new ArrayList(this.f20993d);
            arrayList.remove(c0Var);
            arrayList.add(c0Var2);
            return new a0(this.f20991b, this.f20992c, Collections.unmodifiableCollection(arrayList), this.f20995f, this.f20996g, this.f20990a, this.f20997h, this.f20994e);
        }

        public a0 g(c0 c0Var) {
            c0Var.f21019b = true;
            if (!this.f20992c.contains(c0Var)) {
                return this;
            }
            ArrayList arrayList = new ArrayList(this.f20992c);
            arrayList.remove(c0Var);
            return new a0(this.f20991b, Collections.unmodifiableCollection(arrayList), this.f20993d, this.f20995f, this.f20996g, this.f20990a, this.f20997h, this.f20994e);
        }

        public a0 h(c0 c0Var) {
            Collection collectionUnmodifiableCollection;
            p6.n.u(!this.f20990a, "Already passThrough");
            if (c0Var.f21019b) {
                collectionUnmodifiableCollection = this.f20992c;
            } else if (this.f20992c.isEmpty()) {
                collectionUnmodifiableCollection = Collections.singletonList(c0Var);
            } else {
                ArrayList arrayList = new ArrayList(this.f20992c);
                arrayList.add(c0Var);
                collectionUnmodifiableCollection = Collections.unmodifiableCollection(arrayList);
            }
            Collection collection = collectionUnmodifiableCollection;
            c0 c0Var2 = this.f20995f;
            boolean z10 = c0Var2 != null;
            List list = this.f20991b;
            if (z10) {
                p6.n.u(c0Var2 == c0Var, "Another RPC attempt has already committed");
                list = null;
            }
            return new a0(list, collection, this.f20993d, this.f20995f, this.f20996g, z10, this.f20997h, this.f20994e);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f20998a;

        public b(String str) {
            this.f20998a = str;
        }

        @Override // tb.b2.r
        public void a(c0 c0Var) {
            c0Var.f21018a.h(this.f20998a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class b0 implements tb.s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c0 f21000a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ rb.y0 f21002a;

            public a(rb.y0 y0Var) {
                this.f21002a = y0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                b2.this.f20983u.c(this.f21002a);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c0 f21004a;

            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public class a implements Runnable {
                public a() {
                }

                @Override // java.lang.Runnable
                public void run() {
                    b bVar = b.this;
                    b2.this.f0(bVar.f21004a);
                }
            }

            public b(c0 c0Var) {
                this.f21004a = c0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                b2.this.f20964b.execute(new a());
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class c implements Runnable {
            public c() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b2.this.f20988z = true;
                b2.this.f20983u.d(b2.this.f20981s.f21067a, b2.this.f20981s.f21068b, b2.this.f20981s.f21069c);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c0 f21008a;

            public d(c0 c0Var) {
                this.f21008a = c0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                b2.this.f0(this.f21008a);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class e implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ p2.a f21010a;

            public e(p2.a aVar) {
                this.f21010a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                b2.this.f20983u.a(this.f21010a);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class f implements Runnable {
            public f() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (b2.this.f20988z) {
                    return;
                }
                b2.this.f20983u.b();
            }
        }

        public b0(c0 c0Var) {
            this.f21000a = c0Var;
        }

        @Override // tb.p2
        public void a(p2.a aVar) {
            a0 a0Var = b2.this.f20977o;
            p6.n.u(a0Var.f20995f != null, "Headers should be received prior to messages.");
            if (a0Var.f20995f != this.f21000a) {
                r0.e(aVar);
            } else {
                b2.this.f20965c.execute(new e(aVar));
            }
        }

        @Override // tb.p2
        public void b() {
            if (b2.this.f()) {
                b2.this.f20965c.execute(new f());
            }
        }

        @Override // tb.s
        public void c(rb.y0 y0Var) {
            if (this.f21000a.f21021d > 0) {
                y0.g gVar = b2.A;
                y0Var.e(gVar);
                y0Var.p(gVar, String.valueOf(this.f21000a.f21021d));
            }
            b2.this.c0(this.f21000a);
            if (b2.this.f20977o.f20995f == this.f21000a) {
                if (b2.this.f20975m != null) {
                    b2.this.f20975m.c();
                }
                b2.this.f20965c.execute(new a(y0Var));
            }
        }

        @Override // tb.s
        public void d(rb.k1 k1Var, s.a aVar, rb.y0 y0Var) {
            u uVar;
            synchronized (b2.this.f20971i) {
                b2 b2Var = b2.this;
                b2Var.f20977o = b2Var.f20977o.g(this.f21000a);
                b2.this.f20976n.a(k1Var.n());
            }
            if (b2.this.f20980r.decrementAndGet() == Integer.MIN_VALUE) {
                b2.this.f20965c.execute(new c());
                return;
            }
            c0 c0Var = this.f21000a;
            if (c0Var.f21020c) {
                b2.this.c0(c0Var);
                if (b2.this.f20977o.f20995f == this.f21000a) {
                    b2.this.m0(k1Var, aVar, y0Var);
                    return;
                }
                return;
            }
            s.a aVar2 = s.a.MISCARRIED;
            if (aVar == aVar2 && b2.this.f20979q.incrementAndGet() > 1000) {
                b2.this.c0(this.f21000a);
                if (b2.this.f20977o.f20995f == this.f21000a) {
                    b2.this.m0(rb.k1.f19606s.r("Too many transparent retries. Might be a bug in gRPC").q(k1Var.d()), aVar, y0Var);
                    return;
                }
                return;
            }
            if (b2.this.f20977o.f20995f == null) {
                if (aVar == aVar2 || (aVar == s.a.REFUSED && b2.this.f20978p.compareAndSet(false, true))) {
                    c0 c0VarD0 = b2.this.d0(this.f21000a.f21021d, true);
                    if (c0VarD0 == null) {
                        return;
                    }
                    if (b2.this.f20970h) {
                        synchronized (b2.this.f20971i) {
                            b2 b2Var2 = b2.this;
                            b2Var2.f20977o = b2Var2.f20977o.f(this.f21000a, c0VarD0);
                        }
                    }
                    b2.this.f20964b.execute(new d(c0VarD0));
                    return;
                }
                if (aVar != s.a.DROPPED) {
                    b2.this.f20978p.set(true);
                    if (b2.this.f20970h) {
                        v vVarF = f(k1Var, y0Var);
                        if (vVarF.f21059a) {
                            b2.this.l0(vVarF.f21060b);
                        }
                        synchronized (b2.this.f20971i) {
                            try {
                                b2 b2Var3 = b2.this;
                                b2Var3.f20977o = b2Var3.f20977o.e(this.f21000a);
                                if (vVarF.f21059a) {
                                    b2 b2Var4 = b2.this;
                                    if (!b2Var4.h0(b2Var4.f20977o)) {
                                        if (!b2.this.f20977o.f20993d.isEmpty()) {
                                        }
                                    }
                                    return;
                                }
                            } finally {
                            }
                        }
                    } else {
                        x xVarG = g(k1Var, y0Var);
                        if (xVarG.f21065a) {
                            c0 c0VarD02 = b2.this.d0(this.f21000a.f21021d + 1, false);
                            if (c0VarD02 == null) {
                                return;
                            }
                            synchronized (b2.this.f20971i) {
                                b2 b2Var5 = b2.this;
                                uVar = new u(b2Var5.f20971i);
                                b2Var5.f20984v = uVar;
                            }
                            uVar.c(b2.this.f20966d.schedule(new b(c0VarD02), xVarG.f21066b, TimeUnit.NANOSECONDS));
                            return;
                        }
                    }
                } else if (b2.this.f20970h) {
                    b2.this.g0();
                }
            }
            b2.this.c0(this.f21000a);
            if (b2.this.f20977o.f20995f == this.f21000a) {
                b2.this.m0(k1Var, aVar, y0Var);
            }
        }

        public final Integer e(rb.y0 y0Var) {
            String str = (String) y0Var.g(b2.B);
            if (str == null) {
                return null;
            }
            try {
                return Integer.valueOf(str);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public final v f(rb.k1 k1Var, rb.y0 y0Var) {
            Integer numE = e(y0Var);
            boolean zContains = b2.this.f20969g.f21731c.contains(k1Var.n());
            boolean z10 = (b2.this.f20975m == null || (!zContains && (numE == null || numE.intValue() >= 0))) ? false : !b2.this.f20975m.b();
            if (zContains && !z10 && !k1Var.p() && numE != null && numE.intValue() > 0) {
                numE = 0;
            }
            return new v(zContains && !z10, numE);
        }

        public final x g(rb.k1 k1Var, rb.y0 y0Var) {
            long nanos = 0;
            boolean z10 = false;
            if (b2.this.f20968f == null) {
                return new x(false, 0L);
            }
            boolean zContains = b2.this.f20968f.f21156f.contains(k1Var.n());
            Integer numE = e(y0Var);
            boolean z11 = (b2.this.f20975m == null || (!zContains && (numE == null || numE.intValue() >= 0))) ? false : !b2.this.f20975m.b();
            if (b2.this.f20968f.f21151a > this.f21000a.f21021d + 1 && !z11) {
                if (numE == null) {
                    if (zContains) {
                        nanos = (long) (b2.this.f20986x * b2.D.nextDouble());
                        b2.this.f20986x = Math.min((long) (r10.f20986x * b2.this.f20968f.f21154d), b2.this.f20968f.f21153c);
                        z10 = true;
                    }
                } else if (numE.intValue() >= 0) {
                    nanos = TimeUnit.MILLISECONDS.toNanos(numE.intValue());
                    b2 b2Var = b2.this;
                    b2Var.f20986x = b2Var.f20968f.f21152b;
                    z10 = true;
                }
            }
            return new x(z10, nanos);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Collection f21013a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ c0 f21014b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Future f21015c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Future f21016d;

        public c(Collection collection, c0 c0Var, Future future, Future future2) {
            this.f21013a = collection;
            this.f21014b = c0Var;
            this.f21015c = future;
            this.f21016d = future2;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (c0 c0Var : this.f21013a) {
                if (c0Var != this.f21014b) {
                    c0Var.f21018a.e(b2.C);
                }
            }
            Future future = this.f21015c;
            if (future != null) {
                future.cancel(false);
            }
            Future future2 = this.f21016d;
            if (future2 != null) {
                future2.cancel(false);
            }
            b2.this.j0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public tb.r f21018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f21019b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f21020c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f21021d;

        public c0(int i10) {
            this.f21021d = i10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class d implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rb.n f21022a;

        public d(rb.n nVar) {
            this.f21022a = nVar;
        }

        @Override // tb.b2.r
        public void a(c0 c0Var) {
            c0Var.f21018a.a(this.f21022a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f21024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f21025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f21026c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicInteger f21027d;

        public d0(float f10, float f11) {
            AtomicInteger atomicInteger = new AtomicInteger();
            this.f21027d = atomicInteger;
            this.f21026c = (int) (f11 * 1000.0f);
            int i10 = (int) (f10 * 1000.0f);
            this.f21024a = i10;
            this.f21025b = i10 / 2;
            atomicInteger.set(i10);
        }

        public boolean a() {
            return this.f21027d.get() > this.f21025b;
        }

        public boolean b() {
            int i10;
            int i11;
            do {
                i10 = this.f21027d.get();
                if (i10 == 0) {
                    return false;
                }
                i11 = i10 - 1000;
            } while (!this.f21027d.compareAndSet(i10, Math.max(i11, 0)));
            return i11 > this.f21025b;
        }

        public void c() {
            int i10;
            int i11;
            do {
                i10 = this.f21027d.get();
                i11 = this.f21024a;
                if (i10 == i11) {
                    return;
                }
            } while (!this.f21027d.compareAndSet(i10, Math.min(this.f21026c + i10, i11)));
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof d0)) {
                return false;
            }
            d0 d0Var = (d0) obj;
            return this.f21024a == d0Var.f21024a && this.f21026c == d0Var.f21026c;
        }

        public int hashCode() {
            return p6.j.b(Integer.valueOf(this.f21024a), Integer.valueOf(this.f21026c));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class e implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rb.t f21028a;

        public e(rb.t tVar) {
            this.f21028a = tVar;
        }

        @Override // tb.b2.r
        public void a(c0 c0Var) {
            c0Var.f21018a.g(this.f21028a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class f implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rb.v f21030a;

        public f(rb.v vVar) {
            this.f21030a = vVar;
        }

        @Override // tb.b2.r
        public void a(c0 c0Var) {
            c0Var.f21018a.k(this.f21030a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class g implements r {
        public g() {
        }

        @Override // tb.b2.r
        public void a(c0 c0Var) {
            c0Var.f21018a.flush();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class h implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f21033a;

        public h(boolean z10) {
            this.f21033a = z10;
        }

        @Override // tb.b2.r
        public void a(c0 c0Var) {
            c0Var.f21018a.p(this.f21033a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class i implements r {
        public i() {
        }

        @Override // tb.b2.r
        public void a(c0 c0Var) {
            c0Var.f21018a.i();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class j implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21036a;

        public j(int i10) {
            this.f21036a = i10;
        }

        @Override // tb.b2.r
        public void a(c0 c0Var) {
            c0Var.f21018a.c(this.f21036a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class k implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21038a;

        public k(int i10) {
            this.f21038a = i10;
        }

        @Override // tb.b2.r
        public void a(c0 c0Var) {
            c0Var.f21018a.d(this.f21038a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class l implements r {
        public l() {
        }

        @Override // tb.b2.r
        public void a(c0 c0Var) {
            c0Var.f21018a.o();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class m implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21041a;

        public m(int i10) {
            this.f21041a = i10;
        }

        @Override // tb.b2.r
        public void a(c0 c0Var) {
            c0Var.f21018a.b(this.f21041a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class n implements r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f21043a;

        public n(Object obj) {
            this.f21043a = obj;
        }

        @Override // tb.b2.r
        public void a(c0 c0Var) {
            c0Var.f21018a.n(b2.this.f20963a.j(this.f21043a));
            c0Var.f21018a.flush();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class o extends k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rb.k f21045a;

        public o(rb.k kVar) {
            this.f21045a = kVar;
        }

        @Override // rb.k.a
        public rb.k a(k.b bVar, rb.y0 y0Var) {
            return this.f21045a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class p implements Runnable {
        public p() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b2.this.f20988z) {
                return;
            }
            b2.this.f20983u.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class q implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ rb.k1 f21048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ s.a f21049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ rb.y0 f21050c;

        public q(rb.k1 k1Var, s.a aVar, rb.y0 y0Var) {
            this.f21048a = k1Var;
            this.f21049b = aVar;
            this.f21050c = y0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            b2.this.f20988z = true;
            b2.this.f20983u.d(this.f21048a, this.f21049b, this.f21050c);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface r {
        void a(c0 c0Var);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class s extends rb.k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c0 f21052b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public long f21053c;

        public s(c0 c0Var) {
            this.f21052b = c0Var;
        }

        @Override // rb.n1
        public void h(long j10) {
            if (b2.this.f20977o.f20995f != null) {
                return;
            }
            synchronized (b2.this.f20971i) {
                try {
                    if (b2.this.f20977o.f20995f == null && !this.f21052b.f21019b) {
                        long j11 = this.f21053c + j10;
                        this.f21053c = j11;
                        if (j11 <= b2.this.f20982t) {
                            return;
                        }
                        if (this.f21053c > b2.this.f20973k) {
                            this.f21052b.f21020c = true;
                        } else {
                            long jA = b2.this.f20972j.a(this.f21053c - b2.this.f20982t);
                            b2.this.f20982t = this.f21053c;
                            if (jA > b2.this.f20974l) {
                                this.f21052b.f21020c = true;
                            }
                        }
                        c0 c0Var = this.f21052b;
                        Runnable runnableB0 = c0Var.f21020c ? b2.this.b0(c0Var) : null;
                        if (runnableB0 != null) {
                            runnableB0.run();
                        }
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class t {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicLong f21055a = new AtomicLong();

        public long a(long j10) {
            return this.f21055a.addAndGet(j10);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f21056a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Future f21057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f21058c;

        public u(Object obj) {
            this.f21056a = obj;
        }

        public boolean a() {
            return this.f21058c;
        }

        public Future b() {
            this.f21058c = true;
            return this.f21057b;
        }

        public void c(Future future) {
            synchronized (this.f21056a) {
                try {
                    if (!this.f21058c) {
                        this.f21057b = future;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class v {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f21059a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f21060b;

        public v(boolean z10, Integer num) {
            this.f21059a = z10;
            this.f21060b = num;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public final class w implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final u f21061a;

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ c0 f21063a;

            public a(c0 c0Var) {
                this.f21063a = c0Var;
            }

            @Override // java.lang.Runnable
            public void run() {
                u uVar;
                boolean z10;
                synchronized (b2.this.f20971i) {
                    try {
                        uVar = null;
                        if (w.this.f21061a.a()) {
                            z10 = true;
                        } else {
                            b2 b2Var = b2.this;
                            b2Var.f20977o = b2Var.f20977o.a(this.f21063a);
                            b2 b2Var2 = b2.this;
                            if (b2Var2.h0(b2Var2.f20977o) && (b2.this.f20975m == null || b2.this.f20975m.a())) {
                                b2 b2Var3 = b2.this;
                                uVar = new u(b2Var3.f20971i);
                                b2Var3.f20985w = uVar;
                            } else {
                                b2 b2Var4 = b2.this;
                                b2Var4.f20977o = b2Var4.f20977o.d();
                                b2.this.f20985w = null;
                            }
                            z10 = false;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z10) {
                    this.f21063a.f21018a.j(b2.this.new b0(this.f21063a));
                    this.f21063a.f21018a.e(rb.k1.f19593f.r("Unneeded hedging"));
                } else {
                    if (uVar != null) {
                        uVar.c(b2.this.f20966d.schedule(b2.this.new w(uVar), b2.this.f20969g.f21730b, TimeUnit.NANOSECONDS));
                    }
                    b2.this.f0(this.f21063a);
                }
            }
        }

        public w(u uVar) {
            this.f21061a = uVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            b2 b2Var = b2.this;
            c0 c0VarD0 = b2Var.d0(b2Var.f20977o.f20994e, false);
            if (c0VarD0 == null) {
                return;
            }
            b2.this.f20964b.execute(new a(c0VarD0));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f21065a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f21066b;

        public x(boolean z10, long j10) {
            this.f21065a = z10;
            this.f21066b = j10;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final rb.k1 f21067a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final s.a f21068b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final rb.y0 f21069c;

        public y(rb.k1 k1Var, s.a aVar, rb.y0 y0Var) {
            this.f21067a = k1Var;
            this.f21068b = aVar;
            this.f21069c = y0Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class z implements r {
        public z() {
        }

        @Override // tb.b2.r
        public void a(c0 c0Var) {
            c0Var.f21018a.j(b2.this.new b0(c0Var));
        }
    }

    static {
        y0.d dVar = rb.y0.f19747e;
        A = y0.g.e("grpc-previous-rpc-attempts", dVar);
        B = y0.g.e("grpc-retry-pushback-ms", dVar);
        C = rb.k1.f19593f.r("Stream thrown away because RetriableStream committed");
        D = new Random();
    }

    public b2(rb.z0 z0Var, rb.y0 y0Var, t tVar, long j10, long j11, Executor executor, ScheduledExecutorService scheduledExecutorService, c2 c2Var, t0 t0Var, d0 d0Var) {
        this.f20963a = z0Var;
        this.f20972j = tVar;
        this.f20973k = j10;
        this.f20974l = j11;
        this.f20964b = executor;
        this.f20966d = scheduledExecutorService;
        this.f20967e = y0Var;
        this.f20968f = c2Var;
        if (c2Var != null) {
            this.f20986x = c2Var.f21152b;
        }
        this.f20969g = t0Var;
        p6.n.e(c2Var == null || t0Var == null, "Should not provide both retryPolicy and hedgingPolicy");
        this.f20970h = t0Var != null;
        this.f20975m = d0Var;
    }

    @Override // tb.o2
    public final void a(rb.n nVar) {
        e0(new d(nVar));
    }

    @Override // tb.o2
    public final void b(int i10) {
        a0 a0Var = this.f20977o;
        if (a0Var.f20990a) {
            a0Var.f20995f.f21018a.b(i10);
        } else {
            e0(new m(i10));
        }
    }

    public final Runnable b0(c0 c0Var) {
        Future future;
        Future future2;
        synchronized (this.f20971i) {
            try {
                if (this.f20977o.f20995f != null) {
                    return null;
                }
                Collection collection = this.f20977o.f20992c;
                this.f20977o = this.f20977o.c(c0Var);
                this.f20972j.a(-this.f20982t);
                u uVar = this.f20984v;
                if (uVar != null) {
                    Future futureB = uVar.b();
                    this.f20984v = null;
                    future = futureB;
                } else {
                    future = null;
                }
                u uVar2 = this.f20985w;
                if (uVar2 != null) {
                    Future futureB2 = uVar2.b();
                    this.f20985w = null;
                    future2 = futureB2;
                } else {
                    future2 = null;
                }
                return new c(collection, c0Var, future, future2);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // tb.r
    public final void c(int i10) {
        e0(new j(i10));
    }

    public final void c0(c0 c0Var) {
        Runnable runnableB0 = b0(c0Var);
        if (runnableB0 != null) {
            this.f20964b.execute(runnableB0);
        }
    }

    @Override // tb.r
    public final void d(int i10) {
        e0(new k(i10));
    }

    public final c0 d0(int i10, boolean z10) {
        int i11;
        do {
            i11 = this.f20980r.get();
            if (i11 < 0) {
                return null;
            }
        } while (!this.f20980r.compareAndSet(i11, i11 + 1));
        c0 c0Var = new c0(i10);
        c0Var.f21018a = i0(o0(this.f20967e, i10), new o(new s(c0Var)), i10, z10);
        return c0Var;
    }

    @Override // tb.r
    public final void e(rb.k1 k1Var) {
        c0 c0Var;
        c0 c0Var2 = new c0(0);
        c0Var2.f21018a = new o1();
        Runnable runnableB0 = b0(c0Var2);
        if (runnableB0 != null) {
            synchronized (this.f20971i) {
                this.f20977o = this.f20977o.h(c0Var2);
            }
            runnableB0.run();
            m0(k1Var, s.a.PROCESSED, new rb.y0());
            return;
        }
        synchronized (this.f20971i) {
            try {
                if (this.f20977o.f20992c.contains(this.f20977o.f20995f)) {
                    c0Var = this.f20977o.f20995f;
                } else {
                    this.f20987y = k1Var;
                    c0Var = null;
                }
                this.f20977o = this.f20977o.b();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (c0Var != null) {
            c0Var.f21018a.e(k1Var);
        }
    }

    public final void e0(r rVar) {
        Collection collection;
        synchronized (this.f20971i) {
            try {
                if (!this.f20977o.f20990a) {
                    this.f20977o.f20991b.add(rVar);
                }
                collection = this.f20977o.f20992c;
            } catch (Throwable th) {
                throw th;
            }
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            rVar.a((c0) it.next());
        }
    }

    @Override // tb.o2
    public final boolean f() {
        Iterator it = this.f20977o.f20992c.iterator();
        while (it.hasNext()) {
            if (((c0) it.next()).f21018a.f()) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0036, code lost:
    
        if (r1 == null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0038, code lost:
    
        r8.f20965c.execute(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003e, code lost:
    
        if (r2 != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0040, code lost:
    
        r9.f21018a.j(new tb.b2.b0(r8, r9));
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
    
        r0 = r9.f21018a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0050, code lost:
    
        if (r8.f20977o.f20995f != r9) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0052, code lost:
    
        r9 = r8.f20987y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0055, code lost:
    
        r9 = tb.b2.C;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0057, code lost:
    
        r0.e(r9);
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
    
        r4 = (tb.b2.r) r0.next();
        r4.a(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x009d, code lost:
    
        if ((r4 instanceof tb.b2.z) == false) goto L50;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x009f, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a0, code lost:
    
        r4 = r8.f20977o;
        r5 = r4.f20995f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
    
        if (r5 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00a6, code lost:
    
        if (r5 == r9) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ab, code lost:
    
        if (r4.f20996g == false) goto L67;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f0(tb.b2.c0 r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            r2 = r0
            r3 = r1
        L4:
            java.lang.Object r4 = r8.f20971i
            monitor-enter(r4)
            tb.b2$a0 r5 = r8.f20977o     // Catch: java.lang.Throwable -> L11
            tb.b2$c0 r6 = r5.f20995f     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L14
            if (r6 == r9) goto L14
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            goto L36
        L11:
            r9 = move-exception
            goto Lb0
        L14:
            boolean r6 = r5.f20996g     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L1a
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            goto L36
        L1a:
            java.util.List r6 = r5.f20991b     // Catch: java.lang.Throwable -> L11
            int r6 = r6.size()     // Catch: java.lang.Throwable -> L11
            if (r0 != r6) goto L5b
            tb.b2$a0 r0 = r5.h(r9)     // Catch: java.lang.Throwable -> L11
            r8.f20977o = r0     // Catch: java.lang.Throwable -> L11
            boolean r0 = r8.f()     // Catch: java.lang.Throwable -> L11
            if (r0 != 0) goto L30
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            return
        L30:
            tb.b2$p r1 = new tb.b2$p     // Catch: java.lang.Throwable -> L11
            r1.<init>()     // Catch: java.lang.Throwable -> L11
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
        L36:
            if (r1 == 0) goto L3e
            java.util.concurrent.Executor r9 = r8.f20965c
            r9.execute(r1)
            return
        L3e:
            if (r2 != 0) goto L4a
            tb.r r0 = r9.f21018a
            tb.b2$b0 r1 = new tb.b2$b0
            r1.<init>(r9)
            r0.j(r1)
        L4a:
            tb.r r0 = r9.f21018a
            tb.b2$a0 r1 = r8.f20977o
            tb.b2$c0 r1 = r1.f20995f
            if (r1 != r9) goto L55
            rb.k1 r9 = r8.f20987y
            goto L57
        L55:
            rb.k1 r9 = tb.b2.C
        L57:
            r0.e(r9)
            return
        L5b:
            boolean r6 = r9.f21019b     // Catch: java.lang.Throwable -> L11
            if (r6 == 0) goto L61
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            return
        L61:
            int r6 = r0 + 128
            java.util.List r7 = r5.f20991b     // Catch: java.lang.Throwable -> L11
            int r7 = r7.size()     // Catch: java.lang.Throwable -> L11
            int r6 = java.lang.Math.min(r6, r7)     // Catch: java.lang.Throwable -> L11
            if (r3 != 0) goto L7b
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L11
            java.util.List r5 = r5.f20991b     // Catch: java.lang.Throwable -> L11
            java.util.List r0 = r5.subList(r0, r6)     // Catch: java.lang.Throwable -> L11
            r3.<init>(r0)     // Catch: java.lang.Throwable -> L11
            goto L87
        L7b:
            r3.clear()     // Catch: java.lang.Throwable -> L11
            java.util.List r5 = r5.f20991b     // Catch: java.lang.Throwable -> L11
            java.util.List r0 = r5.subList(r0, r6)     // Catch: java.lang.Throwable -> L11
            r3.addAll(r0)     // Catch: java.lang.Throwable -> L11
        L87:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            java.util.Iterator r0 = r3.iterator()
        L8c:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto Lad
            java.lang.Object r4 = r0.next()
            tb.b2$r r4 = (tb.b2.r) r4
            r4.a(r9)
            boolean r4 = r4 instanceof tb.b2.z
            if (r4 == 0) goto La0
            r2 = 1
        La0:
            tb.b2$a0 r4 = r8.f20977o
            tb.b2$c0 r5 = r4.f20995f
            if (r5 == 0) goto La9
            if (r5 == r9) goto La9
            goto Lad
        La9:
            boolean r4 = r4.f20996g
            if (r4 == 0) goto L8c
        Lad:
            r0 = r6
            goto L4
        Lb0:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L11
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.b2.f0(tb.b2$c0):void");
    }

    @Override // tb.o2
    public final void flush() {
        a0 a0Var = this.f20977o;
        if (a0Var.f20990a) {
            a0Var.f20995f.f21018a.flush();
        } else {
            e0(new g());
        }
    }

    @Override // tb.r
    public final void g(rb.t tVar) {
        e0(new e(tVar));
    }

    public final void g0() {
        Future future;
        synchronized (this.f20971i) {
            try {
                u uVar = this.f20985w;
                future = null;
                if (uVar != null) {
                    Future futureB = uVar.b();
                    this.f20985w = null;
                    future = futureB;
                }
                this.f20977o = this.f20977o.d();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (future != null) {
            future.cancel(false);
        }
    }

    @Override // tb.r
    public final void h(String str) {
        e0(new b(str));
    }

    public final boolean h0(a0 a0Var) {
        return a0Var.f20995f == null && a0Var.f20994e < this.f20969g.f21729a && !a0Var.f20997h;
    }

    @Override // tb.r
    public final void i() {
        e0(new i());
    }

    public abstract tb.r i0(rb.y0 y0Var, k.a aVar, int i10, boolean z10);

    @Override // tb.r
    public final void j(tb.s sVar) {
        u uVar;
        d0 d0Var;
        this.f20983u = sVar;
        rb.k1 k1VarK0 = k0();
        if (k1VarK0 != null) {
            e(k1VarK0);
            return;
        }
        synchronized (this.f20971i) {
            this.f20977o.f20991b.add(new z());
        }
        c0 c0VarD0 = d0(0, false);
        if (c0VarD0 == null) {
            return;
        }
        if (this.f20970h) {
            synchronized (this.f20971i) {
                try {
                    this.f20977o = this.f20977o.a(c0VarD0);
                    if (h0(this.f20977o) && ((d0Var = this.f20975m) == null || d0Var.a())) {
                        uVar = new u(this.f20971i);
                        this.f20985w = uVar;
                    } else {
                        uVar = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (uVar != null) {
                uVar.c(this.f20966d.schedule(new w(uVar), this.f20969g.f21730b, TimeUnit.NANOSECONDS));
            }
        }
        f0(c0VarD0);
    }

    public abstract void j0();

    @Override // tb.r
    public final void k(rb.v vVar) {
        e0(new f(vVar));
    }

    public abstract rb.k1 k0();

    @Override // tb.r
    public void l(x0 x0Var) {
        a0 a0Var;
        synchronized (this.f20971i) {
            x0Var.b("closed", this.f20976n);
            a0Var = this.f20977o;
        }
        if (a0Var.f20995f != null) {
            x0 x0Var2 = new x0();
            a0Var.f20995f.f21018a.l(x0Var2);
            x0Var.b(Constants.COMMITTED, x0Var2);
            return;
        }
        x0 x0Var3 = new x0();
        for (c0 c0Var : a0Var.f20992c) {
            x0 x0Var4 = new x0();
            c0Var.f21018a.l(x0Var4);
            x0Var3.a(x0Var4);
        }
        x0Var.b("open", x0Var3);
    }

    public final void l0(Integer num) {
        if (num == null) {
            return;
        }
        if (num.intValue() < 0) {
            g0();
            return;
        }
        synchronized (this.f20971i) {
            try {
                u uVar = this.f20985w;
                if (uVar == null) {
                    return;
                }
                Future futureB = uVar.b();
                u uVar2 = new u(this.f20971i);
                this.f20985w = uVar2;
                if (futureB != null) {
                    futureB.cancel(false);
                }
                uVar2.c(this.f20966d.schedule(new w(uVar2), num.intValue(), TimeUnit.MILLISECONDS));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m0(rb.k1 k1Var, s.a aVar, rb.y0 y0Var) {
        this.f20981s = new y(k1Var, aVar, y0Var);
        if (this.f20980r.addAndGet(Integer.MIN_VALUE) == Integer.MIN_VALUE) {
            this.f20965c.execute(new q(k1Var, aVar, y0Var));
        }
    }

    @Override // tb.o2
    public final void n(InputStream inputStream) {
        throw new IllegalStateException("RetriableStream.writeMessage() should not be called directly");
    }

    public final void n0(Object obj) {
        a0 a0Var = this.f20977o;
        if (a0Var.f20990a) {
            a0Var.f20995f.f21018a.n(this.f20963a.j(obj));
        } else {
            e0(new n(obj));
        }
    }

    @Override // tb.o2
    public void o() {
        e0(new l());
    }

    public final rb.y0 o0(rb.y0 y0Var, int i10) {
        rb.y0 y0Var2 = new rb.y0();
        y0Var2.m(y0Var);
        if (i10 > 0) {
            y0Var2.p(A, String.valueOf(i10));
        }
        return y0Var2;
    }

    @Override // tb.r
    public final void p(boolean z10) {
        e0(new h(z10));
    }
}
