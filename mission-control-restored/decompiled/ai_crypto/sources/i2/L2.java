package i2;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class L2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15242a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f15243b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15244c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f15245d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Q2 f15246e;

    public L2(Q2 q22, String str, boolean z7) {
        Objects.requireNonNull(q22);
        this.f15246e = q22;
        AbstractC1207s.e(str);
        this.f15242a = str;
        this.f15243b = z7;
    }

    public final boolean a() {
        if (!this.f15244c) {
            this.f15244c = true;
            Q2 q22 = this.f15246e;
            this.f15245d = q22.p().getBoolean(this.f15242a, this.f15243b);
        }
        return this.f15245d;
    }

    public final void b(boolean z7) {
        SharedPreferences.Editor editorEdit = this.f15246e.p().edit();
        editorEdit.putBoolean(this.f15242a, z7);
        editorEdit.apply();
        this.f15245d = z7;
    }
}
