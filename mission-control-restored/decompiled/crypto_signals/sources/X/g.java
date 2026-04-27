package X;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public final class g extends b {
    public g(byte[] bArr) {
        super(bArr);
        this.f3354a.mark(com.google.android.gms.common.api.f.API_PRIORITY_OTHER);
    }

    public final void f(long j4) throws IOException {
        int i = this.f3355b;
        if (i > j4) {
            this.f3355b = 0;
            this.f3354a.reset();
        } else {
            j4 -= (long) i;
        }
        d((int) j4);
    }

    public g(InputStream inputStream) {
        super(inputStream);
        if (inputStream.markSupported()) {
            this.f3354a.mark(com.google.android.gms.common.api.f.API_PRIORITY_OTHER);
            return;
        }
        throw new IllegalArgumentException("Cannot create SeekableByteOrderedDataInputStream with stream that does not support mark/reset");
    }
}
