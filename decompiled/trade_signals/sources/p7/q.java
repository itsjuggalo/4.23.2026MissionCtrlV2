package p7;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2304t;
import m7.c;
import o5.C2470H;
import o5.C2487o;

/* JADX INFO: loaded from: classes2.dex */
public final class q implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f22483a = new q();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.e f22484b = m7.k.d("kotlinx.serialization.json.JsonElement", c.a.f21499a, new m7.e[0], new B5.k() { // from class: p7.k
        @Override // B5.k
        public final Object invoke(Object obj) {
            return q.g((m7.a) obj);
        }
    });

    public static final C2470H g(m7.a buildSerialDescriptor) {
        AbstractC2304t.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
        m7.a.b(buildSerialDescriptor, "JsonPrimitive", r.f(new Function0() { // from class: p7.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return q.h();
            }
        }), null, false, 12, null);
        m7.a.b(buildSerialDescriptor, "JsonNull", r.f(new Function0() { // from class: p7.m
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return q.i();
            }
        }), null, false, 12, null);
        m7.a.b(buildSerialDescriptor, "JsonLiteral", r.f(new Function0() { // from class: p7.n
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return q.j();
            }
        }), null, false, 12, null);
        m7.a.b(buildSerialDescriptor, "JsonObject", r.f(new Function0() { // from class: p7.o
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return q.k();
            }
        }), null, false, 12, null);
        m7.a.b(buildSerialDescriptor, "JsonArray", r.f(new Function0() { // from class: p7.p
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return q.l();
            }
        }), null, false, 12, null);
        return C2470H.f21956a;
    }

    public static final m7.e h() {
        return F.f22432a.getDescriptor();
    }

    public static final m7.e i() {
        return A.f22424a.getDescriptor();
    }

    public static final m7.e j() {
        return w.f22489a.getDescriptor();
    }

    public static final m7.e k() {
        return D.f22427a.getDescriptor();
    }

    public static final m7.e l() {
        return C2611d.f22444a.getDescriptor();
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return f22484b;
    }

    @Override // k7.a
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public i deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        return r.d(decoder).l();
    }

    @Override // k7.k
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void serialize(n7.f encoder, i value) {
        k7.k kVar;
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        r.h(encoder);
        if (value instanceof E) {
            kVar = F.f22432a;
        } else if (value instanceof C) {
            kVar = D.f22427a;
        } else {
            if (!(value instanceof C2610c)) {
                throw new C2487o();
            }
            kVar = C2611d.f22444a;
        }
        encoder.C(kVar, value);
    }
}
