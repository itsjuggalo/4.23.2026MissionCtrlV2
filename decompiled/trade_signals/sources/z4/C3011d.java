package z4;

import B5.k;
import B5.p;
import android.content.Intent;
import io.flutter.plugin.common.PluginRegistry;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: z4.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C3011d implements PluginRegistry.ActivityResultListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f24790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f24791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f24792c;

    public C3011d(k onSuccess, p onError) {
        AbstractC2304t.f(onSuccess, "onSuccess");
        AbstractC2304t.f(onError, "onError");
        this.f24790a = onSuccess;
        this.f24791b = onError;
    }

    @Override // io.flutter.plugin.common.PluginRegistry.ActivityResultListener
    public boolean onActivityResult(int i8, int i9, Intent intent) {
        try {
        } catch (Exception e8) {
            this.f24791b.invoke("flutter_background.PermissionHandler", "Error while waiting for user to disable battery optimizations", e8.getLocalizedMessage());
        }
        if (!this.f24792c && i8 == 5672353) {
            this.f24792c = true;
            this.f24790a.invoke(Boolean.valueOf(i9 == -1));
            return true;
        }
        return false;
    }
}
