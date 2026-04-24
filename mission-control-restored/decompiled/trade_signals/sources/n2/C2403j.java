package n2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: renamed from: n2.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C2403j extends AbstractC2394a implements InterfaceC2405l {
    public C2403j(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.appupdate.protocol.IAppUpdateService");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n2.InterfaceC2405l
    public final void d(String str, Bundle bundle, InterfaceC2407n interfaceC2407n) {
        Parcel parcelD = D();
        parcelD.writeString(str);
        AbstractC2402i.c(parcelD, bundle);
        parcelD.writeStrongBinder(interfaceC2407n);
        E(2, parcelD);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // n2.InterfaceC2405l
    public final void h(String str, Bundle bundle, InterfaceC2407n interfaceC2407n) {
        Parcel parcelD = D();
        parcelD.writeString(str);
        AbstractC2402i.c(parcelD, bundle);
        parcelD.writeStrongBinder(interfaceC2407n);
        E(3, parcelD);
    }
}
