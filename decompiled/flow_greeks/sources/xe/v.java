package xe;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface v extends tf.a0 {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a {

        /* JADX INFO: renamed from: xe.v$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static final class C0458a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final x f24926a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final byte[] f24927b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0458a(x kotlinJvmBinaryClass, byte[] bArr) {
                super(null);
                kotlin.jvm.internal.t.f(kotlinJvmBinaryClass, "kotlinJvmBinaryClass");
                this.f24926a = kotlinJvmBinaryClass;
                this.f24927b = bArr;
            }

            public final x b() {
                return this.f24926a;
            }

            public /* synthetic */ C0458a(x xVar, byte[] bArr, int i10, kotlin.jvm.internal.k kVar) {
                this(xVar, (i10 & 2) != 0 ? null : bArr);
            }
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        public final x a() {
            C0458a c0458a = this instanceof C0458a ? (C0458a) this : null;
            if (c0458a != null) {
                return c0458a.b();
            }
            return null;
        }

        public a() {
        }
    }

    a a(ef.b bVar, df.e eVar);

    a b(ve.g gVar, df.e eVar);
}
