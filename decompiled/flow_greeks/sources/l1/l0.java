package l1;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l0 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.m implements pd.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15209a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f15210b;

        public a(gd.e eVar) {
            super(3, eVar);
        }

        public final Object a(c0 c0Var, boolean z10, gd.e eVar) {
            a aVar = new a(eVar);
            aVar.f15210b = c0Var;
            return aVar.invokeSuspend(cd.h0.f3852a);
        }

        @Override // pd.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return a((c0) obj, ((Boolean) obj2).booleanValue(), (gd.e) obj3);
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.f15209a;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
                return obj;
            }
            cd.s.b(obj);
            c0 c0Var = (c0) this.f15210b;
            this.f15209a = 1;
            Object objA = c0Var.a(this);
            return objA == objF ? objF : objA;
        }
    }

    public static final Object a(k0 k0Var, gd.e eVar) {
        return k0Var.b(new a(null), eVar);
    }
}
