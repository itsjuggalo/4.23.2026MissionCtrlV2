package J2;

import H2.m;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OutputStream f3071a = new a();

    public class a extends OutputStream {
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i7) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            m.n(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i7, int i8) {
            m.n(bArr);
            m.s(i7, i8 + i7, bArr.length);
        }
    }

    public static byte[] a(Queue queue, int i7) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        if (bArr.length == i7) {
            return bArr;
        }
        int length = i7 - bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i7);
        while (length > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int iMin = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i7 - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        m.n(inputStream);
        m.n(outputStream);
        byte[] bArrC = c();
        long j7 = 0;
        while (true) {
            int i7 = inputStream.read(bArrC);
            if (i7 == -1) {
                return j7;
            }
            outputStream.write(bArrC, 0, i7);
            j7 += (long) i7;
        }
    }

    public static byte[] c() {
        return new byte[8192];
    }

    public static byte[] d(InputStream inputStream) {
        m.n(inputStream);
        return e(inputStream, new ArrayDeque(20), 0);
    }

    public static byte[] e(InputStream inputStream, Queue queue, int i7) throws IOException {
        int iMin = Math.min(8192, Math.max(128, Integer.highestOneBit(i7) * 2));
        while (i7 < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i7);
            byte[] bArr = new byte[iMin2];
            queue.add(bArr);
            int i8 = 0;
            while (i8 < iMin2) {
                int i9 = inputStream.read(bArr, i8, iMin2 - i8);
                if (i9 == -1) {
                    return a(queue, i7);
                }
                i8 += i9;
                i7 += i9;
            }
            iMin = K2.a.e(iMin, iMin < 4096 ? 4 : 2);
        }
        if (inputStream.read() == -1) {
            return a(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }
}
