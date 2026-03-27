package O5;

import Z5.u;
import java.io.File;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {
    public static final int a(String str) {
        int iM;
        char c7 = File.separatorChar;
        int iM2 = u.M(str, c7, 0, false, 4, null);
        if (iM2 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c7 || (iM = u.M(str, c7, 2, false, 4, null)) < 0) {
                return 1;
            }
            int iM3 = u.M(str, c7, iM + 1, false, 4, null);
            return iM3 >= 0 ? iM3 + 1 : str.length();
        }
        if (iM2 > 0 && str.charAt(iM2 - 1) == ':') {
            return iM2 + 1;
        }
        if (iM2 == -1 && u.F(str, ':', false, 2, null)) {
            return str.length();
        }
        return 0;
    }

    public static final boolean b(File file) {
        r.f(file, "<this>");
        String path = file.getPath();
        r.e(path, "getPath(...)");
        return a(path) > 0;
    }
}
