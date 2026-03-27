package u1;

import java.util.Arrays;

/* JADX INFO: renamed from: u1.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC1214p extends AbstractBinderC1213o {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final byte[] f10307c;

    public BinderC1214p(byte[] bArr) {
        super(Arrays.copyOfRange(bArr, 0, 25));
        this.f10307c = bArr;
    }

    @Override // u1.AbstractBinderC1213o
    public final byte[] b() {
        return this.f10307c;
    }
}
