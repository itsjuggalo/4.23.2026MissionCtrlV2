package z5;

import U6.o;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes2.dex */
public abstract class m {
    public static final long a(Reader reader, Writer out, int i8) throws IOException {
        AbstractC2304t.f(reader, "<this>");
        AbstractC2304t.f(out, "out");
        char[] cArr = new char[i8];
        int i9 = reader.read(cArr);
        long j8 = 0;
        while (i9 >= 0) {
            out.write(cArr, 0, i9);
            j8 += (long) i9;
            i9 = reader.read(cArr);
        }
        return j8;
    }

    public static /* synthetic */ long b(Reader reader, Writer writer, int i8, int i9, Object obj) {
        if ((i9 & 2) != 0) {
            i8 = 8192;
        }
        return a(reader, writer, i8);
    }

    public static final U6.h c(BufferedReader bufferedReader) {
        AbstractC2304t.f(bufferedReader, "<this>");
        return o.f(new k(bufferedReader));
    }

    public static final String d(Reader reader) {
        AbstractC2304t.f(reader, "<this>");
        StringWriter stringWriter = new StringWriter();
        b(reader, stringWriter, 0, 2, null);
        String string = stringWriter.toString();
        AbstractC2304t.e(string, "toString(...)");
        return string;
    }
}
