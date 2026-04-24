package c0;

import E5.E;

/* JADX INFO: loaded from: classes.dex */
public abstract class y {

    public static final class a extends J5.l implements Q5.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f9326a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f9327b;

        public a(H5.d dVar) {
            super(3, dVar);
        }

        public final Object h(r rVar, boolean z7, H5.d dVar) {
            a aVar = new a(dVar);
            aVar.f9327b = rVar;
            return aVar.invokeSuspend(E.f1657a);
        }

        @Override // Q5.p
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return h((r) obj, ((Boolean) obj2).booleanValue(), (H5.d) obj3);
        }

        @Override // J5.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = I5.c.e();
            int i7 = this.f9326a;
            if (i7 == 0) {
                E5.q.b(obj);
                r rVar = (r) this.f9327b;
                this.f9326a = 1;
                obj = rVar.a(this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                E5.q.b(obj);
            }
            return obj;
        }
    }

    public static final Object a(x xVar, H5.d dVar) {
        return xVar.b(new a(null), dVar);
    }
}
