package r5;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes2.dex */
public final class K {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f22540d = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f22543c;

    public K(String str, String str2, long j7) {
        H2.m.o(str, "typeName");
        H2.m.e(!str.isEmpty(), "empty type");
        this.f22541a = str;
        this.f22542b = str2;
        this.f22543c = j7;
    }

    public static K a(Class cls, String str) {
        return b(c(cls), str);
    }

    public static K b(String str, String str2) {
        return new K(str, str2, e());
    }

    public static String c(Class cls) {
        String simpleName = ((Class) H2.m.o(cls, "type")).getSimpleName();
        return !simpleName.isEmpty() ? simpleName : cls.getName().substring(cls.getPackage().getName().length() + 1);
    }

    public static long e() {
        return f22540d.incrementAndGet();
    }

    public long d() {
        return this.f22543c;
    }

    public String f() {
        return this.f22541a + "<" + this.f22543c + ">";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        if (this.f22542b != null) {
            sb.append(": (");
            sb.append(this.f22542b);
            sb.append(')');
        }
        return sb.toString();
    }
}
