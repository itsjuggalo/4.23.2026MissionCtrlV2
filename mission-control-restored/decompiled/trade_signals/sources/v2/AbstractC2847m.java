package v2;

import java.util.Locale;
import java.util.logging.Logger;

/* JADX INFO: renamed from: v2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2847m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f23766a = Logger.getLogger(AbstractC2847m.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final InterfaceC2846l f23767b = c();

    /* JADX INFO: renamed from: v2.m$b */
    public static final class b implements InterfaceC2846l {
        public b() {
        }
    }

    public static String a(String str) {
        if (d(str)) {
            return null;
        }
        return str;
    }

    public static String b(double d8) {
        return String.format(Locale.ROOT, "%.4g", Double.valueOf(d8));
    }

    public static InterfaceC2846l c() {
        return new b();
    }

    public static boolean d(String str) {
        return str == null || str.isEmpty();
    }
}
