package tb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class r2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f21693a = Logger.getLogger(r2.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f21694b = "-bin".getBytes(p6.d.f18311a);

    public static boolean a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        for (int i10 = length; i10 < bArr.length; i10++) {
            if (bArr[i10] != bArr2[i10 - length]) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(byte[] bArr) {
        for (byte b10 : bArr) {
            if (b10 < 32 || b10 > 126) {
                return false;
            }
        }
        return true;
    }

    public static byte[][] c(byte[][] bArr, int i10) {
        ArrayList arrayList = new ArrayList(bArr.length + 10);
        for (int i11 = 0; i11 < i10; i11++) {
            arrayList.add(bArr[i11]);
        }
        while (i10 < bArr.length) {
            byte[] bArr2 = bArr[i10];
            byte[] bArr3 = bArr[i10 + 1];
            if (a(bArr2, f21694b)) {
                int i12 = 0;
                for (int i13 = 0; i13 <= bArr3.length; i13++) {
                    if (i13 == bArr3.length || bArr3[i13] == 44) {
                        byte[] bArrC = r6.a.b().c(new String(bArr3, i12, i13 - i12, p6.d.f18311a));
                        arrayList.add(bArr2);
                        arrayList.add(bArrC);
                        i12 = i13 + 1;
                    }
                }
            } else {
                arrayList.add(bArr2);
                arrayList.add(bArr3);
            }
            i10 += 2;
        }
        return (byte[][]) arrayList.toArray(new byte[0][]);
    }

    public static byte[][] d(rb.y0 y0Var) {
        byte[][] bArrD = rb.m0.d(y0Var);
        if (bArrD == null) {
            return new byte[0][];
        }
        int i10 = 0;
        for (int i11 = 0; i11 < bArrD.length; i11 += 2) {
            byte[] bArr = bArrD[i11];
            byte[] bArr2 = bArrD[i11 + 1];
            if (a(bArr, f21694b)) {
                bArrD[i10] = bArr;
                bArrD[i10 + 1] = rb.m0.f19650b.f(bArr2).getBytes(p6.d.f18311a);
            } else if (b(bArr2)) {
                bArrD[i10] = bArr;
                bArrD[i10 + 1] = bArr2;
            } else {
                String str = new String(bArr, p6.d.f18311a);
                f21693a.warning("Metadata key=" + str + ", value=" + Arrays.toString(bArr2) + " contains invalid ASCII characters");
            }
            i10 += 2;
        }
        return i10 == bArrD.length ? bArrD : (byte[][]) Arrays.copyOfRange(bArrD, 0, i10);
    }

    public static byte[][] e(byte[][] bArr) {
        for (int i10 = 0; i10 < bArr.length; i10 += 2) {
            byte[] bArr2 = bArr[i10];
            int i11 = i10 + 1;
            byte[] bArr3 = bArr[i11];
            if (a(bArr2, f21694b)) {
                for (byte b10 : bArr3) {
                    if (b10 == 44) {
                        return c(bArr, i10);
                    }
                }
                bArr[i11] = r6.a.b().c(new String(bArr3, p6.d.f18311a));
            }
        }
        return bArr;
    }
}
