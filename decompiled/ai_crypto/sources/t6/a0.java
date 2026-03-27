package t6;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f24302a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f24303b;

    static {
        String[] strArr = new String[93];
        for (int i7 = 0; i7 < 32; i7++) {
            strArr[i7] = "\\u" + e(i7 >> 12) + e(i7 >> 8) + e(i7 >> 4) + e(i7);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f24302a = strArr;
        byte[] bArr = new byte[93];
        for (int i8 = 0; i8 < 32; i8++) {
            bArr[i8] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        f24303b = bArr;
    }

    public static final byte[] a() {
        return f24303b;
    }

    public static final String[] b() {
        return f24302a;
    }

    public static final void c(StringBuilder sb, String value) {
        kotlin.jvm.internal.r.f(sb, "<this>");
        kotlin.jvm.internal.r.f(value, "value");
        sb.append('\"');
        int length = value.length();
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            char cCharAt = value.charAt(i8);
            String[] strArr = f24302a;
            if (cCharAt < strArr.length && strArr[cCharAt] != null) {
                sb.append((CharSequence) value, i7, i8);
                sb.append(strArr[cCharAt]);
                i7 = i8 + 1;
            }
        }
        if (i7 != 0) {
            sb.append((CharSequence) value, i7, value.length());
        } else {
            sb.append(value);
        }
        sb.append('\"');
    }

    public static final Boolean d(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        if (Z5.t.r(str, com.amazon.a.a.o.b.af, true)) {
            return Boolean.TRUE;
        }
        if (Z5.t.r(str, com.amazon.a.a.o.b.ag, true)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static final char e(int i7) {
        int i8 = i7 & 15;
        return (char) (i8 < 10 ? i8 + 48 : i8 + 87);
    }
}
