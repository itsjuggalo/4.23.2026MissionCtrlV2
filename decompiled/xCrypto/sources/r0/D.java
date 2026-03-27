package r0;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class D extends M {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f14322c = true;

    @Override // r0.M
    public float b(View view) {
        if (f14322c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f14322c = false;
            }
        }
        return view.getAlpha();
    }

    @Override // r0.M
    public void e(View view, float f4) {
        if (f14322c) {
            try {
                view.setTransitionAlpha(f4);
                return;
            } catch (NoSuchMethodError unused) {
                f14322c = false;
            }
        }
        view.setAlpha(f4);
    }

    @Override // r0.M
    public void a(View view) {
    }

    @Override // r0.M
    public void c(View view) {
    }
}
