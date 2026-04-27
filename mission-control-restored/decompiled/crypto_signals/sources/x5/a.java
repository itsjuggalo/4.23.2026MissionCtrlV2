package x5;

import java.io.Serializable;
import java.io.Writer;

/* JADX INFO: loaded from: classes.dex */
public final class a extends Writer implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final StringBuilder f11612a = new StringBuilder(4);

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(char c6) {
        this.f11612a.append(c6);
        return this;
    }

    public final String toString() {
        return this.f11612a.toString();
    }

    @Override // java.io.Writer
    public final void write(String str) {
        if (str != null) {
            this.f11612a.append(str);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(char c6) {
        this.f11612a.append(c6);
        return this;
    }

    @Override // java.io.Writer
    public final void write(char[] cArr, int i, int i6) {
        if (cArr != null) {
            this.f11612a.append(cArr, i, i6);
        }
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence) {
        this.f11612a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence) {
        this.f11612a.append(charSequence);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Writer append(CharSequence charSequence, int i, int i6) {
        this.f11612a.append(charSequence, i, i6);
        return this;
    }

    @Override // java.io.Writer, java.lang.Appendable
    public final Appendable append(CharSequence charSequence, int i, int i6) {
        this.f11612a.append(charSequence, i, i6);
        return this;
    }

    @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // java.io.Writer, java.io.Flushable
    public final void flush() {
    }
}
