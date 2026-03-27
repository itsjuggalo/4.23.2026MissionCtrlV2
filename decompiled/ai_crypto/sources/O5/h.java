package O5;

import E5.E;
import F5.AbstractC0551i;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import kotlin.jvm.internal.r;

/* JADX INFO: loaded from: classes2.dex */
public abstract class h extends g {
    public static byte[] c(File file) throws IllegalAccessException, IOException, InvocationTargetException {
        r.f(file, "<this>");
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            long length = file.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + file + " is too big (" + length + " bytes) to fit in memory.");
            }
            int i7 = (int) length;
            byte[] bArrD = new byte[i7];
            int i8 = i7;
            int i9 = 0;
            while (i8 > 0) {
                int i10 = fileInputStream.read(bArrD, i9, i8);
                if (i10 < 0) {
                    break;
                }
                i8 -= i10;
                i9 += i10;
            }
            if (i8 > 0) {
                bArrD = Arrays.copyOf(bArrD, i9);
                r.e(bArrD, "copyOf(...)");
            } else {
                int i11 = fileInputStream.read();
                if (i11 != -1) {
                    d dVar = new d(8193);
                    dVar.write(i11);
                    a.b(fileInputStream, dVar, 0, 2, null);
                    int size = dVar.size() + i7;
                    if (size < 0) {
                        throw new OutOfMemoryError("File " + file + " is too big to fit in memory.");
                    }
                    byte[] bArrH = dVar.h();
                    byte[] bArrCopyOf = Arrays.copyOf(bArrD, size);
                    r.e(bArrCopyOf, "copyOf(...)");
                    bArrD = AbstractC0551i.d(bArrH, bArrCopyOf, i7, 0, dVar.size());
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
            E e7 = E.f1657a;
            b.a(fileOutputStream, null);
        } finally {
        }
    }
}
