package rb;

import io.flutter.plugins.firebase.database.Constants;
import java.util.Map;
import rb.b1;
import rb.r0;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s0 extends r0.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b1.b f19717a = b1.b.a(new a());

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public String toString() {
            return "service config is unused";
        }
    }

    public abstract String b();

    public abstract int c();

    public abstract boolean d();

    public abstract b1.b e(Map map);

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return p6.h.b(this).d("policy", b()).b(Constants.PRIORITY, c()).e("available", d()).toString();
    }
}
