package K3;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements F3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f1331a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final H3.e f1332b = a.f1333b;

    public static final class a implements H3.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f1333b = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f1334c = "kotlinx.serialization.json.JsonArray";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ H3.e f1335a = G3.a.g(j.f1362a).getDescriptor();

        @Override // H3.e
        public String a() {
            return f1334c;
        }

        @Override // H3.e
        public boolean c() {
            return this.f1335a.c();
        }

        @Override // H3.e
        public int d(String name) {
            kotlin.jvm.internal.r.f(name, "name");
            return this.f1335a.d(name);
        }

        @Override // H3.e
        public H3.i e() {
            return this.f1335a.e();
        }

        @Override // H3.e
        public int f() {
            return this.f1335a.f();
        }

        @Override // H3.e
        public String g(int i4) {
            return this.f1335a.g(i4);
        }

        @Override // H3.e
        public List getAnnotations() {
            return this.f1335a.getAnnotations();
        }

        @Override // H3.e
        public List h(int i4) {
            return this.f1335a.h(i4);
        }

        @Override // H3.e
        public H3.e i(int i4) {
            return this.f1335a.i(i4);
        }

        @Override // H3.e
        public boolean isInline() {
            return this.f1335a.isInline();
        }

        @Override // H3.e
        public boolean j(int i4) {
            return this.f1335a.j(i4);
        }
    }

    @Override // F3.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deserialize(I3.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        k.g(decoder);
        return new b((List) G3.a.g(j.f1362a).deserialize(decoder));
    }

    @Override // F3.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(I3.f encoder, b value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        k.h(encoder);
        G3.a.g(j.f1362a).serialize(encoder, value);
    }

    @Override // F3.b, F3.h, F3.a
    public H3.e getDescriptor() {
        return f1332b;
    }
}
