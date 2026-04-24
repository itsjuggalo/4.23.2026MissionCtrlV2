package Z2;

import Z2.i;
import i3.o;
import java.io.Serializable;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements i, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f6008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i.b f6009b;

    public d(i left, i.b element) {
        r.f(left, "left");
        r.f(element, "element");
        this.f6008a = left;
        this.f6009b = element;
    }

    private final int d() {
        int i4 = 2;
        d dVar = this;
        while (true) {
            i iVar = dVar.f6008a;
            dVar = iVar instanceof d ? (d) iVar : null;
            if (dVar == null) {
                return i4;
            }
            i4++;
        }
    }

    public static final String g(String acc, i.b element) {
        r.f(acc, "acc");
        r.f(element, "element");
        if (acc.length() == 0) {
            return element.toString();
        }
        return acc + ", " + element;
    }

    public final boolean b(i.b bVar) {
        return r.b(get(bVar.getKey()), bVar);
    }

    public final boolean c(d dVar) {
        while (b(dVar.f6009b)) {
            i iVar = dVar.f6008a;
            if (!(iVar instanceof d)) {
                r.d(iVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return b((i.b) iVar);
            }
            dVar = (d) iVar;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return dVar.d() == d() && dVar.c(this);
    }

    @Override // Z2.i
    public Object fold(Object obj, o operation) {
        r.f(operation, "operation");
        return operation.invoke(this.f6008a.fold(obj, operation), this.f6009b);
    }

    @Override // Z2.i
    public i.b get(i.c key) {
        r.f(key, "key");
        d dVar = this;
        while (true) {
            i.b bVar = dVar.f6009b.get(key);
            if (bVar != null) {
                return bVar;
            }
            i iVar = dVar.f6008a;
            if (!(iVar instanceof d)) {
                return iVar.get(key);
            }
            dVar = (d) iVar;
        }
    }

    public int hashCode() {
        return this.f6008a.hashCode() + this.f6009b.hashCode();
    }

    @Override // Z2.i
    public i minusKey(i.c key) {
        r.f(key, "key");
        if (this.f6009b.get(key) != null) {
            return this.f6008a;
        }
        i iVarMinusKey = this.f6008a.minusKey(key);
        return iVarMinusKey == this.f6008a ? this : iVarMinusKey == j.f6012a ? this.f6009b : new d(iVarMinusKey, this.f6009b);
    }

    @Override // Z2.i
    public i plus(i iVar) {
        return i.a.b(this, iVar);
    }

    public String toString() {
        return '[' + ((String) fold("", new o() { // from class: Z2.c
            @Override // i3.o
            public final Object invoke(Object obj, Object obj2) {
                return d.g((String) obj, (i.b) obj2);
            }
        })) + ']';
    }
}
