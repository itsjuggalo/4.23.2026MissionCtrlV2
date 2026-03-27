package b6;

import H5.e;
import H5.g;
import g6.AbstractC1654n;
import g6.C1650j;
import g6.C1653m;
import kotlin.jvm.internal.AbstractC2148j;

/* JADX INFO: loaded from: classes2.dex */
public abstract class I extends H5.a implements H5.e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9005b = new a(null);

    public static final class a extends H5.b {

        /* JADX INFO: renamed from: b6.I$a$a, reason: collision with other inner class name */
        public static final class C0147a extends kotlin.jvm.internal.s implements Q5.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0147a f9006a = new C0147a();

            public C0147a() {
                super(1);
            }

            @Override // Q5.k
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final I invoke(g.b bVar) {
                if (bVar instanceof I) {
                    return (I) bVar;
                }
                return null;
            }
        }

        public /* synthetic */ a(AbstractC2148j abstractC2148j) {
            this();
        }

        public a() {
            super(H5.e.f2668J, C0147a.f9006a);
        }
    }

    public I() {
        super(H5.e.f2668J);
    }

    @Override // H5.e
    public final void A(H5.d dVar) {
        kotlin.jvm.internal.r.d(dVar, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((C1650j) dVar).s();
    }

    public I A0(int i7) {
        AbstractC1654n.a(i7);
        return new C1653m(this, i7);
    }

    @Override // H5.e
    public final H5.d K(H5.d dVar) {
        return new C1650j(this, dVar);
    }

    @Override // H5.a, H5.g.b, H5.g
    public g.b get(g.c cVar) {
        return e.a.a(this, cVar);
    }

    @Override // H5.a, H5.g.b, H5.g
    public H5.g minusKey(g.c cVar) {
        return e.a.b(this, cVar);
    }

    public String toString() {
        return P.a(this) + '@' + P.b(this);
    }

    public abstract void y0(H5.g gVar, Runnable runnable);

    public boolean z0(H5.g gVar) {
        return true;
    }
}
