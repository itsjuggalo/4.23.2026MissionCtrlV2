package dh;

import ch.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements zg.b {
    public final Object b(ch.c cVar) {
        return c.a.c(cVar, getDescriptor(), 1, zg.d.a(this, cVar, cVar.s(getDescriptor(), 0)), null, 8, null);
    }

    public zg.a c(ch.c decoder, String str) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        return decoder.a().d(e(), str);
    }

    public zg.k d(ch.f encoder, Object value) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(value, "value");
        return encoder.a().e(e(), value);
    }

    @Override // zg.a
    public final Object deserialize(ch.e decoder) {
        Object objB;
        kotlin.jvm.internal.t.f(decoder, "decoder");
        bh.e descriptor = getDescriptor();
        ch.c cVarB = decoder.b(descriptor);
        kotlin.jvm.internal.m0 m0Var = new kotlin.jvm.internal.m0();
        if (cVarB.z()) {
            objB = b(cVarB);
        } else {
            Object objC = null;
            while (true) {
                int iW = cVarB.w(getDescriptor());
                if (iW != -1) {
                    if (iW == 0) {
                        m0Var.f14947a = cVarB.s(getDescriptor(), iW);
                    } else {
                        if (iW != 1) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Invalid index in polymorphic deserialization of ");
                            String str = (String) m0Var.f14947a;
                            if (str == null) {
                                str = "unknown class";
                            }
                            sb2.append(str);
                            sb2.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                            sb2.append(iW);
                            throw new zg.j(sb2.toString());
                        }
                        Object obj = m0Var.f14947a;
                        if (obj == null) {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token");
                        }
                        m0Var.f14947a = obj;
                        objC = c.a.c(cVarB, getDescriptor(), iW, zg.d.a(this, cVarB, (String) obj), null, 8, null);
                    }
                } else {
                    if (objC == null) {
                        throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) m0Var.f14947a)).toString());
                    }
                    kotlin.jvm.internal.t.d(objC, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer");
                    objB = objC;
                }
            }
        }
        cVarB.c(descriptor);
        return objB;
    }

    public abstract wd.d e();

    @Override // zg.k
    public final void serialize(ch.f encoder, Object value) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(value, "value");
        zg.k kVarB = zg.d.b(this, encoder, value);
        bh.e descriptor = getDescriptor();
        ch.d dVarB = encoder.b(descriptor);
        dVarB.w(getDescriptor(), 0, kVarB.getDescriptor().i());
        bh.e descriptor2 = getDescriptor();
        kotlin.jvm.internal.t.d(kVarB, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        dVarB.n(descriptor2, 1, kVarB, value);
        dVarB.c(descriptor);
    }
}
