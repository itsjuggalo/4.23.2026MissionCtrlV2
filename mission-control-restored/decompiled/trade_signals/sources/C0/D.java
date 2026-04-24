package C0;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class D extends M {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f428c = true;

    @Override // C0.M
    public float b(View view) {
        if (f428c) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f428c = false;
            }
        }
        return view.getAlpha();
    }

    @Override // C0.M
    public void e(View view, float f8) {
        if (f428c) {
            try {
                view.setTransitionAlpha(f8);
                return;
            } catch (NoSuchMethodError unused) {
                f428c = false;
            }
        }
        view.setAlpha(f8);
    }

    @Override // C0.M
    public void a(View view) {
    }

    @Override // C0.M
    public void c(View view) {
    }
}
