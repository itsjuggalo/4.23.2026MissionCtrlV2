package com.google.android.gms.internal.play_billing;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public class N3 implements G0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f15186d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", com.amazon.a.a.o.b.ag));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f15187e = Logger.getLogger(N3.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final H0 f15188f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f15189g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f15190a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile C1398s2 f15191b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile L3 f15192c;

    static {
        H0 k32;
        try {
            k32 = new C1375n3(AtomicReferenceFieldUpdater.newUpdater(L3.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(L3.class, L3.class, "b"), AtomicReferenceFieldUpdater.newUpdater(N3.class, L3.class, "c"), AtomicReferenceFieldUpdater.newUpdater(N3.class, C1398s2.class, "b"), AtomicReferenceFieldUpdater.newUpdater(N3.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            k32 = new K3();
        }
        Throwable th2 = th;
        f15188f = k32;
        if (th2 != null) {
            f15187e.logp(Level.SEVERE, "com.android.billingclient.util.concurrent.AbstractResolvableFuture", "<clinit>", "SafeAtomicHelper is broken!", th2);
        }
        f15189g = new Object();
    }

    public static void d(N3 n32) {
        L3 l32;
        H0 h02;
        C1398s2 c1398s2;
        C1398s2 c1398s22;
        C1398s2 c1398s23;
        do {
            l32 = n32.f15192c;
            h02 = f15188f;
        } while (!h02.e(n32, l32, L3.f15177c));
        while (true) {
            c1398s2 = null;
            if (l32 == null) {
                break;
            }
            Thread thread = l32.f15178a;
            if (thread != null) {
                l32.f15178a = null;
                LockSupport.unpark(thread);
            }
            l32 = l32.f15179b;
        }
        do {
            c1398s22 = n32.f15191b;
        } while (!h02.c(n32, c1398s22, C1398s2.f15501d));
        while (true) {
            c1398s23 = c1398s2;
            c1398s2 = c1398s22;
            if (c1398s2 == null) {
                break;
            }
            c1398s22 = c1398s2.f15504c;
            c1398s2.f15504c = c1398s23;
        }
        while (c1398s23 != null) {
            Runnable runnable = c1398s23.f15502a;
            C1398s2 c1398s24 = c1398s23.f15504c;
            g(runnable, c1398s23.f15503b);
            c1398s23 = c1398s24;
        }
    }

    public static void g(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e8) {
            f15187e.logp(Level.SEVERE, "com.android.billingclient.util.concurrent.AbstractResolvableFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e8);
        }
    }

    public static final Object i(Object obj) throws ExecutionException {
        if (obj instanceof C1338g1) {
            Throwable th = ((C1338g1) obj).f15416a;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (obj instanceof V1) {
            throw new ExecutionException(((V1) obj).f15367a);
        }
        if (obj == f15189g) {
            return null;
        }
        return obj;
    }

    @Override // com.google.android.gms.internal.play_billing.G0
    public final void b(Runnable runnable, Executor executor) {
        executor.getClass();
        C1398s2 c1398s2 = this.f15191b;
        C1398s2 c1398s22 = C1398s2.f15501d;
        if (c1398s2 != c1398s22) {
            C1398s2 c1398s23 = new C1398s2(runnable, executor);
            do {
                c1398s23.f15504c = c1398s2;
                if (f15188f.c(this, c1398s2, c1398s23)) {
                    return;
                } else {
                    c1398s2 = this.f15191b;
                }
            } while (c1398s2 != c1398s22);
        }
        g(runnable, executor);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String c() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z7) {
        Object obj = this.f15190a;
        if (obj == null) {
            if (f15188f.d(this, obj, f15186d ? new C1338g1(z7, new CancellationException("Future.cancel() was called.")) : z7 ? C1338g1.f15414b : C1338g1.f15415c)) {
                d(this);
                return true;
            }
        }
        return false;
    }

    public boolean e(Object obj) {
        if (obj == null) {
            obj = f15189g;
        }
        if (!f15188f.d(this, null, obj)) {
            return false;
        }
        d(this);
        return true;
    }

    public final void f(StringBuilder sb) {
        Object obj;
        String str = "]";
        boolean z7 = false;
        while (true) {
            try {
                try {
                    obj = get();
                    break;
                } catch (InterruptedException unused) {
                    z7 = true;
                } catch (Throwable th) {
                    if (z7) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            } catch (CancellationException unused2) {
                str = "CANCELLED";
                sb.append(str);
                return;
            } catch (RuntimeException e8) {
                sb.append("UNKNOWN, cause=[");
                sb.append(e8.getClass());
                str = " thrown from get()]";
                sb.append(str);
                return;
            } catch (ExecutionException e9) {
                sb.append("FAILURE, cause=[");
                sb.append(e9.getCause());
                sb.append(str);
                return;
            }
        }
        if (z7) {
            Thread.currentThread().interrupt();
        }
        sb.append("SUCCESS, result=[");
        sb.append(obj == this ? "this future" : String.valueOf(obj));
        sb.append("]");
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f15190a;
        if (obj2 != null) {
            return i(obj2);
        }
        L3 l32 = this.f15192c;
        L3 l33 = L3.f15177c;
        if (l32 != l33) {
            L3 l34 = new L3();
            do {
                H0 h02 = f15188f;
                h02.a(l34, l32);
                if (h02.e(this, l32, l34)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            h(l34);
                            throw new InterruptedException();
                        }
                        obj = this.f15190a;
                    } while (!(obj != null));
                    return i(obj);
                }
                l32 = this.f15192c;
            } while (l32 != l33);
        }
        return i(this.f15190a);
    }

    public final void h(L3 l32) {
        l32.f15178a = null;
        while (true) {
            L3 l33 = this.f15192c;
            if (l33 != L3.f15177c) {
                L3 l34 = null;
                while (l33 != null) {
                    L3 l35 = l33.f15179b;
                    if (l33.f15178a != null) {
                        l34 = l33;
                    } else if (l34 != null) {
                        l34.f15179b = l35;
                        if (l34.f15178a == null) {
                            break;
                        }
                    } else if (!f15188f.e(this, l33, l35)) {
                        break;
                    }
                    l33 = l35;
                }
                return;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f15190a instanceof C1338g1;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f15190a != null;
    }

    public final String toString() {
        String strConcat;
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (!(this.f15190a instanceof C1338g1)) {
            if (isDone()) {
                f(sb);
            } else {
                try {
                    strConcat = c();
                } catch (RuntimeException e8) {
                    strConcat = "Exception thrown from implementation: ".concat(String.valueOf(e8.getClass()));
                }
                if (strConcat == null || strConcat.isEmpty()) {
                    str = isDone() ? "CANCELLED" : "PENDING";
                    f(sb);
                } else {
                    sb.append("PENDING, info=[");
                    sb.append(strConcat);
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
        Object obj = this.f15190a;
        if (obj != null) {
            return i(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            L3 l32 = this.f15192c;
            L3 l33 = L3.f15177c;
            if (l32 != l33) {
                L3 l34 = new L3();
                do {
                    H0 h02 = f15188f;
                    h02.a(l34, l32);
                    if (h02.e(this, l32, l34)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                h(l34);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f15190a;
                            if (obj2 != null) {
                                return i(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        h(l34);
                    } else {
                        l32 = this.f15192c;
                    }
                } while (l32 != l33);
            }
            return i(this.f15190a);
        }
        while (nanos > 0) {
            Object obj3 = this.f15190a;
            if (obj3 != null) {
                return i(obj3);
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
        String strConcat = "Waited " + j8 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strConcat2 = strConcat.concat(" (plus ");
            long j9 = -nanos;
            long jConvert = timeUnit.convert(j9, TimeUnit.NANOSECONDS);
            long nanos2 = j9 - timeUnit.toNanos(jConvert);
            boolean z7 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strConcat3 = strConcat2 + jConvert + " " + lowerCase;
                if (z7) {
                    strConcat3 = strConcat3.concat(com.amazon.a.a.o.b.f.f14100a);
                }
                strConcat2 = strConcat3.concat(" ");
            }
            if (z7) {
                strConcat2 = strConcat2 + nanos2 + " nanoseconds ";
            }
            strConcat = strConcat2.concat("delay)");
        }
        if (isDone()) {
            throw new TimeoutException(strConcat.concat(" but future completed as timeout expired"));
        }
        throw new TimeoutException(strConcat + " for " + string);
    }
}
