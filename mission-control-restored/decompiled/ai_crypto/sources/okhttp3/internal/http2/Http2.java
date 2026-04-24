package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.Util;
import w6.C2795h;

/* JADX INFO: loaded from: classes2.dex */
public final class Http2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C2795h f20921a = C2795h.j("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f20922b = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f20923c = new String[64];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f20924d = new String[256];

    static {
        int i7 = 0;
        int i8 = 0;
        while (true) {
            String[] strArr = f20924d;
            if (i8 >= strArr.length) {
                break;
            }
            strArr[i8] = Util.q("%8s", Integer.toBinaryString(i8)).replace(' ', '0');
            i8++;
        }
        String[] strArr2 = f20923c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i9 = iArr[0];
        strArr2[i9 | 8] = strArr2[i9] + "|PADDED";
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i10 = 0; i10 < 3; i10++) {
            int i11 = iArr2[i10];
            int i12 = iArr[0];
            String[] strArr3 = f20923c;
            int i13 = i12 | i11;
            strArr3[i13] = strArr3[i12] + '|' + strArr3[i11];
            strArr3[i13 | 8] = strArr3[i12] + '|' + strArr3[i11] + "|PADDED";
        }
        while (true) {
            String[] strArr4 = f20923c;
            if (i7 >= strArr4.length) {
                return;
            }
            if (strArr4[i7] == null) {
                strArr4[i7] = f20924d[i7];
            }
            i7++;
        }
    }

    private Http2() {
    }

    public static String a(byte b7, byte b8) {
        if (b8 == 0) {
            return "";
        }
        if (b7 != 2 && b7 != 3) {
            if (b7 == 4 || b7 == 6) {
                return b8 == 1 ? "ACK" : f20924d[b8];
            }
            if (b7 != 7 && b7 != 8) {
                String[] strArr = f20923c;
                String str = b8 < strArr.length ? strArr[b8] : f20924d[b8];
                return (b7 != 5 || (b8 & 4) == 0) ? (b7 != 0 || (b8 & 32) == 0) ? str : str.replace("PRIORITY", "COMPRESSED") : str.replace("HEADERS", "PUSH_PROMISE");
            }
        }
        return f20924d[b8];
    }

    public static String b(boolean z7, int i7, int i8, byte b7, byte b8) {
        String[] strArr = f20922b;
        return Util.q("%s 0x%08x %5d %-13s %s", z7 ? "<<" : ">>", Integer.valueOf(i7), Integer.valueOf(i8), b7 < strArr.length ? strArr[b7] : Util.q("0x%02x", Byte.valueOf(b7)), a(b7, b8));
    }

    public static IllegalArgumentException c(String str, Object... objArr) {
        throw new IllegalArgumentException(Util.q(str, objArr));
    }

    public static IOException d(String str, Object... objArr) throws IOException {
        throw new IOException(Util.q(str, objArr));
    }
}
