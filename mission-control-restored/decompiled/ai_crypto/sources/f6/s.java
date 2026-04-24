package f6;

import E5.E;
import g6.J;

/* JADX INFO: loaded from: classes2.dex */
public final class s implements e6.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final H5.g f14224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f14225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Q5.o f14226c;

    public static final class a extends J5.l implements Q5.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14227a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f14228b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e6.e f14229c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(e6.e eVar, H5.d dVar) {
            super(2, dVar);
            this.f14229c = eVar;
        }

        @Override // J5.a
        public final H5.d create(Object obj, H5.d dVar) {
            a aVar = new a(this.f14229c, dVar);
            aVar.f14228b = obj;
            return aVar;
        }

        @Override // Q5.o
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, H5.d dVar) {
            return ((a) create(obj, dVar)).invokeSuspend(E.f1657a);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = I5.c.e();
            int i7 = this.f14227a;
            if (i7 == 0) {
                E5.q.b(obj);
                Object obj2 = this.f14228b;
                e6.e eVar = this.f14229c;
                this.f14227a = 1;
                if (eVar.d(obj2, this) == objE) {
                    return objE;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                E5.q.b(obj);
            }
            return E.f1657a;
        }
    }

    public s(e6.e eVar, H5.g gVar) {
        this.f14224a = gVar;
        this.f14225b = J.b(gVar);
        this.f14226c = new a(eVar, null);
    }

    @Override // e6.e
    public Object d(Object obj, H5.d dVar) {
        Object objB = f.b(this.f14224a, obj, this.f14225b, this.f14226c, dVar);
        return objB == I5.c.e() ? objB : E.f1657a;
    }
}
