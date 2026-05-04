package d0;

import c0.d;
import c0.e;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class p implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f7477a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public c0.e f7478b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public m f7479c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e.b f7480d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f7481e = new g(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f7482f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f7483g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f7484h = new f(this);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f7485i = new f(this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f7486j = b.NONE;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f7487a;

        static {
            int[] iArr = new int[d.b.values().length];
            f7487a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f7487a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f7487a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f7487a[d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f7487a[d.b.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b {
        NONE,
        START,
        END,
        CENTER
    }

    public p(c0.e eVar) {
        this.f7478b = eVar;
    }

    @Override // d0.d
    public abstract void a(d dVar);

    public final void b(f fVar, f fVar2, int i10) {
        fVar.f7435l.add(fVar2);
        fVar.f7429f = i10;
        fVar2.f7434k.add(fVar);
    }

    public final void c(f fVar, f fVar2, int i10, g gVar) {
        fVar.f7435l.add(fVar2);
        fVar.f7435l.add(this.f7481e);
        fVar.f7431h = i10;
        fVar.f7432i = gVar;
        fVar2.f7434k.add(fVar);
        gVar.f7434k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i10, int i11) {
        if (i11 == 0) {
            c0.e eVar = this.f7478b;
            int i12 = eVar.A;
            int iMax = Math.max(eVar.f3507z, i10);
            if (i12 > 0) {
                iMax = Math.min(i12, i10);
            }
            if (iMax != i10) {
                return iMax;
            }
        } else {
            c0.e eVar2 = this.f7478b;
            int i13 = eVar2.D;
            int iMax2 = Math.max(eVar2.C, i10);
            if (i13 > 0) {
                iMax2 = Math.min(i13, i10);
            }
            if (iMax2 != i10) {
                return iMax2;
            }
        }
        return i10;
    }

    public final f h(c0.d dVar) {
        c0.d dVar2 = dVar.f3442f;
        if (dVar2 == null) {
            return null;
        }
        c0.e eVar = dVar2.f3440d;
        int i10 = a.f7487a[dVar2.f3441e.ordinal()];
        if (i10 == 1) {
            return eVar.f3465e.f7484h;
        }
        if (i10 == 2) {
            return eVar.f3465e.f7485i;
        }
        if (i10 == 3) {
            return eVar.f3467f.f7484h;
        }
        if (i10 == 4) {
            return eVar.f3467f.f7459k;
        }
        if (i10 != 5) {
            return null;
        }
        return eVar.f3467f.f7485i;
    }

    public final f i(c0.d dVar, int i10) {
        c0.d dVar2 = dVar.f3442f;
        if (dVar2 == null) {
            return null;
        }
        c0.e eVar = dVar2.f3440d;
        p pVar = i10 == 0 ? eVar.f3465e : eVar.f3467f;
        int i11 = a.f7487a[dVar2.f3441e.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    if (i11 != 5) {
                        return null;
                    }
                }
            }
            return pVar.f7485i;
        }
        return pVar.f7484h;
    }

    public long j() {
        if (this.f7481e.f7433j) {
            return r0.f7430g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f7483g;
    }

    public final void l(int i10, int i11) {
        int i12 = this.f7477a;
        if (i12 == 0) {
            this.f7481e.d(g(i11, i10));
            return;
        }
        if (i12 == 1) {
            this.f7481e.d(Math.min(g(this.f7481e.f7445m, i10), i11));
            return;
        }
        if (i12 == 2) {
            c0.e eVarI = this.f7478b.I();
            if (eVarI != null) {
                if ((i10 == 0 ? eVarI.f3465e : eVarI.f3467f).f7481e.f7433j) {
                    c0.e eVar = this.f7478b;
                    this.f7481e.d(g((int) ((r9.f7430g * (i10 == 0 ? eVar.B : eVar.E)) + 0.5f), i10));
                    return;
                }
                return;
            }
            return;
        }
        if (i12 != 3) {
            return;
        }
        c0.e eVar2 = this.f7478b;
        p pVar = eVar2.f3465e;
        e.b bVar = pVar.f7480d;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        if (bVar == bVar2 && pVar.f7477a == 3) {
            n nVar = eVar2.f3467f;
            if (nVar.f7480d == bVar2 && nVar.f7477a == 3) {
                return;
            }
        }
        if (i10 == 0) {
            pVar = eVar2.f3467f;
        }
        if (pVar.f7481e.f7433j) {
            float fT = eVar2.t();
            this.f7481e.d(i10 == 1 ? (int) ((pVar.f7481e.f7430g / fT) + 0.5f) : (int) ((fT * pVar.f7481e.f7430g) + 0.5f));
        }
    }

    public abstract boolean m();

    public void n(d dVar, c0.d dVar2, c0.d dVar3, int i10) {
        f fVarH = h(dVar2);
        f fVarH2 = h(dVar3);
        if (fVarH.f7433j && fVarH2.f7433j) {
            int iE = fVarH.f7430g + dVar2.e();
            int iE2 = fVarH2.f7430g - dVar3.e();
            int i11 = iE2 - iE;
            if (!this.f7481e.f7433j && this.f7480d == e.b.MATCH_CONSTRAINT) {
                l(i10, i11);
            }
            g gVar = this.f7481e;
            if (gVar.f7433j) {
                if (gVar.f7430g == i11) {
                    this.f7484h.d(iE);
                    this.f7485i.d(iE2);
                    return;
                }
                c0.e eVar = this.f7478b;
                float fW = i10 == 0 ? eVar.w() : eVar.P();
                if (fVarH == fVarH2) {
                    iE = fVarH.f7430g;
                    iE2 = fVarH2.f7430g;
                    fW = 0.5f;
                }
                this.f7484h.d((int) (iE + 0.5f + (((iE2 - iE) - this.f7481e.f7430g) * fW)));
                this.f7485i.d(this.f7484h.f7430g + this.f7481e.f7430g);
            }
        }
    }

    public void o(d dVar) {
    }

    public void p(d dVar) {
    }
}
