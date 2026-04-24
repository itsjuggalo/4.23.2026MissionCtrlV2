package androidx.emoji2.text;

import P.l;
import S.g;
import android.graphics.Typeface;
import android.util.SparseArray;
import h0.h;
import h0.j;
import i0.C1908b;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1908b f11520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char[] f11521b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f11522c = new a(1024);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Typeface f11523d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray f11524a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j f11525b;

        public a() {
            this(1);
        }

        public a a(int i8) {
            SparseArray sparseArray = this.f11524a;
            if (sparseArray == null) {
                return null;
            }
            return (a) sparseArray.get(i8);
        }

        public final j b() {
            return this.f11525b;
        }

        public void c(j jVar, int i8, int i9) {
            a aVarA = a(jVar.b(i8));
            if (aVarA == null) {
                aVarA = new a();
                this.f11524a.put(jVar.b(i8), aVarA);
            }
            if (i9 > i8) {
                aVarA.c(jVar, i8 + 1, i9);
            } else {
                aVarA.f11525b = jVar;
            }
        }

        public a(int i8) {
            this.f11524a = new SparseArray(i8);
        }
    }

    public f(Typeface typeface, C1908b c1908b) {
        this.f11523d = typeface;
        this.f11520a = c1908b;
        this.f11521b = new char[c1908b.k() * 2];
        a(c1908b);
    }

    public static f b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            l.a("EmojiCompat.MetadataRepo.create");
            return new f(typeface, h.b(byteBuffer));
        } finally {
            l.b();
        }
    }

    public final void a(C1908b c1908b) {
        int iK = c1908b.k();
        for (int i8 = 0; i8 < iK; i8++) {
            j jVar = new j(this, i8);
            Character.toChars(jVar.f(), this.f11521b, i8 * 2);
            h(jVar);
        }
    }

    public char[] c() {
        return this.f11521b;
    }

    public C1908b d() {
        return this.f11520a;
    }

    public int e() {
        return this.f11520a.l();
    }

    public a f() {
        return this.f11522c;
    }

    public Typeface g() {
        return this.f11523d;
    }

    public void h(j jVar) {
        g.e(jVar, "emoji metadata cannot be null");
        g.a(jVar.c() > 0, "invalid metadata codepoint length");
        this.f11522c.c(jVar, 0, jVar.c() - 1);
    }
}
