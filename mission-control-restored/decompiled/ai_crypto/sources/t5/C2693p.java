package t5;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import r5.AbstractC2590f;
import r5.F;

/* JADX INFO: renamed from: t5.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2693p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f24095f = Logger.getLogger(AbstractC2590f.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f24096a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r5.K f24097b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Collection f24098c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f24099d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f24100e;

    /* JADX INFO: renamed from: t5.p$a */
    public class a extends ArrayDeque {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f24101a;

        public a(int i7) {
            this.f24101a = i7;
        }

        @Override // java.util.ArrayDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(r5.F f7) {
            if (size() == this.f24101a) {
                removeFirst();
            }
            C2693p.a(C2693p.this);
            return super.add(f7);
        }
    }

    /* JADX INFO: renamed from: t5.p$b */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24103a;

        static {
            int[] iArr = new int[F.b.values().length];
            f24103a = iArr;
            try {
                iArr[F.b.CT_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f24103a[F.b.CT_WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public C2693p(r5.K k7, int i7, long j7, String str) {
        H2.m.o(str, com.amazon.a.a.o.b.f9940c);
        this.f24097b = (r5.K) H2.m.o(k7, "logId");
        if (i7 > 0) {
            this.f24098c = new a(i7);
        } else {
            this.f24098c = null;
        }
        this.f24099d = j7;
        e(new F.a().b(str + " created").c(F.b.CT_INFO).e(j7).a());
    }

    public static /* synthetic */ int a(C2693p c2693p) {
        int i7 = c2693p.f24100e;
        c2693p.f24100e = i7 + 1;
        return i7;
    }

    public static void d(r5.K k7, Level level, String str) {
        Logger logger = f24095f;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + k7 + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    public r5.K b() {
        return this.f24097b;
    }

    public boolean c() {
        boolean z7;
        synchronized (this.f24096a) {
            z7 = this.f24098c != null;
        }
        return z7;
    }

    public void e(r5.F f7) {
        int i7 = b.f24103a[f7.f22522b.ordinal()];
        Level level = i7 != 1 ? i7 != 2 ? Level.FINEST : Level.FINER : Level.FINE;
        f(f7);
        d(this.f24097b, level, f7.f22521a);
    }

    public void f(r5.F f7) {
        synchronized (this.f24096a) {
            try {
                Collection collection = this.f24098c;
                if (collection != null) {
                    collection.add(f7);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
