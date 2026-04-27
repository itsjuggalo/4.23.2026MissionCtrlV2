package u0;

import android.os.Build;
import android.util.Log;
import android.webkit.WebSettings;
import v0.i;
import v0.j;
import v0.k;
import v0.l;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static i a(WebSettings webSettings) {
        try {
            return l.c().a(webSettings);
        } catch (ClassCastException e4) {
            if (Build.VERSION.SDK_INT != 30 || !"android.webkit.WebSettingsWrapper".equals(webSettings.getClass().getCanonicalName())) {
                throw e4;
            }
            Log.e("WebSettingsCompat", "Error converting WebSettings to Chrome implementation. All AndroidX method calls on this WebSettings instance will be no-op calls. See https://crbug.com/388824130 for more info.", e4);
            return new j();
        }
    }

    public static void b(WebSettings webSettings, boolean z4) {
        if (!k.f15274t0.c()) {
            throw k.a();
        }
        a(webSettings).a(z4);
    }
}
