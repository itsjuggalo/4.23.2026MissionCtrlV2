package g9;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class r1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final q1 f10359a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j9.q f10360b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10361c;

    public /* synthetic */ r1(q1 q1Var, j9.q qVar, boolean z10, p1 p1Var) {
        this(q1Var, qVar, z10);
    }

    public void a(j9.q qVar) {
        this.f10359a.b(qVar);
    }

    public void b(j9.q qVar, k9.p pVar) {
        this.f10359a.c(qVar, pVar);
    }

    public r1 c(int i10) {
        return new r1(this.f10359a, null, true);
    }

    public r1 d(j9.q qVar) {
        j9.q qVar2 = this.f10360b;
        r1 r1Var = new r1(this.f10359a, qVar2 == null ? null : (j9.q) qVar2.a(qVar), false);
        r1Var.k();
        return r1Var;
    }

    public r1 e(String str) {
        j9.q qVar = this.f10360b;
        r1 r1Var = new r1(this.f10359a, qVar == null ? null : (j9.q) qVar.b(str), false);
        r1Var.l(str);
        return r1Var;
    }

    public RuntimeException f(String str) {
        String str2;
        j9.q qVar = this.f10360b;
        if (qVar == null || qVar.isEmpty()) {
            str2 = "";
        } else {
            str2 = " (found in field " + this.f10360b.toString() + ")";
        }
        return new IllegalArgumentException("Invalid data. " + str + str2);
    }

    public u1 g() {
        return this.f10359a.f10354a;
    }

    public j9.q h() {
        return this.f10360b;
    }

    public boolean i() {
        return this.f10361c;
    }

    public boolean j() {
        int i10 = p1.f10341a[this.f10359a.f10354a.ordinal()];
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return true;
        }
        if (i10 == 4 || i10 == 5) {
            return false;
        }
        throw n9.b.a("Unexpected case for UserDataSource: %s", this.f10359a.f10354a.name());
    }

    public final void k() {
        if (this.f10360b == null) {
            return;
        }
        for (int i10 = 0; i10 < this.f10360b.u(); i10++) {
            l(this.f10360b.o(i10));
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

    public r1(q1 q1Var, j9.q qVar, boolean z10) {
        this.f10359a = q1Var;
        this.f10360b = qVar;
        this.f10361c = z10;
    }
}
