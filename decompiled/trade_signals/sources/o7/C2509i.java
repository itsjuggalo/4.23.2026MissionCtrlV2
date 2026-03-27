package o7;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: o7.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public final class C2509i extends AbstractC2520n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f22170a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22171b;

    public C2509i(byte[] bufferWithData) {
        AbstractC2304t.f(bufferWithData, "bufferWithData");
        this.f22170a = bufferWithData;
        this.f22171b = bufferWithData.length;
        b(10);
    }

    @Override // o7.AbstractC2520n0
    public void b(int i8) {
        byte[] bArr = this.f22170a;
        if (bArr.length < i8) {
            byte[] bArrCopyOf = Arrays.copyOf(bArr, H5.i.b(i8, bArr.length * 2));
            AbstractC2304t.e(bArrCopyOf, "copyOf(...)");
            this.f22170a = bArrCopyOf;
        }
    }

    @Override // o7.AbstractC2520n0
    public int d() {
        return this.f22171b;
    }

    public final void e(byte b8) {
        AbstractC2520n0.c(this, 0, 1, null);
        byte[] bArr = this.f22170a;
        int iD = d();
        this.f22171b = iD + 1;
        bArr[iD] = b8;
    }

    @Override // o7.AbstractC2520n0
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public byte[] a() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f22170a, d());
        AbstractC2304t.e(bArrCopyOf, "copyOf(...)");
        return bArrCopyOf;
    }
}
