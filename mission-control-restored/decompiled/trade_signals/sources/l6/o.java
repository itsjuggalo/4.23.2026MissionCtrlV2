package l6;

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
public final class o extends AbstractC2722i implements s6.q {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final o f20957f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static s6.r f20958g = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbstractC2717d f20959b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public List f20960c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte f20961d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f20962e;

    public static class a extends AbstractC2715b {
        @Override // s6.r
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public o b(C2718e c2718e, C2720g c2720g) {
            return new o(c2718e, c2720g);
        }
    }

    static {
        o oVar = new o(true);
        f20957f = oVar;
        oVar.y();
    }

    public o(C2718e c2718e, C2720g c2720g) {
        this.f20961d = (byte) -1;
        this.f20962e = -1;
        y();
        AbstractC2717d.b bVarK = AbstractC2717d.K();
        C2719f c2719fI = C2719f.I(bVarK, 1);
        boolean z7 = false;
        boolean z8 = false;
        while (!z7) {
            try {
                try {
                    try {
                        int iJ = c2718e.J();
                        if (iJ != 0) {
                            if (iJ == 10) {
                                if (!z8) {
                                    this.f20960c = new ArrayList();
                                    z8 = true;
                                }
                                this.f20960c.add(c2718e.t(c.f20966j, c2720g));
                            } else if (!q(c2718e, c2719fI, c2720g, iJ)) {
                            }
                        }
                        z7 = true;
                    } catch (C2724k e8) {
                        throw e8.i(this);
                    }
                } catch (IOException e9) {
                    throw new C2724k(e9.getMessage()).i(this);
                }
            } catch (Throwable th) {
                if (z8) {
                    this.f20960c = Collections.unmodifiableList(this.f20960c);
                }
                try {
                    c2719fI.H();
                } catch (IOException unused) {
                } catch (Throwable th2) {
                    this.f20959b = bVarK.n();
                    throw th2;
                }
                this.f20959b = bVarK.n();
                m();
                throw th;
            }
        }
        if (z8) {
            this.f20960c = Collections.unmodifiableList(this.f20960c);
        }
        try {
            c2719fI.H();
        } catch (IOException unused2) {
        } catch (Throwable th3) {
            this.f20959b = bVarK.n();
            throw th3;
        }
        this.f20959b = bVarK.n();
        m();
    }

    public static b A(o oVar) {
        return z().k(oVar);
    }

    public static o v() {
        return f20957f;
    }

    private void y() {
        this.f20960c = Collections.emptyList();
    }

    public static b z() {
        return b.r();
    }

    @Override // s6.p
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public b d() {
        return z();
    }

    @Override // s6.p
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public b g() {
        return A(this);
    }

    @Override // s6.p
    public int c() {
        int i8 = this.f20962e;
        if (i8 != -1) {
            return i8;
        }
        int iR = 0;
        for (int i9 = 0; i9 < this.f20960c.size(); i9++) {
            iR += C2719f.r(1, (s6.p) this.f20960c.get(i9));
        }
        int size = iR + this.f20959b.size();
        this.f20962e = size;
        return size;
    }

    @Override // s6.q
    public final boolean e() {
        byte b8 = this.f20961d;
        if (b8 == 1) {
            return true;
        }
        if (b8 == 0) {
            return false;
        }
        for (int i8 = 0; i8 < x(); i8++) {
            if (!w(i8).e()) {
                this.f20961d = (byte) 0;
                return false;
            }
        }
        this.f20961d = (byte) 1;
        return true;
    }

    @Override // s6.p
    public void h(C2719f c2719f) throws IOException {
        c();
        for (int i8 = 0; i8 < this.f20960c.size(); i8++) {
            c2719f.c0(1, (s6.p) this.f20960c.get(i8));
        }
        c2719f.h0(this.f20959b);
    }

    public c w(int i8) {
        return (c) this.f20960c.get(i8);
    }

    public int x() {
        return this.f20960c.size();
    }

    public static final class c extends AbstractC2722i implements s6.q {

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public static final c f20965i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public static s6.r f20966j = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AbstractC2717d f20967b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f20968c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f20969d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f20970e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public EnumC0353c f20971f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public byte f20972g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f20973h;

        public static class a extends AbstractC2715b {
            @Override // s6.r
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public c b(C2718e c2718e, C2720g c2720g) {
                return new c(c2718e, c2720g);
            }
        }

        /* JADX INFO: renamed from: l6.o$c$c, reason: collision with other inner class name */
        public enum EnumC0353c implements AbstractC2723j.a {
            CLASS(0, 0),
            PACKAGE(1, 1),
            LOCAL(2, 2);


            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public static AbstractC2723j.b f20981e = new a();

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f20983a;

