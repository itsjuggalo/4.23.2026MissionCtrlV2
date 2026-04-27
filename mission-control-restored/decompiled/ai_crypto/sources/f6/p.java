package f6;

import H5.g;
import b6.InterfaceC1101w0;
import g6.B;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p {

    public static final class a extends kotlin.jvm.internal.s implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f14220a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n nVar) {
            super(2);
            this.f14220a = nVar;
        }

        public final Integer a(int i7, g.b bVar) {
            g.c key = bVar.getKey();
            g.b bVar2 = this.f14220a.f14213b.get(key);
            if (key != InterfaceC1101w0.f9097L) {
                return Integer.valueOf(bVar != bVar2 ? Integer.MIN_VALUE : i7 + 1);
            }
            InterfaceC1101w0 interfaceC1101w0 = (InterfaceC1101w0) bVar2;
            kotlin.jvm.internal.r.d(bVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
            InterfaceC1101w0 interfaceC1101w0B = p.b((InterfaceC1101w0) bVar, interfaceC1101w0);
            if (interfaceC1101w0B == interfaceC1101w0) {
                if (interfaceC1101w0 != null) {
                    i7++;
                }
                return Integer.valueOf(i7);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + interfaceC1101w0B + ", expected child of " + interfaceC1101w0 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // Q5.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (g.b) obj2);
        }
    }

    public static final void a(n nVar, H5.g gVar) {
        if (((Number) gVar.fold(0, new a(nVar))).intValue() == nVar.f14214c) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + nVar.f14213b + ",\n\t\tbut emission happened in " + gVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final InterfaceC1101w0 b(InterfaceC1101w0 interfaceC1101w0, InterfaceC1101w0 interfaceC1101w02) {
        while (interfaceC1101w0 != null) {
            if (interfaceC1101w0 == interfaceC1101w02) {
                return interfaceC1101w0;
            }
            if (!(interfaceC1101w0 instanceof B)) {
                return interfaceC1101w0;
            }
            interfaceC1101w0 = interfaceC1101w0.getParent();
        }
        return null;
    }
}
