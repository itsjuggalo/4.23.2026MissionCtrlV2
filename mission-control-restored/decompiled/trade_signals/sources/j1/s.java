package j1;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;
import q1.AbstractC2629l;

/* JADX INFO: loaded from: classes.dex */
public final class s implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set f19983a = Collections.newSetFromMap(new WeakHashMap());

    @Override // j1.l
    public void a() {
        Iterator it = AbstractC2629l.j(this.f19983a).iterator();
        while (it.hasNext()) {
            ((n1.d) it.next()).a();
        }
    }

    @Override // j1.l
    public void c() {
        Iterator it = AbstractC2629l.j(this.f19983a).iterator();
        while (it.hasNext()) {
            ((n1.d) it.next()).c();
        }
    }

    @Override // j1.l
    public void f() {
        Iterator it = AbstractC2629l.j(this.f19983a).iterator();
        while (it.hasNext()) {
            ((n1.d) it.next()).f();
        }
    }

    public void l() {
        this.f19983a.clear();
    }

    public List m() {
        return AbstractC2629l.j(this.f19983a);
    }

    public void n(n1.d dVar) {
        this.f19983a.add(dVar);
    }

    public void o(n1.d dVar) {
        this.f19983a.remove(dVar);
    }
}
