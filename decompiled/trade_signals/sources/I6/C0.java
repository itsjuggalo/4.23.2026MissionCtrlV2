package I6;

/* JADX INFO: loaded from: classes2.dex */
public abstract class C0 implements B0 {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof B0)) {
            return false;
        }
        B0 b02 = (B0) obj;
        return c() == b02.c() && b() == b02.b() && getType().equals(b02.getType());
    }

    public int hashCode() {
        int iHashCode = b().hashCode() * 31;
        if (J0.w(getType())) {
            return iHashCode + 19;
        }
        return iHashCode + (c() ? 17 : getType().hashCode());
    }

    public String toString() {
        if (c()) {
            return "*";
        }
        if (b() == N0.f4370e) {
            return getType().toString();
        }
        return b() + " " + getType();
    }
}
