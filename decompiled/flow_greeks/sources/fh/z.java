package fh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final dh.v f9655a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9656b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a extends kotlin.jvm.internal.q implements pd.o {
        public a(Object obj) {
            super(2, obj, z.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
        }

        @Override // pd.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return o((bh.e) obj, ((Number) obj2).intValue());
        }

        public final Boolean o(bh.e p02, int i10) {
            kotlin.jvm.internal.t.f(p02, "p0");
            return Boolean.valueOf(((z) this.receiver).e(p02, i10));
        }
    }

    public z(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        this.f9655a = new dh.v(descriptor, new a(this));
    }

    public final boolean b() {
        return this.f9656b;
    }

    public final void c(int i10) {
        this.f9655a.a(i10);
    }

    public final int d() {
        return this.f9655a.d();
    }

    public final boolean e(bh.e eVar, int i10) {
        boolean z10 = !eVar.p(i10) && eVar.o(i10).j();
        this.f9656b = z10;
        return z10;
    }
}
