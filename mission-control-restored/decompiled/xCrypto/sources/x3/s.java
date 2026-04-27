package x3;

import W2.E;
import a3.AbstractC0787c;
import y3.J;

/* JADX INFO: loaded from: classes3.dex */
public final class s implements w3.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Z2.i f15790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f15791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i3.o f15792c;

    public static final class a extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f15794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ w3.e f15795c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(w3.e eVar, Z2.e eVar2) {
            super(2, eVar2);
            this.f15795c = eVar;
        }

        @Override // i3.o
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(Object obj, Z2.e eVar) {
            return ((a) create(obj, eVar)).invokeSuspend(E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            a aVar = new a(this.f15795c, eVar);
            aVar.f15794b = obj;
            return aVar;
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.f15793a;
            if (i4 == 0) {
                W2.q.b(obj);
                Object obj2 = this.f15794b;
                w3.e eVar = this.f15795c;
                this.f15793a = 1;
                if (eVar.emit(obj2, this) == objE) {
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

    public s(w3.e eVar, Z2.i iVar) {
        this.f15790a = iVar;
        this.f15791b = J.b(iVar);
        this.f15792c = new a(eVar, null);
    }

    @Override // w3.e
    public Object emit(Object obj, Z2.e eVar) {
        Object objB = f.b(this.f15790a, obj, this.f15791b, this.f15792c, eVar);
        return objB == AbstractC0787c.e() ? objB : E.f5463a;
    }
}
