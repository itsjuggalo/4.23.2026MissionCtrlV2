package ze;

import gf.a;
import gf.i;
import gf.j;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class c extends i.d implements gf.q {
    public static final c R;
    public static gf.r S = new a();
    public List A;
    public int B;
    public List C;
    public List D;
    public int E;
    public t F;
    public List G;
    public w H;
    public byte I;
    public int Q;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final gf.d f25978c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25979d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f25980e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f25981f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25982g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public List f25983h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List f25984i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f25985j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f25986k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public List f25987l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f25988m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f25989n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List f25990o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f25991p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public List f25992q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public List f25993r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List f25994s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public List f25995t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List f25996u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public List f25997v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f25998w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f25999x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public q f26000y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f26001z;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public c c(gf.e eVar, gf.g gVar) {
            return new c(eVar, gVar);
        }
    }

    /* JADX INFO: renamed from: ze.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum EnumC0494c implements j.a {
        CLASS(0, 0),
        INTERFACE(1, 1),
        ENUM_CLASS(2, 2),
        ENUM_ENTRY(3, 3),
        ANNOTATION_CLASS(4, 4),
        OBJECT(5, 5),
        COMPANION_OBJECT(6, 6);


        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static j.b f26032i = new a();

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f26034a;

        /* JADX INFO: renamed from: ze.c$c$a */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a implements j.b {
            @Override // gf.j.b
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public EnumC0494c a(int i10) {
                return EnumC0494c.a(i10);
            }
        }

        EnumC0494c(int i10, int i11) {
            this.f26034a = i11;
        }

        public static EnumC0494c a(int i10) {
            switch (i10) {
                case 0:
                    return CLASS;
                case 1:
                    return INTERFACE;
                case 2:
                    return ENUM_CLASS;
                case 3:
                    return ENUM_ENTRY;
                case 4:
                    return ANNOTATION_CLASS;
                case 5:
                    return OBJECT;
                case 6:
                    return COMPANION_OBJECT;
                default:
                    return null;
            }
        }

        @Override // gf.j.a
        public final int d() {
            return this.f26034a;
        }
    }

    static {
        c cVar = new c(true);
        R = cVar;
        cVar.s1();
    }

    private void s1() {
        this.f25980e = 6;
        this.f25981f = 0;
        this.f25982g = 0;
        List list = Collections.EMPTY_LIST;
        this.f25983h = list;
        this.f25984i = list;
        this.f25985j = list;
        this.f25987l = list;
        this.f25989n = list;
        this.f25990o = list;
        this.f25992q = list;
        this.f25993r = list;
        this.f25994s = list;
        this.f25995t = list;
        this.f25996u = list;
        this.f25997v = list;
        this.f25999x = 0;
        this.f26000y = q.X();
        this.f26001z = 0;
        this.A = list;
        this.C = list;
        this.D = list;
        this.F = t.w();
        this.G = list;
        this.H = w.t();
    }

    public static b t1() {
        return b.t();
    }

    public static b u1(c cVar) {
        return t1().j(cVar);
    }

    public static c w1(InputStream inputStream, gf.g gVar) {
        return (c) S.a(inputStream, gVar);
    }

    public static c y0() {
        return R;
    }

    public g A0(int i10) {
        return (g) this.f25996u.get(i10);
    }

    public int B0() {
        return this.f25996u.size();
    }

    public List C0() {
        return this.f25996u;
    }

    public int D0() {
        return this.f25980e;
    }

    public int E0() {
        return this.f25981f;
    }

    public i F0(int i10) {
        return (i) this.f25993r.get(i10);
    }

    public int G0() {
        return this.f25993r.size();
    }

    public List H0() {
        return this.f25993r;
    }

    public int I0() {
        return this.f25999x;
    }

    public q J0() {
        return this.f26000y;
    }

    public int K0() {
        return this.f26001z;
    }

    public int L0() {
        return this.A.size();
    }

    public List M0() {
        return this.A;
    }

    public q N0(int i10) {
        return (q) this.C.get(i10);
    }

    public int O0() {
        return this.C.size();
    }

    public int P0() {
        return this.D.size();
    }

    public List Q0() {
        return this.D;
    }

    public List R0() {
        return this.C;
    }

    public List S0() {
        return this.f25987l;
    }

    public n T0(int i10) {
        return (n) this.f25994s.get(i10);
    }

    public int U0() {
        return this.f25994s.size();
    }

    public List V0() {
        return this.f25994s;
    }

    public List W0() {
        return this.f25997v;
    }

    public q X0(int i10) {
        return (q) this.f25984i.get(i10);
    }

    public int Y0() {
        return this.f25984i.size();
    }

    public List Z0() {
        return this.f25985j;
    }

    public List a1() {
        return this.f25984i;
    }

    @Override // gf.p
    public int b() {
        int i10 = this.Q;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f25979d & 1) == 1 ? gf.f.o(1, this.f25980e) : 0;
        int iP = 0;
        for (int i11 = 0; i11 < this.f25985j.size(); i11++) {
            iP += gf.f.p(((Integer) this.f25985j.get(i11)).intValue());
        }
        int iR = iO + iP;
        if (!Z0().isEmpty()) {
            iR = iR + 1 + gf.f.p(iP);
        }
        this.f25986k = iP;
        if ((this.f25979d & 2) == 2) {
            iR += gf.f.o(3, this.f25981f);
        }
        if ((this.f25979d & 4) == 4) {
            iR += gf.f.o(4, this.f25982g);
        }
        for (int i12 = 0; i12 < this.f25983h.size(); i12++) {
            iR += gf.f.r(5, (gf.p) this.f25983h.get(i12));
        }
        for (int i13 = 0; i13 < this.f25984i.size(); i13++) {
            iR += gf.f.r(6, (gf.p) this.f25984i.get(i13));
        }
        int iP2 = 0;
        for (int i14 = 0; i14 < this.f25987l.size(); i14++) {
            iP2 += gf.f.p(((Integer) this.f25987l.get(i14)).intValue());
        }
        int iR2 = iR + iP2;
        if (!S0().isEmpty()) {
            iR2 = iR2 + 1 + gf.f.p(iP2);
        }
        this.f25988m = iP2;
        for (int i15 = 0; i15 < this.f25992q.size(); i15++) {
            iR2 += gf.f.r(8, (gf.p) this.f25992q.get(i15));
        }
        for (int i16 = 0; i16 < this.f25993r.size(); i16++) {
            iR2 += gf.f.r(9, (gf.p) this.f25993r.get(i16));
        }
        for (int i17 = 0; i17 < this.f25994s.size(); i17++) {
            iR2 += gf.f.r(10, (gf.p) this.f25994s.get(i17));
        }
        for (int i18 = 0; i18 < this.f25995t.size(); i18++) {
            iR2 += gf.f.r(11, (gf.p) this.f25995t.get(i18));
        }
        for (int i19 = 0; i19 < this.f25996u.size(); i19++) {
            iR2 += gf.f.r(13, (gf.p) this.f25996u.get(i19));
        }
        int iP3 = 0;
        for (int i20 = 0; i20 < this.f25997v.size(); i20++) {
            iP3 += gf.f.p(((Integer) this.f25997v.get(i20)).intValue());
        }
        int iR3 = iR2 + iP3;
        if (!W0().isEmpty()) {
            iR3 = iR3 + 2 + gf.f.p(iP3);
        }
        this.f25998w = iP3;
        if ((this.f25979d & 8) == 8) {
            iR3 += gf.f.o(17, this.f25999x);
        }
        if ((this.f25979d & 16) == 16) {
            iR3 += gf.f.r(18, this.f26000y);
        }
        if ((this.f25979d & 32) == 32) {
            iR3 += gf.f.o(19, this.f26001z);
        }
        for (int i21 = 0; i21 < this.f25989n.size(); i21++) {
            iR3 += gf.f.r(20, (gf.p) this.f25989n.get(i21));
        }
        int iP4 = 0;
        for (int i22 = 0; i22 < this.f25990o.size(); i22++) {
            iP4 += gf.f.p(((Integer) this.f25990o.get(i22)).intValue());
        }
        int iP5 = iR3 + iP4;
        if (!w0().isEmpty()) {
            iP5 = iP5 + 2 + gf.f.p(iP4);
        }
        this.f25991p = iP4;
        int iP6 = 0;
        for (int i23 = 0; i23 < this.A.size(); i23++) {
            iP6 += gf.f.p(((Integer) this.A.get(i23)).intValue());
        }
        int iR4 = iP5 + iP6;
        if (!M0().isEmpty()) {
            iR4 = iR4 + 2 + gf.f.p(iP6);
        }
        this.B = iP6;
        for (int i24 = 0; i24 < this.C.size(); i24++) {
            iR4 += gf.f.r(23, (gf.p) this.C.get(i24));
        }
        int iP7 = 0;
        for (int i25 = 0; i25 < this.D.size(); i25++) {
            iP7 += gf.f.p(((Integer) this.D.get(i25)).intValue());
        }
        int iR5 = iR4 + iP7;
        if (!Q0().isEmpty()) {
            iR5 = iR5 + 2 + gf.f.p(iP7);
        }
        this.E = iP7;
        if ((this.f25979d & 64) == 64) {
            iR5 += gf.f.r(30, this.F);
        }
        int iP8 = 0;
        for (int i26 = 0; i26 < this.G.size(); i26++) {
            iP8 += gf.f.p(((Integer) this.G.get(i26)).intValue());
        }
        int size = iR5 + iP8 + (i1().size() * 2);
        if ((this.f25979d & 128) == 128) {
            size += gf.f.r(32, this.H);
        }
        int iS = size + s() + this.f25978c.size();
        this.Q = iS;
        return iS;
    }

    public r b1(int i10) {
        return (r) this.f25995t.get(i10);
    }

    public int c1() {
        return this.f25995t.size();
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.I;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!m1()) {
            this.I = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < f1(); i10++) {
            if (!e1(i10).d()) {
                this.I = (byte) 0;
                return false;
            }
        }
        for (int i11 = 0; i11 < Y0(); i11++) {
            if (!X0(i11).d()) {
                this.I = (byte) 0;
                return false;
            }
        }
        for (int i12 = 0; i12 < v0(); i12++) {
            if (!u0(i12).d()) {
                this.I = (byte) 0;
                return false;
            }
        }
        for (int i13 = 0; i13 < s0(); i13++) {
            if (!r0(i13).d()) {
                this.I = (byte) 0;
                return false;
            }
        }
        for (int i14 = 0; i14 < G0(); i14++) {
            if (!F0(i14).d()) {
                this.I = (byte) 0;
                return false;
            }
        }
        for (int i15 = 0; i15 < U0(); i15++) {
            if (!T0(i15).d()) {
                this.I = (byte) 0;
                return false;
            }
        }
        for (int i16 = 0; i16 < c1(); i16++) {
            if (!b1(i16).d()) {
                this.I = (byte) 0;
                return false;
            }
        }
        for (int i17 = 0; i17 < B0(); i17++) {
            if (!A0(i17).d()) {
                this.I = (byte) 0;
                return false;
            }
        }
        if (o1() && !J0().d()) {
            this.I = (byte) 0;
            return false;
        }
        for (int i18 = 0; i18 < O0(); i18++) {
            if (!N0(i18).d()) {
                this.I = (byte) 0;
                return false;
            }
        }
        if (q1() && !h1().d()) {
            this.I = (byte) 0;
            return false;
        }
        if (r()) {
            this.I = (byte) 1;
            return true;
        }
        this.I = (byte) 0;
        return false;
    }

    public List d1() {
        return this.f25995t;
    }

    public s e1(int i10) {
        return (s) this.f25983h.get(i10);
    }

    public int f1() {
        return this.f25983h.size();
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        i.d.a aVarY = y();
        if ((this.f25979d & 1) == 1) {
            fVar.Z(1, this.f25980e);
        }
        if (Z0().size() > 0) {
            fVar.n0(18);
            fVar.n0(this.f25986k);
        }
        for (int i10 = 0; i10 < this.f25985j.size(); i10++) {
            fVar.a0(((Integer) this.f25985j.get(i10)).intValue());
        }
        if ((this.f25979d & 2) == 2) {
            fVar.Z(3, this.f25981f);
        }
        if ((this.f25979d & 4) == 4) {
            fVar.Z(4, this.f25982g);
        }
        for (int i11 = 0; i11 < this.f25983h.size(); i11++) {
            fVar.c0(5, (gf.p) this.f25983h.get(i11));
        }
        for (int i12 = 0; i12 < this.f25984i.size(); i12++) {
            fVar.c0(6, (gf.p) this.f25984i.get(i12));
        }
        if (S0().size() > 0) {
            fVar.n0(58);
            fVar.n0(this.f25988m);
        }
        for (int i13 = 0; i13 < this.f25987l.size(); i13++) {
            fVar.a0(((Integer) this.f25987l.get(i13)).intValue());
        }
        for (int i14 = 0; i14 < this.f25992q.size(); i14++) {
            fVar.c0(8, (gf.p) this.f25992q.get(i14));
        }
        for (int i15 = 0; i15 < this.f25993r.size(); i15++) {
            fVar.c0(9, (gf.p) this.f25993r.get(i15));
        }
        for (int i16 = 0; i16 < this.f25994s.size(); i16++) {
            fVar.c0(10, (gf.p) this.f25994s.get(i16));
        }
        for (int i17 = 0; i17 < this.f25995t.size(); i17++) {
            fVar.c0(11, (gf.p) this.f25995t.get(i17));
        }
        for (int i18 = 0; i18 < this.f25996u.size(); i18++) {
            fVar.c0(13, (gf.p) this.f25996u.get(i18));
        }
        if (W0().size() > 0) {
            fVar.n0(130);
            fVar.n0(this.f25998w);
        }
        for (int i19 = 0; i19 < this.f25997v.size(); i19++) {
            fVar.a0(((Integer) this.f25997v.get(i19)).intValue());
        }
        if ((this.f25979d & 8) == 8) {
            fVar.Z(17, this.f25999x);
        }
        if ((this.f25979d & 16) == 16) {
            fVar.c0(18, this.f26000y);
        }
        if ((this.f25979d & 32) == 32) {
            fVar.Z(19, this.f26001z);
        }
        for (int i20 = 0; i20 < this.f25989n.size(); i20++) {
            fVar.c0(20, (gf.p) this.f25989n.get(i20));
        }
        if (w0().size() > 0) {
            fVar.n0(170);
            fVar.n0(this.f25991p);
        }
        for (int i21 = 0; i21 < this.f25990o.size(); i21++) {
            fVar.a0(((Integer) this.f25990o.get(i21)).intValue());
        }
        if (M0().size() > 0) {
            fVar.n0(178);
            fVar.n0(this.B);
        }
        for (int i22 = 0; i22 < this.A.size(); i22++) {
            fVar.a0(((Integer) this.A.get(i22)).intValue());
        }
        for (int i23 = 0; i23 < this.C.size(); i23++) {
            fVar.c0(23, (gf.p) this.C.get(i23));
        }
        if (Q0().size() > 0) {
            fVar.n0(194);
            fVar.n0(this.E);
        }
        for (int i24 = 0; i24 < this.D.size(); i24++) {
            fVar.a0(((Integer) this.D.get(i24)).intValue());
        }
        if ((this.f25979d & 64) == 64) {
            fVar.c0(30, this.F);
        }
        for (int i25 = 0; i25 < this.G.size(); i25++) {
            fVar.Z(31, ((Integer) this.G.get(i25)).intValue());
        }
        if ((this.f25979d & 128) == 128) {
            fVar.c0(32, this.H);
        }
        aVarY.a(19000, fVar);
        fVar.h0(this.f25978c);
    }

    public List g1() {
        return this.f25983h;
    }

    public t h1() {
        return this.F;
    }

    public List i1() {
        return this.G;
    }

    public w j1() {
        return this.H;
    }

    public boolean k1() {
        return (this.f25979d & 4) == 4;
    }

    public boolean l1() {
        return (this.f25979d & 1) == 1;
    }

    public boolean m1() {
        return (this.f25979d & 2) == 2;
    }

    public boolean n1() {
        return (this.f25979d & 8) == 8;
    }

    public boolean o1() {
        return (this.f25979d & 16) == 16;
    }

    public boolean p1() {
        return (this.f25979d & 32) == 32;
    }

    public int q0() {
        return this.f25982g;
    }

    public boolean q1() {
        return (this.f25979d & 64) == 64;
    }

    public d r0(int i10) {
        return (d) this.f25992q.get(i10);
    }

    public boolean r1() {
        return (this.f25979d & 128) == 128;
    }

    public int s0() {
        return this.f25992q.size();
    }

    public List t0() {
        return this.f25992q;
    }

    public q u0(int i10) {
        return (q) this.f25989n.get(i10);
    }

    public int v0() {
        return this.f25989n.size();
    }

    @Override // gf.p
    /* JADX INFO: renamed from: v1, reason: merged with bridge method [inline-methods] */
    public b c() {
        return t1();
    }

    public List w0() {
        return this.f25990o;
    }

    public List x0() {
        return this.f25989n;
    }

    @Override // gf.p
    /* JADX INFO: renamed from: x1, reason: merged with bridge method [inline-methods] */
    public b f() {
        return u1(this);
    }

    @Override // gf.q
    /* JADX INFO: renamed from: z0, reason: merged with bridge method [inline-methods] */
    public c a() {
        return R;
    }

    public c(i.c cVar) {
        super(cVar);
        this.f25986k = -1;
        this.f25988m = -1;
        this.f25991p = -1;
        this.f25998w = -1;
        this.B = -1;
        this.E = -1;
        this.I = (byte) -1;
        this.Q = -1;
        this.f25978c = cVar.i();
    }

    public c(boolean z10) {
        this.f25986k = -1;
        this.f25988m = -1;
        this.f25991p = -1;
        this.f25998w = -1;
        this.B = -1;
        this.E = -1;
        this.I = (byte) -1;
        this.Q = -1;
        this.f25978c = gf.d.f10630a;
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i.c implements gf.q {
        public List A;
        public w B;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f26002d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f26003e = 6;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f26004f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f26005g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public List f26006h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public List f26007i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List f26008j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public List f26009k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public List f26010l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public List f26011m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public List f26012n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public List f26013o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public List f26014p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public List f26015q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public List f26016r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        public List f26017s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        public int f26018t;

        /* JADX INFO: renamed from: u, reason: collision with root package name */
        public q f26019u;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        public int f26020v;

        /* JADX INFO: renamed from: w, reason: collision with root package name */
        public List f26021w;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        public List f26022x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        public List f26023y;

        /* JADX INFO: renamed from: z, reason: collision with root package name */
        public t f26024z;

        public b() {
            List list = Collections.EMPTY_LIST;
            this.f26006h = list;
            this.f26007i = list;
            this.f26008j = list;
            this.f26009k = list;
            this.f26010l = list;
            this.f26011m = list;
            this.f26012n = list;
            this.f26013o = list;
            this.f26014p = list;
            this.f26015q = list;
            this.f26016r = list;
            this.f26017s = list;
            this.f26019u = q.X();
            this.f26021w = list;
            this.f26022x = list;
            this.f26023y = list;
            this.f26024z = t.w();
            this.A = list;
            this.B = w.t();
            L();
        }

        public static b t() {
            return new b();
        }

        public final void A() {
            if ((this.f26002d & 262144) != 262144) {
                this.f26021w = new ArrayList(this.f26021w);
                this.f26002d |= 262144;
            }
        }

        public final void B() {
            if ((this.f26002d & 1048576) != 1048576) {
                this.f26023y = new ArrayList(this.f26023y);
                this.f26002d |= 1048576;
            }
        }

        public final void C() {
            if ((this.f26002d & 524288) != 524288) {
                this.f26022x = new ArrayList(this.f26022x);
                this.f26002d |= 524288;
            }
        }

        public final void D() {
            if ((this.f26002d & 64) != 64) {
                this.f26009k = new ArrayList(this.f26009k);
                this.f26002d |= 64;
            }
        }

        public final void E() {
            if ((this.f26002d & 2048) != 2048) {
                this.f26014p = new ArrayList(this.f26014p);
                this.f26002d |= 2048;
            }
        }

        public final void F() {
            if ((this.f26002d & 16384) != 16384) {
                this.f26017s = new ArrayList(this.f26017s);
                this.f26002d |= 16384;
            }
        }

        public final void G() {
            if ((this.f26002d & 32) != 32) {
                this.f26008j = new ArrayList(this.f26008j);
                this.f26002d |= 32;
            }
        }

        public final void H() {
            if ((this.f26002d & 16) != 16) {
                this.f26007i = new ArrayList(this.f26007i);
                this.f26002d |= 16;
            }
        }

        public final void I() {
            if ((this.f26002d & 4096) != 4096) {
                this.f26015q = new ArrayList(this.f26015q);
                this.f26002d |= 4096;
            }
        }

        public final void J() {
            if ((this.f26002d & 8) != 8) {
                this.f26006h = new ArrayList(this.f26006h);
                this.f26002d |= 8;
            }
        }

        public final void K() {
            if ((this.f26002d & 4194304) != 4194304) {
                this.A = new ArrayList(this.A);
                this.f26002d |= 4194304;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.c.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.c.S     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.c r3 = (ze.c) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.c r4 = (ze.c) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.c.b.u(gf.e, gf.g):ze.c$b");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
        public b j(c cVar) {
            if (cVar == c.y0()) {
                return this;
            }
            if (cVar.l1()) {
                S(cVar.D0());
            }
            if (cVar.m1()) {
                T(cVar.E0());
            }
            if (cVar.k1()) {
                R(cVar.q0());
            }
            if (!cVar.f25983h.isEmpty()) {
                if (this.f26006h.isEmpty()) {
                    this.f26006h = cVar.f25983h;
                    this.f26002d &= -9;
                } else {
                    J();
                    this.f26006h.addAll(cVar.f25983h);
                }
            }
            if (!cVar.f25984i.isEmpty()) {
                if (this.f26007i.isEmpty()) {
                    this.f26007i = cVar.f25984i;
                    this.f26002d &= -17;
                } else {
                    H();
                    this.f26007i.addAll(cVar.f25984i);
                }
            }
            if (!cVar.f25985j.isEmpty()) {
                if (this.f26008j.isEmpty()) {
                    this.f26008j = cVar.f25985j;
                    this.f26002d &= -33;
                } else {
                    G();
                    this.f26008j.addAll(cVar.f25985j);
                }
            }
            if (!cVar.f25987l.isEmpty()) {
                if (this.f26009k.isEmpty()) {
                    this.f26009k = cVar.f25987l;
                    this.f26002d &= -65;
                } else {
                    D();
                    this.f26009k.addAll(cVar.f25987l);
                }
            }
            if (!cVar.f25989n.isEmpty()) {
                if (this.f26010l.isEmpty()) {
                    this.f26010l = cVar.f25989n;
                    this.f26002d &= -129;
                } else {
                    x();
                    this.f26010l.addAll(cVar.f25989n);
                }
            }
            if (!cVar.f25990o.isEmpty()) {
                if (this.f26011m.isEmpty()) {
                    this.f26011m = cVar.f25990o;
                    this.f26002d &= -257;
                } else {
                    w();
                    this.f26011m.addAll(cVar.f25990o);
                }
            }
            if (!cVar.f25992q.isEmpty()) {
                if (this.f26012n.isEmpty()) {
                    this.f26012n = cVar.f25992q;
                    this.f26002d &= -513;
                } else {
                    v();
                    this.f26012n.addAll(cVar.f25992q);
                }
            }
            if (!cVar.f25993r.isEmpty()) {
                if (this.f26013o.isEmpty()) {
                    this.f26013o = cVar.f25993r;
                    this.f26002d &= -1025;
                } else {
                    z();
                    this.f26013o.addAll(cVar.f25993r);
                }
            }
            if (!cVar.f25994s.isEmpty()) {
                if (this.f26014p.isEmpty()) {
                    this.f26014p = cVar.f25994s;
                    this.f26002d &= -2049;
                } else {
                    E();
                    this.f26014p.addAll(cVar.f25994s);
                }
            }
            if (!cVar.f25995t.isEmpty()) {
                if (this.f26015q.isEmpty()) {
                    this.f26015q = cVar.f25995t;
                    this.f26002d &= -4097;
                } else {
                    I();
                    this.f26015q.addAll(cVar.f25995t);
                }
            }
            if (!cVar.f25996u.isEmpty()) {
                if (this.f26016r.isEmpty()) {
                    this.f26016r = cVar.f25996u;
                    this.f26002d &= -8193;
                } else {
                    y();
                    this.f26016r.addAll(cVar.f25996u);
                }
            }
            if (!cVar.f25997v.isEmpty()) {
                if (this.f26017s.isEmpty()) {
                    this.f26017s = cVar.f25997v;
                    this.f26002d &= -16385;
                } else {
                    F();
                    this.f26017s.addAll(cVar.f25997v);
                }
            }
            if (cVar.n1()) {
                U(cVar.I0());
            }
            if (cVar.o1()) {
                O(cVar.J0());
            }
            if (cVar.p1()) {
                V(cVar.K0());
            }
            if (!cVar.A.isEmpty()) {
                if (this.f26021w.isEmpty()) {
                    this.f26021w = cVar.A;
                    this.f26002d &= -262145;
                } else {
                    A();
                    this.f26021w.addAll(cVar.A);
                }
            }
            if (!cVar.C.isEmpty()) {
                if (this.f26022x.isEmpty()) {
                    this.f26022x = cVar.C;
                    this.f26002d &= -524289;
                } else {
                    C();
                    this.f26022x.addAll(cVar.C);
                }
            }
            if (!cVar.D.isEmpty()) {
                if (this.f26023y.isEmpty()) {
                    this.f26023y = cVar.D;
                    this.f26002d &= -1048577;
                } else {
                    B();
                    this.f26023y.addAll(cVar.D);
                }
            }
            if (cVar.q1()) {
                P(cVar.h1());
            }
            if (!cVar.G.isEmpty()) {
                if (this.A.isEmpty()) {
                    this.A = cVar.G;
                    this.f26002d &= -4194305;
                } else {
                    K();
                    this.A.addAll(cVar.G);
                }
            }
            if (cVar.r1()) {
                Q(cVar.j1());
            }
            o(cVar);
            k(i().c(cVar.f25978c));
            return this;
        }

        public b O(q qVar) {
            if ((this.f26002d & 65536) != 65536 || this.f26019u == q.X()) {
                this.f26019u = qVar;
            } else {
                this.f26019u = q.y0(this.f26019u).j(qVar).r();
            }
            this.f26002d |= 65536;
            return this;
        }

        public b P(t tVar) {
            if ((this.f26002d & 2097152) != 2097152 || this.f26024z == t.w()) {
                this.f26024z = tVar;
            } else {
                this.f26024z = t.E(this.f26024z).j(tVar).n();
            }
            this.f26002d |= 2097152;
            return this;
        }

        public b Q(w wVar) {
            if ((this.f26002d & 8388608) != 8388608 || this.B == w.t()) {
                this.B = wVar;
            } else {
                this.B = w.z(this.B).j(wVar).n();
            }
            this.f26002d |= 8388608;
            return this;
        }

        public b R(int i10) {
            this.f26002d |= 4;
            this.f26005g = i10;
            return this;
        }

        public b S(int i10) {
            this.f26002d |= 1;
            this.f26003e = i10;
            return this;
        }

        public b T(int i10) {
            this.f26002d |= 2;
            this.f26004f = i10;
            return this;
        }

        public b U(int i10) {
            this.f26002d |= 32768;
            this.f26018t = i10;
            return this;
        }

        public b V(int i10) {
            this.f26002d |= 131072;
            this.f26020v = i10;
            return this;
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public c build() {
            c cVarR = r();
            if (cVarR.d()) {
                return cVarR;
            }
            throw a.AbstractC0191a.h(cVarR);
        }

        public c r() {
            c cVar = new c(this);
            int i10 = this.f26002d;
            int i11 = (i10 & 1) != 1 ? 0 : 1;
            cVar.f25980e = this.f26003e;
            if ((i10 & 2) == 2) {
                i11 |= 2;
            }
            cVar.f25981f = this.f26004f;
            if ((i10 & 4) == 4) {
                i11 |= 4;
            }
            cVar.f25982g = this.f26005g;
            if ((this.f26002d & 8) == 8) {
                this.f26006h = Collections.unmodifiableList(this.f26006h);
                this.f26002d &= -9;
            }
            cVar.f25983h = this.f26006h;
            if ((this.f26002d & 16) == 16) {
                this.f26007i = Collections.unmodifiableList(this.f26007i);
                this.f26002d &= -17;
            }
            cVar.f25984i = this.f26007i;
            if ((this.f26002d & 32) == 32) {
                this.f26008j = Collections.unmodifiableList(this.f26008j);
                this.f26002d &= -33;
            }
            cVar.f25985j = this.f26008j;
            if ((this.f26002d & 64) == 64) {
                this.f26009k = Collections.unmodifiableList(this.f26009k);
                this.f26002d &= -65;
            }
            cVar.f25987l = this.f26009k;
            if ((this.f26002d & 128) == 128) {
                this.f26010l = Collections.unmodifiableList(this.f26010l);
                this.f26002d &= -129;
            }
            cVar.f25989n = this.f26010l;
            if ((this.f26002d & 256) == 256) {
                this.f26011m = Collections.unmodifiableList(this.f26011m);
                this.f26002d &= -257;
            }
            cVar.f25990o = this.f26011m;
            if ((this.f26002d & 512) == 512) {
                this.f26012n = Collections.unmodifiableList(this.f26012n);
                this.f26002d &= -513;
            }
            cVar.f25992q = this.f26012n;
            if ((this.f26002d & 1024) == 1024) {
                this.f26013o = Collections.unmodifiableList(this.f26013o);
                this.f26002d &= -1025;
            }
            cVar.f25993r = this.f26013o;
            if ((this.f26002d & 2048) == 2048) {
                this.f26014p = Collections.unmodifiableList(this.f26014p);
                this.f26002d &= -2049;
            }
            cVar.f25994s = this.f26014p;
            if ((this.f26002d & 4096) == 4096) {
                this.f26015q = Collections.unmodifiableList(this.f26015q);
                this.f26002d &= -4097;
            }
            cVar.f25995t = this.f26015q;
            if ((this.f26002d & 8192) == 8192) {
                this.f26016r = Collections.unmodifiableList(this.f26016r);
                this.f26002d &= -8193;
            }
            cVar.f25996u = this.f26016r;
            if ((this.f26002d & 16384) == 16384) {
                this.f26017s = Collections.unmodifiableList(this.f26017s);
                this.f26002d &= -16385;
            }
            cVar.f25997v = this.f26017s;
            if ((i10 & 32768) == 32768) {
                i11 |= 8;
            }
            cVar.f25999x = this.f26018t;
            if ((i10 & 65536) == 65536) {
                i11 |= 16;
            }
            cVar.f26000y = this.f26019u;
            if ((i10 & 131072) == 131072) {
                i11 |= 32;
            }
            cVar.f26001z = this.f26020v;
            if ((this.f26002d & 262144) == 262144) {
                this.f26021w = Collections.unmodifiableList(this.f26021w);
                this.f26002d &= -262145;
            }
            cVar.A = this.f26021w;
            if ((this.f26002d & 524288) == 524288) {
                this.f26022x = Collections.unmodifiableList(this.f26022x);
                this.f26002d &= -524289;
            }
            cVar.C = this.f26022x;
            if ((this.f26002d & 1048576) == 1048576) {
                this.f26023y = Collections.unmodifiableList(this.f26023y);
                this.f26002d &= -1048577;
            }
            cVar.D = this.f26023y;
            if ((i10 & 2097152) == 2097152) {
                i11 |= 64;
            }
            cVar.F = this.f26024z;
            if ((this.f26002d & 4194304) == 4194304) {
                this.A = Collections.unmodifiableList(this.A);
                this.f26002d &= -4194305;
            }
            cVar.G = this.A;
            if ((i10 & 8388608) == 8388608) {
                i11 |= 128;
            }
            cVar.H = this.B;
            cVar.f25979d = i11;
            return cVar;
        }

        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return t().j(r());
        }

        public final void v() {
            if ((this.f26002d & 512) != 512) {
                this.f26012n = new ArrayList(this.f26012n);
                this.f26002d |= 512;
            }
        }

        public final void w() {
            if ((this.f26002d & 256) != 256) {
                this.f26011m = new ArrayList(this.f26011m);
                this.f26002d |= 256;
            }
        }

        public final void x() {
            if ((this.f26002d & 128) != 128) {
                this.f26010l = new ArrayList(this.f26010l);
                this.f26002d |= 128;
            }
        }

        public final void y() {
            if ((this.f26002d & 8192) != 8192) {
                this.f26016r = new ArrayList(this.f26016r);
                this.f26002d |= 8192;
            }
        }

        public final void z() {
            if ((this.f26002d & 1024) != 1024) {
                this.f26013o = new ArrayList(this.f26013o);
                this.f26002d |= 1024;
            }
        }

        private void L() {
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:9:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public c(gf.e r22, gf.g r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1760
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ze.c.<init>(gf.e, gf.g):void");
    }
}