            /* JADX INFO: renamed from: l6.o$c$c$a */
            public static class a implements AbstractC2723j.b {
                @Override // s6.AbstractC2723j.b
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public EnumC0353c a(int i8) {
                    return EnumC0353c.a(i8);
                }
            }

            EnumC0353c(int i8, int i9) {
                this.f20983a = i9;
            }

            public static EnumC0353c a(int i8) {
                if (i8 == 0) {
                    return CLASS;
                }
                if (i8 == 1) {
                    return PACKAGE;
                }
                if (i8 != 2) {
                    return null;
                }
                return LOCAL;
            }

            @Override // s6.AbstractC2723j.a
            public final int d() {
                return this.f20983a;
            }
        }

        static {
            c cVar = new c(true);
            f20965i = cVar;
            cVar.E();
        }

        public c(C2718e c2718e, C2720g c2720g) {
            this.f20972g = (byte) -1;
            this.f20973h = -1;
            E();
            AbstractC2717d.b bVarK = AbstractC2717d.K();
            C2719f c2719fI = C2719f.I(bVarK, 1);
            boolean z7 = false;
            while (!z7) {
                try {
                    try {
                        try {
                            int iJ = c2718e.J();
                            if (iJ != 0) {
                                if (iJ == 8) {
                                    this.f20968c |= 1;
                                    this.f20969d = c2718e.r();
                                } else if (iJ == 16) {
                                    this.f20968c |= 2;
                                    this.f20970e = c2718e.r();
                                } else if (iJ == 24) {
                                    int iM = c2718e.m();
                                    EnumC0353c enumC0353cA = EnumC0353c.a(iM);
                                    if (enumC0353cA == null) {
                                        c2719fI.n0(iJ);
                                        c2719fI.n0(iM);
                                    } else {
                                        this.f20968c |= 4;
                                        this.f20971f = enumC0353cA;
                                    }
                                } else if (!q(c2718e, c2719fI, c2720g, iJ)) {
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
                        this.f20967b = bVarK.n();
                        throw th2;
                    }
                    this.f20967b = bVarK.n();
                    m();
                    throw th;
                }
            }
            try {
                c2719fI.H();
            } catch (IOException unused2) {
            } catch (Throwable th3) {
                this.f20967b = bVarK.n();
                throw th3;
            }
            this.f20967b = bVarK.n();
            m();
        }

        private void E() {
            this.f20969d = -1;
            this.f20970e = 0;
            this.f20971f = EnumC0353c.PACKAGE;
        }

        public static b F() {
            return b.r();
        }

        public static b G(c cVar) {
            return F().k(cVar);
        }

        public static c x() {
            return f20965i;
        }

        public int A() {
            return this.f20970e;
        }

        public boolean B() {
            return (this.f20968c & 4) == 4;
        }

        public boolean C() {
            return (this.f20968c & 1) == 1;
        }

        public boolean D() {
            return (this.f20968c & 2) == 2;
        }

        @Override // s6.p
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public b d() {
            return F();
        }

        @Override // s6.p
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public b g() {
            return G(this);
        }

        @Override // s6.p
        public int c() {
            int i8 = this.f20973h;
            if (i8 != -1) {
                return i8;
            }
            int iO = (this.f20968c & 1) == 1 ? C2719f.o(1, this.f20969d) : 0;
            if ((this.f20968c & 2) == 2) {
                iO += C2719f.o(2, this.f20970e);
            }
            if ((this.f20968c & 4) == 4) {
                iO += C2719f.h(3, this.f20971f.d());
            }
            int size = iO + this.f20967b.size();
            this.f20973h = size;
            return size;
        }

        @Override // s6.q
        public final boolean e() {
            byte b8 = this.f20972g;
            if (b8 == 1) {
                return true;
            }
            if (b8 == 0) {
                return false;
            }
            if (D()) {
                this.f20972g = (byte) 1;
                return true;
            }
            this.f20972g = (byte) 0;
            return false;
        }

        @Override // s6.p
        public void h(C2719f c2719f) throws IOException {
            c();
            if ((this.f20968c & 1) == 1) {
                c2719f.Z(1, this.f20969d);
            }
            if ((this.f20968c & 2) == 2) {
                c2719f.Z(2, this.f20970e);
            }
            if ((this.f20968c & 4) == 4) {
                c2719f.R(3, this.f20971f.d());
            }
            c2719f.h0(this.f20967b);
        }

        public EnumC0353c y() {
            return this.f20971f;
        }

        public int z() {
            return this.f20969d;
        }

        public c(AbstractC2722i.b bVar) {
            super(bVar);
            this.f20972g = (byte) -1;
            this.f20973h = -1;
            this.f20967b = bVar.j();
        }

        public c(boolean z7) {
            this.f20972g = (byte) -1;
            this.f20973h = -1;
            this.f20967b = AbstractC2717d.f23128a;
        }

        public static final class b extends AbstractC2722i.b implements s6.q {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public int f20974b;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public int f20976d;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public int f20975c = -1;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public EnumC0353c f20977e = EnumC0353c.PACKAGE;

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
                int i8 = this.f20974b;
                int i9 = (i8 & 1) != 1 ? 0 : 1;
                cVar.f20969d = this.f20975c;
                if ((i8 & 2) == 2) {
                    i9 |= 2;
                }
                cVar.f20970e = this.f20976d;
                if ((i8 & 4) == 4) {
                    i9 |= 4;
                }
                cVar.f20971f = this.f20977e;
                cVar.f20968c = i9;
                return cVar;
            }

            /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
            public b clone() {
                return r().k(p());
            }

            @Override // s6.AbstractC2722i.b
            /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
            public b k(c cVar) {
                if (cVar == c.x()) {
                    return this;
                }
                if (cVar.C()) {
                    w(cVar.z());
                }
                if (cVar.D()) {
                    x(cVar.A());
                }
                if (cVar.B()) {
                    v(cVar.y());
                }
                l(j().d(cVar.f20967b));
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            @Override // s6.p.a
            /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public l6.o.c.b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
                /*
                    r2 = this;
                    r0 = 0
                    s6.r r1 = l6.o.c.f20966j     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                    java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                    l6.o$c r3 = (l6.o.c) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
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
                    l6.o$c r4 = (l6.o.c) r4     // Catch: java.lang.Throwable -> Lf
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
                throw new UnsupportedOperationException("Method not decompiled: l6.o.c.b.n(s6.e, s6.g):l6.o$c$b");
            }

            public b v(EnumC0353c enumC0353c) {
                enumC0353c.getClass();
                this.f20974b |= 4;
                this.f20977e = enumC0353c;
                return this;
            }

            public b w(int i8) {
                this.f20974b |= 1;
                this.f20975c = i8;
                return this;
            }

            public b x(int i8) {
                this.f20974b |= 2;
                this.f20976d = i8;
                return this;
            }

            private void s() {
            }
        }
    }

    public o(AbstractC2722i.b bVar) {
        super(bVar);
        this.f20961d = (byte) -1;
        this.f20962e = -1;
        this.f20959b = bVar.j();
    }

    public o(boolean z7) {
        this.f20961d = (byte) -1;
        this.f20962e = -1;
        this.f20959b = AbstractC2717d.f23128a;
    }

    public static final class b extends AbstractC2722i.b implements s6.q {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f20963b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public List f20964c = Collections.emptyList();

        public b() {
            t();
        }

        public static b r() {
            return new b();
        }

        @Override // s6.p.a
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public o a() {
            o oVarP = p();
            if (oVarP.e()) {
                return oVarP;
            }
            throw AbstractC2714a.AbstractC0396a.i(oVarP);
        }

        public o p() {
            o oVar = new o(this);
            if ((this.f20963b & 1) == 1) {
                this.f20964c = Collections.unmodifiableList(this.f20964c);
                this.f20963b &= -2;
            }
            oVar.f20960c = this.f20964c;
            return oVar;
        }

        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public b clone() {
            return r().k(p());
        }

        public final void s() {
            if ((this.f20963b & 1) != 1) {
                this.f20964c = new ArrayList(this.f20964c);
                this.f20963b |= 1;
            }
        }

        @Override // s6.AbstractC2722i.b
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public b k(o oVar) {
            if (oVar == o.v()) {
                return this;
            }
            if (!oVar.f20960c.isEmpty()) {
                if (this.f20964c.isEmpty()) {
                    this.f20964c = oVar.f20960c;
                    this.f20963b &= -2;
                } else {
                    s();
                    this.f20964c.addAll(oVar.f20960c);
                }
            }
            l(j().d(oVar.f20959b));
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        @Override // s6.p.a
        /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public l6.o.b n(s6.C2718e r3, s6.C2720g r4) throws java.lang.Throwable {
            /*
                r2 = this;
                r0 = 0
                s6.r r1 = l6.o.f20958g     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                java.lang.Object r3 = r1.b(r3, r4)     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
                l6.o r3 = (l6.o) r3     // Catch: java.lang.Throwable -> Lf s6.C2724k -> L11
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
                l6.o r4 = (l6.o) r4     // Catch: java.lang.Throwable -> Lf
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
            throw new UnsupportedOperationException("Method not decompiled: l6.o.b.n(s6.e, s6.g):l6.o$b");
        }

        private void t() {
        }
    }
}
