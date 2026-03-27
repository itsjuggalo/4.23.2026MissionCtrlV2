package F4;

import java.util.concurrent.atomic.AtomicLong;
import v2.AbstractC2848n;

/* JADX INFO: loaded from: classes.dex */
public final class J {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f1639d = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1641b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1642c;

    public J(String str, String str2, long j8) {
        AbstractC2848n.o(str, "typeName");
        AbstractC2848n.e(!str.isEmpty(), "empty type");
        this.f1640a = str;
        this.f1641b = str2;
        this.f1642c = j8;
    }

    public static J a(Class cls, String str) {
        return b(c(cls), str);
    }

    public static J b(String str, String str2) {
        return new J(str, str2, e());
    }

    public static String c(Class cls) {
        String simpleName = ((Class) AbstractC2848n.o(cls, "type")).getSimpleName();
        return !simpleName.isEmpty() ? simpleName : cls.getName().substring(cls.getPackage().getName().length() + 1);
    }

    public static long e() {
        return f1639d.incrementAndGet();
    }

    public long d() {
        return this.f1642c;
    }

    public String f() {
        return this.f1640a + "<" + this.f1642c + ">";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        if (this.f1641b != null) {
            sb.append(": (");
            sb.append(this.f1641b);
            sb.append(')');
        }
        return sb.toString();
    }
}
