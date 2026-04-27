package A;

/* JADX INFO: loaded from: classes.dex */
public class h extends m {
    public h(z.e eVar) {
        super(eVar);
        eVar.f25865e.f();
        eVar.f25867f.f();
        this.f67f = ((z.g) eVar).G0();
    }

    @Override // A.m, A.d
    public void a(d dVar) {
        f fVar = this.f69h;
        if (fVar.f29c && !fVar.f36j) {
            this.f69h.d((int) ((((f) fVar.f38l.get(0)).f33g * ((z.g) this.f63b).J0()) + 0.5f));
        }
    }

    @Override // A.m
    public void d() {
        z.g gVar = (z.g) this.f63b;
        int iH0 = gVar.H0();
        int iI0 = gVar.I0();
        gVar.J0();
        if (gVar.G0() == 1) {
            if (iH0 != -1) {
                this.f69h.f38l.add(this.f63b.f25844N.f25865e.f69h);
                this.f63b.f25844N.f25865e.f69h.f37k.add(this.f69h);
                this.f69h.f32f = iH0;
            } else if (iI0 != -1) {
                this.f69h.f38l.add(this.f63b.f25844N.f25865e.f70i);
                this.f63b.f25844N.f25865e.f70i.f37k.add(this.f69h);
                this.f69h.f32f = -iI0;
            } else {
                f fVar = this.f69h;
                fVar.f28b = true;
                fVar.f38l.add(this.f63b.f25844N.f25865e.f70i);
                this.f63b.f25844N.f25865e.f70i.f37k.add(this.f69h);
            }
            q(this.f63b.f25865e.f69h);
            q(this.f63b.f25865e.f70i);
            return;
        }
        if (iH0 != -1) {
            this.f69h.f38l.add(this.f63b.f25844N.f25867f.f69h);
            this.f63b.f25844N.f25867f.f69h.f37k.add(this.f69h);
            this.f69h.f32f = iH0;
        } else if (iI0 != -1) {
            this.f69h.f38l.add(this.f63b.f25844N.f25867f.f70i);
            this.f63b.f25844N.f25867f.f70i.f37k.add(this.f69h);
            this.f69h.f32f = -iI0;
        } else {
            f fVar2 = this.f69h;
            fVar2.f28b = true;
            fVar2.f38l.add(this.f63b.f25844N.f25867f.f70i);
            this.f63b.f25844N.f25867f.f70i.f37k.add(this.f69h);
        }
        q(this.f63b.f25867f.f69h);
        q(this.f63b.f25867f.f70i);
    }

    @Override // A.m
    public void e() {
        if (((z.g) this.f63b).G0() == 1) {
            this.f63b.B0(this.f69h.f33g);
        } else {
            this.f63b.C0(this.f69h.f33g);
        }
    }

    @Override // A.m
    public void f() {
        this.f69h.c();
    }

    @Override // A.m
    public boolean m() {
        return false;
    }

    public final void q(f fVar) {
        this.f69h.f37k.add(fVar);
        fVar.f38l.add(this.f69h);
    }
}
