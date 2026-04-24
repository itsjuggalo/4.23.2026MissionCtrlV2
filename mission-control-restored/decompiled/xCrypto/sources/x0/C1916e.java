package x0;

import android.util.Log;
import androidx.window.extensions.WindowExtensionsProvider;
import kotlin.jvm.internal.G;

/* JADX INFO: renamed from: x0.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1916e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C1916e f15704a = new C1916e();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f15705b = G.b(C1916e.class).b();

    public final int a() {
        try {
            return WindowExtensionsProvider.getWindowExtensions().getVendorApiLevel();
        } catch (NoClassDefFoundError unused) {
            if (C1914c.f15696a.a() != EnumC1921j.LOG) {
                return 0;
            }
            Log.d(f15705b, "Embedding extension version not found");
            return 0;
        } catch (UnsupportedOperationException unused2) {
            if (C1914c.f15696a.a() != EnumC1921j.LOG) {
                return 0;
            }
            Log.d(f15705b, "Stub Extension");
            return 0;
        }
    }
}
