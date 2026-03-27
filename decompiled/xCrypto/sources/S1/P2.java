package S1;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class P2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4160a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f4162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Q2 f4163d;

    public P2(Q2 q22, String str, String str2) {
        Objects.requireNonNull(q22);
        this.f4163d = q22;
        AbstractC0940s.e(str);
        this.f4160a = str;
    }

    public final String a() {
        if (!this.f4161b) {
            this.f4161b = true;
            Q2 q22 = this.f4163d;
            this.f4162c = q22.p().getString(this.f4160a, null);
        }
        return this.f4162c;
    }

    public final void b(String str) {
        SharedPreferences.Editor editorEdit = this.f4163d.p().edit();
        editorEdit.putString(this.f4160a, str);
        editorEdit.apply();
        this.f4162c = str;
    }
}
