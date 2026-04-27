package w6;

import java.io.RandomAccessFile;

/* JADX INFO: loaded from: classes2.dex */
public final class r extends AbstractC2796i {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RandomAccessFile f25147e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(boolean z7, RandomAccessFile randomAccessFile) {
        super(z7);
        kotlin.jvm.internal.r.f(randomAccessFile, "randomAccessFile");
        this.f25147e = randomAccessFile;
    }

    @Override // w6.AbstractC2796i
    public synchronized void M() {
        this.f25147e.close();
    }

    @Override // w6.AbstractC2796i
    public synchronized void O() {
        this.f25147e.getFD().sync();
    }

    @Override // w6.AbstractC2796i
    public synchronized int T(long j7, byte[] array, int i7, int i8) {
        kotlin.jvm.internal.r.f(array, "array");
        this.f25147e.seek(j7);
        int i9 = 0;
        while (true) {
            if (i9 >= i8) {
                break;
            }
            int i10 = this.f25147e.read(array, i7, i8 - i9);
            if (i10 != -1) {
                i9 += i10;
            } else if (i9 == 0) {
                return -1;
            }
        }
        return i9;
    }

    @Override // w6.AbstractC2796i
    public synchronized long V() {
        return this.f25147e.length();
    }

    @Override // w6.AbstractC2796i
    public synchronized void X(long j7, byte[] array, int i7, int i8) {
        kotlin.jvm.internal.r.f(array, "array");
        this.f25147e.seek(j7);
        this.f25147e.write(array, i7, i8);
    }
}
