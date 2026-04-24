package androidx.concurrent.futures;

import e2.InterfaceFutureC1233e;
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

/* JADX INFO: loaded from: classes.dex */
public abstract class a implements InterfaceFutureC1233e {
    static final b ATOMIC_HELPER;
    private static final Object NULL;
    private static final long SPIN_THRESHOLD_NANOS = 1000;
    volatile e listeners;
    volatile Object value;
    volatile i waiters;
    static final boolean GENERATE_CANCELLATION_CAUSES = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", com.amazon.a.a.o.b.ag));
    private static final Logger log = Logger.getLogger(a.class.getName());

    public static abstract class b {
        public b() {
        }

        public abstract boolean a(a aVar, e eVar, e eVar2);

        public abstract boolean b(a aVar, Object obj, Object obj2);

        public abstract boolean c(a aVar, i iVar, i iVar2);

        public abstract void d(i iVar, i iVar2);

        public abstract void e(i iVar, Thread thread);
    }

    public static final class c {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f6816c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f6817d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f6818a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f6819b;

        static {
            if (a.GENERATE_CANCELLATION_CAUSES) {
                f6817d = null;
                f6816c = null;
            } else {
                f6817d = new c(false, null);
                f6816c = new c(true, null);
            }
        }

        public c(boolean z4, Throwable th) {
            this.f6818a = z4;
            this.f6819b = th;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f6820b = new d(new C0098a("Failure occurred while trying to finish a future."));

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f6821a;

        /* JADX INFO: renamed from: androidx.concurrent.futures.a$d$a, reason: collision with other inner class name */
        public class C0098a extends Throwable {
            public C0098a(String str) {
                super(str);
            }

            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            this.f6821a = (Throwable) a.checkNotNull(th);
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final e f6822d = new e(null, null);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f6823a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Executor f6824b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public e f6825c;

        public e(Runnable runnable, Executor executor) {
            this.f6823a = runnable;
            this.f6824b = executor;
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f6826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f6827b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f6828c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f6829d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicReferenceFieldUpdater f6830e;

        public f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f6826a = atomicReferenceFieldUpdater;
            this.f6827b = atomicReferenceFieldUpdater2;
            this.f6828c = atomicReferenceFieldUpdater3;
            this.f6829d = atomicReferenceFieldUpdater4;
            this.f6830e = atomicReferenceFieldUpdater5;
        }

        @Override // androidx.concurrent.futures.a.b
        public boolean a(a aVar, e eVar, e eVar2) {
            return androidx.concurrent.futures.b.a(this.f6829d, aVar, eVar, eVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        public boolean b(a aVar, Object obj, Object obj2) {
            return androidx.concurrent.futures.b.a(this.f6830e, aVar, obj, obj2);
        }

        @Override // androidx.concurrent.futures.a.b
        public boolean c(a aVar, i iVar, i iVar2) {
            return androidx.concurrent.futures.b.a(this.f6828c, aVar, iVar, iVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        public void d(i iVar, i iVar2) {
            this.f6827b.lazySet(iVar, iVar2);
        }

        @Override // androidx.concurrent.futures.a.b
        public void e(i iVar, Thread thread) {
            this.f6826a.lazySet(iVar, thread);
        }
    }

    public static final class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f6831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final InterfaceFutureC1233e f6832b;

        public g(a aVar, InterfaceFutureC1233e interfaceFutureC1233e) {
            this.f6831a = aVar;
            this.f6832b = interfaceFutureC1233e;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f6831a.value != this) {
                return;
            }
            if (a.ATOMIC_HELPER.b(this.f6831a, this, a.getFutureValue(this.f6832b))) {
                a.complete(this.f6831a);
            }
        }
    }

    public static final class h extends b {
        public h() {
            super();
        }

        @Override // androidx.concurrent.futures.a.b
        public boolean a(a aVar, e eVar, e eVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.listeners != eVar) {
                        return false;
                    }
                    aVar.listeners = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        public boolean b(a aVar, Object obj, Object obj2) {
            synchronized (aVar) {
                try {
                    if (aVar.value != obj) {
                        return false;
                    }
                    aVar.value = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        public boolean c(a aVar, i iVar, i iVar2) {
            synchronized (aVar) {
                try {
                    if (aVar.waiters != iVar) {
                        return false;
                    }
                    aVar.waiters = iVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // androidx.concurrent.futures.a.b
        public void d(i iVar, i iVar2) {
            iVar.f6835b = iVar2;
        }

        @Override // androidx.concurrent.futures.a.b
        public void e(i iVar, Thread thread) {
            iVar.f6834a = thread;
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final i f6833c = new i(false);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public volatile Thread f6834a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public volatile i f6835b;

        public i(boolean z4) {
        }

        public void a(i iVar) {
            a.ATOMIC_HELPER.d(this, iVar);
        }

        public void b() {
            Thread thread = this.f6834a;
            if (thread != null) {
                this.f6834a = null;
                LockSupport.unpark(thread);
            }
        }

        public i() {
            a.ATOMIC_HELPER.e(this, Thread.currentThread());
        }
    }

    static {
        b hVar;
        try {
            hVar = new f(AtomicReferenceFieldUpdater.newUpdater(i.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(i.class, i.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a.class, i.class, "waiters"), AtomicReferenceFieldUpdater.newUpdater(a.class, e.class, "listeners"), AtomicReferenceFieldUpdater.newUpdater(a.class, Object.class, "value"));
            th = null;
        } catch (Throwable th) {
            th = th;
            hVar = new h();
        }
        ATOMIC_HELPER = hVar;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        NULL = new Object();
    }

    public static CancellationException c(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static <T> T checkNotNull(T t4) {
        t4.getClass();
        return t4;
    }

    public static void complete(a aVar) {
        e eVar = null;
        while (true) {
            aVar.k();
            aVar.afterDone();
            e eVarG = aVar.g(eVar);
            while (eVarG != null) {
                eVar = eVarG.f6825c;
                Runnable runnable = eVarG.f6823a;
                if (runnable instanceof g) {
                    g gVar = (g) runnable;
                    aVar = gVar.f6831a;
                    if (aVar.value == gVar) {
                        if (ATOMIC_HELPER.b(aVar, gVar, getFutureValue(gVar.f6832b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    h(runnable, eVarG.f6824b);
                }
                eVarG = eVar;
            }
            return;
        }
    }

    public static Object getFutureValue(InterfaceFutureC1233e interfaceFutureC1233e) {
        if (interfaceFutureC1233e instanceof a) {
            Object obj = ((a) interfaceFutureC1233e).value;
            if (!(obj instanceof c)) {
                return obj;
            }
            c cVar = (c) obj;
            return cVar.f6818a ? cVar.f6819b != null ? new c(false, cVar.f6819b) : c.f6817d : obj;
        }
        boolean zIsCancelled = interfaceFutureC1233e.isCancelled();
        if ((!GENERATE_CANCELLATION_CAUSES) && zIsCancelled) {
            return c.f6817d;
        }
        try {
            Object uninterruptibly = getUninterruptibly(interfaceFutureC1233e);
            return uninterruptibly == null ? NULL : uninterruptibly;
        } catch (CancellationException e4) {
            if (zIsCancelled) {
                return new c(false, e4);
            }
            return new d(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + interfaceFutureC1233e, e4));
        } catch (ExecutionException e5) {
            return new d(e5.getCause());
        } catch (Throwable th) {
            return new d(th);
        }
    }

    public static <V> V getUninterruptibly(Future<V> future) {
        V v4;
        boolean z4 = false;
        while (true) {
            try {
                v4 = future.get();
                break;
            } catch (InterruptedException unused) {
                z4 = true;
            } catch (Throwable th) {
                if (z4) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z4) {
            Thread.currentThread().interrupt();
        }
        return v4;
    }

    public static void h(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e4) {
            log.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e4);
        }
    }

    public final void a(StringBuilder sb) {
        try {
            Object uninterruptibly = getUninterruptibly(this);
            sb.append("SUCCESS, result=[");
            sb.append(m(uninterruptibly));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e4) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e4.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e5) {
            sb.append("FAILURE, cause=[");
            sb.append(e5.getCause());
            sb.append("]");
        }
    }

    @Override // e2.InterfaceFutureC1233e
    public final void addListener(Runnable runnable, Executor executor) {
        checkNotNull(runnable);
        checkNotNull(executor);
        e eVar = this.listeners;
        if (eVar != e.f6822d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f6825c = eVar;
                if (ATOMIC_HELPER.a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.listeners;
                }
            } while (eVar != e.f6822d);
        }
        h(runnable, executor);
    }

    public void afterDone() {
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z4) {
        Object obj = this.value;
        if (!(obj == null) && !(obj instanceof g)) {
            return false;
        }
        c cVar = GENERATE_CANCELLATION_CAUSES ? new c(z4, new CancellationException("Future.cancel() was called.")) : z4 ? c.f6816c : c.f6817d;
        a aVar = this;
        boolean z5 = false;
        while (true) {
            if (ATOMIC_HELPER.b(aVar, obj, cVar)) {
                if (z4) {
                    aVar.interruptTask();
                }
                complete(aVar);
                if (!(obj instanceof g)) {
                    break;
                }
                InterfaceFutureC1233e interfaceFutureC1233e = ((g) obj).f6832b;
                if (!(interfaceFutureC1233e instanceof a)) {
                    interfaceFutureC1233e.cancel(z4);
                    break;
                }
                aVar = (a) interfaceFutureC1233e;
                obj = aVar.value;
                if (!(obj == null) && !(obj instanceof g)) {
                    break;
                }
                z5 = true;
            } else {
                obj = aVar.value;
                if (!(obj instanceof g)) {
                    return z5;
                }
            }
        }
        return true;
    }

    public final e g(e eVar) {
        e eVar2;
        do {
            eVar2 = this.listeners;
        } while (!ATOMIC_HELPER.a(this, eVar2, e.f6822d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f6825c;
            eVar4.f6825c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j4, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j4);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.value;
        if ((obj != null) && (!(obj instanceof g))) {
            return i(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            i iVar = this.waiters;
            if (iVar != i.f6833c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (ATOMIC_HELPER.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                l(iVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.value;
                            if ((obj2 != null) && (!(obj2 instanceof g))) {
                                return i(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        l(iVar2);
                    } else {
                        iVar = this.waiters;
                    }
                } while (iVar != i.f6833c);
            }
            return i(this.value);
        }
        while (nanos > 0) {
            Object obj3 = this.value;
            if ((obj3 != null) && (!(obj3 instanceof g))) {
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
        String str = "Waited " + j4 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j5 = -nanos;
            long jConvert = timeUnit.convert(j5, TimeUnit.NANOSECONDS);
            long nanos2 = j5 - timeUnit.toNanos(jConvert);
            boolean z4 = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z4) {
                    str3 = str3 + com.amazon.a.a.o.b.f.f8804a;
                }
                str2 = str3 + " ";
            }
            if (z4) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    public final Object i(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw c("Task was cancelled.", ((c) obj).f6819b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f6821a);
        }
        if (obj == NULL) {
            return null;
        }
        return obj;
    }

    public void interruptTask() {
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.value instanceof c;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof g)) & (this.value != null);
    }

    public final void k() {
        i iVar;
        do {
            iVar = this.waiters;
        } while (!ATOMIC_HELPER.c(this, iVar, i.f6833c));
        while (iVar != null) {
            iVar.b();
            iVar = iVar.f6835b;
        }
    }

    public final void l(i iVar) {
        iVar.f6834a = null;
        while (true) {
            i iVar2 = this.waiters;
            if (iVar2 == i.f6833c) {
                return;
            }
            i iVar3 = null;
            while (iVar2 != null) {
                i iVar4 = iVar2.f6835b;
                if (iVar2.f6834a != null) {
                    iVar3 = iVar2;
                } else if (iVar3 != null) {
                    iVar3.f6835b = iVar4;
                    if (iVar3.f6834a == null) {
                        break;
                    }
                } else if (!ATOMIC_HELPER.c(this, iVar2, iVar4)) {
                    break;
                }
                iVar2 = iVar4;
            }
            return;
        }
    }

    public final String m(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final void maybePropagateCancellationTo(Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(wasInterrupted());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String pendingToString() {
        Object obj = this.value;
        if (obj instanceof g) {
            return "setFuture=[" + m(((g) obj).f6832b) + "]";
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public boolean set(Object obj) {
        if (obj == null) {
            obj = NULL;
        }
        if (!ATOMIC_HELPER.b(this, null, obj)) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setException(Throwable th) {
        if (!ATOMIC_HELPER.b(this, null, new d((Throwable) checkNotNull(th)))) {
            return false;
        }
        complete(this);
        return true;
    }

    public boolean setFuture(InterfaceFutureC1233e interfaceFutureC1233e) {
        d dVar;
        checkNotNull(interfaceFutureC1233e);
        Object obj = this.value;
        if (obj == null) {
            if (interfaceFutureC1233e.isDone()) {
                if (!ATOMIC_HELPER.b(this, null, getFutureValue(interfaceFutureC1233e))) {
                    return false;
                }
                complete(this);
                return true;
            }
            g gVar = new g(this, interfaceFutureC1233e);
            if (ATOMIC_HELPER.b(this, null, gVar)) {
                try {
                    interfaceFutureC1233e.addListener(gVar, androidx.concurrent.futures.d.INSTANCE);
                } catch (Throwable th) {
                    try {
                        dVar = new d(th);
                    } catch (Throwable unused) {
                        dVar = d.f6820b;
                    }
                    ATOMIC_HELPER.b(this, gVar, dVar);
                }
                return true;
            }
            obj = this.value;
        }
        if (obj instanceof c) {
            interfaceFutureC1233e.cancel(((c) obj).f6818a);
        }
        return false;
    }

    public String toString() {
        String strPendingToString;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (isCancelled()) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strPendingToString = pendingToString();
            } catch (RuntimeException e4) {
                strPendingToString = "Exception thrown from implementation: " + e4.getClass();
            }
            if (strPendingToString != null && !strPendingToString.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strPendingToString);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public final boolean wasInterrupted() {
        Object obj = this.value;
        return (obj instanceof c) && ((c) obj).f6818a;
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.value;
            if ((obj2 != null) & (!(obj2 instanceof g))) {
                return i(obj2);
            }
            i iVar = this.waiters;
            if (iVar != i.f6833c) {
                i iVar2 = new i();
                do {
                    iVar2.a(iVar);
                    if (ATOMIC_HELPER.c(this, iVar, iVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.value;
                            } else {
                                l(iVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof g))));
                        return i(obj);
                    }
                    iVar = this.waiters;
                } while (iVar != i.f6833c);
            }
            return i(this.value);
        }
        throw new InterruptedException();
    }
}
