package k8;

import j8.l;
import k8.d;
import m8.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b extends d {
    public b(e eVar, l lVar) {
        super(d.a.ListenComplete, eVar, lVar);
        m.g(!eVar.d(), "Can't have a listen complete from a user source");
    }

    @Override // k8.d
    public d d(r8.b bVar) {
        return this.f14754c.isEmpty() ? new b(this.f14753b, l.G()) : new b(this.f14753b, this.f14754c.S());
    }

    public String toString() {
        return String.format("ListenComplete { path=%s, source=%s }", a(), b());
    }
}
