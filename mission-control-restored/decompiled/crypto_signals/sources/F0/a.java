package F0;

import D.V;
import android.content.Context;
import android.view.WindowInsets;
import android.view.WindowManager;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f487a = new a();

    public final V a(Context context) {
        j.e(context, "context");
        WindowInsets windowInsets = ((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getWindowInsets();
        j.d(windowInsets, "context.getSystemService…indowMetrics.windowInsets");
        return V.c(windowInsets, null);
    }
}
