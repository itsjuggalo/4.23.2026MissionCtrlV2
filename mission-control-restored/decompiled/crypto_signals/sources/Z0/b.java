package Z0;

import android.content.Context;
import h1.InterfaceC0618a;
import s3.AbstractC1024h;

/* JADX INFO: loaded from: classes.dex */
public final class b extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f3937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC0618a f3938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final InterfaceC0618a f3939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f3940d;

    public b(Context context, InterfaceC0618a interfaceC0618a, InterfaceC0618a interfaceC0618a2, String str) {
        if (context == null) {
            throw new NullPointerException("Null applicationContext");
        }
        this.f3937a = context;
        if (interfaceC0618a == null) {
            throw new NullPointerException("Null wallClock");
        }
        this.f3938b = interfaceC0618a;
        if (interfaceC0618a2 == null) {
            throw new NullPointerException("Null monotonicClock");
        }
        this.f3939c = interfaceC0618a2;
        if (str == null) {
            throw new NullPointerException("Null backendName");
        }
        this.f3940d = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f3937a.equals(((b) cVar).f3937a)) {
                b bVar = (b) cVar;
                if (this.f3938b.equals(bVar.f3938b) && this.f3939c.equals(bVar.f3939c) && this.f3940d.equals(bVar.f3940d)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((this.f3937a.hashCode() ^ 1000003) * 1000003) ^ this.f3938b.hashCode()) * 1000003) ^ this.f3939c.hashCode()) * 1000003) ^ this.f3940d.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("CreationContext{applicationContext=");
        sb.append(this.f3937a);
        sb.append(", wallClock=");
        sb.append(this.f3938b);
        sb.append(", monotonicClock=");
        sb.append(this.f3939c);
        sb.append(", backendName=");
        return AbstractC1024h.d(sb, this.f3940d, "}");
    }
}
