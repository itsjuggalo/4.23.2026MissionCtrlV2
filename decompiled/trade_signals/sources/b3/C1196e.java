package b3;

import java.util.Stack;

/* JADX INFO: renamed from: b3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1196e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f12890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f12891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StackTraceElement[] f12892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C1196e f12893d;

    public C1196e(String str, String str2, StackTraceElement[] stackTraceElementArr, C1196e c1196e) {
        this.f12890a = str;
        this.f12891b = str2;
        this.f12892c = stackTraceElementArr;
        this.f12893d = c1196e;
    }

    public static C1196e a(Throwable th, InterfaceC1195d interfaceC1195d) {
        Stack stack = new Stack();
        while (th != null) {
            stack.push(th);
            th = th.getCause();
        }
        C1196e c1196e = null;
        while (!stack.isEmpty()) {
            Throwable th2 = (Throwable) stack.pop();
            c1196e = new C1196e(th2.getLocalizedMessage(), th2.getClass().getName(), interfaceC1195d.a(th2.getStackTrace()), c1196e);
        }
        return c1196e;
    }
}
