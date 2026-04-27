package g0;

import E5.E;
import E5.q;
import J5.l;
import Q5.o;
import c0.InterfaceC1119h;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {

    public static final class a extends l implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14252a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f14253b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f14254c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o oVar, H5.d dVar) {
            super(2, dVar);
            this.f14254c = oVar;
        }

        @Override // J5.a
        public final H5.d create(Object obj, H5.d dVar) {
            a aVar = new a(this.f14254c, dVar);
            aVar.f14253b = obj;
            return aVar;
        }

        @Override // Q5.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(f fVar, H5.d dVar) {
            return ((a) create(fVar, dVar)).invokeSuspend(E.f1657a);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = I5.c.e();
            int i7 = this.f14252a;
            if (i7 != 0) {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C1631c c1631c = (C1631c) this.f14253b;
                q.b(obj);
                return c1631c;
            }
            q.b(obj);
            C1631c c1631cC = ((f) this.f14253b).c();
            o oVar = this.f14254c;
            this.f14253b = c1631cC;
            this.f14252a = 1;
            return oVar.invoke(c1631cC, this) == objE ? objE : c1631cC;
        }
    }

    public static final Object a(InterfaceC1119h interfaceC1119h, o oVar, H5.d dVar) {
        return interfaceC1119h.a(new a(oVar, null), dVar);
    }
}
