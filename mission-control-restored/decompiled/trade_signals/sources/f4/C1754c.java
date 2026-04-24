package f4;

import java.util.Set;

/* JADX INFO: renamed from: f4.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1754c extends AbstractC1756e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f17547a;

    public C1754c(Set set) {
        if (set == null) {
            throw new NullPointerException("Null rolloutAssignments");
        }
        this.f17547a = set;
    }

    @Override // f4.AbstractC1756e
    public Set b() {
        return this.f17547a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC1756e) {
            return this.f17547a.equals(((AbstractC1756e) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f17547a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "RolloutsState{rolloutAssignments=" + this.f17547a + "}";
    }
}
