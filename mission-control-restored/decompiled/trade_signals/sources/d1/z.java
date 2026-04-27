package d1;

import android.os.Build;
import android.os.ParcelFileDescriptor;

/* JADX INFO: loaded from: classes.dex */
public final class z implements U0.j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f16838a;

    public z(r rVar) {
        this.f16838a = rVar;
    }

    @Override // U0.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public W0.v a(ParcelFileDescriptor parcelFileDescriptor, int i8, int i9, U0.h hVar) {
        return this.f16838a.d(parcelFileDescriptor, i8, i9, hVar);
    }

    @Override // U0.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean b(ParcelFileDescriptor parcelFileDescriptor, U0.h hVar) {
        return e(parcelFileDescriptor) && this.f16838a.o(parcelFileDescriptor);
    }

    public final boolean e(ParcelFileDescriptor parcelFileDescriptor) {
        String str = Build.MANUFACTURER;
        return !("HUAWEI".equalsIgnoreCase(str) || "HONOR".equalsIgnoreCase(str)) || parcelFileDescriptor.getStatSize() <= 536870912;
    }
}
