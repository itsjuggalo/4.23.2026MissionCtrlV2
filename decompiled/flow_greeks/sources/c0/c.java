package c0;

import c0.e;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f3415a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f3416b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f3417c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f3418d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f3419e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f3420f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f3421g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f3422h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f3423i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f3424j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f3425k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f3426l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f3427m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f3428n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f3429o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f3430p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f3431q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f3432r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f3433s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f3434t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f3435u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f3436v;

    public c(e eVar, int i10, boolean z10) {
        this.f3415a = eVar;
        this.f3430p = i10;
        this.f3431q = z10;
    }

    public static boolean c(e eVar, int i10) {
        if (eVar.T() == 8 || eVar.Z[i10] != e.b.MATCH_CONSTRAINT) {
            return false;
        }
        int i11 = eVar.f3505y[i10];
        return i11 == 0 || i11 == 3;
    }

    public void a() {
        if (!this.f3436v) {
            b();
        }
        this.f3436v = true;
    }

    public final void b() {
        int i10 = this.f3430p * 2;
        e eVar = this.f3415a;
        this.f3429o = true;
        e eVar2 = eVar;
        boolean z10 = false;
        while (!z10) {
            this.f3423i++;
            e[] eVarArr = eVar.F0;
            int i11 = this.f3430p;
            e eVar3 = null;
            eVarArr[i11] = null;
            eVar.E0[i11] = null;
            if (eVar.T() != 8) {
                this.f3426l++;
                e.b bVarS = eVar.s(this.f3430p);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarS != bVar) {
                    this.f3427m += eVar.C(this.f3430p);
                }
                int iE = this.f3427m + eVar.W[i10].e();
                this.f3427m = iE;
                int i12 = i10 + 1;
                this.f3427m = iE + eVar.W[i12].e();
                int iE2 = this.f3428n + eVar.W[i10].e();
                this.f3428n = iE2;
                this.f3428n = iE2 + eVar.W[i12].e();
                if (this.f3416b == null) {
                    this.f3416b = eVar;
                }
                this.f3418d = eVar;
                e.b[] bVarArr = eVar.Z;
                int i13 = this.f3430p;
                if (bVarArr[i13] == bVar) {
                    int i14 = eVar.f3505y[i13];
                    if (i14 == 0 || i14 == 3 || i14 == 2) {
                        this.f3424j++;
                        float f10 = eVar.D0[i13];
                        if (f10 > 0.0f) {
                            this.f3425k += f10;
                        }
                        if (c(eVar, i13)) {
                            if (f10 < 0.0f) {
                                this.f3432r = true;
                            } else {
                                this.f3433s = true;
                            }
                            if (this.f3422h == null) {
                                this.f3422h = new ArrayList();
                            }
                            this.f3422h.add(eVar);
                        }
                        if (this.f3420f == null) {
                            this.f3420f = eVar;
                        }
                        e eVar4 = this.f3421g;
                        if (eVar4 != null) {
                            eVar4.E0[this.f3430p] = eVar;
                        }
                        this.f3421g = eVar;
                    }
                    if (this.f3430p == 0) {
                        if (eVar.f3501w != 0 || eVar.f3507z != 0 || eVar.A != 0) {
                            this.f3429o = false;
                        }
                    } else if (eVar.f3503x != 0 || eVar.C != 0 || eVar.D != 0) {
                        this.f3429o = false;
                    }
                    if (eVar.f3464d0 != 0.0f) {
                        this.f3429o = false;
                        this.f3435u = true;
                    }
                }
            }
            if (eVar2 != eVar) {
                eVar2.F0[this.f3430p] = eVar;
            }
            d dVar = eVar.W[i10 + 1].f3442f;
            if (dVar != null) {
                e eVar5 = dVar.f3440d;
                d dVar2 = eVar5.W[i10].f3442f;
                if (dVar2 != null && dVar2.f3440d == eVar) {
                    eVar3 = eVar5;
                }
            }
            if (eVar3 == null) {
                eVar3 = eVar;
                z10 = true;
            }
            eVar2 = eVar;
            eVar = eVar3;
        }
        e eVar6 = this.f3416b;
        if (eVar6 != null) {
            this.f3427m -= eVar6.W[i10].e();
        }
        e eVar7 = this.f3418d;
        if (eVar7 != null) {
            this.f3427m -= eVar7.W[i10 + 1].e();
        }
        this.f3417c = eVar;
        if (this.f3430p == 0 && this.f3431q) {
            this.f3419e = eVar;
        } else {
            this.f3419e = this.f3415a;
        }
        this.f3434t = this.f3433s && this.f3432r;
    }
}
