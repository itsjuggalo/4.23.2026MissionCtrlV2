package u9;

import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l {
    public static void a(String str) {
        if (Log.isLoggable("FIAM.Display", 3)) {
            Log.d("FIAM.Display", str);
        }
    }

    public static void b(String str) {
        a("============ " + str + " ============");
    }

    public static void c(String str, float f10) {
        a(str + ": " + f10);
    }

    public static void d(String str, float f10, float f11) {
        a(str + ": (" + f10 + ", " + f11 + ")");
    }

    public static void e(String str) {
        Log.e("FIAM.Display", str);
    }

    public static void f(String str) {
        if (Log.isLoggable("FIAM.Display", 4)) {
            Log.i("FIAM.Display", str);
        }
    }
}
