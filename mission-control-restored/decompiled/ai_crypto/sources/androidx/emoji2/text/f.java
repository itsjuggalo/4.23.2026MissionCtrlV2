package androidx.emoji2.text;

import M.n;
import android.graphics.Typeface;
import android.util.SparseArray;
import h0.h;
import i0.C1736b;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C1736b f7703a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char[] f7704b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f7705c = new a(1024);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Typeface f7706d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray f7707a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public h0.e f7708b;

        public a() {
            this(1);
        }

        public a a(int i7) {
            SparseArray sparseArray = this.f7707a;
            if (sparseArray == null) {
                return null;
            }
            return (a) sparseArray.get(i7);
        }

        public final h0.e b() {
            return this.f7708b;
        }

        public void c(h0.e eVar, int i7, int i8) {
            a aVarA = a(eVar.b(i7));
            if (aVarA == null) {
                aVarA = new a();
                this.f7707a.put(eVar.b(i7), aVarA);
            }
            if (i8 > i7) {
                aVarA.c(eVar, i7 + 1, i8);
            } else {
                aVarA.f7708b = eVar;
            }
        }

        public a(int i7) {
            this.f7707a = new SparseArray(i7);
        }
    }

    public f(Typeface typeface, C1736b c1736b) {
        this.f7706d = typeface;
        this.f7703a = c1736b;
        this.f7704b = new char[c1736b.k() * 2];
        a(c1736b);
    }

    public static f b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            n.a("EmojiCompat.MetadataRepo.create");
            return new f(typeface, h.b(byteBuffer));
        } finally {
            n.b();
        }
    }

    public final void a(C1736b c1736b) {
        int iK = c1736b.k();
        for (int i7 = 0; i7 < iK; i7++) {
            h0.e eVar = new h0.e(this, i7);
            Character.toChars(eVar.f(), this.f7704b, i7 * 2);
            h(eVar);
        }
    }

    public char[] c() {
        return this.f7704b;
    }

    public C1736b d() {
        return this.f7703a;
    }

    public int e() {
        return this.f7703a.l();
    }

    public a f() {
        return this.f7705c;
    }

    public Typeface g() {
        return this.f7706d;
    }

    public void h(h0.e eVar) {
        P.f.h(eVar, "emoji metadata cannot be null");
        P.f.a(eVar.c() > 0, "invalid metadata codepoint length");
        this.f7705c.c(eVar, 0, eVar.c() - 1);
    }
}
