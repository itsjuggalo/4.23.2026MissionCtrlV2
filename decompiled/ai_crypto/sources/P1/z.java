package P1;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class z extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f4323b;

    public z(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f4323b = bArr;
    }

    @Override // P1.y
    public final byte[] a0() {
        return this.f4323b;
    }
}
