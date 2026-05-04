package p6;

import java.util.Locale;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f18326a = Logger.getLogger(m.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final l f18327b = c();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements l {
        public b() {
        }
    }

    public static String a(String str) {
        if (d(str)) {
            return null;
        }
        return str;
    }

    public static String b(double d10) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d10));
    }

    public static l c() {
        return new b();
    }

    public static boolean d(String str) {
        return str == null || str.isEmpty();
    }
}
