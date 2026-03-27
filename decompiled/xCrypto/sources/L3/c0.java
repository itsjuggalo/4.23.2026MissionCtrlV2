package L3;

import H3.i;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c0 {

    public static final class a extends kotlin.jvm.internal.s implements i3.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.F f1514a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kotlin.jvm.internal.F f4) {
            super(1);
            this.f1514a = f4;
        }

        public final void a(K3.h it) {
            kotlin.jvm.internal.r.f(it, "it");
            this.f1514a.f13410a = it;
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((K3.h) obj);
            return W2.E.f5463a;
        }
    }

    public static final boolean b(H3.e eVar) {
        return (eVar.e() instanceof H3.d) || eVar.e() == i.b.f765a;
    }

    public static final K3.h c(K3.a aVar, Object obj, F3.h serializer) {
        kotlin.jvm.internal.r.f(aVar, "<this>");
        kotlin.jvm.internal.r.f(serializer, "serializer");
        kotlin.jvm.internal.F f4 = new kotlin.jvm.internal.F();
        new M(aVar, new a(f4)).z(serializer, obj);
        Object obj2 = f4.f13410a;
        if (obj2 != null) {
            return (K3.h) obj2;
        }
        kotlin.jvm.internal.r.t("result");
        return null;
    }
}
