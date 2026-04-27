package D;

import C.e;
import D.f;
import D.p;

/* JADX INFO: loaded from: classes.dex */
public class n extends p {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public f f705k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public g f706l;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f707a;

        static {
            int[] iArr = new int[p.b.values().length];
            f707a = iArr;
            try {
                iArr[p.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f707a[p.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f707a[p.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public n(C.e eVar) {
        super(eVar);
        f fVar = new f(this);
        this.f705k = fVar;
        this.f706l = null;
        this.f730h.f674e = f.a.TOP;
        this.f731i.f674e = f.a.BOTTOM;
        fVar.f674e = f.a.BASELINE;
        this.f728f = 1;
    }

    @Override // D.p, D.d
    public void a(d dVar) {
        int i8;
        float fT;
        int i9 = a.f707a[this.f732j.ordinal()];
        if (i9 == 1) {
            p(dVar);
        } else if (i9 == 2) {
            o(dVar);
        } else if (i9 == 3) {
            C.e eVar = this.f724b;
            n(dVar, eVar.f312P, eVar.f314R, 1);
            return;
        }
        g gVar = this.f727e;
        if (gVar.f672c && !gVar.f679j && this.f726d == e.b.MATCH_CONSTRAINT) {
            C.e eVar2 = this.f724b;
            int i10 = eVar2.f369x;
            if (i10 == 2) {
                C.e eVarI = eVar2.I();
                if (eVarI != null) {
                    if (eVarI.f333f.f727e.f679j) {
                        i8 = (int) ((r7.f676g * this.f724b.f295E) + 0.5f);
                        this.f727e.d(i8);
                    }
                }
            } else if (i10 == 3 && eVar2.f331e.f727e.f679j) {
                int iU = eVar2.u();
                if (iU == -1) {
                    fT = r7.f331e.f727e.f676g / this.f724b.t();
                    i8 = (int) (fT + 0.5f);
                    this.f727e.d(i8);
                } else if (iU != 0) {
                    if (iU != 1) {
                        i8 = 0;
                        this.f727e.d(i8);
                    }
                    fT = r7.f331e.f727e.f676g / this.f724b.t();
                    i8 = (int) (fT + 0.5f);
                    this.f727e.d(i8);
                } else {
                    fT = r7.f331e.f727e.f676g * this.f724b.t();
                    i8 = (int) (fT + 0.5f);
                    this.f727e.d(i8);
                }
            }
        }
        f fVar = this.f730h;
        if (fVar.f672c) {
            f fVar2 = this.f731i;
            if (fVar2.f672c) {
                if (fVar.f679j && fVar2.f679j && this.f727e.f679j) {
                    return;
                }
                if (!this.f727e.f679j && this.f726d == e.b.MATCH_CONSTRAINT) {
                    C.e eVar3 = this.f724b;
                    if (eVar3.f367w == 0 && !eVar3.i0()) {
                        f fVar3 = (f) this.f730h.f681l.get(0);
                        f fVar4 = (f) this.f731i.f681l.get(0);
                        int i11 = fVar3.f676g;
                        f fVar5 = this.f730h;
                        int i12 = i11 + fVar5.f675f;
                        int i13 = fVar4.f676g + this.f731i.f675f;
                        fVar5.d(i12);
                        this.f731i.d(i13);
                        this.f727e.d(i13 - i12);
                        return;
                    }
                }
                if (!this.f727e.f679j && this.f726d == e.b.MATCH_CONSTRAINT && this.f723a == 1 && this.f730h.f681l.size() > 0 && this.f731i.f681l.size() > 0) {
                    f fVar6 = (f) this.f730h.f681l.get(0);
                    int i14 = (((f) this.f731i.f681l.get(0)).f676g + this.f731i.f675f) - (fVar6.f676g + this.f730h.f675f);
                    g gVar2 = this.f727e;
                    int i15 = gVar2.f691m;
                    if (i14 < i15) {
                        gVar2.d(i14);
                    } else {
                        gVar2.d(i15);
                    }
                }
                if (this.f727e.f679j && this.f730h.f681l.size() > 0 && this.f731i.f681l.size() > 0) {
                    f fVar7 = (f) this.f730h.f681l.get(0);
                    f fVar8 = (f) this.f731i.f681l.get(0);
                    int i16 = fVar7.f676g + this.f730h.f675f;
                    int i17 = fVar8.f676g + this.f731i.f675f;
                    float fP = this.f724b.P();
                    if (fVar7 == fVar8) {
                        i16 = fVar7.f676g;
                        i17 = fVar8.f676g;
                        fP = 0.5f;
                    }
                    this.f730h.d((int) (i16 + 0.5f + (((i17 - i16) - this.f727e.f676g) * fP)));
                    this.f731i.d(this.f730h.f676g + this.f727e.f676g);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:114:0x02dd, code lost:
    
        if (r10.f724b.X() != false) goto L115;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x02df, code lost:
    
        r0 = r10.f705k;
        r1 = r10.f730h;
        r2 = r10.f706l;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x0362, code lost:
    
        if (r10.f724b.X() != false) goto L115;
     */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03d9 A[PHI: r0
      0x03d9: PHI (r0v32 D.l) = (r0v23 D.l), (r0v47 D.l) binds: [B:155:0x03d7, B:129:0x0332] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:159:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    @Override // D.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void d() {
        /*
            Method dump skipped, instruction units count: 1026
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: D.n.d():void");
    }

    @Override // D.p
    public void e() {
        f fVar = this.f730h;
        if (fVar.f679j) {
            this.f724b.j1(fVar.f676g);
        }
    }

    @Override // D.p
    public void f() {
        this.f725c = null;
        this.f730h.c();
        this.f731i.c();
        this.f705k.c();
        this.f727e.c();
        this.f729g = false;
    }

    @Override // D.p
    public boolean m() {
        return this.f726d != e.b.MATCH_CONSTRAINT || this.f724b.f369x == 0;
    }

    public void q() {
        this.f729g = false;
        this.f730h.c();
        this.f730h.f679j = false;
        this.f731i.c();
        this.f731i.f679j = false;
        this.f705k.c();
        this.f705k.f679j = false;
        this.f727e.f679j = false;
    }

    public String toString() {
        return "VerticalRun " + this.f724b.r();
    }
}
