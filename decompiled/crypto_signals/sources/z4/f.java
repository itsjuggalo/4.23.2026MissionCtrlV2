package z4;

import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public abstract class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f11804a = {"DATA", "HEADERS", "PRIORITY", "RST_STREAM", "SETTINGS", "PUSH_PROMISE", "PING", "GOAWAY", "WINDOW_UPDATE", "CONTINUATION"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String[] f11805b = new String[64];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f11806c = new String[256];

    static {
        int i = 0;
        int i6 = 0;
        while (true) {
            String[] strArr = f11806c;
            if (i6 >= strArr.length) {
                break;
            }
            strArr[i6] = String.format("%8s", Integer.toBinaryString(i6)).replace(' ', '0');
            i6++;
        }
        String[] strArr2 = f11805b;
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
            String[] strArr3 = f11805b;
            int i11 = i10 | i9;
            strArr3[i11] = strArr3[i10] + '|' + strArr3[i9];
            StringBuilder sb = new StringBuilder();
            sb.append(strArr3[i10]);
            sb.append('|');
            strArr3[i11 | 8] = AbstractC1024h.d(sb, strArr3[i9], "|PADDED");
        }
        while (true) {
            String[] strArr4 = f11805b;
            if (i >= strArr4.length) {
                return;
            }
            if (strArr4[i] == null) {
                strArr4[i] = f11806c[i];
            }
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(boolean r3, int r4, int r5, byte r6, byte r7) {
        /*
            r0 = 10
            if (r6 >= r0) goto L9
            java.lang.String[] r0 = z4.f.f11804a
            r0 = r0[r6]
            goto L17
        L9:
            java.lang.Byte r0 = java.lang.Byte.valueOf(r6)
            java.lang.Object[] r0 = new java.lang.Object[]{r0}
            java.lang.String r1 = "0x%02x"
            java.lang.String r0 = java.lang.String.format(r1, r0)
        L17:
            if (r7 != 0) goto L1c
            java.lang.String r6 = ""
            goto L68
        L1c:
            java.lang.String[] r1 = z4.f.f11806c
            r2 = 2
            if (r6 == r2) goto L66
            r2 = 3
            if (r6 == r2) goto L66
            r2 = 4
            if (r6 == r2) goto L5d
            r2 = 6
            if (r6 == r2) goto L5d
            r2 = 7
            if (r6 == r2) goto L66
            r2 = 8
            if (r6 == r2) goto L66
            r2 = 64
            if (r7 >= r2) goto L3a
            java.lang.String[] r1 = z4.f.f11805b
            r1 = r1[r7]
            goto L3c
        L3a:
            r1 = r1[r7]
        L3c:
            r2 = 5
            if (r6 != r2) goto L4c
            r2 = r7 & 4
            if (r2 == 0) goto L4c
            java.lang.String r6 = "HEADERS"
            java.lang.String r7 = "PUSH_PROMISE"
            java.lang.String r6 = r1.replace(r6, r7)
            goto L68
        L4c:
            if (r6 != 0) goto L5b
            r6 = r7 & 32
            if (r6 == 0) goto L5b
            java.lang.String r6 = "PRIORITY"
            java.lang.String r7 = "COMPRESSED"
            java.lang.String r6 = r1.replace(r6, r7)
            goto L68
        L5b:
            r6 = r1
            goto L68
        L5d:
            r6 = 1
            if (r7 != r6) goto L63
            java.lang.String r6 = "ACK"
            goto L68
        L63:
            r6 = r1[r7]
            goto L68
        L66:
            r6 = r1[r7]
        L68:
            java.util.Locale r7 = java.util.Locale.US
            if (r3 == 0) goto L6f
            java.lang.String r3 = "<<"
            goto L71
        L6f:
            java.lang.String r3 = ">>"
        L71:
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.Object[] r3 = new java.lang.Object[]{r3, r4, r5, r0, r6}
            java.lang.String r4 = "%s 0x%08x %5d %-13s %s"
            java.lang.String r3 = java.lang.String.format(r7, r4, r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.f.a(boolean, int, int, byte, byte):java.lang.String");
    }
}
