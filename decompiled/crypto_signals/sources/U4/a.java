package U4;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public final class a extends T4.a {
    @Override // T4.a
    public final Random a() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        j.d(threadLocalRandomCurrent, "current(...)");
        return threadLocalRandomCurrent;
    }
}
