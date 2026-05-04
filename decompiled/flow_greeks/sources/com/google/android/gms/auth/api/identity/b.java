package com.google.android.gms.auth.api.identity;

import android.accounts.Account;
import com.google.android.gms.auth.api.identity.RevokeAccessRequest;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends RevokeAccessRequest.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List f5395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Account f5396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5397c;

    public b() {
    }

    @Override // com.google.android.gms.auth.api.identity.RevokeAccessRequest.a
    public final RevokeAccessRequest a() {
        if (this.f5395a != null && this.f5396b != null) {
            return new RevokeAccessRequest(this.f5395a, this.f5396b, this.f5397c);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f5395a == null) {
            sb2.append(" scopes");
        }
        if (this.f5396b == null) {
            sb2.append(" account");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb2.toString()));
    }

    @Override // com.google.android.gms.auth.api.identity.RevokeAccessRequest.a
    public final RevokeAccessRequest.a b(Account account) {
        if (account == null) {
            throw new NullPointerException("Null account");
        }
        this.f5396b = account;
        return this;
    }

    @Override // com.google.android.gms.auth.api.identity.RevokeAccessRequest.a
    public final RevokeAccessRequest.a c(List list) {
        if (list == null) {
            throw new NullPointerException("Null scopes");
        }
        this.f5395a = list;
        return this;
    }

    @Override // com.google.android.gms.auth.api.identity.RevokeAccessRequest.a
    public final RevokeAccessRequest.a d(String str) {
        this.f5397c = str;
        return this;
    }

    public b(RevokeAccessRequest revokeAccessRequest) {
        this.f5395a = revokeAccessRequest.T();
        this.f5396b = revokeAccessRequest.S();
        this.f5397c = revokeAccessRequest.U();
    }
}
