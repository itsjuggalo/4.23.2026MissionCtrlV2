package i2;

import com.google.android.gms.internal.measurement.zzo;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class Y2 implements zzo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f15458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C1794d3 f15459b;

    public Y2(C1794d3 c1794d3, String str) {
        this.f15458a = str;
        Objects.requireNonNull(c1794d3);
        this.f15459b = c1794d3;
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map = (Map) this.f15459b.p().get(this.f15458a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
