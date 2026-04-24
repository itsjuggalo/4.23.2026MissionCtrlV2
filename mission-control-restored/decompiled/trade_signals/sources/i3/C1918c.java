package i3;

import h3.C1866b;
import h3.C1875k;
import i3.AbstractC1919d;
import p3.C2548b;

/* JADX INFO: renamed from: i3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1918c extends AbstractC1919d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C1866b f18782d;

    public C1918c(C1920e c1920e, C1875k c1875k, C1866b c1866b) {
        super(AbstractC1919d.a.Merge, c1920e, c1875k);
        this.f18782d = c1866b;
    }

    @Override // i3.AbstractC1919d
    public AbstractC1919d d(C2548b c2548b) {
        if (!this.f18785c.isEmpty()) {
            if (this.f18785c.P().equals(c2548b)) {
                return new C1918c(this.f18784b, this.f18785c.S(), this.f18782d);
            }
            return null;
        }
        C1866b c1866bN = this.f18782d.n(new C1875k(c2548b));
        if (c1866bN.isEmpty()) {
            return null;
        }
        return c1866bN.O() != null ? new C1921f(this.f18784b, C1875k.O(), c1866bN.O()) : new C1918c(this.f18784b, C1875k.O(), c1866bN);
    }

    public C1866b e() {
        return this.f18782d;
    }

    public String toString() {
        return String.format("Merge { path=%s, source=%s, children=%s }", a(), b(), this.f18782d);
    }
}
