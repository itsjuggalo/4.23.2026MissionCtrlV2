package t5;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: renamed from: t5.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2682j0 extends M {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReferenceQueue f23982c = new ReferenceQueue();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentMap f23983d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f23984e = Logger.getLogger(C2682j0.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f23985b;

    /* JADX INFO: renamed from: t5.j0$a */
    public static final class a extends WeakReference {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final boolean f23986f = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", com.amazon.a.a.o.b.af));

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final RuntimeException f23987g = e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReferenceQueue f23988a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentMap f23989b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f23990c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Reference f23991d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicBoolean f23992e;

        public a(C2682j0 c2682j0, r5.V v7, ReferenceQueue referenceQueue, ConcurrentMap concurrentMap) {
            super(c2682j0, referenceQueue);
            this.f23992e = new AtomicBoolean();
            this.f23991d = new SoftReference(f23986f ? new RuntimeException("ManagedChannel allocation site") : f23987g);
            this.f23990c = v7.toString();
            this.f23988a = referenceQueue;
            this.f23989b = concurrentMap;
            concurrentMap.put(this, this);
            b(referenceQueue);
        }

        public static int b(ReferenceQueue referenceQueue) {
            int i7 = 0;
            while (true) {
                a aVar = (a) referenceQueue.poll();
                if (aVar == null) {
                    return i7;
                }
                RuntimeException runtimeException = (RuntimeException) aVar.f23991d.get();
                aVar.c();
                if (!aVar.f23992e.get()) {
                    i7++;
                    Level level = Level.SEVERE;
                    if (C2682j0.f23984e.isLoggable(level)) {
                        LogRecord logRecord = new LogRecord(level, "*~*~*~ Previous channel {0} was garbage collected without being shut down! ~*~*~*" + System.getProperty("line.separator") + "    Make sure to call shutdown()/shutdownNow()");
                        logRecord.setLoggerName(C2682j0.f23984e.getName());
                        logRecord.setParameters(new Object[]{aVar.f23990c});
                        logRecord.setThrown(runtimeException);
                        C2682j0.f23984e.log(logRecord);
                    }
                }
            }
        }

        public static RuntimeException e() {
            RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
            runtimeException.setStackTrace(new StackTraceElement[0]);
            return runtimeException;
        }

        public final void c() {
            super.clear();
            this.f23989b.remove(this);
            this.f23991d.clear();
        }

        @Override // java.lang.ref.Reference
        public void clear() {
            c();
            b(this.f23988a);
        }

        public final void d() {
            if (this.f23992e.getAndSet(true)) {
                return;
            }
            clear();
        }
    }

    public C2682j0(r5.V v7) {
        this(v7, f23982c, f23983d);
    }

    @Override // t5.M, r5.V
    public r5.V n() {
        this.f23985b.d();
        return super.n();
    }

    @Override // t5.M, r5.V
    public r5.V o() {
        this.f23985b.d();
        return super.o();
    }

    public C2682j0(r5.V v7, ReferenceQueue referenceQueue, ConcurrentMap concurrentMap) {
        super(v7);
        this.f23985b = new a(this, v7, referenceQueue, concurrentMap);
    }
}
