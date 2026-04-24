package K2;

import K2.S;
import K2.c0;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public abstract class T extends S.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0.b f1084a = c0.b.a(new a());

    public static final class a {
        public String toString() {
            return "service config is unused";
        }
    }

    public abstract String b();

    public abstract int c();

    public abstract boolean d();

    public abstract c0.b e(Map map);

    public final boolean equals(Object obj) {
        return this == obj;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final String toString() {
        return Z1.g.b(this).d("policy", b()).b("priority", c()).e("available", d()).toString();
    }
}
