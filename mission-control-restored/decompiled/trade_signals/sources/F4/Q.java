package F4;

import F4.P;
import F4.a0;
import io.flutter.plugins.firebase.database.Constants;
import java.util.Map;
import v2.AbstractC2842h;

/* JADX INFO: loaded from: classes.dex */
public abstract class Q extends P.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a0.b f1673a = a0.b.a(new a());

    public static final class a {
        public String toString() {
            return "service config is unused";
        }
    }

    public abstract String b();

    public abstract int c();

    public abstract boolean d();

    public abstract a0.b e(Map map);

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return AbstractC2842h.b(this).d("policy", b()).b(Constants.PRIORITY, c()).e("available", d()).toString();
    }
}
