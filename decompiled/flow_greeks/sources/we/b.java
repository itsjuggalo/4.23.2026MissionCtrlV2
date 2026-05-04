package we;

/* JADX INFO: loaded from: classes3.dex */
public class b implements pd.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f23938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h[] f23939b;

    public b(q1 q1Var, h[] hVarArr) {
        this.f23938a = q1Var;
        this.f23939b = hVarArr;
    }

    @Override // pd.k
    public Object invoke(Object obj) {
        return d.e(this.f23938a, this.f23939b, ((Number) obj).intValue());
    }
}
