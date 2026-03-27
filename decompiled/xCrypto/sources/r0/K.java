package r0;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class K extends I {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f14326g = true;

    @Override // r0.M
    public void f(View view, int i4) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i4);
        } else if (f14326g) {
            try {
                view.setTransitionVisibility(i4);
            } catch (NoSuchMethodError unused) {
                f14326g = false;
            }
        }
    }
}
