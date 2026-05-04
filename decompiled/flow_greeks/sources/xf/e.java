package xf;

import java.util.Collection;
import xf.t1;

/* JADX INFO: loaded from: classes3.dex */
public class e implements pd.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Collection f24951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t1 f24952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bg.p f24953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final bg.j f24954d;

    public e(Collection collection, t1 t1Var, bg.p pVar, bg.j jVar) {
        this.f24951a = collection;
        this.f24952b = t1Var;
        this.f24953c = pVar;
        this.f24954d = jVar;
    }

    @Override // pd.k
    public Object invoke(Object obj) {
        return g.x(this.f24951a, this.f24952b, this.f24953c, this.f24954d, (t1.a) obj);
    }
}
