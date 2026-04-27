package i2;

import com.google.android.gms.internal.measurement.zzis;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class N6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f15293a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f15294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EnumC1852k5 f15295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzis f15296d;

    public N6(String str, Map map, EnumC1852k5 enumC1852k5, zzis zzisVar) {
        this.f15293a = str;
        this.f15294b = map;
        this.f15295c = enumC1852k5;
        this.f15296d = zzisVar;
    }

    public final String a() {
        return this.f15293a;
    }

    public final Map b() {
        Map map = this.f15294b;
        return map == null ? Collections.emptyMap() : map;
    }

    public final EnumC1852k5 c() {
        return this.f15295c;
    }

    public final zzis d() {
        return this.f15296d;
    }
}
