package Q3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final char f3555a = File.separatorChar;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f3556b;

    static {
        R3.a aVar = new R3.a(4);
        try {
            PrintWriter printWriter = new PrintWriter(aVar);
            try {
                printWriter.println();
                f3556b = aVar.toString();
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

    public static long b(InputStream inputStream, OutputStream outputStream, int i4) {
        return d(inputStream, outputStream, new byte[i4]);
    }

    public static long c(InputStream inputStream, OutputStream outputStream) {
        return b(inputStream, outputStream, 4096);
    }

    public static long d(InputStream inputStream, OutputStream outputStream, byte[] bArr) throws IOException {
        long j4 = 0;
        while (true) {
            int i4 = inputStream.read(bArr);
            if (-1 == i4) {
                return j4;
            }
            outputStream.write(bArr, 0, i4);
            j4 += (long) i4;
        }
    }

    public static void e(byte[] bArr, OutputStream outputStream) throws IOException {
        if (bArr != null) {
            outputStream.write(bArr);
        }
    }
}
