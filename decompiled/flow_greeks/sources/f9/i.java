package f9;

import g9.b1;
import g9.g1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g1 f9436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b1.a f9437b;

    public i(g1 g1Var, b1.a aVar) {
        this.f9436a = g1Var;
        this.f9437b = aVar;
    }

    public b1.a a() {
        return this.f9437b;
    }

    public g1 b() {
        return this.f9436a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            i iVar = (i) obj;
            if (this.f9436a.equals(iVar.f9436a) && this.f9437b == iVar.f9437b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.f9436a.hashCode() * 31) + this.f9437b.hashCode();
    }
}
