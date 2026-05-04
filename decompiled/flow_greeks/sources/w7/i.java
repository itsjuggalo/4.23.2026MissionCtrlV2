package w7;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Locale;
import w7.h;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class i implements d {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Charset f23718d = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f23719a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f23720b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public h f23721c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public class a implements h.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ byte[] f23722a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int[] f23723b;

        public a(byte[] bArr, int[] iArr) {
            this.f23722a = bArr;
            this.f23723b = iArr;
        }

        @Override // w7.h.d
        public void a(InputStream inputStream, int i10) throws IOException {
            try {
                inputStream.read(this.f23722a, this.f23723b[0], i10);
                int[] iArr = this.f23723b;
                iArr[0] = iArr[0] + i10;
            } finally {
                inputStream.close();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f23725a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f23726b;

        public b(byte[] bArr, int i10) {
            this.f23725a = bArr;
            this.f23726b = i10;
        }
    }

    public i(File file, int i10) {
        this.f23719a = file;
        this.f23720b = i10;
    }

    @Override // w7.d
    public void a() {
        u7.i.f(this.f23721c, "There was a problem closing the Crashlytics log file.");
        this.f23721c = null;
    }

    @Override // w7.d
    public String b() {
        byte[] bArrC = c();
        if (bArrC != null) {
            return new String(bArrC, f23718d);
        }
        return null;
    }

    @Override // w7.d
    public byte[] c() {
        b bVarG = g();
        if (bVarG == null) {
            return null;
        }
        int i10 = bVarG.f23726b;
        byte[] bArr = new byte[i10];
        System.arraycopy(bVarG.f23725a, 0, bArr, 0, i10);
        return bArr;
    }

    @Override // w7.d
    public void d() {
        a();
        this.f23719a.delete();
    }

    @Override // w7.d
    public void e(long j10, String str) {
        h();
        f(j10, str);
    }

    public final void f(long j10, String str) {
        if (this.f23721c == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            int i10 = this.f23720b / 4;
            if (str.length() > i10) {
                str = "..." + str.substring(str.length() - i10);
            }
            this.f23721c.u(String.format(Locale.US, "%d %s%n", Long.valueOf(j10), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f23718d));
            while (!this.f23721c.N() && this.f23721c.h0() > this.f23720b) {
                this.f23721c.d0();
            }
        } catch (IOException e10) {
            r7.g.f().e("There was a problem writing to the Crashlytics log.", e10);
        }
    }

    public final b g() {
        if (!this.f23719a.exists()) {
            return null;
        }
        h();
        h hVar = this.f23721c;
        if (hVar == null) {
            return null;
        }
        int[] iArr = {0};
        byte[] bArr = new byte[hVar.h0()];
        try {
            this.f23721c.H(new a(bArr, iArr));
        } catch (IOException e10) {
            r7.g.f().e("A problem occurred while reading the Crashlytics log file.", e10);
        }
        return new b(bArr, iArr[0]);
    }

    public final void h() {
        if (this.f23721c == null) {
            try {
                this.f23721c = new h(this.f23719a);
            } catch (IOException e10) {
                r7.g.f().e("Could not open log file: " + this.f23719a, e10);
            }
        }
    }
}
