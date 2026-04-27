package e4;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f6212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6213d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f6214f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6215g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f6216h;

    public static D a(ArrayList arrayList) {
        D d4 = new D();
        String str = (String) arrayList.get(0);
        if (str == null) {
            throw new IllegalStateException("Nonnull field \"url\" is null.");
        }
        d4.f6210a = str;
        d4.f6211b = (String) arrayList.get(1);
        Boolean bool = (Boolean) arrayList.get(2);
        if (bool == null) {
            throw new IllegalStateException("Nonnull field \"handleCodeInApp\" is null.");
        }
        d4.f6212c = bool;
        d4.f6213d = (String) arrayList.get(3);
        d4.e = (String) arrayList.get(4);
        Boolean bool2 = (Boolean) arrayList.get(5);
        if (bool2 == null) {
            throw new IllegalStateException("Nonnull field \"androidInstallApp\" is null.");
        }
        d4.f6214f = bool2;
        d4.f6215g = (String) arrayList.get(6);
        d4.f6216h = (String) arrayList.get(7);
        return d4;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(8);
        arrayList.add(this.f6210a);
        arrayList.add(this.f6211b);
        arrayList.add(this.f6212c);
        arrayList.add(this.f6213d);
        arrayList.add(this.e);
        arrayList.add(this.f6214f);
        arrayList.add(this.f6215g);
        arrayList.add(this.f6216h);
        return arrayList;
    }
}
