package S1;

import com.google.android.gms.internal.measurement.zzo;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class Y2 implements zzo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f4299a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0554d3 f4300b;

    public Y2(C0554d3 c0554d3, String str) {
        this.f4299a = str;
        Objects.requireNonNull(c0554d3);
        this.f4300b = c0554d3;
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map = (Map) this.f4300b.p().get(this.f4299a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
