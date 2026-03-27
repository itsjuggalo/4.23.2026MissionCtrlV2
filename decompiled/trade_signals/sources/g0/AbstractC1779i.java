package g0;

import B5.o;
import b0.InterfaceC1178i;
import o5.AbstractC2491s;
import o5.C2470H;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;
import u5.AbstractC2785l;

/* JADX INFO: renamed from: g0.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1779i {

    /* JADX INFO: renamed from: g0.i$a */
    public static final class a extends AbstractC2785l implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17976a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f17977b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f17978c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o oVar, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.f17978c = oVar;
        }

        @Override // B5.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(AbstractC1776f abstractC1776f, InterfaceC2707e interfaceC2707e) {
            return ((a) create(abstractC1776f, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            a aVar = new a(this.f17978c, interfaceC2707e);
            aVar.f17977b = obj;
            return aVar;
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.f17976a;
            if (i8 != 0) {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C1773c c1773c = (C1773c) this.f17977b;
                AbstractC2491s.b(obj);
                return c1773c;
            }
            AbstractC2491s.b(obj);
            C1773c c1773cC = ((AbstractC1776f) this.f17977b).c();
            o oVar = this.f17978c;
            this.f17977b = c1773cC;
            this.f17976a = 1;
            return oVar.invoke(c1773cC, this) == objF ? objF : c1773cC;
        }
    }

    public static final Object a(InterfaceC1178i interfaceC1178i, o oVar, InterfaceC2707e interfaceC2707e) {
        return interfaceC1178i.a(new a(oVar, null), interfaceC2707e);
    }
}
