package W0;

import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class d implements U0.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final U0.f f9044b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final U0.f f9045c;

    public d(U0.f fVar, U0.f fVar2) {
        this.f9044b = fVar;
        this.f9045c = fVar2;
    }

    @Override // U0.f
    public void a(MessageDigest messageDigest) {
        this.f9044b.a(messageDigest);
        this.f9045c.a(messageDigest);
    }

    @Override // U0.f
    public boolean equals(Object obj) {
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f9044b.equals(dVar.f9044b) && this.f9045c.equals(dVar.f9045c);
    }

    @Override // U0.f
    public int hashCode() {
        return (this.f9044b.hashCode() * 31) + this.f9045c.hashCode();
    }

    public String toString() {
        return "DataCacheKey{sourceKey=" + this.f9044b + ", signature=" + this.f9045c + '}';
    }
}
