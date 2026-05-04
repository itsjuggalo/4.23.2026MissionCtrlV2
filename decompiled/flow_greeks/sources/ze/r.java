package ze;

import com.revenuecat.purchases.common.events.EventsManager;
import gf.a;
import gf.d;
import gf.i;
import io.flutter.Build;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ze.q;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class r extends i.d implements gf.q {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static final r f26327p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static gf.r f26328q = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gf.d f26329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f26332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List f26333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q f26334h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f26335i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public q f26336j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f26337k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f26338l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f26339m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public byte f26340n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f26341o;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public r c(gf.e eVar, gf.g gVar) {
            return new r(eVar, gVar);
        }
    }

    static {
        r rVar = new r(true);
        f26327p = rVar;
        rVar.j0();
    }

    public static r R() {
        return f26327p;
    }

    private void j0() {
        this.f26331e = 6;
        this.f26332f = 0;
        List list = Collections.EMPTY_LIST;
        this.f26333g = list;
        this.f26334h = q.X();
        this.f26335i = 0;
        this.f26336j = q.X();
        this.f26337k = 0;
        this.f26338l = list;
        this.f26339m = list;
    }

    public static b k0() {
        return b.t();
    }

    public static b l0(r rVar) {
        return k0().j(rVar);
    }

    public static r n0(InputStream inputStream, gf.g gVar) {
        return (r) f26328q.b(inputStream, gVar);
    }

    public ze.b O(int i10) {
        return (ze.b) this.f26338l.get(i10);
    }

    public int P() {
        return this.f26338l.size();
    }

    public List Q() {
        return this.f26338l;
    }

    @Override // gf.q
    /* JADX INFO: renamed from: S, reason: merged with bridge method [inline-methods] */
    public r a() {
        return f26327p;
    }

    public q T() {
        return this.f26336j;
    }

    public int U() {
        return this.f26337k;
    }

    public int V() {
        return this.f26331e;
    }

    public int W() {
        return this.f26332f;
    }

    public s X(int i10) {
        return (s) this.f26333g.get(i10);
    }

    public int Y() {
        return this.f26333g.size();
    }

    public List Z() {
        return this.f26333g;
    }

    public q a0() {
        return this.f26334h;
    }

    @Override // gf.p
    public int b() {
        int i10 = this.f26341o;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f26330d & 1) == 1 ? gf.f.o(1, this.f26331e) : 0;
        if ((this.f26330d & 2) == 2) {
            iO += gf.f.o(2, this.f26332f);
        }
        for (int i11 = 0; i11 < this.f26333g.size(); i11++) {
            iO += gf.f.r(3, (gf.p) this.f26333g.get(i11));
        }
        if ((this.f26330d & 4) == 4) {
            iO += gf.f.r(4, this.f26334h);
        }
        if ((this.f26330d & 8) == 8) {
            iO += gf.f.o(5, this.f26335i);
        }
        if ((this.f26330d & 16) == 16) {
            iO += gf.f.r(6, this.f26336j);
        }
        if ((this.f26330d & 32) == 32) {
            iO += gf.f.o(7, this.f26337k);
        }
        for (int i12 = 0; i12 < this.f26338l.size(); i12++) {
            iO += gf.f.r(8, (gf.p) this.f26338l.get(i12));
        }
        int iP = 0;
        for (int i13 = 0; i13 < this.f26339m.size(); i13++) {
            iP += gf.f.p(((Integer) this.f26339m.get(i13)).intValue());
        }
        int size = iO + iP + (c0().size() * 2) + s() + this.f26329c.size();
        this.f26341o = size;
        return size;
    }

    public int b0() {
        return this.f26335i;
    }

    public List c0() {
        return this.f26339m;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26340n;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!g0()) {
            this.f26340n = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < Y(); i10++) {
            if (!X(i10).d()) {
                this.f26340n = (byte) 0;
                return false;
            }
        }
        if (h0() && !a0().d()) {
            this.f26340n = (byte) 0;
            return false;
        }
        if (d0() && !T().d()) {
            this.f26340n = (byte) 0;
            return false;
        }
        for (int i11 = 0; i11 < P(); i11++) {
            if (!O(i11).d()) {
                this.f26340n = (byte) 0;
                return false;
            }
        }
        if (r()) {
            this.f26340n = (byte) 1;
            return true;
        }
        this.f26340n = (byte) 0;
        return false;
    }

    public boolean d0() {
        return (this.f26330d & 16) == 16;
    }

    public boolean e0() {
        return (this.f26330d & 32) == 32;
    }

    public boolean f0() {
        return (this.f26330d & 1) == 1;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        i.d.a aVarY = y();
        if ((this.f26330d & 1) == 1) {
            fVar.Z(1, this.f26331e);
        }
        if ((this.f26330d & 2) == 2) {
            fVar.Z(2, this.f26332f);
        }
        for (int i10 = 0; i10 < this.f26333g.size(); i10++) {
            fVar.c0(3, (gf.p) this.f26333g.get(i10));
        }
        if ((this.f26330d & 4) == 4) {
            fVar.c0(4, this.f26334h);
        }
        if ((this.f26330d & 8) == 8) {
            fVar.Z(5, this.f26335i);
        }
        if ((this.f26330d & 16) == 16) {
            fVar.c0(6, this.f26336j);
        }
        if ((this.f26330d & 32) == 32) {
            fVar.Z(7, this.f26337k);
        }
        for (int i11 = 0; i11 < this.f26338l.size(); i11++) {
            fVar.c0(8, (gf.p) this.f26338l.get(i11));
        }
        for (int i12 = 0; i12 < this.f26339m.size(); i12++) {
            fVar.Z(31, ((Integer) this.f26339m.get(i12)).intValue());
        }
        aVarY.a(200, fVar);
        fVar.h0(this.f26329c);
    }

    public boolean g0() {
        return (this.f26330d & 2) == 2;
    }

    public boolean h0() {
        return (this.f26330d & 4) == 4;
    }

    public boolean i0() {
        return (this.f26330d & 8) == 8;
    }

    @Override // gf.p
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public b c() {
        return k0();
    }

    @Override // gf.p
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public b f() {
        return l0(this);
    }

    public r(i.c cVar) {
        super(cVar);
        this.f26340n = (byte) -1;
        this.f26341o = -1;
        this.f26329c = cVar.i();
    }

    public r(boolean z10) {
        this.f26340n = (byte) -1;
        this.f26341o = -1;
        this.f26329c = gf.d.f10630a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public r(gf.e eVar, gf.g gVar) {
        q.c cVarF;
        this.f26340n = (byte) -1;
        this.f26341o = -1;
        j0();
        d.b bVarV = gf.d.v();
        gf.f fVarI = gf.f.I(bVarV, 1);
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            ?? O = 128;
            if (!z10) {
                try {
                    try {
                        int iJ = eVar.J();
                        switch (iJ) {
                            case 0:
                                z10 = true;
                                break;
                            case 8:
                                this.f26330d |= 1;
                                this.f26331e = eVar.r();
                                break;
                            case 16:
                                this.f26330d |= 2;
                                this.f26332f = eVar.r();
                                break;
                            case Build.API_LEVELS.API_26 /* 26 */:
                                if ((i10 & 4) != 4) {
                                    this.f26333g = new ArrayList();
                                    i10 |= 4;
                                }
                                this.f26333g.add(eVar.t(s.f26353o, gVar));
                                break;
                            case Build.API_LEVELS.API_34 /* 34 */:
                                cVarF = (this.f26330d & 4) == 4 ? this.f26334h.f() : null;
                                q qVar = (q) eVar.t(q.f26273v, gVar);
                                this.f26334h = qVar;
                                if (cVarF != null) {
                                    cVarF.j(qVar);
                                    this.f26334h = cVarF.r();
                                }
                                this.f26330d |= 4;
                                break;
                            case 40:
                                this.f26330d |= 8;
                                this.f26335i = eVar.r();
                                break;
                            case EventsManager.EVENTS_TO_CLEAR_ON_LIMIT /* 50 */:
                                cVarF = (this.f26330d & 16) == 16 ? this.f26336j.f() : null;
                                q qVar2 = (q) eVar.t(q.f26273v, gVar);
                                this.f26336j = qVar2;
                                if (cVarF != null) {
                                    cVarF.j(qVar2);
                                    this.f26336j = cVarF.r();
                                }
                                this.f26330d |= 16;
                                break;
                            case 56:
                                this.f26330d |= 32;
                                this.f26337k = eVar.r();
                                break;
                            case 66:
                                if ((i10 & 128) != 128) {
                                    this.f26338l = new ArrayList();
                                    i10 |= 128;
                                }
                                this.f26338l.add(eVar.t(ze.b.f25912i, gVar));
                                break;
                            case 248:
                                if ((i10 & 256) != 256) {
                                    this.f26339m = new ArrayList();
                                    i10 |= 256;
                                }
                                this.f26339m.add(Integer.valueOf(eVar.r()));
                                break;
                            case 250:
                                int i11 = eVar.i(eVar.z());
                                if ((i10 & 256) != 256 && eVar.e() > 0) {
                                    this.f26339m = new ArrayList();
                                    i10 |= 256;
                                }
                                while (eVar.e() > 0) {
                                    this.f26339m.add(Integer.valueOf(eVar.r()));
                                }
                                eVar.h(i11);
                                break;
                            default:
                                O = o(eVar, fVarI, gVar, iJ);
                                if (O == 0) {
                                    z10 = true;
                                }
                                break;
                        }
                    } catch (Throwable th) {
                        if ((i10 & 4) == 4) {
                            this.f26333g = Collections.unmodifiableList(this.f26333g);
                        }
                        if ((i10 & 128) == O) {
                            this.f26338l = Collections.unmodifiableList(this.f26338l);
                        }
                        if ((i10 & 256) == 256) {
                            this.f26339m = Collections.unmodifiableList(this.f26339m);
                        }
                        try {
                            fVarI.H();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f26329c = bVarV.u();
                            throw th2;
                        }
                        this.f26329c = bVarV.u();
                        l();
                        throw th;
                    }
                } catch (gf.k e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new gf.k(e11.getMessage()).i(this);
                }
            } else {
                if ((i10 & 4) == 4) {
                    this.f26333g = Collections.unmodifiableList(this.f26333g);
                }
                if ((i10 & 128) == 128) {
                    this.f26338l = Collections.unmodifiableList(this.f26338l);
                }
                if ((i10 & 256) == 256) {
                    this.f26339m = Collections.unmodifiableList(this.f26339m);
                }
                try {
                    fVarI.H();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.f26329c = bVarV.u();
                    throw th3;
                }
                this.f26329c = bVarV.u();
                l();
                return;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.c implements gf.q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26342d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f26343e = 6;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f26344f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public List f26345g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public q f26346h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f26347i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public q f26348j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f26349k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List f26350l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public List f26351m;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.f26345g = list;
            this.f26346h = q.X();
            this.f26348j = q.X();
            this.f26350l = list;
            this.f26351m = list;
            y();
        }

        public static b t() {
            return new b();
        }

        private void w() {
            if ((this.f26342d & 4) != 4) {
                this.f26345g = new ArrayList(this.f26345g);
                this.f26342d |= 4;
            }
        }

        private void x() {
            if ((this.f26342d & 256) != 256) {
                this.f26351m = new ArrayList(this.f26351m);
                this.f26342d |= 256;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.r.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.r.f26328q     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.r r3 = (ze.r) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                if (r3 == 0) goto Le
                r2.j(r3)
            Le:
                return r2
            Lf:
                r3 = move-exception
                goto L1b
            L11:
                r3 = move-exception
                gf.p r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                ze.r r4 = (ze.r) r4     // Catch: java.lang.Throwable -> Lf
                throw r3     // Catch: java.lang.Throwable -> L19
            L19:
                r3 = move-exception
                r0 = r4
            L1b:
                if (r0 == 0) goto L20
                r2.j(r0)
            L20:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: ze.r.b.u(gf.e, gf.g):ze.r$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public b j(r rVar) {
            if (rVar == r.R()) {
                return this;
            }
            if (rVar.f0()) {
                E(rVar.V());
            }
            if (rVar.g0()) {
                F(rVar.W());
            }
            if (!rVar.f26333g.isEmpty()) {
                if (this.f26345g.isEmpty()) {
                    this.f26345g = rVar.f26333g;
                    this.f26342d &= -5;
                } else {
                    w();
                    this.f26345g.addAll(rVar.f26333g);
                }
            }
            if (rVar.h0()) {
                C(rVar.a0());
            }
            if (rVar.i0()) {
                G(rVar.b0());
            }
            if (rVar.d0()) {
                z(rVar.T());
            }
            if (rVar.e0()) {
                D(rVar.U());
            }
            if (!rVar.f26338l.isEmpty()) {
                if (this.f26350l.isEmpty()) {
                    this.f26350l = rVar.f26338l;
                    this.f26342d &= -129;
                } else {
                    v();
                    this.f26350l.addAll(rVar.f26338l);
                }
            }
            if (!rVar.f26339m.isEmpty()) {
                if (this.f26351m.isEmpty()) {
                    this.f26351m = rVar.f26339m;
                    this.f26342d &= -257;
                } else {
                    x();
                    this.f26351m.addAll(rVar.f26339m);
                }
            }
            o(rVar);
            k(i().c(rVar.f26329c));
            return this;
        }

        public b C(q qVar) {
            if ((this.f26342d & 8) != 8 || this.f26346h == q.X()) {
                this.f26346h = qVar;
            } else {
                this.f26346h = q.y0(this.f26346h).j(qVar).r();
            }
            this.f26342d |= 8;
            return this;
        }

        public b D(int i10) {
            this.f26342d |= 64;
            this.f26349k = i10;
            return this;
        }

        public b E(int i10) {
            this.f26342d |= 1;
            this.f26343e = i10;
            return this;
        }

        public b F(int i10) {
            this.f26342d |= 2;
            this.f26344f = i10;
            return this;
        }

        public b G(int i10) {
            this.f26342d |= 16;
            this.f26347i = i10;
            return this;
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public r build() {
            r rVarR = r();
            if (rVarR.d()) {
                return rVarR;
            }
            throw a.AbstractC0191a.h(rVarR);
        }

        public r r() {
            r rVar = new r(this);
            int i10 = this.f26342d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            rVar.f26331e = this.f26343e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            rVar.f26332f = this.f26344f;
            if ((this.f26342d & 4) == 4) {
                this.f26345g = Collections.unmodifiableList(this.f26345g);
                this.f26342d &= -5;
            }
            rVar.f26333g = this.f26345g;
            if ((i10 & 8) == 8) {
                i11 |= 4;
            }
            rVar.f26334h = this.f26346h;
            if ((i10 & 16) == 16) {
                i11 |= 8;
            }
            rVar.f26335i = this.f26347i;
            if ((i10 & 32) == 32) {
                i11 |= 16;
            }
            rVar.f26336j = this.f26348j;
            if ((i10 & 64) == 64) {
                i11 |= 32;
            }
            rVar.f26337k = this.f26349k;
            if ((this.f26342d & 128) == 128) {
                this.f26350l = Collections.unmodifiableList(this.f26350l);
                this.f26342d &= -129;
            }
            rVar.f26338l = this.f26350l;
            if ((this.f26342d & 256) == 256) {
                this.f26351m = Collections.unmodifiableList(this.f26351m);
                this.f26342d &= -257;
            }
            rVar.f26339m = this.f26351m;
            rVar.f26330d = i11;
            return rVar;
        }

        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return t().j(r());
        }

        public final void v() {
            if ((this.f26342d & 128) != 128) {
                this.f26350l = new ArrayList(this.f26350l);
                this.f26342d |= 128;
            }
        }

        public b z(q qVar) {
            if ((this.f26342d & 32) != 32 || this.f26348j == q.X()) {
                this.f26348j = qVar;
            } else {
                this.f26348j = q.y0(this.f26348j).j(qVar).r();
            }
            this.f26342d |= 32;
            return this;
        }

        private void y() {
        }
    }
}
