package e4;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class I {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6235a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Double f6236b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6237c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6238d;
    public String e;

    public static I a(ArrayList arrayList) {
        I i = new I();
        i.f6235a = (String) arrayList.get(0);
        Double d4 = (Double) arrayList.get(1);
        if (d4 == null) {
            throw new IllegalStateException("Nonnull field \"enrollmentTimestamp\" is null.");
        }
        i.f6236b = d4;
        i.f6237c = (String) arrayList.get(2);
        String str = (String) arrayList.get(3);
        if (str == null) {
            throw new IllegalStateException("Nonnull field \"uid\" is null.");
        }
        i.f6238d = str;
        i.e = (String) arrayList.get(4);
        return i;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(this.f6235a);
        arrayList.add(this.f6236b);
        arrayList.add(this.f6237c);
        arrayList.add(this.f6238d);
        arrayList.add(this.e);
        return arrayList;
    }
}
