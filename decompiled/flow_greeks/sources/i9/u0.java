package i9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class u0 implements m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n1 f12168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b1 f12169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set f12170c;

    public u0(b1 b1Var) {
        this.f12169b = b1Var;
    }

    public final boolean a(j9.k kVar) {
        if (this.f12169b.i().k(kVar) || b(kVar)) {
            return true;
        }
        n1 n1Var = this.f12168a;
        return n1Var != null && n1Var.c(kVar);
    }

    public final boolean b(j9.k kVar) {
        Iterator it = this.f12169b.r().iterator();
        while (it.hasNext()) {
            if (((z0) it.next()).l(kVar)) {
                return true;
            }
        }
        return false;
    }

    @Override // i9.m1
    public void d(j9.k kVar) {
        this.f12170c.add(kVar);
    }

    @Override // i9.m1
    public void e(j9.k kVar) {
        this.f12170c.remove(kVar);
    }

    @Override // i9.m1
    public void g() {
        this.f12170c = new HashSet();
    }

    @Override // i9.m1
    public void h(n1 n1Var) {
        this.f12168a = n1Var;
    }

    @Override // i9.m1
    public long i() {
        return -1L;
    }

    @Override // i9.m1
    public void m(j9.k kVar) {
        if (a(kVar)) {
            this.f12170c.remove(kVar);
        } else {
            this.f12170c.add(kVar);
        }
    }

    @Override // i9.m1
    public void n(j9.k kVar) {
        this.f12170c.add(kVar);
    }

    @Override // i9.m1
    public void o(n4 n4Var) {
        d1 d1VarI = this.f12169b.i();
        Iterator it = d1VarI.f(n4Var.h()).iterator();
        while (it.hasNext()) {
            this.f12170c.add((j9.k) it.next());
        }
        d1VarI.q(n4Var);
    }

    @Override // i9.m1
    public void onTransactionCommitted() {
        c1 c1VarH = this.f12169b.h();
        ArrayList arrayList = new ArrayList();
        for (j9.k kVar : this.f12170c) {
            if (!a(kVar)) {
                arrayList.add(kVar);
            }
        }
        c1VarH.removeAll(arrayList);
        this.f12170c = null;
    }
}
