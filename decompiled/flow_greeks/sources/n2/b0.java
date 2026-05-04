package n2;

import android.view.View;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b0 extends a0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f16476f = true;

    @Override // n2.e0
    public void d(View view, int i10, int i11, int i12, int i13) {
        if (f16476f) {
            try {
                view.setLeftTopRightBottom(i10, i11, i12, i13);
            } catch (NoSuchMethodError unused) {
                f16476f = false;
            }
        }
    }
}
