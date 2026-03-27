package r6;

import q6.c;

/* JADX INFO: renamed from: r6.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2612b implements n6.b {
    public final Object b(q6.c cVar) {
        return c.a.c(cVar, getDescriptor(), 1, n6.d.a(this, cVar, cVar.v(getDescriptor(), 0)), null, 8, null);
    }

    public n6.a c(q6.c decoder, String str) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return decoder.a().d(e(), str);
    }

    public n6.h d(q6.f encoder, Object value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        return encoder.a().e(e(), value);
    }

    @Override // n6.a
    public final Object deserialize(q6.e decoder) {
        Object objC;
        kotlin.jvm.internal.r.f(decoder, "decoder");
        p6.e descriptor = getDescriptor();
        q6.c cVarC = decoder.c(descriptor);
        kotlin.jvm.internal.G g7 = new kotlin.jvm.internal.G();
        if (cVarC.w()) {
            objC = b(cVarC);
        } else {
            objC = null;
            while (true) {
                int iQ = cVarC.q(getDescriptor());
                if (iQ != -1) {
                    if (iQ == 0) {
                        g7.f18249a = cVarC.v(getDescriptor(), iQ);
                    } else {
                        if (iQ != 1) {
                            StringBuilder sb = new StringBuilder();
                            sb.append("Invalid index in polymorphic deserialization of ");
                            String str = (String) g7.f18249a;
                            if (str == null) {
                                str = "unknown class";
                            }
                            sb.append(str);
                            sb.append("\n Expected 0, 1 or DECODE_DONE(-1), but found ");
                            sb.append(iQ);
                            throw new n6.g(sb.toString());
                        }
                        Object obj = g7.f18249a;
                        if (obj == null) {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token");
                        }
                        g7.f18249a = obj;
                        objC = c.a.c(cVarC, getDescriptor(), iQ, n6.d.a(this, cVarC, (String) obj), null, 8, null);
                    }
                } else {
                    if (objC == null) {
                        throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) g7.f18249a)).toString());
                    }
                    kotlin.jvm.internal.r.d(objC, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer.deserialize$lambda$3");
                }
            }
        }
        cVarC.b(descriptor);
        return objC;
    }

    public abstract X5.c e();

    @Override // n6.h
    public final void serialize(q6.f encoder, Object value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        n6.h hVarB = n6.d.b(this, encoder, value);
        p6.e descriptor = getDescriptor();
        q6.d dVarC = encoder.c(descriptor);
        dVarC.m(getDescriptor(), 0, hVarB.getDescriptor().a());
        p6.e descriptor2 = getDescriptor();
        kotlin.jvm.internal.r.d(hVarB, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        dVarC.x(descriptor2, 1, hVarB, value);
        dVarC.b(descriptor);
    }
}
