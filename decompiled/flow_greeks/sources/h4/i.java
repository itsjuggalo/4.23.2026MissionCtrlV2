package h4;

import io.flutter.embedding.android.KeyboardMap;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f11004a = 1179403647;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileChannel f11005b;

    public i(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f11005b = new FileInputStream(file).getChannel();
    }

    public int C(ByteBuffer byteBuffer, long j10) throws IOException {
        o(byteBuffer, j10, 2);
        return byteBuffer.getShort() & 65535;
    }

    public long E(ByteBuffer byteBuffer, long j10) throws IOException {
        o(byteBuffer, j10, 8);
        return byteBuffer.getLong();
    }

    public String G(ByteBuffer byteBuffer, long j10) throws IOException {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            long j11 = 1 + j10;
            short sU = u(byteBuffer, j10);
            if (sU == 0) {
                return sb2.toString();
            }
            sb2.append((char) sU);
            j10 = j11;
        }
    }

    public long H(ByteBuffer byteBuffer, long j10) throws IOException {
        o(byteBuffer, j10, 4);
        return ((long) byteBuffer.getInt()) & KeyboardMap.kValueMask;
    }

    public final long b(d dVar, long j10, long j11) {
        for (long j12 = 0; j12 < j10; j12++) {
            e eVarB = dVar.b(j12);
            if (eVarB.f10997a == 1) {
                long j13 = eVarB.f10999c;
                if (j13 <= j11 && j11 <= eVarB.f11000d + j13) {
                    return (j11 - j13) + eVarB.f10998b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public d c() throws IOException {
        this.f11005b.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (H(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sU = u(byteBufferAllocate, 4L);
        boolean z10 = u(byteBufferAllocate, 5L) == 2;
        if (sU == 1) {
            return new g(z10, this);
        }
        if (sU == 2) {
            return new h(z10, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f11005b.close();
    }

    public List e() throws IOException {
        long j10;
        long j11;
        this.f11005b.position(0L);
        ArrayList arrayList = new ArrayList();
        d dVarC = c();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVarC.f10988a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j12 = dVarC.f10993f;
        int i10 = 0;
        if (j12 == 65535) {
            j12 = dVarC.c(0).f11001a;
        }
        long j13 = 0;
        while (true) {
            j10 = 1;
            if (j13 >= j12) {
                j11 = 0;
                break;
            }
            e eVarB = dVarC.b(j13);
            if (eVarB.f10997a == 2) {
                j11 = eVarB.f10998b;
                break;
            }
            j13++;
        }
        if (j11 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j14 = 0;
        while (true) {
            c cVarA = dVarC.a(j11, i10);
            long j15 = j10;
            long j16 = cVarA.f10986a;
            if (j16 == j15) {
                arrayList2.add(Long.valueOf(cVarA.f10987b));
            } else if (j16 == 5) {
                j14 = cVarA.f10987b;
            }
            i10++;
            if (cVarA.f10986a == 0) {
                break;
            }
            j10 = j15;
            j12 = j12;
        }
        if (j14 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long jB = b(dVarC, j12, j14);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(G(byteBufferAllocate, ((Long) it.next()).longValue() + jB));
        }
        return arrayList;
    }

    public void o(ByteBuffer byteBuffer, long j10, int i10) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i10);
        long j11 = 0;
        while (j11 < i10) {
            int i11 = this.f11005b.read(byteBuffer, j10 + j11);
            if (i11 == -1) {
                throw new EOFException();
            }
            j11 += (long) i11;
        }
        byteBuffer.position(0);
    }

    public short u(ByteBuffer byteBuffer, long j10) throws IOException {
        o(byteBuffer, j10, 1);
        return (short) (byteBuffer.get() & 255);
    }
}
