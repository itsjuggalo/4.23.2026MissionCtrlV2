package eg;

import eg.f;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class k implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8902a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f8903b = new a();

        public a() {
            super("must be a member function", null);
        }

        @Override // eg.f
        public boolean a(fe.z functionDescriptor) {
            kotlin.jvm.internal.t.f(functionDescriptor, "functionDescriptor");
            return functionDescriptor.e0() != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends k {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f8904b = new b();

        public b() {
            super("must be a member or an extension function", null);
        }

        @Override // eg.f
        public boolean a(fe.z functionDescriptor) {
            kotlin.jvm.internal.t.f(functionDescriptor, "functionDescriptor");
            return (functionDescriptor.e0() == null && functionDescriptor.k0() == null) ? false : true;
        }
    }

    public /* synthetic */ k(String str, kotlin.jvm.internal.k kVar) {
        this(str);
    }

    @Override // eg.f
    public String b(fe.z zVar) {
        return f.a.a(this, zVar);
    }

    @Override // eg.f
    public String getDescription() {
        return this.f8902a;
    }

    public k(String str) {
        this.f8902a = str;
    }
}
