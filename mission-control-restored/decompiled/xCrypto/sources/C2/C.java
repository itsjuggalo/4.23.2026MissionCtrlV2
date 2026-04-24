package C2;

import android.database.sqlite.SQLiteProgram;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class C {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f172a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f173b;

    public C(String str, List list) {
        this.f172a = str;
        this.f173b = list == null ? new ArrayList() : list;
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
        for (int i4 = 0; i4 < list.size(); i4++) {
            bArr[i4] = (byte) ((Integer) list.get(i4)).intValue();
        }
        return bArr;
    }

    public void a(SQLiteProgram sQLiteProgram) {
        List list = this.f173b;
        if (list != null) {
            int size = list.size();
            int i4 = 0;
            while (i4 < size) {
                Object objF = f(this.f173b.get(i4));
                int i5 = i4 + 1;
                if (objF == null) {
                    sQLiteProgram.bindNull(i5);
                } else if (objF instanceof byte[]) {
                    sQLiteProgram.bindBlob(i5, (byte[]) objF);
                } else if (objF instanceof Double) {
                    sQLiteProgram.bindDouble(i5, ((Double) objF).doubleValue());
                } else if (objF instanceof Integer) {
                    sQLiteProgram.bindLong(i5, ((Integer) objF).intValue());
                } else if (objF instanceof Long) {
                    sQLiteProgram.bindLong(i5, ((Long) objF).longValue());
                } else if (objF instanceof String) {
                    sQLiteProgram.bindString(i5, (String) objF);
                } else {
                    if (!(objF instanceof Boolean)) {
                        throw new IllegalArgumentException("Could not bind " + objF + " from index " + i4 + ": Supported types are null, byte[], double, long, boolean and String");
                    }
                    sQLiteProgram.bindLong(i5, ((Boolean) objF).booleanValue() ? 1L : 0L);
                }
                i4 = i5;
            }
        }
    }

    public List b() {
        return this.f173b;
    }

    public String c() {
        return this.f172a;
    }

    public Object[] d() {
        return e(this.f173b);
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
        C c4 = (C) obj;
        String str = this.f172a;
        if (str != null) {
            if (!str.equals(c4.f172a)) {
                return false;
            }
        } else if (c4.f172a != null) {
            return false;
        }
        if (this.f173b.size() != c4.f173b.size()) {
            return false;
        }
        for (int i4 = 0; i4 < this.f173b.size(); i4++) {
            if ((this.f173b.get(i4) instanceof byte[]) && (c4.f173b.get(i4) instanceof byte[])) {
                if (!Arrays.equals((byte[]) this.f173b.get(i4), (byte[]) c4.f173b.get(i4))) {
                    return false;
                }
            } else if (!this.f173b.get(i4).equals(c4.f173b.get(i4))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        String str = this.f172a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f172a);
        List list = this.f173b;
        if (list == null || list.isEmpty()) {
            str = "";
        } else {
            str = " " + this.f173b;
        }
        sb.append(str);
        return sb.toString();
    }
}
