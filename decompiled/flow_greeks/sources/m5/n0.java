package m5;

import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class n0 extends o0 {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Callable f15954f;

    public /* synthetic */ n0(Callable callable, byte[] bArr) {
        super(false, 1, 5, null, null, -1L, null);
        this.f15954f = callable;
    }

    @Override // m5.o0
    public final String a() {
        try {
            return (String) this.f15954f.call();
        } catch (Exception e10) {
            throw new RuntimeException(e10);
        }
    }
}
