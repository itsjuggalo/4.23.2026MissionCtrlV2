package g9;

import g9.a1;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f10229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f10230b;

    public i(List list, boolean z10) {
        this.f10230b = list;
        this.f10229a = z10;
    }

    public final int a(List list, j9.h hVar) {
        int i10;
        n9.b.d(this.f10230b.size() <= list.size(), "Bound has more components than query's orderBy", new Object[0]);
        int i11 = 0;
        for (int i12 = 0; i12 < this.f10230b.size(); i12++) {
            a1 a1Var = (a1) list.get(i12);
            bb.d0 d0Var = (bb.d0) this.f10230b.get(i12);
            if (a1Var.f10143b.equals(j9.q.f14256b)) {
                n9.b.d(j9.y.C(d0Var), "Bound has a non-key value where the key path is being used %s", d0Var);
                i10 = j9.k.i(d0Var.t0()).compareTo(hVar.getKey());
            } else {
                bb.d0 d0VarH = hVar.h(a1Var.c());
                n9.b.d(d0VarH != null, "Field should exist since document matched the orderBy already.", new Object[0]);
                i10 = j9.y.i(d0Var, d0VarH);
            }
            if (a1Var.b().equals(a1.a.DESCENDING)) {
                i10 *= -1;
            }
            i11 = i10;
            if (i11 != 0) {
                return i11;
            }
        }
        return i11;
    }

    public List b() {
        return this.f10230b;
    }

    public boolean c() {
        return this.f10229a;
    }

    public String d() {
        StringBuilder sb2 = new StringBuilder();
        boolean z10 = true;
        for (bb.d0 d0Var : this.f10230b) {
            if (!z10) {
                sb2.append(com.amazon.a.a.o.b.f.f4598a);
            }
            sb2.append(j9.y.b(d0Var));
            z10 = false;
        }
        return sb2.toString();
    }

    public boolean e(List list, j9.h hVar) {
        int iA = a(list, hVar);
        return this.f10229a ? iA >= 0 : iA > 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && i.class == obj.getClass()) {
            i iVar = (i) obj;
            if (this.f10229a == iVar.f10229a && this.f10230b.equals(iVar.f10230b)) {
                return true;
            }
        }
        return false;
    }

    public boolean f(List list, j9.h hVar) {
        int iA = a(list, hVar);
        return this.f10229a ? iA <= 0 : iA < 0;
    }

    public int hashCode() {
        return ((this.f10229a ? 1 : 0) * 31) + this.f10230b.hashCode();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Bound(inclusive=");
        sb2.append(this.f10229a);
        sb2.append(", position=");
        for (int i10 = 0; i10 < this.f10230b.size(); i10++) {
            if (i10 > 0) {
                sb2.append(" and ");
            }
            sb2.append(j9.y.b((bb.d0) this.f10230b.get(i10)));
        }
        sb2.append(")");
        return sb2.toString();
    }
}
