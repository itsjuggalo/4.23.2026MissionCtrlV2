package jg;

import dd.a0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class t extends r {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements Iterable, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f14402a;

        public a(h hVar) {
            this.f14402a = hVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.f14402a.iterator();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final /* synthetic */ class b extends kotlin.jvm.internal.q implements pd.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f14403a = new b();

        public b() {
            super(1, h.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // pd.k
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public final Iterator invoke(h p02) {
            kotlin.jvm.internal.t.f(p02, "p0");
            return p02.iterator();
        }
    }

    public static final boolean A(Object obj) {
        return obj == null;
    }

    public static Object B(h hVar) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        Iterator it = hVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static h C(h hVar, pd.k transform) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        kotlin.jvm.internal.t.f(transform, "transform");
        return new f(hVar, transform, b.f14403a);
    }

    public static Object D(h hVar) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        Iterator it = hVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        Object next = it.next();
        while (it.hasNext()) {
            next = it.next();
        }
        return next;
    }

    public static h E(h hVar, pd.k transform) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        kotlin.jvm.internal.t.f(transform, "transform");
        return new x(hVar, transform);
    }

    public static h F(h hVar, pd.k transform) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        kotlin.jvm.internal.t.f(transform, "transform");
        return z(new x(hVar, transform));
    }

    public static h G(h hVar, Iterable elements) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        kotlin.jvm.internal.t.f(elements, "elements");
        return q.j(q.s(hVar, a0.Q(elements)));
    }

    public static h H(h hVar, Object obj) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        return q.j(q.s(hVar, q.r(obj)));
    }

    public static h I(h hVar, h elements) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        kotlin.jvm.internal.t.f(elements, "elements");
        return q.j(q.s(hVar, elements));
    }

    public static h J(h hVar, int i10) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        if (i10 >= 0) {
            return i10 == 0 ? q.i() : hVar instanceof c ? ((c) hVar).a(i10) : new v(hVar, i10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static h K(h hVar, pd.k predicate) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        kotlin.jvm.internal.t.f(predicate, "predicate");
        return new w(hVar, predicate);
    }

    public static final Collection L(h hVar, Collection destination) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        kotlin.jvm.internal.t.f(destination, "destination");
        Iterator it = hVar.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static List M(h hVar) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        Iterator it = hVar.iterator();
        if (!it.hasNext()) {
            return dd.r.k();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return dd.q.e(next);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(next);
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static List N(h hVar) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        return (List) L(hVar, new ArrayList());
    }

    public static Iterable u(h hVar) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        return new a(hVar);
    }

    public static int v(h hVar) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        Iterator it = hVar.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            it.next();
            i10++;
            if (i10 < 0) {
                dd.r.s();
            }
        }
        return i10;
    }

    public static h w(h hVar, int i10) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        if (i10 >= 0) {
            return i10 == 0 ? hVar : hVar instanceof c ? ((c) hVar).b(i10) : new jg.b(hVar, i10);
        }
        throw new IllegalArgumentException(("Requested element count " + i10 + " is less than zero.").toString());
    }

    public static h x(h hVar, pd.k predicate) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        kotlin.jvm.internal.t.f(predicate, "predicate");
        return new e(hVar, true, predicate);
    }

    public static h y(h hVar, pd.k predicate) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        kotlin.jvm.internal.t.f(predicate, "predicate");
        return new e(hVar, false, predicate);
    }

    public static h z(h hVar) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        h hVarY = y(hVar, new pd.k() { // from class: jg.s
            @Override // pd.k
            public final Object invoke(Object obj) {
                return Boolean.valueOf(t.A(obj));
            }
        });
        kotlin.jvm.internal.t.d(hVarY, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return hVarY;
    }
}
