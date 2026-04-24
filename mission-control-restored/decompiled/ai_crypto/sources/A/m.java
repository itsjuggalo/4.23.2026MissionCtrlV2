package A;

import z.d;
import z.e;

/* JADX INFO: loaded from: classes.dex */
public abstract class m implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f62a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public z.e f63b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f64c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e.b f65d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public g f66e = new g(this);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f67f = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f68g = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f69h = new f(this);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public f f70i = new f(this);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f71j = b.NONE;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f72a;

        static {
            int[] iArr = new int[d.b.values().length];
            f72a = iArr;
            try {
                iArr[d.b.LEFT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f72a[d.b.RIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f72a[d.b.TOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f72a[d.b.BASELINE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f72a[d.b.BOTTOM.ordinal()] = 5;
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

    public m(z.e eVar) {
        this.f63b = eVar;
    }

    @Override // A.d
    public abstract void a(d dVar);

    public final void b(f fVar, f fVar2, int i7) {
        fVar.f38l.add(fVar2);
        fVar.f32f = i7;
        fVar2.f37k.add(fVar);
    }

    public final void c(f fVar, f fVar2, int i7, g gVar) {
        fVar.f38l.add(fVar2);
        fVar.f38l.add(this.f66e);
        fVar.f34h = i7;
        fVar.f35i = gVar;
        fVar2.f37k.add(fVar);
        gVar.f37k.add(fVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i7, int i8) {
        int iMax;
        if (i8 == 0) {
            z.e eVar = this.f63b;
            int i9 = eVar.f25887p;
            iMax = Math.max(eVar.f25885o, i7);
            if (i9 > 0) {
                iMax = Math.min(i9, i7);
            }
            if (iMax == i7) {
                return i7;
            }
        } else {
            z.e eVar2 = this.f63b;
            int i10 = eVar2.f25893s;
            iMax = Math.max(eVar2.f25891r, i7);
            if (i10 > 0) {
                iMax = Math.min(i10, i7);
            }
            if (iMax == i7) {
                return i7;
            }
        }
        return iMax;
    }

    public final f h(z.d dVar) {
        z.d dVar2 = dVar.f25815d;
        if (dVar2 == null) {
            return null;
        }
        z.e eVar = dVar2.f25813b;
        int i7 = a.f72a[dVar2.f25814c.ordinal()];
        if (i7 == 1) {
            return eVar.f25865e.f69h;
        }
        if (i7 == 2) {
            return eVar.f25865e.f70i;
        }
        if (i7 == 3) {
            return eVar.f25867f.f69h;
        }
        if (i7 == 4) {
            return eVar.f25867f.f59k;
        }
        if (i7 != 5) {
            return null;
        }
        return eVar.f25867f.f70i;
    }

    public final f i(z.d dVar, int i7) {
        z.d dVar2 = dVar.f25815d;
        if (dVar2 == null) {
            return null;
        }
        z.e eVar = dVar2.f25813b;
        m mVar = i7 == 0 ? eVar.f25865e : eVar.f25867f;
        int i8 = a.f72a[dVar2.f25814c.ordinal()];
        if (i8 != 1) {
            if (i8 != 2) {
                if (i8 != 3) {
                    if (i8 != 5) {
                        return null;
                    }
                }
            }
            return mVar.f70i;
        }
        return mVar.f69h;
    }

    public long j() {
        if (this.f66e.f36j) {
            return r0.f33g;
        }
        return 0L;
    }

    public boolean k() {
        return this.f68g;
    }

    public final void l(int i7, int i8) {
        int i9 = this.f62a;
        if (i9 == 0) {
            this.f66e.d(g(i8, i7));
            return;
        }
        if (i9 == 1) {
            this.f66e.d(Math.min(g(this.f66e.f48m, i7), i8));
            return;
        }
        if (i9 == 2) {
            z.e eVarE = this.f63b.E();
            if (eVarE != null) {
                if ((i7 == 0 ? eVarE.f25865e : eVarE.f25867f).f66e.f36j) {
                    z.e eVar = this.f63b;
                    this.f66e.d(g((int) ((r9.f33g * (i7 == 0 ? eVar.f25889q : eVar.f25895t)) + 0.5f), i7));
                    return;
                }
                return;
            }
            return;
        }
        if (i9 != 3) {
            return;
        }
        z.e eVar2 = this.f63b;
        m mVar = eVar2.f25865e;
        e.b bVar = mVar.f65d;
        e.b bVar2 = e.b.MATCH_CONSTRAINT;
        if (bVar == bVar2 && mVar.f62a == 3) {
            l lVar = eVar2.f25867f;
            if (lVar.f65d == bVar2 && lVar.f62a == 3) {
                return;
            }
        }
        if (i7 == 0) {
            mVar = eVar2.f25867f;
        }
        if (mVar.f66e.f36j) {
            float fR = eVar2.r();
            this.f66e.d(i7 == 1 ? (int) ((mVar.f66e.f33g / fR) + 0.5f) : (int) ((fR * mVar.f66e.f33g) + 0.5f));
        }
    }

    public abstract boolean m();

    public void n(d dVar, z.d dVar2, z.d dVar3, int i7) {
        f fVarH = h(dVar2);
        f fVarH2 = h(dVar3);
        if (fVarH.f36j && fVarH2.f36j) {
            int iB = fVarH.f33g + dVar2.b();
            int iB2 = fVarH2.f33g - dVar3.b();
            int i8 = iB2 - iB;
            if (!this.f66e.f36j && this.f65d == e.b.MATCH_CONSTRAINT) {
                l(i7, i8);
            }
            g gVar = this.f66e;
            if (gVar.f36j) {
                if (gVar.f33g == i8) {
                    this.f69h.d(iB);
                    this.f70i.d(iB2);
                    return;
                }
                z.e eVar = this.f63b;
                float fU = i7 == 0 ? eVar.u() : eVar.I();
                if (fVarH == fVarH2) {
                    iB = fVarH.f33g;
                    iB2 = fVarH2.f33g;
                    fU = 0.5f;
                }
                this.f69h.d((int) (iB + 0.5f + (((iB2 - iB) - this.f66e.f33g) * fU)));
                this.f70i.d(this.f69h.f33g + this.f66e.f33g);
            }
        }
    }

    public void o(d dVar) {
    }

    public void p(d dVar) {
    }
}
