package Q2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class m extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m f2686b = new m(Collections.EMPTY_LIST);

    public static m l(String str) {
        if (str.contains("//")) {
            throw new IllegalArgumentException(AbstractC1024h.c("Invalid path (", str, "). Paths must not contain // in them."));
        }
        String[] strArrSplit = str.split("/");
        ArrayList arrayList = new ArrayList(strArrSplit.length);
        for (String str2 : strArrSplit) {
            if (!str2.isEmpty()) {
                arrayList.add(str2);
            }
        }
        return new m(arrayList);
    }

    @Override // Q2.e
    public final String c() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            List list = this.f2668a;
            if (i >= list.size()) {
                return sb.toString();
            }
            if (i > 0) {
                sb.append("/");
            }
            sb.append((String) list.get(i));
            i++;
        }
    }

    @Override // Q2.e
    public final e e(List list) {
        return new m(list);
    }
}
