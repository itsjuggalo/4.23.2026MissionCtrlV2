package w0;

import android.os.Build;
import java.util.HashSet;

/* JADX INFO: renamed from: w0.c, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1274c implements d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashSet f10700c = new HashSet();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f10701a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f10702b;

    public AbstractC1274c(String str, String str2) {
        this.f10701a = str;
        this.f10702b = str2;
        f10700c.add(this);
    }

    public abstract boolean a();

    public boolean b() {
        HashSet hashSet = AbstractC1272a.f10698a;
        String str = this.f10702b;
        if (hashSet.contains(str)) {
            return true;
        }
        String str2 = Build.TYPE;
        if (!"eng".equals(str2) && !"userdebug".equals(str2)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(":dev");
        return hashSet.contains(sb.toString());
    }
}
