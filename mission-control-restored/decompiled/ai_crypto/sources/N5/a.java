package N5;

import U5.c;

/* JADX INFO: loaded from: classes2.dex */
public class a extends M5.a {

    /* JADX INFO: renamed from: N5.a$a, reason: collision with other inner class name */
    public static final class C0059a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0059a f3966a = new C0059a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f3967b;

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
            f3967b = num;
        }
    }

    @Override // L5.a
    public c b() {
        return c(34) ? new V5.a() : super.b();
    }

    public final boolean c(int i7) {
        Integer num = C0059a.f3967b;
        return num == null || num.intValue() >= i7;
    }
}
