package com.google.android.gms.identitycredentials;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import c6.e;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.t;
import n5.a;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0007\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001\u0015B9\b\u0007\u0012\u000e\b\u0001\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\b\u0001\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R \u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 R \u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b!\u0010\"\u0012\u0004\b%\u0010&\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"Lcom/google/android/gms/identitycredentials/GetCredentialRequest;", "Ln5/a;", "Lcom/google/android/gms/common/internal/ReflectedParcelable;", "", "Lc6/c;", "credentialOptions", "Landroid/os/Bundle;", "data", "", "origin", "Landroid/os/ResultReceiver;", "resultReceiver", "<init>", "(Ljava/util/List;Landroid/os/Bundle;Ljava/lang/String;Landroid/os/ResultReceiver;)V", "Landroid/os/Parcel;", "dest", "", "flags", "Lcd/h0;", "writeToParcel", "(Landroid/os/Parcel;I)V", "a", "Ljava/util/List;", "R", "()Ljava/util/List;", "b", "Landroid/os/Bundle;", "S", "()Landroid/os/Bundle;", "c", "Ljava/lang/String;", "T", "()Ljava/lang/String;", "d", "Landroid/os/ResultReceiver;", "U", "()Landroid/os/ResultReceiver;", "getResultReceiver$annotations", "()V", "e", "java.com.google.android.gmscore.integ.client.identity_credentials_identity_credentials"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class GetCredentialRequest extends a implements ReflectedParcelable {

    /* JADX INFO: renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final List credentialOptions;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final Bundle data;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final String origin;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final ResultReceiver resultReceiver;
    public static final Parcelable.Creator<GetCredentialRequest> CREATOR = new e();

    public GetCredentialRequest(List credentialOptions, Bundle data, String str, ResultReceiver resultReceiver) {
        t.f(credentialOptions, "credentialOptions");
        t.f(data, "data");
        t.f(resultReceiver, "resultReceiver");
        this.credentialOptions = credentialOptions;
        this.data = data;
        this.origin = str;
        this.resultReceiver = resultReceiver;
    }

    /* JADX INFO: renamed from: R, reason: from getter */
    public final List getCredentialOptions() {
        return this.credentialOptions;
    }

    /* JADX INFO: renamed from: S, reason: from getter */
    public final Bundle getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: T, reason: from getter */
    public final String getOrigin() {
        return this.origin;
    }

    /* JADX INFO: renamed from: U, reason: from getter */
    public final ResultReceiver getResultReceiver() {
        return this.resultReceiver;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        t.f(dest, "dest");
        e.c(this, dest, flags);
    }
}
