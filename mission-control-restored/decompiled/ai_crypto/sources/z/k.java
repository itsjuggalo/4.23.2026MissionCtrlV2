package z;

import java.util.ArrayList;
import y.C2831c;

/* JADX INFO: loaded from: classes.dex */
public abstract class k extends e {

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public ArrayList f25944w0 = new ArrayList();

    public abstract void G0();

    public void H0(e eVar) {
        this.f25944w0.remove(eVar);
        eVar.s0(null);
    }

    public void I0() {
        this.f25944w0.clear();
    }

    @Override // z.e
    public void W() {
        this.f25944w0.clear();
        super.W();
    }

    @Override // z.e
    public void X(C2831c c2831c) {
        super.X(c2831c);
        int size = this.f25944w0.size();
        for (int i7 = 0; i7 < size; i7++) {
            ((e) this.f25944w0.get(i7)).X(c2831c);
        }
    }

    public void b(e eVar) {
        this.f25944w0.add(eVar);
        if (eVar.E() != null) {
            ((k) eVar.E()).H0(eVar);
        }
        eVar.s0(this);
    }
}
