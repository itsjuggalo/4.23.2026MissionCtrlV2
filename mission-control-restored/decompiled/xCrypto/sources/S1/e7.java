package S1;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzib;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f4491a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzib f4492b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f4493c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f4494d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EnumC0612k5 f4495e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f4496f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f4497g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f4498h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f4499i;

    public /* synthetic */ e7(long j4, zzib zzibVar, String str, Map map, EnumC0612k5 enumC0612k5, long j5, long j6, long j7, int i4, byte[] bArr) {
        this.f4491a = j4;
        this.f4492b = zzibVar;
        this.f4493c = str;
        this.f4494d = map;
        this.f4495e = enumC0612k5;
        this.f4496f = j5;
        this.f4497g = j6;
        this.f4498h = j7;
        this.f4499i = i4;
    }

    public final N6 a() {
        return new N6(this.f4493c, this.f4494d, this.f4495e, null);
    }

    public final G6 b() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f4494d.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        long j4 = this.f4491a;
        zzib zzibVar = this.f4492b;
        String str = this.f4493c;
        EnumC0612k5 enumC0612k5 = this.f4495e;
        return new G6(j4, zzibVar.zzcc(), str, bundle, enumC0612k5.zza(), this.f4497g, "");
    }

    public final long c() {
        return this.f4491a;
    }

    public final zzib d() {
        return this.f4492b;
    }

    public final String e() {
        return this.f4493c;
    }

    public final EnumC0612k5 f() {
        return this.f4495e;
    }

    public final long g() {
        return this.f4496f;
    }

    public final long h() {
        return this.f4498h;
    }

    public final int i() {
        return this.f4499i;
    }
}
