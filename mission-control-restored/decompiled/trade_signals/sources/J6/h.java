package J6;

import I6.S;
import R5.G;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final G f4646a = new G("KotlinTypeRefiner");

    public static final G a() {
        return f4646a;
    }

    public static final List b(g gVar, Iterable types) {
        AbstractC2304t.f(gVar, "<this>");
        AbstractC2304t.f(types, "types");
        ArrayList arrayList = new ArrayList(p5.r.s(types, 10));
        Iterator it = types.iterator();
        while (it.hasNext()) {
            arrayList.add(gVar.a((S) it.next()));
        }
        return arrayList;
    }
}
