package qg;

import cd.h0;
import cd.r;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class v extends rg.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicReference f19205a = new AtomicReference(null);

    @Override // rg.d
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(t tVar) {
        if (sg.c.a(this.f19205a) != null) {
            return false;
        }
        sg.c.b(this.f19205a, u.f19203a);
        return true;
    }

    public final Object e(gd.e eVar) {
        ng.p pVar = new ng.p(hd.b.c(eVar), 1);
        pVar.E();
        if (!com.amazon.a.a.l.d.a(this.f19205a, u.f19203a, pVar)) {
            r.a aVar = cd.r.f3870b;
            pVar.resumeWith(cd.r.b(h0.f3852a));
        }
        Object objY = pVar.y();
        if (objY == hd.c.f()) {
            id.h.c(eVar);
        }
        return objY == hd.c.f() ? objY : h0.f3852a;
    }

    @Override // rg.d
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public gd.e[] b(t tVar) {
        sg.c.b(this.f19205a, null);
        return rg.c.f19885a;
    }

    public final void g() {
        AtomicReference atomicReference = this.f19205a;
        while (true) {
            Object objA = sg.c.a(atomicReference);
            if (objA == null || objA == u.f19204b) {
                return;
            }
            if (objA == u.f19203a) {
                if (com.amazon.a.a.l.d.a(this.f19205a, objA, u.f19204b)) {
                    return;
                }
            } else if (com.amazon.a.a.l.d.a(this.f19205a, objA, u.f19203a)) {
                r.a aVar = cd.r.f3870b;
                ((ng.p) objA).resumeWith(cd.r.b(h0.f3852a));
                return;
            }
        }
    }

    public final boolean h() {
        Object andSet = this.f19205a.getAndSet(u.f19203a);
        kotlin.jvm.internal.t.c(andSet);
        return andSet == u.f19204b;
    }
}
