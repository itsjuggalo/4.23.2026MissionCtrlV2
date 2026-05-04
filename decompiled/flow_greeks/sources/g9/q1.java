package g9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class q1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u1 f10354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set f10355b = new HashSet();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f10356c = new ArrayList();

    public q1(u1 u1Var) {
        this.f10354a = u1Var;
    }

    public void b(j9.q qVar) {
        this.f10355b.add(qVar);
    }

    public void c(j9.q qVar, k9.p pVar) {
        this.f10356c.add(new k9.e(qVar, pVar));
    }

    public boolean d(j9.q qVar) {
        Iterator it = this.f10355b.iterator();
        while (it.hasNext()) {
            if (qVar.s((j9.q) it.next())) {
                return true;
            }
        }
        Iterator it2 = this.f10356c.iterator();
        while (it2.hasNext()) {
            if (qVar.s(((k9.e) it2.next()).a())) {
                return true;
            }
        }
        return false;
    }

    public List e() {
        return this.f10356c;
    }

    public r1 f() {
        return new r1(this, j9.q.f14257c, false, null);
    }

    public s1 g(j9.s sVar) {
        return new s1(sVar, k9.d.b(this.f10355b), Collections.unmodifiableList(this.f10356c));
    }

    public s1 h(j9.s sVar, k9.d dVar) {
        ArrayList arrayList = new ArrayList();
        for (k9.e eVar : this.f10356c) {
            if (dVar.a(eVar.a())) {
                arrayList.add(eVar);
            }
        }
        return new s1(sVar, dVar, Collections.unmodifiableList(arrayList));
    }

    public s1 i(j9.s sVar) {
        return new s1(sVar, null, Collections.unmodifiableList(this.f10356c));
    }

    public t1 j(j9.s sVar) {
        return new t1(sVar, k9.d.b(this.f10355b), Collections.unmodifiableList(this.f10356c));
    }
}
