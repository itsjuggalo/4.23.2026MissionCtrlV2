package fh;

import bh.l;
import bh.m;
import io.flutter.embedding.android.KeyboardMap;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e extends dh.u0 implements eh.s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final eh.b f9564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pd.k f9565c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final eh.g f9566d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f9567e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f9568f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends ch.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f9570b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ bh.e f9571c;

        public a(String str, bh.e eVar) {
            this.f9570b = str;
            this.f9571c = eVar;
        }

        @Override // ch.b, ch.f
        public void F(String value) {
            kotlin.jvm.internal.t.f(value, "value");
            e.this.v0(this.f9570b, new eh.v(value, false, this.f9571c));
        }

        @Override // ch.f
        public gh.e a() {
            return e.this.d().a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends ch.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final gh.e f9572a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f9574c;

        public b(String str) {
            this.f9574c = str;
            this.f9572a = e.this.d().a();
        }

        @Override // ch.b, ch.f
        public void A(int i10) {
            J(Long.toString(((long) cd.z.b(i10)) & KeyboardMap.kValueMask, 10));
        }

        @Override // ch.b, ch.f
        public void D(long j10) {
            J(h.a(cd.b0.b(j10), 10));
        }

        public final void J(String s10) {
            kotlin.jvm.internal.t.f(s10, "s");
            e.this.v0(this.f9574c, new eh.v(s10, false, null, 4, null));
        }

        @Override // ch.f
        public gh.e a() {
            return this.f9572a;
        }

        @Override // ch.b, ch.f
        public void k(short s10) {
            J(cd.e0.i(cd.e0.b(s10)));
        }

        @Override // ch.b, ch.f
        public void l(byte b10) {
            J(cd.x.i(cd.x.b(b10)));
        }
    }

    public /* synthetic */ e(eh.b bVar, pd.k kVar, kotlin.jvm.internal.k kVar2) {
        this(bVar, kVar);
    }

    public static final cd.h0 e0(e eVar, eh.i node) {
        kotlin.jvm.internal.t.f(node, "node");
        eVar.v0((String) eVar.U(), node);
        return cd.h0.f3852a;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0087  */
    @Override // dh.a2, ch.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void B(zg.k r4, java.lang.Object r5) {
        /*
            Method dump skipped, instruction units count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fh.e.B(zg.k, java.lang.Object):void");
    }

    @Override // dh.a2
    public void T(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        this.f9565c.invoke(r0());
    }

    @Override // dh.u0
    public String Z(String parentName, String childName) {
        kotlin.jvm.internal.t.f(parentName, "parentName");
        kotlin.jvm.internal.t.f(childName, "childName");
        return childName;
    }

    @Override // ch.f
    public final gh.e a() {
        return this.f9564b.a();
    }

    @Override // dh.u0
    public String a0(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return e0.h(descriptor, this.f9564b, i10);
    }

    @Override // ch.f
    public ch.d b(bh.e descriptor) {
        e n0Var;
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        pd.k kVar = V() == null ? this.f9565c : new pd.k() { // from class: fh.d
            @Override // pd.k
            public final Object invoke(Object obj) {
                return e.e0(this.f9553a, (eh.i) obj);
            }
        };
        bh.l lVarH = descriptor.h();
        if (kotlin.jvm.internal.t.b(lVarH, m.b.f3403a) || (lVarH instanceof bh.c)) {
            n0Var = new n0(this.f9564b, kVar);
        } else if (kotlin.jvm.internal.t.b(lVarH, m.c.f3404a)) {
            eh.b bVar = this.f9564b;
            bh.e eVarA = e1.a(descriptor.o(0), bVar.a());
            bh.l lVarH2 = eVarA.h();
            if ((lVarH2 instanceof bh.d) || kotlin.jvm.internal.t.b(lVarH2, l.b.f3401a)) {
                n0Var = new p0(this.f9564b, kVar);
            } else {
                if (!bVar.f().c()) {
                    throw c0.d(eVarA);
                }
                n0Var = new n0(this.f9564b, kVar);
            }
        } else {
            n0Var = new l0(this.f9564b, kVar);
        }
        String str = this.f9567e;
        if (str != null) {
            if (n0Var instanceof p0) {
                p0 p0Var = (p0) n0Var;
                p0Var.v0("key", eh.j.c(str));
                String strI = this.f9568f;
                if (strI == null) {
                    strI = descriptor.i();
                }
                p0Var.v0("value", eh.j.c(strI));
            } else {
                String strI2 = this.f9568f;
                if (strI2 == null) {
                    strI2 = descriptor.i();
                }
                n0Var.v0(str, eh.j.c(strI2));
            }
            this.f9567e = null;
            this.f9568f = null;
        }
        return n0Var;
    }

    @Override // eh.s
    public final eh.b d() {
        return this.f9564b;
    }

    @Override // ch.f
    public void f() {
        String str = (String) V();
        if (str == null) {
            this.f9565c.invoke(eh.z.INSTANCE);
        } else {
            o0(str);
        }
    }

    @Override // dh.a2
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public void I(String tag, boolean z10) {
        kotlin.jvm.internal.t.f(tag, "tag");
        v0(tag, eh.j.a(Boolean.valueOf(z10)));
    }

    @Override // dh.a2
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public void J(String tag, byte b10) {
        kotlin.jvm.internal.t.f(tag, "tag");
        v0(tag, eh.j.b(Byte.valueOf(b10)));
    }

    @Override // dh.a2
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public void K(String tag, char c10) {
        kotlin.jvm.internal.t.f(tag, "tag");
        v0(tag, eh.j.c(String.valueOf(c10)));
    }

    @Override // dh.a2
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void L(String tag, double d10) {
        kotlin.jvm.internal.t.f(tag, "tag");
        v0(tag, eh.j.b(Double.valueOf(d10)));
        if (this.f9566d.b()) {
            return;
        }
        if (Double.isInfinite(d10) || Double.isNaN(d10)) {
            throw c0.c(Double.valueOf(d10), tag, r0().toString());
        }
    }

    @Override // dh.a2
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void M(String tag, bh.e enumDescriptor, int i10) {
        kotlin.jvm.internal.t.f(tag, "tag");
        kotlin.jvm.internal.t.f(enumDescriptor, "enumDescriptor");
        v0(tag, eh.j.c(enumDescriptor.m(i10)));
    }

    @Override // dh.a2
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public void N(String tag, float f10) {
        kotlin.jvm.internal.t.f(tag, "tag");
        v0(tag, eh.j.b(Float.valueOf(f10)));
        if (this.f9566d.b()) {
            return;
        }
        if (Float.isInfinite(f10) || Float.isNaN(f10)) {
            throw c0.c(Float.valueOf(f10), tag, r0().toString());
        }
    }

    @Override // dh.a2
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public ch.f O(String tag, bh.e inlineDescriptor) {
        kotlin.jvm.internal.t.f(tag, "tag");
        kotlin.jvm.internal.t.f(inlineDescriptor, "inlineDescriptor");
        return v0.b(inlineDescriptor) ? u0(tag) : v0.a(inlineDescriptor) ? t0(tag, inlineDescriptor) : super.O(tag, inlineDescriptor);
    }

    @Override // dh.a2
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void P(String tag, int i10) {
        kotlin.jvm.internal.t.f(tag, "tag");
        v0(tag, eh.j.b(Integer.valueOf(i10)));
    }

    @Override // dh.a2
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public void Q(String tag, long j10) {
        kotlin.jvm.internal.t.f(tag, "tag");
        v0(tag, eh.j.b(Long.valueOf(j10)));
    }

    @Override // ch.d
    public boolean o(bh.e descriptor, int i10) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return this.f9566d.i();
    }

    public void o0(String tag) {
        kotlin.jvm.internal.t.f(tag, "tag");
        v0(tag, eh.z.INSTANCE);
    }

    @Override // dh.a2
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void R(String tag, short s10) {
        kotlin.jvm.internal.t.f(tag, "tag");
        v0(tag, eh.j.b(Short.valueOf(s10)));
    }

    @Override // dh.a2
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public void S(String tag, String value) {
        kotlin.jvm.internal.t.f(tag, "tag");
        kotlin.jvm.internal.t.f(value, "value");
        v0(tag, eh.j.c(value));
    }

    public abstract eh.i r0();

    public final pd.k s0() {
        return this.f9565c;
    }

    public final a t0(String str, bh.e eVar) {
        return new a(str, eVar);
    }

    public final b u0(String str) {
        return new b(str);
    }

    @Override // dh.a2, ch.f
    public ch.f v(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        if (V() == null) {
            return new h0(this.f9564b, this.f9565c).v(descriptor);
        }
        if (this.f9567e != null) {
            this.f9568f = descriptor.i();
        }
        return super.v(descriptor);
    }

    public abstract void v0(String str, eh.i iVar);

    public e(eh.b bVar, pd.k kVar) {
        this.f9564b = bVar;
        this.f9565c = kVar;
        this.f9566d = bVar.f();
    }

    @Override // ch.f
    public void u() {
    }
}
