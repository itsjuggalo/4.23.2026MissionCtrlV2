package gf;

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class d implements Iterable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f10630a = new o(new byte[0]);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public interface a extends Iterator {
        byte a();
    }

    public static d a(Iterator it, int i10) {
        if (i10 == 1) {
            return (d) it.next();
        }
        int i11 = i10 >>> 1;
        return a(it, i11).c(a(it, i10 - i11));
    }

    public static d d(Iterable iterable) {
        Collection arrayList;
        if (iterable instanceof Collection) {
            arrayList = (Collection) iterable;
        } else {
            arrayList = new ArrayList();
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                arrayList.add((d) it.next());
            }
        }
        return arrayList.isEmpty() ? f10630a : a(arrayList.iterator(), arrayList.size());
    }

    public static d e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    public static d f(byte[] bArr, int i10, int i11) {
        byte[] bArr2 = new byte[i11];
        System.arraycopy(bArr, i10, bArr2, 0, i11);
        return new o(bArr2);
    }

    public static d g(String str) {
        try {
            return new o(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported?", e10);
        }
    }

    public static b v() {
        return new b(128);
    }

    public abstract int A();

    public byte[] G() {
        int size = size();
        if (size == 0) {
            return j.f10685a;
        }
        byte[] bArr = new byte[size];
        q(bArr, 0, 0, size);
        return bArr;
    }

    public abstract String K(String str);

    public String L() {
        try {
            return K("UTF-8");
        } catch (UnsupportedEncodingException e10) {
            throw new RuntimeException("UTF-8 not supported?", e10);
        }
    }

    public void R(OutputStream outputStream, int i10, int i11) {
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Source offset < 0: ");
            sb2.append(i10);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i11 < 0) {
            StringBuilder sb3 = new StringBuilder(23);
            sb3.append("Length < 0: ");
            sb3.append(i11);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        int i12 = i10 + i11;
        if (i12 <= size()) {
            if (i11 > 0) {
                S(outputStream, i10, i11);
            }
        } else {
            StringBuilder sb4 = new StringBuilder(39);
            sb4.append("Source end offset exceeded: ");
            sb4.append(i12);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
    }

    public abstract void S(OutputStream outputStream, int i10, int i11);

    public d c(d dVar) {
        int size = size();
        int size2 = dVar.size();
        if (((long) size) + ((long) size2) < 2147483647L) {
            return t.W(this, dVar);
        }
        StringBuilder sb2 = new StringBuilder(53);
        sb2.append("ByteString would be too long: ");
        sb2.append(size);
        sb2.append("+");
        sb2.append(size2);
        throw new IllegalArgumentException(sb2.toString());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void p(byte[] bArr, int i10, int i11, int i12) {
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(30);
            sb2.append("Source offset < 0: ");
            sb2.append(i10);
            throw new IndexOutOfBoundsException(sb2.toString());
        }
        if (i11 < 0) {
            StringBuilder sb3 = new StringBuilder(30);
            sb3.append("Target offset < 0: ");
            sb3.append(i11);
            throw new IndexOutOfBoundsException(sb3.toString());
        }
        if (i12 < 0) {
            StringBuilder sb4 = new StringBuilder(23);
            sb4.append("Length < 0: ");
            sb4.append(i12);
            throw new IndexOutOfBoundsException(sb4.toString());
        }
        int i13 = i10 + i12;
        if (i13 > size()) {
            StringBuilder sb5 = new StringBuilder(34);
            sb5.append("Source end offset < 0: ");
            sb5.append(i13);
            throw new IndexOutOfBoundsException(sb5.toString());
        }
        int i14 = i11 + i12;
        if (i14 <= bArr.length) {
            if (i12 > 0) {
                q(bArr, i10, i11, i12);
            }
        } else {
            StringBuilder sb6 = new StringBuilder(34);
            sb6.append("Target end offset < 0: ");
            sb6.append(i14);
            throw new IndexOutOfBoundsException(sb6.toString());
        }
    }

    public abstract void q(byte[] bArr, int i10, int i11, int i12);

    public abstract int r();

    public abstract boolean s();

    public abstract int size();

    public String toString() {
        return String.format("<ByteString@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()));
    }

    public abstract boolean u();

    public abstract int w(int i10, int i11, int i12);

    public abstract int y(int i10, int i11, int i12);

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends OutputStream {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final byte[] f10631f = new byte[0];

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f10632a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList f10633b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f10634c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public byte[] f10635d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public int f10636e;

        public b(int i10) {
            if (i10 < 0) {
                throw new IllegalArgumentException("Buffer size < 0");
            }
            this.f10632a = i10;
            this.f10633b = new ArrayList();
            this.f10635d = new byte[i10];
        }

        public final byte[] b(byte[] bArr, int i10) {
            byte[] bArr2 = new byte[i10];
            System.arraycopy(bArr, 0, bArr2, 0, Math.min(bArr.length, i10));
            return bArr2;
        }

        public final void c(int i10) {
            this.f10633b.add(new o(this.f10635d));
            int length = this.f10634c + this.f10635d.length;
            this.f10634c = length;
            this.f10635d = new byte[Math.max(this.f10632a, Math.max(i10, length >>> 1))];
            this.f10636e = 0;
        }

        public final void e() {
            int i10 = this.f10636e;
            byte[] bArr = this.f10635d;
            if (i10 >= bArr.length) {
                this.f10633b.add(new o(this.f10635d));
                this.f10635d = f10631f;
            } else if (i10 > 0) {
                this.f10633b.add(new o(b(bArr, i10)));
            }
            this.f10634c += this.f10636e;
            this.f10636e = 0;
        }

        public synchronized int o() {
            return this.f10634c + this.f10636e;
        }

        public String toString() {
            return String.format("<ByteString.Output@%s size=%d>", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(o()));
        }

        public synchronized d u() {
            e();
            return d.d(this.f10633b);
        }

        @Override // java.io.OutputStream
        public synchronized void write(int i10) {
            try {
                if (this.f10636e == this.f10635d.length) {
                    c(1);
                }
                byte[] bArr = this.f10635d;
                int i11 = this.f10636e;
                this.f10636e = i11 + 1;
                bArr[i11] = (byte) i10;
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // java.io.OutputStream
        public synchronized void write(byte[] bArr, int i10, int i11) {
            try {
                byte[] bArr2 = this.f10635d;
                int length = bArr2.length;
                int i12 = this.f10636e;
                if (i11 <= length - i12) {
                    System.arraycopy(bArr, i10, bArr2, i12, i11);
                    this.f10636e += i11;
                } else {
                    int length2 = bArr2.length - i12;
                    System.arraycopy(bArr, i10, bArr2, i12, length2);
                    int i13 = i11 - length2;
                    c(i13);
                    System.arraycopy(bArr, i10 + length2, this.f10635d, 0, i13);
                    this.f10636e = i13;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
