package a3;

import Z2.InterfaceC0757g;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.AbstractC1207s;
import java.util.Map;

/* JADX INFO: renamed from: a3.H0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes.dex */
public final class C0819H0 implements InterfaceC0757g {
    public static final Parcelable.Creator<C0819H0> CREATOR = new C0817G0();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f6140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f6141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Map f6142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f6143d;

    public C0819H0(boolean z7) {
        this.f6143d = z7;
        this.f6141b = null;
        this.f6140a = null;
        this.f6142c = null;
    }

    @Override // Z2.InterfaceC0757g
    public final String b() {
        return this.f6140a;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // Z2.InterfaceC0757g
    public final Map getProfile() {
        return this.f6142c;
    }

    @Override // Z2.InterfaceC0757g
    public final String n() {
        if ("github.com".equals(this.f6140a)) {
            return (String) this.f6142c.get("login");
        }
        if ("twitter.com".equals(this.f6140a)) {
            return (String) this.f6142c.get("screen_name");
        }
        return null;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i7) {
        int iA = Q1.c.a(parcel);
        Q1.c.E(parcel, 1, b(), false);
        Q1.c.E(parcel, 2, this.f6141b, false);
        Q1.c.g(parcel, 3, y());
        Q1.c.b(parcel, iA);
    }

    @Override // Z2.InterfaceC0757g
    public final boolean y() {
        return this.f6143d;
    }

    public C0819H0(String str, String str2, boolean z7) {
        AbstractC1207s.e(str);
        AbstractC1207s.e(str2);
        this.f6140a = str;
        this.f6141b = str2;
        this.f6142c = AbstractC0825L.d(str2);
        this.f6143d = z7;
    }
}
