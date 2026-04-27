package G3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class q extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final q f2455b = w("__name__");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final q f2456c = new q(Collections.emptyList());

    public q(List list) {
        super(list);
    }

    public static q u(List list) {
        return list.isEmpty() ? f2456c : new q(list);
    }

    public static q v(String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i7 = 0;
        boolean z7 = false;
        while (i7 < str.length()) {
            char cCharAt = str.charAt(i7);
            if (cCharAt == '\\') {
                i7++;
                if (i7 == str.length()) {
                    throw new IllegalArgumentException("Trailing escape character is not allowed");
                }
                sb.append(str.charAt(i7));
            } else if (cCharAt == '.') {
                if (z7) {
                    sb.append(cCharAt);
                } else {
                    String string = sb.toString();
                    if (string.isEmpty()) {
                        throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
                    }
                    StringBuilder sb2 = new StringBuilder();
                    arrayList.add(string);
                    sb = sb2;
                }
            } else if (cCharAt == '`') {
                z7 = !z7;
            } else {
                sb.append(cCharAt);
            }
            i7++;
        }
        String string2 = sb.toString();
        if (!string2.isEmpty()) {
            arrayList.add(string2);
            return new q(arrayList);
        }
        throw new IllegalArgumentException("Invalid field path (" + str + "). Paths must not be empty, begin with '.', end with '.', or contain '..'");
    }

    public static q w(String str) {
        return new q(Collections.singletonList(str));
    }

    public static boolean y(String str) {
        if (str.isEmpty()) {
            return false;
        }
        char cCharAt = str.charAt(0);
        if (cCharAt != '_' && ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z'))) {
            return false;
        }
        for (int i7 = 1; i7 < str.length(); i7++) {
            char cCharAt2 = str.charAt(i7);
            if (cCharAt2 != '_' && ((cCharAt2 < 'a' || cCharAt2 > 'z') && ((cCharAt2 < 'A' || cCharAt2 > 'Z') && (cCharAt2 < '0' || cCharAt2 > '9')))) {
                return false;
            }
        }
        return true;
    }

    @Override // G3.e
    public String c() {
        StringBuilder sb = new StringBuilder();
        for (int i7 = 0; i7 < this.f2435a.size(); i7++) {
            if (i7 > 0) {
                sb.append(".");
            }
            String strReplace = ((String) this.f2435a.get(i7)).replace("\\", "\\\\").replace("`", "\\`");
            if (!y(strReplace)) {
                strReplace = '`' + strReplace + '`';
            }
            sb.append(strReplace);
        }
        return sb.toString();
    }

    @Override // G3.e
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public q j(List list) {
        return new q(list);
    }

    public boolean x() {
        return equals(f2455b);
    }
}
