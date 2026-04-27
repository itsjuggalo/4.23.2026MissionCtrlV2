package e4;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class M {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Long f6245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f6246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f6247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6248d;
    public String e;

    public static M a(ArrayList arrayList) {
        Long lValueOf;
        Long lValueOf2;
        M m5 = new M();
        Object obj = arrayList.get(0);
        Long lValueOf3 = null;
        if (obj == null) {
            lValueOf = null;
        } else {
            lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
        }
        m5.f6245a = lValueOf;
        Object obj2 = arrayList.get(1);
        if (obj2 == null) {
            lValueOf2 = null;
        } else {
            lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
        }
        m5.f6246b = lValueOf2;
        Object obj3 = arrayList.get(2);
        if (obj3 != null) {
            lValueOf3 = Long.valueOf(obj3 instanceof Integer ? ((Integer) obj3).intValue() : ((Long) obj3).longValue());
        }
        m5.f6247c = lValueOf3;
        m5.f6248d = (String) arrayList.get(3);
        String str = (String) arrayList.get(4);
        if (str == null) {
            throw new IllegalStateException("Nonnull field \"secretKey\" is null.");
        }
        m5.e = str;
        return m5;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(this.f6245a);
        arrayList.add(this.f6246b);
        arrayList.add(this.f6247c);
        arrayList.add(this.f6248d);
        arrayList.add(this.e);
        return arrayList;
    }
}
