package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import c5.e0;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.s;
import java.util.ArrayList;
import java.util.List;
import n5.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class SaveAccountLinkingTokenRequest extends n5.a implements ReflectedParcelable {
    public static final Parcelable.Creator<SaveAccountLinkingTokenRequest> CREATOR = new e0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f5381a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5382b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5383c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f5384d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f5385e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f5386f;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PendingIntent f5387a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5388b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f5389c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f5390d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f5391e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f5392f;

        public SaveAccountLinkingTokenRequest a() {
            s.b(this.f5387a != null, "Consent PendingIntent cannot be null");
            s.b("auth_code".equals(this.f5388b), "Invalid tokenType");
            s.b(!TextUtils.isEmpty(this.f5389c), "serviceId cannot be null or empty");
            s.b(this.f5390d != null, "scopes cannot be null");
            return new SaveAccountLinkingTokenRequest(this.f5387a, this.f5388b, this.f5389c, this.f5390d, this.f5391e, this.f5392f);
        }

        public a b(PendingIntent pendingIntent) {
            this.f5387a = pendingIntent;
            return this;
        }

        public a c(List list) {
            this.f5390d = list;
            return this;
        }

        public a d(String str) {
            this.f5389c = str;
            return this;
        }

        public a e(String str) {
            this.f5388b = str;
            return this;
        }

        public final a f(String str) {
            this.f5391e = str;
            return this;
        }

        public final a g(int i10) {
            this.f5392f = i10;
            return this;
        }
    }

    public SaveAccountLinkingTokenRequest(PendingIntent pendingIntent, String str, String str2, List list, String str3, int i10) {
        this.f5381a = pendingIntent;
        this.f5382b = str;
        this.f5383c = str2;
        this.f5384d = list;
        this.f5385e = str3;
        this.f5386f = i10;
    }

    public static a R() {
        return new a();
    }

    public static a W(SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        s.k(saveAccountLinkingTokenRequest);
        a aVarR = R();
        aVarR.c(saveAccountLinkingTokenRequest.T());
        aVarR.d(saveAccountLinkingTokenRequest.U());
        aVarR.b(saveAccountLinkingTokenRequest.S());
        aVarR.e(saveAccountLinkingTokenRequest.V());
        aVarR.g(saveAccountLinkingTokenRequest.f5386f);
        String str = saveAccountLinkingTokenRequest.f5385e;
        if (!TextUtils.isEmpty(str)) {
            aVarR.f(str);
        }
        return aVarR;
    }

    public PendingIntent S() {
        return this.f5381a;
    }

    public List T() {
        return this.f5384d;
    }

    public String U() {
        return this.f5383c;
    }

    public String V() {
        return this.f5382b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SaveAccountLinkingTokenRequest)) {
            return false;
        }
        SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest = (SaveAccountLinkingTokenRequest) obj;
        List list = this.f5384d;
        int size = list.size();
        List list2 = saveAccountLinkingTokenRequest.f5384d;
        return size == list2.size() && list.containsAll(list2) && q.b(this.f5381a, saveAccountLinkingTokenRequest.f5381a) && q.b(this.f5382b, saveAccountLinkingTokenRequest.f5382b) && q.b(this.f5383c, saveAccountLinkingTokenRequest.f5383c) && q.b(this.f5385e, saveAccountLinkingTokenRequest.f5385e) && this.f5386f == saveAccountLinkingTokenRequest.f5386f;
    }

    public int hashCode() {
        return q.c(this.f5381a, this.f5382b, this.f5383c, this.f5384d, this.f5385e);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = c.a(parcel);
        c.C(parcel, 1, S(), i10, false);
        c.E(parcel, 2, V(), false);
        c.E(parcel, 3, U(), false);
        c.G(parcel, 4, T(), false);
        c.E(parcel, 5, this.f5385e, false);
        c.t(parcel, 6, this.f5386f);
        c.b(parcel, iA);
    }
}
