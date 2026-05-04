package rg;

import cd.h0;
import sg.k0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u implements qg.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gd.i f19918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f19919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pd.o f19920c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19921a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f19922b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ qg.e f19923c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qg.e eVar, gd.e eVar2) {
            super(2, eVar2);
            this.f19923c = eVar;
        }

        @Override // pd.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, gd.e eVar) {
            return ((a) create(obj, eVar)).invokeSuspend(h0.f3852a);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            a aVar = new a(this.f19923c, eVar);
            aVar.f19922b = obj;
            return aVar;
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.f19921a;
            if (i10 == 0) {
                cd.s.b(obj);
                Object obj2 = this.f19922b;
                qg.e eVar = this.f19923c;
                this.f19921a = 1;
                if (eVar.emit(obj2, this) == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
            }
            return h0.f3852a;
        }
    }

    public u(qg.e eVar, gd.i iVar) {
        this.f19918a = iVar;
        this.f19919b = k0.g(iVar);
        this.f19920c = new a(eVar, null);
    }

    @Override // qg.e
    public Object emit(Object obj, gd.e eVar) {
        Object objB = f.b(this.f19918a, obj, this.f19919b, this.f19920c, eVar);
        return objB == hd.c.f() ? objB : h0.f3852a;
    }
}
