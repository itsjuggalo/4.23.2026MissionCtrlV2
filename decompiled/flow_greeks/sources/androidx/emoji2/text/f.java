package androidx.emoji2.text;

import android.graphics.Typeface;
import android.util.SparseArray;
import java.nio.ByteBuffer;
import p0.k;
import q1.g;
import q1.i;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r1.b f2014a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final char[] f2015b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f2016c = new a(1024);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Typeface f2017d;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final SparseArray f2018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public i f2019b;

        public a() {
            this(1);
        }

        public a a(int i10) {
            SparseArray sparseArray = this.f2018a;
            if (sparseArray == null) {
                return null;
            }
            return (a) sparseArray.get(i10);
        }

        public final i b() {
            return this.f2019b;
        }

        public void c(i iVar, int i10, int i11) {
            a aVarA = a(iVar.b(i10));
            if (aVarA == null) {
                aVarA = new a();
                this.f2018a.put(iVar.b(i10), aVarA);
            }
            if (i11 > i10) {
                aVarA.c(iVar, i10 + 1, i11);
            } else {
                aVarA.f2019b = iVar;
            }
        }

        public a(int i10) {
            this.f2018a = new SparseArray(i10);
        }
    }

    public f(Typeface typeface, r1.b bVar) {
        this.f2017d = typeface;
        this.f2014a = bVar;
        this.f2015b = new char[bVar.k() * 2];
        a(bVar);
    }

    public static f b(Typeface typeface, ByteBuffer byteBuffer) {
        try {
            k.a("EmojiCompat.MetadataRepo.create");
            return new f(typeface, g.b(byteBuffer));
        } finally {
            k.b();
        }
    }

    public final void a(r1.b bVar) {
        int iK = bVar.k();
        for (int i10 = 0; i10 < iK; i10++) {
            i iVar = new i(this, i10);
            Character.toChars(iVar.f(), this.f2015b, i10 * 2);
            h(iVar);
        }
    }

    public char[] c() {
        return this.f2015b;
    }

    public r1.b d() {
        return this.f2014a;
    }

    public int e() {
        return this.f2014a.l();
    }

    public a f() {
        return this.f2016c;
    }

    public Typeface g() {
        return this.f2017d;
    }

    public void h(i iVar) {
        s0.f.e(iVar, "emoji metadata cannot be null");
        s0.f.a(iVar.c() > 0, "invalid metadata codepoint length");
        this.f2016c.c(iVar, 0, iVar.c() - 1);
    }
}
