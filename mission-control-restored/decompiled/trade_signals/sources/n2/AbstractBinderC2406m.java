package n2;

import android.os.Bundle;
import android.os.Parcel;

/* JADX INFO: renamed from: n2.m, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC2406m extends AbstractBinderC2401h implements InterfaceC2407n {
    public AbstractBinderC2406m() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    @Override // n2.AbstractBinderC2401h
    public final boolean D(int i8, Parcel parcel, Parcel parcel2, int i9) {
        if (i8 == 2) {
            Bundle bundle = (Bundle) AbstractC2402i.a(parcel, Bundle.CREATOR);
            AbstractC2402i.b(parcel);
            n(bundle);
            return true;
        }
        if (i8 != 3) {
            return false;
        }
        Bundle bundle2 = (Bundle) AbstractC2402i.a(parcel, Bundle.CREATOR);
        AbstractC2402i.b(parcel);
        zzb(bundle2);
        return true;
    }
}
