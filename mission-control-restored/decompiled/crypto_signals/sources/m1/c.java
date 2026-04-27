package m1;

import android.os.Bundle;
import com.google.android.gms.common.api.e;
import com.google.android.gms.common.internal.I;
import java.util.Arrays;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class c implements e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f8455b = new c(new Bundle());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f8456a;

    public /* synthetic */ c(Bundle bundle) {
        this.f8456a = bundle;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        Bundle bundle = ((c) obj).f8456a;
        Bundle bundle2 = this.f8456a;
        if (bundle2 == null || bundle == null) {
            return bundle2 == bundle;
        }
        if (bundle2.size() == bundle.size()) {
            Set<String> setKeySet = bundle2.keySet();
            if (setKeySet.containsAll(bundle.keySet())) {
                for (String str : setKeySet) {
                    if (!I.j(bundle2.get(str), bundle.get(str))) {
                    }
                }
            }
        }
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f8456a});
    }
}
