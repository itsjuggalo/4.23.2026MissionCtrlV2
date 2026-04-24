package i2;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class N2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15278a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f15279b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f15280c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f15281d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Q2 f15282e;

    public N2(Q2 q22, String str, long j7) {
        Objects.requireNonNull(q22);
        this.f15282e = q22;
        AbstractC1207s.e(str);
        this.f15278a = str;
        this.f15279b = j7;
    }

    public final long a() {
        if (!this.f15280c) {
            this.f15280c = true;
            Q2 q22 = this.f15282e;
            this.f15281d = q22.p().getLong(this.f15278a, this.f15279b);
        }
        return this.f15281d;
    }

    public final void b(long j7) {
        SharedPreferences.Editor editorEdit = this.f15282e.p().edit();
        editorEdit.putLong(this.f15278a, j7);
        editorEdit.apply();
        this.f15281d = j7;
    }
}
