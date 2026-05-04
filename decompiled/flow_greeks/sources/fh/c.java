package fh;

import bh.l;
import bh.m;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class c extends dh.t0 implements eh.h {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final eh.b f9549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final eh.i f9550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f9551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final eh.g f9552f;

    public /* synthetic */ c(eh.b bVar, eh.i iVar, String str, kotlin.jvm.internal.k kVar) {
        this(bVar, iVar, str);
    }

    @Override // dh.z1, ch.e
    public ch.e A(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        return Y() != null ? super.A(descriptor) : new g0(d(), z0(), this.f9551e).A(descriptor);
    }

    public final String A0(String currentTag) {
        kotlin.jvm.internal.t.f(currentTag, "currentTag");
        return i0() + com.amazon.a.a.o.c.a.b.f4610a + currentTag;
    }

    public final Void B0(eh.e0 e0Var, String str, String str2) {
        StringBuilder sb2;
        String str3;
        if (kg.z.J(str, "i", false, 2, null)) {
            sb2 = new StringBuilder();
            str3 = "an ";
        } else {
            sb2 = new StringBuilder();
            str3 = "a ";
        }
        sb2.append(str3);
        sb2.append(str);
        throw c0.f(-1, "Failed to parse literal '" + e0Var + "' as " + sb2.toString() + " value at element: " + A0(str2), m0().toString());
    }

    @Override // dh.z1, ch.e
    public Object E(zg.a deserializer) {
        eh.e0 e0VarO;
        kotlin.jvm.internal.t.f(deserializer, "deserializer");
        if (!(deserializer instanceof dh.b) || d().f().p()) {
            return deserializer.deserialize(this);
        }
        dh.b bVar = (dh.b) deserializer;
        String strC = r0.c(bVar.getDescriptor(), d());
        eh.i iVarI = i();
        String strI = bVar.getDescriptor().i();
        if (iVarI instanceof eh.c0) {
            eh.c0 c0Var = (eh.c0) iVarI;
            eh.i iVar = (eh.i) c0Var.get(strC);
            try {
                zg.a aVarA = zg.d.a((dh.b) deserializer, this, (iVar == null || (e0VarO = eh.j.o(iVar)) == null) ? null : eh.j.f(e0VarO));
                kotlin.jvm.internal.t.d(aVarA, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
                return a1.b(d(), strC, c0Var, aVarA);
            } catch (zg.j e10) {
                String message = e10.getMessage();
                kotlin.jvm.internal.t.c(message);
                throw c0.f(-1, message, c0Var.toString());
            }
        }
        throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.c0.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarI.getClass()).c() + " as the serialized body of " + strI + " at element: " + i0(), iVarI.toString());
    }

    @Override // ch.c
    public gh.e a() {
        return d().a();
    }

    @Override // ch.e
    public ch.c b(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
        eh.i iVarM0 = m0();
        bh.l lVarH = descriptor.h();
        if (kotlin.jvm.internal.t.b(lVarH, m.b.f3403a) || (lVarH instanceof bh.c)) {
            eh.b bVarD = d();
            String strI = descriptor.i();
            if (iVarM0 instanceof eh.c) {
                return new m0(bVarD, (eh.c) iVarM0);
            }
            throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.c.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarM0.getClass()).c() + " as the serialized body of " + strI + " at element: " + i0(), iVarM0.toString());
        }
        if (!kotlin.jvm.internal.t.b(lVarH, m.c.f3404a)) {
            eh.b bVarD2 = d();
            String strI2 = descriptor.i();
            if (iVarM0 instanceof eh.c0) {
                return new k0(bVarD2, (eh.c0) iVarM0, this.f9551e, null, 8, null);
            }
            throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.c0.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarM0.getClass()).c() + " as the serialized body of " + strI2 + " at element: " + i0(), iVarM0.toString());
        }
        eh.b bVarD3 = d();
        bh.e eVarA = e1.a(descriptor.o(0), bVarD3.a());
        bh.l lVarH2 = eVarA.h();
        if ((lVarH2 instanceof bh.d) || kotlin.jvm.internal.t.b(lVarH2, l.b.f3401a)) {
            eh.b bVarD4 = d();
            String strI3 = descriptor.i();
            if (iVarM0 instanceof eh.c0) {
                return new o0(bVarD4, (eh.c0) iVarM0);
            }
            throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.c0.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarM0.getClass()).c() + " as the serialized body of " + strI3 + " at element: " + i0(), iVarM0.toString());
        }
        if (!bVarD3.f().c()) {
            throw c0.d(eVarA);
        }
        eh.b bVarD5 = d();
        String strI4 = descriptor.i();
        if (iVarM0 instanceof eh.c) {
            return new m0(bVarD5, (eh.c) iVarM0);
        }
        throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.c.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarM0.getClass()).c() + " as the serialized body of " + strI4 + " at element: " + i0(), iVarM0.toString());
    }

    @Override // ch.c
    public void c(bh.e descriptor) {
        kotlin.jvm.internal.t.f(descriptor, "descriptor");
    }

    @Override // eh.h
    public eh.b d() {
        return this.f9549c;
    }

    @Override // dh.t0
    public String e0(String parentName, String childName) {
        kotlin.jvm.internal.t.f(parentName, "parentName");
        kotlin.jvm.internal.t.f(childName, "childName");
        return childName;
    }

    @Override // eh.h
    public eh.i i() {
        return m0();
    }

    public abstract eh.i l0(String str);

    public final eh.i m0() {
        eh.i iVarL0;
        String str = (String) Y();
        return (str == null || (iVarL0 = l0(str)) == null) ? z0() : iVarL0;
    }

    @Override // dh.z1
    /* JADX INFO: renamed from: n0, reason: merged with bridge method [inline-methods] */
    public boolean N(String tag) {
        kotlin.jvm.internal.t.f(tag, "tag");
        eh.i iVarL0 = l0(tag);
        if (iVarL0 instanceof eh.e0) {
            eh.e0 e0Var = (eh.e0) iVarL0;
            try {
                Boolean boolE = eh.j.e(e0Var);
                if (boolE != null) {
                    return boolE.booleanValue();
                }
                B0(e0Var, "boolean", tag);
                throw new cd.h();
            } catch (IllegalArgumentException unused) {
                B0(e0Var, "boolean", tag);
                throw new cd.h();
            }
        }
        throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.e0.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarL0.getClass()).c() + " as the serialized body of boolean at element: " + A0(tag), iVarL0.toString());
    }

    @Override // dh.z1
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public byte O(String tag) {
        kotlin.jvm.internal.t.f(tag, "tag");
        eh.i iVarL0 = l0(tag);
        if (iVarL0 instanceof eh.e0) {
            eh.e0 e0Var = (eh.e0) iVarL0;
            try {
                int iK = eh.j.k(e0Var);
                Byte bValueOf = (-128 > iK || iK > 127) ? null : Byte.valueOf((byte) iK);
                if (bValueOf != null) {
                    return bValueOf.byteValue();
                }
                B0(e0Var, "byte", tag);
                throw new cd.h();
            } catch (IllegalArgumentException unused) {
                B0(e0Var, "byte", tag);
                throw new cd.h();
            }
        }
        throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.e0.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarL0.getClass()).c() + " as the serialized body of byte at element: " + A0(tag), iVarL0.toString());
    }

    @Override // dh.z1
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public char P(String tag) {
        kotlin.jvm.internal.t.f(tag, "tag");
        eh.i iVarL0 = l0(tag);
        if (iVarL0 instanceof eh.e0) {
            eh.e0 e0Var = (eh.e0) iVarL0;
            try {
                return kg.e0.f1(e0Var.a());
            } catch (IllegalArgumentException unused) {
                B0(e0Var, "char", tag);
                throw new cd.h();
            }
        }
        throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.e0.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarL0.getClass()).c() + " as the serialized body of char at element: " + A0(tag), iVarL0.toString());
    }

    @Override // dh.z1
    /* JADX INFO: renamed from: q0, reason: merged with bridge method [inline-methods] */
    public double Q(String tag) {
        kotlin.jvm.internal.t.f(tag, "tag");
        eh.i iVarL0 = l0(tag);
        if (iVarL0 instanceof eh.e0) {
            eh.e0 e0Var = (eh.e0) iVarL0;
            try {
                double dG = eh.j.g(e0Var);
                if (d().f().b()) {
                    return dG;
                }
                if (Double.isInfinite(dG) || Double.isNaN(dG)) {
                    throw c0.a(Double.valueOf(dG), tag, m0().toString());
                }
                return dG;
            } catch (IllegalArgumentException unused) {
                B0(e0Var, "double", tag);
                throw new cd.h();
            }
        }
        throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.e0.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarL0.getClass()).c() + " as the serialized body of double at element: " + A0(tag), iVarL0.toString());
    }

    @Override // dh.z1
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public int R(String tag, bh.e enumDescriptor) {
        kotlin.jvm.internal.t.f(tag, "tag");
        kotlin.jvm.internal.t.f(enumDescriptor, "enumDescriptor");
        eh.b bVarD = d();
        eh.i iVarL0 = l0(tag);
        String strI = enumDescriptor.i();
        if (iVarL0 instanceof eh.e0) {
            return e0.k(enumDescriptor, bVarD, ((eh.e0) iVarL0).a(), null, 4, null);
        }
        throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.e0.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarL0.getClass()).c() + " as the serialized body of " + strI + " at element: " + A0(tag), iVarL0.toString());
    }

    @Override // dh.z1
    /* JADX INFO: renamed from: s0, reason: merged with bridge method [inline-methods] */
    public float S(String tag) {
        kotlin.jvm.internal.t.f(tag, "tag");
        eh.i iVarL0 = l0(tag);
        if (iVarL0 instanceof eh.e0) {
            eh.e0 e0Var = (eh.e0) iVarL0;
            try {
                float fI = eh.j.i(e0Var);
                if (d().f().b()) {
                    return fI;
                }
                if (Float.isInfinite(fI) || Float.isNaN(fI)) {
                    throw c0.a(Float.valueOf(fI), tag, m0().toString());
                }
                return fI;
            } catch (IllegalArgumentException unused) {
                B0(e0Var, "float", tag);
                throw new cd.h();
            }
        }
        throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.e0.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarL0.getClass()).c() + " as the serialized body of float at element: " + A0(tag), iVarL0.toString());
    }

    @Override // ch.e
    public boolean t() {
        return !(m0() instanceof eh.z);
    }

    @Override // dh.z1
    /* JADX INFO: renamed from: t0, reason: merged with bridge method [inline-methods] */
    public ch.e T(String tag, bh.e inlineDescriptor) {
        kotlin.jvm.internal.t.f(tag, "tag");
        kotlin.jvm.internal.t.f(inlineDescriptor, "inlineDescriptor");
        if (!v0.b(inlineDescriptor)) {
            return super.T(tag, inlineDescriptor);
        }
        eh.b bVarD = d();
        eh.i iVarL0 = l0(tag);
        String strI = inlineDescriptor.i();
        if (iVarL0 instanceof eh.e0) {
            return new x(x0.a(bVarD, ((eh.e0) iVarL0).a()), d());
        }
        throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.e0.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarL0.getClass()).c() + " as the serialized body of " + strI + " at element: " + A0(tag), iVarL0.toString());
    }

    @Override // dh.z1
    /* JADX INFO: renamed from: u0, reason: merged with bridge method [inline-methods] */
    public int U(String tag) {
        kotlin.jvm.internal.t.f(tag, "tag");
        eh.i iVarL0 = l0(tag);
        if (iVarL0 instanceof eh.e0) {
            eh.e0 e0Var = (eh.e0) iVarL0;
            try {
                return eh.j.k(e0Var);
            } catch (IllegalArgumentException unused) {
                B0(e0Var, "int", tag);
                throw new cd.h();
            }
        }
        throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.e0.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarL0.getClass()).c() + " as the serialized body of int at element: " + A0(tag), iVarL0.toString());
    }

    @Override // dh.z1
    /* JADX INFO: renamed from: v0, reason: merged with bridge method [inline-methods] */
    public long V(String tag) {
        kotlin.jvm.internal.t.f(tag, "tag");
        eh.i iVarL0 = l0(tag);
        if (iVarL0 instanceof eh.e0) {
            eh.e0 e0Var = (eh.e0) iVarL0;
            try {
                return eh.j.q(e0Var);
            } catch (IllegalArgumentException unused) {
                B0(e0Var, "long", tag);
                throw new cd.h();
            }
        }
        throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.e0.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarL0.getClass()).c() + " as the serialized body of long at element: " + A0(tag), iVarL0.toString());
    }

    @Override // dh.z1
    /* JADX INFO: renamed from: w0, reason: merged with bridge method [inline-methods] */
    public short W(String tag) {
        kotlin.jvm.internal.t.f(tag, "tag");
        eh.i iVarL0 = l0(tag);
        if (iVarL0 instanceof eh.e0) {
            eh.e0 e0Var = (eh.e0) iVarL0;
            try {
                int iK = eh.j.k(e0Var);
                Short shValueOf = (-32768 > iK || iK > 32767) ? null : Short.valueOf((short) iK);
                if (shValueOf != null) {
                    return shValueOf.shortValue();
                }
                B0(e0Var, "short", tag);
                throw new cd.h();
            } catch (IllegalArgumentException unused) {
                B0(e0Var, "short", tag);
                throw new cd.h();
            }
        }
        throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.e0.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarL0.getClass()).c() + " as the serialized body of short at element: " + A0(tag), iVarL0.toString());
    }

    @Override // dh.z1
    /* JADX INFO: renamed from: x0, reason: merged with bridge method [inline-methods] */
    public String X(String tag) {
        kotlin.jvm.internal.t.f(tag, "tag");
        eh.i iVarL0 = l0(tag);
        if (!(iVarL0 instanceof eh.e0)) {
            throw c0.f(-1, "Expected " + kotlin.jvm.internal.n0.b(eh.e0.class).c() + ", but had " + kotlin.jvm.internal.n0.b(iVarL0.getClass()).c() + " as the serialized body of string at element: " + A0(tag), iVarL0.toString());
        }
        eh.e0 e0Var = (eh.e0) iVarL0;
        if (!(e0Var instanceof eh.v)) {
            throw c0.f(-1, "Expected string value for a non-null key '" + tag + "', got null literal instead at element: " + A0(tag), m0().toString());
        }
        eh.v vVar = (eh.v) e0Var;
        if (vVar.c() || d().f().q()) {
            return vVar.a();
        }
        throw c0.f(-1, "String literal for key '" + tag + "' should be quoted at element: " + A0(tag) + ".\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON.", m0().toString());
    }

    public final String y0() {
        return this.f9551e;
    }

    public abstract eh.i z0();

    public /* synthetic */ c(eh.b bVar, eh.i iVar, String str, int i10, kotlin.jvm.internal.k kVar) {
        this(bVar, iVar, (i10 & 4) != 0 ? null : str, null);
    }

    public c(eh.b bVar, eh.i iVar, String str) {
        this.f9549c = bVar;
        this.f9550d = iVar;
        this.f9551e = str;
        this.f9552f = d().f();
    }
}
