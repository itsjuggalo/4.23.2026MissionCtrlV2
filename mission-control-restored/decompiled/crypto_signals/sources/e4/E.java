package e4;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f6217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6219c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6220d;
    public Map e;

    public static E a(ArrayList arrayList) {
        E e = new E();
        Boolean bool = (Boolean) arrayList.get(0);
        if (bool == null) {
            throw new IllegalStateException("Nonnull field \"isNewUser\" is null.");
        }
        e.f6217a = bool;
        e.f6218b = (String) arrayList.get(1);
        e.f6219c = (String) arrayList.get(2);
        e.f6220d = (String) arrayList.get(3);
        e.e = (Map) arrayList.get(4);
        return e;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(this.f6217a);
        arrayList.add(this.f6218b);
        arrayList.add(this.f6219c);
        arrayList.add(this.f6220d);
        arrayList.add(this.e);
        return arrayList;
    }
}
