package h4;

import java.util.ArrayList;

/* JADX INFO: renamed from: h4.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0639r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f6638a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6639b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f6640c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f6641d;
    public Boolean e;

    public static C0639r a(ArrayList arrayList) {
        Long lValueOf;
        C0639r c0639r = new C0639r();
        c0639r.f6638a = (Boolean) arrayList.get(0);
        c0639r.f6639b = (String) arrayList.get(1);
        c0639r.f6640c = (Boolean) arrayList.get(2);
        Object obj = arrayList.get(3);
        if (obj == null) {
            lValueOf = null;
        } else {
            lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
        }
        c0639r.f6641d = lValueOf;
        Boolean bool = (Boolean) arrayList.get(4);
        if (bool == null) {
            throw new IllegalStateException("Nonnull field \"ignoreUndefinedProperties\" is null.");
        }
        c0639r.e = bool;
        return c0639r;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(this.f6638a);
        arrayList.add(this.f6639b);
        arrayList.add(this.f6640c);
        arrayList.add(this.f6641d);
        arrayList.add(this.e);
        return arrayList;
    }
}
