package T2;

import K2.C0353a;
import K2.C0369q;
import K2.S;
import Z1.m;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S.e f5119a;

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S.i f5120a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final S.k f5121b;

        /* JADX INFO: renamed from: T2.f$a$a, reason: collision with other inner class name */
        public class C0069a implements S.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ S.k f5122a;

            public C0069a(S.k kVar) {
                this.f5122a = kVar;
            }

            @Override // K2.S.k
            public void a(C0369q c0369q) {
                this.f5122a.a(c0369q);
                a.this.f5121b.a(c0369q);
            }
        }

        public a(S.i iVar, S.k kVar) {
            this.f5120a = (S.i) m.o(iVar, "delegate");
            this.f5121b = (S.k) m.o(kVar, "healthListener");
        }

        @Override // T2.d, K2.S.i
        public C0353a c() {
            return super.c().d().d(S.f1060d, Boolean.TRUE).a();
        }

        @Override // T2.d, K2.S.i
        public void h(S.k kVar) {
            this.f5120a.h(new C0069a(kVar));
        }

        @Override // T2.d
        public S.i j() {
            return this.f5120a;
        }
    }

    public f(S.e eVar) {
        this.f5119a = (S.e) m.o(eVar, "helper");
    }

    @Override // T2.c, K2.S.e
    public S.i a(S.b bVar) {
        S.k kVar = (S.k) bVar.c(S.f1059c);
        S.i iVarA = super.a(bVar);
        return (kVar == null || iVarA.c().b(S.f1060d) != null) ? iVarA : new a(iVarA, kVar);
    }

    @Override // T2.c
    public S.e g() {
        return this.f5119a;
    }
}
