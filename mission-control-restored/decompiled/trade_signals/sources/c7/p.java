package c7;

import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.V;
import s5.InterfaceC2707e;

/* JADX INFO: loaded from: classes2.dex */
public abstract class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final B5.p f13607a;

    public /* synthetic */ class a extends AbstractC2302q implements B5.p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f13608a = new a();

        public a() {
            super(3, b7.e.class, "emit", "emit(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        }

        @Override // B5.p
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final Object invoke(b7.e eVar, Object obj, InterfaceC2707e interfaceC2707e) {
            return eVar.emit(obj, interfaceC2707e);
        }
    }

    static {
        a aVar = a.f13608a;
        AbstractC2304t.d(aVar, "null cannot be cast to non-null type kotlin.Function3<kotlinx.coroutines.flow.FlowCollector<kotlin.Any?>, kotlin.Any?, kotlin.coroutines.Continuation<kotlin.Unit>, kotlin.Any?>");
        f13607a = (B5.p) V.c(aVar, 3);
    }
}
