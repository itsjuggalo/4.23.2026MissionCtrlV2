package m8;

import j8.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public q f16098a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j8.l f16099b;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        if (this.f16098a.equals(hVar.f16098a)) {
            return this.f16099b.equals(hVar.f16099b);
        }
        return false;
    }

    public int hashCode() {
        return (this.f16098a.hashCode() * 31) + this.f16099b.hashCode();
    }
}
