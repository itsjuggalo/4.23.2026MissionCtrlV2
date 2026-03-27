package p7;

import java.util.List;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: p7.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2611d implements k7.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2611d f22444a = new C2611d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m7.e f22445b = a.f22446b;

    /* JADX INFO: renamed from: p7.d$a */
    public static final class a implements m7.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f22446b = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f22447c = "kotlinx.serialization.json.JsonArray";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m7.e f22448a = l7.a.g(q.f22483a).getDescriptor();

        @Override // m7.e
        public String a() {
            return f22447c;
        }

        @Override // m7.e
        public boolean c() {
            return this.f22448a.c();
        }

        @Override // m7.e
        public int d(String name) {
            AbstractC2304t.f(name, "name");
            return this.f22448a.d(name);
        }

        @Override // m7.e
        public int e() {
            return this.f22448a.e();
        }

        @Override // m7.e
        public String f(int i8) {
            return this.f22448a.f(i8);
        }

        @Override // m7.e
        public List g(int i8) {
            return this.f22448a.g(i8);
        }

        @Override // m7.e
        public List getAnnotations() {
            return this.f22448a.getAnnotations();
        }

        @Override // m7.e
        public m7.e h(int i8) {
            return this.f22448a.h(i8);
        }

        @Override // m7.e
        public m7.l i() {
            return this.f22448a.i();
        }

        @Override // m7.e
        public boolean isInline() {
            return this.f22448a.isInline();
        }

        @Override // m7.e
        public boolean j(int i8) {
            return this.f22448a.j(i8);
        }
    }

    @Override // k7.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public C2610c deserialize(n7.e decoder) {
        AbstractC2304t.f(decoder, "decoder");
        r.g(decoder);
        return new C2610c((List) l7.a.g(q.f22483a).deserialize(decoder));
    }

    @Override // k7.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(n7.f encoder, C2610c value) {
        AbstractC2304t.f(encoder, "encoder");
        AbstractC2304t.f(value, "value");
        r.h(encoder);
        l7.a.g(q.f22483a).serialize(encoder, value);
    }

    @Override // k7.b, k7.k, k7.a
    public m7.e getDescriptor() {
        return f22445b;
    }
}
