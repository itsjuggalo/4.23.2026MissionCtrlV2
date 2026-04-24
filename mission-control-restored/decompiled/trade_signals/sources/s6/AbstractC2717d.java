package s6;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: renamed from: s6.d, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public abstract class AbstractC2717d implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AbstractC2717d f23128a = new o(new byte[0]);

    /* JADX INFO: renamed from: s6.d$a */
    public interface a extends Iterator {
        byte a();
    }

    /* JADX INFO: renamed from: s6.d$b */
    public static final class b extends OutputStream {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final byte[] f23129f = new byte[0];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f23130a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList f23131b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f23132c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f23133d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f23134e;

        public b(int i8) {
            if (i8 < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.f23130a = i8;
            this.f23131b = new ArrayList();
            this.f23133d = new byte[i8];
        }

        public final byte[] a(byte[] bArr, int i8) {
            byte[] bArr2 = new byte[i8];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i8));
            return bArr2;
        }

        public final void c(int i8) {
            this.f23131b.add(new o(this.f23133d));
            int length = this.f23132c + this.f23133d.length;
            this.f23132c = length;
            this.f23133d = new byte[Math.max(this.f23130a, Math.max(i8, length >>> 1))];
            this.f23134e = 0;
        }

        public final void e() {
            int i8 = this.f23134e;
            byte[] bArr = this.f23133d;
            if (i8 >= bArr.length) {
                this.f23131b.add(new o(this.f23133d));
                this.f23133d = f23129f;
            } else if (i8 > 0) {
                this.f23131b.add(new o(a(bArr, i8)));
            }
            this.f23132c += this.f23134e;
            this.f23134e = 0;
        }

        public synchronized int f() {
            return this.f23132c + this.f23134e;
        }

        public synchronized AbstractC2717d n() {
            e();
            return AbstractC2717d.e(this.f23131b);
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(f()));
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i8) {
            try {
                if (this.f23134e == this.f23133d.length) {
                    c(1);
                }
                byte[] bArr = this.f23133d;
                int i9 = this.f23134e;
                this.f23134e = i9 + 1;
                bArr[i9] = (byte) i8;
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i8, int i9) {
            try {
                byte[] bArr2 = this.f23133d;
                int length = bArr2.length;
                int i10 = this.f23134e;
                if (i9 <= length - i10) {
                    System.arraycopy(bArr, i8, bArr2, i10, i9);
                    this.f23134e += i9;
                } else {
                    int length2 = bArr2.length - i10;
                    System.arraycopy(bArr, i8, bArr2, i10, length2);
                    int i11 = i9 - length2;
                    c(i11);
                    System.arraycopy(bArr, i8 + length2, this.f23133d, 0, i11);
                    this.f23134e = i11;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static b K() {
        return new b(128);
    }

    public static AbstractC2717d a(Iterator it, int i8) {
        if (i8 == 1) {
            return (AbstractC2717d) it.next();
        }
        int i9 = i8 >>> 1;
        return a(it, i9).d(a(it, i8 - i9));
    }

    public static AbstractC2717d e(Iterable iterable) {
        Collection arrayList;
        if (iterable instanceof Collection) {
            arrayList = (Collection) iterable;
        } else {
            arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add((AbstractC2717d) it.next());
            }
        }
        return arrayList.isEmpty() ? f23128a : a(arrayList.iterator(), arrayList.size());
    }

    public static AbstractC2717d f(byte[] bArr) {
        return h(bArr, 0, bArr.length);
    }

    public static AbstractC2717d h(byte[] bArr, int i8, int i9) {
        byte[] bArr2 = new byte[i9];
        System.arraycopy(bArr, i8, bArr2, 0, i9);
        return new o(bArr2);
    }

    public static AbstractC2717d n(String str) {
        try {
            return new o(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e8) {
            throw new RuntimeException("UTF-8 not supported?", e8);
        }
    }

    public void C(byte[] bArr, int i8, int i9, int i10) {
        if (i8 < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i8);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i9 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Target offset < 0: ");
            sb2.append(i9);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i10 < 0) {
            StringBuilder sb3 = new StringBuilder(23);
            sb3.append("Length < 0: ");
            sb3.append(i10);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        int i11 = i8 + i10;
        if (i11 > size()) {
            StringBuilder sb4 = new StringBuilder(34);
            sb4.append("Source end offset < 0: ");
            sb4.append(i11);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
        int i12 = i9 + i10;
        if (i12 <= bArr.length) {
            if (i10 > 0) {
                F(bArr, i8, i9, i10);
            }
        } else {
            StringBuilder sb5 = new StringBuilder(34);
            sb5.append("Target end offset < 0: ");
            sb5.append(i12);
            throw new IndexOutOfBoundsException(sb5.toString());
        }
    }

    public abstract void F(byte[] bArr, int i8, int i9, int i10);

    public abstract int H();

    public abstract boolean I();

    public abstract boolean J();

    public abstract int L(int i8, int i9, int i10);

    public abstract int M(int i8, int i9, int i10);

    public abstract int N();

    public byte[] O() {
        int size = size();
        if (size == 0) {
            return AbstractC2723j.f23183a;
        }
        byte[] bArr = new byte[size];
        F(bArr, 0, 0, size);
        return bArr;
    }

    public abstract String P(String str);

    public String Q() {
        try {
            return P("UTF-8");
        } catch (UnsupportedEncodingException e8) {
            throw new RuntimeException("UTF-8 not supported?", e8);
        }
    }

    public void R(OutputStream outputStream, int i8, int i9) {
        if (i8 < 0) {
            StringBuilder sb = new StringBuilder(30);
            sb.append("Source offset < 0: ");
            sb.append(i8);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        if (i9 < 0) {
            StringBuilder sb2 = new StringBuilder(23);
            sb2.append("Length < 0: ");
            sb2.append(i9);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        int i10 = i8 + i9;
        if (i10 <= size()) {
            if (i9 > 0) {
                S(outputStream, i8, i9);
            }
        } else {
            StringBuilder sb3 = new StringBuilder(39);
            sb3.append("Source end offset exceeded: ");
            sb3.append(i10);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
    }

    public abstract void S(OutputStream outputStream, int i8, int i9);

    public AbstractC2717d d(AbstractC2717d abstractC2717d) {
        int size = size();
        int size2 = abstractC2717d.size();
        if (((long) size) + ((long) size2) < 2147483647L) {
            return t.W(this, abstractC2717d);
        }
        StringBuilder sb = new StringBuilder(53);
        sb.append("ByteString would be too long: ");
        sb.append(size);
        sb.append("+");
        sb.append(size2);
        throw new IllegalArgumentException(sb.toString());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public abstract int size();

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }
}
