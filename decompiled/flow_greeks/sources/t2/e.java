package t2;

import android.util.Log;
import androidx.window.extensions.WindowExtensionsProvider;
import kotlin.jvm.internal.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f20647a = new e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f20648b = n0.b(e.class).c();

    public final int a() {
        try {
            return WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
        } catch (NoClassDefFoundError unused) {
            if (c.f20639a.a() != j.f20662b) {
                return 0;
            }
            Log.d(f20648b, "Embedding extension version not found");
            return 0;
        } catch (NullPointerException unused2) {
            if (c.f20639a.a() != j.f20662b) {
                return 0;
            }
            Log.d(f20648b, "Error with Extension implementation");
            return 0;
        } catch (UnsupportedOperationException unused3) {
            if (c.f20639a.a() != j.f20662b) {
                return 0;
            }
            Log.d(f20648b, "Stub Extension");
            return 0;
        }
    }
}
