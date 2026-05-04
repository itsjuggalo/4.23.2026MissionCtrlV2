package c0;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class k extends e {
    public ArrayList L0 = new ArrayList();

    public void a(e eVar) {
        this.L0.add(eVar);
        if (eVar.I() != null) {
            ((k) eVar.I()).p1(eVar);
        }
        eVar.Y0(this);
    }

    public ArrayList n1() {
        return this.L0;
    }

    public abstract void o1();

    public void p1(e eVar) {
        this.L0.remove(eVar);
        eVar.r0();
    }

    public void q1() {
        this.L0.clear();
    }

    @Override // c0.e
    public void r0() {
        this.L0.clear();
        super.r0();
    }

    @Override // c0.e
    public void t0(z.c cVar) {
        super.t0(cVar);
        int size = this.L0.size();
        for (int i10 = 0; i10 < size; i10++) {
            ((e) this.L0.get(i10)).t0(cVar);
        }
    }
}
