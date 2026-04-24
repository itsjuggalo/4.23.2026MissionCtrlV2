package androidx.heifwriter;

import android.adservices.adid.AdId;
import android.adservices.adid.AdIdManager;
import android.adservices.adselection.AdSelectionConfig;
import android.adservices.adselection.AdSelectionFromOutcomesConfig;
import android.adservices.adselection.AdSelectionManager;
import android.adservices.adselection.AdSelectionOutcome;
import android.adservices.adselection.GetAdSelectionDataOutcome;
import android.adservices.adselection.GetAdSelectionDataRequest;
import android.adservices.adselection.PersistAdSelectionResultRequest;
import android.adservices.adselection.ReportEventRequest;
import android.adservices.adselection.ReportImpressionRequest;
import android.app.slice.Slice;
import android.media.AudioFocusRequest;
import android.media.MediaMuxer;
import android.media.session.MediaSessionManager;
import android.os.Bundle;
import android.service.credentials.Action;
import android.service.credentials.BeginGetCredentialOption;
import android.service.credentials.BeginGetCredentialRequest;
import android.service.credentials.CredentialEntry;
import java.io.FileDescriptor;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class HeifWriter$$ExternalSyntheticApiModelOutline0 {
    public static /* bridge */ /* synthetic */ AdId m(Object obj) {
        return (AdId) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AdIdManager m220m(Object obj) {
        return (AdIdManager) obj;
    }

    public static /* synthetic */ AdSelectionConfig.Builder m() {
        return new AdSelectionConfig.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ AdSelectionFromOutcomesConfig.Builder m221m() {
        return new AdSelectionFromOutcomesConfig.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AdSelectionManager m223m(Object obj) {
        return (AdSelectionManager) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AdSelectionOutcome m224m(Object obj) {
        return (AdSelectionOutcome) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ GetAdSelectionDataOutcome m225m(Object obj) {
        return (GetAdSelectionDataOutcome) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ GetAdSelectionDataRequest.Builder m226m() {
        return new GetAdSelectionDataRequest.Builder();
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ PersistAdSelectionResultRequest.Builder m227m() {
        return new PersistAdSelectionResultRequest.Builder();
    }

    public static /* synthetic */ ReportEventRequest.Builder m(long j, String str, String str2, int i) {
        return new ReportEventRequest.Builder(j, str, str2, i);
    }

    public static /* synthetic */ ReportImpressionRequest m(long j) {
        return new ReportImpressionRequest(j);
    }

    public static /* synthetic */ ReportImpressionRequest m(long j, AdSelectionConfig adSelectionConfig) {
        return new ReportImpressionRequest(j, adSelectionConfig);
    }

    public static /* synthetic */ AudioFocusRequest.Builder m(int i) {
        return new AudioFocusRequest.Builder(i);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ AudioFocusRequest m228m(Object obj) {
        return (AudioFocusRequest) obj;
    }

    public static /* synthetic */ MediaMuxer m(FileDescriptor fileDescriptor, int i) {
        return new MediaMuxer(fileDescriptor, i);
    }

    public static /* synthetic */ MediaSessionManager.RemoteUserInfo m(String str, int i, int i2) {
        return new MediaSessionManager.RemoteUserInfo(str, i, i2);
    }

    public static /* synthetic */ Action m(Slice slice) {
        return new Action(slice);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Action m230m(Object obj) {
        return (Action) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ BeginGetCredentialOption m231m(Object obj) {
        return (BeginGetCredentialOption) obj;
    }

    public static /* synthetic */ BeginGetCredentialOption m(String str, String str2, Bundle bundle) {
        return new BeginGetCredentialOption(str, str2, bundle);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ BeginGetCredentialRequest.Builder m232m() {
        return new BeginGetCredentialRequest.Builder();
    }

    public static /* synthetic */ CredentialEntry m(BeginGetCredentialOption beginGetCredentialOption, Slice slice) {
        return new CredentialEntry(beginGetCredentialOption, slice);
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ CredentialEntry m233m(Object obj) {
        return (CredentialEntry) obj;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* bridge */ /* synthetic */ Class m234m() {
        return AdIdManager.class;
    }

    /* JADX INFO: renamed from: m, reason: collision with other method in class */
    public static /* synthetic */ void m238m() {
    }

    public static /* bridge */ /* synthetic */ Class m$1() {
        return AdSelectionManager.class;
    }

    /* JADX INFO: renamed from: m$1, reason: collision with other method in class */
    public static /* synthetic */ void m241m$1() {
    }

    public static /* synthetic */ void m$2() {
    }

    public static /* synthetic */ void m$3() {
    }

    public static /* synthetic */ void m$4() {
    }

    public static /* synthetic */ void m$5() {
    }
}
