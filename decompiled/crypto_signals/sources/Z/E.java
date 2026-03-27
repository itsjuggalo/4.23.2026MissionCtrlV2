package Z;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class E implements q0.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3704a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3705b;

    public /* synthetic */ E(Object obj, int i) {
        this.f3704a = i;
        this.f3705b = obj;
    }

    @Override // q0.d
    public final Bundle a() {
        switch (this.f3704a) {
            case 0:
                return ((P) this.f3705b).W();
            default:
                return androidx.lifecycle.K.a((androidx.lifecycle.K) this.f3705b);
        }
    }
}
