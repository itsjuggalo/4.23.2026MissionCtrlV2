package w2;

import android.app.Activity;
import cd.h0;
import kotlin.jvm.functions.Function0;
import ng.c1;
import w2.r;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements n {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v f23653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final x2.a f23654c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s2.e f23655d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends id.m implements pd.o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f23656a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public /* synthetic */ Object f23657b;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Activity f23659d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Activity activity, gd.e eVar) {
            super(2, eVar);
            this.f23659d = activity;
        }

        public static final void o(pg.v vVar, s sVar) {
            vVar.l(sVar);
        }

        public static final h0 q(r rVar, s0.a aVar) {
            rVar.f23654c.a(aVar);
            return h0.f3852a;
        }

        @Override // id.a
        public final gd.e create(Object obj, gd.e eVar) {
            a aVar = r.this.new a(this.f23659d, eVar);
            aVar.f23657b = obj;
            return aVar;
        }

        @Override // id.a
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = hd.c.f();
            int i10 = this.f23656a;
            if (i10 == 0) {
                cd.s.b(obj);
                final pg.v vVar = (pg.v) this.f23657b;
                final s0.a aVar = new s0.a() { // from class: w2.p
                    @Override // s0.a
                    public final void accept(Object obj2) {
                        r.a.o(vVar, (s) obj2);
                    }
                };
                r.this.f23654c.b(this.f23659d, new h2.g(), aVar);
                final r rVar = r.this;
                Function0 function0 = new Function0() { // from class: w2.q
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return r.a.q(rVar, aVar);
                    }
                };
                this.f23656a = 1;
                if (pg.t.a(vVar, function0, this) == objF) {
                    return objF;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                cd.s.b(obj);
            }
            return h0.f3852a;
        }

        @Override // pd.o
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public final Object invoke(pg.v vVar, gd.e eVar) {
            return ((a) create(vVar, eVar)).invokeSuspend(h0.f3852a);
        }
    }

    public r(v windowMetricsCalculator, x2.a windowBackend, s2.e windowSdkExtensions) {
        kotlin.jvm.internal.t.f(windowMetricsCalculator, "windowMetricsCalculator");
        kotlin.jvm.internal.t.f(windowBackend, "windowBackend");
        kotlin.jvm.internal.t.f(windowSdkExtensions, "windowSdkExtensions");
        this.f23653b = windowMetricsCalculator;
        this.f23654c = windowBackend;
        this.f23655d = windowSdkExtensions;
    }

    @Override // w2.n
    public qg.d a(Activity activity) {
        kotlin.jvm.internal.t.f(activity, "activity");
        return qg.f.o(qg.f.c(new a(activity, null)), c1.c());
    }
}
