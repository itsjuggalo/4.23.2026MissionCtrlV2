package g3;

import java.io.File;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String string = sb.toString();
        r.e(string, "toString(...)");
        return string;
    }
}
