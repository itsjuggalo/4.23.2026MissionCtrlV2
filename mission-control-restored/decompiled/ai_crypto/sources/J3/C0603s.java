package J3;

import r5.Z;

/* JADX INFO: renamed from: J3.s, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C0603s implements I {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Z.g f3277d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Z.g f3278e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Z.g f3279f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final N3.b f3280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final N3.b f3281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Q2.p f3282c;

    static {
        Z.d dVar = r5.Z.f22587e;
        f3277d = Z.g.e("x-firebase-client-log-type", dVar);
        f3278e = Z.g.e("x-firebase-client", dVar);
        f3279f = Z.g.e("x-firebase-gmpid", dVar);
    }

    public C0603s(N3.b bVar, N3.b bVar2, Q2.p pVar) {
        this.f3281b = bVar;
        this.f3280a = bVar2;
        this.f3282c = pVar;
    }

    @Override // J3.I
    public void a(r5.Z z7) {
        if (this.f3280a.get() == null || this.f3281b.get() == null) {
            return;
        }
        int iB = ((L3.j) this.f3280a.get()).b("fire-fst").b();
        if (iB != 0) {
            z7.p(f3277d, Integer.toString(iB));
        }
        z7.p(f3278e, ((X3.i) this.f3281b.get()).a());
        b(z7);
    }

    public final void b(r5.Z z7) {
        Q2.p pVar = this.f3282c;
        if (pVar == null) {
            return;
        }
        String strC = pVar.c();
        if (strC.length() != 0) {
            z7.p(f3279f, strC);
        }
    }
}
