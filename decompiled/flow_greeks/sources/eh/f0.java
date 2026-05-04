package eh;

import bh.d;
import kotlin.jvm.internal.n0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class f0 implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f0 f9005a = new f0();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bh.e f9006b = bh.k.e("kotlinx.serialization.json.JsonPrimitive", d.i.f3379a, new bh.e[0], null, 8, null);

    @Override // zg.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public e0 deserialize(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        i iVarI = r.d(decoder).i();
        if (iVarI instanceof e0) {
            return (e0) iVarI;
        }
        throw fh.c0.f(-1, "Unexpected JSON element, expected JsonPrimitive, had " + n0.b(iVarI.getClass()), iVarI.toString());
    }

    @Override // zg.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(ch.f encoder, e0 value) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(value, "value");
        r.h(encoder);
        if (value instanceof z) {
            encoder.B(a0.f8970a, z.INSTANCE);
        } else {
            encoder.B(w.f9030a, (v) value);
        }
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return f9006b;
    }
}
