package q2;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: q2.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0926e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f9172b = AbstractC0928g.h(UUID.randomUUID().toString() + System.currentTimeMillis());

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicLong f9173c = new AtomicLong(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f9174a;

    public C0926e() {
        long time = new Date().getTime();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(4);
        byteBufferAllocate.putInt((int) (time / 1000));
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.position(0);
        byte[] bArrArray = byteBufferAllocate.array();
        byte b3 = bArrArray[0];
        byte b6 = bArrArray[1];
        byte b7 = bArrArray[2];
        byte b8 = bArrArray[3];
        byte[] bArrA = a(time % 1000);
        byte b9 = bArrA[0];
        byte b10 = bArrA[1];
        byte[] bArrA2 = a(f9173c.incrementAndGet());
        byte b11 = bArrA2[0];
        byte b12 = bArrA2[1];
        byte[] bArrA3 = a(Integer.valueOf(Process.myPid()).shortValue());
        String strE = AbstractC0928g.e(new byte[]{b3, b6, b7, b8, b9, b10, b11, b12, bArrA3[0], bArrA3[1]});
        Locale locale = Locale.US;
        this.f9174a = String.format(locale, "%s%s%s%s", strE.substring(0, 12), strE.substring(12, 16), strE.subSequence(16, 20), f9172b.substring(0, 12)).toUpperCase(locale);
    }

    public static byte[] a(long j4) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(2);
        byteBufferAllocate.putShort((short) j4);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.position(0);
        return byteBufferAllocate.array();
    }

    public final String toString() {
        return this.f9174a;
    }
}
