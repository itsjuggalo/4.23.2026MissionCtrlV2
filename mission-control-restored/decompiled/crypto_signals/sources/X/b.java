package X;

import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class b extends InputStream implements DataInput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DataInputStream f3354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3355b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ByteOrder f3356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public byte[] f3357d;
    public final int e;

    public b(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), ByteOrder.BIG_ENDIAN);
        this.e = bArr.length;
    }

    @Override // java.io.InputStream
    public final int available() {
        return this.f3354a.available();
    }

    public final void d(int i) throws IOException {
        int i6 = 0;
        while (i6 < i) {
            DataInputStream dataInputStream = this.f3354a;
            int i7 = i - i6;
            int iSkip = (int) dataInputStream.skip(i7);
            if (iSkip <= 0) {
                if (this.f3357d == null) {
                    this.f3357d = new byte[8192];
                }
                iSkip = dataInputStream.read(this.f3357d, 0, Math.min(8192, i7));
                if (iSkip == -1) {
                    throw new EOFException(a3.d.i("Reached EOF while skipping ", i, " bytes."));
                }
            }
            i6 += iSkip;
        }
        this.f3355b += i6;
    }

    @Override // java.io.InputStream
    public final void mark(int i) {
        throw new UnsupportedOperationException("Mark is currently unsupported");
    }

    @Override // java.io.InputStream
    public final int read() {
        this.f3355b++;
        return this.f3354a.read();
    }

    @Override // java.io.DataInput
    public final boolean readBoolean() {
        this.f3355b++;
        return this.f3354a.readBoolean();
    }

    @Override // java.io.DataInput
    public final byte readByte() throws IOException {
        this.f3355b++;
        int i = this.f3354a.read();
        if (i >= 0) {
            return (byte) i;
        }
        throw new EOFException();
    }

    @Override // java.io.DataInput
    public final char readChar() {
        this.f3355b += 2;
        return this.f3354a.readChar();
    }

    @Override // java.io.DataInput
    public final double readDouble() {
        return Double.longBitsToDouble(readLong());
    }

    @Override // java.io.DataInput
    public final float readFloat() {
        return Float.intBitsToFloat(readInt());
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr, int i, int i6) throws IOException {
        this.f3355b += i6;
        this.f3354a.readFully(bArr, i, i6);
    }

    @Override // java.io.DataInput
    public final int readInt() throws IOException {
        this.f3355b += 4;
        DataInputStream dataInputStream = this.f3354a;
        int i = dataInputStream.read();
        int i6 = dataInputStream.read();
        int i7 = dataInputStream.read();
        int i8 = dataInputStream.read();
        if ((i | i6 | i7 | i8) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f3356c;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (i8 << 24) + (i7 << 16) + (i6 << 8) + i;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (i << 24) + (i6 << 16) + (i7 << 8) + i8;
        }
        throw new IOException("Invalid byte order: " + this.f3356c);
    }

    @Override // java.io.DataInput
    public final String readLine() {
        Log.d("ExifInterface", "Currently unsupported");
        return null;
    }

    @Override // java.io.DataInput
    public final long readLong() throws IOException {
        long j4;
        long j6;
        this.f3355b += 8;
        DataInputStream dataInputStream = this.f3354a;
        int i = dataInputStream.read();
        int i6 = dataInputStream.read();
        int i7 = dataInputStream.read();
        int i8 = dataInputStream.read();
        int i9 = dataInputStream.read();
        int i10 = dataInputStream.read();
        int i11 = dataInputStream.read();
        int i12 = dataInputStream.read();
        if ((i | i6 | i7 | i8 | i9 | i10 | i11 | i12) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f3356c;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            j4 = (((long) i12) << 56) + (((long) i11) << 48) + (((long) i10) << 40) + (((long) i9) << 32) + (((long) i8) << 24) + (((long) i7) << 16) + (((long) i6) << 8);
            j6 = i;
        } else {
            if (byteOrder != ByteOrder.BIG_ENDIAN) {
                throw new IOException("Invalid byte order: " + this.f3356c);
            }
            j4 = (((long) i) << 56) + (((long) i6) << 48) + (((long) i7) << 40) + (((long) i8) << 32) + (((long) i9) << 24) + (((long) i10) << 16) + (((long) i11) << 8);
            j6 = i12;
        }
        return j4 + j6;
    }

    @Override // java.io.DataInput
    public final short readShort() throws IOException {
        this.f3355b += 2;
        DataInputStream dataInputStream = this.f3354a;
        int i = dataInputStream.read();
        int i6 = dataInputStream.read();
        if ((i | i6) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f3356c;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (short) ((i6 << 8) + i);
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (short) ((i << 8) + i6);
        }
        throw new IOException("Invalid byte order: " + this.f3356c);
    }

    @Override // java.io.DataInput
    public final String readUTF() {
        this.f3355b += 2;
        return this.f3354a.readUTF();
    }

    @Override // java.io.DataInput
    public final int readUnsignedByte() {
        this.f3355b++;
        return this.f3354a.readUnsignedByte();
    }

    @Override // java.io.DataInput
    public final int readUnsignedShort() throws IOException {
        this.f3355b += 2;
        DataInputStream dataInputStream = this.f3354a;
        int i = dataInputStream.read();
        int i6 = dataInputStream.read();
        if ((i | i6) < 0) {
            throw new EOFException();
        }
        ByteOrder byteOrder = this.f3356c;
        if (byteOrder == ByteOrder.LITTLE_ENDIAN) {
            return (i6 << 8) + i;
        }
        if (byteOrder == ByteOrder.BIG_ENDIAN) {
            return (i << 8) + i6;
        }
        throw new IOException("Invalid byte order: " + this.f3356c);
    }

    @Override // java.io.InputStream
    public final void reset() {
        throw new UnsupportedOperationException("Reset is currently unsupported");
    }

    @Override // java.io.DataInput
    public final int skipBytes(int i) {
        throw new UnsupportedOperationException("skipBytes is currently unsupported");
    }

    public b(InputStream inputStream) {
        this(inputStream, ByteOrder.BIG_ENDIAN);
    }

    @Override // java.io.InputStream
    public final int read(byte[] bArr, int i, int i6) throws IOException {
        int i7 = this.f3354a.read(bArr, i, i6);
        this.f3355b += i7;
        return i7;
    }

    @Override // java.io.DataInput
    public final void readFully(byte[] bArr) throws IOException {
        this.f3355b += bArr.length;
        this.f3354a.readFully(bArr);
    }

    public b(InputStream inputStream, ByteOrder byteOrder) {
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        this.f3354a = dataInputStream;
        dataInputStream.mark(0);
        this.f3355b = 0;
        this.f3356c = byteOrder;
        this.e = inputStream instanceof b ? ((b) inputStream).e : -1;
    }
}
