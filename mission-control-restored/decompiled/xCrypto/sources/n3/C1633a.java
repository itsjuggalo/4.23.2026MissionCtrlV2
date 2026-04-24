package n3;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.r;
import m3.AbstractC1606a;

/* JADX INFO: renamed from: n3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1633a extends AbstractC1606a {
    @Override // m3.AbstractC1608c
    public long f(long j4, long j5) {
        return ThreadLocalRandom.current().nextLong(j4, j5);
    }

    @Override // m3.AbstractC1606a
    public Random g() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        r.e(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
