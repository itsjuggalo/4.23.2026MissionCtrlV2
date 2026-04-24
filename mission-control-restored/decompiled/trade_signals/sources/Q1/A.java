package Q1;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public abstract class A extends y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakReference f6646c = new WeakReference(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f6647b;

    public A(byte[] bArr) {
        super(bArr);
        this.f6647b = f6646c;
    }

    @Override // Q1.y
    public final byte[] G() {
        byte[] bArrH;
        synchronized (this) {
            try {
                bArrH = (byte[]) this.f6647b.get();
                if (bArrH == null) {
                    bArrH = H();
                    this.f6647b = new WeakReference(bArrH);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrH;
    }

    public abstract byte[] H();
}
