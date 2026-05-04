package k8;

import j8.l;
import k8.d;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class f extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final n f14768d;

    public f(e eVar, l lVar, n nVar) {
        super(d.a.Overwrite, eVar, lVar);
        this.f14768d = nVar;
    }

    @Override // k8.d
    public d d(r8.b bVar) {
        return this.f14754c.isEmpty() ? new f(this.f14753b, l.G(), this.f14768d.z(bVar)) : new f(this.f14753b, this.f14754c.S(), this.f14768d);
    }

    public n e() {
        return this.f14768d;
    }

    public String toString() {
        return String.format("Overwrite { path=%s, source=%s, snapshot=%s }", a(), b(), this.f14768d);
    }
}
