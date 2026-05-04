package n2;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f16596b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f16595a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f16597c = new ArrayList();

    public r(View view) {
        this.f16596b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f16596b == rVar.f16596b && this.f16595a.equals(rVar.f16595a);
    }

    public int hashCode() {
        return (this.f16596b.hashCode() * 31) + this.f16595a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f16596b + "\n") + "    values:";
        for (String str2 : this.f16595a.keySet()) {
            str = str + "    " + str2 + ": " + this.f16595a.get(str2) + "\n";
        }
        return str;
    }
}
