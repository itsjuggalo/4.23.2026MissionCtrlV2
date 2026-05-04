package zg;

import kotlin.jvm.internal.n0;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d {
    public static final a a(dh.b bVar, ch.c decoder, String str) {
        t.f(bVar, "<this>");
        t.f(decoder, "decoder");
        a aVarC = bVar.c(decoder, str);
        if (aVarC != null) {
            return aVarC;
        }
        dh.c.a(str, bVar.e());
        throw new cd.h();
    }

    public static final k b(dh.b bVar, ch.f encoder, Object value) {
        t.f(bVar, "<this>");
        t.f(encoder, "encoder");
        t.f(value, "value");
        k kVarD = bVar.d(encoder, value);
        if (kVarD != null) {
            return kVarD;
        }
        dh.c.b(n0.b(value.getClass()), bVar.e());
        throw new cd.h();
    }
}
