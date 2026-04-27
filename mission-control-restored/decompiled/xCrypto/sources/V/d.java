package V;

import S.InterfaceC0523i;
import W2.E;
import W2.q;
import a3.AbstractC0787c;
import b3.l;
import i3.o;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public final class d implements InterfaceC0523i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0523i f5278a;

    public static final class a extends l implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f5279a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f5280b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f5281c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o oVar, Z2.e eVar) {
            super(2, eVar);
            this.f5281c = oVar;
        }

        @Override // i3.o
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Object invoke(f fVar, Z2.e eVar) {
            return ((a) create(fVar, eVar)).invokeSuspend(E.f5463a);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            a aVar = new a(this.f5281c, eVar);
            aVar.f5280b = obj;
            return aVar;
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.f5279a;
            if (i4 == 0) {
                q.b(obj);
                f fVar = (f) this.f5280b;
                o oVar = this.f5281c;
                this.f5279a = 1;
                obj = oVar.invoke(fVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.b(obj);
            }
            f fVar2 = (f) obj;
            r.d(fVar2, "null cannot be cast to non-null type androidx.datastore.preferences.core.MutablePreferences");
            ((c) fVar2).g();
            return fVar2;
        }
    }

    public d(InterfaceC0523i delegate) {
        r.f(delegate, "delegate");
        this.f5278a = delegate;
    }

    @Override // S.InterfaceC0523i
    public Object a(o oVar, Z2.e eVar) {
        return this.f5278a.a(new a(oVar, null), eVar);
    }

    @Override // S.InterfaceC0523i
    public w3.d getData() {
        return this.f5278a.getData();
    }
}
