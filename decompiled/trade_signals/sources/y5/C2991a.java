package y5;

import F5.c;
import x5.AbstractC2959a;

/* JADX INFO: renamed from: y5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C2991a extends AbstractC2959a {

    /* JADX INFO: renamed from: y5.a$a, reason: collision with other inner class name */
    public static final class C0436a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0436a f24511a = new C0436a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f24512b;

        static {
            Object obj;
            Integer num = null;
            try {
                obj = Class.forName("android.os.Build$VERSION").getField("SDK_INT").get(null);
            } catch (Throwable unused) {
            }
            Integer num2 = obj instanceof Integer ? (Integer) obj : null;
            if (num2 != null && num2.intValue() > 0) {
                num = num2;
            }
            f24512b = num;
        }
    }

    @Override // w5.AbstractC2925a
    public c b() {
        return c(34) ? new G5.a() : super.b();
    }

    public final boolean c(int i8) {
        Integer num = C0436a.f24512b;
        return num == null || num.intValue() >= i8;
    }
}
