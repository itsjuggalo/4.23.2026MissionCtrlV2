package q7;

import kotlin.jvm.internal.AbstractC2302q;
import kotlin.jvm.internal.AbstractC2304t;
import o7.C2529v;

/* JADX INFO: loaded from: classes2.dex */
public final class D {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2529v f22792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f22793b;

    public /* synthetic */ class a extends AbstractC2302q implements B5.o {
        public a(Object obj) {
            super(2, obj, D.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
        }

        @Override // B5.o
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m((m7.e) obj, ((Number) obj2).intValue());
        }

        public final Boolean m(m7.e p02, int i8) {
            AbstractC2304t.f(p02, "p0");
            return Boolean.valueOf(((D) this.receiver).e(p02, i8));
        }
    }

    public D(m7.e descriptor) {
        AbstractC2304t.f(descriptor, "descriptor");
        this.f22792a = new C2529v(descriptor, new a(this));
    }

    public final boolean b() {
        return this.f22793b;
    }

    public final void c(int i8) {
        this.f22792a.a(i8);
    }

    public final int d() {
        return this.f22792a.d();
    }

    public final boolean e(m7.e eVar, int i8) {
        boolean z7 = !eVar.j(i8) && eVar.h(i8).c();
        this.f22793b = z7;
        return z7;
    }
}
