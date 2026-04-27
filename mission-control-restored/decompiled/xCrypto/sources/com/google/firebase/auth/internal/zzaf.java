package com.google.firebase.auth.internal;

import A1.c;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.p002firebaseauthapi.zzahn;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.MultiFactor;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.UserInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class zzaf extends FirebaseUser {
    public static final Parcelable.Creator<zzaf> CREATOR = new zzae();
    private zzahn zza;
    private zzab zzb;
    private String zzc;
    private String zzd;
    private List<zzab> zze;
    private List<String> zzf;
    private String zzg;
    private Boolean zzh;
    private zzah zzi;
    private boolean zzj;
    private com.google.firebase.auth.zzc zzk;
    private zzbj zzl;
    private List<com.google.firebase.auth.zzal> zzm;

    public zzaf(FirebaseApp firebaseApp, List<? extends UserInfo> list) {
        AbstractC0940s.k(firebaseApp);
        this.zzc = firebaseApp.getName();
        this.zzd = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.zzg = "2";
        zza(list);
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public String getDisplayName() {
        return this.zzb.getDisplayName();
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public String getEmail() {
        return this.zzb.getEmail();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public FirebaseUserMetadata getMetadata() {
        return this.zzi;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public /* synthetic */ MultiFactor getMultiFactor() {
        return new zzaj(this);
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public String getPhoneNumber() {
        return this.zzb.getPhoneNumber();
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public Uri getPhotoUrl() {
        return this.zzb.getPhotoUrl();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public List<? extends UserInfo> getProviderData() {
        return this.zze;
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public String getProviderId() {
        return this.zzb.getProviderId();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public String getTenantId() {
        Map map;
        zzahn zzahnVar = this.zza;
        if (zzahnVar == null || zzahnVar.zzc() == null || (map = (Map) zzbi.zza(this.zza.zzc()).getClaims().get(FirebaseAuthProvider.PROVIDER_ID)) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    @Override // com.google.firebase.auth.FirebaseUser, com.google.firebase.auth.UserInfo
    public String getUid() {
        return this.zzb.getUid();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public boolean isAnonymous() {
        GetTokenResult getTokenResultZza;
        Boolean bool = this.zzh;
        if (bool == null || bool.booleanValue()) {
            zzahn zzahnVar = this.zza;
            String signInProvider = "";
            if (zzahnVar != null && (getTokenResultZza = zzbi.zza(zzahnVar.zzc())) != null) {
                signInProvider = getTokenResultZza.getSignInProvider();
            }
            boolean z4 = true;
            if (getProviderData().size() > 1 || (signInProvider != null && signInProvider.equals("custom"))) {
                z4 = false;
            }
            this.zzh = Boolean.valueOf(z4);
        }
        return this.zzh.booleanValue();
    }

    @Override // com.google.firebase.auth.UserInfo
    public boolean isEmailVerified() {
        return this.zzb.isEmailVerified();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.C(parcel, 1, zzc(), i4, false);
        c.C(parcel, 2, this.zzb, i4, false);
        c.E(parcel, 3, this.zzc, false);
        c.E(parcel, 4, this.zzd, false);
        c.I(parcel, 5, this.zze, false);
        c.G(parcel, 6, zzg(), false);
        c.E(parcel, 7, this.zzg, false);
        c.i(parcel, 8, Boolean.valueOf(isAnonymous()), false);
        c.C(parcel, 9, getMetadata(), i4, false);
        c.g(parcel, 10, this.zzj);
        c.C(parcel, 11, this.zzk, i4, false);
        c.C(parcel, 12, this.zzl, i4, false);
        c.I(parcel, 13, zzf(), false);
        c.b(parcel, iA);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final FirebaseApp zza() {
        return FirebaseApp.getInstance(this.zzc);
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final /* synthetic */ FirebaseUser zzb() {
        this.zzh = Boolean.FALSE;
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final zzahn zzc() {
        return this.zza;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String zzd() {
        return zzc().zzc();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final String zze() {
        return this.zza.zzf();
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final List<com.google.firebase.auth.zzal> zzf() {
        return this.zzm;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final List<String> zzg() {
        return this.zzf;
    }

    public final com.google.firebase.auth.zzc zzh() {
        return this.zzk;
    }

    public final List<MultiFactorInfo> zzi() {
        zzbj zzbjVar = this.zzl;
        return zzbjVar != null ? zzbjVar.zza() : new ArrayList();
    }

    public final List<zzab> zzj() {
        return this.zze;
    }

    public final boolean zzk() {
        return this.zzj;
    }

    public static FirebaseUser zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser) {
        zzaf zzafVar = new zzaf(firebaseApp, firebaseUser.getProviderData());
        if (firebaseUser instanceof zzaf) {
            zzaf zzafVar2 = (zzaf) firebaseUser;
            zzafVar.zzg = zzafVar2.zzg;
            zzafVar.zzd = zzafVar2.zzd;
            zzafVar.zzi = (zzah) zzafVar2.getMetadata();
        } else {
            zzafVar.zzi = null;
        }
        if (firebaseUser.zzc() != null) {
            zzafVar.zza(firebaseUser.zzc());
        }
        if (!firebaseUser.isAnonymous()) {
            zzafVar.zzb();
        }
        return zzafVar;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzb(List<com.google.firebase.auth.zzal> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.zzm = list;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zzc(List<MultiFactorInfo> list) {
        this.zzl = zzbj.zza(list);
    }

    public zzaf(zzahn zzahnVar, zzab zzabVar, String str, String str2, List<zzab> list, List<String> list2, String str3, Boolean bool, zzah zzahVar, boolean z4, com.google.firebase.auth.zzc zzcVar, zzbj zzbjVar, List<com.google.firebase.auth.zzal> list3) {
        this.zza = zzahnVar;
        this.zzb = zzabVar;
        this.zzc = str;
        this.zzd = str2;
        this.zze = list;
        this.zzf = list2;
        this.zzg = str3;
        this.zzh = bool;
        this.zzi = zzahVar;
        this.zzj = z4;
        this.zzk = zzcVar;
        this.zzl = zzbjVar;
        this.zzm = list3;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final synchronized FirebaseUser zza(List<? extends UserInfo> list) {
        try {
            AbstractC0940s.k(list);
            this.zze = new ArrayList(list.size());
            this.zzf = new ArrayList(list.size());
            for (int i4 = 0; i4 < list.size(); i4++) {
                UserInfo userInfo = list.get(i4);
                if (userInfo.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                    this.zzb = (zzab) userInfo;
                } else {
                    this.zzf.add(userInfo.getProviderId());
                }
                this.zze.add((zzab) userInfo);
            }
            if (this.zzb == null) {
                this.zzb = this.zze.get(0);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this;
    }

    public final zzaf zza(String str) {
        this.zzg = str;
        return this;
    }

    @Override // com.google.firebase.auth.FirebaseUser
    public final void zza(zzahn zzahnVar) {
        this.zza = (zzahn) AbstractC0940s.k(zzahnVar);
    }

    public final void zza(com.google.firebase.auth.zzc zzcVar) {
        this.zzk = zzcVar;
    }

    public final void zza(boolean z4) {
        this.zzj = z4;
    }

    public final void zza(zzah zzahVar) {
        this.zzi = zzahVar;
    }
}
