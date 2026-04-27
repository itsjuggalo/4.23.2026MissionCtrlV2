package s4;

import android.webkit.ValueCallback;

/* JADX INFO: renamed from: s4.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class C1064k implements ValueCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9730a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ R4.l f9731b;

    public /* synthetic */ C1064k(R4.l lVar, int i) {
        this.f9730a = i;
        this.f9731b = lVar;
    }

    @Override // android.webkit.ValueCallback
    public final void onReceiveValue(Object obj) {
        switch (this.f9730a) {
            case 0:
                C1076x c1076x = (C1076x) this.f9731b;
                kotlin.jvm.internal.v.b(1, c1076x);
                c1076x.invoke(new G4.h((Boolean) obj));
                break;
            default:
                C1076x c1076x2 = (C1076x) this.f9731b;
                kotlin.jvm.internal.v.b(1, c1076x2);
                c1076x2.invoke(new G4.h((String) obj));
                break;
        }
    }
}
