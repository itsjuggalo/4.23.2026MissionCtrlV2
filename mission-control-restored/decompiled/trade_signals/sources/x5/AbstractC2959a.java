package x5;

import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.AbstractC2304t;
import w5.AbstractC2925a;

/* JADX INFO: renamed from: x5.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2959a extends AbstractC2925a {

    /* JADX INFO: renamed from: x5.a$a, reason: collision with other inner class name */
    public static final class C0429a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0429a f24201a = new C0429a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f24202b;

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
            f24202b = num;
        }
    }

    private final boolean c(int i8) {
        Integer num = C0429a.f24202b;
        return num == null || num.intValue() >= i8;
    }

    @Override // w5.AbstractC2925a
    public void a(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        AbstractC2304t.f(cause, "cause");
        AbstractC2304t.f(exception, "exception");
        if (c(19)) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }
}
