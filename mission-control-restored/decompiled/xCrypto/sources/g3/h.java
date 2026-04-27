package g3;

import W2.E;
import X2.AbstractC0763j;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes3.dex */
public abstract class h extends g {
    public static byte[] c(File file) throws IllegalAccessException, IOException, InvocationTargetException {
        r.f(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i4 = (int) length;
            byte[] bArrD = new byte[i4];
            int i5 = i4;
            int i6 = 0;
            while (i5 > 0) {
                int i7 = fileInputStream.read(bArrD, i6, i5);
                if (i7 < 0) {
                    break;
                }
                i5 -= i7;
                i6 += i7;
            }
            if (i5 > 0) {
                bArrD = Arrays.copyOf(bArrD, i6);
                r.e(bArrD, "copyOf(...)");
            } else {
                int i8 = fileInputStream.read();
                if (i8 != -1) {
                    d dVar = new d(8193);
                    dVar.write(i8);
                    AbstractC1269a.b(fileInputStream, dVar, 0, 2, null);
                    int size = dVar.size() + i4;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrE = dVar.e();
                    byte[] bArrCopyOf = Arrays.copyOf(bArrD, size);
                    r.e(bArrCopyOf, "copyOf(...)");
                    bArrD = AbstractC0763j.d(bArrE, bArrCopyOf, i4, 0, dVar.size());
                }
            }
            b.a(fileInputStream, null);
            return bArrD;
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
        r.f(file, "<this>");
        r.f(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(array);
            E e4 = E.f5463a;
            b.a(fileOutputStream, null);
        } finally {
        }
    }
}
