package gd;

import gd.i;
import java.io.Serializable;
import kotlin.jvm.internal.t;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements i, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f10528a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i.b f10529b;

    public d(i left, i.b element) {
        t.f(left, "left");
        t.f(element, "element");
        this.f10528a = left;
        this.f10529b = element;
    }

    private final int d() {
        int i10 = 2;
        d dVar = this;
        while (true) {
            i iVar = dVar.f10528a;
            dVar = iVar instanceof d ? (d) iVar : null;
            if (dVar == null) {
                return i10;
            }
            i10++;
        }
    }

    public static final String f(String acc, i.b element) {
        t.f(acc, "acc");
        t.f(element, "element");
        if (acc.length() == 0) {
            return element.toString();
        }
        return acc + ", " + element;
    }

    public final boolean b(i.b bVar) {
        return t.b(get(bVar.getKey()), bVar);
    }

    public final boolean c(d dVar) {
        while (b(dVar.f10529b)) {
            i iVar = dVar.f10528a;
            if (!(iVar instanceof d)) {
                t.d(iVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
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

    @Override // gd.i
    public Object fold(Object obj, o operation) {
        t.f(operation, "operation");
        return operation.invoke(this.f10528a.fold(obj, operation), this.f10529b);
    }

    @Override // gd.i
    public i.b get(i.c key) {
        t.f(key, "key");
        d dVar = this;
        while (true) {
            i.b bVar = dVar.f10529b.get(key);
            if (bVar != null) {
                return bVar;
            }
            i iVar = dVar.f10528a;
            if (!(iVar instanceof d)) {
                return iVar.get(key);
            }
            dVar = (d) iVar;
        }
    }

    public int hashCode() {
        return this.f10528a.hashCode() + this.f10529b.hashCode();
    }

    @Override // gd.i
    public i minusKey(i.c key) {
        t.f(key, "key");
        if (this.f10529b.get(key) != null) {
            return this.f10528a;
        }
        i iVarMinusKey = this.f10528a.minusKey(key);
        return iVarMinusKey == this.f10528a ? this : iVarMinusKey == j.f10531a ? this.f10529b : new d(iVarMinusKey, this.f10529b);
    }

    @Override // gd.i
    public i plus(i iVar) {
        return i.a.b(this, iVar);
    }

    public String toString() {
        return '[' + ((String) fold("", new o() { // from class: gd.c
            @Override // pd.o
            public final Object invoke(Object obj, Object obj2) {
                return d.f((String) obj, (i.b) obj2);
            }
        })) + ']';
    }
}
