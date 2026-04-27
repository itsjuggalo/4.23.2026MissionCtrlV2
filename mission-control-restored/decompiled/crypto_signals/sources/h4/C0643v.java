package h4;

import java.util.ArrayList;

/* JADX INFO: renamed from: h4.v, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0643v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f6654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Boolean f6655b;

    public static C0643v a(ArrayList arrayList) {
        C0643v c0643v = new C0643v();
        Boolean bool = (Boolean) arrayList.get(0);
        if (bool == null) {
            throw new IllegalStateException("Nonnull field \"hasPendingWrites\" is null.");
        }
        c0643v.f6654a = bool;
        Boolean bool2 = (Boolean) arrayList.get(1);
        if (bool2 == null) {
            throw new IllegalStateException("Nonnull field \"isFromCache\" is null.");
        }
        c0643v.f6655b = bool2;
        return c0643v;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(this.f6654a);
        arrayList.add(this.f6655b);
        return arrayList;
    }
}
