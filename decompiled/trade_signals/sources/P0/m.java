package P0;

import android.content.Context;
import android.view.WindowManager;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class m implements l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f6273b = new m();

    @Override // P0.l
    public float a(Context context) {
        AbstractC2304t.f(context, "context");
        return ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getDensity();
    }
}
