package e4;

import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f6229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Long f6230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Long f6231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Long f6232d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Map f6233f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f6234g;

    public static H a(ArrayList arrayList) {
        Long lValueOf;
        Long lValueOf2;
        H h6 = new H();
        h6.f6229a = (String) arrayList.get(0);
        Object obj = arrayList.get(1);
        Long lValueOf3 = null;
        if (obj == null) {
            lValueOf = null;
        } else {
            lValueOf = Long.valueOf(obj instanceof Integer ? ((Integer) obj).intValue() : ((Long) obj).longValue());
        }
        h6.f6230b = lValueOf;
        Object obj2 = arrayList.get(2);
        if (obj2 == null) {
            lValueOf2 = null;
        } else {
            lValueOf2 = Long.valueOf(obj2 instanceof Integer ? ((Integer) obj2).intValue() : ((Long) obj2).longValue());
        }
        h6.f6231c = lValueOf2;
        Object obj3 = arrayList.get(3);
        if (obj3 != null) {
            lValueOf3 = Long.valueOf(obj3 instanceof Integer ? ((Integer) obj3).intValue() : ((Long) obj3).longValue());
        }
        h6.f6232d = lValueOf3;
        h6.e = (String) arrayList.get(4);
        h6.f6233f = (Map) arrayList.get(5);
        h6.f6234g = (String) arrayList.get(6);
        return h6;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(7);
        arrayList.add(this.f6229a);
        arrayList.add(this.f6230b);
        arrayList.add(this.f6231c);
        arrayList.add(this.f6232d);
        arrayList.add(this.e);
        arrayList.add(this.f6233f);
        arrayList.add(this.f6234g);
        return arrayList;
    }
}
