package i9;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public g8.e f12090a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public g8.e f12091b;

    public n1() {
        List list = Collections.EMPTY_LIST;
        this.f12090a = new g8.e(list, e.f11901c);
        this.f12091b = new g8.e(list, e.f11902d);
    }

    public void a(j9.k kVar, int i10) {
        e eVar = new e(kVar, i10);
        this.f12090a = this.f12090a.e(eVar);
        this.f12091b = this.f12091b.e(eVar);
    }

    public void b(g8.e eVar, int i10) {
        Iterator it = eVar.iterator();
        while (it.hasNext()) {
            a((j9.k) it.next(), i10);
        }
    }

    public boolean c(j9.k kVar) {
        Iterator itF = this.f12090a.f(new e(kVar, 0));
        if (itF.hasNext()) {
            return ((e) itF.next()).d().equals(kVar);
        }
        return false;
    }

    public g8.e d(int i10) {
        Iterator itF = this.f12091b.f(new e(j9.k.c(), i10));
        g8.e eVarH = j9.k.h();
        while (itF.hasNext()) {
            e eVar = (e) itF.next();
            if (eVar.c() != i10) {
                break;
            }
            eVarH = eVarH.e(eVar.d());
        }
        return eVarH;
    }

    public final void e(e eVar) {
        this.f12090a = this.f12090a.g(eVar);
        this.f12091b = this.f12091b.g(eVar);
    }

    public void f(j9.k kVar, int i10) {
        e(new e(kVar, i10));
    }

    public void g(g8.e eVar, int i10) {
        Iterator it = eVar.iterator();
        while (it.hasNext()) {
            f((j9.k) it.next(), i10);
        }
    }

    public g8.e h(int i10) {
        Iterator itF = this.f12091b.f(new e(j9.k.c(), i10));
        g8.e eVarH = j9.k.h();
        while (itF.hasNext()) {
            e eVar = (e) itF.next();
            if (eVar.c() != i10) {
                break;
            }
            eVarH = eVarH.e(eVar.d());
            e(eVar);
        }
        return eVarH;
    }
}
