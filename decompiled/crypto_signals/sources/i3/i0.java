package i3;

import n0.C0865a;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class i0 implements p5.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i0 f6970a;
    private static final n5.d descriptor;

    static {
        i0 i0Var = new i0();
        f6970a = i0Var;
        p5.m mVar = new p5.m("com.google.firebase.sessions.Time", i0Var, 3);
        mVar.k("ms", false);
        mVar.k("us", true);
        mVar.k("seconds", true);
        descriptor = mVar;
    }

    @Override // p5.e
    public final l5.a[] a() {
        p5.i iVar = p5.i.f9079a;
        return new l5.a[]{iVar, iVar, iVar};
    }

    @Override // l5.a
    public final void b(C0865a c0865a, Object obj) {
        k0 value = (k0) obj;
        kotlin.jvm.internal.j.e(value, "value");
        n5.d dVar = descriptor;
        C0865a c0865aA = c0865a.a(dVar);
        long j4 = value.f6978a;
        c0865aA.e(dVar, 0, j4);
        boolean zO = c0865aA.o(dVar);
        long j6 = value.f6979b;
        if (zO || j6 != ((long) 1000) * j4) {
            c0865aA.e(dVar, 1, j6);
        }
        boolean zO2 = c0865aA.o(dVar);
        long j7 = value.f6980c;
        if (zO2 || j7 != j4 / ((long) 1000)) {
            c0865aA.e(dVar, 2, j7);
        }
        c0865aA.l(dVar);
    }

    @Override // l5.a
    public final Object c(N2.N n6) throws Throwable {
        n5.d dVar = descriptor;
        N2.N nM = n6.m(dVar);
        int i = 0;
        long jS = 0;
        long jS2 = 0;
        long jS3 = 0;
        boolean z6 = true;
        while (z6) {
            int iN = nM.n(dVar);
            if (iN == -1) {
                z6 = false;
            } else if (iN == 0) {
                jS = nM.s(dVar, 0);
                i |= 1;
            } else if (iN == 1) {
                jS2 = nM.s(dVar, 1);
                i |= 2;
            } else {
                if (iN != 2) {
                    throw new l5.d(iN);
                }
                jS3 = nM.s(dVar, 2);
                i |= 4;
            }
        }
        nM.z(dVar);
        return new k0(i, jS, jS2, jS3);
    }

    @Override // l5.a
    public final n5.d d() {
        return descriptor;
    }
}
