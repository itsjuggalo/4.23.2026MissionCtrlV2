package z5;

import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import o5.AbstractC2477e;

/* JADX INFO: renamed from: z5.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC3014b {
    public static final void a(Closeable closeable, Throwable th) throws IllegalAccessException, IOException, InvocationTargetException {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                AbstractC2477e.a(th, th2);
            }
        }
    }
}
