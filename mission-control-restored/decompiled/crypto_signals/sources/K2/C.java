package K2;

import N2.EnumC0161j;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class C extends D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0069u f824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final EnumC0161j f825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f826c;

    public C(C0069u c0069u, EnumC0161j enumC0161j, Object obj) {
        this.f824a = c0069u;
        this.f825b = enumC0161j;
        this.f826c = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && C.class == obj.getClass()) {
            C c6 = (C) obj;
            if (this.f825b == c6.f825b && Objects.equals(this.f824a, c6.f824a) && Objects.equals(this.f826c, c6.f826c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        C0069u c0069u = this.f824a;
        int iHashCode = (c0069u != null ? c0069u.f972a.hashCode() : 0) * 31;
        EnumC0161j enumC0161j = this.f825b;
        int iHashCode2 = (iHashCode + (enumC0161j != null ? enumC0161j.hashCode() : 0)) * 31;
        Object obj = this.f826c;
        return iHashCode2 + (obj != null ? obj.hashCode() : 0);
    }
}
