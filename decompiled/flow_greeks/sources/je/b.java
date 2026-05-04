package je;

import fe.v1;
import fe.w1;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class b extends w1 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f14312c = new b();

    public b() {
        super("protected_and_package", true);
    }

    @Override // fe.w1
    public Integer a(w1 visibility) {
        t.f(visibility, "visibility");
        if (t.b(this, visibility)) {
            return 0;
        }
        if (visibility == v1.b.f9529c) {
            return null;
        }
        return v1.f9525a.b(visibility) ? 1 : -1;
    }

    @Override // fe.w1
    public String b() {
        return "protected/*protected and package*/";
    }

    @Override // fe.w1
    public w1 d() {
        return v1.g.f9534c;
    }
}
