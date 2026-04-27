package H5;

import H5.g;
import Q5.o;
import java.io.Serializable;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements g, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f2665a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g.b f2666b;

    public static final class a extends s implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f2667a = new a();

        public a() {
            super(2);
        }

        @Override // Q5.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final String invoke(String acc, g.b element) {
            r.f(acc, "acc");
            r.f(element, "element");
            if (acc.length() == 0) {
                return element.toString();
            }
            return acc + ", " + element;
        }
    }

    public c(g left, g.b element) {
        r.f(left, "left");
        r.f(element, "element");
        this.f2665a = left;
        this.f2666b = element;
    }

    private final int c() {
        int i7 = 2;
        c cVar = this;
        while (true) {
            g gVar = cVar.f2665a;
            cVar = gVar instanceof c ? (c) gVar : null;
            if (cVar == null) {
                return i7;
            }
            i7++;
        }
    }

    public final boolean a(g.b bVar) {
        return r.b(get(bVar.getKey()), bVar);
    }

    public final boolean b(c cVar) {
        while (a(cVar.f2666b)) {
            g gVar = cVar.f2665a;
            if (!(gVar instanceof c)) {
                r.d(gVar, "null cannot be cast to non-null type kotlin.coroutines.CoroutineContext.Element");
                return a((g.b) gVar);
            }
            cVar = (c) gVar;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if (cVar.c() != c() || !cVar.b(this)) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // H5.g
    public Object fold(Object obj, o operation) {
        r.f(operation, "operation");
        return operation.invoke(this.f2665a.fold(obj, operation), this.f2666b);
    }

    @Override // H5.g
    public g.b get(g.c key) {
        r.f(key, "key");
        c cVar = this;
        while (true) {
            g.b bVar = cVar.f2666b.get(key);
            if (bVar != null) {
                return bVar;
            }
            g gVar = cVar.f2665a;
            if (!(gVar instanceof c)) {
                return gVar.get(key);
            }
            cVar = (c) gVar;
        }
    }

    public int hashCode() {
        return this.f2665a.hashCode() + this.f2666b.hashCode();
    }

    @Override // H5.g
    public g minusKey(g.c key) {
        r.f(key, "key");
        if (this.f2666b.get(key) != null) {
            return this.f2665a;
        }
        g gVarMinusKey = this.f2665a.minusKey(key);
        return gVarMinusKey == this.f2665a ? this : gVarMinusKey == h.f2671a ? this.f2666b : new c(gVarMinusKey, this.f2666b);
    }

    @Override // H5.g
    public g plus(g gVar) {
        return g.a.a(this, gVar);
    }

    public String toString() {
        return '[' + ((String) fold("", a.f2667a)) + ']';
    }
}
