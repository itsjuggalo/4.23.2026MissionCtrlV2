package o3;

import java.io.PrintWriter;
import java.io.StringWriter;
import o3.InterfaceC2461d;

/* JADX INFO: renamed from: o3.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2460c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC2461d f21930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f21931b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f21932c;

    public C2460c(InterfaceC2461d interfaceC2461d, String str) {
        this(interfaceC2461d, str, null);
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
            this.f21930a.b(InterfaceC2461d.a.DEBUG, this.f21931b, strH, g());
        }
    }

    public void b(String str, Object... objArr) {
        a(str, null, objArr);
    }

    public void c(String str, Throwable th) {
        this.f21930a.b(InterfaceC2461d.a.ERROR, this.f21931b, h(str, new Object[0]) + "\n" + d(th), g());
    }

    public void e(String str) {
        this.f21930a.b(InterfaceC2461d.a.INFO, this.f21931b, h(str, new Object[0]), g());
    }

    public boolean f() {
        return this.f21930a.a().ordinal() <= InterfaceC2461d.a.DEBUG.ordinal();
    }

    public final long g() {
        return System.currentTimeMillis();
    }

    public final String h(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        if (this.f21932c == null) {
            return str;
        }
        return this.f21932c + " - " + str;
    }

    public void i(String str) {
        j(str, null);
    }

    public void j(String str, Throwable th) {
        String strH = h(str, new Object[0]);
        if (th != null) {
            strH = strH + "\n" + d(th);
        }
        this.f21930a.b(InterfaceC2461d.a.WARN, this.f21931b, strH, g());
    }

    public C2460c(InterfaceC2461d interfaceC2461d, String str, String str2) {
        this.f21930a = interfaceC2461d;
        this.f21931b = str;
        this.f21932c = str2;
    }
}
