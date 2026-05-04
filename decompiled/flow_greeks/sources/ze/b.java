package ze;

import gf.a;
import gf.d;
import gf.i;
import gf.j;
import io.flutter.Build;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends gf.i implements gf.q {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final b f25911h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static gf.r f25912i = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gf.d f25913b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f25914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f25915d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List f25916e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public byte f25917f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f25918g;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a extends gf.b {
        @Override // gf.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public b c(gf.e eVar, gf.g gVar) {
            return new b(eVar, gVar);
        }
    }

    /* JADX INFO: renamed from: ze.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0490b extends gf.i implements gf.q {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final C0490b f25919h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static gf.r f25920i = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final gf.d f25921b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f25922c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f25923d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f25924e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte f25925f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f25926g;

        /* JADX INFO: renamed from: ze.b$b$a */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a extends gf.b {
            @Override // gf.r
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public C0490b c(gf.e eVar, gf.g gVar) {
                return new C0490b(eVar, gVar);
            }
        }

        static {
            C0490b c0490b = new C0490b(true);
            f25919h = c0490b;
            c0490b.A();
        }

        private void A() {
            this.f25923d = 0;
            this.f25924e = c.L();
        }

        public static C0491b B() {
            return C0491b.p();
        }

        public static C0491b C(C0490b c0490b) {
            return B().j(c0490b);
        }

        public static C0490b v() {
            return f25919h;
        }

        @Override // gf.p
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public C0491b c() {
            return B();
        }

        @Override // gf.p
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public C0491b f() {
            return C(this);
        }

        @Override // gf.p
        public int b() {
            int i10 = this.f25926g;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.f25922c & 1) == 1 ? gf.f.o(1, this.f25923d) : 0;
            if ((this.f25922c & 2) == 2) {
                iO += gf.f.r(2, this.f25924e);
            }
            int size = iO + this.f25921b.size();
            this.f25926g = size;
            return size;
        }

        @Override // gf.q
        public final boolean d() {
            byte b10 = this.f25925f;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            if (!y()) {
                this.f25925f = (byte) 0;
                return false;
            }
            if (!z()) {
                this.f25925f = (byte) 0;
                return false;
            }
            if (x().d()) {
                this.f25925f = (byte) 1;
                return true;
            }
            this.f25925f = (byte) 0;
            return false;
        }

        @Override // gf.p
        public void g(gf.f fVar) throws IOException {
            b();
            if ((this.f25922c & 1) == 1) {
                fVar.Z(1, this.f25923d);
            }
            if ((this.f25922c & 2) == 2) {
                fVar.c0(2, this.f25924e);
            }
            fVar.h0(this.f25921b);
        }

        public int w() {
            return this.f25923d;
        }

        public c x() {
            return this.f25924e;
        }

        public boolean y() {
            return (this.f25922c & 1) == 1;
        }

        public boolean z() {
            return (this.f25922c & 2) == 2;
        }

        /* JADX INFO: renamed from: ze.b$b$c */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class c extends gf.i implements gf.q {

            /* JADX INFO: renamed from: q, reason: collision with root package name */
            public static final c f25930q;

            /* JADX INFO: renamed from: r, reason: collision with root package name */
            public static gf.r f25931r = new a();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final gf.d f25932b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f25933c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public EnumC0493c f25934d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public long f25935e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public float f25936f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public double f25937g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public int f25938h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public int f25939i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public int f25940j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public b f25941k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public List f25942l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public int f25943m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public int f25944n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public byte f25945o;

            /* JADX INFO: renamed from: p, reason: collision with root package name */
            public int f25946p;

            /* JADX INFO: renamed from: ze.b$b$c$a */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static class a extends gf.b {
                @Override // gf.r
                /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
                public c c(gf.e eVar, gf.g gVar) {
                    return new c(eVar, gVar);
                }
            }

            /* JADX INFO: renamed from: ze.b$b$c$c, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public enum EnumC0493c implements j.a {
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
                public static j.b f25972o = new a();

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final int f25974a;

                /* JADX INFO: renamed from: ze.b$b$c$c$a */
                /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
                public static class a implements j.b {
                    @Override // gf.j.b
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public EnumC0493c a(int i10) {
                        return EnumC0493c.a(i10);
                    }
                }

                EnumC0493c(int i10, int i11) {
                    this.f25974a = i11;
                }

                public static EnumC0493c a(int i10) {
                    switch (i10) {
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
                        case 11:
                            return ANNOTATION;
                        case 12:
                            return ARRAY;
                        default:
                            return null;
                    }
                }

                @Override // gf.j.a
                public final int d() {
                    return this.f25974a;
                }
            }

            static {
                c cVar = new c(true);
                f25930q = cVar;
                cVar.d0();
            }

            public static c L() {
                return f25930q;
            }

            public static C0492b e0() {
                return C0492b.p();
            }

            public static C0492b f0(c cVar) {
                return e0().j(cVar);
            }

            public b F() {
                return this.f25941k;
            }

            public int G() {
                return this.f25943m;
            }

            public c H(int i10) {
                return (c) this.f25942l.get(i10);
            }

            public int I() {
                return this.f25942l.size();
            }

            public List J() {
                return this.f25942l;
            }

            public int K() {
                return this.f25939i;
            }

            public double M() {
                return this.f25937g;
            }

            public int N() {
                return this.f25940j;
            }

            public int O() {
                return this.f25944n;
            }

            public float P() {
                return this.f25936f;
            }

            public long Q() {
                return this.f25935e;
            }

            public int R() {
                return this.f25938h;
            }

            public EnumC0493c S() {
                return this.f25934d;
            }

            public boolean T() {
                return (this.f25933c & 128) == 128;
            }

            public boolean U() {
                return (this.f25933c & 256) == 256;
            }

            public boolean V() {
                return (this.f25933c & 32) == 32;
            }

            public boolean W() {
                return (this.f25933c & 8) == 8;
            }

            public boolean X() {
                return (this.f25933c & 64) == 64;
            }

            public boolean Y() {
                return (this.f25933c & 512) == 512;
            }

            public boolean Z() {
                return (this.f25933c & 4) == 4;
            }

            public boolean a0() {
                return (this.f25933c & 2) == 2;
            }

            @Override // gf.p
            public int b() {
                int i10 = this.f25946p;
                if (i10 != -1) {
                    return i10;
                }
                int iH = (this.f25933c & 1) == 1 ? gf.f.h(1, this.f25934d.d()) : 0;
                if ((this.f25933c & 2) == 2) {
                    iH += gf.f.z(2, this.f25935e);
                }
                if ((this.f25933c & 4) == 4) {
                    iH += gf.f.l(3, this.f25936f);
                }
                if ((this.f25933c & 8) == 8) {
                    iH += gf.f.f(4, this.f25937g);
                }
                if ((this.f25933c & 16) == 16) {
                    iH += gf.f.o(5, this.f25938h);
                }
                if ((this.f25933c & 32) == 32) {
                    iH += gf.f.o(6, this.f25939i);
                }
                if ((this.f25933c & 64) == 64) {
                    iH += gf.f.o(7, this.f25940j);
                }
                if ((this.f25933c & 128) == 128) {
                    iH += gf.f.r(8, this.f25941k);
                }
                for (int i11 = 0; i11 < this.f25942l.size(); i11++) {
                    iH += gf.f.r(9, (gf.p) this.f25942l.get(i11));
                }
                if ((this.f25933c & 512) == 512) {
                    iH += gf.f.o(10, this.f25944n);
                }
                if ((this.f25933c & 256) == 256) {
                    iH += gf.f.o(11, this.f25943m);
                }
                int size = iH + this.f25932b.size();
                this.f25946p = size;
                return size;
            }

            public boolean b0() {
                return (this.f25933c & 16) == 16;
            }

            public boolean c0() {
                return (this.f25933c & 1) == 1;
            }

            @Override // gf.q
            public final boolean d() {
                byte b10 = this.f25945o;
                if (b10 == 1) {
                    return true;
                }
                if (b10 == 0) {
                    return false;
                }
                if (T() && !F().d()) {
                    this.f25945o = (byte) 0;
                    return false;
                }
                for (int i10 = 0; i10 < I(); i10++) {
                    if (!H(i10).d()) {
                        this.f25945o = (byte) 0;
                        return false;
                    }
                }
                this.f25945o = (byte) 1;
                return true;
            }

            public final void d0() {
                this.f25934d = EnumC0493c.BYTE;
                this.f25935e = 0L;
                this.f25936f = 0.0f;
                this.f25937g = 0.0d;
                this.f25938h = 0;
                this.f25939i = 0;
                this.f25940j = 0;
                this.f25941k = b.z();
                this.f25942l = Collections.EMPTY_LIST;
                this.f25943m = 0;
                this.f25944n = 0;
            }

            @Override // gf.p
            public void g(gf.f fVar) throws IOException {
                b();
                if ((this.f25933c & 1) == 1) {
                    fVar.R(1, this.f25934d.d());
                }
                if ((this.f25933c & 2) == 2) {
                    fVar.s0(2, this.f25935e);
                }
                if ((this.f25933c & 4) == 4) {
                    fVar.V(3, this.f25936f);
                }
                if ((this.f25933c & 8) == 8) {
                    fVar.P(4, this.f25937g);
                }
                if ((this.f25933c & 16) == 16) {
                    fVar.Z(5, this.f25938h);
                }
                if ((this.f25933c & 32) == 32) {
                    fVar.Z(6, this.f25939i);
                }
                if ((this.f25933c & 64) == 64) {
                    fVar.Z(7, this.f25940j);
                }
                if ((this.f25933c & 128) == 128) {
                    fVar.c0(8, this.f25941k);
                }
                for (int i10 = 0; i10 < this.f25942l.size(); i10++) {
                    fVar.c0(9, (gf.p) this.f25942l.get(i10));
                }
                if ((this.f25933c & 512) == 512) {
                    fVar.Z(10, this.f25944n);
                }
                if ((this.f25933c & 256) == 256) {
                    fVar.Z(11, this.f25943m);
                }
                fVar.h0(this.f25932b);
            }

            @Override // gf.p
            /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
            public C0492b c() {
                return e0();
            }

            @Override // gf.p
            /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
            public C0492b f() {
                return f0(this);
            }

            public c(i.b bVar) {
                super(bVar);
                this.f25945o = (byte) -1;
                this.f25946p = -1;
                this.f25932b = bVar.i();
            }

            public c(boolean z10) {
                this.f25945o = (byte) -1;
                this.f25946p = -1;
                this.f25932b = gf.d.f10630a;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r5v0 */
            /* JADX WARN: Type inference failed for: r5v1 */
            /* JADX WARN: Type inference failed for: r5v2, types: [boolean] */
            public c(gf.e eVar, gf.g gVar) {
                this.f25945o = (byte) -1;
                this.f25946p = -1;
                d0();
                d.b bVarV = gf.d.v();
                gf.f fVarI = gf.f.I(bVarV, 1);
                boolean z10 = false;
                char c10 = 0;
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
                                            int iM = eVar.m();
                                            EnumC0493c enumC0493cA = EnumC0493c.a(iM);
                                            if (enumC0493cA == null) {
                                                fVarI.n0(iJ);
                                                fVarI.n0(iM);
                                            } else {
                                                this.f25933c |= 1;
                                                this.f25934d = enumC0493cA;
                                            }
                                            break;
                                        case 16:
                                            this.f25933c |= 2;
                                            this.f25935e = eVar.G();
                                            break;
                                        case Build.API_LEVELS.API_29 /* 29 */:
                                            this.f25933c |= 4;
                                            this.f25936f = eVar.p();
                                            break;
                                        case Build.API_LEVELS.API_33 /* 33 */:
                                            this.f25933c |= 8;
                                            this.f25937g = eVar.l();
                                            break;
                                        case 40:
                                            this.f25933c |= 16;
                                            this.f25938h = eVar.r();
                                            break;
                                        case 48:
                                            this.f25933c |= 32;
                                            this.f25939i = eVar.r();
                                            break;
                                        case 56:
                                            this.f25933c |= 64;
                                            this.f25940j = eVar.r();
                                            break;
                                        case 66:
                                            c cVarF = (this.f25933c & 128) == 128 ? this.f25941k.f() : null;
                                            b bVar = (b) eVar.t(b.f25912i, gVar);
                                            this.f25941k = bVar;
                                            if (cVarF != null) {
                                                cVarF.j(bVar);
                                                this.f25941k = cVarF.n();
                                            }
                                            this.f25933c |= 128;
                                            break;
                                        case 74:
                                            if ((c10 & 256) != 256) {
                                                this.f25942l = new ArrayList();
                                                c10 = 256;
                                            }
                                            this.f25942l.add(eVar.t(f25931r, gVar));
                                            break;
                                        case 80:
                                            this.f25933c |= 512;
                                            this.f25944n = eVar.r();
                                            break;
                                        case 88:
                                            this.f25933c |= 256;
                                            this.f25943m = eVar.r();
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
                            if ((c10 & 256) == O) {
                                this.f25942l = Collections.unmodifiableList(this.f25942l);
                            }
                            try {
                                fVarI.H();
                            } catch (IOException unused) {
                            } catch (Throwable th2) {
                                this.f25932b = bVarV.u();
                                throw th2;
                            }
                            this.f25932b = bVarV.u();
                            l();
                            throw th;
                        }
                    } else {
                        if ((c10 & 256) == 256) {
                            this.f25942l = Collections.unmodifiableList(this.f25942l);
                        }
                        try {
                            fVarI.H();
                        } catch (IOException unused2) {
                        } catch (Throwable th3) {
                            this.f25932b = bVarV.u();
                            throw th3;
                        }
                        this.f25932b = bVarV.u();
                        l();
                        return;
                    }
                }
            }

            /* JADX INFO: renamed from: ze.b$b$c$b, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static final class C0492b extends i.b implements gf.q {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public int f25947b;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public long f25949d;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public float f25950e;

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                public double f25951f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public int f25952g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                public int f25953h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                public int f25954i;

                /* JADX INFO: renamed from: l, reason: collision with root package name */
                public int f25957l;

                /* JADX INFO: renamed from: m, reason: collision with root package name */
                public int f25958m;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public EnumC0493c f25948c = EnumC0493c.BYTE;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                public b f25955j = b.z();

                /* JADX INFO: renamed from: k, reason: collision with root package name */
                public List f25956k = Collections.EMPTY_LIST;

                public C0492b() {
                    r();
                }

                public static C0492b p() {
                    return new C0492b();
                }

                public C0492b A(int i10) {
                    this.f25947b |= 1024;
                    this.f25958m = i10;
                    return this;
                }

                public C0492b B(float f10) {
                    this.f25947b |= 4;
                    this.f25950e = f10;
                    return this;
                }

                public C0492b C(long j10) {
                    this.f25947b |= 2;
                    this.f25949d = j10;
                    return this;
                }

                public C0492b D(int i10) {
                    this.f25947b |= 16;
                    this.f25952g = i10;
                    return this;
                }

                public C0492b E(EnumC0493c enumC0493c) {
                    enumC0493c.getClass();
                    this.f25947b |= 1;
                    this.f25948c = enumC0493c;
                    return this;
                }

                @Override // gf.p.a
                /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
                public c build() {
                    c cVarN = n();
                    if (cVarN.d()) {
                        return cVarN;
                    }
                    throw a.AbstractC0191a.h(cVarN);
                }

                public c n() {
                    c cVar = new c(this);
                    int i10 = this.f25947b;
                    int i11 = (i10 & 1) != 1 ? 0 : 1;
                    cVar.f25934d = this.f25948c;
                    if ((i10 & 2) == 2) {
                        i11 |= 2;
                    }
                    cVar.f25935e = this.f25949d;
                    if ((i10 & 4) == 4) {
                        i11 |= 4;
                    }
                    cVar.f25936f = this.f25950e;
                    if ((i10 & 8) == 8) {
                        i11 |= 8;
                    }
                    cVar.f25937g = this.f25951f;
                    if ((i10 & 16) == 16) {
                        i11 |= 16;
                    }
                    cVar.f25938h = this.f25952g;
                    if ((i10 & 32) == 32) {
                        i11 |= 32;
                    }
                    cVar.f25939i = this.f25953h;
                    if ((i10 & 64) == 64) {
                        i11 |= 64;
                    }
                    cVar.f25940j = this.f25954i;
                    if ((i10 & 128) == 128) {
                        i11 |= 128;
                    }
                    cVar.f25941k = this.f25955j;
                    if ((this.f25947b & 256) == 256) {
                        this.f25956k = Collections.unmodifiableList(this.f25956k);
                        this.f25947b &= -257;
                    }
                    cVar.f25942l = this.f25956k;
                    if ((i10 & 512) == 512) {
                        i11 |= 256;
                    }
                    cVar.f25943m = this.f25957l;
                    if ((i10 & 1024) == 1024) {
                        i11 |= 512;
                    }
                    cVar.f25944n = this.f25958m;
                    cVar.f25933c = i11;
                    return cVar;
                }

                /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
                public C0492b clone() {
                    return p().j(n());
                }

                public final void q() {
                    if ((this.f25947b & 256) != 256) {
                        this.f25956k = new ArrayList(this.f25956k);
                        this.f25947b |= 256;
                    }
                }

                public C0492b s(b bVar) {
                    if ((this.f25947b & 128) != 128 || this.f25955j == b.z()) {
                        this.f25955j = bVar;
                    } else {
                        this.f25955j = b.E(this.f25955j).j(bVar).n();
                    }
                    this.f25947b |= 128;
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // gf.p.a
                /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public ze.b.C0490b.c.C0492b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
                    /*
                        r2 = this;
                        r0 = 0
                        gf.r r1 = ze.b.C0490b.c.f25931r     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                        java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                        ze.b$b$c r3 = (ze.b.C0490b.c) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                        ze.b$b$c r4 = (ze.b.C0490b.c) r4     // Catch: java.lang.Throwable -> Lf
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
                    throw new UnsupportedOperationException("Method not decompiled: ze.b.C0490b.c.C0492b.u(gf.e, gf.g):ze.b$b$c$b");
                }

                @Override // gf.i.b
                /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
                public C0492b j(c cVar) {
                    if (cVar == c.L()) {
                        return this;
                    }
                    if (cVar.c0()) {
                        E(cVar.S());
                    }
                    if (cVar.a0()) {
                        C(cVar.Q());
                    }
                    if (cVar.Z()) {
                        B(cVar.P());
                    }
                    if (cVar.W()) {
                        y(cVar.M());
                    }
                    if (cVar.b0()) {
                        D(cVar.R());
                    }
                    if (cVar.V()) {
                        x(cVar.K());
                    }
                    if (cVar.X()) {
                        z(cVar.N());
                    }
                    if (cVar.T()) {
                        s(cVar.F());
                    }
                    if (!cVar.f25942l.isEmpty()) {
                        if (this.f25956k.isEmpty()) {
                            this.f25956k = cVar.f25942l;
                            this.f25947b &= -257;
                        } else {
                            q();
                            this.f25956k.addAll(cVar.f25942l);
                        }
                    }
                    if (cVar.U()) {
                        w(cVar.G());
                    }
                    if (cVar.Y()) {
                        A(cVar.O());
                    }
                    k(i().c(cVar.f25932b));
                    return this;
                }

                public C0492b w(int i10) {
                    this.f25947b |= 512;
                    this.f25957l = i10;
                    return this;
                }

                public C0492b x(int i10) {
                    this.f25947b |= 32;
                    this.f25953h = i10;
                    return this;
                }

                public C0492b y(double d10) {
                    this.f25947b |= 8;
                    this.f25951f = d10;
                    return this;
                }

                public C0492b z(int i10) {
                    this.f25947b |= 64;
                    this.f25954i = i10;
                    return this;
                }

                private void r() {
                }
            }
        }

        public C0490b(i.b bVar) {
            super(bVar);
            this.f25925f = (byte) -1;
            this.f25926g = -1;
            this.f25921b = bVar.i();
        }

        public C0490b(boolean z10) {
            this.f25925f = (byte) -1;
            this.f25926g = -1;
            this.f25921b = gf.d.f10630a;
        }

        public C0490b(gf.e eVar, gf.g gVar) {
            this.f25925f = (byte) -1;
            this.f25926g = -1;
            A();
            d.b bVarV = gf.d.v();
            gf.f fVarI = gf.f.I(bVarV, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int iJ = eVar.J();
                        if (iJ != 0) {
                            if (iJ == 8) {
                                this.f25922c |= 1;
                                this.f25923d = eVar.r();
                            } else if (iJ != 18) {
                                if (!o(eVar, fVarI, gVar, iJ)) {
                                }
                            } else {
                                c.C0492b c0492bF = (this.f25922c & 2) == 2 ? this.f25924e.f() : null;
                                c cVar = (c) eVar.t(c.f25931r, gVar);
                                this.f25924e = cVar;
                                if (c0492bF != null) {
                                    c0492bF.j(cVar);
                                    this.f25924e = c0492bF.n();
                                }
                                this.f25922c |= 2;
                            }
                        }
                        z10 = true;
                    } catch (Throwable th) {
                        try {
                            fVarI.H();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f25921b = bVarV.u();
                            throw th2;
                        }
                        this.f25921b = bVarV.u();
                        l();
                        throw th;
                    }
                } catch (gf.k e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new gf.k(e11.getMessage()).i(this);
                }
            }
            try {
                fVarI.H();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f25921b = bVarV.u();
                throw th3;
            }
            this.f25921b = bVarV.u();
            l();
        }

        /* JADX INFO: renamed from: ze.b$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0491b extends i.b implements gf.q {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f25927b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f25928c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public c f25929d = c.L();

            public C0491b() {
                q();
            }

            public static C0491b p() {
                return new C0491b();
            }

            @Override // gf.p.a
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public C0490b build() {
                C0490b c0490bN = n();
                if (c0490bN.d()) {
                    return c0490bN;
                }
                throw a.AbstractC0191a.h(c0490bN);
            }

            public C0490b n() {
                C0490b c0490b = new C0490b(this);
                int i10 = this.f25927b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                c0490b.f25923d = this.f25928c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                c0490b.f25924e = this.f25929d;
                c0490b.f25922c = i11;
                return c0490b;
            }

            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public C0491b clone() {
                return p().j(n());
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // gf.p.a
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public ze.b.C0490b.C0491b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    gf.r r1 = ze.b.C0490b.f25920i     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                    ze.b$b r3 = (ze.b.C0490b) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                    ze.b$b r4 = (ze.b.C0490b) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: ze.b.C0490b.C0491b.u(gf.e, gf.g):ze.b$b$b");
            }

            @Override // gf.i.b
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            public C0491b j(C0490b c0490b) {
                if (c0490b == C0490b.v()) {
                    return this;
                }
                if (c0490b.y()) {
                    v(c0490b.w());
                }
                if (c0490b.z()) {
                    t(c0490b.x());
                }
                k(i().c(c0490b.f25921b));
                return this;
            }

            public C0491b t(c cVar) {
                if ((this.f25927b & 2) != 2 || this.f25929d == c.L()) {
                    this.f25929d = cVar;
                } else {
                    this.f25929d = c.f0(this.f25929d).j(cVar).n();
                }
                this.f25927b |= 2;
                return this;
            }

            public C0491b v(int i10) {
                this.f25927b |= 1;
                this.f25928c = i10;
                return this;
            }

            public final void q() {
            }
        }
    }

    static {
        b bVar = new b(true);
        f25911h = bVar;
        bVar.C();
    }

    private void C() {
        this.f25915d = 0;
        this.f25916e = Collections.EMPTY_LIST;
    }

    public static c D() {
        return c.p();
    }

    public static c E(b bVar) {
        return D().j(bVar);
    }

    public static b z() {
        return f25911h;
    }

    public int A() {
        return this.f25915d;
    }

    public boolean B() {
        return (this.f25914c & 1) == 1;
    }

    @Override // gf.p
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public c c() {
        return D();
    }

    @Override // gf.p
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public c f() {
        return E(this);
    }

    @Override // gf.p
    public int b() {
        int i10 = this.f25918g;
        if (i10 != -1) {
            return i10;
        }
        int iO = (this.f25914c & 1) == 1 ? gf.f.o(1, this.f25915d) : 0;
        for (int i11 = 0; i11 < this.f25916e.size(); i11++) {
            iO += gf.f.r(2, (gf.p) this.f25916e.get(i11));
        }
        int size = iO + this.f25913b.size();
        this.f25918g = size;
        return size;
    }

    @Override // gf.q
    public final boolean d() {
        byte b10 = this.f25917f;
        if (b10 == 1) {
            return true;
        }
        if (b10 == 0) {
            return false;
        }
        if (!B()) {
            this.f25917f = (byte) 0;
            return false;
        }
        for (int i10 = 0; i10 < x(); i10++) {
            if (!w(i10).d()) {
                this.f25917f = (byte) 0;
                return false;
            }
        }
        this.f25917f = (byte) 1;
        return true;
    }

    @Override // gf.p
    public void g(gf.f fVar) throws IOException {
        b();
        if ((this.f25914c & 1) == 1) {
            fVar.Z(1, this.f25915d);
        }
        for (int i10 = 0; i10 < this.f25916e.size(); i10++) {
            fVar.c0(2, (gf.p) this.f25916e.get(i10));
        }
        fVar.h0(this.f25913b);
    }

    public C0490b w(int i10) {
        return (C0490b) this.f25916e.get(i10);
    }

    public int x() {
        return this.f25916e.size();
    }

    public List y() {
        return this.f25916e;
    }

    public b(i.b bVar) {
        super(bVar);
        this.f25917f = (byte) -1;
        this.f25918g = -1;
        this.f25913b = bVar.i();
    }

    public b(boolean z10) {
        this.f25917f = (byte) -1;
        this.f25918g = -1;
        this.f25913b = gf.d.f10630a;
    }

    public b(gf.e eVar, gf.g gVar) {
        this.f25917f = (byte) -1;
        this.f25918g = -1;
        C();
        d.b bVarV = gf.d.v();
        gf.f fVarI = gf.f.I(bVarV, 1);
        boolean z10 = false;
        char c10 = 0;
        while (!z10) {
            try {
                try {
                    int iJ = eVar.J();
                    if (iJ != 0) {
                        if (iJ == 8) {
                            this.f25914c |= 1;
                            this.f25915d = eVar.r();
                        } else if (iJ != 18) {
                            if (!o(eVar, fVarI, gVar, iJ)) {
                            }
                        } else {
                            if ((c10 & 2) != 2) {
                                this.f25916e = new ArrayList();
                                c10 = 2;
                            }
                            this.f25916e.add(eVar.t(C0490b.f25920i, gVar));
                        }
                    }
                    z10 = true;
                } catch (Throwable th) {
                    if ((c10 & 2) == 2) {
                        this.f25916e = Collections.unmodifiableList(this.f25916e);
                    }
                    try {
                        fVarI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f25913b = bVarV.u();
                        throw th2;
                    }
                    this.f25913b = bVarV.u();
                    l();
                    throw th;
                }
            } catch (gf.k e10) {
                throw e10.i(this);
            } catch (IOException e11) {
                throw new gf.k(e11.getMessage()).i(this);
            }
        }
        if ((c10 & 2) == 2) {
            this.f25916e = Collections.unmodifiableList(this.f25916e);
        }
        try {
            fVarI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f25913b = bVarV.u();
            throw th3;
        }
        this.f25913b = bVarV.u();
        l();
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends i.b implements gf.q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f25975b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f25976c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f25977d = Collections.EMPTY_LIST;

        public c() {
            r();
        }

        public static c p() {
            return new c();
        }

        @Override // gf.p.a
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public b build() {
            b bVarN = n();
            if (bVarN.d()) {
                return bVarN;
            }
            throw a.AbstractC0191a.h(bVarN);
        }

        public b n() {
            b bVar = new b(this);
            int i10 = (this.f25975b & 1) != 1 ? 0 : 1;
            bVar.f25915d = this.f25976c;
            if ((this.f25975b & 2) == 2) {
                this.f25977d = Collections.unmodifiableList(this.f25977d);
                this.f25975b &= -3;
            }
            bVar.f25916e = this.f25977d;
            bVar.f25914c = i10;
            return bVar;
        }

        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public c clone() {
            return p().j(n());
        }

        public final void q() {
            if ((this.f25975b & 2) != 2) {
                this.f25977d = new ArrayList(this.f25977d);
                this.f25975b |= 2;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // gf.p.a
        /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public ze.b.c u(gf.e r3, gf.g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                gf.r r1 = ze.b.f25912i     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                ze.b r3 = (ze.b) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                ze.b r4 = (ze.b) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: ze.b.c.u(gf.e, gf.g):ze.b$c");
        }

        @Override // gf.i.b
        /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
        public c j(b bVar) {
            if (bVar == b.z()) {
                return this;
            }
            if (bVar.B()) {
                v(bVar.A());
            }
            if (!bVar.f25916e.isEmpty()) {
                if (this.f25977d.isEmpty()) {
                    this.f25977d = bVar.f25916e;
                    this.f25975b &= -3;
                } else {
                    q();
                    this.f25977d.addAll(bVar.f25916e);
                }
            }
            k(i().c(bVar.f25913b));
            return this;
        }

        public c v(int i10) {
            this.f25975b |= 1;
            this.f25976c = i10;
            return this;
        }

        private void r() {
        }
    }
}
