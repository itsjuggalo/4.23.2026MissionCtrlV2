package com.google.android.gms.auth.api.identity;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import c5.d0;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.internal.p000authapi.zbbi;
import java.util.List;
import n5.c;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class RevokeAccessRequest extends n5.a implements ReflectedParcelable {
    public static final Parcelable.Creator<RevokeAccessRequest> CREATOR = new d0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final zbbi f5378a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Account f5379b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f5380c;

    /* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
    public static abstract class a {
        public abstract RevokeAccessRequest a();

        public abstract a b(Account account);

        public abstract a c(List list);

        public abstract a d(String str);
    }

    public RevokeAccessRequest(List list, Account account, String str) {
        this.f5378a = zbbi.zbi(list);
        this.f5379b = account;
        this.f5380c = str;
    }

    public static a R() {
        return new b();
    }

    public Account S() {
        return this.f5379b;
    }

    public List T() {
        return this.f5378a;
    }

    public final String U() {
        return this.f5380c;
    }

    public final a V() {
        return new b(this);
    }

    public boolean equals(Object obj) {
        if (obj instanceof RevokeAccessRequest) {
            RevokeAccessRequest revokeAccessRequest = (RevokeAccessRequest) obj;
            zbbi zbbiVar = this.f5378a;
            int size = zbbiVar.size();
            zbbi zbbiVar2 = revokeAccessRequest.f5378a;
            if (size == zbbiVar2.size() && zbbiVar.containsAll(zbbiVar2) && q.b(this.f5379b, revokeAccessRequest.f5379b) && q.b(this.f5380c, revokeAccessRequest.f5380c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return q.c(this.f5378a, this.f5379b, this.f5380c);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        int iA = c.a(parcel);
        c.I(parcel, 1, T(), false);
        c.C(parcel, 2, S(), i10, false);
        c.E(parcel, 3, this.f5380c, false);
        c.b(parcel, iA);
    }
}
