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
import ze.e;
import ze.q;
import ze.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends i.d implements gf.q {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final i f26119v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static gf.r f26120w = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gf.d f26121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26123e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f26124f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f26125g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q f26126h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f26127i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f26128j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public q f26129k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f26130l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f26131m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f26132n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f26133o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public List f26134p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public t f26135q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f26136r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public e f26137s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public byte f26138t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f26139u;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public i c(gf.e eVar, gf.g gVar) {
            return new i(eVar, gVar);
        }
    }

    static {
        i iVar = new i(true);
        f26119v = iVar;
        iVar.A0();
    }

    private void A0() {
        this.f26123e = 6;
        this.f26124f = 6;
        this.f26125g = 0;
        this.f26126h = q.X();
        this.f26127i = 0;
        List list = Collections.EMPTY_LIST;
        this.f26128j = list;
        this.f26129k = q.X();
        this.f26130l = 0;
        this.f26131m = list;
        this.f26132n = list;
        this.f26134p = list;
        this.f26135q = t.w();
        this.f26136r = list;
        this.f26137s = e.t();
    }

    public static b B0() {
        return b.t();
    }

    public static b C0(i iVar) {
        return B0().j(iVar);
    }

    public static i E0(InputStream inputStream, gf.g gVar) {
        return (i) f26120w.a(inputStream, gVar);
    }

    public static i a0() {
        return f26119v;
    }

    @Override // gf.p
    /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
    public b c() {
        return B0();
    }

    @Override // gf.p
    /* JADX INFO: renamed from: F0, reason: merged with bridge method [inline-methods] */
    public b f() {
        return C0(this);
    }

    public q V(int i10) {
        return (q) this.f26131m.get(i10);
    }

    public int W() {
        return this.f26131m.size();
    }

    public List X() {
        return this.f26132n;
    }

    public List Y() {
        return this.f26131m;
    }

    public e Z() {
        return this.f26137s;
    }

    @Override // gf.p
    public int b() {
        int i10 = this.f26139u;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f26122d & 2) == 2 ? gf.f.o(1, this.f26124f) : 0;
        if ((this.f26122d & 4) == 4) {
            iO += gf.f.o(2, this.f26125g);
        }
        if ((this.f26122d & 8) == 8) {
            iO += gf.f.r(3, this.f26126h);
        }
        for (int i11 = 0; i11 < this.f26128j.size(); i11++) {
            iO += gf.f.r(4, (gf.p) this.f26128j.get(i11));
        }
        if ((this.f26122d & 32) == 32) {
            iO += gf.f.r(5, this.f26129k);
        }
        for (int i12 = 0; i12 < this.f26134p.size(); i12++) {
            iO += gf.f.r(6, (gf.p) this.f26134p.get(i12));
        }
        if ((this.f26122d & 16) == 16) {
            iO += gf.f.o(7, this.f26127i);
        }
        if ((this.f26122d & 64) == 64) {
            iO += gf.f.o(8, this.f26130l);
        }
        if ((this.f26122d & 1) == 1) {
            iO += gf.f.o(9, this.f26123e);
        }
        for (int i13 = 0; i13 < this.f26131m.size(); i13++) {
            iO += gf.f.r(10, (gf.p) this.f26131m.get(i13));
        }
        int iP = 0;
        for (int i14 = 0; i14 < this.f26132n.size(); i14++) {
            iP += gf.f.p(((Integer) this.f26132n.get(i14)).intValue());
        }
        int iR = iO + iP;
        if (!X().isEmpty()) {
            iR = iR + 1 + gf.f.p(iP);
        }
        this.f26133o = iP;
        if ((this.f26122d & 128) == 128) {
            iR += gf.f.r(30, this.f26135q);
        }
        int iP2 = 0;
        for (int i15 = 0; i15 < this.f26136r.size(); i15++) {
            iP2 += gf.f.p(((Integer) this.f26136r.get(i15)).intValue());
        }
        int size = iR + iP2 + (q0().size() * 2);
        if ((this.f26122d & 256) == 256) {
            size += gf.f.r(32, this.f26137s);
        }
        int iS = size + s() + this.f26121c.size();
        this.f26139u = iS;
        return iS;
    }

    @Override // gf.q
    /* JADX INFO: renamed from: b0, reason: merged with bridge method [inline-methods] */
    public i a() {
        return f26119v;
    }

    public int c0() {
        return this.f26123e;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26138t;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!t0()) {
            this.f26138t = (byte) 0;
            return false;
        }
        if (x0() && !h0().d()) {
            this.f26138t = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < k0(); i10++) {
            if (!j0(i10).d()) {
                this.f26138t = (byte) 0;
                return false;
            }
        }
        if (v0() && !f0().d()) {
            this.f26138t = (byte) 0;
            return false;
        }
        for (int i11 = 0; i11 < W(); i11++) {
            if (!V(i11).d()) {
                this.f26138t = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < o0(); i12++) {
            if (!n0(i12).d()) {
                this.f26138t = (byte) 0;
                return false;
            }
        }
        if (z0() && !m0().d()) {
            this.f26138t = (byte) 0;
            return false;
        }
        if (r0() && !Z().d()) {
            this.f26138t = (byte) 0;
            return false;
        }
        if (r()) {
            this.f26138t = (byte) 1;
            return true;
        }
        this.f26138t = (byte) 0;
        return false;
    }

    public int d0() {
        return this.f26125g;
    }

    public int e0() {
        return this.f26124f;
    }

    public q f0() {
        return this.f26129k;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        i.d.a aVarY = y();
        if ((this.f26122d & 2) == 2) {
            fVar.Z(1, this.f26124f);
        }
        if ((this.f26122d & 4) == 4) {
            fVar.Z(2, this.f26125g);
        }
        if ((this.f26122d & 8) == 8) {
            fVar.c0(3, this.f26126h);
        }
        for (int i10 = 0; i10 < this.f26128j.size(); i10++) {
            fVar.c0(4, (gf.p) this.f26128j.get(i10));
        }
        if ((this.f26122d & 32) == 32) {
            fVar.c0(5, this.f26129k);
        }
        for (int i11 = 0; i11 < this.f26134p.size(); i11++) {
            fVar.c0(6, (gf.p) this.f26134p.get(i11));
        }
        if ((this.f26122d & 16) == 16) {
            fVar.Z(7, this.f26127i);
        }
        if ((this.f26122d & 64) == 64) {
            fVar.Z(8, this.f26130l);
        }
        if ((this.f26122d & 1) == 1) {
            fVar.Z(9, this.f26123e);
        }
        for (int i12 = 0; i12 < this.f26131m.size(); i12++) {
            fVar.c0(10, (gf.p) this.f26131m.get(i12));
        }
        if (X().size() > 0) {
            fVar.n0(90);
            fVar.n0(this.f26133o);
        }
        for (int i13 = 0; i13 < this.f26132n.size(); i13++) {
            fVar.a0(((Integer) this.f26132n.get(i13)).intValue());
        }
        if ((this.f26122d & 128) == 128) {
            fVar.c0(30, this.f26135q);
        }
        for (int i14 = 0; i14 < this.f26136r.size(); i14++) {
            fVar.Z(31, ((Integer) this.f26136r.get(i14)).intValue());
        }
        if ((this.f26122d & 256) == 256) {
            fVar.c0(32, this.f26137s);
        }
        aVarY.a(19000, fVar);
        fVar.h0(this.f26121c);
    }

    public int g0() {
        return this.f26130l;
    }

    public q h0() {
        return this.f26126h;
    }

    public int i0() {
        return this.f26127i;
    }

    public s j0(int i10) {
        return (s) this.f26128j.get(i10);
    }

    public int k0() {
        return this.f26128j.size();
    }

    public List l0() {
        return this.f26128j;
    }

    public t m0() {
        return this.f26135q;
    }

    public u n0(int i10) {
        return (u) this.f26134p.get(i10);
    }

    public int o0() {
        return this.f26134p.size();
    }

    public List p0() {
        return this.f26134p;
    }

    public List q0() {
        return this.f26136r;
    }

    public boolean r0() {
        return (this.f26122d & 256) == 256;
    }

    public boolean s0() {
        return (this.f26122d & 1) == 1;
    }

    public boolean t0() {
        return (this.f26122d & 4) == 4;
    }

    public boolean u0() {
        return (this.f26122d & 2) == 2;
    }

    public boolean v0() {
        return (this.f26122d & 32) == 32;
    }

    public boolean w0() {
        return (this.f26122d & 64) == 64;
    }

    public boolean x0() {
        return (this.f26122d & 8) == 8;
    }

    public boolean y0() {
        return (this.f26122d & 16) == 16;
    }

    public boolean z0() {
        return (this.f26122d & 128) == 128;
    }

    public i(i.c cVar) {
        super(cVar);
        this.f26133o = -1;
        this.f26138t = (byte) -1;
        this.f26139u = -1;
        this.f26121c = cVar.i();
    }

    public i(boolean z10) {
        this.f26133o = -1;
        this.f26138t = (byte) -1;
        this.f26139u = -1;
        this.f26121c = gf.d.f10630a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public i(gf.e eVar, gf.g gVar) {
        this.f26133o = -1;
        this.f26138t = (byte) -1;
        this.f26139u = -1;
        A0();
        d.b bVarV = gf.d.v();
        gf.f fVarI = gf.f.I(bVarV, 1);
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            ?? O = 1024;
            if (!z10) {
                try {
                    try {
                        int iJ = eVar.J();
                        switch (iJ) {
                            case 0:
                                z10 = true;
                                break;
                            case 8:
                                this.f26122d |= 2;
                                this.f26124f = eVar.r();
                                break;
                            case 16:
                                this.f26122d |= 4;
                                this.f26125g = eVar.r();
                                break;
                            case Build.API_LEVELS.API_26 /* 26 */:
                                q.c cVarA0 = (this.f26122d & 8) == 8 ? this.f26126h.f() : null;
                                q qVar = (q) eVar.t(q.f26273v, gVar);
                                this.f26126h = qVar;
                                if (cVarA0 != null) {
                                    cVarA0.j(qVar);
                                    this.f26126h = cVarA0.r();
                                }
                                this.f26122d |= 8;
                                break;
                            case Build.API_LEVELS.API_34 /* 34 */:
                                int i11 = (i10 == true ? 1 : 0) & 32;
                                i10 = i10;
                                if (i11 != 32) {
                                    this.f26128j = new ArrayList();
                                    i10 = (i10 == true ? 1 : 0) | 32;
                                }
                                this.f26128j.add(eVar.t(s.f26353o, gVar));
                                break;
                            case 42:
                                q.c cVarA02 = (this.f26122d & 32) == 32 ? this.f26129k.f() : null;
                                q qVar2 = (q) eVar.t(q.f26273v, gVar);
                                this.f26129k = qVar2;
                                if (cVarA02 != null) {
                                    cVarA02.j(qVar2);
                                    this.f26129k = cVarA02.r();
                                }
                                this.f26122d |= 32;
                                break;
                            case EventsManager.EVENTS_TO_CLEAR_ON_LIMIT /* 50 */:
                                int i12 = (i10 == true ? 1 : 0) & 1024;
                                i10 = i10;
                                if (i12 != 1024) {
                                    this.f26134p = new ArrayList();
                                    i10 = (i10 == true ? 1 : 0) | 1024;
                                }
                                this.f26134p.add(eVar.t(u.f26390n, gVar));
                                break;
                            case 56:
                                this.f26122d |= 16;
                                this.f26127i = eVar.r();
                                break;
                            case 64:
                                this.f26122d |= 64;
                                this.f26130l = eVar.r();
                                break;
                            case 72:
                                this.f26122d |= 1;
                                this.f26123e = eVar.r();
                                break;
                            case 82:
                                int i13 = (i10 == true ? 1 : 0) & 256;
                                i10 = i10;
                                if (i13 != 256) {
                                    this.f26131m = new ArrayList();
                                    i10 = (i10 == true ? 1 : 0) | 256;
                                }
                                this.f26131m.add(eVar.t(q.f26273v, gVar));
                                break;
                            case 88:
                                int i14 = (i10 == true ? 1 : 0) & 512;
                                i10 = i10;
                                if (i14 != 512) {
                                    this.f26132n = new ArrayList();
                                    i10 = (i10 == true ? 1 : 0) | 512;
                                }
                                this.f26132n.add(Integer.valueOf(eVar.r()));
                                break;
                            case 90:
                                int i15 = eVar.i(eVar.z());
                                int i16 = (i10 == true ? 1 : 0) & 512;
                                i10 = i10;
                                if (i16 != 512) {
                                    i10 = i10;
                                    if (eVar.e() > 0) {
                                        this.f26132n = new ArrayList();
                                        i10 = (i10 == true ? 1 : 0) | 512;
                                    }
                                }
                                while (eVar.e() > 0) {
                                    this.f26132n.add(Integer.valueOf(eVar.r()));
                                }
                                eVar.h(i15);
                                break;
                            case 242:
                                t.b bVarG = (this.f26122d & 128) == 128 ? this.f26135q.f() : null;
                                t tVar = (t) eVar.t(t.f26379i, gVar);
                                this.f26135q = tVar;
                                if (bVarG != null) {
                                    bVarG.j(tVar);
                                    this.f26135q = bVarG.n();
                                }
                                this.f26122d |= 128;
                                break;
                            case 248:
                                int i17 = (i10 == true ? 1 : 0) & 4096;
                                i10 = i10;
                                if (i17 != 4096) {
                                    this.f26136r = new ArrayList();
                                    i10 = (i10 == true ? 1 : 0) | 4096;
                                }
                                this.f26136r.add(Integer.valueOf(eVar.r()));
                                break;
                            case 250:
                                int i18 = eVar.i(eVar.z());
                                int i19 = (i10 == true ? 1 : 0) & 4096;
                                i10 = i10;
                                if (i19 != 4096) {
                                    i10 = i10;
                                    if (eVar.e() > 0) {
                                        this.f26136r = new ArrayList();
                                        i10 = (i10 == true ? 1 : 0) | 4096;
                                    }
                                }
                                while (eVar.e() > 0) {
                                    this.f26136r.add(Integer.valueOf(eVar.r()));
                                }
                                eVar.h(i18);
                                break;
                            case 258:
                                e.b bVarB = (this.f26122d & 256) == 256 ? this.f26137s.f() : null;
                                e eVar2 = (e) eVar.t(e.f26049g, gVar);
                                this.f26137s = eVar2;
                                if (bVarB != null) {
                                    bVarB.j(eVar2);
                                    this.f26137s = bVarB.n();
                                }
                                this.f26122d |= 256;
                                break;
                            default:
                                O = o(eVar, fVarI, gVar, iJ);
                                if (O == 0) {
                                    z10 = true;
                                }
                                break;
                        }
                    } catch (gf.k e10) {
                        throw e10.i(this);
                    } catch (IOException e11) {
                        throw new gf.k(e11.getMessage()).i(this);
                    }
                } catch (Throwable th) {
                    if (((i10 == true ? 1 : 0) & 32) == 32) {
                        this.f26128j = Collections.unmodifiableList(this.f26128j);
                    }
                    if (((i10 == true ? 1 : 0) & 1024) == O) {
                        this.f26134p = Collections.unmodifiableList(this.f26134p);
                    }
                    if (((i10 == true ? 1 : 0) & 256) == 256) {
                        this.f26131m = Collections.unmodifiableList(this.f26131m);
                    }
                    if (((i10 == true ? 1 : 0) & 512) == 512) {
                        this.f26132n = Collections.unmodifiableList(this.f26132n);
                    }
                    if (((i10 == true ? 1 : 0) & 4096) == 4096) {
                        this.f26136r = Collections.unmodifiableList(this.f26136r);
                    }
                    try {
                        fVarI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f26121c = bVarV.u();
                        throw th2;
                    }
                    this.f26121c = bVarV.u();
                    l();
                    throw th;
                }
            } else {
                if (((i10 == true ? 1 : 0) & 32) == 32) {
                    this.f26128j = Collections.unmodifiableList(this.f26128j);
                }
                if (((i10 == true ? 1 : 0) & 1024) == 1024) {
                    this.f26134p = Collections.unmodifiableList(this.f26134p);
                }
                if (((i10 == true ? 1 : 0) & 256) == 256) {
                    this.f26131m = Collections.unmodifiableList(this.f26131m);
                }
                if (((i10 == true ? 1 : 0) & 512) == 512) {
                    this.f26132n = Collections.unmodifiableList(this.f26132n);
                }
                if (((i10 == true ? 1 : 0) & 4096) == 4096) {
                    this.f26136r = Collections.unmodifiableList(this.f26136r);
                }
                try {
                    fVarI.H();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.f26121c = bVarV.u();
                    throw th3;
                }
                this.f26121c = bVarV.u();
                l();
                return;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.c implements gf.q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26140d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f26143g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f26145i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List f26146j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public q f26147k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f26148l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public List f26149m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public List f26150n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public List f26151o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public t f26152p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public List f26153q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public e f26154r;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f26141e = 6;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f26142f = 6;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public q f26144h = q.X();

        public b() {
            List list = Collections.EMPTY_LIST;
            this.f26146j = list;
            this.f26147k = q.X();
            this.f26149m = list;
            this.f26150n = list;
            this.f26151o = list;
            this.f26152p = t.w();
            this.f26153q = list;
            this.f26154r = e.t();
            A();
        }

        public static b t() {
            return new b();
        }

        private void v() {
            if ((this.f26140d & 512) != 512) {
                this.f26150n = new ArrayList(this.f26150n);
                this.f26140d |= 512;
            }
        }

        private void w() {
            if ((this.f26140d & 256) != 256) {
                this.f26149m = new ArrayList(this.f26149m);
                this.f26140d |= 256;
            }
        }

        private void x() {
            if ((this.f26140d & 32) != 32) {
                this.f26146j = new ArrayList(this.f26146j);
                this.f26140d |= 32;
            }
        }

        private void y() {
            if ((this.f26140d & 1024) != 1024) {
                this.f26151o = new ArrayList(this.f26151o);
                this.f26140d |= 1024;
            }
        }

        private void z() {
            if ((this.f26140d & 4096) != 4096) {
                this.f26153q = new ArrayList(this.f26153q);
                this.f26140d |= 4096;
            }
        }

        public b B(e eVar) {
            if ((this.f26140d & 8192) != 8192 || this.f26154r == e.t()) {
                this.f26154r = eVar;
            } else {
                this.f26154r = e.z(this.f26154r).j(eVar).n();
            }
            this.f26140d |= 8192;
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.i.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.i.f26120w     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.i r3 = (ze.i) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.i r4 = (ze.i) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.i.b.u(gf.e, gf.g):ze.i$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public b j(i iVar) {
            if (iVar == i.a0()) {
                return this;
            }
            if (iVar.s0()) {
                H(iVar.c0());
            }
            if (iVar.u0()) {
                J(iVar.e0());
            }
            if (iVar.t0()) {
                I(iVar.d0());
            }
            if (iVar.x0()) {
                F(iVar.h0());
            }
            if (iVar.y0()) {
                L(iVar.i0());
            }
            if (!iVar.f26128j.isEmpty()) {
                if (this.f26146j.isEmpty()) {
                    this.f26146j = iVar.f26128j;
                    this.f26140d &= -33;
                } else {
                    x();
                    this.f26146j.addAll(iVar.f26128j);
                }
            }
            if (iVar.v0()) {
                E(iVar.f0());
            }
            if (iVar.w0()) {
                K(iVar.g0());
            }
            if (!iVar.f26131m.isEmpty()) {
                if (this.f26149m.isEmpty()) {
                    this.f26149m = iVar.f26131m;
                    this.f26140d &= -257;
                } else {
                    w();
                    this.f26149m.addAll(iVar.f26131m);
                }
            }
            if (!iVar.f26132n.isEmpty()) {
                if (this.f26150n.isEmpty()) {
                    this.f26150n = iVar.f26132n;
                    this.f26140d &= -513;
                } else {
                    v();
                    this.f26150n.addAll(iVar.f26132n);
                }
            }
            if (!iVar.f26134p.isEmpty()) {
                if (this.f26151o.isEmpty()) {
                    this.f26151o = iVar.f26134p;
                    this.f26140d &= -1025;
                } else {
                    y();
                    this.f26151o.addAll(iVar.f26134p);
                }
            }
            if (iVar.z0()) {
                G(iVar.m0());
            }
            if (!iVar.f26136r.isEmpty()) {
                if (this.f26153q.isEmpty()) {
                    this.f26153q = iVar.f26136r;
                    this.f26140d &= -4097;
                } else {
                    z();
                    this.f26153q.addAll(iVar.f26136r);
                }
            }
            if (iVar.r0()) {
                B(iVar.Z());
            }
            o(iVar);
            k(i().c(iVar.f26121c));
            return this;
        }

        public b E(q qVar) {
            if ((this.f26140d & 64) != 64 || this.f26147k == q.X()) {
                this.f26147k = qVar;
            } else {
                this.f26147k = q.y0(this.f26147k).j(qVar).r();
            }
            this.f26140d |= 64;
            return this;
        }

        public b F(q qVar) {
            if ((this.f26140d & 8) != 8 || this.f26144h == q.X()) {
                this.f26144h = qVar;
            } else {
                this.f26144h = q.y0(this.f26144h).j(qVar).r();
            }
            this.f26140d |= 8;
            return this;
        }

        public b G(t tVar) {
            if ((this.f26140d & 2048) != 2048 || this.f26152p == t.w()) {
                this.f26152p = tVar;
            } else {
                this.f26152p = t.E(this.f26152p).j(tVar).n();
            }
            this.f26140d |= 2048;
            return this;
        }

        public b H(int i10) {
            this.f26140d |= 1;
            this.f26141e = i10;
            return this;
        }

        public b I(int i10) {
            this.f26140d |= 4;
            this.f26143g = i10;
            return this;
        }

        public b J(int i10) {
            this.f26140d |= 2;
            this.f26142f = i10;
            return this;
        }

        public b K(int i10) {
            this.f26140d |= 128;
            this.f26148l = i10;
            return this;
        }

        public b L(int i10) {
            this.f26140d |= 16;
            this.f26145i = i10;
            return this;
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public i build() {
            i iVarR = r();
            if (iVarR.d()) {
                return iVarR;
            }
            throw a.AbstractC0191a.h(iVarR);
        }

        public i r() {
            i iVar = new i(this);
            int i10 = this.f26140d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            iVar.f26123e = this.f26141e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            iVar.f26124f = this.f26142f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            iVar.f26125g = this.f26143g;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            iVar.f26126h = this.f26144h;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            iVar.f26127i = this.f26145i;
            if ((this.f26140d & 32) == 32) {
                this.f26146j = Collections.unmodifiableList(this.f26146j);
                this.f26140d &= -33;
            }
            iVar.f26128j = this.f26146j;
            if ((i10 & 64) == 64) {
                i11 |= 32;
            }
            iVar.f26129k = this.f26147k;
            if ((i10 & 128) == 128) {
                i11 |= 64;
            }
            iVar.f26130l = this.f26148l;
            if ((this.f26140d & 256) == 256) {
                this.f26149m = Collections.unmodifiableList(this.f26149m);
                this.f26140d &= -257;
            }
            iVar.f26131m = this.f26149m;
            if ((this.f26140d & 512) == 512) {
                this.f26150n = Collections.unmodifiableList(this.f26150n);
                this.f26140d &= -513;
            }
            iVar.f26132n = this.f26150n;
            if ((this.f26140d & 1024) == 1024) {
                this.f26151o = Collections.unmodifiableList(this.f26151o);
                this.f26140d &= -1025;
            }
            iVar.f26134p = this.f26151o;
            if ((i10 & 2048) == 2048) {
                i11 |= 128;
            }
            iVar.f26135q = this.f26152p;
            if ((this.f26140d & 4096) == 4096) {
                this.f26153q = Collections.unmodifiableList(this.f26153q);
                this.f26140d &= -4097;
            }
            iVar.f26136r = this.f26153q;
            if ((i10 & 8192) == 8192) {
                i11 |= 256;
            }
            iVar.f26137s = this.f26154r;
            iVar.f26122d = i11;
            return iVar;
        }

        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return t().j(r());
        }

        private void A() {
        }
    }
}
