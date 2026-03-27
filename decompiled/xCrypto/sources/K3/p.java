package K3;

import H3.d;
import L3.E;
import kotlin.jvm.internal.G;
import r3.H;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f1374a = new p();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f1375b = H3.h.a("kotlinx.serialization.json.JsonLiteral", d.i.f742a);

    @Override // F3.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public o deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        h hVarK = k.d(decoder).k();
        if (hVarK instanceof o) {
            return (o) hVarK;
        }
        throw E.f(-1, "Unexpected JSON element, expected JsonLiteral, had " + G.b(hVarK.getClass()), hVarK.toString());
    }

    @Override // F3.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(I3.f encoder, o value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        k.h(encoder);
        if (value.i()) {
            encoder.F(value.f());
            return;
        }
        if (value.k() != null) {
            encoder.f(value.k()).F(value.f());
            return;
        }
        Long lR = i.r(value);
        if (lR != null) {
            encoder.D(lR.longValue());
            return;
        }
        W2.y yVarH = H.h(value.f());
        if (yVarH != null) {
            encoder.f(G3.a.s(W2.y.f5508b).getDescriptor()).D(yVarH.k());
            return;
        }
        Double dH = i.h(value);
        if (dH != null) {
            encoder.h(dH.doubleValue());
            return;
        }
        Boolean boolE = i.e(value);
        if (boolE != null) {
            encoder.n(boolE.booleanValue());
        } else {
            encoder.F(value.f());
        }
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f1375b;
    }
}
