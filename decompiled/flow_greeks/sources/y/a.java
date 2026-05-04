package y;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a implements u6.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f25113d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", com.amazon.a.a.o.b.f4546ag));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f25114e = Logger.getLogger(a.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f25115f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f25116g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f25117a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile e f25118b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile h f25119c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(a aVar, e eVar, e eVar2);

        public abstract boolean b(a aVar, Object obj, Object obj2);

        public abstract boolean c(a aVar, h hVar, h hVar2);

        public abstract void d(h hVar, h hVar2);

        public abstract void e(h hVar, Thread thread);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f25120c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f25121d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f25122a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f25123b;

        static {
            if (a.f25113d) {
                f25121d = null;
                f25120c = null;
            } else {
                f25121d = new c(false, null);
                f25120c = new c(true, null);
            }
        }

        public c(boolean z10, Throwable th) {
            this.f25122a = z10;
            this.f25123b = th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f25124b = new d(new C0464a("Failure occurred while trying to finish a future."));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f25125a;

        /* JADX INFO: renamed from: y.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0464a extends Throwable {
            public C0464a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            this.f25125a = (Throwable) a.i(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f25126d = new e(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f25127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f25128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f25129c;

        public e(Runnable runnable, Executor executor) {
            this.f25127a = runnable;
            this.f25128b = executor;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f25130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f25131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f25132c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f25133d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f25134e;

        public f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f25130a = atomicReferenceFieldUpdater;
            this.f25131b = atomicReferenceFieldUpdater2;
            this.f25132c = atomicReferenceFieldUpdater3;
            this.f25133d = atomicReferenceFieldUpdater4;
            this.f25134e = atomicReferenceFieldUpdater5;
        }

        @Override // y.a.b
        public boolean a(a aVar, e eVar, e eVar2) {
            return y.b.a(this.f25133d, aVar, eVar, eVar2);
        }

        @Override // y.a.b
        public boolean b(a aVar, Object obj, Object obj2) {
            return y.b.a(this.f25134e, aVar, obj, obj2);
        }

        @Override // y.a.b
        public boolean c(a aVar, h hVar, h hVar2) {
            return y.b.a(this.f25132c, aVar, hVar, hVar2);
        }

        @Override // y.a.b
        public void d(h hVar, h hVar2) {
            this.f25131b.lazySet(hVar, hVar2);
        }

        @Override // y.a.b
        public void e(h hVar, Thread thread) {
            this.f25130a.lazySet(hVar, thread);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g extends b {
        public g() {
            super();
        }

        @Override // y.a.b
        public boolean a(a aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.f25118b != eVar) {
                        return false;
                    }
                    aVar.f25118b = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // y.a.b
        public boolean b(a aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                try {
                    if (aVar.f25117a != obj) {
                        return false;
                    }
                    aVar.f25117a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // y.a.b
        public boolean c(a aVar, h hVar, h hVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.f25119c != hVar) {
                        return false;
                    }
                    aVar.f25119c = hVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // y.a.b
        public void d(h hVar, h hVar2) {
            hVar.f25137b = hVar2;
        }

        @Override // y.a.b
        public void e(h hVar, Thread thread) {
            hVar.f25136a = thread;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f25135c = new h(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Thread f25136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile h f25137b;

        public h(boolean z10) {
        }

        public void a(h hVar) {
            a.f25115f.d(this, hVar);
        }

        public void b() {
            Thread thread = this.f25136a;
            if (thread != null) {
                this.f25136a = null;
                LockSupport.unpark(thread);
            }
        }

        public h() {
            a.f25115f.e(this, Thread.currentThread());
        }
    }

    static {
        b gVar;
        try {
            gVar = new f(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f25115f = gVar;
        if (th != null) {
            f25114e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f25116g = new Object();
    }

    private void b(StringBuilder sb2) {
        try {
            Object objQ = q(this);
            sb2.append("SUCCESS, result=[");
            sb2.append(B(objQ));
            sb2.append("]");
        } catch (CancellationException unused) {
            sb2.append("CANCELLED");
        } catch (RuntimeException e10) {
            sb2.append("UNKNOWN, cause=[");
            sb2.append(e10.getClass());
            sb2.append(" thrown from get()]");
        } catch (ExecutionException e11) {
            sb2.append("FAILURE, cause=[");
            sb2.append(e11.getCause());
            sb2.append("]");
        }
    }

    private static CancellationException h(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static Object i(Object obj) {
        obj.getClass();
        return obj;
    }

    public static void l(a aVar) {
        aVar.v();
        aVar.c();
        e eVarK = aVar.k(null);
        while (eVarK != null) {
            e eVar = eVarK.f25129c;
            m(eVarK.f25127a, eVarK.f25128b);
            eVarK = eVar;
        }
    }

    private static void m(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f25114e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    private Object o(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw h("Task was cancelled.", ((c) obj).f25123b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f25125a);
        }
        if (obj == f25116g) {
            return null;
        }
        return obj;
    }

    public static Object q(Future future) {
        Object obj;
        boolean z10 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z10 = true;
            } catch (Throwable th) {
                if (z10) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z10) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    private void v() {
        h hVar;
        do {
            hVar = this.f25119c;
        } while (!f25115f.c(this, hVar, h.f25135c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.f25137b;
        }
    }

    public boolean A(Throwable th) {
        if (!f25115f.b(this, null, new d((Throwable) i(th)))) {
            return false;
        }
        l(this);
        return true;
    }

    public final String B(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final boolean E() {
        Object obj = this.f25117a;
        return (obj instanceof c) && ((c) obj).f25122a;
    }

    @Override // u6.f
    public final void a(Runnable runnable, Executor executor) {
        i(runnable);
        i(executor);
        e eVar = this.f25118b;
        if (eVar != e.f25126d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f25129c = eVar;
                if (f25115f.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f25118b;
                }
            } while (eVar != e.f25126d);
        }
        m(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z10) {
        Object obj = this.f25117a;
        if (obj == null) {
            if (f25115f.b(this, obj, f25113d ? new c(z10, new CancellationException("Future.cancel() was called.")) : z10 ? c.f25120c : c.f25121d)) {
                if (z10) {
                    s();
                }
                l(this);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j10);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f25117a;
        if (obj != null) {
            return o(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.f25119c;
            if (hVar != h.f25135c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f25115f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                w(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f25117a;
                            if (obj2 != null) {
                                return o(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        w(hVar2);
                    } else {
                        hVar = this.f25119c;
                    }
                } while (hVar != h.f25135c);
            }
            return o(this.f25117a);
        }
        while (nanos > 0) {
            Object obj3 = this.f25117a;
            if (obj3 != null) {
                return o(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j10 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j11 = -nanos;
            long jConvert = timeUnit.convert(j11, TimeUnit.NANOSECONDS);
            long nanos2 = j11 - timeUnit.toNanos(jConvert);
            boolean z10 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z10) {
                    str3 = str3 + com.amazon.a.a.o.b.f.f4598a;
                }
                str2 = str3 + " ";
            }
            if (z10) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f25117a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f25117a != null;
    }

    public final e k(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f25118b;
        } while (!f25115f.a(this, eVar2, e.f25126d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f25129c;
            eVar4.f25129c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    public String toString() {
        String strU;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            b(sb2);
        } else {
            try {
                strU = u();
            } catch (RuntimeException e10) {
                strU = "Exception thrown from implementation: " + e10.getClass();
            }
            if (strU != null && !strU.isEmpty()) {
                sb2.append("PENDING, info=[");
                sb2.append(strU);
                sb2.append("]");
            } else if (isDone()) {
                b(sb2);
            } else {
                sb2.append("PENDING");
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String u() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void w(h hVar) {
        hVar.f25136a = null;
        while (true) {
            h hVar2 = this.f25119c;
            if (hVar2 == h.f25135c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.f25137b;
                if (hVar2.f25136a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.f25137b = hVar4;
                    if (hVar3.f25136a == null) {
                        break;
                    }
                } else if (!f25115f.c(this, hVar2, hVar4)) {
                    break;
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    public boolean y(Object obj) {
        if (obj == null) {
            obj = f25116g;
        }
        if (!f25115f.b(this, null, obj)) {
            return false;
        }
        l(this);
        return true;
    }

    public void c() {
    }

    public void s() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f25117a;
            if (obj2 != null) {
                return o(obj2);
            }
            h hVar = this.f25119c;
            if (hVar != h.f25135c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f25115f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f25117a;
                            } else {
                                w(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!(obj != null));
                        return o(obj);
                    }
                    hVar = this.f25119c;
                } while (hVar != h.f25135c);
            }
            return o(this.f25117a);
        }
        throw new InterruptedException();
    }
}
