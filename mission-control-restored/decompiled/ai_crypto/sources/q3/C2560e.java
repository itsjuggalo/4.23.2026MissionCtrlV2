package q3;

import java.util.Stack;

/* JADX INFO: renamed from: q3.e, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2560e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f22329a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f22330b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StackTraceElement[] f22331c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C2560e f22332d;

    public C2560e(String str, String str2, StackTraceElement[] stackTraceElementArr, C2560e c2560e) {
        this.f22329a = str;
        this.f22330b = str2;
        this.f22331c = stackTraceElementArr;
        this.f22332d = c2560e;
    }

    public static C2560e a(Throwable th, InterfaceC2559d interfaceC2559d) {
        Stack stack = new Stack();
        while (th != null) {
            stack.push(th);
            th = th.getCause();
        }
        C2560e c2560e = null;
        while (!stack.isEmpty()) {
            Throwable th2 = (Throwable) stack.pop();
            c2560e = new C2560e(th2.getLocalizedMessage(), th2.getClass().getName(), interfaceC2559d.a(th2.getStackTrace()), c2560e);
        }
        return c2560e;
    }
}
