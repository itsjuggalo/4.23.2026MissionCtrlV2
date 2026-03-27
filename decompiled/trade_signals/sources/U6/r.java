package U6;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2594p;
import p5.AbstractC2595q;
import p5.z;

/* JADX INFO: loaded from: classes2.dex */
public abstract class r extends p {

    public static final class a implements Iterable, C5.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f8457a;

        public a(h hVar) {
            this.f8457a = hVar;
        }

        @Override // java.lang.Iterable
        public Iterator iterator() {
            return this.f8457a.iterator();
        }
    }

    public /* synthetic */ class b extends AbstractC2302q implements B5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f8458a = new b();

        public b() {
            super(1, h.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
        }

        @Override // B5.k
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final Iterator invoke(h p02) {
            AbstractC2304t.f(p02, "p0");
            return p02.iterator();
        }
    }

    public static Object A(h hVar) {
        Object next;
        AbstractC2304t.f(hVar, "<this>");
        Iterator it = hVar.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException("Sequence is empty.");
        }
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static h B(h hVar, B5.k transform) {
        AbstractC2304t.f(hVar, "<this>");
        AbstractC2304t.f(transform, "transform");
        return new v(hVar, transform);
    }

    public static h C(h hVar, B5.k transform) {
        AbstractC2304t.f(hVar, "<this>");
        AbstractC2304t.f(transform, "transform");
        return w(new v(hVar, transform));
    }

    public static h D(h hVar, h elements) {
        AbstractC2304t.f(hVar, "<this>");
        AbstractC2304t.f(elements, "elements");
        return o.h(o.p(hVar, elements));
    }

    public static h E(h hVar, Iterable elements) {
        AbstractC2304t.f(hVar, "<this>");
        AbstractC2304t.f(elements, "elements");
        return o.h(o.p(hVar, z.P(elements)));
    }

    public static h F(h hVar, Object obj) {
        AbstractC2304t.f(hVar, "<this>");
        return o.h(o.p(hVar, o.p(obj)));
    }

    public static h G(h hVar, int i8) {
        AbstractC2304t.f(hVar, "<this>");
        if (i8 >= 0) {
            return i8 == 0 ? o.g() : hVar instanceof c ? ((c) hVar).a(i8) : new t(hVar, i8);
        }
        throw new IllegalArgumentException(("Requested element count " + i8 + " is less than zero.").toString());
    }

    public static h H(h hVar, B5.k predicate) {
        AbstractC2304t.f(hVar, "<this>");
        AbstractC2304t.f(predicate, "predicate");
        return new u(hVar, predicate);
    }

    public static final Collection I(h hVar, Collection destination) {
        AbstractC2304t.f(hVar, "<this>");
        AbstractC2304t.f(destination, "destination");
        Iterator it = hVar.iterator();
        while (it.hasNext()) {
            destination.add(it.next());
        }
        return destination;
    }

    public static List J(h hVar) {
        AbstractC2304t.f(hVar, "<this>");
        Iterator it = hVar.iterator();
        if (!it.hasNext()) {
            return AbstractC2595q.i();
        }
        Object next = it.next();
        if (!it.hasNext()) {
            return AbstractC2594p.e(next);
        }
        ArrayList arrayList = new ArrayList();
        while (true) {
            arrayList.add(next);
            if (!it.hasNext()) {
                return arrayList;
            }
            next = it.next();
        }
    }

    public static List K(h hVar) {
        AbstractC2304t.f(hVar, "<this>");
        return (List) I(hVar, new ArrayList());
    }

    public static Iterable r(h hVar) {
        AbstractC2304t.f(hVar, "<this>");
        return new a(hVar);
    }

    public static int s(h hVar) {
        AbstractC2304t.f(hVar, "<this>");
        Iterator it = hVar.iterator();
        int i8 = 0;
        while (it.hasNext()) {
            it.next();
            i8++;
            if (i8 < 0) {
                AbstractC2595q.q();
            }
        }
        return i8;
    }

    public static h t(h hVar, int i8) {
        AbstractC2304t.f(hVar, "<this>");
        if (i8 >= 0) {
            return i8 == 0 ? hVar : hVar instanceof c ? ((c) hVar).b(i8) : new U6.b(hVar, i8);
        }
        throw new IllegalArgumentException(("Requested element count " + i8 + " is less than zero.").toString());
    }

    public static h u(h hVar, B5.k predicate) {
        AbstractC2304t.f(hVar, "<this>");
        AbstractC2304t.f(predicate, "predicate");
        return new e(hVar, true, predicate);
    }

    public static h v(h hVar, B5.k predicate) {
        AbstractC2304t.f(hVar, "<this>");
        AbstractC2304t.f(predicate, "predicate");
        return new e(hVar, false, predicate);
    }

    public static h w(h hVar) {
        AbstractC2304t.f(hVar, "<this>");
        h hVarV = v(hVar, new B5.k() { // from class: U6.q
            @Override // B5.k
            public final Object invoke(Object obj) {
                return Boolean.valueOf(r.x(obj));
            }
        });
        AbstractC2304t.d(hVarV, "null cannot be cast to non-null type kotlin.sequences.Sequence<T of kotlin.sequences.SequencesKt___SequencesKt.filterNotNull>");
        return hVarV;
    }

    public static final boolean x(Object obj) {
        return obj == null;
    }

    public static Object y(h hVar) {
        AbstractC2304t.f(hVar, "<this>");
        Iterator it = hVar.iterator();
        if (it.hasNext()) {
            return it.next();
        }
        return null;
    }

    public static h z(h hVar, B5.k transform) {
        AbstractC2304t.f(hVar, "<this>");
        AbstractC2304t.f(transform, "transform");
        return new f(hVar, transform, b.f8458a);
    }
}
