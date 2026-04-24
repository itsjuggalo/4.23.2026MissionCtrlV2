package r0;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public View f14471b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map f14470a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ArrayList f14472c = new ArrayList();

    public s(View view) {
        this.f14471b = view;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof s)) {
            return false;
        }
        s sVar = (s) obj;
        return this.f14471b == sVar.f14471b && this.f14470a.equals(sVar.f14470a);
    }

    public int hashCode() {
        return (this.f14471b.hashCode() * 31) + this.f14470a.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f14471b + "\n") + "    values:";
        for (String str2 : this.f14470a.keySet()) {
            str = str + "    " + str2 + ": " + this.f14470a.get(str2) + "\n";
        }
        return str;
    }
}
