package b0;

import o5.AbstractC2491s;
import o5.C2470H;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;
import u5.AbstractC2785l;

/* JADX INFO: loaded from: classes.dex */
public abstract class L {

    public static final class a extends AbstractC2785l implements B5.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f12586a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f12587b;

        public a(InterfaceC2707e interfaceC2707e) {
            super(3, interfaceC2707e);
        }

        public final Object a(InterfaceC1169C interfaceC1169C, boolean z7, InterfaceC2707e interfaceC2707e) {
            a aVar = new a(interfaceC2707e);
            aVar.f12587b = interfaceC1169C;
            return aVar.invokeSuspend(C2470H.f21956a);
        }

        @Override // B5.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return a((InterfaceC1169C) obj, ((Boolean) obj2).booleanValue(), (InterfaceC2707e) obj3);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.f12586a;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                InterfaceC1169C interfaceC1169C = (InterfaceC1169C) this.f12587b;
                this.f12586a = 1;
                obj = interfaceC1169C.b(this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
            }
            return obj;
        }
    }

    public static final Object a(K k8, InterfaceC2707e interfaceC2707e) {
        return k8.e(new a(null), interfaceC2707e);
    }
}
