package z5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.jvm.internal.AbstractC2304t;
import p5.AbstractC2590l;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h extends g {
    public static byte[] c(File file) throws IllegalAccessException, IOException, InvocationTargetException {
        AbstractC2304t.f(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i8 = (int) length;
            byte[] bArrE = new byte[i8];
            int i9 = i8;
            int i10 = 0;
            while (i9 > 0) {
                int i11 = fileInputStream.read(bArrE, i10, i9);
                if (i11 < 0) {
                    break;
                }
                i9 -= i11;
                i10 += i11;
            }
            if (i9 > 0) {
                bArrE = Arrays.copyOf(bArrE, i10);
                AbstractC2304t.e(bArrE, "copyOf(...)");
            } else {
                int i12 = fileInputStream.read();
                if (i12 != -1) {
                    C3016d c3016d = new C3016d(8193);
                    c3016d.write(i12);
                    AbstractC3013a.b(fileInputStream, c3016d, 0, 2, null);
                    int size = c3016d.size() + i8;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrA = c3016d.a();
                    byte[] bArrCopyOf = Arrays.copyOf(bArrE, size);
                    AbstractC2304t.e(bArrCopyOf, "copyOf(...)");
                    bArrE = AbstractC2590l.e(bArrA, bArrCopyOf, i8, 0, c3016d.size());
                }
            }
            AbstractC3014b.a(fileInputStream, null);
            return bArrE;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AbstractC3014b.a(fileInputStream, th);
                throw th2;
            }
        }
    }
}
