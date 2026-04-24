package i0;

import android.os.Build;
import android.os.ext.SdkExtensions;

/* JADX INFO: renamed from: i0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1286b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1286b f12169a = new C1286b();

    /* JADX INFO: renamed from: i0.b$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f12170a = new a();

        public final int a() {
            return SdkExtensions.getExtensionVersion(31);
        }
    }

    /* JADX INFO: renamed from: i0.b$b, reason: collision with other inner class name */
    public static final class C0200b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0200b f12171a = new C0200b();

        public final int a() {
            return SdkExtensions.getExtensionVersion(1000000);
        }
    }

    public final int a() {
        if (Build.VERSION.SDK_INT >= 33) {
            return C0200b.f12171a.a();
        }
        return 0;
    }

    public final int b() {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 == 31 || i4 == 32) {
            return a.f12170a.a();
        }
        return 0;
    }
}
