package L5;

import R5.InterfaceC0845b;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: L5.y, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes2.dex */
public class C0694y implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final InterfaceC0845b f5255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5256b;

    public C0694y(InterfaceC0845b interfaceC0845b, int i8) {
        this.f5255a = interfaceC0845b;
        this.f5256b = i8;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return A.w(this.f5255a, this.f5256b);
    }
}
