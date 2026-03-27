package f6;

import kotlin.jvm.internal.L;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Q5.p f14218a;

    public /* synthetic */ class a extends kotlin.jvm.internal.o implements Q5.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f14219a = new a();

        public a() {
            super(3, e6.e.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // Q5.p
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public final Object invoke(e6.e eVar, Object obj, H5.d dVar) {
            return eVar.d(obj, dVar);
        }
    }

    static {
        a aVar = a.f14219a;
        kotlin.jvm.internal.r.d(aVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f14218a = (Q5.p) L.b(aVar, 3);
    }
}
