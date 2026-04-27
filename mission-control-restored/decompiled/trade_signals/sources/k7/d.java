package k7;

import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.O;
import o5.C2480h;
import o7.AbstractC2495b;
import o7.AbstractC2497c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    public static final a a(AbstractC2495b abstractC2495b, n7.c decoder, String str) {
        AbstractC2304t.f(abstractC2495b, "<this>");
        AbstractC2304t.f(decoder, "decoder");
        a aVarC = abstractC2495b.c(decoder, str);
        if (aVarC != null) {
            return aVarC;
        }
        AbstractC2497c.b(str, abstractC2495b.e());
        throw new C2480h();
    }

    public static final k b(AbstractC2495b abstractC2495b, n7.f encoder, Object value) {
        AbstractC2304t.f(abstractC2495b, "<this>");
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        k kVarD = abstractC2495b.d(encoder, value);
        if (kVarD != null) {
            return kVarD;
        }
        AbstractC2497c.a(O.b(value.getClass()), abstractC2495b.e());
        throw new C2480h();
    }
}
