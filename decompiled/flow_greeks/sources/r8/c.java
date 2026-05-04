package r8;

import com.revenuecat.purchases.common.Constants;
import g8.c;
import g8.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import r8.n;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c implements n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Comparator f19391d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g8.c f19392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final n f19393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f19394c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(r8.b bVar, r8.b bVar2) {
            return bVar.compareTo(bVar2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b extends h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f19395a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC0339c f19396b;

        public b(AbstractC0339c abstractC0339c) {
            this.f19396b = abstractC0339c;
        }

        @Override // g8.h.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(r8.b bVar, n nVar) {
            if (!this.f19395a && bVar.compareTo(r8.b.m()) > 0) {
                this.f19395a = true;
                this.f19396b.b(r8.b.m(), c.this.n());
            }
            this.f19396b.b(bVar, nVar);
        }
    }

    /* JADX INFO: renamed from: r8.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class AbstractC0339c extends h.b {
        public abstract void b(r8.b bVar, n nVar);

        @Override // g8.h.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(r8.b bVar, n nVar) {
            b(bVar, nVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class d implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f19398a;

        public d(Iterator it) {
            this.f19398a = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public m next() {
            Map.Entry entry = (Map.Entry) this.f19398a.next();
            return new m((r8.b) entry.getKey(), (n) entry.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f19398a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f19398a.remove();
        }
    }

    public c() {
        this.f19394c = null;
        this.f19392a = c.a.c(f19391d);
        this.f19393b = r.a();
    }

    public static void a(StringBuilder sb2, int i10) {
        for (int i11 = 0; i11 < i10; i11++) {
            sb2.append(" ");
        }
    }

    @Override // r8.n
    public String C(n.b bVar) {
        boolean z10;
        n.b bVar2 = n.b.V1;
        if (bVar != bVar2) {
            throw new IllegalArgumentException("Hashes on children nodes only supported for V1");
        }
        StringBuilder sb2 = new StringBuilder();
        if (!this.f19393b.isEmpty()) {
            sb2.append("priority:");
            sb2.append(this.f19393b.C(bVar2));
            sb2.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        }
        ArrayList<m> arrayList = new ArrayList();
        Iterator it = iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                m mVar = (m) it.next();
                arrayList.add(mVar);
                z10 = z10 || !mVar.d().n().isEmpty();
            }
        }
        if (z10) {
            Collections.sort(arrayList, q.j());
        }
        for (m mVar2 : arrayList) {
            String strQ = mVar2.d().Q();
            if (!strQ.equals("")) {
                sb2.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                sb2.append(mVar2.c().b());
                sb2.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                sb2.append(strQ);
            }
        }
        return sb2.toString();
    }

    @Override // r8.n
    public n D(n nVar) {
        return this.f19392a.isEmpty() ? g.y() : new c(this.f19392a, nVar);
    }

    @Override // r8.n
    public boolean F(r8.b bVar) {
        return !z(bVar).isEmpty();
    }

    @Override // r8.n
    public n I(j8.l lVar, n nVar) {
        r8.b bVarK = lVar.K();
        if (bVarK == null) {
            return nVar;
        }
        if (!bVarK.s()) {
            return t(bVarK, z(bVarK).I(lVar.S(), nVar));
        }
        m8.m.f(r.b(nVar));
        return D(nVar);
    }

    @Override // r8.n
    public boolean J() {
        return false;
    }

    @Override // r8.n
    public Object N(boolean z10) {
        Integer numK;
        if (isEmpty()) {
            return null;
        }
        HashMap map = new HashMap();
        boolean z11 = true;
        int i10 = 0;
        int iIntValue = 0;
        for (Map.Entry entry : this.f19392a) {
            String strB = ((r8.b) entry.getKey()).b();
            map.put(strB, ((n) entry.getValue()).N(z10));
            i10++;
            if (z11) {
                if ((strB.length() > 1 && strB.charAt(0) == '0') || (numK = m8.m.k(strB)) == null || numK.intValue() < 0) {
                    z11 = false;
                } else if (numK.intValue() > iIntValue) {
                    iIntValue = numK.intValue();
                }
            }
        }
        if (z10 || !z11 || iIntValue >= i10 * 2) {
            if (z10 && !this.f19393b.isEmpty()) {
                map.put(".priority", this.f19393b.getValue());
            }
            return map;
        }
        ArrayList arrayList = new ArrayList(iIntValue + 1);
        for (int i11 = 0; i11 <= iIntValue; i11++) {
            arrayList.add(map.get("" + i11));
        }
        return arrayList;
    }

    @Override // r8.n
    public n O(j8.l lVar) {
        r8.b bVarK = lVar.K();
        return bVarK == null ? this : z(bVarK).O(lVar.S());
    }

    @Override // r8.n
    public Iterator P() {
        return new d(this.f19392a.P());
    }

    @Override // r8.n
    public String Q() {
        if (this.f19394c == null) {
            String strC = C(n.b.V1);
            this.f19394c = strC.isEmpty() ? "" : m8.m.i(strC);
        }
        return this.f19394c;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: c */
    public int compareTo(n nVar) {
        if (isEmpty()) {
            return nVar.isEmpty() ? 0 : -1;
        }
        if (nVar.J() || nVar.isEmpty()) {
            return 1;
        }
        return nVar == n.P ? -1 : 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!n().equals(cVar.n()) || this.f19392a.size() != cVar.f19392a.size()) {
            return false;
        }
        Iterator it = this.f19392a.iterator();
        Iterator it2 = cVar.f19392a.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            if (!((r8.b) entry.getKey()).equals(entry2.getKey()) || !((n) entry.getValue()).equals(entry2.getValue())) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            throw new IllegalStateException("Something went wrong internally.");
        }
        return true;
    }

    @Override // r8.n
    public Object getValue() {
        return N(false);
    }

    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            m mVar = (m) it.next();
            iHashCode = (((iHashCode * 31) + mVar.c().hashCode()) * 17) + mVar.d().hashCode();
        }
        return iHashCode;
    }

    @Override // r8.n
    public boolean isEmpty() {
        return this.f19392a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new d(this.f19392a.iterator());
    }

    @Override // r8.n
    public int j() {
        return this.f19392a.size();
    }

    @Override // r8.n
    public n n() {
        return this.f19393b;
    }

    public void q(AbstractC0339c abstractC0339c) {
        s(abstractC0339c, false);
    }

    public void s(AbstractC0339c abstractC0339c, boolean z10) {
        if (!z10 || n().isEmpty()) {
            this.f19392a.p(abstractC0339c);
        } else {
            this.f19392a.p(new b(abstractC0339c));
        }
    }

    @Override // r8.n
    public n t(r8.b bVar, n nVar) {
        if (bVar.s()) {
            return D(nVar);
        }
        g8.c cVarQ = this.f19392a;
        if (cVarQ.a(bVar)) {
            cVarQ = cVarQ.s(bVar);
        }
        if (!nVar.isEmpty()) {
            cVarQ = cVarQ.q(bVar, nVar);
        }
        return cVarQ.isEmpty() ? g.y() : new c(cVarQ, this.f19393b);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        w(sb2, 0);
        return sb2.toString();
    }

    public r8.b u() {
        return (r8.b) this.f19392a.f();
    }

    public r8.b v() {
        return (r8.b) this.f19392a.e();
    }

    public final void w(StringBuilder sb2, int i10) {
        if (this.f19392a.isEmpty() && this.f19393b.isEmpty()) {
            sb2.append("{ }");
            return;
        }
        sb2.append("{\n");
        for (Map.Entry entry : this.f19392a) {
            int i11 = i10 + 2;
            a(sb2, i11);
            sb2.append(((r8.b) entry.getKey()).b());
            sb2.append(com.amazon.a.a.o.b.f.f4599b);
            if (entry.getValue() instanceof c) {
                ((c) entry.getValue()).w(sb2, i11);
            } else {
                sb2.append(((n) entry.getValue()).toString());
            }
            sb2.append("\n");
        }
        if (!this.f19393b.isEmpty()) {
            a(sb2, i10 + 2);
            sb2.append(".priority=");
            sb2.append(this.f19393b.toString());
            sb2.append("\n");
        }
        a(sb2, i10);
        sb2.append("}");
    }

    @Override // r8.n
    public r8.b x(r8.b bVar) {
        return (r8.b) this.f19392a.g(bVar);
    }

    @Override // r8.n
    public n z(r8.b bVar) {
        return (!bVar.s() || this.f19393b.isEmpty()) ? this.f19392a.a(bVar) ? (n) this.f19392a.c(bVar) : g.y() : this.f19393b;
    }

    public c(g8.c cVar, n nVar) {
        this.f19394c = null;
        if (cVar.isEmpty() && !nVar.isEmpty()) {
            throw new IllegalArgumentException("Can't create empty ChildrenNode with priority!");
        }
        this.f19393b = nVar;
        this.f19392a = cVar;
    }
}
