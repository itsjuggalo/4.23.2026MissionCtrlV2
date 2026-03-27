package W0;

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

/* JADX INFO: loaded from: classes.dex */
public class i implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f5432a = 1179403647;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileChannel f5433b;

    public i(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f5433b = new FileInputStream(file).getChannel();
    }

    public int A(ByteBuffer byteBuffer, long j4) throws IOException {
        p(byteBuffer, j4, 2);
        return byteBuffer.getShort() & 65535;
    }

    public long E(ByteBuffer byteBuffer, long j4) throws IOException {
        p(byteBuffer, j4, 8);
        return byteBuffer.getLong();
    }

    public String G(ByteBuffer byteBuffer, long j4) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j5 = 1 + j4;
            short sX = x(byteBuffer, j4);
            if (sX == 0) {
                return sb.toString();
            }
            sb.append((char) sX);
            j4 = j5;
        }
    }

    public long J(ByteBuffer byteBuffer, long j4) throws IOException {
        p(byteBuffer, j4, 4);
        return ((long) byteBuffer.getInt()) & KeyboardMap.kValueMask;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f5433b.close();
    }

    public final long e(d dVar, long j4, long j5) {
        for (long j6 = 0; j6 < j4; j6++) {
            e eVarB = dVar.b(j6);
            if (eVarB.f5425a == 1) {
                long j7 = eVarB.f5427c;
                if (j7 <= j5 && j5 <= eVarB.f5428d + j7) {
                    return (j5 - j7) + eVarB.f5426b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public d f() throws IOException {
        this.f5433b.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (J(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sX = x(byteBufferAllocate, 4L);
        boolean z4 = x(byteBufferAllocate, 5L) == 2;
        if (sX == 1) {
            return new g(z4, this);
        }
        if (sX == 2) {
            return new h(z4, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    public List g() throws IOException {
        long j4;
        long j5;
        this.f5433b.position(0L);
        ArrayList arrayList = new ArrayList();
        d dVarF = f();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVarF.f5416a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j6 = dVarF.f5421f;
        int i4 = 0;
        if (j6 == 65535) {
            j6 = dVarF.c(0).f5429a;
        }
        long j7 = 0;
        while (true) {
            j4 = 1;
            if (j7 >= j6) {
                j5 = 0;
                break;
            }
            e eVarB = dVarF.b(j7);
            if (eVarB.f5425a == 2) {
                j5 = eVarB.f5426b;
                break;
            }
            j7++;
        }
        if (j5 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j8 = 0;
        while (true) {
            c cVarA = dVarF.a(j5, i4);
            long j9 = j4;
            long j10 = cVarA.f5414a;
            if (j10 == j9) {
                arrayList2.add(Long.valueOf(cVarA.f5415b));
            } else if (j10 == 5) {
                j8 = cVarA.f5415b;
            }
            i4++;
            if (cVarA.f5414a == 0) {
                break;
            }
            j4 = j9;
            j6 = j6;
        }
        if (j8 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long jE = e(dVarF, j6, j8);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(G(byteBufferAllocate, ((Long) it.next()).longValue() + jE));
        }
        return arrayList;
    }

    public void p(ByteBuffer byteBuffer, long j4, int i4) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i4);
        long j5 = 0;
        while (j5 < i4) {
            int i5 = this.f5433b.read(byteBuffer, j4 + j5);
            if (i5 == -1) {
                throw new EOFException();
            }
            j5 += (long) i5;
        }
        byteBuffer.position(0);
    }

    public short x(ByteBuffer byteBuffer, long j4) throws IOException {
        p(byteBuffer, j4, 1);
        return (short) (byteBuffer.get() & 255);
    }
}
