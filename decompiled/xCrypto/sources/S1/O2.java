package S1;

import android.content.SharedPreferences;
import android.util.Pair;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class O2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f4142b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4143c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f4144d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Q2 f4145e;

    public /* synthetic */ O2(Q2 q22, String str, long j4, byte[] bArr) {
        Objects.requireNonNull(q22);
        this.f4145e = q22;
        AbstractC0940s.e("health_monitor");
        AbstractC0940s.a(j4 > 0);
        this.f4141a = "health_monitor:start";
        this.f4142b = "health_monitor:count";
        this.f4143c = "health_monitor:value";
        this.f4144d = j4;
    }

    public final void a(String str, long j4) {
        Q2 q22 = this.f4145e;
        q22.h();
        if (d() == 0) {
            c();
        }
        if (str == null) {
            str = "";
        }
        SharedPreferences sharedPreferencesP = q22.p();
        String str2 = this.f4142b;
        long j5 = sharedPreferencesP.getLong(str2, 0L);
        if (j5 <= 0) {
            SharedPreferences.Editor editorEdit = q22.p().edit();
            editorEdit.putString(this.f4143c, str);
            editorEdit.putLong(str2, 1L);
            editorEdit.apply();
            return;
        }
        long jNextLong = q22.f4245a.C().q0().nextLong() & Long.MAX_VALUE;
        long j6 = j5 + 1;
        long j7 = Long.MAX_VALUE / j6;
        SharedPreferences.Editor editorEdit2 = q22.p().edit();
        if (jNextLong < j7) {
            editorEdit2.putString(this.f4143c, str);
        }
        editorEdit2.putLong(str2, j6);
        editorEdit2.apply();
    }

    public final Pair b() {
        long jAbs;
        Q2 q22 = this.f4145e;
        q22.h();
        q22.h();
        long jD = d();
        if (jD == 0) {
            c();
            jAbs = 0;
        } else {
            jAbs = Math.abs(jD - q22.f4245a.f().currentTimeMillis());
        }
        long j4 = this.f4144d;
        if (jAbs < j4) {
            return null;
        }
        if (jAbs > j4 + j4) {
            c();
            return null;
        }
        String string = q22.p().getString(this.f4143c, null);
        long j5 = q22.p().getLong(this.f4142b, 0L);
        c();
        return (string == null || j5 <= 0) ? Q2.f4180A : new Pair(string, Long.valueOf(j5));
    }

    public final void c() {
        Q2 q22 = this.f4145e;
        q22.h();
        long jCurrentTimeMillis = q22.f4245a.f().currentTimeMillis();
        SharedPreferences.Editor editorEdit = q22.p().edit();
        editorEdit.remove(this.f4142b);
        editorEdit.remove(this.f4143c);
        editorEdit.putLong(this.f4141a, jCurrentTimeMillis);
        editorEdit.apply();
    }

    public final long d() {
        return this.f4145e.p().getLong(this.f4141a, 0L);
    }
}
