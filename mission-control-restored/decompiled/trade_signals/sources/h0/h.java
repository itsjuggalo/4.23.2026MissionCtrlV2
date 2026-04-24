package h0;

import i0.C1908b;
import io.flutter.embedding.android.KeyboardMap;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    public static class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f18319a;

        public a(ByteBuffer byteBuffer) {
            this.f18319a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // h0.h.c
        public int a() {
            return this.f18319a.getInt();
        }

        @Override // h0.h.c
        public void b(int i8) {
            ByteBuffer byteBuffer = this.f18319a;
            byteBuffer.position(byteBuffer.position() + i8);
        }

        @Override // h0.h.c
        public long c() {
            return h.c(this.f18319a.getInt());
        }

        @Override // h0.h.c
        public long d() {
            return this.f18319a.position();
        }

        @Override // h0.h.c
        public int readUnsignedShort() {
            return h.d(this.f18319a.getShort());
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f18320a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f18321b;

        public b(long j8, long j9) {
            this.f18320a = j8;
            this.f18321b = j9;
        }

        public long a() {
            return this.f18320a;
        }
    }

    public interface c {
        int a();

        void b(int i8);

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
        int i8 = 0;
        while (true) {
            if (i8 >= unsignedShort) {
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
            i8++;
        }
        if (jC != -1) {
            cVar.b((int) (jC - cVar.d()));
            cVar.b(12);
            long jC2 = cVar.c();
            for (int i9 = 0; i9 < jC2; i9++) {
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

    public static C1908b b(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        byteBufferDuplicate.position((int) a(new a(byteBufferDuplicate)).a());
        return C1908b.h(byteBufferDuplicate);
    }

    public static long c(int i8) {
        return ((long) i8) & KeyboardMap.kValueMask;
    }

    public static int d(short s8) {
        return s8 & 65535;
    }
}
