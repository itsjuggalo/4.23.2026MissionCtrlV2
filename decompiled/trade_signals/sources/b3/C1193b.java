package b3;

/* JADX INFO: renamed from: b3.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1193b implements InterfaceC1195d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12888a;

    public C1193b(int i8) {
        this.f12888a = i8;
    }

    @Override // b3.InterfaceC1195d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        int length = stackTraceElementArr.length;
        int i8 = this.f12888a;
        if (length <= i8) {
            return stackTraceElementArr;
        }
        int i9 = i8 / 2;
        int i10 = i8 - i9;
        StackTraceElement[] stackTraceElementArr2 = new StackTraceElement[i8];
        System.arraycopy(stackTraceElementArr, 0, stackTraceElementArr2, 0, i10);
        System.arraycopy(stackTraceElementArr, stackTraceElementArr.length - i9, stackTraceElementArr2, i10, i9);
        return stackTraceElementArr2;
    }
}
