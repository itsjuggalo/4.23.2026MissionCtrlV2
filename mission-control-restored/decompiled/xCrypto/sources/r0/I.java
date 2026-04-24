package r0;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class I extends G {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f14325f = true;

    @Override // r0.M
    public void d(View view, int i4, int i5, int i6, int i7) {
        if (f14325f) {
            try {
                view.setLeftTopRightBottom(i4, i5, i6, i7);
            } catch (NoSuchMethodError unused) {
                f14325f = false;
            }
        }
    }
}
