package j3;

import e3.C1478g;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: j3.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2055k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f17420a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17421b;

    public C2055k(int i7) {
        this.f17421b = i7;
    }

    public List a() {
        List listB = b();
        ArrayList arrayList = new ArrayList();
        for (int i7 = 0; i7 < listB.size(); i7++) {
            arrayList.add(((AbstractC2054j) listB.get(i7)).h());
        }
        return arrayList;
    }

    public synchronized List b() {
        return Collections.unmodifiableList(new ArrayList(this.f17420a));
    }

    public synchronized boolean c(List list) {
        this.f17420a.clear();
        if (list.size() <= this.f17421b) {
            return this.f17420a.addAll(list);
        }
        C1478g.f().k("Ignored 0 entries when adding rollout assignments. Maximum allowable: " + this.f17421b);
        return this.f17420a.addAll(list.subList(0, this.f17421b));
    }
}
