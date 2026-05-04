package com.google.android.gms.auth.api.identity;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import c5.q;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.s;
import java.util.List;
import n5.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class AuthorizationRequest extends n5.a implements ReflectedParcelable {
    public static final Parcelable.Creator<AuthorizationRequest> CREATOR = new q();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List f5348a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f5349b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f5350c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f5351d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Account f5352e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f5353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f5354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f5355h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Bundle f5356i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f5357j;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List f5358a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f5359b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f5360c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f5361d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Account f5362e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f5363f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f5364g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public boolean f5365h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public Bundle f5366i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f5367j;

        public a a(b bVar, String str) {
            s.l(bVar, "Resource parameter cannot be null");
            s.l(str, "Resource parameter value cannot be null");
            if (this.f5366i == null) {
                this.f5366i = new Bundle();
            }
            this.f5366i.putString(bVar.f5375a, str);
            return this;
        }

        public AuthorizationRequest b() {
            return new AuthorizationRequest(this.f5358a, this.f5359b, this.f5360c, this.f5361d, this.f5362e, this.f5363f, this.f5364g, this.f5365h, this.f5366i, this.f5367j);
        }

        public a c(String str) {
            this.f5363f = s.e(str);
            return this;
        }

        public a d(String str, boolean z10) {
            j(str);
            this.f5359b = str;
            this.f5360c = true;
            this.f5365h = z10;
            return this;
        }

        public a e(Account account) {
            this.f5362e = (Account) s.k(account);
            return this;
        }

        public a f(boolean z10) {
            this.f5367j = z10;
            return this;
        }

        public a g(List list) {
            boolean z10 = false;
            if (list != null && !list.isEmpty()) {
                z10 = true;
            }
            s.b(z10, "requestedScopes cannot be null or empty");
            this.f5358a = list;
            return this;
        }

        public final a h(String str) {
            j(str);
            this.f5359b = str;
            this.f5361d = true;
            return this;
        }

        public final a i(String str) {
            this.f5364g = str;
            return this;
        }

        public final String j(String str) {
            s.k(str);
            String str2 = this.f5359b;
            boolean z10 = true;
            if (str2 != null && !str2.equals(str)) {
                z10 = false;
            }
            s.b(z10, "two different server client ids provided");
            return str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public enum b {
        ACCOUNT_SELECTION_TOKEN("account_selection_token"),
        ACCOUNT_SELECTION_STATE("account_selection_state"),
        PICKER_ALLOW_MULTIPLE("allow_multiple"),
        PICKER_MIMETYPES("mimetypes"),
        PICKER_FILE_IDS("file_ids"),
        PICKER_OAUTH_TRIGGER("trigger_onepick");


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f5375a;

        b(String str) {
            this.f5375a = str;
        }
    }

    public AuthorizationRequest(List list, String str, boolean z10, boolean z11, Account account, String str2, String str3, boolean z12, Bundle bundle, boolean z13) {
        boolean z14 = false;
        if (list != null && !list.isEmpty()) {
            z14 = true;
        }
        s.b(z14, "requestedScopes cannot be null or empty");
        this.f5348a = list;
        this.f5349b = str;
        this.f5350c = z10;
        this.f5351d = z11;
        this.f5352e = account;
        this.f5353f = str2;
        this.f5354g = str3;
        this.f5355h = z12;
        this.f5356i = bundle;
        this.f5357j = z13;
    }

    public static a R() {
        return new a();
    }

    public static a a0(AuthorizationRequest authorizationRequest) {
        b bVar;
        s.k(authorizationRequest);
        a aVarR = R();
        aVarR.g(authorizationRequest.V());
        Bundle bundleW = authorizationRequest.W();
        if (bundleW != null) {
            for (String str : bundleW.keySet()) {
                String string = bundleW.getString(str);
                b[] bVarArrValues = b.values();
                int length = bVarArrValues.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        bVar = null;
                        break;
                    }
                    bVar = bVarArrValues[i10];
                    if (bVar.f5375a.equals(str)) {
                        break;
                    }
                    i10++;
                }
                if (string != null && bVar != null) {
                    aVarR.a(bVar, string);
                }
            }
        }
        boolean zY = authorizationRequest.Y();
        String str2 = authorizationRequest.f5354g;
        String strT = authorizationRequest.T();
        Account accountS = authorizationRequest.S();
        String strX = authorizationRequest.X();
        if (str2 != null) {
            aVarR.i(str2);
        }
        if (strT != null) {
            aVarR.c(strT);
        }
        if (accountS != null) {
            aVarR.e(accountS);
        }
        if (authorizationRequest.f5351d && strX != null) {
            aVarR.h(strX);
        }
        if (authorizationRequest.Z() && strX != null) {
            aVarR.d(strX, zY);
        }
        aVarR.f(authorizationRequest.f5357j);
        return aVarR;
    }

    public Account S() {
        return this.f5352e;
    }

    public String T() {
        return this.f5353f;
    }

    public boolean U() {
        return this.f5357j;
    }

    public List V() {
        return this.f5348a;
    }

    public Bundle W() {
        return this.f5356i;
    }

    public String X() {
        return this.f5349b;
    }

    public boolean Y() {
        return this.f5355h;
    }

    public boolean Z() {
        return this.f5350c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AuthorizationRequest)) {
            return false;
        }
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) obj;
        List list = this.f5348a;
        int size = list.size();
        List list2 = authorizationRequest.f5348a;
        if (size == list2.size() && list.containsAll(list2)) {
            Bundle bundle = authorizationRequest.f5356i;
            Bundle bundle2 = this.f5356i;
            if (bundle2 == null) {
                if (bundle == null) {
                    bundle = null;
                }
                return false;
            }
            if (bundle2 == null || bundle != null) {
                if (bundle2 != null) {
                    if (bundle2.size() != bundle.size()) {
                        return false;
                    }
                    for (String str : bundle2.keySet()) {
                        if (!com.google.android.gms.common.internal.q.b(bundle2.getString(str), bundle.getString(str))) {
                            return false;
                        }
                    }
                }
                if (this.f5350c == authorizationRequest.f5350c && this.f5355h == authorizationRequest.f5355h && this.f5351d == authorizationRequest.f5351d && this.f5357j == authorizationRequest.f5357j && com.google.android.gms.common.internal.q.b(this.f5349b, authorizationRequest.f5349b) && com.google.android.gms.common.internal.q.b(this.f5352e, authorizationRequest.f5352e) && com.google.android.gms.common.internal.q.b(this.f5353f, authorizationRequest.f5353f) && com.google.android.gms.common.internal.q.b(this.f5354g, authorizationRequest.f5354g)) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return com.google.android.gms.common.internal.q.c(this.f5348a, this.f5349b, Boolean.valueOf(this.f5350c), Boolean.valueOf(this.f5355h), Boolean.valueOf(this.f5351d), this.f5352e, this.f5353f, this.f5354g, this.f5356i, Boolean.valueOf(this.f5357j));
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = c.a(parcel);
        c.I(parcel, 1, V(), false);
        c.E(parcel, 2, X(), false);
        c.g(parcel, 3, Z());
        c.g(parcel, 4, this.f5351d);
        c.C(parcel, 5, S(), i10, false);
        c.E(parcel, 6, T(), false);
        c.E(parcel, 7, this.f5354g, false);
        c.g(parcel, 8, Y());
        c.j(parcel, 9, W(), false);
        c.g(parcel, 10, U());
        c.b(parcel, iA);
    }
}
