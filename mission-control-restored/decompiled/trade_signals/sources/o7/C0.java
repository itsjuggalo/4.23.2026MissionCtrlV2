package o7;

import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public final class C0 extends AbstractC2520n0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f22099a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f22100b;

    public C0(byte[] bufferWithData) {
        AbstractC2304t.f(bufferWithData, "bufferWithData");
        this.f22099a = bufferWithData;
        this.f22100b = o5.y.I(bufferWithData);
        b(10);
    }

    @Override // o7.AbstractC2520n0
    public /* bridge */ /* synthetic */ Object a() {
        return o5.y.a(f());
    }

    @Override // o7.AbstractC2520n0
    public void b(int i8) {
        if (o5.y.I(this.f22099a) < i8) {
            byte[] bArr = this.f22099a;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, H5.i.b(i8, o5.y.I(bArr) * 2));
            AbstractC2304t.e(bArrCopyOf, "copyOf(...)");
            this.f22099a = o5.y.e(bArrCopyOf);
        }
    }

    @Override // o7.AbstractC2520n0
    public int d() {
        return this.f22100b;
    }

    public final void e(byte b8) {
        AbstractC2520n0.c(this, 0, 1, null);
        byte[] bArr = this.f22099a;
        int iD = d();
        this.f22100b = iD + 1;
        o5.y.M(bArr, iD, b8);
    }

    public byte[] f() {
        byte[] bArrCopyOf = Arrays.copyOf(this.f22099a, d());
        AbstractC2304t.e(bArrCopyOf, "copyOf(...)");
        return o5.y.e(bArrCopyOf);
    }

    public /* synthetic */ C0(byte[] bArr, AbstractC2296k abstractC2296k) {
        this(bArr);
    }
}
