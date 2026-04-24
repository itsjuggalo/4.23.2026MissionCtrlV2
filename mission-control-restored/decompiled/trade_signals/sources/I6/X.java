package I6;

import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes2.dex */
public class X implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final J6.g f4400a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Y f4401b;

    public X(J6.g gVar, Y y7) {
        this.f4400a = gVar;
        this.f4401b = y7;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return Y.W0(this.f4400a, this.f4401b);
    }
}
