package s2;

import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;
import y2.C1946a;

/* JADX INFO: loaded from: classes.dex */
public abstract class F {
    public static q2.j a(C1946a c1946a) {
        boolean z4;
        try {
            try {
                c1946a.r0();
                z4 = false;
            } catch (EOFException e4) {
                e = e4;
                z4 = true;
            }
            try {
                return (q2.j) t2.p.f14857V.c(c1946a);
            } catch (EOFException e5) {
                e = e5;
                if (z4) {
                    return q2.l.f14271a;
                }
                throw new q2.q(e);
            }
        } catch (NumberFormatException e6) {
            throw new q2.q(e6);
        } catch (y2.d e7) {
            throw new q2.q(e7);
        } catch (IOException e8) {
            throw new q2.k(e8);
        }
    }

    public static void b(q2.j jVar, y2.c cVar) {
        t2.p.f14857V.e(cVar, jVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }

    public static final class b extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Appendable f14608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f14609b = new a();

        public static class a implements CharSequence {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public char[] f14610a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f14611b;

            public a() {
            }

            public void a(char[] cArr) {
                this.f14610a = cArr;
                this.f14611b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i4) {
                return this.f14610a[i4];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f14610a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i4, int i5) {
                return new String(this.f14610a, i4, i5 - i4);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f14611b == null) {
                    this.f14611b = new String(this.f14610a);
                }
                return this.f14611b;
            }
        }

        public b(Appendable appendable) {
            this.f14608a = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i4, int i5) throws IOException {
            this.f14609b.a(cArr);
            this.f14608a.append(this.f14609b, i4, i5 + i4);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.f14608a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(int i4) throws IOException {
            this.f14608a.append((char) i4);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i4, int i5) throws IOException {
            this.f14608a.append(charSequence, i4, i5);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i4, int i5) throws IOException {
            Objects.requireNonNull(str);
            this.f14608a.append(str, i4, i5 + i4);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }
    }
}
