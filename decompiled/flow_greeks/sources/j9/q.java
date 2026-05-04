package j9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class q extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f14256b = E("__name__");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f14257c = new q(Collections.EMPTY_LIST);

    public q(List list) {
        super(list);
    }

    public static q A(List list) {
        return list.isEmpty() ? f14257c : new q(list);
    }

    public static q B(String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        boolean z10 = false;
        while (i10 < str.length()) {
            char cCharAt = str.charAt(i10);
            if (cCharAt == '\\') {
                i10++;
                if (i10 == str.length()) {
                    throw new IllegalArgumentException("Trailing escape character is not allowed");
                }
                sb2.append(str.charAt(i10));
            } else if (cCharAt == '.') {
                if (z10) {
                    sb2.append(cCharAt);
                } else {
                    String string = sb2.toString();
                    if (string.isEmpty()) {
                        throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
                    }
                    StringBuilder sb3 = new StringBuilder();
                    arrayList.add(string);
                    sb2 = sb3;
                }
            } else if (cCharAt == '`') {
                z10 = !z10;
            } else {
                sb2.append(cCharAt);
            }
            i10++;
        }
        String string2 = sb2.toString();
        if (!string2.isEmpty()) {
            arrayList.add(string2);
            return new q(arrayList);
        }
        throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
    }

    public static q E(String str) {
        return new q(Collections.singletonList(str));
    }

    public static boolean H(String str) {
        if (str.isEmpty()) {
            return false;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt != '_' && ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z'))) {
            return false;
        }
        for (int i10 = 1; i10 < str.length(); i10++) {
            char cCharAt2 = str.charAt(i10);
            if (cCharAt2 != '_' && ((cCharAt2 < 'a' || cCharAt2 > 'z') && ((cCharAt2 < 'A' || cCharAt2 > 'Z') && (cCharAt2 < '0' || cCharAt2 > '9')))) {
                return false;
            }
        }
        return true;
    }

    public boolean G() {
        return equals(f14256b);
    }

    @Override // j9.e
    public String c() {
        StringBuilder sb2 = new StringBuilder();
        for (int i10 = 0; i10 < this.f14236a.size(); i10++) {
            if (i10 > 0) {
                sb2.append(".");
            }
            String strReplace = ((String) this.f14236a.get(i10)).replace("\\", "\\\\").replace("`", "\\`");
            if (!H(strReplace)) {
                strReplace = '`' + strReplace + '`';
            }
            sb2.append(strReplace);
        }
        return sb2.toString();
    }

    @Override // j9.e
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public q k(List list) {
        return new q(list);
    }
}
