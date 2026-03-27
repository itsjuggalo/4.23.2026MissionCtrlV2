package d5;

/* JADX INFO: loaded from: classes.dex */
public final class t implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6016a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.s f6017b;

    public /* synthetic */ t(kotlin.jvm.internal.s sVar, int i) {
        this.f6016a = i;
        this.f6017b = sVar;
    }

    @Override // d5.f
    public final Object c(Object obj, I4.d dVar) {
        switch (this.f6016a) {
            case 0:
                this.f6017b.f7934a = obj;
                throw new e5.a(this);
            default:
                this.f6017b.f7934a = obj;
                throw new e5.a(this);
        }
    }
}
