package O;

import android.os.ParcelFileDescriptor;
import androidx.datastore.core.NativeSharedCounter;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public final class j0 extends kotlin.jvm.internal.k implements R4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2218a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m0 f2219b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j0(m0 m0Var, int i) {
        super(0);
        this.f2218a = i;
        this.f2219b = m0Var;
    }

    @Override // R4.a
    public final Object invoke() throws Throwable {
        ParcelFileDescriptor parcelFileDescriptorOpen;
        switch (this.f2218a) {
            case 0:
                m0 m0Var = this.f2219b;
                File file = new File(m0Var.f2247b.getAbsolutePath() + m0Var.e);
                m0.f(m0Var, file);
                return file;
            case 1:
                System.loadLibrary("datastore_shared_counter");
                try {
                    parcelFileDescriptorOpen = ParcelFileDescriptor.open((File) new j0(this.f2219b, 0).invoke(), 939524096);
                } catch (Throwable th) {
                    th = th;
                    parcelFileDescriptorOpen = null;
                }
                try {
                    int fd = parcelFileDescriptorOpen.getFd();
                    NativeSharedCounter nativeSharedCounter = v0.f2298b;
                    if (nativeSharedCounter.nativeTruncateFile(fd) != 0) {
                        throw new IOException("Failed to truncate counter file");
                    }
                    long jNativeCreateSharedCounter = nativeSharedCounter.nativeCreateSharedCounter(fd);
                    if (jNativeCreateSharedCounter < 0) {
                        throw new IOException("Failed to mmap counter file");
                    }
                    v0 v0Var = new v0(jNativeCreateSharedCounter);
                    parcelFileDescriptorOpen.close();
                    return v0Var;
                } catch (Throwable th2) {
                    th = th2;
                    if (parcelFileDescriptorOpen != null) {
                        parcelFileDescriptorOpen.close();
                    }
                    throw th;
                }
            default:
                m0 m0Var2 = this.f2219b;
                File file2 = new File(m0Var2.f2247b.getAbsolutePath() + m0Var2.f2249d);
                m0.f(m0Var2, file2);
                return file2;
        }
    }
}
