package m8;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7 */
/* JADX INFO: loaded from: classes.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f16110a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f16111b;

    public String a(String str) {
        String string = str + "<value>: " + this.f16111b + "\n";
        if (this.f16110a.isEmpty()) {
            return string + str + "<empty>";
        }
        for (Map.Entry entry : this.f16110a.entrySet()) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(string);
            sb2.append(str);
            sb2.append(entry.getKey());
            sb2.append(":\n");
            sb2.append(((l) entry.getValue()).a(str + "\t"));
            sb2.append("\n");
            string = sb2.toString();
        }
        return string;
    }
}
