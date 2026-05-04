package q6;

import java.io.Serializable;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f extends t implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator f18805a;

    public f(Comparator comparator) {
        this.f18805a = (Comparator) p6.n.n(comparator);
    }

    @Override // q6.t, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.f18805a.compare(obj, obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f) {
            return this.f18805a.equals(((f) obj).f18805a);
        }
        return false;
    }

    public int hashCode() {
        return this.f18805a.hashCode();
    }

    public String toString() {
        return this.f18805a.toString();
    }
}
