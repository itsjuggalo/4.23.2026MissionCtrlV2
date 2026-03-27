package s6;

import E5.E;
import kotlin.jvm.functions.Function0;
import p6.c;

/* JADX INFO: loaded from: classes2.dex */
public final class j implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f23049a = new j();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.e f23050b = p6.h.c("kotlinx.serialization.json.JsonElement", c.a.f22061a, new p6.e[0], a.f23051a);

    public static final class a extends kotlin.jvm.internal.s implements Q5.k {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f23051a = new a();

        /* JADX INFO: renamed from: s6.j$a$a, reason: collision with other inner class name */
        public static final class C0360a extends kotlin.jvm.internal.s implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C0360a f23052a = new C0360a();

            public C0360a() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final p6.e invoke() {
                return x.f23075a.getDescriptor();
            }
        }

        public static final class b extends kotlin.jvm.internal.s implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f23053a = new b();

            public b() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final p6.e invoke() {
                return t.f23066a.getDescriptor();
            }
        }

        public static final class c extends kotlin.jvm.internal.s implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f23054a = new c();

            public c() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final p6.e invoke() {
                return p.f23061a.getDescriptor();
            }
        }

        public static final class d extends kotlin.jvm.internal.s implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f23055a = new d();

            public d() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final p6.e invoke() {
                return v.f23070a.getDescriptor();
            }
        }

        public static final class e extends kotlin.jvm.internal.s implements Function0 {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f23056a = new e();

            public e() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final p6.e invoke() {
                return s6.c.f23018a.getDescriptor();
            }
        }

        public a() {
            super(1);
        }

        @Override // Q5.k
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            invoke((p6.a) obj);
            return E.f1657a;
        }

        public final void invoke(p6.a buildSerialDescriptor) {
            kotlin.jvm.internal.r.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
            p6.a.b(buildSerialDescriptor, "JsonPrimitive", k.f(C0360a.f23052a), null, false, 12, null);
            p6.a.b(buildSerialDescriptor, "JsonNull", k.f(b.f23053a), null, false, 12, null);
            p6.a.b(buildSerialDescriptor, "JsonLiteral", k.f(c.f23054a), null, false, 12, null);
            p6.a.b(buildSerialDescriptor, "JsonObject", k.f(d.f23055a), null, false, 12, null);
            p6.a.b(buildSerialDescriptor, "JsonArray", k.f(e.f23056a), null, false, 12, null);
        }
    }

    @Override // n6.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public h deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        return k.d(decoder).j();
    }

    @Override // n6.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(q6.f encoder, h value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        k.h(encoder);
        if (value instanceof w) {
            encoder.s(x.f23075a, value);
        } else if (value instanceof u) {
            encoder.s(v.f23070a, value);
        } else if (value instanceof b) {
            encoder.s(c.f23018a, value);
        }
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return f23050b;
    }
}
