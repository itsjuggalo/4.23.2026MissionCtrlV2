package a7;

import Y6.AbstractC1007h;
import Y6.L;
import a7.k;
import o5.AbstractC2491s;
import o5.C2470H;
import o5.C2490r;
import s5.InterfaceC2707e;
import t5.AbstractC2751c;
import u5.AbstractC2785l;

/* JADX INFO: loaded from: classes2.dex */
public abstract /* synthetic */ class o {

    public static final class a extends AbstractC2785l implements B5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f10228a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f10229b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x f10230c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f10231d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(x xVar, Object obj, InterfaceC2707e interfaceC2707e) {
            super(2, interfaceC2707e);
            this.f10230c = xVar;
            this.f10231d = obj;
        }

        @Override // u5.AbstractC2774a
        public final InterfaceC2707e create(Object obj, InterfaceC2707e interfaceC2707e) {
            a aVar = new a(this.f10230c, this.f10231d, interfaceC2707e);
            aVar.f10229b = obj;
            return aVar;
        }

        @Override // B5.o
        public final Object invoke(L l8, InterfaceC2707e interfaceC2707e) {
            return ((a) create(l8, interfaceC2707e)).invokeSuspend(C2470H.f21956a);
        }

        @Override // u5.AbstractC2774a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objB;
            Object objF = AbstractC2751c.f();
            int i8 = this.f10228a;
            try {
                if (i8 == 0) {
                    AbstractC2491s.b(obj);
                    x xVar = this.f10230c;
                    Object obj2 = this.f10231d;
                    C2490r.a aVar = C2490r.f21981b;
                    this.f10228a = 1;
                    if (xVar.n(obj2, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i8 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    AbstractC2491s.b(obj);
                }
                objB = C2490r.b(C2470H.f21956a);
            } catch (Throwable th) {
                C2490r.a aVar2 = C2490r.f21981b;
                objB = C2490r.b(AbstractC2491s.a(th));
            }
            return k.b(C2490r.h(objB) ? k.f10222b.c(C2470H.f21956a) : k.f10222b.a(C2490r.e(objB)));
        }
    }

    public static final Object a(x xVar, Object obj) {
        Object objM = xVar.m(obj);
        if (objM instanceof k.c) {
            return ((k) AbstractC1007h.b(null, new a(xVar, obj, null), 1, null)).k();
        }
        return k.f10222b.c(C2470H.f21956a);
    }
}
