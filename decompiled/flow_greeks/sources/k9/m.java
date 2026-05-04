package k9;

import j9.r;
import j9.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f14793c = new m(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f14794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f14795b;

    public m(v vVar, Boolean bool) {
        n9.b.d(vVar == null || bool == null, "Precondition can specify \"exists\" or \"updateTime\" but not both", new Object[0]);
        this.f14794a = vVar;
        this.f14795b = bool;
    }

    public static m a(boolean z10) {
        return new m(null, Boolean.valueOf(z10));
    }

    public static m f(v vVar) {
        return new m(vVar, null);
    }

    public Boolean b() {
        return this.f14795b;
    }

    public v c() {
        return this.f14794a;
    }

    public boolean d() {
        return this.f14794a == null && this.f14795b == null;
    }

    public boolean e(r rVar) {
        if (this.f14794a != null) {
            return rVar.b() && rVar.k().equals(this.f14794a);
        }
        Boolean bool = this.f14795b;
        if (bool != null) {
            return bool.booleanValue() == rVar.b();
        }
        n9.b.d(d(), "Precondition should be empty", new Object[0]);
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && m.class == obj.getClass()) {
            m mVar = (m) obj;
            v vVar = this.f14794a;
            if (vVar == null ? mVar.f14794a != null : !vVar.equals(mVar.f14794a)) {
                return false;
            }
            Boolean bool = this.f14795b;
            Boolean bool2 = mVar.f14795b;
            if (bool != null) {
                return bool.equals(bool2);
            }
            if (bool2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        v vVar = this.f14794a;
        int iHashCode = (vVar != null ? vVar.hashCode() : 0) * 31;
        Boolean bool = this.f14795b;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        if (d()) {
            return "Precondition{<none>}";
        }
        if (this.f14794a != null) {
            return "Precondition{updateTime=" + this.f14794a + "}";
        }
        if (this.f14795b == null) {
            throw n9.b.a("Invalid Precondition", new Object[0]);
        }
        return "Precondition{exists=" + this.f14795b + "}";
    }
}
