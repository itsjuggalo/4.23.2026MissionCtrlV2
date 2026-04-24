package s5;

import B5.o;
import kotlin.jvm.internal.AbstractC2304t;
import s5.InterfaceC2708f;
import s5.InterfaceC2711i;

/* JADX INFO: renamed from: s5.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public interface InterfaceC2711i {

    /* JADX INFO: renamed from: s5.i$a */
    public static final class a {
        public static InterfaceC2711i b(InterfaceC2711i interfaceC2711i, InterfaceC2711i context) {
            AbstractC2304t.f(context, "context");
            return context == C2712j.f23116a ? interfaceC2711i : (InterfaceC2711i) context.K(interfaceC2711i, new o() { // from class: s5.h
                @Override // B5.o
                public final Object invoke(Object obj, Object obj2) {
                    return InterfaceC2711i.a.c((InterfaceC2711i) obj, (InterfaceC2711i.b) obj2);
                }
            });
        }

        public static InterfaceC2711i c(InterfaceC2711i acc, b element) {
            C2706d c2706d;
            AbstractC2304t.f(acc, "acc");
            AbstractC2304t.f(element, "element");
            InterfaceC2711i interfaceC2711iR0 = acc.r0(element.getKey());
            C2712j c2712j = C2712j.f23116a;
            if (interfaceC2711iR0 == c2712j) {
                return element;
            }
            InterfaceC2708f.b bVar = InterfaceC2708f.f23114O;
            InterfaceC2708f interfaceC2708f = (InterfaceC2708f) interfaceC2711iR0.a(bVar);
            if (interfaceC2708f == null) {
                c2706d = new C2706d(interfaceC2711iR0, element);
            } else {
                InterfaceC2711i interfaceC2711iR02 = interfaceC2711iR0.r0(bVar);
                if (interfaceC2711iR02 == c2712j) {
                    return new C2706d(element, interfaceC2708f);
                }
                c2706d = new C2706d(new C2706d(interfaceC2711iR02, element), interfaceC2708f);
            }
            return c2706d;
        }
    }

    /* JADX INFO: renamed from: s5.i$b */
    public interface b extends InterfaceC2711i {

        /* JADX INFO: renamed from: s5.i$b$a */
        public static final class a {
            public static Object a(b bVar, Object obj, o operation) {
                AbstractC2304t.f(operation, "operation");
                return operation.invoke(obj, bVar);
            }

            public static b b(b bVar, c key) {
                AbstractC2304t.f(key, "key");
                if (!AbstractC2304t.b(bVar.getKey(), key)) {
                    return null;
                }
                AbstractC2304t.d(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static InterfaceC2711i c(b bVar, c key) {
                AbstractC2304t.f(key, "key");
                return AbstractC2304t.b(bVar.getKey(), key) ? C2712j.f23116a : bVar;
            }

            public static InterfaceC2711i d(b bVar, InterfaceC2711i context) {
                AbstractC2304t.f(context, "context");
                return a.b(bVar, context);
            }
        }

        @Override // s5.InterfaceC2711i
        b a(c cVar);

        c getKey();
    }

    /* JADX INFO: renamed from: s5.i$c */
    public interface c {
    }

    Object K(Object obj, o oVar);

    b a(c cVar);

    InterfaceC2711i m0(InterfaceC2711i interfaceC2711i);

    InterfaceC2711i r0(c cVar);
}
