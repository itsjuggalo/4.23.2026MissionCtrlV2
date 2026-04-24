package t2;

import java.util.List;

/* JADX INFO: renamed from: t2.S, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1130S extends C0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final C1132U f10019b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q0 f10020c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C1133V f10021d;
    public final List e;

    public C1130S(List list, C1132U c1132u, q0 q0Var, C1133V c1133v, List list2) {
        this.f10018a = list;
        this.f10019b = c1132u;
        this.f10020c = q0Var;
        this.f10021d = c1133v;
        this.e = list2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0)) {
            return false;
        }
        C0 c02 = (C0) obj;
        List list = this.f10018a;
        if (list == null) {
            if (((C1130S) c02).f10018a != null) {
                return false;
            }
        } else if (!list.equals(((C1130S) c02).f10018a)) {
            return false;
        }
        C1132U c1132u = this.f10019b;
        if (c1132u == null) {
            if (((C1130S) c02).f10019b != null) {
                return false;
            }
        } else if (!c1132u.equals(((C1130S) c02).f10019b)) {
            return false;
        }
        q0 q0Var = this.f10020c;
        if (q0Var == null) {
            if (((C1130S) c02).f10020c != null) {
                return false;
            }
        } else if (!q0Var.equals(((C1130S) c02).f10020c)) {
            return false;
        }
        C1130S c1130s = (C1130S) c02;
        return this.f10021d.equals(c1130s.f10021d) && this.e.equals(c1130s.e);
    }

    public final int hashCode() {
        List list = this.f10018a;
        int iHashCode = ((list == null ? 0 : list.hashCode()) ^ 1000003) * 1000003;
        C1132U c1132u = this.f10019b;
        int iHashCode2 = (iHashCode ^ (c1132u == null ? 0 : c1132u.hashCode())) * 1000003;
        q0 q0Var = this.f10020c;
        return (((((q0Var != null ? q0Var.hashCode() : 0) ^ iHashCode2) * 1000003) ^ this.f10021d.hashCode()) * 1000003) ^ this.e.hashCode();
    }

    public final String toString() {
        return "Execution{threads=" + this.f10018a + ", exception=" + this.f10019b + ", appExitInfo=" + this.f10020c + ", signal=" + this.f10021d + ", binaries=" + this.e + "}";
    }
}
