package W5;

import F5.F;
import java.util.NoSuchElementException;

/* JADX INFO: loaded from: classes2.dex */
public final class i extends F {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f5463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f5464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f5466d;

    public i(long j7, long j8, long j9) {
        this.f5463a = j9;
        this.f5464b = j8;
        boolean z7 = false;
        if (j9 <= 0 ? j7 >= j8 : j7 <= j8) {
            z7 = true;
        }
        this.f5465c = z7;
        this.f5466d = z7 ? j7 : j8;
    }

    @Override // F5.F
    public long c() {
        long j7 = this.f5466d;
        if (j7 != this.f5464b) {
            this.f5466d = this.f5463a + j7;
        } else {
            if (!this.f5465c) {
                throw new NoSuchElementException();
            }
            this.f5465c = false;
        }
        return j7;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f5465c;
    }
}
