package A0;

import A0.i;
import W2.E;
import W2.q;
import a3.AbstractC0787c;
import android.app.Activity;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.s;
import t3.C1803a0;

/* JADX INFO: loaded from: classes.dex */
public final class i implements f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final l f35b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final B0.a f36c;

    public static final class a extends b3.l implements i3.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f37a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f38b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Activity f40d;

        /* JADX INFO: renamed from: A0.i$a$a, reason: collision with other inner class name */
        public static final class C0003a extends s implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ i f41a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ G.a f42b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0003a(i iVar, G.a aVar) {
                super(0);
                this.f41a = iVar;
                this.f42b = aVar;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m0invoke();
                return E.f5463a;
            }

            /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
            public final void m0invoke() {
                this.f41a.f36c.a(this.f42b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Activity activity, Z2.e eVar) {
            super(2, eVar);
            this.f40d = activity;
        }

        public static final void c(v3.s sVar, j jVar) {
            sVar.m(jVar);
        }

        @Override // b3.AbstractC0863a
        public final Z2.e create(Object obj, Z2.e eVar) {
            a aVar = i.this.new a(this.f40d, eVar);
            aVar.f38b = obj;
            return aVar;
        }

        @Override // b3.AbstractC0863a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = AbstractC0787c.e();
            int i4 = this.f37a;
            if (i4 == 0) {
                q.b(obj);
                final v3.s sVar = (v3.s) this.f38b;
                G.a aVar = new G.a() { // from class: A0.h
                    @Override // G.a
                    public final void accept(Object obj2) {
                        i.a.c(sVar, (j) obj2);
                    }
                };
                i.this.f36c.b(this.f40d, new l0.k(), aVar);
                C0003a c0003a = new C0003a(i.this, aVar);
                this.f37a = 1;
                if (v3.q.a(sVar, c0003a, this) == objE) {
                    return objE;
                }
            } else {
                if (i4 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                q.b(obj);
            }
            return E.f5463a;
        }

        @Override // i3.o
        public final Object invoke(v3.s sVar, Z2.e eVar) {
            return ((a) create(sVar, eVar)).invokeSuspend(E.f5463a);
        }
    }

    public i(l windowMetricsCalculator, B0.a windowBackend) {
        r.f(windowMetricsCalculator, "windowMetricsCalculator");
        r.f(windowBackend, "windowBackend");
        this.f35b = windowMetricsCalculator;
        this.f36c = windowBackend;
    }

    @Override // A0.f
    public w3.d a(Activity activity) {
        r.f(activity, "activity");
        return w3.f.n(w3.f.c(new a(activity, null)), C1803a0.c());
    }
}
