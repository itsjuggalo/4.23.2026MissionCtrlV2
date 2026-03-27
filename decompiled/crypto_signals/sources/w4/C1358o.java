package w4;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import u4.AbstractC1222d;
import u4.C1243z;
import u4.EnumC1242y;

/* JADX INFO: renamed from: w4.o, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1358o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Logger f11331c = Logger.getLogger(AbstractC1222d.class.getName());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f11332a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final u4.D f11333b;

    public C1358o(u4.D d4, long j4, String str) {
        s3.D.j(str, "description");
        this.f11333b = d4;
        String strConcat = str.concat(" created");
        EnumC1242y enumC1242y = EnumC1242y.f10491a;
        s3.D.j(strConcat, "description");
        b(new C1243z(strConcat, enumC1242y, j4, null));
    }

    public static void a(u4.D d4, Level level, String str) {
        Logger logger = f11331c;
        if (logger.isLoggable(level)) {
            LogRecord logRecord = new LogRecord(level, "[" + d4 + "] " + str);
            logRecord.setLoggerName(logger.getName());
            logRecord.setSourceClassName(logger.getName());
            logRecord.setSourceMethodName("log");
            logger.log(logRecord);
        }
    }

    public final void b(C1243z c1243z) {
        int iOrdinal = c1243z.f10496b.ordinal();
        Level level = iOrdinal != 2 ? iOrdinal != 3 ? Level.FINEST : Level.FINE : Level.FINER;
        synchronized (this.f11332a) {
        }
        a(this.f11333b, level, c1243z.f10495a);
    }
}
