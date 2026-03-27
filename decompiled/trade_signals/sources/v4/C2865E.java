package v4;

import android.database.sqlite.SQLiteProgram;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: v4.E, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2865E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f23820a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f23821b;

    public C2865E(String str, List list) {
        this.f23820a = str;
        this.f23821b = list == null ? new ArrayList() : list;
    }

    public static Object f(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof List)) {
            return obj;
        }
        List list = (List) obj;
        byte[] bArr = new byte[list.size()];
        for (int i8 = 0; i8 < list.size(); i8++) {
            bArr[i8] = (byte) ((Integer) list.get(i8)).intValue();
        }
        return bArr;
    }

    public void a(SQLiteProgram sQLiteProgram) {
        long jLongValue;
        List list = this.f23821b;
        if (list != null) {
            int size = list.size();
            int i8 = 0;
            while (i8 < size) {
                Object objF = f(this.f23821b.get(i8));
                int i9 = i8 + 1;
                if (objF == null) {
                    sQLiteProgram.bindNull(i9);
                } else if (objF instanceof byte[]) {
                    sQLiteProgram.bindBlob(i9, (byte[]) objF);
                } else if (objF instanceof Double) {
                    sQLiteProgram.bindDouble(i9, ((Double) objF).doubleValue());
                } else {
                    if (objF instanceof Integer) {
                        jLongValue = ((Integer) objF).intValue();
                    } else if (objF instanceof Long) {
                        jLongValue = ((Long) objF).longValue();
                    } else if (objF instanceof String) {
                        sQLiteProgram.bindString(i9, (String) objF);
                    } else {
                        if (!(objF instanceof Boolean)) {
                            throw new IllegalArgumentException("Could not bind " + objF + " from index " + i8 + ": Supported types are null, byte[], double, long, boolean and String");
                        }
                        jLongValue = ((Boolean) objF).booleanValue() ? 1L : 0L;
                    }
                    sQLiteProgram.bindLong(i9, jLongValue);
                }
                i8 = i9;
            }
        }
    }

    public List b() {
        return this.f23821b;
    }

    public String c() {
        return this.f23820a;
    }

    public Object[] d() {
        return e(this.f23821b);
    }

    public final Object[] e(List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(f(it.next()));
            }
        }
        return arrayList.toArray(new Object[0]);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2865E)) {
            return false;
        }
        C2865E c2865e = (C2865E) obj;
        String str = this.f23820a;
        if (str != null) {
            if (!str.equals(c2865e.f23820a)) {
                return false;
            }
        } else if (c2865e.f23820a != null) {
            return false;
        }
        if (this.f23821b.size() != c2865e.f23821b.size()) {
            return false;
        }
        for (int i8 = 0; i8 < this.f23821b.size(); i8++) {
            if ((this.f23821b.get(i8) instanceof byte[]) && (c2865e.f23821b.get(i8) instanceof byte[])) {
                if (!Arrays.equals((byte[]) this.f23821b.get(i8), (byte[]) c2865e.f23821b.get(i8))) {
                    return false;
                }
            } else if (!this.f23821b.get(i8).equals(c2865e.f23821b.get(i8))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        String str = this.f23820a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f23820a);
        List list = this.f23821b;
        if (list == null || list.isEmpty()) {
            str = "";
        } else {
            str = " " + this.f23821b;
        }
        sb.append(str);
        return sb.toString();
    }
}
