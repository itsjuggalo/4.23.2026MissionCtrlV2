package he;

import fe.e;
import fe.f1;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface c {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11301a = new a();

        @Override // he.c
        public boolean a(e classDescriptor, f1 functionDescriptor) {
            t.f(classDescriptor, "classDescriptor");
            t.f(functionDescriptor, "functionDescriptor");
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f11302a = new b();

        @Override // he.c
        public boolean a(e classDescriptor, f1 functionDescriptor) {
            t.f(classDescriptor, "classDescriptor");
            t.f(functionDescriptor, "functionDescriptor");
            return !functionDescriptor.getAnnotations().E(d.a());
        }
    }

    boolean a(e eVar, f1 f1Var);
}
