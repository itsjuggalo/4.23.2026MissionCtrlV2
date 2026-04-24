package k3;

import java.util.List;
import k3.AbstractC2074F;

/* JADX INFO: renamed from: k3.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2100y extends AbstractC2074F.e.d.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f17983a;

    /* JADX INFO: renamed from: k3.y$b */
    public static final class b extends AbstractC2074F.e.d.f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f17984a;

        @Override // k3.AbstractC2074F.e.d.f.a
        public AbstractC2074F.e.d.f a() {
            List list = this.f17984a;
            if (list != null) {
                return new C2100y(list);
            }
            throw new IllegalStateException("Missing required properties: rolloutAssignments");
        }

        @Override // k3.AbstractC2074F.e.d.f.a
        public AbstractC2074F.e.d.f.a b(List list) {
            if (list == null) {
                throw new NullPointerException("Null rolloutAssignments");
            }
            this.f17984a = list;
            return this;
        }
    }

    @Override // k3.AbstractC2074F.e.d.f
    public List b() {
        return this.f17983a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2074F.e.d.f) {
            return this.f17983a.equals(((AbstractC2074F.e.d.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f17983a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f17983a + "}";
    }

    public C2100y(List list) {
        this.f17983a = list;
    }
}
