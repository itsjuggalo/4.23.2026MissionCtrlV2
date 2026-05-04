package com.google.gson.internal;

import com.google.gson.internal.bind.TypeAdapters;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e0 {
    public static com.google.gson.i a(gb.a aVar) {
        boolean z10;
        try {
            try {
                aVar.n0();
                z10 = false;
            } catch (EOFException e10) {
                e = e10;
                z10 = true;
            }
            try {
                return (com.google.gson.i) TypeAdapters.V.c(aVar);
            } catch (EOFException e11) {
                e = e11;
                if (z10) {
                    return com.google.gson.k.f6876a;
                }
                throw new com.google.gson.p(e);
            }
        } catch (gb.d e12) {
            throw new com.google.gson.p(e12);
        } catch (IOException e13) {
            throw new com.google.gson.j(e13);
        } catch (NumberFormatException e14) {
            throw new com.google.gson.p(e14);
        }
    }

    public static void b(com.google.gson.i iVar, gb.c cVar) {
        TypeAdapters.V.e(cVar, iVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class b extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Appendable f6814a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f6815b = new a();

        /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
        public static class a implements CharSequence {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public char[] f6816a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f6817b;

            public a() {
            }

            public void a(char[] cArr) {
                this.f6816a = cArr;
                this.f6817b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i10) {
                return this.f6816a[i10];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f6816a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i10, int i11) {
                return new String(this.f6816a, i10, i11 - i10);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f6817b == null) {
                    this.f6817b = new String(this.f6816a);
                }
                return this.f6817b;
            }
        }

        public b(Appendable appendable) {
            this.f6814a = appendable;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i10, int i11) throws IOException {
            this.f6815b.a(cArr);
            this.f6814a.append(this.f6815b, i10, i11 + i10);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.f6814a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(int i10) throws IOException {
            this.f6814a.append((char) i10);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i10, int i11) throws IOException {
            this.f6814a.append(charSequence, i10, i11);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i10, int i11) throws IOException {
            Objects.requireNonNull(str);
            this.f6814a.append(str, i10, i11 + i10);
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }
    }
}
