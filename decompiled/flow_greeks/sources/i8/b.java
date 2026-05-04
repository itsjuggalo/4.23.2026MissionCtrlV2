package i8;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class b extends Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f11856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f11857b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11858c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11860e = this.f11858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11859d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f11861f = this.f11859d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f11862g = false;

    public b() {
        this.f11856a = null;
        this.f11856a = new ArrayList();
    }

    public void C() {
        if (this.f11862g) {
            throw new IllegalStateException("Trying to freeze frozen StringListReader");
        }
        this.f11862g = true;
    }

    public void b(String str) {
        if (this.f11862g) {
            throw new IllegalStateException("Trying to add string after reading");
        }
        if (str.length() > 0) {
            this.f11856a.add(str);
        }
    }

    public final long c(long j10) {
        long j11 = 0;
        while (this.f11859d < this.f11856a.size() && j11 < j10) {
            long j12 = j10 - j11;
            long jU = u();
            if (j12 < jU) {
                this.f11858c = (int) (((long) this.f11858c) + j12);
                j11 += j12;
            } else {
                j11 += jU;
                this.f11858c = 0;
                this.f11859d++;
            }
        }
        return j11;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        e();
        this.f11857b = true;
    }

    public final void e() throws IOException {
        if (this.f11857b) {
            throw new IOException("Stream already closed");
        }
        if (!this.f11862g) {
            throw new IOException("Reader needs to be frozen before read operations can be called");
        }
    }

    @Override // java.io.Reader
    public void mark(int i10) throws IOException {
        e();
        this.f11860e = this.f11858c;
        this.f11861f = this.f11859d;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    public final String o() {
        if (this.f11859d < this.f11856a.size()) {
            return (String) this.f11856a.get(this.f11859d);
        }
        return null;
    }

    @Override // java.io.Reader, java.lang.Readable
    public int read(CharBuffer charBuffer) throws IOException {
        e();
        int iRemaining = charBuffer.remaining();
        String strO = o();
        int i10 = 0;
        while (iRemaining > 0 && strO != null) {
            int iMin = Math.min(strO.length() - this.f11858c, iRemaining);
            String str = (String) this.f11856a.get(this.f11859d);
            int i11 = this.f11858c;
            charBuffer.put(str, i11, i11 + iMin);
            iRemaining -= iMin;
            i10 += iMin;
            c(iMin);
            strO = o();
        }
        if (i10 > 0 || strO != null) {
            return i10;
        }
        return -1;
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        e();
        return true;
    }

    @Override // java.io.Reader
    public void reset() {
        this.f11858c = this.f11860e;
        this.f11859d = this.f11861f;
    }

    @Override // java.io.Reader
    public long skip(long j10) throws IOException {
        e();
        return c(j10);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Iterator it = this.f11856a.iterator();
        while (it.hasNext()) {
            sb2.append((String) it.next());
        }
        return sb2.toString();
    }

    public final int u() {
        String strO = o();
        if (strO == null) {
            return 0;
        }
        return strO.length() - this.f11858c;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        e();
        String strO = o();
        if (strO == null) {
            return -1;
        }
        char cCharAt = strO.charAt(this.f11858c);
        c(1L);
        return cCharAt;
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i10, int i11) throws IOException {
        e();
        String strO = o();
        int i12 = 0;
        while (strO != null && i12 < i11) {
            int iMin = Math.min(u(), i11 - i12);
            int i13 = this.f11858c;
            strO.getChars(i13, i13 + iMin, cArr, i10 + i12);
            i12 += iMin;
            c(iMin);
            strO = o();
        }
        if (i12 > 0 || strO != null) {
            return i12;
        }
        return -1;
    }
}
