package e4;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f6225a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6226b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6227c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6228d;
    public Boolean e;

    public static G a(ArrayList arrayList) {
        G g2 = new G();
        Boolean bool = (Boolean) arrayList.get(0);
        if (bool == null) {
            throw new IllegalStateException("Nonnull field \"appVerificationDisabledForTesting\" is null.");
        }
        g2.f6225a = bool;
        g2.f6226b = (String) arrayList.get(1);
        g2.f6227c = (String) arrayList.get(2);
        g2.f6228d = (String) arrayList.get(3);
        g2.e = (Boolean) arrayList.get(4);
        return g2;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(this.f6225a);
        arrayList.add(this.f6226b);
        arrayList.add(this.f6227c);
        arrayList.add(this.f6228d);
        arrayList.add(this.e);
        return arrayList;
    }
}
