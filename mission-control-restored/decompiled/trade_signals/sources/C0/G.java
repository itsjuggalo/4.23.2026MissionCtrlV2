package C0;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class G extends D {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f429d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f430e = true;

    @Override // C0.M
    public void g(View view, Matrix matrix) {
        if (f429d) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f429d = false;
            }
        }
    }

    @Override // C0.M
    public void h(View view, Matrix matrix) {
        if (f430e) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f430e = false;
            }
        }
    }
}
