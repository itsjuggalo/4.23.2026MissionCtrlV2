package u6;

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
import p6.n;
import p6.r;
import sun.misc.Unsafe;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a extends v6.a implements u6.f {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final boolean f22173d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f22174e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final b f22175f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Object f22176g;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Object f22177a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile e f22178b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile i f22179c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
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

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f22180c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f22181d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f22182a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f22183b;

        static {
            if (a.f22173d) {
                f22181d = null;
                f22180c = null;
            } else {
                f22181d = new c(false, null);
                f22180c = new c(true, null);
            }
        }

        public c(boolean z10, Throwable th) {
            this.f22182a = z10;
            this.f22183b = th;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f22184b = new d(new C0382a("Failure occurred while trying to finish a future."));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f22185a;

        /* JADX INFO: renamed from: u6.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0382a extends Throwable {
            public C0382a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            this.f22185a = (Throwable) n.n(th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f22190a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f22191b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f22192c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f22193d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f22194e;

        public f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f22190a = atomicReferenceFieldUpdater;
            this.f22191b = atomicReferenceFieldUpdater2;
            this.f22192c = atomicReferenceFieldUpdater3;
            this.f22193d = atomicReferenceFieldUpdater4;
            this.f22194e = atomicReferenceFieldUpdater5;
        }

        @Override // u6.a.b
        public boolean a(a aVar, e eVar, e eVar2) {
            return y.b.a(this.f22193d, aVar, eVar, eVar2);
        }

        @Override // u6.a.b
        public boolean b(a aVar, Object obj, Object obj2) {
            return y.b.a(this.f22194e, aVar, obj, obj2);
        }

        @Override // u6.a.b
        public boolean c(a aVar, i iVar, i iVar2) {
            return y.b.a(this.f22192c, aVar, iVar, iVar2);
        }

        @Override // u6.a.b
        public e d(a aVar, e eVar) {
            return (e) this.f22193d.getAndSet(aVar, eVar);
        }

        @Override // u6.a.b
        public i e(a aVar, i iVar) {
            return (i) this.f22192c.getAndSet(aVar, iVar);
        }

        @Override // u6.a.b
        public void f(i iVar, i iVar2) {
            this.f22191b.lazySet(iVar, iVar2);
        }

        @Override // u6.a.b
        public void g(i iVar, Thread thread) {
            this.f22190a.lazySet(iVar, thread);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class g extends b {
        public g() {
            super();
        }

        @Override // u6.a.b
        public boolean a(a aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.f22178b != eVar) {
                        return false;
                    }
                    aVar.f22178b = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // u6.a.b
        public boolean b(a aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                try {
                    if (aVar.f22177a != obj) {
                        return false;
                    }
                    aVar.f22177a = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // u6.a.b
        public boolean c(a aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.f22179c != iVar) {
                        return false;
                    }
                    aVar.f22179c = iVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // u6.a.b
        public e d(a aVar, e eVar) {
            e eVar2;
            synchronized (aVar) {
                try {
                    eVar2 = aVar.f22178b;
                    if (eVar2 != eVar) {
                        aVar.f22178b = eVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return eVar2;
        }

        @Override // u6.a.b
        public i e(a aVar, i iVar) {
            i iVar2;
            synchronized (aVar) {
                try {
                    iVar2 = aVar.f22179c;
                    if (iVar2 != iVar) {
                        aVar.f22179c = iVar;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return iVar2;
        }

        @Override // u6.a.b
        public void f(i iVar, i iVar2) {
            iVar.f22203b = iVar2;
        }

        @Override // u6.a.b
        public void g(i iVar, Thread thread) {
            iVar.f22202a = thread;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class h extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final Unsafe f22195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final long f22196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final long f22197c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final long f22198d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final long f22199e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final long f22200f;

        /* JADX INFO: renamed from: u6.a$h$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0383a implements PrivilegedExceptionAction {
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
                } catch (PrivilegedActionException e10) {
                    throw new RuntimeException("Could not initialize intrinsics", e10.getCause());
                }
            } catch (SecurityException unused) {
                unsafe = (Unsafe) AccessController.doPrivileged(new C0383a());
            }
            try {
                f22197c = unsafe.objectFieldOffset(a.class.getDeclaredField("c"));
                f22196b = unsafe.objectFieldOffset(a.class.getDeclaredField("b"));
                f22198d = unsafe.objectFieldOffset(a.class.getDeclaredField("a"));
                f22199e = unsafe.objectFieldOffset(i.class.getDeclaredField("a"));
                f22200f = unsafe.objectFieldOffset(i.class.getDeclaredField("b"));
                f22195a = unsafe;
            } catch (NoSuchFieldException e11) {
                throw new RuntimeException(e11);
            } catch (RuntimeException e12) {
                throw e12;
            }
        }

        public h() {
            super();
        }

        @Override // u6.a.b
        public boolean a(a aVar, e eVar, e eVar2) {
            return com.google.android.gms.internal.play_billing.a.a(f22195a, aVar, f22196b, eVar, eVar2);
        }

        @Override // u6.a.b
        public boolean b(a aVar, Object obj, Object obj2) {
            return com.google.android.gms.internal.play_billing.a.a(f22195a, aVar, f22198d, obj, obj2);
        }

        @Override // u6.a.b
        public boolean c(a aVar, i iVar, i iVar2) {
            return com.google.android.gms.internal.play_billing.a.a(f22195a, aVar, f22197c, iVar, iVar2);
        }

        @Override // u6.a.b
        public e d(a aVar, e eVar) {
            e eVar2;
            do {
                eVar2 = aVar.f22178b;
                if (eVar == eVar2) {
                    break;
                }
            } while (!a(aVar, eVar2, eVar));
            return eVar2;
        }

        @Override // u6.a.b
        public i e(a aVar, i iVar) {
            i iVar2;
            do {
                iVar2 = aVar.f22179c;
                if (iVar == iVar2) {
                    break;
                }
            } while (!c(aVar, iVar2, iVar));
            return iVar2;
        }

        @Override // u6.a.b
        public void f(i iVar, i iVar2) {
            f22195a.putObject(iVar, f22200f, iVar2);
        }

        @Override // u6.a.b
        public void g(i iVar, Thread thread) {
            f22195a.putObject(iVar, f22199e, thread);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i f22201c = new i(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Thread f22202a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile i f22203b;

        public i(boolean z10) {
        }

        public void a(i iVar) {
            a.f22175f.f(this, iVar);
        }

        public void b() {
            Thread thread = this.f22202a;
            if (thread != null) {
                this.f22202a = null;
                LockSupport.unpark(thread);
            }
        }

        public i() {
            a.f22175f.g(this, Thread.currentThread());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [java.util.logging.Logger] */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.RuntimeException] */
    /* JADX WARN: Type inference failed for: r5v0, types: [u6.a$a] */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r5v3 */
    static {
        boolean z10;
        Throwable th;
        b fVar;
        try {
            z10 = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", com.amazon.a.a.o.b.f4546ag));
        } catch (SecurityException unused) {
            z10 = false;
        }
        f22173d = z10;
        f22174e = Logger.getLogger(a.class.getName());
        ?? r52 = 0;
        r52 = 0;
        try {
            fVar = new h();
            th = null;
        } catch (Error | RuntimeException e10) {
            th = e10;
            try {
                fVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, "c"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "a"));
            } catch (Error | RuntimeException e11) {
                g gVar = new g();
                r52 = e11;
                fVar = gVar;
            }
        }
        f22175f = fVar;
        if (r52 != 0) {
            ?? r02 = f22174e;
            Level level = Level.SEVERE;
            r02.log(level, "UnsafeAtomicHelper is broken!", th);
            r02.log(level, "SafeAtomicHelper is broken!", r52);
        }
        f22176g = new Object();
    }

    public static CancellationException n(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static void p(a aVar, boolean z10) {
        aVar.v();
        if (z10) {
            aVar.t();
        }
        aVar.l();
        e eVarO = aVar.o(null);
        while (eVarO != null) {
            e eVar = eVarO.f22189c;
            Runnable runnable = eVarO.f22187a;
            Objects.requireNonNull(runnable);
            Executor executor = eVarO.f22188b;
            Objects.requireNonNull(executor);
            q(runnable, executor);
            eVarO = eVar;
        }
    }

    public static void q(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e10) {
            f22174e.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e10);
        }
    }

    private static Object s(Future future) {
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

    @Override // u6.f
    public void a(Runnable runnable, Executor executor) {
        e eVar;
        n.o(runnable, "Runnable was null.");
        n.o(executor, "Executor was null.");
        if (!isDone() && (eVar = this.f22178b) != e.f22186d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f22189c = eVar;
                if (f22175f.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f22178b;
                }
            } while (eVar != e.f22186d);
        }
        q(runnable, executor);
    }

    @Override // v6.a
    public final Throwable b() {
        return null;
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z10) {
        c cVar;
        Object obj = this.f22177a;
        if (obj == null) {
            if (f22173d) {
                cVar = new c(z10, new CancellationException("Future.cancel() was called."));
            } else {
                cVar = z10 ? c.f22180c : c.f22181d;
                Objects.requireNonNull(cVar);
            }
            if (f22175f.b(this, obj, cVar)) {
                p(this, z10);
                return true;
            }
        }
        return false;
    }

    @Override // java.util.concurrent.Future
    public Object get(long j10, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j10);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f22177a;
        if (obj != null) {
            return r(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.f22179c;
            if (iVar != i.f22201c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f22175f.c(this, iVar, iVar2)) {
                        do {
                            u6.i.a(this, nanos);
                            if (Thread.interrupted()) {
                                w(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f22177a;
                            if (obj2 != null) {
                                return r(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        w(iVar2);
                    } else {
                        iVar = this.f22179c;
                    }
                } while (iVar != i.f22201c);
            }
            Object obj3 = this.f22177a;
            Objects.requireNonNull(obj3);
            return r(obj3);
        }
        while (nanos > 0) {
            Object obj4 = this.f22177a;
            if (obj4 != null) {
                return r(obj4);
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
    public boolean isCancelled() {
        return this.f22177a instanceof c;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f22177a != null;
    }

    public final void j(StringBuilder sb2) {
        try {
            Object objS = s(this);
            sb2.append("SUCCESS, result=[");
            m(sb2, objS);
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

    public final void k(StringBuilder sb2) {
        String strA;
        int length = sb2.length();
        sb2.append("PENDING");
        try {
            strA = r.a(u());
        } catch (RuntimeException | StackOverflowError e10) {
            strA = "Exception thrown from implementation: " + e10.getClass();
        }
        if (strA != null) {
            sb2.append(", info=[");
            sb2.append(strA);
            sb2.append("]");
        }
        if (isDone()) {
            sb2.delete(length, sb2.length());
            j(sb2);
        }
    }

    public final void m(StringBuilder sb2, Object obj) {
        if (obj == null) {
            sb2.append("null");
        } else {
            if (obj == this) {
                sb2.append("this future");
                return;
            }
            sb2.append(obj.getClass().getName());
            sb2.append("@");
            sb2.append(Integer.toHexString(System.identityHashCode(obj)));
        }
    }

    public final e o(e eVar) {
        e eVar2 = eVar;
        e eVarD = f22175f.d(this, e.f22186d);
        while (eVarD != null) {
            e eVar3 = eVarD.f22189c;
            eVarD.f22189c = eVar2;
            eVar2 = eVarD;
            eVarD = eVar3;
        }
        return eVar2;
    }

    public final Object r(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw n("Task was cancelled.", ((c) obj).f22183b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f22185a);
        }
        return obj == f22176g ? u6.h.a() : obj;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        if (getClass().getName().startsWith("com.google.common.util.concurrent.")) {
            sb2.append(getClass().getSimpleName());
        } else {
            sb2.append(getClass().getName());
        }
        sb2.append('@');
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append("[status=");
        if (isCancelled()) {
            sb2.append("CANCELLED");
        } else if (isDone()) {
            j(sb2);
        } else {
            k(sb2);
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

    public final void v() {
        for (i iVarE = f22175f.e(this, i.f22201c); iVarE != null; iVarE = iVarE.f22203b) {
            iVarE.b();
        }
    }

    public final void w(i iVar) {
        iVar.f22202a = null;
        while (true) {
            i iVar2 = this.f22179c;
            if (iVar2 == i.f22201c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f22203b;
                if (iVar2.f22202a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f22203b = iVar4;
                    if (iVar3.f22202a == null) {
                        break;
                    }
                } else if (!f22175f.c(this, iVar2, iVar4)) {
                    break;
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    public boolean x(Object obj) {
        if (obj == null) {
            obj = f22176g;
        }
        if (!f22175f.b(this, null, obj)) {
            return false;
        }
        p(this, false);
        return true;
    }

    public boolean y(Throwable th) {
        if (!f22175f.b(this, null, new d((Throwable) n.n(th)))) {
            return false;
        }
        p(this, false);
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f22186d = new e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f22187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f22188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f22189c;

        public e(Runnable runnable, Executor executor) {
            this.f22187a = runnable;
            this.f22188b = executor;
        }

        public e() {
            this.f22187a = null;
            this.f22188b = null;
        }
    }

    public void l() {
    }

    public void t() {
    }

    @Override // java.util.concurrent.Future
    public Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f22177a;
            if (obj2 != null) {
                return r(obj2);
            }
            i iVar = this.f22179c;
            if (iVar != i.f22201c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (f22175f.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f22177a;
                            } else {
                                w(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!(obj != null));
                        return r(obj);
                    }
                    iVar = this.f22179c;
                } while (iVar != i.f22201c);
            }
            Object obj3 = this.f22177a;
            Objects.requireNonNull(obj3);
            return r(obj3);
        }
        throw new InterruptedException();
    }
}
