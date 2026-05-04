package eh;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements zg.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f8978a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final bh.e f8979b = a.f8980b;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements bh.e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8980b = new a();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final String f8981c = "kotlinx.serialization.json.JsonArray";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ bh.e f8982a = ah.a.g(q.f9024a).getDescriptor();

        @Override // bh.e
        public List getAnnotations() {
            return this.f8982a.getAnnotations();
        }

        @Override // bh.e
        public bh.l h() {
            return this.f8982a.h();
        }

        @Override // bh.e
        public String i() {
            return f8981c;
        }

        @Override // bh.e
        public boolean isInline() {
            return this.f8982a.isInline();
        }

        @Override // bh.e
        public boolean j() {
            return this.f8982a.j();
        }

        @Override // bh.e
        public int k(String name) {
            kotlin.jvm.internal.t.f(name, "name");
            return this.f8982a.k(name);
        }

        @Override // bh.e
        public int l() {
            return this.f8982a.l();
        }

        @Override // bh.e
        public String m(int i10) {
            return this.f8982a.m(i10);
        }

        @Override // bh.e
        public List n(int i10) {
            return this.f8982a.n(i10);
        }

        @Override // bh.e
        public bh.e o(int i10) {
            return this.f8982a.o(i10);
        }

        @Override // bh.e
        public boolean p(int i10) {
            return this.f8982a.p(i10);
        }
    }

    @Override // zg.a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public c deserialize(ch.e decoder) {
        kotlin.jvm.internal.t.f(decoder, "decoder");
        r.g(decoder);
        return new c((List) ah.a.g(q.f9024a).deserialize(decoder));
    }

    @Override // zg.k
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void serialize(ch.f encoder, c value) {
        kotlin.jvm.internal.t.f(encoder, "encoder");
        kotlin.jvm.internal.t.f(value, "value");
        r.h(encoder);
        ah.a.g(q.f9024a).serialize(encoder, value);
    }

    @Override // zg.b, zg.k, zg.a
    public bh.e getDescriptor() {
        return f8979b;
    }
}
