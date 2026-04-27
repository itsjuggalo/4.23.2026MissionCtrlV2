package K4;

import a5.AbstractC0317y;
import a5.C0307n;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class c extends a {
    private final I4.i _context;
    private transient I4.d intercepted;

    public c(I4.d dVar, I4.i iVar) {
        super(dVar);
        this._context = iVar;
    }

    @Override // I4.d
    public I4.i getContext() {
        I4.i iVar = this._context;
        kotlin.jvm.internal.j.b(iVar);
        return iVar;
    }

    public final I4.d intercepted() {
        I4.d dVar = this.intercepted;
        if (dVar != null) {
            return dVar;
        }
        I4.f fVar = (I4.f) getContext().get(I4.e.f649a);
        I4.d fVar2 = fVar != null ? new f5.f((AbstractC0317y) fVar, this) : this;
        this.intercepted = fVar2;
        return fVar2;
    }

    @Override // K4.a
    public void releaseIntercepted() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        I4.d dVar = this.intercepted;
        if (dVar != null && dVar != this) {
            I4.g gVar = getContext().get(I4.e.f649a);
            kotlin.jvm.internal.j.b(gVar);
            f5.f fVar = (f5.f) dVar;
            do {
                atomicReferenceFieldUpdater = f5.f.f6506l;
            } while (atomicReferenceFieldUpdater.get(fVar) == f5.a.f6497c);
            Object obj = atomicReferenceFieldUpdater.get(fVar);
            C0307n c0307n = obj instanceof C0307n ? (C0307n) obj : null;
            if (c0307n != null) {
                c0307n.n();
            }
        }
        this.intercepted = b.f1011a;
    }

    public c(I4.d dVar) {
        this(dVar, dVar != null ? dVar.getContext() : null);
    }
}
