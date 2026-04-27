package s6;

import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class c implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f23018a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.e f23019b = a.f23020b;

    public static final class a implements p6.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f23020b = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f23021c = "kotlinx.serialization.json.JsonArray";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p6.e f23022a = o6.a.g(j.f23049a).getDescriptor();

        @Override // p6.e
        public String a() {
            return f23021c;
        }

        @Override // p6.e
        public boolean c() {
            return this.f23022a.c();
        }

        @Override // p6.e
        public int d(String name) {
            kotlin.jvm.internal.r.f(name, "name");
            return this.f23022a.d(name);
        }

        @Override // p6.e
        public p6.i e() {
            return this.f23022a.e();
        }

        @Override // p6.e
        public int f() {
            return this.f23022a.f();
        }

        @Override // p6.e
        public String g(int i7) {
            return this.f23022a.g(i7);
        }

        @Override // p6.e
        public List getAnnotations() {
            return this.f23022a.getAnnotations();
        }

        @Override // p6.e
        public List h(int i7) {
            return this.f23022a.h(i7);
        }

        @Override // p6.e
        public p6.e i(int i7) {
            return this.f23022a.i(i7);
        }

        @Override // p6.e
        public boolean isInline() {
            return this.f23022a.isInline();
        }

        @Override // p6.e
        public boolean j(int i7) {
            return this.f23022a.j(i7);
        }
    }

    @Override // n6.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        k.g(decoder);
        return new b((List) o6.a.g(j.f23049a).deserialize(decoder));
    }

    @Override // n6.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(q6.f encoder, b value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        k.h(encoder);
        o6.a.g(j.f23049a).serialize(encoder, value);
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return f23019b;
    }
}
