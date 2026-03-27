package e4;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class P {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6255b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6256c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6257d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f6258f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Boolean f6259g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f6260h;
    public String i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f6261j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Long f6262k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Long f6263l;

    public static P a(ArrayList arrayList) {
        Long lValueOf;
        P p3 = new P();
        String str = (String) arrayList.get(0);
        if (str == null) {
            throw new IllegalStateException("Nonnull field \"uid\" is null.");
        }
        p3.f6254a = str;
        p3.f6255b = (String) arrayList.get(1);
        p3.f6256c = (String) arrayList.get(2);
        p3.f6257d = (String) arrayList.get(3);
        p3.e = (String) arrayList.get(4);
        Boolean bool = (Boolean) arrayList.get(5);
        if (bool == null) {
            throw new IllegalStateException("Nonnull field \"isAnonymous\" is null.");
        }
        p3.f6258f = bool;
        Boolean bool2 = (Boolean) arrayList.get(6);
        if (bool2 == null) {
            throw new IllegalStateException("Nonnull field \"isEmailVerified\" is null.");
        }
        p3.f6259g = bool2;
        p3.f6260h = (String) arrayList.get(7);
        p3.i = (String) arrayList.get(8);
        p3.f6261j = (String) arrayList.get(9);
        Object obj = arrayList.get(10);
        Long lValueOf2 = null;
        if (obj == null) {
            lValueOf = null;
        } else {
            lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
        }
        p3.f6262k = lValueOf;
        Object obj2 = arrayList.get(11);
        if (obj2 != null) {
            lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
        }
        p3.f6263l = lValueOf2;
        return p3;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(12);
        arrayList.add(this.f6254a);
        arrayList.add(this.f6255b);
        arrayList.add(this.f6256c);
        arrayList.add(this.f6257d);
        arrayList.add(this.e);
        arrayList.add(this.f6258f);
        arrayList.add(this.f6259g);
        arrayList.add(this.f6260h);
        arrayList.add(this.i);
        arrayList.add(this.f6261j);
        arrayList.add(this.f6262k);
        arrayList.add(this.f6263l);
        return arrayList;
    }
}
