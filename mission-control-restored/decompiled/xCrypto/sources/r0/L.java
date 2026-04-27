package r0;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class L extends K {
    @Override // r0.D, r0.M
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // r0.I, r0.M
    public void d(View view, int i4, int i5, int i6, int i7) {
        view.setLeftTopRightBottom(i4, i5, i6, i7);
    }

    @Override // r0.D, r0.M
    public void e(View view, float f4) {
        view.setTransitionAlpha(f4);
    }

    @Override // r0.K, r0.M
    public void f(View view, int i4) {
        view.setTransitionVisibility(i4);
    }

    @Override // r0.G, r0.M
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // r0.G, r0.M
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
