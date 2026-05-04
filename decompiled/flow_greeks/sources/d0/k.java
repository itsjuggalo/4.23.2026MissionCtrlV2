package d0;

import d0.f;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class k extends p {
    public k(c0.e eVar) {
        super(eVar);
    }

    private void q(f fVar) {
        this.f7484h.f7434k.add(fVar);
        fVar.f7435l.add(this.f7484h);
    }

    @Override // d0.p, d0.d
    public void a(d dVar) {
        c0.a aVar = (c0.a) this.f7478b;
        int iR1 = aVar.r1();
        Iterator it = this.f7484h.f7435l.iterator();
        int i10 = 0;
        int i11 = -1;
        while (it.hasNext()) {
            int i12 = ((f) it.next()).f7430g;
            if (i11 == -1 || i12 < i11) {
                i11 = i12;
            }
            if (i10 < i12) {
                i10 = i12;
            }
        }
        if (iR1 == 0 || iR1 == 2) {
            this.f7484h.d(i11 + aVar.s1());
        } else {
            this.f7484h.d(i10 + aVar.s1());
        }
    }

    @Override // d0.p
    public void d() {
        c0.e eVar = this.f7478b;
        if (eVar instanceof c0.a) {
            this.f7484h.f7425b = true;
            c0.a aVar = (c0.a) eVar;
            int iR1 = aVar.r1();
            boolean zQ1 = aVar.q1();
            int i10 = 0;
            if (iR1 == 0) {
                this.f7484h.f7428e = f.a.LEFT;
                while (i10 < aVar.M0) {
                    c0.e eVar2 = aVar.L0[i10];
                    if (zQ1 || eVar2.T() != 8) {
                        f fVar = eVar2.f3465e.f7484h;
                        fVar.f7434k.add(this.f7484h);
                        this.f7484h.f7435l.add(fVar);
                    }
                    i10++;
                }
                q(this.f7478b.f3465e.f7484h);
                q(this.f7478b.f3465e.f7485i);
                return;
            }
            if (iR1 == 1) {
                this.f7484h.f7428e = f.a.RIGHT;
                while (i10 < aVar.M0) {
                    c0.e eVar3 = aVar.L0[i10];
                    if (zQ1 || eVar3.T() != 8) {
                        f fVar2 = eVar3.f3465e.f7485i;
                        fVar2.f7434k.add(this.f7484h);
                        this.f7484h.f7435l.add(fVar2);
                    }
                    i10++;
                }
                q(this.f7478b.f3465e.f7484h);
                q(this.f7478b.f3465e.f7485i);
                return;
            }
            if (iR1 == 2) {
                this.f7484h.f7428e = f.a.TOP;
                while (i10 < aVar.M0) {
                    c0.e eVar4 = aVar.L0[i10];
                    if (zQ1 || eVar4.T() != 8) {
                        f fVar3 = eVar4.f3467f.f7484h;
                        fVar3.f7434k.add(this.f7484h);
                        this.f7484h.f7435l.add(fVar3);
                    }
                    i10++;
                }
                q(this.f7478b.f3467f.f7484h);
                q(this.f7478b.f3467f.f7485i);
                return;
            }
            if (iR1 != 3) {
                return;
            }
            this.f7484h.f7428e = f.a.BOTTOM;
            while (i10 < aVar.M0) {
                c0.e eVar5 = aVar.L0[i10];
                if (zQ1 || eVar5.T() != 8) {
                    f fVar4 = eVar5.f3467f.f7485i;
                    fVar4.f7434k.add(this.f7484h);
                    this.f7484h.f7435l.add(fVar4);
                }
                i10++;
            }
            q(this.f7478b.f3467f.f7484h);
            q(this.f7478b.f3467f.f7485i);
        }
    }

    @Override // d0.p
    public void e() {
        c0.e eVar = this.f7478b;
        if (eVar instanceof c0.a) {
            int iR1 = ((c0.a) eVar).r1();
            if (iR1 == 0 || iR1 == 1) {
                this.f7478b.i1(this.f7484h.f7430g);
            } else {
                this.f7478b.j1(this.f7484h.f7430g);
            }
        }
    }

    @Override // d0.p
    public void f() {
        this.f7479c = null;
        this.f7484h.c();
    }

    @Override // d0.p
    public boolean m() {
        return false;
    }
}
