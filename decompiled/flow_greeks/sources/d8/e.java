package d8;

import java.util.Stack;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7839b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StackTraceElement[] f7840c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e f7841d;

    public e(String str, String str2, StackTraceElement[] stackTraceElementArr, e eVar) {
        this.f7838a = str;
        this.f7839b = str2;
        this.f7840c = stackTraceElementArr;
        this.f7841d = eVar;
    }

    public static e a(Throwable th, d dVar) {
        Stack stack = new Stack();
        while (th != null) {
            stack.push(th);
            th = th.getCause();
        }
        e eVar = null;
        while (!stack.isEmpty()) {
            Throwable th2 = (Throwable) stack.pop();
            eVar = new e(th2.getLocalizedMessage(), th2.getClass().getName(), dVar.a(th2.getStackTrace()), eVar);
        }
        return eVar;
    }
}
