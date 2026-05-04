package i3;

import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements g3.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g3.f f11589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g3.f f11590c;

    public d(g3.f fVar, g3.f fVar2) {
        this.f11589b = fVar;
        this.f11590c = fVar2;
    }

    @Override // g3.f
    public void b(MessageDigest messageDigest) {
        this.f11589b.b(messageDigest);
        this.f11590c.b(messageDigest);
    }

    @Override // g3.f
    public boolean equals(Object obj) {
        if (obj instanceof d) {
            d dVar = (d) obj;
            if (this.f11589b.equals(dVar.f11589b) && this.f11590c.equals(dVar.f11590c)) {
                return true;
            }
        }
        return false;
    }

    @Override // g3.f
    public int hashCode() {
        return (this.f11589b.hashCode() * 31) + this.f11590c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f11589b + ", signature=" + this.f11590c + '}';
    }
}
