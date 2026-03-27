package C0;

import android.os.Build;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class K extends I {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f432g = true;

    @Override // C0.M
    public void f(View view, int i8) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i8);
        } else if (f432g) {
            try {
                view.setTransitionVisibility(i8);
            } catch (NoSuchMethodError unused) {
                f432g = false;
            }
        }
    }
}
