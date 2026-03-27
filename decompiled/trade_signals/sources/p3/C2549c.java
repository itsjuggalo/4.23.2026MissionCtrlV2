package p3;

import com.revenuecat.purchases.common.Constants;
import e3.AbstractC1666c;
import e3.h;
import h3.C1875k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import k3.AbstractC2279m;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: p3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2549c implements InterfaceC2560n {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Comparator f22267d = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AbstractC1666c f22268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2560n f22269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f22270c;

    /* JADX INFO: renamed from: p3.c$a */
    public class a implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C2548b c2548b, C2548b c2548b2) {
            return c2548b.compareTo(c2548b2);
        }
    }

    /* JADX INFO: renamed from: p3.c$b */
    public class b extends h.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f22271a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AbstractC0375c f22272b;

        public b(AbstractC0375c abstractC0375c) {
            this.f22272b = abstractC0375c;
        }

        @Override // e3.h.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(C2548b c2548b, InterfaceC2560n interfaceC2560n) {
            if (!this.f22271a && c2548b.compareTo(C2548b.n()) > 0) {
                this.f22271a = true;
                this.f22272b.b(C2548b.n(), C2549c.this.o());
            }
            this.f22272b.b(c2548b, interfaceC2560n);
        }
    }

    /* JADX INFO: renamed from: p3.c$c, reason: collision with other inner class name */
    public static abstract class AbstractC0375c extends h.b {
        public abstract void b(C2548b c2548b, InterfaceC2560n interfaceC2560n);

        @Override // e3.h.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(C2548b c2548b, InterfaceC2560n interfaceC2560n) {
            b(c2548b, interfaceC2560n);
        }
    }

    /* JADX INFO: renamed from: p3.c$d */
    public static class d implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Iterator f22274a;

        public d(Iterator it) {
            this.f22274a = it;
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C2559m next() {
            Map.Entry entry = (Map.Entry) this.f22274a.next();
            return new C2559m((C2548b) entry.getKey(), (InterfaceC2560n) entry.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f22274a.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f22274a.remove();
        }
    }

    public C2549c() {
        this.f22270c = null;
        this.f22268a = AbstractC1666c.a.c(f22267d);
        this.f22269b = AbstractC2564r.a();
    }

    public static void a(StringBuilder sb, int i8) {
        for (int i9 = 0; i9 < i8; i9++) {
            sb.append(" ");
        }
    }

    @Override // p3.InterfaceC2560n
    public InterfaceC2560n A(C2548b c2548b, InterfaceC2560n interfaceC2560n) {
        if (c2548b.t()) {
            return c(interfaceC2560n);
        }
        AbstractC1666c abstractC1666cF = this.f22268a;
        if (abstractC1666cF.a(c2548b)) {
            abstractC1666cF = abstractC1666cF.H(c2548b);
        }
        if (!interfaceC2560n.isEmpty()) {
            abstractC1666cF = abstractC1666cF.F(c2548b, interfaceC2560n);
        }
        return abstractC1666cF.isEmpty() ? C2553g.M() : new C2549c(abstractC1666cF, this.f22269b);
    }

    @Override // p3.InterfaceC2560n
    public Object D(boolean z7) {
        Integer numK;
        if (isEmpty()) {
            return null;
        }
        HashMap map = new HashMap();
        boolean z8 = true;
        int i8 = 0;
        int iIntValue = 0;
        for (Map.Entry entry : this.f22268a) {
            String strB = ((C2548b) entry.getKey()).b();
            map.put(strB, ((InterfaceC2560n) entry.getValue()).D(z7));
            i8++;
            if (z8) {
                if ((strB.length() > 1 && strB.charAt(0) == '0') || (numK = AbstractC2279m.k(strB)) == null || numK.intValue() < 0) {
                    z8 = false;
                } else if (numK.intValue() > iIntValue) {
                    iIntValue = numK.intValue();
                }
            }
        }
        if (z7 || !z8 || iIntValue >= i8 * 2) {
            if (z7 && !this.f22269b.isEmpty()) {
                map.put(".priority", this.f22269b.getValue());
            }
            return map;
        }
        ArrayList arrayList = new ArrayList(iIntValue + 1);
        for (int i9 = 0; i9 <= iIntValue; i9++) {
            arrayList.add(map.get("" + i9));
        }
        return arrayList;
    }

    @Override // p3.InterfaceC2560n
    public Iterator E() {
        return new d(this.f22268a.E());
    }

    @Override // p3.InterfaceC2560n
    public String G() {
        if (this.f22270c == null) {
            String strV = v(InterfaceC2560n.b.V1);
            this.f22270c = strV.isEmpty() ? "" : AbstractC2279m.i(strV);
        }
        return this.f22270c;
    }

    public void H(AbstractC0375c abstractC0375c) {
        I(abstractC0375c, false);
    }

    public void I(AbstractC0375c abstractC0375c, boolean z7) {
        if (!z7 || o().isEmpty()) {
            this.f22268a.C(abstractC0375c);
        } else {
            this.f22268a.C(new b(abstractC0375c));
        }
    }

    public C2548b J() {
        return (C2548b) this.f22268a.h();
    }

    public C2548b K() {
        return (C2548b) this.f22268a.f();
    }

    public final void L(StringBuilder sb, int i8) {
        String str;
        if (this.f22268a.isEmpty() && this.f22269b.isEmpty()) {
            str = "{ }";
        } else {
            sb.append("{\n");
            for (Map.Entry entry : this.f22268a) {
                int i9 = i8 + 2;
                a(sb, i9);
                sb.append(((C2548b) entry.getKey()).b());
                sb.append(com.amazon.a.a.o.b.f.f14101b);
                boolean z7 = entry.getValue() instanceof C2549c;
                Object value = entry.getValue();
                if (z7) {
                    ((C2549c) value).L(sb, i9);
                } else {
                    sb.append(((InterfaceC2560n) value).toString());
                }
                sb.append("\n");
            }
            if (!this.f22269b.isEmpty()) {
                a(sb, i8 + 2);
                sb.append(".priority=");
                sb.append(this.f22269b.toString());
                sb.append("\n");
            }
            a(sb, i8);
            str = "}";
        }
        sb.append(str);
    }

    @Override // p3.InterfaceC2560n
    public InterfaceC2560n c(InterfaceC2560n interfaceC2560n) {
        return this.f22268a.isEmpty() ? C2553g.M() : new C2549c(this.f22268a, interfaceC2560n);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2549c)) {
            return false;
        }
        C2549c c2549c = (C2549c) obj;
        if (!o().equals(c2549c.o()) || this.f22268a.size() != c2549c.f22268a.size()) {
            return false;
        }
        Iterator it = this.f22268a.iterator();
        Iterator it2 = c2549c.f22268a.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Map.Entry entry2 = (Map.Entry) it2.next();
            if (!((C2548b) entry.getKey()).equals(entry2.getKey()) || !((InterfaceC2560n) entry.getValue()).equals(entry2.getValue())) {
                return false;
            }
        }
        if (it.hasNext() || it2.hasNext()) {
            throw new IllegalStateException("Something went wrong internally.");
        }
        return true;
    }

    @Override // p3.InterfaceC2560n
    public Object getValue() {
        return D(false);
    }

    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            C2559m c2559m = (C2559m) it.next();
            iHashCode = (((iHashCode * 31) + c2559m.c().hashCode()) * 17) + c2559m.d().hashCode();
        }
        return iHashCode;
    }

    @Override // p3.InterfaceC2560n
    public boolean isEmpty() {
        return this.f22268a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new d(this.f22268a.iterator());
    }

    @Override // p3.InterfaceC2560n
    public int j() {
        return this.f22268a.size();
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: n */
    public int compareTo(InterfaceC2560n interfaceC2560n) {
        if (isEmpty()) {
            return interfaceC2560n.isEmpty() ? 0 : -1;
        }
        if (interfaceC2560n.x() || interfaceC2560n.isEmpty()) {
            return 1;
        }
        return interfaceC2560n == InterfaceC2560n.f22308N ? -1 : 0;
    }

    @Override // p3.InterfaceC2560n
    public InterfaceC2560n o() {
        return this.f22269b;
    }

    @Override // p3.InterfaceC2560n
    public C2548b p(C2548b c2548b) {
        return (C2548b) this.f22268a.n(c2548b);
    }

    @Override // p3.InterfaceC2560n
    public InterfaceC2560n s(C1875k c1875k) {
        C2548b c2548bP = c1875k.P();
        return c2548bP == null ? this : z(c2548bP).s(c1875k.S());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        L(sb, 0);
        return sb.toString();
    }

    @Override // p3.InterfaceC2560n
    public boolean u(C2548b c2548b) {
        return !z(c2548b).isEmpty();
    }

    @Override // p3.InterfaceC2560n
    public String v(InterfaceC2560n.b bVar) {
        boolean z7;
        InterfaceC2560n.b bVar2 = InterfaceC2560n.b.V1;
        if (bVar != bVar2) {
            throw new IllegalArgumentException("Hashes on children nodes only supported for V1");
        }
        StringBuilder sb = new StringBuilder();
        if (!this.f22269b.isEmpty()) {
            sb.append("priority:");
            sb.append(this.f22269b.v(bVar2));
            sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
        }
        ArrayList<C2559m> arrayList = new ArrayList();
        Iterator it = iterator();
        loop0: while (true) {
            while (it.hasNext()) {
                C2559m c2559m = (C2559m) it.next();
                arrayList.add(c2559m);
                z7 = z7 || !c2559m.d().o().isEmpty();
            }
        }
        if (z7) {
            Collections.sort(arrayList, C2563q.j());
        }
        for (C2559m c2559m2 : arrayList) {
            String strG = c2559m2.d().G();
            if (!strG.equals("")) {
                sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                sb.append(c2559m2.c().b());
                sb.append(Constants.SUBS_ID_BASE_PLAN_ID_SEPARATOR);
                sb.append(strG);
            }
        }
        return sb.toString();
    }

    @Override // p3.InterfaceC2560n
    public boolean x() {
        return false;
    }

    @Override // p3.InterfaceC2560n
    public InterfaceC2560n y(C1875k c1875k, InterfaceC2560n interfaceC2560n) {
        C2548b c2548bP = c1875k.P();
        if (c2548bP == null) {
            return interfaceC2560n;
        }
        if (!c2548bP.t()) {
            return A(c2548bP, z(c2548bP).y(c1875k.S(), interfaceC2560n));
        }
        AbstractC2279m.f(AbstractC2564r.b(interfaceC2560n));
        return c(interfaceC2560n);
    }

    @Override // p3.InterfaceC2560n
    public InterfaceC2560n z(C2548b c2548b) {
        return (!c2548b.t() || this.f22269b.isEmpty()) ? this.f22268a.a(c2548b) ? (InterfaceC2560n) this.f22268a.d(c2548b) : C2553g.M() : this.f22269b;
    }

    public C2549c(AbstractC1666c abstractC1666c, InterfaceC2560n interfaceC2560n) {
        this.f22270c = null;
        if (abstractC1666c.isEmpty() && !interfaceC2560n.isEmpty()) {
            throw new IllegalArgumentException("Can't create empty ChildrenNode with priority!");
        }
        this.f22269b = interfaceC2560n;
        this.f22268a = abstractC1666c;
    }
}
