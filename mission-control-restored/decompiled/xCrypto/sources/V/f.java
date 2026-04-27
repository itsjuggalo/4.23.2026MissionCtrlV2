package V;

import X2.L;
import java.util.Map;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5284a;

        public a(String name) {
            r.f(name, "name");
            this.f5284a = name;
        }

        public final String a() {
            return this.f5284a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return r.b(this.f5284a, ((a) obj).f5284a);
            }
            return false;
        }

        public int hashCode() {
            return this.f5284a.hashCode();
        }

        public String toString() {
            return this.f5284a;
        }
    }

    public static final class b {
    }

    public abstract Map a();

    public abstract Object b(a aVar);

    public final c c() {
        return new c(L.u(a()), false);
    }

    public final f d() {
        return new c(L.u(a()), true);
    }
}
