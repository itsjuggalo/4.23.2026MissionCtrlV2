package l6;

import io.flutter.Build;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l6.q;
import l6.u;
import s6.AbstractC2714a;
import s6.AbstractC2715b;
import s6.AbstractC2717d;
import s6.AbstractC2722i;
import s6.C2718e;
import s6.C2719f;
import s6.C2720g;
import s6.C2724k;

/* JADX INFO: loaded from: classes2.dex */
public final class n extends AbstractC2722i.d implements s6.q {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final n f20921v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static s6.r f20922w = new a();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC2717d f20923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f20926f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20927g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q f20928h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f20929i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List f20930j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public q f20931k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f20932l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public List f20933m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public List f20934n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f20935o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public u f20936p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f20937q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public int f20938r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public List f20939s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public byte f20940t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f20941u;

    public static class a extends AbstractC2715b {
        @Override // s6.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public n b(C2718e c2718e, C2720g c2720g) {
            return new n(c2718e, c2720g);
        }
    }

    static {
        n nVar = new n(true);
        f20921v = nVar;
        nVar.z0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
    public n(C2718e c2718e, C2720g c2720g) {
        int i8;
        int i9;
        List list;
        int i10;
        Object objT;
        this.f20935o = -1;
        this.f20940t = (byte) -1;
        this.f20941u = -1;
        z0();
        AbstractC2717d.b bVarK = AbstractC2717d.K();
        C2719f c2719fI = C2719f.I(bVarK, 1);
        boolean z7 = false;
        int i11 = 0;
        while (true) {
            ?? Q7 = 256;
            if (z7) {
                if (((i11 == true ? 1 : 0) & 32) == 32) {
                    this.f20930j = Collections.unmodifiableList(this.f20930j);
                }
                if (((i11 == true ? 1 : 0) & 256) == 256) {
                    this.f20933m = Collections.unmodifiableList(this.f20933m);
                }
                if (((i11 == true ? 1 : 0) & 512) == 512) {
                    this.f20934n = Collections.unmodifiableList(this.f20934n);
                }
                if (((i11 == true ? 1 : 0) & 8192) == 8192) {
                    this.f20939s = Collections.unmodifiableList(this.f20939s);
                }
                try {
                    c2719fI.H();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    this.f20923c = bVarK.n();
                    throw th;
                }
                this.f20923c = bVarK.n();
                m();
                return;
            }
            try {
                try {
                    try {
                        int iJ = c2718e.J();
                        switch (iJ) {
                            case 0:
                                z7 = true;
                                break;
                            case 8:
                                this.f20924d |= 2;
                                this.f20926f = c2718e.r();
                                break;
                            case com.amazon.c.a.a.c.f14230g /* 16 */:
                                this.f20924d |= 4;
                                this.f20927g = c2718e.r();
                                break;
                            case Build.API_LEVELS.API_26 /* 26 */:
                                i8 = 8;
                                q.c cVarB0 = (this.f20924d & 8) == 8 ? this.f20928h.g() : null;
                                q qVar = (q) c2718e.t(q.f20993v, c2720g);
                                this.f20928h = qVar;
                                if (cVarB0 != null) {
                                    cVarB0.k(qVar);
                                    this.f20928h = cVarB0.t();
                                }
                                i9 = this.f20924d;
                                this.f20924d = i9 | i8;
                                break;
                            case Build.API_LEVELS.API_34 /* 34 */:
                                int i12 = (i11 == true ? 1 : 0) & 32;
                                int i13 = i11;
                                if (i12 != 32) {
                                    this.f20930j = new ArrayList();
                                    i13 = (i11 == true ? 1 : 0) | 32;
                                }
                                list = this.f20930j;
                                i11 = i13;
                                objT = c2718e.t(s.f21073o, c2720g);
                                list.add(objT);
                                break;
                            case 42:
                                q.c cVarB02 = (this.f20924d & 32) == 32 ? this.f20931k.g() : null;
                                q qVar2 = (q) c2718e.t(q.f20993v, c2720g);
                                this.f20931k = qVar2;
                                if (cVarB02 != null) {
                                    cVarB02.k(qVar2);
                                    this.f20931k = cVarB02.t();
                                }
                                this.f20924d |= 32;
                                break;
                            case 50:
                                i8 = 128;
                                u.b bVarB0 = (this.f20924d & 128) == 128 ? this.f20936p.g() : null;
                                u uVar = (u) c2718e.t(u.f21110n, c2720g);
                                this.f20936p = uVar;
                                if (bVarB0 != null) {
                                    bVarB0.k(uVar);
                                    this.f20936p = bVarB0.t();
                                }
                                i9 = this.f20924d;
                                this.f20924d = i9 | i8;
                                break;
                            case 56:
                                this.f20924d |= 256;
                                this.f20937q = c2718e.r();
                                break;
                            case 64:
                                this.f20924d |= 512;
                                this.f20938r = c2718e.r();
                                break;
                            case 72:
                                this.f20924d |= 16;
                                this.f20929i = c2718e.r();
                                break;
                            case 80:
                                this.f20924d |= 64;
                                this.f20932l = c2718e.r();
                                break;
                            case 88:
                                this.f20924d |= 1;
                                this.f20925e = c2718e.r();
                                break;
                            case 98:
                                int i14 = (i11 == true ? 1 : 0) & 256;
                                int i15 = i11;
                                if (i14 != 256) {
                                    this.f20933m = new ArrayList();
                                    i15 = (i11 == true ? 1 : 0) | 256;
                                }
                                list = this.f20933m;
                                i11 = i15;
                                objT = c2718e.t(q.f20993v, c2720g);
                                list.add(objT);
                                break;
                            case 104:
                                int i16 = (i11 == true ? 1 : 0) & 512;
                                int i17 = i11;
                                if (i16 != 512) {
                                    this.f20934n = new ArrayList();
                                    i17 = (i11 == true ? 1 : 0) | 512;
                                }
                                list = this.f20934n;
                                i11 = i17;
                                objT = Integer.valueOf(c2718e.r());
                                list.add(objT);
                                break;
                            case 106:
                                i10 = c2718e.i(c2718e.z());
                                int i18 = (i11 == true ? 1 : 0) & 512;
                                i11 = i11;
                                if (i18 != 512) {
                                    i11 = i11;
                                    if (c2718e.e() > 0) {
                                        this.f20934n = new ArrayList();
                                        i11 = (i11 == true ? 1 : 0) | 512;
                                    }
                                }
                                while (c2718e.e() > 0) {
                                    this.f20934n.add(Integer.valueOf(c2718e.r()));
                                }
                                c2718e.h(i10);
                                break;
                            case 248:
                                int i19 = (i11 == true ? 1 : 0) & 8192;
                                int i20 = i11;
                                if (i19 != 8192) {
                                    this.f20939s = new ArrayList();
                                    i20 = (i11 == true ? 1 : 0) | 8192;
                                }
                                list = this.f20939s;
                                i11 = i20;
                                objT = Integer.valueOf(c2718e.r());
                                list.add(objT);
                                break;
                            case 250:
                                i10 = c2718e.i(c2718e.z());
                                int i21 = (i11 == true ? 1 : 0) & 8192;
                                i11 = i11;
                                if (i21 != 8192) {
                                    i11 = i11;
                                    if (c2718e.e() > 0) {
                                        this.f20939s = new ArrayList();
                                        i11 = (i11 == true ? 1 : 0) | 8192;
                                    }
                                }
                                while (c2718e.e() > 0) {
                                    this.f20939s.add(Integer.valueOf(c2718e.r()));
                                }
                                c2718e.h(i10);
                                break;
                            default:
                                Q7 = q(c2718e, c2719fI, c2720g, iJ);
                                if (Q7 == 0) {
                                    z7 = true;
                                }
                                break;
                        }
                    } catch (IOException e8) {
                        throw new C2724k(e8.getMessage()).i(this);
                    }
                } catch (C2724k e9) {
                    throw e9.i(this);
                }
            } catch (Throwable th2) {
                if (((i11 == true ? 1 : 0) & 32) == 32) {
                    this.f20930j = Collections.unmodifiableList(this.f20930j);
                }
                if (((i11 == true ? 1 : 0) & 256) == Q7) {
                    this.f20933m = Collections.unmodifiableList(this.f20933m);
                }
                if (((i11 == true ? 1 : 0) & 512) == 512) {
                    this.f20934n = Collections.unmodifiableList(this.f20934n);
                }
                if (((i11 == true ? 1 : 0) & 8192) == 8192) {
                    this.f20939s = Collections.unmodifiableList(this.f20939s);
                }
                try {
                    c2719fI.H();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.f20923c = bVarK.n();
                    throw th3;
                }
                this.f20923c = bVarK.n();
                m();
                throw th2;
            }
        }
    }

    public static b A0() {
        return b.v();
    }

    public static b B0(n nVar) {
        return A0().k(nVar);
    }

    public static n Z() {
        return f20921v;
    }

    private void z0() {
        this.f20925e = 518;
        this.f20926f = 2054;
        this.f20927g = 0;
        this.f20928h = q.Y();
        this.f20929i = 0;
        this.f20930j = Collections.emptyList();
        this.f20931k = q.Y();
        this.f20932l = 0;
        this.f20933m = Collections.emptyList();
        this.f20934n = Collections.emptyList();
        this.f20936p = u.J();
        this.f20937q = 0;
        this.f20938r = 0;
        this.f20939s = Collections.emptyList();
    }

    @Override // s6.p
    /* JADX INFO: renamed from: C0, reason: merged with bridge method [inline-methods] */
    public b d() {
        return A0();
    }

    @Override // s6.p
    /* JADX INFO: renamed from: D0, reason: merged with bridge method [inline-methods] */
    public b g() {
        return B0(this);
    }

    public q V(int i8) {
        return (q) this.f20933m.get(i8);
    }

    public int W() {
        return this.f20933m.size();
    }

    public List X() {
        return this.f20934n;
    }

    public List Y() {
        return this.f20933m;
    }

    @Override // s6.q
    /* JADX INFO: renamed from: a0, reason: merged with bridge method [inline-methods] */
    public n b() {
        return f20921v;
    }

    public int b0() {
        return this.f20925e;
    }

    @Override // s6.p
    public int c() {
        int i8 = this.f20941u;
        if (i8 != -1) {
            return i8;
        }
        int iO = (this.f20924d & 2) == 2 ? C2719f.o(1, this.f20926f) : 0;
        if ((this.f20924d & 4) == 4) {
            iO += C2719f.o(2, this.f20927g);
        }
        if ((this.f20924d & 8) == 8) {
            iO += C2719f.r(3, this.f20928h);
        }
        for (int i9 = 0; i9 < this.f20930j.size(); i9++) {
            iO += C2719f.r(4, (s6.p) this.f20930j.get(i9));
        }
        if ((this.f20924d & 32) == 32) {
            iO += C2719f.r(5, this.f20931k);
        }
        if ((this.f20924d & 128) == 128) {
            iO += C2719f.r(6, this.f20936p);
        }
        if ((this.f20924d & 256) == 256) {
            iO += C2719f.o(7, this.f20937q);
        }
        if ((this.f20924d & 512) == 512) {
            iO += C2719f.o(8, this.f20938r);
        }
        if ((this.f20924d & 16) == 16) {
            iO += C2719f.o(9, this.f20929i);
        }
        if ((this.f20924d & 64) == 64) {
            iO += C2719f.o(10, this.f20932l);
        }
        if ((this.f20924d & 1) == 1) {
            iO += C2719f.o(11, this.f20925e);
        }
        for (int i10 = 0; i10 < this.f20933m.size(); i10++) {
            iO += C2719f.r(12, (s6.p) this.f20933m.get(i10));
        }
        int iP = 0;
        for (int i11 = 0; i11 < this.f20934n.size(); i11++) {
            iP += C2719f.p(((Integer) this.f20934n.get(i11)).intValue());
        }
        int iP2 = iO + iP;
        if (!X().isEmpty()) {
            iP2 = iP2 + 1 + C2719f.p(iP);
        }
        this.f20935o = iP;
        int iP3 = 0;
        for (int i12 = 0; i12 < this.f20939s.size(); i12++) {
            iP3 += C2719f.p(((Integer) this.f20939s.get(i12)).intValue());
        }
        int size = iP2 + iP3 + (o0().size() * 2) + u() + this.f20923c.size();
        this.f20941u = size;
        return size;
    }

    public int c0() {
        return this.f20937q;
    }

    public int d0() {
        return this.f20927g;
    }

    @Override // s6.q
    public final boolean e() {
        byte b8 = this.f20940t;
        if (b8 == 1) {
            return true;
        }
        if (b8 == 0) {
            return false;
        }
        if (!r0()) {
            this.f20940t = (byte) 0;
            return false;
        }
        if (v0() && !h0().e()) {
            this.f20940t = (byte) 0;
            return false;
        }
        for (int i8 = 0; i8 < m0(); i8++) {
            if (!l0(i8).e()) {
                this.f20940t = (byte) 0;
                return false;
            }
        }
        if (t0() && !f0().e()) {
            this.f20940t = (byte) 0;
            return false;
        }
        for (int i9 = 0; i9 < W(); i9++) {
            if (!V(i9).e()) {
                this.f20940t = (byte) 0;
                return false;
            }
        }
        if (y0() && !k0().e()) {
            this.f20940t = (byte) 0;
            return false;
        }
        if (t()) {
            this.f20940t = (byte) 1;
            return true;
        }
        this.f20940t = (byte) 0;
        return false;
    }

    public int e0() {
        return this.f20926f;
    }

    public q f0() {
        return this.f20931k;
    }

    public int g0() {
        return this.f20932l;
    }

    @Override // s6.p
    public void h(C2719f c2719f) throws IOException {
        c();
        AbstractC2722i.d.a aVarZ = z();
        if ((this.f20924d & 2) == 2) {
            c2719f.Z(1, this.f20926f);
        }
        if ((this.f20924d & 4) == 4) {
            c2719f.Z(2, this.f20927g);
        }
        if ((this.f20924d & 8) == 8) {
            c2719f.c0(3, this.f20928h);
        }
        for (int i8 = 0; i8 < this.f20930j.size(); i8++) {
            c2719f.c0(4, (s6.p) this.f20930j.get(i8));
        }
        if ((this.f20924d & 32) == 32) {
            c2719f.c0(5, this.f20931k);
        }
        if ((this.f20924d & 128) == 128) {
            c2719f.c0(6, this.f20936p);
        }
        if ((this.f20924d & 256) == 256) {
            c2719f.Z(7, this.f20937q);
        }
        if ((this.f20924d & 512) == 512) {
            c2719f.Z(8, this.f20938r);
        }
        if ((this.f20924d & 16) == 16) {
            c2719f.Z(9, this.f20929i);
        }
        if ((this.f20924d & 64) == 64) {
            c2719f.Z(10, this.f20932l);
        }
        if ((this.f20924d & 1) == 1) {
            c2719f.Z(11, this.f20925e);
        }
        for (int i9 = 0; i9 < this.f20933m.size(); i9++) {
            c2719f.c0(12, (s6.p) this.f20933m.get(i9));
        }
        if (X().size() > 0) {
            c2719f.n0(106);
            c2719f.n0(this.f20935o);
        }
        for (int i10 = 0; i10 < this.f20934n.size(); i10++) {
            c2719f.a0(((Integer) this.f20934n.get(i10)).intValue());
        }
        for (int i11 = 0; i11 < this.f20939s.size(); i11++) {
            c2719f.Z(31, ((Integer) this.f20939s.get(i11)).intValue());
        }
        aVarZ.a(19000, c2719f);
        c2719f.h0(this.f20923c);
    }

    public q h0() {
        return this.f20928h;
    }

    public int i0() {
        return this.f20929i;
    }

    public int j0() {
        return this.f20938r;
    }

    public u k0() {
        return this.f20936p;
    }

    public s l0(int i8) {
        return (s) this.f20930j.get(i8);
    }

    public int m0() {
        return this.f20930j.size();
    }

    public List n0() {
        return this.f20930j;
    }

    public List o0() {
        return this.f20939s;
    }

    public boolean p0() {
        return (this.f20924d & 1) == 1;
    }

    public boolean q0() {
        return (this.f20924d & 256) == 256;
    }

    public boolean r0() {
        return (this.f20924d & 4) == 4;
    }

    public boolean s0() {
        return (this.f20924d & 2) == 2;
    }

    public boolean t0() {
        return (this.f20924d & 32) == 32;
    }

    public boolean u0() {
        return (this.f20924d & 64) == 64;
    }

    public boolean v0() {
        return (this.f20924d & 8) == 8;
    }

    public boolean w0() {
        return (this.f20924d & 16) == 16;
    }

    public boolean x0() {
        return (this.f20924d & 512) == 512;
    }

    public boolean y0() {
        return (this.f20924d & 128) == 128;
    }

    public n(AbstractC2722i.c cVar) {
        super(cVar);
        this.f20935o = -1;
        this.f20940t = (byte) -1;
        this.f20941u = -1;
        this.f20923c = cVar.j();
    }

    public n(boolean z7) {
        this.f20935o = -1;
        this.f20940t = (byte) -1;
        this.f20941u = -1;
        this.f20923c = AbstractC2717d.f23128a;
    }

    public static final class b extends AbstractC2722i.c implements s6.q {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f20942d;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f20945g;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public int f20947i;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public int f20950l;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        public int f20954p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        public int f20955q;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f20943e = 518;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f20944f = 2054;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public q f20946h = q.Y();

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public List f20948j = Collections.emptyList();

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public q f20949k = q.Y();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public List f20951m = Collections.emptyList();

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public List f20952n = Collections.emptyList();

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public u f20953o = u.J();

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        public List f20956r = Collections.emptyList();

        public b() {
            A();
        }

        public static b v() {
            return new b();
        }

        private void w() {
            if ((this.f20942d & 512) != 512) {
                this.f20952n = new ArrayList(this.f20952n);
                this.f20942d |= 512;
            }
        }

        private void x() {
            if ((this.f20942d & 256) != 256) {
                this.f20951m = new ArrayList(this.f20951m);
                this.f20942d |= 256;
            }
        }

        private void y() {
            if ((this.f20942d & 32) != 32) {
                this.f20948j = new ArrayList(this.f20948j);
                this.f20942d |= 32;
            }
        }

        private void z() {
            if ((this.f20942d & 8192) != 8192) {
                this.f20956r = new ArrayList(this.f20956r);
                this.f20942d |= 8192;
            }
        }

        @Override // s6.AbstractC2722i.b
        /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
        public b k(n nVar) {
            if (nVar == n.Z()) {
                return this;
            }
            if (nVar.p0()) {
                G(nVar.b0());
            }
            if (nVar.s0()) {
                J(nVar.e0());
            }
            if (nVar.r0()) {
                I(nVar.d0());
            }
            if (nVar.v0()) {
                E(nVar.h0());
            }
            if (nVar.w0()) {
                L(nVar.i0());
            }
            if (!nVar.f20930j.isEmpty()) {
                if (this.f20948j.isEmpty()) {
                    this.f20948j = nVar.f20930j;
                    this.f20942d &= -33;
                } else {
                    y();
                    this.f20948j.addAll(nVar.f20930j);
                }
            }
            if (nVar.t0()) {
                D(nVar.f0());
            }
            if (nVar.u0()) {
                K(nVar.g0());
            }
            if (!nVar.f20933m.isEmpty()) {
                if (this.f20951m.isEmpty()) {
                    this.f20951m = nVar.f20933m;
                    this.f20942d &= -257;
                } else {
                    x();
                    this.f20951m.addAll(nVar.f20933m);
                }
            }
            if (!nVar.f20934n.isEmpty()) {
                if (this.f20952n.isEmpty()) {
                    this.f20952n = nVar.f20934n;
                    this.f20942d &= -513;
                } else {
                    w();
                    this.f20952n.addAll(nVar.f20934n);
                }
            }
            if (nVar.y0()) {
                F(nVar.k0());
            }
            if (nVar.q0()) {
                H(nVar.c0());
            }
            if (nVar.x0()) {
                M(nVar.j0());
            }
            if (!nVar.f20939s.isEmpty()) {
                if (this.f20956r.isEmpty()) {
                    this.f20956r = nVar.f20939s;
                    this.f20942d &= -8193;
                } else {
                    z();
                    this.f20956r.addAll(nVar.f20939s);
                }
            }
            q(nVar);
            l(j().d(nVar.f20923c));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // s6.p.a
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public l6.n.b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                s6.r r1 = l6.n.f20922w     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                l6.n r3 = (l6.n) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                if (r3 == 0) goto Le
                r2.k(r3)
            Le:
                return r2
            Lf:
                r3 = move-exception
                goto L1b
            L11:
                r3 = move-exception
                s6.p r4 = r3.a()     // Catch: java.lang.Throwable -> Lf
                l6.n r4 = (l6.n) r4     // Catch: java.lang.Throwable -> Lf
                throw r3     // Catch: java.lang.Throwable -> L19
            L19:
                r3 = move-exception
                r0 = r4
            L1b:
                if (r0 == 0) goto L20
                r2.k(r0)
            L20:
                throw r3
            */
            throw new UnsupportedOperationException("Method not decompiled: l6.n.b.n(s6.e, s6.g):l6.n$b");
        }

        public b D(q qVar) {
            if ((this.f20942d & 64) == 64 && this.f20949k != q.Y()) {
                qVar = q.z0(this.f20949k).k(qVar).t();
            }
            this.f20949k = qVar;
            this.f20942d |= 64;
            return this;
        }

        public b E(q qVar) {
            if ((this.f20942d & 8) == 8 && this.f20946h != q.Y()) {
                qVar = q.z0(this.f20946h).k(qVar).t();
            }
            this.f20946h = qVar;
            this.f20942d |= 8;
            return this;
        }

        public b F(u uVar) {
            if ((this.f20942d & 1024) == 1024 && this.f20953o != u.J()) {
                uVar = u.Z(this.f20953o).k(uVar).t();
            }
            this.f20953o = uVar;
            this.f20942d |= 1024;
            return this;
        }

        public b G(int i8) {
            this.f20942d |= 1;
            this.f20943e = i8;
            return this;
        }

        public b H(int i8) {
            this.f20942d |= 2048;
            this.f20954p = i8;
            return this;
        }

        public b I(int i8) {
            this.f20942d |= 4;
            this.f20945g = i8;
            return this;
        }

        public b J(int i8) {
            this.f20942d |= 2;
            this.f20944f = i8;
            return this;
        }

        public b K(int i8) {
            this.f20942d |= 128;
            this.f20950l = i8;
            return this;
        }

        public b L(int i8) {
            this.f20942d |= 16;
            this.f20947i = i8;
            return this;
        }

        public b M(int i8) {
            this.f20942d |= 4096;
            this.f20955q = i8;
            return this;
        }

        @Override // s6.p.a
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        public n a() {
            n nVarT = t();
            if (nVarT.e()) {
                return nVarT;
            }
            throw AbstractC2714a.AbstractC0396a.i(nVarT);
        }

        public n t() {
            n nVar = new n(this);
            int i8 = this.f20942d;
            int i9 = (i8 & 1) != 1 ? 0 : 1;
            nVar.f20925e = this.f20943e;
            if ((i8 & 2) == 2) {
                i9 |= 2;
            }
            nVar.f20926f = this.f20944f;
            if ((i8 & 4) == 4) {
                i9 |= 4;
            }
            nVar.f20927g = this.f20945g;
            if ((i8 & 8) == 8) {
                i9 |= 8;
            }
            nVar.f20928h = this.f20946h;
            if ((i8 & 16) == 16) {
                i9 |= 16;
            }
            nVar.f20929i = this.f20947i;
            if ((this.f20942d & 32) == 32) {
                this.f20948j = Collections.unmodifiableList(this.f20948j);
                this.f20942d &= -33;
            }
            nVar.f20930j = this.f20948j;
            if ((i8 & 64) == 64) {
                i9 |= 32;
            }
            nVar.f20931k = this.f20949k;
            if ((i8 & 128) == 128) {
                i9 |= 64;
            }
            nVar.f20932l = this.f20950l;
            if ((this.f20942d & 256) == 256) {
                this.f20951m = Collections.unmodifiableList(this.f20951m);
                this.f20942d &= -257;
            }
            nVar.f20933m = this.f20951m;
            if ((this.f20942d & 512) == 512) {
                this.f20952n = Collections.unmodifiableList(this.f20952n);
                this.f20942d &= -513;
            }
            nVar.f20934n = this.f20952n;
            if ((i8 & 1024) == 1024) {
                i9 |= 128;
            }
            nVar.f20936p = this.f20953o;
            if ((i8 & 2048) == 2048) {
                i9 |= 256;
            }
            nVar.f20937q = this.f20954p;
            if ((i8 & 4096) == 4096) {
                i9 |= 512;
            }
            nVar.f20938r = this.f20955q;
            if ((this.f20942d & 8192) == 8192) {
                this.f20956r = Collections.unmodifiableList(this.f20956r);
                this.f20942d &= -8193;
            }
            nVar.f20939s = this.f20956r;
            nVar.f20924d = i9;
            return nVar;
        }

        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return v().k(t());
        }

        private void A() {
        }
    }
}
