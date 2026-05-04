package ld;

import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends kd.a {

    /* JADX INFO: renamed from: ld.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class C0278a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C0278a f15589a = new C0278a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final Integer f15590b;

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
            f15590b = num;
        }
    }

    private final boolean c(int i10) {
        Integer num = C0278a.f15590b;
        return num == null || num.intValue() >= i10;
    }

    @Override // kd.a
    public void a(Throwable cause, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        t.f(cause, "cause");
        t.f(exception, "exception");
        if (c(19)) {
            cause.addSuppressed(exception);
        } else {
            super.a(cause, exception);
        }
    }
}
