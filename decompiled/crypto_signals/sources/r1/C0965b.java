package r1;

import android.accounts.Account;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.I;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: renamed from: r1.b, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0965b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashSet f9445a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9446b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f9447c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f9448d;
    public String e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Account f9449f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f9450g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashMap f9451h;
    public String i;

    public C0965b() {
        this.f9445a = new HashSet();
        this.f9451h = new HashMap();
    }

    public final GoogleSignInOptions a() {
        Scope scope = GoogleSignInOptions.f5032t;
        HashSet hashSet = this.f9445a;
        if (hashSet.contains(scope)) {
            Scope scope2 = GoogleSignInOptions.f5031s;
            if (hashSet.contains(scope2)) {
                hashSet.remove(scope2);
            }
        }
        if (this.f9448d && (this.f9449f == null || !hashSet.isEmpty())) {
            this.f9445a.add(GoogleSignInOptions.f5030r);
        }
        return new GoogleSignInOptions(3, new ArrayList(hashSet), this.f9449f, this.f9448d, this.f9446b, this.f9447c, this.e, this.f9450g, this.f9451h, this.i);
    }

    public C0965b(GoogleSignInOptions googleSignInOptions) {
        this.f9445a = new HashSet();
        this.f9451h = new HashMap();
        I.g(googleSignInOptions);
        this.f9445a = new HashSet(googleSignInOptions.f5035b);
        this.f9446b = googleSignInOptions.e;
        this.f9447c = googleSignInOptions.f5038f;
        this.f9448d = googleSignInOptions.f5037d;
        this.e = googleSignInOptions.f5039k;
        this.f9449f = googleSignInOptions.f5036c;
        this.f9450g = googleSignInOptions.f5040l;
        this.f9451h = GoogleSignInOptions.o(googleSignInOptions.f5041m);
        this.i = googleSignInOptions.f5042n;
    }
}
