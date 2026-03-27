package D;

/* JADX INFO: loaded from: classes.dex */
public class j extends p {
    public j(C.e eVar) {
        super(eVar);
        eVar.f331e.f();
        eVar.f333f.f();
        this.f728f = ((C.g) eVar).o1();
    }

    @Override // D.p, D.d
    public void a(d dVar) {
        f fVar = this.f730h;
        if (fVar.f672c && !fVar.f679j) {
            this.f730h.d((int) ((((f) fVar.f681l.get(0)).f676g * ((C.g) this.f724b).r1()) + 0.5f));
        }
    }

    @Override // D.p
    public void d() {
        f fVar;
        p pVar;
        f fVar2;
        C.g gVar = (C.g) this.f724b;
        int iP1 = gVar.p1();
        int iQ1 = gVar.q1();
        gVar.r1();
        if (gVar.o1() == 1) {
            f fVar3 = this.f730h;
            if (iP1 != -1) {
                fVar3.f681l.add(this.f724b.f324a0.f331e.f730h);
                this.f724b.f324a0.f331e.f730h.f680k.add(this.f730h);
                fVar2 = this.f730h;
            } else if (iQ1 != -1) {
                fVar3.f681l.add(this.f724b.f324a0.f331e.f731i);
                this.f724b.f324a0.f331e.f731i.f680k.add(this.f730h);
                fVar2 = this.f730h;
                iP1 = -iQ1;
            } else {
                fVar3.f671b = true;
                fVar3.f681l.add(this.f724b.f324a0.f331e.f731i);
                this.f724b.f324a0.f331e.f731i.f680k.add(this.f730h);
                q(this.f724b.f331e.f730h);
                pVar = this.f724b.f331e;
            }
            fVar2.f675f = iP1;
            q(this.f724b.f331e.f730h);
            pVar = this.f724b.f331e;
        } else {
            f fVar4 = this.f730h;
            if (iP1 != -1) {
                fVar4.f681l.add(this.f724b.f324a0.f333f.f730h);
                this.f724b.f324a0.f333f.f730h.f680k.add(this.f730h);
                fVar = this.f730h;
            } else if (iQ1 != -1) {
                fVar4.f681l.add(this.f724b.f324a0.f333f.f731i);
                this.f724b.f324a0.f333f.f731i.f680k.add(this.f730h);
                fVar = this.f730h;
                iP1 = -iQ1;
            } else {
                fVar4.f671b = true;
                fVar4.f681l.add(this.f724b.f324a0.f333f.f731i);
                this.f724b.f324a0.f333f.f731i.f680k.add(this.f730h);
                q(this.f724b.f333f.f730h);
                pVar = this.f724b.f333f;
            }
            fVar.f675f = iP1;
            q(this.f724b.f333f.f730h);
            pVar = this.f724b.f333f;
        }
        q(pVar.f731i);
    }

    @Override // D.p
    public void e() {
        if (((C.g) this.f724b).o1() == 1) {
            this.f724b.i1(this.f730h.f676g);
        } else {
            this.f724b.j1(this.f730h.f676g);
        }
    }

    @Override // D.p
    public void f() {
        this.f730h.c();
    }

    @Override // D.p
    public boolean m() {
        return false;
    }

    public final void q(f fVar) {
        this.f730h.f680k.add(fVar);
        fVar.f681l.add(this.f730h);
    }
}
