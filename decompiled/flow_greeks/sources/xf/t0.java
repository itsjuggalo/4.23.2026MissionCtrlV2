package xf;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class t0 implements pd.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u1 f25052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f25053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q1 f25054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f25055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final qf.k f25056e;

    public t0(u1 u1Var, List list, q1 q1Var, boolean z10, qf.k kVar) {
        this.f25052a = u1Var;
        this.f25053b = list;
        this.f25054c = q1Var;
        this.f25055d = z10;
        this.f25056e = kVar;
    }

    @Override // pd.k
    public Object invoke(Object obj) {
        return u0.o(this.f25052a, this.f25053b, this.f25054c, this.f25055d, this.f25056e, (yf.g) obj);
    }
}
