package V5;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public final class a extends U5.a {
    @Override // U5.c
    public long f(long j7, long j8) {
        return ThreadLocalRandom.current().nextLong(j7, j8);
    }

    @Override // U5.a
    public Random g() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        r.e(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
