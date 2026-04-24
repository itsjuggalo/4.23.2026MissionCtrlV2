package Z2;

import Z2.f;
import Z2.i;
import i3.o;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public interface i {

    public static final class a {
        public static i b(i iVar, i context) {
            r.f(context, "context");
            return context == j.f6012a ? iVar : (i) context.fold(iVar, new o() { // from class: Z2.h
                @Override // i3.o
                public final Object invoke(Object obj, Object obj2) {
                    return i.a.c((i) obj, (i.b) obj2);
                }
            });
        }

        public static i c(i acc, b element) {
            r.f(acc, "acc");
            r.f(element, "element");
            i iVarMinusKey = acc.minusKey(element.getKey());
            j jVar = j.f6012a;
            if (iVarMinusKey == jVar) {
                return element;
            }
            f.b bVar = f.f6010J;
            f fVar = (f) iVarMinusKey.get(bVar);
            if (fVar == null) {
                return new d(iVarMinusKey, element);
            }
            i iVarMinusKey2 = iVarMinusKey.minusKey(bVar);
            return iVarMinusKey2 == jVar ? new d(element, fVar) : new d(new d(iVarMinusKey2, element), fVar);
        }
    }

    public interface b extends i {

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

            public static i c(b bVar, c key) {
                r.f(key, "key");
                return r.b(bVar.getKey(), key) ? j.f6012a : bVar;
            }

            public static i d(b bVar, i context) {
                r.f(context, "context");
                return a.b(bVar, context);
            }
        }

        @Override // Z2.i
        Object fold(Object obj, o oVar);

        @Override // Z2.i
        b get(c cVar);

        c getKey();

        @Override // Z2.i
        i minusKey(c cVar);
    }

    public interface c {
    }

    Object fold(Object obj, o oVar);

    b get(c cVar);

    i minusKey(c cVar);

    i plus(i iVar);
}
