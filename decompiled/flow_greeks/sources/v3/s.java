package v3;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class s implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f23132a = Collections.newSetFromMap(new WeakHashMap());

    @Override // v3.l
    public void a() {
        Iterator it = c4.l.j(this.f23132a).iterator();
        while (it.hasNext()) {
            ((z3.d) it.next()).a();
        }
    }

    @Override // v3.l
    public void e() {
        Iterator it = c4.l.j(this.f23132a).iterator();
        while (it.hasNext()) {
            ((z3.d) it.next()).e();
        }
    }

    @Override // v3.l
    public void h() {
        Iterator it = c4.l.j(this.f23132a).iterator();
        while (it.hasNext()) {
            ((z3.d) it.next()).h();
        }
    }

    public void l() {
        this.f23132a.clear();
    }

    public List m() {
        return c4.l.j(this.f23132a);
    }

    public void n(z3.d dVar) {
        this.f23132a.add(dVar);
    }

    public void o(z3.d dVar) {
        this.f23132a.remove(dVar);
    }
}
