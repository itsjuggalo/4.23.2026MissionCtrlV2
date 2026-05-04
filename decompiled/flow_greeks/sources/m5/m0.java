package m5;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15948a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f15950c;

    public /* synthetic */ m0(String str, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, byte[] bArr) {
        this.f15948a = str;
        this.f15949b = z10;
        this.f15950c = z13;
    }

    public final boolean a() {
        return this.f15950c;
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [android.os.IBinder, w5.a] */
    public final f0 b(Context context) {
        return new f0(this.f15948a, this.f15949b, false, w5.b.J(context), false, true, false);
    }
}
