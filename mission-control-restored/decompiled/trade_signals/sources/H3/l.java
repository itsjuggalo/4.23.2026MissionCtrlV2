package H3;

import android.util.Log;

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

    public static void c(String str, float f8) {
        a(str + ": " + f8);
    }

    public static void d(String str, float f8, float f9) {
        a(str + ": (" + f8 + ", " + f9 + ")");
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
