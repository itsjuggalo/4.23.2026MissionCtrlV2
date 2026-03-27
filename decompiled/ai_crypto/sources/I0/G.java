package I0;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class G extends D {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f2707d = true;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f2708e = true;

    @Override // I0.M
    public void g(View view, Matrix matrix) {
        if (f2707d) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError unused) {
                f2707d = false;
            }
        }
    }

    @Override // I0.M
    public void h(View view, Matrix matrix) {
        if (f2708e) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError unused) {
                f2708e = false;
            }
        }
    }
}
