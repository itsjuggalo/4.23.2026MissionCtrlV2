package t3;

import Z2.f;
import Z2.i;
import kotlin.jvm.internal.AbstractC1585j;
import y3.AbstractC1960n;
import y3.C1956j;
import y3.C1959m;

/* JADX INFO: loaded from: classes3.dex */
public abstract class I extends Z2.a implements Z2.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f14947b = new a(null);

    public static final class a extends Z2.b {

        /* JADX INFO: renamed from: t3.I$a$a, reason: collision with other inner class name */
        public static final class C0242a extends kotlin.jvm.internal.s implements i3.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0242a f14948a = new C0242a();

            public C0242a() {
                super(1);
            }

            @Override // i3.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final I invoke(i.b bVar) {
                if (bVar instanceof I) {
                    return (I) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(AbstractC1585j abstractC1585j) {
            this();
        }

        public a() {
            super(Z2.f.f6010J, C0242a.f14948a);
        }
    }

    public I() {
        super(Z2.f.f6010J);
    }

    @Override // Z2.f
    public final Z2.e J(Z2.e eVar) {
        return new C1956j(this, eVar);
    }

    @Override // Z2.f
    public final void S(Z2.e eVar) {
        kotlin.jvm.internal.r.d(eVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((C1956j) eVar).s();
    }

    public abstract void d0(Z2.i iVar, Runnable runnable);

    public boolean e0(Z2.i iVar) {
        return true;
    }

    public I f0(int i4) {
        AbstractC1960n.a(i4);
        return new C1959m(this, i4);
    }

    @Override // Z2.a, Z2.i.b, Z2.i
    public i.b get(i.c cVar) {
        return f.a.a(this, cVar);
    }

    @Override // Z2.a, Z2.i.b, Z2.i
    public Z2.i minusKey(i.c cVar) {
        return f.a.b(this, cVar);
    }

    public String toString() {
        return P.a(this) + '@' + P.b(this);
    }
}
