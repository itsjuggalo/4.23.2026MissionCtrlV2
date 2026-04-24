package t2;

import java.util.List;

/* JADX INFO: renamed from: t2.U, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1132U extends y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10027b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List f10028c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final y0 f10029d;
    public final int e;

    public C1132U(String str, String str2, List list, y0 y0Var, int i) {
        this.f10026a = str;
        this.f10027b = str2;
        this.f10028c = list;
        this.f10029d = y0Var;
        this.e = i;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (obj instanceof y0) {
            y0 y0Var = (y0) obj;
            if (this.f10026a.equals(((C1132U) y0Var).f10026a) && ((str = this.f10027b) != null ? str.equals(((C1132U) y0Var).f10027b) : ((C1132U) y0Var).f10027b == null)) {
                C1132U c1132u = (C1132U) y0Var;
                if (this.f10028c.equals(c1132u.f10028c)) {
                    y0 y0Var2 = c1132u.f10029d;
                    y0 y0Var3 = this.f10029d;
                    if (y0Var3 != null ? y0Var3.equals(y0Var2) : y0Var2 == null) {
                        if (this.e == c1132u.e) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        int iHashCode = (this.f10026a.hashCode() ^ 1000003) * 1000003;
        String str = this.f10027b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f10028c.hashCode()) * 1000003;
        y0 y0Var = this.f10029d;
        return ((iHashCode2 ^ (y0Var != null ? y0Var.hashCode() : 0)) * 1000003) ^ this.e;
    }

    public final String toString() {
        return "Exception{type=" + this.f10026a + ", reason=" + this.f10027b + ", frames=" + this.f10028c + ", causedBy=" + this.f10029d + ", overflowCount=" + this.e + "}";
    }
}
