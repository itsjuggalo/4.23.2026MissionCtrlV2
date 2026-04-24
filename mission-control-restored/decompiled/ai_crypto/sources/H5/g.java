package H5;

import H5.e;
import Q5.o;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;

/* JADX INFO: loaded from: classes2.dex */
public interface g {

    public static final class a {

        /* JADX INFO: renamed from: H5.g$a$a, reason: collision with other inner class name */
        public static final class C0025a extends s implements o {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0025a f2670a = new C0025a();

            public C0025a() {
                super(2);
            }

            @Override // Q5.o
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final g invoke(g acc, b element) {
                H5.c cVar;
                r.f(acc, "acc");
                r.f(element, "element");
                g gVarMinusKey = acc.minusKey(element.getKey());
                h hVar = h.f2671a;
                if (gVarMinusKey == hVar) {
                    return element;
                }
                e.b bVar = e.f2668J;
                e eVar = (e) gVarMinusKey.get(bVar);
                if (eVar == null) {
                    cVar = new H5.c(gVarMinusKey, element);
                } else {
                    g gVarMinusKey2 = gVarMinusKey.minusKey(bVar);
                    if (gVarMinusKey2 == hVar) {
                        return new H5.c(element, eVar);
                    }
                    cVar = new H5.c(new H5.c(gVarMinusKey2, element), eVar);
                }
                return cVar;
            }
        }

        public static g a(g gVar, g context) {
            r.f(context, "context");
            return context == h.f2671a ? gVar : (g) context.fold(gVar, C0025a.f2670a);
        }
    }

    public interface b extends g {

        public static final class a {
            public static Object a(b bVar, Object obj, o operation) {
                r.f(operation, "operation");
                return operation.invoke(obj, bVar);
            }

            public static b b(b bVar, c key) {
                r.f(key, "key");
                if (!r.b(bVar.getKey(), key)) {
                    return null;
                }
                r.d(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static g c(b bVar, c key) {
                r.f(key, "key");
                return r.b(bVar.getKey(), key) ? h.f2671a : bVar;
            }

            public static g d(b bVar, g context) {
                r.f(context, "context");
                return a.a(bVar, context);
            }
        }

        @Override // H5.g
        Object fold(Object obj, o oVar);

        @Override // H5.g
        b get(c cVar);

        c getKey();

        @Override // H5.g
        g minusKey(c cVar);
    }

    public interface c {
    }

    Object fold(Object obj, o oVar);

    b get(c cVar);

    g minusKey(c cVar);

    g plus(g gVar);
}
