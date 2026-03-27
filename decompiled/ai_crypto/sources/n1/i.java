package n1;

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

/* JADX INFO: loaded from: classes.dex */
public class i implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f19095a = 1179403647;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileChannel f19096b;

    public i(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f19096b = new FileInputStream(file).getChannel();
    }

    public List A() throws IOException {
        long j7;
        c cVarA;
        this.f19096b.position(0L);
        ArrayList arrayList = new ArrayList();
        d dVarI = i();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVarI.f19079a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j8 = dVarI.f19084f;
        int i7 = 0;
        if (j8 == 65535) {
            j8 = dVarI.c(0).f19092a;
        }
        long j9 = 0;
        while (true) {
            if (j9 >= j8) {
                j7 = 0;
                break;
            }
            e eVarB = dVarI.b(j9);
            if (eVarB.f19088a == 2) {
                j7 = eVarB.f19089b;
                break;
            }
            j9++;
        }
        if (j7 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j10 = 0;
        do {
            cVarA = dVarI.a(j7, i7);
            long j11 = cVarA.f19077a;
            if (j11 == 1) {
                arrayList2.add(Long.valueOf(cVarA.f19078b));
            } else if (j11 == 5) {
                j10 = cVarA.f19078b;
            }
            i7++;
        } while (cVarA.f19077a != 0);
        if (j10 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long jH = h(dVarI, j8, j10);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(O(byteBufferAllocate, ((Long) it.next()).longValue() + jH));
        }
        return arrayList;
    }

    public void G(ByteBuffer byteBuffer, long j7, int i7) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i7);
        long j8 = 0;
        while (j8 < i7) {
            int i8 = this.f19096b.read(byteBuffer, j7 + j8);
            if (i8 == -1) {
                throw new EOFException();
            }
            j8 += (long) i8;
        }
        byteBuffer.position(0);
    }

    public short H(ByteBuffer byteBuffer, long j7) throws IOException {
        G(byteBuffer, j7, 1);
        return (short) (byteBuffer.get() & 255);
    }

    public int K(ByteBuffer byteBuffer, long j7) throws IOException {
        G(byteBuffer, j7, 2);
        return byteBuffer.getShort() & 65535;
    }

    public long M(ByteBuffer byteBuffer, long j7) throws IOException {
        G(byteBuffer, j7, 8);
        return byteBuffer.getLong();
    }

    public String O(ByteBuffer byteBuffer, long j7) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j8 = 1 + j7;
            short sH = H(byteBuffer, j7);
            if (sH == 0) {
                return sb.toString();
            }
            sb.append((char) sH);
            j7 = j8;
        }
    }

    public long T(ByteBuffer byteBuffer, long j7) throws IOException {
        G(byteBuffer, j7, 4);
        return ((long) byteBuffer.getInt()) & 4294967295L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f19096b.close();
    }

    public final long h(d dVar, long j7, long j8) {
        for (long j9 = 0; j9 < j7; j9++) {
            e eVarB = dVar.b(j9);
            if (eVarB.f19088a == 1) {
                long j10 = eVarB.f19090c;
                if (j10 <= j8 && j8 <= eVarB.f19091d + j10) {
                    return (j8 - j10) + eVarB.f19089b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public d i() throws IOException {
        this.f19096b.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (T(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sH = H(byteBufferAllocate, 4L);
        boolean z7 = H(byteBufferAllocate, 5L) == 2;
        if (sH == 1) {
            return new g(z7, this);
        }
        if (sH == 2) {
            return new h(z7, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }
}
