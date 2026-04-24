package V2;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class k implements R4.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ long f3282b;

    public /* synthetic */ k(int i, long j4) {
        this.f3281a = i;
        this.f3282b = j4;
    }

    @Override // R4.l
    public final Object invoke(Object obj) {
        switch (this.f3281a) {
            case 0:
                ((T.b) obj).e(l.f3283b, Long.valueOf(this.f3282b));
                return null;
            default:
                if (((G4.h) obj).f532a instanceof G4.g) {
                    Log.e("PigeonProxyApiRegistrar", "Failed to remove Dart strong reference with identifier: " + this.f3282b);
                }
                return G4.l.f540a;
        }
    }
}
