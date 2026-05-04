package y1;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f25164a = new LinkedHashMap();

    /* JADX INFO: renamed from: y1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0467a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C0467a f25165b = new C0467a();

        @Override // y1.a
        public Object a(b key) {
            t.f(key, "key");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface b {
    }

    public abstract Object a(b bVar);

    public final Map b() {
        return this.f25164a;
    }
}
