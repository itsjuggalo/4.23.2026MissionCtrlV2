package okhttp3.internal.ws;

import w6.C2792e;

/* JADX INFO: loaded from: classes2.dex */
public final class WebSocketProtocol {
    private WebSocketProtocol() {
        throw new AssertionError("No instances.");
    }

    public static String a(int i7) {
        if (i7 < 1000 || i7 >= 5000) {
            return "Code must be in range [1000,5000): " + i7;
        }
        if ((i7 < 1004 || i7 > 1006) && (i7 < 1012 || i7 > 2999)) {
            return null;
        }
        return "Code " + i7 + " is reserved and may not be used.";
    }

    public static void b(C2792e.a aVar, byte[] bArr) {
        int length = bArr.length;
        int i7 = 0;
        do {
            byte[] bArr2 = aVar.f25101e;
            int i8 = aVar.f25102f;
            int i9 = aVar.f25103g;
            while (i8 < i9) {
                int i10 = i7 % length;
                bArr2[i8] = (byte) (bArr2[i8] ^ bArr[i10]);
                i8++;
                i7 = i10 + 1;
            }
        } while (aVar.i() != -1);
    }

    public static void c(int i7) {
        String strA = a(i7);
        if (strA != null) {
            throw new IllegalArgumentException(strA);
        }
    }
}
