package K4;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes2.dex */
public class G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3510a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f3511b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f3512c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f3513d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f3514e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public a f3515f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f3516g;

    public enum a {
        kKeyboard(0),
        kDirectionalPad(1),
        kGamepad(2),
        kJoystick(3),
        kHdmi(4);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f3523a;

        a(long j7) {
            this.f3523a = j7;
        }

        public long b() {
            return this.f3523a;
        }
    }

    public enum b {
        kDown(0),
        kUp(1),
        kRepeat(2);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f3528a;

        b(long j7) {
            this.f3528a = j7;
        }

        public long b() {
            return this.f3528a;
        }
    }

    public ByteBuffer a() {
        try {
            String str = this.f3516g;
            byte[] bytes = str == null ? null : str.getBytes("UTF-8");
            int length = bytes == null ? 0 : bytes.length;
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(length + 56);
            byteBufferAllocateDirect.order(ByteOrder.LITTLE_ENDIAN);
            byteBufferAllocateDirect.putLong(length);
            byteBufferAllocateDirect.putLong(this.f3510a);
            byteBufferAllocateDirect.putLong(this.f3511b.b());
            byteBufferAllocateDirect.putLong(this.f3512c);
            byteBufferAllocateDirect.putLong(this.f3513d);
            byteBufferAllocateDirect.putLong(this.f3514e ? 1L : 0L);
            byteBufferAllocateDirect.putLong(this.f3515f.b());
            if (bytes != null) {
                byteBufferAllocateDirect.put(bytes);
            }
            return byteBufferAllocateDirect;
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError("UTF-8 not supported");
        }
    }
}
