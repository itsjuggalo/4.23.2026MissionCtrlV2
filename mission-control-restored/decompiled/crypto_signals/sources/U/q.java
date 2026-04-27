package U;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseArray f3090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f3091b;

    public q(int i) {
        this.f3090a = new SparseArray(i);
    }

    public final void a(m mVar, int i, int i6) {
        int iA = mVar.a(i);
        SparseArray sparseArray = this.f3090a;
        q qVar = sparseArray == null ? null : (q) sparseArray.get(iA);
        if (qVar == null) {
            qVar = new q(1);
            sparseArray.put(mVar.a(i), qVar);
        }
        if (i6 > i) {
            qVar.a(mVar, i + 1, i6);
        } else {
            qVar.f3091b = mVar;
        }
    }
}
