package D3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final v0 f1423a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f1424b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f1425c = new ArrayList();

    public r0(v0 v0Var) {
        this.f1423a = v0Var;
    }

    public void b(G3.q qVar) {
        this.f1424b.add(qVar);
    }

    public void c(G3.q qVar, H3.p pVar) {
        this.f1425c.add(new H3.e(qVar, pVar));
    }

    public boolean d(G3.q qVar) {
        Iterator it = this.f1424b.iterator();
        while (it.hasNext()) {
            if (qVar.p((G3.q) it.next())) {
                return true;
            }
        }
        Iterator it2 = this.f1425c.iterator();
        while (it2.hasNext()) {
            if (qVar.p(((H3.e) it2.next()).a())) {
                return true;
            }
        }
        return false;
    }

    public List e() {
        return this.f1425c;
    }

    public s0 f() {
        return new s0(this, G3.q.f2456c, false, null);
    }

    public t0 g(G3.s sVar) {
        return new t0(sVar, H3.d.b(this.f1424b), Collections.unmodifiableList(this.f1425c));
    }

    public t0 h(G3.s sVar, H3.d dVar) {
        ArrayList arrayList = new ArrayList();
        for (H3.e eVar : this.f1425c) {
            if (dVar.a(eVar.a())) {
                arrayList.add(eVar);
            }
        }
        return new t0(sVar, dVar, Collections.unmodifiableList(arrayList));
    }

    public t0 i(G3.s sVar) {
        return new t0(sVar, null, Collections.unmodifiableList(this.f1425c));
    }

    public u0 j(G3.s sVar) {
        return new u0(sVar, H3.d.b(this.f1424b), Collections.unmodifiableList(this.f1425c));
    }
}
