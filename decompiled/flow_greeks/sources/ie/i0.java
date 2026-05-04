package ie;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12348a = a.f12349a;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f12349a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final fe.g0 f12350b = new fe.g0("PackageViewDescriptorFactory");

        public final fe.g0 a() {
            return f12350b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements i0 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f12351b = new b();

        @Override // ie.i0
        public fe.u0 a(f0 module, ef.c fqName, wf.n storageManager) {
            kotlin.jvm.internal.t.f(module, "module");
            kotlin.jvm.internal.t.f(fqName, "fqName");
            kotlin.jvm.internal.t.f(storageManager, "storageManager");
            return new x(module, fqName, storageManager);
        }
    }

    fe.u0 a(f0 f0Var, ef.c cVar, wf.n nVar);
}
