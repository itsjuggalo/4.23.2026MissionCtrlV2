package H5;

import java.util.NoSuchElementException;
import p5.J;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends J {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f3968a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f3969b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f3970c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3971d;

    public f(long j8, long j9, long j10) {
        this.f3968a = j10;
        this.f3969b = j9;
        boolean z7 = false;
        if (j10 <= 0 ? j8 >= j9 : j8 <= j9) {
            z7 = true;
        }
        this.f3970c = z7;
        this.f3971d = z7 ? j8 : j9;
    }

    @Override // p5.J
    public long c() {
        long j8 = this.f3971d;
        if (j8 != this.f3969b) {
            this.f3971d = this.f3968a + j8;
        } else {
            if (!this.f3970c) {
                throw new NoSuchElementException();
            }
            this.f3970c = false;
        }
        return j8;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f3970c;
    }
}
