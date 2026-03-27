package J5;

import H5.g;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d extends a {
    private final H5.g _context;
    private transient H5.d intercepted;

    public d(H5.d dVar, H5.g gVar) {
        super(dVar);
        this._context = gVar;
    }

    @Override // H5.d
    public H5.g getContext() {
        H5.g gVar = this._context;
        r.c(gVar);
        return gVar;
    }

    public final H5.d intercepted() {
        H5.d dVarK = this.intercepted;
        if (dVarK == null) {
            H5.e eVar = (H5.e) getContext().get(H5.e.f2668J);
            if (eVar == null || (dVarK = eVar.K(this)) == null) {
                dVarK = this;
            }
            this.intercepted = dVarK;
        }
        return dVarK;
    }

    @Override // J5.a
    public void releaseIntercepted() {
        H5.d dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            g.b bVar = getContext().get(H5.e.f2668J);
            r.c(bVar);
            ((H5.e) bVar).A(dVar);
        }
        this.intercepted = c.f3330a;
    }

    public d(H5.d dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }
}
