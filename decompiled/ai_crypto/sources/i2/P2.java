package i2;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class P2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15319a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f15320b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f15321c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Q2 f15322d;

    public P2(Q2 q22, String str, String str2) {
        Objects.requireNonNull(q22);
        this.f15322d = q22;
        AbstractC1207s.e(str);
        this.f15319a = str;
    }

    public final String a() {
        if (!this.f15320b) {
            this.f15320b = true;
            Q2 q22 = this.f15322d;
            this.f15321c = q22.p().getString(this.f15319a, null);
        }
        return this.f15321c;
    }

    public final void b(String str) {
        SharedPreferences.Editor editorEdit = this.f15322d.p().edit();
        editorEdit.putString(this.f15319a, str);
        editorEdit.apply();
        this.f15321c = str;
    }
}
