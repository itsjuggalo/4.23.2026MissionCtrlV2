package o5;

import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.AbstractC2304t;
import w5.AbstractC2926b;

/* JADX INFO: renamed from: o5.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2477e {
    public static void a(Throwable th, Throwable exception) throws IllegalAccessException, InvocationTargetException {
        AbstractC2304t.f(th, "<this>");
        AbstractC2304t.f(exception, "exception");
        if (th != exception) {
            AbstractC2926b.f24073a.a(th, exception);
        }
    }
}
