package ge;

import dd.a0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class o implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10568a;

    public o(List delegates) {
        t.f(delegates, "delegates");
        this.f10568a = delegates;
    }

    public static final c e(ef.c cVar, h it) {
        t.f(it, "it");
        return it.b(cVar);
    }

    public static final jg.h f(h it) {
        t.f(it, "it");
        return a0.Q(it);
    }

    @Override // ge.h
    public boolean E(ef.c fqName) {
        t.f(fqName, "fqName");
        Iterator it = a0.Q(this.f10568a).iterator();
        while (it.hasNext()) {
            if (((h) it.next()).E(fqName)) {
                return true;
            }
        }
        return false;
    }

    @Override // ge.h
    public c b(ef.c fqName) {
        t.f(fqName, "fqName");
        return (c) jg.t.B(jg.t.F(a0.Q(this.f10568a), new m(fqName)));
    }

    @Override // ge.h
    public boolean isEmpty() {
        List list = this.f10568a;
        if (list != null && list.isEmpty()) {
            return true;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (!((h) it.next()).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return jg.t.C(a0.Q(this.f10568a), n.f10567a).iterator();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(h... delegates) {
        this(dd.n.z0(delegates));
        t.f(delegates, "delegates");
    }
}
