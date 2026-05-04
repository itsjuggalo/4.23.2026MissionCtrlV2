package fh;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class u0 extends ch.b implements eh.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f9640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final eh.b f9641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d1 f9642c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final eh.s[] f9643d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final gh.e f9644e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final eh.g f9645f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f9646g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f9647h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f9648i;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9649a;

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
            f9649a = iArr;
        }
    }

    public u0(n composer, eh.b json, d1 mode, eh.s[] sVarArr) {
        kotlin.jvm.internal.t.f(composer, "composer");
        kotlin.jvm.internal.t.f(json, "json");
        kotlin.jvm.internal.t.f(mode, "mode");
        this.f9640a = composer;
        this.f9641b = json;
        this.f9642c = mode;
        this.f9643d = sVarArr;
        this.f9644e = d().a();
        this.f9645f = d().f();
        int iOrdinal = mode.ordinal();
        if (sVarArr != null) {
            eh.s sVar = sVarArr[iOrdinal];
            if (sVar == null && sVar == this) {
                return;
            }
            sVarArr[iOrdinal] = this;
        }
    }

    @Override // ch.b, ch.f
    public void A(int i10) {
        if (this.f9646g) {
            F(String.valueOf(i10));
        } else {
            this.f9640a.i(i10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0061  */
    @Override // ch.b, ch.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void B(zg.k r4, java.lang.Object r5) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fh.u0.B(zg.k, java.lang.Object):void");
    }

    @Override // ch.b, ch.f
    public void D(long j10) {
        if (this.f9646g) {
            F(String.valueOf(j10));
        } else {
            this.f9640a.j(j10);
        }
    }

    @Override // ch.b, ch.f
    public void F(String value) {
        kotlin.jvm.internal.t.f(value, "value");
        this.f9640a.n(value);
    }

    @Override // ch.b
    public boolean G(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        int i11 = a.f9649a[this.f9642c.ordinal()];
        if (i11 != 1) {
            boolean z10 = false;
            if (i11 != 2) {
                if (i11 != 3) {
                    if (!this.f9640a.a()) {
                        this.f9640a.f(',');
                    }
                    this.f9640a.c();
                    F(e0.h(descriptor, d(), i10));
                    this.f9640a.f(':');
                    this.f9640a.p();
                } else {
                    if (i10 == 0) {
                        this.f9646g = true;
                    }
                    if (i10 == 1) {
                        this.f9640a.f(',');
                        this.f9640a.p();
                        this.f9646g = false;
                    }
                }
            } else if (this.f9640a.a()) {
                this.f9646g = true;
                this.f9640a.c();
            } else {
                if (i10 % 2 == 0) {
                    this.f9640a.f(',');
                    this.f9640a.c();
                    z10 = true;
                } else {
                    this.f9640a.f(':');
                    this.f9640a.p();
                }
                this.f9646g = z10;
            }
        } else {
            if (!this.f9640a.a()) {
                this.f9640a.f(',');
            }
            this.f9640a.c();
        }
        return true;
    }

    public final void J(String str, String str2) {
        this.f9640a.c();
        F(str);
        this.f9640a.f(':');
        this.f9640a.p();
        F(str2);
    }

    @Override // ch.f
    public gh.e a() {
        return this.f9644e;
    }

    @Override // ch.b, ch.f
    public ch.d b(bh.e descriptor) {
        eh.s sVar;
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        d1 d1VarB = e1.b(d(), descriptor);
        char c10 = d1VarB.f9562a;
        if (c10 != 0) {
            this.f9640a.f(c10);
            this.f9640a.b();
        }
        String str = this.f9647h;
        if (str != null) {
            String strI = this.f9648i;
            if (strI == null) {
                strI = descriptor.i();
            }
            J(str, strI);
            this.f9647h = null;
            this.f9648i = null;
        }
        if (this.f9642c == d1VarB) {
            return this;
        }
        eh.s[] sVarArr = this.f9643d;
        return (sVarArr == null || (sVar = sVarArr[d1VarB.ordinal()]) == null) ? new u0(this.f9640a, d(), d1VarB, this.f9643d) : sVar;
    }

    @Override // ch.b, ch.d
    public void c(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        if (this.f9642c.f9563b != 0) {
            this.f9640a.q();
            this.f9640a.d();
            this.f9640a.f(this.f9642c.f9563b);
        }
    }

    @Override // eh.s
    public eh.b d() {
        return this.f9641b;
    }

    @Override // ch.b, ch.d
    public void e(bh.e descriptor, int i10, zg.k serializer, Object obj) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        kotlin.jvm.internal.t.f(serializer, "serializer");
        if (obj != null || this.f9645f.j()) {
            super.e(descriptor, i10, serializer, obj);
        }
    }

    @Override // ch.b, ch.f
    public void f() {
        this.f9640a.k("null");
    }

    @Override // ch.b, ch.f
    public void j(double d10) {
        if (this.f9646g) {
            F(String.valueOf(d10));
        } else {
            this.f9640a.g(d10);
        }
        if (this.f9645f.b()) {
            return;
        }
        if (Double.isInfinite(d10) || Double.isNaN(d10)) {
            throw c0.b(Double.valueOf(d10), this.f9640a.f9600a.toString());
        }
    }

    @Override // ch.b, ch.f
    public void k(short s10) {
        if (this.f9646g) {
            F(String.valueOf((int) s10));
        } else {
            this.f9640a.l(s10);
        }
    }

    @Override // ch.b, ch.f
    public void l(byte b10) {
        if (this.f9646g) {
            F(String.valueOf((int) b10));
        } else {
            this.f9640a.e(b10);
        }
    }

    @Override // ch.b, ch.f
    public void m(boolean z10) {
        if (this.f9646g) {
            F(String.valueOf(z10));
        } else {
            this.f9640a.m(z10);
        }
    }

    @Override // ch.b, ch.d
    public boolean o(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return this.f9645f.i();
    }

    @Override // ch.b, ch.f
    public void p(float f10) {
        if (this.f9646g) {
            F(String.valueOf(f10));
        } else {
            this.f9640a.h(f10);
        }
        if (this.f9645f.b()) {
            return;
        }
        if (Float.isInfinite(f10) || Float.isNaN(f10)) {
            throw c0.b(Float.valueOf(f10), this.f9640a.f9600a.toString());
        }
    }

    @Override // ch.b, ch.f
    public void t(char c10) {
        F(String.valueOf(c10));
    }

    @Override // ch.b, ch.f
    public ch.f v(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        if (v0.b(descriptor)) {
            n rVar = this.f9640a;
            if (!(rVar instanceof r)) {
                rVar = new r(rVar.f9600a, this.f9646g);
            }
            return new u0(rVar, d(), this.f9642c, (eh.s[]) null);
        }
        if (v0.a(descriptor)) {
            n oVar = this.f9640a;
            if (!(oVar instanceof o)) {
                oVar = new o(oVar.f9600a, this.f9646g);
            }
            return new u0(oVar, d(), this.f9642c, (eh.s[]) null);
        }
        if (this.f9647h == null) {
            return super.v(descriptor);
        }
        this.f9648i = descriptor.i();
        return this;
    }

    @Override // ch.b, ch.f
    public void y(bh.e enumDescriptor, int i10) {
        kotlin.jvm.internal.t.f(enumDescriptor, "enumDescriptor");
        F(enumDescriptor.m(i10));
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public u0(w output, eh.b json, d1 mode, eh.s[] modeReuseCache) {
        this(t.a(output, json), json, mode, modeReuseCache);
        kotlin.jvm.internal.t.f(output, "output");
        kotlin.jvm.internal.t.f(json, "json");
        kotlin.jvm.internal.t.f(mode, "mode");
        kotlin.jvm.internal.t.f(modeReuseCache, "modeReuseCache");
    }
}
