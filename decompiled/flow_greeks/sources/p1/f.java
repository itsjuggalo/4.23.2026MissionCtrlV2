package p1;

import dd.o0;
import java.util.Map;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f18185a;

        public a(String name) {
            t.f(name, "name");
            this.f18185a = name;
        }

        public final String a() {
            return this.f18185a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return t.b(this.f18185a, ((a) obj).f18185a);
            }
            return false;
        }

        public int hashCode() {
            return this.f18185a.hashCode();
        }

        public String toString() {
            return this.f18185a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b {
    }

    public abstract Map a();

    public abstract Object b(a aVar);

    public final c c() {
        return new c(o0.z(a()), false);
    }

    public final f d() {
        return new c(o0.z(a()), true);
    }
}
