package C0;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class I extends G {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f431f = true;

    @Override // C0.M
    public void d(View view, int i8, int i9, int i10, int i11) {
        if (f431f) {
            try {
                view.setLeftTopRightBottom(i8, i9, i10, i11);
            } catch (NoSuchMethodError unused) {
                f431f = false;
            }
        }
    }
}
