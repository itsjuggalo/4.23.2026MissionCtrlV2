package e4;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class K {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6240a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6241b;

    public static K a(ArrayList arrayList) {
        K k6 = new K();
        String str = (String) arrayList.get(0);
        if (str == null) {
            throw new IllegalStateException("Nonnull field \"verificationId\" is null.");
        }
        k6.f6240a = str;
        String str2 = (String) arrayList.get(1);
        if (str2 == null) {
            throw new IllegalStateException("Nonnull field \"verificationCode\" is null.");
        }
        k6.f6241b = str2;
        return k6;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(this.f6240a);
        arrayList.add(this.f6241b);
        return arrayList;
    }
}
