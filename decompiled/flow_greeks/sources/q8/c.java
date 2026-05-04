package q8;

import java.io.PrintWriter;
import java.io.StringWriter;
import q8.d;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f18877a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f18878b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f18879c;

    public c(d dVar, String str) {
        this(dVar, str, null);
    }

    public static String d(Throwable th) {
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }

    public void a(String str, Throwable th, Object... objArr) {
        if (f()) {
            String strH = h(str, objArr);
            if (th != null) {
                strH = strH + "\n" + d(th);
            }
            this.f18877a.b(d.a.DEBUG, this.f18878b, strH, g());
        }
    }

    public void b(String str, Object... objArr) {
        a(str, null, objArr);
    }

    public void c(String str, Throwable th) {
        this.f18877a.b(d.a.ERROR, this.f18878b, h(str, new Object[0]) + "\n" + d(th), g());
    }

    public void e(String str) {
        this.f18877a.b(d.a.INFO, this.f18878b, h(str, new Object[0]), g());
    }

    public boolean f() {
        return this.f18877a.a().ordinal() <= d.a.DEBUG.ordinal();
    }

    public final long g() {
        return System.currentTimeMillis();
    }

    public final String h(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        if (this.f18879c == null) {
            return str;
        }
        return this.f18879c + " - " + str;
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, Throwable th) {
        String strH = h(str, new Object[0]);
        if (th != null) {
            strH = strH + "\n" + d(th);
        }
        this.f18877a.b(d.a.WARN, this.f18878b, strH, g());
    }

    public c(d dVar, String str, String str2) {
        this.f18877a = dVar;
        this.f18878b = str;
        this.f18879c = str2;
    }
}
