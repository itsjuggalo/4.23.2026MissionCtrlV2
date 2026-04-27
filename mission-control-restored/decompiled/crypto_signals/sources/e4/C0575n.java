package e4;

import java.util.ArrayList;

/* JADX INFO: renamed from: e4.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0575n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6326c;

    public static C0575n a(ArrayList arrayList) {
        C0575n c0575n = new C0575n();
        String str = (String) arrayList.get(0);
        if (str == null) {
            throw new IllegalStateException("Nonnull field \"appName\" is null.");
        }
        c0575n.f6324a = str;
        c0575n.f6325b = (String) arrayList.get(1);
        c0575n.f6326c = (String) arrayList.get(2);
        return c0575n;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.f6324a);
        arrayList.add(this.f6325b);
        arrayList.add(this.f6326c);
        return arrayList;
    }
}
