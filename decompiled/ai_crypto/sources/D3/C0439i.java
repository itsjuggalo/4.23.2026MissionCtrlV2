package D3;

import D3.b0;
import K3.AbstractC0612b;
import java.util.List;
import k4.C2105D;

/* JADX INFO: renamed from: D3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0439i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f1324b;

    public C0439i(List list, boolean z7) {
        this.f1324b = list;
        this.f1323a = z7;
    }

    public final int a(List list, G3.h hVar) {
        int i7;
        AbstractC0612b.d(this.f1324b.size() <= list.size(), "Bound has more components than query's orderBy", new Object[0]);
        int i8 = 0;
        for (int i9 = 0; i9 < this.f1324b.size(); i9++) {
            b0 b0Var = (b0) list.get(i9);
            C2105D c2105d = (C2105D) this.f1324b.get(i9);
            if (b0Var.f1254b.equals(G3.q.f2455b)) {
                AbstractC0612b.d(G3.y.C(c2105d), "Bound has a non-key value where the key path is being used %s", c2105d);
                i7 = G3.k.i(c2105d.t0()).compareTo(hVar.getKey());
            } else {
                C2105D c2105dI = hVar.i(b0Var.c());
                AbstractC0612b.d(c2105dI != null, "Field should exist since document matched the orderBy already.", new Object[0]);
                i7 = G3.y.i(c2105d, c2105dI);
            }
            if (b0Var.b().equals(b0.a.DESCENDING)) {
                i7 *= -1;
            }
            i8 = i7;
            if (i8 != 0) {
                break;
            }
        }
        return i8;
    }

    public List b() {
        return this.f1324b;
    }

    public boolean c() {
        return this.f1323a;
    }

    public String d() {
        StringBuilder sb = new StringBuilder();
        boolean z7 = true;
        for (C2105D c2105d : this.f1324b) {
            if (!z7) {
                sb.append(com.amazon.a.a.o.b.f.f9989a);
            }
            sb.append(G3.y.b(c2105d));
            z7 = false;
        }
        return sb.toString();
    }

    public boolean e(List list, G3.h hVar) {
        int iA = a(list, hVar);
        if (this.f1323a) {
            if (iA < 0) {
                return false;
            }
        } else if (iA <= 0) {
            return false;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C0439i.class != obj.getClass()) {
            return false;
        }
        C0439i c0439i = (C0439i) obj;
        return this.f1323a == c0439i.f1323a && this.f1324b.equals(c0439i.f1324b);
    }

    public boolean f(List list, G3.h hVar) {
        int iA = a(list, hVar);
        if (this.f1323a) {
            if (iA > 0) {
                return false;
            }
        } else if (iA >= 0) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((this.f1323a ? 1 : 0) * 31) + this.f1324b.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Bound(inclusive=");
        sb.append(this.f1323a);
        sb.append(", position=");
        for (int i7 = 0; i7 < this.f1324b.size(); i7++) {
            if (i7 > 0) {
                sb.append(" and ");
            }
            sb.append(G3.y.b((C2105D) this.f1324b.get(i7)));
        }
        sb.append(")");
        return sb.toString();
    }
}
