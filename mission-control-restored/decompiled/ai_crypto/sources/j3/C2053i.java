package j3;

import e3.C1478g;
import h3.AbstractC1695i;
import j3.C2052h;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: renamed from: j3.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2053i implements InterfaceC2048d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f17410d = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f17411a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f17412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public C2052h f17413c;

    /* JADX INFO: renamed from: j3.i$a */
    public class a implements C2052h.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f17414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f17415b;

        public a(byte[] bArr, int[] iArr) {
            this.f17414a = bArr;
            this.f17415b = iArr;
        }

        @Override // j3.C2052h.d
        public void a(InputStream inputStream, int i7) throws IOException {
            try {
                inputStream.read(this.f17414a, this.f17415b[0], i7);
                int[] iArr = this.f17415b;
                iArr[0] = iArr[0] + i7;
            } finally {
                inputStream.close();
            }
        }
    }

    /* JADX INFO: renamed from: j3.i$b */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f17417a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f17418b;

        public b(byte[] bArr, int i7) {
            this.f17417a = bArr;
            this.f17418b = i7;
        }
    }

    public C2053i(File file, int i7) {
        this.f17411a = file;
        this.f17412b = i7;
    }

    @Override // j3.InterfaceC2048d
    public void a() {
        AbstractC1695i.f(this.f17413c, "There was a problem closing the Crashlytics log file.");
        this.f17413c = null;
    }

    @Override // j3.InterfaceC2048d
    public String b() {
        byte[] bArrC = c();
        if (bArrC != null) {
            return new String(bArrC, f17410d);
        }
        return null;
    }

    @Override // j3.InterfaceC2048d
    public byte[] c() {
        b bVarG = g();
        if (bVarG == null) {
            return null;
        }
        int i7 = bVarG.f17418b;
        byte[] bArr = new byte[i7];
        System.arraycopy(bVarG.f17417a, 0, bArr, 0, i7);
        return bArr;
    }

    @Override // j3.InterfaceC2048d
    public void d() {
        a();
        this.f17411a.delete();
    }

    @Override // j3.InterfaceC2048d
    public void e(long j7, String str) {
        h();
        f(j7, str);
    }

    public final void f(long j7, String str) {
        if (this.f17413c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i7 = this.f17412b / 4;
            if (str.length() > i7) {
                str = "..." + str.substring(str.length() - i7);
            }
            this.f17413c.H(String.format(Locale.US, "%d %s%n", Long.valueOf(j7), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f17410d));
            while (!this.f17413c.X() && this.f17413c.G0() > this.f17412b) {
                this.f17413c.C0();
            }
        } catch (IOException e7) {
            C1478g.f().e("There was a problem writing to the Crashlytics log.", e7);
        }
    }

    public final b g() {
        if (!this.f17411a.exists()) {
            return null;
        }
        h();
        C2052h c2052h = this.f17413c;
        if (c2052h == null) {
            return null;
        }
        int[] iArr = {0};
        byte[] bArr = new byte[c2052h.G0()];
        try {
            this.f17413c.T(new a(bArr, iArr));
        } catch (IOException e7) {
            C1478g.f().e("A problem occurred while reading the Crashlytics log file.", e7);
        }
        return new b(bArr, iArr[0]);
    }

    public final void h() {
        if (this.f17413c == null) {
            try {
                this.f17413c = new C2052h(this.f17411a);
            } catch (IOException e7) {
                C1478g.f().e("Could not open log file: " + this.f17411a, e7);
            }
        }
    }
}
