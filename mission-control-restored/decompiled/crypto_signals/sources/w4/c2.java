package w4;

import java.io.OutputStream;
import java.net.ProxySelector;
import java.nio.ByteBuffer;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class c2 implements InterfaceC1387y, Y1, U1.l, u4.V, u4.Y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c2 f11222b = new c2(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11223a;

    public /* synthetic */ c2(int i) {
        this.f11223a = i;
    }

    public static U g() {
        U u6 = new U();
        u6.f11118a = new Random();
        long nanos = TimeUnit.SECONDS.toNanos(1L);
        u6.f11119b = TimeUnit.MINUTES.toNanos(2L);
        u6.f11120c = 1.6d;
        u6.f11121d = 0.2d;
        u6.e = nanos;
        return u6;
    }

    @Override // u4.Y
    /* JADX INFO: renamed from: a */
    public byte[] mo4a(Object obj) {
        switch (this.f11223a) {
            case 11:
                return (byte[]) obj;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // w4.InterfaceC1387y
    public int b(AbstractC1322c abstractC1322c, int i, Object obj, int i6) {
        switch (this.f11223a) {
            case 2:
                break;
            case 3:
                abstractC1322c.o(i);
                break;
            case 4:
                abstractC1322c.k((byte[]) obj, i6, i);
                break;
            case 5:
                ByteBuffer byteBuffer = (ByteBuffer) obj;
                int iLimit = byteBuffer.limit();
                byteBuffer.limit(byteBuffer.position() + i);
                abstractC1322c.j(byteBuffer);
                byteBuffer.limit(iLimit);
                break;
            default:
                abstractC1322c.i((OutputStream) obj, i);
                break;
        }
        return 0;
    }

    @Override // w4.Y1
    public Object c() {
        switch (this.f11223a) {
            case 8:
                return Executors.newCachedThreadPool(AbstractC1323c0.e("grpc-default-executor-%d"));
            default:
                ScheduledExecutorService scheduledExecutorServiceNewScheduledThreadPool = Executors.newScheduledThreadPool(1, AbstractC1323c0.e("grpc-timer-%d"));
                try {
                    scheduledExecutorServiceNewScheduledThreadPool.getClass().getMethod("setRemoveOnCancelPolicy", Boolean.TYPE).invoke(scheduledExecutorServiceNewScheduledThreadPool, Boolean.TRUE);
                    break;
                } catch (NoSuchMethodException unused) {
                } catch (RuntimeException e) {
                    throw e;
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
                return Executors.unconfigurableScheduledExecutorService(scheduledExecutorServiceNewScheduledThreadPool);
        }
    }

    @Override // u4.Y
    public Object d(byte[] bArr) {
        switch (this.f11223a) {
            case 11:
                return bArr;
            default:
                if (bArr.length < 3) {
                    throw new NumberFormatException("Malformed status code ".concat(new String(bArr, u4.E.f10340a)));
                }
                return Integer.valueOf((bArr[2] - 48) + ((bArr[1] - 48) * 10) + ((bArr[0] - 48) * 100));
        }
    }

    @Override // w4.Y1
    public void e(Object obj) {
        switch (this.f11223a) {
            case 8:
                ((ExecutorService) ((Executor) obj)).shutdown();
                break;
            default:
                ((ScheduledExecutorService) obj).shutdown();
                break;
        }
    }

    public long f() {
        return TimeUnit.MILLISECONDS.toNanos(System.currentTimeMillis());
    }

    @Override // U1.l
    public Object get() {
        switch (this.f11223a) {
            case s3.I0.TIMESTAMP_VALUE_FIELD_NUMBER /* 10 */:
                return new U1.k();
            default:
                return ProxySelector.getDefault();
        }
    }

    @Override // u4.V
    public Object h(String str) {
        s3.D.f("empty timeout", str.length() > 0);
        s3.D.f("bad timeout format", str.length() <= 9);
        long j4 = Long.parseLong(str.substring(0, str.length() - 1));
        char cCharAt = str.charAt(str.length() - 1);
        if (cCharAt == 'H') {
            return Long.valueOf(TimeUnit.HOURS.toNanos(j4));
        }
        if (cCharAt == 'M') {
            return Long.valueOf(TimeUnit.MINUTES.toNanos(j4));
        }
        if (cCharAt == 'S') {
            return Long.valueOf(TimeUnit.SECONDS.toNanos(j4));
        }
        if (cCharAt == 'u') {
            return Long.valueOf(TimeUnit.MICROSECONDS.toNanos(j4));
        }
        if (cCharAt == 'm') {
            return Long.valueOf(TimeUnit.MILLISECONDS.toNanos(j4));
        }
        if (cCharAt == 'n') {
            return Long.valueOf(j4);
        }
        throw new IllegalArgumentException("Invalid timeout unit: " + cCharAt);
    }

    public String toString() {
        switch (this.f11223a) {
            case 8:
                return "grpc-default-executor";
            default:
                return super.toString();
        }
    }

    @Override // u4.V
    public String a(Object obj) {
        Long l6 = (Long) obj;
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        if (l6.longValue() < 0) {
            throw new IllegalArgumentException("Timeout too small");
        }
        if (l6.longValue() < 100000000) {
            return l6 + "n";
        }
        if (l6.longValue() < 100000000000L) {
            return timeUnit.toMicros(l6.longValue()) + "u";
        }
        if (l6.longValue() < 100000000000000L) {
            return timeUnit.toMillis(l6.longValue()) + "m";
        }
        if (l6.longValue() < 100000000000000000L) {
            return timeUnit.toSeconds(l6.longValue()) + "S";
        }
        if (l6.longValue() < 6000000000000000000L) {
            return timeUnit.toMinutes(l6.longValue()) + "M";
        }
        return timeUnit.toHours(l6.longValue()) + "H";
    }
}
