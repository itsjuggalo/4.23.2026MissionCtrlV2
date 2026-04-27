package k3;

import e3.AbstractC1666c;
import h3.C1875k;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p3.C2548b;

/* JADX INFO: renamed from: k3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2270d implements Iterable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AbstractC1666c f20361c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C2270d f20362d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f20363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC1666c f20364b;

    /* JADX INFO: renamed from: k3.d$a */
    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f20365a;

        public a(ArrayList arrayList) {
            this.f20365a = arrayList;
        }

        @Override // k3.C2270d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(C1875k c1875k, Object obj, Void r32) {
            this.f20365a.add(obj);
            return null;
        }
    }

    /* JADX INFO: renamed from: k3.d$b */
    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f20367a;

        public b(List list) {
            this.f20367a = list;
        }

        @Override // k3.C2270d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(C1875k c1875k, Object obj, Void r42) {
            this.f20367a.add(new AbstractMap.SimpleImmutableEntry(c1875k, obj));
            return null;
        }
    }

    /* JADX INFO: renamed from: k3.d$c */
    public interface c {
        Object a(C1875k c1875k, Object obj, Object obj2);
    }

    static {
        AbstractC1666c abstractC1666cC = AbstractC1666c.a.c(e3.l.b(C2548b.class));
        f20361c = abstractC1666cC;
        f20362d = new C2270d(null, abstractC1666cC);
    }

    public C2270d(Object obj) {
        this(obj, f20361c);
    }

    public static C2270d d() {
        return f20362d;
    }

    public void C(c cVar) {
        h(C1875k.O(), cVar, null);
    }

    public Object F(C1875k c1875k) {
        if (c1875k.isEmpty()) {
            return this.f20363a;
        }
        C2270d c2270d = (C2270d) this.f20364b.d(c1875k.P());
        if (c2270d != null) {
            return c2270d.F(c1875k.S());
        }
        return null;
    }

    public C2270d H(C2548b c2548b) {
        C2270d c2270d = (C2270d) this.f20364b.d(c2548b);
        return c2270d != null ? c2270d : d();
    }

    public AbstractC1666c I() {
        return this.f20364b;
    }

    public Object J(C1875k c1875k) {
        return K(c1875k, InterfaceC2275i.f20375a);
    }

    public Object K(C1875k c1875k, InterfaceC2275i interfaceC2275i) {
        Object obj = this.f20363a;
        Object obj2 = (obj == null || !interfaceC2275i.a(obj)) ? null : this.f20363a;
        Iterator it = c1875k.iterator();
        C2270d c2270d = this;
        while (it.hasNext()) {
            c2270d = (C2270d) c2270d.f20364b.d((C2548b) it.next());
            if (c2270d == null) {
                return obj2;
            }
            Object obj3 = c2270d.f20363a;
            if (obj3 != null && interfaceC2275i.a(obj3)) {
                obj2 = c2270d.f20363a;
            }
        }
        return obj2;
    }

    public C2270d L(C1875k c1875k) {
        if (c1875k.isEmpty()) {
            return this.f20364b.isEmpty() ? d() : new C2270d(null, this.f20364b);
        }
        C2548b c2548bP = c1875k.P();
        C2270d c2270d = (C2270d) this.f20364b.d(c2548bP);
        if (c2270d == null) {
            return this;
        }
        C2270d c2270dL = c2270d.L(c1875k.S());
        AbstractC1666c abstractC1666cH = c2270dL.isEmpty() ? this.f20364b.H(c2548bP) : this.f20364b.F(c2548bP, c2270dL);
        return (this.f20363a == null && abstractC1666cH.isEmpty()) ? d() : new C2270d(this.f20363a, abstractC1666cH);
    }

    public Object M(C1875k c1875k, InterfaceC2275i interfaceC2275i) {
        Object obj = this.f20363a;
        if (obj != null && interfaceC2275i.a(obj)) {
            return this.f20363a;
        }
        Iterator it = c1875k.iterator();
        C2270d c2270d = this;
        while (it.hasNext()) {
            c2270d = (C2270d) c2270d.f20364b.d((C2548b) it.next());
            if (c2270d == null) {
                return null;
            }
            Object obj2 = c2270d.f20363a;
            if (obj2 != null && interfaceC2275i.a(obj2)) {
                return c2270d.f20363a;
            }
        }
        return null;
    }

    public C2270d N(C1875k c1875k, Object obj) {
        if (c1875k.isEmpty()) {
            return new C2270d(obj, this.f20364b);
        }
        C2548b c2548bP = c1875k.P();
        C2270d c2270dD = (C2270d) this.f20364b.d(c2548bP);
        if (c2270dD == null) {
            c2270dD = d();
        }
        return new C2270d(this.f20363a, this.f20364b.F(c2548bP, c2270dD.N(c1875k.S(), obj)));
    }

    public C2270d O(C1875k c1875k, C2270d c2270d) {
        if (c1875k.isEmpty()) {
            return c2270d;
        }
        C2548b c2548bP = c1875k.P();
        C2270d c2270dD = (C2270d) this.f20364b.d(c2548bP);
        if (c2270dD == null) {
            c2270dD = d();
        }
        C2270d c2270dO = c2270dD.O(c1875k.S(), c2270d);
        return new C2270d(this.f20363a, c2270dO.isEmpty() ? this.f20364b.H(c2548bP) : this.f20364b.F(c2548bP, c2270dO));
    }

    public C2270d P(C1875k c1875k) {
        if (c1875k.isEmpty()) {
            return this;
        }
        C2270d c2270d = (C2270d) this.f20364b.d(c1875k.P());
        return c2270d != null ? c2270d.P(c1875k.S()) : d();
    }

    public Collection Q() {
        ArrayList arrayList = new ArrayList();
        C(new a(arrayList));
        return arrayList;
    }

    public boolean a(InterfaceC2275i interfaceC2275i) {
        Object obj = this.f20363a;
        if (obj != null && interfaceC2275i.a(obj)) {
            return true;
        }
        Iterator it = this.f20364b.iterator();
        while (it.hasNext()) {
            if (((C2270d) ((Map.Entry) it.next()).getValue()).a(interfaceC2275i)) {
                return true;
            }
        }
        return false;
    }

    public C1875k e(C1875k c1875k, InterfaceC2275i interfaceC2275i) {
        C1875k c1875kE;
        Object obj = this.f20363a;
        if (obj != null && interfaceC2275i.a(obj)) {
            return C1875k.O();
        }
        if (c1875k.isEmpty()) {
            return null;
        }
        C2548b c2548bP = c1875k.P();
        C2270d c2270d = (C2270d) this.f20364b.d(c2548bP);
        if (c2270d == null || (c1875kE = c2270d.e(c1875k.S(), interfaceC2275i)) == null) {
            return null;
        }
        return new C1875k(c2548bP).J(c1875kE);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2270d.class != obj.getClass()) {
            return false;
        }
        C2270d c2270d = (C2270d) obj;
        AbstractC1666c abstractC1666c = this.f20364b;
        if (abstractC1666c == null ? c2270d.f20364b != null : !abstractC1666c.equals(c2270d.f20364b)) {
            return false;
        }
        Object obj2 = this.f20363a;
        Object obj3 = c2270d.f20363a;
        return obj2 == null ? obj3 == null : obj2.equals(obj3);
    }

    public C1875k f(C1875k c1875k) {
        return e(c1875k, InterfaceC2275i.f20375a);
    }

    public Object getValue() {
        return this.f20363a;
    }

    public final Object h(C1875k c1875k, c cVar, Object obj) {
        for (Map.Entry entry : this.f20364b) {
            obj = ((C2270d) entry.getValue()).h(c1875k.K((C2548b) entry.getKey()), cVar, obj);
        }
        Object obj2 = this.f20363a;
        return obj2 != null ? cVar.a(c1875k, obj2, obj) : obj;
    }

    public int hashCode() {
        Object obj = this.f20363a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        AbstractC1666c abstractC1666c = this.f20364b;
        return iHashCode + (abstractC1666c != null ? abstractC1666c.hashCode() : 0);
    }

    public boolean isEmpty() {
        return this.f20363a == null && this.f20364b.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        ArrayList arrayList = new ArrayList();
        C(new b(arrayList));
        return arrayList.iterator();
    }

    public Object n(Object obj, c cVar) {
        return h(C1875k.O(), cVar, obj);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImmutableTree { value=");
        sb.append(getValue());
        sb.append(", children={");
        for (Map.Entry entry : this.f20364b) {
            sb.append(((C2548b) entry.getKey()).b());
            sb.append(com.amazon.a.a.o.b.f.f14101b);
            sb.append(entry.getValue());
        }
        sb.append("} }");
        return sb.toString();
    }

    public C2270d(Object obj, AbstractC1666c abstractC1666c) {
        this.f20363a = obj;
        this.f20364b = abstractC1666c;
    }
}
