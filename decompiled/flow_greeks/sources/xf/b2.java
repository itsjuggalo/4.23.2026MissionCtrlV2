package xf;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b2 implements a2 {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a2)) {
            return false;
        }
        a2 a2Var = (a2) obj;
        return c() == a2Var.c() && b() == a2Var.b() && getType().equals(a2Var.getType());
    }

    public int hashCode() {
        int iHashCode = b().hashCode();
        if (i2.w(getType())) {
            return (iHashCode * 31) + 19;
        }
        return (iHashCode * 31) + (c() ? 17 : getType().hashCode());
    }

    public String toString() {
        if (c()) {
            return "*";
        }
        if (b() == m2.f25015e) {
            return getType().toString();
        }
        return b() + " " + getType();
    }
}
