package t6;

import r6.AbstractC2612b;

/* JADX INFO: loaded from: classes2.dex */
public final class X extends q6.b implements s6.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C2723m f24287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final s6.a f24288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d0 f24289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final s6.l[] f24290d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final u6.e f24291e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final s6.f f24292f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f24293g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f24294h;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f24295a;

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
            f24295a = iArr;
        }
    }

    public X(C2723m composer, s6.a json, d0 mode, s6.l[] lVarArr) {
        kotlin.jvm.internal.r.f(composer, "composer");
        kotlin.jvm.internal.r.f(json, "json");
        kotlin.jvm.internal.r.f(mode, "mode");
        this.f24287a = composer;
        this.f24288b = json;
        this.f24289c = mode;
        this.f24290d = lVarArr;
        this.f24291e = d().a();
        this.f24292f = d().f();
        int iOrdinal = mode.ordinal();
        if (lVarArr != null) {
            s6.l lVar = lVarArr[iOrdinal];
            if (lVar == null && lVar == this) {
                return;
            }
            lVarArr[iOrdinal] = this;
        }
    }

    @Override // q6.b, q6.f
    public void A(int i7) {
        if (this.f24293g) {
            F(String.valueOf(i7));
        } else {
            this.f24287a.h(i7);
        }
    }

    @Override // q6.b, q6.f
    public void B(long j7) {
        if (this.f24293g) {
            F(String.valueOf(j7));
        } else {
            this.f24287a.i(j7);
        }
    }

    @Override // q6.b, q6.d
    public boolean C(p6.e descriptor, int i7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return this.f24292f.e();
    }

    @Override // q6.b, q6.f
    public void F(String value) {
        kotlin.jvm.internal.r.f(value, "value");
        this.f24287a.m(value);
    }

    @Override // q6.b
    public boolean G(p6.e descriptor, int i7) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        int i8 = a.f24295a[this.f24289c.ordinal()];
        if (i8 != 1) {
            boolean z7 = false;
            if (i8 != 2) {
                if (i8 != 3) {
                    if (!this.f24287a.a()) {
                        this.f24287a.e(',');
                    }
                    this.f24287a.c();
                    F(F.f(descriptor, d(), i7));
                    this.f24287a.e(':');
                    this.f24287a.o();
                } else {
                    if (i7 == 0) {
                        this.f24293g = true;
                    }
                    if (i7 == 1) {
                        this.f24287a.e(',');
                        this.f24287a.o();
                        this.f24293g = false;
                    }
                }
            } else if (this.f24287a.a()) {
                this.f24293g = true;
                this.f24287a.c();
            } else {
                if (i7 % 2 == 0) {
                    this.f24287a.e(',');
                    this.f24287a.c();
                    z7 = true;
                } else {
                    this.f24287a.e(':');
                    this.f24287a.o();
                }
                this.f24293g = z7;
            }
        } else {
            if (!this.f24287a.a()) {
                this.f24287a.e(',');
            }
            this.f24287a.c();
        }
        return true;
    }

    public final void J(p6.e eVar) {
        this.f24287a.c();
        String str = this.f24294h;
        kotlin.jvm.internal.r.c(str);
        F(str);
        this.f24287a.e(':');
        this.f24287a.o();
        F(eVar.a());
    }

    @Override // q6.f
    public u6.e a() {
        return this.f24291e;
    }

    @Override // q6.b, q6.d
    public void b(p6.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        if (this.f24289c.f24325b != 0) {
            this.f24287a.p();
            this.f24287a.c();
            this.f24287a.e(this.f24289c.f24325b);
        }
    }

    @Override // q6.b, q6.f
    public q6.d c(p6.e descriptor) {
        s6.l lVar;
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        d0 d0VarB = e0.b(d(), descriptor);
        char c7 = d0VarB.f24324a;
        if (c7 != 0) {
            this.f24287a.e(c7);
            this.f24287a.b();
        }
        if (this.f24294h != null) {
            J(descriptor);
            this.f24294h = null;
        }
        if (this.f24289c == d0VarB) {
            return this;
        }
        s6.l[] lVarArr = this.f24290d;
        return (lVarArr == null || (lVar = lVarArr[d0VarB.ordinal()]) == null) ? new X(this.f24287a, d(), d0VarB, this.f24290d) : lVar;
    }

    @Override // s6.l
    public s6.a d() {
        return this.f24288b;
    }

    @Override // q6.b, q6.f
    public void e() {
        this.f24287a.j("null");
    }

    @Override // q6.b, q6.f
    public void g(double d7) {
        if (this.f24293g) {
            F(String.valueOf(d7));
        } else {
            this.f24287a.f(d7);
        }
        if (this.f24292f.a()) {
            return;
        }
        if (Double.isInfinite(d7) || Double.isNaN(d7)) {
            throw E.b(Double.valueOf(d7), this.f24287a.f24333a.toString());
        }
    }

    @Override // q6.b, q6.f
    public void h(short s7) {
        if (this.f24293g) {
            F(String.valueOf((int) s7));
        } else {
            this.f24287a.k(s7);
        }
    }

    @Override // q6.b, q6.f
    public void j(byte b7) {
        if (this.f24293g) {
            F(String.valueOf((int) b7));
        } else {
            this.f24287a.d(b7);
        }
    }

    @Override // q6.b, q6.f
    public void k(boolean z7) {
        if (this.f24293g) {
            F(String.valueOf(z7));
        } else {
            this.f24287a.l(z7);
        }
    }

    @Override // q6.b, q6.f
    public void n(float f7) {
        if (this.f24293g) {
            F(String.valueOf(f7));
        } else {
            this.f24287a.g(f7);
        }
        if (this.f24292f.a()) {
            return;
        }
        if (Float.isInfinite(f7) || Float.isNaN(f7)) {
            throw E.b(Float.valueOf(f7), this.f24287a.f24333a.toString());
        }
    }

    @Override // q6.b, q6.f
    public void o(p6.e enumDescriptor, int i7) {
        kotlin.jvm.internal.r.f(enumDescriptor, "enumDescriptor");
        F(enumDescriptor.g(i7));
    }

    @Override // q6.b, q6.f
    public void p(char c7) {
        F(String.valueOf(c7));
    }

    @Override // q6.b, q6.d
    public void r(p6.e descriptor, int i7, n6.h serializer, Object obj) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        kotlin.jvm.internal.r.f(serializer, "serializer");
        if (obj != null || this.f24292f.f()) {
            super.r(descriptor, i7, serializer, obj);
        }
    }

    @Override // q6.b, q6.f
    public void s(n6.h serializer, Object obj) {
        kotlin.jvm.internal.r.f(serializer, "serializer");
        if (!(serializer instanceof AbstractC2612b) || d().f().l()) {
            serializer.serialize(this, obj);
            return;
        }
        AbstractC2612b abstractC2612b = (AbstractC2612b) serializer;
        String strC = U.c(serializer.getDescriptor(), d());
        kotlin.jvm.internal.r.d(obj, "null cannot be cast to non-null type kotlin.Any");
        n6.h hVarB = n6.d.b(abstractC2612b, this, obj);
        U.f(abstractC2612b, hVarB, strC);
        U.b(hVarB.getDescriptor().e());
        this.f24294h = strC;
        hVarB.serialize(this, obj);
    }

    @Override // q6.b, q6.f
    public q6.f u(p6.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        if (Y.b(descriptor)) {
            C2723m c2730u = this.f24287a;
            if (!(c2730u instanceof C2730u)) {
                c2730u = new C2730u(c2730u.f24333a, this.f24293g);
            }
            return new X(c2730u, d(), this.f24289c, (s6.l[]) null);
        }
        if (!Y.a(descriptor)) {
            return super.u(descriptor);
        }
        C2723m c2724n = this.f24287a;
        if (!(c2724n instanceof C2724n)) {
            c2724n = new C2724n(c2724n.f24333a, this.f24293g);
        }
        return new X(c2724n, d(), this.f24289c, (s6.l[]) null);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public X(T output, s6.a json, d0 mode, s6.l[] modeReuseCache) {
        this(AbstractC2732w.a(output, json), json, mode, modeReuseCache);
        kotlin.jvm.internal.r.f(output, "output");
        kotlin.jvm.internal.r.f(json, "json");
        kotlin.jvm.internal.r.f(mode, "mode");
        kotlin.jvm.internal.r.f(modeReuseCache, "modeReuseCache");
    }
}
