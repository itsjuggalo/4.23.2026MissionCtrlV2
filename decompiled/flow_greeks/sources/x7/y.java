package x7;

import java.util.List;
import x7.f0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class y extends f0.e.d.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f24662a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends f0.e.d.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f24663a;

        @Override // x7.f0.e.d.f.a
        public f0.e.d.f a() {
            List list = this.f24663a;
            if (list != null) {
                return new y(list);
            }
            throw new IllegalStateException("Missing required properties: rolloutAssignments");
        }

        @Override // x7.f0.e.d.f.a
        public f0.e.d.f.a b(List list) {
            if (list == null) {
                throw new NullPointerException("Null rolloutAssignments");
            }
            this.f24663a = list;
            return this;
        }
    }

    @Override // x7.f0.e.d.f
    public List b() {
        return this.f24662a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.f) {
            return this.f24662a.equals(((f0.e.d.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f24662a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f24662a + "}";
    }

    public y(List list) {
        this.f24662a = list;
    }
}
