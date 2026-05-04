package tb;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import rb.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Logger f21565f = Logger.getLogger(rb.f.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f21566a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final rb.k0 f21567b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Collection f21568c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f21569d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f21570e;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a extends ArrayDeque {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ int f21571a;

        public a(int i10) {
            this.f21571a = i10;
        }

        @Override // java.util.ArrayDeque, java.util.AbstractCollection, java.util.Collection, java.util.Deque, java.util.Queue
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(rb.f0 f0Var) {
            if (size() == this.f21571a) {
                removeFirst();
            }
            p.a(p.this);
            return super.add(f0Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f21573a;

        static {
            int[] iArr = new int[f0.b.values().length];
            f21573a = iArr;
            try {
                iArr[f0.b.CT_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21573a[f0.b.CT_WARNING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public p(rb.k0 k0Var, int i10, long j10, String str) {
        p6.n.o(str, com.amazon.a.a.o.b.f4549c);
        this.f21567b = (rb.k0) p6.n.o(k0Var, "logId");
        if (i10 > 0) {
            this.f21568c = new a(i10);
        } else {
            this.f21568c = null;
        }
        this.f21569d = j10;
        e(new f0.a().b(str + " created").c(f0.b.CT_INFO).e(j10).a());
    }

    public static /* synthetic */ int a(p pVar) {
        int i10 = pVar.f21570e;
        pVar.f21570e = i10 + 1;
        return i10;
    }

    public static void d(rb.k0 k0Var, Level level, String str) {
        Logger logger = f21565f;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + k0Var + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    public rb.k0 b() {
        return this.f21567b;
    }

    public boolean c() {
        boolean z10;
        synchronized (this.f21566a) {
            z10 = this.f21568c != null;
        }
        return z10;
    }

    public void e(rb.f0 f0Var) {
        int i10 = b.f21573a[f0Var.f19552b.ordinal()];
        Level level = i10 != 1 ? i10 != 2 ? Level.FINEST : Level.FINER : Level.FINE;
        f(f0Var);
        d(this.f21567b, level, f0Var.f19551a);
    }

    public void f(rb.f0 f0Var) {
        synchronized (this.f21566a) {
            try {
                Collection collection = this.f21568c;
                if (collection != null) {
                    collection.add(f0Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
