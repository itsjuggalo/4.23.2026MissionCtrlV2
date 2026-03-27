package S;

import a3.AbstractC0787c;

/* JADX INFO: loaded from: classes.dex */
public abstract class G {

    public static final class a extends b3.l implements i3.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f3596a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f3597b;

        public a(Z2.e eVar) {
            super(3, eVar);
        }

        public final Object b(y yVar, boolean z4, Z2.e eVar) {
            a aVar = new a(eVar);
            aVar.f3597b = yVar;
            return aVar.invokeSuspend(W2.E.f5463a);
        }

        @Override // i3.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return b((y) obj, ((Boolean) obj2).booleanValue(), (Z2.e) obj3);
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.f3596a;
            if (i4 != 0) {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
                return obj;
            }
            W2.q.b(obj);
            y yVar = (y) this.f3597b;
            this.f3596a = 1;
            Object objE2 = yVar.e(this);
            return objE2 == objE ? objE : objE2;
        }
    }

    public static final Object a(F f4, Z2.e eVar) {
        return f4.a(new a(null), eVar);
    }
}
