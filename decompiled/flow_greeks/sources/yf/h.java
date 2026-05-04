package yf;

import fe.g0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import xf.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g0 f25405a = new g0("KotlinTypeRefiner");

    public static final g0 a() {
        return f25405a;
    }

    public static final List b(g gVar, Iterable types) {
        kotlin.jvm.internal.t.f(gVar, "<this>");
        kotlin.jvm.internal.t.f(types, "types");
        ArrayList arrayList = new ArrayList(dd.s.u(types, 10));
        Iterator it = types.iterator();
        while (it.hasNext()) {
            arrayList.add(gVar.a((r0) it.next()));
        }
        return arrayList;
    }
}
