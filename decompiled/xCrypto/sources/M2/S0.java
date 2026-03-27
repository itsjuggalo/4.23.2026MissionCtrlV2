package M2;

import b2.AbstractC0862a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public abstract class S0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Logger f1998a = Logger.getLogger(S0.class.getName());

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f1999b = "-bin".getBytes(Z1.c.f5966a);

    public static boolean a(byte[] bArr, byte[] bArr2) {
        int length = bArr.length - bArr2.length;
        if (length < 0) {
            return false;
        }
        for (int i4 = length; i4 < bArr.length; i4++) {
            if (bArr[i4] != bArr2[i4 - length]) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(byte[] bArr) {
        for (byte b4 : bArr) {
            if (b4 < 32 || b4 > 126) {
                return false;
            }
        }
        return true;
    }

    public static byte[][] c(byte[][] bArr, int i4) {
        ArrayList arrayList = new ArrayList(bArr.length + 10);
        for (int i5 = 0; i5 < i4; i5++) {
            arrayList.add(bArr[i5]);
        }
        while (i4 < bArr.length) {
            byte[] bArr2 = bArr[i4];
            byte[] bArr3 = bArr[i4 + 1];
            if (a(bArr2, f1999b)) {
                int i6 = 0;
                for (int i7 = 0; i7 <= bArr3.length; i7++) {
                    if (i7 == bArr3.length || bArr3[i7] == 44) {
                        byte[] bArrB = AbstractC0862a.a().b(new String(bArr3, i6, i7 - i6, Z1.c.f5966a));
                        arrayList.add(bArr2);
                        arrayList.add(bArrB);
                        i6 = i7 + 1;
                    }
                }
            } else {
                arrayList.add(bArr2);
                arrayList.add(bArr3);
            }
            i4 += 2;
        }
        return (byte[][]) arrayList.toArray(new byte[0][]);
    }

    public static byte[][] d(K2.Z z4) {
        byte[][] bArrD = K2.M.d(z4);
        if (bArrD == null) {
            return new byte[0][];
        }
        int i4 = 0;
        for (int i5 = 0; i5 < bArrD.length; i5 += 2) {
            byte[] bArr = bArrD[i5];
            byte[] bArr2 = bArrD[i5 + 1];
            if (a(bArr, f1999b)) {
                bArrD[i4] = bArr;
                bArrD[i4 + 1] = K2.M.f1055b.e(bArr2).getBytes(Z1.c.f5966a);
            } else if (b(bArr2)) {
                bArrD[i4] = bArr;
                bArrD[i4 + 1] = bArr2;
            } else {
                String str = new String(bArr, Z1.c.f5966a);
                f1998a.warning("Metadata key=" + str + ", value=" + Arrays.toString(bArr2) + " contains invalid ASCII characters");
            }
            i4 += 2;
        }
        return i4 == bArrD.length ? bArrD : (byte[][]) Arrays.copyOfRange(bArrD, 0, i4);
    }

    public static byte[][] e(byte[][] bArr) {
        for (int i4 = 0; i4 < bArr.length; i4 += 2) {
            byte[] bArr2 = bArr[i4];
            int i5 = i4 + 1;
            byte[] bArr3 = bArr[i5];
            if (a(bArr2, f1999b)) {
                for (byte b4 : bArr3) {
                    if (b4 == 44) {
                        return c(bArr, i4);
                    }
                }
                bArr[i5] = AbstractC0862a.a().b(new String(bArr3, Z1.c.f5966a));
            }
        }
        return bArr;
    }
}
