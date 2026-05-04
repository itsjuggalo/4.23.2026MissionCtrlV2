package ac;

import p6.n;
import rb.q;
import rb.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0.e f626a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r0.i f627a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final r0.k f628b;

        /* JADX INFO: renamed from: ac.f$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public class C0006a implements r0.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ r0.k f629a;

            public C0006a(r0.k kVar) {
                this.f629a = kVar;
            }

            @Override // rb.r0.k
            public void a(q qVar) {
                this.f629a.a(qVar);
                a.this.f628b.a(qVar);
            }
        }

        public a(r0.i iVar, r0.k kVar) {
            this.f627a = (r0.i) n.o(iVar, "delegate");
            this.f628b = (r0.k) n.o(kVar, "healthListener");
        }

        @Override // ac.d, rb.r0.i
        public rb.a c() {
            return super.c().d().d(r0.f19693d, Boolean.TRUE).a();
        }

        @Override // ac.d, rb.r0.i
        public void h(r0.k kVar) {
            this.f627a.h(new C0006a(kVar));
        }

        @Override // ac.d
        public r0.i j() {
            return this.f627a;
        }
    }

    public f(r0.e eVar) {
        this.f626a = (r0.e) n.o(eVar, "helper");
    }

    @Override // ac.c, rb.r0.e
    public r0.i a(r0.b bVar) {
        r0.k kVar = (r0.k) bVar.c(r0.f19692c);
        r0.i iVarA = super.a(bVar);
        return (kVar == null || iVarA.c().b(r0.f19693d) != null) ? iVarA : new a(iVarA, kVar);
    }

    @Override // ac.c
    public r0.e g() {
        return this.f626a;
    }
}
