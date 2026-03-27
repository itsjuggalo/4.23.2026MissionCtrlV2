package f3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: f3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1748e {
    public static void a(boolean z7) {
        b(z7, "", new Object[0]);
    }

    public static void b(boolean z7, String str, Object... objArr) {
        if (z7) {
            return;
        }
        throw new AssertionError("hardAssert failed: " + String.format(str, objArr));
    }

    public static Long c(Object obj) {
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Long) {
            return (Long) obj;
        }
        return null;
    }

    public static String d(List list) {
        if (list.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        boolean z7 = true;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (!z7) {
                sb.append("/");
            }
            sb.append(str);
            z7 = false;
        }
        return sb.toString();
    }

    public static List e(String str) {
        ArrayList arrayList = new ArrayList();
        String[] strArrSplit = str.split("/", -1);
        for (int i8 = 0; i8 < strArrSplit.length; i8++) {
            if (!strArrSplit[i8].isEmpty()) {
                arrayList.add(strArrSplit[i8]);
            }
        }
        return arrayList;
    }
}
