package U2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f8142a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8143b;

    public k(int i8) {
        this.f8143b = i8;
    }

    public List a() {
        List listB = b();
        ArrayList arrayList = new ArrayList();
        for (int i8 = 0; i8 < listB.size(); i8++) {
            arrayList.add(((j) listB.get(i8)).h());
        }
        return arrayList;
    }

    public synchronized List b() {
        return Collections.unmodifiableList(new ArrayList(this.f8142a));
    }

    public synchronized boolean c(List list) {
        this.f8142a.clear();
        if (list.size() <= this.f8143b) {
            return this.f8142a.addAll(list);
        }
        P2.g.f().k("Ignored 0 entries when adding rollout assignments. Maximum allowable: " + this.f8143b);
        return this.f8142a.addAll(list.subList(0, this.f8143b));
    }
}
