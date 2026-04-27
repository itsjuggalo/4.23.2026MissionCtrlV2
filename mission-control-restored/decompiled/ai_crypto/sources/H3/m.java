package H3;

import G3.r;
import G3.v;
import K3.AbstractC0612b;

/* JADX INFO: loaded from: classes.dex */
public final class m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final m f2654c = new m(null, null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v f2655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Boolean f2656b;

    public m(v vVar, Boolean bool) {
        AbstractC0612b.d(vVar == null || bool == null, "Precondition can specify \"exists\" or \"updateTime\" but not both", new Object[0]);
        this.f2655a = vVar;
        this.f2656b = bool;
    }

    public static m a(boolean z7) {
        return new m(null, Boolean.valueOf(z7));
    }

    public static m f(v vVar) {
        return new m(vVar, null);
    }

    public Boolean b() {
        return this.f2656b;
    }

    public v c() {
        return this.f2655a;
    }

    public boolean d() {
        return this.f2655a == null && this.f2656b == null;
    }

    public boolean e(r rVar) {
        if (this.f2655a != null) {
            return rVar.b() && rVar.l().equals(this.f2655a);
        }
        Boolean bool = this.f2656b;
        if (bool != null) {
            return bool.booleanValue() == rVar.b();
        }
        AbstractC0612b.d(d(), "Precondition should be empty", new Object[0]);
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || m.class != obj.getClass()) {
            return false;
        }
        m mVar = (m) obj;
        v vVar = this.f2655a;
        if (vVar == null ? mVar.f2655a != null : !vVar.equals(mVar.f2655a)) {
            return false;
        }
        Boolean bool = this.f2656b;
        Boolean bool2 = mVar.f2656b;
        return bool != null ? bool.equals(bool2) : bool2 == null;
    }

    public int hashCode() {
        v vVar = this.f2655a;
        int iHashCode = (vVar != null ? vVar.hashCode() : 0) * 31;
        Boolean bool = this.f2656b;
        return iHashCode + (bool != null ? bool.hashCode() : 0);
    }

    public String toString() {
        if (d()) {
            return "Precondition{<none>}";
        }
        if (this.f2655a != null) {
            return "Precondition{updateTime=" + this.f2655a + "}";
        }
        if (this.f2656b == null) {
            throw AbstractC0612b.a("Invalid Precondition", new Object[0]);
        }
        return "Precondition{exists=" + this.f2656b + "}";
    }
}
