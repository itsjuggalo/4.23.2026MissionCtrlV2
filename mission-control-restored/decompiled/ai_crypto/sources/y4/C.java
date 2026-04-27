package y4;

import android.database.sqlite.SQLiteProgram;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f25693a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f25694b;

    public C(String str, List list) {
        this.f25693a = str;
        this.f25694b = list == null ? new ArrayList() : list;
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
        for (int i7 = 0; i7 < list.size(); i7++) {
            bArr[i7] = (byte) ((Integer) list.get(i7)).intValue();
        }
        return bArr;
    }

    public void a(SQLiteProgram sQLiteProgram) {
        List list = this.f25694b;
        if (list != null) {
            int size = list.size();
            int i7 = 0;
            while (i7 < size) {
                Object objF = f(this.f25694b.get(i7));
                int i8 = i7 + 1;
                if (objF == null) {
                    sQLiteProgram.bindNull(i8);
                } else if (objF instanceof byte[]) {
                    sQLiteProgram.bindBlob(i8, (byte[]) objF);
                } else if (objF instanceof Double) {
                    sQLiteProgram.bindDouble(i8, ((Double) objF).doubleValue());
                } else if (objF instanceof Integer) {
                    sQLiteProgram.bindLong(i8, ((Integer) objF).intValue());
                } else if (objF instanceof Long) {
                    sQLiteProgram.bindLong(i8, ((Long) objF).longValue());
                } else if (objF instanceof String) {
                    sQLiteProgram.bindString(i8, (String) objF);
                } else {
                    if (!(objF instanceof Boolean)) {
                        throw new IllegalArgumentException("Could not bind " + objF + " from index " + i7 + ": Supported types are null, byte[], double, long, boolean and String");
                    }
                    sQLiteProgram.bindLong(i8, ((Boolean) objF).booleanValue() ? 1L : 0L);
                }
                i7 = i8;
            }
        }
    }

    public List b() {
        return this.f25694b;
    }

    public String c() {
        return this.f25693a;
    }

    public Object[] d() {
        return e(this.f25694b);
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
        if (!(obj instanceof C)) {
            return false;
        }
        C c7 = (C) obj;
        String str = this.f25693a;
        if (str != null) {
            if (!str.equals(c7.f25693a)) {
                return false;
            }
        } else if (c7.f25693a != null) {
            return false;
        }
        if (this.f25694b.size() != c7.f25694b.size()) {
            return false;
        }
        for (int i7 = 0; i7 < this.f25694b.size(); i7++) {
            if ((this.f25694b.get(i7) instanceof byte[]) && (c7.f25694b.get(i7) instanceof byte[])) {
                if (!Arrays.equals((byte[]) this.f25694b.get(i7), (byte[]) c7.f25694b.get(i7))) {
                    return false;
                }
            } else if (!this.f25694b.get(i7).equals(c7.f25694b.get(i7))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        String str = this.f25693a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f25693a);
        List list = this.f25694b;
        if (list == null || list.isEmpty()) {
            str = "";
        } else {
            str = " " + this.f25694b;
        }
        sb.append(str);
        return sb.toString();
    }
}
