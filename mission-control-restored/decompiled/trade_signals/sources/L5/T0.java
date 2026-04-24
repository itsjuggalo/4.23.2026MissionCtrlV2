package L5;

import kotlin.jvm.functions.Function0;
import o5.InterfaceC2483k;

/* JADX INFO: loaded from: classes2.dex */
public class T0 implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final U0 f5094a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5095b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC2483k f5096c;

    public T0(U0 u02, int i8, InterfaceC2483k interfaceC2483k) {
        this.f5094a = u02;
        this.f5095b = i8;
        this.f5096c = interfaceC2483k;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return U0.v(this.f5094a, this.f5095b, this.f5096c);
    }
}
