package i9;

import j9.p;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c1 implements o1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g8.c f11882a = j9.i.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public m f11883b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class b implements Iterable {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class a implements Iterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Iterator f11885a;

            public a(Iterator it) {
                this.f11885a = it;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public j9.h next() {
                return (j9.h) ((Map.Entry) this.f11885a.next()).getValue();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f11885a.hasNext();
            }
        }

        public b() {
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return new a(c1.this.f11882a.iterator());
        }
    }

    @Override // i9.o1
    public Map a(g9.b1 b1Var, p.a aVar, Set set, i1 i1Var) {
        HashMap map = new HashMap();
        Iterator itR = this.f11882a.r(j9.k.k((j9.t) b1Var.n().b("")));
        while (itR.hasNext()) {
            Map.Entry entry = (Map.Entry) itR.next();
            j9.h hVar = (j9.h) entry.getValue();
            j9.k kVar = (j9.k) entry.getKey();
            if (!b1Var.n().s(kVar.s())) {
                break;
            }
            if (kVar.s().u() <= b1Var.n().u() + 1 && p.a.i(hVar).compareTo(aVar) > 0 && (set.contains(hVar.getKey()) || b1Var.u(hVar))) {
                map.put(hVar.getKey(), hVar.a());
            }
        }
        return map;
    }

    @Override // i9.o1
    public Map b(Iterable iterable) {
        HashMap map = new HashMap();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            j9.k kVar = (j9.k) it.next();
            map.put(kVar, f(kVar));
        }
        return map;
    }

    @Override // i9.o1
    public Map c(String str, p.a aVar, int i10) {
        throw new UnsupportedOperationException("getAll(String, IndexOffset, int) is not supported.");
    }

    @Override // i9.o1
    public void d(j9.r rVar, j9.v vVar) {
        n9.b.d(this.f11883b != null, "setIndexManager() not called", new Object[0]);
        n9.b.d(!vVar.equals(j9.v.f14278b), "Cannot add document to the RemoteDocumentCache with a read time of zero", new Object[0]);
        this.f11882a = this.f11882a.q(rVar.getKey(), rVar.a().v(vVar));
        this.f11883b.l(rVar.getKey().o());
    }

    @Override // i9.o1
    public void e(m mVar) {
        this.f11883b = mVar;
    }

    @Override // i9.o1
    public j9.r f(j9.k kVar) {
        j9.h hVar = (j9.h) this.f11882a.c(kVar);
        return hVar != null ? hVar.a() : j9.r.q(kVar);
    }

    public long h(p pVar) {
        Iterator it = new b().iterator();
        long jB = 0;
        while (it.hasNext()) {
            jB += (long) pVar.m((j9.h) it.next()).b();
        }
        return jB;
    }

    public Iterable i() {
        return new b();
    }

    @Override // i9.o1
    public void removeAll(Collection collection) {
        n9.b.d(this.f11883b != null, "setIndexManager() not called", new Object[0]);
        g8.c cVarA = j9.i.a();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            j9.k kVar = (j9.k) it.next();
            this.f11882a = this.f11882a.s(kVar);
            cVarA = cVarA.q(kVar, j9.r.r(kVar, j9.v.f14278b));
        }
        this.f11883b.h(cVarA);
    }
}
