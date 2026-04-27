package l6;

import io.flutter.Build;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import s6.AbstractC2714a;
import s6.AbstractC2715b;
import s6.AbstractC2717d;
import s6.AbstractC2722i;
import s6.AbstractC2723j;
import s6.C2718e;
import s6.C2719f;
import s6.C2720g;
import s6.C2724k;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends AbstractC2722i implements s6.q {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f20617h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static s6.r f20618i = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2717d f20619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f20620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f20621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f20622e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte f20623f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f20624g;

    public static class a extends AbstractC2715b {
        @Override // s6.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public b b(C2718e c2718e, C2720g c2720g) {
            return new b(c2718e, c2720g);
        }
    }

    /* JADX INFO: renamed from: l6.b$b, reason: collision with other inner class name */
    public static final class C0348b extends AbstractC2722i implements s6.q {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final C0348b f20625h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static s6.r f20626i = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC2717d f20627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f20628c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f20629d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f20630e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte f20631f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f20632g;

        /* JADX INFO: renamed from: l6.b$b$a */
        public static class a extends AbstractC2715b {
            @Override // s6.r
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public C0348b b(C2718e c2718e, C2720g c2720g) {
                return new C0348b(c2718e, c2720g);
            }
        }

        static {
            C0348b c0348b = new C0348b(true);
            f20625h = c0348b;
            c0348b.B();
        }

        public C0348b(C2718e c2718e, C2720g c2720g) {
            this.f20631f = (byte) -1;
            this.f20632g = -1;
            B();
            AbstractC2717d.b bVarK = AbstractC2717d.K();
            C2719f c2719fI = C2719f.I(bVarK, 1);
            boolean z7 = false;
            while (!z7) {
                try {
                    try {
                        int iJ = c2718e.J();
                        if (iJ != 0) {
                            if (iJ == 8) {
                                this.f20628c |= 1;
                                this.f20629d = c2718e.r();
                            } else if (iJ == 18) {
                                c.C0350b c0350bG = (this.f20628c & 2) == 2 ? this.f20630e.g() : null;
                                c cVar = (c) c2718e.t(c.f20637r, c2720g);
                                this.f20630e = cVar;
                                if (c0350bG != null) {
                                    c0350bG.k(cVar);
                                    this.f20630e = c0350bG.p();
                                }
                                this.f20628c |= 2;
                            } else if (!q(c2718e, c2719fI, c2720g, iJ)) {
                            }
                        }
                        z7 = true;
                    } catch (Throwable th) {
                        try {
                            c2719fI.H();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f20627b = bVarK.n();
                            throw th2;
                        }
                        this.f20627b = bVarK.n();
                        m();
                        throw th;
                    }
                } catch (C2724k e8) {
                    throw e8.i(this);
                } catch (IOException e9) {
                    throw new C2724k(e9.getMessage()).i(this);
                }
            }
            try {
                c2719fI.H();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f20627b = bVarK.n();
                throw th3;
            }
            this.f20627b = bVarK.n();
            m();
        }

        private void B() {
            this.f20629d = 0;
            this.f20630e = c.M();
        }

        public static C0349b C() {
            return C0349b.r();
        }

        public static C0349b D(C0348b c0348b) {
            return C().k(c0348b);
        }

        public static C0348b w() {
            return f20625h;
        }

        public boolean A() {
            return (this.f20628c & 2) == 2;
        }

        @Override // s6.p
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public C0349b d() {
            return C();
        }

        @Override // s6.p
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public C0349b g() {
            return D(this);
        }

        @Override // s6.p
        public int c() {
            int i8 = this.f20632g;
            if (i8 != -1) {
                return i8;
            }
            int iO = (this.f20628c & 1) == 1 ? C2719f.o(1, this.f20629d) : 0;
            if ((this.f20628c & 2) == 2) {
                iO += C2719f.r(2, this.f20630e);
            }
            int size = iO + this.f20627b.size();
            this.f20632g = size;
            return size;
        }

        @Override // s6.q
        public final boolean e() {
            byte b8 = this.f20631f;
            if (b8 == 1) {
                return true;
            }
            if (b8 == 0) {
                return false;
            }
            if (!z()) {
                this.f20631f = (byte) 0;
                return false;
            }
            if (!A()) {
                this.f20631f = (byte) 0;
                return false;
            }
            if (y().e()) {
                this.f20631f = (byte) 1;
                return true;
            }
            this.f20631f = (byte) 0;
            return false;
        }

        @Override // s6.p
        public void h(C2719f c2719f) throws IOException {
            c();
            if ((this.f20628c & 1) == 1) {
                c2719f.Z(1, this.f20629d);
            }
            if ((this.f20628c & 2) == 2) {
                c2719f.c0(2, this.f20630e);
            }
            c2719f.h0(this.f20627b);
        }

        public int x() {
            return this.f20629d;
        }

        public c y() {
            return this.f20630e;
        }

        public boolean z() {
            return (this.f20628c & 1) == 1;
        }

        /* JADX INFO: renamed from: l6.b$b$c */
        public static final class c extends AbstractC2722i implements s6.q {

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public static final c f20636q;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            public static s6.r f20637r = new a();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AbstractC2717d f20638b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f20639c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public EnumC0351c f20640d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public long f20641e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public float f20642f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public double f20643g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public int f20644h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public int f20645i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f20646j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public b f20647k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public List f20648l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public int f20649m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public int f20650n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public byte f20651o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public int f20652p;

            /* JADX INFO: renamed from: l6.b$b$c$a */
            public static class a extends AbstractC2715b {
                @Override // s6.r
                /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
                public c b(C2718e c2718e, C2720g c2720g) {
                    return new c(c2718e, c2720g);
                }
            }

            /* JADX INFO: renamed from: l6.b$b$c$c, reason: collision with other inner class name */
            public enum EnumC0351c implements AbstractC2723j.a {
                BYTE(0, 0),
                CHAR(1, 1),
                SHORT(2, 2),
                INT(3, 3),
                LONG(4, 4),
                FLOAT(5, 5),
                DOUBLE(6, 6),
                BOOLEAN(7, 7),
                STRING(8, 8),
                CLASS(9, 9),
                ENUM(10, 10),
                ANNOTATION(11, 11),
                ARRAY(12, 12);


                /* JADX INFO: renamed from: o, reason: collision with root package name */
                public static AbstractC2723j.b f20678o = new a();

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final int f20680a;

                /* JADX INFO: renamed from: l6.b$b$c$c$a */
                public static class a implements AbstractC2723j.b {
                    @Override // s6.AbstractC2723j.b
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public EnumC0351c a(int i8) {
                        return EnumC0351c.a(i8);
                    }
                }

                EnumC0351c(int i8, int i9) {
                    this.f20680a = i9;
                }

                public static EnumC0351c a(int i8) {
                    switch (i8) {
                        case 0:
                            return BYTE;
                        case 1:
                            return CHAR;
                        case 2:
                            return SHORT;
                        case 3:
                            return INT;
                        case 4:
                            return LONG;
                        case 5:
                            return FLOAT;
                        case 6:
                            return DOUBLE;
                        case 7:
                            return BOOLEAN;
                        case 8:
                            return STRING;
                        case 9:
                            return CLASS;
                        case 10:
                            return ENUM;
                        case D3.m.TTL_EXPIRY_EVENT_TO_LOG_FIELD_NUMBER /* 11 */:
                            return ANNOTATION;
                        case 12:
                            return ARRAY;
                        default:
                            return null;
                    }
                }

                @Override // s6.AbstractC2723j.a
                public final int d() {
                    return this.f20680a;
                }
            }

            static {
                c cVar = new c(true);
                f20636q = cVar;
                cVar.e0();
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v0 */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
            public c(C2718e c2718e, C2720g c2720g) {
                this.f20651o = (byte) -1;
                this.f20652p = -1;
                e0();
                AbstractC2717d.b bVarK = AbstractC2717d.K();
                C2719f c2719fI = C2719f.I(bVarK, 1);
                boolean z7 = false;
                char c8 = 0;
                while (true) {
                    ?? Q7 = 256;
                    if (z7) {
                        if ((c8 & 256) == 256) {
                            this.f20648l = Collections.unmodifiableList(this.f20648l);
                        }
                        try {
                            c2719fI.H();
                        } catch (IOException unused) {
                        } catch (Throwable th) {
                            this.f20638b = bVarK.n();
                            throw th;
                        }
                        this.f20638b = bVarK.n();
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
                                        int iM = c2718e.m();
                                        EnumC0351c enumC0351cA = EnumC0351c.a(iM);
                                        if (enumC0351cA == null) {
                                            c2719fI.n0(iJ);
                                            c2719fI.n0(iM);
                                        } else {
                                            this.f20639c |= 1;
                                            this.f20640d = enumC0351cA;
                                        }
                                        break;
                                    case com.amazon.c.a.a.c.f14230g /* 16 */:
                                        this.f20639c |= 2;
                                        this.f20641e = c2718e.G();
                                        break;
                                    case Build.API_LEVELS.API_29 /* 29 */:
                                        this.f20639c |= 4;
                                        this.f20642f = c2718e.p();
                                        break;
                                    case Build.API_LEVELS.API_33 /* 33 */:
                                        this.f20639c |= 8;
                                        this.f20643g = c2718e.l();
                                        break;
                                    case 40:
                                        this.f20639c |= 16;
                                        this.f20644h = c2718e.r();
                                        break;
                                    case 48:
                                        this.f20639c |= 32;
                                        this.f20645i = c2718e.r();
                                        break;
                                    case 56:
                                        this.f20639c |= 64;
                                        this.f20646j = c2718e.r();
                                        break;
                                    case 66:
                                        c cVarG = (this.f20639c & 128) == 128 ? this.f20647k.g() : null;
                                        b bVar = (b) c2718e.t(b.f20618i, c2720g);
                                        this.f20647k = bVar;
                                        if (cVarG != null) {
                                            cVarG.k(bVar);
                                            this.f20647k = cVarG.p();
                                        }
                                        this.f20639c |= 128;
                                        break;
                                    case 74:
                                        if ((c8 & 256) != 256) {
                                            this.f20648l = new ArrayList();
                                            c8 = 256;
                                        }
                                        this.f20648l.add(c2718e.t(f20637r, c2720g));
                                        break;
                                    case 80:
                                        this.f20639c |= 512;
                                        this.f20650n = c2718e.r();
                                        break;
                                    case 88:
                                        this.f20639c |= 256;
                                        this.f20649m = c2718e.r();
                                        break;
                                    default:
                                        Q7 = q(c2718e, c2719fI, c2720g, iJ);
                                        if (Q7 == 0) {
                                            z7 = true;
                                        }
                                        break;
                                }
                            } catch (C2724k e8) {
                                throw e8.i(this);
                            }
                        } catch (IOException e9) {
                            throw new C2724k(e9.getMessage()).i(this);
                        }
                    } catch (Throwable th2) {
                        if ((c8 & 256) == Q7) {
                            this.f20648l = Collections.unmodifiableList(this.f20648l);
                        }
                        try {
                            c2719fI.H();
                        } catch (IOException unused2) {
                        } catch (Throwable th3) {
                            this.f20638b = bVarK.n();
                            throw th3;
                        }
                        this.f20638b = bVarK.n();
                        m();
                        throw th2;
                    }
                }
            }

            public static c M() {
                return f20636q;
            }

            public static C0350b f0() {
                return C0350b.r();
            }

            public static C0350b g0(c cVar) {
                return f0().k(cVar);
            }

            public b G() {
                return this.f20647k;
            }

            public int H() {
                return this.f20649m;
            }

            public c I(int i8) {
                return (c) this.f20648l.get(i8);
            }

            public int J() {
                return this.f20648l.size();
            }

            public List K() {
                return this.f20648l;
            }

            public int L() {
                return this.f20645i;
            }

            public double N() {
                return this.f20643g;
            }

            public int O() {
                return this.f20646j;
            }

            public int P() {
                return this.f20650n;
            }

            public float Q() {
                return this.f20642f;
            }

            public long R() {
                return this.f20641e;
            }

            public int S() {
                return this.f20644h;
            }

            public EnumC0351c T() {
                return this.f20640d;
            }

            public boolean U() {
                return (this.f20639c & 128) == 128;
            }

            public boolean V() {
                return (this.f20639c & 256) == 256;
            }

            public boolean W() {
                return (this.f20639c & 32) == 32;
            }

            public boolean X() {
                return (this.f20639c & 8) == 8;
            }

            public boolean Y() {
                return (this.f20639c & 64) == 64;
            }

            public boolean Z() {
                return (this.f20639c & 512) == 512;
            }

            public boolean a0() {
                return (this.f20639c & 4) == 4;
            }

            public boolean b0() {
                return (this.f20639c & 2) == 2;
            }

            @Override // s6.p
            public int c() {
                int i8 = this.f20652p;
                if (i8 != -1) {
                    return i8;
                }
                int iH = (this.f20639c & 1) == 1 ? C2719f.h(1, this.f20640d.d()) : 0;
                if ((this.f20639c & 2) == 2) {
                    iH += C2719f.z(2, this.f20641e);
                }
                if ((this.f20639c & 4) == 4) {
                    iH += C2719f.l(3, this.f20642f);
                }
                if ((this.f20639c & 8) == 8) {
                    iH += C2719f.f(4, this.f20643g);
                }
                if ((this.f20639c & 16) == 16) {
                    iH += C2719f.o(5, this.f20644h);
                }
                if ((this.f20639c & 32) == 32) {
                    iH += C2719f.o(6, this.f20645i);
                }
                if ((this.f20639c & 64) == 64) {
                    iH += C2719f.o(7, this.f20646j);
                }
                if ((this.f20639c & 128) == 128) {
                    iH += C2719f.r(8, this.f20647k);
                }
                for (int i9 = 0; i9 < this.f20648l.size(); i9++) {
                    iH += C2719f.r(9, (s6.p) this.f20648l.get(i9));
                }
                if ((this.f20639c & 512) == 512) {
                    iH += C2719f.o(10, this.f20650n);
                }
                if ((this.f20639c & 256) == 256) {
                    iH += C2719f.o(11, this.f20649m);
                }
                int size = iH + this.f20638b.size();
                this.f20652p = size;
                return size;
            }

            public boolean c0() {
                return (this.f20639c & 16) == 16;
            }

            public boolean d0() {
                return (this.f20639c & 1) == 1;
            }

            @Override // s6.q
            public final boolean e() {
                byte b8 = this.f20651o;
                if (b8 == 1) {
                    return true;
                }
                if (b8 == 0) {
                    return false;
                }
                if (U() && !G().e()) {
                    this.f20651o = (byte) 0;
                    return false;
                }
                for (int i8 = 0; i8 < J(); i8++) {
                    if (!I(i8).e()) {
                        this.f20651o = (byte) 0;
                        return false;
                    }
                }
                this.f20651o = (byte) 1;
                return true;
            }

            public final void e0() {
                this.f20640d = EnumC0351c.BYTE;
                this.f20641e = 0L;
                this.f20642f = 0.0f;
                this.f20643g = 0.0d;
                this.f20644h = 0;
                this.f20645i = 0;
                this.f20646j = 0;
                this.f20647k = b.A();
                this.f20648l = Collections.emptyList();
                this.f20649m = 0;
                this.f20650n = 0;
            }

            @Override // s6.p
            public void h(C2719f c2719f) throws IOException {
                c();
                if ((this.f20639c & 1) == 1) {
                    c2719f.R(1, this.f20640d.d());
                }
                if ((this.f20639c & 2) == 2) {
                    c2719f.s0(2, this.f20641e);
                }
                if ((this.f20639c & 4) == 4) {
                    c2719f.V(3, this.f20642f);
                }
                if ((this.f20639c & 8) == 8) {
                    c2719f.P(4, this.f20643g);
                }
                if ((this.f20639c & 16) == 16) {
                    c2719f.Z(5, this.f20644h);
                }
                if ((this.f20639c & 32) == 32) {
                    c2719f.Z(6, this.f20645i);
                }
                if ((this.f20639c & 64) == 64) {
                    c2719f.Z(7, this.f20646j);
                }
                if ((this.f20639c & 128) == 128) {
                    c2719f.c0(8, this.f20647k);
                }
                for (int i8 = 0; i8 < this.f20648l.size(); i8++) {
                    c2719f.c0(9, (s6.p) this.f20648l.get(i8));
                }
                if ((this.f20639c & 512) == 512) {
                    c2719f.Z(10, this.f20650n);
                }
                if ((this.f20639c & 256) == 256) {
                    c2719f.Z(11, this.f20649m);
                }
                c2719f.h0(this.f20638b);
            }

            @Override // s6.p
            /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
            public C0350b d() {
                return f0();
            }

            @Override // s6.p
            /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
            public C0350b g() {
                return g0(this);
            }

            public c(AbstractC2722i.b bVar) {
                super(bVar);
                this.f20651o = (byte) -1;
                this.f20652p = -1;
                this.f20638b = bVar.j();
            }

            public c(boolean z7) {
                this.f20651o = (byte) -1;
                this.f20652p = -1;
                this.f20638b = AbstractC2717d.f23128a;
            }

            /* JADX INFO: renamed from: l6.b$b$c$b, reason: collision with other inner class name */
            public static final class C0350b extends AbstractC2722i.b implements s6.q {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public int f20653b;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public long f20655d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public float f20656e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                public double f20657f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public int f20658g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                public int f20659h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                public int f20660i;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public int f20663l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                public int f20664m;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public EnumC0351c f20654c = EnumC0351c.BYTE;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public b f20661j = b.A();

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public List f20662k = Collections.emptyList();

                public C0350b() {
                    t();
                }

                public static C0350b r() {
                    return new C0350b();
                }

                public C0350b A(int i8) {
                    this.f20653b |= 64;
                    this.f20660i = i8;
                    return this;
                }

                public C0350b B(int i8) {
                    this.f20653b |= 1024;
                    this.f20664m = i8;
                    return this;
                }

                public C0350b C(float f8) {
                    this.f20653b |= 4;
                    this.f20656e = f8;
                    return this;
                }

                public C0350b D(long j8) {
                    this.f20653b |= 2;
                    this.f20655d = j8;
                    return this;
                }

                public C0350b E(int i8) {
                    this.f20653b |= 16;
                    this.f20658g = i8;
                    return this;
                }

                public C0350b F(EnumC0351c enumC0351c) {
                    enumC0351c.getClass();
                    this.f20653b |= 1;
                    this.f20654c = enumC0351c;
                    return this;
                }

                @Override // s6.p.a
                /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
                public c a() {
                    c cVarP = p();
                    if (cVarP.e()) {
                        return cVarP;
                    }
                    throw AbstractC2714a.AbstractC0396a.i(cVarP);
                }

                public c p() {
                    c cVar = new c(this);
                    int i8 = this.f20653b;
                    int i9 = (i8 & 1) != 1 ? 0 : 1;
                    cVar.f20640d = this.f20654c;
                    if ((i8 & 2) == 2) {
                        i9 |= 2;
                    }
                    cVar.f20641e = this.f20655d;
                    if ((i8 & 4) == 4) {
                        i9 |= 4;
                    }
                    cVar.f20642f = this.f20656e;
                    if ((i8 & 8) == 8) {
                        i9 |= 8;
                    }
                    cVar.f20643g = this.f20657f;
                    if ((i8 & 16) == 16) {
                        i9 |= 16;
                    }
                    cVar.f20644h = this.f20658g;
                    if ((i8 & 32) == 32) {
                        i9 |= 32;
                    }
                    cVar.f20645i = this.f20659h;
                    if ((i8 & 64) == 64) {
                        i9 |= 64;
                    }
                    cVar.f20646j = this.f20660i;
                    if ((i8 & 128) == 128) {
                        i9 |= 128;
                    }
                    cVar.f20647k = this.f20661j;
                    if ((this.f20653b & 256) == 256) {
                        this.f20662k = Collections.unmodifiableList(this.f20662k);
                        this.f20653b &= -257;
                    }
                    cVar.f20648l = this.f20662k;
                    if ((i8 & 512) == 512) {
                        i9 |= 256;
                    }
                    cVar.f20649m = this.f20663l;
                    if ((i8 & 1024) == 1024) {
                        i9 |= 512;
                    }
                    cVar.f20650n = this.f20664m;
                    cVar.f20639c = i9;
                    return cVar;
                }

                /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
                public C0350b clone() {
                    return r().k(p());
                }

                public final void s() {
                    if ((this.f20653b & 256) != 256) {
                        this.f20662k = new ArrayList(this.f20662k);
                        this.f20653b |= 256;
                    }
                }

                public C0350b u(b bVar) {
                    if ((this.f20653b & 128) == 128 && this.f20661j != b.A()) {
                        bVar = b.F(this.f20661j).k(bVar).p();
                    }
                    this.f20661j = bVar;
                    this.f20653b |= 128;
                    return this;
                }

                @Override // s6.AbstractC2722i.b
                /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
                public C0350b k(c cVar) {
                    if (cVar == c.M()) {
                        return this;
                    }
                    if (cVar.d0()) {
                        F(cVar.T());
                    }
                    if (cVar.b0()) {
                        D(cVar.R());
                    }
                    if (cVar.a0()) {
                        C(cVar.Q());
                    }
                    if (cVar.X()) {
                        z(cVar.N());
                    }
                    if (cVar.c0()) {
                        E(cVar.S());
                    }
                    if (cVar.W()) {
                        y(cVar.L());
                    }
                    if (cVar.Y()) {
                        A(cVar.O());
                    }
                    if (cVar.U()) {
                        u(cVar.G());
                    }
                    if (!cVar.f20648l.isEmpty()) {
                        if (this.f20662k.isEmpty()) {
                            this.f20662k = cVar.f20648l;
                            this.f20653b &= -257;
                        } else {
                            s();
                            this.f20662k.addAll(cVar.f20648l);
                        }
                    }
                    if (cVar.V()) {
                        x(cVar.H());
                    }
                    if (cVar.Z()) {
                        B(cVar.P());
                    }
                    l(j().d(cVar.f20638b));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // s6.p.a
                /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public l6.b.C0348b.c.C0350b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
                    /*
                        r2 = this;
                        r0 = 0
                        s6.r r1 = l6.b.C0348b.c.f20637r     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                        java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                        l6.b$b$c r3 = (l6.b.C0348b.c) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
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
                        l6.b$b$c r4 = (l6.b.C0348b.c) r4     // Catch: java.lang.Throwable -> Lf
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
                    throw new UnsupportedOperationException("Method not decompiled: l6.b.C0348b.c.C0350b.n(s6.e, s6.g):l6.b$b$c$b");
                }

                public C0350b x(int i8) {
                    this.f20653b |= 512;
                    this.f20663l = i8;
                    return this;
                }

                public C0350b y(int i8) {
                    this.f20653b |= 32;
                    this.f20659h = i8;
                    return this;
                }

                public C0350b z(double d8) {
                    this.f20653b |= 8;
                    this.f20657f = d8;
                    return this;
                }

                private void t() {
                }
            }
        }

        public C0348b(AbstractC2722i.b bVar) {
            super(bVar);
            this.f20631f = (byte) -1;
            this.f20632g = -1;
            this.f20627b = bVar.j();
        }

        public C0348b(boolean z7) {
            this.f20631f = (byte) -1;
            this.f20632g = -1;
            this.f20627b = AbstractC2717d.f23128a;
        }

        /* JADX INFO: renamed from: l6.b$b$b, reason: collision with other inner class name */
        public static final class C0349b extends AbstractC2722i.b implements s6.q {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f20633b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f20634c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public c f20635d = c.M();

            public C0349b() {
                s();
            }

            public static C0349b r() {
                return new C0349b();
            }

            @Override // s6.p.a
            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public C0348b a() {
                C0348b c0348bP = p();
                if (c0348bP.e()) {
                    return c0348bP;
                }
                throw AbstractC2714a.AbstractC0396a.i(c0348bP);
            }

            public C0348b p() {
                C0348b c0348b = new C0348b(this);
                int i8 = this.f20633b;
                int i9 = (i8 & 1) != 1 ? 0 : 1;
                c0348b.f20629d = this.f20634c;
                if ((i8 & 2) == 2) {
                    i9 |= 2;
                }
                c0348b.f20630e = this.f20635d;
                c0348b.f20628c = i9;
                return c0348b;
            }

            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public C0349b clone() {
                return r().k(p());
            }

            @Override // s6.AbstractC2722i.b
            /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
            public C0349b k(C0348b c0348b) {
                if (c0348b == C0348b.w()) {
                    return this;
                }
                if (c0348b.z()) {
                    w(c0348b.x());
                }
                if (c0348b.A()) {
                    v(c0348b.y());
                }
                l(j().d(c0348b.f20627b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // s6.p.a
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public l6.b.C0348b.C0349b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    s6.r r1 = l6.b.C0348b.f20626i     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                    java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                    l6.b$b r3 = (l6.b.C0348b) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
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
                    l6.b$b r4 = (l6.b.C0348b) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: l6.b.C0348b.C0349b.n(s6.e, s6.g):l6.b$b$b");
            }

            public C0349b v(c cVar) {
                if ((this.f20633b & 2) == 2 && this.f20635d != c.M()) {
                    cVar = c.g0(this.f20635d).k(cVar).p();
                }
                this.f20635d = cVar;
                this.f20633b |= 2;
                return this;
            }

            public C0349b w(int i8) {
                this.f20633b |= 1;
                this.f20634c = i8;
                return this;
            }

            public final void s() {
            }
        }
    }

    static {
        b bVar = new b(true);
        f20617h = bVar;
        bVar.D();
    }

    public b(C2718e c2718e, C2720g c2720g) {
        this.f20623f = (byte) -1;
        this.f20624g = -1;
        D();
        AbstractC2717d.b bVarK = AbstractC2717d.K();
        C2719f c2719fI = C2719f.I(bVarK, 1);
        boolean z7 = false;
        char c8 = 0;
        while (!z7) {
            try {
                try {
                    int iJ = c2718e.J();
                    if (iJ != 0) {
                        if (iJ == 8) {
                            this.f20620c |= 1;
                            this.f20621d = c2718e.r();
                        } else if (iJ == 18) {
                            if ((c8 & 2) != 2) {
                                this.f20622e = new ArrayList();
                                c8 = 2;
                            }
                            this.f20622e.add(c2718e.t(C0348b.f20626i, c2720g));
                        } else if (!q(c2718e, c2719fI, c2720g, iJ)) {
                        }
                    }
                    z7 = true;
                } catch (Throwable th) {
                    if ((c8 & 2) == 2) {
                        this.f20622e = Collections.unmodifiableList(this.f20622e);
                    }
                    try {
                        c2719fI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f20619b = bVarK.n();
                        throw th2;
                    }
                    this.f20619b = bVarK.n();
                    m();
                    throw th;
                }
            } catch (C2724k e8) {
                throw e8.i(this);
            } catch (IOException e9) {
                throw new C2724k(e9.getMessage()).i(this);
            }
        }
        if ((c8 & 2) == 2) {
            this.f20622e = Collections.unmodifiableList(this.f20622e);
        }
        try {
            c2719fI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f20619b = bVarK.n();
            throw th3;
        }
        this.f20619b = bVarK.n();
        m();
    }

    public static b A() {
        return f20617h;
    }

    private void D() {
        this.f20621d = 0;
        this.f20622e = Collections.emptyList();
    }

    public static c E() {
        return c.r();
    }

    public static c F(b bVar) {
        return E().k(bVar);
    }

    public int B() {
        return this.f20621d;
    }

    public boolean C() {
        return (this.f20620c & 1) == 1;
    }

    @Override // s6.p
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public c d() {
        return E();
    }

    @Override // s6.p
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public c g() {
        return F(this);
    }

    @Override // s6.p
    public int c() {
        int i8 = this.f20624g;
        if (i8 != -1) {
            return i8;
        }
        int iO = (this.f20620c & 1) == 1 ? C2719f.o(1, this.f20621d) : 0;
        for (int i9 = 0; i9 < this.f20622e.size(); i9++) {
            iO += C2719f.r(2, (s6.p) this.f20622e.get(i9));
        }
        int size = iO + this.f20619b.size();
        this.f20624g = size;
        return size;
    }

    @Override // s6.q
    public final boolean e() {
        byte b8 = this.f20623f;
        if (b8 == 1) {
            return true;
        }
        if (b8 == 0) {
            return false;
        }
        if (!C()) {
            this.f20623f = (byte) 0;
            return false;
        }
        for (int i8 = 0; i8 < y(); i8++) {
            if (!x(i8).e()) {
                this.f20623f = (byte) 0;
                return false;
            }
        }
        this.f20623f = (byte) 1;
        return true;
    }

    @Override // s6.p
    public void h(C2719f c2719f) throws IOException {
        c();
        if ((this.f20620c & 1) == 1) {
            c2719f.Z(1, this.f20621d);
        }
        for (int i8 = 0; i8 < this.f20622e.size(); i8++) {
            c2719f.c0(2, (s6.p) this.f20622e.get(i8));
        }
        c2719f.h0(this.f20619b);
    }

    public C0348b x(int i8) {
        return (C0348b) this.f20622e.get(i8);
    }

    public int y() {
        return this.f20622e.size();
    }

    public List z() {
        return this.f20622e;
    }

    public b(AbstractC2722i.b bVar) {
        super(bVar);
        this.f20623f = (byte) -1;
        this.f20624g = -1;
        this.f20619b = bVar.j();
    }

    public b(boolean z7) {
        this.f20623f = (byte) -1;
        this.f20624g = -1;
        this.f20619b = AbstractC2717d.f23128a;
    }

    public static final class c extends AbstractC2722i.b implements s6.q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20681b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f20682c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f20683d = Collections.emptyList();

        public c() {
            t();
        }

        public static c r() {
            return new c();
        }

        @Override // s6.p.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public b a() {
            b bVarP = p();
            if (bVarP.e()) {
                return bVarP;
            }
            throw AbstractC2714a.AbstractC0396a.i(bVarP);
        }

        public b p() {
            b bVar = new b(this);
            int i8 = (this.f20681b & 1) != 1 ? 0 : 1;
            bVar.f20621d = this.f20682c;
            if ((this.f20681b & 2) == 2) {
                this.f20683d = Collections.unmodifiableList(this.f20683d);
                this.f20681b &= -3;
            }
            bVar.f20622e = this.f20683d;
            bVar.f20620c = i8;
            return bVar;
        }

        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public c clone() {
            return r().k(p());
        }

        public final void s() {
            if ((this.f20681b & 2) != 2) {
                this.f20683d = new ArrayList(this.f20683d);
                this.f20681b |= 2;
            }
        }

        @Override // s6.AbstractC2722i.b
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public c k(b bVar) {
            if (bVar == b.A()) {
                return this;
            }
            if (bVar.C()) {
                w(bVar.B());
            }
            if (!bVar.f20622e.isEmpty()) {
                if (this.f20683d.isEmpty()) {
                    this.f20683d = bVar.f20622e;
                    this.f20681b &= -3;
                } else {
                    s();
                    this.f20683d.addAll(bVar.f20622e);
                }
            }
            l(j().d(bVar.f20619b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // s6.p.a
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public l6.b.c n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                s6.r r1 = l6.b.f20618i     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                l6.b r3 = (l6.b) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
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
                l6.b r4 = (l6.b) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: l6.b.c.n(s6.e, s6.g):l6.b$c");
        }

        public c w(int i8) {
            this.f20681b |= 1;
            this.f20682c = i8;
            return this;
        }

        private void t() {
        }
    }
}
