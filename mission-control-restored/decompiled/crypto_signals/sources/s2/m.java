package s2;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Locale;
import q2.AbstractC0928g;

/* JADX INFO: loaded from: classes.dex */
public final class m implements InterfaceC1001d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Charset f9566c = Charset.forName("UTF-8");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final File f9567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public l f9568b;

    public m(File file) {
        this.f9567a = file;
    }

    @Override // s2.InterfaceC1001d
    public final void a() {
        AbstractC0928g.b(this.f9568b, "There was a problem closing the Crashlytics log file.");
        this.f9568b = null;
    }

    public final void b() {
        File file = this.f9567a;
        if (this.f9568b == null) {
            try {
                this.f9568b = new l(file);
            } catch (IOException e) {
                Log.e("FirebaseCrashlytics", "Could not open log file: " + file, e);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x000a  */
    @Override // s2.InterfaceC1001d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String c() {
        /*
            r7 = this;
            java.io.File r0 = r7.f9567a
            boolean r0 = r0.exists()
            r1 = 0
            r2 = 0
            if (r0 != 0) goto Lc
        La:
            r4 = r1
            goto L38
        Lc:
            r7.b()
            s2.l r0 = r7.f9568b
            if (r0 != 0) goto L14
            goto La
        L14:
            int[] r3 = new int[]{r2}
            int r0 = r0.n()
            byte[] r0 = new byte[r0]
            s2.l r4 = r7.f9568b     // Catch: java.io.IOException -> L29
            s2.f r5 = new s2.f     // Catch: java.io.IOException -> L29
            r5.<init>(r0, r3)     // Catch: java.io.IOException -> L29
            r4.g(r5)     // Catch: java.io.IOException -> L29
            goto L31
        L29:
            r4 = move-exception
            java.lang.String r5 = "FirebaseCrashlytics"
            java.lang.String r6 = "A problem occurred while reading the Crashlytics log file."
            android.util.Log.e(r5, r6, r4)
        L31:
            A.k r4 = new A.k
            r3 = r3[r2]
            r4.<init>(r0, r3)
        L38:
            if (r4 != 0) goto L3c
            r3 = r1
            goto L47
        L3c:
            int r0 = r4.f29b
            byte[] r3 = new byte[r0]
            java.lang.Object r4 = r4.f30c
            byte[] r4 = (byte[]) r4
            java.lang.System.arraycopy(r4, r2, r3, r2, r0)
        L47:
            if (r3 == 0) goto L51
            java.lang.String r0 = new java.lang.String
            java.nio.charset.Charset r1 = s2.m.f9566c
            r0.<init>(r3, r1)
            return r0
        L51:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: s2.m.c():java.lang.String");
    }

    @Override // s2.InterfaceC1001d
    public final void e(String str, long j4) {
        b();
        if (this.f9568b == null) {
            return;
        }
        if (str == null) {
            str = "null";
        }
        try {
            if (str.length() > 16384) {
                str = "..." + str.substring(str.length() - 16384);
            }
            this.f9568b.d(String.format(Locale.US, "%d %s%n", Long.valueOf(j4), str.replaceAll("\r", " ").replaceAll("\n", " ")).getBytes(f9566c));
            while (!this.f9568b.h() && this.f9568b.n() > 65536) {
                this.f9568b.k();
            }
        } catch (IOException e) {
            Log.e("FirebaseCrashlytics", "There was a problem writing to the Crashlytics log.", e);
        }
    }
}
