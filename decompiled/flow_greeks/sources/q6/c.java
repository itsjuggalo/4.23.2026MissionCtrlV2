package q6;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends t implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p6.f f18803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f18804b;

    public c(p6.f fVar, t tVar) {
        this.f18803a = (p6.f) p6.n.n(fVar);
        this.f18804b = (t) p6.n.n(tVar);
    }

    @Override // q6.t, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f18804b.compare(this.f18803a.apply(obj), this.f18803a.apply(obj2));
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f18803a.equals(cVar.f18803a) && this.f18804b.equals(cVar.f18804b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return p6.j.b(this.f18803a, this.f18804b);
    }

    public String toString() {
        return this.f18804b + ".onResultOf(" + this.f18803a + ")";
    }
}
