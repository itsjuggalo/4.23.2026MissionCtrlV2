package q3;

import X2.AbstractC0768o;
import X2.AbstractC0769p;
import j3.InterfaceC1564a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class l extends k {

    public static final class a implements Iterable, InterfaceC1564a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f14304a;

        public a(e eVar) {
            this.f14304a = eVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.f14304a.iterator();
        }
    }

    public static Iterable f(e eVar) {
        r.f(eVar, "<this>");
        return new a(eVar);
    }

    public static int g(e eVar) {
        r.f(eVar, "<this>");
        Iterator it = eVar.iterator();
        int i4 = 0;
        while (it.hasNext()) {
            it.next();
            i4++;
            if (i4 < 0) {
                AbstractC0769p.o();
            }
        }
        return i4;
    }

    public static e h(e eVar, int i4) {
        r.f(eVar, "<this>");
        if (i4 >= 0) {
            return i4 == 0 ? eVar : eVar instanceof c ? ((c) eVar).b(i4) : new b(eVar, i4);
        }
        throw new IllegalArgumentException(("Requested element count " + i4 + " is less than zero.").toString());
    }

    public static e i(e eVar, i3.k transform) {
        r.f(eVar, "<this>");
        r.f(transform, "transform");
        return new o(eVar, transform);
    }

    public static e j(e eVar, int i4) {
        r.f(eVar, "<this>");
        if (i4 >= 0) {
            return i4 == 0 ? j.e() : eVar instanceof c ? ((c) eVar).a(i4) : new n(eVar, i4);
        }
        throw new IllegalArgumentException(("Requested element count " + i4 + " is less than zero.").toString());
    }

    public static List k(e eVar) {
        r.f(eVar, "<this>");
        Iterator it = eVar.iterator();
        if (!it.hasNext()) {
            return AbstractC0769p.g();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return AbstractC0768o.b(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
