package m5;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c0 extends z {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final WeakReference f15894c = new WeakReference(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WeakReference f15895b;

    public c0(byte[] bArr) {
        super(bArr);
        this.f15895b = f15894c;
    }

    @Override // m5.z
    public final byte[] I() {
        byte[] bArrK;
        synchronized (this) {
            try {
                bArrK = (byte[]) this.f15895b.get();
                if (bArrK == null) {
                    bArrK = K();
                    this.f15895b = new WeakReference(bArrK);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArrK;
    }

    public abstract byte[] K();
}
