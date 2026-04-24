package u4;

import N1.C0094g0;
import a.AbstractC0284a;

/* JADX INFO: renamed from: u4.t, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1237t extends AbstractC1222d {
    @Override // u4.AbstractC1222d
    public P g() {
        return u().g();
    }

    public final String toString() {
        C0094g0 c0094g0J = AbstractC0284a.J(this);
        c0094g0J.a(u(), "delegate");
        return c0094g0J.toString();
    }

    public abstract AbstractC1222d u();
}
