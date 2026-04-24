package L3;

import H3.i;
import H3.j;
import J3.AbstractC0326b;
import io.flutter.embedding.android.KeyboardMap;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: L3.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0381d extends J3.T implements K3.l {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final K3.a f1515b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final i3.k f1516c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final K3.f f1517d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f1518e;

    /* JADX INFO: renamed from: L3.d$a */
    public static final class a extends kotlin.jvm.internal.s implements i3.k {
        public a() {
            super(1);
        }

        public final void a(K3.h node) {
            kotlin.jvm.internal.r.f(node, "node");
            AbstractC0381d abstractC0381d = AbstractC0381d.this;
            abstractC0381d.u0(AbstractC0381d.d0(abstractC0381d), node);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((K3.h) obj);
            return W2.E.f5463a;
        }
    }

    /* JADX INFO: renamed from: L3.d$b */
    public static final class b extends I3.b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f1521b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ H3.e f1522c;

        public b(String str, H3.e eVar) {
            this.f1521b = str;
            this.f1522c = eVar;
        }

        @Override // I3.b, I3.f
        public void F(String value) {
            kotlin.jvm.internal.r.f(value, "value");
            AbstractC0381d.this.u0(this.f1521b, new K3.o(value, false, this.f1522c));
        }

        @Override // I3.f
        public M3.e a() {
            return AbstractC0381d.this.b().a();
        }
    }

    /* JADX INFO: renamed from: L3.d$c */
    public static final class c extends I3.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final M3.e f1523a;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f1525c;

        public c(String str) {
            this.f1525c = str;
            this.f1523a = AbstractC0381d.this.b().a();
        }

        @Override // I3.b, I3.f
        public void B(int i4) {
            J(Long.toString(((long) W2.w.c(i4)) & KeyboardMap.kValueMask, 10));
        }

        @Override // I3.b, I3.f
        public void D(long j4) {
            J(AbstractC0385h.a(W2.y.c(j4), 10));
        }

        public final void J(String s4) {
            kotlin.jvm.internal.r.f(s4, "s");
            AbstractC0381d.this.u0(this.f1525c, new K3.o(s4, false, null, 4, null));
        }

        @Override // I3.f
        public M3.e a() {
            return this.f1523a;
        }

        @Override // I3.b, I3.f
        public void i(short s4) {
            J(W2.B.i(W2.B.c(s4)));
        }

        @Override // I3.b, I3.f
        public void m(byte b4) {
            J(W2.u.i(W2.u.c(b4)));
        }
    }

    public /* synthetic */ AbstractC0381d(K3.a aVar, i3.k kVar, AbstractC1585j abstractC1585j) {
        this(aVar, kVar);
    }

    public static final /* synthetic */ String d0(AbstractC0381d abstractC0381d) {
        return (String) abstractC0381d.U();
    }

    @Override // J3.q0
    public void T(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        this.f1516c.invoke(q0());
    }

    @Override // J3.T
    public String Z(String parentName, String childName) {
        kotlin.jvm.internal.r.f(parentName, "parentName");
        kotlin.jvm.internal.r.f(childName, "childName");
        return childName;
    }

    @Override // I3.f
    public final M3.e a() {
        return this.f1515b.a();
    }

    @Override // J3.T
    public String a0(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return F.f(descriptor, this.f1515b, i4);
    }

    @Override // K3.l
    public final K3.a b() {
        return this.f1515b;
    }

    @Override // I3.f
    public I3.d d(H3.e descriptor) {
        AbstractC0381d m4;
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        i3.k aVar = V() == null ? this.f1516c : new a();
        H3.i iVarE = descriptor.e();
        if (kotlin.jvm.internal.r.b(iVarE, j.b.f767a) ? true : iVarE instanceof H3.c) {
            m4 = new O(this.f1515b, aVar);
        } else if (kotlin.jvm.internal.r.b(iVarE, j.c.f768a)) {
            K3.a aVar2 = this.f1515b;
            H3.e eVarA = e0.a(descriptor.i(0), aVar2.a());
            H3.i iVarE2 = eVarA.e();
            if ((iVarE2 instanceof H3.d) || kotlin.jvm.internal.r.b(iVarE2, i.b.f765a)) {
                m4 = new Q(this.f1515b, aVar);
            } else {
                if (!aVar2.f().b()) {
                    throw E.d(eVarA);
                }
                m4 = new O(this.f1515b, aVar);
            }
        } else {
            m4 = new M(this.f1515b, aVar);
        }
        String str = this.f1518e;
        if (str != null) {
            kotlin.jvm.internal.r.c(str);
            m4.u0(str, K3.i.c(descriptor.a()));
            this.f1518e = null;
        }
        return m4;
    }

    @Override // I3.f
    public void e() {
        String str = (String) V();
        if (str == null) {
            this.f1516c.invoke(K3.s.INSTANCE);
        } else {
            n0(str);
        }
    }

    @Override // J3.q0
    /* JADX INFO: renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void I(String tag, boolean z4) {
        kotlin.jvm.internal.r.f(tag, "tag");
        u0(tag, K3.i.a(Boolean.valueOf(z4)));
    }

    @Override // J3.q0, I3.f
    public I3.f f(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return V() != null ? super.f(descriptor) : new I(this.f1515b, this.f1516c).f(descriptor);
    }

    @Override // J3.q0
    /* JADX INFO: renamed from: f0, reason: merged with bridge method [inline-methods] */
    public void J(String tag, byte b4) {
        kotlin.jvm.internal.r.f(tag, "tag");
        u0(tag, K3.i.b(Byte.valueOf(b4)));
    }

    @Override // J3.q0
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public void K(String tag, char c4) {
        kotlin.jvm.internal.r.f(tag, "tag");
        u0(tag, K3.i.c(String.valueOf(c4)));
    }

    @Override // J3.q0
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public void L(String tag, double d4) {
        kotlin.jvm.internal.r.f(tag, "tag");
        u0(tag, K3.i.b(Double.valueOf(d4)));
        if (this.f1517d.a()) {
            return;
        }
        if (Double.isInfinite(d4) || Double.isNaN(d4)) {
            throw E.c(Double.valueOf(d4), tag, q0().toString());
        }
    }

    @Override // J3.q0
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public void M(String tag, H3.e enumDescriptor, int i4) {
        kotlin.jvm.internal.r.f(tag, "tag");
        kotlin.jvm.internal.r.f(enumDescriptor, "enumDescriptor");
        u0(tag, K3.i.c(enumDescriptor.g(i4)));
    }

    @Override // I3.d
    public boolean j(H3.e descriptor, int i4) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return this.f1517d.e();
    }

    @Override // J3.q0
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public void N(String tag, float f4) {
        kotlin.jvm.internal.r.f(tag, "tag");
        u0(tag, K3.i.b(Float.valueOf(f4)));
        if (this.f1517d.a()) {
            return;
        }
        if (Float.isInfinite(f4) || Float.isNaN(f4)) {
            throw E.c(Float.valueOf(f4), tag, q0().toString());
        }
    }

    @Override // J3.q0
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public I3.f O(String tag, H3.e inlineDescriptor) {
        kotlin.jvm.internal.r.f(tag, "tag");
        kotlin.jvm.internal.r.f(inlineDescriptor, "inlineDescriptor");
        return Y.b(inlineDescriptor) ? t0(tag) : Y.a(inlineDescriptor) ? s0(tag, inlineDescriptor) : super.O(tag, inlineDescriptor);
    }

    @Override // J3.q0
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public void P(String tag, int i4) {
        kotlin.jvm.internal.r.f(tag, "tag");
        u0(tag, K3.i.b(Integer.valueOf(i4)));
    }

    @Override // J3.q0
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void Q(String tag, long j4) {
        kotlin.jvm.internal.r.f(tag, "tag");
        u0(tag, K3.i.b(Long.valueOf(j4)));
    }

    public void n0(String tag) {
        kotlin.jvm.internal.r.f(tag, "tag");
        u0(tag, K3.s.INSTANCE);
    }

    @Override // J3.q0
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public void R(String tag, short s4) {
        kotlin.jvm.internal.r.f(tag, "tag");
        u0(tag, K3.i.b(Short.valueOf(s4)));
    }

    @Override // J3.q0
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public void S(String tag, String value) {
        kotlin.jvm.internal.r.f(tag, "tag");
        kotlin.jvm.internal.r.f(value, "value");
        u0(tag, K3.i.c(value));
    }

    public abstract K3.h q0();

    public final i3.k r0() {
        return this.f1516c;
    }

    public final b s0(String str, H3.e eVar) {
        return new b(str, eVar);
    }

    public final c t0(String str) {
        return new c(str);
    }

    public abstract void u0(String str, K3.h hVar);

    @Override // J3.q0, I3.f
    public void z(F3.h serializer, Object obj) {
        kotlin.jvm.internal.r.f(serializer, "serializer");
        if (V() == null && c0.b(e0.a(serializer.getDescriptor(), a()))) {
            new I(this.f1515b, this.f1516c).z(serializer, obj);
            return;
        }
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
        this.f1518e = strC;
        hVarB.serialize(this, obj);
    }

    public AbstractC0381d(K3.a aVar, i3.k kVar) {
        this.f1515b = aVar;
        this.f1516c = kVar;
        this.f1517d = aVar.f();
    }

    @Override // I3.f
    public void r() {
    }
}
