package n2;

import android.os.Build;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c0 extends b0 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static boolean f16503g = true;

    @Override // n2.e0
    public void f(View view, int i10) {
        if (Build.VERSION.SDK_INT == 28) {
            super.f(view, i10);
        } else if (f16503g) {
            try {
                view.setTransitionVisibility(i10);
            } catch (NoSuchMethodError unused) {
                f16503g = false;
            }
        }
    }
}
