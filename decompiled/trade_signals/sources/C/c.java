package C;

import C.e;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f244a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f245b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public e f246c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public e f247d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public e f248e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public e f249f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public e f250g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ArrayList f251h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f252i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f253j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public float f254k = 0.0f;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f255l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f256m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f257n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f258o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f259p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f260q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f261r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f262s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public boolean f263t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f264u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f265v;

    public c(e eVar, int i8, boolean z7) {
        this.f244a = eVar;
        this.f259p = i8;
        this.f260q = z7;
    }

    public static boolean c(e eVar, int i8) {
        int i9;
        return eVar.T() != 8 && eVar.f322Z[i8] == e.b.MATCH_CONSTRAINT && ((i9 = eVar.f371y[i8]) == 0 || i9 == 3);
    }

    public void a() {
        if (!this.f265v) {
            b();
        }
        this.f265v = true;
    }

    public final void b() {
        int i8 = this.f259p * 2;
        e eVar = this.f244a;
        this.f258o = true;
        e eVar2 = eVar;
        boolean z7 = false;
        while (!z7) {
            this.f252i++;
            e[] eVarArr = eVar.f298F0;
            int i9 = this.f259p;
            e eVar3 = null;
            eVarArr[i9] = null;
            eVar.f296E0[i9] = null;
            if (eVar.T() != 8) {
                this.f255l++;
                e.b bVarS = eVar.s(this.f259p);
                e.b bVar = e.b.MATCH_CONSTRAINT;
                if (bVarS != bVar) {
                    this.f256m += eVar.C(this.f259p);
                }
                int iE = this.f256m + eVar.f319W[i8].e();
                this.f256m = iE;
                int i10 = i8 + 1;
                this.f256m = iE + eVar.f319W[i10].e();
                int iE2 = this.f257n + eVar.f319W[i8].e();
                this.f257n = iE2;
                this.f257n = iE2 + eVar.f319W[i10].e();
                if (this.f245b == null) {
                    this.f245b = eVar;
                }
                this.f247d = eVar;
                e.b[] bVarArr = eVar.f322Z;
                int i11 = this.f259p;
                if (bVarArr[i11] == bVar) {
                    int i12 = eVar.f371y[i11];
                    if (i12 == 0 || i12 == 3 || i12 == 2) {
                        this.f253j++;
                        float f8 = eVar.f294D0[i11];
                        if (f8 > 0.0f) {
                            this.f254k += f8;
                        }
                        if (c(eVar, i11)) {
                            if (f8 < 0.0f) {
                                this.f261r = true;
                            } else {
                                this.f262s = true;
                            }
                            if (this.f251h == null) {
                                this.f251h = new ArrayList();
                            }
                            this.f251h.add(eVar);
                        }
                        if (this.f249f == null) {
                            this.f249f = eVar;
                        }
                        e eVar4 = this.f250g;
                        if (eVar4 != null) {
                            eVar4.f296E0[this.f259p] = eVar;
                        }
                        this.f250g = eVar;
                    }
                    if (this.f259p != 0 ? !(eVar.f369x == 0 && eVar.f291C == 0 && eVar.f293D == 0) : !(eVar.f367w == 0 && eVar.f373z == 0 && eVar.f287A == 0)) {
                        this.f258o = false;
                    }
                    if (eVar.f330d0 != 0.0f) {
                        this.f258o = false;
                        this.f264u = true;
                    }
                }
            }
            if (eVar2 != eVar) {
                eVar2.f298F0[this.f259p] = eVar;
            }
            d dVar = eVar.f319W[i8 + 1].f271f;
            if (dVar != null) {
                e eVar5 = dVar.f269d;
                d dVar2 = eVar5.f319W[i8].f271f;
                if (dVar2 != null && dVar2.f269d == eVar) {
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
        e eVar6 = this.f245b;
        if (eVar6 != null) {
            this.f256m -= eVar6.f319W[i8].e();
        }
        e eVar7 = this.f247d;
        if (eVar7 != null) {
            this.f256m -= eVar7.f319W[i8 + 1].e();
        }
        this.f246c = eVar;
        if (this.f259p == 0 && this.f260q) {
            this.f248e = eVar;
        } else {
            this.f248e = this.f244a;
        }
        this.f263t = this.f262s && this.f261r;
    }
}
