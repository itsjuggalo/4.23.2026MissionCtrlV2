package e4;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List f6243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f6244c;

    public static L a(ArrayList arrayList) {
        L l6 = new L();
        String str = (String) arrayList.get(0);
        if (str == null) {
            throw new IllegalStateException("Nonnull field \"providerId\" is null.");
        }
        l6.f6242a = str;
        l6.f6243b = (List) arrayList.get(1);
        l6.f6244c = (Map) arrayList.get(2);
        return l6;
    }
}
