package A;

import A.f;
import A.m;
import z.d;
import z.e;

/* JADX INFO: loaded from: classes.dex */
public class j extends m {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static int[] f49k = new int[2];

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f50a;

        static {
            int[] iArr = new int[m.b.values().length];
            f50a = iArr;
            try {
                iArr[m.b.START.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f50a[m.b.END.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f50a[m.b.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public j(z.e eVar) {
        super(eVar);
        this.f69h.f31e = f.a.LEFT;
        this.f70i.f31e = f.a.RIGHT;
        this.f67f = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:125:0x02df  */
    @Override // A.m, A.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(A.d r17) {
        /*
            Method dump skipped, instruction units count: 1088
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: A.j.a(A.d):void");
    }

    @Override // A.m
    public void d() {
        z.e eVarE;
        z.e eVarE2;
        z.e eVar = this.f63b;
        if (eVar.f25857a) {
            this.f66e.d(eVar.N());
        }
        if (this.f66e.f36j) {
            e.b bVar = this.f65d;
            e.b bVar2 = e.b.MATCH_PARENT;
            if (bVar == bVar2 && (((eVarE = this.f63b.E()) != null && eVarE.w() == e.b.FIXED) || eVarE.w() == bVar2)) {
                b(this.f69h, eVarE.f25865e.f69h, this.f63b.f25832B.b());
                b(this.f70i, eVarE.f25865e.f70i, -this.f63b.f25834D.b());
                return;
            }
        } else {
            e.b bVarW = this.f63b.w();
            this.f65d = bVarW;
            if (bVarW != e.b.MATCH_CONSTRAINT) {
                e.b bVar3 = e.b.MATCH_PARENT;
                if (bVarW == bVar3 && (((eVarE2 = this.f63b.E()) != null && eVarE2.w() == e.b.FIXED) || eVarE2.w() == bVar3)) {
                    int iN = (eVarE2.N() - this.f63b.f25832B.b()) - this.f63b.f25834D.b();
                    b(this.f69h, eVarE2.f25865e.f69h, this.f63b.f25832B.b());
                    b(this.f70i, eVarE2.f25865e.f70i, -this.f63b.f25834D.b());
                    this.f66e.d(iN);
                    return;
                }
                if (this.f65d == e.b.FIXED) {
                    this.f66e.d(this.f63b.N());
                }
            }
        }
        g gVar = this.f66e;
        if (gVar.f36j) {
            z.e eVar2 = this.f63b;
            if (eVar2.f25857a) {
                z.d[] dVarArr = eVar2.f25840J;
                z.d dVar = dVarArr[0];
                z.d dVar2 = dVar.f25815d;
                if (dVar2 != null && dVarArr[1].f25815d != null) {
                    if (eVar2.T()) {
                        this.f69h.f32f = this.f63b.f25840J[0].b();
                        this.f70i.f32f = -this.f63b.f25840J[1].b();
                        return;
                    }
                    f fVarH = h(this.f63b.f25840J[0]);
                    if (fVarH != null) {
                        b(this.f69h, fVarH, this.f63b.f25840J[0].b());
                    }
                    f fVarH2 = h(this.f63b.f25840J[1]);
                    if (fVarH2 != null) {
                        b(this.f70i, fVarH2, -this.f63b.f25840J[1].b());
                    }
                    this.f69h.f28b = true;
                    this.f70i.f28b = true;
                    return;
                }
                if (dVar2 != null) {
                    f fVarH3 = h(dVar);
                    if (fVarH3 != null) {
                        b(this.f69h, fVarH3, this.f63b.f25840J[0].b());
                        b(this.f70i, this.f69h, this.f66e.f33g);
                        return;
                    }
                    return;
                }
                z.d dVar3 = dVarArr[1];
                if (dVar3.f25815d != null) {
                    f fVarH4 = h(dVar3);
                    if (fVarH4 != null) {
                        b(this.f70i, fVarH4, -this.f63b.f25840J[1].b());
                        b(this.f69h, this.f70i, -this.f66e.f33g);
                        return;
                    }
                    return;
                }
                if ((eVar2 instanceof z.h) || eVar2.E() == null || this.f63b.k(d.b.CENTER).f25815d != null) {
                    return;
                }
                b(this.f69h, this.f63b.E().f25865e.f69h, this.f63b.O());
                b(this.f70i, this.f69h, this.f66e.f33g);
                return;
            }
        }
        if (this.f65d == e.b.MATCH_CONSTRAINT) {
            z.e eVar3 = this.f63b;
            int i7 = eVar3.f25879l;
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
            } else if (i7 == 3) {
                if (eVar3.f25881m == 3) {
                    this.f69h.f27a = this;
                    this.f70i.f27a = this;
                    l lVar = eVar3.f25867f;
                    lVar.f69h.f27a = this;
                    lVar.f70i.f27a = this;
                    gVar.f27a = this;
                    if (eVar3.V()) {
                        this.f66e.f38l.add(this.f63b.f25867f.f66e);
                        this.f63b.f25867f.f66e.f37k.add(this.f66e);
                        l lVar2 = this.f63b.f25867f;
                        lVar2.f66e.f27a = this;
                        this.f66e.f38l.add(lVar2.f69h);
                        this.f66e.f38l.add(this.f63b.f25867f.f70i);
                        this.f63b.f25867f.f69h.f37k.add(this.f66e);
                        this.f63b.f25867f.f70i.f37k.add(this.f66e);
                    } else if (this.f63b.T()) {
                        this.f63b.f25867f.f66e.f38l.add(this.f66e);
                        this.f66e.f37k.add(this.f63b.f25867f.f66e);
                    } else {
                        this.f63b.f25867f.f66e.f38l.add(this.f66e);
                    }
                } else {
                    g gVar4 = eVar3.f25867f.f66e;
                    gVar.f38l.add(gVar4);
                    gVar4.f37k.add(this.f66e);
                    this.f63b.f25867f.f69h.f37k.add(this.f66e);
                    this.f63b.f25867f.f70i.f37k.add(this.f66e);
                    g gVar5 = this.f66e;
                    gVar5.f28b = true;
                    gVar5.f37k.add(this.f69h);
                    this.f66e.f37k.add(this.f70i);
                    this.f69h.f38l.add(this.f66e);
                    this.f70i.f38l.add(this.f66e);
                }
            }
        }
        z.e eVar4 = this.f63b;
        z.d[] dVarArr2 = eVar4.f25840J;
        z.d dVar4 = dVarArr2[0];
        z.d dVar5 = dVar4.f25815d;
        if (dVar5 != null && dVarArr2[1].f25815d != null) {
            if (eVar4.T()) {
                this.f69h.f32f = this.f63b.f25840J[0].b();
                this.f70i.f32f = -this.f63b.f25840J[1].b();
                return;
            }
            f fVarH5 = h(this.f63b.f25840J[0]);
            f fVarH6 = h(this.f63b.f25840J[1]);
            fVarH5.b(this);
            fVarH6.b(this);
            this.f71j = m.b.CENTER;
            return;
        }
        if (dVar5 != null) {
            f fVarH7 = h(dVar4);
            if (fVarH7 != null) {
                b(this.f69h, fVarH7, this.f63b.f25840J[0].b());
                c(this.f70i, this.f69h, 1, this.f66e);
                return;
            }
            return;
        }
        z.d dVar6 = dVarArr2[1];
        if (dVar6.f25815d != null) {
            f fVarH8 = h(dVar6);
            if (fVarH8 != null) {
                b(this.f70i, fVarH8, -this.f63b.f25840J[1].b());
                c(this.f69h, this.f70i, -1, this.f66e);
                return;
            }
            return;
        }
        if ((eVar4 instanceof z.h) || eVar4.E() == null) {
            return;
        }
        b(this.f69h, this.f63b.E().f25865e.f69h, this.f63b.O());
        c(this.f70i, this.f69h, 1, this.f66e);
    }

    @Override // A.m
    public void e() {
        f fVar = this.f69h;
        if (fVar.f36j) {
            this.f63b.B0(fVar.f33g);
        }
    }

    @Override // A.m
    public void f() {
        this.f64c = null;
        this.f69h.c();
        this.f70i.c();
        this.f66e.c();
        this.f68g = false;
    }

    @Override // A.m
    public boolean m() {
        return this.f65d != e.b.MATCH_CONSTRAINT || this.f63b.f25879l == 0;
    }

    public final void q(int[] iArr, int i7, int i8, int i9, int i10, float f7, int i11) {
        int i12 = i8 - i7;
        int i13 = i10 - i9;
        if (i11 != -1) {
            if (i11 == 0) {
                iArr[0] = (int) ((i13 * f7) + 0.5f);
                iArr[1] = i13;
                return;
            } else {
                if (i11 != 1) {
                    return;
                }
                iArr[0] = i12;
                iArr[1] = (int) ((i12 * f7) + 0.5f);
                return;
            }
        }
        int i14 = (int) ((i13 * f7) + 0.5f);
        int i15 = (int) ((i12 / f7) + 0.5f);
        if (i14 <= i12) {
            iArr[0] = i14;
            iArr[1] = i13;
        } else if (i15 <= i13) {
            iArr[0] = i12;
            iArr[1] = i15;
        }
    }

    public void r() {
        this.f68g = false;
        this.f69h.c();
        this.f69h.f36j = false;
        this.f70i.c();
        this.f70i.f36j = false;
        this.f66e.f36j = false;
    }

    public String toString() {
        return "HorizontalRun " + this.f63b.p();
    }
}
