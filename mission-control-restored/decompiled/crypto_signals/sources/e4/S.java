package e4;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class S {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f6269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f6270c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6271d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f6272f;

    public static S a(ArrayList arrayList) {
        Long lValueOf;
        S s6 = new S();
        s6.f6268a = (String) arrayList.get(0);
        Object obj = arrayList.get(1);
        Long lValueOf2 = null;
        if (obj == null) {
            lValueOf = null;
        } else {
            lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
        }
        if (lValueOf == null) {
            throw new IllegalStateException("Nonnull field \"timeout\" is null.");
        }
        s6.f6269b = lValueOf;
        Object obj2 = arrayList.get(2);
        if (obj2 != null) {
            lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
        }
        s6.f6270c = lValueOf2;
        s6.f6271d = (String) arrayList.get(3);
        s6.e = (String) arrayList.get(4);
        s6.f6272f = (String) arrayList.get(5);
        return s6;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(6);
        arrayList.add(this.f6268a);
        arrayList.add(this.f6269b);
        arrayList.add(this.f6270c);
        arrayList.add(this.f6271d);
        arrayList.add(this.e);
        arrayList.add(this.f6272f);
        return arrayList;
    }
}
