package x4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;
import w4.d2;
import z4.C1473b;

/* JADX INFO: loaded from: classes.dex */
public abstract class v {
    static {
        Logger.getLogger(v.class.getName());
    }

    public static byte[][] a(ArrayList arrayList) {
        int size = arrayList.size() * 2;
        byte[][] bArr = new byte[size][];
        Iterator it = arrayList.iterator();
        int i = 0;
        while (it.hasNext()) {
            C1473b c1473b = (C1473b) it.next();
            int i6 = i + 1;
            bArr[i] = c1473b.f11786a.r();
            i += 2;
            bArr[i6] = c1473b.f11787b.r();
        }
        Logger logger = d2.f11241a;
        int i7 = 0;
        while (i7 < size) {
            byte[] bArr2 = bArr[i7];
            int i8 = i7 + 1;
            byte[] bArr3 = bArr[i8];
            byte[] bArr4 = d2.f11242b;
            if (d2.a(bArr2, bArr4)) {
                for (byte b3 : bArr3) {
                    if (b3 == 44) {
                        ArrayList arrayList2 = new ArrayList(size + 10);
                        for (int i9 = 0; i9 < i7; i9++) {
                            arrayList2.add(bArr[i9]);
                        }
                        while (i7 < size) {
                            byte[] bArr5 = bArr[i7];
                            byte[] bArr6 = bArr[i7 + 1];
                            if (d2.a(bArr5, bArr4)) {
                                int i10 = 0;
                                for (int i11 = 0; i11 <= bArr6.length; i11++) {
                                    if (i11 == bArr6.length || bArr6[i11] == 44) {
                                        byte[] bArrA = W1.e.f3348c.a(new String(bArr6, i10, i11 - i10, U1.d.f3106a));
                                        arrayList2.add(bArr5);
                                        arrayList2.add(bArrA);
                                        i10 = i11 + 1;
                                    }
                                }
                            } else {
                                arrayList2.add(bArr5);
                                arrayList2.add(bArr6);
                            }
                            i7 += 2;
                        }
                        return (byte[][]) arrayList2.toArray(new byte[0][]);
                    }
                }
                bArr[i8] = W1.e.f3348c.a(new String(bArr3, U1.d.f3106a));
            }
            i7 += 2;
        }
        return bArr;
    }
}
