package S1;

import Q1.C0790b;
import R1.a;
import R1.f;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.google.android.gms.common.internal.AbstractC1294n;
import com.google.android.gms.common.internal.C1284d;
import j2.AbstractBinderC2207d;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class N extends AbstractBinderC2207d implements f.a, f.b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a.AbstractC0099a f7362h = i2.d.f18774c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f7363a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f7364b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a.AbstractC0099a f7365c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set f7366d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final C1284d f7367e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public i2.e f7368f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public M f7369g;

    public N(Context context, Handler handler, C1284d c1284d) {
        a.AbstractC0099a abstractC0099a = f7362h;
        this.f7363a = context;
        this.f7364b = handler;
        this.f7367e = (C1284d) AbstractC1294n.k(c1284d, "ClientSettings must not be null");
        this.f7366d = c1284d.e();
        this.f7365c = abstractC0099a;
    }

    public static /* bridge */ /* synthetic */ void F(N n8, j2.l lVar) {
        C0790b c0790bA = lVar.a();
        if (c0790bA.h()) {
            com.google.android.gms.common.internal.I i8 = (com.google.android.gms.common.internal.I) AbstractC1294n.j(lVar.d());
            c0790bA = i8.a();
            if (c0790bA.h()) {
                n8.f7369g.c(i8.d(), n8.f7366d);
            } else {
                String strValueOf = String.valueOf(c0790bA);
                Log.wtf("SignInCoordinator", "Sign-in succeeded with resolve account failure: ".concat(strValueOf), new Exception());
                n8.f7369g.b(c0790bA);
            }
        } else {
            n8.f7369g.b(c0790bA);
        }
        n8.f7368f.disconnect();
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [R1.a$f, i2.e] */
    public final void G(M m8) {
        i2.e eVar = this.f7368f;
        if (eVar != null) {
            eVar.disconnect();
        }
        this.f7367e.i(Integer.valueOf(System.identityHashCode(this)));
        a.AbstractC0099a abstractC0099a = this.f7365c;
        Context context = this.f7363a;
        Handler handler = this.f7364b;
        C1284d c1284d = this.f7367e;
        this.f7368f = abstractC0099a.a(context, handler.getLooper(), c1284d, c1284d.f(), this, this);
        this.f7369g = m8;
        Set set = this.f7366d;
        if (set == null || set.isEmpty()) {
            this.f7364b.post(new K(this));
        } else {
            this.f7368f.c();
        }
    }

    public final void H() {
        i2.e eVar = this.f7368f;
        if (eVar != null) {
            eVar.disconnect();
        }
    }

    @Override // S1.InterfaceC0872d
    public final void onConnected(Bundle bundle) {
        this.f7368f.b(this);
    }

    @Override // S1.InterfaceC0879k
    public final void onConnectionFailed(C0790b c0790b) {
        this.f7369g.b(c0790b);
    }

    @Override // S1.InterfaceC0872d
    public final void onConnectionSuspended(int i8) {
        this.f7369g.d(i8);
    }

    @Override // j2.f
    public final void w(j2.l lVar) {
        this.f7364b.post(new L(this, lVar));
    }
}
