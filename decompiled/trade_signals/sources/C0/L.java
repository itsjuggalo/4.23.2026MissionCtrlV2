package C0;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class L extends K {
    @Override // C0.D, C0.M
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // C0.I, C0.M
    public void d(View view, int i8, int i9, int i10, int i11) {
        view.setLeftTopRightBottom(i8, i9, i10, i11);
    }

    @Override // C0.D, C0.M
    public void e(View view, float f8) {
        view.setTransitionAlpha(f8);
    }

    @Override // C0.K, C0.M
    public void f(View view, int i8) {
        view.setTransitionVisibility(i8);
    }

    @Override // C0.G, C0.M
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // C0.G, C0.M
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
