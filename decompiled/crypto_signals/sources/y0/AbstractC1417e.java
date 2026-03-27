package y0;

import androidx.window.extensions.WindowExtensionsProvider;
import kotlin.jvm.internal.t;

/* JADX INFO: renamed from: y0.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1417e {
    static {
        t.a(AbstractC1417e.class).b();
    }

    public static int a() {
        try {
            return WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
        } catch (NoClassDefFoundError | UnsupportedOperationException unused) {
            return 0;
        }
    }
}
