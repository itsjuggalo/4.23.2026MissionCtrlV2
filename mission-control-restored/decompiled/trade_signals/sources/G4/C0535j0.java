package G4;

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

/* JADX INFO: renamed from: G4.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0535j0 extends M {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReferenceQueue f3009c = new ReferenceQueue();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentMap f3010d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f3011e = Logger.getLogger(C0535j0.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f3012b;

    /* JADX INFO: renamed from: G4.j0$a */
    public static final class a extends WeakReference {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final boolean f3013f = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", com.amazon.a.a.o.b.af));

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final RuntimeException f3014g = c();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReferenceQueue f3015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentMap f3016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f3017c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Reference f3018d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicBoolean f3019e;

        public a(C0535j0 c0535j0, F4.T t8, ReferenceQueue referenceQueue, ConcurrentMap concurrentMap) {
            super(c0535j0, referenceQueue);
            this.f3019e = new AtomicBoolean();
            this.f3018d = new SoftReference(f3013f ? new RuntimeException("ManagedChannel allocation site") : f3014g);
            this.f3017c = t8.toString();
            this.f3015a = referenceQueue;
            this.f3016b = concurrentMap;
            concurrentMap.put(this, this);
            a(referenceQueue);
        }

        public static int a(ReferenceQueue referenceQueue) {
            int i8 = 0;
            while (true) {
                a aVar = (a) referenceQueue.poll();
                if (aVar == null) {
                    return i8;
                }
                RuntimeException runtimeException = (RuntimeException) aVar.f3018d.get();
                aVar.b();
                if (!aVar.f3019e.get()) {
                    i8++;
                    Level level = Level.SEVERE;
                    if (C0535j0.f3011e.isLoggable(level)) {
                        LogRecord logRecord = new LogRecord(level, "*~*~*~ Previous channel {0} was garbage collected without being shut down! ~*~*~*" + System.getProperty("line.separator") + "    Make sure to call shutdown()/shutdownNow()");
                        logRecord.setLoggerName(C0535j0.f3011e.getName());
                        logRecord.setParameters(new Object[]{aVar.f3017c});
                        logRecord.setThrown(runtimeException);
                        C0535j0.f3011e.log(logRecord);
                    }
                }
            }
        }

        public static RuntimeException c() {
            RuntimeException runtimeException = new RuntimeException("ManagedChannel allocation site not recorded.  Set -Dio.grpc.ManagedChannel.enableAllocationTracking=true to enable it");
            runtimeException.setStackTrace(new StackTraceElement[0]);
            return runtimeException;
        }

        public final void b() {
            super.clear();
            this.f3016b.remove(this);
            this.f3018d.clear();
        }

        @Override // java.lang.ref.Reference
        public void clear() {
            b();
            a(this.f3015a);
        }
    }

    public C0535j0(F4.T t8) {
        this(t8, f3009c, f3010d);
    }

    public C0535j0(F4.T t8, ReferenceQueue referenceQueue, ConcurrentMap concurrentMap) {
        super(t8);
        this.f3012b = new a(this, t8, referenceQueue, concurrentMap);
    }
}
