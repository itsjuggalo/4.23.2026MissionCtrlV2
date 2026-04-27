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

/* JADX INFO: renamed from: y.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2964a implements A2.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f24209d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", com.amazon.a.a.o.b.ag));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f24210e = Logger.getLogger(AbstractC2964a.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f24211f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f24212g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f24213a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile e f24214b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile h f24215c;

    /* JADX INFO: renamed from: y.a$b */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractC2964a abstractC2964a, e eVar, e eVar2);

        public abstract boolean b(AbstractC2964a abstractC2964a, Object obj, Object obj2);

        public abstract boolean c(AbstractC2964a abstractC2964a, h hVar, h hVar2);

        public abstract void d(h hVar, h hVar2);

        public abstract void e(h hVar, Thread thread);
    }

    /* JADX INFO: renamed from: y.a$c */
    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f24216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f24217d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f24218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f24219b;

        static {
            if (AbstractC2964a.f24209d) {
                f24217d = null;
                f24216c = null;
            } else {
                f24217d = new c(false, null);
                f24216c = new c(true, null);
            }
        }

        public c(boolean z7, Throwable th) {
            this.f24218a = z7;
            this.f24219b = th;
        }
    }

    /* JADX INFO: renamed from: y.a$d */
    public static final class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f24220b = new d(new C0431a("Failure occurred while trying to finish a future."));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f24221a;

        /* JADX INFO: renamed from: y.a$d$a, reason: collision with other inner class name */
        public class C0431a extends Throwable {
            public C0431a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            this.f24221a = (Throwable) AbstractC2964a.l(th);
        }
    }

    /* JADX INFO: renamed from: y.a$e */
    public static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f24222d = new e(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f24223a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f24224b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f24225c;

        public e(Runnable runnable, Executor executor) {
            this.f24223a = runnable;
            this.f24224b = executor;
        }
    }

    /* JADX INFO: renamed from: y.a$f */
    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f24226a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f24227b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f24228c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f24229d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f24230e;

        public f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f24226a = atomicReferenceFieldUpdater;
            this.f24227b = atomicReferenceFieldUpdater2;
            this.f24228c = atomicReferenceFieldUpdater3;
            this.f24229d = atomicReferenceFieldUpdater4;
            this.f24230e = atomicReferenceFieldUpdater5;
        }

        @Override // y.AbstractC2964a.b
        public boolean a(AbstractC2964a abstractC2964a, e eVar, e eVar2) {
            return AbstractC2965b.a(this.f24229d, abstractC2964a, eVar, eVar2);
        }

        @Override // y.AbstractC2964a.b
        public boolean b(AbstractC2964a abstractC2964a, Object obj, Object obj2) {
            return AbstractC2965b.a(this.f24230e, abstractC2964a, obj, obj2);
        }

        @Override // y.AbstractC2964a.b
        public boolean c(AbstractC2964a abstractC2964a, h hVar, h hVar2) {
            return AbstractC2965b.a(this.f24228c, abstractC2964a, hVar, hVar2);
        }

        @Override // y.AbstractC2964a.b
        public void d(h hVar, h hVar2) {
            this.f24227b.lazySet(hVar, hVar2);
        }

        @Override // y.AbstractC2964a.b
        public void e(h hVar, Thread thread) {
            this.f24226a.lazySet(hVar, thread);
        }
    }

    /* JADX INFO: renamed from: y.a$g */
    public static final class g extends b {
        public g() {
            super();
        }

        @Override // y.AbstractC2964a.b
        public boolean a(AbstractC2964a abstractC2964a, e eVar, e eVar2) {
            synchronized (abstractC2964a) {
                try {
                    if (abstractC2964a.f24214b != eVar) {
                        return false;
                    }
                    abstractC2964a.f24214b = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // y.AbstractC2964a.b
        public boolean b(AbstractC2964a abstractC2964a, Object obj, Object obj2) {
            synchronized (abstractC2964a) {
                try {
                    if (abstractC2964a.f24213a != obj) {
                        return false;
                    }
                    abstractC2964a.f24213a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // y.AbstractC2964a.b
        public boolean c(AbstractC2964a abstractC2964a, h hVar, h hVar2) {
            synchronized (abstractC2964a) {
                try {
                    if (abstractC2964a.f24215c != hVar) {
                        return false;
                    }
                    abstractC2964a.f24215c = hVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // y.AbstractC2964a.b
        public void d(h hVar, h hVar2) {
            hVar.f24233b = hVar2;
        }

        @Override // y.AbstractC2964a.b
        public void e(h hVar, Thread thread) {
            hVar.f24232a = thread;
        }
    }

    /* JADX INFO: renamed from: y.a$h */
    public static final class h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f24231c = new h(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Thread f24232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile h f24233b;

        public h() {
            AbstractC2964a.f24211f.e(this, Thread.currentThread());
        }

        public void a(h hVar) {
            AbstractC2964a.f24211f.d(this, hVar);
        }

        public void b() {
            Thread thread = this.f24232a;
            if (thread != null) {
                this.f24232a = null;
                LockSupport.unpark(thread);
            }
        }

        public h(boolean z7) {
        }
    }

    static {
        b gVar;
        try {
            gVar = new f(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractC2964a.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractC2964a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractC2964a.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f24211f = gVar;
        if (th != null) {
            f24210e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f24212g = new Object();
    }

    private void H() {
        h hVar;
        do {
            hVar = this.f24215c;
        } while (!f24211f.c(this, hVar, h.f24231c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.f24233b;
        }
    }

    private void g(StringBuilder sb) {
        String str = "]";
        try {
            Object objT = t(this);
            sb.append("SUCCESS, result=[");
            sb.append(L(objT));
            sb.append("]");
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        } catch (RuntimeException e8) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e8.getClass());
            str = " thrown from get()]";
            sb.append(str);
        } catch (ExecutionException e9) {
            sb.append("FAILURE, cause=[");
            sb.append(e9.getCause());
            sb.append(str);
        }
    }

    private static CancellationException k(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static Object l(Object obj) {
        obj.getClass();
        return obj;
    }

    public static void n(AbstractC2964a abstractC2964a) {
        abstractC2964a.H();
        abstractC2964a.i();
        e eVarM = abstractC2964a.m(null);
        while (eVarM != null) {
            e eVar = eVarM.f24225c;
            q(eVarM.f24223a, eVarM.f24224b);
            eVarM = eVar;
        }
    }

    private static void q(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e8) {
            f24210e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e8);
        }
    }

    private Object r(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw k("Task was cancelled.", ((c) obj).f24219b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f24221a);
        }
        if (obj == f24212g) {
            return null;
        }
        return obj;
    }

    public static Object t(Future future) {
        Object obj;
        boolean z7 = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z7 = true;
            } catch (Throwable th) {
                if (z7) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String B() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void I(h hVar) {
        hVar.f24232a = null;
        while (true) {
            h hVar2 = this.f24215c;
            if (hVar2 == h.f24231c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.f24233b;
                if (hVar2.f24232a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.f24233b = hVar4;
                    if (hVar3.f24232a == null) {
                        break;
                    }
                } else if (!f24211f.c(this, hVar2, hVar4)) {
                    break;
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    public boolean J(Object obj) {
        if (obj == null) {
            obj = f24212g;
        }
        if (!f24211f.b(this, null, obj)) {
            return false;
        }
        n(this);
        return true;
    }

    public boolean K(Throwable th) {
        if (!f24211f.b(this, null, new d((Throwable) l(th)))) {
            return false;
        }
        n(this);
        return true;
    }

    public final String L(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final boolean M() {
        Object obj = this.f24213a;
        return (obj instanceof c) && ((c) obj).f24218a;
    }

    @Override // A2.f
    public final void a(Runnable runnable, Executor executor) {
        l(runnable);
        l(executor);
        e eVar = this.f24214b;
        if (eVar != e.f24222d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f24225c = eVar;
                if (f24211f.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f24214b;
                }
            } while (eVar != e.f24222d);
        }
        q(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z7) {
        Object obj = this.f24213a;
        if (obj == null) {
            if (f24211f.b(this, obj, f24209d ? new c(z7, new CancellationException("Future.cancel() was called.")) : z7 ? c.f24216c : c.f24217d)) {
                if (z7) {
                    w();
                }
                n(this);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f24213a;
        if (obj2 != null) {
            return r(obj2);
        }
        h hVar = this.f24215c;
        if (hVar != h.f24231c) {
            h hVar2 = new h();
            do {
                hVar2.a(hVar);
                if (f24211f.c(this, hVar, hVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            I(hVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f24213a;
                    } while (!(obj != null));
                    return r(obj);
                }
                hVar = this.f24215c;
            } while (hVar != h.f24231c);
        }
        return r(this.f24213a);
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f24213a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f24213a != null;
    }

    public final e m(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f24214b;
        } while (!f24211f.a(this, eVar2, e.f24222d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f24225c;
            eVar4.f24225c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    public String toString() {
        String strB;
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (!isCancelled()) {
            if (isDone()) {
                g(sb);
            } else {
                try {
                    strB = B();
                } catch (RuntimeException e8) {
                    strB = "Exception thrown from implementation: " + e8.getClass();
                }
                if (strB == null || strB.isEmpty()) {
                    str = isDone() ? "CANCELLED" : "PENDING";
                    g(sb);
                } else {
                    sb.append("PENDING, info=[");
                    sb.append(strB);
                    sb.append("]");
                }
            }
            sb.append("]");
            return sb.toString();
        }
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j8, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j8);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f24213a;
        if (obj != null) {
            return r(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.f24215c;
            if (hVar != h.f24231c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f24211f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                I(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f24213a;
                            if (obj2 != null) {
                                return r(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        I(hVar2);
                    } else {
                        hVar = this.f24215c;
                    }
                } while (hVar != h.f24231c);
            }
            return r(this.f24213a);
        }
        while (nanos > 0) {
            Object obj3 = this.f24213a;
            if (obj3 != null) {
                return r(obj3);
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
        String str = "Waited " + j8 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j9 = -nanos;
            long jConvert = timeUnit.convert(j9, TimeUnit.NANOSECONDS);
            long nanos2 = j9 - timeUnit.toNanos(jConvert);
            boolean z7 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z7) {
                    str3 = str3 + com.amazon.a.a.o.b.f.f14100a;
                }
                str2 = str3 + " ";
            }
            if (z7) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    public void i() {
    }

    public void w() {
    }
}
