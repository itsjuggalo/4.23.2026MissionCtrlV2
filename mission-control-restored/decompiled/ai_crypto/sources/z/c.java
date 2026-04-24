package z;

import java.util.ArrayList;
import z.e;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f25790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f25791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f25792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f25793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f25794e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f25795f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f25796g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f25797h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f25798i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f25799j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f25800k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f25801l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f25802m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f25803n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f25804o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f25805p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f25806q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f25807r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f25808s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f25809t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f25810u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f25811v;

    public c(e eVar, int i7, boolean z7) {
        this.f25790a = eVar;
        this.f25805p = i7;
        this.f25806q = z7;
    }

    public static boolean c(e eVar, int i7) {
        int i8;
        return eVar.M() != 8 && eVar.f25843M[i7] == e.b.MATCH_CONSTRAINT && ((i8 = eVar.f25883n[i7]) == 0 || i8 == 3);
    }

    public void a() {
        if (!this.f25811v) {
            b();
        }
        this.f25811v = true;
    }

    public final void b() {
        int i7 = this.f25805p * 2;
        e eVar = this.f25790a;
        this.f25804o = true;
        e eVar2 = eVar;
        boolean z7 = false;
        while (!z7) {
            this.f25798i++;
            e[] eVarArr = eVar.f25894s0;
            int i8 = this.f25805p;
            e eVar3 = null;
            eVarArr[i8] = null;
            eVar.f25892r0[i8] = null;
            if (eVar.M() != 8) {
                this.f25801l++;
                e.b bVarQ = eVar.q(this.f25805p);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarQ != bVar) {
                    this.f25802m += eVar.y(this.f25805p);
                }
                int iB = this.f25802m + eVar.f25840J[i7].b();
                this.f25802m = iB;
                int i9 = i7 + 1;
                this.f25802m = iB + eVar.f25840J[i9].b();
                int iB2 = this.f25803n + eVar.f25840J[i7].b();
                this.f25803n = iB2;
                this.f25803n = iB2 + eVar.f25840J[i9].b();
                if (this.f25791b == null) {
                    this.f25791b = eVar;
                }
                this.f25793d = eVar;
                e.b[] bVarArr = eVar.f25843M;
                int i10 = this.f25805p;
                if (bVarArr[i10] == bVar) {
                    int i11 = eVar.f25883n[i10];
                    if (i11 == 0 || i11 == 3 || i11 == 2) {
                        this.f25799j++;
                        float f7 = eVar.f25890q0[i10];
                        if (f7 > 0.0f) {
                            this.f25800k += f7;
                        }
                        if (c(eVar, i10)) {
                            if (f7 < 0.0f) {
                                this.f25807r = true;
                            } else {
                                this.f25808s = true;
                            }
                            if (this.f25797h == null) {
                                this.f25797h = new ArrayList();
                            }
                            this.f25797h.add(eVar);
                        }
                        if (this.f25795f == null) {
                            this.f25795f = eVar;
                        }
                        e eVar4 = this.f25796g;
                        if (eVar4 != null) {
                            eVar4.f25892r0[this.f25805p] = eVar;
                        }
                        this.f25796g = eVar;
                    }
                    if (this.f25805p == 0) {
                        if (eVar.f25879l != 0 || eVar.f25885o != 0 || eVar.f25887p != 0) {
                            this.f25804o = false;
                        }
                    } else if (eVar.f25881m != 0 || eVar.f25891r != 0 || eVar.f25893s != 0) {
                        this.f25804o = false;
                    }
                    if (eVar.f25847Q != 0.0f) {
                        this.f25804o = false;
                        this.f25810u = true;
                    }
                }
            }
            if (eVar2 != eVar) {
                eVar2.f25894s0[this.f25805p] = eVar;
            }
            d dVar = eVar.f25840J[i7 + 1].f25815d;
            if (dVar != null) {
                e eVar5 = dVar.f25813b;
                d dVar2 = eVar5.f25840J[i7].f25815d;
                if (dVar2 != null && dVar2.f25813b == eVar) {
                    eVar3 = eVar5;
                }
            }
            if (eVar3 == null) {
                eVar3 = eVar;
                z7 = true;
            }
            eVar2 = eVar;
            eVar = eVar3;
        }
        e eVar6 = this.f25791b;
        if (eVar6 != null) {
            this.f25802m -= eVar6.f25840J[i7].b();
        }
        e eVar7 = this.f25793d;
        if (eVar7 != null) {
            this.f25802m -= eVar7.f25840J[i7 + 1].b();
        }
        this.f25792c = eVar;
        if (this.f25805p == 0 && this.f25806q) {
            this.f25794e = eVar;
        } else {
            this.f25794e = this.f25790a;
        }
        this.f25809t = this.f25808s && this.f25807r;
    }
}
