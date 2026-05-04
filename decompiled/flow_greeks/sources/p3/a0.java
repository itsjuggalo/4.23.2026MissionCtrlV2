package p3;

import android.os.Build;
import android.os.ParcelFileDescriptor;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class a0 implements g3.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final p f18204a;

    public a0(p pVar) {
        this.f18204a = pVar;
    }

    @Override // g3.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public i3.v a(ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, g3.h hVar) {
        return this.f18204a.d(parcelFileDescriptor, i10, i11, hVar);
    }

    @Override // g3.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(ParcelFileDescriptor parcelFileDescriptor, g3.h hVar) {
        return e(parcelFileDescriptor) && this.f18204a.o(parcelFileDescriptor);
    }

    public final boolean e(ParcelFileDescriptor parcelFileDescriptor) {
        String str = Build.MANUFACTURER;
        return !("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912;
    }
}
