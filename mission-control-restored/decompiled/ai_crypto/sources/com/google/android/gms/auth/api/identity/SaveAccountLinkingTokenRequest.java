package com.google.android.gms.auth.api.identity;

import I1.A;
import Q1.c;
import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class SaveAccountLinkingTokenRequest extends Q1.a implements ReflectedParcelable {
    public static final Parcelable.Creator<SaveAccountLinkingTokenRequest> CREATOR = new A();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PendingIntent f10768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f10770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List f10771d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f10772e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f10773f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PendingIntent f10774a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10775b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f10776c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public List f10777d = new ArrayList();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f10778e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f10779f;

        public SaveAccountLinkingTokenRequest a() {
            AbstractC1207s.b(this.f10774a != null, "Consent PendingIntent cannot be null");
            AbstractC1207s.b("auth_code".equals(this.f10775b), "Invalid tokenType");
            AbstractC1207s.b(!TextUtils.isEmpty(this.f10776c), "serviceId cannot be null or empty");
            AbstractC1207s.b(this.f10777d != null, "scopes cannot be null");
            return new SaveAccountLinkingTokenRequest(this.f10774a, this.f10775b, this.f10776c, this.f10777d, this.f10778e, this.f10779f);
        }

        public a b(PendingIntent pendingIntent) {
            this.f10774a = pendingIntent;
            return this;
        }

        public a c(List list) {
            this.f10777d = list;
            return this;
        }

        public a d(String str) {
            this.f10776c = str;
            return this;
        }

        public a e(String str) {
            this.f10775b = str;
            return this;
        }

        public final a f(String str) {
            this.f10778e = str;
            return this;
        }

        public final a g(int i7) {
            this.f10779f = i7;
            return this;
        }
    }

    public SaveAccountLinkingTokenRequest(PendingIntent pendingIntent, String str, String str2, List list, String str3, int i7) {
        this.f10768a = pendingIntent;
        this.f10769b = str;
        this.f10770c = str2;
        this.f10771d = list;
        this.f10772e = str3;
        this.f10773f = i7;
    }

    public static a A() {
        return new a();
    }

    public static a F(SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        AbstractC1207s.k(saveAccountLinkingTokenRequest);
        a aVarA = A();
        aVarA.c(saveAccountLinkingTokenRequest.C());
        aVarA.d(saveAccountLinkingTokenRequest.D());
        aVarA.b(saveAccountLinkingTokenRequest.B());
        aVarA.e(saveAccountLinkingTokenRequest.E());
        aVarA.g(saveAccountLinkingTokenRequest.f10773f);
        String str = saveAccountLinkingTokenRequest.f10772e;
        if (!TextUtils.isEmpty(str)) {
            aVarA.f(str);
        }
        return aVarA;
    }

    public PendingIntent B() {
        return this.f10768a;
    }

    public List C() {
        return this.f10771d;
    }

    public String D() {
        return this.f10770c;
    }

    public String E() {
        return this.f10769b;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof SaveAccountLinkingTokenRequest)) {
            return false;
        }
        SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest = (SaveAccountLinkingTokenRequest) obj;
        return this.f10771d.size() == saveAccountLinkingTokenRequest.f10771d.size() && this.f10771d.containsAll(saveAccountLinkingTokenRequest.f10771d) && AbstractC1206q.b(this.f10768a, saveAccountLinkingTokenRequest.f10768a) && AbstractC1206q.b(this.f10769b, saveAccountLinkingTokenRequest.f10769b) && AbstractC1206q.b(this.f10770c, saveAccountLinkingTokenRequest.f10770c) && AbstractC1206q.b(this.f10772e, saveAccountLinkingTokenRequest.f10772e) && this.f10773f == saveAccountLinkingTokenRequest.f10773f;
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f10768a, this.f10769b, this.f10770c, this.f10771d, this.f10772e);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = c.a(parcel);
        c.C(parcel, 1, B(), i7, false);
        c.E(parcel, 2, E(), false);
        c.E(parcel, 3, D(), false);
        c.G(parcel, 4, C(), false);
        c.E(parcel, 5, this.f10772e, false);
        c.t(parcel, 6, this.f10773f);
        c.b(parcel, iA);
    }
}
