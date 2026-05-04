package n2;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a0 extends z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f16474d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f16475e = true;

    @Override // n2.e0
    public void g(View view, Matrix matrix) {
        if (f16474d) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f16474d = false;
            }
        }
    }

    @Override // n2.e0
    public void h(View view, Matrix matrix) {
        if (f16475e) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f16475e = false;
            }
        }
    }
}
