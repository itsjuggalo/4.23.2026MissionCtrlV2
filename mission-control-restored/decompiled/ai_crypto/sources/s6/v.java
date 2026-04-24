package s6;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.K;

/* JADX INFO: loaded from: classes2.dex */
public final class v implements n6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v f23070a = new v();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final p6.e f23071b = a.f23072b;

    public static final class a implements p6.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f23072b = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f23073c = "kotlinx.serialization.json.JsonObject";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ p6.e f23074a = o6.a.i(o6.a.E(K.f18253a), j.f23049a).getDescriptor();

        @Override // p6.e
        public String a() {
            return f23073c;
        }

        @Override // p6.e
        public boolean c() {
            return this.f23074a.c();
        }

        @Override // p6.e
        public int d(String name) {
            kotlin.jvm.internal.r.f(name, "name");
            return this.f23074a.d(name);
        }

        @Override // p6.e
        public p6.i e() {
            return this.f23074a.e();
        }

        @Override // p6.e
        public int f() {
            return this.f23074a.f();
        }

        @Override // p6.e
        public String g(int i7) {
            return this.f23074a.g(i7);
        }

        @Override // p6.e
        public List getAnnotations() {
            return this.f23074a.getAnnotations();
        }

        @Override // p6.e
        public List h(int i7) {
            return this.f23074a.h(i7);
        }

        @Override // p6.e
        public p6.e i(int i7) {
            return this.f23074a.i(i7);
        }

        @Override // p6.e
        public boolean isInline() {
            return this.f23074a.isInline();
        }

        @Override // p6.e
        public boolean j(int i7) {
            return this.f23074a.j(i7);
        }
    }

    @Override // n6.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public u deserialize(q6.e decoder) {
        kotlin.jvm.internal.r.f(decoder, "decoder");
        k.g(decoder);
        return new u((Map) o6.a.i(o6.a.E(K.f18253a), j.f23049a).deserialize(decoder));
    }

    @Override // n6.h
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(q6.f encoder, u value) {
        kotlin.jvm.internal.r.f(encoder, "encoder");
        kotlin.jvm.internal.r.f(value, "value");
        k.h(encoder);
        o6.a.i(o6.a.E(K.f18253a), j.f23049a).serialize(encoder, value);
    }

    @Override // n6.b, n6.h, n6.a
    public p6.e getDescriptor() {
        return f23071b;
    }
}
