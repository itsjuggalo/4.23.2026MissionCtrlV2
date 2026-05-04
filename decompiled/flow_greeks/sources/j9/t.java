package j9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final t f14277b = new t(Collections.EMPTY_LIST);

    public t(List list) {
        super(list);
    }

    public static t A(List list) {
        return list.isEmpty() ? f14277b : new t(list);
    }

    public static t B(String str) {
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

    @Override // j9.e
    public String c() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < this.f14236a.size(); i10++) {
            if (i10 > 0) {
                sb2.append("/");
            }
            sb2.append((String) this.f14236a.get(i10));
        }
        return sb2.toString();
    }

    @Override // j9.e
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public t k(List list) {
        return new t(list);
    }
}
