package c7;

import d7.K;
import o5.AbstractC2491s;
import o5.C2470H;
import s5.InterfaceC2707e;
import s5.InterfaceC2711i;
import t5.AbstractC2751c;
import u5.AbstractC2785l;

/* JADX INFO: loaded from: classes2.dex */
public final class u implements b7.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2711i f13613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final B5.o f13615c;

    public static final class a extends AbstractC2785l implements B5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f13616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f13617b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b7.e f13618c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b7.e eVar, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.f13618c = eVar;
        }

        @Override // B5.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, InterfaceC2707e interfaceC2707e) {
            return ((a) create(obj, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            a aVar = new a(this.f13618c, interfaceC2707e);
            aVar.f13617b = obj;
            return aVar;
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = AbstractC2751c.f();
            int i8 = this.f13616a;
            if (i8 == 0) {
                AbstractC2491s.b(obj);
                Object obj2 = this.f13617b;
                b7.e eVar = this.f13618c;
                this.f13616a = 1;
                if (eVar.emit(obj2, this) == objF) {
                    return objF;
                }
            } else {
                if (i8 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                AbstractC2491s.b(obj);
            }
            return C2470H.f21956a;
        }
    }

    public u(b7.e eVar, InterfaceC2711i interfaceC2711i) {
        this.f13613a = interfaceC2711i;
        this.f13614b = K.g(interfaceC2711i);
        this.f13615c = new a(eVar, null);
    }

    @Override // b7.e
    public Object emit(Object obj, InterfaceC2707e interfaceC2707e) {
        Object objB = f.b(this.f13613a, obj, this.f13614b, this.f13615c, interfaceC2707e);
        return objB == AbstractC2751c.f() ? objB : C2470H.f21956a;
    }
}
