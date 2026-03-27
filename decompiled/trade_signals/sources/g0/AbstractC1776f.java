package g0;

import java.util.Map;
import kotlin.jvm.internal.AbstractC2304t;
import p5.M;

/* JADX INFO: renamed from: g0.f, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1776f {

    /* JADX INFO: renamed from: g0.f$a */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f17975a;

        public a(String name) {
            AbstractC2304t.f(name, "name");
            this.f17975a = name;
        }

        public final String a() {
            return this.f17975a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                return AbstractC2304t.b(this.f17975a, ((a) obj).f17975a);
            }
            return false;
        }

        public int hashCode() {
            return this.f17975a.hashCode();
        }

        public String toString() {
            return this.f17975a;
        }
    }

    /* JADX INFO: renamed from: g0.f$b */
    public static final class b {
    }

    public abstract Map a();

    public abstract Object b(a aVar);

    public final C1773c c() {
        return new C1773c(M.y(a()), false);
    }

    public final AbstractC1776f d() {
        return new C1773c(M.y(a()), true);
    }
}
