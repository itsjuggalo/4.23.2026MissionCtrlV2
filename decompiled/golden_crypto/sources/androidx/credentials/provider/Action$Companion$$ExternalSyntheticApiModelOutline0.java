package androidx.credentials.provider;

import android.app.slice.Slice;
import android.app.slice.SliceItem;
import android.app.slice.SliceSpec;
import android.content.pm.SigningInfo;
import android.credentials.ClearCredentialStateException;
import android.credentials.CreateCredentialException;
import android.credentials.CreateCredentialResponse;
import android.credentials.Credential;
import android.credentials.CredentialOption;
import android.credentials.GetCredentialException;
import android.credentials.GetCredentialResponse;
import android.credentials.PrepareGetCredentialResponse;
import android.net.Uri;
import android.os.Bundle;
import android.service.credentials.BeginCreateCredentialResponse;
import android.service.credentials.BeginGetCredentialResponse;
import android.service.credentials.CreateCredentialRequest;
import android.service.credentials.GetCredentialRequest;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class Action$Companion$$ExternalSyntheticApiModelOutline0 {
    public static /* synthetic */ Slice.Builder m(Slice.Builder builder) {
        return new Slice.Builder(builder);
    }

    public static /* synthetic */ Slice.Builder m(Uri uri, SliceSpec sliceSpec) {
        return new Slice.Builder(uri, sliceSpec);
    }

    public static /* bridge */ /* synthetic */ SliceItem m(Object obj) {
        return (SliceItem) obj;
    }

    public static /* synthetic */ SliceSpec m(String str, int i) {
        return new SliceSpec(str, i);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ ClearCredentialStateException m154m(Object obj) {
        return (ClearCredentialStateException) obj;
    }

    public static /* synthetic */ ClearCredentialStateException m(String str, String str2) {
        return new ClearCredentialStateException(str, str2);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CreateCredentialException m155m(Object obj) {
        return (CreateCredentialException) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ CreateCredentialException m156m(String str, String str2) {
        return new CreateCredentialException(str, str2);
    }

    public static /* synthetic */ CreateCredentialResponse m(Bundle bundle) {
        return new CreateCredentialResponse(bundle);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CreateCredentialResponse m157m(Object obj) {
        return (CreateCredentialResponse) obj;
    }

    public static /* synthetic */ Credential m(String str, Bundle bundle) {
        return new Credential(str, bundle);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CredentialOption m158m(Object obj) {
        return (CredentialOption) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ GetCredentialException m159m(Object obj) {
        return (GetCredentialException) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ GetCredentialException m160m(String str, String str2) {
        return new GetCredentialException(str, str2);
    }

    public static /* synthetic */ GetCredentialResponse m(Credential credential) {
        return new GetCredentialResponse(credential);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ GetCredentialResponse m161m(Object obj) {
        return (GetCredentialResponse) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ PrepareGetCredentialResponse m162m(Object obj) {
        return (PrepareGetCredentialResponse) obj;
    }

    public static /* synthetic */ android.service.credentials.BeginCreateCredentialRequest m(String str, Bundle bundle, android.service.credentials.CallingAppInfo callingAppInfo) {
        return new android.service.credentials.BeginCreateCredentialRequest(str, bundle, callingAppInfo);
    }

    public static /* synthetic */ BeginCreateCredentialResponse.Builder m() {
        return new BeginCreateCredentialResponse.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ android.service.credentials.BeginGetCredentialRequest m163m(Object obj) {
        return (android.service.credentials.BeginGetCredentialRequest) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ BeginGetCredentialResponse.Builder m164m() {
        return new BeginGetCredentialResponse.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ android.service.credentials.BeginGetCredentialResponse m165m(Object obj) {
        return (android.service.credentials.BeginGetCredentialResponse) obj;
    }

    public static /* synthetic */ android.service.credentials.CallingAppInfo m(String str, SigningInfo signingInfo, String str2) {
        return new android.service.credentials.CallingAppInfo(str, signingInfo, str2);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CreateCredentialRequest m168m(Object obj) {
        return (CreateCredentialRequest) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ android.service.credentials.CreateEntry m169m(Slice slice) {
        return new android.service.credentials.CreateEntry(slice);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ android.service.credentials.CreateEntry m170m(Object obj) {
        return (android.service.credentials.CreateEntry) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ GetCredentialRequest m171m(Object obj) {
        return (GetCredentialRequest) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ android.service.credentials.RemoteEntry m172m(Slice slice) {
        return new android.service.credentials.RemoteEntry(slice);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m174m() {
        return GetCredentialResponse.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m184m() {
    }

    public static /* bridge */ /* synthetic */ Class m$1() {
        return android.service.credentials.BeginGetCredentialResponse.class;
    }

    /* JADX INFO: renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m187m$1() {
    }

    public static /* synthetic */ void m$10() {
    }

    public static /* bridge */ /* synthetic */ Class m$2() {
        return CreateCredentialException.class;
    }

    /* JADX INFO: renamed from: m$2, reason: collision with other method in class */
    public static /* synthetic */ void m188m$2() {
    }

    public static /* bridge */ /* synthetic */ Class m$3() {
        return GetCredentialException.class;
    }

    /* JADX INFO: renamed from: m$3, reason: collision with other method in class */
    public static /* synthetic */ void m189m$3() {
    }

    public static /* bridge */ /* synthetic */ Class m$4() {
        return CreateCredentialResponse.class;
    }

    /* JADX INFO: renamed from: m$4, reason: collision with other method in class */
    public static /* synthetic */ void m190m$4() {
    }

    public static /* bridge */ /* synthetic */ Class m$5() {
        return GetCredentialRequest.class;
    }

    /* JADX INFO: renamed from: m$5, reason: collision with other method in class */
    public static /* synthetic */ void m191m$5() {
    }

    public static /* bridge */ /* synthetic */ Class m$6() {
        return CreateCredentialRequest.class;
    }

    /* JADX INFO: renamed from: m$6, reason: collision with other method in class */
    public static /* synthetic */ void m192m$6() {
    }

    public static /* bridge */ /* synthetic */ Class m$7() {
        return android.service.credentials.BeginGetCredentialRequest.class;
    }

    /* JADX INFO: renamed from: m$7, reason: collision with other method in class */
    public static /* synthetic */ void m193m$7() {
    }

    public static /* synthetic */ void m$8() {
    }

    public static /* synthetic */ void m$9() {
    }
}
