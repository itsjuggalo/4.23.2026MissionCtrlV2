package t0;

import android.os.Build;
import android.os.ext.SdkExtensions;

/* JADX INFO: renamed from: t0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2731b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2731b f23287a = new C2731b();

    /* JADX INFO: renamed from: t0.b$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f23288a = new a();

        public final int a() {
            return SdkExtensions.getExtensionVersion(31);
        }
    }

    /* JADX INFO: renamed from: t0.b$b, reason: collision with other inner class name */
    public static final class C0402b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0402b f23289a = new C0402b();

        public final int a() {
            return SdkExtensions.getExtensionVersion(1000000);
        }
    }

    public final int a() {
        if (Build.VERSION.SDK_INT >= 33) {
            return C0402b.f23289a.a();
        }
        return 0;
    }

    public final int b() {
        int i8 = Build.VERSION.SDK_INT;
        if (i8 == 31 || i8 == 32) {
            return a.f23288a.a();
        }
        return 0;
    }
}
