package com.google.firebase.auth;

import A1.a;
import android.app.Activity;
import android.net.Uri;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.internal.p002firebaseauthapi.zzahn;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class FirebaseUser extends a implements UserInfo {
    public Task<Void> delete() {
        return FirebaseAuth.getInstance(zza()).zza(this);
    }

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getDisplayName();

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getEmail();

    public Task<GetTokenResult> getIdToken(boolean z4) {
        return FirebaseAuth.getInstance(zza()).zza(this, z4);
    }

    public abstract FirebaseUserMetadata getMetadata();

    public abstract MultiFactor getMultiFactor();

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getPhoneNumber();

    @Override // com.google.firebase.auth.UserInfo
    public abstract Uri getPhotoUrl();

    public abstract List<? extends UserInfo> getProviderData();

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getProviderId();

    public abstract String getTenantId();

    @Override // com.google.firebase.auth.UserInfo
    public abstract String getUid();

    public abstract boolean isAnonymous();

    public Task<AuthResult> linkWithCredential(AuthCredential authCredential) {
        AbstractC0940s.k(authCredential);
        return FirebaseAuth.getInstance(zza()).zza(this, authCredential);
    }

    public Task<Void> reauthenticate(AuthCredential authCredential) {
        AbstractC0940s.k(authCredential);
        return FirebaseAuth.getInstance(zza()).zzb(this, authCredential);
    }

    public Task<AuthResult> reauthenticateAndRetrieveData(AuthCredential authCredential) {
        AbstractC0940s.k(authCredential);
        return FirebaseAuth.getInstance(zza()).zzc(this, authCredential);
    }

    public Task<Void> reload() {
        return FirebaseAuth.getInstance(zza()).zzb(this);
    }

    public Task<Void> sendEmailVerification() {
        return FirebaseAuth.getInstance(zza()).zza(this, false).continueWithTask(new zzag(this));
    }

    public Task<AuthResult> startActivityForLinkWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        AbstractC0940s.k(activity);
        AbstractC0940s.k(federatedAuthProvider);
        return FirebaseAuth.getInstance(zza()).zza(activity, federatedAuthProvider, this);
    }

    public Task<AuthResult> startActivityForReauthenticateWithProvider(Activity activity, FederatedAuthProvider federatedAuthProvider) {
        AbstractC0940s.k(activity);
        AbstractC0940s.k(federatedAuthProvider);
        return FirebaseAuth.getInstance(zza()).zzb(activity, federatedAuthProvider, this);
    }

    public Task<AuthResult> unlink(String str) {
        AbstractC0940s.e(str);
        return FirebaseAuth.getInstance(zza()).zzb(this, str);
    }

    @Deprecated
    public Task<Void> updateEmail(String str) {
        AbstractC0940s.e(str);
        return FirebaseAuth.getInstance(zza()).zzc(this, str);
    }

    public Task<Void> updatePassword(String str) {
        AbstractC0940s.e(str);
        return FirebaseAuth.getInstance(zza()).zzd(this, str);
    }

    public Task<Void> updatePhoneNumber(PhoneAuthCredential phoneAuthCredential) {
        return FirebaseAuth.getInstance(zza()).zza(this, phoneAuthCredential);
    }

    public Task<Void> updateProfile(UserProfileChangeRequest userProfileChangeRequest) {
        AbstractC0940s.k(userProfileChangeRequest);
        return FirebaseAuth.getInstance(zza()).zza(this, userProfileChangeRequest);
    }

    public Task<Void> verifyBeforeUpdateEmail(String str) {
        return verifyBeforeUpdateEmail(str, null);
    }

    public abstract FirebaseApp zza();

    public abstract FirebaseUser zza(List<? extends UserInfo> list);

    public abstract void zza(zzahn zzahnVar);

    public abstract FirebaseUser zzb();

    public abstract void zzb(List<zzal> list);

    public abstract zzahn zzc();

    public abstract void zzc(List<MultiFactorInfo> list);

    public abstract String zzd();

    public abstract String zze();

    public abstract List<zzal> zzf();

    public abstract List<String> zzg();

    public Task<Void> verifyBeforeUpdateEmail(String str, ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zza()).zza(this, false).continueWithTask(new zzah(this, str, actionCodeSettings));
    }

    public Task<Void> sendEmailVerification(ActionCodeSettings actionCodeSettings) {
        return FirebaseAuth.getInstance(zza()).zza(this, false).continueWithTask(new zzai(this, actionCodeSettings));
    }
}
