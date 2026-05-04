package nd;

import java.io.File;
import kg.c0;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public static final int a(String str) {
        int iB0;
        char c10 = File.separatorChar;
        int iB02 = c0.b0(str, c10, 0, false, 4, null);
        if (iB02 == 0) {
            if (str.length() <= 1 || str.charAt(1) != c10 || (iB0 = c0.b0(str, c10, 2, false, 4, null)) < 0) {
                return 1;
            }
            int iB03 = c0.b0(str, c10, iB0 + 1, false, 4, null);
            return iB03 >= 0 ? iB03 + 1 : str.length();
        }
        if (iB02 > 0 && str.charAt(iB02 - 1) == ':') {
            return iB02 + 1;
        }
        if (iB02 == -1 && c0.S(str, ':', false, 2, null)) {
            return str.length();
        }
        return 0;
    }

    public static final boolean b(File file) {
        t.f(file, "<this>");
        String path = file.getPath();
        t.e(path, "getPath(...)");
        return a(path) > 0;
    }
}
