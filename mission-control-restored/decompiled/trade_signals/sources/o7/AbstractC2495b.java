package o7;

import kotlin.jvm.internal.AbstractC2304t;
import n7.c;

/* JADX INFO: renamed from: o7.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2495b implements k7.b {
    public final Object b(n7.c cVar) {
        return c.a.c(cVar, getDescriptor(), 1, k7.d.a(this, cVar, cVar.j(getDescriptor(), 0)), null, 8, null);
    }

    public k7.a c(n7.c decoder, String str) {
        AbstractC2304t.f(decoder, "decoder");
        return decoder.a().d(e(), str);
    }

    public k7.k d(n7.f encoder, Object value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        return encoder.a().e(e(), value);
    }

    @Override // k7.a
    public final Object deserialize(n7.e decoder) {
        Object objC;
        AbstractC2304t.f(decoder, "decoder");
        m7.e descriptor = getDescriptor();
        n7.c cVarC = decoder.c(descriptor);
        kotlin.jvm.internal.N n8 = new kotlin.jvm.internal.N();
        if (cVarC.w()) {
            objC = b(cVarC);
        } else {
            objC = null;
            while (true) {
                int iE = cVarC.E(getDescriptor());
                if (iE != -1) {
                    if (iE == 0) {
                        n8.f20469a = cVarC.j(getDescriptor(), iE);
                    } else {
                        if (iE != 1) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid index in polymorphic deserialization of ");
                            String str = (String) n8.f20469a;
                            if (str == null) {
                                str = "unknown class";
                            }
                            sb.append(str);
                            sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                            sb.append(iE);
                            throw new k7.j(sb.toString());
                        }
                        Object obj = n8.f20469a;
                        if (obj == null) {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token".toString());
                        }
                        n8.f20469a = obj;
                        objC = c.a.c(cVarC, getDescriptor(), iE, k7.d.a(this, cVarC, (String) obj), null, 8, null);
                    }
                } else {
                    if (objC == null) {
                        throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) n8.f20469a)).toString());
                    }
                    AbstractC2304t.d(objC, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer");
                }
            }
        }
        cVarC.d(descriptor);
        return objC;
    }

    public abstract I5.d e();

    @Override // k7.k
    public final void serialize(n7.f encoder, Object value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        k7.k kVarB = k7.d.b(this, encoder, value);
        m7.e descriptor = getDescriptor();
        n7.d dVarC = encoder.c(descriptor);
        dVarC.g(getDescriptor(), 0, kVarB.getDescriptor().a());
        m7.e descriptor2 = getDescriptor();
        AbstractC2304t.d(kVarB, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        dVarC.B(descriptor2, 1, kVarB, value);
        dVarC.d(descriptor);
    }
}
