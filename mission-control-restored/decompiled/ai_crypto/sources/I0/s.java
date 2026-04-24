package I0;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f2855b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f2854a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f2856c = new ArrayList();

    public s(View view) {
        this.f2855b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f2855b == sVar.f2855b && this.f2854a.equals(sVar.f2854a);
    }

    public int hashCode() {
        return (this.f2855b.hashCode() * 31) + this.f2854a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f2855b + "\n") + "    values:";
        for (String str2 : this.f2854a.keySet()) {
            str = str + "    " + str2 + ": " + this.f2854a.get(str2) + "\n";
        }
        return str;
    }
}
