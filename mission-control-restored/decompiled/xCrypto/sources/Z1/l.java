package Z1;

import java.util.Locale;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f5981a = Logger.getLogger(l.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final k f5982b = b();

    public static final class b implements k {
        public b() {
        }
    }

    public static String a(double d4) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d4));
    }

    public static k b() {
        return new b();
    }

    public static boolean c(String str) {
        return str == null || str.isEmpty();
    }
}
