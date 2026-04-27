package A5;

import H2.m;
import r5.C2585a;
import r5.C2601q;
import r5.S;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final S.e f282a;

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final S.i f283a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final S.k f284b;

        /* JADX INFO: renamed from: A5.f$a$a, reason: collision with other inner class name */
        public class C0004a implements S.k {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ S.k f285a;

            public C0004a(S.k kVar) {
                this.f285a = kVar;
            }

            @Override // r5.S.k
            public void a(C2601q c2601q) {
                this.f285a.a(c2601q);
                a.this.f284b.a(c2601q);
            }
        }

        public a(S.i iVar, S.k kVar) {
            this.f283a = (S.i) m.o(iVar, "delegate");
            this.f284b = (S.k) m.o(kVar, "healthListener");
        }

        @Override // A5.d, r5.S.i
        public C2585a c() {
            return super.c().d().d(S.f22550d, Boolean.TRUE).a();
        }

        @Override // A5.d, r5.S.i
        public void h(S.k kVar) {
            this.f283a.h(new C0004a(kVar));
        }

        @Override // A5.d
        public S.i j() {
            return this.f283a;
        }
    }

    public f(S.e eVar) {
        this.f282a = (S.e) m.o(eVar, "helper");
    }

    @Override // A5.c, r5.S.e
    public S.i a(S.b bVar) {
        S.k kVar = (S.k) bVar.c(S.f22549c);
        S.i iVarA = super.a(bVar);
        return (kVar == null || iVarA.c().b(S.f22550d) != null) ? iVarA : new a(iVarA, kVar);
    }

    @Override // A5.c
    public S.e g() {
        return this.f282a;
    }
}
