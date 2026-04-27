package J3;

import I3.c;
import p3.InterfaceC1716c;

/* JADX INFO: renamed from: J3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC0326b implements F3.b {
    public final Object b(I3.c cVar) {
        return c.a.c(cVar, getDescriptor(), 1, F3.d.a(this, cVar, cVar.v(getDescriptor(), 0)), null, 8, null);
    }

    public F3.a c(I3.c decoder, String str) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return decoder.a().d(e(), str);
    }

    public F3.h d(I3.f encoder, Object value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        return encoder.a().e(e(), value);
    }

    @Override // F3.a
    public final Object deserialize(I3.e decoder) {
        Object objB;
        kotlin.jvm.internal.r.f(decoder, "decoder");
        H3.e descriptor = getDescriptor();
        I3.c cVarD = decoder.d(descriptor);
        kotlin.jvm.internal.F f4 = new kotlin.jvm.internal.F();
        if (cVarD.w()) {
            objB = b(cVarD);
        } else {
            Object objC = null;
            while (true) {
                int i4 = cVarD.i(getDescriptor());
                if (i4 != -1) {
                    if (i4 == 0) {
                        f4.f13410a = cVarD.v(getDescriptor(), i4);
                    } else {
                        if (i4 != 1) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid index in polymorphic deserialization of ");
                            String str = (String) f4.f13410a;
                            if (str == null) {
                                str = "unknown class";
                            }
                            sb.append(str);
                            sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                            sb.append(i4);
                            throw new F3.g(sb.toString());
                        }
                        Object obj = f4.f13410a;
                        if (obj == null) {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token");
                        }
                        f4.f13410a = obj;
                        objC = c.a.c(cVarD, getDescriptor(), i4, F3.d.a(this, cVarD, (String) obj), null, 8, null);
                    }
                } else {
                    if (objC == null) {
                        throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) f4.f13410a)).toString());
                    }
                    kotlin.jvm.internal.r.d(objC, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer.deserialize$lambda$3");
                    objB = objC;
                }
            }
        }
        cVarD.c(descriptor);
        return objB;
    }

    public abstract InterfaceC1716c e();

    @Override // F3.h
    public final void serialize(I3.f encoder, Object value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        F3.h hVarB = F3.d.b(this, encoder, value);
        H3.e descriptor = getDescriptor();
        I3.d dVarD = encoder.d(descriptor);
        dVarD.o(getDescriptor(), 0, hVarB.getDescriptor().a());
        H3.e descriptor2 = getDescriptor();
        kotlin.jvm.internal.r.d(hVarB, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        dVarD.u(descriptor2, 1, hVarB, value);
        dVarD.c(descriptor);
    }
}
