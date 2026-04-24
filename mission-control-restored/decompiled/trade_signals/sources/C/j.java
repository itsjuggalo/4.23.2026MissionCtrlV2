package C;

import C.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean[] f423a = new boolean[3];

    public static void a(f fVar, z.d dVar, e eVar) {
        eVar.f361t = -1;
        eVar.f363u = -1;
        e.b bVar = fVar.f322Z[0];
        e.b bVar2 = e.b.WRAP_CONTENT;
        if (bVar != bVar2 && eVar.f322Z[0] == e.b.MATCH_PARENT) {
            int i8 = eVar.f311O.f272g;
            int iU = fVar.U() - eVar.f313Q.f272g;
            d dVar2 = eVar.f311O;
            dVar2.f274i = dVar.q(dVar2);
            d dVar3 = eVar.f313Q;
            dVar3.f274i = dVar.q(dVar3);
            dVar.f(eVar.f311O.f274i, i8);
            dVar.f(eVar.f313Q.f274i, iU);
            eVar.f361t = 2;
            eVar.L0(i8, iU);
        }
        if (fVar.f322Z[1] == bVar2 || eVar.f322Z[1] != e.b.MATCH_PARENT) {
            return;
        }
        int i9 = eVar.f312P.f272g;
        int iV = fVar.v() - eVar.f314R.f272g;
        d dVar4 = eVar.f312P;
        dVar4.f274i = dVar.q(dVar4);
        d dVar5 = eVar.f314R;
        dVar5.f274i = dVar.q(dVar5);
        dVar.f(eVar.f312P.f274i, i9);
        dVar.f(eVar.f314R.f274i, iV);
        if (eVar.f346l0 > 0 || eVar.T() == 8) {
            d dVar6 = eVar.f315S;
            dVar6.f274i = dVar.q(dVar6);
            dVar.f(eVar.f315S.f274i, eVar.f346l0 + i9);
        }
        eVar.f363u = 2;
        eVar.b1(i9, iV);
    }

    public static final boolean b(int i8, int i9) {
        return (i8 & i9) == i9;
    }
}
