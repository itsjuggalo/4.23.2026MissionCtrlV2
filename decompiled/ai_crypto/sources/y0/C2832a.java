package y0;

import android.os.Build;
import android.os.ext.SdkExtensions;

/* JADX INFO: renamed from: y0.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2832a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2832a f25453a = new C2832a();

    /* JADX INFO: renamed from: y0.a$a, reason: collision with other inner class name */
    public static final class C0394a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0394a f25454a = new C0394a();

        public final int a() {
            return SdkExtensions.getExtensionVersion(31);
        }
    }

    /* JADX INFO: renamed from: y0.a$b */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f25455a = new b();

        public final int a() {
            return SdkExtensions.getExtensionVersion(1000000);
        }
    }

    public final int a() {
        if (Build.VERSION.SDK_INT >= 33) {
            return b.f25455a.a();
        }
        return 0;
    }

    public final int b() {
        int i7 = Build.VERSION.SDK_INT;
        if (i7 == 31 || i7 == 32) {
            return C0394a.f25454a.a();
        }
        return 0;
    }
}
