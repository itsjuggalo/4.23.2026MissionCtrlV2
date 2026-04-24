package e4;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class Q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6265b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Boolean f6266c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Boolean f6267d;

    public static Q a(ArrayList arrayList) {
        Q q6 = new Q();
        q6.f6264a = (String) arrayList.get(0);
        q6.f6265b = (String) arrayList.get(1);
        Boolean bool = (Boolean) arrayList.get(2);
        if (bool == null) {
            throw new IllegalStateException("Nonnull field \"displayNameChanged\" is null.");
        }
        q6.f6266c = bool;
        Boolean bool2 = (Boolean) arrayList.get(3);
        if (bool2 == null) {
            throw new IllegalStateException("Nonnull field \"photoUrlChanged\" is null.");
        }
        q6.f6267d = bool2;
        return q6;
    }
}
