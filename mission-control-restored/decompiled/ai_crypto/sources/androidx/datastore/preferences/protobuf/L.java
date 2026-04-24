package androidx.datastore.preferences.protobuf;

import com.revenuecat.purchases.subscriberattributes.SubscriberAttributeKt;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class L {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char[] f7333a;

    static {
        char[] cArr = new char[80];
        f7333a = cArr;
        Arrays.fill(cArr, ' ');
    }

    public static void a(int i7, StringBuilder sb) {
        while (i7 > 0) {
            char[] cArr = f7333a;
            int length = i7 > cArr.length ? cArr.length : i7;
            sb.append(cArr, 0, length);
            i7 -= length;
        }
    }

    public static boolean b(Object obj) {
        return obj instanceof Boolean ? !((Boolean) obj).booleanValue() : obj instanceof Integer ? ((Integer) obj).intValue() == 0 : obj instanceof Float ? Float.floatToRawIntBits(((Float) obj).floatValue()) == 0 : obj instanceof Double ? Double.doubleToRawLongBits(((Double) obj).doubleValue()) == 0 : obj instanceof String ? obj.equals("") : obj instanceof AbstractC0935f ? obj.equals(AbstractC0935f.f7402b) : obj instanceof J ? obj == ((J) obj).a() : (obj instanceof Enum) && ((Enum) obj).ordinal() == 0;
    }

    public static String c(String str) {
        if (str.isEmpty()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toLowerCase(str.charAt(0)));
        for (int i7 = 1; i7 < str.length(); i7++) {
            char cCharAt = str.charAt(i7);
            if (Character.isUpperCase(cCharAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(cCharAt));
        }
        return sb.toString();
    }

    public static void d(StringBuilder sb, int i7, String str, Object obj) {
        if (obj instanceof List) {
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                d(sb, i7, str, it.next());
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                d(sb, i7, str, (Map.Entry) it2.next());
            }
            return;
        }
        sb.append('\n');
        a(i7, sb);
        sb.append(c(str));
        if (obj instanceof String) {
            sb.append(": \"");
            sb.append(d0.c((String) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC0935f) {
            sb.append(": \"");
            sb.append(d0.a((AbstractC0935f) obj));
            sb.append('\"');
            return;
        }
        if (obj instanceof AbstractC0948t) {
            sb.append(" {");
            e((AbstractC0948t) obj, sb, i7 + 2);
            sb.append("\n");
            a(i7, sb);
            sb.append("}");
            return;
        }
        if (!(obj instanceof Map.Entry)) {
            sb.append(": ");
            sb.append(obj);
            return;
        }
        sb.append(" {");
        Map.Entry entry = (Map.Entry) obj;
        int i8 = i7 + 2;
        d(sb, i8, SubscriberAttributeKt.JSON_NAME_KEY, entry.getKey());
        d(sb, i8, "value", entry.getValue());
        sb.append("\n");
        a(i7, sb);
        sb.append("}");
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

    public static String f(J j7, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        e(j7, sb, 0);
        return sb.toString();
    }
}
