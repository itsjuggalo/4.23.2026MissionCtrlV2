package f9;

import j9.k;
import j9.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f9410a;

    public b(r rVar) {
        this.f9410a = rVar;
    }

    public r a() {
        return this.f9410a;
    }

    public k b() {
        return this.f9410a.getKey();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.f9410a.equals(((b) obj).f9410a);
    }

    public int hashCode() {
        return this.f9410a.hashCode();
    }
}
