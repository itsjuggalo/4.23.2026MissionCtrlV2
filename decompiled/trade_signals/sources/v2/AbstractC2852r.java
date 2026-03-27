package v2;

import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: v2.r, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2852r {
    public static String a(String str) {
        return AbstractC2847m.a(str);
    }

    public static boolean b(String str) {
        return AbstractC2847m.d(str);
    }

    public static String c(String str, Object... objArr) {
        int iIndexOf;
        String strValueOf = String.valueOf(str);
        int i8 = 0;
        if (objArr == null) {
            objArr = new Object[]{"(Object[])null"};
        } else {
            for (int i9 = 0; i9 < objArr.length; i9++) {
                objArr[i9] = d(objArr[i9]);
            }
        }
        StringBuilder sb = new StringBuilder(strValueOf.length() + (objArr.length * 16));
        int i10 = 0;
        while (i8 < objArr.length && (iIndexOf = strValueOf.indexOf("%s", i10)) != -1) {
            sb.append((CharSequence) strValueOf, i10, iIndexOf);
            sb.append(objArr[i8]);
            i10 = iIndexOf + 2;
            i8++;
        }
        sb.append((CharSequence) strValueOf, i10, strValueOf.length());
        if (i8 < objArr.length) {
            sb.append(" [");
            sb.append(objArr[i8]);
            for (int i11 = i8 + 1; i11 < objArr.length; i11++) {
                sb.append(", ");
                sb.append(objArr[i11]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static String d(Object obj) {
        if (obj == null) {
            return "null";
        }
        try {
            return obj.toString();
        } catch (Exception e8) {
            String str = obj.getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(obj));
            Logger.getLogger("com.google.common.base.Strings").log(Level.WARNING, "Exception during lenientFormat for " + str, (Throwable) e8);
            return "<" + str + " threw " + e8.getClass().getName() + ">";
        }
    }
}
