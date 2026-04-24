package k0;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;
import android.system.ErrnoException;
import android.system.Os;
import android.util.Log;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: renamed from: k0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2064b {

    /* JADX INFO: renamed from: k0.b$a */
    public static class a {
        public static void a(FileDescriptor fileDescriptor) throws ErrnoException {
            Os.close(fileDescriptor);
        }

        public static FileDescriptor b(FileDescriptor fileDescriptor) {
            return Os.dup(fileDescriptor);
        }

        public static long c(FileDescriptor fileDescriptor, long j7, int i7) {
            return Os.lseek(fileDescriptor, j7, i7);
        }
    }

    /* JADX INFO: renamed from: k0.b$b, reason: collision with other inner class name */
    public static class C0268b {
        public static void a(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) {
            mediaMetadataRetriever.setDataSource(mediaDataSource);
        }
    }

    public static void a(FileDescriptor fileDescriptor) {
        try {
            a.a(fileDescriptor);
        } catch (Exception unused) {
            Log.e("ExifInterfaceUtils", "Error closing fd.");
        }
    }

    public static void b(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e7) {
                throw e7;
            } catch (Exception unused) {
            }
        }
    }

    public static long[] c(Object obj) {
        if (!(obj instanceof int[])) {
            if (obj instanceof long[]) {
                return (long[]) obj;
            }
            return null;
        }
        int[] iArr = (int[]) obj;
        long[] jArr = new long[iArr.length];
        for (int i7 = 0; i7 < iArr.length; i7++) {
            jArr[i7] = iArr[i7];
        }
        return jArr;
    }

    public static int d(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        int i7 = 0;
        while (true) {
            int i8 = inputStream.read(bArr);
            if (i8 == -1) {
                return i7;
            }
            i7 += i8;
            outputStream.write(bArr, 0, i8);
        }
    }

    public static void e(InputStream inputStream, OutputStream outputStream, int i7) throws IOException {
        byte[] bArr = new byte[8192];
        while (i7 > 0) {
            int iMin = Math.min(i7, 8192);
            int i8 = inputStream.read(bArr, 0, iMin);
            if (i8 != iMin) {
                throw new IOException("Failed to copy the given amount of bytes from the inputstream to the output stream.");
            }
            i7 -= i8;
            outputStream.write(bArr, 0, i8);
        }
    }

    public static boolean f(byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr2 == null || bArr.length < bArr2.length) {
            return false;
        }
        for (int i7 = 0; i7 < bArr2.length; i7++) {
            if (bArr[i7] != bArr2[i7]) {
                return false;
            }
        }
        return true;
    }
}
