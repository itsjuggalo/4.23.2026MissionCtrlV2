package n6;

import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class t extends p implements Set {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient s f16673b;

    public static t p() {
        return v.f16677f;
    }

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof t) {
            ((t) obj).q();
            if (obj.hashCode() != 0) {
                return false;
            }
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    return containsAll(set);
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public final s f() {
        s sVar = this.f16673b;
        if (sVar != null) {
            return sVar;
        }
        s sVarG = g();
        this.f16673b = sVarG;
        return sVarG;
    }

    public abstract s g();

    public abstract boolean q();
}
