package C0;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f577b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f576a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f578c = new ArrayList();

    public s(View view) {
        this.f577b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f577b == sVar.f577b && this.f576a.equals(sVar.f576a);
    }

    public int hashCode() {
        return (this.f577b.hashCode() * 31) + this.f576a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f577b + "\n") + "    values:";
        for (String str2 : this.f576a.keySet()) {
            str = str + "    " + str2 + ": " + this.f576a.get(str2) + "\n";
        }
        return str;
    }
}
