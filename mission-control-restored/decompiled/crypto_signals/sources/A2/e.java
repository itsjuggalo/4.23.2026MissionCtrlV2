package A2;

import P2.C0204b;
import e3.w;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f51a;

    public e(List list, Comparator comparator) {
        c cVarF;
        Map map = Collections.EMPTY_MAP;
        if (list.size() < 25) {
            Collections.sort(list, comparator);
            int size = list.size();
            Object[] objArr = new Object[size];
            Object[] objArr2 = new Object[size];
            int i = 0;
            for (Object obj : list) {
                objArr[i] = obj;
                objArr2[i] = map.get(obj);
                i++;
            }
            cVarF = new b(comparator, objArr, objArr2);
        } else {
            cVarF = w.f(list, map, comparator);
        }
        this.f51a = cVarF;
    }

    public final e a(Object obj) {
        return new e(this.f51a.l(obj, null));
    }

    public final d b(C0204b c0204b) {
        return new d(this.f51a.m(c0204b));
    }

    public final e c(Object obj) {
        c cVar = this.f51a;
        c cVarN = cVar.n(obj);
        return cVarN == cVar ? this : new e(cVarN);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.f51a.equals(((e) obj).f51a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f51a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new d(this.f51a.iterator());
    }

    public e(c cVar) {
        this.f51a = cVar;
    }
}
