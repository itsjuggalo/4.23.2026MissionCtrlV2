package V;

import S.InterfaceC0523i;
import W2.E;
import W2.q;
import a3.AbstractC0787c;
import b3.l;
import i3.o;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    public static final class a extends l implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5287a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f5288b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f5289c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o oVar, Z2.e eVar) {
            super(2, eVar);
            this.f5289c = oVar;
        }

        @Override // i3.o
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(f fVar, Z2.e eVar) {
            return ((a) create(fVar, eVar)).invokeSuspend(E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            a aVar = new a(this.f5289c, eVar);
            aVar.f5288b = obj;
            return aVar;
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.f5287a;
            if (i4 != 0) {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                c cVar = (c) this.f5288b;
                q.b(obj);
                return cVar;
            }
            q.b(obj);
            c cVarC = ((f) this.f5288b).c();
            o oVar = this.f5289c;
            this.f5288b = cVarC;
            this.f5287a = 1;
            return oVar.invoke(cVarC, this) == objE ? objE : cVarC;
        }
    }

    public static final Object a(InterfaceC0523i interfaceC0523i, o oVar, Z2.e eVar) {
        return interfaceC0523i.a(new a(oVar, null), eVar);
    }
}
