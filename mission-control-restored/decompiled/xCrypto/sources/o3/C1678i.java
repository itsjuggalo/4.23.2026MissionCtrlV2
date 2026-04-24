package o3;

import X2.H;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: o3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes3.dex */
public final class C1678i extends H {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f13948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f13950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f13951d;

    public C1678i(long j4, long j5, long j6) {
        this.f13948a = j6;
        this.f13949b = j5;
        boolean z4 = false;
        if (j6 <= 0 ? j4 >= j5 : j4 <= j5) {
            z4 = true;
        }
        this.f13950c = z4;
        this.f13951d = z4 ? j4 : j5;
    }

    @Override // X2.H
    public long b() {
        long j4 = this.f13951d;
        if (j4 != this.f13949b) {
            this.f13951d = this.f13948a + j4;
            return j4;
        }
        if (!this.f13950c) {
            throw new NoSuchElementException();
        }
        this.f13950c = false;
        return j4;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f13950c;
    }
}
