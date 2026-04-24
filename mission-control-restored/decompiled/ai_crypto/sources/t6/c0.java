package t6;

import p6.i;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c0 {

    public static final class a extends kotlin.jvm.internal.s implements Q5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlin.jvm.internal.G f24307a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(kotlin.jvm.internal.G g7) {
            super(1);
            this.f24307a = g7;
        }

        public final void a(s6.h it) {
            kotlin.jvm.internal.r.f(it, "it");
            this.f24307a.f18249a = it;
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((s6.h) obj);
            return E5.E.f1657a;
        }
    }

    public static final boolean b(p6.e eVar) {
        return (eVar.e() instanceof p6.d) || eVar.e() == i.b.f22093a;
    }

    public static final s6.h c(s6.a aVar, Object obj, n6.h serializer) {
        kotlin.jvm.internal.r.f(aVar, "<this>");
        kotlin.jvm.internal.r.f(serializer, "serializer");
        kotlin.jvm.internal.G g7 = new kotlin.jvm.internal.G();
        new M(aVar, new a(g7)).s(serializer, obj);
        Object obj2 = g7.f18249a;
        if (obj2 != null) {
            return (s6.h) obj2;
        }
        kotlin.jvm.internal.r.s("result");
        return null;
    }
}
