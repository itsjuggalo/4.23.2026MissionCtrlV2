package v;

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

/* JADX INFO: renamed from: v.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2758a implements M2.e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f24708d = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", com.amazon.a.a.o.b.ag));

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f24709e = Logger.getLogger(AbstractC2758a.class.getName());

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f24710f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f24711g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f24712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile e f24713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile h f24714c;

    /* JADX INFO: renamed from: v.a$b */
    public static abstract class b {
        public b() {
        }

        public abstract boolean a(AbstractC2758a abstractC2758a, e eVar, e eVar2);

        public abstract boolean b(AbstractC2758a abstractC2758a, Object obj, Object obj2);

        public abstract boolean c(AbstractC2758a abstractC2758a, h hVar, h hVar2);

        public abstract void d(h hVar, h hVar2);

        public abstract void e(h hVar, Thread thread);
    }

    /* JADX INFO: renamed from: v.a$c */
    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f24715c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f24716d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f24717a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f24718b;

        static {
            if (AbstractC2758a.f24708d) {
                f24716d = null;
                f24715c = null;
            } else {
                f24716d = new c(false, null);
                f24715c = new c(true, null);
            }
        }

        public c(boolean z7, Throwable th) {
            this.f24717a = z7;
            this.f24718b = th;
        }
    }

    /* JADX INFO: renamed from: v.a$d */
    public static final class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f24719b = new d(new C0384a("Failure occurred while trying to finish a future."));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f24720a;

        /* JADX INFO: renamed from: v.a$d$a, reason: collision with other inner class name */
        public class C0384a extends Throwable {
            public C0384a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            this.f24720a = (Throwable) AbstractC2758a.i(th);
        }
    }

    /* JADX INFO: renamed from: v.a$e */
    public static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f24721d = new e(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f24722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f24723b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f24724c;

        public e(Runnable runnable, Executor executor) {
            this.f24722a = runnable;
            this.f24723b = executor;
        }
    }

    /* JADX INFO: renamed from: v.a$f */
    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f24725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f24726b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f24727c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f24728d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f24729e;

        public f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f24725a = atomicReferenceFieldUpdater;
            this.f24726b = atomicReferenceFieldUpdater2;
            this.f24727c = atomicReferenceFieldUpdater3;
            this.f24728d = atomicReferenceFieldUpdater4;
            this.f24729e = atomicReferenceFieldUpdater5;
        }

        @Override // v.AbstractC2758a.b
        public boolean a(AbstractC2758a abstractC2758a, e eVar, e eVar2) {
            return AbstractC2759b.a(this.f24728d, abstractC2758a, eVar, eVar2);
        }

        @Override // v.AbstractC2758a.b
        public boolean b(AbstractC2758a abstractC2758a, Object obj, Object obj2) {
            return AbstractC2759b.a(this.f24729e, abstractC2758a, obj, obj2);
        }

        @Override // v.AbstractC2758a.b
        public boolean c(AbstractC2758a abstractC2758a, h hVar, h hVar2) {
            return AbstractC2759b.a(this.f24727c, abstractC2758a, hVar, hVar2);
        }

        @Override // v.AbstractC2758a.b
        public void d(h hVar, h hVar2) {
            this.f24726b.lazySet(hVar, hVar2);
        }

        @Override // v.AbstractC2758a.b
        public void e(h hVar, Thread thread) {
            this.f24725a.lazySet(hVar, thread);
        }
    }

    /* JADX INFO: renamed from: v.a$g */
    public static final class g extends b {
        public g() {
            super();
        }

        @Override // v.AbstractC2758a.b
        public boolean a(AbstractC2758a abstractC2758a, e eVar, e eVar2) {
            synchronized (abstractC2758a) {
                try {
                    if (abstractC2758a.f24713b != eVar) {
                        return false;
                    }
                    abstractC2758a.f24713b = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // v.AbstractC2758a.b
        public boolean b(AbstractC2758a abstractC2758a, Object obj, Object obj2) {
            synchronized (abstractC2758a) {
                try {
                    if (abstractC2758a.f24712a != obj) {
                        return false;
                    }
                    abstractC2758a.f24712a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // v.AbstractC2758a.b
        public boolean c(AbstractC2758a abstractC2758a, h hVar, h hVar2) {
            synchronized (abstractC2758a) {
                try {
                    if (abstractC2758a.f24714c != hVar) {
                        return false;
                    }
                    abstractC2758a.f24714c = hVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // v.AbstractC2758a.b
        public void d(h hVar, h hVar2) {
            hVar.f24732b = hVar2;
        }

        @Override // v.AbstractC2758a.b
        public void e(h hVar, Thread thread) {
            hVar.f24731a = thread;
        }
    }

    /* JADX INFO: renamed from: v.a$h */
    public static final class h {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final h f24730c = new h(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Thread f24731a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile h f24732b;

        public h(boolean z7) {
        }

        public void a(h hVar) {
            AbstractC2758a.f24710f.d(this, hVar);
        }

        public void b() {
            Thread thread = this.f24731a;
            if (thread != null) {
                this.f24731a = null;
                LockSupport.unpark(thread);
            }
        }

        public h() {
            AbstractC2758a.f24710f.e(this, Thread.currentThread());
        }
    }

    static {
        b gVar;
        try {
            gVar = new f(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractC2758a.class, h.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractC2758a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractC2758a.class, Object.class, "a"));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f24710f = gVar;
        if (th != null) {
            f24709e.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f24711g = new Object();
    }

    public static CancellationException h(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static Object i(Object obj) {
        obj.getClass();
        return obj;
    }

    public static void k(AbstractC2758a abstractC2758a) {
        abstractC2758a.q();
        abstractC2758a.c();
        e eVarJ = abstractC2758a.j(null);
        while (eVarJ != null) {
            e eVar = eVarJ.f24724c;
            l(eVarJ.f24722a, eVarJ.f24723b);
            eVarJ = eVar;
        }
    }

    public static void l(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e7) {
            f24709e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e7);
        }
    }

    public static Object n(Future future) {
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

    @Override // M2.e
    public final void a(Runnable runnable, Executor executor) {
        i(runnable);
        i(executor);
        e eVar = this.f24713b;
        if (eVar != e.f24721d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f24724c = eVar;
                if (f24710f.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f24713b;
                }
            } while (eVar != e.f24721d);
        }
        l(runnable, executor);
    }

    public final void b(StringBuilder sb) {
        try {
            Object objN = n(this);
            sb.append("SUCCESS, result=[");
            sb.append(u(objN));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e7) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e7.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e8) {
            sb.append("FAILURE, cause=[");
            sb.append(e8.getCause());
            sb.append("]");
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z7) {
        Object obj = this.f24712a;
        if (obj == null) {
            if (f24710f.b(this, obj, f24708d ? new c(z7, new CancellationException("Future.cancel() was called.")) : z7 ? c.f24715c : c.f24716d)) {
                if (z7) {
                    o();
                }
                k(this);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j7, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j7);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f24712a;
        if (obj != null) {
            return m(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.f24714c;
            if (hVar != h.f24730c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f24710f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                r(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f24712a;
                            if (obj2 != null) {
                                return m(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        r(hVar2);
                    } else {
                        hVar = this.f24714c;
                    }
                } while (hVar != h.f24730c);
            }
            return m(this.f24712a);
        }
        while (nanos > 0) {
            Object obj3 = this.f24712a;
            if (obj3 != null) {
                return m(obj3);
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
        String str = "Waited " + j7 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j8 = -nanos;
            long jConvert = timeUnit.convert(j8, TimeUnit.NANOSECONDS);
            long nanos2 = j8 - timeUnit.toNanos(jConvert);
            boolean z7 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z7) {
                    str3 = str3 + com.amazon.a.a.o.b.f.f9989a;
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

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f24712a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.f24712a != null;
    }

    public final e j(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f24713b;
        } while (!f24710f.a(this, eVar2, e.f24721d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f24724c;
            eVar4.f24724c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    public final Object m(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw h("Task was cancelled.", ((c) obj).f24718b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f24720a);
        }
        if (obj == f24711g) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String p() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void q() {
        h hVar;
        do {
            hVar = this.f24714c;
        } while (!f24710f.c(this, hVar, h.f24730c));
        while (hVar != null) {
            hVar.b();
            hVar = hVar.f24732b;
        }
    }

    public final void r(h hVar) {
        hVar.f24731a = null;
        while (true) {
            h hVar2 = this.f24714c;
            if (hVar2 == h.f24730c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.f24732b;
                if (hVar2.f24731a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.f24732b = hVar4;
                    if (hVar3.f24731a == null) {
                        break;
                    }
                } else if (!f24710f.c(this, hVar2, hVar4)) {
                    break;
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    public boolean s(Object obj) {
        if (obj == null) {
            obj = f24711g;
        }
        if (!f24710f.b(this, null, obj)) {
            return false;
        }
        k(this);
        return true;
    }

    public boolean t(Throwable th) {
        if (!f24710f.b(this, null, new d((Throwable) i(th)))) {
            return false;
        }
        k(this);
        return true;
    }

    public String toString() {
        String strP;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            b(sb);
        } else {
            try {
                strP = p();
            } catch (RuntimeException e7) {
                strP = "Exception thrown from implementation: " + e7.getClass();
            }
            if (strP != null && !strP.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strP);
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

    public final String u(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final boolean v() {
        Object obj = this.f24712a;
        return (obj instanceof c) && ((c) obj).f24717a;
    }

    public void c() {
    }

    public void o() {
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f24712a;
            if (obj2 != null) {
                return m(obj2);
            }
            h hVar = this.f24714c;
            if (hVar != h.f24730c) {
                h hVar2 = new h();
                do {
                    hVar2.a(hVar);
                    if (f24710f.c(this, hVar, hVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f24712a;
                            } else {
                                r(hVar2);
                                throw new InterruptedException();
                            }
                        } while (!(obj != null));
                        return m(obj);
                    }
                    hVar = this.f24714c;
                } while (hVar != h.f24730c);
            }
            return m(this.f24712a);
        }
        throw new InterruptedException();
    }
}
