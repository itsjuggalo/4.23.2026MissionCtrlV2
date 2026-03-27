package v3;

import W2.E;
import W2.p;
import a3.AbstractC0787c;
import t3.AbstractC1820j;
import t3.L;
import v3.h;

/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class l {

    public static final class a extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f15370a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f15371b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ u f15372c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Object f15373d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(u uVar, Object obj, Z2.e eVar) {
            super(2, eVar);
            this.f15372c = uVar;
            this.f15373d = obj;
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            a aVar = new a(this.f15372c, this.f15373d, eVar);
            aVar.f15371b = obj;
            return aVar;
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objB;
            Object objE = AbstractC0787c.e();
            int i4 = this.f15370a;
            try {
                if (i4 == 0) {
                    W2.q.b(obj);
                    u uVar = this.f15372c;
                    Object obj2 = this.f15373d;
                    p.a aVar = W2.p.f5487b;
                    this.f15370a = 1;
                    if (uVar.a(obj2, this) == objE) {
                        return objE;
                    }
                } else {
                    if (i4 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    W2.q.b(obj);
                }
                objB = W2.p.b(E.f5463a);
            } catch (Throwable th) {
                p.a aVar2 = W2.p.f5487b;
                objB = W2.p.b(W2.q.a(th));
            }
            return h.b(W2.p.h(objB) ? h.f15364b.c(E.f5463a) : h.f15364b.a(W2.p.e(objB)));
        }

        @Override // i3.o
        public final Object invoke(L l4, Z2.e eVar) {
            return ((a) create(l4, eVar)).invokeSuspend(E.f5463a);
        }
    }

    public static final Object a(u uVar, Object obj) {
        Object objM = uVar.m(obj);
        if (objM instanceof h.c) {
            return ((h) AbstractC1820j.b(null, new a(uVar, obj, null), 1, null)).k();
        }
        return h.f15364b.c(E.f5463a);
    }
}
