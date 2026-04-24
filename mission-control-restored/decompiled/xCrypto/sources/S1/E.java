package S1;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.AbstractC0940s;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class E {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f3911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f3912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f3913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f3914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f3915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final H f3916f;

    public E(C0658q3 c0658q3, String str, String str2, String str3, long j4, long j5, Bundle bundle) {
        H h4;
        AbstractC0940s.e(str2);
        AbstractC0940s.e(str3);
        this.f3911a = str2;
        this.f3912b = str3;
        this.f3913c = true == TextUtils.isEmpty(str) ? null : str;
        this.f3914d = j4;
        this.f3915e = j5;
        if (j5 != 0 && j5 > j4) {
            c0658q3.a().r().b("Event created with reverse previous/current timestamps. appId", C2.x(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            h4 = new H(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    c0658q3.a().o().a("Param name can't be null");
                    it.remove();
                } else {
                    Object objS = c0658q3.C().s(next, bundle2.get(next));
                    if (objS == null) {
                        c0658q3.a().r().b("Param value can't be null", c0658q3.D().b(next));
                        it.remove();
                    } else {
                        c0658q3.C().A(bundle2, next, objS);
                    }
                }
            }
            h4 = new H(bundle2);
        }
        this.f3916f = h4;
    }

    public final E a(C0658q3 c0658q3, long j4) {
        return new E(c0658q3, this.f3913c, this.f3911a, this.f3912b, this.f3914d, j4, this.f3916f);
    }

    public final String toString() {
        String string = this.f3916f.toString();
        String str = this.f3911a;
        int length = String.valueOf(str).length();
        String str2 = this.f3912b;
        StringBuilder sb = new StringBuilder(length + 22 + String.valueOf(str2).length() + 10 + string.length() + 1);
        sb.append("Event{appId='");
        sb.append(str);
        sb.append("', name='");
        sb.append(str2);
        sb.append("', params=");
        sb.append(string);
        sb.append("}");
        return sb.toString();
    }

    public E(C0658q3 c0658q3, String str, String str2, String str3, long j4, long j5, H h4) {
        AbstractC0940s.e(str2);
        AbstractC0940s.e(str3);
        AbstractC0940s.k(h4);
        this.f3911a = str2;
        this.f3912b = str3;
        this.f3913c = true == TextUtils.isEmpty(str) ? null : str;
        this.f3914d = j4;
        this.f3915e = j5;
        if (j5 != 0 && j5 > j4) {
            c0658q3.a().r().c("Event created with reverse previous/current timestamps. appId, name", C2.x(str2), C2.x(str3));
        }
        this.f3916f = h4;
    }
}
