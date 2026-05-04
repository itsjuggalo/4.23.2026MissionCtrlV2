package gd;

import gd.f;
import gd.i;
import kotlin.jvm.internal.t;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface i {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public static i b(i iVar, i context) {
            t.f(context, "context");
            return context == j.f10531a ? iVar : (i) context.fold(iVar, new o() { // from class: gd.h
                @Override // pd.o
                public final Object invoke(Object obj, Object obj2) {
                    return i.a.c((i) obj, (i.b) obj2);
                }
            });
        }

        public static i c(i acc, b element) {
            t.f(acc, "acc");
            t.f(element, "element");
            i iVarMinusKey = acc.minusKey(element.getKey());
            j jVar = j.f10531a;
            if (iVarMinusKey == jVar) {
                return element;
            }
            f.b bVar = f.K;
            f fVar = (f) iVarMinusKey.get(bVar);
            if (fVar == null) {
                return new d(iVarMinusKey, element);
            }
            i iVarMinusKey2 = iVarMinusKey.minusKey(bVar);
            return iVarMinusKey2 == jVar ? new d(element, fVar) : new d(new d(iVarMinusKey2, element), fVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b extends i {

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class a {
            public static Object a(b bVar, Object obj, o operation) {
                t.f(operation, "operation");
                return operation.invoke(obj, bVar);
            }

            public static b b(b bVar, c key) {
                t.f(key, "key");
                if (!t.b(bVar.getKey(), key)) {
                    return null;
                }
                t.d(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static i c(b bVar, c key) {
                t.f(key, "key");
                return t.b(bVar.getKey(), key) ? j.f10531a : bVar;
            }

            public static i d(b bVar, i context) {
                t.f(context, "context");
                return a.b(bVar, context);
            }
        }

        @Override // gd.i
        Object fold(Object obj, o oVar);

        @Override // gd.i
        b get(c cVar);

        c getKey();

        @Override // gd.i
        i minusKey(c cVar);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface c {
    }

    Object fold(Object obj, o oVar);

    b get(c cVar);

    i minusKey(c cVar);

    i plus(i iVar);
}
