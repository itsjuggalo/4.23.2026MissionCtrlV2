package com.google.gson.internal;

import com.google.gson.internal.bind.TypeAdapters;
import java.io.EOFException;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;
import p4.C2568a;
import p4.C2570c;
import p4.C2571d;

/* JADX INFO: loaded from: classes.dex */
public abstract class E {

    public static final class b extends Writer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Appendable f16016a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final a f16017b = new a();

        public static class a implements CharSequence {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public char[] f16018a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f16019b;

            public a() {
            }

            public void a(char[] cArr) {
                this.f16018a = cArr;
                this.f16019b = null;
            }

            @Override // java.lang.CharSequence
            public char charAt(int i8) {
                return this.f16018a[i8];
            }

            @Override // java.lang.CharSequence
            public int length() {
                return this.f16018a.length;
            }

            @Override // java.lang.CharSequence
            public CharSequence subSequence(int i8, int i9) {
                return new String(this.f16018a, i8, i9 - i8);
            }

            @Override // java.lang.CharSequence
            public String toString() {
                if (this.f16019b == null) {
                    this.f16019b = new String(this.f16018a);
                }
                return this.f16019b;
            }
        }

        public b(Appendable appendable) {
            this.f16016a = appendable;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) throws IOException {
            this.f16016a.append(charSequence);
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.io.Writer
        public void write(int i8) throws IOException {
            this.f16016a.append((char) i8);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i8, int i9) throws IOException {
            this.f16016a.append(charSequence, i8, i9);
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i8, int i9) throws IOException {
            Objects.requireNonNull(str);
            this.f16016a.append(str, i8, i9 + i8);
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i8, int i9) throws IOException {
            this.f16017b.a(cArr);
            this.f16016a.append(this.f16017b, i8, i9 + i8);
        }
    }

    public static com.google.gson.i a(C2568a c2568a) {
        boolean z7;
        try {
            try {
                c2568a.x0();
                z7 = false;
                try {
                    return (com.google.gson.i) TypeAdapters.f16143V.c(c2568a);
                } catch (EOFException e8) {
                    e = e8;
                    if (z7) {
                        return com.google.gson.k.f16252a;
                    }
                    throw new com.google.gson.p(e);
                }
            } catch (EOFException e9) {
                e = e9;
                z7 = true;
            }
        } catch (IOException e10) {
            throw new com.google.gson.j(e10);
        } catch (NumberFormatException e11) {
            throw new com.google.gson.p(e11);
        } catch (C2571d e12) {
            throw new com.google.gson.p(e12);
        }
    }

    public static void b(com.google.gson.i iVar, C2570c c2570c) {
        TypeAdapters.f16143V.e(c2570c, iVar);
    }

    public static Writer c(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new b(appendable);
    }
}
