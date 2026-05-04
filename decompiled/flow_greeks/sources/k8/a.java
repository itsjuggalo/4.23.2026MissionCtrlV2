package k8;

import j8.l;
import k8.d;
import m8.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a extends d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f14749d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m8.d f14750e;

    public a(l lVar, m8.d dVar, boolean z10) {
        super(d.a.AckUserWrite, e.f14760d, lVar);
        this.f14750e = dVar;
        this.f14749d = z10;
    }

    @Override // k8.d
    public d d(r8.b bVar) {
        if (!this.f14754c.isEmpty()) {
            m.g(this.f14754c.K().equals(bVar), "operationForChild called for unrelated child.");
            return new a(this.f14754c.S(), this.f14750e, this.f14749d);
        }
        if (this.f14750e.getValue() != null) {
            m.g(this.f14750e.s().isEmpty(), "affectedTree should not have overlapping affected paths.");
            return this;
        }
        return new a(l.G(), this.f14750e.K(new l(bVar)), this.f14749d);
    }

    public m8.d e() {
        return this.f14750e;
    }

    public boolean f() {
        return this.f14749d;
    }

    public String toString() {
        return String.format("AckUserWrite { path=%s, revert=%s, affectedTree=%s }", a(), Boolean.valueOf(this.f14749d), this.f14750e);
    }
}
