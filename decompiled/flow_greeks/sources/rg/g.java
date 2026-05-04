package rg;

import cd.h0;
import gd.f;
import ng.i0;
import pg.v;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final qg.d f19896d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f19897a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f19898b;

        public a(gd.e eVar) {
            super(2, eVar);
        }

        @Override // pd.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(qg.e eVar, gd.e eVar2) {
            return ((a) create(eVar, eVar2)).invokeSuspend(h0.f3852a);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            a aVar = g.this.new a(eVar);
            aVar.f19898b = obj;
            return aVar;
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.f19897a;
            if (i10 == 0) {
                cd.s.b(obj);
                qg.e eVar = (qg.e) this.f19898b;
                g gVar = g.this;
                this.f19897a = 1;
                if (gVar.m(eVar, this) == objF) {
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

    public g(qg.d dVar, gd.i iVar, int i10, pg.a aVar) {
        super(iVar, i10, aVar);
        this.f19896d = dVar;
    }

    public static /* synthetic */ Object j(g gVar, qg.e eVar, gd.e eVar2) {
        if (gVar.f19887b == -3) {
            gd.i context = eVar2.getContext();
            gd.i iVarJ = i0.j(context, gVar.f19886a);
            if (kotlin.jvm.internal.t.b(iVarJ, context)) {
                Object objM = gVar.m(eVar, eVar2);
                return objM == hd.c.f() ? objM : h0.f3852a;
            }
            f.b bVar = gd.f.K;
            if (kotlin.jvm.internal.t.b(iVarJ.get(bVar), context.get(bVar))) {
                Object objL = gVar.l(eVar, iVarJ, eVar2);
                return objL == hd.c.f() ? objL : h0.f3852a;
            }
        }
        Object objCollect = super.collect(eVar, eVar2);
        return objCollect == hd.c.f() ? objCollect : h0.f3852a;
    }

    public static /* synthetic */ Object k(g gVar, v vVar, gd.e eVar) {
        Object objM = gVar.m(new s(vVar), eVar);
        return objM == hd.c.f() ? objM : h0.f3852a;
    }

    @Override // rg.e, qg.d
    public Object collect(qg.e eVar, gd.e eVar2) {
        return j(this, eVar, eVar2);
    }

    @Override // rg.e
    public Object e(v vVar, gd.e eVar) {
        return k(this, vVar, eVar);
    }

    public final Object l(qg.e eVar, gd.i iVar, gd.e eVar2) {
        return f.c(iVar, f.d(eVar, eVar2.getContext()), null, new a(null), eVar2, 4, null);
    }

    public abstract Object m(qg.e eVar, gd.e eVar2);

    @Override // rg.e
    public String toString() {
        return this.f19896d + " -> " + super.toString();
    }
}
