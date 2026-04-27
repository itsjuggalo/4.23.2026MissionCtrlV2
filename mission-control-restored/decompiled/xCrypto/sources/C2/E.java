package C2;

import android.database.Cursor;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public abstract class E {
    public static List a(Cursor cursor, int i4) {
        ArrayList arrayList = new ArrayList(i4);
        for (int i5 = 0; i5 < i4; i5++) {
            Object objB = b(cursor, i5);
            if (D2.a.f324c) {
                String strC = c(objB);
                StringBuilder sb = new StringBuilder();
                sb.append("column ");
                sb.append(i5);
                sb.append(" ");
                sb.append(cursor.getType(i5));
                sb.append(": ");
                sb.append(objB);
                sb.append(strC == null ? "" : " (" + strC + ")");
                Log.d("Sqflite", sb.toString());
            }
            arrayList.add(objB);
        }
        return arrayList;
    }

    public static Object b(Cursor cursor, int i4) {
        int type = cursor.getType(i4);
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i4));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i4));
        }
        if (type == 3) {
            return cursor.getString(i4);
        }
        if (type != 4) {
            return null;
        }
        return cursor.getBlob(i4);
    }

    public static String c(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!obj.getClass().isArray()) {
            return obj.getClass().getName();
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("array(");
            Class<?> componentType = obj.getClass().getComponentType();
            Objects.requireNonNull(componentType);
            sb.append(componentType.getName());
            sb.append(")");
            return sb.toString();
        } catch (Exception unused) {
            return "array";
        }
    }

    public static long d(Thread thread) {
        return Build.VERSION.SDK_INT >= 36 ? thread.threadId() : thread.getId();
    }

    public static Locale e(String str) {
        return f(str);
    }

    public static Locale f(String str) {
        return Locale.forLanguageTag(str);
    }
}
