package x3;

import kotlin.jvm.internal.K;

/* JADX INFO: loaded from: classes3.dex */
public abstract class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i3.p f15784a;

    public /* synthetic */ class a extends kotlin.jvm.internal.o implements i3.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15785a = new a();

        public a() {
            super(3, w3.e.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // i3.p
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public final Object invoke(w3.e eVar, Object obj, Z2.e eVar2) {
            return eVar.emit(obj, eVar2);
        }
    }

    static {
        a aVar = a.f15785a;
        kotlin.jvm.internal.r.d(aVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f15784a = (i3.p) K.b(aVar, 3);
    }
}
