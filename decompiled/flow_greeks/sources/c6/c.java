package c6;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import kg.c0;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class c extends n5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3691a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Bundle f3692b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f3693c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3694d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f3695e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f3696f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f3690g = new a(null);
    public static final Parcelable.Creator<c> CREATOR = new d();

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    public c(String type, Bundle credentialRetrievalData, Bundle candidateQueryData, String requestMatcher, String requestType, String protocolType) {
        t.f(type, "type");
        t.f(credentialRetrievalData, "credentialRetrievalData");
        t.f(candidateQueryData, "candidateQueryData");
        t.f(requestMatcher, "requestMatcher");
        t.f(requestType, "requestType");
        t.f(protocolType, "protocolType");
        this.f3691a = type;
        this.f3692b = credentialRetrievalData;
        this.f3693c = candidateQueryData;
        this.f3694d = requestMatcher;
        this.f3695e = requestType;
        this.f3696f = protocolType;
        boolean z10 = (c0.e0(requestType) || c0.e0(protocolType)) ? false : true;
        boolean z11 = !c0.e0(type) && requestType.length() == 0 && protocolType.length() == 0;
        if (z10 || z11) {
            return;
        }
        throw new IllegalArgumentException("Either type: " + type + ", or requestType: " + requestType + " and protocolType: " + protocolType + " must be specified, but at least one contains an invalid blank value.");
    }

    public final Bundle R() {
        return this.f3693c;
    }

    public final Bundle S() {
        return this.f3692b;
    }

    public final String T() {
        return this.f3696f;
    }

    public final String U() {
        return this.f3694d;
    }

    public final String V() {
        return this.f3695e;
    }

    public final String W() {
        return this.f3691a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int i10) {
        t.f(dest, "dest");
        d.c(this, dest, i10);
    }
}
