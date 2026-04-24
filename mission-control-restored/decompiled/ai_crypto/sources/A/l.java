package A;

import A.f;
import A.m;
import z.d;
import z.e;

/* JADX INFO: loaded from: classes.dex */
public class l extends m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f59k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f60l;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f61a;

        static {
            int[] iArr = new int[m.b.values().length];
            f61a = iArr;
            try {
                iArr[m.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f61a[m.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f61a[m.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(z.e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.f59k = fVar;
        this.f60l = null;
        this.f69h.f31e = f.a.TOP;
        this.f70i.f31e = f.a.BOTTOM;
        fVar.f31e = f.a.BASELINE;
        this.f67f = 1;
    }

    @Override // A.m, A.d
    public void a(d dVar) {
        float f7;
        float fR;
        float fR2;
        int i7;
        int i8 = a.f61a[this.f71j.ordinal()];
        if (i8 == 1) {
            p(dVar);
        } else if (i8 == 2) {
            o(dVar);
        } else if (i8 == 3) {
            z.e eVar = this.f63b;
            n(dVar, eVar.f25833C, eVar.f25835E, 1);
            return;
        }
        g gVar = this.f66e;
        if (gVar.f29c && !gVar.f36j && this.f65d == e.b.MATCH_CONSTRAINT) {
            z.e eVar2 = this.f63b;
            int i9 = eVar2.f25881m;
            if (i9 == 2) {
                z.e eVarE = eVar2.E();
                if (eVarE != null) {
                    if (eVarE.f25867f.f66e.f36j) {
                        this.f66e.d((int) ((r7.f33g * this.f63b.f25895t) + 0.5f));
                    }
                }
            } else if (i9 == 3 && eVar2.f25865e.f66e.f36j) {
                int iS = eVar2.s();
                if (iS == -1) {
                    z.e eVar3 = this.f63b;
                    f7 = eVar3.f25865e.f66e.f33g;
                    fR = eVar3.r();
                } else if (iS == 0) {
                    fR2 = r7.f25865e.f66e.f33g * this.f63b.r();
                    i7 = (int) (fR2 + 0.5f);
                    this.f66e.d(i7);
                } else if (iS != 1) {
                    i7 = 0;
                    this.f66e.d(i7);
                } else {
                    z.e eVar4 = this.f63b;
                    f7 = eVar4.f25865e.f66e.f33g;
                    fR = eVar4.r();
                }
                fR2 = f7 / fR;
                i7 = (int) (fR2 + 0.5f);
                this.f66e.d(i7);
            }
        }
        f fVar = this.f69h;
        if (fVar.f29c) {
            f fVar2 = this.f70i;
            if (fVar2.f29c) {
                if (fVar.f36j && fVar2.f36j && this.f66e.f36j) {
                    return;
                }
                if (!this.f66e.f36j && this.f65d == e.b.MATCH_CONSTRAINT) {
                    z.e eVar5 = this.f63b;
                    if (eVar5.f25879l == 0 && !eVar5.V()) {
                        f fVar3 = (f) this.f69h.f38l.get(0);
                        f fVar4 = (f) this.f70i.f38l.get(0);
                        int i10 = fVar3.f33g;
                        f fVar5 = this.f69h;
                        int i11 = i10 + fVar5.f32f;
                        int i12 = fVar4.f33g + this.f70i.f32f;
                        fVar5.d(i11);
                        this.f70i.d(i12);
                        this.f66e.d(i12 - i11);
                        return;
                    }
                }
                if (!this.f66e.f36j && this.f65d == e.b.MATCH_CONSTRAINT && this.f62a == 1 && this.f69h.f38l.size() > 0 && this.f70i.f38l.size() > 0) {
                    f fVar6 = (f) this.f69h.f38l.get(0);
                    int i13 = (((f) this.f70i.f38l.get(0)).f33g + this.f70i.f32f) - (fVar6.f33g + this.f69h.f32f);
                    g gVar2 = this.f66e;
                    int i14 = gVar2.f48m;
                    if (i13 < i14) {
                        gVar2.d(i13);
                    } else {
                        gVar2.d(i14);
                    }
                }
                if (this.f66e.f36j && this.f69h.f38l.size() > 0 && this.f70i.f38l.size() > 0) {
                    f fVar7 = (f) this.f69h.f38l.get(0);
                    f fVar8 = (f) this.f70i.f38l.get(0);
                    int i15 = fVar7.f33g + this.f69h.f32f;
                    int i16 = fVar8.f33g + this.f70i.f32f;
                    float fI = this.f63b.I();
                    if (fVar7 == fVar8) {
                        i15 = fVar7.f33g;
                        i16 = fVar8.f33g;
                        fI = 0.5f;
                    }
                    this.f69h.d((int) (i15 + 0.5f + (((i16 - i15) - this.f66e.f33g) * fI)));
                    this.f70i.d(this.f69h.f33g + this.f66e.f33g);
                }
            }
        }
    }

    @Override // A.m
    public void d() {
        z.e eVarE;
        z.e eVarE2;
        z.e eVar = this.f63b;
        if (eVar.f25857a) {
            this.f66e.d(eVar.t());
        }
        if (!this.f66e.f36j) {
            this.f65d = this.f63b.K();
            if (this.f63b.Q()) {
                this.f60l = new A.a(this);
            }
            e.b bVar = this.f65d;
            if (bVar != e.b.MATCH_CONSTRAINT) {
                if (bVar == e.b.MATCH_PARENT && (eVarE2 = this.f63b.E()) != null && eVarE2.K() == e.b.FIXED) {
                    int iT = (eVarE2.t() - this.f63b.f25833C.b()) - this.f63b.f25835E.b();
                    b(this.f69h, eVarE2.f25867f.f69h, this.f63b.f25833C.b());
                    b(this.f70i, eVarE2.f25867f.f70i, -this.f63b.f25835E.b());
                    this.f66e.d(iT);
                    return;
                }
                if (this.f65d == e.b.FIXED) {
                    this.f66e.d(this.f63b.t());
                }
            }
        } else if (this.f65d == e.b.MATCH_PARENT && (eVarE = this.f63b.E()) != null && eVarE.K() == e.b.FIXED) {
            b(this.f69h, eVarE.f25867f.f69h, this.f63b.f25833C.b());
            b(this.f70i, eVarE.f25867f.f70i, -this.f63b.f25835E.b());
            return;
        }
        g gVar = this.f66e;
        boolean z7 = gVar.f36j;
        if (z7) {
            z.e eVar2 = this.f63b;
            if (eVar2.f25857a) {
                z.d[] dVarArr = eVar2.f25840J;
                z.d dVar = dVarArr[2];
                z.d dVar2 = dVar.f25815d;
                if (dVar2 != null && dVarArr[3].f25815d != null) {
                    if (eVar2.V()) {
                        this.f69h.f32f = this.f63b.f25840J[2].b();
                        this.f70i.f32f = -this.f63b.f25840J[3].b();
                    } else {
                        f fVarH = h(this.f63b.f25840J[2]);
                        if (fVarH != null) {
                            b(this.f69h, fVarH, this.f63b.f25840J[2].b());
                        }
                        f fVarH2 = h(this.f63b.f25840J[3]);
                        if (fVarH2 != null) {
                            b(this.f70i, fVarH2, -this.f63b.f25840J[3].b());
                        }
                        this.f69h.f28b = true;
                        this.f70i.f28b = true;
                    }
                    if (this.f63b.Q()) {
                        b(this.f59k, this.f69h, this.f63b.l());
                        return;
                    }
                    return;
                }
                if (dVar2 != null) {
                    f fVarH3 = h(dVar);
                    if (fVarH3 != null) {
                        b(this.f69h, fVarH3, this.f63b.f25840J[2].b());
                        b(this.f70i, this.f69h, this.f66e.f33g);
                        if (this.f63b.Q()) {
                            b(this.f59k, this.f69h, this.f63b.l());
                            return;
                        }
                        return;
                    }
                    return;
                }
                z.d dVar3 = dVarArr[3];
                if (dVar3.f25815d != null) {
                    f fVarH4 = h(dVar3);
                    if (fVarH4 != null) {
                        b(this.f70i, fVarH4, -this.f63b.f25840J[3].b());
                        b(this.f69h, this.f70i, -this.f66e.f33g);
                    }
                    if (this.f63b.Q()) {
                        b(this.f59k, this.f69h, this.f63b.l());
                        return;
                    }
                    return;
                }
                z.d dVar4 = dVarArr[4];
                if (dVar4.f25815d != null) {
                    f fVarH5 = h(dVar4);
                    if (fVarH5 != null) {
                        b(this.f59k, fVarH5, 0);
                        b(this.f69h, this.f59k, -this.f63b.l());
                        b(this.f70i, this.f69h, this.f66e.f33g);
                        return;
                    }
                    return;
                }
                if ((eVar2 instanceof z.h) || eVar2.E() == null || this.f63b.k(d.b.CENTER).f25815d != null) {
                    return;
                }
                b(this.f69h, this.f63b.E().f25867f.f69h, this.f63b.P());
                b(this.f70i, this.f69h, this.f66e.f33g);
                if (this.f63b.Q()) {
                    b(this.f59k, this.f69h, this.f63b.l());
                    return;
                }
                return;
            }
        }
        if (z7 || this.f65d != e.b.MATCH_CONSTRAINT) {
            gVar.b(this);
        } else {
            z.e eVar3 = this.f63b;
            int i7 = eVar3.f25881m;
            if (i7 == 2) {
                z.e eVarE3 = eVar3.E();
                if (eVarE3 != null) {
                    g gVar2 = eVarE3.f25867f.f66e;
                    this.f66e.f38l.add(gVar2);
                    gVar2.f37k.add(this.f66e);
                    g gVar3 = this.f66e;
                    gVar3.f28b = true;
                    gVar3.f37k.add(this.f69h);
                    this.f66e.f37k.add(this.f70i);
                }
            } else if (i7 == 3 && !eVar3.V()) {
                z.e eVar4 = this.f63b;
                if (eVar4.f25879l != 3) {
                    g gVar4 = eVar4.f25865e.f66e;
                    this.f66e.f38l.add(gVar4);
                    gVar4.f37k.add(this.f66e);
                    g gVar5 = this.f66e;
                    gVar5.f28b = true;
                    gVar5.f37k.add(this.f69h);
                    this.f66e.f37k.add(this.f70i);
                }
            }
        }
        z.e eVar5 = this.f63b;
        z.d[] dVarArr2 = eVar5.f25840J;
        z.d dVar5 = dVarArr2[2];
        z.d dVar6 = dVar5.f25815d;
        if (dVar6 != null && dVarArr2[3].f25815d != null) {
            if (eVar5.V()) {
                this.f69h.f32f = this.f63b.f25840J[2].b();
                this.f70i.f32f = -this.f63b.f25840J[3].b();
            } else {
                f fVarH6 = h(this.f63b.f25840J[2]);
                f fVarH7 = h(this.f63b.f25840J[3]);
                fVarH6.b(this);
                fVarH7.b(this);
                this.f71j = m.b.CENTER;
            }
            if (this.f63b.Q()) {
                c(this.f59k, this.f69h, 1, this.f60l);
            }
        } else if (dVar6 != null) {
            f fVarH8 = h(dVar5);
            if (fVarH8 != null) {
                b(this.f69h, fVarH8, this.f63b.f25840J[2].b());
                c(this.f70i, this.f69h, 1, this.f66e);
                if (this.f63b.Q()) {
                    c(this.f59k, this.f69h, 1, this.f60l);
                }
                e.b bVar2 = this.f65d;
                e.b bVar3 = e.b.MATCH_CONSTRAINT;
                if (bVar2 == bVar3 && this.f63b.r() > 0.0f) {
                    j jVar = this.f63b.f25865e;
                    if (jVar.f65d == bVar3) {
                        jVar.f66e.f37k.add(this.f66e);
                        this.f66e.f38l.add(this.f63b.f25865e.f66e);
                        this.f66e.f27a = this;
                    }
                }
            }
        } else {
            z.d dVar7 = dVarArr2[3];
            if (dVar7.f25815d != null) {
                f fVarH9 = h(dVar7);
                if (fVarH9 != null) {
                    b(this.f70i, fVarH9, -this.f63b.f25840J[3].b());
                    c(this.f69h, this.f70i, -1, this.f66e);
                    if (this.f63b.Q()) {
                        c(this.f59k, this.f69h, 1, this.f60l);
                    }
                }
            } else {
                z.d dVar8 = dVarArr2[4];
                if (dVar8.f25815d != null) {
                    f fVarH10 = h(dVar8);
                    if (fVarH10 != null) {
                        b(this.f59k, fVarH10, 0);
                        c(this.f69h, this.f59k, -1, this.f60l);
                        c(this.f70i, this.f69h, 1, this.f66e);
                    }
                } else if (!(eVar5 instanceof z.h) && eVar5.E() != null) {
                    b(this.f69h, this.f63b.E().f25867f.f69h, this.f63b.P());
                    c(this.f70i, this.f69h, 1, this.f66e);
                    if (this.f63b.Q()) {
                        c(this.f59k, this.f69h, 1, this.f60l);
                    }
                    e.b bVar4 = this.f65d;
                    e.b bVar5 = e.b.MATCH_CONSTRAINT;
                    if (bVar4 == bVar5 && this.f63b.r() > 0.0f) {
                        j jVar2 = this.f63b.f25865e;
                        if (jVar2.f65d == bVar5) {
                            jVar2.f66e.f37k.add(this.f66e);
                            this.f66e.f38l.add(this.f63b.f25865e.f66e);
                            this.f66e.f27a = this;
                        }
                    }
                }
            }
        }
        if (this.f66e.f38l.size() == 0) {
            this.f66e.f29c = true;
        }
    }

    @Override // A.m
    public void e() {
        f fVar = this.f69h;
        if (fVar.f36j) {
            this.f63b.C0(fVar.f33g);
        }
    }

    @Override // A.m
    public void f() {
        this.f64c = null;
        this.f69h.c();
        this.f70i.c();
        this.f59k.c();
        this.f66e.c();
        this.f68g = false;
    }

    @Override // A.m
    public boolean m() {
        return this.f65d != e.b.MATCH_CONSTRAINT || this.f63b.f25881m == 0;
    }

    public void q() {
        this.f68g = false;
        this.f69h.c();
        this.f69h.f36j = false;
        this.f70i.c();
        this.f70i.f36j = false;
        this.f59k.c();
        this.f59k.f36j = false;
        this.f66e.f36j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f63b.p();
    }
}
