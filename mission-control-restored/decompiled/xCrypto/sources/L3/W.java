package L3;

import H3.i;
import J3.AbstractC0326b;
import W2.C0739g;
import r3.AbstractC1753A;

/* JADX INFO: loaded from: classes3.dex */
public class W extends I3.a implements K3.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final K3.a f1484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d0 f1485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AbstractC0378a f1486c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final M3.e f1487d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f1488e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f1489f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final K3.f f1490g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final B f1491h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f1492a;

        public a(String str) {
            this.f1492a = str;
        }
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1493a;

        static {
            int[] iArr = new int[d0.values().length];
            try {
                iArr[d0.LIST.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d0.MAP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d0.POLY_OBJ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d0.OBJ.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f1493a = iArr;
        }
    }

    public W(K3.a json, d0 mode, AbstractC0378a lexer, H3.e descriptor, a aVar) {
        kotlin.jvm.internal.r.f(json, "json");
        kotlin.jvm.internal.r.f(mode, "mode");
        kotlin.jvm.internal.r.f(lexer, "lexer");
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        this.f1484a = json;
        this.f1485b = mode;
        this.f1486c = lexer;
        this.f1487d = json.a();
        this.f1488e = -1;
        this.f1489f = aVar;
        K3.f fVarF = json.f();
        this.f1490g = fVarF;
        this.f1491h = fVarF.f() ? null : new B(descriptor);
    }

    @Override // I3.a, I3.e
    public int A(H3.e enumDescriptor) {
        kotlin.jvm.internal.r.f(enumDescriptor, "enumDescriptor");
        return F.i(enumDescriptor, this.f1484a, q(), " at path " + this.f1486c.f1506b.a());
    }

    @Override // I3.a, I3.e
    public byte C() {
        long jP = this.f1486c.p();
        byte b4 = (byte) jP;
        if (jP == b4) {
            return b4;
        }
        AbstractC0378a.y(this.f1486c, "Failed to parse byte for input '" + jP + '\'', 0, null, 6, null);
        throw new C0739g();
    }

    @Override // I3.a, I3.e
    public short F() {
        long jP = this.f1486c.p();
        short s4 = (short) jP;
        if (jP == s4) {
            return s4;
        }
        AbstractC0378a.y(this.f1486c, "Failed to parse short for input '" + jP + '\'', 0, null, 6, null);
        throw new C0739g();
    }

    @Override // I3.a, I3.e
    public float G() {
        AbstractC0378a abstractC0378a = this.f1486c;
        String strS = abstractC0378a.s();
        try {
            float f4 = Float.parseFloat(strS);
            if (this.f1484a.f().a()) {
                return f4;
            }
            if (!Float.isInfinite(f4) && !Float.isNaN(f4)) {
                return f4;
            }
            E.j(this.f1486c, Float.valueOf(f4));
            throw new C0739g();
        } catch (IllegalArgumentException unused) {
            AbstractC0378a.y(abstractC0378a, "Failed to parse type 'float' for input '" + strS + '\'', 0, null, 6, null);
            throw new C0739g();
        }
    }

    @Override // I3.a, I3.e
    public double H() {
        AbstractC0378a abstractC0378a = this.f1486c;
        String strS = abstractC0378a.s();
        try {
            double d4 = Double.parseDouble(strS);
            if (this.f1484a.f().a()) {
                return d4;
            }
            if (!Double.isInfinite(d4) && !Double.isNaN(d4)) {
                return d4;
            }
            E.j(this.f1486c, Double.valueOf(d4));
            throw new C0739g();
        } catch (IllegalArgumentException unused) {
            AbstractC0378a.y(abstractC0378a, "Failed to parse type 'double' for input '" + strS + '\'', 0, null, 6, null);
            throw new C0739g();
        }
    }

    public final void K() {
        if (this.f1486c.E() != 4) {
            return;
        }
        AbstractC0378a.y(this.f1486c, "Unexpected leading comma", 0, null, 6, null);
        throw new C0739g();
    }

    public final boolean L(H3.e eVar, int i4) {
        String strF;
        K3.a aVar = this.f1484a;
        H3.e eVarI = eVar.i(i4);
        if (!eVarI.c() && this.f1486c.M(true)) {
            return true;
        }
        if (!kotlin.jvm.internal.r.b(eVarI.e(), i.b.f765a) || ((eVarI.c() && this.f1486c.M(false)) || (strF = this.f1486c.F(this.f1490g.m())) == null || F.g(eVarI, aVar, strF) != -3)) {
            return false;
        }
        this.f1486c.q();
        return true;
    }

    public final int M() {
        boolean zL = this.f1486c.L();
        if (!this.f1486c.f()) {
            if (!zL) {
                return -1;
            }
            AbstractC0378a.y(this.f1486c, "Unexpected trailing comma", 0, null, 6, null);
            throw new C0739g();
        }
        int i4 = this.f1488e;
        if (i4 != -1 && !zL) {
            AbstractC0378a.y(this.f1486c, "Expected end of the array or comma", 0, null, 6, null);
            throw new C0739g();
        }
        int i5 = i4 + 1;
        this.f1488e = i5;
        return i5;
    }

    public final int N() {
        int i4 = this.f1488e;
        boolean zL = false;
        boolean z4 = i4 % 2 != 0;
        if (!z4) {
            this.f1486c.o(':');
        } else if (i4 != -1) {
            zL = this.f1486c.L();
        }
        if (!this.f1486c.f()) {
            if (!zL) {
                return -1;
            }
            AbstractC0378a.y(this.f1486c, "Expected '}', but had ',' instead", 0, null, 6, null);
            throw new C0739g();
        }
        if (z4) {
            if (this.f1488e == -1) {
                AbstractC0378a abstractC0378a = this.f1486c;
                int i5 = abstractC0378a.f1505a;
                if (zL) {
                    AbstractC0378a.y(abstractC0378a, "Unexpected trailing comma", i5, null, 4, null);
                    throw new C0739g();
                }
            } else {
                AbstractC0378a abstractC0378a2 = this.f1486c;
                boolean z5 = zL;
                int i6 = abstractC0378a2.f1505a;
                if (!z5) {
                    AbstractC0378a.y(abstractC0378a2, "Expected comma after the key-value pair", i6, null, 4, null);
                    throw new C0739g();
                }
            }
        }
        int i7 = this.f1488e + 1;
        this.f1488e = i7;
        return i7;
    }

    public final int O(H3.e eVar) {
        boolean zL;
        boolean zL2 = this.f1486c.L();
        while (this.f1486c.f()) {
            String strP = P();
            this.f1486c.o(':');
            int iG = F.g(eVar, this.f1484a, strP);
            boolean z4 = false;
            if (iG == -3) {
                z4 = true;
                zL = false;
            } else {
                if (!this.f1490g.d() || !L(eVar, iG)) {
                    B b4 = this.f1491h;
                    if (b4 != null) {
                        b4.c(iG);
                    }
                    return iG;
                }
                zL = this.f1486c.L();
            }
            zL2 = z4 ? Q(strP) : zL;
        }
        if (zL2) {
            AbstractC0378a.y(this.f1486c, "Unexpected trailing comma", 0, null, 6, null);
            throw new C0739g();
        }
        B b5 = this.f1491h;
        if (b5 != null) {
            return b5.d();
        }
        return -1;
    }

    public final String P() {
        return this.f1490g.m() ? this.f1486c.t() : this.f1486c.k();
    }

    public final boolean Q(String str) {
        if (this.f1490g.g() || S(this.f1489f, str)) {
            this.f1486c.H(this.f1490g.m());
        } else {
            this.f1486c.A(str);
        }
        return this.f1486c.L();
    }

    public final void R(H3.e eVar) {
        while (i(eVar) != -1) {
        }
    }

    public final boolean S(a aVar, String str) {
        if (aVar == null || !kotlin.jvm.internal.r.b(aVar.f1492a, str)) {
            return false;
        }
        aVar.f1492a = null;
        return true;
    }

    @Override // I3.c
    public M3.e a() {
        return this.f1487d;
    }

    @Override // K3.g
    public final K3.a b() {
        return this.f1484a;
    }

    @Override // I3.a, I3.c
    public void c(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        if (this.f1484a.f().g() && descriptor.f() == 0) {
            R(descriptor);
        }
        this.f1486c.o(this.f1485b.f1532b);
        this.f1486c.f1506b.b();
    }

    @Override // I3.a, I3.e
    public I3.c d(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        d0 d0VarB = e0.b(this.f1484a, descriptor);
        this.f1486c.f1506b.c(descriptor);
        this.f1486c.o(d0VarB.f1531a);
        K();
        int i4 = b.f1493a[d0VarB.ordinal()];
        return (i4 == 1 || i4 == 2 || i4 == 3) ? new W(this.f1484a, d0VarB, this.f1486c, descriptor, this.f1489f) : (this.f1485b == d0VarB && this.f1484a.f().f()) ? this : new W(this.f1484a, d0VarB, this.f1486c, descriptor, this.f1489f);
    }

    @Override // I3.a, I3.e
    public boolean e() {
        return this.f1490g.m() ? this.f1486c.i() : this.f1486c.g();
    }

    @Override // I3.a, I3.e
    public char f() {
        String strS = this.f1486c.s();
        if (strS.length() == 1) {
            return strS.charAt(0);
        }
        AbstractC0378a.y(this.f1486c, "Expected single char, but got '" + strS + '\'', 0, null, 6, null);
        throw new C0739g();
    }

    @Override // I3.a, I3.e
    public I3.e g(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return Y.b(descriptor) ? new C0402z(this.f1486c, this.f1484a) : super.g(descriptor);
    }

    @Override // I3.c
    public int i(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        int i4 = b.f1493a[this.f1485b.ordinal()];
        int iM = i4 != 2 ? i4 != 4 ? M() : O(descriptor) : N();
        if (this.f1485b != d0.MAP) {
            this.f1486c.f1506b.g(iM);
        }
        return iM;
    }

    @Override // K3.g
    public K3.h k() {
        return new S(this.f1484a.f(), this.f1486c).e();
    }

    @Override // I3.a, I3.e
    public int l() {
        long jP = this.f1486c.p();
        int i4 = (int) jP;
        if (jP == i4) {
            return i4;
        }
        AbstractC0378a.y(this.f1486c, "Failed to parse int for input '" + jP + '\'', 0, null, 6, null);
        throw new C0739g();
    }

    @Override // I3.a, I3.c
    public Object m(H3.e descriptor, int i4, F3.a deserializer, Object obj) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(deserializer, "deserializer");
        boolean z4 = this.f1485b == d0.MAP && (i4 & 1) == 0;
        if (z4) {
            this.f1486c.f1506b.d();
        }
        Object objM = super.m(descriptor, i4, deserializer, obj);
        if (z4) {
            this.f1486c.f1506b.f(objM);
        }
        return objM;
    }

    @Override // I3.a, I3.e
    public Void o() {
        return null;
    }

    @Override // I3.a, I3.e
    public Object p(F3.a deserializer) {
        kotlin.jvm.internal.r.f(deserializer, "deserializer");
        try {
            if ((deserializer instanceof AbstractC0326b) && !this.f1484a.f().l()) {
                String strC = U.c(deserializer.getDescriptor(), this.f1484a);
                String strL = this.f1486c.l(strC, this.f1490g.m());
                F3.a aVarC = strL != null ? ((AbstractC0326b) deserializer).c(this, strL) : null;
                if (aVarC == null) {
                    return U.d(this, deserializer);
                }
                this.f1489f = new a(strC);
                return aVarC.deserialize(this);
            }
            return deserializer.deserialize(this);
        } catch (F3.c e4) {
            String message = e4.getMessage();
            kotlin.jvm.internal.r.c(message);
            if (AbstractC1753A.I(message, "at path", false, 2, null)) {
                throw e4;
            }
            throw new F3.c(e4.a(), e4.getMessage() + " at path: " + this.f1486c.f1506b.a(), e4);
        }
    }

    @Override // I3.a, I3.e
    public String q() {
        return this.f1490g.m() ? this.f1486c.t() : this.f1486c.q();
    }

    @Override // I3.a, I3.e
    public long r() {
        return this.f1486c.p();
    }

    @Override // I3.a, I3.e
    public boolean t() {
        B b4 = this.f1491h;
        return ((b4 != null ? b4.b() : false) || AbstractC0378a.N(this.f1486c, false, 1, null)) ? false : true;
    }
}
