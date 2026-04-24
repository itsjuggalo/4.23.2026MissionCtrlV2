package L3;

import J3.AbstractC0326b;

/* JADX INFO: loaded from: classes3.dex */
public final class X extends I3.b implements K3.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C0390m f1494a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final K3.a f1495b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f1496c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final K3.l[] f1497d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final M3.e f1498e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final K3.f f1499f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1500g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f1501h;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f1502a;

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
            f1502a = iArr;
        }
    }

    public X(C0390m composer, K3.a json, d0 mode, K3.l[] lVarArr) {
        kotlin.jvm.internal.r.f(composer, "composer");
        kotlin.jvm.internal.r.f(json, "json");
        kotlin.jvm.internal.r.f(mode, "mode");
        this.f1494a = composer;
        this.f1495b = json;
        this.f1496c = mode;
        this.f1497d = lVarArr;
        this.f1498e = b().a();
        this.f1499f = b().f();
        int iOrdinal = mode.ordinal();
        if (lVarArr != null) {
            K3.l lVar = lVarArr[iOrdinal];
            if (lVar == null && lVar == this) {
                return;
            }
            lVarArr[iOrdinal] = this;
        }
    }

    @Override // I3.b, I3.f
    public void B(int i4) {
        if (this.f1500g) {
            F(String.valueOf(i4));
        } else {
            this.f1494a.h(i4);
        }
    }

    @Override // I3.b, I3.f
    public void C(H3.e enumDescriptor, int i4) {
        kotlin.jvm.internal.r.f(enumDescriptor, "enumDescriptor");
        F(enumDescriptor.g(i4));
    }

    @Override // I3.b, I3.f
    public void D(long j4) {
        if (this.f1500g) {
            F(String.valueOf(j4));
        } else {
            this.f1494a.i(j4);
        }
    }

    @Override // I3.b, I3.d
    public void E(H3.e descriptor, int i4, F3.h serializer, Object obj) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(serializer, "serializer");
        if (obj != null || this.f1499f.f()) {
            super.E(descriptor, i4, serializer, obj);
        }
    }

    @Override // I3.b, I3.f
    public void F(String value) {
        kotlin.jvm.internal.r.f(value, "value");
        this.f1494a.m(value);
    }

    @Override // I3.b
    public boolean G(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        int i5 = a.f1502a[this.f1496c.ordinal()];
        if (i5 != 1) {
            boolean z4 = false;
            if (i5 != 2) {
                if (i5 != 3) {
                    if (!this.f1494a.a()) {
                        this.f1494a.e(',');
                    }
                    this.f1494a.c();
                    F(F.f(descriptor, b(), i4));
                    this.f1494a.e(':');
                    this.f1494a.o();
                } else {
                    if (i4 == 0) {
                        this.f1500g = true;
                    }
                    if (i4 == 1) {
                        this.f1494a.e(',');
                        this.f1494a.o();
                        this.f1500g = false;
                    }
                }
            } else if (this.f1494a.a()) {
                this.f1500g = true;
                this.f1494a.c();
            } else {
                if (i4 % 2 == 0) {
                    this.f1494a.e(',');
                    this.f1494a.c();
                    z4 = true;
                } else {
                    this.f1494a.e(':');
                    this.f1494a.o();
                }
                this.f1500g = z4;
            }
        } else {
            if (!this.f1494a.a()) {
                this.f1494a.e(',');
            }
            this.f1494a.c();
        }
        return true;
    }

    public final void J(H3.e eVar) {
        this.f1494a.c();
        String str = this.f1501h;
        kotlin.jvm.internal.r.c(str);
        F(str);
        this.f1494a.e(':');
        this.f1494a.o();
        F(eVar.a());
    }

    @Override // I3.f
    public M3.e a() {
        return this.f1498e;
    }

    @Override // K3.l
    public K3.a b() {
        return this.f1495b;
    }

    @Override // I3.b, I3.d
    public void c(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        if (this.f1496c.f1532b != 0) {
            this.f1494a.p();
            this.f1494a.c();
            this.f1494a.e(this.f1496c.f1532b);
        }
    }

    @Override // I3.b, I3.f
    public I3.d d(H3.e descriptor) {
        K3.l lVar;
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        d0 d0VarB = e0.b(b(), descriptor);
        char c4 = d0VarB.f1531a;
        if (c4 != 0) {
            this.f1494a.e(c4);
            this.f1494a.b();
        }
        if (this.f1501h != null) {
            J(descriptor);
            this.f1501h = null;
        }
        if (this.f1496c == d0VarB) {
            return this;
        }
        K3.l[] lVarArr = this.f1497d;
        return (lVarArr == null || (lVar = lVarArr[d0VarB.ordinal()]) == null) ? new X(this.f1494a, b(), d0VarB, this.f1497d) : lVar;
    }

    @Override // I3.b, I3.f
    public void e() {
        this.f1494a.j("null");
    }

    @Override // I3.b, I3.f
    public I3.f f(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        if (Y.b(descriptor)) {
            C0390m c0397u = this.f1494a;
            if (!(c0397u instanceof C0397u)) {
                c0397u = new C0397u(c0397u.f1540a, this.f1500g);
            }
            return new X(c0397u, b(), this.f1496c, (K3.l[]) null);
        }
        if (!Y.a(descriptor)) {
            return super.f(descriptor);
        }
        C0390m c0391n = this.f1494a;
        if (!(c0391n instanceof C0391n)) {
            c0391n = new C0391n(c0391n.f1540a, this.f1500g);
        }
        return new X(c0391n, b(), this.f1496c, (K3.l[]) null);
    }

    @Override // I3.b, I3.f
    public void h(double d4) {
        if (this.f1500g) {
            F(String.valueOf(d4));
        } else {
            this.f1494a.f(d4);
        }
        if (this.f1499f.a()) {
            return;
        }
        if (Double.isInfinite(d4) || Double.isNaN(d4)) {
            throw E.b(Double.valueOf(d4), this.f1494a.f1540a.toString());
        }
    }

    @Override // I3.b, I3.f
    public void i(short s4) {
        if (this.f1500g) {
            F(String.valueOf((int) s4));
        } else {
            this.f1494a.k(s4);
        }
    }

    @Override // I3.b, I3.d
    public boolean j(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return this.f1499f.e();
    }

    @Override // I3.b, I3.f
    public void m(byte b4) {
        if (this.f1500g) {
            F(String.valueOf((int) b4));
        } else {
            this.f1494a.d(b4);
        }
    }

    @Override // I3.b, I3.f
    public void n(boolean z4) {
        if (this.f1500g) {
            F(String.valueOf(z4));
        } else {
            this.f1494a.l(z4);
        }
    }

    @Override // I3.b, I3.f
    public void p(float f4) {
        if (this.f1500g) {
            F(String.valueOf(f4));
        } else {
            this.f1494a.g(f4);
        }
        if (this.f1499f.a()) {
            return;
        }
        if (Float.isInfinite(f4) || Float.isNaN(f4)) {
            throw E.b(Float.valueOf(f4), this.f1494a.f1540a.toString());
        }
    }

    @Override // I3.b, I3.f
    public void q(char c4) {
        F(String.valueOf(c4));
    }

    @Override // I3.b, I3.f
    public void z(F3.h serializer, Object obj) {
        kotlin.jvm.internal.r.f(serializer, "serializer");
        if (!(serializer instanceof AbstractC0326b) || b().f().l()) {
            serializer.serialize(this, obj);
            return;
        }
        AbstractC0326b abstractC0326b = (AbstractC0326b) serializer;
        String strC = U.c(serializer.getDescriptor(), b());
        kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.Any");
        F3.h hVarB = F3.d.b(abstractC0326b, this, obj);
        U.f(abstractC0326b, hVarB, strC);
        U.b(hVarB.getDescriptor().e());
        this.f1501h = strC;
        hVarB.serialize(this, obj);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public X(T output, K3.a json, d0 mode, K3.l[] modeReuseCache) {
        this(AbstractC0399w.a(output, json), json, mode, modeReuseCache);
        kotlin.jvm.internal.r.f(output, "output");
        kotlin.jvm.internal.r.f(json, "json");
        kotlin.jvm.internal.r.f(mode, "mode");
        kotlin.jvm.internal.r.f(modeReuseCache, "modeReuseCache");
    }
}
