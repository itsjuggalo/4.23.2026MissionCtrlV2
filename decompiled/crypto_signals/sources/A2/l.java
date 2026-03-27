package A2;

import java.util.Comparator;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class l extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f59a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Comparator f60b;

    public l(h hVar, Comparator comparator) {
        this.f59a = hVar;
        this.f60b = comparator;
    }

    @Override // A2.c
    public final boolean a(Object obj) {
        return o(obj) != null;
    }

    @Override // A2.c
    public final Object b(Q2.h hVar) {
        h hVarO = o(hVar);
        if (hVarO != null) {
            return hVarO.getValue();
        }
        return null;
    }

    @Override // A2.c
    public final Comparator c() {
        return this.f60b;
    }

    @Override // A2.c
    public final Object f() {
        return this.f59a.h().getKey();
    }

    @Override // A2.c
    public final Object h() {
        return this.f59a.g().getKey();
    }

    @Override // A2.c
    public final boolean isEmpty() {
        return this.f59a.isEmpty();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new d(this.f59a, null, this.f60b);
    }

    @Override // A2.c
    public final int k(Q2.k kVar) {
        h hVarA = this.f59a;
        int i = 0;
        while (!hVarA.isEmpty()) {
            int iCompare = this.f60b.compare(kVar, hVarA.getKey());
            if (iCompare == 0) {
                return hVarA.a().size() + i;
            }
            if (iCompare < 0) {
                hVarA = hVarA.a();
            } else {
                int size = hVarA.a().size() + 1 + i;
                hVarA = hVarA.d();
                i = size;
            }
        }
        return -1;
    }

    @Override // A2.c
    public final c l(Object obj, Object obj2) {
        h hVar = this.f59a;
        Comparator comparator = this.f60b;
        return new l(((j) hVar.b(obj, obj2, comparator)).f(2, null, null), comparator);
    }

    @Override // A2.c
    public final Iterator m(Object obj) {
        return new d(this.f59a, obj, this.f60b);
    }

    @Override // A2.c
    public final c n(Object obj) {
        if (!a(obj)) {
            return this;
        }
        h hVar = this.f59a;
        Comparator comparator = this.f60b;
        return new l(hVar.e(obj, comparator).f(2, null, null), comparator);
    }

    public final h o(Object obj) {
        h hVarA = this.f59a;
        while (!hVarA.isEmpty()) {
            int iCompare = this.f60b.compare(obj, hVarA.getKey());
            if (iCompare < 0) {
                hVarA = hVarA.a();
            } else {
                if (iCompare == 0) {
                    return hVarA;
                }
                hVarA = hVarA.d();
            }
        }
        return null;
    }

    @Override // A2.c
    public final int size() {
        return this.f59a.size();
    }
}
