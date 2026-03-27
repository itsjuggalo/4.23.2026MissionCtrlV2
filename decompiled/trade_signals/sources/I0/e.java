package I0;

import android.util.Log;
import androidx.window.extensions.WindowExtensionsProvider;
import kotlin.jvm.internal.O;

/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f4033a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f4034b = O.b(e.class).r();

    public final int a() {
        String str;
        String str2;
        try {
            return WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
        } catch (NoClassDefFoundError unused) {
            if (c.f4025a.a() != j.f4048b) {
                return 0;
            }
            str = f4034b;
            str2 = "Embedding extension version not found";
            Log.d(str, str2);
            return 0;
        } catch (UnsupportedOperationException unused2) {
            if (c.f4025a.a() != j.f4048b) {
                return 0;
            }
            str = f4034b;
            str2 = "Stub Extension";
            Log.d(str, str2);
            return 0;
        }
    }
}
