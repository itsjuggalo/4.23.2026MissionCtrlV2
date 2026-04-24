package w4;

import java.io.OutputStream;
import java.util.ArrayList;

/* JADX INFO: renamed from: w4.c1, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C1324c1 extends OutputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f11219a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public x4.s f11220b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C1327d1 f11221c;

    public C1324c1(C1327d1 c1327d1) {
        this.f11221c = c1327d1;
    }

    @Override // java.io.OutputStream
    public final void write(int i) {
        x4.s sVar = this.f11220b;
        if (sVar == null || sVar.f11604b <= 0) {
            write(new byte[]{(byte) i}, 0, 1);
            return;
        }
        sVar.f11603a.B((byte) i);
        sVar.f11604b--;
        sVar.f11605c++;
    }

    @Override // java.io.OutputStream
    public final void write(byte[] bArr, int i, int i6) {
        x4.s sVar = this.f11220b;
        ArrayList arrayList = this.f11219a;
        C1327d1 c1327d1 = this.f11221c;
        if (sVar == null) {
            c1327d1.f11235k.getClass();
            x4.s sVarB = p0.p.b(i6);
            this.f11220b = sVarB;
            arrayList.add(sVarB);
        }
        while (i6 > 0) {
            int iMin = Math.min(i6, this.f11220b.f11604b);
            if (iMin == 0) {
                int iMax = Math.max(i6, this.f11220b.f11605c * 2);
                c1327d1.f11235k.getClass();
                x4.s sVarB2 = p0.p.b(iMax);
                this.f11220b = sVarB2;
                arrayList.add(sVarB2);
            } else {
                this.f11220b.a(bArr, i, iMin);
                i += iMin;
                i6 -= iMin;
            }
        }
    }
}
