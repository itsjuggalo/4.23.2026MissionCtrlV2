package oe;

import fe.f1;

/* JADX INFO: loaded from: classes3.dex */
public class e implements pd.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f1 f17964a;

    public e(f1 f1Var) {
        this.f17964a = f1Var;
    }

    @Override // pd.k
    public Object invoke(Object obj) {
        return Boolean.valueOf(f.l(this.f17964a, (fe.b) obj));
    }
}
