package R3;

import java.io.Serializable;
import java.io.Writer;

/* JADX INFO: loaded from: classes3.dex */
public class a extends Writer implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f3569a;

    public a(int i4) {
        this.f3569a = new StringBuilder(i4);
    }

    public String toString() {
        return this.f3569a.toString();
    }

    @Override // java.io.Writer
    public void write(String str) {
        if (str != null) {
            this.f3569a.append(str);
        }
    }

    @Override // java.io.Writer
    public void write(char[] cArr, int i4, int i5) {
        if (cArr != null) {
            this.f3569a.append(cArr, i4, i5);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(char c4) {
        this.f3569a.append(c4);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence) {
        this.f3569a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public Writer append(CharSequence charSequence, int i4, int i5) {
        this.f3569a.append(charSequence, i4, i5);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public void flush() {
    }
}
