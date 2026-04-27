package F3;

import J3.AbstractC0326b;
import J3.AbstractC0328c;
import W2.C0739g;
import kotlin.jvm.internal.G;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static final a a(AbstractC0326b abstractC0326b, I3.c decoder, String str) {
        r.f(abstractC0326b, "<this>");
        r.f(decoder, "decoder");
        a aVarC = abstractC0326b.c(decoder, str);
        if (aVarC != null) {
            return aVarC;
        }
        AbstractC0328c.a(str, abstractC0326b.e());
        throw new C0739g();
    }

    public static final h b(AbstractC0326b abstractC0326b, I3.f encoder, Object value) {
        r.f(abstractC0326b, "<this>");
        r.f(encoder, "encoder");
        r.f(value, "value");
        h hVarD = abstractC0326b.d(encoder, value);
        if (hVarD != null) {
            return hVarD;
        }
        AbstractC0328c.b(G.b(value.getClass()), abstractC0326b.e());
        throw new C0739g();
    }
}
