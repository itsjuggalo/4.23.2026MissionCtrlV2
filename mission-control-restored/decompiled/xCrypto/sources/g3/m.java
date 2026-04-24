package g3;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class m {
    public static final long a(Reader reader, Writer out, int i4) throws IOException {
        r.f(reader, "<this>");
        r.f(out, "out");
        char[] cArr = new char[i4];
        int i5 = reader.read(cArr);
        long j4 = 0;
        while (i5 >= 0) {
            out.write(cArr, 0, i5);
            j4 += (long) i5;
            i5 = reader.read(cArr);
        }
        return j4;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i4, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = UserMetadata.MAX_INTERNAL_KEY_SIZE;
        }
        return a(reader, writer, i4);
    }

    public static final q3.e c(BufferedReader bufferedReader) {
        r.f(bufferedReader, "<this>");
        return q3.j.d(new k(bufferedReader));
    }

    public static final String d(Reader reader) {
        r.f(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        r.e(string, "toString(...)");
        return string;
    }
}
