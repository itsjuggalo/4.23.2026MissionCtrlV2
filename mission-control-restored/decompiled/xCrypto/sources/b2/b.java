package b2;

import Z1.m;
import c2.AbstractC0874a;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final OutputStream f8283a = new a();

    public class a extends OutputStream {
        public String toString() {
            return "ByteStreams.nullOutputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i4) {
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            m.n(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i4, int i5) {
            m.n(bArr);
            m.s(i4, i5 + i4, bArr.length);
        }
    }

    public static byte[] a(Queue queue, int i4) {
        if (queue.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) queue.remove();
        if (bArr.length == i4) {
            return bArr;
        }
        int length = i4 - bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i4);
        while (length > 0) {
            byte[] bArr2 = (byte[]) queue.remove();
            int iMin = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i4 - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    public static long b(InputStream inputStream, OutputStream outputStream) throws IOException {
        m.n(inputStream);
        m.n(outputStream);
        byte[] bArrC = c();
        long j4 = 0;
        while (true) {
            int i4 = inputStream.read(bArrC);
            if (i4 == -1) {
                return j4;
            }
            outputStream.write(bArrC, 0, i4);
            j4 += (long) i4;
        }
    }

    public static byte[] c() {
        return new byte[UserMetadata.MAX_INTERNAL_KEY_SIZE];
    }

    public static byte[] d(InputStream inputStream) {
        m.n(inputStream);
        return e(inputStream, new ArrayDeque(20), 0);
    }

    public static byte[] e(InputStream inputStream, Queue queue, int i4) throws IOException {
        int iMin = Math.min(UserMetadata.MAX_INTERNAL_KEY_SIZE, Math.max(UserMetadata.MAX_ROLLOUT_ASSIGNMENTS, Integer.highestOneBit(i4) * 2));
        while (i4 < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i4);
            byte[] bArr = new byte[iMin2];
            queue.add(bArr);
            int i5 = 0;
            while (i5 < iMin2) {
                int i6 = inputStream.read(bArr, i5, iMin2 - i5);
                if (i6 == -1) {
                    return a(queue, i4);
                }
                i5 += i6;
                i4 += i6;
            }
            iMin = AbstractC0874a.e(iMin, iMin < 4096 ? 4 : 2);
        }
        if (inputStream.read() == -1) {
            return a(queue, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }
}
