package d0;

import c0.d;
import c0.e;
import d0.f;
import d0.p;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int[] f7449k = new int[2];

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7450a;

        static {
            int[] iArr = new int[p.b.values().length];
            f7450a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7450a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7450a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public l(c0.e eVar) {
        super(eVar);
        this.f7484h.f7428e = f.a.LEFT;
        this.f7485i.f7428e = f.a.RIGHT;
        this.f7482f = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x02ca  */
    @Override // d0.p, d0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(d0.d r14) {
        /*
            Method dump skipped, instruction units count: 1067
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: d0.l.a(d0.d):void");
    }

    @Override // d0.p
    public void d() {
        c0.e eVarI;
        c0.e eVarI2;
        c0.e eVar = this.f7478b;
        if (eVar.f3457a) {
            this.f7481e.d(eVar.U());
        }
        if (this.f7481e.f7433j) {
            e.b bVar = this.f7480d;
            e.b bVar2 = e.b.MATCH_PARENT;
            if (bVar == bVar2 && (eVarI = this.f7478b.I()) != null && (eVarI.y() == e.b.FIXED || eVarI.y() == bVar2)) {
                b(this.f7484h, eVarI.f3465e.f7484h, this.f7478b.O.e());
                b(this.f7485i, eVarI.f3465e.f7485i, -this.f7478b.Q.e());
                return;
            }
        } else {
            e.b bVarY = this.f7478b.y();
            this.f7480d = bVarY;
            if (bVarY != e.b.MATCH_CONSTRAINT) {
                e.b bVar3 = e.b.MATCH_PARENT;
                if (bVarY == bVar3 && (eVarI2 = this.f7478b.I()) != null && (eVarI2.y() == e.b.FIXED || eVarI2.y() == bVar3)) {
                    int iU = (eVarI2.U() - this.f7478b.O.e()) - this.f7478b.Q.e();
                    b(this.f7484h, eVarI2.f3465e.f7484h, this.f7478b.O.e());
                    b(this.f7485i, eVarI2.f3465e.f7485i, -this.f7478b.Q.e());
                    this.f7481e.d(iU);
                    return;
                }
                if (this.f7480d == e.b.FIXED) {
                    this.f7481e.d(this.f7478b.U());
                }
            }
        }
        g gVar = this.f7481e;
        if (gVar.f7433j) {
            c0.e eVar2 = this.f7478b;
            if (eVar2.f3457a) {
                c0.d[] dVarArr = eVar2.W;
                c0.d dVar = dVarArr[0];
                c0.d dVar2 = dVar.f3442f;
                if (dVar2 != null && dVarArr[1].f3442f != null) {
                    if (eVar2.g0()) {
                        this.f7484h.f7429f = this.f7478b.W[0].e();
                        this.f7485i.f7429f = -this.f7478b.W[1].e();
                        return;
                    }
                    f fVarH = h(this.f7478b.W[0]);
                    if (fVarH != null) {
                        b(this.f7484h, fVarH, this.f7478b.W[0].e());
                    }
                    f fVarH2 = h(this.f7478b.W[1]);
                    if (fVarH2 != null) {
                        b(this.f7485i, fVarH2, -this.f7478b.W[1].e());
                    }
                    this.f7484h.f7425b = true;
                    this.f7485i.f7425b = true;
                    return;
                }
                if (dVar2 != null) {
                    f fVarH3 = h(dVar);
                    if (fVarH3 != null) {
                        b(this.f7484h, fVarH3, this.f7478b.W[0].e());
                        b(this.f7485i, this.f7484h, this.f7481e.f7430g);
                        return;
                    }
                    return;
                }
                c0.d dVar3 = dVarArr[1];
                if (dVar3.f3442f != null) {
                    f fVarH4 = h(dVar3);
                    if (fVarH4 != null) {
                        b(this.f7485i, fVarH4, -this.f7478b.W[1].e());
                        b(this.f7484h, this.f7485i, -this.f7481e.f7430g);
                        return;
                    }
                    return;
                }
                if ((eVar2 instanceof c0.h) || eVar2.I() == null || this.f7478b.m(d.b.CENTER).f3442f != null) {
                    return;
                }
                b(this.f7484h, this.f7478b.I().f3465e.f7484h, this.f7478b.V());
                b(this.f7485i, this.f7484h, this.f7481e.f7430g);
                return;
            }
        }
        if (this.f7480d == e.b.MATCH_CONSTRAINT) {
            c0.e eVar3 = this.f7478b;
            int i10 = eVar3.f3501w;
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
            } else if (i10 == 3) {
                if (eVar3.f3503x == 3) {
                    this.f7484h.f7424a = this;
                    this.f7485i.f7424a = this;
                    n nVar = eVar3.f3467f;
                    nVar.f7484h.f7424a = this;
                    nVar.f7485i.f7424a = this;
                    gVar.f7424a = this;
                    if (eVar3.i0()) {
                        this.f7481e.f7435l.add(this.f7478b.f3467f.f7481e);
                        this.f7478b.f3467f.f7481e.f7434k.add(this.f7481e);
                        n nVar2 = this.f7478b.f3467f;
                        nVar2.f7481e.f7424a = this;
                        this.f7481e.f7435l.add(nVar2.f7484h);
                        this.f7481e.f7435l.add(this.f7478b.f3467f.f7485i);
                        this.f7478b.f3467f.f7484h.f7434k.add(this.f7481e);
                        this.f7478b.f3467f.f7485i.f7434k.add(this.f7481e);
                    } else if (this.f7478b.g0()) {
                        this.f7478b.f3467f.f7481e.f7435l.add(this.f7481e);
                        this.f7481e.f7434k.add(this.f7478b.f3467f.f7481e);
                    } else {
                        this.f7478b.f3467f.f7481e.f7435l.add(this.f7481e);
                    }
                } else {
                    g gVar4 = eVar3.f3467f.f7481e;
                    gVar.f7435l.add(gVar4);
                    gVar4.f7434k.add(this.f7481e);
                    this.f7478b.f3467f.f7484h.f7434k.add(this.f7481e);
                    this.f7478b.f3467f.f7485i.f7434k.add(this.f7481e);
                    g gVar5 = this.f7481e;
                    gVar5.f7425b = true;
                    gVar5.f7434k.add(this.f7484h);
                    this.f7481e.f7434k.add(this.f7485i);
                    this.f7484h.f7435l.add(this.f7481e);
                    this.f7485i.f7435l.add(this.f7481e);
                }
            }
        }
        c0.e eVar4 = this.f7478b;
        c0.d[] dVarArr2 = eVar4.W;
        c0.d dVar4 = dVarArr2[0];
        c0.d dVar5 = dVar4.f3442f;
        if (dVar5 != null && dVarArr2[1].f3442f != null) {
            if (eVar4.g0()) {
                this.f7484h.f7429f = this.f7478b.W[0].e();
                this.f7485i.f7429f = -this.f7478b.W[1].e();
                return;
            }
            f fVarH5 = h(this.f7478b.W[0]);
            f fVarH6 = h(this.f7478b.W[1]);
            if (fVarH5 != null) {
                fVarH5.b(this);
            }
            if (fVarH6 != null) {
                fVarH6.b(this);
            }
            this.f7486j = p.b.CENTER;
            return;
        }
        if (dVar5 != null) {
            f fVarH7 = h(dVar4);
            if (fVarH7 != null) {
                b(this.f7484h, fVarH7, this.f7478b.W[0].e());
                c(this.f7485i, this.f7484h, 1, this.f7481e);
                return;
            }
            return;
        }
        c0.d dVar6 = dVarArr2[1];
        if (dVar6.f3442f != null) {
            f fVarH8 = h(dVar6);
            if (fVarH8 != null) {
                b(this.f7485i, fVarH8, -this.f7478b.W[1].e());
                c(this.f7484h, this.f7485i, -1, this.f7481e);
                return;
            }
            return;
        }
        if ((eVar4 instanceof c0.h) || eVar4.I() == null) {
            return;
        }
        b(this.f7484h, this.f7478b.I().f3465e.f7484h, this.f7478b.V());
        c(this.f7485i, this.f7484h, 1, this.f7481e);
    }

    @Override // d0.p
    public void e() {
        f fVar = this.f7484h;
        if (fVar.f7433j) {
            this.f7478b.i1(fVar.f7430g);
        }
    }

    @Override // d0.p
    public void f() {
        this.f7479c = null;
        this.f7484h.c();
        this.f7485i.c();
        this.f7481e.c();
        this.f7483g = false;
    }

    @Override // d0.p
    public boolean m() {
        return this.f7480d != e.b.MATCH_CONSTRAINT || this.f7478b.f3501w == 0;
    }

    public final void q(int[] iArr, int i10, int i11, int i12, int i13, float f10, int i14) {
        int i15 = i11 - i10;
        int i16 = i13 - i12;
        if (i14 != -1) {
            if (i14 == 0) {
                iArr[0] = (int) ((i16 * f10) + 0.5f);
                iArr[1] = i16;
                return;
            } else {
                if (i14 != 1) {
                    return;
                }
                iArr[0] = i15;
                iArr[1] = (int) ((i15 * f10) + 0.5f);
                return;
            }
        }
        int i17 = (int) ((i16 * f10) + 0.5f);
        int i18 = (int) ((i15 / f10) + 0.5f);
        if (i17 <= i15) {
            iArr[0] = i17;
            iArr[1] = i16;
        } else if (i18 <= i16) {
            iArr[0] = i15;
            iArr[1] = i18;
        }
    }

    public void r() {
        this.f7483g = false;
        this.f7484h.c();
        this.f7484h.f7433j = false;
        this.f7485i.c();
        this.f7485i.f7433j = false;
        this.f7481e.f7433j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f7478b.r();
    }
}
