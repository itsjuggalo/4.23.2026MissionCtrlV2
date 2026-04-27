package Y5;

import F5.AbstractC0555m;
import F5.AbstractC0556n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m extends l {

    public static final class a implements Iterable, R5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f5665a;

        public a(f fVar) {
            this.f5665a = fVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.f5665a.iterator();
        }
    }

    public static Iterable g(f fVar) {
        r.f(fVar, "<this>");
        return new a(fVar);
    }

    public static int h(f fVar) {
        r.f(fVar, "<this>");
        Iterator it = fVar.iterator();
        int i7 = 0;
        while (it.hasNext()) {
            it.next();
            i7++;
            if (i7 < 0) {
                AbstractC0556n.o();
            }
        }
        return i7;
    }

    public static f i(f fVar, int i7) {
        r.f(fVar, "<this>");
        if (i7 >= 0) {
            return i7 == 0 ? fVar : fVar instanceof c ? ((c) fVar).b(i7) : new b(fVar, i7);
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    public static f j(f fVar, Q5.k transform) {
        r.f(fVar, "<this>");
        r.f(transform, "transform");
        return new p(fVar, transform);
    }

    public static f k(f fVar, int i7) {
        r.f(fVar, "<this>");
        if (i7 >= 0) {
            return i7 == 0 ? k.e() : fVar instanceof c ? ((c) fVar).a(i7) : new o(fVar, i7);
        }
        throw new IllegalArgumentException(("Requested element count " + i7 + " is less than zero.").toString());
    }

    public static List l(f fVar) {
        r.f(fVar, "<this>");
        Iterator it = fVar.iterator();
        if (!it.hasNext()) {
            return AbstractC0556n.g();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return AbstractC0555m.b(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }
}
