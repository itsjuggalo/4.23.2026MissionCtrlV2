package C;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class k extends e {

    /* JADX INFO: renamed from: L0, reason: collision with root package name */
    public ArrayList f424L0 = new ArrayList();

    public void a(e eVar) {
        this.f424L0.add(eVar);
        if (eVar.I() != null) {
            ((k) eVar.I()).p1(eVar);
        }
        eVar.Y0(this);
    }

    public ArrayList n1() {
        return this.f424L0;
    }

    public abstract void o1();

    public void p1(e eVar) {
        this.f424L0.remove(eVar);
        eVar.r0();
    }

    public void q1() {
        this.f424L0.clear();
    }

    @Override // C.e
    public void r0() {
        this.f424L0.clear();
        super.r0();
    }

    @Override // C.e
    public void t0(z.c cVar) {
        super.t0(cVar);
        int size = this.f424L0.size();
        for (int i8 = 0; i8 < size; i8++) {
            ((e) this.f424L0.get(i8)).t0(cVar);
        }
    }
}
