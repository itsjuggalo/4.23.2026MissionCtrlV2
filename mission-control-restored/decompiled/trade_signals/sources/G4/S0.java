package G4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;
import v2.AbstractC2838d;
import x2.AbstractC2954a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class S0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f2586a = Logger.getLogger(S0.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f2587b = "-bin".getBytes(AbstractC2838d.f23751a);

    public static boolean a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        for (int i8 = length; i8 < bArr.length; i8++) {
            if (bArr[i8] != bArr2[i8 - length]) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(byte[] bArr) {
        for (byte b8 : bArr) {
            if (b8 < 32 || b8 > 126) {
                return false;
            }
        }
        return true;
    }

    public static byte[][] c(byte[][] bArr, int i8) {
        ArrayList arrayList = new ArrayList(bArr.length + 10);
        for (int i9 = 0; i9 < i8; i9++) {
            arrayList.add(bArr[i9]);
        }
        while (i8 < bArr.length) {
            byte[] bArr2 = bArr[i8];
            byte[] bArr3 = bArr[i8 + 1];
            if (a(bArr2, f2587b)) {
                int i10 = 0;
                for (int i11 = 0; i11 <= bArr3.length; i11++) {
                    if (i11 == bArr3.length || bArr3[i11] == 44) {
                        byte[] bArrC = AbstractC2954a.b().c(new String(bArr3, i10, i11 - i10, AbstractC2838d.f23751a));
                        arrayList.add(bArr2);
                        arrayList.add(bArrC);
                        i10 = i11 + 1;
                    }
                }
            } else {
                arrayList.add(bArr2);
                arrayList.add(bArr3);
            }
            i8 += 2;
        }
        return (byte[][]) arrayList.toArray(new byte[0][]);
    }

    public static byte[][] d(F4.X x8) {
        byte[][] bArrD = F4.K.d(x8);
        if (bArrD == null) {
            return new byte[0][];
        }
        int i8 = 0;
        for (int i9 = 0; i9 < bArrD.length; i9 += 2) {
            byte[] bArr = bArrD[i9];
            byte[] bArr2 = bArrD[i9 + 1];
            if (a(bArr, f2587b)) {
                bArrD[i8] = bArr;
                bArrD[i8 + 1] = F4.K.f1644b.f(bArr2).getBytes(AbstractC2838d.f23751a);
            } else if (b(bArr2)) {
                bArrD[i8] = bArr;
                bArrD[i8 + 1] = bArr2;
            } else {
                String str = new String(bArr, AbstractC2838d.f23751a);
                f2586a.warning("Metadata key=" + str + ", value=" + Arrays.toString(bArr2) + " contains invalid ASCII characters");
            }
            i8 += 2;
        }
        return i8 == bArrD.length ? bArrD : (byte[][]) Arrays.copyOfRange(bArrD, 0, i8);
    }

    public static byte[][] e(byte[][] bArr) {
        for (int i8 = 0; i8 < bArr.length; i8 += 2) {
            byte[] bArr2 = bArr[i8];
            int i9 = i8 + 1;
            byte[] bArr3 = bArr[i9];
            if (a(bArr2, f2587b)) {
                for (byte b8 : bArr3) {
                    if (b8 == 44) {
                        return c(bArr, i8);
                    }
                }
                bArr[i9] = AbstractC2954a.b().c(new String(bArr3, AbstractC2838d.f23751a));
            }
        }
        return bArr;
    }
}
