package P1;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class A extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakReference f4252c = new WeakReference(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f4253b;

    public A(byte[] bArr) {
        super(bArr);
        this.f4253b = f4252c;
    }

    @Override // P1.y
    public final byte[] a0() {
        byte[] bArrB0;
        synchronized (this) {
            try {
                bArrB0 = (byte[]) this.f4253b.get();
                if (bArrB0 == null) {
                    bArrB0 = b0();
                    this.f4253b = new WeakReference(bArrB0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrB0;
    }

    public abstract byte[] b0();
}
