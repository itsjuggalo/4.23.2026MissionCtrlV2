package sg;

import ng.u2;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gd.i f20415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object[] f20416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final u2[] f20417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20418d;

    public o0(gd.i iVar, int i10) {
        this.f20415a = iVar;
        this.f20416b = new Object[i10];
        this.f20417c = new u2[i10];
    }

    public final void a(u2 u2Var, Object obj) {
        Object[] objArr = this.f20416b;
        int i10 = this.f20418d;
        objArr[i10] = obj;
        u2[] u2VarArr = this.f20417c;
        this.f20418d = i10 + 1;
        kotlin.jvm.internal.t.d(u2Var, "null cannot be cast to non-null type kotlinx.coroutines.ThreadContextElement<kotlin.Any?>");
        u2VarArr[i10] = u2Var;
    }

    public final void b(gd.i iVar) {
        int length = this.f20417c.length - 1;
        if (length < 0) {
            return;
        }
        while (true) {
            int i10 = length - 1;
            u2 u2Var = this.f20417c[length];
            kotlin.jvm.internal.t.c(u2Var);
            u2Var.e(iVar, this.f20416b[length]);
            if (i10 < 0) {
                return;
            } else {
                length = i10;
            }
        }
    }
}
