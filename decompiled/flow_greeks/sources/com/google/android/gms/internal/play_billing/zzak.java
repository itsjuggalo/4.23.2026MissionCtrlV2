package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class zzak extends zzap implements zzam {
    public zzak(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    @Override // com.google.android.gms.internal.play_billing.zzam
    public final int zza(int i10, String str, String str2) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(3);
        parcelZzs.writeString(str);
        parcelZzs.writeString(str2);
        Parcel parcelZzt = zzt(5, parcelZzs);
        int i11 = parcelZzt.readInt();
        parcelZzt.recycle();
        return i11;
    }

    @Override // com.google.android.gms.internal.play_billing.zzam
    public final int zzc(int i10, String str, String str2, Bundle bundle) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(i10);
        parcelZzs.writeString(str);
        parcelZzs.writeString(str2);
        zzar.zzc(parcelZzs, bundle);
        Parcel parcelZzt = zzt(10, parcelZzs);
        int i11 = parcelZzt.readInt();
        parcelZzt.recycle();
        return i11;
    }

    @Override // com.google.android.gms.internal.play_billing.zzam
    public final Bundle zzd(int i10, String str, String str2, Bundle bundle) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(9);
        parcelZzs.writeString(str);
        parcelZzs.writeString(str2);
        zzar.zzc(parcelZzs, bundle);
        Parcel parcelZzt = zzt(902, parcelZzs);
        Bundle bundle2 = (Bundle) zzar.zza(parcelZzt, Bundle.CREATOR);
        parcelZzt.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzam
    public final Bundle zze(int i10, String str, String str2, Bundle bundle) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(9);
        parcelZzs.writeString(str);
        parcelZzs.writeString(str2);
        zzar.zzc(parcelZzs, bundle);
        Parcel parcelZzt = zzt(12, parcelZzs);
        Bundle bundle2 = (Bundle) zzar.zza(parcelZzt, Bundle.CREATOR);
        parcelZzt.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzam
    public final Bundle zzf(int i10, String str, String str2, String str3, String str4) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(3);
        parcelZzs.writeString(str);
        parcelZzs.writeString(str2);
        parcelZzs.writeString(str3);
        parcelZzs.writeString(null);
        Parcel parcelZzt = zzt(3, parcelZzs);
        Bundle bundle = (Bundle) zzar.zza(parcelZzt, Bundle.CREATOR);
        parcelZzt.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzam
    public final Bundle zzg(int i10, String str, String str2, String str3, String str4, Bundle bundle) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(i10);
        parcelZzs.writeString(str);
        parcelZzs.writeString(str2);
        parcelZzs.writeString(str3);
        parcelZzs.writeString(null);
        zzar.zzc(parcelZzs, bundle);
        Parcel parcelZzt = zzt(8, parcelZzs);
        Bundle bundle2 = (Bundle) zzar.zza(parcelZzt, Bundle.CREATOR);
        parcelZzt.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzam
    public final Bundle zzh(int i10, String str, String str2, String str3) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(3);
        parcelZzs.writeString(str);
        parcelZzs.writeString(str2);
        parcelZzs.writeString(str3);
        Parcel parcelZzt = zzt(4, parcelZzs);
        Bundle bundle = (Bundle) zzar.zza(parcelZzt, Bundle.CREATOR);
        parcelZzt.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzam
    public final Bundle zzi(int i10, String str, String str2, String str3, Bundle bundle) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(i10);
        parcelZzs.writeString(str);
        parcelZzs.writeString(str2);
        parcelZzs.writeString(str3);
        zzar.zzc(parcelZzs, bundle);
        Parcel parcelZzt = zzt(11, parcelZzs);
        Bundle bundle2 = (Bundle) zzar.zza(parcelZzt, Bundle.CREATOR);
        parcelZzt.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzam
    public final Bundle zzj(int i10, String str, String str2, Bundle bundle, Bundle bundle2) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(i10);
        parcelZzs.writeString(str);
        parcelZzs.writeString(str2);
        zzar.zzc(parcelZzs, bundle);
        zzar.zzc(parcelZzs, bundle2);
        Parcel parcelZzt = zzt(901, parcelZzs);
        Bundle bundle3 = (Bundle) zzar.zza(parcelZzt, Bundle.CREATOR);
        parcelZzt.recycle();
        return bundle3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzam
    public final void zzk(int i10, String str, Bundle bundle, zzx zzxVar) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(21);
        parcelZzs.writeString(str);
        zzar.zzc(parcelZzs, bundle);
        parcelZzs.writeStrongBinder(zzxVar);
        zzv(1501, parcelZzs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzam
    public final void zzl(int i10, String str, Bundle bundle, zzz zzzVar) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(22);
        parcelZzs.writeString(str);
        zzar.zzc(parcelZzs, bundle);
        parcelZzs.writeStrongBinder(zzzVar);
        zzv(1801, parcelZzs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzam
    public final void zzm(int i10, String str, Bundle bundle, zzab zzabVar) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(21);
        parcelZzs.writeString(str);
        zzar.zzc(parcelZzs, bundle);
        parcelZzs.writeStrongBinder(zzabVar);
        zzv(1601, parcelZzs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzam
    public final void zzn(int i10, String str, Bundle bundle, zzad zzadVar) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(18);
        parcelZzs.writeString(str);
        zzar.zzc(parcelZzs, bundle);
        parcelZzs.writeStrongBinder(zzadVar);
        zzu(1301, parcelZzs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzam
    public final void zzo(int i10, String str, Bundle bundle, zzaf zzafVar) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(22);
        parcelZzs.writeString(str);
        zzar.zzc(parcelZzs, bundle);
        parcelZzs.writeStrongBinder(zzafVar);
        zzv(1901, parcelZzs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzam
    public final void zzp(int i10, String str, Bundle bundle, zzah zzahVar) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(21);
        parcelZzs.writeString(str);
        zzar.zzc(parcelZzs, bundle);
        parcelZzs.writeStrongBinder(zzahVar);
        zzv(1401, parcelZzs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzam
    public final void zzq(int i10, String str, Bundle bundle, zzaj zzajVar) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(24);
        parcelZzs.writeString(str);
        zzar.zzc(parcelZzs, bundle);
        parcelZzs.writeStrongBinder(zzajVar);
        zzv(1701, parcelZzs);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzam
    public final void zzr(int i10, String str, Bundle bundle, zzao zzaoVar) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(12);
        parcelZzs.writeString(str);
        zzar.zzc(parcelZzs, bundle);
        parcelZzs.writeStrongBinder(zzaoVar);
        zzu(1201, parcelZzs);
    }

    @Override // com.google.android.gms.internal.play_billing.zzam
    public final int zzw(int i10, String str, String str2) {
        Parcel parcelZzs = zzs();
        parcelZzs.writeInt(i10);
        parcelZzs.writeString(str);
        parcelZzs.writeString(str2);
        Parcel parcelZzt = zzt(1, parcelZzs);
        int i11 = parcelZzt.readInt();
        parcelZzt.recycle();
        return i11;
    }
}
