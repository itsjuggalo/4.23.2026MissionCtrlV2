package D;

import C.d;
import C.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class p implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f723a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C.e f724b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f725c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e.b f726d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f727e = new g(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f728f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f729g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f730h = new f(this);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f731i = new f(this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f732j = b.NONE;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f733a;

        static {
            int[] iArr = new int[d.b.values().length];
            f733a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f733a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f733a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f733a[d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f733a[d.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public p(C.e eVar) {
        this.f724b = eVar;
    }

    @Override // D.d
    public abstract void a(d dVar);

    public final void b(f fVar, f fVar2, int i8) {
        fVar.f681l.add(fVar2);
        fVar.f675f = i8;
        fVar2.f680k.add(fVar);
    }

    public final void c(f fVar, f fVar2, int i8, g gVar) {
        fVar.f681l.add(fVar2);
        fVar.f681l.add(this.f727e);
        fVar.f677h = i8;
        fVar.f678i = gVar;
        fVar2.f680k.add(fVar);
        gVar.f680k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i8, int i9) {
        int iMax;
        if (i9 == 0) {
            C.e eVar = this.f724b;
            int i10 = eVar.f287A;
            iMax = Math.max(eVar.f373z, i8);
            if (i10 > 0) {
                iMax = Math.min(i10, i8);
            }
            if (iMax == i8) {
                return i8;
            }
        } else {
            C.e eVar2 = this.f724b;
            int i11 = eVar2.f293D;
            iMax = Math.max(eVar2.f291C, i8);
            if (i11 > 0) {
                iMax = Math.min(i11, i8);
            }
            if (iMax == i8) {
                return i8;
            }
        }
        return iMax;
    }

    public final f h(C.d dVar) {
        p pVar;
        p pVar2;
        C.d dVar2 = dVar.f271f;
        if (dVar2 == null) {
            return null;
        }
        C.e eVar = dVar2.f269d;
        int i8 = a.f733a[dVar2.f270e.ordinal()];
        if (i8 != 1) {
            if (i8 == 2) {
                pVar2 = eVar.f331e;
            } else if (i8 == 3) {
                pVar = eVar.f333f;
            } else {
                if (i8 == 4) {
                    return eVar.f333f.f705k;
                }
                if (i8 != 5) {
                    return null;
                }
                pVar2 = eVar.f333f;
            }
            return pVar2.f731i;
        }
        pVar = eVar.f331e;
        return pVar.f730h;
    }

    public final f i(C.d dVar, int i8) {
        C.d dVar2 = dVar.f271f;
        if (dVar2 == null) {
            return null;
        }
        C.e eVar = dVar2.f269d;
        p pVar = i8 == 0 ? eVar.f331e : eVar.f333f;
        int i9 = a.f733a[dVar2.f270e.ordinal()];
        if (i9 != 1) {
            if (i9 != 2) {
                if (i9 != 3) {
                    if (i9 != 5) {
                        return null;
                    }
                }
            }
            return pVar.f731i;
        }
        return pVar.f730h;
    }

    public long j() {
        if (this.f727e.f679j) {
            return r0.f676g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f729g;
    }

    public final void l(int i8, int i9) {
        g gVar;
        int iG;
        int i10 = this.f723a;
        if (i10 == 0) {
            gVar = this.f727e;
            iG = g(i9, i8);
        } else if (i10 == 1) {
            int iG2 = g(this.f727e.f691m, i8);
            gVar = this.f727e;
            iG = Math.min(iG2, i9);
        } else {
            if (i10 != 2) {
                if (i10 != 3) {
                    return;
                }
                C.e eVar = this.f724b;
                p pVar = eVar.f331e;
                e.b bVar = pVar.f726d;
                e.b bVar2 = e.b.MATCH_CONSTRAINT;
                if (bVar == bVar2 && pVar.f723a == 3) {
                    n nVar = eVar.f333f;
                    if (nVar.f726d == bVar2 && nVar.f723a == 3) {
                        return;
                    }
                }
                if (i8 == 0) {
                    pVar = eVar.f333f;
                }
                if (pVar.f727e.f679j) {
                    float fT = eVar.t();
                    this.f727e.d(i8 == 1 ? (int) ((pVar.f727e.f676g / fT) + 0.5f) : (int) ((fT * pVar.f727e.f676g) + 0.5f));
                    return;
                }
                return;
            }
            C.e eVarI = this.f724b.I();
            if (eVarI == null) {
                return;
            }
            if (!(i8 == 0 ? eVarI.f331e : eVarI.f333f).f727e.f679j) {
                return;
            }
            C.e eVar2 = this.f724b;
            i9 = (int) ((r9.f676g * (i8 == 0 ? eVar2.f289B : eVar2.f295E)) + 0.5f);
            gVar = this.f727e;
            iG = g(i9, i8);
        }
        gVar.d(iG);
    }

    public abstract boolean m();

    public void n(d dVar, C.d dVar2, C.d dVar3, int i8) {
        f fVar;
        f fVarH = h(dVar2);
        f fVarH2 = h(dVar3);
        if (fVarH.f679j && fVarH2.f679j) {
            int iE = fVarH.f676g + dVar2.e();
            int iE2 = fVarH2.f676g - dVar3.e();
            int i9 = iE2 - iE;
            if (!this.f727e.f679j && this.f726d == e.b.MATCH_CONSTRAINT) {
                l(i8, i9);
            }
            g gVar = this.f727e;
            if (gVar.f679j) {
                if (gVar.f676g == i9) {
                    this.f730h.d(iE);
                    fVar = this.f731i;
                } else {
                    C.e eVar = this.f724b;
                    float fW = i8 == 0 ? eVar.w() : eVar.P();
                    if (fVarH == fVarH2) {
                        iE = fVarH.f676g;
                        iE2 = fVarH2.f676g;
                        fW = 0.5f;
                    }
                    this.f730h.d((int) (iE + 0.5f + (((iE2 - iE) - this.f727e.f676g) * fW)));
                    fVar = this.f731i;
                    iE2 = this.f730h.f676g + this.f727e.f676g;
                }
                fVar.d(iE2);
            }
        }
    }

    public void o(d dVar) {
    }

    public void p(d dVar) {
    }
}
