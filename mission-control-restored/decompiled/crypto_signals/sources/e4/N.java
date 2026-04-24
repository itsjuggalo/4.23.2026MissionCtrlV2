package e4;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class N {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public O f6249a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public E f6250b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public F f6251c;

    public static N a(ArrayList arrayList) {
        N n6 = new N();
        n6.f6249a = (O) arrayList.get(0);
        n6.f6250b = (E) arrayList.get(1);
        n6.f6251c = (F) arrayList.get(2);
        return n6;
    }

    public final ArrayList b() {
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(this.f6249a);
        arrayList.add(this.f6250b);
        arrayList.add(this.f6251c);
        return arrayList;
    }
}
