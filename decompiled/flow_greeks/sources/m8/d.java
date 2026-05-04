package m8;

import g8.c;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements Iterable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g8.c f16086c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final d f16087d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f16088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g8.c f16089b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ArrayList f16090a;

        public a(ArrayList arrayList) {
            this.f16090a = arrayList;
        }

        @Override // m8.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(j8.l lVar, Object obj, Void r32) {
            this.f16090a.add(obj);
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ List f16092a;

        public b(List list) {
            this.f16092a = list;
        }

        @Override // m8.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(j8.l lVar, Object obj, Void r42) {
            this.f16092a.add(new AbstractMap.SimpleImmutableEntry(lVar, obj));
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c {
        Object a(j8.l lVar, Object obj, Object obj2);
    }

    static {
        g8.c cVarC = c.a.c(g8.l.b(r8.b.class));
        f16086c = cVarC;
        f16087d = new d(null, cVarC);
    }

    public d(Object obj, g8.c cVar) {
        this.f16088a = obj;
        this.f16089b = cVar;
    }

    public static d c() {
        return f16087d;
    }

    public d A(j8.l lVar, Object obj) {
        if (lVar.isEmpty()) {
            return new d(obj, this.f16089b);
        }
        r8.b bVarK = lVar.K();
        d dVarC = (d) this.f16089b.c(bVarK);
        if (dVarC == null) {
            dVarC = c();
        }
        return new d(this.f16088a, this.f16089b.q(bVarK, dVarC.A(lVar.S(), obj)));
    }

    public d G(j8.l lVar, d dVar) {
        if (lVar.isEmpty()) {
            return dVar;
        }
        r8.b bVarK = lVar.K();
        d dVarC = (d) this.f16089b.c(bVarK);
        if (dVarC == null) {
            dVarC = c();
        }
        d dVarG = dVarC.G(lVar.S(), dVar);
        return new d(this.f16088a, dVarG.isEmpty() ? this.f16089b.s(bVarK) : this.f16089b.q(bVarK, dVarG));
    }

    public d K(j8.l lVar) {
        if (lVar.isEmpty()) {
            return this;
        }
        d dVar = (d) this.f16089b.c(lVar.K());
        return dVar != null ? dVar.K(lVar.S()) : c();
    }

    public Collection L() {
        ArrayList arrayList = new ArrayList();
        p(new a(arrayList));
        return arrayList;
    }

    public boolean a(i iVar) {
        Object obj = this.f16088a;
        if (obj != null && iVar.a(obj)) {
            return true;
        }
        Iterator it = this.f16089b.iterator();
        while (it.hasNext()) {
            if (((d) ((Map.Entry) it.next()).getValue()).a(iVar)) {
                return true;
            }
        }
        return false;
    }

    public j8.l d(j8.l lVar, i iVar) {
        j8.l lVarD;
        Object obj = this.f16088a;
        if (obj != null && iVar.a(obj)) {
            return j8.l.G();
        }
        if (lVar.isEmpty()) {
            return null;
        }
        r8.b bVarK = lVar.K();
        d dVar = (d) this.f16089b.c(bVarK);
        if (dVar == null || (lVarD = dVar.d(lVar.S(), iVar)) == null) {
            return null;
        }
        return new j8.l(bVarK).u(lVarD);
    }

    public j8.l e(j8.l lVar) {
        return d(lVar, i.f16100a);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        g8.c cVar = this.f16089b;
        if (cVar == null ? dVar.f16089b != null : !cVar.equals(dVar.f16089b)) {
            return false;
        }
        Object obj2 = this.f16088a;
        Object obj3 = dVar.f16088a;
        return obj2 == null ? obj3 == null : obj2.equals(obj3);
    }

    public final Object f(j8.l lVar, c cVar, Object obj) {
        for (Map.Entry entry : this.f16089b) {
            obj = ((d) entry.getValue()).f(lVar.v((r8.b) entry.getKey()), cVar, obj);
        }
        Object obj2 = this.f16088a;
        return obj2 != null ? cVar.a(lVar, obj2, obj) : obj;
    }

    public Object g(Object obj, c cVar) {
        return f(j8.l.G(), cVar, obj);
    }

    public Object getValue() {
        return this.f16088a;
    }

    public int hashCode() {
        Object obj = this.f16088a;
        int iHashCode = (obj != null ? obj.hashCode() : 0) * 31;
        g8.c cVar = this.f16089b;
        return iHashCode + (cVar != null ? cVar.hashCode() : 0);
    }

    public boolean isEmpty() {
        return this.f16088a == null && this.f16089b.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        ArrayList arrayList = new ArrayList();
        p(new b(arrayList));
        return arrayList.iterator();
    }

    public void p(c cVar) {
        f(j8.l.G(), cVar, null);
    }

    public Object q(j8.l lVar) {
        if (lVar.isEmpty()) {
            return this.f16088a;
        }
        d dVar = (d) this.f16089b.c(lVar.K());
        if (dVar != null) {
            return dVar.q(lVar.S());
        }
        return null;
    }

    public d r(r8.b bVar) {
        d dVar = (d) this.f16089b.c(bVar);
        return dVar != null ? dVar : c();
    }

    public g8.c s() {
        return this.f16089b;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ImmutableTree { value=");
        sb2.append(getValue());
        sb2.append(", children={");
        for (Map.Entry entry : this.f16089b) {
            sb2.append(((r8.b) entry.getKey()).b());
            sb2.append(com.amazon.a.a.o.b.f.f4599b);
            sb2.append(entry.getValue());
        }
        sb2.append("} }");
        return sb2.toString();
    }

    public Object u(j8.l lVar) {
        return v(lVar, i.f16100a);
    }

    public Object v(j8.l lVar, i iVar) {
        Object obj = this.f16088a;
        Object obj2 = (obj == null || !iVar.a(obj)) ? null : this.f16088a;
        Iterator it = lVar.iterator();
        d dVar = this;
        while (it.hasNext()) {
            dVar = (d) dVar.f16089b.c((r8.b) it.next());
            if (dVar == null) {
                break;
            }
            Object obj3 = dVar.f16088a;
            if (obj3 != null && iVar.a(obj3)) {
                obj2 = dVar.f16088a;
            }
        }
        return obj2;
    }

    public d w(j8.l lVar) {
        if (lVar.isEmpty()) {
            return this.f16089b.isEmpty() ? c() : new d(null, this.f16089b);
        }
        r8.b bVarK = lVar.K();
        d dVar = (d) this.f16089b.c(bVarK);
        if (dVar == null) {
            return this;
        }
        d dVarW = dVar.w(lVar.S());
        g8.c cVarS = dVarW.isEmpty() ? this.f16089b.s(bVarK) : this.f16089b.q(bVarK, dVarW);
        return (this.f16088a == null && cVarS.isEmpty()) ? c() : new d(this.f16088a, cVarS);
    }

    public Object y(j8.l lVar, i iVar) {
        Object obj = this.f16088a;
        if (obj != null && iVar.a(obj)) {
            return this.f16088a;
        }
        Iterator it = lVar.iterator();
        d dVar = this;
        while (it.hasNext()) {
            dVar = (d) dVar.f16089b.c((r8.b) it.next());
            if (dVar == null) {
                return null;
            }
            Object obj2 = dVar.f16088a;
            if (obj2 != null && iVar.a(obj2)) {
                return dVar.f16088a;
            }
        }
        return null;
    }

    public d(Object obj) {
        this(obj, f16086c);
    }
}
