package a6;

import R5.InterfaceC0845b;
import R5.g0;

/* JADX INFO: renamed from: a6.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C1082e implements B5.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0 f10137a;

    public C1082e(g0 g0Var) {
        this.f10137a = g0Var;
    }

    @Override // B5.k
    public Object invoke(Object obj) {
        return Boolean.valueOf(C1083f.l(this.f10137a, (InterfaceC0845b) obj));
    }
}
