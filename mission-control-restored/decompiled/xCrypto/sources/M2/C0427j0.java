package M2;

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

/* JADX INFO: renamed from: M2.j0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0427j0 extends M {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ReferenceQueue f2431c = new ReferenceQueue();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final ConcurrentMap f2432d = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Logger f2433e = Logger.getLogger(C0427j0.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f2434b;

    /* JADX INFO: renamed from: M2.j0$a */
    public static final class a extends WeakReference {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final boolean f2435f = Boolean.parseBoolean(System.getProperty("io.grpc.ManagedChannel.enableAllocationTracking", com.amazon.a.a.o.b.af));

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final RuntimeException f2436g = e();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReferenceQueue f2437a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ConcurrentMap f2438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f2439c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Reference f2440d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final AtomicBoolean f2441e;

        public a(C0427j0 c0427j0, K2.V v4, ReferenceQueue referenceQueue, ConcurrentMap concurrentMap) {
            super(c0427j0, referenceQueue);
            this.f2441e = new AtomicBoolean();
            this.f2440d = new SoftReference(f2435f ? new RuntimeException("ManagedChannel allocation site") : f2436g);
            this.f2439c = v4.toString();
            this.f2437a = referenceQueue;
            this.f2438b = concurrentMap;
            concurrentMap.put(this, this);
            b(referenceQueue);
        }

        public static int b(ReferenceQueue referenceQueue) {
            int i4 = 0;
            while (true) {
                a aVar = (a) referenceQueue.poll();
                if (aVar == null) {
                    return i4;
                }
                RuntimeException runtimeException = (RuntimeException) aVar.f2440d.get();
                aVar.c();
                if (!aVar.f2441e.get()) {
                    i4++;
                    Level level = Level.SEVERE;
                    if (C0427j0.f2433e.isLoggable(level)) {
                        LogRecord logRecord = new LogRecord(level, "*~*~*~ Previous channel {0} was garbage collected without being shut down! ~*~*~*" + System.getProperty("line.separator") + "    Make sure to call shutdown()/shutdownNow()");
                        logRecord.setLoggerName(C0427j0.f2433e.getName());
                        logRecord.setParameters(new Object[]{aVar.f2439c});
                        logRecord.setThrown(runtimeException);
                        C0427j0.f2433e.log(logRecord);
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
            this.f2438b.remove(this);
            this.f2440d.clear();
        }

        @Override // java.lang.ref.Reference
        public void clear() {
            c();
            b(this.f2437a);
        }

        public final void d() {
            if (this.f2441e.getAndSet(true)) {
                return;
            }
            clear();
        }
    }

    public C0427j0(K2.V v4) {
        this(v4, f2431c, f2432d);
    }

    @Override // M2.M, K2.V
    public K2.V n() {
        this.f2434b.d();
        return super.n();
    }

    @Override // M2.M, K2.V
    public K2.V o() {
        this.f2434b.d();
        return super.o();
    }

    public C0427j0(K2.V v4, ReferenceQueue referenceQueue, ConcurrentMap concurrentMap) {
        super(v4);
        this.f2434b = new a(this, v4, referenceQueue, concurrentMap);
    }
}
