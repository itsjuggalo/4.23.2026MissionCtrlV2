package h4;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: h4.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0637p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f6633a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f6634b;

    public static C0637p a(ArrayList arrayList) {
        C0637p c0637p = new C0637p();
        c0637p.f6633a = (Boolean) arrayList.get(0);
        c0637p.f6634b = (List) arrayList.get(1);
        return c0637p;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(this.f6633a);
        arrayList.add(this.f6634b);
        return arrayList;
    }
}
