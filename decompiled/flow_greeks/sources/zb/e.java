package zb;

import p6.n;
import rb.a0;
import rb.g;
import rb.h;
import rb.y0;
import rb.z0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final y0 f25661a;

        /* JADX INFO: renamed from: zb.e$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public final class C0487a extends a0.a {
            public C0487a(g gVar) {
                super(gVar);
            }

            @Override // rb.a0, rb.g
            public void e(g.a aVar, y0 y0Var) {
                y0Var.m(a.this.f25661a);
                super.e(aVar, y0Var);
            }
        }

        public a(y0 y0Var) {
            this.f25661a = (y0) n.o(y0Var, "extraHeaders");
        }

        @Override // rb.h
        public g a(z0 z0Var, rb.c cVar, rb.d dVar) {
            return new C0487a(dVar.e(z0Var, cVar));
        }
    }

    public static h a(y0 y0Var) {
        return new a(y0Var);
    }
}
