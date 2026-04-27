package S5;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;
import p5.z;

/* JADX INFO: loaded from: classes2.dex */
public final class o implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f7675a;

    public o(List delegates) {
        AbstractC2304t.f(delegates, "delegates");
        this.f7675a = delegates;
    }

    public static final c e(q6.c cVar, h it) {
        AbstractC2304t.f(it, "it");
        return it.b(cVar);
    }

    public static final U6.h f(h it) {
        AbstractC2304t.f(it, "it");
        return z.P(it);
    }

    @Override // S5.h
    public c b(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        return (c) U6.r.y(U6.r.C(z.P(this.f7675a), new m(fqName)));
    }

    @Override // S5.h
    public boolean isEmpty() {
        List list = this.f7675a;
        if ((list instanceof Collection) && list.isEmpty()) {
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
        return U6.r.z(z.P(this.f7675a), n.f7674a).iterator();
    }

    @Override // S5.h
    public boolean r(q6.c fqName) {
        AbstractC2304t.f(fqName, "fqName");
        Iterator it = z.P(this.f7675a).iterator();
        while (it.hasNext()) {
            if (((h) it.next()).r(fqName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public o(h... delegates) {
        this(AbstractC2592n.k0(delegates));
        AbstractC2304t.f(delegates, "delegates");
    }
}
