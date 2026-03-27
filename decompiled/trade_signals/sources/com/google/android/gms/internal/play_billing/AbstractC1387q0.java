package com.google.android.gms.internal.play_billing;

import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: com.google.android.gms.internal.play_billing.q0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1387q0 extends N0 implements G0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Object f15487d = new Object();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final F0 f15488e = new F0(AbstractC1357k0.class);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final boolean f15489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AbstractC1362l0 f15490g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f15491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile C1347i0 f15492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile C1382p0 f15493c;

    static {
        boolean z7;
        Throwable th;
        Throwable th2;
        AbstractC1362l0 c1372n0;
        try {
            z7 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", com.amazon.a.a.o.b.ag));
        } catch (SecurityException unused) {
            z7 = false;
        }
        f15489f = z7;
        String property = System.getProperty("java.runtime.name", "");
        AbstractC1411v0 abstractC1411v0 = null;
        if (property == null || property.contains("Android")) {
            try {
                c1372n0 = new C1377o0(abstractC1411v0);
            } catch (Error | Exception e8) {
                try {
                    th = e8;
                    th2 = null;
                    c1372n0 = new C1367m0(abstractC1411v0);
                } catch (Error | Exception e9) {
                    th = e8;
                    th2 = e9;
                    c1372n0 = new C1372n0(abstractC1411v0);
                }
            }
        } else {
            try {
                c1372n0 = new C1367m0(abstractC1411v0);
            } catch (NoClassDefFoundError unused2) {
                c1372n0 = new C1372n0(abstractC1411v0);
            }
        }
        th2 = null;
        th = null;
        f15490g = c1372n0;
        if (th2 != null) {
            F0 f02 = f15488e;
            Logger loggerA = f02.a();
            Level level = Level.SEVERE;
            loggerA.logp(level, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "UnsafeAtomicHelper is broken!", th);
            f02.a().logp(level, "com.google.common.util.concurrent.AbstractFutureState", "<clinit>", "AtomicReferenceFieldUpdaterAtomicHelper is broken!", th2);
        }
    }

    public static boolean k(AbstractC1387q0 abstractC1387q0, Object obj, Object obj2) {
        return f15490g.f(abstractC1387q0, obj, obj2);
    }

    public final void d(C1382p0 c1382p0) {
        c1382p0.f15482a = null;
        while (true) {
            C1382p0 c1382p02 = this.f15493c;
            if (c1382p02 != C1382p0.f15481c) {
                C1382p0 c1382p03 = null;
                while (c1382p02 != null) {
                    C1382p0 c1382p04 = c1382p02.f15483b;
                    if (c1382p02.f15482a != null) {
                        c1382p03 = c1382p02;
                    } else if (c1382p03 != null) {
                        c1382p03.f15483b = c1382p04;
                        if (c1382p03.f15482a == null) {
                            break;
                        }
                    } else if (!f15490g.g(this, c1382p02, c1382p04)) {
                        break;
                    }
                    c1382p02 = c1382p04;
                }
                return;
            }
            return;
        }
    }

    public final C1347i0 e(C1347i0 c1347i0) {
        return f15490g.a(this, c1347i0);
    }

    public final Object f() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f15491a;
        if ((obj2 != null) && AbstractC1357k0.q(obj2)) {
            return AbstractC1357k0.m(obj2);
        }
        C1382p0 c1382p0 = this.f15493c;
        if (c1382p0 != C1382p0.f15481c) {
            C1382p0 c1382p02 = new C1382p0();
            do {
                AbstractC1362l0 abstractC1362l0 = f15490g;
                abstractC1362l0.c(c1382p02, c1382p0);
                if (abstractC1362l0.g(this, c1382p0, c1382p02)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            d(c1382p02);
                            throw new InterruptedException();
                        }
                        obj = this.f15491a;
                    } while (!((obj != null) & AbstractC1357k0.q(obj)));
                    return AbstractC1357k0.m(obj);
                }
                c1382p0 = this.f15493c;
            } while (c1382p0 != C1382p0.f15481c);
        }
        Object obj3 = this.f15491a;
        Objects.requireNonNull(obj3);
        return AbstractC1357k0.m(obj3);
    }

    public final Object g(long j8, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j8);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f15491a;
        boolean z7 = true;
        if ((obj != null) && AbstractC1357k0.q(obj)) {
            return AbstractC1357k0.m(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            C1382p0 c1382p0 = this.f15493c;
            if (c1382p0 != C1382p0.f15481c) {
                C1382p0 c1382p02 = new C1382p0();
                do {
                    AbstractC1362l0 abstractC1362l0 = f15490g;
                    abstractC1362l0.c(c1382p02, c1382p0);
                    if (abstractC1362l0.g(this, c1382p0, c1382p02)) {
                        do {
                            LockSupport.parkNanos(this, Math.min(nanos, 2147483647999999999L));
                            if (Thread.interrupted()) {
                                d(c1382p02);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f15491a;
                            if ((obj2 != null) && AbstractC1357k0.q(obj2)) {
                                return AbstractC1357k0.m(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        d(c1382p02);
                    } else {
                        c1382p0 = this.f15493c;
                    }
                } while (c1382p0 != C1382p0.f15481c);
            }
            Object obj3 = this.f15491a;
            Objects.requireNonNull(obj3);
            return AbstractC1357k0.m(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.f15491a;
            if ((obj4 != null) && AbstractC1357k0.q(obj4)) {
                return AbstractC1357k0.m(obj4);
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
            if (jConvert != 0 && nanos2 <= 1000) {
                z7 = false;
            }
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

    public final void i() {
        for (C1382p0 c1382p0B = f15490g.b(this, C1382p0.f15481c); c1382p0B != null; c1382p0B = c1382p0B.f15483b) {
            Thread thread = c1382p0B.f15482a;
            if (thread != null) {
                c1382p0B.f15482a = null;
                LockSupport.unpark(thread);
            }
        }
    }

    public final boolean j(C1347i0 c1347i0, C1347i0 c1347i02) {
        return f15490g.e(this, c1347i0, c1347i02);
    }
}
