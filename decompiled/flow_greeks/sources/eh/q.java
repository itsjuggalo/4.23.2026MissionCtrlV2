package eh;

import bh.c;
import cd.h0;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class q implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f9024a = new q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bh.e f9025b = bh.k.d("kotlinx.serialization.json.JsonElement", c.a.f3370a, new bh.e[0], new pd.k() { // from class: eh.k
        @Override // pd.k
        public final Object invoke(Object obj) {
            return q.g((bh.a) obj);
        }
    });

    public static final h0 g(bh.a buildSerialDescriptor) {
        kotlin.jvm.internal.t.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
        bh.a.b(buildSerialDescriptor, "JsonPrimitive", r.f(new Function0() { // from class: eh.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return q.h();
            }
        }), null, false, 12, null);
        bh.a.b(buildSerialDescriptor, "JsonNull", r.f(new Function0() { // from class: eh.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return q.i();
            }
        }), null, false, 12, null);
        bh.a.b(buildSerialDescriptor, "JsonLiteral", r.f(new Function0() { // from class: eh.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return q.j();
            }
        }), null, false, 12, null);
        bh.a.b(buildSerialDescriptor, "JsonObject", r.f(new Function0() { // from class: eh.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return q.k();
            }
        }), null, false, 12, null);
        bh.a.b(buildSerialDescriptor, "JsonArray", r.f(new Function0() { // from class: eh.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return q.l();
            }
        }), null, false, 12, null);
        return h0.f3852a;
    }

    public static final bh.e h() {
        return f0.f9005a.getDescriptor();
    }

    public static final bh.e i() {
        return a0.f8970a.getDescriptor();
    }

    public static final bh.e j() {
        return w.f9030a.getDescriptor();
    }

    public static final bh.e k() {
        return d0.f8983a.getDescriptor();
    }

    public static final bh.e l() {
        return d.f8978a.getDescriptor();
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return f9025b;
    }

    @Override // zg.a
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public i deserialize(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        return r.d(decoder).i();
    }

    @Override // zg.k
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void serialize(ch.f encoder, i value) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(value, "value");
        r.h(encoder);
        if (value instanceof e0) {
            encoder.B(f0.f9005a, value);
        } else if (value instanceof c0) {
            encoder.B(d0.f8983a, value);
        } else {
            if (!(value instanceof c)) {
                throw new cd.o();
            }
            encoder.B(d.f8978a, value);
        }
    }
}
