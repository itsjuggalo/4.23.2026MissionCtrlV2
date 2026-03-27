package M5;

import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends L5.a {

    /* JADX INFO: renamed from: M5.a$a, reason: collision with other inner class name */
    public static final class C0052a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0052a f3892a = new C0052a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f3893b;

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
            f3893b = num;
        }
    }

    private final boolean c(int i7) {
        Integer num = C0052a.f3893b;
        return num == null || num.intValue() >= i7;
    }

    @Override // L5.a
    public void a(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        r.f(cause, "cause");
        r.f(exception, "exception");
        if (c(19)) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }
}
