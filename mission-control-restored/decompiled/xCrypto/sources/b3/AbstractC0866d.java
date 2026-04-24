package b3;

import Z2.i;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: b3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0866d extends AbstractC0863a {
    private final Z2.i _context;
    private transient Z2.e intercepted;

    public AbstractC0866d(Z2.e eVar, Z2.i iVar) {
        super(eVar);
        this._context = iVar;
    }

    @Override // Z2.e
    public Z2.i getContext() {
        Z2.i iVar = this._context;
        r.c(iVar);
        return iVar;
    }

    public final Z2.e intercepted() {
        Z2.e eVarJ = this.intercepted;
        if (eVarJ == null) {
            Z2.f fVar = (Z2.f) getContext().get(Z2.f.f6010J);
            if (fVar == null || (eVarJ = fVar.J(this)) == null) {
                eVarJ = this;
            }
            this.intercepted = eVarJ;
        }
        return eVarJ;
    }

    @Override // b3.AbstractC0863a
    public void releaseIntercepted() {
        Z2.e eVar = this.intercepted;
        if (eVar != null && eVar != this) {
            i.b bVar = getContext().get(Z2.f.f6010J);
            r.c(bVar);
            ((Z2.f) bVar).S(eVar);
        }
        this.intercepted = C0865c.f8284a;
    }

    public AbstractC0866d(Z2.e eVar) {
        this(eVar, eVar != null ? eVar.getContext() : null);
    }
}
