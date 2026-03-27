package x3;

import W2.E;
import Z2.f;
import a3.AbstractC0787c;
import t3.H;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g extends e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final w3.d f15767d;

    public static final class a extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15768a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f15769b;

        public a(Z2.e eVar) {
            super(2, eVar);
        }

        @Override // i3.o
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(w3.e eVar, Z2.e eVar2) {
            return ((a) create(eVar, eVar2)).invokeSuspend(E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            a aVar = g.this.new a(eVar);
            aVar.f15769b = obj;
            return aVar;
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.f15768a;
            if (i4 == 0) {
                W2.q.b(obj);
                w3.e eVar = (w3.e) this.f15769b;
                g gVar = g.this;
                this.f15768a = 1;
                if (gVar.m(eVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                W2.q.b(obj);
            }
            return E.f5463a;
        }
    }

    public g(w3.d dVar, Z2.i iVar, int i4, v3.a aVar) {
        super(iVar, i4, aVar);
        this.f15767d = dVar;
    }

    public static /* synthetic */ Object j(g gVar, w3.e eVar, Z2.e eVar2) {
        if (gVar.f15758b == -3) {
            Z2.i context = eVar2.getContext();
            Z2.i iVarD = H.d(context, gVar.f15757a);
            if (kotlin.jvm.internal.r.b(iVarD, context)) {
                Object objM = gVar.m(eVar, eVar2);
                return objM == AbstractC0787c.e() ? objM : E.f5463a;
            }
            f.b bVar = Z2.f.f6010J;
            if (kotlin.jvm.internal.r.b(iVarD.get(bVar), context.get(bVar))) {
                Object objL = gVar.l(eVar, iVarD, eVar2);
                return objL == AbstractC0787c.e() ? objL : E.f5463a;
            }
        }
        Object objCollect = super.collect(eVar, eVar2);
        return objCollect == AbstractC0787c.e() ? objCollect : E.f5463a;
    }

    public static /* synthetic */ Object k(g gVar, v3.s sVar, Z2.e eVar) {
        Object objM = gVar.m(new q(sVar), eVar);
        return objM == AbstractC0787c.e() ? objM : E.f5463a;
    }

    @Override // x3.e, w3.d
    public Object collect(w3.e eVar, Z2.e eVar2) {
        return j(this, eVar, eVar2);
    }

    @Override // x3.e
    public Object e(v3.s sVar, Z2.e eVar) {
        return k(this, sVar, eVar);
    }

    public final Object l(w3.e eVar, Z2.i iVar, Z2.e eVar2) {
        Object objC = f.c(iVar, f.d(eVar, eVar2.getContext()), null, new a(null), eVar2, 4, null);
        return objC == AbstractC0787c.e() ? objC : E.f5463a;
    }

    public abstract Object m(w3.e eVar, Z2.e eVar2);

    @Override // x3.e
    public String toString() {
        return this.f15767d + " -> " + super.toString();
    }
}
