package K2;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class K {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f1050d = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f1053c;

    public K(String str, String str2, long j4) {
        Z1.m.o(str, "typeName");
        Z1.m.e(!str.isEmpty(), "empty type");
        this.f1051a = str;
        this.f1052b = str2;
        this.f1053c = j4;
    }

    public static K a(Class cls, String str) {
        return b(c(cls), str);
    }

    public static K b(String str, String str2) {
        return new K(str, str2, e());
    }

    public static String c(Class cls) {
        String simpleName = ((Class) Z1.m.o(cls, "type")).getSimpleName();
        return !simpleName.isEmpty() ? simpleName : cls.getName().substring(cls.getPackage().getName().length() + 1);
    }

    public static long e() {
        return f1050d.incrementAndGet();
    }

    public long d() {
        return this.f1053c;
    }

    public String f() {
        return this.f1051a + "<" + this.f1053c + ">";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(f());
        if (this.f1052b != null) {
            sb.append(": (");
            sb.append(this.f1052b);
            sb.append(')');
        }
        return sb.toString();
    }
}
