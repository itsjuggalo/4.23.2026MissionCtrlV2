package G5;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends F5.a {
    @Override // F5.c
    public long f(long j8, long j9) {
        return ThreadLocalRandom.current().nextLong(j8, j9);
    }

    @Override // F5.a
    public Random g() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        AbstractC2304t.e(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
