package t5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes2.dex */
public abstract class S0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f23549a = Logger.getLogger(S0.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f23550b = "-bin".getBytes(H2.c.f2591a);

    public static boolean a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        for (int i7 = length; i7 < bArr.length; i7++) {
            if (bArr[i7] != bArr2[i7 - length]) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(byte[] bArr) {
        for (byte b7 : bArr) {
            if (b7 < 32 || b7 > 126) {
                return false;
            }
        }
        return true;
    }

    public static byte[][] c(byte[][] bArr, int i7) {
        ArrayList arrayList = new ArrayList(bArr.length + 10);
        for (int i8 = 0; i8 < i7; i8++) {
            arrayList.add(bArr[i8]);
        }
        while (i7 < bArr.length) {
            byte[] bArr2 = bArr[i7];
            byte[] bArr3 = bArr[i7 + 1];
            if (a(bArr2, f23550b)) {
                int i9 = 0;
                for (int i10 = 0; i10 <= bArr3.length; i10++) {
                    if (i10 == bArr3.length || bArr3[i10] == 44) {
                        byte[] bArrB = J2.a.a().b(new String(bArr3, i9, i10 - i9, H2.c.f2591a));
                        arrayList.add(bArr2);
                        arrayList.add(bArrB);
                        i9 = i10 + 1;
                    }
                }
            } else {
                arrayList.add(bArr2);
                arrayList.add(bArr3);
            }
            i7 += 2;
        }
        return (byte[][]) arrayList.toArray(new byte[0][]);
    }

    public static byte[][] d(r5.Z z7) {
        byte[][] bArrD = r5.M.d(z7);
        if (bArrD == null) {
            return new byte[0][];
        }
        int i7 = 0;
        for (int i8 = 0; i8 < bArrD.length; i8 += 2) {
            byte[] bArr = bArrD[i8];
            byte[] bArr2 = bArrD[i8 + 1];
            if (a(bArr, f23550b)) {
                bArrD[i7] = bArr;
                bArrD[i7 + 1] = r5.M.f22545b.e(bArr2).getBytes(H2.c.f2591a);
            } else if (b(bArr2)) {
                bArrD[i7] = bArr;
                bArrD[i7 + 1] = bArr2;
            } else {
                String str = new String(bArr, H2.c.f2591a);
                f23549a.warning("Metadata key=" + str + ", value=" + Arrays.toString(bArr2) + " contains invalid ASCII characters");
            }
            i7 += 2;
        }
        return i7 == bArrD.length ? bArrD : (byte[][]) Arrays.copyOfRange(bArrD, 0, i7);
    }

    public static byte[][] e(byte[][] bArr) {
        for (int i7 = 0; i7 < bArr.length; i7 += 2) {
            byte[] bArr2 = bArr[i7];
            int i8 = i7 + 1;
            byte[] bArr3 = bArr[i8];
            if (a(bArr2, f23550b)) {
                for (byte b7 : bArr3) {
                    if (b7 == 44) {
                        return c(bArr, i7);
                    }
                }
                bArr[i8] = J2.a.a().b(new String(bArr3, H2.c.f2591a));
            }
        }
        return bArr;
    }
}
