package x3;

import Z2.i;
import t3.InterfaceC1846w0;
import y3.B;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p {

    public static final class a extends kotlin.jvm.internal.s implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ n f15786a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(n nVar) {
            super(2);
            this.f15786a = nVar;
        }

        public final Integer a(int i4, i.b bVar) {
            i.c key = bVar.getKey();
            i.b bVar2 = this.f15786a.f15779b.get(key);
            if (key != InterfaceC1846w0.f15039M) {
                return Integer.valueOf(bVar != bVar2 ? Integer.MIN_VALUE : i4 + 1);
            }
            InterfaceC1846w0 interfaceC1846w0 = (InterfaceC1846w0) bVar2;
            kotlin.jvm.internal.r.d(bVar, "null cannot be cast to non-null type kotlinx.coroutines.Job");
            InterfaceC1846w0 interfaceC1846w0B = p.b((InterfaceC1846w0) bVar, interfaceC1846w0);
            if (interfaceC1846w0B == interfaceC1846w0) {
                if (interfaceC1846w0 != null) {
                    i4++;
                }
                return Integer.valueOf(i4);
            }
            throw new IllegalStateException(("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n\t\tChild of " + interfaceC1846w0B + ", expected child of " + interfaceC1846w0 + ".\n\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return a(((Number) obj).intValue(), (i.b) obj2);
        }
    }

    public static final void a(n nVar, Z2.i iVar) {
        if (((Number) iVar.fold(0, new a(nVar))).intValue() == nVar.f15780c) {
            return;
        }
        throw new IllegalStateException(("Flow invariant is violated:\n\t\tFlow was collected in " + nVar.f15779b + ",\n\t\tbut emission happened in " + iVar + ".\n\t\tPlease refer to 'flow' documentation or use 'flowOn' instead").toString());
    }

    public static final InterfaceC1846w0 b(InterfaceC1846w0 interfaceC1846w0, InterfaceC1846w0 interfaceC1846w02) {
        while (interfaceC1846w0 != null) {
            if (interfaceC1846w0 == interfaceC1846w02 || !(interfaceC1846w0 instanceof B)) {
                return interfaceC1846w0;
            }
            interfaceC1846w0 = interfaceC1846w0.getParent();
        }
        return null;
    }
}
