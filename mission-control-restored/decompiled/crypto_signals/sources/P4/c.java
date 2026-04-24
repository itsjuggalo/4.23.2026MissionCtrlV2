package P4;

import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.j;

/* JADX INFO: loaded from: classes.dex */
public class c extends IOException {
    public /* synthetic */ c(IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", indexOutOfBoundsException);
    }

    public c(File file, File file2, String str) {
        StringBuilder sb = new StringBuilder(file.toString());
        if (file2 != null) {
            sb.append(" -> " + file2);
        }
        sb.append(": ".concat(str));
        String string = sb.toString();
        j.d(string, "toString(...)");
        super(string);
    }

    public c(String str, IndexOutOfBoundsException indexOutOfBoundsException) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(str), indexOutOfBoundsException);
    }
}
