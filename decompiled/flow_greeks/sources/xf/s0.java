package xf;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class s0 implements pd.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u1 f25046a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f25047b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q1 f25048c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f25049d;

    public s0(u1 u1Var, List list, q1 q1Var, boolean z10) {
        this.f25046a = u1Var;
        this.f25047b = list;
        this.f25048c = q1Var;
        this.f25049d = z10;
    }

    @Override // pd.k
    public Object invoke(Object obj) {
        return u0.l(this.f25046a, this.f25047b, this.f25048c, this.f25049d, (yf.g) obj);
    }
}
