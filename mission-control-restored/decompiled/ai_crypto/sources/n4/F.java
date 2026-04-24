package n4;

import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;
import l4.AbstractC2177j;
import l4.C2178k;
import t4.C2657a;

/* JADX INFO: loaded from: classes.dex */
public abstract class F {
    public static AbstractC2177j a(C2657a c2657a) {
        boolean z7;
        try {
            try {
                c2657a.M0();
                z7 = false;
                try {
                    return (AbstractC2177j) o4.p.f20166V.c(c2657a);
                } catch (EOFException e7) {
                    e = e7;
                    if (z7) {
                        return l4.l.f18379a;
                    }
                    throw new l4.q(e);
                }
            } catch (EOFException e8) {
                e = e8;
                z7 = true;
            }
        } catch (NumberFormatException e9) {
            throw new l4.q(e9);
        } catch (t4.d e10) {
            throw new l4.q(e10);
        } catch (IOException e11) {
            throw new C2178k(e11);
        }
    }

    public static void b(AbstractC2177j abstractC2177j, t4.c cVar) {
        o4.p.f20166V.e(cVar, abstractC2177j);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }

    public static final class b extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Appendable f19637a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f19638b = new a();

        public static class a implements CharSequence {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public char[] f19639a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f19640b;

            public a() {
            }

            public void a(char[] cArr) {
                this.f19639a = cArr;
                this.f19640b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i7) {
                return this.f19639a[i7];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f19639a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i7, int i8) {
                return new String(this.f19639a, i7, i8 - i7);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f19640b == null) {
                    this.f19640b = new String(this.f19639a);
                }
                return this.f19640b;
            }
        }

        public b(Appendable appendable) {
            this.f19637a = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i7, int i8) throws IOException {
            this.f19638b.a(cArr);
            this.f19637a.append(this.f19638b, i7, i8 + i7);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.f19637a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(int i7) throws IOException {
            this.f19637a.append((char) i7);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i7, int i8) throws IOException {
            this.f19637a.append(charSequence, i7, i8);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i7, int i8) throws IOException {
            Objects.requireNonNull(str);
            this.f19637a.append(str, i7, i8 + i7);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }
    }
}
