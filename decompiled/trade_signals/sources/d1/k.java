package d1;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import q1.AbstractC2628k;

/* JADX INFO: loaded from: classes.dex */
public final class k implements ImageHeaderParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte[] f16784a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f16785b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f16786a;

        public a(ByteBuffer byteBuffer) {
            this.f16786a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // d1.k.c
        public int a() {
            return (c() << 8) | c();
        }

        @Override // d1.k.c
        public int b(byte[] bArr, int i8) {
            int iMin = Math.min(i8, this.f16786a.remaining());
            if (iMin == 0) {
                return -1;
            }
            this.f16786a.get(bArr, 0, iMin);
            return iMin;
        }

        @Override // d1.k.c
        public short c() throws c.a {
            if (this.f16786a.remaining() >= 1) {
                return (short) (this.f16786a.get() & 255);
            }
            throw new c.a();
        }

        @Override // d1.k.c
        public long skip(long j8) {
            int iMin = (int) Math.min(this.f16786a.remaining(), j8);
            ByteBuffer byteBuffer = this.f16786a;
            byteBuffer.position(byteBuffer.position() + iMin);
            return iMin;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ByteBuffer f16787a;

        public b(byte[] bArr, int i8) {
            this.f16787a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i8);
        }

        public short a(int i8) {
            if (c(i8, 2)) {
                return this.f16787a.getShort(i8);
            }
            return (short) -1;
        }

        public int b(int i8) {
            if (c(i8, 4)) {
                return this.f16787a.getInt(i8);
            }
            return -1;
        }

        public final boolean c(int i8, int i9) {
            return this.f16787a.remaining() - i8 >= i9;
        }

        public int d() {
            return this.f16787a.remaining();
        }

        public void e(ByteOrder byteOrder) {
            this.f16787a.order(byteOrder);
        }
    }

    public interface c {

        public static final class a extends IOException {
            public a() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a();

        int b(byte[] bArr, int i8);

        short c();

        long skip(long j8);
    }

    public static final class d implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final InputStream f16788a;

        public d(InputStream inputStream) {
            this.f16788a = inputStream;
        }

        @Override // d1.k.c
        public int a() {
            return (c() << 8) | c();
        }

        @Override // d1.k.c
        public int b(byte[] bArr, int i8) throws c.a {
            int i9 = 0;
            int i10 = 0;
            while (i9 < i8 && (i10 = this.f16788a.read(bArr, i9, i8 - i9)) != -1) {
                i9 += i10;
            }
            if (i9 == 0 && i10 == -1) {
                throw new c.a();
            }
            return i9;
        }

        @Override // d1.k.c
        public short c() throws IOException {
            int i8 = this.f16788a.read();
            if (i8 != -1) {
                return (short) i8;
            }
            throw new c.a();
        }

        @Override // d1.k.c
        public long skip(long j8) throws IOException {
            if (j8 < 0) {
                return 0L;
            }
            long j9 = j8;
            while (j9 > 0) {
                long jSkip = this.f16788a.skip(j9);
                if (jSkip <= 0) {
                    if (this.f16788a.read() == -1) {
                        break;
                    }
                    jSkip = 1;
                }
                j9 -= jSkip;
            }
            return j8 - j9;
        }
    }

    public static int e(int i8, int i9) {
        return i8 + 2 + (i9 * 12);
    }

    public static boolean h(int i8) {
        return (i8 & 65496) == 65496 || i8 == 19789 || i8 == 18761;
    }

    public static int k(b bVar) {
        ByteOrder byteOrder;
        StringBuilder sb;
        String str;
        String string;
        short sA = bVar.a(6);
        if (sA != 18761) {
            if (sA != 19789 && Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) sA));
            }
            byteOrder = ByteOrder.BIG_ENDIAN;
        } else {
            byteOrder = ByteOrder.LITTLE_ENDIAN;
        }
        bVar.e(byteOrder);
        int iB = bVar.b(10) + 6;
        short sA2 = bVar.a(iB);
        for (int i8 = 0; i8 < sA2; i8++) {
            int iE = e(iB, i8);
            short sA3 = bVar.a(iE);
            if (sA3 == 274) {
                short sA4 = bVar.a(iE + 2);
                if (sA4 >= 1 && sA4 <= 12) {
                    int iB2 = bVar.b(iE + 4);
                    if (iB2 >= 0) {
                        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            Log.d("DfltImageHeaderParser", "Got tagIndex=" + i8 + " tagType=" + ((int) sA3) + " formatCode=" + ((int) sA4) + " componentCount=" + iB2);
                        }
                        int i9 = iB2 + f16785b[sA4];
                        if (i9 <= 4) {
                            int i10 = iE + 8;
                            if (i10 >= 0 && i10 <= bVar.d()) {
                                if (i9 >= 0 && i9 + i10 <= bVar.d()) {
                                    return bVar.a(i10);
                                }
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    sb = new StringBuilder();
                                    sb.append("Illegal number of bytes for TI tag data tagType=");
                                    sb.append((int) sA3);
                                }
                            } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                string = "Illegal tagValueOffset=" + i10 + " tagType=" + ((int) sA3);
                                Log.d("DfltImageHeaderParser", string);
                            }
                        } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                            sb = new StringBuilder();
                            str = "Got byte count > 4, not orientation, continuing, formatCode=";
                            sb.append(str);
                            sb.append((int) sA4);
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        string = "Negative tiff component count";
                        Log.d("DfltImageHeaderParser", string);
                    }
                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    sb = new StringBuilder();
                    str = "Got invalid format code = ";
                    sb.append(str);
                    sb.append((int) sA4);
                }
                string = sb.toString();
                Log.d("DfltImageHeaderParser", string);
            }
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        return g(new a((ByteBuffer) AbstractC2628k.d(byteBuffer)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int b(InputStream inputStream, X0.b bVar) {
        return f(new d((InputStream) AbstractC2628k.d(inputStream)), (X0.b) AbstractC2628k.d(bVar));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType c(InputStream inputStream) {
        return g(new d((InputStream) AbstractC2628k.d(inputStream)));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int d(ByteBuffer byteBuffer, X0.b bVar) {
        return f(new a((ByteBuffer) AbstractC2628k.d(byteBuffer)), (X0.b) AbstractC2628k.d(bVar));
    }

    public final int f(c cVar, X0.b bVar) {
        try {
            int iA = cVar.a();
            if (!h(iA)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + iA);
                }
                return -1;
            }
            int iJ = j(cVar);
            if (iJ == -1) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                }
                return -1;
            }
            byte[] bArr = (byte[]) bVar.e(iJ, byte[].class);
            try {
                return l(cVar, bArr, iJ);
            } finally {
                bVar.d(bArr);
            }
        } catch (c.a unused) {
            return -1;
        }
    }

    public final ImageHeaderParser.ImageType g(c cVar) {
        try {
            int iA = cVar.a();
            if (iA == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int iC = (iA << 8) | cVar.c();
            if (iC == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int iC2 = (iC << 8) | cVar.c();
            if (iC2 == -1991225785) {
                cVar.skip(21L);
                try {
                    return cVar.c() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (c.a unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            }
            if (iC2 != 1380533830) {
                return m(cVar, iC2);
            }
            cVar.skip(4L);
            if (((cVar.a() << 16) | cVar.a()) != 1464156752) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int iA2 = (cVar.a() << 16) | cVar.a();
            if ((iA2 & (-256)) != 1448097792) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            }
            int i8 = iA2 & 255;
            if (i8 == 88) {
                cVar.skip(4L);
                short sC = cVar.c();
                return (sC & 2) != 0 ? ImageHeaderParser.ImageType.ANIMATED_WEBP : (sC & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
            }
            if (i8 != 76) {
                return ImageHeaderParser.ImageType.WEBP;
            }
            cVar.skip(4L);
            return (cVar.c() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
        } catch (c.a unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    public final boolean i(byte[] bArr, int i8) {
        boolean z7 = bArr != null && i8 > f16784a.length;
        if (z7) {
            int i9 = 0;
            while (true) {
                byte[] bArr2 = f16784a;
                if (i9 >= bArr2.length) {
                    break;
                }
                if (bArr[i9] != bArr2[i9]) {
                    return false;
                }
                i9++;
            }
        }
        return z7;
    }

    public final int j(c cVar) {
        short sC;
        int iA;
        long j8;
        long jSkip;
        do {
            short sC2 = cVar.c();
            if (sC2 != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) sC2));
                }
                return -1;
            }
            sC = cVar.c();
            if (sC == 218) {
                return -1;
            }
            if (sC == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            iA = cVar.a() - 2;
            if (sC == 225) {
                return iA;
            }
            j8 = iA;
            jSkip = cVar.skip(j8);
        } while (jSkip == j8);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to skip enough data, type: " + ((int) sC) + ", wanted to skip: " + iA + ", but actually skipped: " + jSkip);
        }
        return -1;
    }

    public final int l(c cVar, byte[] bArr, int i8) {
        int iB = cVar.b(bArr, i8);
        if (iB == i8) {
            if (i(bArr, i8)) {
                return k(new b(bArr, i8));
            }
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
            }
            return -1;
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i8 + ", actually read: " + iB);
        }
        return -1;
    }

    public final ImageHeaderParser.ImageType m(c cVar, int i8) {
        if (((cVar.a() << 16) | cVar.a()) != 1718909296) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        int iA = (cVar.a() << 16) | cVar.a();
        if (iA == 1635150195) {
            return ImageHeaderParser.ImageType.ANIMATED_AVIF;
        }
        int i9 = 0;
        boolean z7 = iA == 1635150182;
        cVar.skip(4L);
        int i10 = i8 - 16;
        if (i10 % 4 == 0) {
            while (i9 < 5 && i10 > 0) {
                int iA2 = (cVar.a() << 16) | cVar.a();
                if (iA2 == 1635150195) {
                    return ImageHeaderParser.ImageType.ANIMATED_AVIF;
                }
                if (iA2 == 1635150182) {
                    z7 = true;
                }
                i9++;
                i10 -= 4;
            }
        }
        return z7 ? ImageHeaderParser.ImageType.AVIF : ImageHeaderParser.ImageType.UNKNOWN;
    }
}
