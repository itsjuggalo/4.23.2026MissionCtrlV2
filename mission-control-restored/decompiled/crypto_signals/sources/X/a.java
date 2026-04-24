package X;

import android.media.MediaDataSource;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class a extends MediaDataSource {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3352a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f3353b;

    public a(g gVar) {
        this.f3353b = gVar;
    }

    @Override // android.media.MediaDataSource
    public final long getSize() {
        return -1L;
    }

    @Override // android.media.MediaDataSource
    public final int readAt(long j4, byte[] bArr, int i, int i6) {
        if (i6 == 0) {
            return 0;
        }
        if (j4 < 0) {
            return -1;
        }
        try {
            long j6 = this.f3352a;
            g gVar = this.f3353b;
            if (j6 != j4) {
                if (j6 >= 0 && j4 >= j6 + ((long) gVar.f3354a.available())) {
                    return -1;
                }
                gVar.f(j4);
                this.f3352a = j4;
            }
            if (i6 > gVar.f3354a.available()) {
                i6 = gVar.f3354a.available();
            }
            int i7 = gVar.read(bArr, i, i6);
            if (i7 >= 0) {
                this.f3352a += (long) i7;
                return i7;
            }
        } catch (IOException unused) {
        }
        this.f3352a = -1L;
        return -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
