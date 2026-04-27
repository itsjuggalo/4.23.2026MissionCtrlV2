package u7;

import java.io.RandomAccessFile;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: u7.n, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2821n extends AbstractC2815h {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final RandomAccessFile f23682e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2821n(boolean z7, RandomAccessFile randomAccessFile) {
        super(z7);
        AbstractC2304t.f(randomAccessFile, "randomAccessFile");
        this.f23682e = randomAccessFile;
    }

    @Override // u7.AbstractC2815h
    public synchronized void B() {
        this.f23682e.close();
    }

    @Override // u7.AbstractC2815h
    public synchronized void D() {
        this.f23682e.getFD().sync();
    }

    @Override // u7.AbstractC2815h
    public synchronized int E(long j8, byte[] array, int i8, int i9) {
        AbstractC2304t.f(array, "array");
        this.f23682e.seek(j8);
        int i10 = 0;
        while (true) {
            if (i10 >= i9) {
                break;
            }
            int i11 = this.f23682e.read(array, i8, i9 - i10);
            if (i11 != -1) {
                i10 += i11;
            } else if (i10 == 0) {
                return -1;
            }
        }
        return i10;
    }

    @Override // u7.AbstractC2815h
    public synchronized long K() {
        return this.f23682e.length();
    }

    @Override // u7.AbstractC2815h
    public synchronized void M(long j8, byte[] array, int i8, int i9) {
        AbstractC2304t.f(array, "array");
        this.f23682e.seek(j8);
        this.f23682e.write(array, i8, i9);
    }
}
