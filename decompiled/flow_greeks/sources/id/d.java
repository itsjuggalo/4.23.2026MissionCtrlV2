package id;

import gd.i;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d extends a {
    private final gd.i _context;
    private transient gd.e intercepted;

    public d(gd.e eVar, gd.i iVar) {
        super(eVar);
        this._context = iVar;
    }

    @Override // gd.e
    public gd.i getContext() {
        gd.i iVar = this._context;
        t.c(iVar);
        return iVar;
    }

    public final gd.e intercepted() {
        gd.e eVarR = this.intercepted;
        if (eVarR == null) {
            gd.f fVar = (gd.f) getContext().get(gd.f.K);
            if (fVar == null || (eVarR = fVar.R(this)) == null) {
                eVarR = this;
            }
            this.intercepted = eVarR;
        }
        return eVarR;
    }

    @Override // id.a
    public void releaseIntercepted() {
        gd.e eVar = this.intercepted;
        if (eVar != null && eVar != this) {
            i.b bVar = getContext().get(gd.f.K);
            t.c(bVar);
            ((gd.f) bVar).O(eVar);
        }
        this.intercepted = c.f12282a;
    }

    public d(gd.e eVar) {
        this(eVar, eVar != null ? eVar.getContext() : null);
    }
}
