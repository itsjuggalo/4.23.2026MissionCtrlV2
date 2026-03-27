package R2;

import Z1.r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f2784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f2785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f2786d;

    public i(int i, r rVar, ArrayList arrayList, List list) {
        D1.b.w("Cannot create an empty mutation batch", !list.isEmpty(), new Object[0]);
        this.f2783a = i;
        this.f2784b = rVar;
        this.f2785c = arrayList;
        this.f2786d = list;
    }

    public final f a(Q2.k kVar, f fVar) {
        r rVar;
        int i = 0;
        int i6 = 0;
        while (true) {
            ArrayList arrayList = this.f2785c;
            int size = arrayList.size();
            rVar = this.f2784b;
            if (i6 >= size) {
                break;
            }
            h hVar = (h) arrayList.get(i6);
            if (hVar.f2780a.equals(kVar.f2679a)) {
                fVar = hVar.a(kVar, fVar, rVar);
            }
            i6++;
        }
        while (true) {
            List list = this.f2786d;
            if (i >= list.size()) {
                return fVar;
            }
            h hVar2 = (h) list.get(i);
            if (hVar2.f2780a.equals(kVar.f2679a)) {
                fVar = hVar2.a(kVar, fVar, rVar);
            }
            i++;
        }
    }

    public final HashSet b() {
        HashSet hashSet = new HashSet();
        Iterator it = this.f2786d.iterator();
        while (it.hasNext()) {
            hashSet.add(((h) it.next()).f2780a);
        }
        return hashSet;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || i.class != obj.getClass()) {
            return false;
        }
        i iVar = (i) obj;
        return this.f2783a == iVar.f2783a && this.f2784b.equals(iVar.f2784b) && this.f2785c.equals(iVar.f2785c) && this.f2786d.equals(iVar.f2786d);
    }

    public final int hashCode() {
        return this.f2786d.hashCode() + ((this.f2785c.hashCode() + ((this.f2784b.hashCode() + (this.f2783a * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "MutationBatch(batchId=" + this.f2783a + ", localWriteTime=" + this.f2784b + ", baseMutations=" + this.f2785c + ", mutations=" + this.f2786d + ')';
    }
}
