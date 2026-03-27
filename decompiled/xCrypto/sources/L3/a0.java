package L3;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f1509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final byte[] f1510b;

    static {
        String[] strArr = new String[93];
        for (int i4 = 0; i4 < 32; i4++) {
            strArr[i4] = "\\u" + e(i4 >> 12) + e(i4 >> 8) + e(i4 >> 4) + e(i4);
        }
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        f1509a = strArr;
        byte[] bArr = new byte[93];
        for (int i5 = 0; i5 < 32; i5++) {
            bArr[i5] = 1;
        }
        bArr[34] = 34;
        bArr[92] = 92;
        bArr[9] = 116;
        bArr[8] = 98;
        bArr[10] = 110;
        bArr[13] = 114;
        bArr[12] = 102;
        f1510b = bArr;
    }

    public static final byte[] a() {
        return f1510b;
    }

    public static final String[] b() {
        return f1509a;
    }

    public static final void c(StringBuilder sb, String value) {
        kotlin.jvm.internal.r.f(sb, "<this>");
        kotlin.jvm.internal.r.f(value, "value");
        sb.append('\"');
        int length = value.length();
        int i4 = 0;
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = value.charAt(i5);
            String[] strArr = f1509a;
            if (cCharAt < strArr.length && strArr[cCharAt] != null) {
                sb.append((CharSequence) value, i4, i5);
                sb.append(strArr[cCharAt]);
                i4 = i5 + 1;
            }
        }
        if (i4 != 0) {
            sb.append((CharSequence) value, i4, value.length());
        } else {
            sb.append(value);
        }
        sb.append('\"');
    }

    public static final Boolean d(String str) {
        kotlin.jvm.internal.r.f(str, "<this>");
        if (r3.x.v(str, com.amazon.a.a.o.b.af, true)) {
            return Boolean.TRUE;
        }
        if (r3.x.v(str, com.amazon.a.a.o.b.ag, true)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static final char e(int i4) {
        int i5 = i4 & 15;
        return (char) (i5 < 10 ? i5 + 48 : i5 + 87);
    }
}
