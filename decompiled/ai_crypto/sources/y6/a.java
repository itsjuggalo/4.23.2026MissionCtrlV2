package y6;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f25785a = File.separatorChar;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f25786b;

    static {
        z6.a aVar = new z6.a(4);
        try {
            PrintWriter printWriter = new PrintWriter(aVar);
            try {
                printWriter.println();
                f25786b = aVar.toString();
                printWriter.close();
                aVar.close();
            } finally {
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                try {
                    aVar.close();
                } catch (Throwable th3) {
                    th.addSuppressed(th3);
                }
                throw th2;
            }
        }
    }

    public static int a(InputStream inputStream, OutputStream outputStream) {
        long jC = c(inputStream, outputStream);
        if (jC > 2147483647L) {
            return -1;
        }
        return (int) jC;
    }

    public static long b(InputStream inputStream, OutputStream outputStream, int i7) {
        return d(inputStream, outputStream, new byte[i7]);
    }

    public static long c(InputStream inputStream, OutputStream outputStream) {
        return b(inputStream, outputStream, 4096);
    }

    public static long d(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j7 = 0;
        while (true) {
            int i7 = inputStream.read(bArr);
            if (-1 == i7) {
                return j7;
            }
            outputStream.write(bArr, 0, i7);
            j7 += (long) i7;
        }
    }

    public static void e(byte[] bArr, OutputStream outputStream) throws IOException {
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }
}
