package z5;

import V6.C;
import java.io.File;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class g {
    public static final int a(String str) {
        int iX;
        char c8 = File.separatorChar;
        int iX2 = C.X(str, c8, 0, false, 4, null);
        if (iX2 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c8 || (iX = C.X(str, c8, 2, false, 4, null)) < 0) {
                return 1;
            }
            int iX3 = C.X(str, c8, iX + 1, false, 4, null);
            return iX3 >= 0 ? iX3 + 1 : str.length();
        }
        if (iX2 > 0 && str.charAt(iX2 - 1) == ':') {
            return iX2 + 1;
        }
        if (iX2 == -1 && C.O(str, ':', false, 2, null)) {
            return str.length();
        }
        return 0;
    }

    public static final boolean b(File file) {
        AbstractC2304t.f(file, "<this>");
        String path = file.getPath();
        AbstractC2304t.e(path, "getPath(...)");
        return a(path) > 0;
    }
}
