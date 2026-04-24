package g0;

import E5.E;
import E5.q;
import J5.l;
import Q5.o;
import c0.InterfaceC1119h;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: g0.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1632d implements InterfaceC1119h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC1119h f14245a;

    /* JADX INFO: renamed from: g0.d$a */
    public static final class a extends l implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f14246a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f14247b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f14248c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o oVar, H5.d dVar) {
            super(2, dVar);
            this.f14248c = oVar;
        }

        @Override // J5.a
        public final H5.d create(Object obj, H5.d dVar) {
            a aVar = new a(this.f14248c, dVar);
            aVar.f14247b = obj;
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
            int i7 = this.f14246a;
            if (i7 == 0) {
                q.b(obj);
                f fVar = (f) this.f14247b;
                o oVar = this.f14248c;
                this.f14246a = 1;
                obj = oVar.invoke(fVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i7 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.b(obj);
            }
            f fVar2 = (f) obj;
            r.d(fVar2, "null cannot be cast to non-null type androidx.datastore.preferences.core.MutablePreferences");
            ((C1631c) fVar2).g();
            return fVar2;
        }
    }

    public C1632d(InterfaceC1119h delegate) {
        r.f(delegate, "delegate");
        this.f14245a = delegate;
    }

    @Override // c0.InterfaceC1119h
    public Object a(o oVar, H5.d dVar) {
        return this.f14245a.a(new a(oVar, null), dVar);
    }

    @Override // c0.InterfaceC1119h
    public e6.d getData() {
        return this.f14245a.getData();
    }
}
