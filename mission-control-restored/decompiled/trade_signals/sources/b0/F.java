package b0;

import android.os.ParcelFileDescriptor;
import androidx.datastore.core.NativeSharedCounter;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.AbstractC2296k;
import kotlin.jvm.internal.AbstractC2304t;

/* JADX INFO: loaded from: classes.dex */
public final class F {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12557b = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final NativeSharedCounter f12558c = new NativeSharedCounter();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f12559a;

    public static final class a {
        public a() {
        }

        public final F a(Function0 produceFile) throws Throwable {
            ParcelFileDescriptor parcelFileDescriptorOpen;
            AbstractC2304t.f(produceFile, "produceFile");
            try {
                parcelFileDescriptorOpen = ParcelFileDescriptor.open((File) produceFile.invoke(), 939524096);
                try {
                    F fB = b(parcelFileDescriptorOpen);
                    if (parcelFileDescriptorOpen != null) {
                        parcelFileDescriptorOpen.close();
                    }
                    return fB;
                } catch (Throwable th) {
                    th = th;
                    if (parcelFileDescriptorOpen != null) {
                        parcelFileDescriptorOpen.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                parcelFileDescriptorOpen = null;
            }
        }

        public final F b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
            int fd = parcelFileDescriptor.getFd();
            if (c().nativeTruncateFile(fd) != 0) {
                throw new IOException("Failed to truncate counter file");
            }
            long jNativeCreateSharedCounter = c().nativeCreateSharedCounter(fd);
            if (jNativeCreateSharedCounter >= 0) {
                return new F(jNativeCreateSharedCounter, null);
            }
            throw new IOException("Failed to mmap counter file");
        }

        public final NativeSharedCounter c() {
            return F.f12558c;
        }

        public final void d() {
            System.loadLibrary("datastore_shared_counter");
        }

        public /* synthetic */ a(AbstractC2296k abstractC2296k) {
            this();
        }
    }

    public F(long j8) {
        this.f12559a = j8;
    }

    public final int b() {
        return f12558c.nativeGetCounterValue(this.f12559a);
    }

    public final int c() {
        return f12558c.nativeIncrementAndGetCounterValue(this.f12559a);
    }

    public /* synthetic */ F(long j8, AbstractC2296k abstractC2296k) {
        this(j8);
    }
}
