package K3;

import H3.d;
import L3.E;
import kotlin.jvm.internal.G;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f1388a = new x();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f1389b = H3.h.d("kotlinx.serialization.json.JsonPrimitive", d.i.f742a, new H3.e[0], null, 8, null);

    @Override // F3.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public w deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        h hVarK = k.d(decoder).k();
        if (hVarK instanceof w) {
            return (w) hVarK;
        }
        throw E.f(-1, "Unexpected JSON element, expected JsonPrimitive, had " + G.b(hVarK.getClass()), hVarK.toString());
    }

    @Override // F3.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(I3.f encoder, w value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        k.h(encoder);
        if (value instanceof s) {
            encoder.z(t.f1379a, s.INSTANCE);
        } else {
            encoder.z(p.f1374a, (o) value);
        }
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f1389b;
    }
}
