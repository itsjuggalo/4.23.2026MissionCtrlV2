package eh;

import bh.d;
import kg.j0;
import kotlin.jvm.internal.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class w implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f9030a = new w();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bh.e f9031b = bh.k.b("kotlinx.serialization.json.JsonLiteral", d.i.f3379a);

    @Override // zg.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public v deserialize(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        i iVarI = r.d(decoder).i();
        if (iVarI instanceof v) {
            return (v) iVarI;
        }
        throw fh.c0.f(-1, "Unexpected JSON element, expected JsonLiteral, had " + n0.b(iVarI.getClass()), iVarI.toString());
    }

    @Override // zg.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(ch.f encoder, v value) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(value, "value");
        r.h(encoder);
        if (value.c()) {
            encoder.F(value.a());
            return;
        }
        if (value.e() != null) {
            encoder.v(value.e()).F(value.a());
            return;
        }
        Long lQ = kg.y.q(value.a());
        if (lQ != null) {
            encoder.D(lQ.longValue());
            return;
        }
        cd.b0 b0VarH = j0.h(value.a());
        if (b0VarH != null) {
            encoder.v(ah.a.s(cd.b0.f3836b).getDescriptor()).D(b0VarH.k());
            return;
        }
        Double dL = kg.x.l(value.a());
        if (dL != null) {
            encoder.j(dL.doubleValue());
            return;
        }
        Boolean boolZ0 = kg.c0.Z0(value.a());
        if (boolZ0 != null) {
            encoder.m(boolZ0.booleanValue());
        } else {
            encoder.F(value.a());
        }
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return f9031b;
    }
}
