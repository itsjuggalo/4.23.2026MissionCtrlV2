package r;

import N1.P0;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import t2.u0;

/* JADX INFO: loaded from: classes.dex */
public abstract class h implements Y1.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f9426d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger e = Logger.getLogger(h.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final u0 f9427f;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Object f9428k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f9429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile C0961d f9430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile g f9431c;

    static {
        u0 fVar;
        try {
            fVar = new C0962e(AtomicReferenceFieldUpdater.newUpdater(g.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(g.class, g.class, "b"), AtomicReferenceFieldUpdater.newUpdater(h.class, g.class, "c"), AtomicReferenceFieldUpdater.newUpdater(h.class, C0961d.class, "b"), AtomicReferenceFieldUpdater.newUpdater(h.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            fVar = new f(20);
        }
        f9427f = fVar;
        if (th != null) {
            e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f9428k = new Object();
    }

    public static void d(h hVar) {
        g gVar;
        C0961d c0961d;
        C0961d c0961d2;
        C0961d c0961d3;
        do {
            gVar = hVar.f9431c;
        } while (!f9427f.e(hVar, gVar, g.f9423c));
        while (true) {
            c0961d = null;
            if (gVar == null) {
                break;
            }
            Thread thread = gVar.f9424a;
            if (thread != null) {
                gVar.f9424a = null;
                LockSupport.unpark(thread);
            }
            gVar = gVar.f9425b;
        }
        hVar.c();
        do {
            c0961d2 = hVar.f9430b;
        } while (!f9427f.b(hVar, c0961d2, C0961d.f9414d));
        while (true) {
            c0961d3 = c0961d;
            c0961d = c0961d2;
            if (c0961d == null) {
                break;
            }
            c0961d2 = c0961d.f9417c;
            c0961d.f9417c = c0961d3;
        }
        while (c0961d3 != null) {
            C0961d c0961d4 = c0961d3.f9417c;
            e(c0961d3.f9415a, c0961d3.f9416b);
            c0961d3 = c0961d4;
        }
    }

    public static void e(A.a aVar, P0 p02) {
        try {
            p02.execute(aVar);
        } catch (RuntimeException e2) {
            e.log(Level.SEVERE, "RuntimeException while executing runnable " + aVar + " with executor " + p02, (Throwable) e2);
        }
    }

    public static Object f(Object obj) throws ExecutionException {
        if (obj instanceof C0958a) {
            CancellationException cancellationException = ((C0958a) obj).f9411b;
            CancellationException cancellationException2 = new CancellationException("Task was cancelled.");
            cancellationException2.initCause(cancellationException);
            throw cancellationException2;
        }
        if (obj instanceof C0960c) {
            throw new ExecutionException(((C0960c) obj).f9413a);
        }
        if (obj == f9428k) {
            return null;
        }
        return obj;
    }

    public static Object g(h hVar) {
        Object obj;
        boolean z6 = false;
        while (true) {
            try {
                obj = hVar.get();
                break;
            } catch (InterruptedException unused) {
                z6 = true;
            } catch (Throwable th) {
                if (z6) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z6) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    @Override // Y1.b
    public final void a(A.a aVar, P0 p02) {
        C0961d c0961d = this.f9430b;
        C0961d c0961d2 = C0961d.f9414d;
        if (c0961d != c0961d2) {
            C0961d c0961d3 = new C0961d(aVar, p02);
            do {
                c0961d3.f9417c = c0961d;
                if (f9427f.b(this, c0961d, c0961d3)) {
                    return;
                } else {
                    c0961d = this.f9430b;
                }
            } while (c0961d != c0961d2);
        }
        e(aVar, p02);
    }

    public final void b(StringBuilder sb) {
        try {
            Object objG = g(this);
            sb.append("SUCCESS, result=[");
            sb.append(objG == this ? "this future" : String.valueOf(objG));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e6) {
            sb.append("FAILURE, cause=[");
            sb.append(e6.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z6) {
        Object obj = this.f9429a;
        if (obj != null) {
            return false;
        }
        if (!f9427f.d(this, obj, f9426d ? new C0958a(z6, new CancellationException("Future.cancel() was called.")) : z6 ? C0958a.f9408c : C0958a.f9409d)) {
            return false;
        }
        d(this);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j4);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f9429a;
        if (obj != null) {
            return f(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            g gVar = this.f9431c;
            g gVar2 = g.f9423c;
            if (gVar != gVar2) {
                g gVar3 = new g();
                do {
                    u0 u0Var = f9427f;
                    u0Var.C(gVar3, gVar);
                    if (u0Var.e(this, gVar, gVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                i(gVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f9429a;
                            if (obj2 != null) {
                                return f(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        i(gVar3);
                    } else {
                        gVar = this.f9431c;
                    }
                } while (gVar != gVar2);
            }
            return f(this.f9429a);
        }
        while (nanos > 0) {
            Object obj3 = this.f9429a;
            if (obj3 != null) {
                return f(obj3);
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
        String strJ = "Waited " + j4 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strJ2 = a3.d.j(strJ, " (plus ");
            long j6 = -nanos;
            long jConvert = timeUnit.convert(j6, TimeUnit.NANOSECONDS);
            long nanos2 = j6 - timeUnit.toNanos(jConvert);
            boolean z6 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strJ3 = strJ2 + jConvert + " " + lowerCase;
                if (z6) {
                    strJ3 = a3.d.j(strJ3, ",");
                }
                strJ2 = a3.d.j(strJ3, " ");
            }
            if (z6) {
                strJ2 = strJ2 + nanos2 + " nanoseconds ";
            }
            strJ = a3.d.j(strJ2, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(a3.d.j(strJ, " but future completed as timeout expired"));
        }
        throw new TimeoutException(a3.d.k(strJ, " for ", string));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String h() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void i(g gVar) {
        gVar.f9424a = null;
        while (true) {
            g gVar2 = this.f9431c;
            if (gVar2 == g.f9423c) {
                return;
            }
            g gVar3 = null;
            while (gVar2 != null) {
                g gVar4 = gVar2.f9425b;
                if (gVar2.f9424a != null) {
                    gVar3 = gVar2;
                } else if (gVar3 != null) {
                    gVar3.f9425b = gVar4;
                    if (gVar3.f9424a == null) {
                        break;
                    }
                } else if (!f9427f.e(this, gVar2, gVar4)) {
                    break;
                }
                gVar2 = gVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f9429a instanceof C0958a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f9429a != null;
    }

    public boolean j(Object obj) {
        if (obj == null) {
            obj = f9428k;
        }
        if (!f9427f.d(this, null, obj)) {
            return false;
        }
        d(this);
        return true;
    }

    public boolean k(Throwable th) {
        th.getClass();
        if (!f9427f.d(this, null, new C0960c(th))) {
            return false;
        }
        d(this);
        return true;
    }

    public final String toString() {
        String strH;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.f9429a instanceof C0958a) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            b(sb);
        } else {
            try {
                strH = h();
            } catch (RuntimeException e2) {
                strH = "Exception thrown from implementation: " + e2.getClass();
            }
            if (strH != null && !strH.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strH);
                sb.append("]");
            } else if (isDone()) {
                b(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void c() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f9429a;
            if (obj2 != null) {
                return f(obj2);
            }
            g gVar = this.f9431c;
            g gVar2 = g.f9423c;
            if (gVar != gVar2) {
                g gVar3 = new g();
                do {
                    u0 u0Var = f9427f;
                    u0Var.C(gVar3, gVar);
                    if (u0Var.e(this, gVar, gVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f9429a;
                            } else {
                                i(gVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return f(obj);
                    }
                    gVar = this.f9431c;
                } while (gVar != gVar2);
            }
            return f(this.f9429a);
        }
        throw new InterruptedException();
    }
}
