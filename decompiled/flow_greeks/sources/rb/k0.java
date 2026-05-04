package rb;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class k0 {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f19587d = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f19588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f19589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f19590c;

    public k0(String str, String str2, long j10) {
        p6.n.o(str, "typeName");
        p6.n.e(!str.isEmpty(), "empty type");
        this.f19588a = str;
        this.f19589b = str2;
        this.f19590c = j10;
    }

    public static k0 a(Class cls, String str) {
        return b(c(cls), str);
    }

    public static k0 b(String str, String str2) {
        return new k0(str, str2, e());
    }

    public static String c(Class cls) {
        String simpleName = ((Class) p6.n.o(cls, "type")).getSimpleName();
        return !simpleName.isEmpty() ? simpleName : cls.getName().substring(cls.getPackage().getName().length() + 1);
    }

    public static long e() {
        return f19587d.incrementAndGet();
    }

    public long d() {
        return this.f19590c;
    }

    public String f() {
        return this.f19588a + "<" + this.f19590c + ">";
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(f());
        if (this.f19589b != null) {
            sb2.append(": (");
            sb2.append(this.f19589b);
            sb2.append(')');
        }
        return sb2.toString();
    }
}
