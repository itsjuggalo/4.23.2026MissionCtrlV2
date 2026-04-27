package g3;

import java.io.File;
import kotlin.jvm.internal.r;
import r3.AbstractC1753A;

/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public static final int a(String str) {
        int iR;
        char c4 = File.separatorChar;
        int iR2 = AbstractC1753A.R(str, c4, 0, false, 4, null);
        if (iR2 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c4 || (iR = AbstractC1753A.R(str, c4, 2, false, 4, null)) < 0) {
                return 1;
            }
            int iR3 = AbstractC1753A.R(str, c4, iR + 1, false, 4, null);
            return iR3 >= 0 ? iR3 + 1 : str.length();
        }
        if (iR2 > 0 && str.charAt(iR2 - 1) == ':') {
            return iR2 + 1;
        }
        if (iR2 == -1 && AbstractC1753A.K(str, ':', false, 2, null)) {
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
