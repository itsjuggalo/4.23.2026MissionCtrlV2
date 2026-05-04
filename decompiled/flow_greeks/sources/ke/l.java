package ke;

import fe.h1;
import kotlin.jvm.internal.t;
import le.u;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements ue.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f14841a = new l();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a implements ue.a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final u f14842b;

        public a(u javaElement) {
            t.f(javaElement, "javaElement");
            this.f14842b = javaElement;
        }

        @Override // fe.g1
        public h1 a() {
            h1 NO_SOURCE_FILE = h1.f9484a;
            t.e(NO_SOURCE_FILE, "NO_SOURCE_FILE");
            return NO_SOURCE_FILE;
        }

        @Override // ue.a
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public u b() {
            return this.f14842b;
        }

        public String toString() {
            return a.class.getName() + ": " + b();
        }
    }

    @Override // ue.b
    public ue.a a(ve.l javaElement) {
        t.f(javaElement, "javaElement");
        return new a((u) javaElement);
    }
}
