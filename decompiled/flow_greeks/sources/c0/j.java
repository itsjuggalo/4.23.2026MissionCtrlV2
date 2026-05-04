package c0;

import c0.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean[] f3533a = new boolean[3];

    public static void a(f fVar, z.d dVar, e eVar) {
        eVar.f3495t = -1;
        eVar.f3497u = -1;
        e.b bVar = fVar.Z[0];
        e.b bVar2 = e.b.WRAP_CONTENT;
        if (bVar != bVar2 && eVar.Z[0] == e.b.MATCH_PARENT) {
            int i10 = eVar.O.f3443g;
            int iU = fVar.U() - eVar.Q.f3443g;
            d dVar2 = eVar.O;
            dVar2.f3445i = dVar.q(dVar2);
            d dVar3 = eVar.Q;
            dVar3.f3445i = dVar.q(dVar3);
            dVar.f(eVar.O.f3445i, i10);
            dVar.f(eVar.Q.f3445i, iU);
            eVar.f3495t = 2;
            eVar.L0(i10, iU);
        }
        if (fVar.Z[1] == bVar2 || eVar.Z[1] != e.b.MATCH_PARENT) {
            return;
        }
        int i11 = eVar.P.f3443g;
        int iV = fVar.v() - eVar.R.f3443g;
        d dVar4 = eVar.P;
        dVar4.f3445i = dVar.q(dVar4);
        d dVar5 = eVar.R;
        dVar5.f3445i = dVar.q(dVar5);
        dVar.f(eVar.P.f3445i, i11);
        dVar.f(eVar.R.f3445i, iV);
        if (eVar.f3480l0 > 0 || eVar.T() == 8) {
            d dVar6 = eVar.S;
            dVar6.f3445i = dVar.q(dVar6);
            dVar.f(eVar.S.f3445i, eVar.f3480l0 + i11);
        }
        eVar.f3497u = 2;
        eVar.b1(i11, iV);
    }

    public static final boolean b(int i10, int i11) {
        return (i10 & i11) == i11;
    }
}
