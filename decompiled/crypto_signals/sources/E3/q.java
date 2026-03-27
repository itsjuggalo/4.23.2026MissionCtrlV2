package E3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f456a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List f457b;

    public q(String str, List list) {
        this.f456a = str;
        this.f457b = list == null ? new ArrayList() : list;
    }

    public static Object a(Object obj) {
        if (obj == null) {
            return null;
        }
        if (!(obj instanceof List)) {
            return obj;
        }
        List list = (List) obj;
        byte[] bArr = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bArr[i] = (byte) ((Integer) list.get(i)).intValue();
        }
        return bArr;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        String str = this.f456a;
        if (str != null) {
            if (!str.equals(qVar.f456a)) {
                return false;
            }
        } else if (qVar.f456a != null) {
            return false;
        }
        List list = this.f457b;
        if (list.size() != qVar.f457b.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            boolean z6 = list.get(i) instanceof byte[];
            List list2 = qVar.f457b;
            if (z6 && (list2.get(i) instanceof byte[])) {
                if (!Arrays.equals((byte[]) list.get(i), (byte[]) list2.get(i))) {
                    return false;
                }
            } else if (!list.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        String str = this.f456a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f456a);
        List list = this.f457b;
        if (list == null || list.isEmpty()) {
            str = "";
        } else {
            str = " " + list;
        }
        sb.append(str);
        return sb.toString();
    }
}
