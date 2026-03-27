package G3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class t extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f2474b = new t(Collections.emptyList());

    public t(List list) {
        super(list);
    }

    public static t u(List list) {
        return list.isEmpty() ? f2474b : new t(list);
    }

    public static t v(String str) {
        if (str.contains("//")) {
            throw new IllegalArgumentException("Invalid path (" + str + "). Paths must not contain // in them.");
        }
        String[] strArrSplit = str.split("/");
        ArrayList arrayList = new ArrayList(strArrSplit.length);
        for (String str2 : strArrSplit) {
            if (!str2.isEmpty()) {
                arrayList.add(str2);
            }
        }
        return new t(arrayList);
    }

    @Override // G3.e
    public String c() {
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < this.f2435a.size(); i7++) {
            if (i7 > 0) {
                sb.append("/");
            }
            sb.append((String) this.f2435a.get(i7));
        }
        return sb.toString();
    }

    @Override // G3.e
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public t j(List list) {
        return new t(list);
    }
}
