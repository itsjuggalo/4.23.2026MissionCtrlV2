package h0;

import i0.C1736b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f14704a;

        public a(ByteBuffer byteBuffer) {
            this.f14704a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // h0.h.c
        public int a() {
            return this.f14704a.getInt();
        }

        @Override // h0.h.c
        public void b(int i7) {
            ByteBuffer byteBuffer = this.f14704a;
            byteBuffer.position(byteBuffer.position() + i7);
        }

        @Override // h0.h.c
        public long c() {
            return h.c(this.f14704a.getInt());
        }

        @Override // h0.h.c
        public long d() {
            return this.f14704a.position();
        }

        @Override // h0.h.c
        public int readUnsignedShort() {
            return h.d(this.f14704a.getShort());
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f14705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f14706b;

        public b(long j7, long j8) {
            this.f14705a = j7;
            this.f14706b = j8;
        }

        public long a() {
            return this.f14705a;
        }
    }

    public interface c {
        int a();

        void b(int i7);

        long c();

        long d();

        int readUnsignedShort();
    }

    public static b a(c cVar) throws IOException {
        long jC;
        cVar.b(4);
        int unsignedShort = cVar.readUnsignedShort();
        if (unsignedShort > 100) {
            throw new IOException("Cannot read metadata.");
        }
        cVar.b(6);
        int i7 = 0;
        while (true) {
            if (i7 >= unsignedShort) {
                jC = -1;
                break;
            }
            int iA = cVar.a();
            cVar.b(4);
            jC = cVar.c();
            cVar.b(4);
            if (1835365473 == iA) {
                break;
            }
            i7++;
        }
        if (jC != -1) {
            cVar.b((int) (jC - cVar.d()));
            cVar.b(12);
            long jC2 = cVar.c();
            for (int i8 = 0; i8 < jC2; i8++) {
                int iA2 = cVar.a();
                long jC3 = cVar.c();
                long jC4 = cVar.c();
                if (1164798569 == iA2 || 1701669481 == iA2) {
                    return new b(jC3 + jC, jC4);
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static C1736b b(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) a(new a(byteBufferDuplicate)).a());
        return C1736b.h(byteBufferDuplicate);
    }

    public static long c(int i7) {
        return ((long) i7) & 4294967295L;
    }

    public static int d(short s7) {
        return s7 & 65535;
    }
}
