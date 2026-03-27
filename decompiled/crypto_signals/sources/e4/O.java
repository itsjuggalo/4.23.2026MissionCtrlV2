package e4;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class O {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public P f6252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f6253b;

    public static O a(ArrayList arrayList) {
        O o3 = new O();
        P p3 = (P) arrayList.get(0);
        if (p3 == null) {
            throw new IllegalStateException("Nonnull field \"userInfo\" is null.");
        }
        o3.f6252a = p3;
        List list = (List) arrayList.get(1);
        if (list == null) {
            throw new IllegalStateException("Nonnull field \"providerData\" is null.");
        }
        o3.f6253b = list;
        return o3;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(this.f6252a);
        arrayList.add(this.f6253b);
        return arrayList;
    }
}
