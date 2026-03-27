package K3;

import H3.c;
import W2.E;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f1362a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f1363b = H3.h.c("kotlinx.serialization.json.JsonElement", c.a.f733a, new H3.e[0], a.f1364a);

    public static final class a extends kotlin.jvm.internal.s implements i3.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f1364a = new a();

        /* JADX INFO: renamed from: K3.j$a$a, reason: collision with other inner class name */
        public static final class C0034a extends kotlin.jvm.internal.s implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0034a f1365a = new C0034a();

            public C0034a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final H3.e invoke() {
                return x.f1388a.getDescriptor();
            }
        }

        public static final class b extends kotlin.jvm.internal.s implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f1366a = new b();

            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final H3.e invoke() {
                return t.f1379a.getDescriptor();
            }
        }

        public static final class c extends kotlin.jvm.internal.s implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f1367a = new c();

            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final H3.e invoke() {
                return p.f1374a.getDescriptor();
            }
        }

        public static final class d extends kotlin.jvm.internal.s implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f1368a = new d();

            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final H3.e invoke() {
                return v.f1383a.getDescriptor();
            }
        }

        public static final class e extends kotlin.jvm.internal.s implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f1369a = new e();

            public e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final H3.e invoke() {
                return K3.c.f1331a.getDescriptor();
            }
        }

        public a() {
            super(1);
        }

        @Override // i3.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((H3.a) obj);
            return E.f5463a;
        }

        public final void invoke(H3.a buildSerialDescriptor) {
            kotlin.jvm.internal.r.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
            H3.a.b(buildSerialDescriptor, "JsonPrimitive", k.f(C0034a.f1365a), null, false, 12, null);
            H3.a.b(buildSerialDescriptor, "JsonNull", k.f(b.f1366a), null, false, 12, null);
            H3.a.b(buildSerialDescriptor, "JsonLiteral", k.f(c.f1367a), null, false, 12, null);
            H3.a.b(buildSerialDescriptor, "JsonObject", k.f(d.f1368a), null, false, 12, null);
            H3.a.b(buildSerialDescriptor, "JsonArray", k.f(e.f1369a), null, false, 12, null);
        }
    }

    @Override // F3.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public h deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return k.d(decoder).k();
    }

    @Override // F3.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(I3.f encoder, h value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        k.h(encoder);
        if (value instanceof w) {
            encoder.z(x.f1388a, value);
        } else if (value instanceof u) {
            encoder.z(v.f1383a, value);
        } else if (value instanceof b) {
            encoder.z(c.f1331a, value);
        }
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f1363b;
    }
}
