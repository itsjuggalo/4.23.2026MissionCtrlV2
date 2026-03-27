package M2;

import K2.AbstractC0358f;
import K2.F;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/* JADX INFO: renamed from: M2.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C0438p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f2544f = Logger.getLogger(AbstractC0358f.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f2545a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final K2.K f2546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Collection f2547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f2548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f2549e;

    /* JADX INFO: renamed from: M2.p$a */
    public class a extends ArrayDeque {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f2550a;

        public a(int i4) {
            this.f2550a = i4;
        }

        @Override // java.util.ArrayDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public boolean add(K2.F f4) {
            if (size() == this.f2550a) {
                removeFirst();
            }
            C0438p.a(C0438p.this);
            return super.add(f4);
        }
    }

    /* JADX INFO: renamed from: M2.p$b */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f2552a;

        static {
            int[] iArr = new int[F.b.values().length];
            f2552a = iArr;
            try {
                iArr[F.b.CT_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2552a[F.b.CT_WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public C0438p(K2.K k4, int i4, long j4, String str) {
        Z1.m.o(str, com.amazon.a.a.o.b.f8755c);
        this.f2546b = (K2.K) Z1.m.o(k4, "logId");
        if (i4 > 0) {
            this.f2547c = new a(i4);
        } else {
            this.f2547c = null;
        }
        this.f2548d = j4;
        e(new F.a().b(str + " created").c(F.b.CT_INFO).e(j4).a());
    }

    public static /* synthetic */ int a(C0438p c0438p) {
        int i4 = c0438p.f2549e;
        c0438p.f2549e = i4 + 1;
        return i4;
    }

    public static void d(K2.K k4, Level level, String str) {
        Logger logger = f2544f;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + k4 + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    public K2.K b() {
        return this.f2546b;
    }

    public boolean c() {
        boolean z4;
        synchronized (this.f2545a) {
            z4 = this.f2547c != null;
        }
        return z4;
    }

    public void e(K2.F f4) {
        int i4 = b.f2552a[f4.f1032b.ordinal()];
        Level level = i4 != 1 ? i4 != 2 ? Level.FINEST : Level.FINER : Level.FINE;
        f(f4);
        d(this.f2546b, level, f4.f1031a);
    }

    public void f(K2.F f4) {
        synchronized (this.f2545a) {
            try {
                Collection collection = this.f2547c;
                if (collection != null) {
                    collection.add(f4);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
