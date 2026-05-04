package d0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class j extends p {
    public j(c0.e eVar) {
        super(eVar);
        eVar.f3465e.f();
        eVar.f3467f.f();
        this.f7482f = ((c0.g) eVar).o1();
    }

    @Override // d0.p, d0.d
    public void a(d dVar) {
        f fVar = this.f7484h;
        if (fVar.f7426c && !fVar.f7433j) {
            this.f7484h.d((int) ((((f) fVar.f7435l.get(0)).f7430g * ((c0.g) this.f7478b).r1()) + 0.5f));
        }
    }

    @Override // d0.p
    public void d() {
        c0.g gVar = (c0.g) this.f7478b;
        int iP1 = gVar.p1();
        int iQ1 = gVar.q1();
        gVar.r1();
        if (gVar.o1() == 1) {
            if (iP1 != -1) {
                this.f7484h.f7435l.add(this.f7478b.f3458a0.f3465e.f7484h);
                this.f7478b.f3458a0.f3465e.f7484h.f7434k.add(this.f7484h);
                this.f7484h.f7429f = iP1;
            } else if (iQ1 != -1) {
                this.f7484h.f7435l.add(this.f7478b.f3458a0.f3465e.f7485i);
                this.f7478b.f3458a0.f3465e.f7485i.f7434k.add(this.f7484h);
                this.f7484h.f7429f = -iQ1;
            } else {
                f fVar = this.f7484h;
                fVar.f7425b = true;
                fVar.f7435l.add(this.f7478b.f3458a0.f3465e.f7485i);
                this.f7478b.f3458a0.f3465e.f7485i.f7434k.add(this.f7484h);
            }
            q(this.f7478b.f3465e.f7484h);
            q(this.f7478b.f3465e.f7485i);
            return;
        }
        if (iP1 != -1) {
            this.f7484h.f7435l.add(this.f7478b.f3458a0.f3467f.f7484h);
            this.f7478b.f3458a0.f3467f.f7484h.f7434k.add(this.f7484h);
            this.f7484h.f7429f = iP1;
        } else if (iQ1 != -1) {
            this.f7484h.f7435l.add(this.f7478b.f3458a0.f3467f.f7485i);
            this.f7478b.f3458a0.f3467f.f7485i.f7434k.add(this.f7484h);
            this.f7484h.f7429f = -iQ1;
        } else {
            f fVar2 = this.f7484h;
            fVar2.f7425b = true;
            fVar2.f7435l.add(this.f7478b.f3458a0.f3467f.f7485i);
            this.f7478b.f3458a0.f3467f.f7485i.f7434k.add(this.f7484h);
        }
        q(this.f7478b.f3467f.f7484h);
        q(this.f7478b.f3467f.f7485i);
    }

    @Override // d0.p
    public void e() {
        if (((c0.g) this.f7478b).o1() == 1) {
            this.f7478b.i1(this.f7484h.f7430g);
        } else {
            this.f7478b.j1(this.f7484h.f7430g);
        }
    }

    @Override // d0.p
    public void f() {
        this.f7484h.c();
    }

    @Override // d0.p
    public boolean m() {
        return false;
    }

    public final void q(f fVar) {
        this.f7484h.f7434k.add(fVar);
        fVar.f7435l.add(this.f7484h);
    }
}
