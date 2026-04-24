package b4;

import java.util.Set;

/* JADX INFO: renamed from: b4.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1198a extends AbstractC1199b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f12895a;

    public C1198a(Set set) {
        if (set == null) {
            throw new NullPointerException("Null updatedKeys");
        }
        this.f12895a = set;
    }

    @Override // b4.AbstractC1199b
    public Set b() {
        return this.f12895a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC1199b) {
            return this.f12895a.equals(((AbstractC1199b) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.f12895a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "ConfigUpdate{updatedKeys=" + this.f12895a + "}";
    }
}
