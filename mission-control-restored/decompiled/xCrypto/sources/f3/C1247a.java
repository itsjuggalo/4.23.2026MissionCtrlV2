package f3;

import e3.AbstractC1237a;
import m3.AbstractC1608c;
import n3.C1633a;

/* JADX INFO: renamed from: f3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public class C1247a extends AbstractC1237a {

    /* JADX INFO: renamed from: f3.a$a, reason: collision with other inner class name */
    public static final class C0195a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0195a f11540a = new C0195a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f11541b;

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
            f11541b = num;
        }
    }

    @Override // d3.AbstractC1217a
    public AbstractC1608c b() {
        return c(34) ? new C1633a() : super.b();
    }

    public final boolean c(int i4) {
        Integer num = C0195a.f11541b;
        return num == null || num.intValue() >= i4;
    }
}
