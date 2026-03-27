package U6;

import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2592n;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o extends j {

    public static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Iterator f8456a;

        public a(Iterator it) {
            this.f8456a = it;
        }

        @Override // U6.h
        public Iterator iterator() {
            return this.f8456a;
        }
    }

    public static h e(Iterator it) {
        AbstractC2304t.f(it, "<this>");
        return f(new a(it));
    }

    public static h f(h hVar) {
        AbstractC2304t.f(hVar, "<this>");
        return hVar instanceof U6.a ? hVar : new U6.a(hVar);
    }

    public static h g() {
        return d.f8434a;
    }

    public static final h h(h hVar) {
        AbstractC2304t.f(hVar, "<this>");
        return i(hVar, new B5.k() { // from class: U6.m
            @Override // B5.k
            public final Object invoke(Object obj) {
                return o.j((h) obj);
            }
        });
    }

    public static final h i(h hVar, B5.k kVar) {
        return hVar instanceof v ? ((v) hVar).e(kVar) : new f(hVar, new B5.k() { // from class: U6.n
            @Override // B5.k
            public final Object invoke(Object obj) {
                return o.k(obj);
            }
        }, kVar);
    }

    public static final Iterator j(h it) {
        AbstractC2304t.f(it, "it");
        return it.iterator();
    }

    public static h l(final Object obj, B5.k nextFunction) {
        AbstractC2304t.f(nextFunction, "nextFunction");
        return obj == null ? d.f8434a : new g(new Function0() { // from class: U6.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return o.o(obj);
            }
        }, nextFunction);
    }

    public static h m(final Function0 nextFunction) {
        AbstractC2304t.f(nextFunction, "nextFunction");
        return f(new g(nextFunction, new B5.k() { // from class: U6.l
            @Override // B5.k
            public final Object invoke(Object obj) {
                return o.n(nextFunction, obj);
            }
        }));
    }

    public static final Object n(Function0 function0, Object it) {
        AbstractC2304t.f(it, "it");
        return function0.invoke();
    }

    public static h p(Object... elements) {
        AbstractC2304t.f(elements, "elements");
        return AbstractC2592n.t(elements);
    }

    public static final Object k(Object obj) {
        return obj;
    }

    public static final Object o(Object obj) {
        return obj;
    }
}
