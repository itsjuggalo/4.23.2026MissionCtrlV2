package S1;

import com.google.android.gms.internal.measurement.zzis;
import java.util.Collections;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class N6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f4134a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map f4135b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EnumC0612k5 f4136c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final zzis f4137d;

    public N6(String str, Map map, EnumC0612k5 enumC0612k5, zzis zzisVar) {
        this.f4134a = str;
        this.f4135b = map;
        this.f4136c = enumC0612k5;
        this.f4137d = zzisVar;
    }

    public final String a() {
        return this.f4134a;
    }

    public final Map b() {
        Map map = this.f4135b;
        return map == null ? Collections.EMPTY_MAP : map;
    }

    public final EnumC0612k5 c() {
        return this.f4136c;
    }

    public final zzis d() {
        return this.f4137d;
    }
}
