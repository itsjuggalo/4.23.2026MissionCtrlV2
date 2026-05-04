package w7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f23728a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23729b;

    public k(int i10) {
        this.f23729b = i10;
    }

    public List a() {
        List listB = b();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < listB.size(); i10++) {
            arrayList.add(((j) listB.get(i10)).h());
        }
        return arrayList;
    }

    public synchronized List b() {
        return Collections.unmodifiableList(new ArrayList(this.f23728a));
    }

    public synchronized boolean c(List list) {
        this.f23728a.clear();
        if (list.size() <= this.f23729b) {
            return this.f23728a.addAll(list);
        }
        r7.g.f().k("Ignored 0 entries when adding rollout assignments. Maximum allowable: " + this.f23729b);
        return this.f23728a.addAll(list.subList(0, this.f23729b));
    }
}
