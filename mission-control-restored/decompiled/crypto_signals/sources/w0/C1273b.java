package w0;

import android.os.Build;

/* JADX INFO: renamed from: w0.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C1273b extends AbstractC1274c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f10699d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C1273b(String str, int i, String str2) {
        super(str, str2);
        this.f10699d = i;
    }

    @Override // w0.AbstractC1274c
    public final boolean a() {
        switch (this.f10699d) {
            case 0:
                return true;
            case 1:
                return true;
            case 2:
                return false;
            case 3:
                return Build.VERSION.SDK_INT >= 26;
            case 4:
                return Build.VERSION.SDK_INT >= 27;
            case 5:
                return Build.VERSION.SDK_INT >= 28;
            default:
                return Build.VERSION.SDK_INT >= 29;
        }
    }
}
