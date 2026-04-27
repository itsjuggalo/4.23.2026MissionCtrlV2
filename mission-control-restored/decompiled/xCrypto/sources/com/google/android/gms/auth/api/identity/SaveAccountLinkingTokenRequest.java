package com.google.android.gms.auth.api.identity;

import A1.c;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.List;
import r1.C1743A;

/* JADX INFO: loaded from: classes.dex */
public class SaveAccountLinkingTokenRequest extends A1.a implements ReflectedParcelable {
    public static final Parcelable.Creator<SaveAccountLinkingTokenRequest> CREATOR = new C1743A();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f9583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f9585c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f9586d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f9587e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f9588f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PendingIntent f9589a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f9590b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f9591c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f9592d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f9593e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f9594f;

        public SaveAccountLinkingTokenRequest a() {
            AbstractC0940s.b(this.f9589a != null, "Consent PendingIntent cannot be null");
            AbstractC0940s.b("auth_code".equals(this.f9590b), "Invalid tokenType");
            AbstractC0940s.b(!TextUtils.isEmpty(this.f9591c), "serviceId cannot be null or empty");
            AbstractC0940s.b(this.f9592d != null, "scopes cannot be null");
            return new SaveAccountLinkingTokenRequest(this.f9589a, this.f9590b, this.f9591c, this.f9592d, this.f9593e, this.f9594f);
        }

        public a b(PendingIntent pendingIntent) {
            this.f9589a = pendingIntent;
            return this;
        }

        public a c(List list) {
            this.f9592d = list;
            return this;
        }

        public a d(String str) {
            this.f9591c = str;
            return this;
        }

        public a e(String str) {
            this.f9590b = str;
            return this;
        }

        public final a f(String str) {
            this.f9593e = str;
            return this;
        }

        public final a g(int i4) {
            this.f9594f = i4;
            return this;
        }
    }

    public SaveAccountLinkingTokenRequest(PendingIntent pendingIntent, String str, String str2, List list, String str3, int i4) {
        this.f9583a = pendingIntent;
        this.f9584b = str;
        this.f9585c = str2;
        this.f9586d = list;
        this.f9587e = str3;
        this.f9588f = i4;
    }

    public static a i() {
        return new a();
    }

    public static a o(SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        AbstractC0940s.k(saveAccountLinkingTokenRequest);
        a aVarI = i();
        aVarI.c(saveAccountLinkingTokenRequest.l());
        aVarI.d(saveAccountLinkingTokenRequest.m());
        aVarI.b(saveAccountLinkingTokenRequest.k());
        aVarI.e(saveAccountLinkingTokenRequest.n());
        aVarI.g(saveAccountLinkingTokenRequest.f9588f);
        String str = saveAccountLinkingTokenRequest.f9587e;
        if (!TextUtils.isEmpty(str)) {
            aVarI.f(str);
        }
        return aVarI;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SaveAccountLinkingTokenRequest)) {
            return false;
        }
        SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest = (SaveAccountLinkingTokenRequest) obj;
        return this.f9586d.size() == saveAccountLinkingTokenRequest.f9586d.size() && this.f9586d.containsAll(saveAccountLinkingTokenRequest.f9586d) && AbstractC0939q.b(this.f9583a, saveAccountLinkingTokenRequest.f9583a) && AbstractC0939q.b(this.f9584b, saveAccountLinkingTokenRequest.f9584b) && AbstractC0939q.b(this.f9585c, saveAccountLinkingTokenRequest.f9585c) && AbstractC0939q.b(this.f9587e, saveAccountLinkingTokenRequest.f9587e) && this.f9588f == saveAccountLinkingTokenRequest.f9588f;
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f9583a, this.f9584b, this.f9585c, this.f9586d, this.f9587e);
    }

    public PendingIntent k() {
        return this.f9583a;
    }

    public List l() {
        return this.f9586d;
    }

    public String m() {
        return this.f9585c;
    }

    public String n() {
        return this.f9584b;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.C(parcel, 1, k(), i4, false);
        c.E(parcel, 2, n(), false);
        c.E(parcel, 3, m(), false);
        c.G(parcel, 4, l(), false);
        c.E(parcel, 5, this.f9587e, false);
        c.t(parcel, 6, this.f9588f);
        c.b(parcel, iA);
    }
}
