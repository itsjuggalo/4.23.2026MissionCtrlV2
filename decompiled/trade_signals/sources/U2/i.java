package U2;

import S2.AbstractC0903j;
import U2.h;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class i implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f8132d = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f8133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f8135c;

    public class a implements h.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f8136a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f8137b;

        public a(byte[] bArr, int[] iArr) {
            this.f8136a = bArr;
            this.f8137b = iArr;
        }

        @Override // U2.h.d
        public void a(InputStream inputStream, int i8) throws IOException {
            try {
                inputStream.read(this.f8136a, this.f8137b[0], i8);
                int[] iArr = this.f8137b;
                iArr[0] = iArr[0] + i8;
            } finally {
                inputStream.close();
            }
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f8139a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f8140b;

        public b(byte[] bArr, int i8) {
            this.f8139a = bArr;
            this.f8140b = i8;
        }
    }

    public i(File file, int i8) {
        this.f8133a = file;
        this.f8134b = i8;
    }

    @Override // U2.d
    public void a() {
        AbstractC0903j.f(this.f8135c, "There was a problem closing the Crashlytics log file.");
        this.f8135c = null;
    }

    @Override // U2.d
    public String b() {
        byte[] bArrC = c();
        if (bArrC != null) {
            return new String(bArrC, f8132d);
        }
        return null;
    }

    @Override // U2.d
    public byte[] c() {
        b bVarG = g();
        if (bVarG == null) {
            return null;
        }
        int i8 = bVarG.f8140b;
        byte[] bArr = new byte[i8];
        System.arraycopy(bVarG.f8139a, 0, bArr, 0, i8);
        return bArr;
    }

    @Override // U2.d
    public void d() {
        a();
        this.f8133a.delete();
    }

    @Override // U2.d
    public void e(long j8, String str) {
        h();
        f(j8, str);
    }

    public final void f(long j8, String str) {
        if (this.f8135c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i8 = this.f8134b / 4;
            if (str.length() > i8) {
                str = "..." + str.substring(str.length() - i8);
            }
            this.f8135c.n(String.format(Locale.US, "%d %s%n", Long.valueOf(j8), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f8132d));
            while (!this.f8135c.M() && this.f8135c.i0() > this.f8134b) {
                this.f8135c.U();
            }
        } catch (IOException e8) {
            P2.g.f().e("There was a problem writing to the Crashlytics log.", e8);
        }
    }

    public final b g() {
        if (!this.f8133a.exists()) {
            return null;
        }
        h();
        h hVar = this.f8135c;
        if (hVar == null) {
            return null;
        }
        int[] iArr = {0};
        byte[] bArr = new byte[hVar.i0()];
        try {
            this.f8135c.E(new a(bArr, iArr));
        } catch (IOException e8) {
            P2.g.f().e("A problem occurred while reading the Crashlytics log file.", e8);
        }
        return new b(bArr, iArr[0]);
    }

    public final void h() {
        if (this.f8135c == null) {
            try {
                this.f8135c = new h(this.f8133a);
            } catch (IOException e8) {
                P2.g.f().e("Could not open log file: " + this.f8133a, e8);
            }
        }
    }
}
