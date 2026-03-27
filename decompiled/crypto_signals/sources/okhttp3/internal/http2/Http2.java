package okhttp3.internal.http2;

import java.io.IOException;
import java.util.Locale;
import okhttp3.internal.Util;
import s3.AbstractC1024h;
import u5.AbstractC1245b;
import u5.j;

/* JADX INFO: loaded from: classes.dex */
public final class Http2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f8870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f8871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f8872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f8873d;

    static {
        j jVar = j.f10527d;
        f8870a = AbstractC1245b.e("PRI * HTTP/2.0\r\n\r\nSM\r\n\r\n");
        f8871b = new String[]{"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};
        f8872c = new String[64];
        f8873d = new String[256];
        int i = 0;
        int i6 = 0;
        while (true) {
            String[] strArr = f8873d;
            if (i6 >= strArr.length) {
                break;
            }
            Object[] objArr = {Integer.toBinaryString(i6)};
            byte[] bArr = Util.f8827a;
            strArr[i6] = String.format(Locale.US, "%8s", objArr).replace(' ', '0');
            i6++;
        }
        String[] strArr2 = f8872c;
        strArr2[0] = "";
        strArr2[1] = "END_STREAM";
        int[] iArr = {1};
        strArr2[8] = "PADDED";
        int i7 = iArr[0];
        strArr2[i7 | 8] = AbstractC1024h.d(new StringBuilder(), strArr2[i7], "|PADDED");
        strArr2[4] = "END_HEADERS";
        strArr2[32] = "PRIORITY";
        strArr2[36] = "END_HEADERS|PRIORITY";
        int[] iArr2 = {4, 32, 36};
        for (int i8 = 0; i8 < 3; i8++) {
            int i9 = iArr2[i8];
            int i10 = iArr[0];
            String[] strArr3 = f8872c;
            int i11 = i10 | i9;
            strArr3[i11] = strArr3[i10] + '|' + strArr3[i9];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i10]);
            sb.append('|');
            strArr3[i11 | 8] = AbstractC1024h.d(sb, strArr3[i9], "|PADDED");
        }
        while (true) {
            String[] strArr4 = f8872c;
            if (i >= strArr4.length) {
                return;
            }
            if (strArr4[i] == null) {
                strArr4[i] = f8873d[i];
            }
            i++;
        }
    }

    private Http2() {
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(boolean r5, int r6, int r7, byte r8, byte r9) {
        /*
            r0 = 4
            java.lang.String[] r1 = okhttp3.internal.http2.Http2.f8871b
            int r2 = r1.length
            if (r8 >= r2) goto L9
            r1 = r1[r8]
            goto L1b
        L9:
            java.lang.Byte r1 = java.lang.Byte.valueOf(r8)
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            byte[] r2 = okhttp3.internal.Util.f8827a
            java.util.Locale r2 = java.util.Locale.US
            java.lang.String r3 = "0x%02x"
            java.lang.String r1 = java.lang.String.format(r2, r3, r1)
        L1b:
            if (r9 != 0) goto L20
            java.lang.String r8 = ""
            goto L69
        L20:
            r2 = 2
            java.lang.String[] r3 = okhttp3.internal.http2.Http2.f8873d
            if (r8 == r2) goto L67
            r2 = 3
            if (r8 == r2) goto L67
            if (r8 == r0) goto L5e
            r2 = 6
            if (r8 == r2) goto L5e
            r2 = 7
            if (r8 == r2) goto L67
            r2 = 8
            if (r8 == r2) goto L67
            java.lang.String[] r2 = okhttp3.internal.http2.Http2.f8872c
            int r4 = r2.length
            if (r9 >= r4) goto L3c
            r2 = r2[r9]
            goto L3e
        L3c:
            r2 = r3[r9]
        L3e:
            r3 = 5
            if (r8 != r3) goto L4d
            r0 = r0 & r9
            if (r0 == 0) goto L4d
            java.lang.String r8 = "HEADERS"
            java.lang.String r9 = "PUSH_PROMISE"
            java.lang.String r8 = r2.replace(r8, r9)
            goto L69
        L4d:
            if (r8 != 0) goto L5c
            r8 = r9 & 32
            if (r8 == 0) goto L5c
            java.lang.String r8 = "PRIORITY"
            java.lang.String r9 = "COMPRESSED"
            java.lang.String r8 = r2.replace(r8, r9)
            goto L69
        L5c:
            r8 = r2
            goto L69
        L5e:
            r8 = 1
            if (r9 != r8) goto L64
            java.lang.String r8 = "ACK"
            goto L69
        L64:
            r8 = r3[r9]
            goto L69
        L67:
            r8 = r3[r9]
        L69:
            if (r5 == 0) goto L6e
            java.lang.String r5 = "<<"
            goto L70
        L6e:
            java.lang.String r5 = ">>"
        L70:
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.Object[] r5 = new java.lang.Object[]{r5, r6, r7, r1, r8}
            byte[] r6 = okhttp3.internal.Util.f8827a
            java.util.Locale r6 = java.util.Locale.US
            java.lang.String r7 = "%s 0x%08x %5d %-13s %s"
            java.lang.String r5 = java.lang.String.format(r6, r7, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2.a(boolean, int, int, byte, byte):java.lang.String");
    }

    public static void b(String str, Object... objArr) {
        byte[] bArr = Util.f8827a;
        throw new IllegalArgumentException(String.format(Locale.US, str, objArr));
    }

    public static void c(String str, Object... objArr) throws IOException {
        byte[] bArr = Util.f8827a;
        throw new IOException(String.format(Locale.US, str, objArr));
    }
}
