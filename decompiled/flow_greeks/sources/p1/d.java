package p1;

import cd.h0;
import cd.s;
import id.m;
import kotlin.jvm.internal.t;
import pd.o;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements l1.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l1.i f18179a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends m implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f18180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f18181b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f18182c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(o oVar, gd.e eVar) {
            super(2, eVar);
            this.f18182c = oVar;
        }

        @Override // pd.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Object invoke(f fVar, gd.e eVar) {
            return ((a) create(fVar, eVar)).invokeSuspend(h0.f3852a);
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            a aVar = new a(this.f18182c, eVar);
            aVar.f18181b = obj;
            return aVar;
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.f18180a;
            if (i10 == 0) {
                s.b(obj);
                f fVar = (f) this.f18181b;
                o oVar = this.f18182c;
                this.f18180a = 1;
                obj = oVar.invoke(fVar, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                s.b(obj);
            }
            f fVar2 = (f) obj;
            t.d(fVar2, "null cannot be cast to non-null type androidx.datastore.preferences.core.MutablePreferences");
            ((c) fVar2).g();
            return fVar2;
        }
    }

    public d(l1.i delegate) {
        t.f(delegate, "delegate");
        this.f18179a = delegate;
    }

    @Override // l1.i
    public Object a(o oVar, gd.e eVar) {
        return this.f18179a.a(new a(oVar, null), eVar);
    }

    @Override // l1.i
    public qg.d getData() {
        return this.f18179a.getData();
    }
}
