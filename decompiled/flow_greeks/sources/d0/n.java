package d0;

import c0.d;
import c0.e;
import d0.f;
import d0.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class n extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f7459k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f7460l;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7461a;

        static {
            int[] iArr = new int[p.b.values().length];
            f7461a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7461a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7461a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public n(c0.e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.f7459k = fVar;
        this.f7460l = null;
        this.f7484h.f7428e = f.a.TOP;
        this.f7485i.f7428e = f.a.BOTTOM;
        fVar.f7428e = f.a.BASELINE;
        this.f7482f = 1;
    }

    @Override // d0.p, d0.d
    public void a(d dVar) {
        float f10;
        float fT;
        float fT2;
        int i10;
        int i11 = a.f7461a[this.f7486j.ordinal()];
        if (i11 == 1) {
            p(dVar);
        } else if (i11 == 2) {
            o(dVar);
        } else if (i11 == 3) {
            c0.e eVar = this.f7478b;
            n(dVar, eVar.P, eVar.R, 1);
            return;
        }
        g gVar = this.f7481e;
        if (gVar.f7426c && !gVar.f7433j && this.f7480d == e.b.MATCH_CONSTRAINT) {
            c0.e eVar2 = this.f7478b;
            int i12 = eVar2.f3503x;
            if (i12 == 2) {
                c0.e eVarI = eVar2.I();
                if (eVarI != null) {
                    if (eVarI.f3467f.f7481e.f7433j) {
                        this.f7481e.d((int) ((r7.f7430g * this.f7478b.E) + 0.5f));
                    }
                }
            } else if (i12 == 3 && eVar2.f3465e.f7481e.f7433j) {
                int iU = eVar2.u();
                if (iU == -1) {
                    c0.e eVar3 = this.f7478b;
                    f10 = eVar3.f3465e.f7481e.f7430g;
                    fT = eVar3.t();
                } else if (iU == 0) {
                    fT2 = r7.f3465e.f7481e.f7430g * this.f7478b.t();
                    i10 = (int) (fT2 + 0.5f);
                    this.f7481e.d(i10);
                } else if (iU != 1) {
                    i10 = 0;
                    this.f7481e.d(i10);
                } else {
                    c0.e eVar4 = this.f7478b;
                    f10 = eVar4.f3465e.f7481e.f7430g;
                    fT = eVar4.t();
                }
                fT2 = f10 / fT;
                i10 = (int) (fT2 + 0.5f);
                this.f7481e.d(i10);
            }
        }
        f fVar = this.f7484h;
        if (fVar.f7426c) {
            f fVar2 = this.f7485i;
            if (fVar2.f7426c) {
                if (fVar.f7433j && fVar2.f7433j && this.f7481e.f7433j) {
                    return;
                }
                if (!this.f7481e.f7433j && this.f7480d == e.b.MATCH_CONSTRAINT) {
                    c0.e eVar5 = this.f7478b;
                    if (eVar5.f3501w == 0 && !eVar5.i0()) {
                        f fVar3 = (f) this.f7484h.f7435l.get(0);
                        f fVar4 = (f) this.f7485i.f7435l.get(0);
                        int i13 = fVar3.f7430g;
                        f fVar5 = this.f7484h;
                        int i14 = i13 + fVar5.f7429f;
                        int i15 = fVar4.f7430g + this.f7485i.f7429f;
                        fVar5.d(i14);
                        this.f7485i.d(i15);
                        this.f7481e.d(i15 - i14);
                        return;
                    }
                }
                if (!this.f7481e.f7433j && this.f7480d == e.b.MATCH_CONSTRAINT && this.f7477a == 1 && this.f7484h.f7435l.size() > 0 && this.f7485i.f7435l.size() > 0) {
                    f fVar6 = (f) this.f7484h.f7435l.get(0);
                    int i16 = (((f) this.f7485i.f7435l.get(0)).f7430g + this.f7485i.f7429f) - (fVar6.f7430g + this.f7484h.f7429f);
                    g gVar2 = this.f7481e;
                    int i17 = gVar2.f7445m;
                    if (i16 < i17) {
                        gVar2.d(i16);
                    } else {
                        gVar2.d(i17);
                    }
                }
                if (this.f7481e.f7433j && this.f7484h.f7435l.size() > 0 && this.f7485i.f7435l.size() > 0) {
                    f fVar7 = (f) this.f7484h.f7435l.get(0);
                    f fVar8 = (f) this.f7485i.f7435l.get(0);
                    int i18 = fVar7.f7430g + this.f7484h.f7429f;
                    int i19 = fVar8.f7430g + this.f7485i.f7429f;
                    float fP = this.f7478b.P();
                    if (fVar7 == fVar8) {
                        i18 = fVar7.f7430g;
                        i19 = fVar8.f7430g;
                        fP = 0.5f;
                    }
                    this.f7484h.d((int) (i18 + 0.5f + (((i19 - i18) - this.f7481e.f7430g) * fP)));
                    this.f7485i.d(this.f7484h.f7430g + this.f7481e.f7430g);
                }
            }
        }
    }

    @Override // d0.p
    public void d() {
        c0.e eVarI;
        c0.e eVarI2;
        c0.e eVar = this.f7478b;
        if (eVar.f3457a) {
            this.f7481e.d(eVar.v());
        }
        if (!this.f7481e.f7433j) {
            this.f7480d = this.f7478b.R();
            if (this.f7478b.X()) {
                this.f7460l = new d0.a(this);
            }
            e.b bVar = this.f7480d;
            if (bVar != e.b.MATCH_CONSTRAINT) {
                if (bVar == e.b.MATCH_PARENT && (eVarI2 = this.f7478b.I()) != null && eVarI2.R() == e.b.FIXED) {
                    int iV = (eVarI2.v() - this.f7478b.P.e()) - this.f7478b.R.e();
                    b(this.f7484h, eVarI2.f3467f.f7484h, this.f7478b.P.e());
                    b(this.f7485i, eVarI2.f3467f.f7485i, -this.f7478b.R.e());
                    this.f7481e.d(iV);
                    return;
                }
                if (this.f7480d == e.b.FIXED) {
                    this.f7481e.d(this.f7478b.v());
                }
            }
        } else if (this.f7480d == e.b.MATCH_PARENT && (eVarI = this.f7478b.I()) != null && eVarI.R() == e.b.FIXED) {
            b(this.f7484h, eVarI.f3467f.f7484h, this.f7478b.P.e());
            b(this.f7485i, eVarI.f3467f.f7485i, -this.f7478b.R.e());
            return;
        }
        g gVar = this.f7481e;
        boolean z10 = gVar.f7433j;
        if (z10) {
            c0.e eVar2 = this.f7478b;
            if (eVar2.f3457a) {
                c0.d[] dVarArr = eVar2.W;
                c0.d dVar = dVarArr[2];
                c0.d dVar2 = dVar.f3442f;
                if (dVar2 != null && dVarArr[3].f3442f != null) {
                    if (eVar2.i0()) {
                        this.f7484h.f7429f = this.f7478b.W[2].e();
                        this.f7485i.f7429f = -this.f7478b.W[3].e();
                    } else {
                        f fVarH = h(this.f7478b.W[2]);
                        if (fVarH != null) {
                            b(this.f7484h, fVarH, this.f7478b.W[2].e());
                        }
                        f fVarH2 = h(this.f7478b.W[3]);
                        if (fVarH2 != null) {
                            b(this.f7485i, fVarH2, -this.f7478b.W[3].e());
                        }
                        this.f7484h.f7425b = true;
                        this.f7485i.f7425b = true;
                    }
                    if (this.f7478b.X()) {
                        b(this.f7459k, this.f7484h, this.f7478b.n());
                        return;
                    }
                    return;
                }
                if (dVar2 != null) {
                    f fVarH3 = h(dVar);
                    if (fVarH3 != null) {
                        b(this.f7484h, fVarH3, this.f7478b.W[2].e());
                        b(this.f7485i, this.f7484h, this.f7481e.f7430g);
                        if (this.f7478b.X()) {
                            b(this.f7459k, this.f7484h, this.f7478b.n());
                            return;
                        }
                        return;
                    }
                    return;
                }
                c0.d dVar3 = dVarArr[3];
                if (dVar3.f3442f != null) {
                    f fVarH4 = h(dVar3);
                    if (fVarH4 != null) {
                        b(this.f7485i, fVarH4, -this.f7478b.W[3].e());
                        b(this.f7484h, this.f7485i, -this.f7481e.f7430g);
                    }
                    if (this.f7478b.X()) {
                        b(this.f7459k, this.f7484h, this.f7478b.n());
                        return;
                    }
                    return;
                }
                c0.d dVar4 = dVarArr[4];
                if (dVar4.f3442f != null) {
                    f fVarH5 = h(dVar4);
                    if (fVarH5 != null) {
                        b(this.f7459k, fVarH5, 0);
                        b(this.f7484h, this.f7459k, -this.f7478b.n());
                        b(this.f7485i, this.f7484h, this.f7481e.f7430g);
                        return;
                    }
                    return;
                }
                if ((eVar2 instanceof c0.h) || eVar2.I() == null || this.f7478b.m(d.b.CENTER).f3442f != null) {
                    return;
                }
                b(this.f7484h, this.f7478b.I().f3467f.f7484h, this.f7478b.W());
                b(this.f7485i, this.f7484h, this.f7481e.f7430g);
                if (this.f7478b.X()) {
                    b(this.f7459k, this.f7484h, this.f7478b.n());
                    return;
                }
                return;
            }
        }
        if (z10 || this.f7480d != e.b.MATCH_CONSTRAINT) {
            gVar.b(this);
        } else {
            c0.e eVar3 = this.f7478b;
            int i10 = eVar3.f3503x;
            if (i10 == 2) {
                c0.e eVarI3 = eVar3.I();
                if (eVarI3 != null) {
                    g gVar2 = eVarI3.f3467f.f7481e;
                    this.f7481e.f7435l.add(gVar2);
                    gVar2.f7434k.add(this.f7481e);
                    g gVar3 = this.f7481e;
                    gVar3.f7425b = true;
                    gVar3.f7434k.add(this.f7484h);
                    this.f7481e.f7434k.add(this.f7485i);
                }
            } else if (i10 == 3 && !eVar3.i0()) {
                c0.e eVar4 = this.f7478b;
                if (eVar4.f3501w != 3) {
                    g gVar4 = eVar4.f3465e.f7481e;
                    this.f7481e.f7435l.add(gVar4);
                    gVar4.f7434k.add(this.f7481e);
                    g gVar5 = this.f7481e;
                    gVar5.f7425b = true;
                    gVar5.f7434k.add(this.f7484h);
                    this.f7481e.f7434k.add(this.f7485i);
                }
            }
        }
        c0.e eVar5 = this.f7478b;
        c0.d[] dVarArr2 = eVar5.W;
        c0.d dVar5 = dVarArr2[2];
        c0.d dVar6 = dVar5.f3442f;
        if (dVar6 != null && dVarArr2[3].f3442f != null) {
            if (eVar5.i0()) {
                this.f7484h.f7429f = this.f7478b.W[2].e();
                this.f7485i.f7429f = -this.f7478b.W[3].e();
            } else {
                f fVarH6 = h(this.f7478b.W[2]);
                f fVarH7 = h(this.f7478b.W[3]);
                if (fVarH6 != null) {
                    fVarH6.b(this);
                }
                if (fVarH7 != null) {
                    fVarH7.b(this);
                }
                this.f7486j = p.b.CENTER;
            }
            if (this.f7478b.X()) {
                c(this.f7459k, this.f7484h, 1, this.f7460l);
            }
        } else if (dVar6 != null) {
            f fVarH8 = h(dVar5);
            if (fVarH8 != null) {
                b(this.f7484h, fVarH8, this.f7478b.W[2].e());
                c(this.f7485i, this.f7484h, 1, this.f7481e);
                if (this.f7478b.X()) {
                    c(this.f7459k, this.f7484h, 1, this.f7460l);
                }
                e.b bVar2 = this.f7480d;
                e.b bVar3 = e.b.MATCH_CONSTRAINT;
                if (bVar2 == bVar3 && this.f7478b.t() > 0.0f) {
                    l lVar = this.f7478b.f3465e;
                    if (lVar.f7480d == bVar3) {
                        lVar.f7481e.f7434k.add(this.f7481e);
                        this.f7481e.f7435l.add(this.f7478b.f3465e.f7481e);
                        this.f7481e.f7424a = this;
                    }
                }
            }
        } else {
            c0.d dVar7 = dVarArr2[3];
            if (dVar7.f3442f != null) {
                f fVarH9 = h(dVar7);
                if (fVarH9 != null) {
                    b(this.f7485i, fVarH9, -this.f7478b.W[3].e());
                    c(this.f7484h, this.f7485i, -1, this.f7481e);
                    if (this.f7478b.X()) {
                        c(this.f7459k, this.f7484h, 1, this.f7460l);
                    }
                }
            } else {
                c0.d dVar8 = dVarArr2[4];
                if (dVar8.f3442f != null) {
                    f fVarH10 = h(dVar8);
                    if (fVarH10 != null) {
                        b(this.f7459k, fVarH10, 0);
                        c(this.f7484h, this.f7459k, -1, this.f7460l);
                        c(this.f7485i, this.f7484h, 1, this.f7481e);
                    }
                } else if (!(eVar5 instanceof c0.h) && eVar5.I() != null) {
                    b(this.f7484h, this.f7478b.I().f3467f.f7484h, this.f7478b.W());
                    c(this.f7485i, this.f7484h, 1, this.f7481e);
                    if (this.f7478b.X()) {
                        c(this.f7459k, this.f7484h, 1, this.f7460l);
                    }
                    e.b bVar4 = this.f7480d;
                    e.b bVar5 = e.b.MATCH_CONSTRAINT;
                    if (bVar4 == bVar5 && this.f7478b.t() > 0.0f) {
                        l lVar2 = this.f7478b.f3465e;
                        if (lVar2.f7480d == bVar5) {
                            lVar2.f7481e.f7434k.add(this.f7481e);
                            this.f7481e.f7435l.add(this.f7478b.f3465e.f7481e);
                            this.f7481e.f7424a = this;
                        }
                    }
                }
            }
        }
        if (this.f7481e.f7435l.size() == 0) {
            this.f7481e.f7426c = true;
        }
    }

    @Override // d0.p
    public void e() {
        f fVar = this.f7484h;
        if (fVar.f7433j) {
            this.f7478b.j1(fVar.f7430g);
        }
    }

    @Override // d0.p
    public void f() {
        this.f7479c = null;
        this.f7484h.c();
        this.f7485i.c();
        this.f7459k.c();
        this.f7481e.c();
        this.f7483g = false;
    }

    @Override // d0.p
    public boolean m() {
        return this.f7480d != e.b.MATCH_CONSTRAINT || this.f7478b.f3503x == 0;
    }

    public void q() {
        this.f7483g = false;
        this.f7484h.c();
        this.f7484h.f7433j = false;
        this.f7485i.c();
        this.f7485i.f7433j = false;
        this.f7459k.c();
        this.f7459k.f7433j = false;
        this.f7481e.f7433j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f7478b.r();
    }
}
