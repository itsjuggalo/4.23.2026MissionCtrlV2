package o6;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import l6.i;
import l6.l;
import l6.n;
import l6.s;
import s6.AbstractC2714a;
import s6.AbstractC2715b;
import s6.AbstractC2717d;
import s6.AbstractC2722i;
import s6.AbstractC2723j;
import s6.C2718e;
import s6.C2719f;
import s6.C2720g;
import s6.C2724k;
import s6.p;
import s6.q;
import s6.r;
import s6.y;

/* JADX INFO: renamed from: o6.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2492a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC2722i.f f22002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AbstractC2722i.f f22003b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AbstractC2722i.f f22004c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AbstractC2722i.f f22005d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final AbstractC2722i.f f22006e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final AbstractC2722i.f f22007f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final AbstractC2722i.f f22008g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final AbstractC2722i.f f22009h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final AbstractC2722i.f f22010i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final AbstractC2722i.f f22011j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final AbstractC2722i.f f22012k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final AbstractC2722i.f f22013l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final AbstractC2722i.f f22014m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final AbstractC2722i.f f22015n;

    /* JADX INFO: renamed from: o6.a$e */
    public static final class e extends AbstractC2722i implements q {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final e f22055h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static r f22056i = new C0369a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC2717d f22057b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f22058c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f22059d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f22060e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte f22061f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f22062g;

        /* JADX INFO: renamed from: o6.a$e$a, reason: collision with other inner class name */
        public static class C0369a extends AbstractC2715b {
            @Override // s6.r
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public e b(C2718e c2718e, C2720g c2720g) {
                return new e(c2718e, c2720g);
            }
        }

        static {
            e eVar = new e(true);
            f22055h = eVar;
            eVar.A();
        }

        public e(C2718e c2718e, C2720g c2720g) {
            List list;
            Object objT;
            this.f22060e = -1;
            this.f22061f = (byte) -1;
            this.f22062g = -1;
            A();
            AbstractC2717d.b bVarK = AbstractC2717d.K();
            C2719f c2719fI = C2719f.I(bVarK, 1);
            boolean z7 = false;
            int i8 = 0;
            while (!z7) {
                try {
                    try {
                        int iJ = c2718e.J();
                        if (iJ != 0) {
                            if (iJ == 10) {
                                if ((i8 & 1) != 1) {
                                    this.f22058c = new ArrayList();
                                    i8 |= 1;
                                }
                                list = this.f22058c;
                                objT = c2718e.t(c.f22067o, c2720g);
                            } else if (iJ == 40) {
                                if ((i8 & 2) != 2) {
                                    this.f22059d = new ArrayList();
                                    i8 |= 2;
                                }
                                list = this.f22059d;
                                objT = Integer.valueOf(c2718e.r());
                            } else if (iJ == 42) {
                                int i9 = c2718e.i(c2718e.z());
                                if ((i8 & 2) != 2 && c2718e.e() > 0) {
                                    this.f22059d = new ArrayList();
                                    i8 |= 2;
                                }
                                while (c2718e.e() > 0) {
                                    this.f22059d.add(Integer.valueOf(c2718e.r()));
                                }
                                c2718e.h(i9);
                            } else if (!q(c2718e, c2719fI, c2720g, iJ)) {
                            }
                            list.add(objT);
                        }
                        z7 = true;
                    } catch (C2724k e8) {
                        throw e8.i(this);
                    } catch (IOException e9) {
                        throw new C2724k(e9.getMessage()).i(this);
                    }
                } catch (Throwable th) {
                    if ((i8 & 1) == 1) {
                        this.f22058c = Collections.unmodifiableList(this.f22058c);
                    }
                    if ((i8 & 2) == 2) {
                        this.f22059d = Collections.unmodifiableList(this.f22059d);
                    }
                    try {
                        c2719fI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f22057b = bVarK.n();
                        throw th2;
                    }
                    this.f22057b = bVarK.n();
                    m();
                    throw th;
                }
            }
            if ((i8 & 1) == 1) {
                this.f22058c = Collections.unmodifiableList(this.f22058c);
            }
            if ((i8 & 2) == 2) {
                this.f22059d = Collections.unmodifiableList(this.f22059d);
            }
            try {
                c2719fI.H();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f22057b = bVarK.n();
                throw th3;
            }
            this.f22057b = bVarK.n();
            m();
        }

        private void A() {
            this.f22058c = Collections.emptyList();
            this.f22059d = Collections.emptyList();
        }

        public static b B() {
            return b.r();
        }

        public static b C(e eVar) {
            return B().k(eVar);
        }

        public static e E(InputStream inputStream, C2720g c2720g) {
            return (e) f22056i.a(inputStream, c2720g);
        }

        public static e x() {
            return f22055h;
        }

        @Override // s6.p
        /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
        public b d() {
            return B();
        }

        @Override // s6.p
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public b g() {
            return C(this);
        }

        @Override // s6.p
        public int c() {
            int i8 = this.f22062g;
            if (i8 != -1) {
                return i8;
            }
            int iR = 0;
            for (int i9 = 0; i9 < this.f22058c.size(); i9++) {
                iR += C2719f.r(1, (p) this.f22058c.get(i9));
            }
            int iP = 0;
            for (int i10 = 0; i10 < this.f22059d.size(); i10++) {
                iP += C2719f.p(((Integer) this.f22059d.get(i10)).intValue());
            }
            int iP2 = iR + iP;
            if (!y().isEmpty()) {
                iP2 = iP2 + 1 + C2719f.p(iP);
            }
            this.f22060e = iP;
            int size = iP2 + this.f22057b.size();
            this.f22062g = size;
            return size;
        }

        @Override // s6.q
        public final boolean e() {
            byte b8 = this.f22061f;
            if (b8 == 1) {
                return true;
            }
            if (b8 == 0) {
                return false;
            }
            this.f22061f = (byte) 1;
            return true;
        }

        @Override // s6.p
        public void h(C2719f c2719f) throws IOException {
            c();
            for (int i8 = 0; i8 < this.f22058c.size(); i8++) {
                c2719f.c0(1, (p) this.f22058c.get(i8));
            }
            if (y().size() > 0) {
                c2719f.n0(42);
                c2719f.n0(this.f22060e);
            }
            for (int i9 = 0; i9 < this.f22059d.size(); i9++) {
                c2719f.a0(((Integer) this.f22059d.get(i9)).intValue());
            }
            c2719f.h0(this.f22057b);
        }

        public List y() {
            return this.f22059d;
        }

        public List z() {
            return this.f22058c;
        }

        /* JADX INFO: renamed from: o6.a$e$c */
        public static final class c extends AbstractC2722i implements q {

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public static final c f22066n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public static r f22067o = new C0370a();

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final AbstractC2717d f22068b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f22069c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f22070d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public int f22071e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public Object f22072f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public EnumC0371c f22073g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public List f22074h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public int f22075i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public List f22076j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public int f22077k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public byte f22078l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public int f22079m;

            /* JADX INFO: renamed from: o6.a$e$c$a, reason: collision with other inner class name */
            public static class C0370a extends AbstractC2715b {
                @Override // s6.r
                /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
                public c b(C2718e c2718e, C2720g c2720g) {
                    return new c(c2718e, c2720g);
                }
            }

            /* JADX INFO: renamed from: o6.a$e$c$c, reason: collision with other inner class name */
            public enum EnumC0371c implements AbstractC2723j.a {
                NONE(0, 0),
                INTERNAL_TO_CLASS_ID(1, 1),
                DESC_TO_CLASS_ID(2, 2);


                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public static AbstractC2723j.b f22090e = new C0372a();

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                public final int f22092a;

                /* JADX INFO: renamed from: o6.a$e$c$c$a, reason: collision with other inner class name */
                public static class C0372a implements AbstractC2723j.b {
                    @Override // s6.AbstractC2723j.b
                    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                    public EnumC0371c a(int i8) {
                        return EnumC0371c.a(i8);
                    }
                }

                EnumC0371c(int i8, int i9) {
                    this.f22092a = i9;
                }

                public static EnumC0371c a(int i8) {
                    if (i8 == 0) {
                        return NONE;
                    }
                    if (i8 == 1) {
                        return INTERNAL_TO_CLASS_ID;
                    }
                    if (i8 != 2) {
                        return null;
                    }
                    return DESC_TO_CLASS_ID;
                }

                @Override // s6.AbstractC2723j.a
                public final int d() {
                    return this.f22092a;
                }
            }

            static {
                c cVar = new c(true);
                f22066n = cVar;
                cVar.R();
            }

            public c(C2718e c2718e, C2720g c2720g) {
                List list;
                Integer numValueOf;
                int i8;
                this.f22075i = -1;
                this.f22077k = -1;
                this.f22078l = (byte) -1;
                this.f22079m = -1;
                R();
                AbstractC2717d.b bVarK = AbstractC2717d.K();
                C2719f c2719fI = C2719f.I(bVarK, 1);
                boolean z7 = false;
                int i9 = 0;
                while (!z7) {
                    try {
                        try {
                            try {
                                int iJ = c2718e.J();
                                if (iJ != 0) {
                                    if (iJ == 8) {
                                        this.f22069c |= 1;
                                        this.f22070d = c2718e.r();
                                    } else if (iJ == 16) {
                                        this.f22069c |= 2;
                                        this.f22071e = c2718e.r();
                                    } else if (iJ != 24) {
                                        if (iJ != 32) {
                                            if (iJ == 34) {
                                                i8 = c2718e.i(c2718e.z());
                                                if ((i9 & 16) != 16 && c2718e.e() > 0) {
                                                    this.f22074h = new ArrayList();
                                                    i9 |= 16;
                                                }
                                                while (c2718e.e() > 0) {
                                                    this.f22074h.add(Integer.valueOf(c2718e.r()));
                                                }
                                            } else if (iJ == 40) {
                                                if ((i9 & 32) != 32) {
                                                    this.f22076j = new ArrayList();
                                                    i9 |= 32;
                                                }
                                                list = this.f22076j;
                                                numValueOf = Integer.valueOf(c2718e.r());
                                            } else if (iJ == 42) {
                                                i8 = c2718e.i(c2718e.z());
                                                if ((i9 & 32) != 32 && c2718e.e() > 0) {
                                                    this.f22076j = new ArrayList();
                                                    i9 |= 32;
                                                }
                                                while (c2718e.e() > 0) {
                                                    this.f22076j.add(Integer.valueOf(c2718e.r()));
                                                }
                                            } else if (iJ == 50) {
                                                AbstractC2717d abstractC2717dK = c2718e.k();
                                                this.f22069c |= 4;
                                                this.f22072f = abstractC2717dK;
                                            } else if (!q(c2718e, c2719fI, c2720g, iJ)) {
                                            }
                                            c2718e.h(i8);
                                        } else {
                                            if ((i9 & 16) != 16) {
                                                this.f22074h = new ArrayList();
                                                i9 |= 16;
                                            }
                                            list = this.f22074h;
                                            numValueOf = Integer.valueOf(c2718e.r());
                                        }
                                        list.add(numValueOf);
                                    } else {
                                        int iM = c2718e.m();
                                        EnumC0371c enumC0371cA = EnumC0371c.a(iM);
                                        if (enumC0371cA == null) {
                                            c2719fI.n0(iJ);
                                            c2719fI.n0(iM);
                                        } else {
                                            this.f22069c |= 8;
                                            this.f22073g = enumC0371cA;
                                        }
                                    }
                                }
                                z7 = true;
                            } catch (IOException e8) {
                                throw new C2724k(e8.getMessage()).i(this);
                            }
                        } catch (C2724k e9) {
                            throw e9.i(this);
                        }
                    } catch (Throwable th) {
                        if ((i9 & 16) == 16) {
                            this.f22074h = Collections.unmodifiableList(this.f22074h);
                        }
                        if ((i9 & 32) == 32) {
                            this.f22076j = Collections.unmodifiableList(this.f22076j);
                        }
                        try {
                            c2719fI.H();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f22068b = bVarK.n();
                            throw th2;
                        }
                        this.f22068b = bVarK.n();
                        m();
                        throw th;
                    }
                }
                if ((i9 & 16) == 16) {
                    this.f22074h = Collections.unmodifiableList(this.f22074h);
                }
                if ((i9 & 32) == 32) {
                    this.f22076j = Collections.unmodifiableList(this.f22076j);
                }
                try {
                    c2719fI.H();
                } catch (IOException unused2) {
                } catch (Throwable th3) {
                    this.f22068b = bVarK.n();
                    throw th3;
                }
                this.f22068b = bVarK.n();
                m();
            }

            public static c D() {
                return f22066n;
            }

            private void R() {
                this.f22070d = 1;
                this.f22071e = 0;
                this.f22072f = "";
                this.f22073g = EnumC0371c.NONE;
                this.f22074h = Collections.emptyList();
                this.f22076j = Collections.emptyList();
            }

            public static b S() {
                return b.r();
            }

            public static b T(c cVar) {
                return S().k(cVar);
            }

            public EnumC0371c E() {
                return this.f22073g;
            }

            public int F() {
                return this.f22071e;
            }

            public int G() {
                return this.f22070d;
            }

            public int H() {
                return this.f22076j.size();
            }

            public List I() {
                return this.f22076j;
            }

            public String J() {
                Object obj = this.f22072f;
                if (obj instanceof String) {
                    return (String) obj;
                }
                AbstractC2717d abstractC2717d = (AbstractC2717d) obj;
                String strQ = abstractC2717d.Q();
                if (abstractC2717d.J()) {
                    this.f22072f = strQ;
                }
                return strQ;
            }

            public AbstractC2717d K() {
                Object obj = this.f22072f;
                if (!(obj instanceof String)) {
                    return (AbstractC2717d) obj;
                }
                AbstractC2717d abstractC2717dN = AbstractC2717d.n((String) obj);
                this.f22072f = abstractC2717dN;
                return abstractC2717dN;
            }

            public int L() {
                return this.f22074h.size();
            }

            public List M() {
                return this.f22074h;
            }

            public boolean N() {
                return (this.f22069c & 8) == 8;
            }

            public boolean O() {
                return (this.f22069c & 2) == 2;
            }

            public boolean P() {
                return (this.f22069c & 1) == 1;
            }

            public boolean Q() {
                return (this.f22069c & 4) == 4;
            }

            @Override // s6.p
            /* JADX INFO: renamed from: U, reason: merged with bridge method [inline-methods] */
            public b d() {
                return S();
            }

            @Override // s6.p
            /* JADX INFO: renamed from: V, reason: merged with bridge method [inline-methods] */
            public b g() {
                return T(this);
            }

            @Override // s6.p
            public int c() {
                int i8 = this.f22079m;
                if (i8 != -1) {
                    return i8;
                }
                int iO = (this.f22069c & 1) == 1 ? C2719f.o(1, this.f22070d) : 0;
                if ((this.f22069c & 2) == 2) {
                    iO += C2719f.o(2, this.f22071e);
                }
                if ((this.f22069c & 8) == 8) {
                    iO += C2719f.h(3, this.f22073g.d());
                }
                int iP = 0;
                for (int i9 = 0; i9 < this.f22074h.size(); i9++) {
                    iP += C2719f.p(((Integer) this.f22074h.get(i9)).intValue());
                }
                int iP2 = iO + iP;
                if (!M().isEmpty()) {
                    iP2 = iP2 + 1 + C2719f.p(iP);
                }
                this.f22075i = iP;
                int iP3 = 0;
                for (int i10 = 0; i10 < this.f22076j.size(); i10++) {
                    iP3 += C2719f.p(((Integer) this.f22076j.get(i10)).intValue());
                }
                int iD = iP2 + iP3;
                if (!I().isEmpty()) {
                    iD = iD + 1 + C2719f.p(iP3);
                }
                this.f22077k = iP3;
                if ((this.f22069c & 4) == 4) {
                    iD += C2719f.d(6, K());
                }
                int size = iD + this.f22068b.size();
                this.f22079m = size;
                return size;
            }

            @Override // s6.q
            public final boolean e() {
                byte b8 = this.f22078l;
                if (b8 == 1) {
                    return true;
                }
                if (b8 == 0) {
                    return false;
                }
                this.f22078l = (byte) 1;
                return true;
            }

            @Override // s6.p
            public void h(C2719f c2719f) throws IOException {
                c();
                if ((this.f22069c & 1) == 1) {
                    c2719f.Z(1, this.f22070d);
                }
                if ((this.f22069c & 2) == 2) {
                    c2719f.Z(2, this.f22071e);
                }
                if ((this.f22069c & 8) == 8) {
                    c2719f.R(3, this.f22073g.d());
                }
                if (M().size() > 0) {
                    c2719f.n0(34);
                    c2719f.n0(this.f22075i);
                }
                for (int i8 = 0; i8 < this.f22074h.size(); i8++) {
                    c2719f.a0(((Integer) this.f22074h.get(i8)).intValue());
                }
                if (I().size() > 0) {
                    c2719f.n0(42);
                    c2719f.n0(this.f22077k);
                }
                for (int i9 = 0; i9 < this.f22076j.size(); i9++) {
                    c2719f.a0(((Integer) this.f22076j.get(i9)).intValue());
                }
                if ((this.f22069c & 4) == 4) {
                    c2719f.N(6, K());
                }
                c2719f.h0(this.f22068b);
            }

            public c(AbstractC2722i.b bVar) {
                super(bVar);
                this.f22075i = -1;
                this.f22077k = -1;
                this.f22078l = (byte) -1;
                this.f22079m = -1;
                this.f22068b = bVar.j();
            }

            public c(boolean z7) {
                this.f22075i = -1;
                this.f22077k = -1;
                this.f22078l = (byte) -1;
                this.f22079m = -1;
                this.f22068b = AbstractC2717d.f23128a;
            }

            /* JADX INFO: renamed from: o6.a$e$c$b */
            public static final class b extends AbstractC2722i.b implements q {

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                public int f22080b;

                /* JADX INFO: renamed from: d, reason: collision with root package name */
                public int f22082d;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                public int f22081c = 1;

                /* JADX INFO: renamed from: e, reason: collision with root package name */
                public Object f22083e = "";

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                public EnumC0371c f22084f = EnumC0371c.NONE;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                public List f22085g = Collections.emptyList();

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                public List f22086h = Collections.emptyList();

                public b() {
                    u();
                }

                public static b r() {
                    return new b();
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
                    int i8 = this.f22080b;
                    int i9 = (i8 & 1) != 1 ? 0 : 1;
                    cVar.f22070d = this.f22081c;
                    if ((i8 & 2) == 2) {
                        i9 |= 2;
                    }
                    cVar.f22071e = this.f22082d;
                    if ((i8 & 4) == 4) {
                        i9 |= 4;
                    }
                    cVar.f22072f = this.f22083e;
                    if ((i8 & 8) == 8) {
                        i9 |= 8;
                    }
                    cVar.f22073g = this.f22084f;
                    if ((this.f22080b & 16) == 16) {
                        this.f22085g = Collections.unmodifiableList(this.f22085g);
                        this.f22080b &= -17;
                    }
                    cVar.f22074h = this.f22085g;
                    if ((this.f22080b & 32) == 32) {
                        this.f22086h = Collections.unmodifiableList(this.f22086h);
                        this.f22080b &= -33;
                    }
                    cVar.f22076j = this.f22086h;
                    cVar.f22069c = i9;
                    return cVar;
                }

                /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
                public b clone() {
                    return r().k(p());
                }

                public final void s() {
                    if ((this.f22080b & 32) != 32) {
                        this.f22086h = new ArrayList(this.f22086h);
                        this.f22080b |= 32;
                    }
                }

                public final void t() {
                    if ((this.f22080b & 16) != 16) {
                        this.f22085g = new ArrayList(this.f22085g);
                        this.f22080b |= 16;
                    }
                }

                @Override // s6.AbstractC2722i.b
                /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
                public b k(c cVar) {
                    if (cVar == c.D()) {
                        return this;
                    }
                    if (cVar.P()) {
                        z(cVar.G());
                    }
                    if (cVar.O()) {
                        y(cVar.F());
                    }
                    if (cVar.Q()) {
                        this.f22080b |= 4;
                        this.f22083e = cVar.f22072f;
                    }
                    if (cVar.N()) {
                        x(cVar.E());
                    }
                    if (!cVar.f22074h.isEmpty()) {
                        if (this.f22085g.isEmpty()) {
                            this.f22085g = cVar.f22074h;
                            this.f22080b &= -17;
                        } else {
                            t();
                            this.f22085g.addAll(cVar.f22074h);
                        }
                    }
                    if (!cVar.f22076j.isEmpty()) {
                        if (this.f22086h.isEmpty()) {
                            this.f22086h = cVar.f22076j;
                            this.f22080b &= -33;
                        } else {
                            s();
                            this.f22086h.addAll(cVar.f22076j);
                        }
                    }
                    l(j().d(cVar.f22068b));
                    return this;
                }

                /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
                @Override // s6.p.a
                /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public o6.AbstractC2492a.e.c.b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
                    /*
                        r2 = this;
                        r0 = 0
                        s6.r r1 = o6.AbstractC2492a.e.c.f22067o     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                        java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                        o6.a$e$c r3 = (o6.AbstractC2492a.e.c) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
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
                        o6.a$e$c r4 = (o6.AbstractC2492a.e.c) r4     // Catch: java.lang.Throwable -> Lf
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
                    throw new UnsupportedOperationException("Method not decompiled: o6.AbstractC2492a.e.c.b.n(s6.e, s6.g):o6.a$e$c$b");
                }

                public b x(EnumC0371c enumC0371c) {
                    enumC0371c.getClass();
                    this.f22080b |= 8;
                    this.f22084f = enumC0371c;
                    return this;
                }

                public b y(int i8) {
                    this.f22080b |= 2;
                    this.f22082d = i8;
                    return this;
                }

                public b z(int i8) {
                    this.f22080b |= 1;
                    this.f22081c = i8;
                    return this;
                }

                private void u() {
                }
            }
        }

        public e(AbstractC2722i.b bVar) {
            super(bVar);
            this.f22060e = -1;
            this.f22061f = (byte) -1;
            this.f22062g = -1;
            this.f22057b = bVar.j();
        }

        public e(boolean z7) {
            this.f22060e = -1;
            this.f22061f = (byte) -1;
            this.f22062g = -1;
            this.f22057b = AbstractC2717d.f23128a;
        }

        /* JADX INFO: renamed from: o6.a$e$b */
        public static final class b extends AbstractC2722i.b implements q {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f22063b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public List f22064c = Collections.emptyList();

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public List f22065d = Collections.emptyList();

            public b() {
                u();
            }

            public static b r() {
                return new b();
            }

            @Override // s6.p.a
            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public e a() {
                e eVarP = p();
                if (eVarP.e()) {
                    return eVarP;
                }
                throw AbstractC2714a.AbstractC0396a.i(eVarP);
            }

            public e p() {
                e eVar = new e(this);
                if ((this.f22063b & 1) == 1) {
                    this.f22064c = Collections.unmodifiableList(this.f22064c);
                    this.f22063b &= -2;
                }
                eVar.f22058c = this.f22064c;
                if ((this.f22063b & 2) == 2) {
                    this.f22065d = Collections.unmodifiableList(this.f22065d);
                    this.f22063b &= -3;
                }
                eVar.f22059d = this.f22065d;
                return eVar;
            }

            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return r().k(p());
            }

            public final void s() {
                if ((this.f22063b & 2) != 2) {
                    this.f22065d = new ArrayList(this.f22065d);
                    this.f22063b |= 2;
                }
            }

            public final void t() {
                if ((this.f22063b & 1) != 1) {
                    this.f22064c = new ArrayList(this.f22064c);
                    this.f22063b |= 1;
                }
            }

            @Override // s6.AbstractC2722i.b
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            public b k(e eVar) {
                if (eVar == e.x()) {
                    return this;
                }
                if (!eVar.f22058c.isEmpty()) {
                    if (this.f22064c.isEmpty()) {
                        this.f22064c = eVar.f22058c;
                        this.f22063b &= -2;
                    } else {
                        t();
                        this.f22064c.addAll(eVar.f22058c);
                    }
                }
                if (!eVar.f22059d.isEmpty()) {
                    if (this.f22065d.isEmpty()) {
                        this.f22065d = eVar.f22059d;
                        this.f22063b &= -3;
                    } else {
                        s();
                        this.f22065d.addAll(eVar.f22059d);
                    }
                }
                l(j().d(eVar.f22057b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // s6.p.a
            /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public o6.AbstractC2492a.e.b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    s6.r r1 = o6.AbstractC2492a.e.f22056i     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                    java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                    o6.a$e r3 = (o6.AbstractC2492a.e) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
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
                    o6.a$e r4 = (o6.AbstractC2492a.e) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: o6.AbstractC2492a.e.b.n(s6.e, s6.g):o6.a$e$b");
            }

            private void u() {
            }
        }
    }

    static {
        l6.d dVarI = l6.d.I();
        c cVarW = c.w();
        c cVarW2 = c.w();
        y.b bVar = y.b.f23244m;
        f22002a = AbstractC2722i.p(dVarI, cVarW, cVarW2, null, 100, bVar, c.class);
        f22003b = AbstractC2722i.p(i.b0(), c.w(), c.w(), null, 100, bVar, c.class);
        i iVarB0 = i.b0();
        y.b bVar2 = y.b.f23238g;
        f22004c = AbstractC2722i.p(iVarB0, 0, null, null, 101, bVar2, Integer.class);
        f22005d = AbstractC2722i.p(n.Z(), d.z(), d.z(), null, 100, bVar, d.class);
        f22006e = AbstractC2722i.p(n.Z(), 0, null, null, 101, bVar2, Integer.class);
        f22007f = AbstractC2722i.o(l6.q.Y(), l6.b.A(), null, 100, bVar, false, l6.b.class);
        f22008g = AbstractC2722i.p(l6.q.Y(), Boolean.FALSE, null, null, 101, y.b.f23241j, Boolean.class);
        f22009h = AbstractC2722i.o(s.L(), l6.b.A(), null, 100, bVar, false, l6.b.class);
        f22010i = AbstractC2722i.p(l6.c.z0(), 0, null, null, 101, bVar2, Integer.class);
        f22011j = AbstractC2722i.o(l6.c.z0(), n.Z(), null, 102, bVar, false, n.class);
        f22012k = AbstractC2722i.p(l6.c.z0(), 0, null, null, 103, bVar2, Integer.class);
        f22013l = AbstractC2722i.p(l6.c.z0(), 0, null, null, 104, bVar2, Integer.class);
        f22014m = AbstractC2722i.p(l.L(), 0, null, null, 101, bVar2, Integer.class);
        f22015n = AbstractC2722i.o(l.L(), n.Z(), null, 102, bVar, false, n.class);
    }

    public static void a(C2720g c2720g) {
        c2720g.a(f22002a);
        c2720g.a(f22003b);
        c2720g.a(f22004c);
        c2720g.a(f22005d);
        c2720g.a(f22006e);
        c2720g.a(f22007f);
        c2720g.a(f22008g);
        c2720g.a(f22009h);
        c2720g.a(f22010i);
        c2720g.a(f22011j);
        c2720g.a(f22012k);
        c2720g.a(f22013l);
        c2720g.a(f22014m);
        c2720g.a(f22015n);
    }

    /* JADX INFO: renamed from: o6.a$b */
    public static final class b extends AbstractC2722i implements q {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final b f22016h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static r f22017i = new C0365a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC2717d f22018b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22019c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f22020d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f22021e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte f22022f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f22023g;

        /* JADX INFO: renamed from: o6.a$b$a, reason: collision with other inner class name */
        public static class C0365a extends AbstractC2715b {
            @Override // s6.r
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public b b(C2718e c2718e, C2720g c2720g) {
                return new b(c2718e, c2720g);
            }
        }

        static {
            b bVar = new b(true);
            f22016h = bVar;
            bVar.B();
        }

        public b(C2718e c2718e, C2720g c2720g) {
            this.f22022f = (byte) -1;
            this.f22023g = -1;
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
                                this.f22019c |= 1;
                                this.f22020d = c2718e.r();
                            } else if (iJ == 16) {
                                this.f22019c |= 2;
                                this.f22021e = c2718e.r();
                            } else if (!q(c2718e, c2719fI, c2720g, iJ)) {
                            }
                        }
                        z7 = true;
                    } catch (Throwable th) {
                        try {
                            c2719fI.H();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f22018b = bVarK.n();
                            throw th2;
                        }
                        this.f22018b = bVarK.n();
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
                this.f22018b = bVarK.n();
                throw th3;
            }
            this.f22018b = bVarK.n();
            m();
        }

        private void B() {
            this.f22020d = 0;
            this.f22021e = 0;
        }

        public static C0366b C() {
            return C0366b.r();
        }

        public static C0366b D(b bVar) {
            return C().k(bVar);
        }

        public static b w() {
            return f22016h;
        }

        public boolean A() {
            return (this.f22019c & 1) == 1;
        }

        @Override // s6.p
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public C0366b d() {
            return C();
        }

        @Override // s6.p
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public C0366b g() {
            return D(this);
        }

        @Override // s6.p
        public int c() {
            int i8 = this.f22023g;
            if (i8 != -1) {
                return i8;
            }
            int iO = (this.f22019c & 1) == 1 ? C2719f.o(1, this.f22020d) : 0;
            if ((this.f22019c & 2) == 2) {
                iO += C2719f.o(2, this.f22021e);
            }
            int size = iO + this.f22018b.size();
            this.f22023g = size;
            return size;
        }

        @Override // s6.q
        public final boolean e() {
            byte b8 = this.f22022f;
            if (b8 == 1) {
                return true;
            }
            if (b8 == 0) {
                return false;
            }
            this.f22022f = (byte) 1;
            return true;
        }

        @Override // s6.p
        public void h(C2719f c2719f) throws IOException {
            c();
            if ((this.f22019c & 1) == 1) {
                c2719f.Z(1, this.f22020d);
            }
            if ((this.f22019c & 2) == 2) {
                c2719f.Z(2, this.f22021e);
            }
            c2719f.h0(this.f22018b);
        }

        public int x() {
            return this.f22021e;
        }

        public int y() {
            return this.f22020d;
        }

        public boolean z() {
            return (this.f22019c & 2) == 2;
        }

        public b(AbstractC2722i.b bVar) {
            super(bVar);
            this.f22022f = (byte) -1;
            this.f22023g = -1;
            this.f22018b = bVar.j();
        }

        public b(boolean z7) {
            this.f22022f = (byte) -1;
            this.f22023g = -1;
            this.f22018b = AbstractC2717d.f23128a;
        }

        /* JADX INFO: renamed from: o6.a$b$b, reason: collision with other inner class name */
        public static final class C0366b extends AbstractC2722i.b implements q {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f22024b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f22025c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f22026d;

            public C0366b() {
                s();
            }

            public static C0366b r() {
                return new C0366b();
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
                int i8 = this.f22024b;
                int i9 = (i8 & 1) != 1 ? 0 : 1;
                bVar.f22020d = this.f22025c;
                if ((i8 & 2) == 2) {
                    i9 |= 2;
                }
                bVar.f22021e = this.f22026d;
                bVar.f22019c = i9;
                return bVar;
            }

            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public C0366b clone() {
                return r().k(p());
            }

            @Override // s6.AbstractC2722i.b
            /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
            public C0366b k(b bVar) {
                if (bVar == b.w()) {
                    return this;
                }
                if (bVar.A()) {
                    w(bVar.y());
                }
                if (bVar.z()) {
                    v(bVar.x());
                }
                l(j().d(bVar.f22018b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // s6.p.a
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public o6.AbstractC2492a.b.C0366b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    s6.r r1 = o6.AbstractC2492a.b.f22017i     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                    java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                    o6.a$b r3 = (o6.AbstractC2492a.b) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
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
                    o6.a$b r4 = (o6.AbstractC2492a.b) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: o6.AbstractC2492a.b.C0366b.n(s6.e, s6.g):o6.a$b$b");
            }

            public C0366b v(int i8) {
                this.f22024b |= 2;
                this.f22026d = i8;
                return this;
            }

            public C0366b w(int i8) {
                this.f22024b |= 1;
                this.f22025c = i8;
                return this;
            }

            private void s() {
            }
        }
    }

    /* JADX INFO: renamed from: o6.a$c */
    public static final class c extends AbstractC2722i implements q {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final c f22027h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static r f22028i = new C0367a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC2717d f22029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f22031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f22032e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public byte f22033f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public int f22034g;

        /* JADX INFO: renamed from: o6.a$c$a, reason: collision with other inner class name */
        public static class C0367a extends AbstractC2715b {
            @Override // s6.r
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public c b(C2718e c2718e, C2720g c2720g) {
                return new c(c2718e, c2720g);
            }
        }

        static {
            c cVar = new c(true);
            f22027h = cVar;
            cVar.B();
        }

        public c(C2718e c2718e, C2720g c2720g) {
            this.f22033f = (byte) -1;
            this.f22034g = -1;
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
                                this.f22030c |= 1;
                                this.f22031d = c2718e.r();
                            } else if (iJ == 16) {
                                this.f22030c |= 2;
                                this.f22032e = c2718e.r();
                            } else if (!q(c2718e, c2719fI, c2720g, iJ)) {
                            }
                        }
                        z7 = true;
                    } catch (Throwable th) {
                        try {
                            c2719fI.H();
                        } catch (IOException unused) {
                        } catch (Throwable th2) {
                            this.f22029b = bVarK.n();
                            throw th2;
                        }
                        this.f22029b = bVarK.n();
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
                this.f22029b = bVarK.n();
                throw th3;
            }
            this.f22029b = bVarK.n();
            m();
        }

        private void B() {
            this.f22031d = 0;
            this.f22032e = 0;
        }

        public static b C() {
            return b.r();
        }

        public static b D(c cVar) {
            return C().k(cVar);
        }

        public static c w() {
            return f22027h;
        }

        public boolean A() {
            return (this.f22030c & 1) == 1;
        }

        @Override // s6.p
        /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
        public b d() {
            return C();
        }

        @Override // s6.p
        /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
        public b g() {
            return D(this);
        }

        @Override // s6.p
        public int c() {
            int i8 = this.f22034g;
            if (i8 != -1) {
                return i8;
            }
            int iO = (this.f22030c & 1) == 1 ? C2719f.o(1, this.f22031d) : 0;
            if ((this.f22030c & 2) == 2) {
                iO += C2719f.o(2, this.f22032e);
            }
            int size = iO + this.f22029b.size();
            this.f22034g = size;
            return size;
        }

        @Override // s6.q
        public final boolean e() {
            byte b8 = this.f22033f;
            if (b8 == 1) {
                return true;
            }
            if (b8 == 0) {
                return false;
            }
            this.f22033f = (byte) 1;
            return true;
        }

        @Override // s6.p
        public void h(C2719f c2719f) throws IOException {
            c();
            if ((this.f22030c & 1) == 1) {
                c2719f.Z(1, this.f22031d);
            }
            if ((this.f22030c & 2) == 2) {
                c2719f.Z(2, this.f22032e);
            }
            c2719f.h0(this.f22029b);
        }

        public int x() {
            return this.f22032e;
        }

        public int y() {
            return this.f22031d;
        }

        public boolean z() {
            return (this.f22030c & 2) == 2;
        }

        public c(AbstractC2722i.b bVar) {
            super(bVar);
            this.f22033f = (byte) -1;
            this.f22034g = -1;
            this.f22029b = bVar.j();
        }

        public c(boolean z7) {
            this.f22033f = (byte) -1;
            this.f22034g = -1;
            this.f22029b = AbstractC2717d.f23128a;
        }

        /* JADX INFO: renamed from: o6.a$c$b */
        public static final class b extends AbstractC2722i.b implements q {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f22035b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f22036c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f22037d;

            public b() {
                s();
            }

            public static b r() {
                return new b();
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
                int i8 = this.f22035b;
                int i9 = (i8 & 1) != 1 ? 0 : 1;
                cVar.f22031d = this.f22036c;
                if ((i8 & 2) == 2) {
                    i9 |= 2;
                }
                cVar.f22032e = this.f22037d;
                cVar.f22030c = i9;
                return cVar;
            }

            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return r().k(p());
            }

            @Override // s6.AbstractC2722i.b
            /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
            public b k(c cVar) {
                if (cVar == c.w()) {
                    return this;
                }
                if (cVar.A()) {
                    w(cVar.y());
                }
                if (cVar.z()) {
                    v(cVar.x());
                }
                l(j().d(cVar.f22029b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // s6.p.a
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public o6.AbstractC2492a.c.b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    s6.r r1 = o6.AbstractC2492a.c.f22028i     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                    java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                    o6.a$c r3 = (o6.AbstractC2492a.c) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
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
                    o6.a$c r4 = (o6.AbstractC2492a.c) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: o6.AbstractC2492a.c.b.n(s6.e, s6.g):o6.a$c$b");
            }

            public b v(int i8) {
                this.f22035b |= 2;
                this.f22037d = i8;
                return this;
            }

            public b w(int i8) {
                this.f22035b |= 1;
                this.f22036c = i8;
                return this;
            }

            private void s() {
            }
        }
    }

    /* JADX INFO: renamed from: o6.a$d */
    public static final class d extends AbstractC2722i implements q {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public static final d f22038k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public static r f22039l = new C0368a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC2717d f22040b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f22041c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public b f22042d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public c f22043e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public c f22044f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public c f22045g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public c f22046h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public byte f22047i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public int f22048j;

        /* JADX INFO: renamed from: o6.a$d$a, reason: collision with other inner class name */
        public static class C0368a extends AbstractC2715b {
            @Override // s6.r
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public d b(C2718e c2718e, C2720g c2720g) {
                return new d(c2718e, c2720g);
            }
        }

        static {
            d dVar = new d(true);
            f22038k = dVar;
            dVar.K();
        }

        public d(C2718e c2718e, C2720g c2720g) {
            int i8;
            int i9;
            this.f22047i = (byte) -1;
            this.f22048j = -1;
            K();
            AbstractC2717d.b bVarK = AbstractC2717d.K();
            C2719f c2719fI = C2719f.I(bVarK, 1);
            boolean z7 = false;
            while (!z7) {
                try {
                    try {
                        try {
                            int iJ = c2718e.J();
                            if (iJ != 0) {
                                if (iJ != 10) {
                                    if (iJ == 18) {
                                        i8 = 2;
                                        c.b bVarG = (this.f22041c & 2) == 2 ? this.f22043e.g() : null;
                                        c cVar = (c) c2718e.t(c.f22028i, c2720g);
                                        this.f22043e = cVar;
                                        if (bVarG != null) {
                                            bVarG.k(cVar);
                                            this.f22043e = bVarG.p();
                                        }
                                        i9 = this.f22041c;
                                    } else if (iJ == 26) {
                                        i8 = 4;
                                        c.b bVarG2 = (this.f22041c & 4) == 4 ? this.f22044f.g() : null;
                                        c cVar2 = (c) c2718e.t(c.f22028i, c2720g);
                                        this.f22044f = cVar2;
                                        if (bVarG2 != null) {
                                            bVarG2.k(cVar2);
                                            this.f22044f = bVarG2.p();
                                        }
                                        i9 = this.f22041c;
                                    } else if (iJ == 34) {
                                        i8 = 8;
                                        c.b bVarG3 = (this.f22041c & 8) == 8 ? this.f22045g.g() : null;
                                        c cVar3 = (c) c2718e.t(c.f22028i, c2720g);
                                        this.f22045g = cVar3;
                                        if (bVarG3 != null) {
                                            bVarG3.k(cVar3);
                                            this.f22045g = bVarG3.p();
                                        }
                                        i9 = this.f22041c;
                                    } else if (iJ == 42) {
                                        i8 = 16;
                                        c.b bVarG4 = (this.f22041c & 16) == 16 ? this.f22046h.g() : null;
                                        c cVar4 = (c) c2718e.t(c.f22028i, c2720g);
                                        this.f22046h = cVar4;
                                        if (bVarG4 != null) {
                                            bVarG4.k(cVar4);
                                            this.f22046h = bVarG4.p();
                                        }
                                        i9 = this.f22041c;
                                    } else if (!q(c2718e, c2719fI, c2720g, iJ)) {
                                    }
                                    this.f22041c = i9 | i8;
                                } else {
                                    b.C0366b c0366bG = (this.f22041c & 1) == 1 ? this.f22042d.g() : null;
                                    b bVar = (b) c2718e.t(b.f22017i, c2720g);
                                    this.f22042d = bVar;
                                    if (c0366bG != null) {
                                        c0366bG.k(bVar);
                                        this.f22042d = c0366bG.p();
                                    }
                                    this.f22041c |= 1;
                                }
                            }
                            z7 = true;
                        } catch (IOException e8) {
                            throw new C2724k(e8.getMessage()).i(this);
                        }
                    } catch (C2724k e9) {
                        throw e9.i(this);
                    }
                } catch (Throwable th) {
                    try {
                        c2719fI.H();
                    } catch (IOException unused) {
                    } catch (Throwable th2) {
                        this.f22040b = bVarK.n();
                        throw th2;
                    }
                    this.f22040b = bVarK.n();
                    m();
                    throw th;
                }
            }
            try {
                c2719fI.H();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f22040b = bVarK.n();
                throw th3;
            }
            this.f22040b = bVarK.n();
            m();
        }

        private void K() {
            this.f22042d = b.w();
            this.f22043e = c.w();
            this.f22044f = c.w();
            this.f22045g = c.w();
            this.f22046h = c.w();
        }

        public static b L() {
            return b.r();
        }

        public static b M(d dVar) {
            return L().k(dVar);
        }

        public static d z() {
            return f22038k;
        }

        public c A() {
            return this.f22046h;
        }

        public b B() {
            return this.f22042d;
        }

        public c C() {
            return this.f22044f;
        }

        public c D() {
            return this.f22045g;
        }

        public c E() {
            return this.f22043e;
        }

        public boolean F() {
            return (this.f22041c & 16) == 16;
        }

        public boolean G() {
            return (this.f22041c & 1) == 1;
        }

        public boolean H() {
            return (this.f22041c & 4) == 4;
        }

        public boolean I() {
            return (this.f22041c & 8) == 8;
        }

        public boolean J() {
            return (this.f22041c & 2) == 2;
        }

        @Override // s6.p
        /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
        public b d() {
            return L();
        }

        @Override // s6.p
        /* JADX INFO: renamed from: O, reason: merged with bridge method [inline-methods] */
        public b g() {
            return M(this);
        }

        @Override // s6.p
        public int c() {
            int i8 = this.f22048j;
            if (i8 != -1) {
                return i8;
            }
            int iR = (this.f22041c & 1) == 1 ? C2719f.r(1, this.f22042d) : 0;
            if ((this.f22041c & 2) == 2) {
                iR += C2719f.r(2, this.f22043e);
            }
            if ((this.f22041c & 4) == 4) {
                iR += C2719f.r(3, this.f22044f);
            }
            if ((this.f22041c & 8) == 8) {
                iR += C2719f.r(4, this.f22045g);
            }
            if ((this.f22041c & 16) == 16) {
                iR += C2719f.r(5, this.f22046h);
            }
            int size = iR + this.f22040b.size();
            this.f22048j = size;
            return size;
        }

        @Override // s6.q
        public final boolean e() {
            byte b8 = this.f22047i;
            if (b8 == 1) {
                return true;
            }
            if (b8 == 0) {
                return false;
            }
            this.f22047i = (byte) 1;
            return true;
        }

        @Override // s6.p
        public void h(C2719f c2719f) throws IOException {
            c();
            if ((this.f22041c & 1) == 1) {
                c2719f.c0(1, this.f22042d);
            }
            if ((this.f22041c & 2) == 2) {
                c2719f.c0(2, this.f22043e);
            }
            if ((this.f22041c & 4) == 4) {
                c2719f.c0(3, this.f22044f);
            }
            if ((this.f22041c & 8) == 8) {
                c2719f.c0(4, this.f22045g);
            }
            if ((this.f22041c & 16) == 16) {
                c2719f.c0(5, this.f22046h);
            }
            c2719f.h0(this.f22040b);
        }

        public d(AbstractC2722i.b bVar) {
            super(bVar);
            this.f22047i = (byte) -1;
            this.f22048j = -1;
            this.f22040b = bVar.j();
        }

        public d(boolean z7) {
            this.f22047i = (byte) -1;
            this.f22048j = -1;
            this.f22040b = AbstractC2717d.f23128a;
        }

        /* JADX INFO: renamed from: o6.a$d$b */
        public static final class b extends AbstractC2722i.b implements q {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f22049b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public b f22050c = b.w();

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public c f22051d = c.w();

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public c f22052e = c.w();

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public c f22053f = c.w();

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public c f22054g = c.w();

            public b() {
                s();
            }

            public static b r() {
                return new b();
            }

            @Override // s6.p.a
            /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
            public d a() {
                d dVarP = p();
                if (dVarP.e()) {
                    return dVarP;
                }
                throw AbstractC2714a.AbstractC0396a.i(dVarP);
            }

            public d p() {
                d dVar = new d(this);
                int i8 = this.f22049b;
                int i9 = (i8 & 1) != 1 ? 0 : 1;
                dVar.f22042d = this.f22050c;
                if ((i8 & 2) == 2) {
                    i9 |= 2;
                }
                dVar.f22043e = this.f22051d;
                if ((i8 & 4) == 4) {
                    i9 |= 4;
                }
                dVar.f22044f = this.f22052e;
                if ((i8 & 8) == 8) {
                    i9 |= 8;
                }
                dVar.f22045g = this.f22053f;
                if ((i8 & 16) == 16) {
                    i9 |= 16;
                }
                dVar.f22046h = this.f22054g;
                dVar.f22041c = i9;
                return dVar;
            }

            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return r().k(p());
            }

            public b t(c cVar) {
                if ((this.f22049b & 16) == 16 && this.f22054g != c.w()) {
                    cVar = c.D(this.f22054g).k(cVar).p();
                }
                this.f22054g = cVar;
                this.f22049b |= 16;
                return this;
            }

            public b u(b bVar) {
                if ((this.f22049b & 1) == 1 && this.f22050c != b.w()) {
                    bVar = b.D(this.f22050c).k(bVar).p();
                }
                this.f22050c = bVar;
                this.f22049b |= 1;
                return this;
            }

            @Override // s6.AbstractC2722i.b
            /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
            public b k(d dVar) {
                if (dVar == d.z()) {
                    return this;
                }
                if (dVar.G()) {
                    u(dVar.B());
                }
                if (dVar.J()) {
                    z(dVar.E());
                }
                if (dVar.H()) {
                    x(dVar.C());
                }
                if (dVar.I()) {
                    y(dVar.D());
                }
                if (dVar.F()) {
                    t(dVar.A());
                }
                l(j().d(dVar.f22040b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // s6.p.a
            /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public o6.AbstractC2492a.d.b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    s6.r r1 = o6.AbstractC2492a.d.f22039l     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                    java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                    o6.a$d r3 = (o6.AbstractC2492a.d) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
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
                    o6.a$d r4 = (o6.AbstractC2492a.d) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: o6.AbstractC2492a.d.b.n(s6.e, s6.g):o6.a$d$b");
            }

            public b x(c cVar) {
                if ((this.f22049b & 4) == 4 && this.f22052e != c.w()) {
                    cVar = c.D(this.f22052e).k(cVar).p();
                }
                this.f22052e = cVar;
                this.f22049b |= 4;
                return this;
            }

            public b y(c cVar) {
                if ((this.f22049b & 8) == 8 && this.f22053f != c.w()) {
                    cVar = c.D(this.f22053f).k(cVar).p();
                }
                this.f22053f = cVar;
                this.f22049b |= 8;
                return this;
            }

            public b z(c cVar) {
                if ((this.f22049b & 2) == 2 && this.f22051d != c.w()) {
                    cVar = c.D(this.f22051d).k(cVar).p();
                }
                this.f22051d = cVar;
                this.f22049b |= 2;
                return this;
            }

            private void s() {
            }
        }
    }
}
