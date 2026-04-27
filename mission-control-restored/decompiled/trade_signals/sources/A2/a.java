package A2;

import com.google.android.gms.internal.play_billing.AbstractC1396s0;
import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.Locale;
import java.util.Objects;
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
import sun.misc.Unsafe;
import v2.AbstractC2848n;
import v2.AbstractC2852r;
import y.AbstractC2965b;

/* JADX INFO: loaded from: classes.dex */
public abstract class a extends B2.a implements A2.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f40d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f41e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f42f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f43g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f44a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile e f45b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile i f46c;

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(a aVar, e eVar, e eVar2);

        public abstract boolean b(a aVar, Object obj, Object obj2);

        public abstract boolean c(a aVar, i iVar, i iVar2);

        public abstract e d(a aVar, e eVar);

        public abstract i e(a aVar, i iVar);

        public abstract void f(i iVar, i iVar2);

        public abstract void g(i iVar, Thread thread);
    }

    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f47c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f48d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f49a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f50b;

        static {
            if (a.f40d) {
                f48d = null;
                f47c = null;
            } else {
                f48d = new c(false, null);
                f47c = new c(true, null);
            }
        }

        public c(boolean z7, Throwable th) {
            this.f49a = z7;
            this.f50b = th;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f51b = new d(new C0002a("Failure occurred while trying to finish a future."));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f52a;

        /* JADX INFO: renamed from: A2.a$d$a, reason: collision with other inner class name */
        public class C0002a extends Throwable {
            public C0002a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            this.f52a = (Throwable) AbstractC2848n.n(th);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f53d = new e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f54a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f55b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f56c;

        public e() {
            this.f54a = null;
            this.f55b = null;
        }

        public e(Runnable runnable, Executor executor) {
            this.f54a = runnable;
            this.f55b = executor;
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f57a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f58b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f59c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f60d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f61e;

        public f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f57a = atomicReferenceFieldUpdater;
            this.f58b = atomicReferenceFieldUpdater2;
            this.f59c = atomicReferenceFieldUpdater3;
            this.f60d = atomicReferenceFieldUpdater4;
            this.f61e = atomicReferenceFieldUpdater5;
        }

        @Override // A2.a.b
        public boolean a(a aVar, e eVar, e eVar2) {
            return AbstractC2965b.a(this.f60d, aVar, eVar, eVar2);
        }

        @Override // A2.a.b
        public boolean b(a aVar, Object obj, Object obj2) {
            return AbstractC2965b.a(this.f61e, aVar, obj, obj2);
        }

        @Override // A2.a.b
        public boolean c(a aVar, i iVar, i iVar2) {
            return AbstractC2965b.a(this.f59c, aVar, iVar, iVar2);
        }

        @Override // A2.a.b
        public e d(a aVar, e eVar) {
            return (e) this.f60d.getAndSet(aVar, eVar);
        }

        @Override // A2.a.b
        public i e(a aVar, i iVar) {
            return (i) this.f59c.getAndSet(aVar, iVar);
        }

        @Override // A2.a.b
        public void f(i iVar, i iVar2) {
            this.f58b.lazySet(iVar, iVar2);
        }

        @Override // A2.a.b
        public void g(i iVar, Thread thread) {
            this.f57a.lazySet(iVar, thread);
        }
    }

    public static final class g extends b {
        public g() {
            super();
        }

        @Override // A2.a.b
        public boolean a(a aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.f45b != eVar) {
                        return false;
                    }
                    aVar.f45b = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // A2.a.b
        public boolean b(a aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                try {
                    if (aVar.f44a != obj) {
                        return false;
                    }
                    aVar.f44a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // A2.a.b
        public boolean c(a aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.f46c != iVar) {
                        return false;
                    }
                    aVar.f46c = iVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // A2.a.b
        public e d(a aVar, e eVar) {
            e eVar2;
            synchronized (aVar) {
                try {
                    eVar2 = aVar.f45b;
                    if (eVar2 != eVar) {
                        aVar.f45b = eVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return eVar2;
        }

        @Override // A2.a.b
        public i e(a aVar, i iVar) {
            i iVar2;
            synchronized (aVar) {
                try {
                    iVar2 = aVar.f46c;
                    if (iVar2 != iVar) {
                        aVar.f46c = iVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return iVar2;
        }

        @Override // A2.a.b
        public void f(i iVar, i iVar2) {
            iVar.f70b = iVar2;
        }

        @Override // A2.a.b
        public void g(i iVar, Thread thread) {
            iVar.f69a = thread;
        }
    }

    public static final class h extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Unsafe f62a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final long f63b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final long f64c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final long f65d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final long f66e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final long f67f;

        /* JADX INFO: renamed from: A2.a$h$a, reason: collision with other inner class name */
        public class C0003a implements PrivilegedExceptionAction {
            @Override // java.security.PrivilegedExceptionAction
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Unsafe run() throws IllegalAccessException {
                for (Field field : Unsafe.class.getDeclaredFields()) {
                    field.setAccessible(true);
                    Object obj = field.get(null);
                    if (Unsafe.class.isInstance(obj)) {
                        return (Unsafe) Unsafe.class.cast(obj);
                    }
                }
                throw new NoSuchFieldError("the Unsafe");
            }
        }

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (PrivilegedActionException e8) {
                    throw new RuntimeException("Could not initialize intrinsics", e8.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new C0003a());
            }
            try {
                f64c = unsafe.objectFieldOffset(a.class.getDeclaredField("c"));
                f63b = unsafe.objectFieldOffset(a.class.getDeclaredField("b"));
                f65d = unsafe.objectFieldOffset(a.class.getDeclaredField("a"));
                f66e = unsafe.objectFieldOffset(i.class.getDeclaredField("a"));
                f67f = unsafe.objectFieldOffset(i.class.getDeclaredField("b"));
                f62a = unsafe;
            } catch (NoSuchFieldException e9) {
                throw new RuntimeException(e9);
            } catch (RuntimeException e10) {
                throw e10;
            }
        }

        public h() {
            super();
        }

        @Override // A2.a.b
        public boolean a(a aVar, e eVar, e eVar2) {
            return AbstractC1396s0.a(f62a, aVar, f63b, eVar, eVar2);
        }

        @Override // A2.a.b
        public boolean b(a aVar, Object obj, Object obj2) {
            return AbstractC1396s0.a(f62a, aVar, f65d, obj, obj2);
        }

        @Override // A2.a.b
        public boolean c(a aVar, i iVar, i iVar2) {
            return AbstractC1396s0.a(f62a, aVar, f64c, iVar, iVar2);
        }

        @Override // A2.a.b
        public e d(a aVar, e eVar) {
            e eVar2;
            do {
                eVar2 = aVar.f45b;
                if (eVar == eVar2) {
                    return eVar2;
                }
            } while (!a(aVar, eVar2, eVar));
            return eVar2;
        }

        @Override // A2.a.b
        public i e(a aVar, i iVar) {
            i iVar2;
            do {
                iVar2 = aVar.f46c;
                if (iVar == iVar2) {
                    return iVar2;
                }
            } while (!c(aVar, iVar2, iVar));
            return iVar2;
        }

        @Override // A2.a.b
        public void f(i iVar, i iVar2) {
            f62a.putObject(iVar, f67f, iVar2);
        }

        @Override // A2.a.b
        public void g(i iVar, Thread thread) {
            f62a.putObject(iVar, f66e, thread);
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i f68c = new i(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Thread f69a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile i f70b;

        public i() {
            a.f42f.g(this, Thread.currentThread());
        }

        public void a(i iVar) {
            a.f42f.f(this, iVar);
        }

        public void b() {
            Thread thread = this.f69a;
            if (thread != null) {
                this.f69a = null;
                LockSupport.unpark(thread);
            }
        }

        public i(boolean z7) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r4v2, types: [A2.a$a] */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v5 */
    static {
        boolean z7;
        b gVar;
        try {
            z7 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", com.amazon.a.a.o.b.ag));
        } catch (SecurityException unused) {
            z7 = false;
        }
        f40d = z7;
        f41e = Logger.getLogger(a.class.getName());
        ?? r42 = 0;
        r42 = 0;
        try {
            gVar = new h();
            e = null;
        } catch (Error | RuntimeException e8) {
            e = e8;
            try {
                gVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            } catch (Error | RuntimeException e9) {
                gVar = new g();
                r42 = e9;
            }
        }
        f42f = gVar;
        if (r42 != 0) {
            ?? r02 = f41e;
            Level level = Level.SEVERE;
            r02.log(level, "UnsafeAtomicHelper is broken!", e);
            r02.log(level, "SafeAtomicHelper is broken!", r42);
        }
        f43g = new Object();
    }

    public static CancellationException o(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static void q(a aVar, boolean z7) {
        aVar.w();
        if (z7) {
            aVar.u();
        }
        aVar.m();
        e eVarP = aVar.p(null);
        while (eVarP != null) {
            e eVar = eVarP.f56c;
            Runnable runnable = eVarP.f54a;
            Objects.requireNonNull(runnable);
            Executor executor = eVarP.f55b;
            Objects.requireNonNull(executor);
            r(runnable, executor);
            eVarP = eVar;
        }
    }

    public static void r(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e8) {
            f41e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e8);
        }
    }

    private static Object t(Future future) {
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

    @Override // A2.f
    public void a(Runnable runnable, Executor executor) {
        e eVar;
        AbstractC2848n.o(runnable, "Runnable was null.");
        AbstractC2848n.o(executor, "Executor was null.");
        if (!isDone() && (eVar = this.f45b) != e.f53d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f56c = eVar;
                if (f42f.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f45b;
                }
            } while (eVar != e.f53d);
        }
        r(runnable, executor);
    }

    @Override // B2.a
    public final Throwable c() {
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z7) {
        c cVar;
        Object obj = this.f44a;
        if (obj == null) {
            if (f40d) {
                cVar = new c(z7, new CancellationException("Future.cancel() was called."));
            } else {
                cVar = z7 ? c.f47c : c.f48d;
                Objects.requireNonNull(cVar);
            }
            if (f42f.b(this, obj, cVar)) {
                q(this, z7);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f44a;
        if (obj2 != null) {
            return s(obj2);
        }
        i iVar = this.f46c;
        if (iVar != i.f68c) {
            i iVar2 = new i();
            do {
                iVar2.a(iVar);
                if (f42f.c(this, iVar, iVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            x(iVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f44a;
                    } while (!(obj != null));
                    return s(obj);
                }
                iVar = this.f46c;
            } while (iVar != i.f68c);
        }
        Object obj3 = this.f44a;
        Objects.requireNonNull(obj3);
        return s(obj3);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f44a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f44a != null;
    }

    public final void k(StringBuilder sb) {
        String str = "]";
        try {
            Object objT = t(this);
            sb.append("SUCCESS, result=[");
            n(sb, objT);
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

    public final void l(StringBuilder sb) {
        String strA;
        int length = sb.length();
        sb.append("PENDING");
        try {
            strA = AbstractC2852r.a(v());
        } catch (RuntimeException | StackOverflowError e8) {
            strA = "Exception thrown from implementation: " + e8.getClass();
        }
        if (strA != null) {
            sb.append(", info=[");
            sb.append(strA);
            sb.append("]");
        }
        if (isDone()) {
            sb.delete(length, sb.length());
            k(sb);
        }
    }

    public final void n(StringBuilder sb, Object obj) {
        String hexString;
        if (obj == null) {
            hexString = "null";
        } else if (obj == this) {
            hexString = "this future";
        } else {
            sb.append(obj.getClass().getName());
            sb.append("@");
            hexString = Integer.toHexString(System.identityHashCode(obj));
        }
        sb.append(hexString);
    }

    public final e p(e eVar) {
        e eVar2 = eVar;
        e eVarD = f42f.d(this, e.f53d);
        while (eVarD != null) {
            e eVar3 = eVarD.f56c;
            eVarD.f56c = eVar2;
            eVar2 = eVarD;
            eVarD = eVar3;
        }
        return eVar2;
    }

    public final Object s(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw o("Task was cancelled.", ((c) obj).f50b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f52a);
        }
        return obj == f43g ? A2.h.a() : obj;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName().startsWith("com.google.common.util.concurrent.") ? getClass().getSimpleName() : getClass().getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            k(sb);
        } else {
            l(sb);
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String v() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void w() {
        for (i iVarE = f42f.e(this, i.f68c); iVarE != null; iVarE = iVarE.f70b) {
            iVarE.b();
        }
    }

    public final void x(i iVar) {
        iVar.f69a = null;
        while (true) {
            i iVar2 = this.f46c;
            if (iVar2 == i.f68c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f70b;
                if (iVar2.f69a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f70b = iVar4;
                    if (iVar3.f69a == null) {
                        break;
                    }
                } else if (!f42f.c(this, iVar2, iVar4)) {
                    break;
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    public boolean y(Object obj) {
        if (obj == null) {
            obj = f43g;
        }
        if (!f42f.b(this, null, obj)) {
            return false;
        }
        q(this, false);
        return true;
    }

    public boolean z(Throwable th) {
        if (!f42f.b(this, null, new d((Throwable) AbstractC2848n.n(th)))) {
            return false;
        }
        q(this, false);
        return true;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j8, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j8);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f44a;
        if (obj != null) {
            return s(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.f46c;
            if (iVar != i.f68c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f42f.c(this, iVar, iVar2)) {
                        do {
                            A2.i.a(this, nanos);
                            if (Thread.interrupted()) {
                                x(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f44a;
                            if (obj2 != null) {
                                return s(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        x(iVar2);
                    } else {
                        iVar = this.f46c;
                    }
                } while (iVar != i.f68c);
            }
            Object obj3 = this.f44a;
            Objects.requireNonNull(obj3);
            return s(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.f44a;
            if (obj4 != null) {
                return s(obj4);
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

    public void m() {
    }

    public void u() {
    }
}
