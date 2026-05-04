package we;

import ge.h;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f implements ge.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ef.c f23959a;

    public f(ef.c fqNameToMatch) {
        kotlin.jvm.internal.t.f(fqNameToMatch, "fqNameToMatch");
        this.f23959a = fqNameToMatch;
    }

    @Override // ge.h
    public boolean E(ef.c cVar) {
        return h.b.b(this, cVar);
    }

    @Override // ge.h
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e b(ef.c fqName) {
        kotlin.jvm.internal.t.f(fqName, "fqName");
        if (kotlin.jvm.internal.t.b(fqName, this.f23959a)) {
            return e.f23952a;
        }
        return null;
    }

    @Override // ge.h
    public boolean isEmpty() {
        return false;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return dd.r.k().iterator();
    }
}
