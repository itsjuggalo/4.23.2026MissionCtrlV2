package S1;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class L2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f4084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f4085c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f4086d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Q2 f4087e;

    public L2(Q2 q22, String str, boolean z4) {
        Objects.requireNonNull(q22);
        this.f4087e = q22;
        AbstractC0940s.e(str);
        this.f4083a = str;
        this.f4084b = z4;
    }

    public final boolean a() {
        if (!this.f4085c) {
            this.f4085c = true;
            Q2 q22 = this.f4087e;
            this.f4086d = q22.p().getBoolean(this.f4083a, this.f4084b);
        }
        return this.f4086d;
    }

    public final void b(boolean z4) {
        SharedPreferences.Editor editorEdit = this.f4087e.p().edit();
        editorEdit.putBoolean(this.f4083a, z4);
        editorEdit.apply();
        this.f4086d = z4;
    }
}
