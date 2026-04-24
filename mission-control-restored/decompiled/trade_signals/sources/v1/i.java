package v1;

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
    public final int f23743a = 1179403647;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FileChannel f23744b;

    public i(File file) {
        if (file == null || !file.exists()) {
            throw new IllegalArgumentException("File is null or does not exist");
        }
        this.f23744b = new FileInputStream(file).getChannel();
    }

    public long B(ByteBuffer byteBuffer, long j8) throws IOException {
        f(byteBuffer, j8, 8);
        return byteBuffer.getLong();
    }

    public String D(ByteBuffer byteBuffer, long j8) throws IOException {
        StringBuilder sb = new StringBuilder();
        while (true) {
            long j9 = 1 + j8;
            short sN = n(byteBuffer, j8);
            if (sN == 0) {
                return sb.toString();
            }
            sb.append((char) sN);
            j8 = j9;
        }
    }

    public long E(ByteBuffer byteBuffer, long j8) throws IOException {
        f(byteBuffer, j8, 4);
        return ((long) byteBuffer.getInt()) & KeyboardMap.kValueMask;
    }

    public final long a(d dVar, long j8, long j9) {
        for (long j10 = 0; j10 < j8; j10++) {
            e eVarB = dVar.b(j10);
            if (eVarB.f23736a == 1) {
                long j11 = eVarB.f23738c;
                if (j11 <= j9 && j9 <= eVarB.f23739d + j11) {
                    return (j9 - j11) + eVarB.f23737b;
                }
            }
        }
        throw new IllegalStateException("Could not map vma to file offset!");
    }

    public d c() throws IOException {
        this.f23744b.position(0L);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(ByteOrder.LITTLE_ENDIAN);
        if (E(byteBufferAllocate, 0L) != 1179403647) {
            throw new IllegalArgumentException("Invalid ELF Magic!");
        }
        short sN = n(byteBufferAllocate, 4L);
        boolean z7 = n(byteBufferAllocate, 5L) == 2;
        if (sN == 1) {
            return new g(z7, this);
        }
        if (sN == 2) {
            return new h(z7, this);
        }
        throw new IllegalStateException("Invalid class type!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f23744b.close();
    }

    public List e() throws IOException {
        long j8;
        c cVarA;
        this.f23744b.position(0L);
        ArrayList arrayList = new ArrayList();
        d dVarC = c();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(dVarC.f23727a ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN);
        long j9 = dVarC.f23732f;
        int i8 = 0;
        if (j9 == 65535) {
            j9 = dVarC.c(0).f23740a;
        }
        long j10 = 0;
        while (true) {
            if (j10 >= j9) {
                j8 = 0;
                break;
            }
            e eVarB = dVarC.b(j10);
            if (eVarB.f23736a == 2) {
                j8 = eVarB.f23737b;
                break;
            }
            j10++;
        }
        if (j8 == 0) {
            return Collections.unmodifiableList(arrayList);
        }
        ArrayList arrayList2 = new ArrayList();
        long j11 = 0;
        do {
            cVarA = dVarC.a(j8, i8);
            long j12 = cVarA.f23725a;
            if (j12 == 1) {
                arrayList2.add(Long.valueOf(cVarA.f23726b));
            } else if (j12 == 5) {
                j11 = cVarA.f23726b;
            }
            i8++;
        } while (cVarA.f23725a != 0);
        if (j11 == 0) {
            throw new IllegalStateException("String table offset not found!");
        }
        long jA = a(dVarC, j9, j11);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(D(byteBufferAllocate, ((Long) it.next()).longValue() + jA));
        }
        return arrayList;
    }

    public void f(ByteBuffer byteBuffer, long j8, int i8) throws IOException {
        byteBuffer.position(0);
        byteBuffer.limit(i8);
        long j9 = 0;
        while (j9 < i8) {
            int i9 = this.f23744b.read(byteBuffer, j8 + j9);
            if (i9 == -1) {
                throw new EOFException();
            }
            j9 += (long) i9;
        }
        byteBuffer.position(0);
    }

    public short n(ByteBuffer byteBuffer, long j8) throws IOException {
        f(byteBuffer, j8, 1);
        return (short) (byteBuffer.get() & 255);
    }

    public int r(ByteBuffer byteBuffer, long j8) throws IOException {
        f(byteBuffer, j8, 2);
        return byteBuffer.getShort() & 65535;
    }
}
