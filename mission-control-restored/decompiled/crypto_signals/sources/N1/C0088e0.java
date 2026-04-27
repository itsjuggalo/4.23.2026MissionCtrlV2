package N1;

import android.content.SharedPreferences;
import java.util.Objects;

/* JADX INFO: renamed from: N1.e0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0088e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1588a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1589b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f1590c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f1591d;
    public final /* synthetic */ C0097h0 e;

    public C0088e0(C0097h0 c0097h0, String str, long j4) {
        Objects.requireNonNull(c0097h0);
        this.e = c0097h0;
        com.google.android.gms.common.internal.I.d(str);
        this.f1588a = str;
        this.f1589b = j4;
    }

    public final long a() {
        if (!this.f1590c) {
            this.f1590c = true;
            this.f1591d = this.e.t().getLong(this.f1588a, this.f1589b);
        }
        return this.f1591d;
    }

    public final void b(long j4) {
        SharedPreferences.Editor editorEdit = this.e.t().edit();
        editorEdit.putLong(this.f1588a, j4);
        editorEdit.apply();
        this.f1591d = j4;
    }
}
