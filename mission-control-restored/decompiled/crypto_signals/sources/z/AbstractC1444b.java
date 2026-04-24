package z;

import android.os.Build;
import java.util.Locale;

/* JADX INFO: renamed from: z.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1444b {
    static {
        int i = Build.VERSION.SDK_INT;
        C1443a c1443a = C1443a.f11722a;
        if (i >= 30) {
            c1443a.a(30);
        }
        if (i >= 30) {
            c1443a.a(31);
        }
        if (i >= 30) {
            c1443a.a(33);
        }
        if (i >= 30) {
            c1443a.a(1000000);
        }
    }

    public static final boolean a() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 33) {
            return true;
        }
        if (i < 32) {
            return false;
        }
        String CODENAME = Build.VERSION.CODENAME;
        kotlin.jvm.internal.j.d(CODENAME, "CODENAME");
        if ("REL".equals(CODENAME)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = CODENAME.toUpperCase(locale);
        kotlin.jvm.internal.j.d(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = "Tiramisu".toUpperCase(locale);
        kotlin.jvm.internal.j.d(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase.compareTo(upperCase2) >= 0;
    }
}
