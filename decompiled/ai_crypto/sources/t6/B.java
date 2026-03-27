package t6;

import r6.C2634v;

/* JADX INFO: loaded from: classes2.dex */
public final class B {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2634v f24232a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f24233b;

    public /* synthetic */ class a extends kotlin.jvm.internal.o implements Q5.o {
        public a(Object obj) {
            super(2, obj, B.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
        }

        public final Boolean e(p6.e p02, int i7) {
            kotlin.jvm.internal.r.f(p02, "p0");
            return Boolean.valueOf(((B) this.receiver).e(p02, i7));
        }

        @Override // Q5.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return e((p6.e) obj, ((Number) obj2).intValue());
        }
    }

    public B(p6.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        this.f24232a = new C2634v(descriptor, new a(this));
    }

    public final boolean b() {
        return this.f24233b;
    }

    public final void c(int i7) {
        this.f24232a.a(i7);
    }

    public final int d() {
        return this.f24232a.d();
    }

    public final boolean e(p6.e eVar, int i7) {
        boolean z7 = !eVar.j(i7) && eVar.i(i7).c();
        this.f24233b = z7;
        return z7;
    }
}
