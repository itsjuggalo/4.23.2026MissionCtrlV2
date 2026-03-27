package I4;

import R4.p;
import java.io.Serializable;

/* JADX INFO: loaded from: classes.dex */
public final class c implements i, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i f647a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f648b;

    public c(g element, i left) {
        kotlin.jvm.internal.j.e(left, "left");
        kotlin.jvm.internal.j.e(element, "element");
        this.f647a = left;
        this.f648b = element;
    }

    public final boolean equals(Object obj) {
        boolean zA;
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            cVar.getClass();
            int i = 2;
            c cVar2 = cVar;
            int i6 = 2;
            while (true) {
                i iVar = cVar2.f647a;
                cVar2 = iVar instanceof c ? (c) iVar : null;
                if (cVar2 == null) {
                    break;
                }
                i6++;
            }
            c cVar3 = this;
            while (true) {
                i iVar2 = cVar3.f647a;
                cVar3 = iVar2 instanceof c ? (c) iVar2 : null;
                if (cVar3 == null) {
                    break;
                }
                i++;
            }
            if (i6 == i) {
                c cVar4 = this;
                while (true) {
                    g gVar = cVar4.f648b;
                    if (!kotlin.jvm.internal.j.a(cVar.get(gVar.getKey()), gVar)) {
                        zA = false;
                        break;
                    }
                    i iVar3 = cVar4.f647a;
                    if (!(iVar3 instanceof c)) {
                        kotlin.jvm.internal.j.c(iVar3, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                        g gVar2 = (g) iVar3;
                        zA = kotlin.jvm.internal.j.a(cVar.get(gVar2.getKey()), gVar2);
                        break;
                    }
                    cVar4 = (c) iVar3;
                }
                if (zA) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // I4.i
    public final Object fold(Object obj, p pVar) {
        return pVar.invoke(this.f647a.fold(obj, pVar), this.f648b);
    }

    @Override // I4.i
    public final g get(h key) {
        kotlin.jvm.internal.j.e(key, "key");
        c cVar = this;
        while (true) {
            g gVar = cVar.f648b.get(key);
            if (gVar != null) {
                return gVar;
            }
            i iVar = cVar.f647a;
            if (!(iVar instanceof c)) {
                return iVar.get(key);
            }
            cVar = (c) iVar;
        }
    }

    public final int hashCode() {
        return this.f648b.hashCode() + this.f647a.hashCode();
    }

    @Override // I4.i
    public final i minusKey(h key) {
        kotlin.jvm.internal.j.e(key, "key");
        g gVar = this.f648b;
        g gVar2 = gVar.get(key);
        i iVar = this.f647a;
        if (gVar2 != null) {
            return iVar;
        }
        i iVarMinusKey = iVar.minusKey(key);
        return iVarMinusKey == iVar ? this : iVarMinusKey == j.f650a ? gVar : new c(gVar, iVarMinusKey);
    }

    @Override // I4.i
    public final i plus(i context) {
        kotlin.jvm.internal.j.e(context, "context");
        return context == j.f650a ? this : (i) context.fold(this, new b(1));
    }

    public final String toString() {
        return "[" + ((String) fold("", new b(0))) + ']';
    }
}
