package g0;

import F5.J;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f14251a;

        public a(String name) {
            r.f(name, "name");
            this.f14251a = name;
        }

        public final String a() {
            return this.f14251a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return r.b(this.f14251a, ((a) obj).f14251a);
            }
            return false;
        }

        public int hashCode() {
            return this.f14251a.hashCode();
        }

        public String toString() {
            return this.f14251a;
        }
    }

    public static final class b {
    }

    public abstract Map a();

    public abstract Object b(a aVar);

    public final C1631c c() {
        return new C1631c(J.u(a()), false);
    }

    public final f d() {
        return new C1631c(J.u(a()), true);
    }
}
