package e3;

import d3.AbstractC1217a;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.r;

/* JADX INFO: renamed from: e3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1237a extends AbstractC1217a {

    /* JADX INFO: renamed from: e3.a$a, reason: collision with other inner class name */
    public static final class C0190a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0190a f11515a = new C0190a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f11516b;

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
            f11516b = num;
        }
    }

    private final boolean c(int i4) {
        Integer num = C0190a.f11516b;
        return num == null || num.intValue() >= i4;
    }

    @Override // d3.AbstractC1217a
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
