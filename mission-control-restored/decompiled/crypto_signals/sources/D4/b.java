package D4;

import N1.C0094g0;
import a.AbstractC0284a;
import java.util.List;
import u4.AbstractC1222d;
import u4.AbstractC1240w;

/* JADX INFO: loaded from: classes.dex */
public abstract class b extends AbstractC1240w {
    @Override // u4.AbstractC1240w
    public final List b() {
        return q().b();
    }

    @Override // u4.AbstractC1240w
    public final AbstractC1222d d() {
        return q().d();
    }

    @Override // u4.AbstractC1240w
    public final Object e() {
        return q().e();
    }

    @Override // u4.AbstractC1240w
    public final void m() {
        q().m();
    }

    @Override // u4.AbstractC1240w
    public void n() {
        q().n();
    }

    @Override // u4.AbstractC1240w
    public void p(List list) {
        q().p(list);
    }

    public abstract AbstractC1240w q();

    public String toString() {
        C0094g0 c0094g0J = AbstractC0284a.J(this);
        c0094g0J.a(q(), "delegate");
        return c0094g0J.toString();
    }
}
