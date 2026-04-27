package F3;

import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: renamed from: F3.o0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0520o0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r3.e f2229a = new r3.e(Collections.emptyList(), C0489e.f2134c);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r3.e f2230b = new r3.e(Collections.emptyList(), C0489e.f2135d);

    public void a(G3.k kVar, int i7) {
        C0489e c0489e = new C0489e(kVar, i7);
        this.f2229a = this.f2229a.c(c0489e);
        this.f2230b = this.f2230b.c(c0489e);
    }

    public void b(r3.e eVar, int i7) {
        Iterator it = eVar.iterator();
        while (it.hasNext()) {
            a((G3.k) it.next(), i7);
        }
    }

    public boolean c(G3.k kVar) {
        Iterator itG = this.f2229a.g(new C0489e(kVar, 0));
        if (itG.hasNext()) {
            return ((C0489e) itG.next()).d().equals(kVar);
        }
        return false;
    }

    public r3.e d(int i7) {
        Iterator itG = this.f2230b.g(new C0489e(G3.k.c(), i7));
        r3.e eVarH = G3.k.h();
        while (itG.hasNext()) {
            C0489e c0489e = (C0489e) itG.next();
            if (c0489e.c() != i7) {
                break;
            }
            eVarH = eVarH.c(c0489e.d());
        }
        return eVarH;
    }

    public final void e(C0489e c0489e) {
        this.f2229a = this.f2229a.h(c0489e);
        this.f2230b = this.f2230b.h(c0489e);
    }

    public void f(G3.k kVar, int i7) {
        e(new C0489e(kVar, i7));
    }

    public void g(r3.e eVar, int i7) {
        Iterator it = eVar.iterator();
        while (it.hasNext()) {
            f((G3.k) it.next(), i7);
        }
    }

    public r3.e h(int i7) {
        Iterator itG = this.f2230b.g(new C0489e(G3.k.c(), i7));
        r3.e eVarH = G3.k.h();
        while (itG.hasNext()) {
            C0489e c0489e = (C0489e) itG.next();
            if (c0489e.c() != i7) {
                break;
            }
            eVarH = eVarH.c(c0489e.d());
            e(c0489e);
        }
        return eVarH;
    }
}
