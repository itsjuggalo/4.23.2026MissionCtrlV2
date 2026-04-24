package z;

import z.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean[] f25943a = new boolean[3];

    public static void a(f fVar, y.d dVar, e eVar) {
        eVar.f25875j = -1;
        eVar.f25877k = -1;
        e.b bVar = fVar.f25843M[0];
        e.b bVar2 = e.b.WRAP_CONTENT;
        if (bVar != bVar2 && eVar.f25843M[0] == e.b.MATCH_PARENT) {
            int i7 = eVar.f25832B.f25816e;
            int iN = fVar.N() - eVar.f25834D.f25816e;
            d dVar2 = eVar.f25832B;
            dVar2.f25818g = dVar.q(dVar2);
            d dVar3 = eVar.f25834D;
            dVar3.f25818g = dVar.q(dVar3);
            dVar.f(eVar.f25832B.f25818g, i7);
            dVar.f(eVar.f25834D.f25818g, iN);
            eVar.f25875j = 2;
            eVar.h0(i7, iN);
        }
        if (fVar.f25843M[1] == bVar2 || eVar.f25843M[1] != e.b.MATCH_PARENT) {
            return;
        }
        int i8 = eVar.f25833C.f25816e;
        int iT = fVar.t() - eVar.f25835E.f25816e;
        d dVar4 = eVar.f25833C;
        dVar4.f25818g = dVar.q(dVar4);
        d dVar5 = eVar.f25835E;
        dVar5.f25818g = dVar.q(dVar5);
        dVar.f(eVar.f25833C.f25818g, i8);
        dVar.f(eVar.f25835E.f25818g, iT);
        if (eVar.f25855Y > 0 || eVar.M() == 8) {
            d dVar6 = eVar.f25836F;
            dVar6.f25818g = dVar.q(dVar6);
            dVar.f(eVar.f25836F.f25818g, eVar.f25855Y + i8);
        }
        eVar.f25877k = 2;
        eVar.v0(i8, iT);
    }

    public static final boolean b(int i7, int i8) {
        return (i7 & i8) == i8;
    }
}
