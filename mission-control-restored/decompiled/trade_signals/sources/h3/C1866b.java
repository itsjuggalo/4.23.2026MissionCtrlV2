package h3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import k3.AbstractC2279m;
import k3.C2270d;
import p3.AbstractC2561o;
import p3.C2548b;
import p3.C2559m;
import p3.InterfaceC2560n;

/* JADX INFO: renamed from: h3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1866b implements Iterable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final C1866b f18419b = new C1866b(new C2270d(null));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2270d f18420a;

    /* JADX INFO: renamed from: h3.b$a */
    public class a implements C2270d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ C1875k f18421a;

        public a(C1875k c1875k) {
            this.f18421a = c1875k;
        }

        @Override // k3.C2270d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public C1866b a(C1875k c1875k, InterfaceC2560n interfaceC2560n, C1866b c1866b) {
            return c1866b.a(this.f18421a.J(c1875k), interfaceC2560n);
        }
    }

    /* JADX INFO: renamed from: h3.b$b, reason: collision with other inner class name */
    public class C0313b implements C2270d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f18423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f18424b;

        public C0313b(Map map, boolean z7) {
            this.f18423a = map;
            this.f18424b = z7;
        }

        @Override // k3.C2270d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(C1875k c1875k, InterfaceC2560n interfaceC2560n, Void r42) {
            this.f18423a.put(c1875k.T(), interfaceC2560n.D(this.f18424b));
            return null;
        }
    }

    public C1866b(C2270d c2270d) {
        this.f18420a = c2270d;
    }

    public static C1866b F() {
        return f18419b;
    }

    public static C1866b H(Map map) {
        C2270d c2270dD = C2270d.d();
        for (Map.Entry entry : map.entrySet()) {
            c2270dD = c2270dD.O((C1875k) entry.getKey(), new C2270d((InterfaceC2560n) entry.getValue()));
        }
        return new C1866b(c2270dD);
    }

    public static C1866b I(Map map) {
        C2270d c2270dD = C2270d.d();
        for (Map.Entry entry : map.entrySet()) {
            c2270dD = c2270dD.O(new C1875k((String) entry.getKey()), new C2270d(AbstractC2561o.a(entry.getValue())));
        }
        return new C1866b(c2270dD);
    }

    public Map C() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f18420a.I()) {
            map.put((C2548b) entry.getKey(), new C1866b((C2270d) entry.getValue()));
        }
        return map;
    }

    public List J() {
        ArrayList arrayList = new ArrayList();
        if (this.f18420a.getValue() != null) {
            for (C2559m c2559m : (InterfaceC2560n) this.f18420a.getValue()) {
                arrayList.add(new C2559m(c2559m.c(), c2559m.d()));
            }
        } else {
            for (Map.Entry entry : this.f18420a.I()) {
                C2270d c2270d = (C2270d) entry.getValue();
                if (c2270d.getValue() != null) {
                    arrayList.add(new C2559m((C2548b) entry.getKey(), (InterfaceC2560n) c2270d.getValue()));
                }
            }
        }
        return arrayList;
    }

    public InterfaceC2560n K(C1875k c1875k) {
        C1875k c1875kF = this.f18420a.f(c1875k);
        if (c1875kF != null) {
            return ((InterfaceC2560n) this.f18420a.F(c1875kF)).s(C1875k.R(c1875kF, c1875k));
        }
        return null;
    }

    public Map L(boolean z7) {
        HashMap map = new HashMap();
        this.f18420a.C(new C0313b(map, z7));
        return map;
    }

    public boolean M(C1875k c1875k) {
        return K(c1875k) != null;
    }

    public C1866b N(C1875k c1875k) {
        return c1875k.isEmpty() ? f18419b : new C1866b(this.f18420a.O(c1875k, C2270d.d()));
    }

    public InterfaceC2560n O() {
        return (InterfaceC2560n) this.f18420a.getValue();
    }

    public C1866b a(C1875k c1875k, InterfaceC2560n interfaceC2560n) {
        if (c1875k.isEmpty()) {
            return new C1866b(new C2270d(interfaceC2560n));
        }
        C1875k c1875kF = this.f18420a.f(c1875k);
        if (c1875kF == null) {
            return new C1866b(this.f18420a.O(c1875k, new C2270d(interfaceC2560n)));
        }
        C1875k c1875kR = C1875k.R(c1875kF, c1875k);
        InterfaceC2560n interfaceC2560n2 = (InterfaceC2560n) this.f18420a.F(c1875kF);
        C2548b c2548bN = c1875kR.N();
        if (c2548bN != null && c2548bN.t() && interfaceC2560n2.s(c1875kR.Q()).isEmpty()) {
            return this;
        }
        return new C1866b(this.f18420a.N(c1875kF, interfaceC2560n2.y(c1875kR, interfaceC2560n)));
    }

    public C1866b d(C2548b c2548b, InterfaceC2560n interfaceC2560n) {
        return a(new C1875k(c2548b), interfaceC2560n);
    }

    public C1866b e(C1875k c1875k, C1866b c1866b) {
        return (C1866b) c1866b.f18420a.n(this, new a(c1875k));
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C1866b.class) {
            return false;
        }
        return ((C1866b) obj).L(true).equals(L(true));
    }

    public InterfaceC2560n f(InterfaceC2560n interfaceC2560n) {
        return h(C1875k.O(), this.f18420a, interfaceC2560n);
    }

    public final InterfaceC2560n h(C1875k c1875k, C2270d c2270d, InterfaceC2560n interfaceC2560n) {
        if (c2270d.getValue() != null) {
            return interfaceC2560n.y(c1875k, (InterfaceC2560n) c2270d.getValue());
        }
        InterfaceC2560n interfaceC2560n2 = null;
        for (Map.Entry entry : c2270d.I()) {
            C2270d c2270d2 = (C2270d) entry.getValue();
            C2548b c2548b = (C2548b) entry.getKey();
            if (c2548b.t()) {
                AbstractC2279m.g(c2270d2.getValue() != null, "Priority writes must always be leaf nodes");
                interfaceC2560n2 = (InterfaceC2560n) c2270d2.getValue();
            } else {
                interfaceC2560n = h(c1875k.K(c2548b), c2270d2, interfaceC2560n);
            }
        }
        return (interfaceC2560n.s(c1875k).isEmpty() || interfaceC2560n2 == null) ? interfaceC2560n : interfaceC2560n.y(c1875k.K(C2548b.n()), interfaceC2560n2);
    }

    public int hashCode() {
        return L(true).hashCode();
    }

    public boolean isEmpty() {
        return this.f18420a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f18420a.iterator();
    }

    public C1866b n(C1875k c1875k) {
        if (c1875k.isEmpty()) {
            return this;
        }
        InterfaceC2560n interfaceC2560nK = K(c1875k);
        return interfaceC2560nK != null ? new C1866b(new C2270d(interfaceC2560nK)) : new C1866b(this.f18420a.P(c1875k));
    }

    public String toString() {
        return "CompoundWrite{" + L(true).toString() + "}";
    }
}
