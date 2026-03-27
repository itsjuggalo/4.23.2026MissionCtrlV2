package com.google.android.gms.auth.api.identity;

import A1.c;
import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC0939q;
import com.google.android.gms.common.internal.AbstractC0940s;
import com.google.android.gms.common.internal.ReflectedParcelable;
import java.util.List;
import r1.p;

/* JADX INFO: loaded from: classes.dex */
public class AuthorizationRequest extends A1.a implements ReflectedParcelable {
    public static final Parcelable.Creator<AuthorizationRequest> CREATOR = new p();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f9567a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f9568b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f9569c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f9570d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Account f9571e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f9572f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f9573g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f9574h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f9575a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f9576b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f9577c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f9578d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Account f9579e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f9580f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f9581g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f9582h;

        public AuthorizationRequest a() {
            return new AuthorizationRequest(this.f9575a, this.f9576b, this.f9577c, this.f9578d, this.f9579e, this.f9580f, this.f9581g, this.f9582h);
        }

        public a b(String str) {
            this.f9580f = AbstractC0940s.e(str);
            return this;
        }

        public a c(String str, boolean z4) {
            h(str);
            this.f9576b = str;
            this.f9577c = true;
            this.f9582h = z4;
            return this;
        }

        public a d(Account account) {
            this.f9579e = (Account) AbstractC0940s.k(account);
            return this;
        }

        public a e(List list) {
            boolean z4 = false;
            if (list != null && !list.isEmpty()) {
                z4 = true;
            }
            AbstractC0940s.b(z4, "requestedScopes cannot be null or empty");
            this.f9575a = list;
            return this;
        }

        public final a f(String str) {
            h(str);
            this.f9576b = str;
            this.f9578d = true;
            return this;
        }

        public final a g(String str) {
            this.f9581g = str;
            return this;
        }

        public final String h(String str) {
            AbstractC0940s.k(str);
            String str2 = this.f9576b;
            boolean z4 = true;
            if (str2 != null && !str2.equals(str)) {
                z4 = false;
            }
            AbstractC0940s.b(z4, "two different server client ids provided");
            return str;
        }
    }

    public AuthorizationRequest(List list, String str, boolean z4, boolean z5, Account account, String str2, String str3, boolean z6) {
        boolean z7 = false;
        if (list != null && !list.isEmpty()) {
            z7 = true;
        }
        AbstractC0940s.b(z7, "requestedScopes cannot be null or empty");
        this.f9567a = list;
        this.f9568b = str;
        this.f9569c = z4;
        this.f9570d = z5;
        this.f9571e = account;
        this.f9572f = str2;
        this.f9573g = str3;
        this.f9574h = z6;
    }

    public static a i() {
        return new a();
    }

    public static a q(AuthorizationRequest authorizationRequest) {
        AbstractC0940s.k(authorizationRequest);
        a aVarI = i();
        aVarI.e(authorizationRequest.m());
        boolean zO = authorizationRequest.o();
        String strL = authorizationRequest.l();
        Account accountK = authorizationRequest.k();
        String strN = authorizationRequest.n();
        String str = authorizationRequest.f9573g;
        if (str != null) {
            aVarI.g(str);
        }
        if (strL != null) {
            aVarI.b(strL);
        }
        if (accountK != null) {
            aVarI.d(accountK);
        }
        if (authorizationRequest.f9570d && strN != null) {
            aVarI.f(strN);
        }
        if (authorizationRequest.p() && strN != null) {
            aVarI.c(strN, zO);
        }
        return aVarI;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthorizationRequest)) {
            return false;
        }
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) obj;
        return this.f9567a.size() == authorizationRequest.f9567a.size() && this.f9567a.containsAll(authorizationRequest.f9567a) && this.f9569c == authorizationRequest.f9569c && this.f9574h == authorizationRequest.f9574h && this.f9570d == authorizationRequest.f9570d && AbstractC0939q.b(this.f9568b, authorizationRequest.f9568b) && AbstractC0939q.b(this.f9571e, authorizationRequest.f9571e) && AbstractC0939q.b(this.f9572f, authorizationRequest.f9572f) && AbstractC0939q.b(this.f9573g, authorizationRequest.f9573g);
    }

    public int hashCode() {
        return AbstractC0939q.c(this.f9567a, this.f9568b, Boolean.valueOf(this.f9569c), Boolean.valueOf(this.f9574h), Boolean.valueOf(this.f9570d), this.f9571e, this.f9572f, this.f9573g);
    }

    public Account k() {
        return this.f9571e;
    }

    public String l() {
        return this.f9572f;
    }

    public List m() {
        return this.f9567a;
    }

    public String n() {
        return this.f9568b;
    }

    public boolean o() {
        return this.f9574h;
    }

    public boolean p() {
        return this.f9569c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i4) {
        int iA = c.a(parcel);
        c.I(parcel, 1, m(), false);
        c.E(parcel, 2, n(), false);
        c.g(parcel, 3, p());
        c.g(parcel, 4, this.f9570d);
        c.C(parcel, 5, k(), i4, false);
        c.E(parcel, 6, l(), false);
        c.E(parcel, 7, this.f9573g, false);
        c.g(parcel, 8, o());
        c.b(parcel, iA);
    }
}
