package I0;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class I extends G {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f2709f = true;

    @Override // I0.M
    public void d(View view, int i7, int i8, int i9, int i10) {
        if (f2709f) {
            try {
                view.setLeftTopRightBottom(i7, i8, i9, i10);
            } catch (NoSuchMethodError unused) {
                f2709f = false;
            }
        }
    }
}
