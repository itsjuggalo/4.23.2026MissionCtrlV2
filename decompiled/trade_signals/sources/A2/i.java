package A2;

import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes.dex */
public abstract class i {
    public static void a(Object obj, long j8) {
        LockSupport.parkNanos(obj, Math.min(j8, 2147483647999999999L));
    }
}
