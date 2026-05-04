package nd;

import cd.h0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends g {
    public static byte[] c(File file) throws IllegalAccessException, IOException, InvocationTargetException {
        t.f(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i10 = (int) length;
            byte[] bArrE = new byte[i10];
            int i11 = i10;
            int i12 = 0;
            while (i11 > 0) {
                int i13 = fileInputStream.read(bArrE, i12, i11);
                if (i13 < 0) {
                    break;
                }
                i11 -= i13;
                i12 += i13;
            }
            if (i11 > 0) {
                bArrE = Arrays.copyOf(bArrE, i12);
                t.e(bArrE, "copyOf(...)");
            } else {
                int i14 = fileInputStream.read();
                if (i14 != -1) {
                    d dVar = new d(8193);
                    dVar.write(i14);
                    a.b(fileInputStream, dVar, 0, 2, null);
                    int size = dVar.size() + i10;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrB = dVar.b();
                    byte[] bArrCopyOf = Arrays.copyOf(bArrE, size);
                    t.e(bArrCopyOf, "copyOf(...)");
                    bArrE = dd.l.e(bArrB, bArrCopyOf, i10, 0, dVar.size());
                }
            }
            b.a(fileInputStream, null);
            return bArrE;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                b.a(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static void d(File file, byte[] array) throws IllegalAccessException, IOException, InvocationTargetException {
        t.f(file, "<this>");
        t.f(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            h0 h0Var = h0.f3852a;
            b.a(fileOutputStream, null);
        } finally {
        }
    }
}
