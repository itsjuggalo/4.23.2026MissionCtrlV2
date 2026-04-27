package Q2;

import U2.r;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class e implements Comparable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f2668a;

    public e(List list) {
        this.f2668a = list;
    }

    public final e a(e eVar) {
        ArrayList arrayList = new ArrayList(this.f2668a);
        arrayList.addAll(eVar.f2668a);
        return e(arrayList);
    }

    public final e b(String str) {
        ArrayList arrayList = new ArrayList(this.f2668a);
        arrayList.add(str);
        return e(arrayList);
    }

    public abstract String c();

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final int compareTo(e eVar) {
        int size = this.f2668a.size();
        int size2 = eVar.f2668a.size();
        for (int i = 0; i < size && i < size2; i++) {
            String strG = g(i);
            String strG2 = eVar.g(i);
            int iCompare = 1;
            boolean z6 = strG.startsWith("__id") && strG.endsWith("__");
            boolean z7 = strG2.startsWith("__id") && strG2.endsWith("__");
            if (z6 && !z7) {
                iCompare = -1;
            } else if (z6 || !z7) {
                iCompare = (z6 && z7) ? Long.compare(Long.parseLong(strG.substring(4, strG.length() - 2)), Long.parseLong(strG2.substring(4, strG2.length() - 2))) : r.e(strG, strG2);
            }
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(size, size2);
    }

    public abstract e e(List list);

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && compareTo((e) obj) == 0;
    }

    public final String f() {
        return (String) this.f2668a.get(r0.size() - 1);
    }

    public final String g(int i) {
        return (String) this.f2668a.get(i);
    }

    public final boolean h() {
        return this.f2668a.size() == 0;
    }

    public final int hashCode() {
        return this.f2668a.hashCode() + ((getClass().hashCode() + 37) * 37);
    }

    public final boolean i(e eVar) {
        List list = this.f2668a;
        if (list.size() <= eVar.f2668a.size()) {
            for (int i = 0; i < list.size(); i++) {
                if (g(i).equals(eVar.g(i))) {
                }
            }
            return true;
        }
        return false;
    }

    public final e j() {
        List list = this.f2668a;
        int size = list.size();
        D1.b.w("Can't call popFirst with count > length() (%d > %d)", size >= 5, 5, Integer.valueOf(size));
        return new m(list.subList(5, size));
    }

    public final e k() {
        return e(this.f2668a.subList(0, r0.size() - 1));
    }

    public final String toString() {
        return c();
    }
}
