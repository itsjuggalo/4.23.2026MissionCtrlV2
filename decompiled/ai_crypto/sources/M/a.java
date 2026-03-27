package M;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f3703a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f3704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f3705c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f3706d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f3707e;

    /* JADX INFO: renamed from: M.a$a, reason: collision with other inner class name */
    public static final class C0047a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0047a f3708a = new C0047a();

        public final int a(int i7) {
            return SdkExtensions.getExtensionVersion(i7);
        }
    }

    static {
        int i7 = Build.VERSION.SDK_INT;
        f3704b = i7 >= 30 ? C0047a.f3708a.a(30) : 0;
        f3705c = i7 >= 30 ? C0047a.f3708a.a(31) : 0;
        f3706d = i7 >= 30 ? C0047a.f3708a.a(33) : 0;
        f3707e = i7 >= 30 ? C0047a.f3708a.a(1000000) : 0;
    }

    public static final boolean a(String codename, String buildCodename) {
        r.f(codename, "codename");
        r.f(buildCodename, "buildCodename");
        if (r.b("REL", buildCodename)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = buildCodename.toUpperCase(locale);
        r.e(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = codename.toUpperCase(locale);
        r.e(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase.compareTo(upperCase2) >= 0;
    }

    public static final boolean b() {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 < 33) {
            if (i7 >= 32) {
                String CODENAME = Build.VERSION.CODENAME;
                r.e(CODENAME, "CODENAME");
                if (a("Tiramisu", CODENAME)) {
                }
            }
            return false;
        }
        return true;
    }
}
