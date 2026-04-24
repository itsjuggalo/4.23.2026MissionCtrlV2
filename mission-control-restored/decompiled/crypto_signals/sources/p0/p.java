package p0;

import u5.C1250g;
import z2.InterfaceC1465a;

/* JADX INFO: loaded from: classes.dex */
public final class p implements InterfaceC1465a {
    public static final boolean a(u5.v vVar) {
        u5.v vVar2 = v5.d.f10660c;
        return !Y4.l.Q(vVar.b(), ".class", true);
    }

    public static x4.s b(int i) {
        return new x4.s(new C1250g(), Math.min(1048576, Math.max(4096, i)));
    }

    @Override // z2.InterfaceC1465a
    public StackTraceElement[] d(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= 1024) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[1024];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, 512);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - 512, stackTraceElementArr2, 512, 512);
        return stackTraceElementArr2;
    }
}
