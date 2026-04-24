package Q;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* JADX INFO: loaded from: classes.dex */
public abstract class V {

    public static class a {
        public static void a(Window window, boolean z7) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z7 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    public static class b {
        public static void a(Window window, boolean z7) {
            window.setDecorFitsSystemWindows(z7);
        }
    }

    public static v0 a(Window window, View view) {
        return new v0(window, view);
    }

    public static void b(Window window, boolean z7) {
        if (Build.VERSION.SDK_INT >= 30) {
            b.a(window, z7);
        } else {
            a.a(window, z7);
        }
    }
}
