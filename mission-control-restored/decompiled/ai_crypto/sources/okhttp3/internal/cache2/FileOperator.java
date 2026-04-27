package okhttp3.internal.cache2;

import java.io.IOException;
import java.nio.channels.FileChannel;
import w6.C2792e;

/* JADX INFO: loaded from: classes2.dex */
final class FileOperator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FileChannel f20757a;

    public FileOperator(FileChannel fileChannel) {
        this.f20757a = fileChannel;
    }

    public void a(long j7, C2792e c2792e, long j8) throws IOException {
        if (j8 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j8 > 0) {
            long jTransferTo = this.f20757a.transferTo(j7, j8, c2792e);
            j7 += jTransferTo;
            j8 -= jTransferTo;
        }
    }

    public void b(long j7, C2792e c2792e, long j8) throws IOException {
        if (j8 < 0 || j8 > c2792e.E0()) {
            throw new IndexOutOfBoundsException();
        }
        while (j8 > 0) {
            long jTransferFrom = this.f20757a.transferFrom(c2792e, j7, j8);
            j7 += jTransferFrom;
            j8 -= jTransferFrom;
        }
    }
}
