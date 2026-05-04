package p1;

import cd.h0;
import cd.s;
import id.m;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends m implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18188a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f18189b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f18190c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o oVar, gd.e eVar) {
            super(2, eVar);
            this.f18190c = oVar;
        }

        @Override // pd.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(f fVar, gd.e eVar) {
            return ((a) create(fVar, eVar)).invokeSuspend(h0.f3852a);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            a aVar = new a(this.f18190c, eVar);
            aVar.f18189b = obj;
            return aVar;
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.f18188a;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c cVar = (c) this.f18189b;
                s.b(obj);
                return cVar;
            }
            s.b(obj);
            c cVarC = ((f) this.f18189b).c();
            o oVar = this.f18190c;
            this.f18189b = cVarC;
            this.f18188a = 1;
            return oVar.invoke(cVarC, this) == objF ? objF : cVarC;
        }
    }

    public static final Object a(l1.i iVar, o oVar, gd.e eVar) {
        return iVar.a(new a(oVar, null), eVar);
    }
}
