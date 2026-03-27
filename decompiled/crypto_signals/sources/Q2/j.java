package Q2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class j extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final j f2677b = new j(Collections.singletonList("__name__"));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final j f2678c = new j(Collections.EMPTY_LIST);

    public static j l(String str) {
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        boolean z6 = false;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\\') {
                i++;
                if (i == str.length()) {
                    throw new IllegalArgumentException("Trailing escape character is not allowed");
                }
                sb.append(str.charAt(i));
            } else if (cCharAt == '.') {
                if (z6) {
                    sb.append(cCharAt);
                } else {
                    String string = sb.toString();
                    if (string.isEmpty()) {
                        throw new IllegalArgumentException(AbstractC1024h.c("Invalid field path (", str, "). Paths must not be empty, begin with '.', end with '.', or contain '..'"));
                    }
                    StringBuilder sb2 = new StringBuilder();
                    arrayList.add(string);
                    sb = sb2;
                }
            } else if (cCharAt == '`') {
                z6 = !z6;
            } else {
                sb.append(cCharAt);
            }
            i++;
        }
        String string2 = sb.toString();
        if (string2.isEmpty()) {
            throw new IllegalArgumentException(AbstractC1024h.c("Invalid field path (", str, "). Paths must not be empty, begin with '.', end with '.', or contain '..'"));
        }
        arrayList.add(string2);
        return new j(arrayList);
    }

    @Override // Q2.e
    public final String c() {
        char cCharAt;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (true) {
            List list = this.f2668a;
            if (i >= list.size()) {
                return sb.toString();
            }
            if (i > 0) {
                sb.append(".");
            }
            String strReplace = ((String) list.get(i)).replace("\\", "\\\\").replace("`", "\\`");
            if (strReplace.isEmpty() || ((cCharAt = strReplace.charAt(0)) != '_' && ((cCharAt < 'a' || cCharAt > 'z') && (cCharAt < 'A' || cCharAt > 'Z')))) {
                strReplace = "`" + strReplace + '`';
                break;
                break;
            }
            for (int i6 = 1; i6 < strReplace.length(); i6++) {
                char cCharAt2 = strReplace.charAt(i6);
                if (cCharAt2 != '_' && ((cCharAt2 < 'a' || cCharAt2 > 'z') && ((cCharAt2 < 'A' || cCharAt2 > 'Z') && (cCharAt2 < '0' || cCharAt2 > '9')))) {
                    strReplace = "`" + strReplace + '`';
                    break;
                }
            }
            sb.append(strReplace);
            i++;
        }
    }

    @Override // Q2.e
    public final e e(List list) {
        return new j(list);
    }
}
