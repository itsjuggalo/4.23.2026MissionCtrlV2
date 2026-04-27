package i2;

import android.os.Bundle;
import com.google.android.gms.internal.measurement.zzib;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class e7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f15650a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final zzib f15651b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f15652c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map f15653d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final EnumC1852k5 f15654e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f15655f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f15656g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f15657h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f15658i;

    public /* synthetic */ e7(long j7, zzib zzibVar, String str, Map map, EnumC1852k5 enumC1852k5, long j8, long j9, long j10, int i7, byte[] bArr) {
        this.f15650a = j7;
        this.f15651b = zzibVar;
        this.f15652c = str;
        this.f15653d = map;
        this.f15654e = enumC1852k5;
        this.f15655f = j8;
        this.f15656g = j9;
        this.f15657h = j10;
        this.f15658i = i7;
    }

    public final N6 a() {
        return new N6(this.f15652c, this.f15653d, this.f15654e, null);
    }

    public final G6 b() {
        Bundle bundle = new Bundle();
        for (Map.Entry entry : this.f15653d.entrySet()) {
            bundle.putString((String) entry.getKey(), (String) entry.getValue());
        }
        long j7 = this.f15650a;
        zzib zzibVar = this.f15651b;
        String str = this.f15652c;
        EnumC1852k5 enumC1852k5 = this.f15654e;
        return new G6(j7, zzibVar.zzcc(), str, bundle, enumC1852k5.zza(), this.f15656g, "");
    }

    public final long c() {
        return this.f15650a;
    }

    public final zzib d() {
        return this.f15651b;
    }

    public final String e() {
        return this.f15652c;
    }

    public final EnumC1852k5 f() {
        return this.f15654e;
    }

    public final long g() {
        return this.f15655f;
    }

    public final long h() {
        return this.f15657h;
    }

    public final int i() {
        return this.f15658i;
    }
}
