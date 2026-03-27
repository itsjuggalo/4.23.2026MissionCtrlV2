package z1;

import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: z1.A, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC1970A extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakReference f16049c = new WeakReference(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f16050b;

    public AbstractBinderC1970A(byte[] bArr) {
        super(bArr);
        this.f16050b = f16049c;
    }

    @Override // z1.y
    public final byte[] a0() {
        byte[] bArrB0;
        synchronized (this) {
            try {
                bArrB0 = (byte[]) this.f16050b.get();
                if (bArrB0 == null) {
                    bArrB0 = b0();
                    this.f16050b = new WeakReference(bArrB0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrB0;
    }

    public abstract byte[] b0();
}
