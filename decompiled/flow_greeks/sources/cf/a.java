package cf;

import gf.a;
import gf.d;
import gf.f;
import gf.g;
import gf.i;
import gf.j;
import gf.k;
import gf.p;
import gf.q;
import gf.r;
import gf.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import ze.l;
import ze.n;
import ze.s;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i.f f4050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final i.f f4051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final i.f f4052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i.f f4053d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i.f f4054e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final i.f f4055f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final i.f f4056g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final i.f f4057h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final i.f f4058i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final i.f f4059j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final i.f f4060k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final i.f f4061l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final i.f f4062m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final i.f f4063n;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class e extends i implements q {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final e f4103h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static r f4104i = new C0074a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final gf.d f4105b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f4106c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f4107d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4108e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte f4109f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f4110g;

        /* JADX INFO: renamed from: cf.a$e$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class C0074a extends gf.b {
            @Override // gf.r
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public e c(gf.e eVar, g gVar) {
                return new e(eVar, gVar);
            }
        }

        static {
            e eVar = new e(true);
            f4103h = eVar;
            eVar.z();
        }

        public static b A() {
            return b.p();
        }

        public static b B(e eVar) {
            return A().j(eVar);
        }

        public static e D(InputStream inputStream, g gVar) {
            return (e) f4104i.b(inputStream, gVar);
        }

        public static e w() {
            return f4103h;
        }

        private void z() {
            List list = Collections.EMPTY_LIST;
            this.f4106c = list;
            this.f4107d = list;
        }

        @Override // gf.p
        /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
        public b c() {
            return A();
        }

        @Override // gf.p
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public b f() {
            return B(this);
        }

        @Override // gf.p
        public int b() {
            int i10 = this.f4110g;
            if (i10 != -1) {
                return i10;
            }
            int iR = 0;
            for (int i11 = 0; i11 < this.f4106c.size(); i11++) {
                iR += f.r(1, (p) this.f4106c.get(i11));
            }
            int iP = 0;
            for (int i12 = 0; i12 < this.f4107d.size(); i12++) {
                iP += f.p(((Integer) this.f4107d.get(i12)).intValue());
            }
            int iP2 = iR + iP;
            if (!x().isEmpty()) {
                iP2 = iP2 + 1 + f.p(iP);
            }
            this.f4108e = iP;
            int size = iP2 + this.f4105b.size();
            this.f4110g = size;
            return size;
        }

        @Override // gf.q
        public final boolean d() {
            byte b10 = this.f4109f;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.f4109f = (byte) 1;
            return true;
        }

        @Override // gf.p
        public void g(f fVar) throws IOException {
            b();
            for (int i10 = 0; i10 < this.f4106c.size(); i10++) {
                fVar.c0(1, (p) this.f4106c.get(i10));
            }
            if (x().size() > 0) {
                fVar.n0(42);
                fVar.n0(this.f4108e);
            }
            for (int i11 = 0; i11 < this.f4107d.size(); i11++) {
                fVar.a0(((Integer) this.f4107d.get(i11)).intValue());
            }
            fVar.h0(this.f4105b);
        }

        public List x() {
            return this.f4107d;
        }

        public List y() {
            return this.f4106c;
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class c extends i implements q {

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public static final c f4114n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public static r f4115o = new C0075a();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final gf.d f4116b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f4117c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f4118d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f4119e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Object f4120f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public EnumC0076c f4121g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public List f4122h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public int f4123i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public List f4124j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public int f4125k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public byte f4126l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public int f4127m;

            /* JADX INFO: renamed from: cf.a$e$c$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static class C0075a extends gf.b {
                @Override // gf.r
                /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
                public c c(gf.e eVar, g gVar) {
                    return new c(eVar, gVar);
                }
            }

            /* JADX INFO: renamed from: cf.a$e$c$c, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public enum EnumC0076c implements j.a {
                NONE(0, 0),
                INTERNAL_TO_CLASS_ID(1, 1),
                DESC_TO_CLASS_ID(2, 2);


                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public static j.b f4138e = new C0077a();

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final int f4140a;

                /* JADX INFO: renamed from: cf.a$e$c$c$a, reason: collision with other inner class name */
                /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
                public static class C0077a implements j.b {
                    @Override // gf.j.b
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public EnumC0076c a(int i10) {
                        return EnumC0076c.a(i10);
                    }
                }

                EnumC0076c(int i10, int i11) {
                    this.f4140a = i11;
                }

                public static EnumC0076c a(int i10) {
                    if (i10 == 0) {
                        return NONE;
                    }
                    if (i10 == 1) {
                        return INTERNAL_TO_CLASS_ID;
                    }
                    if (i10 != 2) {
                        return null;
                    }
                    return DESC_TO_CLASS_ID;
                }

                @Override // gf.j.a
                public final int d() {
                    return this.f4140a;
                }
            }

            static {
                c cVar = new c(true);
                f4114n = cVar;
                cVar.Q();
            }

            public static c C() {
                return f4114n;
            }

            private void Q() {
                this.f4118d = 1;
                this.f4119e = 0;
                this.f4120f = "";
                this.f4121g = EnumC0076c.NONE;
                List list = Collections.EMPTY_LIST;
                this.f4122h = list;
                this.f4124j = list;
            }

            public static b R() {
                return b.p();
            }

            public static b S(c cVar) {
                return R().j(cVar);
            }

            public EnumC0076c D() {
                return this.f4121g;
            }

            public int E() {
                return this.f4119e;
            }

            public int F() {
                return this.f4118d;
            }

            public int G() {
                return this.f4124j.size();
            }

            public List H() {
                return this.f4124j;
            }

            public String I() {
                Object obj = this.f4120f;
                if (obj instanceof String) {
                    return (String) obj;
                }
                gf.d dVar = (gf.d) obj;
                String strL = dVar.L();
                if (dVar.u()) {
                    this.f4120f = strL;
                }
                return strL;
            }

            public gf.d J() {
                Object obj = this.f4120f;
                if (!(obj instanceof String)) {
                    return (gf.d) obj;
                }
                gf.d dVarG = gf.d.g((String) obj);
                this.f4120f = dVarG;
                return dVarG;
            }

            public int K() {
                return this.f4122h.size();
            }

            public List L() {
                return this.f4122h;
            }

            public boolean M() {
                return (this.f4117c & 8) == 8;
            }

            public boolean N() {
                return (this.f4117c & 2) == 2;
            }

            public boolean O() {
                return (this.f4117c & 1) == 1;
            }

            public boolean P() {
                return (this.f4117c & 4) == 4;
            }

            @Override // gf.p
            /* JADX INFO: renamed from: T, reason: merged with bridge method [inline-methods] */
            public b c() {
                return R();
            }

            @Override // gf.p
            /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
            public b f() {
                return S(this);
            }

            @Override // gf.p
            public int b() {
                int i10 = this.f4127m;
                if (i10 != -1) {
                    return i10;
                }
                int iO = (this.f4117c & 1) == 1 ? f.o(1, this.f4118d) : 0;
                if ((this.f4117c & 2) == 2) {
                    iO += f.o(2, this.f4119e);
                }
                if ((this.f4117c & 8) == 8) {
                    iO += f.h(3, this.f4121g.d());
                }
                int iP = 0;
                for (int i11 = 0; i11 < this.f4122h.size(); i11++) {
                    iP += f.p(((Integer) this.f4122h.get(i11)).intValue());
                }
                int iP2 = iO + iP;
                if (!L().isEmpty()) {
                    iP2 = iP2 + 1 + f.p(iP);
                }
                this.f4123i = iP;
                int iP3 = 0;
                for (int i12 = 0; i12 < this.f4124j.size(); i12++) {
                    iP3 += f.p(((Integer) this.f4124j.get(i12)).intValue());
                }
                int iD = iP2 + iP3;
                if (!H().isEmpty()) {
                    iD = iD + 1 + f.p(iP3);
                }
                this.f4125k = iP3;
                if ((this.f4117c & 4) == 4) {
                    iD += f.d(6, J());
                }
                int size = iD + this.f4116b.size();
                this.f4127m = size;
                return size;
            }

            @Override // gf.q
            public final boolean d() {
                byte b10 = this.f4126l;
                if (b10 == 1) {
                    return true;
                }
                if (b10 == 0) {
                    return false;
                }
                this.f4126l = (byte) 1;
                return true;
            }

            @Override // gf.p
            public void g(f fVar) throws IOException {
                b();
                if ((this.f4117c & 1) == 1) {
                    fVar.Z(1, this.f4118d);
                }
                if ((this.f4117c & 2) == 2) {
                    fVar.Z(2, this.f4119e);
                }
                if ((this.f4117c & 8) == 8) {
                    fVar.R(3, this.f4121g.d());
                }
                if (L().size() > 0) {
                    fVar.n0(34);
                    fVar.n0(this.f4123i);
                }
                for (int i10 = 0; i10 < this.f4122h.size(); i10++) {
                    fVar.a0(((Integer) this.f4122h.get(i10)).intValue());
                }
                if (H().size() > 0) {
                    fVar.n0(42);
                    fVar.n0(this.f4125k);
                }
                for (int i11 = 0; i11 < this.f4124j.size(); i11++) {
                    fVar.a0(((Integer) this.f4124j.get(i11)).intValue());
                }
                if ((this.f4117c & 4) == 4) {
                    fVar.N(6, J());
                }
                fVar.h0(this.f4116b);
            }

            public c(i.b bVar) {
                super(bVar);
                this.f4123i = -1;
                this.f4125k = -1;
                this.f4126l = (byte) -1;
                this.f4127m = -1;
                this.f4116b = bVar.i();
            }

            public c(boolean z10) {
                this.f4123i = -1;
                this.f4125k = -1;
                this.f4126l = (byte) -1;
                this.f4127m = -1;
                this.f4116b = gf.d.f10630a;
            }

            public c(gf.e eVar, g gVar) {
                this.f4123i = -1;
                this.f4125k = -1;
                this.f4126l = (byte) -1;
                this.f4127m = -1;
                Q();
                d.b bVarV = gf.d.v();
                f fVarI = f.I(bVarV, 1);
                boolean z10 = false;
                int i10 = 0;
                while (!z10) {
                    try {
                        try {
                            try {
                                int iJ = eVar.J();
                                if (iJ != 0) {
                                    if (iJ == 8) {
                                        this.f4117c |= 1;
                                        this.f4118d = eVar.r();
                                    } else if (iJ == 16) {
                                        this.f4117c |= 2;
                                        this.f4119e = eVar.r();
                                    } else if (iJ == 24) {
                                        int iM = eVar.m();
                                        EnumC0076c enumC0076cA = EnumC0076c.a(iM);
                                        if (enumC0076cA == null) {
                                            fVarI.n0(iJ);
                                            fVarI.n0(iM);
                                        } else {
                                            this.f4117c |= 8;
                                            this.f4121g = enumC0076cA;
                                        }
                                    } else if (iJ == 32) {
                                        if ((i10 & 16) != 16) {
                                            this.f4122h = new ArrayList();
                                            i10 |= 16;
                                        }
                                        this.f4122h.add(Integer.valueOf(eVar.r()));
                                    } else if (iJ == 34) {
                                        int i11 = eVar.i(eVar.z());
                                        if ((i10 & 16) != 16 && eVar.e() > 0) {
                                            this.f4122h = new ArrayList();
                                            i10 |= 16;
                                        }
                                        while (eVar.e() > 0) {
                                            this.f4122h.add(Integer.valueOf(eVar.r()));
                                        }
                                        eVar.h(i11);
                                    } else if (iJ == 40) {
                                        if ((i10 & 32) != 32) {
                                            this.f4124j = new ArrayList();
                                            i10 |= 32;
                                        }
                                        this.f4124j.add(Integer.valueOf(eVar.r()));
                                    } else if (iJ == 42) {
                                        int i12 = eVar.i(eVar.z());
                                        if ((i10 & 32) != 32 && eVar.e() > 0) {
                                            this.f4124j = new ArrayList();
                                            i10 |= 32;
                                        }
                                        while (eVar.e() > 0) {
                                            this.f4124j.add(Integer.valueOf(eVar.r()));
                                        }
                                        eVar.h(i12);
                                    } else if (iJ != 50) {
                                        if (!o(eVar, fVarI, gVar, iJ)) {
                                        }
                                    } else {
                                        gf.d dVarK = eVar.k();
                                        this.f4117c |= 4;
                                        this.f4120f = dVarK;
                                    }
                                }
                                z10 = true;
                            } catch (k e10) {
                                throw e10.i(this);
                            }
                        } catch (IOException e11) {
                            throw new k(e11.getMessage()).i(this);
                        }
                    } catch (Throwable th) {
                        if ((i10 & 16) == 16) {
                            this.f4122h = Collections.unmodifiableList(this.f4122h);
                        }
                        if ((i10 & 32) == 32) {
                            this.f4124j = Collections.unmodifiableList(this.f4124j);
                        }
                        try {
                            fVarI.H();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f4116b = bVarV.u();
                            throw th2;
                        }
                        this.f4116b = bVarV.u();
                        l();
                        throw th;
                    }
                }
                if ((i10 & 16) == 16) {
                    this.f4122h = Collections.unmodifiableList(this.f4122h);
                }
                if ((i10 & 32) == 32) {
                    this.f4124j = Collections.unmodifiableList(this.f4124j);
                }
                try {
                    fVarI.H();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.f4116b = bVarV.u();
                    throw th3;
                }
                this.f4116b = bVarV.u();
                l();
            }

            /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
            public static final class b extends i.b implements q {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public int f4128b;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public int f4130d;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public List f4133g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                public List f4134h;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public int f4129c = 1;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public Object f4131e = "";

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                public EnumC0076c f4132f = EnumC0076c.NONE;

                public b() {
                    List list = Collections.EMPTY_LIST;
                    this.f4133g = list;
                    this.f4134h = list;
                    s();
                }

                public static b p() {
                    return new b();
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
                    int i10 = this.f4128b;
                    int i11 = (i10 & 1) != 1 ? 0 : 1;
                    cVar.f4118d = this.f4129c;
                    if ((i10 & 2) == 2) {
                        i11 |= 2;
                    }
                    cVar.f4119e = this.f4130d;
                    if ((i10 & 4) == 4) {
                        i11 |= 4;
                    }
                    cVar.f4120f = this.f4131e;
                    if ((i10 & 8) == 8) {
                        i11 |= 8;
                    }
                    cVar.f4121g = this.f4132f;
                    if ((this.f4128b & 16) == 16) {
                        this.f4133g = Collections.unmodifiableList(this.f4133g);
                        this.f4128b &= -17;
                    }
                    cVar.f4122h = this.f4133g;
                    if ((this.f4128b & 32) == 32) {
                        this.f4134h = Collections.unmodifiableList(this.f4134h);
                        this.f4128b &= -33;
                    }
                    cVar.f4124j = this.f4134h;
                    cVar.f4117c = i11;
                    return cVar;
                }

                /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
                public b clone() {
                    return p().j(n());
                }

                public final void q() {
                    if ((this.f4128b & 32) != 32) {
                        this.f4134h = new ArrayList(this.f4134h);
                        this.f4128b |= 32;
                    }
                }

                public final void r() {
                    if ((this.f4128b & 16) != 16) {
                        this.f4133g = new ArrayList(this.f4133g);
                        this.f4128b |= 16;
                    }
                }

                @Override // gf.i.b
                /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
                public b j(c cVar) {
                    if (cVar == c.C()) {
                        return this;
                    }
                    if (cVar.O()) {
                        y(cVar.F());
                    }
                    if (cVar.N()) {
                        x(cVar.E());
                    }
                    if (cVar.P()) {
                        this.f4128b |= 4;
                        this.f4131e = cVar.f4120f;
                    }
                    if (cVar.M()) {
                        w(cVar.D());
                    }
                    if (!cVar.f4122h.isEmpty()) {
                        if (this.f4133g.isEmpty()) {
                            this.f4133g = cVar.f4122h;
                            this.f4128b &= -17;
                        } else {
                            r();
                            this.f4133g.addAll(cVar.f4122h);
                        }
                    }
                    if (!cVar.f4124j.isEmpty()) {
                        if (this.f4134h.isEmpty()) {
                            this.f4134h = cVar.f4124j;
                            this.f4128b &= -33;
                        } else {
                            q();
                            this.f4134h.addAll(cVar.f4124j);
                        }
                    }
                    k(i().c(cVar.f4116b));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // gf.p.a
                /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public cf.a.e.c.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
                    /*
                        r2 = this;
                        r0 = 0
                        gf.r r1 = cf.a.e.c.f4115o     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                        java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                        cf.a$e$c r3 = (cf.a.e.c) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                        cf.a$e$c r4 = (cf.a.e.c) r4     // Catch: java.lang.Throwable -> Lf
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
                    throw new UnsupportedOperationException("Method not decompiled: cf.a.e.c.b.u(gf.e, gf.g):cf.a$e$c$b");
                }

                public b w(EnumC0076c enumC0076c) {
                    enumC0076c.getClass();
                    this.f4128b |= 8;
                    this.f4132f = enumC0076c;
                    return this;
                }

                public b x(int i10) {
                    this.f4128b |= 2;
                    this.f4130d = i10;
                    return this;
                }

                public b y(int i10) {
                    this.f4128b |= 1;
                    this.f4129c = i10;
                    return this;
                }

                private void s() {
                }
            }
        }

        public e(i.b bVar) {
            super(bVar);
            this.f4108e = -1;
            this.f4109f = (byte) -1;
            this.f4110g = -1;
            this.f4105b = bVar.i();
        }

        public e(boolean z10) {
            this.f4108e = -1;
            this.f4109f = (byte) -1;
            this.f4110g = -1;
            this.f4105b = gf.d.f10630a;
        }

        public e(gf.e eVar, g gVar) {
            this.f4108e = -1;
            this.f4109f = (byte) -1;
            this.f4110g = -1;
            z();
            d.b bVarV = gf.d.v();
            f fVarI = f.I(bVarV, 1);
            boolean z10 = false;
            int i10 = 0;
            while (!z10) {
                try {
                    try {
                        int iJ = eVar.J();
                        if (iJ != 0) {
                            if (iJ == 10) {
                                if ((i10 & 1) != 1) {
                                    this.f4106c = new ArrayList();
                                    i10 |= 1;
                                }
                                this.f4106c.add(eVar.t(c.f4115o, gVar));
                            } else if (iJ == 40) {
                                if ((i10 & 2) != 2) {
                                    this.f4107d = new ArrayList();
                                    i10 |= 2;
                                }
                                this.f4107d.add(Integer.valueOf(eVar.r()));
                            } else if (iJ != 42) {
                                if (!o(eVar, fVarI, gVar, iJ)) {
                                }
                            } else {
                                int i11 = eVar.i(eVar.z());
                                if ((i10 & 2) != 2 && eVar.e() > 0) {
                                    this.f4107d = new ArrayList();
                                    i10 |= 2;
                                }
                                while (eVar.e() > 0) {
                                    this.f4107d.add(Integer.valueOf(eVar.r()));
                                }
                                eVar.h(i11);
                            }
                        }
                        z10 = true;
                    } catch (k e10) {
                        throw e10.i(this);
                    } catch (IOException e11) {
                        throw new k(e11.getMessage()).i(this);
                    }
                } catch (Throwable th) {
                    if ((i10 & 1) == 1) {
                        this.f4106c = Collections.unmodifiableList(this.f4106c);
                    }
                    if ((i10 & 2) == 2) {
                        this.f4107d = Collections.unmodifiableList(this.f4107d);
                    }
                    try {
                        fVarI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f4105b = bVarV.u();
                        throw th2;
                    }
                    this.f4105b = bVarV.u();
                    l();
                    throw th;
                }
            }
            if ((i10 & 1) == 1) {
                this.f4106c = Collections.unmodifiableList(this.f4106c);
            }
            if ((i10 & 2) == 2) {
                this.f4107d = Collections.unmodifiableList(this.f4107d);
            }
            try {
                fVarI.H();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f4105b = bVarV.u();
                throw th3;
            }
            this.f4105b = bVarV.u();
            l();
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class b extends i.b implements q {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f4111b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public List f4112c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public List f4113d;

            public b() {
                List list = Collections.EMPTY_LIST;
                this.f4112c = list;
                this.f4113d = list;
                s();
            }

            public static b p() {
                return new b();
            }

            @Override // gf.p.a
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public e build() {
                e eVarN = n();
                if (eVarN.d()) {
                    return eVarN;
                }
                throw a.AbstractC0191a.h(eVarN);
            }

            public e n() {
                e eVar = new e(this);
                if ((this.f4111b & 1) == 1) {
                    this.f4112c = Collections.unmodifiableList(this.f4112c);
                    this.f4111b &= -2;
                }
                eVar.f4106c = this.f4112c;
                if ((this.f4111b & 2) == 2) {
                    this.f4113d = Collections.unmodifiableList(this.f4113d);
                    this.f4111b &= -3;
                }
                eVar.f4107d = this.f4113d;
                return eVar;
            }

            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return p().j(n());
            }

            public final void q() {
                if ((this.f4111b & 2) != 2) {
                    this.f4113d = new ArrayList(this.f4113d);
                    this.f4111b |= 2;
                }
            }

            public final void r() {
                if ((this.f4111b & 1) != 1) {
                    this.f4112c = new ArrayList(this.f4112c);
                    this.f4111b |= 1;
                }
            }

            @Override // gf.i.b
            /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
            public b j(e eVar) {
                if (eVar == e.w()) {
                    return this;
                }
                if (!eVar.f4106c.isEmpty()) {
                    if (this.f4112c.isEmpty()) {
                        this.f4112c = eVar.f4106c;
                        this.f4111b &= -2;
                    } else {
                        r();
                        this.f4112c.addAll(eVar.f4106c);
                    }
                }
                if (!eVar.f4107d.isEmpty()) {
                    if (this.f4113d.isEmpty()) {
                        this.f4113d = eVar.f4107d;
                        this.f4111b &= -3;
                    } else {
                        q();
                        this.f4113d.addAll(eVar.f4107d);
                    }
                }
                k(i().c(eVar.f4105b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // gf.p.a
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public cf.a.e.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    gf.r r1 = cf.a.e.f4104i     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                    cf.a$e r3 = (cf.a.e) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                    cf.a$e r4 = (cf.a.e) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: cf.a.e.b.u(gf.e, gf.g):cf.a$e$b");
            }

            private void s() {
            }
        }
    }

    static {
        ze.d dVarH = ze.d.H();
        c cVarV = c.v();
        c cVarV2 = c.v();
        y.b bVar = y.b.f10746m;
        f4050a = i.n(dVarH, cVarV, cVarV2, null, 100, bVar, c.class);
        f4051b = i.n(ze.i.a0(), c.v(), c.v(), null, 100, bVar, c.class);
        ze.i iVarA0 = ze.i.a0();
        y.b bVar2 = y.b.f10740g;
        f4052c = i.n(iVarA0, 0, null, null, 101, bVar2, Integer.class);
        f4053d = i.n(n.Y(), d.y(), d.y(), null, 100, bVar, d.class);
        f4054e = i.n(n.Y(), 0, null, null, 101, bVar2, Integer.class);
        f4055f = i.m(ze.q.X(), ze.b.z(), null, 100, bVar, false, ze.b.class);
        f4056g = i.n(ze.q.X(), Boolean.FALSE, null, null, 101, y.b.f10743j, Boolean.class);
        f4057h = i.m(s.K(), ze.b.z(), null, 100, bVar, false, ze.b.class);
        f4058i = i.n(ze.c.y0(), 0, null, null, 101, bVar2, Integer.class);
        f4059j = i.m(ze.c.y0(), n.Y(), null, 102, bVar, false, n.class);
        f4060k = i.n(ze.c.y0(), 0, null, null, 103, bVar2, Integer.class);
        f4061l = i.n(ze.c.y0(), 0, null, null, 104, bVar2, Integer.class);
        f4062m = i.n(l.K(), 0, null, null, 101, bVar2, Integer.class);
        f4063n = i.m(l.K(), n.Y(), null, 102, bVar, false, n.class);
    }

    public static void a(g gVar) {
        gVar.a(f4050a);
        gVar.a(f4051b);
        gVar.a(f4052c);
        gVar.a(f4053d);
        gVar.a(f4054e);
        gVar.a(f4055f);
        gVar.a(f4056g);
        gVar.a(f4057h);
        gVar.a(f4058i);
        gVar.a(f4059j);
        gVar.a(f4060k);
        gVar.a(f4061l);
        gVar.a(f4062m);
        gVar.a(f4063n);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends i implements q {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f4064h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static r f4065i = new C0070a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final gf.d f4066b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4067c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4068d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4069e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte f4070f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f4071g;

        /* JADX INFO: renamed from: cf.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class C0070a extends gf.b {
            @Override // gf.r
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public b c(gf.e eVar, g gVar) {
                return new b(eVar, gVar);
            }
        }

        static {
            b bVar = new b(true);
            f4064h = bVar;
            bVar.A();
        }

        private void A() {
            this.f4068d = 0;
            this.f4069e = 0;
        }

        public static C0071b B() {
            return C0071b.p();
        }

        public static C0071b C(b bVar) {
            return B().j(bVar);
        }

        public static b v() {
            return f4064h;
        }

        @Override // gf.p
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public C0071b c() {
            return B();
        }

        @Override // gf.p
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public C0071b f() {
            return C(this);
        }

        @Override // gf.p
        public int b() {
            int i10 = this.f4071g;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.f4067c & 1) == 1 ? f.o(1, this.f4068d) : 0;
            if ((this.f4067c & 2) == 2) {
                iO += f.o(2, this.f4069e);
            }
            int size = iO + this.f4066b.size();
            this.f4071g = size;
            return size;
        }

        @Override // gf.q
        public final boolean d() {
            byte b10 = this.f4070f;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.f4070f = (byte) 1;
            return true;
        }

        @Override // gf.p
        public void g(f fVar) throws IOException {
            b();
            if ((this.f4067c & 1) == 1) {
                fVar.Z(1, this.f4068d);
            }
            if ((this.f4067c & 2) == 2) {
                fVar.Z(2, this.f4069e);
            }
            fVar.h0(this.f4066b);
        }

        public int w() {
            return this.f4069e;
        }

        public int x() {
            return this.f4068d;
        }

        public boolean y() {
            return (this.f4067c & 2) == 2;
        }

        public boolean z() {
            return (this.f4067c & 1) == 1;
        }

        public b(i.b bVar) {
            super(bVar);
            this.f4070f = (byte) -1;
            this.f4071g = -1;
            this.f4066b = bVar.i();
        }

        public b(boolean z10) {
            this.f4070f = (byte) -1;
            this.f4071g = -1;
            this.f4066b = gf.d.f10630a;
        }

        public b(gf.e eVar, g gVar) {
            this.f4070f = (byte) -1;
            this.f4071g = -1;
            A();
            d.b bVarV = gf.d.v();
            f fVarI = f.I(bVarV, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int iJ = eVar.J();
                        if (iJ != 0) {
                            if (iJ == 8) {
                                this.f4067c |= 1;
                                this.f4068d = eVar.r();
                            } else if (iJ != 16) {
                                if (!o(eVar, fVarI, gVar, iJ)) {
                                }
                            } else {
                                this.f4067c |= 2;
                                this.f4069e = eVar.r();
                            }
                        }
                        z10 = true;
                    } catch (Throwable th) {
                        try {
                            fVarI.H();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f4066b = bVarV.u();
                            throw th2;
                        }
                        this.f4066b = bVarV.u();
                        l();
                        throw th;
                    }
                } catch (k e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new k(e11.getMessage()).i(this);
                }
            }
            try {
                fVarI.H();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f4066b = bVarV.u();
                throw th3;
            }
            this.f4066b = bVarV.u();
            l();
        }

        /* JADX INFO: renamed from: cf.a$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0071b extends i.b implements q {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f4072b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f4073c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f4074d;

            public C0071b() {
                q();
            }

            public static C0071b p() {
                return new C0071b();
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
                int i10 = this.f4072b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                bVar.f4068d = this.f4073c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                bVar.f4069e = this.f4074d;
                bVar.f4067c = i11;
                return bVar;
            }

            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public C0071b clone() {
                return p().j(n());
            }

            @Override // gf.i.b
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            public C0071b j(b bVar) {
                if (bVar == b.v()) {
                    return this;
                }
                if (bVar.z()) {
                    v(bVar.x());
                }
                if (bVar.y()) {
                    t(bVar.w());
                }
                k(i().c(bVar.f4066b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // gf.p.a
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public cf.a.b.C0071b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    gf.r r1 = cf.a.b.f4065i     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                    cf.a$b r3 = (cf.a.b) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                    cf.a$b r4 = (cf.a.b) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: cf.a.b.C0071b.u(gf.e, gf.g):cf.a$b$b");
            }

            public C0071b t(int i10) {
                this.f4072b |= 2;
                this.f4074d = i10;
                return this;
            }

            public C0071b v(int i10) {
                this.f4072b |= 1;
                this.f4073c = i10;
                return this;
            }

            private void q() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends i implements q {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f4075h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static r f4076i = new C0072a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final gf.d f4077b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4078c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f4079d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f4080e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte f4081f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f4082g;

        /* JADX INFO: renamed from: cf.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class C0072a extends gf.b {
            @Override // gf.r
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public c c(gf.e eVar, g gVar) {
                return new c(eVar, gVar);
            }
        }

        static {
            c cVar = new c(true);
            f4075h = cVar;
            cVar.A();
        }

        private void A() {
            this.f4079d = 0;
            this.f4080e = 0;
        }

        public static b B() {
            return b.p();
        }

        public static b C(c cVar) {
            return B().j(cVar);
        }

        public static c v() {
            return f4075h;
        }

        @Override // gf.p
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public b c() {
            return B();
        }

        @Override // gf.p
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public b f() {
            return C(this);
        }

        @Override // gf.p
        public int b() {
            int i10 = this.f4082g;
            if (i10 != -1) {
                return i10;
            }
            int iO = (this.f4078c & 1) == 1 ? f.o(1, this.f4079d) : 0;
            if ((this.f4078c & 2) == 2) {
                iO += f.o(2, this.f4080e);
            }
            int size = iO + this.f4077b.size();
            this.f4082g = size;
            return size;
        }

        @Override // gf.q
        public final boolean d() {
            byte b10 = this.f4081f;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.f4081f = (byte) 1;
            return true;
        }

        @Override // gf.p
        public void g(f fVar) throws IOException {
            b();
            if ((this.f4078c & 1) == 1) {
                fVar.Z(1, this.f4079d);
            }
            if ((this.f4078c & 2) == 2) {
                fVar.Z(2, this.f4080e);
            }
            fVar.h0(this.f4077b);
        }

        public int w() {
            return this.f4080e;
        }

        public int x() {
            return this.f4079d;
        }

        public boolean y() {
            return (this.f4078c & 2) == 2;
        }

        public boolean z() {
            return (this.f4078c & 1) == 1;
        }

        public c(i.b bVar) {
            super(bVar);
            this.f4081f = (byte) -1;
            this.f4082g = -1;
            this.f4077b = bVar.i();
        }

        public c(boolean z10) {
            this.f4081f = (byte) -1;
            this.f4082g = -1;
            this.f4077b = gf.d.f10630a;
        }

        public c(gf.e eVar, g gVar) {
            this.f4081f = (byte) -1;
            this.f4082g = -1;
            A();
            d.b bVarV = gf.d.v();
            f fVarI = f.I(bVarV, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        int iJ = eVar.J();
                        if (iJ != 0) {
                            if (iJ == 8) {
                                this.f4078c |= 1;
                                this.f4079d = eVar.r();
                            } else if (iJ != 16) {
                                if (!o(eVar, fVarI, gVar, iJ)) {
                                }
                            } else {
                                this.f4078c |= 2;
                                this.f4080e = eVar.r();
                            }
                        }
                        z10 = true;
                    } catch (Throwable th) {
                        try {
                            fVarI.H();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f4077b = bVarV.u();
                            throw th2;
                        }
                        this.f4077b = bVarV.u();
                        l();
                        throw th;
                    }
                } catch (k e10) {
                    throw e10.i(this);
                } catch (IOException e11) {
                    throw new k(e11.getMessage()).i(this);
                }
            }
            try {
                fVarI.H();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f4077b = bVarV.u();
                throw th3;
            }
            this.f4077b = bVarV.u();
            l();
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class b extends i.b implements q {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f4083b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f4084c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f4085d;

            public b() {
                q();
            }

            public static b p() {
                return new b();
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
                int i10 = this.f4083b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                cVar.f4079d = this.f4084c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                cVar.f4080e = this.f4085d;
                cVar.f4078c = i11;
                return cVar;
            }

            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return p().j(n());
            }

            @Override // gf.i.b
            /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
            public b j(c cVar) {
                if (cVar == c.v()) {
                    return this;
                }
                if (cVar.z()) {
                    v(cVar.x());
                }
                if (cVar.y()) {
                    t(cVar.w());
                }
                k(i().c(cVar.f4077b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // gf.p.a
            /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public cf.a.c.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    gf.r r1 = cf.a.c.f4076i     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                    cf.a$c r3 = (cf.a.c) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                    cf.a$c r4 = (cf.a.c) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: cf.a.c.b.u(gf.e, gf.g):cf.a$c$b");
            }

            public b t(int i10) {
                this.f4083b |= 2;
                this.f4085d = i10;
                return this;
            }

            public b v(int i10) {
                this.f4083b |= 1;
                this.f4084c = i10;
                return this;
            }

            private void q() {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends i implements q {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final d f4086k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static r f4087l = new C0073a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final gf.d f4088b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f4089c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b f4090d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f4091e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c f4092f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public c f4093g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public c f4094h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte f4095i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f4096j;

        /* JADX INFO: renamed from: cf.a$d$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class C0073a extends gf.b {
            @Override // gf.r
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public d c(gf.e eVar, g gVar) {
                return new d(eVar, gVar);
            }
        }

        static {
            d dVar = new d(true);
            f4086k = dVar;
            dVar.J();
        }

        private void J() {
            this.f4090d = b.v();
            this.f4091e = c.v();
            this.f4092f = c.v();
            this.f4093g = c.v();
            this.f4094h = c.v();
        }

        public static b K() {
            return b.p();
        }

        public static b L(d dVar) {
            return K().j(dVar);
        }

        public static d y() {
            return f4086k;
        }

        public b A() {
            return this.f4090d;
        }

        public c B() {
            return this.f4092f;
        }

        public c C() {
            return this.f4093g;
        }

        public c D() {
            return this.f4091e;
        }

        public boolean E() {
            return (this.f4089c & 16) == 16;
        }

        public boolean F() {
            return (this.f4089c & 1) == 1;
        }

        public boolean G() {
            return (this.f4089c & 4) == 4;
        }

        public boolean H() {
            return (this.f4089c & 8) == 8;
        }

        public boolean I() {
            return (this.f4089c & 2) == 2;
        }

        @Override // gf.p
        /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
        public b c() {
            return K();
        }

        @Override // gf.p
        /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
        public b f() {
            return L(this);
        }

        @Override // gf.p
        public int b() {
            int i10 = this.f4096j;
            if (i10 != -1) {
                return i10;
            }
            int iR = (this.f4089c & 1) == 1 ? f.r(1, this.f4090d) : 0;
            if ((this.f4089c & 2) == 2) {
                iR += f.r(2, this.f4091e);
            }
            if ((this.f4089c & 4) == 4) {
                iR += f.r(3, this.f4092f);
            }
            if ((this.f4089c & 8) == 8) {
                iR += f.r(4, this.f4093g);
            }
            if ((this.f4089c & 16) == 16) {
                iR += f.r(5, this.f4094h);
            }
            int size = iR + this.f4088b.size();
            this.f4096j = size;
            return size;
        }

        @Override // gf.q
        public final boolean d() {
            byte b10 = this.f4095i;
            if (b10 == 1) {
                return true;
            }
            if (b10 == 0) {
                return false;
            }
            this.f4095i = (byte) 1;
            return true;
        }

        @Override // gf.p
        public void g(f fVar) throws IOException {
            b();
            if ((this.f4089c & 1) == 1) {
                fVar.c0(1, this.f4090d);
            }
            if ((this.f4089c & 2) == 2) {
                fVar.c0(2, this.f4091e);
            }
            if ((this.f4089c & 4) == 4) {
                fVar.c0(3, this.f4092f);
            }
            if ((this.f4089c & 8) == 8) {
                fVar.c0(4, this.f4093g);
            }
            if ((this.f4089c & 16) == 16) {
                fVar.c0(5, this.f4094h);
            }
            fVar.h0(this.f4088b);
        }

        public c z() {
            return this.f4094h;
        }

        public d(i.b bVar) {
            super(bVar);
            this.f4095i = (byte) -1;
            this.f4096j = -1;
            this.f4088b = bVar.i();
        }

        public d(boolean z10) {
            this.f4095i = (byte) -1;
            this.f4096j = -1;
            this.f4088b = gf.d.f10630a;
        }

        public d(gf.e eVar, g gVar) {
            this.f4095i = (byte) -1;
            this.f4096j = -1;
            J();
            d.b bVarV = gf.d.v();
            f fVarI = f.I(bVarV, 1);
            boolean z10 = false;
            while (!z10) {
                try {
                    try {
                        try {
                            int iJ = eVar.J();
                            if (iJ != 0) {
                                if (iJ == 10) {
                                    b.C0071b c0071bF = (this.f4089c & 1) == 1 ? this.f4090d.f() : null;
                                    b bVar = (b) eVar.t(b.f4065i, gVar);
                                    this.f4090d = bVar;
                                    if (c0071bF != null) {
                                        c0071bF.j(bVar);
                                        this.f4090d = c0071bF.n();
                                    }
                                    this.f4089c |= 1;
                                } else if (iJ == 18) {
                                    c.b bVarF = (this.f4089c & 2) == 2 ? this.f4091e.f() : null;
                                    c cVar = (c) eVar.t(c.f4076i, gVar);
                                    this.f4091e = cVar;
                                    if (bVarF != null) {
                                        bVarF.j(cVar);
                                        this.f4091e = bVarF.n();
                                    }
                                    this.f4089c |= 2;
                                } else if (iJ == 26) {
                                    c.b bVarF2 = (this.f4089c & 4) == 4 ? this.f4092f.f() : null;
                                    c cVar2 = (c) eVar.t(c.f4076i, gVar);
                                    this.f4092f = cVar2;
                                    if (bVarF2 != null) {
                                        bVarF2.j(cVar2);
                                        this.f4092f = bVarF2.n();
                                    }
                                    this.f4089c |= 4;
                                } else if (iJ == 34) {
                                    c.b bVarF3 = (this.f4089c & 8) == 8 ? this.f4093g.f() : null;
                                    c cVar3 = (c) eVar.t(c.f4076i, gVar);
                                    this.f4093g = cVar3;
                                    if (bVarF3 != null) {
                                        bVarF3.j(cVar3);
                                        this.f4093g = bVarF3.n();
                                    }
                                    this.f4089c |= 8;
                                } else if (iJ != 42) {
                                    if (!o(eVar, fVarI, gVar, iJ)) {
                                    }
                                } else {
                                    c.b bVarF4 = (this.f4089c & 16) == 16 ? this.f4094h.f() : null;
                                    c cVar4 = (c) eVar.t(c.f4076i, gVar);
                                    this.f4094h = cVar4;
                                    if (bVarF4 != null) {
                                        bVarF4.j(cVar4);
                                        this.f4094h = bVarF4.n();
                                    }
                                    this.f4089c |= 16;
                                }
                            }
                            z10 = true;
                        } catch (k e10) {
                            throw e10.i(this);
                        }
                    } catch (IOException e11) {
                        throw new k(e11.getMessage()).i(this);
                    }
                } catch (Throwable th) {
                    try {
                        fVarI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f4088b = bVarV.u();
                        throw th2;
                    }
                    this.f4088b = bVarV.u();
                    l();
                    throw th;
                }
            }
            try {
                fVarI.H();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f4088b = bVarV.u();
                throw th3;
            }
            this.f4088b = bVarV.u();
            l();
        }

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class b extends i.b implements q {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f4097b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public b f4098c = b.v();

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public c f4099d = c.v();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public c f4100e = c.v();

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public c f4101f = c.v();

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public c f4102g = c.v();

            public b() {
                q();
            }

            public static b p() {
                return new b();
            }

            @Override // gf.p.a
            /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
            public d build() {
                d dVarN = n();
                if (dVarN.d()) {
                    return dVarN;
                }
                throw a.AbstractC0191a.h(dVarN);
            }

            public d n() {
                d dVar = new d(this);
                int i10 = this.f4097b;
                int i11 = (i10 & 1) != 1 ? 0 : 1;
                dVar.f4090d = this.f4098c;
                if ((i10 & 2) == 2) {
                    i11 |= 2;
                }
                dVar.f4091e = this.f4099d;
                if ((i10 & 4) == 4) {
                    i11 |= 4;
                }
                dVar.f4092f = this.f4100e;
                if ((i10 & 8) == 8) {
                    i11 |= 8;
                }
                dVar.f4093g = this.f4101f;
                if ((i10 & 16) == 16) {
                    i11 |= 16;
                }
                dVar.f4094h = this.f4102g;
                dVar.f4089c = i11;
                return dVar;
            }

            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return p().j(n());
            }

            public b r(c cVar) {
                if ((this.f4097b & 16) != 16 || this.f4102g == c.v()) {
                    this.f4102g = cVar;
                } else {
                    this.f4102g = c.C(this.f4102g).j(cVar).n();
                }
                this.f4097b |= 16;
                return this;
            }

            public b s(b bVar) {
                if ((this.f4097b & 1) != 1 || this.f4098c == b.v()) {
                    this.f4098c = bVar;
                } else {
                    this.f4098c = b.C(this.f4098c).j(bVar).n();
                }
                this.f4097b |= 1;
                return this;
            }

            @Override // gf.i.b
            /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
            public b j(d dVar) {
                if (dVar == d.y()) {
                    return this;
                }
                if (dVar.F()) {
                    s(dVar.A());
                }
                if (dVar.I()) {
                    y(dVar.D());
                }
                if (dVar.G()) {
                    w(dVar.B());
                }
                if (dVar.H()) {
                    x(dVar.C());
                }
                if (dVar.E()) {
                    r(dVar.z());
                }
                k(i().c(dVar.f4088b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // gf.p.a
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public cf.a.d.b u(gf.e r3, gf.g r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    gf.r r1 = cf.a.d.f4087l     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                    java.lang.Object r3 = r1.c(r3, r4)     // Catch: java.lang.Throwable -> Lf gf.k -> L11
                    cf.a$d r3 = (cf.a.d) r3     // Catch: java.lang.Throwable -> Lf gf.k -> L11
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
                    cf.a$d r4 = (cf.a.d) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: cf.a.d.b.u(gf.e, gf.g):cf.a$d$b");
            }

            public b w(c cVar) {
                if ((this.f4097b & 4) != 4 || this.f4100e == c.v()) {
                    this.f4100e = cVar;
                } else {
                    this.f4100e = c.C(this.f4100e).j(cVar).n();
                }
                this.f4097b |= 4;
                return this;
            }

            public b x(c cVar) {
                if ((this.f4097b & 8) != 8 || this.f4101f == c.v()) {
                    this.f4101f = cVar;
                } else {
                    this.f4101f = c.C(this.f4101f).j(cVar).n();
                }
                this.f4097b |= 8;
                return this;
            }

            public b y(c cVar) {
                if ((this.f4097b & 2) != 2 || this.f4099d == c.v()) {
                    this.f4099d = cVar;
                } else {
                    this.f4099d = c.C(this.f4099d).j(cVar).n();
                }
                this.f4097b |= 2;
                return this;
            }

            private void q() {
            }
        }
    }
}
