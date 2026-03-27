package L3;

import H3.i;
import H3.j;
import W2.C0739g;
import kotlin.jvm.internal.AbstractC1585j;

/* JADX INFO: renamed from: L3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0380c extends J3.S implements K3.g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final K3.a f1511c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final K3.h f1512d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final K3.f f1513e;

    public /* synthetic */ AbstractC0380c(K3.a aVar, K3.h hVar, AbstractC1585j abstractC1585j) {
        this(aVar, hVar);
    }

    @Override // J3.S
    public String Z(String parentName, String childName) {
        kotlin.jvm.internal.r.f(parentName, "parentName");
        kotlin.jvm.internal.r.f(childName, "childName");
        return childName;
    }

    @Override // I3.c
    public M3.e a() {
        return b().a();
    }

    @Override // K3.g
    public K3.a b() {
        return this.f1511c;
    }

    public void c(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
    }

    @Override // I3.e
    public I3.c d(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        K3.h hVarF0 = f0();
        H3.i iVarE = descriptor.e();
        if (kotlin.jvm.internal.r.b(iVarE, j.b.f767a) ? true : iVarE instanceof H3.c) {
            K3.a aVarB = b();
            if (hVarF0 instanceof K3.b) {
                return new N(aVarB, (K3.b) hVarF0);
            }
            throw E.e(-1, "Expected " + kotlin.jvm.internal.G.b(K3.b.class) + " as the serialized body of " + descriptor.a() + ", but had " + kotlin.jvm.internal.G.b(hVarF0.getClass()));
        }
        if (!kotlin.jvm.internal.r.b(iVarE, j.c.f768a)) {
            K3.a aVarB2 = b();
            if (hVarF0 instanceof K3.u) {
                return new L(aVarB2, (K3.u) hVarF0, null, null, 12, null);
            }
            throw E.e(-1, "Expected " + kotlin.jvm.internal.G.b(K3.u.class) + " as the serialized body of " + descriptor.a() + ", but had " + kotlin.jvm.internal.G.b(hVarF0.getClass()));
        }
        K3.a aVarB3 = b();
        H3.e eVarA = e0.a(descriptor.i(0), aVarB3.a());
        H3.i iVarE2 = eVarA.e();
        if ((iVarE2 instanceof H3.d) || kotlin.jvm.internal.r.b(iVarE2, i.b.f765a)) {
            K3.a aVarB4 = b();
            if (hVarF0 instanceof K3.u) {
                return new P(aVarB4, (K3.u) hVarF0);
            }
            throw E.e(-1, "Expected " + kotlin.jvm.internal.G.b(K3.u.class) + " as the serialized body of " + descriptor.a() + ", but had " + kotlin.jvm.internal.G.b(hVarF0.getClass()));
        }
        if (!aVarB3.f().b()) {
            throw E.d(eVarA);
        }
        K3.a aVarB5 = b();
        if (hVarF0 instanceof K3.b) {
            return new N(aVarB5, (K3.b) hVarF0);
        }
        throw E.e(-1, "Expected " + kotlin.jvm.internal.G.b(K3.b.class) + " as the serialized body of " + descriptor.a() + ", but had " + kotlin.jvm.internal.G.b(hVarF0.getClass()));
    }

    public final K3.o d0(K3.w wVar, String str) {
        K3.o oVar = wVar instanceof K3.o ? (K3.o) wVar : null;
        if (oVar != null) {
            return oVar;
        }
        throw E.e(-1, "Unexpected 'null' when " + str + " was expected");
    }

    public abstract K3.h e0(String str);

    public final K3.h f0() {
        K3.h hVarE0;
        String str = (String) U();
        return (str == null || (hVarE0 = e0(str)) == null) ? s0() : hVarE0;
    }

    @Override // J3.p0, I3.e
    public I3.e g(H3.e descriptor) {
        kotlin.jvm.internal.r.f(descriptor, "descriptor");
        return U() != null ? super.g(descriptor) : new H(b(), s0()).g(descriptor);
    }

    @Override // J3.p0
    /* JADX INFO: renamed from: g0, reason: merged with bridge method [inline-methods] */
    public boolean J(String tag) {
        kotlin.jvm.internal.r.f(tag, "tag");
        K3.w wVarR0 = r0(tag);
        if (!b().f().m() && d0(wVarR0, "boolean").i()) {
            throw E.f(-1, "Boolean literal for key '" + tag + "' should be unquoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", f0().toString());
        }
        try {
            Boolean boolE = K3.i.e(wVarR0);
            if (boolE != null) {
                return boolE.booleanValue();
            }
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException unused) {
            t0("boolean");
            throw new C0739g();
        }
    }

    @Override // J3.p0
    /* JADX INFO: renamed from: h0, reason: merged with bridge method [inline-methods] */
    public byte K(String tag) {
        kotlin.jvm.internal.r.f(tag, "tag");
        try {
            int iK = K3.i.k(r0(tag));
            Byte bValueOf = (-128 > iK || iK > 127) ? null : Byte.valueOf((byte) iK);
            if (bValueOf != null) {
                return bValueOf.byteValue();
            }
            t0("byte");
            throw new C0739g();
        } catch (IllegalArgumentException unused) {
            t0("byte");
            throw new C0739g();
        }
    }

    @Override // J3.p0
    /* JADX INFO: renamed from: i0, reason: merged with bridge method [inline-methods] */
    public char L(String tag) {
        kotlin.jvm.internal.r.f(tag, "tag");
        try {
            return r3.C.L0(r0(tag).f());
        } catch (IllegalArgumentException unused) {
            t0("char");
            throw new C0739g();
        }
    }

    @Override // J3.p0
    /* JADX INFO: renamed from: j0, reason: merged with bridge method [inline-methods] */
    public double M(String tag) {
        kotlin.jvm.internal.r.f(tag, "tag");
        try {
            double dG = K3.i.g(r0(tag));
            if (b().f().a()) {
                return dG;
            }
            if (Double.isInfinite(dG) || Double.isNaN(dG)) {
                throw E.a(Double.valueOf(dG), tag, f0().toString());
            }
            return dG;
        } catch (IllegalArgumentException unused) {
            t0("double");
            throw new C0739g();
        }
    }

    @Override // K3.g
    public K3.h k() {
        return f0();
    }

    @Override // J3.p0
    /* JADX INFO: renamed from: k0, reason: merged with bridge method [inline-methods] */
    public int N(String tag, H3.e enumDescriptor) {
        kotlin.jvm.internal.r.f(tag, "tag");
        kotlin.jvm.internal.r.f(enumDescriptor, "enumDescriptor");
        return F.j(enumDescriptor, b(), r0(tag).f(), null, 4, null);
    }

    @Override // J3.p0
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public float O(String tag) {
        kotlin.jvm.internal.r.f(tag, "tag");
        try {
            float fI = K3.i.i(r0(tag));
            if (b().f().a()) {
                return fI;
            }
            if (Float.isInfinite(fI) || Float.isNaN(fI)) {
                throw E.a(Float.valueOf(fI), tag, f0().toString());
            }
            return fI;
        } catch (IllegalArgumentException unused) {
            t0("float");
            throw new C0739g();
        }
    }

    @Override // J3.p0
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] */
    public I3.e P(String tag, H3.e inlineDescriptor) {
        kotlin.jvm.internal.r.f(tag, "tag");
        kotlin.jvm.internal.r.f(inlineDescriptor, "inlineDescriptor");
        return Y.b(inlineDescriptor) ? new C0402z(new Z(r0(tag).f()), b()) : super.P(tag, inlineDescriptor);
    }

    @Override // J3.p0
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public int Q(String tag) {
        kotlin.jvm.internal.r.f(tag, "tag");
        try {
            return K3.i.k(r0(tag));
        } catch (IllegalArgumentException unused) {
            t0("int");
            throw new C0739g();
        }
    }

    @Override // J3.p0
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public long R(String tag) {
        kotlin.jvm.internal.r.f(tag, "tag");
        try {
            return K3.i.q(r0(tag));
        } catch (IllegalArgumentException unused) {
            t0("long");
            throw new C0739g();
        }
    }

    @Override // J3.p0, I3.e
    public Object p(F3.a deserializer) {
        kotlin.jvm.internal.r.f(deserializer, "deserializer");
        return U.d(this, deserializer);
    }

    @Override // J3.p0
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public short S(String tag) {
        kotlin.jvm.internal.r.f(tag, "tag");
        try {
            int iK = K3.i.k(r0(tag));
            Short shValueOf = (-32768 > iK || iK > 32767) ? null : Short.valueOf((short) iK);
            if (shValueOf != null) {
                return shValueOf.shortValue();
            }
            t0("short");
            throw new C0739g();
        } catch (IllegalArgumentException unused) {
            t0("short");
            throw new C0739g();
        }
    }

    @Override // J3.p0
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public String T(String tag) {
        kotlin.jvm.internal.r.f(tag, "tag");
        K3.w wVarR0 = r0(tag);
        if (b().f().m() || d0(wVarR0, "string").i()) {
            if (wVarR0 instanceof K3.s) {
                throw E.f(-1, "Unexpected 'null' value instead of string literal", f0().toString());
            }
            return wVarR0.f();
        }
        throw E.f(-1, "String literal for key '" + tag + "' should be quoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", f0().toString());
    }

    public final K3.w r0(String tag) {
        kotlin.jvm.internal.r.f(tag, "tag");
        K3.h hVarE0 = e0(tag);
        K3.w wVar = hVarE0 instanceof K3.w ? (K3.w) hVarE0 : null;
        if (wVar != null) {
            return wVar;
        }
        throw E.f(-1, "Expected JsonPrimitive at " + tag + ", found " + hVarE0, f0().toString());
    }

    public abstract K3.h s0();

    @Override // J3.p0, I3.e
    public boolean t() {
        return !(f0() instanceof K3.s);
    }

    public final Void t0(String str) {
        throw E.f(-1, "Failed to parse '" + str + '\'', f0().toString());
    }

    public AbstractC0380c(K3.a aVar, K3.h hVar) {
        this.f1511c = aVar;
        this.f1512d = hVar;
        this.f1513e = b().f();
    }
}
