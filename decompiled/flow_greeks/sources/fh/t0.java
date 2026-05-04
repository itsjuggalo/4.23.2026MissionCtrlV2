package fh;

import bh.l;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public class t0 extends ch.a implements eh.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final eh.b f9630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d1 f9631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final fh.a f9632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final gh.e f9633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9634e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f9635f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final eh.g f9636g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final z f9637h;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f9638a;

        public a(String str) {
            this.f9638a = str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9639a;

        static {
            int[] iArr = new int[d1.values().length];
            try {
                iArr[d1.f9557d.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d1.f9558e.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d1.f9559f.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d1.f9556c.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f9639a = iArr;
        }
    }

    public t0(eh.b json, d1 mode, fh.a lexer, bh.e descriptor, a aVar) {
        kotlin.jvm.internal.t.f(json, "json");
        kotlin.jvm.internal.t.f(mode, "mode");
        kotlin.jvm.internal.t.f(lexer, "lexer");
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        this.f9630a = json;
        this.f9631b = mode;
        this.f9632c = lexer;
        this.f9633d = json.a();
        this.f9634e = -1;
        this.f9635f = aVar;
        eh.g gVarF = json.f();
        this.f9636g = gVarF;
        this.f9637h = gVarF.j() ? null : new z(descriptor);
    }

    @Override // ch.a, ch.e
    public ch.e A(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return v0.b(descriptor) ? new x(this.f9632c, this.f9630a) : super.A(descriptor);
    }

    @Override // ch.a, ch.e
    public byte D() {
        long jM = this.f9632c.m();
        byte b10 = (byte) jM;
        if (jM == b10) {
            return b10;
        }
        fh.a.x(this.f9632c, "Failed to parse byte for input '" + jM + '\'', 0, null, 6, null);
        throw new cd.h();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0157  */
    @Override // ch.a, ch.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object E(zg.a r12) {
        /*
            Method dump skipped, instruction units count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fh.t0.E(zg.a):java.lang.Object");
    }

    @Override // ch.a, ch.e
    public short F() {
        long jM = this.f9632c.m();
        short s10 = (short) jM;
        if (jM == s10) {
            return s10;
        }
        fh.a.x(this.f9632c, "Failed to parse short for input '" + jM + '\'', 0, null, 6, null);
        throw new cd.h();
    }

    @Override // ch.a, ch.e
    public float G() {
        fh.a aVar = this.f9632c;
        String strQ = aVar.q();
        try {
            float f10 = Float.parseFloat(strQ);
            if (this.f9630a.f().b()) {
                return f10;
            }
            if (!Float.isInfinite(f10) && !Float.isNaN(f10)) {
                return f10;
            }
            c0.l(this.f9632c, Float.valueOf(f10));
            throw new cd.h();
        } catch (IllegalArgumentException unused) {
            fh.a.x(aVar, "Failed to parse type 'float' for input '" + strQ + '\'', 0, null, 6, null);
            throw new cd.h();
        }
    }

    @Override // ch.a, ch.e
    public double H() {
        fh.a aVar = this.f9632c;
        String strQ = aVar.q();
        try {
            double d10 = Double.parseDouble(strQ);
            if (this.f9630a.f().b()) {
                return d10;
            }
            if (!Double.isInfinite(d10) && !Double.isNaN(d10)) {
                return d10;
            }
            c0.l(this.f9632c, Double.valueOf(d10));
            throw new cd.h();
        } catch (IllegalArgumentException unused) {
            fh.a.x(aVar, "Failed to parse type 'double' for input '" + strQ + '\'', 0, null, 6, null);
            throw new cd.h();
        }
    }

    public final void K() {
        if (this.f9632c.F() != 4) {
            return;
        }
        fh.a.x(this.f9632c, "Unexpected leading comma", 0, null, 6, null);
        throw new cd.h();
    }

    public final boolean L(bh.e eVar, int i10) {
        String strG;
        eh.b bVar = this.f9630a;
        boolean zP = eVar.p(i10);
        bh.e eVarO = eVar.o(i10);
        if (zP && !eVarO.j() && this.f9632c.N(true)) {
            return true;
        }
        if (!kotlin.jvm.internal.t.b(eVarO.h(), l.b.f3401a) || ((eVarO.j() && this.f9632c.N(false)) || (strG = this.f9632c.G(this.f9636g.q())) == null)) {
            return false;
        }
        int i11 = e0.i(eVarO, bVar, strG);
        boolean z10 = !bVar.f().j() && eVarO.j();
        if (i11 == -3 && (zP || z10)) {
            this.f9632c.o();
            return true;
        }
        return false;
    }

    public final int M() {
        boolean zM = this.f9632c.M();
        if (!this.f9632c.e()) {
            if (!zM || this.f9630a.f().d()) {
                return -1;
            }
            c0.h(this.f9632c, "array");
            throw new cd.h();
        }
        int i10 = this.f9634e;
        if (i10 != -1 && !zM) {
            fh.a.x(this.f9632c, "Expected end of the array or comma", 0, null, 6, null);
            throw new cd.h();
        }
        int i11 = i10 + 1;
        this.f9634e = i11;
        return i11;
    }

    public final int N() {
        int i10 = this.f9634e;
        boolean zM = false;
        boolean z10 = i10 % 2 != 0;
        if (!z10) {
            this.f9632c.l(':');
        } else if (i10 != -1) {
            zM = this.f9632c.M();
        }
        if (!this.f9632c.e()) {
            if (!zM || this.f9630a.f().d()) {
                return -1;
            }
            c0.i(this.f9632c, null, 1, null);
            throw new cd.h();
        }
        if (z10) {
            if (this.f9634e == -1) {
                fh.a aVar = this.f9632c;
                int i11 = aVar.f9544a;
                if (zM) {
                    fh.a.x(aVar, "Unexpected leading comma", i11, null, 4, null);
                    throw new cd.h();
                }
            } else {
                fh.a aVar2 = this.f9632c;
                boolean z11 = zM;
                int i12 = aVar2.f9544a;
                if (!z11) {
                    fh.a.x(aVar2, "Expected comma after the key-value pair", i12, null, 4, null);
                    throw new cd.h();
                }
            }
        }
        int i13 = this.f9634e + 1;
        this.f9634e = i13;
        return i13;
    }

    public final int O(bh.e eVar) {
        int i10;
        boolean zM;
        boolean zM2 = this.f9632c.M();
        while (true) {
            boolean z10 = true;
            if (!this.f9632c.e()) {
                if (zM2 && !this.f9630a.f().d()) {
                    c0.i(this.f9632c, null, 1, null);
                    throw new cd.h();
                }
                z zVar = this.f9637h;
                if (zVar != null) {
                    return zVar.d();
                }
                return -1;
            }
            String strP = P();
            this.f9632c.l(':');
            i10 = e0.i(eVar, this.f9630a, strP);
            if (i10 == -3) {
                zM = false;
            } else {
                if (!this.f9636g.g() || !L(eVar, i10)) {
                    break;
                }
                zM = this.f9632c.M();
                z10 = false;
            }
            zM2 = z10 ? Q(strP) : zM;
        }
        z zVar2 = this.f9637h;
        if (zVar2 != null) {
            zVar2.c(i10);
        }
        return i10;
    }

    public final String P() {
        return this.f9636g.q() ? this.f9632c.r() : this.f9632c.i();
    }

    public final boolean Q(String str) {
        if (this.f9636g.k() || S(this.f9635f, str)) {
            this.f9632c.I(this.f9636g.q());
        } else {
            this.f9632c.A(str);
        }
        return this.f9632c.M();
    }

    public final void R(bh.e eVar) {
        while (w(eVar) != -1) {
        }
    }

    public final boolean S(a aVar, String str) {
        if (aVar == null || !kotlin.jvm.internal.t.b(aVar.f9638a, str)) {
            return false;
        }
        aVar.f9638a = null;
        return true;
    }

    @Override // ch.c
    public gh.e a() {
        return this.f9633d;
    }

    @Override // ch.a, ch.e
    public ch.c b(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        d1 d1VarB = e1.b(this.f9630a, descriptor);
        this.f9632c.f9545b.c(descriptor);
        this.f9632c.l(d1VarB.f9562a);
        K();
        int i10 = b.f9639a[d1VarB.ordinal()];
        return (i10 == 1 || i10 == 2 || i10 == 3) ? new t0(this.f9630a, d1VarB, this.f9632c, descriptor, this.f9635f) : (this.f9631b == d1VarB && this.f9630a.f().j()) ? this : new t0(this.f9630a, d1VarB, this.f9632c, descriptor, this.f9635f);
    }

    @Override // ch.a, ch.c
    public void c(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        if (this.f9630a.f().k() && descriptor.l() == 0) {
            R(descriptor);
        }
        if (this.f9632c.M() && !this.f9630a.f().d()) {
            c0.h(this.f9632c, "");
            throw new cd.h();
        }
        this.f9632c.l(this.f9631b.f9563b);
        this.f9632c.f9545b.b();
    }

    @Override // eh.h
    public final eh.b d() {
        return this.f9630a;
    }

    @Override // ch.a, ch.e
    public boolean e() {
        return this.f9632c.g();
    }

    @Override // ch.a, ch.e
    public char f() {
        String strQ = this.f9632c.q();
        if (strQ.length() == 1) {
            return strQ.charAt(0);
        }
        fh.a.x(this.f9632c, "Expected single char, but got '" + strQ + '\'', 0, null, 6, null);
        throw new cd.h();
    }

    @Override // ch.a, ch.c
    public Object h(bh.e descriptor, int i10, zg.a deserializer, Object obj) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        kotlin.jvm.internal.t.f(deserializer, "deserializer");
        boolean z10 = this.f9631b == d1.f9558e && (i10 & 1) == 0;
        if (z10) {
            this.f9632c.f9545b.d();
        }
        Object objH = super.h(descriptor, i10, deserializer, obj);
        if (z10) {
            this.f9632c.f9545b.f(objH);
        }
        return objH;
    }

    @Override // eh.h
    public eh.i i() {
        return new q0(this.f9630a.f(), this.f9632c).e();
    }

    @Override // ch.a, ch.e
    public int j() {
        long jM = this.f9632c.m();
        int i10 = (int) jM;
        if (jM == i10) {
            return i10;
        }
        fh.a.x(this.f9632c, "Failed to parse int for input '" + jM + '\'', 0, null, 6, null);
        throw new cd.h();
    }

    @Override // ch.a, ch.e
    public Void l() {
        return null;
    }

    @Override // ch.a, ch.e
    public String m() {
        return this.f9636g.q() ? this.f9632c.r() : this.f9632c.o();
    }

    @Override // ch.a, ch.e
    public long q() {
        return this.f9632c.m();
    }

    @Override // ch.a, ch.e
    public boolean t() {
        z zVar = this.f9637h;
        return ((zVar != null ? zVar.b() : false) || fh.a.O(this.f9632c, false, 1, null)) ? false : true;
    }

    @Override // ch.c
    public int w(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        int i10 = b.f9639a[this.f9631b.ordinal()];
        int iM = i10 != 2 ? i10 != 4 ? M() : O(descriptor) : N();
        if (this.f9631b != d1.f9558e) {
            this.f9632c.f9545b.g(iM);
        }
        return iM;
    }

    @Override // ch.a, ch.e
    public int x(bh.e enumDescriptor) {
        kotlin.jvm.internal.t.f(enumDescriptor, "enumDescriptor");
        return e0.j(enumDescriptor, this.f9630a, m(), " at path " + this.f9632c.f9545b.a());
    }
}
