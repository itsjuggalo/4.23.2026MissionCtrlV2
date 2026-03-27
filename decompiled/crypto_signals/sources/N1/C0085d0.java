package N1;

import android.content.SharedPreferences;
import java.util.Objects;

/* JADX INFO: renamed from: N1.d0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0085d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1574c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1575d;
    public final /* synthetic */ C0097h0 e;

    public C0085d0(C0097h0 c0097h0, String str, boolean z6) {
        Objects.requireNonNull(c0097h0);
        this.e = c0097h0;
        com.google.android.gms.common.internal.I.d(str);
        this.f1572a = str;
        this.f1573b = z6;
    }

    public final boolean a() {
        if (!this.f1574c) {
            this.f1574c = true;
            this.f1575d = this.e.t().getBoolean(this.f1572a, this.f1573b);
        }
        return this.f1575d;
    }

    public final void b(boolean z6) {
        SharedPreferences.Editor editorEdit = this.e.t().edit();
        editorEdit.putBoolean(this.f1572a, z6);
        editorEdit.apply();
        this.f1575d = z6;
    }
}
