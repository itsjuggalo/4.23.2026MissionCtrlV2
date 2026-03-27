package D3;

import K3.AbstractC0612b;

/* JADX INFO: loaded from: classes.dex */
public class s0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f1428a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final G3.q f1429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f1430c;

    public /* synthetic */ s0(r0 r0Var, G3.q qVar, boolean z7, q0 q0Var) {
        this(r0Var, qVar, z7);
    }

    public void a(G3.q qVar) {
        this.f1428a.b(qVar);
    }

    public void b(G3.q qVar, H3.p pVar) {
        this.f1428a.c(qVar, pVar);
    }

    public s0 c(int i7) {
        return new s0(this.f1428a, null, true);
    }

    public s0 d(G3.q qVar) {
        G3.q qVar2 = this.f1429b;
        s0 s0Var = new s0(this.f1428a, qVar2 == null ? null : (G3.q) qVar2.a(qVar), false);
        s0Var.k();
        return s0Var;
    }

    public s0 e(String str) {
        G3.q qVar = this.f1429b;
        s0 s0Var = new s0(this.f1428a, qVar == null ? null : (G3.q) qVar.b(str), false);
        s0Var.l(str);
        return s0Var;
    }

    public RuntimeException f(String str) {
        String str2;
        G3.q qVar = this.f1429b;
        if (qVar == null || qVar.n()) {
            str2 = "";
        } else {
            str2 = " (found in field " + this.f1429b.toString() + ")";
        }
        return new IllegalArgumentException("Invalid data. " + str + str2);
    }

    public v0 g() {
        return this.f1428a.f1423a;
    }

    public G3.q h() {
        return this.f1429b;
    }

    public boolean i() {
        return this.f1430c;
    }

    public boolean j() {
        int i7 = q0.f1421a[this.f1428a.f1423a.ordinal()];
        if (i7 == 1 || i7 == 2 || i7 == 3) {
            return true;
        }
        if (i7 == 4 || i7 == 5) {
            return false;
        }
        throw AbstractC0612b.a("Unexpected case for UserDataSource: %s", this.f1428a.f1423a.name());
    }

    public final void k() {
        if (this.f1429b == null) {
            return;
        }
        for (int i7 = 0; i7 < this.f1429b.q(); i7++) {
            l(this.f1429b.m(i7));
        }
    }

    public final void l(String str) {
        if (str.isEmpty()) {
            throw f("Document fields must not be empty");
        }
        if (j() && str.startsWith("__") && str.endsWith("__")) {
            throw f("Document fields cannot begin and end with \"__\"");
        }
    }

    public s0(r0 r0Var, G3.q qVar, boolean z7) {
        this.f1428a = r0Var;
        this.f1429b = qVar;
        this.f1430c = z7;
    }
}
