package m5;

import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends z {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f15882b;

    public a0(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f15882b = bArr;
    }

    @Override // m5.z
    public final byte[] I() {
        return this.f15882b;
    }
}
