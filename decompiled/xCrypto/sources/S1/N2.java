package S1;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class N2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4119a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f4120b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4121c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f4122d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Q2 f4123e;

    public N2(Q2 q22, String str, long j4) {
        Objects.requireNonNull(q22);
        this.f4123e = q22;
        AbstractC0940s.e(str);
        this.f4119a = str;
        this.f4120b = j4;
    }

    public final long a() {
        if (!this.f4121c) {
            this.f4121c = true;
            Q2 q22 = this.f4123e;
            this.f4122d = q22.p().getLong(this.f4119a, this.f4120b);
        }
        return this.f4122d;
    }

    public final void b(long j4) {
        SharedPreferences.Editor editorEdit = this.f4123e.p().edit();
        editorEdit.putLong(this.f4119a, j4);
        editorEdit.apply();
        this.f4122d = j4;
    }
}
