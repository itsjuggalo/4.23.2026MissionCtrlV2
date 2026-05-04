package eg;

import eg.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8876a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8877b;

        public a(int i10) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("must have at least ");
            sb2.append(i10);
            sb2.append(" value parameter");
            sb2.append(i10 > 1 ? "s" : "");
            super(sb2.toString(), null);
            this.f8877b = i10;
        }

        @Override // eg.f
        public boolean a(fe.z functionDescriptor) {
            kotlin.jvm.internal.t.f(functionDescriptor, "functionDescriptor");
            return functionDescriptor.i().size() >= this.f8877b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8878b;

        public b(int i10) {
            super("must have exactly " + i10 + " value parameters", null);
            this.f8878b = i10;
        }

        @Override // eg.f
        public boolean a(fe.z functionDescriptor) {
            kotlin.jvm.internal.t.f(functionDescriptor, "functionDescriptor");
            return functionDescriptor.i().size() == this.f8878b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class c extends a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f8879b = new c();

        public c() {
            super("must have no value parameters", null);
        }

        @Override // eg.f
        public boolean a(fe.z functionDescriptor) {
            kotlin.jvm.internal.t.f(functionDescriptor, "functionDescriptor");
            return functionDescriptor.i().isEmpty();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class d extends a0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f8880b = new d();

        public d() {
            super("must have a single value parameter", null);
        }

        @Override // eg.f
        public boolean a(fe.z functionDescriptor) {
            kotlin.jvm.internal.t.f(functionDescriptor, "functionDescriptor");
            return functionDescriptor.i().size() == 1;
        }
    }

    public /* synthetic */ a0(String str, kotlin.jvm.internal.k kVar) {
        this(str);
    }

    @Override // eg.f
    public String b(fe.z zVar) {
        return f.a.a(this, zVar);
    }

    @Override // eg.f
    public String getDescription() {
        return this.f8876a;
    }

    public a0(String str) {
        this.f8876a = str;
    }
}
