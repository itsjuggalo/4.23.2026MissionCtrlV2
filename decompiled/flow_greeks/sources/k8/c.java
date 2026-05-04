package k8;

import j8.l;
import k8.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final j8.b f14751d;

    public c(e eVar, l lVar, j8.b bVar) {
        super(d.a.Merge, eVar, lVar);
        this.f14751d = bVar;
    }

    @Override // k8.d
    public d d(r8.b bVar) {
        if (!this.f14754c.isEmpty()) {
            if (this.f14754c.K().equals(bVar)) {
                return new c(this.f14753b, this.f14754c.S(), this.f14751d);
            }
            return null;
        }
        j8.b bVarG = this.f14751d.g(new l(bVar));
        if (bVarG.isEmpty()) {
            return null;
        }
        return bVarG.G() != null ? new f(this.f14753b, l.G(), bVarG.G()) : new c(this.f14753b, l.G(), bVarG);
    }

    public j8.b e() {
        return this.f14751d;
    }

    public String toString() {
        return String.format("Merge { path=%s, source=%s, children=%s }", a(), b(), this.f14751d);
    }
}
