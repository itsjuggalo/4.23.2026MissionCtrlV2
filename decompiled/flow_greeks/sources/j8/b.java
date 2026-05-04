package j8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m8.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Iterable {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final b f13949b = new b(new m8.d(null));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m8.d f13950a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f13951a;

        public a(l lVar) {
            this.f13951a = lVar;
        }

        @Override // m8.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public b a(l lVar, r8.n nVar, b bVar) {
            return bVar.a(this.f13951a.u(lVar), nVar);
        }
    }

    /* JADX INFO: renamed from: j8.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class C0245b implements d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Map f13953a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f13954b;

        public C0245b(Map map, boolean z10) {
            this.f13953a = map;
            this.f13954b = z10;
        }

        @Override // m8.d.c
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(l lVar, r8.n nVar, Void r42) {
            this.f13953a.put(lVar.T(), nVar.N(this.f13954b));
            return null;
        }
    }

    public b(m8.d dVar) {
        this.f13950a = dVar;
    }

    public static b q() {
        return f13949b;
    }

    public static b r(Map map) {
        m8.d dVarC = m8.d.c();
        for (Map.Entry entry : map.entrySet()) {
            dVarC = dVarC.G((l) entry.getKey(), new m8.d((r8.n) entry.getValue()));
        }
        return new b(dVarC);
    }

    public static b s(Map map) {
        m8.d dVarC = m8.d.c();
        for (Map.Entry entry : map.entrySet()) {
            dVarC = dVarC.G(new l((String) entry.getKey()), new m8.d(r8.o.a(entry.getValue())));
        }
        return new b(dVarC);
    }

    public b A(l lVar) {
        return lVar.isEmpty() ? f13949b : new b(this.f13950a.G(lVar, m8.d.c()));
    }

    public r8.n G() {
        return (r8.n) this.f13950a.getValue();
    }

    public b a(l lVar, r8.n nVar) {
        if (lVar.isEmpty()) {
            return new b(new m8.d(nVar));
        }
        l lVarE = this.f13950a.e(lVar);
        if (lVarE == null) {
            return new b(this.f13950a.G(lVar, new m8.d(nVar)));
        }
        l lVarR = l.R(lVarE, lVar);
        r8.n nVar2 = (r8.n) this.f13950a.q(lVarE);
        r8.b bVarA = lVarR.A();
        if (bVarA != null && bVarA.s() && nVar2.O(lVarR.L()).isEmpty()) {
            return this;
        }
        return new b(this.f13950a.A(lVarE, nVar2.I(lVarR, nVar)));
    }

    public b c(r8.b bVar, r8.n nVar) {
        return a(new l(bVar), nVar);
    }

    public b d(l lVar, b bVar) {
        return (b) bVar.f13950a.g(this, new a(lVar));
    }

    public r8.n e(r8.n nVar) {
        return f(l.G(), this.f13950a, nVar);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != b.class) {
            return false;
        }
        return ((b) obj).w(true).equals(w(true));
    }

    public final r8.n f(l lVar, m8.d dVar, r8.n nVar) {
        if (dVar.getValue() != null) {
            return nVar.I(lVar, (r8.n) dVar.getValue());
        }
        r8.n nVar2 = null;
        for (Map.Entry entry : dVar.s()) {
            m8.d dVar2 = (m8.d) entry.getValue();
            r8.b bVar = (r8.b) entry.getKey();
            if (bVar.s()) {
                m8.m.g(dVar2.getValue() != null, "Priority writes must always be leaf nodes");
                nVar2 = (r8.n) dVar2.getValue();
            } else {
                nVar = f(lVar.v(bVar), dVar2, nVar);
            }
        }
        return (nVar.O(lVar).isEmpty() || nVar2 == null) ? nVar : nVar.I(lVar.v(r8.b.m()), nVar2);
    }

    public b g(l lVar) {
        if (lVar.isEmpty()) {
            return this;
        }
        r8.n nVarV = v(lVar);
        return nVarV != null ? new b(new m8.d(nVarV)) : new b(this.f13950a.K(lVar));
    }

    public int hashCode() {
        return w(true).hashCode();
    }

    public boolean isEmpty() {
        return this.f13950a.isEmpty();
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f13950a.iterator();
    }

    public Map p() {
        HashMap map = new HashMap();
        for (Map.Entry entry : this.f13950a.s()) {
            map.put((r8.b) entry.getKey(), new b((m8.d) entry.getValue()));
        }
        return map;
    }

    public String toString() {
        return "CompoundWrite{" + w(true).toString() + "}";
    }

    public List u() {
        ArrayList arrayList = new ArrayList();
        if (this.f13950a.getValue() != null) {
            for (r8.m mVar : (r8.n) this.f13950a.getValue()) {
                arrayList.add(new r8.m(mVar.c(), mVar.d()));
            }
        } else {
            for (Map.Entry entry : this.f13950a.s()) {
                m8.d dVar = (m8.d) entry.getValue();
                if (dVar.getValue() != null) {
                    arrayList.add(new r8.m((r8.b) entry.getKey(), (r8.n) dVar.getValue()));
                }
            }
        }
        return arrayList;
    }

    public r8.n v(l lVar) {
        l lVarE = this.f13950a.e(lVar);
        if (lVarE != null) {
            return ((r8.n) this.f13950a.q(lVarE)).O(l.R(lVarE, lVar));
        }
        return null;
    }

    public Map w(boolean z10) {
        HashMap map = new HashMap();
        this.f13950a.p(new C0245b(map, z10));
        return map;
    }

    public boolean y(l lVar) {
        return v(lVar) != null;
    }
}
