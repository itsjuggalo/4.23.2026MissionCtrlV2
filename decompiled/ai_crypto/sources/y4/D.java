package y4;

import android.database.Cursor;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import z4.AbstractC2893a;

/* JADX INFO: loaded from: classes2.dex */
public abstract class D {
    public static List a(Cursor cursor, int i7) {
        String name;
        ArrayList arrayList = new ArrayList(i7);
        for (int i8 = 0; i8 < i7; i8++) {
            Object objB = b(cursor, i8);
            if (AbstractC2893a.f26061c) {
                if (objB == null) {
                    name = null;
                } else if (objB.getClass().isArray()) {
                    name = "array(" + objB.getClass().getComponentType().getName() + ")";
                } else {
                    name = objB.getClass().getName();
                }
                StringBuilder sb = new StringBuilder();
                sb.append("column ");
                sb.append(i8);
                sb.append(" ");
                sb.append(cursor.getType(i8));
                sb.append(": ");
                sb.append(objB);
                sb.append(name == null ? "" : " (" + name + ")");
                Log.d("Sqflite", sb.toString());
            }
            arrayList.add(objB);
        }
        return arrayList;
    }

    public static Object b(Cursor cursor, int i7) {
        int type = cursor.getType(i7);
        if (type == 1) {
            return Long.valueOf(cursor.getLong(i7));
        }
        if (type == 2) {
            return Double.valueOf(cursor.getDouble(i7));
        }
        if (type == 3) {
            return cursor.getString(i7);
        }
        if (type != 4) {
            return null;
        }
        return cursor.getBlob(i7);
    }

    public static Locale c(String str) {
        return Locale.forLanguageTag(str);
    }

    public static Locale d(String str) {
        return c(str);
    }
}
