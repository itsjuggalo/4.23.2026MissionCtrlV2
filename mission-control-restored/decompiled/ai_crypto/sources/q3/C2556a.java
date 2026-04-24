package q3;

/* JADX INFO: renamed from: q3.a, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2556a implements InterfaceC2559d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f22324a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC2559d[] f22325b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C2557b f22326c;

    public C2556a(int i7, InterfaceC2559d... interfaceC2559dArr) {
        this.f22324a = i7;
        this.f22325b = interfaceC2559dArr;
        this.f22326c = new C2557b(i7);
    }

    @Override // q3.InterfaceC2559d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f22324a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArrA = stackTraceElementArr;
        for (InterfaceC2559d interfaceC2559d : this.f22325b) {
            if (stackTraceElementArrA.length <= this.f22324a) {
                break;
            }
            stackTraceElementArrA = interfaceC2559d.a(stackTraceElementArr);
        }
        return stackTraceElementArrA.length > this.f22324a ? this.f22326c.a(stackTraceElementArrA) : stackTraceElementArrA;
    }
}
