package e4;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6221a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6222b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f6223c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6224d;

    public static F a(ArrayList arrayList) {
        Long lValueOf;
        F f6 = new F();
        String str = (String) arrayList.get(0);
        if (str == null) {
            throw new IllegalStateException("Nonnull field \"providerId\" is null.");
        }
        f6.f6221a = str;
        String str2 = (String) arrayList.get(1);
        if (str2 == null) {
            throw new IllegalStateException("Nonnull field \"signInMethod\" is null.");
        }
        f6.f6222b = str2;
        Object obj = arrayList.get(2);
        if (obj == null) {
            lValueOf = null;
        } else {
            lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
        }
        if (lValueOf == null) {
            throw new IllegalStateException("Nonnull field \"nativeId\" is null.");
        }
        f6.f6223c = lValueOf;
        f6.f6224d = (String) arrayList.get(3);
        return f6;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(this.f6221a);
        arrayList.add(this.f6222b);
        arrayList.add(this.f6223c);
        arrayList.add(this.f6224d);
        return arrayList;
    }
}
