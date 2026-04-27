package Q1;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class z extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final byte[] f6717b;

    public z(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f6717b = bArr;
    }

    @Override // Q1.y
    public final byte[] G() {
        return this.f6717b;
    }
}
