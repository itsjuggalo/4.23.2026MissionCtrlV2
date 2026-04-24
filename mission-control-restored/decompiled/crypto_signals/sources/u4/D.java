package u4;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class D {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicLong f10336d = new AtomicLong();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f10339c;

    public D(String str, String str2, long j4) {
        s3.D.j(str, "typeName");
        s3.D.f("empty type", !str.isEmpty());
        this.f10337a = str;
        this.f10338b = str2;
        this.f10339c = j4;
    }

    public static D a(Class cls, String str) {
        String simpleName = cls.getSimpleName();
        if (simpleName.isEmpty()) {
            simpleName = cls.getName().substring(cls.getPackage().getName().length() + 1);
        }
        return new D(simpleName, str, f10336d.incrementAndGet());
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10337a + "<" + this.f10339c + ">");
        String str = this.f10338b;
        if (str != null) {
            sb.append(": (");
            sb.append(str);
            sb.append(')');
        }
        return sb.toString();
    }
}
