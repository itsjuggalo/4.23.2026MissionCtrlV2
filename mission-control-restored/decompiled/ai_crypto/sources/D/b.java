package D;

import P.d;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import u.g;

/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P.c f1070a = new d(10);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g f1071b = new g();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f1072c = new ArrayList();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashSet f1073d = new HashSet();

    public void a(Object obj, Object obj2) {
        if (!this.f1071b.containsKey(obj) || !this.f1071b.containsKey(obj2)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayListF = (ArrayList) this.f1071b.get(obj);
        if (arrayListF == null) {
            arrayListF = f();
            this.f1071b.put(obj, arrayListF);
        }
        arrayListF.add(obj2);
    }

    public void b(Object obj) {
        if (this.f1071b.containsKey(obj)) {
            return;
        }
        this.f1071b.put(obj, null);
    }

    public void c() {
        int size = this.f1071b.size();
        for (int i7 = 0; i7 < size; i7++) {
            ArrayList arrayList = (ArrayList) this.f1071b.n(i7);
            if (arrayList != null) {
                j(arrayList);
            }
        }
        this.f1071b.clear();
    }

    public boolean d(Object obj) {
        return this.f1071b.containsKey(obj);
    }

    public final void e(Object obj, ArrayList arrayList, HashSet hashSet) {
        if (arrayList.contains(obj)) {
            return;
        }
        if (hashSet.contains(obj)) {
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
        hashSet.add(obj);
        ArrayList arrayList2 = (ArrayList) this.f1071b.get(obj);
        if (arrayList2 != null) {
            int size = arrayList2.size();
            for (int i7 = 0; i7 < size; i7++) {
                e(arrayList2.get(i7), arrayList, hashSet);
            }
        }
        hashSet.remove(obj);
        arrayList.add(obj);
    }

    public final ArrayList f() {
        ArrayList arrayList = (ArrayList) this.f1070a.b();
        return arrayList == null ? new ArrayList() : arrayList;
    }

    public List g(Object obj) {
        int size = this.f1071b.size();
        ArrayList arrayList = null;
        for (int i7 = 0; i7 < size; i7++) {
            ArrayList arrayList2 = (ArrayList) this.f1071b.n(i7);
            if (arrayList2 != null && arrayList2.contains(obj)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.f1071b.j(i7));
            }
        }
        return arrayList;
    }

    public ArrayList h() {
        this.f1072c.clear();
        this.f1073d.clear();
        int size = this.f1071b.size();
        for (int i7 = 0; i7 < size; i7++) {
            e(this.f1071b.j(i7), this.f1072c, this.f1073d);
        }
        return this.f1072c;
    }

    public boolean i(Object obj) {
        int size = this.f1071b.size();
        for (int i7 = 0; i7 < size; i7++) {
            ArrayList arrayList = (ArrayList) this.f1071b.n(i7);
            if (arrayList != null && arrayList.contains(obj)) {
                return true;
            }
        }
        return false;
    }

    public final void j(ArrayList arrayList) {
        arrayList.clear();
        this.f1070a.a(arrayList);
    }
}
