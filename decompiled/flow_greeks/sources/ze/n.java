package ze;

import com.revenuecat.purchases.common.events.EventsManager;
import gf.a;
import gf.d;
import gf.i;
import io.flutter.Build;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ze.q;
import ze.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends i.d implements gf.q {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final n f26201v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static gf.r f26202w = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gf.d f26203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f26204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f26205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f26206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f26207g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q f26208h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f26209i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f26210j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public q f26211k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f26212l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f26213m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f26214n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f26215o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public u f26216p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f26217q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f26218r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List f26219s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public byte f26220t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f26221u;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public n c(gf.e eVar, gf.g gVar) {
            return new n(eVar, gVar);
        }
    }

    static {
        n nVar = new n(true);
        f26201v = nVar;
        nVar.y0();
    }

    public static b A0(n nVar) {
        return z0().j(nVar);
    }

    public static n Y() {
        return f26201v;
    }

    private void y0() {
        this.f26205e = 518;
        this.f26206f = 2054;
        this.f26207g = 0;
        this.f26208h = q.X();
        this.f26209i = 0;
        List list = Collections.EMPTY_LIST;
        this.f26210j = list;
        this.f26211k = q.X();
        this.f26212l = 0;
        this.f26213m = list;
        this.f26214n = list;
        this.f26216p = u.I();
        this.f26217q = 0;
        this.f26218r = 0;
        this.f26219s = list;
    }

    public static b z0() {
        return b.t();
    }

    @Override // gf.p
    /* JADX INFO: renamed from: B0, reason: merged with bridge method [inline-methods] */
    public b c() {
        return z0();
    }

    @Override // gf.p
    /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] */
    public b f() {
        return A0(this);
    }

    public q U(int i10) {
        return (q) this.f26213m.get(i10);
    }

    public int V() {
        return this.f26213m.size();
    }

    public List W() {
        return this.f26214n;
    }

    public List X() {
        return this.f26213m;
    }

    @Override // gf.q
    /* JADX INFO: renamed from: Z, reason: merged with bridge method [inline-methods] */
    public n a() {
        return f26201v;
    }

    public int a0() {
        return this.f26205e;
    }

    @Override // gf.p
    public int b() {
        int i10 = this.f26221u;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f26204d & 2) == 2 ? gf.f.o(1, this.f26206f) : 0;
        if ((this.f26204d & 4) == 4) {
            iO += gf.f.o(2, this.f26207g);
        }
        if ((this.f26204d & 8) == 8) {
            iO += gf.f.r(3, this.f26208h);
        }
        for (int i11 = 0; i11 < this.f26210j.size(); i11++) {
            iO += gf.f.r(4, (gf.p) this.f26210j.get(i11));
        }
        if ((this.f26204d & 32) == 32) {
            iO += gf.f.r(5, this.f26211k);
        }
        if ((this.f26204d & 128) == 128) {
            iO += gf.f.r(6, this.f26216p);
        }
        if ((this.f26204d & 256) == 256) {
            iO += gf.f.o(7, this.f26217q);
        }
        if ((this.f26204d & 512) == 512) {
            iO += gf.f.o(8, this.f26218r);
        }
        if ((this.f26204d & 16) == 16) {
            iO += gf.f.o(9, this.f26209i);
        }
        if ((this.f26204d & 64) == 64) {
            iO += gf.f.o(10, this.f26212l);
        }
        if ((this.f26204d & 1) == 1) {
            iO += gf.f.o(11, this.f26205e);
        }
        for (int i12 = 0; i12 < this.f26213m.size(); i12++) {
            iO += gf.f.r(12, (gf.p) this.f26213m.get(i12));
        }
        int iP = 0;
        for (int i13 = 0; i13 < this.f26214n.size(); i13++) {
            iP += gf.f.p(((Integer) this.f26214n.get(i13)).intValue());
        }
        int iP2 = iO + iP;
        if (!W().isEmpty()) {
            iP2 = iP2 + 1 + gf.f.p(iP);
        }
        this.f26215o = iP;
        int iP3 = 0;
        for (int i14 = 0; i14 < this.f26219s.size(); i14++) {
            iP3 += gf.f.p(((Integer) this.f26219s.get(i14)).intValue());
        }
        int size = iP2 + iP3 + (n0().size() * 2) + s() + this.f26203c.size();
        this.f26221u = size;
        return size;
    }

    public int b0() {
        return this.f26217q;
    }

    public int c0() {
        return this.f26207g;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f26220t;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!q0()) {
            this.f26220t = (byte) 0;
            return false;
        }
        if (u0() && !g0().d()) {
            this.f26220t = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < l0(); i10++) {
            if (!k0(i10).d()) {
                this.f26220t = (byte) 0;
                return false;
            }
        }
        if (s0() && !e0().d()) {
            this.f26220t = (byte) 0;
            return false;
        }
        for (int i11 = 0; i11 < V(); i11++) {
            if (!U(i11).d()) {
                this.f26220t = (byte) 0;
                return false;
            }
        }
        if (x0() && !j0().d()) {
            this.f26220t = (byte) 0;
            return false;
        }
        if (r()) {
            this.f26220t = (byte) 1;
            return true;
        }
        this.f26220t = (byte) 0;
        return false;
    }

    public int d0() {
        return this.f26206f;
    }

    public q e0() {
        return this.f26211k;
    }

    public int f0() {
        return this.f26212l;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        i.d.a aVarY = y();
        if ((this.f26204d & 2) == 2) {
            fVar.Z(1, this.f26206f);
        }
        if ((this.f26204d & 4) == 4) {
            fVar.Z(2, this.f26207g);
        }
        if ((this.f26204d & 8) == 8) {
            fVar.c0(3, this.f26208h);
        }
        for (int i10 = 0; i10 < this.f26210j.size(); i10++) {
            fVar.c0(4, (gf.p) this.f26210j.get(i10));
        }
        if ((this.f26204d & 32) == 32) {
            fVar.c0(5, this.f26211k);
        }
        if ((this.f26204d & 128) == 128) {
            fVar.c0(6, this.f26216p);
        }
        if ((this.f26204d & 256) == 256) {
            fVar.Z(7, this.f26217q);
        }
        if ((this.f26204d & 512) == 512) {
            fVar.Z(8, this.f26218r);
        }
        if ((this.f26204d & 16) == 16) {
            fVar.Z(9, this.f26209i);
        }
        if ((this.f26204d & 64) == 64) {
            fVar.Z(10, this.f26212l);
        }
        if ((this.f26204d & 1) == 1) {
            fVar.Z(11, this.f26205e);
        }
        for (int i11 = 0; i11 < this.f26213m.size(); i11++) {
            fVar.c0(12, (gf.p) this.f26213m.get(i11));
        }
        if (W().size() > 0) {
            fVar.n0(106);
            fVar.n0(this.f26215o);
        }
        for (int i12 = 0; i12 < this.f26214n.size(); i12++) {
            fVar.a0(((Integer) this.f26214n.get(i12)).intValue());
        }
        for (int i13 = 0; i13 < this.f26219s.size(); i13++) {
            fVar.Z(31, ((Integer) this.f26219s.get(i13)).intValue());
        }
        aVarY.a(19000, fVar);
        fVar.h0(this.f26203c);
    }

    public q g0() {
        return this.f26208h;
    }

    public int h0() {
        return this.f26209i;
    }

    public int i0() {
        return this.f26218r;
    }

    public u j0() {
        return this.f26216p;
    }

    public s k0(int i10) {
        return (s) this.f26210j.get(i10);
    }

    public int l0() {
        return this.f26210j.size();
    }

    public List m0() {
        return this.f26210j;
    }

    public List n0() {
        return this.f26219s;
    }

    public boolean o0() {
        return (this.f26204d & 1) == 1;
    }

    public boolean p0() {
        return (this.f26204d & 256) == 256;
    }

    public boolean q0() {
        return (this.f26204d & 4) == 4;
    }

    public boolean r0() {
        return (this.f26204d & 2) == 2;
    }

    public boolean s0() {
        return (this.f26204d & 32) == 32;
    }

    public boolean t0() {
        return (this.f26204d & 64) == 64;
    }

    public boolean u0() {
        return (this.f26204d & 8) == 8;
    }

    public boolean v0() {
        return (this.f26204d & 16) == 16;
    }

    public boolean w0() {
        return (this.f26204d & 512) == 512;
    }

    public boolean x0() {
        return (this.f26204d & 128) == 128;
    }

    public n(i.c cVar) {
        super(cVar);
        this.f26215o = -1;
        this.f26220t = (byte) -1;
        this.f26221u = -1;
        this.f26203c = cVar.i();
    }

    public n(boolean z10) {
        this.f26215o = -1;
        this.f26220t = (byte) -1;
        this.f26221u = -1;
        this.f26203c = gf.d.f10630a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public n(gf.e eVar, gf.g gVar) {
        this.f26215o = -1;
        this.f26220t = (byte) -1;
        this.f26221u = -1;
        y0();
        d.b bVarV = gf.d.v();
        gf.f fVarI = gf.f.I(bVarV, 1);
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            ?? O = 256;
            if (!z10) {
                try {
                    try {
                        try {
                            int iJ = eVar.J();
                            switch (iJ) {
                                case 0:
                                    z10 = true;
                                    break;
                                case 8:
                                    this.f26204d |= 2;
                                    this.f26206f = eVar.r();
                                    break;
                                case 16:
                                    this.f26204d |= 4;
                                    this.f26207g = eVar.r();
                                    break;
                                case Build.API_LEVELS.API_26 /* 26 */:
                                    q.c cVarA0 = (this.f26204d & 8) == 8 ? this.f26208h.f() : null;
                                    q qVar = (q) eVar.t(q.f26273v, gVar);
                                    this.f26208h = qVar;
                                    if (cVarA0 != null) {
                                        cVarA0.j(qVar);
                                        this.f26208h = cVarA0.r();
                                    }
                                    this.f26204d |= 8;
                                    break;
                                case Build.API_LEVELS.API_34 /* 34 */:
                                    int i11 = (i10 == true ? 1 : 0) & 32;
                                    i10 = i10;
                                    if (i11 != 32) {
                                        this.f26210j = new ArrayList();
                                        i10 = (i10 == true ? 1 : 0) | 32;
                                    }
                                    this.f26210j.add(eVar.t(s.f26353o, gVar));
                                    break;
                                case 42:
                                    q.c cVarA02 = (this.f26204d & 32) == 32 ? this.f26211k.f() : null;
                                    q qVar2 = (q) eVar.t(q.f26273v, gVar);
                                    this.f26211k = qVar2;
                                    if (cVarA02 != null) {
                                        cVarA02.j(qVar2);
                                        this.f26211k = cVarA02.r();
                                    }
                                    this.f26204d |= 32;
                                    break;
                                case EventsManager.EVENTS_TO_CLEAR_ON_LIMIT /* 50 */:
                                    u.b bVarA0 = (this.f26204d & 128) == 128 ? this.f26216p.f() : null;
                                    u uVar = (u) eVar.t(u.f26390n, gVar);
                                    this.f26216p = uVar;
                                    if (bVarA0 != null) {
                                        bVarA0.j(uVar);
                                        this.f26216p = bVarA0.r();
                                    }
                                    this.f26204d |= 128;
                                    break;
                                case 56:
                                    this.f26204d |= 256;
                                    this.f26217q = eVar.r();
                                    break;
                                case 64:
                                    this.f26204d |= 512;
                                    this.f26218r = eVar.r();
                                    break;
                                case 72:
                                    this.f26204d |= 16;
                                    this.f26209i = eVar.r();
                                    break;
                                case 80:
                                    this.f26204d |= 64;
                                    this.f26212l = eVar.r();
                                    break;
                                case 88:
                                    this.f26204d |= 1;
                                    this.f26205e = eVar.r();
                                    break;
                                case 98:
                                    int i12 = (i10 == true ? 1 : 0) & 256;
                                    i10 = i10;
                                    if (i12 != 256) {
                                        this.f26213m = new ArrayList();
                                        i10 = (i10 == true ? 1 : 0) | 256;
                                    }
                                    this.f26213m.add(eVar.t(q.f26273v, gVar));
                                    break;
                                case 104:
                                    int i13 = (i10 == true ? 1 : 0) & 512;
                                    i10 = i10;
                                    if (i13 != 512) {
                                        this.f26214n = new ArrayList();
                                        i10 = (i10 == true ? 1 : 0) | 512;
                                    }
                                    this.f26214n.add(Integer.valueOf(eVar.r()));
                                    break;
                                case 106:
                                    int i14 = eVar.i(eVar.z());
                                    int i15 = (i10 == true ? 1 : 0) & 512;
                                    i10 = i10;
                                    if (i15 != 512) {
                                        i10 = i10;
                                        if (eVar.e() > 0) {
                                            this.f26214n = new ArrayList();
                                            i10 = (i10 == true ? 1 : 0) | 512;
                                        }
                                    }
                                    while (eVar.e() > 0) {
                                        this.f26214n.add(Integer.valueOf(eVar.r()));
                                    }
                                    eVar.h(i14);
                                    break;
                                case 248:
                                    int i16 = (i10 == true ? 1 : 0) & 8192;
                                    i10 = i10;
                                    if (i16 != 8192) {
                                        this.f26219s = new ArrayList();
                                        i10 = (i10 == true ? 1 : 0) | 8192;
                                    }
                                    this.f26219s.add(Integer.valueOf(eVar.r()));
                                    break;
                                case 250:
                                    int i17 = eVar.i(eVar.z());
                                    int i18 = (i10 == true ? 1 : 0) & 8192;
                                    i10 = i10;
                                    if (i18 != 8192) {
                                        i10 = i10;
                                        if (eVar.e() > 0) {
                                            this.f26219s = new ArrayList();
                                            i10 = (i10 == true ? 1 : 0) | 8192;
                                        }
                                    }
                                    while (eVar.e() > 0) {
                                        this.f26219s.add(Integer.valueOf(eVar.r()));
                                    }
                                    eVar.h(i17);
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
                        }
                    } catch (IOException e11) {
                        throw new gf.k(e11.getMessage()).i(this);
                    }
                } catch (Throwable th) {
                    if (((i10 == true ? 1 : 0) & 32) == 32) {
                        this.f26210j = Collections.unmodifiableList(this.f26210j);
                    }
                    if (((i10 == true ? 1 : 0) & 256) == O) {
                        this.f26213m = Collections.unmodifiableList(this.f26213m);
                    }
                    if (((i10 == true ? 1 : 0) & 512) == 512) {
                        this.f26214n = Collections.unmodifiableList(this.f26214n);
                    }
                    if (((i10 == true ? 1 : 0) & 8192) == 8192) {
                        this.f26219s = Collections.unmodifiableList(this.f26219s);
                    }
                    try {
                        fVarI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f26203c = bVarV.u();
                        throw th2;
                    }
                    this.f26203c = bVarV.u();
                    l();
                    throw th;
                }
            } else {
                if (((i10 == true ? 1 : 0) & 32) == 32) {
                    this.f26210j = Collections.unmodifiableList(this.f26210j);
                }
                if (((i10 == true ? 1 : 0) & 256) == 256) {
                    this.f26213m = Collections.unmodifiableList(this.f26213m);
                }
                if (((i10 == true ? 1 : 0) & 512) == 512) {
                    this.f26214n = Collections.unmodifiableList(this.f26214n);
                }
                if (((i10 == true ? 1 : 0) & 8192) == 8192) {
                    this.f26219s = Collections.unmodifiableList(this.f26219s);
                }
                try {
                    fVarI.H();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.f26203c = bVarV.u();
                    throw th3;
                }
                this.f26203c = bVarV.u();
                l();
                return;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.c implements gf.q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26222d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f26225g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f26227i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List f26228j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public q f26229k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f26230l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public List f26231m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public List f26232n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public u f26233o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f26234p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f26235q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public List f26236r;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f26223e = 518;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f26224f = 2054;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public q f26226h = q.X();

        public b() {
            List list = Collections.EMPTY_LIST;
            this.f26228j = list;
            this.f26229k = q.X();
            this.f26231m = list;
            this.f26232n = list;
            this.f26233o = u.I();
            this.f26236r = list;
            z();
        }

        public static b t() {
            return new b();
        }

        private void v() {
            if ((this.f26222d & 512) != 512) {
                this.f26232n = new ArrayList(this.f26232n);
                this.f26222d |= 512;
            }
        }

        private void w() {
            if ((this.f26222d & 256) != 256) {
                this.f26231m = new ArrayList(this.f26231m);
                this.f26222d |= 256;
            }
        }

        private void x() {
            if ((this.f26222d & 32) != 32) {
                this.f26228j = new ArrayList(this.f26228j);
                this.f26222d |= 32;
            }
        }

        private void y() {
            if ((this.f26222d & 8192) != 8192) {
                this.f26236r = new ArrayList(this.f26236r);
                this.f26222d |= 8192;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.n.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.n.f26202w     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.n r3 = (ze.n) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.n r4 = (ze.n) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.n.b.u(gf.e, gf.g):ze.n$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public b j(n nVar) {
            if (nVar == n.Y()) {
                return this;
            }
            if (nVar.o0()) {
                F(nVar.a0());
            }
            if (nVar.r0()) {
                I(nVar.d0());
            }
            if (nVar.q0()) {
                H(nVar.c0());
            }
            if (nVar.u0()) {
                D(nVar.g0());
            }
            if (nVar.v0()) {
                K(nVar.h0());
            }
            if (!nVar.f26210j.isEmpty()) {
                if (this.f26228j.isEmpty()) {
                    this.f26228j = nVar.f26210j;
                    this.f26222d &= -33;
                } else {
                    x();
                    this.f26228j.addAll(nVar.f26210j);
                }
            }
            if (nVar.s0()) {
                C(nVar.e0());
            }
            if (nVar.t0()) {
                J(nVar.f0());
            }
            if (!nVar.f26213m.isEmpty()) {
                if (this.f26231m.isEmpty()) {
                    this.f26231m = nVar.f26213m;
                    this.f26222d &= -257;
                } else {
                    w();
                    this.f26231m.addAll(nVar.f26213m);
                }
            }
            if (!nVar.f26214n.isEmpty()) {
                if (this.f26232n.isEmpty()) {
                    this.f26232n = nVar.f26214n;
                    this.f26222d &= -513;
                } else {
                    v();
                    this.f26232n.addAll(nVar.f26214n);
                }
            }
            if (nVar.x0()) {
                E(nVar.j0());
            }
            if (nVar.p0()) {
                G(nVar.b0());
            }
            if (nVar.w0()) {
                L(nVar.i0());
            }
            if (!nVar.f26219s.isEmpty()) {
                if (this.f26236r.isEmpty()) {
                    this.f26236r = nVar.f26219s;
                    this.f26222d &= -8193;
                } else {
                    y();
                    this.f26236r.addAll(nVar.f26219s);
                }
            }
            o(nVar);
            k(i().c(nVar.f26203c));
            return this;
        }

        public b C(q qVar) {
            if ((this.f26222d & 64) != 64 || this.f26229k == q.X()) {
                this.f26229k = qVar;
            } else {
                this.f26229k = q.y0(this.f26229k).j(qVar).r();
            }
            this.f26222d |= 64;
            return this;
        }

        public b D(q qVar) {
            if ((this.f26222d & 8) != 8 || this.f26226h == q.X()) {
                this.f26226h = qVar;
            } else {
                this.f26226h = q.y0(this.f26226h).j(qVar).r();
            }
            this.f26222d |= 8;
            return this;
        }

        public b E(u uVar) {
            if ((this.f26222d & 1024) != 1024 || this.f26233o == u.I()) {
                this.f26233o = uVar;
            } else {
                this.f26233o = u.Y(this.f26233o).j(uVar).r();
            }
            this.f26222d |= 1024;
            return this;
        }

        public b F(int i10) {
            this.f26222d |= 1;
            this.f26223e = i10;
            return this;
        }

        public b G(int i10) {
            this.f26222d |= 2048;
            this.f26234p = i10;
            return this;
        }

        public b H(int i10) {
            this.f26222d |= 4;
            this.f26225g = i10;
            return this;
        }

        public b I(int i10) {
            this.f26222d |= 2;
            this.f26224f = i10;
            return this;
        }

        public b J(int i10) {
            this.f26222d |= 128;
            this.f26230l = i10;
            return this;
        }

        public b K(int i10) {
            this.f26222d |= 16;
            this.f26227i = i10;
            return this;
        }

        public b L(int i10) {
            this.f26222d |= 4096;
            this.f26235q = i10;
            return this;
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public n build() {
            n nVarR = r();
            if (nVarR.d()) {
                return nVarR;
            }
            throw a.AbstractC0191a.h(nVarR);
        }

        public n r() {
            n nVar = new n(this);
            int i10 = this.f26222d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            nVar.f26205e = this.f26223e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            nVar.f26206f = this.f26224f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            nVar.f26207g = this.f26225g;
            if ((i10 & 8) == 8) {
                i11 |= 8;
            }
            nVar.f26208h = this.f26226h;
            if ((i10 & 16) == 16) {
                i11 |= 16;
            }
            nVar.f26209i = this.f26227i;
            if ((this.f26222d & 32) == 32) {
                this.f26228j = Collections.unmodifiableList(this.f26228j);
                this.f26222d &= -33;
            }
            nVar.f26210j = this.f26228j;
            if ((i10 & 64) == 64) {
                i11 |= 32;
            }
            nVar.f26211k = this.f26229k;
            if ((i10 & 128) == 128) {
                i11 |= 64;
            }
            nVar.f26212l = this.f26230l;
            if ((this.f26222d & 256) == 256) {
                this.f26231m = Collections.unmodifiableList(this.f26231m);
                this.f26222d &= -257;
            }
            nVar.f26213m = this.f26231m;
            if ((this.f26222d & 512) == 512) {
                this.f26232n = Collections.unmodifiableList(this.f26232n);
                this.f26222d &= -513;
            }
            nVar.f26214n = this.f26232n;
            if ((i10 & 1024) == 1024) {
                i11 |= 128;
            }
            nVar.f26216p = this.f26233o;
            if ((i10 & 2048) == 2048) {
                i11 |= 256;
            }
            nVar.f26217q = this.f26234p;
            if ((i10 & 4096) == 4096) {
                i11 |= 512;
            }
            nVar.f26218r = this.f26235q;
            if ((this.f26222d & 8192) == 8192) {
                this.f26236r = Collections.unmodifiableList(this.f26236r);
                this.f26222d &= -8193;
            }
            nVar.f26219s = this.f26236r;
            nVar.f26204d = i11;
            return nVar;
        }

        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return t().j(r());
        }

        private void z() {
        }
    }
}
