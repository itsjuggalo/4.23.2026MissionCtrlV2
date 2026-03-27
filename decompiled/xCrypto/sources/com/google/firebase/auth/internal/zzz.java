package com.google.firebase.auth.internal;

import A1.c;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public final class zzz implements AuthResult {
    public static final Parcelable.Creator<zzz> CREATOR = new zzy();
    private zzaf zza;
    private zzx zzb;
    private com.google.firebase.auth.zzc zzc;

    public zzz(zzaf zzafVar) {
        zzaf zzafVar2 = (zzaf) AbstractC0940s.k(zzafVar);
        this.zza = zzafVar2;
        List<zzab> listZzj = zzafVar2.zzj();
        this.zzb = null;
        for (int i4 = 0; i4 < listZzj.size(); i4++) {
            if (!TextUtils.isEmpty(listZzj.get(i4).zza())) {
                this.zzb = new zzx(listZzj.get(i4).getProviderId(), listZzj.get(i4).zza(), zzafVar.zzk());
            }
        }
        if (this.zzb == null) {
            this.zzb = new zzx(zzafVar.zzk());
        }
        this.zzc = zzafVar.zzh();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzb;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final AuthCredential getCredential() {
        return this.zzc;
    }

    @Override // com.google.firebase.auth.AuthResult
    public final FirebaseUser getUser() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.C(parcel, 1, getUser(), i4, false);
        c.C(parcel, 2, getAdditionalUserInfo(), i4, false);
        c.C(parcel, 3, this.zzc, i4, false);
        c.b(parcel, iA);
    }

    public zzz(zzaf zzafVar, zzx zzxVar, com.google.firebase.auth.zzc zzcVar) {
        this.zza = zzafVar;
        this.zzb = zzxVar;
        this.zzc = zzcVar;
    }
}
