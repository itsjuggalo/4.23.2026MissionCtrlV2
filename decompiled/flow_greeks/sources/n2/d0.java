package n2;

import android.graphics.Matrix;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class d0 extends c0 {
    @Override // n2.z, n2.e0
    public float b(View view) {
        return view.getTransitionAlpha();
    }

    @Override // n2.b0, n2.e0
    public void d(View view, int i10, int i11, int i12, int i13) {
        view.setLeftTopRightBottom(i10, i11, i12, i13);
    }

    @Override // n2.z, n2.e0
    public void e(View view, float f10) {
        view.setTransitionAlpha(f10);
    }

    @Override // n2.c0, n2.e0
    public void f(View view, int i10) {
        view.setTransitionVisibility(i10);
    }

    @Override // n2.a0, n2.e0
    public void g(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    @Override // n2.a0, n2.e0
    public void h(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }
}
