package L3;

import J3.C0348v;

/* JADX INFO: loaded from: classes3.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0348v f1439a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1440b;

    public /* synthetic */ class a extends kotlin.jvm.internal.o implements i3.o {
        public a(Object obj) {
            super(2, obj, B.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
        }

        public final Boolean d(H3.e p02, int i4) {
            kotlin.jvm.internal.r.f(p02, "p0");
            return Boolean.valueOf(((B) this.receiver).e(p02, i4));
        }

        @Override // i3.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return d((H3.e) obj, ((Number) obj2).intValue());
        }
    }

    public B(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        this.f1439a = new C0348v(descriptor, new a(this));
    }

    public final boolean b() {
        return this.f1440b;
    }

    public final void c(int i4) {
        this.f1439a.a(i4);
    }

    public final int d() {
        return this.f1439a.d();
    }

    public final boolean e(H3.e eVar, int i4) {
        boolean z4 = !eVar.j(i4) && eVar.i(i4).c();
        this.f1440b = z4;
        return z4;
    }
}
