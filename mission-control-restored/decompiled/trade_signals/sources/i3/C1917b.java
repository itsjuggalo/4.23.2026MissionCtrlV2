package i3;

import h3.C1875k;
import i3.AbstractC1919d;
import k3.AbstractC2279m;
import p3.C2548b;

/* JADX INFO: renamed from: i3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1917b extends AbstractC1919d {
    public C1917b(C1920e c1920e, C1875k c1875k) {
        super(AbstractC1919d.a.ListenComplete, c1920e, c1875k);
        AbstractC2279m.g(!c1920e.d(), "Can't have a listen complete from a user source");
    }

    @Override // i3.AbstractC1919d
    public AbstractC1919d d(C2548b c2548b) {
        return this.f18785c.isEmpty() ? new C1917b(this.f18784b, C1875k.O()) : new C1917b(this.f18784b, this.f18785c.S());
    }

    public String toString() {
        return String.format("ListenComplete { path=%s, source=%s }", a(), b());
    }
}
