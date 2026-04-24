package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f11145a;

    static {
        char[] cArr = new char[80];
        f11145a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static void a(int i8, StringBuilder sb) {
        while (i8 > 0) {
            char[] cArr = f11145a;
            int length = i8 > cArr.length ? cArr.length : i8;
            sb.append(cArr, 0, length);
            i8 -= length;
        }
    }

    public static boolean b(Object obj) {
        Object obj2;
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0;
        }
        if (obj instanceof Float) {
            return Float.floatToRawIntBits(((Float) obj).floatValue()) == 0;
        }
        if (obj instanceof Double) {
            return Double.doubleToRawLongBits(((Double) obj).doubleValue()) == 0;
        }
        if (obj instanceof String) {
            obj2 = "";
        } else {
            if (!(obj instanceof AbstractC1104f)) {
                return obj instanceof J ? obj == ((J) obj).b() : (obj instanceof Enum) && ((Enum) obj).ordinal() == 0;
            }
            obj2 = AbstractC1104f.f11214b;
        }
        return obj.equals(obj2);
    }

    public static String c(String str) {
        if (str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(str.charAt(0)));
        for (int i8 = 1; i8 < str.length(); i8++) {
            char cCharAt = str.charAt(i8);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    public static void d(StringBuilder sb, int i8, String str, Object obj) {
        String strA;
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                d(sb, i8, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                d(sb, i8, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        a(i8, sb);
        sb.append(c(str));
        if (obj instanceof String) {
            sb.append(": \"");
            strA = d0.c((String) obj);
        } else {
            if (!(obj instanceof AbstractC1104f)) {
                if (obj instanceof AbstractC1117t) {
                    sb.append(" {");
                    e((AbstractC1117t) obj, sb, i8 + 2);
                } else if (!(obj instanceof Map.Entry)) {
                    sb.append(": ");
                    sb.append(obj);
                    return;
                } else {
                    sb.append(" {");
                    Map.Entry entry = (Map.Entry) obj;
                    int i9 = i8 + 2;
                    d(sb, i9, "key", entry.getKey());
                    d(sb, i9, "value", entry.getValue());
                }
                sb.append("\n");
                a(i8, sb);
                sb.append("}");
                return;
            }
            sb.append(": \"");
            strA = d0.a((AbstractC1104f) obj);
        }
        sb.append(strA);
        sb.append('\"');
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0172  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void e(androidx.datastore.preferences.protobuf.J r16, java.lang.StringBuilder r17, int r18) {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.protobuf.L.e(androidx.datastore.preferences.protobuf.J, java.lang.StringBuilder, int):void");
    }

    public static String f(J j8, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        e(j8, sb, 0);
        return sb.toString();
    }
}
