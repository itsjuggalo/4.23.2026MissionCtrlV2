package ce;

import ce.o;
import dd.a0;
import ef.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f3895a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set f3896b;

    static {
        Set set = l.f3918f;
        ArrayList arrayList = new ArrayList(dd.s.u(set, 10));
        Iterator it = set.iterator();
        while (it.hasNext()) {
            arrayList.add(o.c((l) it.next()));
        }
        List listT0 = a0.t0(a0.t0(a0.t0(arrayList, o.a.f3987h.m()), o.a.f3991j.m()), o.a.f4009s.m());
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        b.a aVar = ef.b.f8779d;
        Iterator it2 = listT0.iterator();
        while (it2.hasNext()) {
            linkedHashSet.add(aVar.c((ef.c) it2.next()));
        }
        f3896b = linkedHashSet;
    }

    public final Set a() {
        return f3896b;
    }

    public final Set b() {
        return f3896b;
    }
}
