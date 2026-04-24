package I0;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class D extends M {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f2706c = true;

    @Override // I0.M
    public float b(View view) {
        if (f2706c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f2706c = false;
            }
        }
        return view.getAlpha();
    }

    @Override // I0.M
    public void e(View view, float f7) {
        if (f2706c) {
            try {
                view.setTransitionAlpha(f7);
                return;
            } catch (NoSuchMethodError unused) {
                f2706c = false;
            }
        }
        view.setAlpha(f7);
    }

    @Override // I0.M
    public void a(View view) {
    }

    @Override // I0.M
    public void c(View view) {
    }
}
