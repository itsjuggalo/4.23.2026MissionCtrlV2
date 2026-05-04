package xf;

import kotlin.jvm.functions.Function0;
import xf.p;

/* JADX INFO: loaded from: classes3.dex */
public class o implements Function0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p.a f25027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f25028b;

    public o(p.a aVar, p pVar) {
        this.f25027a = aVar;
        this.f25028b = pVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public Object invoke() {
        return p.a.i(this.f25027a, this.f25028b);
    }
}
