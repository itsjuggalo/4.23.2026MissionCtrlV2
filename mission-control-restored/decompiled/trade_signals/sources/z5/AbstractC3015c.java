package z5;

import java.io.File;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: renamed from: z5.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC3015c {
    public static final String b(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        if (str != null) {
            sb.append(": " + str);
        }
        String string = sb.toString();
        AbstractC2304t.e(string, "toString(...)");
        return string;
    }
}
