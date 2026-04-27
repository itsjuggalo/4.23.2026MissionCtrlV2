package I0;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class K extends I {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f2710g = true;

    @Override // I0.M
    public void f(View view, int i7) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i7);
        } else if (f2710g) {
            try {
                view.setTransitionVisibility(i7);
            } catch (NoSuchMethodError unused) {
                f2710g = false;
            }
        }
    }
}
