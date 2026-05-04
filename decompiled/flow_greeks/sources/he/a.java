package he;

import dd.r;
import ef.f;
import fe.e;
import java.util.Collection;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public interface a {

    /* JADX INFO: renamed from: he.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0208a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0208a f11300a = new C0208a();

        @Override // he.a
        public Collection b(e classDescriptor) {
            t.f(classDescriptor, "classDescriptor");
            return r.k();
        }

        @Override // he.a
        public Collection c(e classDescriptor) {
            t.f(classDescriptor, "classDescriptor");
            return r.k();
        }

        @Override // he.a
        public Collection d(f name, e classDescriptor) {
            t.f(name, "name");
            t.f(classDescriptor, "classDescriptor");
            return r.k();
        }

        @Override // he.a
        public Collection e(e classDescriptor) {
            t.f(classDescriptor, "classDescriptor");
            return r.k();
        }
    }

    Collection b(e eVar);

    Collection c(e eVar);

    Collection d(f fVar, e eVar);

    Collection e(e eVar);
}
