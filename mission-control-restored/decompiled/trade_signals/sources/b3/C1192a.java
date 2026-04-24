package b3;

/* JADX INFO: renamed from: b3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1192a implements InterfaceC1195d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC1195d[] f12886b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C1193b f12887c;

    public C1192a(int i8, InterfaceC1195d... interfaceC1195dArr) {
        this.f12885a = i8;
        this.f12886b = interfaceC1195dArr;
        this.f12887c = new C1193b(i8);
    }

    @Override // b3.InterfaceC1195d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f12885a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArrA = stackTraceElementArr;
        for (InterfaceC1195d interfaceC1195d : this.f12886b) {
            if (stackTraceElementArrA.length <= this.f12885a) {
                break;
            }
            stackTraceElementArrA = interfaceC1195d.a(stackTraceElementArr);
        }
        return stackTraceElementArrA.length > this.f12885a ? this.f12887c.a(stackTraceElementArrA) : stackTraceElementArrA;
    }
}
