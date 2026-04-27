package k3;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: k3.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public class C2278l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map f20385a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f20386b;

    public String a(String str) {
        String string = str + "<value>: " + this.f20386b + "\n";
        if (this.f20385a.isEmpty()) {
            return string + str + "<empty>";
        }
        for (Map.Entry entry : this.f20385a.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append(string);
            sb.append(str);
            sb.append(entry.getKey());
            sb.append(":\n");
            sb.append(((C2278l) entry.getValue()).a(str + "\t"));
            sb.append("\n");
            string = sb.toString();
        }
        return string;
    }
}
