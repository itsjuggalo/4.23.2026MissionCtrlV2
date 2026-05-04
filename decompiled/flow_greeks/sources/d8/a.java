package d8;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f7833a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d[] f7834b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f7835c;

    public a(int i10, d... dVarArr) {
        this.f7833a = i10;
        this.f7834b = dVarArr;
        this.f7835c = new b(i10);
    }

    @Override // d8.d
    public StackTraceElement[] a(StackTraceElement[] stackTraceElementArr) {
        if (stackTraceElementArr.length <= this.f7833a) {
            return stackTraceElementArr;
        }
        StackTraceElement[] stackTraceElementArrA = stackTraceElementArr;
        for (d dVar : this.f7834b) {
            if (stackTraceElementArrA.length <= this.f7833a) {
                break;
            }
            stackTraceElementArrA = dVar.a(stackTraceElementArr);
        }
        return stackTraceElementArrA.length > this.f7833a ? this.f7835c.a(stackTraceElementArrA) : stackTraceElementArrA;
    }
}
