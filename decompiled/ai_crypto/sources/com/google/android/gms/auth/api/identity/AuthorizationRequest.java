package com.google.android.gms.auth.api.identity;

import I1.p;
import Q1.c;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1206q;
import com.google.android.gms.common.internal.AbstractC1207s;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class AuthorizationRequest extends Q1.a implements ReflectedParcelable {
    public static final Parcelable.Creator<AuthorizationRequest> CREATOR = new p();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f10752a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10753b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f10754c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f10755d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Account f10756e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f10757f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f10758g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f10759h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f10760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f10761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f10762c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f10763d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Account f10764e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f10765f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f10766g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f10767h;

        public AuthorizationRequest a() {
            return new AuthorizationRequest(this.f10760a, this.f10761b, this.f10762c, this.f10763d, this.f10764e, this.f10765f, this.f10766g, this.f10767h);
        }

        public a b(String str) {
            this.f10765f = AbstractC1207s.e(str);
            return this;
        }

        public a c(String str, boolean z7) {
            h(str);
            this.f10761b = str;
            this.f10762c = true;
            this.f10767h = z7;
            return this;
        }

        public a d(Account account) {
            this.f10764e = (Account) AbstractC1207s.k(account);
            return this;
        }

        public a e(List list) {
            boolean z7 = false;
            if (list != null && !list.isEmpty()) {
                z7 = true;
            }
            AbstractC1207s.b(z7, "requestedScopes cannot be null or empty");
            this.f10760a = list;
            return this;
        }

        public final a f(String str) {
            h(str);
            this.f10761b = str;
            this.f10763d = true;
            return this;
        }

        public final a g(String str) {
            this.f10766g = str;
            return this;
        }

        public final String h(String str) {
            AbstractC1207s.k(str);
            String str2 = this.f10761b;
            boolean z7 = true;
            if (str2 != null && !str2.equals(str)) {
                z7 = false;
            }
            AbstractC1207s.b(z7, "two different server client ids provided");
            return str;
        }
    }

    public AuthorizationRequest(List list, String str, boolean z7, boolean z8, Account account, String str2, String str3, boolean z9) {
        boolean z10 = false;
        if (list != null && !list.isEmpty()) {
            z10 = true;
        }
        AbstractC1207s.b(z10, "requestedScopes cannot be null or empty");
        this.f10752a = list;
        this.f10753b = str;
        this.f10754c = z7;
        this.f10755d = z8;
        this.f10756e = account;
        this.f10757f = str2;
        this.f10758g = str3;
        this.f10759h = z9;
    }

    public static a A() {
        return new a();
    }

    public static a H(AuthorizationRequest authorizationRequest) {
        AbstractC1207s.k(authorizationRequest);
        a aVarA = A();
        aVarA.e(authorizationRequest.D());
        boolean zF = authorizationRequest.F();
        String strC = authorizationRequest.C();
        Account accountB = authorizationRequest.B();
        String strE = authorizationRequest.E();
        String str = authorizationRequest.f10758g;
        if (str != null) {
            aVarA.g(str);
        }
        if (strC != null) {
            aVarA.b(strC);
        }
        if (accountB != null) {
            aVarA.d(accountB);
        }
        if (authorizationRequest.f10755d && strE != null) {
            aVarA.f(strE);
        }
        if (authorizationRequest.G() && strE != null) {
            aVarA.c(strE, zF);
        }
        return aVarA;
    }

    public Account B() {
        return this.f10756e;
    }

    public String C() {
        return this.f10757f;
    }

    public List D() {
        return this.f10752a;
    }

    public String E() {
        return this.f10753b;
    }

    public boolean F() {
        return this.f10759h;
    }

    public boolean G() {
        return this.f10754c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthorizationRequest)) {
            return false;
        }
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) obj;
        return this.f10752a.size() == authorizationRequest.f10752a.size() && this.f10752a.containsAll(authorizationRequest.f10752a) && this.f10754c == authorizationRequest.f10754c && this.f10759h == authorizationRequest.f10759h && this.f10755d == authorizationRequest.f10755d && AbstractC1206q.b(this.f10753b, authorizationRequest.f10753b) && AbstractC1206q.b(this.f10756e, authorizationRequest.f10756e) && AbstractC1206q.b(this.f10757f, authorizationRequest.f10757f) && AbstractC1206q.b(this.f10758g, authorizationRequest.f10758g);
    }

    public int hashCode() {
        return AbstractC1206q.c(this.f10752a, this.f10753b, Boolean.valueOf(this.f10754c), Boolean.valueOf(this.f10759h), Boolean.valueOf(this.f10755d), this.f10756e, this.f10757f, this.f10758g);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i7) {
        int iA = c.a(parcel);
        c.I(parcel, 1, D(), false);
        c.E(parcel, 2, E(), false);
        c.g(parcel, 3, G());
        c.g(parcel, 4, this.f10755d);
        c.C(parcel, 5, B(), i7, false);
        c.E(parcel, 6, C(), false);
        c.E(parcel, 7, this.f10758g, false);
        c.g(parcel, 8, F());
        c.b(parcel, iA);
    }
}
