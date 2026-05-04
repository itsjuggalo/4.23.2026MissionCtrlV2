package tb;

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

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i1 extends m0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReferenceQueue f21421c = new ReferenceQueue();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentMap f21422d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f21423e = Logger.getLogger(i1.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f21424b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends WeakReference {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final boolean f21425f = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", com.amazon.a.a.o.b.f4545af));

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final RuntimeException f21426g = e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReferenceQueue f21427a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentMap f21428b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f21429c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Reference f21430d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicBoolean f21431e;

        public a(i1 i1Var, rb.u0 u0Var, ReferenceQueue referenceQueue, ConcurrentMap concurrentMap) {
            super(i1Var, referenceQueue);
            this.f21431e = new AtomicBoolean();
            this.f21430d = new SoftReference(f21425f ? new RuntimeException("ManagedChannel allocation site") : f21426g);
            this.f21429c = u0Var.toString();
            this.f21427a = referenceQueue;
            this.f21428b = concurrentMap;
            concurrentMap.put(this, this);
            b(referenceQueue);
        }

        public static int b(ReferenceQueue referenceQueue) {
            int i10 = 0;
            while (true) {
                a aVar = (a) referenceQueue.poll();
                if (aVar == null) {
                    return i10;
                }
                RuntimeException runtimeException = (RuntimeException) aVar.f21430d.get();
                aVar.c();
                if (!aVar.f21431e.get()) {
                    i10++;
                    Level level = Level.SEVERE;
                    if (i1.f21423e.isLoggable(level)) {
                        LogRecord logRecord = new LogRecord(level, "*~*~*~ Previous channel {0} was garbage collected without being shut down! ~*~*~*" + System.getProperty("line.separator") + "    Make sure to call shutdown()/shutdownNow()");
                        logRecord.setLoggerName(i1.f21423e.getName());
                        logRecord.setParameters(new Object[]{aVar.f21429c});
                        logRecord.setThrown(runtimeException);
                        i1.f21423e.log(logRecord);
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
            this.f21428b.remove(this);
            this.f21430d.clear();
        }

        @Override // java.lang.ref.Reference
        public void clear() {
            c();
            b(this.f21427a);
        }

        public final void d() {
            if (this.f21431e.getAndSet(true)) {
                return;
            }
            clear();
        }
    }

    public i1(rb.u0 u0Var) {
        this(u0Var, f21421c, f21422d);
    }

    @Override // tb.m0, rb.u0
    public rb.u0 m() {
        this.f21424b.d();
        return super.m();
    }

    @Override // tb.m0, rb.u0
    public rb.u0 n() {
        this.f21424b.d();
        return super.n();
    }

    public i1(rb.u0 u0Var, ReferenceQueue referenceQueue, ConcurrentMap concurrentMap) {
        super(u0Var);
        this.f21424b = new a(this, u0Var, referenceQueue, concurrentMap);
    }
}
