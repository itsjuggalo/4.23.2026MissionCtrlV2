package com.google.android.gms.internal.play_billing;

import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.k0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1357k0 extends AbstractC1387q0 {
    public static Object m(Object obj) throws ExecutionException {
        if (obj instanceof C1332f0) {
            Throwable th = ((C1332f0) obj).f15411b;
            CancellationException cancellationException = new CancellationException("Task was cancelled.");
            cancellationException.initCause(th);
            throw cancellationException;
        }
        if (!(obj instanceof C1342h0)) {
            if (obj == AbstractC1387q0.f15487d) {
                return null;
            }
            return obj;
        }
        Throwable th2 = ((C1342h0) obj).f15419a;
        if (th2 != null) {
            throw new ExecutionException(th2);
        }
        AbstractC1387q0.f15488e.a().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "getDoneValue", "Failure.exception is unexpectedly null.");
        throw new ExecutionException(C1342h0.f15418c.f15419a);
    }

    public static boolean q(Object obj) {
        return !(obj instanceof RunnableC1337g0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Object t(G0 g02) {
        Throwable thC;
        if (g02 instanceof InterfaceC1352j0) {
            Object c1332f0 = ((AbstractC1357k0) g02).f15491a;
            if (c1332f0 instanceof C1332f0) {
                C1332f0 c1332f02 = (C1332f0) c1332f0;
                if (c1332f02.f15410a) {
                    Throwable th = c1332f02.f15411b;
                    c1332f0 = th != null ? new C1332f0(false, th) : C1332f0.f15409d;
                }
            }
            Objects.requireNonNull(c1332f0);
            return c1332f0;
        }
        if ((g02 instanceof N0) && (thC = ((N0) g02).c()) != null) {
            return new C1342h0(thC);
        }
        boolean zIsCancelled = g02.isCancelled();
        if ((!AbstractC1387q0.f15489f) && zIsCancelled) {
            C1332f0 c1332f03 = C1332f0.f15409d;
            Objects.requireNonNull(c1332f03);
            return c1332f03;
        }
        try {
            Object objU = u(g02);
            if (!zIsCancelled) {
                return objU == null ? AbstractC1387q0.f15487d : objU;
            }
            return new C1332f0(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: " + String.valueOf(g02)));
        } catch (Error e8) {
            e = e8;
            return new C1342h0(e);
        } catch (CancellationException e9) {
            return !zIsCancelled ? new C1342h0(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: ".concat(String.valueOf(g02)), e9)) : new C1332f0(false, e9);
        } catch (ExecutionException e10) {
            return zIsCancelled ? new C1332f0(false, new IllegalArgumentException("get() did not throw CancellationException, despite reporting isCancelled() == true: ".concat(String.valueOf(g02)), e10)) : new C1342h0(e10.getCause());
        } catch (Exception e11) {
            e = e11;
            return new C1342h0(e);
        }
    }

    public static Object u(Future future) {
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

    public static void w(AbstractC1357k0 abstractC1357k0, boolean z7) {
        C1347i0 c1347i0;
        C1347i0 c1347i02 = null;
        while (true) {
            abstractC1357k0.i();
            abstractC1357k0.p();
            C1347i0 c1347i03 = c1347i02;
            C1347i0 c1347i0E = abstractC1357k0.e(C1347i0.f15426d);
            C1347i0 c1347i04 = c1347i03;
            while (c1347i0E != null) {
                C1347i0 c1347i05 = c1347i0E.f15429c;
                c1347i0E.f15429c = c1347i04;
                c1347i04 = c1347i0E;
                c1347i0E = c1347i05;
            }
            while (c1347i04 != null) {
                Runnable runnable = c1347i04.f15427a;
                c1347i0 = c1347i04.f15429c;
                Objects.requireNonNull(runnable);
                Runnable runnable2 = runnable;
                if (runnable2 instanceof RunnableC1337g0) {
                    RunnableC1337g0 runnableC1337g0 = (RunnableC1337g0) runnable2;
                    abstractC1357k0 = runnableC1337g0.f15412a;
                    if (abstractC1357k0.f15491a != runnableC1337g0 || !AbstractC1387q0.k(abstractC1357k0, runnableC1337g0, t(runnableC1337g0.f15413b))) {
                    }
                } else {
                    Executor executor = c1347i04.f15428b;
                    Objects.requireNonNull(executor);
                    x(runnable2, executor);
                }
                c1347i04 = c1347i0;
            }
            return;
            c1347i02 = c1347i0;
        }
    }

    public static void x(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (Exception e8) {
            AbstractC1387q0.f15488e.a().logp(Level.SEVERE, "com.google.common.util.concurrent.AbstractFuture", "executeListener", "RuntimeException while executing runnable " + String.valueOf(runnable) + " with executor " + String.valueOf(executor), (Throwable) e8);
        }
    }

    @Override // com.google.android.gms.internal.play_billing.G0
    public final void b(Runnable runnable, Executor executor) {
        C1347i0 c1347i0;
        A.c(executor, "Executor was null.");
        if (!isDone() && (c1347i0 = this.f15492b) != C1347i0.f15426d) {
            C1347i0 c1347i02 = new C1347i0(runnable, executor);
            do {
                c1347i02.f15429c = c1347i0;
                if (j(c1347i0, c1347i02)) {
                    return;
                } else {
                    c1347i0 = this.f15492b;
                }
            } while (c1347i0 != C1347i0.f15426d);
        }
        x(runnable, executor);
    }

    @Override // com.google.android.gms.internal.play_billing.N0
    public final Throwable c() {
        if (!(this instanceof InterfaceC1352j0)) {
            return null;
        }
        Object obj = this.f15491a;
        if (obj instanceof C1342h0) {
            return ((C1342h0) obj).f15419a;
        }
        return null;
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z7) {
        C1332f0 c1332f0;
        Object obj = this.f15491a;
        if (!(obj instanceof RunnableC1337g0) && !(obj == null)) {
            return false;
        }
        if (AbstractC1387q0.f15489f) {
            c1332f0 = new C1332f0(z7, new CancellationException("Future.cancel() was called."));
        } else {
            c1332f0 = z7 ? C1332f0.f15408c : C1332f0.f15409d;
            Objects.requireNonNull(c1332f0);
        }
        AbstractC1357k0 abstractC1357k0 = this;
        boolean z8 = false;
        while (true) {
            if (AbstractC1387q0.k(abstractC1357k0, obj, c1332f0)) {
                w(abstractC1357k0, z7);
                if (!(obj instanceof RunnableC1337g0)) {
                    break;
                }
                G0 g02 = ((RunnableC1337g0) obj).f15413b;
                if (!(g02 instanceof InterfaceC1352j0)) {
                    g02.cancel(z7);
                    break;
                }
                abstractC1357k0 = (AbstractC1357k0) g02;
                obj = abstractC1357k0.f15491a;
                if (!(obj == null) && !(obj instanceof RunnableC1337g0)) {
                    break;
                }
                z8 = true;
            } else {
                obj = abstractC1357k0.f15491a;
                if (q(obj)) {
                    return z8;
                }
            }
        }
        return true;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return f();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f15491a instanceof C1332f0;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        Object obj = this.f15491a;
        return (obj != null) & q(obj);
    }

    public abstract String n();

    public abstract void p();

    public final boolean r(Throwable th) {
        if (!AbstractC1387q0.k(this, null, new C1342h0(th))) {
            return false;
        }
        w(this, false);
        return true;
    }

    public final boolean s(G0 g02) {
        C1342h0 c1342h0;
        Object obj = this.f15491a;
        if (obj == null) {
            if (g02.isDone()) {
                if (!AbstractC1387q0.k(this, null, t(g02))) {
                    return false;
                }
                w(this, false);
                return true;
            }
            RunnableC1337g0 runnableC1337g0 = new RunnableC1337g0(this, g02);
            if (AbstractC1387q0.k(this, null, runnableC1337g0)) {
                try {
                    g02.b(runnableC1337g0, EnumC1415w0.INSTANCE);
                } catch (Throwable th) {
                    try {
                        c1342h0 = new C1342h0(th);
                    } catch (Error | Exception unused) {
                        c1342h0 = C1342h0.f15417b;
                    }
                    AbstractC1387q0.k(this, runnableC1337g0, c1342h0);
                }
                return true;
            }
            obj = this.f15491a;
        }
        if (obj instanceof C1332f0) {
            g02.cancel(((C1332f0) obj).f15410a);
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 210
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.play_billing.AbstractC1357k0.toString():java.lang.String");
    }

    public final void v(StringBuilder sb) {
        String hexString;
        String str = "]";
        try {
            Object objU = u(this);
            sb.append("SUCCESS, result=[");
            if (objU == null) {
                hexString = "null";
            } else if (objU == this) {
                hexString = "this future";
            } else {
                sb.append(objU.getClass().getName());
                sb.append("@");
                hexString = Integer.toHexString(System.identityHashCode(objU));
            }
            sb.append(hexString);
            sb.append("]");
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        } catch (ExecutionException e8) {
            sb.append("FAILURE, cause=[");
            sb.append(e8.getCause());
            sb.append(str);
        } catch (Exception e9) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e9.getClass());
            str = " thrown from get()]";
            sb.append(str);
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j8, TimeUnit timeUnit) {
        return g(j8, timeUnit);
    }
}
