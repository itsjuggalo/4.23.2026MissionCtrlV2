package I0;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class L extends K {
    @Override // I0.D, I0.M
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // I0.I, I0.M
    public void d(View view, int i7, int i8, int i9, int i10) {
        view.setLeftTopRightBottom(i7, i8, i9, i10);
    }

    @Override // I0.D, I0.M
    public void e(View view, float f7) {
        view.setTransitionAlpha(f7);
    }

    @Override // I0.K, I0.M
    public void f(View view, int i7) {
        view.setTransitionVisibility(i7);
    }

    @Override // I0.G, I0.M
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // I0.G, I0.M
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
