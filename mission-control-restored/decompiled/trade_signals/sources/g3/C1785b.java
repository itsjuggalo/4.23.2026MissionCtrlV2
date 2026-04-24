package g3;

import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: g3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1785b extends Reader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f18000a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f18001b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f18002c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f18004e = this.f18002c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f18003d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f18005f = this.f18003d;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f18006g = false;

    public C1785b() {
        this.f18000a = null;
        this.f18000a = new ArrayList();
    }

    public void a(String str) {
        if (this.f18006g) {
            throw new IllegalStateException("Trying to add string after reading");
        }
        if (str.length() > 0) {
            this.f18000a.add(str);
        }
    }

    public final long c(long j8) {
        long j9 = 0;
        while (this.f18003d < this.f18000a.size() && j9 < j8) {
            long j10 = j8 - j9;
            long jN = n();
            if (j10 < jN) {
                this.f18002c = (int) (((long) this.f18002c) + j10);
                j9 += j10;
            } else {
                j9 += jN;
                this.f18002c = 0;
                this.f18003d++;
            }
        }
        return j9;
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        e();
        this.f18001b = true;
    }

    public final void e() throws IOException {
        if (this.f18001b) {
            throw new IOException("Stream already closed");
        }
        if (!this.f18006g) {
            throw new IOException("Reader needs to be frozen before read operations can be called");
        }
    }

    public final String f() {
        if (this.f18003d < this.f18000a.size()) {
            return (String) this.f18000a.get(this.f18003d);
        }
        return null;
    }

    @Override // java.io.Reader
    public void mark(int i8) throws IOException {
        e();
        this.f18004e = this.f18002c;
        this.f18005f = this.f18003d;
    }

    @Override // java.io.Reader
    public boolean markSupported() {
        return true;
    }

    public final int n() {
        String strF = f();
        if (strF == null) {
            return 0;
        }
        return strF.length() - this.f18002c;
    }

    public void r() {
        if (this.f18006g) {
            throw new IllegalStateException("Trying to freeze frozen StringListReader");
        }
        this.f18006g = true;
    }

    @Override // java.io.Reader
    public int read() throws IOException {
        e();
        String strF = f();
        if (strF == null) {
            return -1;
        }
        char cCharAt = strF.charAt(this.f18002c);
        c(1L);
        return cCharAt;
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        e();
        return true;
    }

    @Override // java.io.Reader
    public void reset() {
        this.f18002c = this.f18004e;
        this.f18003d = this.f18005f;
    }

    @Override // java.io.Reader
    public long skip(long j8) throws IOException {
        e();
        return c(j8);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.f18000a.iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
        }
        return sb.toString();
    }

    @Override // java.io.Reader, java.lang.Readable
    public int read(CharBuffer charBuffer) throws IOException {
        e();
        int iRemaining = charBuffer.remaining();
        String strF = f();
        int i8 = 0;
        while (iRemaining > 0 && strF != null) {
            int iMin = Math.min(strF.length() - this.f18002c, iRemaining);
            String str = (String) this.f18000a.get(this.f18003d);
            int i9 = this.f18002c;
            charBuffer.put(str, i9, i9 + iMin);
            iRemaining -= iMin;
            i8 += iMin;
            c(iMin);
            strF = f();
        }
        if (i8 > 0 || strF != null) {
            return i8;
        }
        return -1;
    }

    @Override // java.io.Reader
    public int read(char[] cArr, int i8, int i9) throws IOException {
        e();
        String strF = f();
        int i10 = 0;
        while (strF != null && i10 < i9) {
            int iMin = Math.min(n(), i9 - i10);
            int i11 = this.f18002c;
            strF.getChars(i11, i11 + iMin, cArr, i8 + i10);
            i10 += iMin;
            c(iMin);
            strF = f();
        }
        if (i10 > 0 || strF != null) {
            return i10;
        }
        return -1;
    }
}
