package g0;

import B5.o;
import b0.InterfaceC1178i;
import kotlin.jvm.internal.AbstractC2304t;
import o5.AbstractC2491s;
import o5.C2470H;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;
import u5.AbstractC2785l;

/* JADX INFO: renamed from: g0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1774d implements InterfaceC1178i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1178i f17969a;

    /* JADX INFO: renamed from: g0.d$a */
    public static final class a extends AbstractC2785l implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f17970a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f17971b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f17972c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o oVar, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.f17972c = oVar;
        }

        @Override // B5.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(AbstractC1776f abstractC1776f, InterfaceC2707e interfaceC2707e) {
            return ((a) create(abstractC1776f, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            a aVar = new a(this.f17972c, interfaceC2707e);
            aVar.f17971b = obj;
            return aVar;
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.f17970a;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                AbstractC1776f abstractC1776f = (AbstractC1776f) this.f17971b;
                o oVar = this.f17972c;
                this.f17970a = 1;
                obj = oVar.invoke(abstractC1776f, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
            }
            AbstractC1776f abstractC1776f2 = (AbstractC1776f) obj;
            AbstractC2304t.d(abstractC1776f2, "null cannot be cast to non-null type androidx.datastore.preferences.core.MutablePreferences");
            ((C1773c) abstractC1776f2).g();
            return abstractC1776f2;
        }
    }

    public C1774d(InterfaceC1178i delegate) {
        AbstractC2304t.f(delegate, "delegate");
        this.f17969a = delegate;
    }

    @Override // b0.InterfaceC1178i
    public Object a(o oVar, InterfaceC2707e interfaceC2707e) {
        return this.f17969a.a(new a(oVar, null), interfaceC2707e);
    }

    @Override // b0.InterfaceC1178i
    public b7.d getData() {
        return this.f17969a.getData();
    }
}
