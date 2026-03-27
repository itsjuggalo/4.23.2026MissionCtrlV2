package p7;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import kotlin.jvm.internal.U;

/* JADX INFO: loaded from: classes2.dex */
public final class D implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final D f22427a = new D();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.e f22428b = a.f22429b;

    public static final class a implements m7.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f22429b = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f22430c = "kotlinx.serialization.json.JsonObject";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m7.e f22431a = l7.a.i(l7.a.A(U.f20474a), q.f22483a).getDescriptor();

        @Override // m7.e
        public String a() {
            return f22430c;
        }

        @Override // m7.e
        public boolean c() {
            return this.f22431a.c();
        }

        @Override // m7.e
        public int d(String name) {
            AbstractC2304t.f(name, "name");
            return this.f22431a.d(name);
        }

        @Override // m7.e
        public int e() {
            return this.f22431a.e();
        }

        @Override // m7.e
        public String f(int i8) {
            return this.f22431a.f(i8);
        }

        @Override // m7.e
        public List g(int i8) {
            return this.f22431a.g(i8);
        }

        @Override // m7.e
        public List getAnnotations() {
            return this.f22431a.getAnnotations();
        }

        @Override // m7.e
        public m7.e h(int i8) {
            return this.f22431a.h(i8);
        }

        @Override // m7.e
        public m7.l i() {
            return this.f22431a.i();
        }

        @Override // m7.e
        public boolean isInline() {
            return this.f22431a.isInline();
        }

        @Override // m7.e
        public boolean j(int i8) {
            return this.f22431a.j(i8);
        }
    }

    @Override // k7.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        r.g(decoder);
        return new C((Map) l7.a.i(l7.a.A(U.f20474a), q.f22483a).deserialize(decoder));
    }

    @Override // k7.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(n7.f encoder, C value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        r.h(encoder);
        l7.a.i(l7.a.A(U.f20474a), q.f22483a).serialize(encoder, value);
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return f22428b;
    }
}
