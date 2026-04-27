package N4;

import F4.C0487a;
import F4.C0503q;
import F4.P;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final P.e f5773a;

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final P.i f5774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final P.k f5775b;

        /* JADX INFO: renamed from: N4.f$a$a, reason: collision with other inner class name */
        public class C0080a implements P.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ P.k f5776a;

            public C0080a(P.k kVar) {
                this.f5776a = kVar;
            }

            @Override // F4.P.k
            public void a(C0503q c0503q) {
                this.f5776a.a(c0503q);
                a.this.f5775b.a(c0503q);
            }
        }

        public a(P.i iVar, P.k kVar) {
            this.f5774a = (P.i) AbstractC2848n.o(iVar, "delegate");
            this.f5775b = (P.k) AbstractC2848n.o(kVar, "healthListener");
        }

        @Override // N4.d, F4.P.i
        public C0487a c() {
            return super.c().d().d(P.f1649d, Boolean.TRUE).a();
        }

        @Override // N4.d, F4.P.i
        public void h(P.k kVar) {
            this.f5774a.h(new C0080a(kVar));
        }

        @Override // N4.d
        public P.i j() {
            return this.f5774a;
        }
    }

    public f(P.e eVar) {
        this.f5773a = (P.e) AbstractC2848n.o(eVar, "helper");
    }

    @Override // N4.c, F4.P.e
    public P.i a(P.b bVar) {
        P.k kVar = (P.k) bVar.c(P.f1648c);
        P.i iVarA = super.a(bVar);
        return (kVar == null || iVarA.c().b(P.f1649d) != null) ? iVarA : new a(iVarA, kVar);
    }

    @Override // N4.c
    public P.e g() {
        return this.f5773a;
    }
}
