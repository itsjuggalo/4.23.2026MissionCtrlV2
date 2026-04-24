package n6;

import E5.C0462g;
import kotlin.jvm.internal.H;
import kotlin.jvm.internal.r;
import r6.AbstractC2612b;
import r6.AbstractC2614c;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {
    public static final a a(AbstractC2612b abstractC2612b, q6.c decoder, String str) {
        r.f(abstractC2612b, "<this>");
        r.f(decoder, "decoder");
        a aVarC = abstractC2612b.c(decoder, str);
        if (aVarC != null) {
            return aVarC;
        }
        AbstractC2614c.b(str, abstractC2612b.e());
        throw new C0462g();
    }

    public static final h b(AbstractC2612b abstractC2612b, q6.f encoder, Object value) {
        r.f(abstractC2612b, "<this>");
        r.f(encoder, "encoder");
        r.f(value, "value");
        h hVarD = abstractC2612b.d(encoder, value);
        if (hVarD != null) {
            return hVarD;
        }
        AbstractC2614c.a(H.b(value.getClass()), abstractC2612b.e());
        throw new C0462g();
    }
}
