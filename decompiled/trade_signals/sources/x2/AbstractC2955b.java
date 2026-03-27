package x2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import v2.AbstractC2848n;
import y2.AbstractC2976a;

/* JADX INFO: renamed from: x2.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2955b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OutputStream f24186a = new a();

    /* JADX INFO: renamed from: x2.b$a */
    public class a extends OutputStream {
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i8) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            AbstractC2848n.n(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i8, int i9) {
            AbstractC2848n.n(bArr);
            AbstractC2848n.s(i8, i9 + i8, bArr.length);
        }
    }

    public static byte[] a(Queue queue, int i8) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        if (bArr.length == i8) {
            return bArr;
        }
        int length = i8 - bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i8);
        while (length > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int iMin = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i8 - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        AbstractC2848n.n(inputStream);
        AbstractC2848n.n(outputStream);
        byte[] bArrC = c();
        long j8 = 0;
        while (true) {
            int i8 = inputStream.read(bArrC);
            if (i8 == -1) {
                return j8;
            }
            outputStream.write(bArrC, 0, i8);
            j8 += (long) i8;
        }
    }

    public static byte[] c() {
        return new byte[8192];
    }

    public static byte[] d(InputStream inputStream) {
        AbstractC2848n.n(inputStream);
        return e(inputStream, new ArrayDeque(20), 0);
    }

    public static byte[] e(InputStream inputStream, Queue queue, int i8) throws IOException {
        int iMin = Math.min(8192, Math.max(128, Integer.highestOneBit(i8) * 2));
        while (i8 < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i8);
            byte[] bArr = new byte[iMin2];
            queue.add(bArr);
            int i9 = 0;
            while (i9 < iMin2) {
                int i10 = inputStream.read(bArr, i9, iMin2 - i9);
                if (i10 == -1) {
                    return a(queue, i8);
                }
                i9 += i10;
                i8 += i10;
            }
            iMin = AbstractC2976a.e(iMin, iMin < 4096 ? 4 : 2);
        }
        if (inputStream.read() == -1) {
            return a(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }
}
