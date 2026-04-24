package G4;

import F4.AbstractC0492f;
import F4.E;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import v2.AbstractC2848n;

/* JADX INFO: renamed from: G4.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C0546p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f3122f = Logger.getLogger(AbstractC0492f.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f3123a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final F4.J f3124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Collection f3125c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f3126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f3127e;

    /* JADX INFO: renamed from: G4.p$a */
    public class a extends ArrayDeque {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f3128a;

        public a(int i8) {
            this.f3128a = i8;
        }

        @Override // java.util.ArrayDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public boolean add(F4.E e8) {
            if (size() == this.f3128a) {
                removeFirst();
            }
            C0546p.a(C0546p.this);
            return super.add(e8);
        }
    }

    /* JADX INFO: renamed from: G4.p$b */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f3130a;

        static {
            int[] iArr = new int[E.b.values().length];
            f3130a = iArr;
            try {
                iArr[E.b.CT_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3130a[E.b.CT_WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public C0546p(F4.J j8, int i8, long j9, String str) {
        AbstractC2848n.o(str, com.amazon.a.a.o.b.f14051c);
        this.f3124b = (F4.J) AbstractC2848n.o(j8, "logId");
        this.f3125c = i8 > 0 ? new a(i8) : null;
        this.f3126d = j9;
        e(new E.a().b(str + " created").c(E.b.CT_INFO).e(j9).a());
    }

    public static /* synthetic */ int a(C0546p c0546p) {
        int i8 = c0546p.f3127e;
        c0546p.f3127e = i8 + 1;
        return i8;
    }

    public static void d(F4.J j8, Level level, String str) {
        Logger logger = f3122f;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + j8 + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    public F4.J b() {
        return this.f3124b;
    }

    public boolean c() {
        boolean z7;
        synchronized (this.f3123a) {
            z7 = this.f3125c != null;
        }
        return z7;
    }

    public void e(F4.E e8) {
        int i8 = b.f3130a[e8.f1619b.ordinal()];
        Level level = i8 != 1 ? i8 != 2 ? Level.FINEST : Level.FINER : Level.FINE;
        f(e8);
        d(this.f3124b, level, e8.f1618a);
    }

    public void f(F4.E e8) {
        synchronized (this.f3123a) {
            try {
                Collection collection = this.f3125c;
                if (collection != null) {
                    collection.add(e8);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
