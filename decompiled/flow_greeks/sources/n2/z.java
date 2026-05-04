package n2;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z extends e0 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f16608c = true;

    @Override // n2.e0
    public float b(View view) {
        if (f16608c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f16608c = false;
            }
        }
        return view.getAlpha();
    }

    @Override // n2.e0
    public void e(View view, float f10) {
        if (f16608c) {
            try {
                view.setTransitionAlpha(f10);
                return;
            } catch (NoSuchMethodError unused) {
                f16608c = false;
            }
        }
        view.setAlpha(f10);
    }

    @Override // n2.e0
    public void a(View view) {
    }

    @Override // n2.e0
    public void c(View view) {
    }
}
