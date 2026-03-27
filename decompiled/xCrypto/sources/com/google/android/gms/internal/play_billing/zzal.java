package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: loaded from: classes.dex */
public final class zzal extends zzaq implements zzan {
    public zzal(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final int zza(int i4, String str, String str2) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(3);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        Parcel parcelZzv = zzv(5, parcelZzu);
        int i5 = parcelZzv.readInt();
        parcelZzv.recycle();
        return i5;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final int zzc(int i4, String str, String str2, Bundle bundle) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i4);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzas.zzc(parcelZzu, bundle);
        Parcel parcelZzv = zzv(10, parcelZzu);
        int i5 = parcelZzv.readInt();
        parcelZzv.recycle();
        return i5;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zzd(int i4, String str, String str2, Bundle bundle) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(9);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzas.zzc(parcelZzu, bundle);
        Parcel parcelZzv = zzv(902, parcelZzu);
        Bundle bundle2 = (Bundle) zzas.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zze(int i4, String str, String str2, Bundle bundle) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(9);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzas.zzc(parcelZzu, bundle);
        Parcel parcelZzv = zzv(12, parcelZzu);
        Bundle bundle2 = (Bundle) zzas.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zzf(int i4, String str, String str2, String str3, String str4) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(3);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        parcelZzu.writeString(null);
        Parcel parcelZzv = zzv(3, parcelZzu);
        Bundle bundle = (Bundle) zzas.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zzg(int i4, String str, String str2, String str3, String str4, Bundle bundle) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i4);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        parcelZzu.writeString(null);
        zzas.zzc(parcelZzu, bundle);
        Parcel parcelZzv = zzv(8, parcelZzu);
        Bundle bundle2 = (Bundle) zzas.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zzh(int i4, String str, String str2, String str3, Bundle bundle) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(6);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        zzas.zzc(parcelZzu, bundle);
        Parcel parcelZzv = zzv(9, parcelZzu);
        Bundle bundle2 = (Bundle) zzas.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zzi(int i4, String str, String str2, String str3) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(3);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        Parcel parcelZzv = zzv(4, parcelZzu);
        Bundle bundle = (Bundle) zzas.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zzj(int i4, String str, String str2, String str3, Bundle bundle) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i4);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        parcelZzu.writeString(str3);
        zzas.zzc(parcelZzu, bundle);
        Parcel parcelZzv = zzv(11, parcelZzu);
        Bundle bundle2 = (Bundle) zzas.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zzk(int i4, String str, String str2, Bundle bundle) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(3);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzas.zzc(parcelZzu, bundle);
        Parcel parcelZzv = zzv(2, parcelZzu);
        Bundle bundle2 = (Bundle) zzas.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle2;
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final Bundle zzl(int i4, String str, String str2, Bundle bundle, Bundle bundle2) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i4);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        zzas.zzc(parcelZzu, bundle);
        zzas.zzc(parcelZzu, bundle2);
        Parcel parcelZzv = zzv(901, parcelZzu);
        Bundle bundle3 = (Bundle) zzas.zza(parcelZzv, Bundle.CREATOR);
        parcelZzv.recycle();
        return bundle3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final void zzm(int i4, String str, Bundle bundle, zzy zzyVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(21);
        parcelZzu.writeString(str);
        zzas.zzc(parcelZzu, bundle);
        parcelZzu.writeStrongBinder(zzyVar);
        zzx(1501, parcelZzu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final void zzn(int i4, String str, Bundle bundle, zzaa zzaaVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(22);
        parcelZzu.writeString(str);
        zzas.zzc(parcelZzu, bundle);
        parcelZzu.writeStrongBinder(zzaaVar);
        zzx(1801, parcelZzu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final void zzo(int i4, String str, Bundle bundle, zzac zzacVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(21);
        parcelZzu.writeString(str);
        zzas.zzc(parcelZzu, bundle);
        parcelZzu.writeStrongBinder(zzacVar);
        zzx(1601, parcelZzu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final void zzp(int i4, String str, Bundle bundle, zzae zzaeVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(18);
        parcelZzu.writeString(str);
        zzas.zzc(parcelZzu, bundle);
        parcelZzu.writeStrongBinder(zzaeVar);
        zzw(1301, parcelZzu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final void zzq(int i4, String str, Bundle bundle, zzag zzagVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(22);
        parcelZzu.writeString(str);
        zzas.zzc(parcelZzu, bundle);
        parcelZzu.writeStrongBinder(zzagVar);
        zzx(1901, parcelZzu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final void zzr(int i4, String str, Bundle bundle, zzai zzaiVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(21);
        parcelZzu.writeString(str);
        zzas.zzc(parcelZzu, bundle);
        parcelZzu.writeStrongBinder(zzaiVar);
        zzx(1401, parcelZzu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final void zzs(int i4, String str, Bundle bundle, zzak zzakVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(22);
        parcelZzu.writeString(str);
        zzas.zzc(parcelZzu, bundle);
        parcelZzu.writeStrongBinder(zzakVar);
        zzx(1701, parcelZzu);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.play_billing.zzan
    public final void zzt(int i4, String str, Bundle bundle, zzap zzapVar) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(12);
        parcelZzu.writeString(str);
        zzas.zzc(parcelZzu, bundle);
        parcelZzu.writeStrongBinder(zzapVar);
        zzw(1201, parcelZzu);
    }

    @Override // com.google.android.gms.internal.play_billing.zzan
    public final int zzy(int i4, String str, String str2) {
        Parcel parcelZzu = zzu();
        parcelZzu.writeInt(i4);
        parcelZzu.writeString(str);
        parcelZzu.writeString(str2);
        Parcel parcelZzv = zzv(1, parcelZzu);
        int i5 = parcelZzv.readInt();
        parcelZzv.recycle();
        return i5;
    }
}
