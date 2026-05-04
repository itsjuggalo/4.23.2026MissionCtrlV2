package vd;

import dd.k0;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f23400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f23401b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f23402c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f23403d;

    public i(long j10, long j11, long j12) {
        this.f23400a = j12;
        this.f23401b = j11;
        boolean z10 = false;
        if (j12 <= 0 ? j10 >= j11 : j10 <= j11) {
            z10 = true;
        }
        this.f23402c = z10;
        this.f23403d = z10 ? j10 : j11;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f23402c;
    }

    @Override // dd.k0
    public long nextLong() {
        long j10 = this.f23403d;
        if (j10 != this.f23401b) {
            this.f23403d = this.f23400a + j10;
            return j10;
        }
        if (!this.f23402c) {
            throw new NoSuchElementException();
        }
        this.f23402c = false;
        return j10;
    }
}
