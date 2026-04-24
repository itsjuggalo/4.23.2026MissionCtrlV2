package kotlin.jvm.internal;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y extends C implements X5.h {
    public y(Object obj, Class cls, String str, String str2, int i7) {
        super(obj, cls, str, str2, i7);
    }

    @Override // kotlin.jvm.internal.AbstractC2143e
    public X5.b computeReflected() {
        return H.e(this);
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return get();
    }
}
