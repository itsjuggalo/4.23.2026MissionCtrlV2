package jg;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q extends l {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f14398a;

        public a(Iterator it) {
            this.f14398a = it;
        }

        @Override // jg.h
        public Iterator iterator() {
            return this.f14398a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f14399a;

        public b(Object obj) {
            this.f14399a = obj;
        }

        @Override // jg.h
        public Iterator iterator() {
            return new c(this.f14399a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c implements Iterator, qd.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f14400a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Object f14401b;

        public c(Object obj) {
            this.f14401b = obj;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f14400a;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.f14400a) {
                throw new NoSuchElementException();
            }
            this.f14400a = false;
            return this.f14401b;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static h g(Iterator it) {
        kotlin.jvm.internal.t.f(it, "<this>");
        return h(new a(it));
    }

    public static h h(h hVar) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        return hVar instanceof jg.a ? hVar : new jg.a(hVar);
    }

    public static h i() {
        return d.f14371a;
    }

    public static final h j(h hVar) {
        kotlin.jvm.internal.t.f(hVar, "<this>");
        return k(hVar, new pd.k() { // from class: jg.o
            @Override // pd.k
            public final Object invoke(Object obj) {
                return q.l((h) obj);
            }
        });
    }

    public static final h k(h hVar, pd.k kVar) {
        return hVar instanceof x ? ((x) hVar).e(kVar) : new f(hVar, new pd.k() { // from class: jg.p
            @Override // pd.k
            public final Object invoke(Object obj) {
                return q.m(obj);
            }
        }, kVar);
    }

    public static final Iterator l(h it) {
        kotlin.jvm.internal.t.f(it, "it");
        return it.iterator();
    }

    public static h n(final Object obj, pd.k nextFunction) {
        kotlin.jvm.internal.t.f(nextFunction, "nextFunction");
        return obj == null ? d.f14371a : new g(new Function0() { // from class: jg.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return q.q(obj);
            }
        }, nextFunction);
    }

    public static h o(final Function0 nextFunction) {
        kotlin.jvm.internal.t.f(nextFunction, "nextFunction");
        return h(new g(nextFunction, new pd.k() { // from class: jg.n
            @Override // pd.k
            public final Object invoke(Object obj) {
                return q.p(nextFunction, obj);
            }
        }));
    }

    public static final Object p(Function0 function0, Object it) {
        kotlin.jvm.internal.t.f(it, "it");
        return function0.invoke();
    }

    public static final h r(Object obj) {
        return new b(obj);
    }

    public static h s(Object... elements) {
        kotlin.jvm.internal.t.f(elements, "elements");
        return dd.n.t(elements);
    }

    public static final Object m(Object obj) {
        return obj;
    }

    public static final Object q(Object obj) {
        return obj;
    }
}
