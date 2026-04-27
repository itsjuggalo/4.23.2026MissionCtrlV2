package r0;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class G extends D {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f14323d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f14324e = true;

    @Override // r0.M
    public void g(View view, Matrix matrix) {
        if (f14323d) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f14323d = false;
            }
        }
    }

    @Override // r0.M
    public void h(View view, Matrix matrix) {
        if (f14324e) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f14324e = false;
            }
        }
    }
}
