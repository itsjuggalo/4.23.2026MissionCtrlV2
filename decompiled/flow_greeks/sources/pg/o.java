package pg;

import cd.h0;
import cd.r;
import ng.n0;
import pg.k;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class o {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18675a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f18676b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ x f18677c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f18678d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(x xVar, Object obj, gd.e eVar) {
            super(2, eVar);
            this.f18677c = xVar;
            this.f18678d = obj;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            a aVar = new a(this.f18677c, this.f18678d, eVar);
            aVar.f18676b = obj;
            return aVar;
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objB;
            Object objF = hd.c.f();
            int i10 = this.f18675a;
            try {
                if (i10 == 0) {
                    cd.s.b(obj);
                    x xVar = this.f18677c;
                    Object obj2 = this.f18678d;
                    r.a aVar = cd.r.f3870b;
                    this.f18675a = 1;
                    if (xVar.i(obj2, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i10 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    cd.s.b(obj);
                }
                objB = cd.r.b(h0.f3852a);
            } catch (Throwable th) {
                r.a aVar2 = cd.r.f3870b;
                objB = cd.r.b(cd.s.a(th));
            }
            return k.b(cd.r.h(objB) ? k.f18669b.c(h0.f3852a) : k.f18669b.a(cd.r.e(objB)));
        }

        @Override // pd.o
        public final Object invoke(n0 n0Var, gd.e eVar) {
            return ((a) create(n0Var, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    public static final Object a(x xVar, Object obj) {
        Object objL = xVar.l(obj);
        if (objL instanceof k.c) {
            return ((k) ng.j.b(null, new a(xVar, obj, null), 1, null)).k();
        }
        return k.f18669b.c(h0.f3852a);
    }
}
